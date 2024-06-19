//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.codec;

import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.stream.InputStream;

public abstract class Decoder {
    protected Session session;

    public Decoder(Session session) {
        this.session = session;
    }

    public abstract void decode(InputStream var1);
}
