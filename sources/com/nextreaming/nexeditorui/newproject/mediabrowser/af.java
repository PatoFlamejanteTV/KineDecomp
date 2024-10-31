package com.nextreaming.nexeditorui.newproject.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class af implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f4702a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MediaBrowserFragment mediaBrowserFragment, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.b = mediaBrowserFragment;
        this.f4702a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (this.f4702a.isShowing()) {
            this.f4702a.dismiss();
        }
    }
}
