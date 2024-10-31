package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class ip implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ io f3986a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ip(io ioVar) {
        this.f3986a = ioVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        TimelineView timelineView;
        TimelineView timelineView2;
        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) this.f3986a.e.p().a((VideoEditor) this.f3986a.d);
        if (nexVideoClipItem != null) {
            this.f3986a.e.p().a((NexTimelineItem) nexVideoClipItem);
            nexVideoClipItem.setReversePath(file.getAbsolutePath());
            nexVideoClipItem.setReverseState(true);
            nexVideoClipItem.setTrimStart(this.f3986a.d.getTrimTimeEnd());
            nexVideoClipItem.setTrimEnd(this.f3986a.d.getTrimTimeStart());
            this.f3986a.e.p().a((NexTimelineItem) nexVideoClipItem);
            this.f3986a.e.p().n();
            this.f3986a.e.p().l();
            timelineView = this.f3986a.e.k;
            timelineView.invalidate();
            timelineView2 = this.f3986a.e.k;
            timelineView2.k();
        }
    }
}
