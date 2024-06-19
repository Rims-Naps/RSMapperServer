//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.alex.store;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import java.util.Arrays;

public final class ReferenceTable {
    private Archive archive;
    private int revision;
    private boolean named;
    private boolean usesWhirpool;
    private ArchiveReference[] archives;
    private int[] validArchiveIds;
    private boolean updatedRevision;
    private boolean needsArchivesSort;

    protected ReferenceTable(Archive archive) {
        this.archive = archive;
        this.decodeHeader();
    }

    public void setKeys(int[] keys) {
        this.archive.setKeys(keys);
    }

    public int[] getKeys() {
        return this.archive.getKeys();
    }

    public void sortArchives() {
        Arrays.sort(this.validArchiveIds);
        this.needsArchivesSort = false;
    }

    public void addEmptyArchiveReference(int archiveId) {
        this.needsArchivesSort = true;
        int[] newValidArchiveIds = Arrays.copyOf(this.validArchiveIds, this.validArchiveIds.length + 1);
        newValidArchiveIds[newValidArchiveIds.length - 1] = archiveId;
        this.validArchiveIds = newValidArchiveIds;
        ArchiveReference reference;
        if (this.archives.length <= archiveId) {
            ArchiveReference[] newArchives = (ArchiveReference[])Arrays.copyOf(this.archives, archiveId + 1);
            reference = newArchives[archiveId] = new ArchiveReference();
            this.archives = newArchives;
        } else {
            reference = this.archives[archiveId] = new ArchiveReference();
        }

        reference.reset();
    }

    public void sortTable() {
        if (this.needsArchivesSort) {
            this.sortArchives();
        }

        for(int index = 0; index < this.validArchiveIds.length; ++index) {
            ArchiveReference archive = this.archives[this.validArchiveIds[index]];
            if (archive.isNeedsFilesSort()) {
                archive.sortFiles();
            }
        }

    }

    public Object[] encodeHeader(MainFile mainFile) {
        OutputStream stream = new OutputStream();
        int protocol = this.getProtocol();
        stream.writeByte(protocol);
        if (protocol >= 6) {
            stream.writeInt(this.revision);
        }

        stream.writeByte((this.named ? 1 : 0) | (this.usesWhirpool ? 2 : 0));
        if (protocol >= 7) {
            stream.writeBigSmart(this.validArchiveIds.length);
        } else {
            stream.writeShort(this.validArchiveIds.length);
        }

        int index;
        int value;
        for(index = 0; index < this.validArchiveIds.length; ++index) {
            value = this.validArchiveIds[index];
            if (index != 0) {
                value -= this.validArchiveIds[index - 1];
            }

            if (protocol >= 7) {
                stream.writeBigSmart(value);
            } else {
                stream.writeShort(value);
            }
        }

        if (this.named) {
            for(index = 0; index < this.validArchiveIds.length; ++index) {
                stream.writeInt(this.archives[this.validArchiveIds[index]].getNameHash());
            }
        }

        if (this.usesWhirpool) {
            for(index = 0; index < this.validArchiveIds.length; ++index) {
                stream.writeBytes(this.archives[this.validArchiveIds[index]].getWhirpool());
            }
        }

        for(index = 0; index < this.validArchiveIds.length; ++index) {
            stream.writeInt(this.archives[this.validArchiveIds[index]].getCRC());
        }

        for(index = 0; index < this.validArchiveIds.length; ++index) {
            stream.writeInt(this.archives[this.validArchiveIds[index]].getRevision());
        }

        for(index = 0; index < this.validArchiveIds.length; ++index) {
            value = this.archives[this.validArchiveIds[index]].getValidFileIds().length;
            if (protocol >= 7) {
                stream.writeBigSmart(value);
            } else {
                stream.writeShort(value);
            }
        }

        int index2;
        ArchiveReference archive;
        for(index = 0; index < this.validArchiveIds.length; ++index) {
            archive = this.archives[this.validArchiveIds[index]];

            for(index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                int offset = archive.getValidFileIds()[index2];
                if (index2 != 0) {
                    offset -= archive.getValidFileIds()[index2 - 1];
                }

                if (protocol >= 7) {
                    stream.writeBigSmart(offset);
                } else {
                    stream.writeShort(offset);
                }
            }
        }

        if (this.named) {
            for(index = 0; index < this.validArchiveIds.length; ++index) {
                archive = this.archives[this.validArchiveIds[index]];

                for(index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                    stream.writeInt(archive.getFiles()[archive.getValidFileIds()[index2]].getNameHash());
                }
            }
        }

        byte[] data = new byte[stream.getOffset()];
        stream.setOffset(0);
        stream.getBytes(data, 0, data.length);
        return this.archive.editNoRevision(data, mainFile);
    }

