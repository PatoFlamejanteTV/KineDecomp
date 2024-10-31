package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: CustomTabActivity.java */
/* renamed from: com.facebook.i */
/* loaded from: classes.dex */
class C0730i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CustomTabActivity f9264a;

    public C0730i(CustomTabActivity customTabActivity) {
        this.f9264a = customTabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f9264a.finish();
    }
}
