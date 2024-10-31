package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class ob extends com.nexstreaming.app.general.util.M<VideoEditor.k> {
    final /* synthetic */ VideoEditor i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ob(VideoEditor videoEditor) {
        this.i = videoEditor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.util.M
    public int a(VideoEditor.k kVar) {
        byte[] bArr = kVar.f20277a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.util.M
    public void a(VideoEditor.k kVar, VideoEditor.k kVar2) {
        Task a2;
        if (kVar.f20277a == null) {
            return;
        }
        this.i.v = kVar2.f20278b;
        a2 = this.i.a(kVar.f20277a);
        a2.onComplete(new mb(this, kVar2));
    }

    @Override // com.nexstreaming.app.general.util.M
    protected void a(boolean z, boolean z2) {
        com.nexstreaming.app.general.util.u uVar;
        uVar = this.i.p;
        uVar.a((u.a) new nb(this, z, z2));
    }
}
