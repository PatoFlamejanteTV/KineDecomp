package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class mb implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor.k f20333a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ob f20334b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mb(ob obVar, VideoEditor.k kVar) {
        this.f20334b = obVar;
        this.f20333a = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20334b.i.a(this.f20333a.f20278b, true);
        this.f20334b.i.d(true);
    }
}
