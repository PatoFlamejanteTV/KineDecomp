package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24686a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int[] f24687b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24688c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(NexEditorEventListener nexEditorEventListener, int i, int[] iArr) {
        this.f24688c = nexEditorEventListener;
        this.f24686a = i;
        this.f24687b = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24688c.f24606c != null) {
            this.f24688c.f24606c.a(this.f24686a, this.f24687b);
        }
    }
}
