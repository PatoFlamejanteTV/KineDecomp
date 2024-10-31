package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbld extends zzbrd<zzbld, zza> implements zzbsn {
    private static volatile zzbsw<zzbld> zzcas;
    private static final zzbld zzfeg = new zzbld();
    private zzblh zzfee;
    private zzbmr zzfef;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbld, zza> implements zzbsn {
        private zza() {
            super(zzbld.zzfeg);
        }

        /* synthetic */ zza(C1152xg c1152xg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbld>) zzbld.class, zzfeg);
    }

    private zzbld() {
    }

    public static zzbld zzj(zzbpu zzbpuVar) throws zzbrl {
        return (zzbld) zzbrd.zza(zzfeg, zzbpuVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C1152xg c1152xg = null;
        switch (C1152xg.f12659a[i - 1]) {
            case 1:
                return new zzbld();
            case 2:
                return new zza(c1152xg);
            case 3:
                return zzbrd.zza(zzfeg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzfee", "zzfef"});
            case 4:
                return zzfeg;
            case 5:
                zzbsw<zzbld> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbld.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfeg);
                            zzcas = zzbswVar;
                        }
                    }
                }
                return zzbswVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzblh zzagb() {
        zzblh zzblhVar = this.zzfee;
        return zzblhVar == null ? zzblh.zzagj() : zzblhVar;
    }

    public final zzbmr zzagc() {
        zzbmr zzbmrVar = this.zzfef;
        return zzbmrVar == null ? zzbmr.zzaia() : zzbmrVar;
    }
}
