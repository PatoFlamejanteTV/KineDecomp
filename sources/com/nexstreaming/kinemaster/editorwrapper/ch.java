package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class ch implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor.k f3361a;
    final /* synthetic */ cg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, VideoEditor.k kVar) {
        this.b = cgVar;
        this.f3361a = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.f3360a.a(this.f3361a.b, true);
        this.b.f3360a.d(true);
    }
}
