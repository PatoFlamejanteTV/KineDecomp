package com.nextreaming.nexeditorui;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: NexIndexableListView.java */
/* loaded from: classes.dex */
class cj extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexIndexableListView f4573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(NexIndexableListView nexIndexableListView) {
        this.f4573a = nexIndexableListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
