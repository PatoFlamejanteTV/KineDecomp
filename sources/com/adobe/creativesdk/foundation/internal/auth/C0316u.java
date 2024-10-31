package com.adobe.creativesdk.foundation.internal.auth;

import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0316u implements c.a.a.a.b<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4919a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4920b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0318w f4921c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0316u(C0318w c0318w, String str, String str2) {
        this.f4921c = c0318w;
        this.f4919a = str;
        this.f4920b = str2;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        this.f4921c.f4927c.a(jSONObject);
        this.f4921c.f4926b.a(this.f4919a, this.f4920b);
    }
}
