package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeOneUpMultiPageViewPagerController.java */
/* loaded from: classes.dex */
public class q implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0402f f6316a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ u f6317b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(u uVar, C0402f c0402f) {
        this.f6317b = uVar;
        this.f6316a = c0402f;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        View view;
        view = this.f6317b.j;
        if (view != null) {
            if (bitmapDrawable == null) {
                this.f6316a.e();
            } else {
                this.f6316a.a(bitmapDrawable);
            }
        }
    }
}
