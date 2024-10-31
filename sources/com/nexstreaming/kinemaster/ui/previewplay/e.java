package com.nexstreaming.kinemaster.ui.previewplay;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PreviewPlayActivity previewPlayActivity) {
        this.f3724a = previewPlayActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        this.f3724a.e();
        PreviewPlayActivity previewPlayActivity = this.f3724a;
        z = this.f3724a.f;
        previewPlayActivity.f = !z;
        z2 = this.f3724a.f;
        if (z2) {
            this.f3724a.b().r();
        } else {
            this.f3724a.b().p();
        }
    }
}
