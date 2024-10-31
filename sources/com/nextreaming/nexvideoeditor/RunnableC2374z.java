package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* renamed from: com.nextreaming.nexvideoeditor.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2374z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24753a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24754b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2374z(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24754b = nexEditorEventListener;
        this.f24753a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24754b.f24606c != null) {
            this.f24754b.f24606c.g(this.f24753a);
        }
    }
}
