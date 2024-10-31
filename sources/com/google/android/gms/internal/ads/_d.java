package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class _d extends BroadcastReceiver {

    /* renamed from: a */
    private final /* synthetic */ zzbap f12034a;

    public _d(zzbap zzbapVar) {
        this.f12034a = zzbapVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f12034a.zzc(context, intent);
    }
}
