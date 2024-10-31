package org.keyczar;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.ShortSignatureException;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Clock;
import org.keyczar.util.SystemClock;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
public class TimeoutVerifier {
    private Clock clock = new SystemClock();
    private Verifier verifier;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutVerifier() {
    }

    void setClock(Clock clock) {
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerifier(Verifier verifier) {
        this.verifier = verifier;
    }

    public boolean verify(String str, String str2) throws KeyczarException {
        try {
            return verify(str.getBytes("UTF-8"), Base64Coder.decodeWebSafe(str2));
        } catch (UnsupportedEncodingException e2) {
            throw new KeyczarException(e2);
        }
    }

    public TimeoutVerifier(KeyczarReader keyczarReader) throws KeyczarException {
        setVerifier(new Verifier(keyczarReader));
    }

    public boolean verify(byte[] bArr, byte[] bArr2) throws KeyczarException {
        return verify(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr2));
    }

    public TimeoutVerifier(String str) throws KeyczarException {
        setVerifier(new Verifier(str));
    }

    public boolean verify(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
        if (byteBuffer2.remaining() >= 13) {
            byte[] bArr = new byte[5];
            byteBuffer2.get(bArr);
            byte[] bArr2 = new byte[8];
            byteBuffer2.get(bArr2);
            if (this.clock.now() > Util.toLong(bArr2)) {
                return false;
            }
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer2.remaining() + 5);
            allocate.put(bArr);
            allocate.put(byteBuffer2);
            allocate.rewind();
            ByteBuffer allocate2 = ByteBuffer.allocate(byteBuffer.remaining() + 8);
            allocate2.put(bArr2);
            allocate2.put(byteBuffer);
            allocate2.rewind();
            return this.verifier.verify(allocate2, allocate);
        }
        throw new ShortSignatureException(byteBuffer2.remaining());
    }

    public TimeoutVerifier(Verifier verifier) {
        setVerifier(verifier);
    }
}
