package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblz extends zzbrd<zzblz, zza> implements zzbsn {
    private static volatile zzbsw<zzblz> zzcas;
    private static final zzblz zzffc = new zzblz();
    private zzbna zzffb;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblz, zza> implements zzbsn {
        private zza() {
            super(zzblz.zzffc);
        }

        /* synthetic */ zza(Ig ig) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblz>) zzblz.class, zzffc);
    }

    private zzblz() {
    }

    public static zzblz zzaha() {
        return zzffc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Ig ig = null;
        switch (Ig.f11604a[i - 1]) {
            case 1:
                return new zzblz();
            case 2:
                return new zza(ig);
            case 3:
                return zzbrd.zza(zzffc, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzffb"});
            case 4:
                return zzffc;
            case 5:
                zzbsw<zzblz> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblz.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzffc);
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

    public final zzbna zzagz() {
        zzbna zzbnaVar = this.zzffb;
        return zzbnaVar == null ? zzbna.zzaim() : zzbnaVar;
    }
}
