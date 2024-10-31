package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24694a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24695b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(NexEditorEventListener nexEditorEventListener, int i) {
        this.f24695b = nexEditorEventListener;
        this.f24694a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f24695b.f24606c != null) {
            this.f24695b.f24606c.a(NexEditor.b.f24591b, this.f24694a);
        }
    }
}
