package com.nexstreaming.kinemaster.camcorder;

import android.view.View;
import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f19988a;

    public a(CamcorderActivity camcorderActivity) {
        this.f19988a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ImageButton imageButton;
        boolean z2;
        CamcorderActivity camcorderActivity = this.f19988a;
        z = camcorderActivity.r;
        camcorderActivity.r = !z;
        imageButton = this.f19988a.f19973e;
        z2 = this.f19988a.r;
        imageButton.setSelected(z2);
    }
}
