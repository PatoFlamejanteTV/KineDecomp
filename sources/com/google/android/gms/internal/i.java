package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
class i extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzaz f1616a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(zzaz zzazVar) {
        this.f1616a = zzazVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1616a.zzh(false);
    }
}
