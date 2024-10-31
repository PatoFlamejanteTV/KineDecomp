package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzx extends com.google.android.gms.analytics.zzi<zzx> {
    private String category;
    private String label;
    private long value;
    private String zzup;

    public final String getAction() {
        return this.zzup;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getValue() {
        return this.value;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.category);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.zzup);
        hashMap.put("label", this.label);
        hashMap.put("value", Long.valueOf(this.value));
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzx zzxVar) {
        zzx zzxVar2 = zzxVar;
        if (!TextUtils.isEmpty(this.category)) {
            zzxVar2.category = this.category;
        }
        if (!TextUtils.isEmpty(this.zzup)) {
            zzxVar2.zzup = this.zzup;
        }
        if (!TextUtils.isEmpty(this.label)) {
            zzxVar2.label = this.label;
        }
        long j = this.value;
        if (j != 0) {
            zzxVar2.value = j;
        }
    }

    public final String zzbr() {
        return this.category;
    }
}
