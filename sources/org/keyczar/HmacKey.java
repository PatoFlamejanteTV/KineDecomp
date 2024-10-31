package org.keyczar;

import com.google.gson.annotations.Expose;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.Stream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

/* loaded from: classes.dex */
public class HmacKey extends KeyczarKey {
    private static final String MAC_ALGORITHM = "HMACSHA1";
    private final byte[] hash;
    private SecretKey hmacKey;

    @Expose
    private final String hmacKeyString;

    public HmacKey(byte[] bArr) throws KeyczarException {
        super(bArr.length * 8);
        this.hash = new byte[4];
        this.hmacKeyString = Base64Coder.encodeWebSafe(bArr);
        initJceKey(bArr);
    }

    private HmacKey() {
        super(0);
        this.hash = new byte[4];
        this.hmacKeyString = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HmacKey generate() throws KeyczarException {
        return generate(DefaultKeyType.HMAC_SHA1.defaultSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HmacKey generate(int i) throws KeyczarException {
        return new HmacKey(Util.rand(i / 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initFromJson() throws KeyczarException {
        initJceKey(Base64Coder.decodeWebSafe(this.hmacKeyString));
    }

    private void initJceKey(byte[] bArr) throws KeyczarException {
        this.hmacKey = new SecretKeySpec(bArr, MAC_ALGORITHM);
        System.arraycopy(Util.hash(bArr), 0, this.hash, 0, this.hash.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getEncoded() {
        return this.hmacKey.getEncoded();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public Stream getStream() throws KeyczarException {
        return new HmacStream();
    }

    @Override // org.keyczar.KeyczarKey
    public KeyType getType() {
        return DefaultKeyType.HMAC_SHA1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public byte[] hash() {
        return this.hash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HmacKey read(String str) throws KeyczarException {
        HmacKey hmacKey = (HmacKey) Util.gson().fromJson(str, HmacKey.class);
        hmacKey.initFromJson();
        return hmacKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public SecretKey getJceKey() {
        return this.hmacKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HmacStream implements SigningStream, VerifyingStream {
        private final Mac hmac;

        public HmacStream() throws KeyczarException {
            try {
                this.hmac = Mac.getInstance(HmacKey.MAC_ALGORITHM);
            } catch (GeneralSecurityException e) {
                throw new KeyczarException(e);
            }
        }

        @Override // org.keyczar.interfaces.SigningStream, org.keyczar.interfaces.VerifyingStream
        public int digestSize() {
            return HmacKey.this.getType().getOutputSize();
        }

        @Override // org.keyczar.interfaces.SigningStream
        public void initSign() throws KeyczarException {
            try {
                this.hmac.init(HmacKey.this.hmacKey);
            } catch (GeneralSecurityException e) {
                throw new KeyczarException(e);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public void initVerify() throws KeyczarException {
            initSign();
        }

        @Override // org.keyczar.interfaces.SigningStream
        public void sign(ByteBuffer byteBuffer) {
            byteBuffer.put(this.hmac.doFinal());
        }

        @Override // org.keyczar.interfaces.SigningStream
        public void updateSign(ByteBuffer byteBuffer) {
            this.hmac.update(byteBuffer);
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public void updateVerify(ByteBuffer byteBuffer) {
            updateSign(byteBuffer);
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public boolean verify(ByteBuffer byteBuffer) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return Util.safeArrayEquals(this.hmac.doFinal(), bArr);
        }
    }
}
