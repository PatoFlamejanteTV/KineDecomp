package com.adobe.creativesdk.foundation.internal.auth;

import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.m */
/* loaded from: classes.dex */
class C0309m implements c.a.a.a.b<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ String f4899a;

    /* renamed from: b */
    final /* synthetic */ String f4900b;

    /* renamed from: c */
    final /* synthetic */ C0311o f4901c;

    public C0309m(C0311o c0311o, String str, String str2) {
        this.f4901c = c0311o;
        this.f4899a = str;
        this.f4900b = str2;
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(JSONObject jSONObject) {
        this.f4901c.f4905a.a(this.f4899a, this.f4900b);
    }
}
