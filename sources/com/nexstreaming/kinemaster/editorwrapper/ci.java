package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class ci implements m.a<VideoEditor.i> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f3362a;
    final /* synthetic */ boolean b;
    final /* synthetic */ cg c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar, boolean z, boolean z2) {
        this.c = cgVar;
        this.f3362a = z;
        this.b = z2;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(VideoEditor.i iVar) {
        iVar.a(this.f3362a, this.b);
    }
}
