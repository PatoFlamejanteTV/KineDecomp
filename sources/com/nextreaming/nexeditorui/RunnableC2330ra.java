package com.nextreaming.nexeditorui;

import android.content.Intent;
import android.net.Uri;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.ra */
/* loaded from: classes.dex */
class RunnableC2330ra implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2334ta f24393a;

    public RunnableC2330ra(C2334ta c2334ta) {
        this.f24393a = c2334ta;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24393a.f24399a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/kinemaster/privacy")));
    }
}
