package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbbl;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbcb;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.ads.internal.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0776b implements zzbbl {

    /* renamed from: a, reason: collision with root package name */
    static final zzbbl f10023a = new C0776b();

    private C0776b() {
    }

    @Override // com.google.android.gms.internal.ads.zzbbl
    public final zzbcb zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzbv.i().zzyq().zzdv(jSONObject.getString("appSettingsJson"));
        }
        return zzbbq.zzm(null);
    }
}
