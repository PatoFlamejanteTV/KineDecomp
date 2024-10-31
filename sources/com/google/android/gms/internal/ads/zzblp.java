package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblp extends zzbrd<zzblp, zza> implements zzbsn {
    private static volatile zzbsw<zzblp> zzcas;
    private static final zzblp zzfer = new zzblp();
    private int zzfem;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblp, zza> implements zzbsn {
        private zza() {
            super(zzblp.zzfer);
        }

        /* synthetic */ zza(Dg dg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblp>) zzblp.class, zzfer);
    }

    private zzblp() {
    }

    public static zzblp zzags() {
        return zzfer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Dg dg = null;
        switch (Dg.f11461a[i - 1]) {
            case 1:
                return new zzblp();
            case 2:
                return new zza(dg);
            case 3:
                return zzbrd.zza(zzfer, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzfem"});
            case 4:
                return zzfer;
            case 5:
                zzbsw<zzblp> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblp.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfer);
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

    public final int zzagl() {
        return this.zzfem;
    }
}
