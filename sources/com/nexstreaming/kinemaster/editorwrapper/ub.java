package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class ub implements u.a<VideoEditor.g> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ub(VideoEditor videoEditor) {
        this.f20367a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.g gVar) {
        int i;
        int i2;
        i = this.f20367a.v;
        i2 = this.f20367a.w;
        gVar.a(i, i2);
    }
}
