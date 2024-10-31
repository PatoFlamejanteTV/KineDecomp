package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class z implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VolleyNetworkService volleyNetworkService) {
        this.f21156a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AssetStoreAPIData$StandardRequest m;
        ResultTask b2;
        ResultTask resultTask;
        VolleyNetworkService volleyNetworkService = this.f21156a;
        m = volleyNetworkService.m();
        b2 = volleyNetworkService.b(m);
        ResultTask onResultAvailable = b2.onResultAvailable(new y(this));
        resultTask = this.f21156a.w;
        onResultAvailable.onFailure(resultTask);
    }
}
