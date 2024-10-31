package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24661a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24662b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24662b = nexEditorEventListener;
        this.f24661a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24662b.f24607d;
        if (haVar != null) {
            haVar2 = this.f24662b.f24607d;
            haVar2.b(NexEditor.b.a(this.f24661a));
        }
    }
}
