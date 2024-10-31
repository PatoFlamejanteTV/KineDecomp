package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbnc extends zzbrd<zzbnc, zza> implements zzbsn {
    private static volatile zzbsw<zzbnc> zzcas;
    private static final zzbnc zzfhh = new zzbnc();
    private int zzfhe;
    private boolean zzfhf;
    private String zzfhd = "";
    private String zzfgk = "";
    private String zzfhg = "";

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbnc, zza> implements zzbsn {
        private zza() {
            super(zzbnc.zzfhh);
        }

        public final zza zzbc(boolean z) {
            zzamw();
            ((zzbnc) this.zzfpy).zzbb(true);
            return this;
        }

        public final zza zzdy(int i) {
            zzamw();
            ((zzbnc) this.zzfpy).zzdx(0);
            return this;
        }

        public final zza zzfo(String str) {
            zzamw();
            ((zzbnc) this.zzfpy).zzfm(str);
            return this;
        }

        public final zza zzfp(String str) {
            zzamw();
            ((zzbnc) this.zzfpy).zzfk(str);
            return this;
        }

        public final zza zzfq(String str) {
            zzamw();
            ((zzbnc) this.zzfpy).zzfn(str);
            return this;
        }

        /* synthetic */ zza(Xg xg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbnc>) zzbnc.class, zzfhh);
    }

    private zzbnc() {
    }

    public static zza zzais() {
        return (zza) zzfhh.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbb(boolean z) {
        this.zzfhf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdx(int i) {
        this.zzfhe = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfk(String str) {
        if (str != null) {
            this.zzfgk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfm(String str) {
        if (str != null) {
            this.zzfhd = str;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfn(String str) {
        if (str != null) {
            this.zzfhg = str;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Xg xg = null;
        switch (Xg.f11958a[i - 1]) {
            case 1:
                return new zzbnc();
            case 2:
                return new zza(xg);
            case 3:
                return zzbrd.zza(zzfhh, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzfhd", "zzfgk", "zzfhe", "zzfhf", "zzfhg"});
            case 4:
                return zzfhh;
            case 5:
                zzbsw<zzbnc> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbnc.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfhh);
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

    public final String zzaio() {
        return this.zzfhd;
    }

    public final int zzaip() {
        return this.zzfhe;
    }

    public final boolean zzaiq() {
        return this.zzfhf;
    }

    public final String zzair() {
        return this.zzfhg;
    }
}
