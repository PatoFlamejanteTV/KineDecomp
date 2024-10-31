package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.tg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2018tg implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2018tg(ProjectEditActivity projectEditActivity) {
        this.f22543a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22543a.ja().O();
    }
}
