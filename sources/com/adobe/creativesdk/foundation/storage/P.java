package com.adobe.creativesdk.foundation.storage;

import org.json.JSONObject;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
class P implements c.a.a.a.b<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f7084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(S s) {
        this.f7084a = s;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        this.f7084a.f7108b.hlsHref = jSONObject.optString("hls_playlist", null);
        this.f7084a.f7108b._videDuration = jSONObject.optInt("duration", 0);
    }
}
