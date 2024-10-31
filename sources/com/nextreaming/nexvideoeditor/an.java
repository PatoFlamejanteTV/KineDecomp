package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class an implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4821a;
    final /* synthetic */ NexEditorEventListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NexEditorEventListener nexEditorEventListener, int i) {
        this.b = nexEditorEventListener;
        this.f4821a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ar arVar;
        NexEditor nexEditor;
        NexEditor nexEditor2;
        ar arVar2;
        arVar = this.b.b;
        if (arVar != null) {
            arVar2 = this.b.b;
            arVar2.a(this.f4821a);
        }
        nexEditor = this.b.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.b.f4797a;
            nexEditor2.g(this.f4821a);
        }
    }
}
