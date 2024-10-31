package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* renamed from: com.nextreaming.nexvideoeditor.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2371w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2371w(NexEditorEventListener nexEditorEventListener) {
        this.f24745a = nexEditorEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        NexEditor.PlayState playState;
        ha haVar2;
        haVar = this.f24745a.f24607d;
        if (haVar != null) {
            haVar2 = this.f24745a.f24607d;
            haVar2.c(NexEditor.b.f24591b);
        }
        if (this.f24745a.f24606c != null) {
            this.f24745a.f24606c.b(NexEditor.b.f24591b);
        }
        NexEditorEventListener nexEditorEventListener = this.f24745a;
        playState = nexEditorEventListener.f24609f;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
