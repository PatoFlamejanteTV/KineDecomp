package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.C1784b;
import com.nexstreaming.kinemaster.mediainfo.T;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VideoLayer.java */
/* loaded from: classes.dex */
class c implements ResultTask.OnResultAvailableListener<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.r f20632a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoLayer f20633b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(VideoLayer videoLayer, NexTimelineItem.r rVar) {
        this.f20633b = videoLayer;
        this.f20632a = rVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<T> resultTask, Task.Event event, T t) {
        this.f20633b.t = false;
        this.f20633b.r = C1784b.a(t);
        this.f20632a.a(this.f20633b);
    }
}
