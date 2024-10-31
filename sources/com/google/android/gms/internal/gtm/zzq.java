package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzq extends com.google.android.gms.analytics.zzi<zzq> {
    private String zztv;
    private String zztw;
    private String zztx;
    private String zzty;

    public final void setAppId(String str) {
        this.zztx = str;
    }

    public final void setAppInstallerId(String str) {
        this.zzty = str;
    }

    public final void setAppName(String str) {
        this.zztv = str;
    }

    public final void setAppVersion(String str) {
        this.zztw = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.zztv);
        hashMap.put("appVersion", this.zztw);
        hashMap.put("appId", this.zztx);
        hashMap.put("appInstallerId", this.zzty);
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    /* renamed from: zza */
    public final void zzb(zzq zzqVar) {
        if (!TextUtils.isEmpty(this.zztv)) {
            zzqVar.zztv = this.zztv;
        }
        if (!TextUtils.isEmpty(this.zztw)) {
            zzqVar.zztw = this.zztw;
        }
        if (!TextUtils.isEmpty(this.zztx)) {
            zzqVar.zztx = this.zztx;
        }
        if (TextUtils.isEmpty(this.zzty)) {
            return;
        }
        zzqVar.zzty = this.zzty;
    }

    public final String zzaz() {
        return this.zztv;
    }

    public final String zzba() {
        return this.zztw;
    }

    public final String zzbb() {
        return this.zztx;
    }

    public final String zzbc() {
        return this.zzty;
    }
}
