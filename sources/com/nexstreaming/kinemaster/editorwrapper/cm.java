package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import java.io.File;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class cm implements m.a<VideoEditor.e> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cl f3366a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
        this.f3366a = clVar;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(VideoEditor.e eVar) {
        File file;
        file = this.f3366a.m.E;
        eVar.a(file);
    }
}
