package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Ra implements u.a<VideoEditor.h> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f20248a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20249b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(VideoEditor videoEditor, NexTimelineItem nexTimelineItem) {
        this.f20249b = videoEditor;
        this.f20248a = nexTimelineItem;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.h hVar) {
        hVar.a(this.f20248a);
    }
}
