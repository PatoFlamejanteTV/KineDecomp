package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: RecyclerItemClickListener.java */
/* loaded from: classes.dex */
public class z implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private a f6340a;

    /* renamed from: b, reason: collision with root package name */
    GestureDetector f6341b;

    /* compiled from: RecyclerItemClickListener.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(View view, int i);

        void b(View view, int i);
    }

    public z(Context context, RecyclerView recyclerView, a aVar) {
        this.f6340a = aVar;
        this.f6341b = new GestureDetector(context, new y(this, recyclerView));
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder == null || this.f6340a == null || !this.f6341b.onTouchEvent(motionEvent)) {
            return false;
        }
        this.f6340a.a(findChildViewUnder, recyclerView.getChildPosition(findChildViewUnder));
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
