package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerListTouchListener.java */
/* loaded from: classes.dex */
public class A extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ C f6257a;

    public A(C c2) {
        this.f6257a = c2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
