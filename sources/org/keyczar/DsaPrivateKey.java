package org.keyczar;

import com.google.gson.annotations.Expose;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAPrivateKeySpec;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.Stream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
public class DsaPrivateKey extends KeyczarKey implements KeyczarPrivateKey {
    private static final String KEY_GEN_ALGORITHM = "DSA";
    private static final String SIG_ALGORITHM = "SHA1withDSA";
    private DSAPrivateKey jcePrivateKey;

    @Expose
    private final DsaPublicKey publicKey;

    @Expose
    private final String x;

    /* loaded from: classes3.dex */
    private class DsaSigningStream implements SigningStream, VerifyingStream {
        private Signature signature;
        private VerifyingStream verifyingStream;

        public DsaSigningStream() throws KeyczarException {
            try {
                this.signature = Signature.getInstance(DsaPrivateKey.SIG_ALGORITHM);
                this.verifyingStream = (VerifyingStream) DsaPrivateKey.this.publicKey.getStream();
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.SigningStream, org.keyczar.interfaces.VerifyingStream
        public int digestSize() {
            return DsaPrivateKey.this.getType().getOutputSize();
        }

        @Override // org.keyczar.interfaces.SigningStream
        public void initSign() throws KeyczarException {
            try {
                this.signature.initSign(DsaPrivateKey.this.jcePrivateKey);
            } catch (GeneralSecurityException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public void initVerify() throws KeyczarException {
            this.verifyingStream.initVerify();
        }

        @Override // org.keyczar.interfaces.SigningStream
        public void sign(ByteBuffer byteBuffer) throws KeyczarException {
            try {
                byteBuffer.put(this.signature.sign());
            } catch (SignatureException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.SigningStream
        public void updateSign(ByteBuffer byteBuffer) throws KeyczarException {
            try {
                this.signature.update(byteBuffer);
            } catch (SignatureException e2) {
                throw new KeyczarException(e2);
            }
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public void updateVerify(ByteBuffer byteBuffer) throws KeyczarException {
            this.verifyingStream.updateVerify(byteBuffer);
        }

        @Override // org.keyczar.interfaces.VerifyingStream
        public boolean verify(ByteBuffer byteBuffer) throws KeyczarException {
            return this.verifyingStream.verify(byteBuffer);
        }
    }

    public DsaPrivateKey(DSAPrivateKey dSAPrivateKey) throws KeyczarException {
        super(dSAPrivateKey.getParams().getP().bitLength());
        this.publicKey = new DsaPublicKey(dSAPrivateKey);
        this.jcePrivateKey = dSAPrivateKey;
        this.x = Base64Coder.encodeWebSafe(this.jcePrivateKey.getX().toByteArray());
    }

    static DsaPrivateKey generate() throws KeyczarException {
        return generate(DefaultKeyType.DSA_PRIV.defaultSize());
    }

    private DsaPrivateKey initFromJson() throws KeyczarException {
        this.publicKey.initFromJson();
        try {
            this.jcePrivateKey = (DSAPrivateKey) KeyFactory.getInstance(KEY_GEN_ALGORITHM).generatePrivate(new DSAPrivateKeySpec(new BigInteger(Base64Coder.decodeWebSafe(this.x)), new BigInteger(Base64Coder.decodeWebSafe(this.publicKey.p)), new BigInteger(Base64Coder.decodeWebSafe(this.publicKey.q)), new BigInteger(Base64Coder.decodeWebSafe(this.publicKey.f29338g))));
            return this;
        } catch (GeneralSecurityException e2) {
            throw new KeyczarException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DsaPrivateKey read(String str) throws KeyczarException {
        DsaPrivateKey dsaPrivateKey = (DsaPrivateKey) Util.gson().fromJson(str, DsaPrivateKey.class);
        dsaPrivateKey.initFromJson();
        return dsaPrivateKey;
    }

    public String getKeyGenAlgorithm() {
        return KEY_GEN_ALGORITHM;
    }

    @Override // org.keyczar.KeyczarPrivateKey
    public KeyczarPublicKey getPublic() {
        return this.publicKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public Stream getStream() throws KeyczarException {
        return new DsaSigningStream();
    }

    @Override // org.keyczar.KeyczarKey
    public KeyType getType() {
        return DefaultKeyType.DSA_PRIV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public byte[] hash() {
        return getPublic().hash();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DsaPrivateKey generate(int i) throws KeyczarException {
        return new DsaPrivateKey((DSAPrivateKey) Util.generateKeyPair(KEY_GEN_ALGORITHM, i).getPrivate());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.keyczar.KeyczarKey
    public DSAPrivateKey getJceKey() {
        return this.jcePrivateKey;
    }

    private DsaPrivateKey() {
        super(0);
        this.publicKey = null;
        this.x = null;
    }
}
