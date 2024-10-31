package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmt extends zzbrd<zzbmt, zza> implements zzbsn {
    private static volatile zzbsw<zzbmt> zzcas;
    private static final zzbmt zzfgj = new zzbmt();
    private int zzfgh;
    private int zzfgi;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmt, zza> implements zzbsn {
        private zza() {
            super(zzbmt.zzfgj);
        }

        /* synthetic */ zza(Sg sg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmt>) zzbmt.class, zzfgj);
    }

    private zzbmt() {
    }

    public static zzbmt zzaie() {
        return zzfgj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Sg sg = null;
        switch (Sg.f11829a[i - 1]) {
            case 1:
                return new zzbmt();
            case 2:
                return new zza(sg);
            case 3:
                return zzbrd.zza(zzfgj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzfgh", "zzfgi"});
            case 4:
                return zzfgj;
            case 5:
                zzbsw<zzbmt> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmt.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfgj);
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

    public final zzbmn zzaic() {
        zzbmn zzdt = zzbmn.zzdt(this.zzfgh);
        return zzdt == null ? zzbmn.UNRECOGNIZED : zzdt;
    }

    public final int zzaid() {
        return this.zzfgi;
    }
}
