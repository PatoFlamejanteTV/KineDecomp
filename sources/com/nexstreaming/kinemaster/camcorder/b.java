package com.nexstreaming.kinemaster.camcorder;

import android.view.View;
import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderActivity f3266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CamcorderActivity camcorderActivity) {
        this.f3266a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        boolean z;
        ImageButton imageButton2;
        ImageButton imageButton3;
        imageButton = this.f3266a.c;
        if (imageButton.isEnabled()) {
            z = this.f3266a.g;
            if (z) {
                this.f3266a.a(true);
            } else {
                this.f3266a.e();
            }
            imageButton2 = this.f3266a.c;
            imageButton2.setEnabled(false);
            imageButton3 = this.f3266a.c;
            imageButton3.postDelayed(new c(this), 2000L);
        }
    }
}
