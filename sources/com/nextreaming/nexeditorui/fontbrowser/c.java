package com.nextreaming.nexeditorui.fontbrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
class c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FontBrowserActivity f24264a;

    public c(FontBrowserActivity fontBrowserActivity) {
        this.f24264a = fontBrowserActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.nextreaming.kinemaster.asset.install.completed".equals(action) || "com.nextreaming.kinemaster.asset.uninstall.completed".equals(action)) {
            this.f24264a.u();
        }
    }
}
