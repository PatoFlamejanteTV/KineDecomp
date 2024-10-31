package com.nexstreaming.kinemaster.camcorder;

import android.view.View;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderPreviewActivity f20010a;

    public u(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f20010a = camcorderPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f20010a.setResult(0);
        this.f20010a.finish();
    }
}
