package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
class da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24697a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24698b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditorEventListener f24699c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(NexEditorEventListener nexEditorEventListener, int i, int i2) {
        this.f24699c = nexEditorEventListener;
        this.f24697a = i;
        this.f24698b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor.PlayState fromValue = NexEditor.PlayState.fromValue(this.f24697a);
        NexEditor.PlayState fromValue2 = NexEditor.PlayState.fromValue(this.f24698b);
        if (fromValue2 == NexEditor.PlayState.RESUME) {
            fromValue2 = NexEditor.PlayState.RECORD;
        }
        this.f24699c.a(fromValue, fromValue2);
    }
}
