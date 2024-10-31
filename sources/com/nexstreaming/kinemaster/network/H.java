package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class H implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(VolleyNetworkService volleyNetworkService) {
        this.f21101a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean a2;
        Task task2;
        this.f21101a.m = false;
        a2 = this.f21101a.a(taskError);
        if (a2) {
            return;
        }
        task2 = this.f21101a.k;
        task2.sendFailure(taskError);
    }
}
