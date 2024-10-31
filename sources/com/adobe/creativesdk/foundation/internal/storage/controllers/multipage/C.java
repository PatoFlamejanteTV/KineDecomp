package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/* compiled from: RecyclerListTouchListener.java */
/* loaded from: classes.dex */
public class C implements View.OnTouchListener {

    /* renamed from: a */
    private a f6259a;

    /* renamed from: b */
    GestureDetector f6260b;

    /* renamed from: c */
    ScaleGestureDetector f6261c;

    /* compiled from: RecyclerListTouchListener.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public C(Context context, a aVar) {
        this.f6259a = aVar;
        this.f6260b = new GestureDetector(context, new A(this));
        this.f6261c = new ScaleGestureDetector(context, new B(this));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != null && this.f6259a != null && this.f6260b.onTouchEvent(motionEvent)) {
            this.f6259a.a();
            return true;
        }
        if (view == null || this.f6259a == null) {
            return true;
        }
        this.f6261c.onTouchEvent(motionEvent);
        return true;
    }
}
