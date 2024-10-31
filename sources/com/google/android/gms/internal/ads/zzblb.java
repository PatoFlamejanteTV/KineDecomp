package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblb extends zzbrd<zzblb, zza> implements zzbsn {
    private static volatile zzbsw<zzblb> zzcas;
    private static final zzblb zzfed = new zzblb();
    private int zzfea;
    private zzblf zzfeb;
    private zzbmp zzfec;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblb, zza> implements zzbsn {
        private zza() {
            super(zzblb.zzfed);
        }

        public final zza zzb(zzblf zzblfVar) {
            zzamw();
            ((zzblb) this.zzfpy).zza(zzblfVar);
            return this;
        }

        public final zza zzdk(int i) {
            zzamw();
            ((zzblb) this.zzfpy).setVersion(i);
            return this;
        }

        /* synthetic */ zza(C1138wg c1138wg) {
            this();
        }

        public final zza zzb(zzbmp zzbmpVar) {
            zzamw();
            ((zzblb) this.zzfpy).zza(zzbmpVar);
            return this;
        }
    }

    static {
        zzbrd.zza((Class<zzblb>) zzblb.class, zzfed);
    }

    private zzblb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzblf zzblfVar) {
        if (zzblfVar != null) {
            this.zzfeb = zzblfVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzafz() {
        return (zza) zzfed.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public static zzblb zzi(zzbpu zzbpuVar) throws zzbrl {
        return (zzblb) zzbrd.zza(zzfed, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    public final zzblf zzafx() {
        zzblf zzblfVar = this.zzfeb;
        return zzblfVar == null ? zzblf.zzagh() : zzblfVar;
    }

    public final zzbmp zzafy() {
        zzbmp zzbmpVar = this.zzfec;
        return zzbmpVar == null ? zzbmp.zzahy() : zzbmpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbmp zzbmpVar) {
        if (zzbmpVar != null) {
            this.zzfec = zzbmpVar;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C1138wg c1138wg = null;
        switch (C1138wg.f12626a[i - 1]) {
            case 1:
                return new zzblb();
            case 2:
                return new zza(c1138wg);
            case 3:
                return zzbrd.zza(zzfed, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzfea", "zzfeb", "zzfec"});
            case 4:
                return zzfed;
            case 5:
                zzbsw<zzblb> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblb.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfed);
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
