package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzuw {

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd<zza, zzb> implements zzbsn {
        private static volatile zzbsw<zza> zzcas;
        private static final zza zzccj = new zza();
        private int zzccg;
        private int zzcch;
        private zzl zzcci;

        /* renamed from: com.google.android.gms.internal.ads.zzuw$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public enum EnumC0075zza implements zzbrg {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            private static final zzbrh<EnumC0075zza> zzcbx = new _m();
            private final int value;

            EnumC0075zza(int i) {
                this.value = i;
            }

            public static EnumC0075zza zzca(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzbri zzop() {
                return C0836an.f12074a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzbrd.zza<zza, zzb> implements zzbsn {
            private zzb() {
                super(zza.zzccj);
            }

            /* synthetic */ zzb(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zza>) zza.class, zzccj);
        }

        private zza() {
        }

        public static zzbsw<zza> zzon() {
            return (zzbsw) zzccj.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zm);
                case 3:
                    return zzbrd.zza(zzccj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzccg", "zzcch", EnumC0075zza.zzop(), "zzcci"});
                case 4:
                    return zzccj;
                case 5:
                    zzbsw<zza> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zza.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzccj);
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

    /* loaded from: classes2.dex */
    public static final class zzb extends zzbrd<zzb, zza> implements zzbsn {
        private static volatile zzbsw<zzb> zzcas;
        private static final zzb zzcda = new zzb();
        private int zzccg;
        private String zzccx = "";
        private zzbrk<zza> zzccy = zzbrd.zzams();
        private int zzccz;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzb, zza> implements zzbsn {
            private zza() {
                super(zzb.zzcda);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzb>) zzb.class, zzcda);
        }

        private zzb() {
        }

        public static zzbsw<zzb> zzon() {
            return (zzbsw) zzcda.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcda, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzccg", "zzccx", "zzccy", zza.class, "zzccz", zzvc.zzop()});
                case 4:
                    return zzcda;
                case 5:
                    zzbsw<zzb> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzb.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcda);
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

    /* loaded from: classes2.dex */
    public static final class zzc extends zzbrd<zzc, zza> implements zzbsn {
        private static volatile zzbsw<zzc> zzcas;
        private static final zzc zzcdh = new zzc();
        private int zzccg;
        private int zzcdb;
        private zzn zzcdc;
        private zzn zzcdd;
        private zzn zzcde;
        private zzbrk<zzn> zzcdf = zzbrd.zzams();
        private int zzcdg;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzc, zza> implements zzbsn {
            private zza() {
                super(zzc.zzcdh);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzc>) zzc.class, zzcdh);
        }

        private zzc() {
        }

        public static zzbsw<zzc> zzon() {
            return (zzbsw) zzcdh.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcdh, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzccg", "zzcdb", "zzcdc", "zzcdd", "zzcde", "zzcdf", zzn.class, "zzcdg"});
                case 4:
                    return zzcdh;
                case 5:
                    zzbsw<zzc> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzc.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcdh);
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

    /* loaded from: classes2.dex */
    public static final class zzd extends zzbrd<zzd, zza> implements zzbsn {
        private static volatile zzbsw<zzd> zzcas;
        private static final zzd zzcdm = new zzd();
        private int zzccg;
        private int zzcdi;
        private zzo zzcdj;
        private String zzcdk = "";
        private String zzcdl = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzd, zza> implements zzbsn {
            private zza() {
                super(zzd.zzcdm);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        /* loaded from: classes2.dex */
        public enum zzb implements zzbrg {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);

            private static final zzbrh<zzb> zzcbx = new C0851bn();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzb zzcc(int i) {
                if (i == 0) {
                    return PLATFORM_UNSPECIFIED;
                }
                if (i == 1) {
                    return IOS;
                }
                if (i != 2) {
                    return null;
                }
                return ANDROID;
            }

            public static zzbri zzop() {
                return C0866cn.f12110a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        static {
            zzbrd.zza((Class<zzd>) zzd.class, zzcdm);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcdm, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005\f\u0000\u0006\t\u0001\u0007\b\u0002\b\b\u0003", new Object[]{"zzccg", "zzcdi", zzb.zzop(), "zzcdj", "zzcdk", "zzcdl"});
                case 4:
                    return zzcdm;
                case 5:
                    zzbsw<zzd> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzd.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcdm);
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

    /* loaded from: classes2.dex */
    public static final class zze extends zzbrd<zze, zza> implements zzbsn {
        private static volatile zzbsw<zze> zzcas;
        private static final zze zzcdz = new zze();
        private int zzccg;
        private int zzcdw;
        private zzn zzcdy;
        private String zzcdv = "";
        private zzbrj zzcdx = zzbrd.zzamr();

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zze, zza> implements zzbsn {
            private zza() {
                super(zze.zzcdz);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zze>) zze.class, zzcdz);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcdz, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzccg", "zzcdv", "zzcdw", zzvc.zzop(), "zzcdx", "zzcdy"});
                case 4:
                    return zzcdz;
                case 5:
                    zzbsw<zze> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zze.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcdz);
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

    /* loaded from: classes2.dex */
    public static final class zzf extends zzbrd<zzf, zza> implements zzbsn {
        private static volatile zzbsw<zzf> zzcas;
        private static final zzf zzceb = new zzf();
        private int zzccg;
        private zzbrj zzcdx = zzbrd.zzamr();
        private int zzcea;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzf, zza> implements zzbsn {
            private zza() {
                super(zzf.zzceb);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzf>) zzf.class, zzceb);
        }

        private zzf() {
        }

        public static zzbsw<zzf> zzon() {
            return (zzbsw) zzceb.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzceb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcdx"});
                case 4:
                    return zzceb;
                case 5:
                    zzbsw<zzf> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzf.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzceb);
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

    /* loaded from: classes2.dex */
    public static final class zzg extends zzbrd<zzg, zza> implements zzbsn {
        private static volatile zzbsw<zzg> zzcas;
        private static final zzg zzcee = new zzg();
        private int zzccg;
        private zzn zzcdy;
        private int zzcea;
        private zze zzcec;
        private zzbrk<zzm> zzced = zzbrd.zzams();

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzg, zza> implements zzbsn {
            private zza() {
                super(zzg.zzcee);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzg>) zzg.class, zzcee);
        }

        private zzg() {
        }

        public static zzbsw<zzg> zzon() {
            return (zzbsw) zzcee.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcee, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzccg", "zzcec", "zzced", zzm.class, "zzcea", zzvc.zzop(), "zzcdy"});
                case 4:
                    return zzcee;
                case 5:
                    zzbsw<zzg> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzg.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcee);
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

    /* loaded from: classes2.dex */
    public static final class zzh extends zzbrd<zzh, zza> implements zzbsn {
        private static volatile zzbsw<zzh> zzcas;
        private static final zzh zzceg = new zzh();
        private int zzccg;
        private int zzcch;
        private int zzcef;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzh, zza> implements zzbsn {
            private zza() {
                super(zzh.zzceg);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        /* loaded from: classes2.dex */
        public enum zzb implements zzbrg {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);

            private static final zzbrh<zzb> zzcbx = new fn();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzb zzce(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
            }

            public static zzbri zzop() {
                return gn.f12186a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum zzc implements zzbrg {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);

            private static final zzbrh<zzc> zzcbx = new hn();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzc zzcf(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
            }

            public static zzbri zzop() {
                return in.f12215a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        static {
            zzbrd.zza((Class<zzh>) zzh.class, zzceg);
        }

        private zzh() {
        }

        public static zzbsw<zzh> zzon() {
            return (zzbsw) zzceg.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzceg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzccg", "zzcch", zzc.zzop(), "zzcef", zzb.zzop()});
                case 4:
                    return zzceg;
                case 5:
                    zzbsw<zzh> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzh.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzceg);
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

    /* loaded from: classes2.dex */
    public static final class zzi extends zzbrd<zzi, zza> implements zzbsn {
        private static volatile zzbsw<zzi> zzcas;
        private static final zzi zzces = new zzi();
        private int zzccg;
        private int zzceq;
        private zzn zzcer;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzi, zza> implements zzbsn {
            private zza() {
                super(zzi.zzces);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzi>) zzi.class, zzces);
        }

        private zzi() {
        }

        public static zzbsw<zzi> zzon() {
            return (zzbsw) zzces.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzces, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzccg", "zzceq", zzvc.zzop(), "zzcer"});
                case 4:
                    return zzces;
                case 5:
                    zzbsw<zzi> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzi.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzces);
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

    /* loaded from: classes2.dex */
    public static final class zzj extends zzbrd<zzj, zza> implements zzbsn {
        private static volatile zzbsw<zzj> zzcas;
        private static final zzj zzcfe = new zzj();
        private int zzccg;
        private int zzcet = 1000;
        private int zzceu = 1000;
        private int zzcev;
        private int zzcew;
        private int zzcex;
        private int zzcey;
        private int zzcez;
        private int zzcfa;
        private int zzcfb;
        private int zzcfc;
        private zzk zzcfd;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzj, zza> implements zzbsn {
            private zza() {
                super(zzj.zzcfe);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzj>) zzj.class, zzcfe);
        }

        private zzj() {
        }

        public static zzbsw<zzj> zzon() {
            return (zzbsw) zzcfe.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfe, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzccg", "zzcet", zzvc.zzop(), "zzceu", zzvc.zzop(), "zzcev", "zzcew", "zzcex", "zzcey", "zzcez", "zzcfa", "zzcfb", "zzcfc", "zzcfd"});
                case 4:
                    return zzcfe;
                case 5:
                    zzbsw<zzj> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzj.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfe);
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

    /* loaded from: classes2.dex */
    public static final class zzk extends zzbrd<zzk, zza> implements zzbsn {
        private static volatile zzbsw<zzk> zzcas;
        private static final zzk zzcfh = new zzk();
        private int zzccg;
        private int zzcff;
        private int zzcfg;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzk, zza> implements zzbsn {
            private zza() {
                super(zzk.zzcfh);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzk>) zzk.class, zzcfh);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzccg", "zzcff", "zzcfg"});
                case 4:
                    return zzcfh;
                case 5:
                    zzbsw<zzk> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzk.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfh);
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

    /* loaded from: classes2.dex */
    public static final class zzl extends zzbrd<zzl, zza> implements zzbsn {
        private static volatile zzbsw<zzl> zzcas;
        private static final zzl zzcfk = new zzl();
        private int zzccg;
        private int zzcfi;
        private int zzcfj;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzl, zza> implements zzbsn {
            private zza() {
                super(zzl.zzcfk);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzl>) zzl.class, zzcfk);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzccg", "zzcfi", "zzcfj"});
                case 4:
                    return zzcfk;
                case 5:
                    zzbsw<zzl> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzl.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfk);
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

    /* loaded from: classes2.dex */
    public static final class zzm extends zzbrd<zzm, zza> implements zzbsn {
        private static volatile zzbsw<zzm> zzcas;
        private static final zzm zzcfl = new zzm();
        private int zzccg;
        private String zzcdv = "";
        private int zzcdw;
        private zzn zzcdy;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzm, zza> implements zzbsn {
            private zza() {
                super(zzm.zzcfl);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzm>) zzm.class, zzcfl);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcdv", "zzcdw", zzvc.zzop(), "zzcdy"});
                case 4:
                    return zzcfl;
                case 5:
                    zzbsw<zzm> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzm.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfl);
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

    /* loaded from: classes2.dex */
    public static final class zzn extends zzbrd<zzn, zza> implements zzbsn {
        private static volatile zzbsw<zzn> zzcas;
        private static final zzn zzcfo = new zzn();
        private int zzccg;
        private int zzcfm;
        private int zzcfn;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzn, zza> implements zzbsn {
            private zza() {
                super(zzn.zzcfo);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzn>) zzn.class, zzcfo);
        }

        private zzn() {
        }

        public static zzbsw<zzn> zzon() {
            return (zzbsw) zzcfo.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzccg", "zzcfm", "zzcfn"});
                case 4:
                    return zzcfo;
                case 5:
                    zzbsw<zzn> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzn.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfo);
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

    /* loaded from: classes2.dex */
    public static final class zzo extends zzbrd<zzo, zza> implements zzbsn {
        private static volatile zzbsw<zzo> zzcas;
        private static final zzo zzcfs = new zzo();
        private int zzccg;
        private int zzcfp;
        private int zzcfq;
        private int zzcfr;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzo, zza> implements zzbsn {
            private zza() {
                super(zzo.zzcfs);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzo>) zzo.class, zzcfs);
        }

        private zzo() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfs, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzccg", "zzcfp", "zzcfq", "zzcfr"});
                case 4:
                    return zzcfs;
                case 5:
                    zzbsw<zzo> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzo.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfs);
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

    /* loaded from: classes2.dex */
    public static final class zzp extends zzbrd<zzp, zza> implements zzbsn {
        private static volatile zzbsw<zzp> zzcas;
        private static final zzp zzcfv = new zzp();
        private int zzccg;
        private int zzcea = 1000;
        private zzq zzcft;
        private zzn zzcfu;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzp, zza> implements zzbsn {
            private zza() {
                super(zzp.zzcfv);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzp>) zzp.class, zzcfv);
        }

        private zzp() {
        }

        public static zzbsw<zzp> zzon() {
            return (zzbsw) zzcfv.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcft", "zzcfu"});
                case 4:
                    return zzcfv;
                case 5:
                    zzbsw<zzp> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzp.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfv);
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

    /* loaded from: classes2.dex */
    public static final class zzq extends zzbrd<zzq, zza> implements zzbsn {
        private static volatile zzbsw<zzq> zzcas;
        private static final zzq zzcfx = new zzq();
        private int zzccg;
        private int zzcfw;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzq, zza> implements zzbsn {
            private zza() {
                super(zzq.zzcfx);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        /* loaded from: classes2.dex */
        public enum zzb implements zzbrg {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);

            private static final zzbrh<zzb> zzcbx = new jn();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzb zzcg(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
            }

            public static zzbri zzop() {
                return kn.f12288a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        static {
            zzbrd.zza((Class<zzq>) zzq.class, zzcfx);
        }

        private zzq() {
        }

        public static zzbsw<zzq> zzon() {
            return (zzbsw) zzcfx.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcfx, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzccg", "zzcfw", zzb.zzop()});
                case 4:
                    return zzcfx;
                case 5:
                    zzbsw<zzq> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzq.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcfx);
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

    /* loaded from: classes2.dex */
    public static final class zzr extends zzbrd<zzr, zza> implements zzbsn {
        private static volatile zzbsw<zzr> zzcas;
        private static final zzr zzcgg = new zzr();
        private int zzccg;
        private int zzcea = 1000;
        private zzq zzcft;
        private int zzcgd;
        private int zzcge;
        private int zzcgf;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzr, zza> implements zzbsn {
            private zza() {
                super(zzr.zzcgg);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzr>) zzr.class, zzcgg);
        }

        private zzr() {
        }

        public static zzbsw<zzr> zzon() {
            return (zzbsw) zzcgg.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcgg, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcft", "zzcgd", "zzcge", "zzcgf"});
                case 4:
                    return zzcgg;
                case 5:
                    zzbsw<zzr> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzr.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcgg);
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

    /* loaded from: classes2.dex */
    public static final class zzs extends zzbrd<zzs, zza> implements zzbsn {
        private static volatile zzbsw<zzs> zzcas;
        private static final zzs zzcgh = new zzs();
        private int zzccg;
        private int zzcea = 1000;
        private zzq zzcft;
        private zzn zzcfu;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzs, zza> implements zzbsn {
            private zza() {
                super(zzs.zzcgh);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzs>) zzs.class, zzcgh);
        }

        private zzs() {
        }

        public static zzbsw<zzs> zzon() {
            return (zzbsw) zzcgh.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcgh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcft", "zzcfu"});
                case 4:
                    return zzcgh;
                case 5:
                    zzbsw<zzs> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzs.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcgh);
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

    /* loaded from: classes2.dex */
    public static final class zzt extends zzbrd<zzt, zza> implements zzbsn {
        private static volatile zzbsw<zzt> zzcas;
        private static final zzt zzcgj = new zzt();
        private int zzccg;
        private int zzcea = 1000;
        private zzq zzcft;
        private int zzcgd;
        private int zzcge;
        private int zzcgf;
        private long zzcgi;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzt, zza> implements zzbsn {
            private zza() {
                super(zzt.zzcgj);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzt>) zzt.class, zzcgj);
        }

        private zzt() {
        }

        public static zzbsw<zzt> zzon() {
            return (zzbsw) zzcgj.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcgj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcft", "zzcgd", "zzcge", "zzcgf", "zzcgi"});
                case 4:
                    return zzcgj;
                case 5:
                    zzbsw<zzt> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzt.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcgj);
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

    /* loaded from: classes2.dex */
    public static final class zzu extends zzbrd<zzu, zza> implements zzbsn {
        private static volatile zzbsw<zzu> zzcas;
        private static final zzu zzcgk = new zzu();
        private int zzccg;
        private int zzcea = 1000;
        private zzq zzcft;
        private zzn zzcfu;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzu, zza> implements zzbsn {
            private zza() {
                super(zzu.zzcgk);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzu>) zzu.class, zzcgk);
        }

        private zzu() {
        }

        public static zzbsw<zzu> zzon() {
            return (zzbsw) zzcgk.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcgk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcft", "zzcfu"});
                case 4:
                    return zzcgk;
                case 5:
                    zzbsw<zzu> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzu.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcgk);
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

    /* loaded from: classes2.dex */
    public static final class zzv extends zzbrd<zzv, zza> implements zzbsn {
        private static volatile zzbsw<zzv> zzcas;
        private static final zzv zzcgl = new zzv();
        private int zzccg;
        private int zzcea = 1000;
        private zzq zzcft;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzv, zza> implements zzbsn {
            private zza() {
                super(zzv.zzcgl);
            }

            /* synthetic */ zza(Zm zm) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzv>) zzv.class, zzcgl);
        }

        private zzv() {
        }

        public static zzbsw<zzv> zzon() {
            return (zzbsw) zzcgl.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Zm zm = null;
            switch (Zm.f12021a[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(zm);
                case 3:
                    return zzbrd.zza(zzcgl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzccg", "zzcea", zzvc.zzop(), "zzcft"});
                case 4:
                    return zzcgl;
                case 5:
                    zzbsw<zzv> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzv.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcgl);
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
}
