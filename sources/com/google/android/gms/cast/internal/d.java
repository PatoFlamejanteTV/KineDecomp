package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.zze;
import java.util.Map;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f849a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ zze.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zze.b bVar, zze zzeVar, String str, String str2) {
        this.d = bVar;
        this.f849a = zzeVar;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        Cast.MessageReceivedCallback messageReceivedCallback;
        CastDevice castDevice;
        map = this.f849a.e;
        synchronized (map) {
            map2 = this.f849a.e;
            messageReceivedCallback = (Cast.MessageReceivedCallback) map2.get(this.b);
        }
        if (messageReceivedCallback == null) {
            zze.f851a.b("Discarded message for unknown namespace '%s'", this.b);
        } else {
            castDevice = this.f849a.c;
            messageReceivedCallback.a(castDevice, this.b, this.c);
        }
    }
}
