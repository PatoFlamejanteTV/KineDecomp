package com.birbit.android.jobqueue.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkUtilImpl.java */
/* loaded from: classes.dex */
public class c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ f f8153a;

    public c(f fVar) {
        this.f8153a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f8153a.b(context);
    }
}
