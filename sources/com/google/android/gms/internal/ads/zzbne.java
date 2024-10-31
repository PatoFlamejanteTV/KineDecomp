package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbne extends zzbrd<zzbne, zza> implements zzbsn {
    private static volatile zzbsw<zzbne> zzcas;
    private static final zzbne zzfhk = new zzbne();
    private int zzccg;
    private int zzfhi;
    private zzbrk<zzb> zzfhj = zzbrd.zzams();

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbne, zza> implements zzbsn {
        private zza() {
            super(zzbne.zzfhk);
        }

        /* synthetic */ zza(Yg yg) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzbrd<zzb, zza> implements zzbsn {
        private static volatile zzbsw<zzb> zzcas;
        private static final zzb zzfho = new zzb();
        private int zzfhb;
        private zzbmv zzfhl;
        private int zzfhm;
        private int zzfhn;

        /* loaded from: classes2.dex */
        public static final class zza extends zzbrd.zza<zzb, zza> implements zzbsn {
            private zza() {
                super(zzb.zzfho);
            }

            /* synthetic */ zza(Yg yg) {
                this();
            }
        }

        static {
            zzbrd.zza((Class<zzb>) zzb.class, zzfho);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            Yg yg = null;
            switch (Yg.f11980a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(yg);
                case 3:
                    return zzbrd.zza(zzfho, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzfhl", "zzfhm", "zzfhn", "zzfhb"});
                case 4:
                    return zzfho;
                case 5:
                    zzbsw<zzb> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zzb.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzfho);
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

        public final boolean zzaiy() {
            return this.zzfhl != null;
        }

        public final zzbmv zzaiz() {
            zzbmv zzbmvVar = this.zzfhl;
            return zzbmvVar == null ? zzbmv.zzaik() : zzbmvVar;
        }

        public final zzbmy zzaja() {
            zzbmy zzdw = zzbmy.zzdw(this.zzfhm);
            return zzdw == null ? zzbmy.UNRECOGNIZED : zzdw;
        }

        public final int zzajb() {
            return this.zzfhn;
        }

        public final zzbnq zzajc() {
            zzbnq zzef = zzbnq.zzef(this.zzfhb);
            return zzef == null ? zzbnq.UNRECOGNIZED : zzef;
        }
    }

    static {
        zzbrd.zza((Class<zzbne>) zzbne.class, zzfhk);
    }

    private zzbne() {
    }

    public static zzbne zzm(byte[] bArr) throws zzbrl {
        return (zzbne) zzbrd.zzb(zzfhk, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Yg yg = null;
        switch (Yg.f11980a[i - 1]) {
            case 1:
                return new zzbne();
            case 2:
                return new zza(yg);
            case 3:
                return zzbrd.zza(zzfhk, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzccg", "zzfhi", "zzfhj", zzb.class});
            case 4:
                return zzfhk;
            case 5:
                zzbsw<zzbne> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbne.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfhk);
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

    public final int zzaiu() {
        return this.zzfhi;
    }

    public final List<zzb> zzaiv() {
        return this.zzfhj;
    }

    public final int zzaiw() {
        return this.zzfhj.size();
    }
}
