package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: CustomTabMainActivity.java */
/* loaded from: classes.dex */
class j extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CustomTabMainActivity f9344a;

    public j(CustomTabMainActivity customTabMainActivity) {
        this.f9344a = customTabMainActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(this.f9344a, (Class<?>) CustomTabMainActivity.class);
        intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
        String str = CustomTabMainActivity.EXTRA_URL;
        intent2.putExtra(str, intent.getStringExtra(str));
        intent2.addFlags(603979776);
        this.f9344a.startActivity(intent2);
    }
}
