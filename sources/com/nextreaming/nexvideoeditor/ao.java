package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4822a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ NexEditorEventListener e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4) {
        this.e = nexEditorEventListener;
        this.f4822a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.e.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.e.f4797a;
            nexEditor2.a(this.f4822a, this.b, this.c, this.d);
        }
    }
}
