package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;

/* loaded from: classes.dex */
class fa implements Cast.MessageReceivedCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f1546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ez ezVar) {
        this.f1546a = ezVar;
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void a(CastDevice castDevice, String str, String str2) {
        this.f1546a.f1544a.zzbK(str2);
    }
}
