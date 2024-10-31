package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.o;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeAssetOneUpRecyclerViewController.java */
/* loaded from: classes.dex */
class n implements sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f6295a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0582ma f6296b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f6297c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ o.a f6298d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o.a aVar, h hVar, C0582ma c0582ma, int i) {
        this.f6298d = aVar;
        this.f6295a = hVar;
        this.f6296b = c0582ma;
        this.f6297c = i;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        o.this.a(null, this.f6295a, this.f6296b, this.f6297c);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        o.this.a(bArr, this.f6295a, this.f6296b, this.f6297c);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        o.this.a(null, this.f6295a, this.f6296b, this.f6297c);
    }
}
