package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4811a;
    final /* synthetic */ int b;
    final /* synthetic */ NexEditorEventListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.c = nexEditorEventListener;
        this.f4811a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.c.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.c.f4797a;
            nexEditor2.a(NexEditor.b.a(this.f4811a), this.b);
        }
    }
}
