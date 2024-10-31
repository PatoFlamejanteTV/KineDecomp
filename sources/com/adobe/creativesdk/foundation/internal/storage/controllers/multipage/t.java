package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f;
import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.u;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeOneUpMultiPageViewPagerController.java */
/* loaded from: classes.dex */
class t implements sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0402f f6322a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0582ma f6323b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f6324c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ u.a f6325d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(u.a aVar, C0402f c0402f, C0582ma c0582ma, int i) {
        this.f6325d = aVar;
        this.f6322a = c0402f;
        this.f6323b = c0582ma;
        this.f6324c = i;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        u.this.a(null, this.f6322a, this.f6323b, this.f6324c);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        u.this.a(bArr, this.f6322a, this.f6323b, this.f6324c);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        u.this.a(null, this.f6322a, this.f6323b, this.f6324c);
    }
}
