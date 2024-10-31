package org.keyczar;

import java.util.HashMap;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.enums.KeyStatus;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.EncryptedReader;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.util.Util;

/* loaded from: classes.dex */
public abstract class Keyczar {
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final byte[] FORMAT_BYTES = {0};
    public static final byte FORMAT_VERSION = 0;
    public static final int HEADER_SIZE = 5;
    public static final int KEY_HASH_SIZE = 4;
    final HashMap<KeyHash, KeyczarKey> hashMap;
    final KeyMetadata kmd;
    KeyVersion primaryVersion;
    final HashMap<KeyVersion, KeyczarKey> versionMap;

    abstract boolean isAcceptablePurpose(KeyPurpose keyPurpose);

    /* loaded from: classes.dex */
    public class KeyHash {
        private byte[] data;

        /* synthetic */ KeyHash(Keyczar keyczar, byte[] bArr, AnonymousClass1 anonymousClass1) {
            this(bArr);
        }

        private KeyHash(byte[] bArr) {
            if (bArr.length != 4) {
                throw new IllegalArgumentException();
            }
            this.data = bArr;
        }

        public boolean equals(Object obj) {
            return (obj instanceof KeyHash) && obj.hashCode() == hashCode();
        }

        public int hashCode() {
            return Util.toInt(this.data);
        }
    }

    public Keyczar(KeyczarReader keyczarReader) throws KeyczarException {
        this.versionMap = new HashMap<>();
        this.hashMap = new HashMap<>();
        this.kmd = KeyMetadata.read(keyczarReader.getMetadata());
        if (!isAcceptablePurpose(this.kmd.getPurpose())) {
            throw new KeyczarException(Messages.getString("Keyczar.UnacceptablePurpose", this.kmd.getPurpose()));
        }
        if (this.kmd.isEncrypted() && !(keyczarReader instanceof EncryptedReader)) {
            throw new KeyczarException(Messages.getString("Keyczar.NeedEncryptedReader", new Object[0]));
        }
        for (KeyVersion keyVersion : this.kmd.getVersions()) {
            if (keyVersion.getStatus() == KeyStatus.PRIMARY) {
                if (this.primaryVersion != null) {
                    throw new KeyczarException(Messages.getString("Keyczar.SinglePrimary", new Object[0]));
                }
                this.primaryVersion = keyVersion;
            }
            KeyczarKey readKey = KeyczarKey.readKey(this.kmd.getType(), keyczarReader.getKey(keyVersion.getVersionNumber()));
            this.hashMap.put(new KeyHash(readKey.hash()), readKey);
            this.versionMap.put(keyVersion, readKey);
        }
    }

    public Keyczar(String str) throws KeyczarException {
        this(new KeyczarFileReader(str));
    }

    public String toString() {
        return this.kmd.toString();
    }

    public void addKey(KeyVersion keyVersion, KeyczarKey keyczarKey) {
        this.hashMap.put(new KeyHash(keyczarKey.hash()), keyczarKey);
        this.versionMap.put(keyVersion, keyczarKey);
        this.kmd.addVersion(keyVersion);
    }

    public KeyczarKey getPrimaryKey() {
        if (this.primaryVersion == null) {
            return null;
        }
        return this.versionMap.get(this.primaryVersion);
    }

    public KeyczarKey getKey(byte[] bArr) {
        return this.hashMap.get(new KeyHash(bArr));
    }
}
