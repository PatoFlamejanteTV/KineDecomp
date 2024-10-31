package com.adobe.creativesdk.foundation.internal.utils.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* compiled from: DefaultOnDoubleTapListener.java */
/* loaded from: classes.dex */
public class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a */
    private g f6890a;

    public b(g gVar) {
        a(gVar);
    }

    public void a(g gVar) {
        this.f6890a = gVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        float h2;
        g gVar = this.f6890a;
        if (gVar == null) {
            return false;
        }
        try {
            float k = gVar.k();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (k < this.f6890a.g()) {
                this.f6890a.a(this.f6890a.g(), x, y, true);
                h2 = this.f6890a.g();
            } else if (k >= this.f6890a.g() && k < this.f6890a.f()) {
                this.f6890a.a(this.f6890a.f(), x, y, true);
                h2 = this.f6890a.f();
            } else {
                this.f6890a.a(this.f6890a.h(), x, y, true);
                h2 = this.f6890a.h();
            }
            d n = this.f6890a.n();
            if (n != null) {
                n.a(h2, x, y);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF c2;
        g gVar = this.f6890a;
        if (gVar == null) {
            return false;
        }
        ImageView e2 = gVar.e();
        if (this.f6890a.i() != null && (c2 = this.f6890a.c()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (c2.contains(x, y)) {
                this.f6890a.i().a(e2, (x - c2.left) / c2.width(), (y - c2.top) / c2.height());
                return true;
            }
        }
        if (this.f6890a.j() != null) {
            this.f6890a.j().a(e2, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
