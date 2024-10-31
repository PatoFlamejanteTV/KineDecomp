package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3459a;
    final /* synthetic */ EffectLibrary b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EffectLibrary effectLibrary, Task task) {
        this.b = effectLibrary;
        this.f3459a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.a(this.f3459a);
    }
}
