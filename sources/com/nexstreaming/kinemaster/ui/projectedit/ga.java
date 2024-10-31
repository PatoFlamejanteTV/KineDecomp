package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class ga implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(ez ezVar) {
        this.f3918a = ezVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean K;
        View view2;
        boolean z;
        View view3;
        float f;
        View view4;
        View view5;
        View view6;
        View view7;
        boolean z2;
        View view8;
        View view9;
        View view10;
        View view11;
        View view12;
        View view13;
        View view14;
        View view15;
        View view16;
        K = this.f3918a.K();
        if (K) {
            return false;
        }
        view2 = this.f3918a.b;
        if (view2 == null) {
            return false;
        }
        z = this.f3918a.f;
        if (!z) {
            return false;
        }
        float x = motionEvent.getX() - (view.getWidth() / 2.0f);
        float y = motionEvent.getY() - (view.getHeight() / 2.0f);
        view3 = this.f3918a.b;
        if (view3.findViewById(R.id.btn_camera).getHeight() > 0) {
            view16 = this.f3918a.b;
            f = view16.findViewById(R.id.btn_camera).getHeight() / 2.0f;
        } else {
            f = 0.0f;
        }
        view4 = this.f3918a.f3888a;
        if (view4 == null) {
            z2 = this.f3918a.d;
            if (z2) {
                if (motionEvent.getActionMasked() != 0) {
                    return false;
                }
                if (f > 0.0f && Math.pow(x, 2.0d) + Math.pow(y, 2.0d) < Math.pow(f, 2.0d)) {
                    ez ezVar = this.f3918a;
                    view15 = this.f3918a.b;
                    ezVar.f3888a = view15.findViewById(R.id.btn_camera_back);
                } else if (x > 0.0f) {
                    ez ezVar2 = this.f3918a;
                    view14 = this.f3918a.b;
                    ezVar2.f3888a = view14.findViewById(R.id.camcorder_button_holder);
                } else if (x < 0.0f) {
                    ez ezVar3 = this.f3918a;
                    view13 = this.f3918a.b;
                    ezVar3.f3888a = view13.findViewById(R.id.camera_button_holder);
                }
            } else {
                if (motionEvent.getActionMasked() != 0) {
                    return false;
                }
                if (f > 0.0f && Math.pow(x, 2.0d) + Math.pow(y, 2.0d) < Math.pow(f, 2.0d)) {
                    ez ezVar4 = this.f3918a;
                    view12 = this.f3918a.b;
                    ezVar4.f3888a = view12.findViewById(R.id.btn_camera);
                } else if ((-y) > Math.abs(x)) {
                    ez ezVar5 = this.f3918a;
                    view11 = this.f3918a.b;
                    ezVar5.f3888a = view11.findViewById(R.id.mediabrowser_button_holder);
                } else if (y > Math.abs(x)) {
                    ez ezVar6 = this.f3918a;
                    view10 = this.f3918a.b;
                    ezVar6.f3888a = view10.findViewById(R.id.voicerecord_button_holder);
                } else if ((-x) > Math.abs(y)) {
                    ez ezVar7 = this.f3918a;
                    view9 = this.f3918a.b;
                    ezVar7.f3888a = view9.findViewById(R.id.layer_button_holder);
                } else if (x > Math.abs(y)) {
                    ez ezVar8 = this.f3918a;
                    view8 = this.f3918a.b;
                    ezVar8.f3888a = view8.findViewById(R.id.audiobrowser_button_holder);
                }
            }
        }
        view5 = this.f3918a.f3888a;
        if (view5 == null) {
            return false;
        }
        view6 = this.f3918a.f3888a;
        view6.getLocationOnScreen(new int[2]);
        motionEvent.setLocation(motionEvent.getRawX() - r0[0], motionEvent.getRawY() - r0[1]);
        view7 = this.f3918a.f3888a;
        if (!view7.dispatchTouchEvent(motionEvent) || motionEvent.getActionMasked() == 1) {
            this.f3918a.f3888a = null;
        }
        return true;
    }
}
