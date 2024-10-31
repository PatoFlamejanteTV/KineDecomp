package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: UniformTimelineLayoutManager.java */
/* loaded from: classes2.dex */
class U implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22650a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22651b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ UniformTimelineLayoutManager f22652c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(UniformTimelineLayoutManager uniformTimelineLayoutManager, VideoEditor videoEditor, NexTimelineItem nexTimelineItem) {
        this.f22652c = uniformTimelineLayoutManager;
        this.f22650a = videoEditor;
        this.f22651b = nexTimelineItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22650a.c(this.f22651b);
        this.f22650a.J();
    }
}
