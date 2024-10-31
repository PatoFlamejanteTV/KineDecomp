package com.adobe.creativesdk.foundation.internal.utils.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* compiled from: FroyoGestureDetector.java */
@TargetApi(8)
/* loaded from: classes.dex */
public class d extends b {
    protected final ScaleGestureDetector j;

    public d(Context context) {
        super(context);
        this.j = new ScaleGestureDetector(context, new c(this));
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.a, com.adobe.creativesdk.foundation.internal.utils.photoview.a.e
    public boolean a() {
        return this.j.isInProgress();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.b, com.adobe.creativesdk.foundation.internal.utils.photoview.a.a, com.adobe.creativesdk.foundation.internal.utils.photoview.a.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.j.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