    public int getProtocol() {
        if (this.archives.length > 65535) {
            return 7;
        } else {
            for(int index = 0; index < this.validArchiveIds.length; ++index) {
                if (index > 0 && this.validArchiveIds[index] - this.validArchiveIds[index - 1] > 65535) {
                    return 7;
                }

                if (this.archives[this.validArchiveIds[index]].getValidFileIds().length > 65535) {
                    return 7;
                }
            }

            return this.revision == 0 ? 5 : 6;
        }
    }

    public void setRevision(int revision) {
        this.updatedRevision = true;
        this.revision = revision;
    }

    public void updateRevision() {
        if (!this.updatedRevision) {
            ++this.revision;
            this.updatedRevision = true;
        }
    }

    private void decodeHeader() {
        InputStream stream = new InputStream(this.archive.getData());
        int protocol = stream.readUnsignedByte();
        if (protocol >= 5 && protocol <= 7) {
            if (protocol >= 6) {
                this.revision = stream.readInt();
            }

            int hash = stream.readUnsignedByte();
            this.named = (1 & hash) != 0;
            this.usesWhirpool = (2 & hash) != 0;
            int validArchivesCount = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
            this.validArchiveIds = new int[validArchivesCount];
            int lastArchiveId = 0;
            int biggestArchiveId = 0;

            int index;
            int lastFileId;
            for(index = 0; index < validArchivesCount; ++index) {
                lastFileId = lastArchiveId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
                if (lastFileId > biggestArchiveId) {
                    biggestArchiveId = lastFileId;
                }

                this.validArchiveIds[index] = lastFileId;
            }

            this.archives = new ArchiveReference[biggestArchiveId + 1];

            for(index = 0; index < validArchivesCount; ++index) {
                this.archives[this.validArchiveIds[index]] = new ArchiveReference();
            }

            if (this.named) {
                for(index = 0; index < validArchivesCount; ++index) {
                    this.archives[this.validArchiveIds[index]].setNameHash(stream.readInt());
                }
            }

            if (this.usesWhirpool) {
                for(index = 0; index < validArchivesCount; ++index) {
                    byte[] whirpool = new byte[64];
                    stream.getBytes(whirpool, 0, 64);
                    this.archives[this.validArchiveIds[index]].setWhirpool(whirpool);
                }
            }

            for(index = 0; index < validArchivesCount; ++index) {
                this.archives[this.validArchiveIds[index]].setCrc(stream.readInt());
            }

            for(index = 0; index < validArchivesCount; ++index) {
                this.archives[this.validArchiveIds[index]].setRevision(stream.readInt());
            }

            for(index = 0; index < validArchivesCount; ++index) {
                this.archives[this.validArchiveIds[index]].setValidFileIds(new int[protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort()]);
            }

            int index2;
            for(index = 0; index < validArchivesCount; ++index) {
                lastFileId = 0;
                index2 = 0;
                ArchiveReference archive = this.archives[this.validArchiveIds[index]];

                int index2;
                for(index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                    int fileId = lastFileId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
                    if (fileId > index2) {
                        index2 = fileId;
                    }

                    archive.getValidFileIds()[index2] = fileId;
                }

                archive.setFiles(new FileReference[index2 + 1]);

                for(index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                    archive.getFiles()[archive.getValidFileIds()[index2]] = new FileReference();
                }
            }

            if (this.named) {
                for(index = 0; index < validArchivesCount; ++index) {
                    ArchiveReference archive = this.archives[this.validArchiveIds[index]];

                    for(index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                        archive.getFiles()[archive.getValidFileIds()[index2]].setNameHash(stream.readInt());
                    }
                }
            }

        } else {
            throw new RuntimeException("INVALID PROTOCOL");
        }
    }

    public int getRevision() {
        return this.revision;
    }

    public ArchiveReference[] getArchives() {
        return this.archives;
    }

    public int[] getValidArchiveIds() {
        return this.validArchiveIds;
    }

    public boolean isNamed() {
        return this.named;
    }

    public boolean usesWhirpool() {
        return this.usesWhirpool;
    }

    public int getCompression() {
        return this.archive.getCompression();
    }
}
