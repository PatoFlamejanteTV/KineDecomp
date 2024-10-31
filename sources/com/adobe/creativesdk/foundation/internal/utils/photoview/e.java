package com.adobe.creativesdk.foundation.internal.utils.photoview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public class e extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ g f6895a;

    public e(g gVar) {
        this.f6895a = gVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.f6895a.w;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.f6895a.w;
            onLongClickListener2.onLongClick(this.f6895a.e());
        }
    }
}
