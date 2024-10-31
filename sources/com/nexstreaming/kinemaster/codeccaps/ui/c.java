package com.nexstreaming.kinemaster.codeccaps.ui;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class c implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20124a = capabilityTestRunnerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View findViewById = this.f20124a.findViewById(R.id.logView);
        if (findViewById.getVisibility() == 0) {
            findViewById.setVisibility(8);
            return true;
        }
        findViewById.setVisibility(0);
        return true;
    }
}
