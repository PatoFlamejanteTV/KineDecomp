package com.nexstreaming.kinemaster.camcorder;

import android.view.View;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderPreviewActivity f3275a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f3275a = camcorderPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3275a.b();
    }
}
