package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmh extends zzbrd<zzbmh, zza> implements zzbsn {
    private static volatile zzbsw<zzbmh> zzcas;
    private static final zzbmh zzffn = new zzbmh();
    private int zzfea;
    private zzbmd zzffd;
    private zzbpu zzffl;
    private zzbpu zzffm;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmh, zza> implements zzbsn {
        private zza() {
            super(zzbmh.zzffn);
        }

        public final zza zzac(zzbpu zzbpuVar) {
            zzamw();
            ((zzbmh) this.zzfpy).zzz(zzbpuVar);
            return this;
        }

        public final zza zzad(zzbpu zzbpuVar) {
            zzamw();
            ((zzbmh) this.zzfpy).zzaa(zzbpuVar);
            return this;
        }

        public final zza zzc(zzbmd zzbmdVar) {
            zzamw();
            ((zzbmh) this.zzfpy).zzb(zzbmdVar);
            return this;
        }

        public final zza zzdr(int i) {
            zzamw();
            ((zzbmh) this.zzfpy).setVersion(0);
            return this;
        }

        /* synthetic */ zza(Mg mg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmh>) zzbmh.class, zzffn);
    }

    private zzbmh() {
        zzbpu zzbpuVar = zzbpu.zzfli;
        this.zzffl = zzbpuVar;
        this.zzffm = zzbpuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzffm = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzbmh zzab(zzbpu zzbpuVar) throws zzbrl {
        return (zzbmh) zzbrd.zza(zzffn, zzbpuVar);
    }

    public static zza zzaho() {
        return (zza) zzffn.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public static zzbmh zzahp() {
        return zzffn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzbmd zzbmdVar) {
        if (zzbmdVar != null) {
            this.zzffd = zzbmdVar;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzz(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzffl = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public final int getVersion() {
        return this.zzfea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Mg mg = null;
        switch (Mg.f11686a[i - 1]) {
            case 1:
                return new zzbmh();
            case 2:
                return new zza(mg);
            case 3:
                return zzbrd.zza(zzffn, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzfea", "zzffd", "zzffl", "zzffm"});
            case 4:
                return zzffn;
            case 5:
                zzbsw<zzbmh> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmh.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzffn);
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

    public final zzbmd zzahc() {
        zzbmd zzbmdVar = this.zzffd;
        return zzbmdVar == null ? zzbmd.zzahh() : zzbmdVar;
    }

    public final zzbpu zzahm() {
        return this.zzffl;
    }

    public final zzbpu zzahn() {
        return this.zzffm;
    }
}
