package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class J implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24447a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24448b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24449c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24449c = nexEditorEventListener;
        this.f24447a = i;
        this.f24448b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        if (this.f24449c.f24606c != null) {
            this.f24449c.f24606c.b(NexEditor.b.a(this.f24447a), this.f24448b);
        }
        haVar = this.f24449c.f24607d;
        if (haVar != null) {
            haVar2 = this.f24449c.f24607d;
            haVar2.c();
        }
    }
}
