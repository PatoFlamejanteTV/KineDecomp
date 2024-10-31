package com.nexstreaming.kinemaster.ui.widget;

import android.view.MotionEvent;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.v;

/* compiled from: ValueSpinner.java */
/* loaded from: classes2.dex */
class v implements v.c {

    /* renamed from: a */
    final /* synthetic */ ValueSpinner f23891a;

    public v(ValueSpinner valueSpinner) {
        this.f23891a = valueSpinner;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        Scroller scroller;
        float f4;
        int minScrollX;
        int maxScrollX;
        Scroller scroller2;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        Scroller scroller3;
        this.f23891a.t = false;
        scroller = this.f23891a.q;
        f4 = this.f23891a.f23839c;
        minScrollX = this.f23891a.getMinScrollX();
        maxScrollX = this.f23891a.getMaxScrollX();
        scroller.fling((int) f4, 0, (int) (-f2), 0, minScrollX, maxScrollX, 0, 0);
        scroller2 = this.f23891a.q;
        float finalX = scroller2.getFinalX();
        f5 = this.f23891a.f23841e;
        f6 = this.f23891a.j;
        float f12 = finalX + (f6 / 2.0f);
        f7 = this.f23891a.j;
        float f13 = (int) (f12 / f7);
        f8 = this.f23891a.f23840d;
        float f14 = f5 + (f13 * f8);
        f9 = this.f23891a.f23841e;
        float f15 = f14 - f9;
        f10 = this.f23891a.f23840d;
        float f16 = f15 / f10;
        f11 = this.f23891a.j;
        float f17 = f16 * f11;
        scroller3 = this.f23891a.q;
        scroller3.setFinalX((int) f17);
        this.f23891a.postInvalidateOnAnimation();
        return false;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        int minScrollX;
        int maxScrollX;
        float f4;
        this.f23891a.t = true;
        ValueSpinner valueSpinner = this.f23891a;
        minScrollX = valueSpinner.getMinScrollX();
        maxScrollX = this.f23891a.getMaxScrollX();
        f4 = this.f23891a.f23839c;
        valueSpinner.f23839c = Math.max(minScrollX, Math.min(maxScrollX, f4 + f2));
        this.f23891a.invalidate();
        return true;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
