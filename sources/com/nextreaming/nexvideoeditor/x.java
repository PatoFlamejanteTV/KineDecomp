package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4848a;
    final /* synthetic */ NexEditorEventListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NexEditorEventListener nexEditorEventListener, int i) {
        this.b = nexEditorEventListener;
        this.f4848a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.b.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.b.f4797a;
            nexEditor2.h(this.f4848a);
        }
    }
}
