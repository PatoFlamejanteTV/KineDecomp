package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblr extends zzbrd<zzblr, zza> implements zzbsn {
    private static volatile zzbsw<zzblr> zzcas;
    private static final zzblr zzfes = new zzblr();
    private int zzfea;
    private zzbpu zzfei = zzbpu.zzfli;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblr, zza> implements zzbsn {
        private zza() {
            super(zzblr.zzfes);
        }

        public final zza zzdn(int i) {
            zzamw();
            ((zzblr) this.zzfpy).setVersion(0);
            return this;
        }

        public final zza zzs(zzbpu zzbpuVar) {
            zzamw();
            ((zzblr) this.zzfpy).zzk(zzbpuVar);
            return this;
        }

        /* synthetic */ zza(Eg eg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblr>) zzblr.class, zzfes);
    }

    private zzblr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    public static zza zzagu() {
        return (zza) zzfes.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfei = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzblr zzr(zzbpu zzbpuVar) throws zzbrl {
        return (zzblr) zzbrd.zza(zzfes, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Eg eg = null;
        switch (Eg.f11491a[i - 1]) {
            case 1:
                return new zzblr();
            case 2:
                return new zza(eg);
            case 3:
                return zzbrd.zza(zzfes, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzfea", "zzfei"});
            case 4:
                return zzfes;
            case 5:
                zzbsw<zzblr> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblr.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfes);
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

    public final zzbpu zzagf() {
        return this.zzfei;
    }
}
