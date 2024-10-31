package com.nexstreaming.kinemaster.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/* compiled from: ProductView.java */
/* loaded from: classes.dex */
class l implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProductView f4397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ProductView productView) {
        this.f4397a = productView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Button button;
        Button button2;
        button = this.f4397a.f;
        if (button == null) {
            return false;
        }
        button2 = this.f4397a.f;
        button2.dispatchTouchEvent(motionEvent);
        return true;
    }
}
