package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.NexEditorHelp;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class cg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorHelp.b f4570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(NexEditorHelp.b bVar) {
        this.f4570a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditorHelp.this.finish();
    }
}
