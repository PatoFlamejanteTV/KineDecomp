package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzac extends com.google.android.gms.analytics.zzi<zzac> {
    public String mCategory;
    public String zzvk;
    public long zzvl;
    public String zzvm;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzvk);
        hashMap.put("timeInMillis", Long.valueOf(this.zzvl));
        hashMap.put("category", this.mCategory);
        hashMap.put("label", this.zzvm);
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzac zzacVar) {
        zzac zzacVar2 = zzacVar;
        if (!TextUtils.isEmpty(this.zzvk)) {
            zzacVar2.zzvk = this.zzvk;
        }
        long j = this.zzvl;
        if (j != 0) {
            zzacVar2.zzvl = j;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzacVar2.mCategory = this.mCategory;
        }
        if (TextUtils.isEmpty(this.zzvm)) {
            return;
        }
        zzacVar2.zzvm = this.zzvm;
    }
}
