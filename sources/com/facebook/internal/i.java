package com.facebook.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class I implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ WebDialog f9286a;

    public I(WebDialog webDialog) {
        this.f9286a = webDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }
}
