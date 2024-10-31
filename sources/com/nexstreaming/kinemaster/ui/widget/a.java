package com.nexstreaming.kinemaster.ui.widget;

import android.view.MotionEvent;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.n;

/* compiled from: DurationSpinner.java */
/* loaded from: classes.dex */
class a implements n.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DurationSpinner f4384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DurationSpinner durationSpinner) {
        this.f4384a = durationSpinner;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean a(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public void b(MotionEvent motionEvent) {
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean c(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int minScrollX;
        int maxScrollX;
        float f3;
        this.f4384a.u = true;
        DurationSpinner durationSpinner = this.f4384a;
        minScrollX = this.f4384a.getMinScrollX();
        maxScrollX = this.f4384a.getMaxScrollX();
        f3 = this.f4384a.d;
        durationSpinner.d = Math.max(minScrollX, Math.min(maxScrollX, f3 + f));
        this.f4384a.invalidate();
        return true;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public void d(MotionEvent motionEvent) {
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean b(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Scroller scroller;
        float f3;
        int minScrollX;
        int maxScrollX;
        Scroller scroller2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Scroller scroller3;
        this.f4384a.u = false;
        scroller = this.f4384a.r;
        f3 = this.f4384a.d;
        minScrollX = this.f4384a.getMinScrollX();
        maxScrollX = this.f4384a.getMaxScrollX();
        scroller.fling((int) f3, 0, (int) (-f), 0, minScrollX, maxScrollX, 0, 0);
        scroller2 = this.f4384a.r;
        float finalX = scroller2.getFinalX();
        f4 = this.f4384a.e;
        f5 = this.f4384a.k;
        float f9 = finalX + (f5 / 2.0f);
        f6 = this.f4384a.k;
        float f10 = (((int) (f9 / f6)) * 0.125f) + f4;
        f7 = this.f4384a.e;
        float f11 = (f10 - f7) / 0.125f;
        f8 = this.f4384a.k;
        float f12 = f11 * f8;
        scroller3 = this.f4384a.r;
        scroller3.setFinalX((int) f12);
        this.f4384a.postInvalidateOnAnimation();
        return false;
    }
}
