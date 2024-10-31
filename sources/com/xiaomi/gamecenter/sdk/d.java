package com.xiaomi.gamecenter.sdk;

import android.util.Log;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* loaded from: classes.dex */
class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f4890a = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        IGameCenterSDK iGameCenterSDK;
        MiAppInfo miAppInfo;
        String version;
        int i;
        IGameCenterSDK iGameCenterSDK2;
        IServiceCallback iServiceCallback;
        IGameCenterSDK iGameCenterSDK3;
        IServiceCallback iServiceCallback2;
        String version2;
        try {
            iGameCenterSDK = this.f4890a.f4889a.sdk;
            miAppInfo = this.f4890a.f4889a.appInfo;
            version = this.f4890a.f4889a.getVersion();
            int ConnServiceNew = iGameCenterSDK.ConnServiceNew(miAppInfo, version);
            if (ConnServiceNew == 0) {
                this.f4890a.f4889a.connect_flag = 0;
                iGameCenterSDK2 = this.f4890a.f4889a.sdk;
                if (iGameCenterSDK2 != null) {
                    iServiceCallback = this.f4890a.f4889a.serviceCallback;
                    if (iServiceCallback != null) {
                        iGameCenterSDK3 = this.f4890a.f4889a.sdk;
                        iServiceCallback2 = this.f4890a.f4889a.serviceCallback;
                        version2 = this.f4890a.f4889a.getVersion();
                        iGameCenterSDK3.registCallback(iServiceCallback2, version2);
                    }
                }
                this.f4890a.f4889a.connect_flag = 2;
            } else if (ConnServiceNew == 2) {
                this.f4890a.f4889a.sendToastMsg();
                this.f4890a.f4889a.connect_flag = -2;
            } else {
                this.f4890a.f4889a.connect_flag = -2;
            }
            StringBuilder append = new StringBuilder().append("Service Connected ");
            i = this.f4890a.f4889a.connect_flag;
            Log.i(">>>>", append.append(i).toString());
        } catch (Exception e) {
            this.f4890a.f4889a.connect_flag = -2;
        }
        obj = this.f4890a.f4889a._Lock_;
        synchronized (obj) {
            obj2 = this.f4890a.f4889a._Lock_;
            obj2.notify();
        }
    }
}
