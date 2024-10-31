package com.xiaomi.gamecenter.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.gamecenter.sdk.IGameCenterSDK;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class z implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MiCommplatform miCommplatform) {
        this.f26646a = miCommplatform;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        Object obj2;
        this.f26646a.loginSdk = IGameCenterSDK.Stub.asInterface(iBinder);
        obj = this.f26646a._Lock_;
        synchronized (obj) {
            obj2 = this.f26646a._Lock_;
            obj2.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f26646a.loginSdk = null;
        Log.i(">>>>", "Service DisConnected");
    }
}