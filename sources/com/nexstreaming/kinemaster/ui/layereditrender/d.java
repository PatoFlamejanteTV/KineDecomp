package com.nexstreaming.kinemaster.ui.layereditrender;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
class d implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ b f3716a;

    public d(b bVar) {
        this.f3716a = bVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        VideoEditor videoEditor2;
        this.f3716a.f3714a.I = false;
        videoEditor = this.f3716a.f3714a.x;
        if (videoEditor != null) {
            videoEditor2 = this.f3716a.f3714a.x;
            videoEditor2.a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
