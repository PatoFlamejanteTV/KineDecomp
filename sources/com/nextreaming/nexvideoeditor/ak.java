package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4818a;
    final /* synthetic */ int[] b;
    final /* synthetic */ NexEditorEventListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(NexEditorEventListener nexEditorEventListener, int i, int[] iArr) {
        this.c = nexEditorEventListener;
        this.f4818a = i;
        this.b = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.c.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.c.f4797a;
            nexEditor2.a(this.f4818a, this.b);
        }
    }
}
