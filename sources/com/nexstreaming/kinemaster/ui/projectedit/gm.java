package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: OptionRotateFragment.java */
/* loaded from: classes.dex */
class gm implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gj f3930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gm(gj gjVar) {
        this.f3930a = gjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        KMUsage.EditScreen_FlipRotate.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "rotate_ccw");
        z = this.f3930a.b;
        if (!z) {
            i = (this.f3930a.f3927a.getRotation() + 90) % 360;
        } else {
            i = -90;
        }
        this.f3930a.f3927a.setRotation(i);
        this.f3930a.d();
    }
}
