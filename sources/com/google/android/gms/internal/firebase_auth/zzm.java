package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* loaded from: classes2.dex */
public final class zzm extends zzft<zzm, zza> implements zzhe {
    private static final zzm zzet = new zzm();
    private static volatile zzhm<zzm> zzm;
    private int zzi;
    private String zzr = "";
    private String zzcd = "";
    private String zzcn = "";
    private String zzdk = "";
    private String zzat = "";
    private String zzes = "";
    private String zzei = "";
    private String zzby = "";

    /* loaded from: classes2.dex */
    public static final class zza extends zzft.zza<zzm, zza> implements zzhe {
        private zza() {
            super(zzm.zzet);
        }

        /* synthetic */ zza(Xa xa) {
            this();
        }
    }

    static {
        zzft.zza((Class<zzm>) zzm.class, zzet);
    }

    private zzm() {
    }

    public final String getDisplayName() {
        return this.zzcd;
    }

    public final String getEmail() {
        return this.zzat;
    }

    public final String getPhoneNumber() {
        return this.zzby;
    }

    public final String getProviderId() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzft
    public final Object zza(int i, Object obj, Object obj2) {
        Xa xa = null;
        switch (Xa.f12999a[i - 1]) {
            case 1:
                return new zzm();
            case 2:
                return new zza(xa);
            case 3:
                return zzft.zza(zzet, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\t\b\u0007", new Object[]{"zzi", "zzr", "zzcd", "zzcn", "zzdk", "zzat", "zzes", "zzei", "zzby"});
            case 4:
                return zzet;
            case 5:
                zzhm<zzm> zzhmVar = zzm;
                if (zzhmVar == null) {
                    synchronized (zzm.class) {
                        zzhmVar = zzm;
                        if (zzhmVar == null) {
                            zzhmVar = new zzft.zzb<>(zzet);
                            zzm = zzhmVar;
                        }
                    }
                }
                return zzhmVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final String zzal() {
        return this.zzcn;
    }

    public final String zzbg() {
        return this.zzdk;
    }
}
