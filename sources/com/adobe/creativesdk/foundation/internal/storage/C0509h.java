package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFileInternal.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0509h implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f6585a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.e f6586b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ sd f6587c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f6588d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0509h(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, sd sdVar, ra raVar) {
        this.f6585a = fVar;
        this.f6586b = eVar;
        this.f6587c = sdVar;
        this.f6588d = raVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 201 && g2 != 200 && g2 != 204) {
            ra raVar = this.f6588d;
            this.f6587c.a((sd) ra.a(lVar));
            return;
        }
        try {
            Map<String, List<String>> e2 = lVar.e();
            if (e2 != null) {
                if (e2.containsKey("etag")) {
                    this.f6585a.f6613e = e2.get("etag").get(0);
                }
                if (e2.containsKey("x-latest-version")) {
                    this.f6585a.e(e2.get("x-latest-version").get(0));
                }
                if (e2.containsKey("content-md5")) {
                    this.f6585a.c(e2.get("content-md5").get(0));
                }
                if (e2.containsKey("x-resource-id")) {
                    this.f6585a.f6609a = e2.get("x-resource-id").get(0);
                }
                if (e2.containsKey("date")) {
                    this.f6585a.f6615g = e2.get("date").get(0);
                }
            }
            if (lVar.d() != null) {
                JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(lVar.d());
                if (a2 != null) {
                    this.f6585a.f6609a = a2.getString("id");
                    this.f6585a.a(Integer.valueOf(a2.getInt("size")));
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
                    this.f6585a.a(jSONObject);
                }
            } else if (lVar.b() != 0) {
                this.f6585a.a(Integer.valueOf(lVar.b()));
            }
        } catch (JSONException unused) {
        }
        this.f6587c.b(new AdobeAssetFileInternal(this.f6585a, this.f6586b));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        ra raVar = this.f6588d;
        this.f6587c.a((sd) ra.a(adobeNetworkException));
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f6587c.a(d2);
    }
}
