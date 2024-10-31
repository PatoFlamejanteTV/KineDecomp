package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24704a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24705b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24705b = nexEditorEventListener;
        this.f24704a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24705b.f24607d;
        if (haVar != null) {
            haVar2 = this.f24705b.f24607d;
            haVar2.b(this.f24704a);
        }
        if (this.f24705b.f24606c != null) {
            this.f24705b.f24606c.j(this.f24704a);
        }
    }
}
