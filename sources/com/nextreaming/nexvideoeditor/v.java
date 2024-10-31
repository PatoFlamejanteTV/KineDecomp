package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class V implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24666a;

    /* renamed from: b */
    final /* synthetic */ int f24667b;

    /* renamed from: c */
    final /* synthetic */ int f24668c;

    /* renamed from: d */
    final /* synthetic */ NexEditorEventListener f24669d;

    public V(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3) {
        this.f24669d = nexEditorEventListener;
        this.f24666a = i;
        this.f24667b = i2;
        this.f24668c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24669d.f24607d;
        if (haVar != null) {
            haVar2 = this.f24669d.f24607d;
            haVar2.a(this.f24666a, this.f24667b, this.f24668c);
        }
    }
}
