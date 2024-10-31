package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class _a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0324c.a f4296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f4297b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f4298c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4299d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ tb f4300e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ db f4301f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _a(db dbVar, C0324c.a aVar, C0225c c0225c, C0231f c0231f, String str, tb tbVar) {
        this.f4301f = dbVar;
        this.f4296a = aVar;
        this.f4297b = c0225c;
        this.f4298c = c0231f;
        this.f4299d = str;
        this.f4300e = tbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4301f.f4348c.a(this.f4296a);
        this.f4301f.f4346a.a(this.f4297b, this.f4298c, this.f4299d, this.f4300e);
    }
}
