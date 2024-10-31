package com.xiaomi.gamecenter.sdk;

import android.util.Log;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* loaded from: classes3.dex */
class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f26587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f26587a = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        IGameCenterSDK iGameCenterSDK;
        MiAppInfo miAppInfo;
        String version;
        c cVar;
        int i;
        IGameCenterSDK iGameCenterSDK2;
        IServiceCallback iServiceCallback;
        IGameCenterSDK iGameCenterSDK3;
        IServiceCallback iServiceCallback2;
        String version2;
        try {
            iGameCenterSDK = this.f26587a.f26586a.sdk;
            miAppInfo = this.f26587a.f26586a.appInfo;
            version = this.f26587a.f26586a.getVersion();
            int ConnServiceNew = iGameCenterSDK.ConnServiceNew(miAppInfo, version);
            if (ConnServiceNew == 0) {
                this.f26587a.f26586a.connect_flag = 0;
                iGameCenterSDK2 = this.f26587a.f26586a.sdk;
                if (iGameCenterSDK2 != null) {
                    iServiceCallback = this.f26587a.f26586a.serviceCallback;
                    if (iServiceCallback != null) {
                        iGameCenterSDK3 = this.f26587a.f26586a.sdk;
                        iServiceCallback2 = this.f26587a.f26586a.serviceCallback;
                        version2 = this.f26587a.f26586a.getVersion();
                        iGameCenterSDK3.registCallback(iServiceCallback2, version2);
                    }
                }
                this.f26587a.f26586a.connect_flag = 2;
            } else {
                if (ConnServiceNew == 2) {
                    this.f26587a.f26586a.sendToastMsg();
                    cVar = this.f26587a;
                } else {
                    cVar = this.f26587a;
                }
                cVar.f26586a.connect_flag = -2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Service Connected ");
            i = this.f26587a.f26586a.connect_flag;
            sb.append(i);
            Log.i(">>>>", sb.toString());
        } catch (Exception unused) {
            this.f26587a.f26586a.connect_flag = -2;
        }
        obj = this.f26587a.f26586a._Lock_;
        synchronized (obj) {
            obj2 = this.f26587a.f26586a._Lock_;
            obj2.notify();
        }
    }
}
