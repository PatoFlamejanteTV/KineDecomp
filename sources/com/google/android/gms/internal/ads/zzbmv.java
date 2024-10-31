package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmv extends zzbrd<zzbmv, zza> implements zzbsn {
    private static volatile zzbsw<zzbmv> zzcas;
    private static final zzbmv zzfgn = new zzbmv();
    private String zzfgk = "";
    private zzbpu zzfgl = zzbpu.zzfli;
    private int zzfgm;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmv, zza> implements zzbsn {
        private zza() {
            super(zzbmv.zzfgn);
        }

        public final zza zzai(zzbpu zzbpuVar) {
            zzamw();
            ((zzbmv) this.zzfpy).zzah(zzbpuVar);
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            zzamw();
            ((zzbmv) this.zzfpy).zza(zzbVar);
            return this;
        }

        public final zza zzfl(String str) {
            zzamw();
            ((zzbmv) this.zzfpy).zzfk(str);
            return this;
        }

        /* synthetic */ zza(Tg tg) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public enum zzb implements zzbrg {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final zzbrh<zzb> zzcbx = new Ug();
        private final int value;

        zzb(int i) {
            this.value = i;
        }

        public static zzb zzdv(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // com.google.android.gms.internal.ads.zzbrg
        public final int zzom() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzbrd.zza((Class<zzbmv>) zzbmv.class, zzfgn);
    }

    private zzbmv() {
    }

    public final void zza(zzb zzbVar) {
        if (zzbVar != null) {
            this.zzfgm = zzbVar.zzom();
            return;
        }
        throw new NullPointerException();
    }

    public final void zzah(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfgl = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzaij() {
        return (zza) zzfgn.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public static zzbmv zzaik() {
        return zzfgn;
    }

    public final void zzfk(String str) {
        if (str != null) {
            this.zzfgk = str;
            return;
        }
        throw new NullPointerException();
    }

    public final String zzaig() {
        return this.zzfgk;
    }

    public final zzbpu zzaih() {
        return this.zzfgl;
    }

    public final zzb zzaii() {
        zzb zzdv = zzb.zzdv(this.zzfgm);
        return zzdv == null ? zzb.UNRECOGNIZED : zzdv;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        switch (Tg.f11848a[i - 1]) {
            case 1:
                return new zzbmv();
            case 2:
                return new zza(null);
            case 3:
                return zzbrd.zza(zzfgn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzfgk", "zzfgl", "zzfgm"});
            case 4:
                return zzfgn;
            case 5:
                zzbsw<zzbmv> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmv.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfgn);
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
