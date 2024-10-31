package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f4845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NexEditorEventListener nexEditorEventListener) {
        this.f4845a = nexEditorEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ar arVar;
        NexEditor nexEditor;
        NexEditor.PlayState playState;
        NexEditor nexEditor2;
        ar arVar2;
        arVar = this.f4845a.b;
        if (arVar != null) {
            arVar2 = this.f4845a.b;
            arVar2.b(NexEditor.b.f4793a);
        }
        nexEditor = this.f4845a.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.f4845a.f4797a;
            nexEditor2.e(NexEditor.b.f4793a);
        }
        NexEditorEventListener nexEditorEventListener = this.f4845a;
        playState = this.f4845a.d;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
