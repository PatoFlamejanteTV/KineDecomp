package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f4808a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(NexEditorEventListener nexEditorEventListener) {
        this.f4808a = nexEditorEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        ar arVar;
        ar arVar2;
        NexEditor nexEditor2;
        nexEditor = this.f4808a.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.f4808a.f4797a;
            nexEditor2.f();
        }
        arVar = this.f4808a.b;
        if (arVar != null) {
            arVar2 = this.f4808a.b;
            arVar2.c();
        }
    }
}
