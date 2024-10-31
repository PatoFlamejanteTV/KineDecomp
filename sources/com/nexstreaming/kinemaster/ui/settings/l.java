package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.ProgressBar;

/* compiled from: DeviceCapabilityInfoFragment.java */
/* loaded from: classes.dex */
class l implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f4262a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        ProgressBar progressBar;
        view2 = this.f4262a.j;
        if (view2.getVisibility() == 0) {
            progressBar = this.f4262a.i;
            if (progressBar.getVisibility() == 0) {
            }
        }
    }
}
