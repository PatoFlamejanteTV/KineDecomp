package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class g extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ WindowManager f19994a;

    /* renamed from: b */
    final /* synthetic */ CamcorderActivity f19995b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CamcorderActivity camcorderActivity, Context context, WindowManager windowManager) {
        super(context);
        this.f19995b = camcorderActivity;
        this.f19994a = windowManager;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i == -1) {
            return;
        }
        i2 = this.f19995b.I;
        if (i2 != -1) {
            i5 = this.f19995b.I;
            int abs = Math.abs((i5 + 360) - i);
            i6 = this.f19995b.I;
            if (Math.min(abs, Math.abs(i6 - i)) < 15) {
                return;
            }
        }
        int i7 = 90;
        int i8 = (((i + 45) / 90) % 4) * 90;
        i3 = this.f19995b.H;
        if (i3 != i8) {
            this.f19995b.H = i8;
            this.f19995b.I = i;
            int rotation = this.f19994a.getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation == 2) {
                        i7 = 180;
                    } else if (rotation == 3) {
                        i7 = 270;
                    }
                }
                i4 = this.f19995b.H;
                this.f19995b.e((((-i7) - i4) + 360) % 360);
            }
            i7 = 0;
            i4 = this.f19995b.H;
            this.f19995b.e((((-i7) - i4) + 360) % 360);
        }
    }
}
