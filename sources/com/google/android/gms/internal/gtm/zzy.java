package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzy extends com.google.android.gms.analytics.zzi<zzy> {
    public String zzuq;
    public boolean zzur;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.zzuq);
        hashMap.put("fatal", Boolean.valueOf(this.zzur));
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzy zzyVar) {
        zzy zzyVar2 = zzyVar;
        if (!TextUtils.isEmpty(this.zzuq)) {
            zzyVar2.zzuq = this.zzuq;
        }
        boolean z = this.zzur;
        if (z) {
            zzyVar2.zzur = z;
        }
    }
}
