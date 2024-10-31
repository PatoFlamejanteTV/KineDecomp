package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbvd {

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd<zza, C0067zza> implements zzbsn {
        private static volatile zzbsw<zza> zzcas;
        private static final zza zzfxm = new zza();
        private int zzccg;
        private int zzfxf;
        private zzb zzfxg;
        private zzbpu zzfxh;
        private zzbpu zzfxi;
        private boolean zzfxj;
        private boolean zzfxk;
        private byte zzfxl = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzbvd$zza$zza */
        /* loaded from: classes2.dex */
        public static final class C0067zza extends zzbrd.zza<zza, C0067zza> implements zzbsn {
            private C0067zza() {
                super(zza.zzfxm);
            }

            /* synthetic */ C0067zza(_i _iVar) {
                this();
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzbrd<zzb, C0068zza> implements zzbsn {
            private static volatile zzbsw<zzb> zzcas;
            private static final zzb zzfxr = new zzb();
            private int zzccg;
            private String zzfxn = "";
            private String zzfxo = "";
            private String zzfxp = "";
            private int zzfxq;

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zza$zzb$zza */
            /* loaded from: classes2.dex */
            public static final class C0068zza extends zzbrd.zza<zzb, C0068zza> implements zzbsn {
                private C0068zza() {
                    super(zzb.zzfxr);
                }

                /* synthetic */ C0068zza(_i _iVar) {
                    this();
                }
            }

            static {
                zzbrd.zza((Class<zzb>) zzb.class, zzfxr);
            }

            private zzb() {
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0068zza(null);
                    case 3:
                        return zzbrd.zza(zzfxr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzccg", "zzfxn", "zzfxo", "zzfxp", "zzfxq"});
                    case 4:
                        return zzfxr;
                    case 5:
                        zzbsw<zzb> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zzb.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzfxr);
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
        public enum zzc implements zzbrg {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);

            private static final zzbrh<zzc> zzcbx = new C0832aj();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzc zzgi(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzbri zzop() {
                return C0847bj.f12085a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        static {
            zzbrd.zza((Class<zza>) zza.class, zzfxm);
        }

        private zza() {
            zzbpu zzbpuVar = zzbpu.zzfli;
            this.zzfxh = zzbpuVar;
            this.zzfxi = zzbpuVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            switch (_i.f12041a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0067zza(null);
                case 3:
                    return zzbrd.zza(zzfxm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzccg", "zzfxf", zzc.zzop(), "zzfxg", "zzfxh", "zzfxi", "zzfxj", "zzfxk"});
                case 4:
                    return zzfxm;
                case 5:
                    zzbsw<zza> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zza.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzfxm);
                                zzcas = zzbswVar;
                            }
                        }
                    }
                    return zzbswVar;
                case 6:
                    return Byte.valueOf(this.zzfxl);
                case 7:
                    this.zzfxl = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzbrd<zzb, zza> implements zzbsn {
        private static volatile zzbsw<zzb> zzcas;
        private static final zzb zzfyn = new zzb();
        private int zzccg;
        private int zzcch;
        private int zzfxy;
        private C0069zzb zzfyb;
        private zzf zzfye;
        private boolean zzfyf;
        private boolean zzfyi;
        private boolean zzfyj;
        private zzi zzfyk;
        private byte zzfxl = 2;
        private String zzfxo = "";
        private String zzfxz = "";
        private String zzfya = "";
        private zzbrk<zzh> zzfyc = zzbrd.zzams();
        private String zzfyd = "";
        private zzbrk<String> zzfyg = zzbrd.zzams();
        private String zzfyh = "";
        private zzbpu zzfxh = zzbpu.zzfli;
        private zzbrk<String> zzfyl = zzbrd.zzams();
        private zzbrk<String> zzfym = zzbrd.zzams();

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzb, zza> implements zzbsn {
            private zza() {
                super(zzb.zzfyn);
            }

            /* synthetic */ zza(_i _iVar) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzb */
        /* loaded from: classes2.dex */
        public static final class C0069zzb extends zzbrd<C0069zzb, zza> implements zzbsn {
            private static volatile zzbsw<C0069zzb> zzcas;
            private static final C0069zzb zzfyp = new C0069zzb();
            private int zzccg;
            private String zzfyo = "";

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzb$zza */
            /* loaded from: classes2.dex */
            public static final class zza extends zzbrd.zza<C0069zzb, zza> implements zzbsn {
                private zza() {
                    super(C0069zzb.zzfyp);
                }

                /* synthetic */ zza(_i _iVar) {
                    this();
                }
            }

            static {
                zzbrd.zza((Class<C0069zzb>) C0069zzb.class, zzfyp);
            }

            private C0069zzb() {
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new C0069zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzbrd.zza(zzfyp, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzccg", "zzfyo"});
                    case 4:
                        return zzfyp;
                    case 5:
                        zzbsw<C0069zzb> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (C0069zzb.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzfyp);
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
            private static final zzc zzfyr = new zzc();
            private int zzccg;
            private zzbpu zzfgl;
            private byte zzfxl = 2;
            private zzbpu zzfyq;

            /* loaded from: classes2.dex */
            public static final class zza extends zzbrd.zza<zzc, zza> implements zzbsn {
                private zza() {
                    super(zzc.zzfyr);
                }

                /* synthetic */ zza(_i _iVar) {
                    this();
                }
            }

            static {
                zzbrd.zza((Class<zzc>) zzc.class, zzfyr);
            }

            private zzc() {
                zzbpu zzbpuVar = zzbpu.zzfli;
                this.zzfyq = zzbpuVar;
                this.zzfgl = zzbpuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzbrd.zza(zzfyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzccg", "zzfyq", "zzfgl"});
                    case 4:
                        return zzfyr;
                    case 5:
                        zzbsw<zzc> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zzc.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzfyr);
                                    zzcas = zzbswVar;
                                }
                            }
                        }
                        return zzbswVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzd extends zzbrd<zzd, zza> implements zzbsn {
            private static volatile zzbsw<zzd> zzcas;
            private static final zzd zzfyx = new zzd();
            private int zzccg;
            private C0070zzb zzfys;
            private zzbpu zzfyu;
            private zzbpu zzfyv;
            private int zzfyw;
            private byte zzfxl = 2;
            private zzbrk<zzc> zzfyt = zzbrd.zzams();

            /* loaded from: classes2.dex */
            public static final class zza extends zzbrd.zza<zzd, zza> implements zzbsn {
                private zza() {
                    super(zzd.zzfyx);
                }

                /* synthetic */ zza(_i _iVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzd$zzb */
            /* loaded from: classes2.dex */
            public static final class C0070zzb extends zzbrd<C0070zzb, zza> implements zzbsn {
                private static volatile zzbsw<C0070zzb> zzcas;
                private static final C0070zzb zzfzb = new C0070zzb();
                private int zzccg;
                private zzbpu zzfyy;
                private zzbpu zzfyz;
                private zzbpu zzfza;

                /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzd$zzb$zza */
                /* loaded from: classes2.dex */
                public static final class zza extends zzbrd.zza<C0070zzb, zza> implements zzbsn {
                    private zza() {
                        super(C0070zzb.zzfzb);
                    }

                    /* synthetic */ zza(_i _iVar) {
                        this();
                    }
                }

                static {
                    zzbrd.zza((Class<C0070zzb>) C0070zzb.class, zzfzb);
                }

                private C0070zzb() {
                    zzbpu zzbpuVar = zzbpu.zzfli;
                    this.zzfyy = zzbpuVar;
                    this.zzfyz = zzbpuVar;
                    this.zzfza = zzbpuVar;
                }

                public static zzbsw<C0070zzb> zzon() {
                    return (zzbsw) zzfzb.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
                }

                @Override // com.google.android.gms.internal.ads.zzbrd
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (_i.f12041a[i - 1]) {
                        case 1:
                            return new C0070zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zzbrd.zza(zzfzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzfyy", "zzfyz", "zzfza"});
                        case 4:
                            return zzfzb;
                        case 5:
                            zzbsw<C0070zzb> zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                synchronized (C0070zzb.class) {
                                    zzbswVar = zzcas;
                                    if (zzbswVar == null) {
                                        zzbswVar = new zzbrd.zzb<>(zzfzb);
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

            static {
                zzbrd.zza((Class<zzd>) zzd.class, zzfyx);
            }

            private zzd() {
                zzbpu zzbpuVar = zzbpu.zzfli;
                this.zzfyu = zzbpuVar;
                this.zzfyv = zzbpuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzbrd.zza(zzfyx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzccg", "zzfys", "zzfyt", zzc.class, "zzfyu", "zzfyv", "zzfyw"});
                    case 4:
                        return zzfyx;
                    case 5:
                        zzbsw<zzd> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zzd.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzfyx);
                                    zzcas = zzbswVar;
                                }
                            }
                        }
                        return zzbswVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes2.dex */
        public static final class zze extends zzbrd<zze, zza> implements zzbsn {
            private static volatile zzbsw<zze> zzcas;
            private static final zze zzfze = new zze();
            private int zzccg;
            private byte zzfxl = 2;
            private zzbrk<zzc> zzfyt = zzbrd.zzams();
            private zzbpu zzfyu;
            private zzbpu zzfyv;
            private int zzfyw;
            private C0071zzb zzfzc;
            private zzbpu zzfzd;

            /* loaded from: classes2.dex */
            public static final class zza extends zzbrd.zza<zze, zza> implements zzbsn {
                private zza() {
                    super(zze.zzfze);
                }

                /* synthetic */ zza(_i _iVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zze$zzb */
            /* loaded from: classes2.dex */
            public static final class C0071zzb extends zzbrd<C0071zzb, zza> implements zzbsn {
                private static volatile zzbsw<C0071zzb> zzcas;
                private static final C0071zzb zzfzh = new C0071zzb();
                private int zzccg;
                private zzbpu zzfza;
                private int zzfzf;
                private zzbpu zzfzg;

                /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zze$zzb$zza */
                /* loaded from: classes2.dex */
                public static final class zza extends zzbrd.zza<C0071zzb, zza> implements zzbsn {
                    private zza() {
                        super(C0071zzb.zzfzh);
                    }

                    /* synthetic */ zza(_i _iVar) {
                        this();
                    }
                }

                static {
                    zzbrd.zza((Class<C0071zzb>) C0071zzb.class, zzfzh);
                }

                private C0071zzb() {
                    zzbpu zzbpuVar = zzbpu.zzfli;
                    this.zzfzg = zzbpuVar;
                    this.zzfza = zzbpuVar;
                }

                public static zzbsw<C0071zzb> zzon() {
                    return (zzbsw) zzfzh.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
                }

                @Override // com.google.android.gms.internal.ads.zzbrd
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (_i.f12041a[i - 1]) {
                        case 1:
                            return new C0071zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zzbrd.zza(zzfzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzfzf", "zzfzg", "zzfza"});
                        case 4:
                            return zzfzh;
                        case 5:
                            zzbsw<C0071zzb> zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                synchronized (C0071zzb.class) {
                                    zzbswVar = zzcas;
                                    if (zzbswVar == null) {
                                        zzbswVar = new zzbrd.zzb<>(zzfzh);
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

            static {
                zzbrd.zza((Class<zze>) zze.class, zzfze);
            }

            private zze() {
                zzbpu zzbpuVar = zzbpu.zzfli;
                this.zzfyu = zzbpuVar;
                this.zzfyv = zzbpuVar;
                this.zzfzd = zzbpuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzbrd.zza(zzfze, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzccg", "zzfzc", "zzfyt", zzc.class, "zzfyu", "zzfyv", "zzfyw", "zzfzd"});
                    case 4:
                        return zzfze;
                    case 5:
                        zzbsw<zze> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zze.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzfze);
                                    zzcas = zzbswVar;
                                }
                            }
                        }
                        return zzbswVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzf extends zzbrd<zzf, zza> implements zzbsn {
            private static volatile zzbsw<zzf> zzcas;
            private static final zzf zzfzk = new zzf();
            private int zzccg;
            private int zzcch;
            private String zzfzi = "";
            private zzbpu zzfzj = zzbpu.zzfli;

            /* loaded from: classes2.dex */
            public static final class zza extends zzbrd.zza<zzf, zza> implements zzbsn {
                private zza() {
                    super(zzf.zzfzk);
                }

                /* synthetic */ zza(_i _iVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzf$zzb */
            /* loaded from: classes2.dex */
            public enum EnumC0072zzb implements zzbrg {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);

                private static final zzbrh<EnumC0072zzb> zzcbx = new C0862cj();
                private final int value;

                EnumC0072zzb(int i) {
                    this.value = i;
                }

                public static EnumC0072zzb zzgj(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzbri zzop() {
                    return C0877dj.f12128a;
                }

                @Override // com.google.android.gms.internal.ads.zzbrg
                public final int zzom() {
                    return this.value;
                }
            }

            static {
                zzbrd.zza((Class<zzf>) zzf.class, zzfzk);
            }

            private zzf() {
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzbrd.zza(zzfzk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzcch", EnumC0072zzb.zzop(), "zzfzi", "zzfzj"});
                    case 4:
                        return zzfzk;
                    case 5:
                        zzbsw<zzf> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zzf.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzfzk);
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
        public enum zzg implements zzbrg {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final zzbrh<zzg> zzcbx = new C0891ej();
            private final int value;

            zzg(int i) {
                this.value = i;
            }

            public static zzg zzgk(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzbri zzop() {
                return C0905fj.f12163a;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzh extends zzbrd<zzh, C0073zzb> implements zzbsn {
            private static volatile zzbsw<zzh> zzcas;
            private static final zzh zzgah = new zzh();
            private int zzccg;
            private int zzfzz;
            private zzd zzgaa;
            private zze zzgab;
            private int zzgac;
            private int zzgaf;
            private byte zzfxl = 2;
            private String zzfxo = "";
            private zzbrj zzgad = zzbrd.zzamr();
            private String zzgae = "";
            private zzbrk<String> zzgag = zzbrd.zzams();

            /* loaded from: classes2.dex */
            public enum zza implements zzbrg {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);

                private static final zzbrh<zza> zzcbx = new C0919gj();
                private final int value;

                zza(int i) {
                    this.value = i;
                }

                public static zza zzgl(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzbri zzop() {
                    return C0933hj.f12194a;
                }

                @Override // com.google.android.gms.internal.ads.zzbrg
                public final int zzom() {
                    return this.value;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzh$zzb */
            /* loaded from: classes2.dex */
            public static final class C0073zzb extends zzbrd.zza<zzh, C0073zzb> implements zzbsn {
                private C0073zzb() {
                    super(zzh.zzgah);
                }

                /* synthetic */ C0073zzb(_i _iVar) {
                    this();
                }
            }

            static {
                zzbrd.zza((Class<zzh>) zzh.class, zzgah);
            }

            private zzh() {
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0073zzb(null);
                    case 3:
                        return zzbrd.zza(zzgah, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzccg", "zzfzz", "zzfxo", "zzgaa", "zzgab", "zzgac", "zzgad", "zzgae", "zzgaf", zza.zzop(), "zzgag"});
                    case 4:
                        return zzgah;
                    case 5:
                        zzbsw<zzh> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zzh.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzgah);
                                    zzcas = zzbswVar;
                                }
                            }
                        }
                        return zzbswVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzi extends zzbrd<zzi, zza> implements zzbsn {
            private static volatile zzbsw<zzi> zzcas;
            private static final zzi zzgaq = new zzi();
            private int zzccg;
            private String zzgan = "";
            private long zzgao;
            private boolean zzgap;

            /* loaded from: classes2.dex */
            public static final class zza extends zzbrd.zza<zzi, zza> implements zzbsn {
                private zza() {
                    super(zzi.zzgaq);
                }

                /* synthetic */ zza(_i _iVar) {
                    this();
                }
            }

            static {
                zzbrd.zza((Class<zzi>) zzi.class, zzgaq);
            }

            private zzi() {
            }

            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (_i.f12041a[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzbrd.zza(zzgaq, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzccg", "zzgan", "zzgao", "zzgap"});
                    case 4:
                        return zzgaq;
                    case 5:
                        zzbsw<zzi> zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            synchronized (zzi.class) {
                                zzbswVar = zzcas;
                                if (zzbswVar == null) {
                                    zzbswVar = new zzbrd.zzb<>(zzgaq);
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

        static {
            zzbrd.zza((Class<zzb>) zzb.class, zzfyn);
        }

        private zzb() {
        }

        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            switch (_i.f12041a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzbrd.zza(zzfyn, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzccg", "zzfxo", "zzfxz", "zzfya", "zzfyc", zzh.class, "zzfyf", "zzfyg", "zzfyh", "zzfyi", "zzfyj", "zzcch", zzg.zzop(), "zzfxy", zza.zzc.zzop(), "zzfyb", "zzfyd", "zzfye", "zzfxh", "zzfyk", "zzfyl", "zzfym"});
                case 4:
                    return zzfyn;
                case 5:
                    zzbsw<zzb> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzb.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzfyn);
                                zzcas = zzbswVar;
                            }
                        }
                    }
                    return zzbswVar;
                case 6:
                    return Byte.valueOf(this.zzfxl);
                case 7:
                    this.zzfxl = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
