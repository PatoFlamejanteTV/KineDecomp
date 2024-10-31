package com.birbit.android.jobqueue.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkUtilImpl.java */
/* loaded from: classes.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ f f8156a;

    public e(f fVar) {
        this.f8156a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f8156a.b(context);
    }
}
