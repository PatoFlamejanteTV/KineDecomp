package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.GraphResponse;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.qc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1051qc implements com.google.android.gms.ads.internal.gmsg.zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbgg f12448a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbcl f12449b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzaqt f12450c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1051qc(zzaqt zzaqtVar, zzbgg zzbggVar, zzbcl zzbclVar) {
        this.f12450c = zzaqtVar;
        this.f12448a = zzbggVar;
        this.f12449b = zzbclVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        JSONObject jSONObject;
        boolean z;
        String str;
        try {
            String str2 = (String) map.get(GraphResponse.SUCCESS_KEY);
            String str3 = (String) map.get("failure");
            if (!TextUtils.isEmpty(str3)) {
                jSONObject = new JSONObject(str3);
                z = false;
            } else {
                jSONObject = new JSONObject(str2);
                z = true;
            }
            str = this.f12450c.zzbqb;
            if (str.equals(jSONObject.optString("ads_id", ""))) {
                this.f12448a.zzb("/nativeAdPreProcess", this);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GraphResponse.SUCCESS_KEY, z);
                jSONObject2.put("json", jSONObject);
                this.f12449b.set(jSONObject2);
            }
        } catch (Throwable th) {
            zzbbd.zzb("Error while preprocessing json.", th);
            this.f12449b.setException(th);
        }
    }
}
