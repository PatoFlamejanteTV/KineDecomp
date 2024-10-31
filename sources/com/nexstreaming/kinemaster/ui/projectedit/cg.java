package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
public class cg implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ce f3814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(ce ceVar) {
        this.f3814a = ceVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3814a.f = false;
        this.f3814a.g = false;
        this.f3814a.a(true);
        this.f3814a.h();
    }
}
