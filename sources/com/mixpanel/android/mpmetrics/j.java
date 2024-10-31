package com.mixpanel.android.mpmetrics;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: InAppFragment.java */
/* loaded from: classes.dex */
class j implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f3034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f3034a = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        gestureDetector = this.f3034a.f3033a.c;
        return gestureDetector.onTouchEvent(motionEvent);
    }
}
