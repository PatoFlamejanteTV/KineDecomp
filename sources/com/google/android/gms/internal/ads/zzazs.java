package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzazs {
    private static zzv zzemw;
    private static final Object zzemx = new Object();

    @Deprecated
    private static final zzazy<Void> zzemy = new Qd();

    public zzazs(Context context) {
        zzbe(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    @VisibleForTesting
    private static zzv zzbe(Context context) {
        zzv zzvVar;
        zzv zzvVar2;
        synchronized (zzemx) {
            if (zzemw == null) {
                zzaan.initialize(context);
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvy)).booleanValue()) {
                    zzvVar2 = zzazm.zzbd(context);
                } else {
                    zzvVar2 = new zzv(new zzam(new File(context.getCacheDir(), "volley")), new zzaj((zzai) new zzas()));
                    zzvVar2.start();
                }
                zzemw = zzvVar2;
            }
            zzvVar = zzemw;
        }
        return zzvVar;
    }

    @Deprecated
    public final <T> zzbcb<T> zza(String str, zzazy<T> zzazyVar) {
        zzbcl zzbclVar = new zzbcl();
        zzemw.zze(new zzbaa(str, zzbclVar));
        return zzbbq.zza(zzbbq.zza(zzbclVar, new Sd(this, zzazyVar), zzayf.zzeky), Throwable.class, new Rd(this, zzazyVar), zzbcg.zzepp);
    }

    public final zzbcb<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }

    public final zzbcb<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        Vd vd = new Vd(null);
        Td td = new Td(this, str, vd);
        zzbax zzbaxVar = new zzbax(null);
        Ud ud = new Ud(this, i, str, vd, td, bArr, map, zzbaxVar);
        if (zzbax.isEnabled()) {
            try {
                zzbaxVar.zza(str, "GET", ud.getHeaders(), ud.zzh());
            } catch (zza e2) {
                zzbbd.zzeo(e2.getMessage());
            }
        }
        zzemw.zze(ud);
        return vd;
    }
}
