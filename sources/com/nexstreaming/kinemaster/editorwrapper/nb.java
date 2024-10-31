package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class nb implements u.a<VideoEditor.i> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f20337a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f20338b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ob f20339c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nb(ob obVar, boolean z, boolean z2) {
        this.f20339c = obVar;
        this.f20337a = z;
        this.f20338b = z2;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.i iVar) {
        iVar.a(this.f20337a, this.f20338b);
    }
}
