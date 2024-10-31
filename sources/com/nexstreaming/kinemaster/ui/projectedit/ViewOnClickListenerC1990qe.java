package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionRotateFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.qe, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1990qe implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2048ue f22487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1990qe(C2048ue c2048ue) {
        this.f22487a = c2048ue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        int rotation = this.f22487a.l.getRotation();
        z = this.f22487a.n;
        if (!z) {
            z2 = this.f22487a.m;
            if (z2) {
                this.f22487a.l.setFlipH(!r2.getFlipH());
            } else if (rotation != 90 && rotation != 270) {
                this.f22487a.l.setFlipH(!r2.getFlipH());
            } else {
                this.f22487a.l.setFlipV(!r2.getFlipV());
            }
        } else {
            this.f22487a.l.setFlipH(!r2.getFlipH());
        }
        this.f22487a.G();
    }
}
