package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* renamed from: com.nextreaming.nexvideoeditor.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2373y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24748a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24749b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24750c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24751d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24752e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2373y(NexEditorEventListener nexEditorEventListener, int i, int i2, int i3, int i4) {
        this.f24752e = nexEditorEventListener;
        this.f24748a = i;
        this.f24749b = i2;
        this.f24750c = i3;
        this.f24751d = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        ha haVar;
        ha haVar2;
        ha haVar3;
        ha haVar4;
        if (this.f24752e.f24606c != null) {
            if (this.f24749b == 1) {
                this.f24752e.f24606c.p();
            } else {
                this.f24752e.f24606c.c(this.f24750c, this.f24751d);
            }
        }
        haVar = this.f24752e.f24607d;
        if (haVar != null) {
            if (this.f24749b == 1) {
                haVar4 = this.f24752e.f24607d;
                haVar4.b();
            } else if (this.f24748a != 0) {
                haVar3 = this.f24752e.f24607d;
                haVar3.d(NexEditor.b.a(this.f24748a));
            } else {
                haVar2 = this.f24752e.f24607d;
                haVar2.a(this.f24750c);
            }
        }
    }
}
