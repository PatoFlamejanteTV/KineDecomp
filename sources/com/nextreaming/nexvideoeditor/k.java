package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class K implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24450a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24451b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24452c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24452c = nexEditorEventListener;
        this.f24450a = i;
        this.f24451b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        if (this.f24452c.f24606c != null) {
            this.f24452c.f24606c.b(NexEditor.b.la, this.f24451b);
        }
        haVar = this.f24452c.f24607d;
        if (haVar != null) {
            haVar2 = this.f24452c.f24607d;
            haVar2.c();
        }
    }
}
