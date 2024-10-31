package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbom;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class zzbol<T_WRAPPER extends zzbom<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzbol.class.getName());
    private static final List<Provider> zzfjq;
    public static final zzbol<zzbon, Cipher> zzfjr;
    public static final zzbol<zzbor, Mac> zzfjs;
    private static final zzbol<zzbot, Signature> zzfjt;
    private static final zzbol<zzbos, MessageDigest> zzfju;
    public static final zzbol<zzboo, KeyAgreement> zzfjv;
    public static final zzbol<zzboq, KeyPairGenerator> zzfjw;
    public static final zzbol<zzbop, KeyFactory> zzfjx;
    private T_WRAPPER zzfjy;
    private List<Provider> zzfjz = zzfjq;
    private boolean zzfka = true;

    static {
        if (C0986lh.a()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzfjq = arrayList;
        } else {
            zzfjq = new ArrayList();
        }
        zzfjr = new zzbol<>(new zzbon());
        zzfjs = new zzbol<>(new zzbor());
        zzfjt = new zzbol<>(new zzbot());
        zzfju = new zzbol<>(new zzbos());
        zzfjv = new zzbol<>(new zzboo());
        zzfjw = new zzbol<>(new zzboq());
        zzfjx = new zzbol<>(new zzbop());
    }

    private zzbol(T_WRAPPER t_wrapper) {
        this.zzfjy = t_wrapper;
    }

    private final boolean zza(String str, Provider provider) {
        try {
            this.zzfjy.zzb(str, provider);
            return true;
        } catch (Exception e2) {
            zzbpe.zze(e2);
            return false;
        }
    }

    public final T_ENGINE zzfu(String str) throws GeneralSecurityException {
        for (Provider provider : this.zzfjz) {
            if (zza(str, provider)) {
                return (T_ENGINE) this.zzfjy.zzb(str, provider);
            }
        }
        if (this.zzfka) {
            return (T_ENGINE) this.zzfjy.zzb(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
