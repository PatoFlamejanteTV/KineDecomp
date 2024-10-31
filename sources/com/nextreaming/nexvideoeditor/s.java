package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class S implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24659a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24660b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24660b = nexEditorEventListener;
        this.f24659a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24660b.f24607d;
        if (haVar != null) {
            haVar2 = this.f24660b.f24607d;
            haVar2.a(NexEditor.b.a(this.f24659a));
        }
    }
}
