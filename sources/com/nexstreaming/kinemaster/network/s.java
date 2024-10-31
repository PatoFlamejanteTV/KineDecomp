package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class s implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21144a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f21145b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21146c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(VolleyNetworkService volleyNetworkService, int i, ResultTask resultTask) {
        this.f21146c = volleyNetworkService;
        this.f21144a = i;
        this.f21145b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AssetStoreAPIData$StandardRequest m;
        ResultTask b2;
        VolleyNetworkService volleyNetworkService = this.f21146c;
        m = volleyNetworkService.m();
        b2 = volleyNetworkService.b(m, this.f21144a);
        b2.onResultAvailable(new r(this)).onFailure(this.f21145b);
    }
}
