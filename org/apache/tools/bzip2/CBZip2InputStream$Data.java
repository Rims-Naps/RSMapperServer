//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.apache.tools.bzip2;

final class CBZip2InputStream$Data {
    final boolean[] inUse = new boolean[256];
    final byte[] seqToUnseq = new byte[256];
    final byte[] selector = new byte[18002];
    final byte[] selectorMtf = new byte[18002];
    final int[] unzftab = new int[256];
    final int[][] limit = new int[6][258];
    final int[][] base = new int[6][258];
    final int[][] perm = new int[6][258];
    final int[] minLens = new int[6];
    final int[] cftab = new int[257];
    final char[] getAndMoveToFrontDecode_yy = new char[256];
    final char[][] temp_charArray2d = new char[6][258];
    final byte[] recvDecodingTables_pos = new byte[6];
    int[] tt;
    byte[] ll8;

    CBZip2InputStream$Data(int blockSize100k) {
        this.ll8 = new byte[blockSize100k * 100000];
    }

    final int[] initTT(int length) {
        int[] ttShadow = this.tt;
        if (ttShadow == null || ttShadow.length < length) {
            this.tt = ttShadow = new int[length];
        }

        return ttShadow;
    }
}
