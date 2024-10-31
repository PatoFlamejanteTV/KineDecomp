package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class g extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowManager f3271a;
    final /* synthetic */ CamcorderActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CamcorderActivity camcorderActivity, Context context, WindowManager windowManager) {
        super(context);
        this.b = camcorderActivity;
        this.f3271a = windowManager;
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
            i2 = this.b.I;
            if (i2 != -1) {
                i5 = this.b.I;
                int abs = Math.abs((i5 + 360) - i);
                i6 = this.b.I;
                if (Math.min(abs, Math.abs(i6 - i)) < 15) {
                    return;
                }
            }
            int i8 = (((i + 45) / 90) % 4) * 90;
            i3 = this.b.H;
            if (i3 != i8) {
                this.b.H = i8;
                this.b.I = i;
                switch (this.f3271a.getDefaultDisplay().getRotation()) {
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
                i4 = this.b.H;
                this.b.d((((-i7) - i4) + 360) % 360);
            }
        }
    }
}
