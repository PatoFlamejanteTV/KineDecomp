package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4815a;
    final /* synthetic */ int b;
    final /* synthetic */ NexEditorEventListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.c = nexEditorEventListener;
        this.f4815a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        ar arVar;
        ar arVar2;
        NexEditor nexEditor2;
        nexEditor = this.c.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.c.f4797a;
            nexEditor2.c(NexEditor.b.a(this.f4815a), this.b);
        }
        arVar = this.c.b;
        if (arVar != null) {
            arVar2 = this.c.b;
            arVar2.d();
        }
    }
}
