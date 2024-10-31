package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.AbstractC2022c;

/* compiled from: NexAudioClipItem.java */
/* renamed from: com.nextreaming.nexeditorui.ga, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C2309ga extends AbstractC2022c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f24284a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2309ga(NexAudioClipItem nexAudioClipItem) {
        this.f24284a = nexAudioClipItem;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.AbstractC2022c
    protected ResultTask a(Object obj) {
        return MediaInfo.a(obj.toString()).A();
    }
}
