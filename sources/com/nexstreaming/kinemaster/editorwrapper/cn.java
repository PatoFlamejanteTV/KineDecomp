package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class cn implements m.a<VideoEditor.g> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(VideoEditor videoEditor) {
        this.f3367a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(VideoEditor.g gVar) {
        int i;
        int i2;
        i = this.f3367a.u;
        i2 = this.f3367a.v;
        gVar.a(i, i2);
    }
}
