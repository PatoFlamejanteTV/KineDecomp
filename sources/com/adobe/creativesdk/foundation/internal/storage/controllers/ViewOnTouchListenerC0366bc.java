package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.bc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC0366bc implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc f5960a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnTouchListenerC0366bc(C0415hc c0415hc) {
        this.f5960a = c0415hc;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 1) {
            return false;
        }
        this.f5960a.Ga.setVisibility(4);
        this.f5960a.Ba.d();
        return true;
    }
}
