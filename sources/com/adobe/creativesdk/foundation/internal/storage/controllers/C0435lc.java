package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0453oc;

/* compiled from: CompositionsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.lc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0435lc implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0448nc f6179a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0435lc(C0448nc c0448nc) {
        this.f6179a = c0448nc;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        if (this.f6179a.f6347b.t().equals(this.f6179a.f6348c)) {
            C0453oc.a.C0036a.a(this.f6179a.f6347b, r0.f6349d.indexOf(r0.f6346a), bitmapDrawable);
        } else {
            C0453oc.a.C0036a.a(this.f6179a.f6347b, r5.f6349d.indexOf(r5.f6346a), (BitmapDrawable) null);
        }
    }
}
