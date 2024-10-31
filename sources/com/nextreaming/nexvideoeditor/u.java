package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class U implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24663a;

    /* renamed from: b */
    final /* synthetic */ int f24664b;

    /* renamed from: c */
    final /* synthetic */ NexEditorEventListener f24665c;

    public U(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24665c = nexEditorEventListener;
        this.f24663a = i;
        this.f24664b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24665c.f24607d;
        if (haVar != null) {
            haVar2 = this.f24665c.f24607d;
            haVar2.a(this.f24663a, this.f24664b);
        }
    }
}
