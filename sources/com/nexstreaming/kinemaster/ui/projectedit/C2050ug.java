package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ug, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2050ug implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22733a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2050ug(ProjectEditActivity projectEditActivity) {
        this.f22733a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22733a.ja().G();
    }
}
