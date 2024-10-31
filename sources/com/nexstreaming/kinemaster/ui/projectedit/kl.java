package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class kl implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4036a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kl(ProjectEditActivity projectEditActivity, Intent intent) {
        this.b = projectEditActivity;
        this.f4036a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.d(this.f4036a);
    }
}
