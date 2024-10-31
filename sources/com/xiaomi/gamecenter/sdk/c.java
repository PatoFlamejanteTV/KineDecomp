package com.xiaomi.gamecenter.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.gamecenter.sdk.IGameCenterSDK;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f4889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MiCommplatform miCommplatform) {
        this.f4889a = miCommplatform;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4889a.sdk = IGameCenterSDK.Stub.asInterface(iBinder);
        new d(this).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4889a.sdk = null;
        Log.i(">>>>", "Service DisConnected");
    }
}
