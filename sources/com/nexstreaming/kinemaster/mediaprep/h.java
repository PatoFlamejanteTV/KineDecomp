package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class h implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f20797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.f20797a = iVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        k kVar = this.f20797a.f20799b.f20800a;
        kVar.f20804d.a(kVar.f20801a, kVar.f20803c, kVar.f20802b.getAbsolutePath());
    }
}
