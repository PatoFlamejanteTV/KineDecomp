package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class d extends NexEditor.g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4829a;
    final /* synthetic */ int b;
    final /* synthetic */ NexEditor.o c;
    final /* synthetic */ NexEditor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NexEditor nexEditor, int i, int i2, NexEditor.o oVar) {
        this.d = nexEditor;
        this.f4829a = i;
        this.b = i2;
        this.c = oVar;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.g
    public void a(NexEditor.b bVar) {
        boolean z;
        int i;
        int startPlay;
        Deque deque;
        z = this.d.ah;
        if (z) {
            i = this.d.ag;
            if (i == this.f4829a) {
                this.d.ah = false;
                this.d.ai = true;
                startPlay = this.d.startPlay(this.b);
                if (startPlay == 0) {
                    deque = this.d.s;
                    deque.add(this.c);
                } else {
                    this.c.a(NexEditor.b.a(startPlay));
                }
            }
        }
    }
}
