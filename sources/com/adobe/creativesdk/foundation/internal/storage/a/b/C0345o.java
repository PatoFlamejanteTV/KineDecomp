package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0345o implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f5453a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f5454b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5455c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0345o(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar) {
        this.f5455c = raVar;
        this.f5453a = fVar;
        this.f5454b = vaVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 201 && g2 != 200 && g2 != 204) {
            this.f5454b.a((va) ra.a(lVar));
            return;
        }
        try {
            Map<String, List<String>> e2 = lVar.e();
            if (e2 != null) {
                if (e2.containsKey("etag")) {
                    this.f5453a.f6613e = e2.get("etag").get(0);
                }
                if (e2.containsKey("x-latest-version")) {
                    this.f5453a.e(e2.get("x-latest-version").get(0));
                }
                if (e2.containsKey("content-md5")) {
                    this.f5453a.c(e2.get("content-md5").get(0));
                }
                if (e2.containsKey("x-resource-id")) {
                    this.f5453a.f6609a = e2.get("x-resource-id").get(0);
                }
                if (e2.containsKey("date")) {
                    this.f5453a.f6615g = e2.get("date").get(0);
                }
            }
            if (lVar.d() != null) {
                JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(lVar.d());
                if (a2 != null) {
                    this.f5453a.f6609a = a2.getString("id");
                    this.f5453a.a(Integer.valueOf(a2.getInt("size")));
                    JSONObject jSONObject = new JSONObject();
                    if (a2.has(com.umeng.analytics.pro.b.s)) {
                        jSONObject.put(com.umeng.analytics.pro.b.s, a2.getInt(com.umeng.analytics.pro.b.s));
                    }
                    if (a2.has("width")) {
                        jSONObject.put("width", a2.getInt("width"));
                    }
                    if (a2.has("height")) {
                        jSONObject.put("height", a2.getInt("height"));
                    }
                    this.f5453a.a(jSONObject);
                }
            } else if (lVar.b() != 0) {
                this.f5453a.a(Integer.valueOf(lVar.b()));
            }
        } catch (JSONException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
        }
        this.f5454b.a(this.f5453a);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f5454b.a(d2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5454b.a((va) ra.a(adobeNetworkException));
    }
}
