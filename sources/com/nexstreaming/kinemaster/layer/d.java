package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.AbstractC2022c;

/* compiled from: VideoLayer.java */
/* loaded from: classes.dex */
class d extends AbstractC2022c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoLayer f20634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VideoLayer videoLayer) {
        this.f20634a = videoLayer;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.AbstractC2022c
    protected ResultTask a(Object obj) {
        return MediaInfo.a(obj.toString()).H();
    }
}
