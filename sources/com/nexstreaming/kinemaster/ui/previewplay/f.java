package com.nexstreaming.kinemaster.ui.previewplay;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PreviewPlayActivity previewPlayActivity) {
        this.f3725a = previewPlayActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        boolean z;
        long nanoTime = System.nanoTime();
        j = this.f3725a.q;
        if ((nanoTime - j) / 1000000 >= 200) {
            z = this.f3725a.r;
            if (z) {
                this.f3725a.d();
            } else {
                this.f3725a.e();
                this.f3725a.f();
            }
        }
    }
}
