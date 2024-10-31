package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class M implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24577a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24578b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24579c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24579c = nexEditorEventListener;
        this.f24577a = i;
        this.f24578b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24579c.f24607d;
        if (haVar != null) {
            haVar2 = this.f24579c.f24607d;
            haVar2.b(NexEditor.b.a(this.f24577a), this.f24578b);
        }
    }
}
