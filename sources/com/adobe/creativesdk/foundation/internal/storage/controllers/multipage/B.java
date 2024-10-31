package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.view.ScaleGestureDetector;
import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.C;

/* compiled from: RecyclerListTouchListener.java */
/* loaded from: classes.dex */
public class B implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a */
    final /* synthetic */ C f6258a;

    public B(C c2) {
        this.f6258a = c2;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        C.a aVar;
        aVar = this.f6258a.f6259a;
        aVar.a();
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
