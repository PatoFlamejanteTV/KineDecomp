package com.nexstreaming.kinemaster.codeccaps.ui;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20127a = capabilityTestRunnerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CapabilityChecker capabilityChecker;
        long j;
        CapabilityChecker capabilityChecker2;
        dialogInterface.dismiss();
        capabilityChecker = this.f20127a.H;
        if (capabilityChecker != null) {
            capabilityChecker2 = this.f20127a.H;
            capabilityChecker2.b();
        }
        CapabilityTestIntroActivity.H = true;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f20127a.O;
        long j2 = currentTimeMillis - j;
        HashMap hashMap = new HashMap();
        hashMap.put("spent_time", String.valueOf(j2));
        hashMap.put("result", "cancel");
        KMEvents.DCI_ANALYSIS_RESULT.logEvent(hashMap);
        this.f20127a.finish();
    }
}
