package com.adobe.creativesdk.foundation.internal.utils.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

/* compiled from: EclairGestureDetector.java */
@TargetApi(5)
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: h */
    private int f6888h;
    private int i;

    public b(Context context) {
        super(context);
        this.f6888h = -1;
        this.i = 0;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.a
    float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.i);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.a
    float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.i);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.a, com.adobe.creativesdk.foundation.internal.utils.photoview.a.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f6888h = -1;
            } else if (action == 6) {
                int a2 = com.adobe.creativesdk.foundation.internal.utils.photoview.a.a(motionEvent.getAction());
                if (motionEvent.getPointerId(a2) == this.f6888h) {
                    int i = a2 != 0 ? 0 : 1;
                    this.f6888h = motionEvent.getPointerId(i);
                    this.f6882b = motionEvent.getX(i);
                    this.f6883c = motionEvent.getY(i);
                }
            }
        } else {
            this.f6888h = motionEvent.getPointerId(0);
        }
        int i2 = this.f6888h;
        if (i2 == -1) {
            i2 = 0;
        }
        this.i = motionEvent.findPointerIndex(i2);
        return super.onTouchEvent(motionEvent);
    }
}
