package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes.dex */
public class i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3970a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar, VideoEditor videoEditor) {
        this.b = eVar;
        this.f3970a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.b.isAdded()) {
            this.f3970a.r().onComplete(new k(this)).onFailure(new j(this));
        }
    }
}
