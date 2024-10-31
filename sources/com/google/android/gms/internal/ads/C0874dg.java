package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.dg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0874dg implements zzbjn<zzbjm> {
    @Override // com.google.android.gms.internal.ads.zzbjn
    public final zzbjt<zzbjm> zzb(String str, String str2, int i) throws GeneralSecurityException {
        zzbjt<zzbjm> c0888eg;
        String lowerCase = str2.toLowerCase();
        char c2 = 65535;
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : (char) 65535) == 0) {
            switch (str.hashCode()) {
                case 360753376:
                    if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1215885937:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1469984853:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1797113348:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1855890991:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2079211877:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                c0888eg = new C0888eg();
            } else if (c2 == 1) {
                c0888eg = new C0916gg();
            } else if (c2 == 2) {
                c0888eg = new C0930hg();
            } else if (c2 == 3) {
                c0888eg = new C0943ig();
            } else if (c2 == 4) {
                c0888eg = new C0957jg();
            } else if (c2 == 5) {
                c0888eg = new C0971kg();
            } else {
                throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", str));
            }
            if (c0888eg.getVersion() >= i) {
                return c0888eg;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }
}
