package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24453a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24454b = nexEditorEventListener;
        this.f24453a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24454b.f24606c != null) {
            this.f24454b.f24606c.c(NexEditor.b.a(this.f24453a));
        }
    }
}
