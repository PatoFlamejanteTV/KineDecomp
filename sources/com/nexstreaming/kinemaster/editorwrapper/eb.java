package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class eb implements u.a<VideoEditor.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20308a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f20309b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f20310c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ fb f20311d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(fb fbVar, int i, int i2, int i3) {
        this.f20311d = fbVar;
        this.f20308a = i;
        this.f20309b = i2;
        this.f20310c = i3;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.c cVar) {
        cVar.a(this.f20308a, this.f20309b, this.f20310c);
    }
}
