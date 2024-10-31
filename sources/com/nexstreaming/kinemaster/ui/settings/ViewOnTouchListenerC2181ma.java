package com.nexstreaming.kinemaster.ui.settings;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ma */
/* loaded from: classes2.dex */
public class ViewOnTouchListenerC2181ma implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C2202xa f23166a;

    public ViewOnTouchListenerC2181ma(C2202xa c2202xa) {
        this.f23166a = c2202xa;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f23166a.m(view.getId());
        return true;
    }
}
