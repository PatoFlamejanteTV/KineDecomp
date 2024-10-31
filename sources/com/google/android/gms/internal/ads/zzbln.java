package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbln extends zzbrd<zzbln, zza> implements zzbsn {
    private static volatile zzbsw<zzbln> zzcas;
    private static final zzbln zzfeq = new zzbln();
    private int zzfek;
    private zzblp zzfeo;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbln, zza> implements zzbsn {
        private zza() {
            super(zzbln.zzfeq);
        }

        /* synthetic */ zza(Cg cg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbln>) zzbln.class, zzfeq);
    }

    private zzbln() {
    }

    public static zzbln zzq(zzbpu zzbpuVar) throws zzbrl {
        return (zzbln) zzbrd.zza(zzfeq, zzbpuVar);
    }

    public final int getKeySize() {
        return this.zzfek;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Cg cg = null;
        switch (Cg.f11444a[i - 1]) {
            case 1:
                return new zzbln();
            case 2:
                return new zza(cg);
            case 3:
                return zzbrd.zza(zzfeq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzfeo", "zzfek"});
            case 4:
                return zzfeq;
            case 5:
                zzbsw<zzbln> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbln.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfeq);
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

    public final zzblp zzago() {
        zzblp zzblpVar = this.zzfeo;
        return zzblpVar == null ? zzblp.zzags() : zzblpVar;
    }
}
