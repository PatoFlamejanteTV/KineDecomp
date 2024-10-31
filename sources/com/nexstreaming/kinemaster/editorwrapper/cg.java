package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class cg extends com.nexstreaming.app.general.util.y<VideoEditor.k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3360a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(VideoEditor videoEditor) {
        this.f3360a = videoEditor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.util.y
    public int a(VideoEditor.k kVar) {
        if (kVar.f3305a == null) {
            return 0;
        }
        return kVar.f3305a.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.util.y
    public void a(VideoEditor.k kVar, VideoEditor.k kVar2) {
        Task a2;
        if (kVar.f3305a != null) {
            this.f3360a.u = kVar2.b;
            a2 = this.f3360a.a(kVar.f3305a);
            a2.onComplete(new ch(this, kVar2));
        }
    }

    @Override // com.nexstreaming.app.general.util.y
    protected void a(boolean z, boolean z2) {
        com.nexstreaming.app.general.util.m mVar;
        mVar = this.f3360a.m;
        mVar.a((m.a) new ci(this, z, z2));
    }
}
