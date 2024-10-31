package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

/* loaded from: classes2.dex */
public final class zzfe {

    /* loaded from: classes2.dex */
    public static final class zzb extends zzuo<zzb, zza> implements zzvx {
        private static final zzb zzauz = new zzb();
        private static volatile zzwf<zzb> zznw;
        private int zzaux = 1;
        private zzuu<zza> zzauy = zzuo.zzwg();
        private int zznr;

        /* loaded from: classes2.dex */
        public static final class zza extends zzuo.zza<zzb, zza> implements zzvx {
            private zza() {
                super(zzb.zzauz);
            }

            public final zza zzb(zza zzaVar) {
                zzwk();
                ((zzb) this.zzbyh).zza(zzaVar);
                return this;
            }

            /* synthetic */ zza(E e2) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzfe$zzb$zzb */
        /* loaded from: classes2.dex */
        public enum EnumC0088zzb implements zzur {
            RADS(1),
            PROVISIONING(2);

            private static final zzus<EnumC0088zzb> zzoa = new F();
            private final int value;

            EnumC0088zzb(int i) {
                this.value = i;
            }

            public static zzut zzd() {
                return G.f13365a;
            }

            public static EnumC0088zzb zzt(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            @Override // com.google.android.gms.internal.measurement.zzur
            public final int zzc() {
                return this.value;
            }
        }

        static {
            zzuo.zza((Class<zzb>) zzb.class, zzauz);
        }

        private zzb() {
        }

        public final void zza(zza zzaVar) {
            if (zzaVar != null) {
                if (!this.zzauy.zztz()) {
                    zzuu<zza> zzuuVar = this.zzauy;
                    int size = zzuuVar.size();
                    this.zzauy = zzuuVar.zzal(size == 0 ? 10 : size << 1);
                }
                this.zzauy.add(zzaVar);
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzmp() {
            return (zza) zzauz.zza(zzuo.zze.zzbyo, (Object) null, (Object) null);
        }

        @Override // com.google.android.gms.internal.measurement.zzuo
        public final Object zza(int i, Object obj, Object obj2) {
            switch (E.f13361a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzuo.zza(zzauz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zznr", "zzaux", EnumC0088zzb.zzd(), "zzauy", zza.class});
                case 4:
                    return zzauz;
                case 5:
                    zzwf<zzb> zzwfVar = zznw;
                    if (zzwfVar == null) {
                        synchronized (zzb.class) {
                            zzwfVar = zznw;
                            if (zzwfVar == null) {
                                zzwfVar = new zzuo.zzb<>(zzauz);
                                zznw = zzwfVar;
                            }
                        }
                    }
                    return zzwfVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzwf<zzb> zza() {
            return (zzwf) zzauz.zza(zzuo.zze.zzbyq, (Object) null, (Object) null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzuo<zza, C0087zza> implements zzvx {
        private static final zza zzauw = new zza();
        private static volatile zzwf<zza> zznw;
        private String zzauu = "";
        private long zzauv;
        private int zznr;

        /* renamed from: com.google.android.gms.internal.measurement.zzfe$zza$zza */
        /* loaded from: classes2.dex */
        public static final class C0087zza extends zzuo.zza<zza, C0087zza> implements zzvx {
            private C0087zza() {
                super(zza.zzauw);
            }

            public final C0087zza zzan(long j) {
                zzwk();
                ((zza) this.zzbyh).zzam(j);
                return this;
            }

            public final C0087zza zzda(String str) {
                zzwk();
                ((zza) this.zzbyh).setName(str);
                return this;
            }

            /* synthetic */ C0087zza(E e2) {
                this();
            }
        }

        static {
            zzuo.zza((Class<zza>) zza.class, zzauw);
        }

        private zza() {
        }

        public final void setName(String str) {
            if (str != null) {
                this.zznr |= 1;
                this.zzauu = str;
                return;
            }
            throw new NullPointerException();
        }

        public final void zzam(long j) {
            this.zznr |= 2;
            this.zzauv = j;
        }

        public static C0087zza zzmn() {
            return (C0087zza) zzauw.zza(zzuo.zze.zzbyo, (Object) null, (Object) null);
        }

        @Override // com.google.android.gms.internal.measurement.zzuo
        public final Object zza(int i, Object obj, Object obj2) {
            switch (E.f13361a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0087zza(null);
                case 3:
                    return zzuo.zza(zzauw, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zznr", "zzauu", "zzauv"});
                case 4:
                    return zzauw;
                case 5:
                    zzwf<zza> zzwfVar = zznw;
                    if (zzwfVar == null) {
                        synchronized (zza.class) {
                            zzwfVar = zznw;
                            if (zzwfVar == null) {
                                zzwfVar = new zzuo.zzb<>(zzauw);
                                zznw = zzwfVar;
                            }
                        }
                    }
                    return zzwfVar;
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
