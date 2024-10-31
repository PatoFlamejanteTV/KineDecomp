package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class am implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4820a;
    final /* synthetic */ int b;
    final /* synthetic */ NexEditorEventListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.c = nexEditorEventListener;
        this.f4820a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(NexEditor.PlayState.fromValue(this.f4820a), NexEditor.PlayState.fromValue(this.b));
    }
}
