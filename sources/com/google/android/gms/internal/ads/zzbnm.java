package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbnm extends zzbrd<zzbnm, zza> implements zzbsn {
    private static volatile zzbsw<zzbnm> zzcas;
    private static final zzbnm zzfhx = new zzbnm();
    private int zzfea;
    private zzbno zzfhw;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbnm, zza> implements zzbsn {
        private zza() {
            super(zzbnm.zzfhx);
        }

        public final zza zzb(zzbno zzbnoVar) {
            zzamw();
            ((zzbnm) this.zzfpy).zza(zzbnoVar);
            return this;
        }

        public final zza zzee(int i) {
            zzamw();
            ((zzbnm) this.zzfpy).setVersion(0);
            return this;
        }

        /* synthetic */ zza(C0845bh c0845bh) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbnm>) zzbnm.class, zzfhx);
    }

    private zzbnm() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbno zzbnoVar) {
        if (zzbnoVar != null) {
            this.zzfhw = zzbnoVar;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzajp() {
        return (zza) zzfhx.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public static zzbnm zzal(zzbpu zzbpuVar) throws zzbrl {
        return (zzbnm) zzbrd.zza(zzfhx, zzbpuVar);
    }

    public final int getVersion() {
        return this.zzfea;
    }

    public final zzbno zzajo() {
        zzbno zzbnoVar = this.zzfhw;
        return zzbnoVar == null ? zzbno.zzajt() : zzbnoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C0845bh c0845bh = null;
        switch (C0845bh.f12084a[i - 1]) {
            case 1:
                return new zzbnm();
            case 2:
                return new zza(c0845bh);
            case 3:
                return zzbrd.zza(zzfhx, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzfea", "zzfhw"});
            case 4:
                return zzfhx;
            case 5:
                zzbsw<zzbnm> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbnm.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfhx);
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
