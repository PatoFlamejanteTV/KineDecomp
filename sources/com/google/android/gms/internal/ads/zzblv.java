package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblv extends zzbrd<zzblv, zza> implements zzbsn {
    private static volatile zzbsw<zzblv> zzcas;
    private static final zzblv zzfeu = new zzblv();
    private int zzfea;
    private zzbpu zzfei = zzbpu.zzfli;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblv, zza> implements zzbsn {
        private zza() {
            super(zzblv.zzfeu);
        }

        public final zza zzdo(int i) {
            zzamw();
            ((zzblv) this.zzfpy).setVersion(0);
            return this;
        }

        public final zza zzv(zzbpu zzbpuVar) {
            zzamw();
            ((zzblv) this.zzfpy).zzk(zzbpuVar);
            return this;
        }

        /* synthetic */ zza(Gg gg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblv>) zzblv.class, zzfeu);
    }

    private zzblv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    public static zza zzagx() {
        return (zza) zzfeu.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfei = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzblv zzu(zzbpu zzbpuVar) throws zzbrl {
        return (zzblv) zzbrd.zza(zzfeu, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Gg gg = null;
        switch (Gg.f11549a[i - 1]) {
            case 1:
                return new zzblv();
            case 2:
                return new zza(gg);
            case 3:
                return zzbrd.zza(zzfeu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzfea", "zzfei"});
            case 4:
                return zzfeu;
            case 5:
                zzbsw<zzblv> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblv.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfeu);
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
