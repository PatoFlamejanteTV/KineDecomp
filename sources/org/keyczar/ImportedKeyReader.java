package org.keyczar;

import java.util.ArrayList;
import java.util.List;
import org.keyczar.annotations.Experimental;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.enums.KeyStatus;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

@Experimental
/* loaded from: classes.dex */
public class ImportedKeyReader implements KeyczarReader {
    private final List<KeyczarKey> keys;
    private final KeyMetadata metadata;

    ImportedKeyReader(KeyMetadata keyMetadata, List<KeyczarKey> list) {
        this.metadata = keyMetadata;
        this.keys = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImportedKeyReader(AesKey aesKey) {
        this.metadata = new KeyMetadata("Imported AES", KeyPurpose.DECRYPT_AND_ENCRYPT, DefaultKeyType.AES);
        this.metadata.addVersion(new KeyVersion(0, KeyStatus.PRIMARY, false));
        this.keys = new ArrayList();
        this.keys.add(aesKey);
    }

    ImportedKeyReader(HmacKey hmacKey) {
        this.metadata = new KeyMetadata("Imported HMAC", KeyPurpose.SIGN_AND_VERIFY, DefaultKeyType.HMAC_SHA1);
        this.metadata.addVersion(new KeyVersion(0, KeyStatus.PRIMARY, false));
        this.keys = new ArrayList();
        this.keys.add(hmacKey);
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey() throws KeyczarException {
        return getKey(KeyMetadata.read(getMetadata()).getPrimaryVersion().getVersionNumber());
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey(int i) {
        return this.keys.get(i).toString();
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getMetadata() {
        return this.metadata.toString();
    }
}
