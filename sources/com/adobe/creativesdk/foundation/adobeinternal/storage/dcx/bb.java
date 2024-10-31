package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0324c.a f4320a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f4321b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f4322c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4323d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ub f4324e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ db f4325f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(db dbVar, C0324c.a aVar, C0225c c0225c, C0231f c0231f, String str, ub ubVar) {
        this.f4325f = dbVar;
        this.f4320a = aVar;
        this.f4321b = c0225c;
        this.f4322c = c0231f;
        this.f4323d = str;
        this.f4324e = ubVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4325f.f4348c.a(this.f4320a);
        this.f4325f.f4346a.a(this.f4321b, this.f4322c, this.f4323d, this.f4324e);
    }
}
