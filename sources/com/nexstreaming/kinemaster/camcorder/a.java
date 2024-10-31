package com.nexstreaming.kinemaster.camcorder;

import android.view.View;
import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderActivity f3265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CamcorderActivity camcorderActivity) {
        this.f3265a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ImageButton imageButton;
        boolean z2;
        CamcorderActivity camcorderActivity = this.f3265a;
        z = this.f3265a.r;
        camcorderActivity.r = !z;
        imageButton = this.f3265a.e;
        z2 = this.f3265a.r;
        imageButton.setSelected(z2);
    }
}
