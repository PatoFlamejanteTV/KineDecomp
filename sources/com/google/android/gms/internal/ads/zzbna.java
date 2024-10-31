package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbna extends zzbrd<zzbna, zza> implements zzbsn {
    private static volatile zzbsw<zzbna> zzcas;
    private static final zzbna zzfhc = new zzbna();
    private String zzfgk = "";
    private zzbpu zzfgl = zzbpu.zzfli;
    private int zzfhb;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbna, zza> implements zzbsn {
        private zza() {
            super(zzbna.zzfhc);
        }

        /* synthetic */ zza(Wg wg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbna>) zzbna.class, zzfhc);
    }

    private zzbna() {
    }

    public static zzbna zzaim() {
        return zzfhc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Wg wg = null;
        switch (Wg.f11930a[i - 1]) {
            case 1:
                return new zzbna();
            case 2:
                return new zza(wg);
            case 3:
                return zzbrd.zza(zzfhc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzfgk", "zzfgl", "zzfhb"});
            case 4:
                return zzfhc;
            case 5:
                zzbsw<zzbna> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbna.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfhc);
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

    public final String zzaig() {
        return this.zzfgk;
    }

    public final zzbpu zzaih() {
        return this.zzfgl;
    }
}
