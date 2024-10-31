package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class e implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f4206a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        Task task2;
        eVar = this.f4206a.b.h;
        eVar.dismiss();
        this.f4206a.b.a(Task.Event.FAIL, R.string.theme_download_server_connection_failure, R.string.theme_download_server_connection_error);
        task2 = this.f4206a.b.d;
        task2.signalEvent(Task.Event.CANCEL);
    }
}
