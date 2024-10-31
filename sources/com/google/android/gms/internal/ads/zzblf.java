package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzblf extends zzbrd<zzblf, zza> implements zzbsn {
    private static volatile zzbsw<zzblf> zzcas;
    private static final zzblf zzfej = new zzblf();
    private int zzfea;
    private zzblj zzfeh;
    private zzbpu zzfei = zzbpu.zzfli;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzblf, zza> implements zzbsn {
        private zza() {
            super(zzblf.zzfej);
        }

        public final zza zzc(zzblj zzbljVar) {
            zzamw();
            ((zzblf) this.zzfpy).zzb(zzbljVar);
            return this;
        }

        public final zza zzdl(int i) {
            zzamw();
            ((zzblf) this.zzfpy).setVersion(0);
            return this;
        }

        public final zza zzm(zzbpu zzbpuVar) {
            zzamw();
            ((zzblf) this.zzfpy).zzk(zzbpuVar);
            return this;
        }

        /* synthetic */ zza(C1166yg c1166yg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzblf>) zzblf.class, zzfej);
    }

    private zzblf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    public static zza zzagg() {
        return (zza) zzfej.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public static zzblf zzagh() {
        return zzfej;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzblj zzbljVar) {
        if (zzbljVar != null) {
            this.zzfeh = zzbljVar;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfei = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzblf zzl(zzbpu zzbpuVar) throws zzbrl {
        return (zzblf) zzbrd.zza(zzfej, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C1166yg c1166yg = null;
        switch (C1166yg.f12686a[i - 1]) {
            case 1:
                return new zzblf();
            case 2:
                return new zza(c1166yg);
            case 3:
                return zzbrd.zza(zzfej, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzfeh", "zzfei"});
            case 4:
                return zzfej;
            case 5:
                zzbsw<zzblf> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzblf.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfej);
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

    public final zzblj zzage() {
        zzblj zzbljVar = this.zzfeh;
        return zzbljVar == null ? zzblj.zzagm() : zzbljVar;
    }

    public final zzbpu zzagf() {
        return this.zzfei;
    }
}
