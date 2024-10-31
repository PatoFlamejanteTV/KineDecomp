package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bh implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3335a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(VideoEditor videoEditor, int i) {
        this.b = videoEditor;
        this.f3335a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.a(this.f3335a);
        this.b.n();
    }
}
