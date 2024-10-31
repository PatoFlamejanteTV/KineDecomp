package org.keyczar;

import com.google.gson.annotations.Expose;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.keyczar.enums.RsaPadding;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.UnsupportedTypeException;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.Stream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
public class RsaPublicKey extends KeyczarPublicKey {
    private static final String KEY_GEN_ALGORITHM = "RSA";
    private static final String SIG_ALGORITHM = "SHA1withRSA";
    private final byte[] hash;
    private RSAPublicKey jcePublicKey;

    @Expose
    final String modulus;

    @Expose
    final RsaPadding padding;

    @Expose
    final String publicExponent;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class RsaStream implements VerifyingStream, EncryptingStream {
        private Cipher cipher;
        private Signature signature;

        RsaStream() throws KeyczarException {
            try {
                this.signature = Signature.getInstance(RsaPublicKey.SIG_ALGORITHM);
                this.cipher = Cipher.getInstance(RsaPublicKey.this.getPadding().getCryptAlgorithm());
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public int digestSize() {
            return RsaPublicKey.this.getType().getOutputSize();
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public int doFinalEncrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
            try {
                int outputSize = this.cipher.getOutputSize(byteBuffer.limit());
                int limit = byteBuffer2.limit() - byteBuffer2.position();
                ByteBuffer allocate = ByteBuffer.allocate(outputSize);
                this.cipher.doFinal(byteBuffer, allocate);
                if (outputSize == limit) {
                    byteBuffer2.put(allocate.array());
                } else if (outputSize == limit + 1 && allocate.array()[outputSize - 1] == 0) {
                    byteBuffer2.put(allocate.array(), 0, limit);
                } else {
                    throw new KeyczarException("Expected " + limit + " bytes from encryption operation but got " + outputSize);
                }
                return limit;
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public SigningStream getSigningStream() {
            return new SigningStream() { // from class: org.keyczar.RsaPublicKey.RsaStream.1
                @Override // org.keyczar.interfaces.SigningStream, org.keyczar.interfaces.VerifyingStream
                public int digestSize() {
                    return 0;
                }

                @Override // org.keyczar.interfaces.SigningStream
                public void initSign() {
                }

                @Override // org.keyczar.interfaces.SigningStream
                public void sign(ByteBuffer byteBuffer) {
                }

                @Override // org.keyczar.interfaces.SigningStream
                public void updateSign(ByteBuffer byteBuffer) {
                }
            };
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public int initEncrypt(ByteBuffer byteBuffer) throws KeyczarException {
            try {
                this.cipher.init(1, RsaPublicKey.this.jcePublicKey);
                return 0;
            } catch (InvalidKeyException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public void initVerify() throws KeyczarException {
            try {
                this.signature.initVerify(RsaPublicKey.this.jcePublicKey);
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.EncryptingStream, org.keyczar.interfaces.DecryptingStream
        public int maxOutputSize(int i) {
            return RsaPublicKey.this.getType().getOutputSize(RsaPublicKey.this.size);
        }

        @Override // org.keyczar.interfaces.EncryptingStream
        public int updateEncrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException {
            try {
                return this.cipher.update(byteBuffer, byteBuffer2);
            } catch (ShortBufferException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public void updateVerify(ByteBuffer byteBuffer) throws KeyczarException {
            try {
                this.signature.update(byteBuffer);
            } catch (SignatureException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public boolean verify(ByteBuffer byteBuffer) throws KeyczarException {
            try {
                return this.signature.verify(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RsaPublicKey(RSAPrivateCrtKey rSAPrivateCrtKey, RsaPadding rsaPadding) throws KeyczarException {
        this(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rsaPadding);
        initializeJceKey(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent());
        initializeHash();
    }

    private void initializeHash() throws KeyczarException {
        byte[] computeFullHash = getPadding().computeFullHash(this.jcePublicKey);
        byte[] bArr = this.hash;
        System.arraycopy(computeFullHash, 0, bArr, 0, bArr.length);
    }

    private void initializeJceKey(BigInteger bigInteger, BigInteger bigInteger2) throws KeyczarException {
        try {
            this.jcePublicKey = (RSAPublicKey) KeyFactory.getInstance(KEY_GEN_ALGORITHM).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
        } catch (GeneralSecurityException e2) {
            throw new KeyczarException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RsaPublicKey read(String str) throws KeyczarException {
        RsaPublicKey rsaPublicKey = (RsaPublicKey) Util.gson().fromJson(str, RsaPublicKey.class);
        if (rsaPublicKey.getType() == DefaultKeyType.RSA_PUB) {
            return rsaPublicKey.initFromJson();
        }
        throw new UnsupportedTypeException(rsaPublicKey.getType());
    }

    public RsaPadding getPadding() {
        RsaPadding rsaPadding = this.padding;
        if (rsaPadding != null && rsaPadding != RsaPadding.OAEP) {
            return RsaPadding.PKCS;
        }
        return RsaPadding.OAEP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public Stream getStream() throws KeyczarException {
        return new RsaStream();
    }

    @Override // org.keyczar.KeyczarKey
    public KeyType getType() {
        return DefaultKeyType.RSA_PUB;
    }

    @Override // org.keyczar.KeyczarKey
    public byte[] hash() {
        return this.hash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RsaPublicKey initFromJson() throws KeyczarException {
        initializeJceKey(Util.decodeBigInteger(this.modulus), Util.decodeBigInteger(this.publicExponent));
        initializeHash();
        return this;
    }

    @Override // org.keyczar.KeyczarKey
    protected boolean isSecret() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public RSAPublicKey getJceKey() {
        return this.jcePublicKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RsaPublicKey(RSAPublicKey rSAPublicKey, RsaPadding rsaPadding) throws KeyczarException {
        this(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent(), rsaPadding);
        this.jcePublicKey = rSAPublicKey;
        initializeHash();
    }

    private RsaPublicKey() {
        super(0);
        this.hash = new byte[4];
        this.publicExponent = null;
        this.modulus = null;
        this.padding = null;
    }

    private RsaPublicKey(BigInteger bigInteger, BigInteger bigInteger2, RsaPadding rsaPadding) {
        super(bigInteger.bitLength());
        this.hash = new byte[4];
        this.modulus = Util.encodeBigInteger(bigInteger);
        this.publicExponent = Util.encodeBigInteger(bigInteger2);
        RsaPadding rsaPadding2 = RsaPadding.PKCS;
        this.padding = rsaPadding != rsaPadding2 ? null : rsaPadding2;
    }
}
