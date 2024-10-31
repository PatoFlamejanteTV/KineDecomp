package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4819a;
    final /* synthetic */ NexEditorEventListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NexEditorEventListener nexEditorEventListener, int i) {
        this.b = nexEditorEventListener;
        this.f4819a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.b.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.b.f4797a;
            nexEditor2.b(NexEditor.b.f4793a, this.f4819a);
        }
    }
}
