package com.adobe.creativesdk.foundation.internal.utils.photoview.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* compiled from: GingerScroller.java */
@TargetApi(9)
/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: a */
    protected final OverScroller f6892a;

    /* renamed from: b */
    private boolean f6893b = false;

    public a(Context context) {
        this.f6892a = new OverScroller(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public boolean a() {
        if (this.f6893b) {
            this.f6892a.computeScrollOffset();
            this.f6893b = false;
        }
        return this.f6892a.computeScrollOffset();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public int b() {
        return this.f6892a.getCurrX();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public int c() {
        return this.f6892a.getCurrY();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public boolean d() {
        return this.f6892a.isFinished();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f6892a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public void a(boolean z) {
        this.f6892a.forceFinished(z);
    }
}
