package com.facebook.internal;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class ai implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebDialog f287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WebDialog webDialog) {
        this.f287a = webDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!view.hasFocus()) {
            view.requestFocus();
            return false;
        }
        return false;
    }
}
