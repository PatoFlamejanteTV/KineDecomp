package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class r extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4842a;
    final /* synthetic */ NexEditor.f b;
    final /* synthetic */ NexEditor.f c;
    final /* synthetic */ NexEditor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NexEditor nexEditor, int i, NexEditor.f fVar, NexEditor.f fVar2) {
        this.d = nexEditor;
        this.f4842a = i;
        this.b = fVar;
        this.c = fVar2;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        this.d.ad = false;
        this.b.a(bVar);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(int i) {
        this.d.b(this.c);
    }
}
