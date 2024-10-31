package com.xiaomi.gamecenter.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.gamecenter.sdk.IGameCenterSDK;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class x implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MiCommplatform miCommplatform) {
        this.f26644a = miCommplatform;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f26644a.sdk = IGameCenterSDK.Stub.asInterface(iBinder);
        new y(this).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f26644a.sdk = null;
    }
}
