package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class Q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24651a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24652b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24653c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24654d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f24655e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f24656f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f24657g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f24658h;
    final /* synthetic */ int i;
    final /* synthetic */ NexEditorEventListener j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8) {
        this.j = nexEditorEventListener;
        this.f24651a = i;
        this.f24652b = i2;
        this.f24653c = i3;
        this.f24654d = i4;
        this.f24655e = i5;
        this.f24656f = bArr;
        this.f24657g = i6;
        this.f24658h = i7;
        this.i = i8;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.j.f24606c != null) {
            this.j.f24606c.a(this.f24651a, this.f24652b, this.f24653c, this.f24654d, this.f24655e, this.f24656f, this.f24657g, this.f24658h, this.i);
        }
    }
}
