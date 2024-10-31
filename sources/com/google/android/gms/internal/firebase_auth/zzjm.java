package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* loaded from: classes2.dex */
public final class zzjm {

    /* loaded from: classes2.dex */
    public static final class zzb extends zzft<zzb, zza> implements zzhe {
        private static final zzb zzaef = new zzb();
        private static volatile zzhm<zzb> zzm;
        private long zzaee;
        private long zzaw;
        private String zzaeb = "";
        private String zzaec = "";
        private String zzav = "";
        private String zzaq = "";
        private String zzaed = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzb, zza> implements zzhe {
            private zza() {
                super(zzb.zzaef);
            }

            /* synthetic */ zza(Sa sa) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzb>) zzb.class, zzaef);
        }

        private zzb() {
        }

        public static zzhm<zzb> zzl() {
            return (zzhm) zzaef.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Sa sa = null;
            switch (Sa.f12994a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(sa);
                case 3:
                    return zzft.zza(zzaef, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002", new Object[]{"zzaeb", "zzaw", "zzaec", "zzav", "zzaq", "zzaed", "zzaee"});
                case 4:
                    return zzaef;
                case 5:
                    zzhm<zzb> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzb.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzaef);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzdw() {
            return this.zzaeb;
        }

        public final String zzdx() {
            return this.zzaec;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzft<zza, C0084zza> implements zzhe {
        private static final zza zzaea = new zza();
        private static volatile zzhm<zza> zzm;
        private String zzadw = "";
        private String zzadx = "";
        private String zzav = "";
        private String zzady = "";
        private String zzadz = "";

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzjm$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0084zza extends zzft.zza<zza, C0084zza> implements zzhe {
            private C0084zza() {
                super(zza.zzaea);
            }

            public final C0084zza zzdf(String str) {
                zzhj();
                ((zza) this.zzxc).zzde(str);
                return this;
            }

            public final C0084zza zzdg(String str) {
                zzhj();
                ((zza) this.zzxc).zzce(str);
                return this;
            }

            /* synthetic */ C0084zza(Sa sa) {
                this();
            }
        }

        static {
            zzft.zza((Class<zza>) zza.class, zzaea);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzce(String str) {
            if (str != null) {
                this.zzav = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzde(String str) {
            if (str != null) {
                this.zzadw = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C0084zza zzka() {
            return (C0084zza) zzaea.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Sa sa = null;
            switch (Sa.f12994a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0084zza(sa);
                case 3:
                    return zzft.zza(zzaea, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"zzadw", "zzadx", "zzav", "zzady", "zzadz"});
                case 4:
                    return zzaea;
                case 5:
                    zzhm<zza> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zza.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzaea);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
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
