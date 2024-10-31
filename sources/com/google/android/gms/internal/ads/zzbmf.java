package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmf extends zzbrd<zzbmf, zza> implements zzbsn {
    private static volatile zzbsw<zzbmf> zzcas;
    private static final zzbmf zzffk = new zzbmf();
    private int zzfea;
    private zzbpu zzfei = zzbpu.zzfli;
    private zzbmh zzffj;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmf, zza> implements zzbsn {
        private zza() {
            super(zzbmf.zzffk);
        }

        public final zza zzb(zzbmh zzbmhVar) {
            zzamw();
            ((zzbmf) this.zzfpy).zza(zzbmhVar);
            return this;
        }

        public final zza zzdq(int i) {
            zzamw();
            ((zzbmf) this.zzfpy).setVersion(0);
            return this;
        }

        public final zza zzy(zzbpu zzbpuVar) {
            zzamw();
            ((zzbmf) this.zzfpy).zzk(zzbpuVar);
            return this;
        }

        /* synthetic */ zza(Lg lg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmf>) zzbmf.class, zzffk);
    }

    private zzbmf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbmh zzbmhVar) {
        if (zzbmhVar != null) {
            this.zzffj = zzbmhVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzahk() {
        return (zza) zzffk.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfei = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzbmf zzx(zzbpu zzbpuVar) throws zzbrl {
        return (zzbmf) zzbrd.zza(zzffk, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    public final zzbpu zzagf() {
        return this.zzfei;
    }

    public final zzbmh zzahj() {
        zzbmh zzbmhVar = this.zzffj;
        return zzbmhVar == null ? zzbmh.zzahp() : zzbmhVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Lg lg = null;
        switch (Lg.f11666a[i - 1]) {
            case 1:
                return new zzbmf();
            case 2:
                return new zza(lg);
            case 3:
                return zzbrd.zza(zzffk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzffj", "zzfei"});
            case 4:
                return zzffk;
            case 5:
                zzbsw<zzbmf> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmf.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzffk);
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
