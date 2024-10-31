package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionRotateFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.se, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2007se implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2048ue f22521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2007se(C2048ue c2048ue) {
        this.f22521a = c2048ue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.f22521a.m;
        this.f22521a.l.setRotation(!z ? (this.f22521a.l.getRotation() + 90) % 360 : -90);
        this.f22521a.G();
    }
}
