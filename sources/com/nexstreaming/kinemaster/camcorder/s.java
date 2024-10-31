package com.nexstreaming.kinemaster.camcorder;

import android.view.View;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderPreviewActivity f3283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f3283a = camcorderPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3283a.setResult(0);
        this.f3283a.finish();
    }
}
