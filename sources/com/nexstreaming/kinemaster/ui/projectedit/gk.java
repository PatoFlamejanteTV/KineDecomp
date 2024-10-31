package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: OptionRotateFragment.java */
/* loaded from: classes.dex */
class gk implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gj f3928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(gj gjVar) {
        this.f3928a = gjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        KMUsage.EditScreen_FlipRotate.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "mirror_h");
        int rotation = this.f3928a.f3927a.getRotation();
        z = this.f3928a.c;
        if (!z) {
            z2 = this.f3928a.b;
            if (z2) {
                this.f3928a.f3927a.setFlipH(this.f3928a.f3927a.getFlipH() ? false : true);
            } else if (rotation == 90 || rotation == 270) {
                this.f3928a.f3927a.setFlipV(this.f3928a.f3927a.getFlipV() ? false : true);
            } else {
                this.f3928a.f3927a.setFlipH(this.f3928a.f3927a.getFlipH() ? false : true);
            }
        } else {
            this.f3928a.f3927a.setFlipV(this.f3928a.f3927a.getFlipV() ? false : true);
        }
        this.f3928a.d();
    }
}
