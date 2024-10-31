package com.birbit.android.jobqueue.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkUtilImpl.java */
/* loaded from: classes.dex */
public class d extends ConnectivityManager.NetworkCallback {

    /* renamed from: a */
    final /* synthetic */ Context f8154a;

    /* renamed from: b */
    final /* synthetic */ f f8155b;

    public d(f fVar, Context context) {
        this.f8155b = fVar;
        this.f8154a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        this.f8155b.b(this.f8154a);
    }
}
