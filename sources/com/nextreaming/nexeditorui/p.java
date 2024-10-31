package com.nextreaming.nexeditorui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class P extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(I i) {
        this.f24160a = i;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (intent == null || intent.getAction() == null || !kotlin.jvm.internal.h.a((Object) intent.getAction(), (Object) "android.net.conn.CONNECTIVITY_CHANGE")) {
            return;
        }
        if (c.d.b.m.i.f(context)) {
            str2 = I.f24039b;
            Log.i(str2, "onReceive() returned: network change : on");
            this.f24160a.b(context);
        } else {
            str = I.f24039b;
            Log.i(str, "onReceive() returned: network change : off");
            this.f24160a.a(context);
        }
    }
}
