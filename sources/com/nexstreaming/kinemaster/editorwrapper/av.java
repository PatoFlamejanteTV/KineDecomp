package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleClipPreview.java */
/* loaded from: classes.dex */
public class av implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3323a;
    final /* synthetic */ at b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar, int i) {
        this.b = atVar;
        this.f3323a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        Task task2;
        videoEditor = this.b.f3321a;
        videoEditor.a(this.b, this.f3323a);
        this.b.f3321a = null;
        task2 = this.b.d;
        task2.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
