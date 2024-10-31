package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbne;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzbkb {
    private static final Logger logger = Logger.getLogger(zzbkb.class.getName());
    private static final ConcurrentMap<String, zzbjt> zzfdi = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzfdj = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzbjn> zzfdk = new ConcurrentHashMap();

    public static synchronized <P> void zza(String str, zzbjn<P> zzbjnVar) throws GeneralSecurityException {
        synchronized (zzbkb.class) {
            if (zzfdk.containsKey(str.toLowerCase())) {
                if (!zzbjnVar.getClass().equals(zzfdk.get(str.toLowerCase()).getClass())) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str);
                    logger2.logp(level, "com.google.crypto.tink.Registry", "addCatalogue", valueOf.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(valueOf) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                    sb.append("catalogue for name ");
                    sb.append(str);
                    sb.append(" has been already registered");
                    throw new GeneralSecurityException(sb.toString());
                }
            }
            zzfdk.put(str.toLowerCase(), zzbjnVar);
        }
    }

    public static synchronized <P> zzbsl zzb(zzbna zzbnaVar) throws GeneralSecurityException {
        zzbsl zzb;
        synchronized (zzbkb.class) {
            zzbjt zzfj = zzfj(zzbnaVar.zzaig());
            if (zzfdj.get(zzbnaVar.zzaig()).booleanValue()) {
                zzb = zzfj.zzb(zzbnaVar.zzaih());
            } else {
                String valueOf = String.valueOf(zzbnaVar.zzaig());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzb;
    }

    public static <P> zzbjn<P> zzfi(String str) throws GeneralSecurityException {
        if (str != null) {
            zzbjn<P> zzbjnVar = zzfdk.get(str.toLowerCase());
            if (zzbjnVar != null) {
                return zzbjnVar;
            }
            String format = String.format("no catalogue found for %s. ", str);
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (!str.toLowerCase().startsWith("tinkdeterministicaead")) {
                if (!str.toLowerCase().startsWith("tinkstreamingaead")) {
                    if (!str.toLowerCase().startsWith("tinkhybriddecrypt") && !str.toLowerCase().startsWith("tinkhybridencrypt")) {
                        if (!str.toLowerCase().startsWith("tinkmac")) {
                            if (!str.toLowerCase().startsWith("tinkpublickeysign") && !str.toLowerCase().startsWith("tinkpublickeyverify")) {
                                if (str.toLowerCase().startsWith("tink")) {
                                    format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
                                }
                            } else {
                                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
                            }
                        } else {
                            format = String.valueOf(format).concat("Maybe call MacConfig.register().");
                        }
                    } else {
                        format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
                    }
                } else {
                    format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
                }
            } else {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <P> zzbjt<P> zzfj(String str) throws GeneralSecurityException {
        zzbjt<P> zzbjtVar = zzfdi.get(str);
        if (zzbjtVar != null) {
            return zzbjtVar;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("No key manager found for key type: ");
        sb.append(str);
        sb.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(sb.toString());
    }

    public static <P> P zzb(String str, zzbsl zzbslVar) throws GeneralSecurityException {
        return (P) zzfj(str).zza(zzbslVar);
    }

    public static synchronized <P> void zza(zzbjt<P> zzbjtVar) throws GeneralSecurityException {
        synchronized (zzbkb.class) {
            zza((zzbjt) zzbjtVar, true);
        }
    }

    public static synchronized <P> void zza(zzbjt<P> zzbjtVar, boolean z) throws GeneralSecurityException {
        synchronized (zzbkb.class) {
            if (zzbjtVar != null) {
                String keyType = zzbjtVar.getKeyType();
                if (zzfdi.containsKey(keyType)) {
                    zzbjt zzfj = zzfj(keyType);
                    boolean booleanValue = zzfdj.get(keyType).booleanValue();
                    if (!zzbjtVar.getClass().equals(zzfj.getClass()) || (!booleanValue && z)) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(keyType);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                        throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", keyType, zzfj.getClass().getName(), zzbjtVar.getClass().getName()));
                    }
                }
                zzfdi.put(keyType, zzbjtVar);
                zzfdj.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <P> zzbmv zza(zzbna zzbnaVar) throws GeneralSecurityException {
        zzbmv zzc;
        synchronized (zzbkb.class) {
            zzbjt zzfj = zzfj(zzbnaVar.zzaig());
            if (zzfdj.get(zzbnaVar.zzaig()).booleanValue()) {
                zzc = zzfj.zzc(zzbnaVar.zzaih());
            } else {
                String valueOf = String.valueOf(zzbnaVar.zzaig());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzc;
    }

    public static synchronized <P> zzbsl zza(String str, zzbsl zzbslVar) throws GeneralSecurityException {
        zzbsl zzb;
        synchronized (zzbkb.class) {
            zzbjt zzfj = zzfj(str);
            if (zzfdj.get(str).booleanValue()) {
                zzb = zzfj.zzb(zzbslVar);
            } else {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzb;
    }

    private static <P> P zza(String str, zzbpu zzbpuVar) throws GeneralSecurityException {
        return (P) zzfj(str).zza(zzbpuVar);
    }

    public static <P> P zza(String str, byte[] bArr) throws GeneralSecurityException {
        return (P) zza(str, zzbpu.zzr(bArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzbjz<P> zza(zzbju zzbjuVar, zzbjt<P> zzbjtVar) throws GeneralSecurityException {
        C0859cg.b(zzbjuVar.zzafp());
        zzbjz<P> zzbjzVar = (zzbjz<P>) new zzbjz();
        for (zzbne.zzb zzbVar : zzbjuVar.zzafp().zzaiv()) {
            if (zzbVar.zzaja() == zzbmy.ENABLED) {
                zzbka zza = zzbjzVar.zza(zza(zzbVar.zzaiz().zzaig(), zzbVar.zzaiz().zzaih()), zzbVar);
                if (zzbVar.zzajb() == zzbjuVar.zzafp().zzaiu()) {
                    zzbjzVar.zza(zza);
                }
            }
        }
        return zzbjzVar;
    }
}
