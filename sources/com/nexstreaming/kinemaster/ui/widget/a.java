package com.nexstreaming.kinemaster.ui.widget;

import android.support.v7.widget.ActivityChooserView;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.v;

/* compiled from: WheelScroller.java */
/* loaded from: classes2.dex */
public class A extends v.d {

    /* renamed from: a */
    final /* synthetic */ C f23710a;

    public A(C c2) {
        this.f23710a = c2;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        Scroller scroller;
        int i;
        this.f23710a.f23724e = 0;
        scroller = this.f23710a.f23723d;
        i = this.f23710a.f23724e;
        scroller.fling(0, i, 0, (int) (-f3), 0, 0, -2147483647, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.f23710a.a(0);
        return true;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return true;
    }
}
