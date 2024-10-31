package com.adobe.creativesdk.foundation.internal.auth;

import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.j */
/* loaded from: classes.dex */
class C0306j implements c.a.a.a.b<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ String f4891a;

    /* renamed from: b */
    final /* synthetic */ String f4892b;

    /* renamed from: c */
    final /* synthetic */ C0308l f4893c;

    public C0306j(C0308l c0308l, String str, String str2) {
        this.f4893c = c0308l;
        this.f4891a = str;
        this.f4892b = str2;
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(JSONObject jSONObject) {
        this.f4893c.f4897a.a(this.f4891a, this.f4892b);
    }
}
