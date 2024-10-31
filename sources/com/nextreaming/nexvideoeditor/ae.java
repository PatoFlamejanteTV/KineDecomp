package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4812a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ byte[] f;
    final /* synthetic */ int g;
    final /* synthetic */ int h;
    final /* synthetic */ int i;
    final /* synthetic */ NexEditorEventListener j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8) {
        this.j = nexEditorEventListener;
        this.f4812a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = bArr;
        this.g = i6;
        this.h = i7;
        this.i = i8;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        NexEditor nexEditor2;
        nexEditor = this.j.f4797a;
        if (nexEditor != null) {
            nexEditor2 = this.j.f4797a;
            nexEditor2.a(this.f4812a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
    }
}
