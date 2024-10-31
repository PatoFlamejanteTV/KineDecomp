package com.adobe.creativesdk.foundation.internal.auth;

import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* loaded from: classes.dex */
class r implements c.a.a.a.b<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4911a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4912b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0315t f4913c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C0315t c0315t, String str, String str2) {
        this.f4913c = c0315t;
        this.f4911a = str;
        this.f4912b = str2;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        this.f4913c.f4918b.a(jSONObject);
        this.f4913c.f4917a.a(this.f4911a, this.f4912b);
    }
}
