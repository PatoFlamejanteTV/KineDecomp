package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class D implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21093a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f21094b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21095c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(VolleyNetworkService volleyNetworkService, int i, ResultTask resultTask) {
        this.f21095c = volleyNetworkService;
        this.f21093a = i;
        this.f21094b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AssetStoreAPIData$StandardRequest m;
        ResultTask c2;
        VolleyNetworkService volleyNetworkService = this.f21095c;
        m = volleyNetworkService.m();
        c2 = volleyNetworkService.c(m, this.f21093a);
        c2.onResultAvailable(new C(this)).onFailure(this.f21094b);
    }
}
