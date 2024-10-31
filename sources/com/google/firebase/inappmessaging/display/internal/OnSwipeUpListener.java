package com.google.firebase.inappmessaging.display.internal;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class OnSwipeUpListener extends GestureDetector.SimpleOnGestureListener {
    public boolean a() {
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 250.0f && motionEvent.getY() - motionEvent2.getY() > 120.0f && Math.abs(f3) > 200.0f) {
            return a();
        }
        return false;
    }
}
