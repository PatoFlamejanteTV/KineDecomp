package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Sa implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20251a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20252b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sa(VideoEditor videoEditor, int i) {
        this.f20252b = videoEditor;
        this.f20251a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20252b.b(this.f20251a);
        this.f20252b.H();
    }
}
