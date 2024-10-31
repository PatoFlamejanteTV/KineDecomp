package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetOneUpRecyclerViewController.java */
/* loaded from: classes.dex */
public class k implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f6288a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6289b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ o f6290c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(o oVar, h hVar, int i) {
        this.f6290c = oVar;
        this.f6288a = hVar;
        this.f6289b = i;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        if (this.f6290c.f6301c == null) {
            return;
        }
        if (bitmapDrawable == null) {
            this.f6288a.e();
        } else {
            this.f6288a.a(bitmapDrawable, this.f6289b);
        }
    }
}
