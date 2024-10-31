package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class fa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24706a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24707b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24708c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24709d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24710e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4) {
        this.f24710e = nexEditorEventListener;
        this.f24706a = i;
        this.f24707b = i2;
        this.f24708c = i3;
        this.f24709d = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24710e.f24606c != null) {
            this.f24710e.f24606c.a(this.f24706a, this.f24707b, this.f24708c, this.f24709d);
        }
    }
}
