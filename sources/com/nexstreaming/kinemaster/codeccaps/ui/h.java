package com.nexstreaming.kinemaster.codeccaps.ui;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class h implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20129a = capabilityTestRunnerActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        long j;
        com.nexstreaming.kinemaster.ui.a.e eVar;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f20129a.O;
        HashMap hashMap = new HashMap();
        hashMap.put("spent_time", String.valueOf(currentTimeMillis - j));
        hashMap.put("result", "error");
        KMEvents.DCI_ANALYSIS_RESULT.logEvent(hashMap);
        CapabilityTestIntroActivity.H = true;
        this.f20129a.L = true;
        eVar = this.f20129a.K;
        if (eVar != null) {
            eVar2 = this.f20129a.K;
            if (eVar2.isShowing()) {
                eVar3 = this.f20129a.K;
                eVar3.dismiss();
            }
        }
        this.f20129a.finish();
    }
}
