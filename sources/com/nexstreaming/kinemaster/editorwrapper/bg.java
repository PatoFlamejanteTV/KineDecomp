package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bg implements m.a<VideoEditor.h> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f3334a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(VideoEditor videoEditor, NexTimelineItem nexTimelineItem) {
        this.b = videoEditor;
        this.f3334a = nexTimelineItem;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(VideoEditor.h hVar) {
        hVar.a(this.f3334a);
    }
}
