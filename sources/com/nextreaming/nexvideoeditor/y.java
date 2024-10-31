package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class Y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24680a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24681b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24682c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24683d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24684e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4) {
        this.f24684e = nexEditorEventListener;
        this.f24680a = i;
        this.f24681b = i2;
        this.f24682c = i3;
        this.f24683d = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24684e.f24606c != null) {
            this.f24684e.f24606c.b(this.f24680a, this.f24681b, this.f24682c, this.f24683d);
        }
    }
}
