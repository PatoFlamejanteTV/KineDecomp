package com.nexstreaming.kinemaster.integration.cloud;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* compiled from: KMCloud.java */
/* loaded from: classes.dex */
public class e implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ KMCloud f20431a;

    public e(KMCloud kMCloud) {
        this.f20431a = kMCloud;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20431a.f20424h = 0;
        KMCloud kMCloud = this.f20431a;
        kMCloud.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN;
        kMCloud.f20419c.b(kMCloud.a(), KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_CREATEFILE_FAILED, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FILE);
    }
}
