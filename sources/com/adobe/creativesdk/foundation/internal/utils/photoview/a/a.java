package com.adobe.creativesdk.foundation.internal.utils.photoview.a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: CupcakeGestureDetector.java */
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a */
    protected f f6881a;

    /* renamed from: b */
    float f6882b;

    /* renamed from: c */
    float f6883c;

    /* renamed from: d */
    final float f6884d;

    /* renamed from: e */
    final float f6885e;

    /* renamed from: f */
    private VelocityTracker f6886f;

    /* renamed from: g */
    private boolean f6887g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6885e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6884d = viewConfiguration.getScaledTouchSlop();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.e
    public void a(f fVar) {
        this.f6881a = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.e
    public boolean a() {
        return false;
    }

    float b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6886f = VelocityTracker.obtain();
            VelocityTracker velocityTracker2 = this.f6886f;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            } else {
                Log.i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            this.f6882b = a(motionEvent);
            this.f6883c = b(motionEvent);
            this.f6887g = false;
        } else if (action == 1) {
            if (this.f6887g && this.f6886f != null) {
                this.f6882b = a(motionEvent);
                this.f6883c = b(motionEvent);
                this.f6886f.addMovement(motionEvent);
                this.f6886f.computeCurrentVelocity(1000);
                float xVelocity = this.f6886f.getXVelocity();
                float yVelocity = this.f6886f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f6885e) {
                    this.f6881a.a(this.f6882b, this.f6883c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker3 = this.f6886f;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f6886f = null;
            }
        } else if (action == 2) {
            float a2 = a(motionEvent);
            float b2 = b(motionEvent);
            float f2 = a2 - this.f6882b;
            float f3 = b2 - this.f6883c;
            if (!this.f6887g) {
                this.f6887g = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f6884d);
            }
            if (this.f6887g) {
                this.f6881a.a(f2, f3);
                this.f6882b = a2;
                this.f6883c = b2;
                VelocityTracker velocityTracker4 = this.f6886f;
                if (velocityTracker4 != null) {
                    velocityTracker4.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f6886f) != null) {
            velocityTracker.recycle();
            this.f6886f = null;
        }
        return true;
    }

    float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }
}
