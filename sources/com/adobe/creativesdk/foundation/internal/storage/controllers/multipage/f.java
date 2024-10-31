package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.g;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeAssetAutoFitRecyclerViewController.java */
/* loaded from: classes.dex */
class f implements sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0442a f6273a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0582ma f6274b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f6275c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g.a f6276d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g.a aVar, C0442a c0442a, C0582ma c0582ma, int i) {
        this.f6276d = aVar;
        this.f6273a = c0442a;
        this.f6274b = c0582ma;
        this.f6275c = i;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        g.this.a(null, this.f6273a, this.f6274b, this.f6275c);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        g.this.a(bArr, this.f6273a, this.f6274b, this.f6275c);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        g.this.a(null, this.f6273a, this.f6274b, this.f6275c);
    }
}
