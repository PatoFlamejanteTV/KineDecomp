package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmr extends zzbrd<zzbmr, zza> implements zzbsn {
    private static volatile zzbsw<zzbmr> zzcas;
    private static final zzbmr zzfgg = new zzbmr();
    private int zzfek;
    private zzbmt zzfge;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmr, zza> implements zzbsn {
        private zza() {
            super(zzbmr.zzfgg);
        }

        /* synthetic */ zza(Rg rg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmr>) zzbmr.class, zzfgg);
    }

    private zzbmr() {
    }

    public static zzbmr zzag(zzbpu zzbpuVar) throws zzbrl {
        return (zzbmr) zzbrd.zza(zzfgg, zzbpuVar);
    }

    public static zzbmr zzaia() {
        return zzfgg;
    }

    public final int getKeySize() {
        return this.zzfek;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Rg rg = null;
        switch (Rg.f11811a[i - 1]) {
            case 1:
                return new zzbmr();
            case 2:
                return new zza(rg);
            case 3:
                return zzbrd.zza(zzfgg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzfge", "zzfek"});
            case 4:
                return zzfgg;
            case 5:
                zzbsw<zzbmr> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmr.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfgg);
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

    public final zzbmt zzahw() {
        zzbmt zzbmtVar = this.zzfge;
        return zzbmtVar == null ? zzbmt.zzaie() : zzbmtVar;
    }
}
