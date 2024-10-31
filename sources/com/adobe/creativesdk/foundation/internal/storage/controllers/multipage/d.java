package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetAutoFitRecyclerViewController.java */
/* loaded from: classes.dex */
public class d implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0442a f6269a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6270b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f6271c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(g gVar, C0442a c0442a, int i) {
        this.f6271c = gVar;
        this.f6269a = c0442a;
        this.f6270b = i;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        if (this.f6271c.f6277a == null || bitmapDrawable == null) {
            return;
        }
        this.f6269a.a(bitmapDrawable, this.f6270b);
        g gVar = this.f6271c;
        if (!gVar.m) {
            gVar.m = true;
            gVar.g();
        }
        g gVar2 = this.f6271c;
        gVar2.m = true;
        gVar2.j.setVisibility(4);
    }
}
