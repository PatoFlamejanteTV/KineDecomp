package org.keyczar;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.NoPrimaryKeyException;
import org.keyczar.exceptions.ShortBufferException;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.util.Base64Coder;

/* loaded from: classes3.dex */
public class UnversionedSigner extends UnversionedVerifier {
    static final int TIMESTAMP_SIZE = 8;
    private final StreamQueue<SigningStream> SIGN_QUEUE;

    public UnversionedSigner(KeyczarReader keyczarReader) throws KeyczarException {
        super(keyczarReader);
        this.SIGN_QUEUE = new StreamQueue<>();
    }

    public int digestSize() throws KeyczarException {
        KeyczarKey primaryKey = getPrimaryKey();
        if (primaryKey != null) {
            return ((SigningStream) primaryKey.getStream()).digestSize();
        }
        throw new NoPrimaryKeyException();
    }

    @Override // org.keyczar.UnversionedVerifier, org.keyczar.Keyczar
    boolean isAcceptablePurpose(KeyPurpose keyPurpose) {
        return keyPurpose == KeyPurpose.SIGN_AND_VERIFY;
    }

    public byte[] sign(byte[] bArr) throws KeyczarException {
        ByteBuffer allocate = ByteBuffer.allocate(digestSize());
        sign(ByteBuffer.wrap(bArr), allocate);
        allocate.reset();
        byte[] bArr2 = new byte[allocate.remaining()];
        allocate.get(bArr2);
        return bArr2;
    }

    public UnversionedSigner(String str) throws KeyczarException {
        super(str);
        this.SIGN_QUEUE = new StreamQueue<>();
    }

    void sign(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
        KeyczarKey primaryKey = getPrimaryKey();
        if (primaryKey != null) {
            SigningStream signingStream = (SigningStream) this.SIGN_QUEUE.poll();
            if (signingStream == null) {
                signingStream = (SigningStream) primaryKey.getStream();
            }
            int digestSize = digestSize();
            if (byteBuffer2.capacity() >= digestSize) {
                signingStream.initSign();
                byteBuffer2.mark();
                signingStream.updateSign(byteBuffer);
                signingStream.sign(byteBuffer2);
                byteBuffer2.limit(byteBuffer2.position());
                this.SIGN_QUEUE.add(signingStream);
                return;
            }
            throw new ShortBufferException(byteBuffer2.capacity(), digestSize);
        }
        throw new NoPrimaryKeyException();
    }

    public String sign(String str) throws KeyczarException {
        try {
            return Base64Coder.encodeWebSafe(sign(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            throw new KeyczarException(e2);
        }
    }
}
