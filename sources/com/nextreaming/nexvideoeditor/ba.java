package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24690a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int[] f24691b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int[] f24692c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24693d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NexEditorEventListener nexEditorEventListener, int i, int[] iArr, int[] iArr2) {
        this.f24693d = nexEditorEventListener;
        this.f24690a = i;
        this.f24691b = iArr;
        this.f24692c = iArr2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24693d.f24606c != null) {
            this.f24693d.f24606c.a(this.f24690a, this.f24691b, this.f24692c);
        }
    }
}
