package org.keyczar;

import com.google.gson.annotations.Expose;
import org.keyczar.annotations.Experimental;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.util.Util;

@Experimental
/* loaded from: classes.dex */
public class SessionMaterial {

    @Expose
    private AesKey key;

    @Expose
    private String nonce;

    public SessionMaterial() {
        this.key = null;
        this.nonce = "";
    }

    public SessionMaterial(AesKey aesKey, String str) {
        this.key = null;
        this.nonce = "";
        this.key = aesKey;
        this.nonce = str;
    }

    public AesKey getKey() throws KeyczarException {
        if (this.key == null) {
            throw new KeyczarException("Key has not been initialized");
        }
        return this.key;
    }

    public String getNonce() {
        return this.nonce;
    }

    public String toString() {
        return Util.gson().toJson(this);
    }

    public static SessionMaterial read(String str) {
        return (SessionMaterial) Util.gson().fromJson(str, SessionMaterial.class);
    }
}
