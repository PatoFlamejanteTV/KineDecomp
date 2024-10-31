package com.nexstreaming.kinemaster.codeccaps.ui;

import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class g implements CapabilityChecker.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20128a = capabilityTestRunnerActivity;
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.CapabilityChecker.b
    public void log(String str) {
        if (!str.endsWith("\n")) {
            str = str + "\n";
        }
        ((TextView) this.f20128a.findViewById(R.id.logView)).append(str);
    }
}
