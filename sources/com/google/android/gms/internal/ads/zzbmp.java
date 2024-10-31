package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
public final class zzbmp extends zzbrd<zzbmp, zza> implements zzbsn {
    private static volatile zzbsw<zzbmp> zzcas;
    private static final zzbmp zzfgf = new zzbmp();
    private int zzfea;
    private zzbpu zzfei = zzbpu.zzfli;
    private zzbmt zzfge;

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbmp, zza> implements zzbsn {
        private zza() {
            super(zzbmp.zzfgf);
        }

        public final zza zzaf(zzbpu zzbpuVar) {
            zzamw();
            ((zzbmp) this.zzfpy).zzk(zzbpuVar);
            return this;
        }

        public final zza zzc(zzbmt zzbmtVar) {
            zzamw();
            ((zzbmp) this.zzfpy).zzb(zzbmtVar);
            return this;
        }

        public final zza zzdu(int i) {
            zzamw();
            ((zzbmp) this.zzfpy).setVersion(0);
            return this;
        }

        /* synthetic */ zza(Qg qg) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbmp>) zzbmp.class, zzfgf);
    }

    private zzbmp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzfea = i;
    }

    public static zzbmp zzae(zzbpu zzbpuVar) throws zzbrl {
        return (zzbmp) zzbrd.zza(zzfgf, zzbpuVar);
    }

    public static zza zzahx() {
        return (zza) zzfgf.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    public static zzbmp zzahy() {
        return zzfgf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzbmt zzbmtVar) {
        if (zzbmtVar != null) {
            this.zzfge = zzbmtVar;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzbpu zzbpuVar) {
        if (zzbpuVar != null) {
            this.zzfei = zzbpuVar;
            return;
        }
        throw new NullPointerException();
    }

    public final int getVersion() {
        return this.zzfea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        Qg qg = null;
        switch (Qg.f11788a[i - 1]) {
            case 1:
                return new zzbmp();
            case 2:
                return new zza(qg);
            case 3:
                return zzbrd.zza(zzfgf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzfge", "zzfei"});
            case 4:
                return zzfgf;
            case 5:
                zzbsw<zzbmp> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbmp.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfgf);
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

    public final zzbpu zzagf() {
        return this.zzfei;
    }

    public final zzbmt zzahw() {
        zzbmt zzbmtVar = this.zzfge;
        return zzbmtVar == null ? zzbmt.zzaie() : zzbmtVar;
    }
}
