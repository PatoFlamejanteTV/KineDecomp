package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class C implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(NexEditorEventListener nexEditorEventListener) {
        this.f24425a = nexEditorEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        if (this.f24425a.f24606c != null) {
            this.f24425a.f24606c.o();
        }
        haVar = this.f24425a.f24607d;
        if (haVar != null) {
            haVar2 = this.f24425a.f24607d;
            haVar2.d();
        }
    }
}
