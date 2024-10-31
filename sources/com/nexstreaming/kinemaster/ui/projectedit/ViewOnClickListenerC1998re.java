package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionRotateFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.re, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1998re implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2048ue f22507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1998re(C2048ue c2048ue) {
        this.f22507a = c2048ue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        int rotation = this.f22507a.l.getRotation();
        z = this.f22507a.n;
        if (!z) {
            z2 = this.f22507a.m;
            if (z2) {
                this.f22507a.l.setFlipV(!r2.getFlipV());
            } else if (rotation != 90 && rotation != 270) {
                this.f22507a.l.setFlipV(!r2.getFlipV());
            } else {
                this.f22507a.l.setFlipH(!r2.getFlipH());
            }
        } else {
            this.f22507a.l.setFlipV(!r2.getFlipV());
        }
        this.f22507a.G();
    }
}
