package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class co implements m.a<VideoEditor.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(VideoEditor videoEditor) {
        this.f3368a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(VideoEditor.f fVar) {
        VideoEditor.State state;
        state = this.f3368a.x;
        fVar.a(state);
    }
}
