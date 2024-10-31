package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* renamed from: com.nextreaming.nexvideoeditor.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2370v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24743a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24744b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2370v(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24744b = nexEditorEventListener;
        this.f24743a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24744b.f24606c != null) {
            this.f24744b.f24606c.h(this.f24743a);
        }
    }
}
