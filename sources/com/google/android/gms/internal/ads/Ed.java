package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class Ed extends BroadcastReceiver {

    /* renamed from: a */
    private final /* synthetic */ zzayh f11485a;

    private Ed(zzayh zzayhVar) {
        this.f11485a = zzayhVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!"android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f11485a.zzeld = false;
                return;
            }
            return;
        }
        this.f11485a.zzeld = true;
    }

    public /* synthetic */ Ed(zzayh zzayhVar, Ad ad) {
        this(zzayhVar);
    }
}
