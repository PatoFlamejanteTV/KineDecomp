package com.nexstreaming.kinemaster.integration.cloud;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* compiled from: KMCloud.java */
/* loaded from: classes.dex */
public class f implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ KMCloud f20432a;

    public f(KMCloud kMCloud) {
        this.f20432a = kMCloud;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        KMCloud kMCloud = this.f20432a;
        kMCloud.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FILE;
        kMCloud.f20419c.a(kMCloud.a(), KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_SUCCESS, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FILE);
        this.f20432a.b(null);
    }
}
