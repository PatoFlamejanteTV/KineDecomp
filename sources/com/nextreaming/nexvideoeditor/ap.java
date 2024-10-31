package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ap implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4823a;
    final /* synthetic */ int b;
    final /* synthetic */ NexEditorEventListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.c = nexEditorEventListener;
        this.f4823a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.c.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.c.f4797a;
            nexEditor2.a(this.f4823a, this.b);
        }
    }
}
