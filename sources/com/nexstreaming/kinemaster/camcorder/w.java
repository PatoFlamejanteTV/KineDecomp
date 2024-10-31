package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* compiled from: SquareOrientedFrameLayout.java */
/* loaded from: classes.dex */
class w extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ WindowManager f20012a;

    /* renamed from: b */
    final /* synthetic */ SquareOrientedFrameLayout f20013b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(SquareOrientedFrameLayout squareOrientedFrameLayout, Context context, int i, WindowManager windowManager) {
        super(context, i);
        this.f20013b = squareOrientedFrameLayout;
        this.f20012a = windowManager;
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
        i2 = this.f20013b.f19987c;
        if (i2 != -1) {
            i5 = this.f20013b.f19987c;
            int abs = Math.abs((i5 + 360) - i);
            i6 = this.f20013b.f19987c;
            if (Math.min(abs, Math.abs(i6 - i)) < 15) {
                return;
            }
        }
        int i7 = 90;
        int i8 = (((i + 45) / 90) % 4) * 90;
        i3 = this.f20013b.f19986b;
        if (i3 != i8) {
            this.f20013b.f19986b = i8;
            this.f20013b.f19987c = i;
            int rotation = this.f20012a.getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation == 2) {
                        i7 = 180;
                    } else if (rotation == 3) {
                        i7 = 270;
                    }
                }
                i4 = this.f20013b.f19986b;
                this.f20013b.setRotation((-i7) - i4);
            }
            i7 = 0;
            i4 = this.f20013b.f19986b;
            this.f20013b.setRotation((-i7) - i4);
        }
    }
}
