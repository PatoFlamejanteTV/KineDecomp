package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbni extends zzbrd<zzbni, zza> implements zzbsn {
    private static volatile zzbsw<zzbni> zzcas;
    private static final zzbni zzfht = new zzbni();
    private int zzfea;
    private zzbnk zzfhs;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbni, zza> implements zzbsn {
        private zza() {
            super(zzbni.zzfht);
        }

        public final zza zzb(zzbnk zzbnkVar) {
            zzamw();
            ((zzbni) this.zzfpy).zza(zzbnkVar);
            return this;
        }

        public final zza zzed(int i) {
            zzamw();
            ((zzbni) this.zzfpy).setVersion(0);
            return this;
        }

        /* synthetic */ zza(_g _gVar) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbni>) zzbni.class, zzfht);
    }

    private zzbni() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbnk zzbnkVar) {
        if (zzbnkVar != null) {
            this.zzfhs = zzbnkVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zzbni zzaj(zzbpu zzbpuVar) throws zzbrl {
        return (zzbni) zzbrd.zza(zzfht, zzbpuVar);
    }

    public static zza zzajj() {
        return (zza) zzfht.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    public final zzbnk zzaji() {
        zzbnk zzbnkVar = this.zzfhs;
        return zzbnkVar == null ? zzbnk.zzajm() : zzbnkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        _g _gVar = null;
        switch (_g.f12037a[i - 1]) {
            case 1:
                return new zzbni();
            case 2:
                return new zza(_gVar);
            case 3:
                return zzbrd.zza(zzfht, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzfea", "zzfhs"});
            case 4:
                return zzfht;
            case 5:
                zzbsw<zzbni> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbni.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfht);
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
