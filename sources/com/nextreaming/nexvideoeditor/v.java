package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4846a;
    final /* synthetic */ NexEditorEventListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NexEditorEventListener nexEditorEventListener, int i) {
        this.b = nexEditorEventListener;
        this.f4846a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ar arVar;
        NexEditor nexEditor;
        NexEditor.PlayState playState;
        NexEditor nexEditor2;
        ar arVar2;
        arVar = this.b.b;
        if (arVar != null) {
            arVar2 = this.b.b;
            arVar2.b(NexEditor.b.a(this.f4846a));
        }
        nexEditor = this.b.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.b.f4797a;
            nexEditor2.e(NexEditor.b.a(this.f4846a));
        }
        NexEditorEventListener nexEditorEventListener = this.b;
        playState = this.b.d;
        nexEditorEventListener.a(playState, NexEditor.PlayState.IDLE);
    }
}
