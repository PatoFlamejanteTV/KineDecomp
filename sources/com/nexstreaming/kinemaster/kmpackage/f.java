package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class f implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Theme f3450a;
    final /* synthetic */ EffectLibrary b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EffectLibrary effectLibrary, Theme theme) {
        this.b = effectLibrary;
        this.f3450a = theme;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.b.a(this.f3450a, taskError);
    }
}
