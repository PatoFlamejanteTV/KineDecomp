package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f;
import com.adobe.creativesdk.foundation.internal.utils.photoview.g;

/* compiled from: AdobeAssetOneUpBaseCellView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0378e implements g.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0402f f6012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0378e(C0402f c0402f) {
        this.f6012a = c0402f;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.g.d
    public void a(View view, float f2, float f3) {
        C0402f.a aVar = this.f6012a.j;
        if (aVar == null || aVar.a(f2, f3) || this.f6012a.i.a().c() == null) {
            return;
        }
        this.f6012a.i.a().c().e();
    }
}
