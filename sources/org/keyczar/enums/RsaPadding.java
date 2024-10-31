package org.keyczar.enums;

import java.security.interfaces.RSAPublicKey;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.util.Util;

/* loaded from: classes3.dex */
public enum RsaPadding {
    OAEP("RSA/ECB/OAEPWITHSHA1ANDMGF1PADDING"),
    PKCS("RSA/ECB/PKCS1PADDING");

    private final String cryptAlgorithm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.keyczar.enums.RsaPadding$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$keyczar$enums$RsaPadding = new int[RsaPadding.values().length];

        static {
            try {
                $SwitchMap$org$keyczar$enums$RsaPadding[RsaPadding.OAEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$keyczar$enums$RsaPadding[RsaPadding.PKCS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    RsaPadding(String str) {
        this.cryptAlgorithm = str;
    }

    public byte[] computeFullHash(RSAPublicKey rSAPublicKey) throws KeyczarException {
        int i = AnonymousClass1.$SwitchMap$org$keyczar$enums$RsaPadding[ordinal()];
        if (i == 1) {
            return Util.prefixHash(Util.stripLeadingZeros(rSAPublicKey.getModulus().toByteArray()), Util.stripLeadingZeros(rSAPublicKey.getPublicExponent().toByteArray()));
        }
        if (i == 2) {
            return Util.prefixHash(rSAPublicKey.getModulus().toByteArray(), rSAPublicKey.getPublicExponent().toByteArray());
        }
        throw new KeyczarException("Bug! Unknown padding type");
    }

    public String getCryptAlgorithm() {
        return this.cryptAlgorithm;
    }
}
