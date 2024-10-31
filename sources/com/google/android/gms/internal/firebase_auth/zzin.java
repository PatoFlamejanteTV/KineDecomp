package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* loaded from: classes2.dex */
public final class zzin extends zzft<zzin, zza> implements zzhe {
    private static final zzin zzabn = new zzin();
    private static volatile zzhm<zzin> zzm;
    private long zzabl;
    private int zzabm;

    /* loaded from: classes2.dex */
    public static final class zza extends zzft.zza<zzin, zza> implements zzhe {
        private zza() {
            super(zzin.zzabn);
        }

        /* synthetic */ zza(Ea ea) {
            this();
        }
    }

    static {
        zzft.zza((Class<zzin>) zzin.class, zzabn);
    }

    private zzin() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzft
    public final Object zza(int i, Object obj, Object obj2) {
        Ea ea = null;
        switch (Ea.f12961a[i - 1]) {
            case 1:
                return new zzin();
            case 2:
                return new zza(ea);
            case 3:
                return new C1253ha(zzabn, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzabl", "zzabm"});
            case 4:
                return zzabn;
            case 5:
                zzhm<zzin> zzhmVar = zzm;
                if (zzhmVar == null) {
                    synchronized (zzin.class) {
                        zzhmVar = zzm;
                        if (zzhmVar == null) {
                            zzhmVar = new zzft.zzb<>(zzabn);
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
