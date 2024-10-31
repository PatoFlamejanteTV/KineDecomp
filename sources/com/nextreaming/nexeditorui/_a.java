package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.AbstractC2022c;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class _a extends AbstractC2022c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24198a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _a(NexVideoClipItem nexVideoClipItem) {
        this.f24198a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.AbstractC2022c
    protected ResultTask a(Object obj) {
        return MediaInfo.a(obj.toString()).H();
    }
}
