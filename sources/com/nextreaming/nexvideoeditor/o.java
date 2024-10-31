package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class O implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24644a;

    /* renamed from: b */
    final /* synthetic */ int f24645b;

    /* renamed from: c */
    final /* synthetic */ NexEditorEventListener f24646c;

    public O(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24646c = nexEditorEventListener;
        this.f24644a = i;
        this.f24645b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24646c.f24607d;
        if (haVar != null) {
            haVar2 = this.f24646c.f24607d;
            haVar2.a(this.f24644a, this.f24645b);
        }
    }
}
