package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* compiled from: SquareOrientedFrameLayout.java */
/* loaded from: classes.dex */
class u extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowManager f3285a;
    final /* synthetic */ SquareOrientedFrameLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(SquareOrientedFrameLayout squareOrientedFrameLayout, Context context, int i, WindowManager windowManager) {
        super(context, i);
        this.b = squareOrientedFrameLayout;
        this.f3285a = windowManager;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (i != -1) {
            i2 = this.b.c;
            if (i2 != -1) {
                i5 = this.b.c;
                int abs = Math.abs((i5 + 360) - i);
                i6 = this.b.c;
                if (Math.min(abs, Math.abs(i6 - i)) < 15) {
                    return;
                }
            }
            int i8 = (((i + 45) / 90) % 4) * 90;
            i3 = this.b.b;
            if (i3 != i8) {
                this.b.b = i8;
                this.b.c = i;
                switch (this.f3285a.getDefaultDisplay().getRotation()) {
                    case 1:
                        i7 = 90;
                        break;
                    case 2:
                        i7 = 180;
                        break;
                    case 3:
                        i7 = 270;
                        break;
                }
                i4 = this.b.b;
                this.b.setRotation((-i7) - i4);
            }
        }
    }
}
