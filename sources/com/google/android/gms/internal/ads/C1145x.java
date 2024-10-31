package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.x */
/* loaded from: classes2.dex */
public final class C1145x implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {

    /* renamed from: a */
    private final /* synthetic */ zzaqp f12648a;

    /* renamed from: b */
    private final /* synthetic */ C1075s f12649b;

    public C1145x(C1075s c1075s, zzaqp zzaqpVar) {
        this.f12649b = c1075s;
        this.f12648a = zzaqpVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            str = this.f12649b.f12507b;
            jSONObject.put("id", str);
            this.f12648a.zza("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e2) {
            zzbbd.zzb("Unable to dispatch sendMessageToNativeJs event", e2);
        }
    }
}
