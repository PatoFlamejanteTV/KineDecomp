package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class X implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24678a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24679b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24679b = nexEditorEventListener;
        this.f24678a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24679b.f24606c != null) {
            this.f24679b.f24606c.k(this.f24678a);
        }
    }
}
