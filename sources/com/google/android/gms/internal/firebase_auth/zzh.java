package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* loaded from: classes2.dex */
public final class zzh extends zzft<zzh, zza> implements zzhe {
    private static final zzh zzl = new zzh();
    private static volatile zzhm<zzh> zzm;
    private int zzi;
    private String zzj = "";
    private String zzk = "";

    /* loaded from: classes2.dex */
    public static final class zza extends zzft.zza<zzh, zza> implements zzhe {
        private zza() {
            super(zzh.zzl);
        }

        /* synthetic */ zza(C1271qa c1271qa) {
            this();
        }
    }

    static {
        zzft.zza((Class<zzh>) zzh.class, zzl);
    }

    private zzh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzft
    public final Object zza(int i, Object obj, Object obj2) {
        C1271qa c1271qa = null;
        switch (C1271qa.f13073a[i - 1]) {
            case 1:
                return new zzh();
            case 2:
                return new zza(c1271qa);
            case 3:
                return zzft.zza(zzl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                zzhm<zzh> zzhmVar = zzm;
                if (zzhmVar == null) {
                    synchronized (zzh.class) {
                        zzhmVar = zzm;
                        if (zzhmVar == null) {
                            zzhmVar = new zzft.zzb<>(zzl);
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
}
