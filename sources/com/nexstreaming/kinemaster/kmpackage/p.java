package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class p implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3460a;
    final /* synthetic */ EffectLibrary b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EffectLibrary effectLibrary, Task task) {
        this.b = effectLibrary;
        this.f3460a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3460a.sendFailure(taskError);
    }
}
