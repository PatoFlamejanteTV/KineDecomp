package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
public class cl implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3819a;
    final /* synthetic */ ce b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ce ceVar, VideoEditor videoEditor) {
        this.b = ceVar;
        this.f3819a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3819a.p();
        this.b.f = false;
        this.b.g = false;
        this.f3819a.b(false);
        this.b.h();
        this.b.a(true);
    }
}
