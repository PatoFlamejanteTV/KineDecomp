package com.nexstreaming.kinemaster.ui.previewplay;

import com.nexstreaming.app.general.task.Task;

/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
class j implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f3729a = hVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3729a.b = false;
        this.f3729a.a();
    }
}
