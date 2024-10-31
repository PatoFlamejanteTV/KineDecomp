package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbns extends zzbrd<zzbns, zza> implements zzbsn {
    private static volatile zzbsw<zzbns> zzcas;
    private static final zzbns zzfik = new zzbns();
    private int zzccg;
    private String zzfii = "";
    private zzbrk<zzbnc> zzfij = zzbrd.zzams();

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd.zza<zzbns, zza> implements zzbsn {
        private zza() {
            super(zzbns.zzfik);
        }

        public final zza zzb(zzbnc zzbncVar) {
            zzamw();
            ((zzbns) this.zzfpy).zza(zzbncVar);
            return this;
        }

        public final zza zzft(String str) {
            zzamw();
            ((zzbns) this.zzfpy).zzfs(str);
            return this;
        }

        /* synthetic */ zza(C0889eh c0889eh) {
            this();
        }
    }

    static {
        zzbrd.zza((Class<zzbns>) zzbns.class, zzfik);
    }

    private zzbns() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbnc zzbncVar) {
        if (zzbncVar != null) {
            if (!this.zzfij.zzaki()) {
                zzbrk<zzbnc> zzbrkVar = this.zzfij;
                int size = zzbrkVar.size();
                this.zzfij = zzbrkVar.zzel(size == 0 ? 10 : size << 1);
            }
            this.zzfij.add(zzbncVar);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzajw() {
        return (zza) zzfik.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfs(String str) {
        if (str != null) {
            this.zzfii = str;
            return;
        }
        throw new NullPointerException();
    }

    public final List<zzbnc> zzajv() {
        return this.zzfij;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        C0889eh c0889eh = null;
        switch (C0889eh.f12146a[i - 1]) {
            case 1:
                return new zzbns();
            case 2:
                return new zza(c0889eh);
            case 3:
                return zzbrd.zza(zzfik, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzccg", "zzfii", "zzfij", zzbnc.class});
            case 4:
                return zzfik;
            case 5:
                zzbsw<zzbns> zzbswVar = zzcas;
                if (zzbswVar == null) {
                    synchronized (zzbns.class) {
                        zzbswVar = zzcas;
                        if (zzbswVar == null) {
                            zzbswVar = new zzbrd.zzb<>(zzfik);
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
