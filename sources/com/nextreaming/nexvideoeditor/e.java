package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24428a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24429b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24430c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24431d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3) {
        this.f24431d = nexEditorEventListener;
        this.f24428a = i;
        this.f24429b = i2;
        this.f24430c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24431d.f24606c != null) {
            this.f24431d.f24606c.a(this.f24428a, this.f24429b, this.f24430c);
        }
    }
}
