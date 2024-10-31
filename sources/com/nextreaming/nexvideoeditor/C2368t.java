package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2368t extends NexEditor.q {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24738c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexEditor.f f24739d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditor.f f24740e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ NexEditor f24741f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2368t(NexEditor nexEditor, int i, NexEditor.f fVar, NexEditor.f fVar2) {
        this.f24741f = nexEditor;
        this.f24738c = i;
        this.f24739d = fVar;
        this.f24740e = fVar2;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(NexEditor.b bVar) {
        this.f24741f.la = false;
        this.f24739d.a(bVar);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(int i, int i2) {
        this.f24741f.b(this.f24740e);
    }
}
