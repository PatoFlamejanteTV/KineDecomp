package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzf;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzakg<I, O> implements zzajv<I, O> {
    private final zzait zzdkg;
    private final zzajx<O> zzdkh;
    private final zzajy<I> zzdki;
    private final String zzdkj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakg(zzait zzaitVar, String str, zzajy<I> zzajyVar, zzajx<O> zzajxVar) {
        this.zzdkg = zzaitVar;
        this.zzdkj = str;
        this.zzdki = zzajyVar;
        this.zzdkh = zzajxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzaji zzajiVar, zzajr zzajrVar, I i, zzbcl<O> zzbclVar) {
        try {
            com.google.android.gms.ads.internal.zzbv.e();
            String zzzs = zzayh.zzzs();
            zzf.o.a(zzzs, new C0897fb(this, zzajiVar, zzbclVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzzs);
            jSONObject.put("args", this.zzdki.zzk(i));
            zzajrVar.zzb(this.zzdkj, jSONObject);
        } catch (Exception e2) {
            try {
                zzbclVar.setException(e2);
                zzbbd.zzb("Unable to invokeJavaScript", e2);
            } finally {
                zzajiVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbl
    public final zzbcb<O> zzf(@Nullable I i) throws Exception {
        return zzj(i);
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final zzbcb<O> zzj(I i) {
        zzbcl zzbclVar = new zzbcl();
        zzaji zzb = this.zzdkg.zzb((zzcu) null);
        zzb.zza(new C0869db(this, zzb, i, zzbclVar), new C0883eb(this, zzbclVar, zzb));
        return zzbclVar;
    }
}
