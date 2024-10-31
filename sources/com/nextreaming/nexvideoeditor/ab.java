package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4809a;
    final /* synthetic */ NexEditorEventListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(NexEditorEventListener nexEditorEventListener, int i) {
        this.b = nexEditorEventListener;
        this.f4809a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.b.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.b.f4797a;
            nexEditor2.f(NexEditor.b.a(this.f4809a));
        }
    }
}
