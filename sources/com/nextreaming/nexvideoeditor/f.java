package com.nextreaming.nexvideoeditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class F implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24432a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24433b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24434c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ byte[] f24435d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24436e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, byte[] bArr) {
        this.f24436e = nexEditorEventListener;
        this.f24432a = i;
        this.f24433b = i2;
        this.f24434c = i3;
        this.f24435d = bArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24436e.f24606c != null) {
            this.f24436e.f24606c.a(this.f24432a, this.f24433b, this.f24434c, this.f24435d, true);
        }
    }
}
