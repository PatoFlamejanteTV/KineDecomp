package com.nexstreaming.kinemaster.ui.widget;

import android.view.MotionEvent;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.v;

/* compiled from: DurationSpinner.java */
/* renamed from: com.nexstreaming.kinemaster.ui.widget.b */
/* loaded from: classes2.dex */
class C2294b implements v.c {

    /* renamed from: a */
    final /* synthetic */ DurationSpinner f23854a;

    public C2294b(DurationSpinner durationSpinner) {
        this.f23854a = durationSpinner;
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
        Scroller scroller3;
        this.f23854a.t = false;
        scroller = this.f23854a.q;
        f4 = this.f23854a.f23744c;
        minScrollX = this.f23854a.getMinScrollX();
        maxScrollX = this.f23854a.getMaxScrollX();
        scroller.fling((int) f4, 0, (int) (-f2), 0, minScrollX, maxScrollX, 0, 0);
        scroller2 = this.f23854a.q;
        float finalX = scroller2.getFinalX();
        f5 = this.f23854a.f23745d;
        f6 = this.f23854a.j;
        float f10 = finalX + (f6 / 2.0f);
        f7 = this.f23854a.j;
        float f11 = f5 + (((int) (f10 / f7)) * 0.1f);
        f8 = this.f23854a.f23745d;
        float f12 = (f11 - f8) / 0.1f;
        f9 = this.f23854a.j;
        float f13 = f12 * f9;
        scroller3 = this.f23854a.q;
        scroller3.setFinalX((int) f13);
        this.f23854a.postInvalidateOnAnimation();
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
        this.f23854a.t = true;
        DurationSpinner durationSpinner = this.f23854a;
        minScrollX = durationSpinner.getMinScrollX();
        maxScrollX = this.f23854a.getMaxScrollX();
        f4 = this.f23854a.f23744c;
        durationSpinner.f23744c = Math.max(minScrollX, Math.min(maxScrollX, f4 + f2));
        this.f23854a.invalidate();
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
