package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class V implements com.adobe.creativesdk.foundation.internal.storage.model.util.j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4248a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f4249b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ db f4250c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0225c f4251d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0231f f4252e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f4253f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f4254g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f4255h;
    final /* synthetic */ Ab i;
    final /* synthetic */ Ka j;
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra k;
    final /* synthetic */ C0324c l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(String str, boolean z, db dbVar, C0225c c0225c, C0231f c0231f, String str2, String str3, boolean z2, Ab ab, Ka ka, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0324c c0324c) {
        this.f4248a = str;
        this.f4249b = z;
        this.f4250c = dbVar;
        this.f4251d = c0225c;
        this.f4252e = c0231f;
        this.f4253f = str2;
        this.f4254g = str3;
        this.f4255h = z2;
        this.i = ab;
        this.j = ka;
        this.k = raVar;
        this.l = c0324c;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.model.util.j
    public void a(String str) {
        if (str != null && this.f4248a.equals(str)) {
            if (this.f4249b) {
                this.f4250c.a(this.f4251d, this.f4252e, this.f4253f, this.f4254g, (AdobeCSDKException) null);
            }
            if (this.f4255h) {
                this.i.a(this.j, this.f4254g, this.f4252e, null);
                return;
            } else {
                this.i.b(this.j, this.f4254g, this.f4252e, null);
                return;
            }
        }
        new M(this.f4251d, this.f4252e, this.l, this.f4249b, this.f4250c, this.i, this.k, this.f4255h, this.f4253f).a(this.f4254g);
    }
}
