package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblt extends zzbrd<zzblt, zza> implements zzbsn {
    private static volatile zzbsw<zzblt> zzcas;
    private static final zzblt zzfet = new zzblt();
    private int zzfek;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblt, zza> implements zzbsn {
        private zza() {
            super(zzblt.zzfet);
        }

        /* synthetic */ zza(Fg fg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblt>) zzblt.class, zzfet);
    }

    private zzblt() {
    }

    public static zzblt zzt(zzbpu zzbpuVar) throws zzbrl {
        return (zzblt) zzbrd.zza(zzfet, zzbpuVar);
    }

    public final int getKeySize() {
        return this.zzfek;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Fg fg = null;
        switch (Fg.f11531a[i - 1]) {
            case 1:
                return new zzblt();
            case 2:
                return new zza(fg);
            case 3:
                return zzbrd.zza(zzfet, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzfek"});
            case 4:
                return zzfet;
            case 5:
                zzbsw<zzblt> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblt.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfet);
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
}
