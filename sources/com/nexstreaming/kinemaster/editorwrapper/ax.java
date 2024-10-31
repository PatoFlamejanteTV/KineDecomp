package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class ax implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3325a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Task c;
    final /* synthetic */ VideoEditor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(VideoEditor videoEditor, int i, boolean z, Task task) {
        this.d = videoEditor;
        this.f3325a = i;
        this.b = z;
        this.c = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.d.N().a(this.f3325a, this.b, new ay(this));
    }
}
