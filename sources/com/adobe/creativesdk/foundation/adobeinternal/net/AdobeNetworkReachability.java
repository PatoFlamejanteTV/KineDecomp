package com.adobe.creativesdk.foundation.adobeinternal.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.notification.c;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeNetworkReachability {

    /* renamed from: a */
    private AdobeNetworkStatusCode f4068a = AdobeNetworkStatusCode.AdobeNetworkNotReachable;

    /* renamed from: b */
    private Context f4069b = null;

    /* renamed from: c */
    private b f4070c = null;

    /* loaded from: classes.dex */
    public enum AdobeNetworkStatusCode {
        AdobeNetworkNotReachable,
        AdobeNetworkReachableNonMetered,
        AdobeNetworkReachableMetered
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public AdobeNetworkStatusCode f4071a = AdobeNetworkStatusCode.AdobeNetworkNotReachable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            AdobeNetworkStatusCode adobeNetworkStatusCode = AdobeNetworkReachability.this.f4068a;
            AdobeNetworkReachability.this.a(activeNetworkInfo, connectivityManager);
            if (adobeNetworkStatusCode != AdobeNetworkReachability.this.f4068a) {
                AdobeNetworkReachability.this.c();
            }
        }
    }

    public boolean b() {
        return this.f4068a != AdobeNetworkStatusCode.AdobeNetworkNotReachable;
    }

    void c() {
        com.adobe.creativesdk.foundation.internal.notification.b a2 = com.adobe.creativesdk.foundation.internal.notification.b.a();
        HashMap hashMap = new HashMap();
        a aVar = new a();
        aVar.f4071a = this.f4068a;
        hashMap.put("AdobeNetworkReachabilityStatusKey", aVar);
        a2.a(new c(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, hashMap));
    }

    public synchronized void d() {
        if (this.f4070c != null && this.f4069b != null) {
            this.f4069b.unregisterReceiver(this.f4070c);
        }
        this.f4069b = null;
        this.f4070c = null;
    }

    public AdobeNetworkStatusCode a() {
        return this.f4068a;
    }

    public synchronized boolean a(Context context) {
        if (this.f4069b != null) {
            return b();
        }
        this.f4069b = context;
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.f4070c = new b();
        this.f4069b.registerReceiver(this.f4070c, intentFilter);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        a(connectivityManager.getActiveNetworkInfo(), connectivityManager);
        return b();
    }

    void a(NetworkInfo networkInfo, ConnectivityManager connectivityManager) {
        if (networkInfo != null) {
            if (!connectivityManager.isActiveNetworkMetered()) {
                this.f4068a = AdobeNetworkStatusCode.AdobeNetworkReachableNonMetered;
                return;
            } else {
                this.f4068a = AdobeNetworkStatusCode.AdobeNetworkReachableMetered;
                return;
            }
        }
        this.f4068a = AdobeNetworkStatusCode.AdobeNetworkNotReachable;
    }
}
