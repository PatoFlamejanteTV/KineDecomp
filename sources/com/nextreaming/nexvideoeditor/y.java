package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f4849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NexEditorEventListener nexEditorEventListener) {
        this.f4849a = nexEditorEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ar arVar;
        NexEditor.PlayState playState;
        ar arVar2;
        arVar = this.f4849a.b;
        if (arVar != null) {
            arVar2 = this.f4849a.b;
            arVar2.b();
        }
        NexEditorEventListener nexEditorEventListener = this.f4849a;
        playState = this.f4849a.d;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
