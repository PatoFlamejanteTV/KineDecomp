package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class Q implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f23295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(S s) {
        this.f23295a = s;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        VideoEditor videoEditor2;
        videoEditor = this.f23295a.f23298c.f23306f;
        videoEditor.a(this.f23295a.f23296a.getAbsolutePath());
        videoEditor2 = this.f23295a.f23298c.f23306f;
        videoEditor2.a(VideoEditor.ExportPass.Layers).onComplete(new P(this));
    }
}
