package org.keyczar;

import java.util.HashMap;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.enums.KeyStatus;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.EncryptedReader;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class KeyHash {
        private byte[] data;

        public boolean equals(Object obj) {
            return (obj instanceof KeyHash) && obj.hashCode() == hashCode();
        }

        public int hashCode() {
            return Util.toInt(this.data);
        }

        private KeyHash(byte[] bArr) {
            if (bArr.length == 4) {
                this.data = bArr;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public Keyczar(KeyczarReader keyczarReader) throws KeyczarException {
        this.versionMap = new HashMap<>();
        this.hashMap = new HashMap<>();
        this.kmd = KeyMetadata.read(keyczarReader.getMetadata());
        if (isAcceptablePurpose(this.kmd.getPurpose())) {
            if (this.kmd.isEncrypted() && !(keyczarReader instanceof EncryptedReader)) {
                throw new KeyczarException(Messages.getString("Keyczar.NeedEncryptedReader", new Object[0]));
            }
            for (KeyVersion keyVersion : this.kmd.getVersions()) {
                if (keyVersion.getStatus() == KeyStatus.PRIMARY) {
                    if (this.primaryVersion == null) {
                        this.primaryVersion = keyVersion;
                    } else {
                        throw new KeyczarException(Messages.getString("Keyczar.SinglePrimary", new Object[0]));
                    }
                }
                KeyczarKey readKey = KeyczarKey.readKey(this.kmd.getType(), keyczarReader.getKey(keyVersion.getVersionNumber()));
                this.hashMap.put(new KeyHash(readKey.hash()), readKey);
                this.versionMap.put(keyVersion, readKey);
            }
            return;
        }
        throw new KeyczarException(Messages.getString("Keyczar.UnacceptablePurpose", this.kmd.getPurpose()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addKey(KeyVersion keyVersion, KeyczarKey keyczarKey) {
        this.hashMap.put(new KeyHash(keyczarKey.hash()), keyczarKey);
        this.versionMap.put(keyVersion, keyczarKey);
        this.kmd.addVersion(keyVersion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyczarKey getKey(byte[] bArr) {
        return this.hashMap.get(new KeyHash(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyczarKey getPrimaryKey() {
        KeyVersion keyVersion = this.primaryVersion;
        if (keyVersion == null) {
            return null;
        }
        return this.versionMap.get(keyVersion);
    }

    abstract boolean isAcceptablePurpose(KeyPurpose keyPurpose);

    public String toString() {
        return this.kmd.toString();
    }

    public Keyczar(String str) throws KeyczarException {
        this(new KeyczarFileReader(str));
    }
}
