package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4817a;
    final /* synthetic */ NexEditorEventListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(NexEditorEventListener nexEditorEventListener, int i) {
        this.b = nexEditorEventListener;
        this.f4817a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.b.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.b.f4797a;
            nexEditor2.a(NexEditor.b.a(this.f4817a));
        }
    }
}
