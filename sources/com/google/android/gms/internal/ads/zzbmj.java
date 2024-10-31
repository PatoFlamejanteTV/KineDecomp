package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmj extends zzbrd<zzbmj, zza> implements zzbsn {
    private static volatile zzbsw<zzbmj> zzcas;
    private static final zzbmj zzffr = new zzbmj();
    private int zzffo;
    private int zzffp;
    private zzbpu zzffq = zzbpu.zzfli;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmj, zza> implements zzbsn {
        private zza() {
            super(zzbmj.zzffr);
        }

        /* synthetic */ zza(Ng ng) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmj>) zzbmj.class, zzffr);
    }

    private zzbmj() {
    }

    public static zzbmj zzahu() {
        return zzffr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Ng ng = null;
        switch (Ng.f11712a[i - 1]) {
            case 1:
                return new zzbmj();
            case 2:
                return new zza(ng);
            case 3:
                return zzbrd.zza(zzffr, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzffo", "zzffp", "zzffq"});
            case 4:
                return zzffr;
            case 5:
                zzbsw<zzbmj> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmj.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzffr);
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

    public final zzbml zzahr() {
        zzbml zzds = zzbml.zzds(this.zzffo);
        return zzds == null ? zzbml.UNRECOGNIZED : zzds;
    }

    public final zzbmn zzahs() {
        zzbmn zzdt = zzbmn.zzdt(this.zzffp);
        return zzdt == null ? zzbmn.UNRECOGNIZED : zzdt;
    }

    public final zzbpu zzaht() {
        return this.zzffq;
    }
}
