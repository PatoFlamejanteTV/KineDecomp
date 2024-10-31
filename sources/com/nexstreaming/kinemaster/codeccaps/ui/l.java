package com.nexstreaming.kinemaster.codeccaps.ui;

import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.u;
import com.nexstreaming.kinemaster.codeccaps.z;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
public class l implements ResultTask.OnResultAvailableListener<u> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityChecker.b f20133a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20134b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(CapabilityTestRunnerActivity capabilityTestRunnerActivity, CapabilityChecker.b bVar) {
        this.f20134b = capabilityTestRunnerActivity;
        this.f20133a = bVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<u> resultTask, Task.Event event, u uVar) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        long j;
        boolean z;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        this.f20134b.M.setMax(100);
        this.f20134b.M.setProgress(100);
        this.f20134b.L = true;
        eVar = this.f20134b.K;
        if (eVar != null) {
            eVar2 = this.f20134b.K;
            if (eVar2.isShowing()) {
                eVar3 = this.f20134b.K;
                eVar3.dismiss();
            }
        }
        String stringExtra = this.f20134b.getIntent() != null ? this.f20134b.getIntent().getStringExtra("device_id") : null;
        if (this.f20134b.findViewById(R.id.logView).getVisibility() == 0) {
            if (z.e(uVar)) {
                this.f20133a.log(">> Results written to file");
            } else {
                this.f20133a.log("!!!! FILE WRITE FAILED");
            }
        }
        z.a(stringExtra);
        z.a(this.f20134b, uVar);
        z.d(uVar).onSuccess(new k(this)).onFailure(new j(this));
        CapabilityManager.f20040b.a(z.b(uVar).capabilityInfo, "Ck7", true);
        CapabilityManager.f20040b.u();
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f20134b.O;
        HashMap hashMap = new HashMap();
        hashMap.put("spent_time", String.valueOf(currentTimeMillis - j));
        hashMap.put("chipset", c.d.b.a.a.f3576b.e());
        hashMap.put("variant", String.valueOf(c.d.b.a.a.f3576b.f().h()));
        hashMap.put("codec_mem", String.valueOf(uVar.d()));
        hashMap.put("high_res", String.valueOf(uVar.m().f3592b));
        hashMap.put("layer_res", String.valueOf(NexEditorDeviceProfile.getDeviceProfile().getMaxTranscodingHeight(EditorGlobal.i().b())));
        hashMap.put("encoding_res", String.valueOf(uVar.a().f3592b));
        hashMap.put("reencoding_res", String.valueOf(uVar.l().f3592b));
        hashMap.put("encoding_high_profile", uVar.c() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("layer_max_dec", String.valueOf(uVar.p()));
        hashMap.put("result", GraphResponse.SUCCESS_KEY);
        KMEvents.DCI_ANALYSIS_RESULT.logEvent(hashMap);
        z = this.f20134b.P;
        if (!z) {
            this.f20134b.K();
        } else {
            CapabilityTestIntroActivity.H = true;
            this.f20134b.finish();
        }
    }
}
