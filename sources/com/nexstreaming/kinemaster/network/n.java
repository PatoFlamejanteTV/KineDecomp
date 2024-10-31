package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class n implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21138a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VolleyNetworkService volleyNetworkService) {
        this.f21138a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Task task2;
        this.f21138a.n = false;
        task2 = this.f21138a.l;
        task2.sendFailure(taskError);
        this.f21138a.a(taskError);
    }
}
