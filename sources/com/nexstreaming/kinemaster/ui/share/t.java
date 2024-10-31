package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class t implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f4364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f4364a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4364a.b.e();
    }
}
