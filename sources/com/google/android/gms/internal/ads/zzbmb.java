package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmb extends zzbrd<zzbmb, zza> implements zzbsn {
    private static volatile zzbsw<zzbmb> zzcas;
    private static final zzbmb zzffe = new zzbmb();
    private zzbmd zzffd;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmb, zza> implements zzbsn {
        private zza() {
            super(zzbmb.zzffe);
        }

        /* synthetic */ zza(Jg jg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmb>) zzbmb.class, zzffe);
    }

    private zzbmb() {
    }

    public static zzbmb zzw(zzbpu zzbpuVar) throws zzbrl {
        return (zzbmb) zzbrd.zza(zzffe, zzbpuVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Jg jg = null;
        switch (Jg.f11628a[i - 1]) {
            case 1:
                return new zzbmb();
            case 2:
                return new zza(jg);
            case 3:
                return zzbrd.zza(zzffe, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzffd"});
            case 4:
                return zzffe;
            case 5:
                zzbsw<zzbmb> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmb.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzffe);
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

    public final zzbmd zzahc() {
        zzbmd zzbmdVar = this.zzffd;
        return zzbmdVar == null ? zzbmd.zzahh() : zzbmdVar;
    }
}
