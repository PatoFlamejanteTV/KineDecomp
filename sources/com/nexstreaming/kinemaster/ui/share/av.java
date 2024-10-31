package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class av implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f4306a;
    final /* synthetic */ Intent b;
    final /* synthetic */ ShareIntentActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ShareIntentActivity shareIntentActivity, long j, Intent intent) {
        this.c = shareIntentActivity;
        this.f4306a = j;
        this.b = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        com.nexstreaming.kinemaster.ui.a.e eVar4;
        eVar = this.c.f;
        if (eVar != null) {
            eVar2 = this.c.f;
            if (eVar2.getWindow().getDecorView().getParent() != null) {
                eVar3 = this.c.f;
                if (eVar3.isShowing()) {
                    eVar4 = this.c.f;
                    eVar4.dismiss();
                    KMUsage.Media_Indexing_End.logEvent("Activity", "ShareIntentActivity", "Duration", KMUsage.bucketParamProjectTime((int) (System.currentTimeMillis() - this.f4306a)));
                    if (this.b == null && this.b.getAction() != null) {
                        if (this.b.getAction().equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                            this.c.e(this.b);
                            return;
                        } else {
                            if (this.b.getAction().equals("android.intent.action.SEND") || this.b.getAction().equals("android.intent.action.SEND_MULTIPLE")) {
                                this.c.c(this.b);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        this.c.f = null;
        KMUsage.Media_Indexing_End.logEvent("Activity", "ShareIntentActivity", "Duration", KMUsage.bucketParamProjectTime((int) (System.currentTimeMillis() - this.f4306a)));
        if (this.b == null) {
        }
    }
}
