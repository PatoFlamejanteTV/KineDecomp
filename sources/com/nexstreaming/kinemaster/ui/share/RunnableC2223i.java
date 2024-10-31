package com.nexstreaming.kinemaster.ui.share;

import android.widget.LinearLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC2223i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2223i(ExportAndShareActivity exportAndShareActivity) {
        this.f23354a = exportAndShareActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        linearLayout = this.f23354a.X;
        linearLayout.setVisibility(4);
    }
}
