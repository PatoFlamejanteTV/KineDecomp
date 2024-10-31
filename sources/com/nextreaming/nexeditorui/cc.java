package com.nextreaming.nexeditorui;

import android.content.Intent;
import android.net.Uri;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class cc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f4566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar) {
        this.f4566a = caVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4566a.f4564a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/kinemaster/privacy")));
    }
}
