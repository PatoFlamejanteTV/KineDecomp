package com.adobe.creativesdk.foundation.internal.utils.photoview.c;

import android.content.Context;
import android.widget.Scroller;

/* compiled from: PreGingerScroller.java */
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: a */
    private final Scroller f6894a;

    public c(Context context) {
        this.f6894a = new Scroller(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public boolean a() {
        return this.f6894a.computeScrollOffset();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public int b() {
        return this.f6894a.getCurrX();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public int c() {
        return this.f6894a.getCurrY();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public boolean d() {
        return this.f6894a.isFinished();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f6894a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public void a(boolean z) {
        this.f6894a.forceFinished(z);
    }
}
