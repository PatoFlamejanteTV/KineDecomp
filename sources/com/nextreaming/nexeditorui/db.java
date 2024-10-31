package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.C1784b;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class db implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.mediainfo.T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.r f24232a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24233b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(NexVideoClipItem nexVideoClipItem, NexTimelineItem.r rVar) {
        this.f24233b = nexVideoClipItem;
        this.f24232a = rVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.mediainfo.T> resultTask, Task.Event event, com.nexstreaming.kinemaster.mediainfo.T t) {
        this.f24233b.k = false;
        this.f24233b.j = C1784b.a(t);
        NexTimelineItem.r rVar = this.f24232a;
        if (rVar != null) {
            NexVideoClipItem nexVideoClipItem = this.f24233b;
            rVar.a(nexVideoClipItem, nexVideoClipItem.getPrecedingTransition(), this.f24233b.getTransition());
        }
    }
}
