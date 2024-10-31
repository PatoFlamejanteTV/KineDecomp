package org.keyczar;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Base64Coder;

/* loaded from: classes.dex */
public class UnversionedVerifier extends Keyczar {
    private static final StreamCache<VerifyingStream> VERIFY_CACHE = new StreamCache<>();

    public UnversionedVerifier(KeyczarReader keyczarReader) throws KeyczarException {
        super(keyczarReader);
    }

    public UnversionedVerifier(String str) throws KeyczarException {
        super(str);
    }

    public boolean verify(byte[] bArr, byte[] bArr2) throws KeyczarException {
        return verify(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr2));
    }

    public boolean verify(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
        Iterator<Map.Entry<KeyVersion, KeyczarKey>> it = this.versionMap.entrySet().iterator();
        while (it.hasNext()) {
            KeyczarKey value = it.next().getValue();
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            VerifyingStream verifyingStream = VERIFY_CACHE.get(value);
            if (verifyingStream == null) {
                verifyingStream = (VerifyingStream) value.getStream();
            }
            verifyingStream.initVerify();
            verifyingStream.updateVerify(duplicate);
            boolean verify = verifyingStream.verify(duplicate2);
            VERIFY_CACHE.put(value, verifyingStream);
            if (verify) {
                return true;
            }
        }
        return false;
    }

    public boolean verify(String str, String str2) throws KeyczarException {
        try {
            return verify(str.getBytes(Keyczar.DEFAULT_ENCODING), Base64Coder.decodeWebSafe(str2));
        } catch (UnsupportedEncodingException e) {
            throw new KeyczarException(e);
        }
    }

    @Override // org.keyczar.Keyczar
    boolean isAcceptablePurpose(KeyPurpose keyPurpose) {
        return keyPurpose == KeyPurpose.VERIFY || keyPurpose == KeyPurpose.SIGN_AND_VERIFY;
    }
}
