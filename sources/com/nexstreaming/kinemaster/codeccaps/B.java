package com.nexstreaming.kinemaster.codeccaps;

import android.view.View;

/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class B implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    final /* synthetic */ P f20015a;

    public B(P p) {
        this.f20015a = p;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f20015a.I = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f20015a.I = false;
    }
}
