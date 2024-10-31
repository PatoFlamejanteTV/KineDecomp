package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4844a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ byte[] d;
    final /* synthetic */ NexEditorEventListener e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, byte[] bArr) {
        this.e = nexEditorEventListener;
        this.f4844a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.e.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.e.f4797a;
            nexEditor2.a(this.f4844a, this.b, this.c, this.d);
        }
    }
}
