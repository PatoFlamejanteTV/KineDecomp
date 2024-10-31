package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzj {

    /* loaded from: classes2.dex */
    public static final class zzb extends zzft<zzb, zza> implements zzhe {
        private static final zzb zzan = new zzb();
        private static volatile zzhm<zzb> zzm;
        private boolean zzai;
        private boolean zzaj;
        private boolean zzak;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzag = "";
        private zzgb<String> zzah = zzft.zzhf();
        private String zzr = "";
        private String zzz = "";
        private zzgb<String> zzal = zzft.zzhf();

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzb, zza> implements zzhe {
            private zza() {
                super(zzb.zzan);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzb>) zzb.class, zzan);
        }

        private zzb() {
        }

        public static zzhm<zzb> zzl() {
            return (zzhm) zzan.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getProviderId() {
            return this.zzr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzan, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\u001a\u0004\u0007\u0002\u0005\b\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\b\u0006\t\u001a", new Object[]{"zzi", "zzaf", "zzag", "zzah", "zzai", "zzr", "zzaj", "zzak", "zzz", "zzal"});
                case 4:
                    return zzan;
                case 5:
                    zzhm<zzb> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzb.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzan);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zze() {
            return this.zzag;
        }

        public final List<String> zzf() {
            return this.zzah;
        }

        public final int zzg() {
            return this.zzah.size();
        }

        public final boolean zzh() {
            return this.zzai;
        }

        public final boolean zzi() {
            return this.zzaj;
        }

        public final List<String> zzj() {
            return this.zzal;
        }

        public final int zzk() {
            return this.zzal.size();
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzft<zze, zza> implements zzhe {
        private static final zze zzay = new zze();
        private static volatile zzhm<zze> zzm;
        private long zzaw;
        private boolean zzax;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzaq = "";
        private String zzat = "";
        private String zzav = "";
        private String zzao = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zze, zza> implements zzhe {
            private zza() {
                super(zze.zzay);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zze>) zze.class, zzay);
        }

        private zze() {
        }

        public static zzhm<zze> zzl() {
            return (zzhm) zzay.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzay, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0002\u0004\u0006\b\u0005\u0007\u0007\u0006", new Object[]{"zzi", "zzaf", "zzaq", "zzat", "zzav", "zzaw", "zzao", "zzax"});
                case 4:
                    return zzay;
                case 5:
                    zzhm<zze> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zze.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzay);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final boolean zzt() {
            return this.zzax;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzg extends zzft<zzg, zza> implements zzhe {
        private static final zzg zzbd = new zzg();
        private static volatile zzhm<zzg> zzm;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private zzgb<com.google.android.gms.internal.firebase_auth.zzr> zzbc = zzft.zzhf();

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzg, zza> implements zzhe {
            private zza() {
                super(zzg.zzbd);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzg>) zzg.class, zzbd);
        }

        private zzg() {
        }

        public static zzhm<zzg> zzl() {
            return (zzhm) zzbd.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final com.google.android.gms.internal.firebase_auth.zzr zza(int i) {
            return this.zzbc.get(i);
        }

        public final int zzx() {
            return this.zzbc.size();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzbd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001b", new Object[]{"zzi", "zzaf", "zzbc", com.google.android.gms.internal.firebase_auth.zzr.class});
                case 4:
                    return zzbd;
                case 5:
                    zzhm<zzg> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzg.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzbd);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase_auth.zzj$zzj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0083zzj extends zzft<C0083zzj, zza> implements zzhe {
        private static final C0083zzj zzbx = new C0083zzj();
        private static volatile zzhm<C0083zzj> zzm;
        private int zzbw;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzat = "";
        private String zzbi = "";

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzj$zzj$zza */
        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<C0083zzj, zza> implements zzhe {
            private zza() {
                super(C0083zzj.zzbx);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<C0083zzj>) C0083zzj.class, zzbx);
        }

        private C0083zzj() {
        }

        public static zzhm<C0083zzj> zzl() {
            return (zzhm) zzbx.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getEmail() {
            return this.zzat;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new C0083zzj();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzbx, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\f\u0003", new Object[]{"zzi", "zzaf", "zzat", "zzbi", "zzbw", zzjo.zzbj()});
                case 4:
                    return zzbx;
                case 5:
                    zzhm<C0083zzj> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (C0083zzj.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzbx);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzad() {
            return this.zzbi;
        }

        public final zzjo zzae() {
            zzjo zzbg = zzjo.zzbg(this.zzbw);
            return zzbg == null ? zzjo.OOB_REQ_TYPE_UNSPECIFIED : zzbg;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzm extends zzft<zzm, zza> implements zzhe {
        private static final zzm zzcx = new zzm();
        private static volatile zzhm<zzm> zzm;
        private long zzaw;
        private boolean zzcg;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzao = "";
        private String zzat = "";
        private String zzcd = "";
        private zzgb<String> zzcf = zzft.zzhf();
        private String zzaq = "";
        private zzgb<com.google.android.gms.internal.firebase_auth.zzm> zzcv = zzft.zzhf();
        private String zzbi = "";
        private String zzcn = "";
        private String zzav = "";
        private String zzcw = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzm, zza> implements zzhe {
            private zza() {
                super(zzm.zzcx);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzm>) zzm.class, zzcx);
        }

        private zzm() {
        }

        public static zzhm<zzm> zzl() {
            return (zzhm) zzcx.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        @Deprecated
        public final String getDisplayName() {
            return this.zzcd;
        }

        @Deprecated
        public final String getEmail() {
            return this.zzat;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzcx, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u001a\u0006\b\u0004\u0007\u001b\b\b\u0005\t\b\u0006\n\b\u0007\u000b\u0002\b\f\b\t\r\u0007\n", new Object[]{"zzi", "zzaf", "zzao", "zzat", "zzcd", "zzcf", "zzaq", "zzcv", com.google.android.gms.internal.firebase_auth.zzm.class, "zzbi", "zzcn", "zzav", "zzaw", "zzcw", "zzcg"});
                case 4:
                    return zzcx;
                case 5:
                    zzhm<zzm> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzm.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzcx);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Deprecated
        public final List<com.google.android.gms.internal.firebase_auth.zzm> zzak() {
            return this.zzcv;
        }

        @Deprecated
        public final String zzal() {
            return this.zzcn;
        }

        public final String zzam() {
            return this.zzcw;
        }

        public final boolean zzan() {
            return this.zzcg;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzo extends zzft<zzo, zza> implements zzhe {
        private static final zzo zzda = new zzo();
        private static volatile zzhm<zzo> zzm;
        private long zzaw;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzaq = "";
        private String zzcd = "";
        private String zzat = "";
        private String zzav = "";
        private String zzao = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzo, zza> implements zzhe {
            private zza() {
                super(zzo.zzda);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzo>) zzo.class, zzda);
        }

        private zzo() {
        }

        public static zzhm<zzo> zzl() {
            return (zzhm) zzda.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzda, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005\b\b\u0006", new Object[]{"zzi", "zzaf", "zzaq", "zzcd", "zzat", "zzav", "zzaw", "zzao"});
                case 4:
                    return zzda;
                case 5:
                    zzhm<zzo> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzo.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzda);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzp extends zzft<zzp, zza> implements zzhe {
        private static final zzp zzdi = new zzp();
        private static volatile zzhm<zzp> zzm;
        private long zzad;
        private long zzap;
        private boolean zzcq;
        private boolean zzde;
        private boolean zzdf;
        private int zzi;
        private String zzdb = "";
        private String zzdc = "";
        private String zzdd = "";
        private String zzz = "";
        private String zzcm = "";
        private String zzaq = "";
        private boolean zzdg = true;
        private String zzac = "";
        private String zzdh = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzp, zza> implements zzhe {
            private zza() {
                super(zzp.zzdi);
            }

            public final zza zzbb(String str) {
                zzhj();
                ((zzp) this.zzxc).zzax(str);
                return this;
            }

            public final zza zzbc(String str) {
                zzhj();
                ((zzp) this.zzxc).zzay(str);
                return this;
            }

            public final zza zzbd(String str) {
                zzhj();
                ((zzp) this.zzxc).zzaz(str);
                return this;
            }

            public final zza zzbe(String str) {
                zzhj();
                ((zzp) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzbf(String str) {
                zzhj();
                ((zzp) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzbg(String str) {
                zzhj();
                ((zzp) this.zzxc).zzba(str);
                return this;
            }

            public final zza zzi(boolean z) {
                zzhj();
                ((zzp) this.zzxc).zze(z);
                return this;
            }

            public final zza zzj(boolean z) {
                zzhj();
                ((zzp) this.zzxc).zzg(z);
                return this;
            }

            public final zza zzk(boolean z) {
                zzhj();
                ((zzp) this.zzxc).zzh(z);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzp>) zzp.class, zzdi);
        }

        private zzp() {
        }

        public static zza zzas() {
            return (zza) zzdi.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzax(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzdb = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzay(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzdc = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaz(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzz = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzba(String str) {
            if (str != null) {
                this.zzi |= 8192;
                this.zzdh = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 2048;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 256;
            this.zzcq = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 128;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(boolean z) {
            this.zzi |= 1024;
            this.zzdg = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzdi, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\u0002\u0006\b\b\u0007\t\u0007\b\n\u0007\t\u000b\u0007\n\r\b\u000b\u000e\u0003\f\u000f\b\r", new Object[]{"zzi", "zzdb", "zzdc", "zzdd", "zzde", "zzz", "zzcm", "zzap", "zzaq", "zzcq", "zzdf", "zzdg", "zzac", "zzad", "zzdh"});
                case 4:
                    return zzdi;
                case 5:
                    zzhm<zzp> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzp.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzdi);
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(boolean z) {
            this.zzi |= 512;
            this.zzdf = z;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzq extends zzft<zzq, zza> implements zzhe {
        private static final zzq zzel = new zzq();
        private static volatile zzhm<zzq> zzm;
        private long zzaw;
        private boolean zzax;
        private boolean zzcg;
        private int zzdj;
        private boolean zzdv;
        private boolean zzdy;
        private long zzed;
        private boolean zzef;
        private int zzi;
        private String zzdk = "";
        private String zzr = "";
        private String zzat = "";
        private String zzdl = "";
        private String zzdm = "";
        private String zzdn = "";
        private String zzdo = "";
        private String zzdp = "";
        private String zzdq = "";
        private String zzcn = "";
        private String zzdr = "";
        private String zzds = "";
        private String zzt = "";
        private String zzdt = "";
        private String zzdu = "";
        private String zzao = "";
        private String zzcd = "";
        private String zzaq = "";
        private String zzdw = "";
        private String zzv = "";
        private zzgb<String> zzdx = zzft.zzhf();
        private String zzdz = "";
        private String zzea = "";
        private String zzeb = "";
        private String zzec = "";
        private String zzee = "";
        private String zzeg = "";
        private String zzav = "";
        private String zzeh = "";
        private String zzei = "";
        private String zzej = "";
        private String zzek = "";
        private String zzdh = "";
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzq, zza> implements zzhe {
            private zza() {
                super(zzq.zzel);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzq>) zzq.class, zzel);
        }

        private zzq() {
        }

        public static zzhm<zzq> zzl() {
            return (zzhm) zzel.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String getErrorMessage() {
            return this.zzek;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        public final String getProviderId() {
            return this.zzr;
        }

        public final String getRawUserInfo() {
            return this.zzej;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzel, "\u0001)\u0000\u0002\u0001+)\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\b\r\u000f\b\u000e\u0010\b\u000f\u0011\b\u0010\u0012\u0007\u0011\u0013\b\u0012\u0014\b\u0013\u0015\b\u0014\u0017\b\u0015\u0018\u001a\u0019\u0007\u0016\u001a\b\u0017\u001b\b\u0018\u001c\b\u0019\u001d\b\u001a\u001e\u0002\u001b\u001f\b\u001c \u0007\u001d!\b\u001e\"\b\u001f#\u0002 $\b!%\b\"&\b#'\b$(\u0007%*\b&+\b'", new Object[]{"zzi", "zzdj", "zzdk", "zzr", "zzat", "zzcg", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzcn", "zzdr", "zzds", "zzt", "zzdt", "zzdu", "zzao", "zzdv", "zzcd", "zzaq", "zzdw", "zzv", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzav", "zzaw", "zzeh", "zzei", "zzej", "zzek", "zzax", "zzdh", "zzac"});
                case 4:
                    return zzel;
                case 5:
                    zzhm<zzq> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzq.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzel);
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

        public final String zzal() {
            return this.zzcn;
        }

        public final boolean zzau() {
            return this.zzdy;
        }

        public final String zzav() {
            return this.zzeb;
        }

        public final boolean zzaw() {
            return this.zzef;
        }

        public final String zzax() {
            return this.zzeh;
        }

        public final String zzay() {
            return this.zzdh;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final boolean zzt() {
            return this.zzax;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzs extends zzft<zzs, zza> implements zzhe {
        private static final zzs zzeo = new zzs();
        private static volatile zzhm<zzs> zzm;
        private long zzaw;
        private boolean zzax;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzaq = "";
        private String zzav = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzs, zza> implements zzhe {
            private zza() {
                super(zzs.zzeo);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzs>) zzs.class, zzeo);
        }

        private zzs() {
        }

        public static zzhm<zzs> zzl() {
            return (zzhm) zzeo.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzeo, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0007\u0004", new Object[]{"zzi", "zzaf", "zzaq", "zzav", "zzaw", "zzax"});
                case 4:
                    return zzeo;
                case 5:
                    zzhm<zzs> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzs.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzeo);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final boolean zzt() {
            return this.zzax;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzu extends zzft<zzu, zza> implements zzhe {
        private static final zzu zzer = new zzu();
        private static volatile zzhm<zzu> zzm;
        private boolean zzai;
        private long zzaw;
        private long zzed;
        private int zzi;
        private byte zzam = 2;
        private String zzaf = "";
        private String zzao = "";
        private String zzat = "";
        private String zzcd = "";
        private String zzaq = "";
        private String zzcn = "";
        private String zzeb = "";
        private String zzee = "";
        private String zzav = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzu, zza> implements zzhe {
            private zza() {
                super(zzu.zzer);
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzu>) zzu.class, zzer);
        }

        private zzu() {
        }

        public static zzhm<zzu> zzl() {
            return (zzhm) zzer.zza(zzft.zze.zzxl, (Object) null, (Object) null);
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzer, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0007\u0005\u0007\b\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u0002\u000b", new Object[]{"zzi", "zzaf", "zzao", "zzat", "zzcd", "zzaq", "zzai", "zzcn", "zzeb", "zzed", "zzee", "zzav", "zzaw"});
                case 4:
                    return zzer;
                case 5:
                    zzhm<zzu> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzu.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzer);
                                zzm = zzhmVar;
                            }
                        }
                    }
                    return zzhmVar;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    this.zzam = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzal() {
            return this.zzcn;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzh extends zzft<zzh, zza> implements zzhe {
        private static final zzh zzbs = new zzh();
        private static volatile zzhm<zzh> zzm;
        private long zzad;
        private int zzbe;
        private boolean zzbn;
        private boolean zzbp;
        private boolean zzbr;
        private int zzi;
        private String zzat = "";
        private String zzbf = "";
        private String zzbg = "";
        private String zzbh = "";
        private String zzbi = "";
        private String zzaq = "";
        private String zzbj = "";
        private String zzbk = "";
        private String zzbl = "";
        private String zzbm = "";
        private String zzbo = "";
        private String zzac = "";
        private String zzbq = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzh, zza> implements zzhe {
            private zza() {
                super(zzh.zzbs);
            }

            public final zza zzaa(String str) {
                zzhj();
                ((zzh) this.zzxc).zzs(str);
                return this;
            }

            public final zza zzab(String str) {
                zzhj();
                ((zzh) this.zzxc).zzt(str);
                return this;
            }

            public final zza zzac(String str) {
                zzhj();
                ((zzh) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzad(String str) {
                zzhj();
                ((zzh) this.zzxc).zzu(str);
                return this;
            }

            public final zza zzb(zzjo zzjoVar) {
                zzhj();
                ((zzh) this.zzxc).zza(zzjoVar);
                return this;
            }

            public final zza zzc(boolean z) {
                zzhj();
                ((zzh) this.zzxc).zza(z);
                return this;
            }

            public final zza zzd(boolean z) {
                zzhj();
                ((zzh) this.zzxc).zzb(z);
                return this;
            }

            public final zza zzv(String str) {
                zzhj();
                ((zzh) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzw(String str) {
                zzhj();
                ((zzh) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzx(String str) {
                zzhj();
                ((zzh) this.zzxc).zzp(str);
                return this;
            }

            public final zza zzy(String str) {
                zzhj();
                ((zzh) this.zzxc).zzq(str);
                return this;
            }

            public final zza zzz(String str) {
                zzhj();
                ((zzh) this.zzxc).zzr(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzh>) zzh.class, zzbs);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzjo zzjoVar) {
            if (zzjoVar != null) {
                this.zzi |= 1;
                this.zzbe = zzjoVar.zzbi();
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzi |= 8192;
            this.zzbp = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 16384;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 64;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(String str) {
            if (str != null) {
                this.zzi |= 128;
                this.zzbj = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(String str) {
            if (str != null) {
                this.zzi |= 256;
                this.zzbk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(String str) {
            if (str != null) {
                this.zzi |= 512;
                this.zzbl = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(String str) {
            if (str != null) {
                this.zzi |= 1024;
                this.zzbm = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(String str) {
            if (str != null) {
                this.zzi |= 4096;
                this.zzbo = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzu(String str) {
            if (str != null) {
                this.zzi |= 65536;
                this.zzbq = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzz() {
            return (zza) zzbs.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzi |= 2048;
            this.zzbn = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzbs, "\u0001\u0012\u0000\u0001\u0001\u0013\u0012\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\u0007\u000b\r\b\f\u000e\u0007\r\u000f\b\u000e\u0010\u0003\u000f\u0012\b\u0010\u0013\u0007\u0011", new Object[]{"zzi", "zzbe", zzjo.zzbj(), "zzat", "zzbf", "zzbg", "zzbh", "zzbi", "zzaq", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo", "zzbp", "zzac", "zzad", "zzbq", "zzbr"});
                case 4:
                    return zzbs;
                case 5:
                    zzhm<zzh> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzh.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzbs);
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

    /* loaded from: classes2.dex */
    public static final class zzl extends zzft<zzl, zza> implements zzhe {
        private static final zzga<Integer, com.google.android.gms.internal.firebase_auth.zzo> zzcp = new Wa();
        private static final zzl zzcu = new zzl();
        private static volatile zzhm<zzl> zzm;
        private long zzad;
        private long zzap;
        private boolean zzcg;
        private boolean zzch;
        private zzin zzck;
        private boolean zzcl;
        private boolean zzcq;
        private long zzcs;
        private long zzct;
        private int zzi;
        private String zzaq = "";
        private String zzao = "";
        private String zzcd = "";
        private String zzat = "";
        private String zzce = "";
        private zzgb<String> zzcf = zzft.zzhf();
        private String zzas = "";
        private String zzci = "";
        private String zzcj = "";
        private String zzcm = "";
        private String zzcn = "";
        private zzfz zzco = zzft.zzhe();
        private zzgb<String> zzcr = zzft.zzhf();
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzl, zza> implements zzhe {
            private zza() {
                super(zzl.zzcu);
            }

            public final zza zzan(String str) {
                zzhj();
                ((zzl) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzao(String str) {
                zzhj();
                ((zzl) this.zzxc).zzal(str);
                return this;
            }

            public final zza zzap(String str) {
                zzhj();
                ((zzl) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzaq(String str) {
                zzhj();
                ((zzl) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzar(String str) {
                zzhj();
                ((zzl) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzas(String str) {
                zzhj();
                ((zzl) this.zzxc).zzam(str);
                return this;
            }

            public final zza zzat(String str) {
                zzhj();
                ((zzl) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzc(Iterable<? extends com.google.android.gms.internal.firebase_auth.zzo> iterable) {
                zzhj();
                ((zzl) this.zzxc).zza(iterable);
                return this;
            }

            public final zza zzd(Iterable<String> iterable) {
                zzhj();
                ((zzl) this.zzxc).zzb(iterable);
                return this;
            }

            public final zza zzf(boolean z) {
                zzhj();
                ((zzl) this.zzxc).zze(z);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzl>) zzl.class, zzcu);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setPassword(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzce = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends com.google.android.gms.internal.firebase_auth.zzo> iterable) {
            if (!this.zzco.zzeu()) {
                zzfz zzfzVar = this.zzco;
                int size = zzfzVar.size();
                this.zzco = zzfzVar.zzj(size == 0 ? 10 : size << 1);
            }
            Iterator<? extends com.google.android.gms.internal.firebase_auth.zzo> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzco.zzas(it.next().zzbi());
            }
        }

        public static zza zzai() {
            return (zza) zzcu.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzal(String str) {
            if (str != null) {
                this.zzi |= 4;
                this.zzcd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzam(String str) {
            if (str != null) {
                this.zzi |= 16384;
                this.zzcn = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<String> iterable) {
            if (!this.zzcr.zzeu()) {
                zzgb<String> zzgbVar = this.zzcr;
                int size = zzgbVar.size();
                this.zzcr = zzgbVar.zzj(size == 0 ? 10 : size << 1);
            }
            zzdz.zza(iterable, this.zzcr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 262144;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 32768;
            this.zzcq = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzi |= 32;
                this.zzas = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 8;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzcu, "\u0001\u0017\u0000\u0001\u0002\u001a\u0017\u0000\u0003\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u001a\b\b\u0005\t\u0007\u0006\n\u0007\u0007\u000b\b\b\f\b\t\r\t\n\u000e\u0007\u000b\u000f\b\f\u0010\u0002\r\u0011\b\u000e\u0012\u001e\u0013\u0007\u000f\u0014\u001a\u0015\u0002\u0010\u0016\u0002\u0011\u0019\b\u0012\u001a\u0003\u0013", new Object[]{"zzi", "zzaq", "zzao", "zzcd", "zzat", "zzce", "zzcf", "zzas", "zzcg", "zzch", "zzci", "zzcj", "zzck", "zzcl", "zzcm", "zzap", "zzcn", "zzco", com.google.android.gms.internal.firebase_auth.zzo.zzbj(), "zzcq", "zzcr", "zzcs", "zzct", "zzac", "zzad"});
                case 4:
                    return zzcu;
                case 5:
                    zzhm<zzl> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzl.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzcu);
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

    /* loaded from: classes2.dex */
    public static final class zza extends zzft<zza, C0082zza> implements zzhe {
        private static final zza zzae = new zza();
        private static volatile zzhm<zza> zzm;
        private long zzad;
        private int zzi;
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private String zzu = "";
        private String zzv = "";
        private String zzw = "";
        private String zzx = "";
        private String zzy = "";
        private String zzz = "";
        private String zzaa = "";
        private zzgb<com.google.android.gms.internal.firebase_auth.zzh> zzab = zzft.zzhf();
        private String zzac = "";

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzj$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0082zza extends zzft.zza<zza, C0082zza> implements zzhe {
            private C0082zza() {
                super(zza.zzae);
            }

            public final C0082zza zzd(String str) {
                zzhj();
                ((zza) this.zzxc).zza(str);
                return this;
            }

            public final C0082zza zze(String str) {
                zzhj();
                ((zza) this.zzxc).zzb(str);
                return this;
            }

            public final C0082zza zzf(String str) {
                zzhj();
                ((zza) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ C0082zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zza>) zza.class, zzae);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzo = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzp = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 8192;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C0082zza zzc() {
            return (C0082zza) zzae.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0082zza(va);
                case 3:
                    return zzft.zza(zzae, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u001b\u000f\b\r\u0010\u0003\u000e", new Object[]{"zzi", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", com.google.android.gms.internal.firebase_auth.zzh.class, "zzac", "zzad"});
                case 4:
                    return zzae;
                case 5:
                    zzhm<zza> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zza.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzae);
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

    /* loaded from: classes2.dex */
    public static final class zzd extends zzft<zzd, zza> implements zzhe {
        private static final zzd zzau = new zzd();
        private static volatile zzhm<zzd> zzm;
        private long zzad;
        private int zzi;
        private String zzas = "";
        private String zzat = "";
        private String zzaq = "";
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzd, zza> implements zzhe {
            private zza() {
                super(zzd.zzau);
            }

            public final zza zzk(String str) {
                zzhj();
                ((zzd) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzl(String str) {
                zzhj();
                ((zzd) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzm(String str) {
                zzhj();
                ((zzd) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzn(String str) {
                zzhj();
                ((zzd) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzd>) zzd.class, zzau);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 8;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 4;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzas = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzp() {
            return (zza) zzau.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzau, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0006\b\u0003\u0007\u0003\u0004", new Object[]{"zzi", "zzas", "zzat", "zzaq", "zzac", "zzad"});
                case 4:
                    return zzau;
                case 5:
                    zzhm<zzd> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzd.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzau);
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

    /* loaded from: classes2.dex */
    public static final class zzi extends zzft<zzi, zza> implements zzhe {
        private static final zzi zzbv = new zzi();
        private static volatile zzhm<zzi> zzm;
        private long zzad;
        private int zzi;
        private String zzas = "";
        private String zzbt = "";
        private String zzbu = "";
        private String zzat = "";
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzi, zza> implements zzhe {
            private zza() {
                super(zzi.zzbv);
            }

            public final zza zzaf(String str) {
                zzhj();
                ((zzi) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzag(String str) {
                zzhj();
                ((zzi) this.zzxc).zzae(str);
                return this;
            }

            public final zza zzah(String str) {
                zzhj();
                ((zzi) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzi>) zzi.class, zzbv);
        }

        private zzi() {
        }

        public static zza zzab() {
            return (zza) zzbv.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzae(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzbt = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzas = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzbv, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0006\b\u0004\u0007\u0003\u0005", new Object[]{"zzi", "zzas", "zzbt", "zzbu", "zzat", "zzac", "zzad"});
                case 4:
                    return zzbv;
                case 5:
                    zzhm<zzi> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzi.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzbv);
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

    /* loaded from: classes2.dex */
    public static final class zzn extends zzft<zzn, zza> implements zzhe {
        private static final zzn zzcz = new zzn();
        private static volatile zzhm<zzn> zzm;
        private long zzad;
        private boolean zzcg;
        private boolean zzcy;
        private int zzi;
        private String zzat = "";
        private String zzce = "";
        private String zzcd = "";
        private String zzci = "";
        private String zzcj = "";
        private String zzcm = "";
        private String zzaq = "";
        private String zzcn = "";
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzn, zza> implements zzhe {
            private zza() {
                super(zzn.zzcz);
            }

            public final zza zzau(String str) {
                zzhj();
                ((zzn) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzav(String str) {
                zzhj();
                ((zzn) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzaw(String str) {
                zzhj();
                ((zzn) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzn>) zzn.class, zzcz);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setPassword(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzce = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzap() {
            return (zza) zzcz.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 1024;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzcz, "\u0001\f\u0000\u0001\u0001\u000e\f\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0007\u0007\t\b\b\n\u0007\t\r\b\n\u000e\u0003\u000b", new Object[]{"zzi", "zzat", "zzce", "zzcd", "zzci", "zzcj", "zzcm", "zzaq", "zzcg", "zzcn", "zzcy", "zzac", "zzad"});
                case 4:
                    return zzcz;
                case 5:
                    zzhm<zzn> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzn.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzcz);
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

    /* loaded from: classes2.dex */
    public static final class zzt extends zzft<zzt, zza> implements zzhe {
        private static final zzt zzeq = new zzt();
        private static volatile zzhm<zzt> zzm;
        private long zzad;
        private long zzap;
        private boolean zzcq;
        private int zzi;
        private String zzat = "";
        private String zzce = "";
        private String zzdd = "";
        private String zzci = "";
        private String zzcj = "";
        private String zzep = "";
        private String zzcm = "";
        private String zzaq = "";
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzt, zza> implements zzhe {
            private zza() {
                super(zzt.zzeq);
            }

            public final zza zzbj(String str) {
                zzhj();
                ((zzt) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzbk(String str) {
                zzhj();
                ((zzt) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzbl(String str) {
                zzhj();
                ((zzt) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzm(boolean z) {
                zzhj();
                ((zzt) this.zzxc).zze(z);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzt>) zzt.class, zzeq);
        }

        private zzt() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setPassword(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzce = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzbd() {
            return (zza) zzeq.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 1024;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 512;
            this.zzcq = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzeq, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0007\t\u000b\b\n\f\u0003\u000b", new Object[]{"zzi", "zzat", "zzce", "zzdd", "zzci", "zzcj", "zzep", "zzcm", "zzap", "zzaq", "zzcq", "zzac", "zzad"});
                case 4:
                    return zzeq;
                case 5:
                    zzhm<zzt> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzt.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzeq);
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

    /* loaded from: classes2.dex */
    public static final class zzc extends zzft<zzc, zza> implements zzhe {
        private static final zzc zzar = new zzc();
        private static volatile zzhm<zzc> zzm;
        private long zzap;
        private int zzi;
        private String zzao = "";
        private String zzaq = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzc, zza> implements zzhe {
            private zza() {
                super(zzc.zzar);
            }

            public final zza zzh(String str) {
                zzhj();
                ((zzc) this.zzxc).zzg(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzc>) zzc.class, zzar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 4;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzn() {
            return (zza) zzar.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzar, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002", new Object[]{"zzi", "zzao", "zzap", "zzaq"});
                case 4:
                    return zzar;
                case 5:
                    zzhm<zzc> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzc.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzar);
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

    /* loaded from: classes2.dex */
    public static final class zzf extends zzft<zzf, zza> implements zzhe {
        private static final zzf zzbb = new zzf();
        private static volatile zzhm<zzf> zzm;
        private long zzap;
        private String zzaq = "";
        private zzgb<String> zzaz = zzft.zzhf();
        private zzgb<String> zzba = zzft.zzhf();
        private int zzi;

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzf, zza> implements zzhe {
            private zza() {
                super(zzf.zzbb);
            }

            public final zza zzo(String str) {
                zzhj();
                ((zzf) this.zzxc).zzg(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzf>) zzf.class, zzbb);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzv() {
            return (zza) zzbb.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\b\u0000\u0002\u001a\u0003\u001a\u0004\u0002\u0001", new Object[]{"zzi", "zzaq", "zzaz", "zzba", "zzap"});
                case 4:
                    return zzbb;
                case 5:
                    zzhm<zzf> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzf.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzbb);
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

    /* loaded from: classes2.dex */
    public static final class zzk extends zzft<zzk, zza> implements zzhe {
        private static final zzk zzcc = new zzk();
        private static volatile zzhm<zzk> zzm;
        private long zzad;
        private int zzi;
        private String zzby = "";
        private String zzbz = "";
        private String zzca = "";
        private String zzcb = "";
        private String zzac = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzk, zza> implements zzhe {
            private zza() {
                super(zzk.zzcc);
            }

            public final zza zzaj(String str) {
                zzhj();
                ((zzk) this.zzxc).zzai(str);
                return this;
            }

            public final zza zzak(String str) {
                zzhj();
                ((zzk) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzk>) zzk.class, zzcc);
        }

        private zzk() {
        }

        public static zza zzag() {
            return (zza) zzcc.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzai(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzby = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzcc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0003\u0005", new Object[]{"zzi", "zzby", "zzbz", "zzca", "zzcb", "zzac", "zzad"});
                case 4:
                    return zzcc;
                case 5:
                    zzhm<zzk> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzk.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzcc);
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

    /* loaded from: classes2.dex */
    public static final class zzr extends zzft<zzr, zza> implements zzhe {
        private static final zzr zzen = new zzr();
        private static volatile zzhm<zzr> zzm;
        private long zzap;
        private boolean zzcq;
        private int zzi;
        private String zzem = "";
        private String zzcm = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzft.zza<zzr, zza> implements zzhe {
            private zza() {
                super(zzr.zzen);
            }

            public final zza zzbi(String str) {
                zzhj();
                ((zzr) this.zzxc).zzbh(str);
                return this;
            }

            public final zza zzl(boolean z) {
                zzhj();
                ((zzr) this.zzxc).zze(z);
                return this;
            }

            /* synthetic */ zza(Va va) {
                this();
            }
        }

        static {
            zzft.zza((Class<zzr>) zzr.class, zzen);
        }

        private zzr() {
        }

        public static zza zzba() {
            return (zza) zzen.zza(zzft.zze.zzxj, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbh(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzem = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 4;
            this.zzcq = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.firebase_auth.zzft
        public final Object zza(int i, Object obj, Object obj2) {
            Va va = null;
            switch (Va.f12998a[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(va);
                case 3:
                    return zzft.zza(zzen, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u0002\u0003", new Object[]{"zzi", "zzem", "zzcm", "zzcq", "zzap"});
                case 4:
                    return zzen;
                case 5:
                    zzhm<zzr> zzhmVar = zzm;
                    if (zzhmVar == null) {
                        synchronized (zzr.class) {
                            zzhmVar = zzm;
                            if (zzhmVar == null) {
                                zzhmVar = new zzft.zzb<>(zzen);
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
