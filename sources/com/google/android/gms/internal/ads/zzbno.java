package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbno extends zzbrd<zzbno, zza> implements zzbsn {
    private static volatile zzbsw<zzbno> zzcas;
    private static final zzbno zzfia = new zzbno();
    private String zzfhy = "";
    private zzbna zzfhz;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbno, zza> implements zzbsn {
        private zza() {
            super(zzbno.zzfia);
        }

        /* synthetic */ zza(C0860ch c0860ch) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbno>) zzbno.class, zzfia);
    }

    private zzbno() {
    }

    public static zzbno zzajt() {
        return zzfia;
    }

    public static zzbno zzam(zzbpu zzbpuVar) throws zzbrl {
        return (zzbno) zzbrd.zza(zzfia, zzbpuVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C0860ch c0860ch = null;
        switch (C0860ch.f12104a[i - 1]) {
            case 1:
                return new zzbno();
            case 2:
                return new zza(c0860ch);
            case 3:
                return zzbrd.zza(zzfia, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzfhy", "zzfhz"});
            case 4:
                return zzfia;
            case 5:
                zzbsw<zzbno> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbno.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfia);
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

    public final String zzajr() {
        return this.zzfhy;
    }

    public final zzbna zzajs() {
        zzbna zzbnaVar = this.zzfhz;
        return zzbnaVar == null ? zzbna.zzaim() : zzbnaVar;
    }
}
