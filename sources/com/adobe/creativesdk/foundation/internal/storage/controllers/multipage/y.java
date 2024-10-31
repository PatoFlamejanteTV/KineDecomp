package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerItemClickListener.java */
/* loaded from: classes.dex */
public class y extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f6338a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f6339b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(z zVar, RecyclerView recyclerView) {
        this.f6339b = zVar;
        this.f6338a = recyclerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        z.a aVar;
        z.a aVar2;
        View findChildViewUnder = this.f6338a.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder != null) {
            aVar = this.f6339b.f6340a;
            if (aVar != null) {
                aVar2 = this.f6339b.f6340a;
                aVar2.b(findChildViewUnder, this.f6338a.getChildPosition(findChildViewUnder));
            }
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
