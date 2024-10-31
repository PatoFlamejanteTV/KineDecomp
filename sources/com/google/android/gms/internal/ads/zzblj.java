package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblj extends zzbrd<zzblj, zza> implements zzbsn {
    private static volatile zzbsw<zzblj> zzcas;
    private static final zzblj zzfen = new zzblj();
    private int zzfem;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblj, zza> implements zzbsn {
        private zza() {
            super(zzblj.zzfen);
        }

        /* synthetic */ zza(Ag ag) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblj>) zzblj.class, zzfen);
    }

    private zzblj() {
    }

    public static zzblj zzagm() {
        return zzfen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Ag ag = null;
        switch (Ag.f11377a[i - 1]) {
            case 1:
                return new zzblj();
            case 2:
                return new zza(ag);
            case 3:
                return zzbrd.zza(zzfen, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzfem"});
            case 4:
                return zzfen;
            case 5:
                zzbsw<zzblj> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblj.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfen);
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
