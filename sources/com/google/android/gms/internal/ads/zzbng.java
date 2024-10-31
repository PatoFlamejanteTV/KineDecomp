package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbng extends zzbrd<zzbng, zza> implements zzbsn {
    private static volatile zzbsw<zzbng> zzcas;
    private static final zzbng zzfhq = new zzbng();
    private int zzccg;
    private int zzfhi;
    private zzbrk<zzb> zzfhp = zzbrd.zzams();

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbng, zza> implements zzbsn {
        private zza() {
            super(zzbng.zzfhq);
        }

        public final zza zzb(zzb zzbVar) {
            zzamw();
            ((zzbng) this.zzfpy).zza(zzbVar);
            return this;
        }

        public final zza zzea(int i) {
            zzamw();
            ((zzbng) this.zzfpy).zzdz(i);
            return this;
        }

        /* synthetic */ zza(Zg zg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbng>) zzbng.class, zzfhq);
    }

    private zzbng() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        if (zzbVar != null) {
            if (!this.zzfhp.zzaki()) {
                zzbrk<zzb> zzbrkVar = this.zzfhp;
                int size = zzbrkVar.size();
                this.zzfhp = zzbrkVar.zzel(size == 0 ? 10 : size << 1);
            }
            this.zzfhp.add(zzbVar);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzaje() {
        return (zza) zzfhq.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdz(int i) {
        this.zzfhi = i;
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzbrd<zzb, zza> implements zzbsn {
        private static volatile zzbsw<zzb> zzcas;
        private static final zzb zzfhr = new zzb();
        private String zzfgk = "";
        private int zzfhb;
        private int zzfhm;
        private int zzfhn;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzb, zza> implements zzbsn {
            private zza() {
                super(zzb.zzfhr);
            }

            public final zza zzb(zzbmy zzbmyVar) {
                zzamw();
                ((zzb) this.zzfpy).zza(zzbmyVar);
                return this;
            }

            public final zza zzec(int i) {
                zzamw();
                ((zzb) this.zzfpy).zzeb(i);
                return this;
            }

            public final zza zzfr(String str) {
                zzamw();
                ((zzb) this.zzfpy).zzfk(str);
                return this;
            }

            /* synthetic */ zza(Zg zg) {
                this();
            }

            public final zza zzb(zzbnq zzbnqVar) {
                zzamw();
                ((zzb) this.zzfpy).zza(zzbnqVar);
                return this;
            }
        }

        static {
            zzbrd.zza((Class<zzb>) zzb.class, zzfhr);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbmy zzbmyVar) {
            if (zzbmyVar != null) {
                this.zzfhm = zzbmyVar.zzom();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzajg() {
            return (zza) zzfhr.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzeb(int i) {
            this.zzfhn = i;
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
        public final void zza(zzbnq zzbnqVar) {
            if (zzbnqVar != null) {
                this.zzfhb = zzbnqVar.zzom();
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zg zg = null;
            switch (Zg.f12010a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zg);
                case 3:
                    return zzbrd.zza(zzfhr, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzfgk", "zzfhm", "zzfhn", "zzfhb"});
                case 4:
                    return zzfhr;
                case 5:
                    zzbsw<zzb> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzb.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzfhr);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Zg zg = null;
        switch (Zg.f12010a[i - 1]) {
            case 1:
                return new zzbng();
            case 2:
                return new zza(zg);
            case 3:
                return zzbrd.zza(zzfhq, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzccg", "zzfhi", "zzfhp", zzb.class});
            case 4:
                return zzfhq;
            case 5:
                zzbsw<zzbng> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbng.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfhq);
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
