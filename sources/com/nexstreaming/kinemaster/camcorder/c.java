package com.nexstreaming.kinemaster.camcorder;

import android.view.View;
import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f19990a;

    public c(CamcorderActivity camcorderActivity) {
        this.f19990a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        boolean z;
        ImageButton imageButton2;
        ImageButton imageButton3;
        imageButton = this.f19990a.f19971c;
        if (imageButton.isEnabled()) {
            z = this.f19990a.f19975g;
            if (!z) {
                this.f19990a.C();
            } else {
                this.f19990a.d(true);
            }
            imageButton2 = this.f19990a.f19971c;
            imageButton2.setEnabled(false);
            imageButton3 = this.f19990a.f19971c;
            imageButton3.postDelayed(new b(this), 2000L);
        }
    }
}
