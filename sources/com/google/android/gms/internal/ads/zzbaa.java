package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbaa extends zzr<zzp> {
    private final zzbcl<zzp> zzene;
    private final Map<String, String> zzenf;
    private final zzbax zzeng;

    public zzbaa(String str, zzbcl<zzp> zzbclVar) {
        this(str, null, zzbclVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzr
    public final zzx<zzp> zza(zzp zzpVar) {
        return zzx.zza(zzpVar, zzap.zzb(zzpVar));
    }

    private zzbaa(String str, Map<String, String> map, zzbcl<zzp> zzbclVar) {
        super(0, str, new Wd(zzbclVar));
        this.zzenf = null;
        this.zzene = zzbclVar;
        this.zzeng = new zzbax();
        this.zzeng.zza(str, "GET", null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    public final /* synthetic */ void zza(zzp zzpVar) {
        zzp zzpVar2 = zzpVar;
        this.zzeng.zza(zzpVar2.zzab, zzpVar2.statusCode);
        zzbax zzbaxVar = this.zzeng;
        byte[] bArr = zzpVar2.data;
        if (zzbax.isEnabled() && bArr != null) {
            zzbaxVar.zzi(bArr);
        }
        this.zzene.set(zzpVar2);
    }
}
