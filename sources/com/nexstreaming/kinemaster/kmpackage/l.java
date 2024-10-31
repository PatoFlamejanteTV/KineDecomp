package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class l implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLibrary f3456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EffectLibrary effectLibrary) {
        this.f3456a = effectLibrary;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Task task2;
        task2 = this.f3456a.ad;
        task2.sendFailure(taskError);
        this.f3456a.a((Task) null);
    }
}
