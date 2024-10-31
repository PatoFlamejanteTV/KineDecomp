package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class N implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24580a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24581b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24581b = nexEditorEventListener;
        this.f24580a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        NexEditor.PlayState playState;
        ha haVar2;
        haVar = this.f24581b.f24607d;
        if (haVar != null) {
            haVar2 = this.f24581b.f24607d;
            haVar2.c(NexEditor.b.a(this.f24580a));
        }
        if (this.f24581b.f24606c != null) {
            this.f24581b.f24606c.b(NexEditor.b.a(this.f24580a));
        }
        NexEditorEventListener nexEditorEventListener = this.f24581b;
        playState = nexEditorEventListener.f24609f;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
