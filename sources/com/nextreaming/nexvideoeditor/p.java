package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class P implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24647a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24648b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24649c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24650d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3) {
        this.f24650d = nexEditorEventListener;
        this.f24647a = i;
        this.f24648b = i2;
        this.f24649c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        haVar = this.f24650d.f24607d;
        if (haVar != null) {
            haVar2 = this.f24650d.f24607d;
            haVar2.a(NexEditor.b.a(this.f24647a), this.f24648b, this.f24649c);
        }
    }
}
