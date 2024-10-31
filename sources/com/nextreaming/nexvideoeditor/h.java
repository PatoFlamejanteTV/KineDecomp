package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class H implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24440a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24441b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24442c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24443d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3) {
        this.f24443d = nexEditorEventListener;
        this.f24440a = i;
        this.f24441b = i2;
        this.f24442c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24443d.f24606c != null) {
            this.f24443d.f24606c.a(this.f24440a, this.f24441b, this.f24442c);
        }
    }
}
