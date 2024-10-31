package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.app.general.task.Task;

/* compiled from: VideoLayer.java */
/* loaded from: classes.dex */
class b implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoLayer f20631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VideoLayer videoLayer) {
        this.f20631a = videoLayer;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20631a.t = false;
    }
}
