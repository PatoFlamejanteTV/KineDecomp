package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmd extends zzbrd<zzbmd, zza> implements zzbsn {
    private static volatile zzbsw<zzbmd> zzcas;
    private static final zzbmd zzffi = new zzbmd();
    private zzbmj zzfff;
    private zzblz zzffg;
    private int zzffh;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmd, zza> implements zzbsn {
        private zza() {
            super(zzbmd.zzffi);
        }

        /* synthetic */ zza(Kg kg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmd>) zzbmd.class, zzffi);
    }

    private zzbmd() {
    }

    public static zzbmd zzahh() {
        return zzffi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Kg kg = null;
        switch (Kg.f11643a[i - 1]) {
            case 1:
                return new zzbmd();
            case 2:
                return new zza(kg);
            case 3:
                return zzbrd.zza(zzffi, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzfff", "zzffg", "zzffh"});
            case 4:
                return zzffi;
            case 5:
                zzbsw<zzbmd> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmd.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzffi);
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

    public final zzbmj zzahe() {
        zzbmj zzbmjVar = this.zzfff;
        return zzbmjVar == null ? zzbmj.zzahu() : zzbmjVar;
    }

    public final zzblz zzahf() {
        zzblz zzblzVar = this.zzffg;
        return zzblzVar == null ? zzblz.zzaha() : zzblzVar;
    }

    public final zzblx zzahg() {
        zzblx zzdp = zzblx.zzdp(this.zzffh);
        return zzdp == null ? zzblx.UNRECOGNIZED : zzdp;
    }
}
