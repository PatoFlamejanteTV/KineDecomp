package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4850a;
    final /* synthetic */ int b;
    final /* synthetic */ NexEditorEventListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.c = nexEditorEventListener;
        this.f4850a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        ar arVar;
        ar arVar2;
        NexEditor nexEditor2;
        NexEditor nexEditor3;
        NexEditor nexEditor4;
        nexEditor = this.c.f4797a;
        if (nexEditor != null) {
            NexEditor.b a2 = NexEditor.b.a(this.f4850a);
            nexEditor2 = this.c.f4797a;
            nexEditor2.b(a2);
            nexEditor3 = this.c.f4797a;
            nexEditor3.m();
            nexEditor4 = this.c.f4797a;
            nexEditor4.c(a2);
        }
        arVar = this.c.b;
        if (arVar != null) {
            arVar2 = this.c.b;
            arVar2.a(NexEditor.b.a(this.f4850a), this.b);
        }
    }
}
