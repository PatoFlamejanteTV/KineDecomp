package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.cc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0371cc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5974a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0415hc f5975b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0371cc(C0415hc c0415hc, int i) {
        this.f5975b = c0415hc;
        this.f5974a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (this.f5974a == 0 || this.f5975b.f6104c.a().isPrivateCloud()) {
            textView = this.f5975b.ha;
            textView.setVisibility(4);
            return;
        }
        textView2 = this.f5975b.ha;
        textView2.setVisibility(0);
        textView3 = this.f5975b.ha;
        textView3.setText("" + this.f5974a);
    }
}
