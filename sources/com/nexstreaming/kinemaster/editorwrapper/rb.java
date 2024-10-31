package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import java.io.File;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class rb implements u.a<VideoEditor.e> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sb f20354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rb(sb sbVar) {
        this.f20354a = sbVar;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.e eVar) {
        File file;
        file = this.f20354a.q.F;
        eVar.a(file);
    }
}
