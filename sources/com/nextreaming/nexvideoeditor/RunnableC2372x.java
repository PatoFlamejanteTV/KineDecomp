package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* renamed from: com.nextreaming.nexvideoeditor.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2372x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24746a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24747b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2372x(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24747b = nexEditorEventListener;
        this.f24746a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        NexEditor.PlayState playState;
        ha haVar2;
        haVar = this.f24747b.f24607d;
        if (haVar != null) {
            haVar2 = this.f24747b.f24607d;
            haVar2.c(NexEditor.b.a(this.f24746a));
        }
        if (this.f24747b.f24606c != null) {
            this.f24747b.f24606c.b(NexEditor.b.a(this.f24746a));
        }
        NexEditorEventListener nexEditorEventListener = this.f24747b;
        playState = nexEditorEventListener.f24609f;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
