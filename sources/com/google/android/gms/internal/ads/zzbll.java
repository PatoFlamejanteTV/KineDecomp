package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbll extends zzbrd<zzbll, zza> implements zzbsn {
    private static volatile zzbsw<zzbll> zzcas;
    private static final zzbll zzfep = new zzbll();
    private int zzfea;
    private zzbpu zzfei = zzbpu.zzfli;
    private zzblp zzfeo;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbll, zza> implements zzbsn {
        private zza() {
            super(zzbll.zzfep);
        }

        public final zza zzb(zzblp zzblpVar) {
            zzamw();
            ((zzbll) this.zzfpy).zza(zzblpVar);
            return this;
        }

        public final zza zzdm(int i) {
            zzamw();
            ((zzbll) this.zzfpy).setVersion(0);
            return this;
        }

        public final zza zzp(zzbpu zzbpuVar) {
            zzamw();
            ((zzbll) this.zzfpy).zzk(zzbpuVar);
            return this;
        }

        /* synthetic */ zza(Bg bg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbll>) zzbll.class, zzfep);
    }

    private zzbll() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzblp zzblpVar) {
        if (zzblpVar != null) {
            this.zzfeo = zzblpVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzagp() {
        return (zza) zzfep.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfei = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzbll zzo(zzbpu zzbpuVar) throws zzbrl {
        return (zzbll) zzbrd.zza(zzfep, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    public final zzbpu zzagf() {
        return this.zzfei;
    }

    public final zzblp zzago() {
        zzblp zzblpVar = this.zzfeo;
        return zzblpVar == null ? zzblp.zzags() : zzblpVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Bg bg = null;
        switch (Bg.f11405a[i - 1]) {
            case 1:
                return new zzbll();
            case 2:
                return new zza(bg);
            case 3:
                return zzbrd.zza(zzfep, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzfeo", "zzfei"});
            case 4:
                return zzfep;
            case 5:
                zzbsw<zzbll> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbll.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfep);
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
