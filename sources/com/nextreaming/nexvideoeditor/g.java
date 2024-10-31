package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24437a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24438b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24439c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24439c = nexEditorEventListener;
        this.f24437a = i;
        this.f24438b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24439c.f24606c != null) {
            this.f24439c.f24606c.c(NexEditor.b.a(this.f24437a), this.f24438b);
        }
    }
}
