package com.mixpanel.android.util;

import android.util.Log;
import com.mixpanel.android.mpmetrics.m;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: HttpService.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3076a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        try {
            InetAddress byName = InetAddress.getByName("api.mixpanel.com");
            InetAddress byName2 = InetAddress.getByName("decide.mixpanel.com");
            boolean unused = c.f3075a = byName.isLoopbackAddress() || byName.isAnyLocalAddress() || byName2.isLoopbackAddress() || byName2.isAnyLocalAddress();
            if (m.f3036a) {
                z = c.f3075a;
                if (z) {
                    Log.v("MixpanelAPI.Message", "AdBlocker is enabled. Won't be able to use Mixpanel services.");
                }
            }
        } catch (UnknownHostException e) {
        }
    }
}
