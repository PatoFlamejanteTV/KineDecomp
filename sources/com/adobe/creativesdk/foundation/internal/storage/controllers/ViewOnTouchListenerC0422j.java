package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetShareBaseOneUpActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC0422j implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private float f6147a;

    /* renamed from: b, reason: collision with root package name */
    private float f6148b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6149c = false;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AbstractActivityC0427k f6150d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnTouchListenerC0422j(AbstractActivityC0427k abstractActivityC0427k) {
        this.f6150d = abstractActivityC0427k;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6149c = true;
            this.f6147a = motionEvent.getX();
            this.f6148b = motionEvent.getY();
        } else if (action == 1) {
            boolean z = this.f6147a + 50.0f > motionEvent.getX() && this.f6147a - 50.0f < motionEvent.getX();
            boolean z2 = this.f6148b + 50.0f > motionEvent.getY() && this.f6148b - 50.0f < motionEvent.getY();
            if (z && z2) {
                this.f6150d.e();
            } else if (Math.abs(motionEvent.getY() - this.f6148b) > 350.0f) {
                AbstractActivityC0427k abstractActivityC0427k = this.f6150d;
                if (!abstractActivityC0427k.u && this.f6149c) {
                    this.f6149c = false;
                    abstractActivityC0427k.onBackPressed();
                } else {
                    this.f6150d.u = false;
                }
            }
        } else if (action == 2 || action != 8) {
            return false;
        }
        return false;
    }
}
