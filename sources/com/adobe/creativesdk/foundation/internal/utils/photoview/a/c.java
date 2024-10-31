package com.adobe.creativesdk.foundation.internal.utils.photoview.a;

import android.view.ScaleGestureDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FroyoGestureDetector.java */
/* loaded from: classes.dex */
public class c implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a */
    final /* synthetic */ d f6889a;

    public c(d dVar) {
        this.f6889a = dVar;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.f6889a.f6881a.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}
