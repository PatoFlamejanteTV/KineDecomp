package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexAudioClipItem.java */
/* loaded from: classes.dex */
public class bq implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.mediainfo.aj> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.p f4553a;
    final /* synthetic */ NexAudioClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(NexAudioClipItem nexAudioClipItem, NexTimelineItem.p pVar) {
        this.b = nexAudioClipItem;
        this.f4553a = pVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.mediainfo.aj> resultTask, Task.Event event, com.nexstreaming.kinemaster.mediainfo.aj ajVar) {
        this.b.j = ajVar.a();
        this.b.k = true;
        this.b.l = false;
        this.f4553a.a(this.b);
    }
}
