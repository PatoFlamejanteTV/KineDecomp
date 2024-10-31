package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class D implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24426a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24427b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24427b = nexEditorEventListener;
        this.f24426a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24427b.f24606c != null) {
            this.f24427b.f24606c.a(NexEditor.b.a(this.f24426a));
        }
    }
}
