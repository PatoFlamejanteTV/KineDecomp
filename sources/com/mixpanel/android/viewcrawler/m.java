package com.mixpanel.android.viewcrawler;

import android.util.Log;
import com.mixpanel.android.mpmetrics.ab;
import com.mixpanel.android.viewcrawler.k;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewCrawler.java */
/* loaded from: classes.dex */
class m implements ab {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f3103a;
    final /* synthetic */ k.f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k.f fVar, JSONObject jSONObject) {
        this.b = fVar;
        this.f3103a = jSONObject;
    }

    @Override // com.mixpanel.android.mpmetrics.ab
    public JSONObject a(JSONObject jSONObject) {
        try {
            jSONObject.put("$experiments", this.f3103a);
        } catch (JSONException e) {
            Log.wtf("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", e);
        }
        return jSONObject;
    }
}
