package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4810a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ NexEditorEventListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3) {
        this.d = nexEditorEventListener;
        this.f4810a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.d.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.d.f4797a;
            nexEditor2.a(this.f4810a, this.b, this.c);
        }
    }
}
