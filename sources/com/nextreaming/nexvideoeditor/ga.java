package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class ga implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24712a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24713b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24714c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24714c = nexEditorEventListener;
        this.f24712a = i;
        this.f24713b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24714c.f24606c != null) {
            this.f24714c.f24606c.b(this.f24712a, this.f24713b);
        }
    }
}
