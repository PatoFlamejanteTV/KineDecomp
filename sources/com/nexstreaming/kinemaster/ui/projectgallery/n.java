package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class n implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.f4215a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        eVar = this.f4215a.h;
        eVar.dismiss();
        this.f4215a.a(Task.Event.FAIL, R.string.theme_download_server_connection_failure, R.string.theme_download_server_connection_error);
    }
}
