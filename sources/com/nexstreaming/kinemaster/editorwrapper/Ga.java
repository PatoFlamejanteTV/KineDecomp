package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Ga implements u.a<VideoEditor.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(VideoEditor videoEditor) {
        this.f20205a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.f fVar) {
        VideoEditor.State state;
        try {
            state = this.f20205a.y;
            fVar.a(state);
        } catch (IllegalStateException unused) {
        }
    }
}
