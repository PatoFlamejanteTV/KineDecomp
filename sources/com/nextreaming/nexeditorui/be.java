package com.nextreaming.nexeditorui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class be extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f4542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ba baVar) {
        this.f4542a = baVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (com.nexstreaming.kinemaster.h.a.c(context)) {
                Log.i("BaseActivity", "onReceive() returned: network change : on");
                this.f4542a.b(context);
            } else {
                Log.i("BaseActivity", "onReceive() returned: network change : off");
                this.f4542a.a(context);
            }
        }
    }
}
