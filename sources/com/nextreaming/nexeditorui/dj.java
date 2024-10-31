package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class dj implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.mediainfo.aq> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.p f4599a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(NexVideoClipItem nexVideoClipItem, NexTimelineItem.p pVar) {
        this.b = nexVideoClipItem;
        this.f4599a = pVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.mediainfo.aq> resultTask, Task.Event event, com.nexstreaming.kinemaster.mediainfo.aq aqVar) {
        this.b.i = false;
        this.b.h = com.nexstreaming.kinemaster.mediainfo.a.a(aqVar);
        if (this.f4599a != null) {
            this.f4599a.a(this.b, this.b.getPrecedingTransition(), this.b.getTransition());
        }
    }
}
