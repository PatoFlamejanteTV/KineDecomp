package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.OnFontChangeListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class n implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3458a;
    final /* synthetic */ EffectLibrary b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EffectLibrary effectLibrary, Task task) {
        this.b = effectLibrary;
        this.f3458a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.b.j();
        this.b.a(OnFontChangeListener.FontEvent.SERVER_UPDATE);
        if (this.f3458a != null) {
            this.f3458a.sendFailure(taskError);
        }
    }
}
