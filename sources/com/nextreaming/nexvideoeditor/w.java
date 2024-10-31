package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class W implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24670a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24671b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24671b = nexEditorEventListener;
        this.f24670a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24671b.f24606c != null) {
            this.f24671b.f24606c.i(this.f24670a);
        }
    }
}
