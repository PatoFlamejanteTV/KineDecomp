package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4847a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ NexEditorEventListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3) {
        this.d = nexEditorEventListener;
        this.f4847a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor nexEditor;
        ar arVar;
        ar arVar2;
        ar arVar3;
        ar arVar4;
        NexEditor nexEditor2;
        NexEditor nexEditor3;
        nexEditor = this.d.f4797a;
        if (nexEditor != null) {
            if (this.f4847a == 1) {
                nexEditor3 = this.d.f4797a;
                nexEditor3.n();
            } else {
                nexEditor2 = this.d.f4797a;
                nexEditor2.f(this.b);
            }
        }
        arVar = this.d.b;
        if (arVar != null) {
            if (this.f4847a == 1) {
                arVar4 = this.d.b;
                arVar4.a();
            } else if (this.c != 0) {
                arVar3 = this.d.b;
                arVar3.a(NexEditor.b.a(this.c));
            } else {
                arVar2 = this.d.b;
                arVar2.b(this.b);
            }
        }
    }
}
