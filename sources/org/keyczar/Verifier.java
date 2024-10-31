package org.keyczar;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.BadVersionException;
import org.keyczar.exceptions.KeyNotFoundException;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.ShortSignatureException;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
public class Verifier extends Keyczar {
    private final StreamCache<VerifyingStream> VERIFY_CACHE;

    public Verifier(KeyczarReader keyczarReader) throws KeyczarException {
        super(keyczarReader);
        this.VERIFY_CACHE = new StreamCache<>();
    }

    private byte[] checkFormatAndGetHash(ByteBuffer byteBuffer) throws BadVersionException {
        byte b2 = byteBuffer.get();
        if (b2 == 0) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new BadVersionException(b2);
    }

    private KeyczarKey getVerifyingKey(byte[] bArr) throws KeyNotFoundException {
        KeyczarKey key = getKey(bArr);
        if (key != null) {
            return key;
        }
        throw new KeyNotFoundException(bArr);
    }

    public boolean attachedVerify(byte[] bArr, byte[] bArr2) throws KeyczarException {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        KeyczarKey verifyingKey = getVerifyingKey(checkFormatAndGetHash(wrap));
        byte[] bArr3 = new byte[wrap.getInt()];
        wrap.get(bArr3);
        byte[] bArr4 = new byte[wrap.remaining()];
        wrap.get(bArr4);
        byte[] fromInt = Util.fromInt(0);
        if (bArr2.length > 0) {
            fromInt = Util.lenPrefix(bArr2);
        }
        return rawVerify(verifyingKey, ByteBuffer.wrap(bArr3), ByteBuffer.wrap(fromInt), ByteBuffer.wrap(bArr4));
    }

    public byte[] getAttachedData(byte[] bArr, byte[] bArr2) throws KeyczarException {
        if (attachedVerify(bArr, bArr2)) {
            return getAttachedDataWithoutVerifying(bArr);
        }
        throw new KeyczarException("Attached signature failed to verify. Unable to return signed data.");
    }

    public byte[] getAttachedDataWithoutVerifying(byte[] bArr) throws KeyczarException {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        getVerifyingKey(checkFormatAndGetHash(wrap));
        byte[] bArr2 = new byte[wrap.getInt()];
        wrap.get(bArr2);
        return bArr2;
    }

    @Override // org.keyczar.Keyczar
    boolean isAcceptablePurpose(KeyPurpose keyPurpose) {
        return keyPurpose == KeyPurpose.VERIFY || keyPurpose == KeyPurpose.SIGN_AND_VERIFY;
    }

    boolean rawVerify(KeyczarKey keyczarKey, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) throws KeyczarException {
        VerifyingStream verifyingStream = this.VERIFY_CACHE.get(keyczarKey);
        if (verifyingStream == null) {
            verifyingStream = (VerifyingStream) keyczarKey.getStream();
        }
        verifyingStream.initVerify();
        verifyingStream.updateVerify(byteBuffer);
        if (byteBuffer2 != null) {
            verifyingStream.updateVerify(byteBuffer2);
        }
        verifyingStream.updateVerify(ByteBuffer.wrap(Keyczar.FORMAT_BYTES));
        boolean verify = verifyingStream.verify(byteBuffer3);
        this.VERIFY_CACHE.put(keyczarKey, verifyingStream);
        return verify;
    }

    public boolean verify(byte[] bArr, byte[] bArr2) throws KeyczarException {
        return verify(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr2));
    }

    public boolean verify(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
        return verify(byteBuffer, null, byteBuffer2);
    }

    public Verifier(String str) throws KeyczarException {
        super(str);
        this.VERIFY_CACHE = new StreamCache<>();
    }

    boolean verify(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) throws KeyczarException {
        if (byteBuffer3.remaining() >= 5) {
            byte[] checkFormatAndGetHash = checkFormatAndGetHash(byteBuffer3);
            KeyczarKey verifyingKey = getVerifyingKey(checkFormatAndGetHash);
            if (verifyingKey != null) {
                VerifyingStream verifyingStream = this.VERIFY_CACHE.get(verifyingKey);
                if (verifyingStream == null) {
                    verifyingStream = (VerifyingStream) verifyingKey.getStream();
                }
                verifyingStream.initVerify();
                if (byteBuffer2 != null) {
                    verifyingStream.updateVerify(byteBuffer2);
                }
                verifyingStream.updateVerify(byteBuffer);
                verifyingStream.updateVerify(ByteBuffer.wrap(Keyczar.FORMAT_BYTES));
                boolean verify = verifyingStream.verify(byteBuffer3);
                this.VERIFY_CACHE.put(verifyingKey, verifyingStream);
                return verify;
            }
            throw new KeyNotFoundException(checkFormatAndGetHash);
        }
        throw new ShortSignatureException(byteBuffer3.remaining());
    }

    public boolean verify(String str, String str2) throws KeyczarException {
        try {
            return verify(str.getBytes("UTF-8"), Base64Coder.decodeWebSafe(str2));
        } catch (UnsupportedEncodingException e2) {
            throw new KeyczarException(e2);
        }
    }
}
