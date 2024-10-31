package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class A implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(NexEditorEventListener nexEditorEventListener) {
        this.f24419a = nexEditorEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        NexEditor.PlayState playState;
        ha haVar2;
        haVar = this.f24419a.f24607d;
        if (haVar != null) {
            haVar2 = this.f24419a.f24607d;
            haVar2.a();
        }
        NexEditorEventListener nexEditorEventListener = this.f24419a;
        playState = nexEditorEventListener.f24609f;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
