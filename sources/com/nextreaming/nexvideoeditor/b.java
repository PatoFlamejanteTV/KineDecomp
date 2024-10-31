package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class B implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24420a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24421b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24422c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24423d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24424e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4) {
        this.f24424e = nexEditorEventListener;
        this.f24420a = i;
        this.f24421b = i2;
        this.f24422c = i3;
        this.f24423d = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        if (this.f24424e.f24606c != null) {
            NexEditor.b a2 = NexEditor.b.a(this.f24420a);
            this.f24424e.f24606c.e(a2);
            this.f24424e.f24606c.s();
            this.f24424e.f24606c.d(a2);
        }
        haVar = this.f24424e.f24607d;
        if (haVar != null) {
            haVar2 = this.f24424e.f24607d;
            haVar2.a(NexEditor.b.a(this.f24420a), this.f24421b);
        }
    }
}
