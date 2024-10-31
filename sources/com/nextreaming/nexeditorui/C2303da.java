package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexAudioClipItem.java */
/* renamed from: com.nextreaming.nexeditorui.da, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C2303da implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.mediainfo.L> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.r f24230a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f24231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2303da(NexAudioClipItem nexAudioClipItem, NexTimelineItem.r rVar) {
        this.f24231b = nexAudioClipItem;
        this.f24230a = rVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.mediainfo.L> resultTask, Task.Event event, com.nexstreaming.kinemaster.mediainfo.L l) {
        this.f24231b.o = l.a();
        this.f24231b.p = true;
        this.f24231b.q = false;
        this.f24230a.a(this.f24231b);
    }
}
