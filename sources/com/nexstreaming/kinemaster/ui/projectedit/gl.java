package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: OptionRotateFragment.java */
/* loaded from: classes.dex */
class gl implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gj f3929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(gj gjVar) {
        this.f3929a = gjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        KMUsage.EditScreen_FlipRotate.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "mirror_v");
        int rotation = this.f3929a.f3927a.getRotation();
        z = this.f3929a.c;
        if (!z) {
            z2 = this.f3929a.b;
            if (z2) {
                this.f3929a.f3927a.setFlipV(this.f3929a.f3927a.getFlipV() ? false : true);
            } else if (rotation == 90 || rotation == 270) {
                this.f3929a.f3927a.setFlipH(this.f3929a.f3927a.getFlipH() ? false : true);
            } else {
                this.f3929a.f3927a.setFlipV(this.f3929a.f3927a.getFlipV() ? false : true);
            }
        } else {
            this.f3929a.f3927a.setFlipH(this.f3929a.f3927a.getFlipH() ? false : true);
        }
        this.f3929a.d();
    }
}
