package com.nextreaming.nexeditorui;

import android.content.Intent;
import android.net.Uri;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.qa */
/* loaded from: classes.dex */
class RunnableC2329qa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2334ta f24391a;

    public RunnableC2329qa(C2334ta c2334ta) {
        this.f24391a = c2334ta;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24391a.f24399a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/main/licenses")));
    }
}
