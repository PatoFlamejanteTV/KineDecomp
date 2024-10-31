package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.aq;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VideoLayer.java */
/* loaded from: classes.dex */
class b implements ResultTask.OnResultAvailableListener<aq> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.p f3477a;
    final /* synthetic */ VideoLayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VideoLayer videoLayer, NexTimelineItem.p pVar) {
        this.b = videoLayer;
        this.f3477a = pVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<aq> resultTask, Task.Event event, aq aqVar) {
        this.b.g = false;
        this.b.e = com.nexstreaming.kinemaster.mediainfo.a.a(aqVar);
        this.f3477a.a(this.b);
    }
}
