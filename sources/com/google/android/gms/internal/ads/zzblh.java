package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblh extends zzbrd<zzblh, zza> implements zzbsn {
    private static volatile zzbsw<zzblh> zzcas;
    private static final zzblh zzfel = new zzblh();
    private zzblj zzfeh;
    private int zzfek;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblh, zza> implements zzbsn {
        private zza() {
            super(zzblh.zzfel);
        }

        /* synthetic */ zza(C1180zg c1180zg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblh>) zzblh.class, zzfel);
    }

    private zzblh() {
    }

    public static zzblh zzagj() {
        return zzfel;
    }

    public static zzblh zzn(zzbpu zzbpuVar) throws zzbrl {
        return (zzblh) zzbrd.zza(zzfel, zzbpuVar);
    }

    public final int getKeySize() {
        return this.zzfek;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C1180zg c1180zg = null;
        switch (C1180zg.f12703a[i - 1]) {
            case 1:
                return new zzblh();
            case 2:
                return new zza(c1180zg);
            case 3:
                return zzbrd.zza(zzfel, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzfeh", "zzfek"});
            case 4:
                return zzfel;
            case 5:
                zzbsw<zzblh> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblh.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfel);
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

    public final zzblj zzage() {
        zzblj zzbljVar = this.zzfeh;
        return zzbljVar == null ? zzblj.zzagm() : zzbljVar;
    }
}
