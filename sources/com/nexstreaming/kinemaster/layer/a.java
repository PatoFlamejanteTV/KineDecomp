package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.app.general.task.Task;

/* compiled from: VideoLayer.java */
/* loaded from: classes.dex */
class a implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoLayer f3476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(VideoLayer videoLayer) {
        this.f3476a = videoLayer;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3476a.g = false;
    }
}
