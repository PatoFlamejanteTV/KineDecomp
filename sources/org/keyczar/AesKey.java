package org.keyczar;

import com.google.gson.annotations.Expose;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.keyczar.enums.CipherMode;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.DecryptingStream;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.Stream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
public class AesKey extends KeyczarKey {
    private static final String AES_ALGORITHM = "AES";
    private static final int BLOCK_SIZE = 16;
    private static final CipherMode DEFAULT_MODE = CipherMode.CBC;
    private SecretKey aesKey;

    @Expose
    private final String aesKeyString;
    private final byte[] hash;

    @Expose
    private final HmacKey hmacKey;

    @Expose
    private final CipherMode mode;

    /* loaded from: classes3.dex */
    private class AesStream implements EncryptingStream, DecryptingStream {
        private final Cipher decryptingCipher;
        private final Cipher encryptingCipher;
        boolean ivRead = false;
        private final SigningStream signStream;

        public AesStream() throws KeyczarException {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
            try {
                this.encryptingCipher = Cipher.getInstance(AesKey.this.mode.getMode());
                this.encryptingCipher.init(1, AesKey.this.aesKey, ivParameterSpec);
                this.decryptingCipher = Cipher.getInstance(AesKey.this.mode.getMode());
                this.decryptingCipher.init(2, AesKey.this.aesKey, ivParameterSpec);
                this.signStream = (SigningStream) AesKey.this.hmacKey.getStream();
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.DecryptingStream
        public int doFinalDecrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
            if (this.ivRead) {
                if (byteBuffer.remaining() == 0) {
                    return 0;
                }
                byte[] bArr = new byte[16];
                byteBuffer.get(bArr);
                this.decryptingCipher.update(bArr);
                this.ivRead = false;
            }
            try {
                if (byteBuffer.remaining() == 0) {
                    byte[] doFinal = this.decryptingCipher.doFinal();
                    byteBuffer2.put(doFinal);
                    return doFinal.length;
                }
                return this.decryptingCipher.doFinal(byteBuffer, byteBuffer2);
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public int doFinalEncrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
            try {
                return this.encryptingCipher.doFinal(byteBuffer, byteBuffer2);
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public SigningStream getSigningStream() {
            return this.signStream;
        }

        @Override // org.keyczar.interfaces.DecryptingStream
        public VerifyingStream getVerifyingStream() {
            return (VerifyingStream) this.signStream;
        }

        @Override // org.keyczar.interfaces.DecryptingStream
        public void initDecrypt(ByteBuffer byteBuffer) {
            byte[] bArr = new byte[16];
            byteBuffer.get(bArr);
            this.decryptingCipher.update(bArr);
            this.ivRead = true;
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public int initEncrypt(ByteBuffer byteBuffer) throws KeyczarException {
            byte[] bArr = new byte[16];
            Util.rand(bArr);
            try {
                return this.encryptingCipher.update(ByteBuffer.wrap(bArr), byteBuffer);
            } catch (ShortBufferException e2) {
                throw new org.keyczar.exceptions.ShortBufferException(e2);
            }
        }

        @Override // org.keyczar.interfaces.EncryptingStream, org.keyczar.interfaces.DecryptingStream
        public int maxOutputSize(int i) {
            return AesKey.this.mode.getOutputSize(16, i);
        }

        @Override // org.keyczar.interfaces.DecryptingStream
        public int updateDecrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
            if (this.ivRead && byteBuffer.remaining() >= 16) {
                byte[] bArr = new byte[16];
                byteBuffer.get(bArr);
                this.decryptingCipher.update(bArr);
                this.ivRead = false;
            }
            try {
                return this.decryptingCipher.update(byteBuffer, byteBuffer2);
            } catch (ShortBufferException e2) {
                throw new org.keyczar.exceptions.ShortBufferException(e2);
            }
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public int updateEncrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
            try {
                return this.encryptingCipher.update(byteBuffer, byteBuffer2);
            } catch (ShortBufferException e2) {
                throw new org.keyczar.exceptions.ShortBufferException(e2);
            }
        }
    }

    public AesKey(byte[] bArr, HmacKey hmacKey) throws KeyczarException {
        super(bArr.length * 8);
        this.hash = new byte[4];
        this.aesKeyString = Base64Coder.encodeWebSafe(bArr);
        this.mode = DEFAULT_MODE;
        this.hmacKey = hmacKey;
        initJceKey(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AesKey fromPackedKey(byte[] bArr) throws KeyczarException {
        byte[][] lenPrefixUnpack = Util.lenPrefixUnpack(bArr);
        if (lenPrefixUnpack.length == 2) {
            return new AesKey(lenPrefixUnpack[0], new HmacKey(lenPrefixUnpack[1]));
        }
        throw new KeyczarException(Messages.getString("AesKey.InvalidPackedKey", new Object[0]));
    }

    static AesKey generate() throws KeyczarException {
        return generate(DefaultKeyType.AES.defaultSize());
    }

    private void initJceKey(byte[] bArr) throws KeyczarException {
        this.aesKey = new SecretKeySpec(bArr, AES_ALGORITHM);
        byte[] hash = Util.hash(Util.fromInt(16), bArr, this.hmacKey.getEncoded());
        byte[] bArr2 = this.hash;
        System.arraycopy(hash, 0, bArr2, 0, bArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AesKey read(String str) throws KeyczarException {
        AesKey aesKey = (AesKey) Util.gson().fromJson(str, AesKey.class);
        aesKey.hmacKey.initFromJson();
        aesKey.initJceKey(Base64Coder.decodeWebSafe(aesKey.aesKeyString));
        return aesKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getEncoded() {
        return Util.lenPrefixPack(this.aesKey.getEncoded(), this.hmacKey.getEncoded());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public Stream getStream() throws KeyczarException {
        return new AesStream();
    }

    @Override // org.keyczar.KeyczarKey
    public KeyType getType() {
        return DefaultKeyType.AES;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public byte[] hash() {
        return this.hash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AesKey generate(int i) throws KeyczarException {
        return new AesKey(Util.rand(i / 8), HmacKey.generate());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public SecretKey getJceKey() {
        return this.aesKey;
    }

    private AesKey() {
        super(0);
        this.hash = new byte[4];
        this.aesKeyString = null;
        this.hmacKey = null;
        this.mode = null;
    }
}
