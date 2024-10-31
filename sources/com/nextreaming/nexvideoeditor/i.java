package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class I implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24444a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24445b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24446c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24446c = nexEditorEventListener;
        this.f24444a = i;
        this.f24445b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        haVar = this.f24446c.f24607d;
        if (haVar == null || this.f24446c.f24606c == null) {
            return;
        }
        this.f24446c.f24606c.c(NexEditor.b.a(this.f24444a), this.f24445b);
    }
}
