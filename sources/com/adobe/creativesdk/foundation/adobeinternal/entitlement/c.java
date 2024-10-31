package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f3970a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3971b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f3972c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f3973d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(h hVar, c.a.a.a.b bVar, JSONObject jSONObject, String str) {
        this.f3973d = hVar;
        this.f3970a = bVar;
        this.f3971b = jSONObject;
        this.f3972c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3970a.b(this.f3971b);
        this.f3973d.a(this.f3971b, this.f3972c);
    }
}
