package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbnk extends zzbrd<zzbnk, zza> implements zzbsn {
    private static volatile zzbsw<zzbnk> zzcas;
    private static final zzbnk zzfhv = new zzbnk();
    private String zzfhu = "";

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbnk, zza> implements zzbsn {
        private zza() {
            super(zzbnk.zzfhv);
        }

        /* synthetic */ zza(C0830ah c0830ah) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbnk>) zzbnk.class, zzfhv);
    }

    private zzbnk() {
    }

    public static zzbnk zzajm() {
        return zzfhv;
    }

    public static zzbnk zzak(zzbpu zzbpuVar) throws zzbrl {
        return (zzbnk) zzbrd.zza(zzfhv, zzbpuVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C0830ah c0830ah = null;
        switch (C0830ah.f12064a[i - 1]) {
            case 1:
                return new zzbnk();
            case 2:
                return new zza(c0830ah);
            case 3:
                return zzbrd.zza(zzfhv, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzfhu"});
            case 4:
                return zzfhv;
            case 5:
                zzbsw<zzbnk> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbnk.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfhv);
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

    public final String zzajl() {
        return this.zzfhu;
    }
}
