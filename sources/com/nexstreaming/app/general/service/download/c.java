package com.nexstreaming.app.general.service.download;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.nexstreaming.app.general.service.download.n;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
public class c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ i f19691a;

    public c(i iVar) {
        this.f19691a = iVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            this.f19691a.a(n.a.a(iBinder));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f19691a.f();
    }
}
