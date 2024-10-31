package com.facebook.devicerequests.internal;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceRequestsHelper.java */
/* loaded from: classes.dex */
public class a implements NsdManager.RegistrationListener {

    /* renamed from: a */
    final /* synthetic */ String f9249a;

    /* renamed from: b */
    final /* synthetic */ String f9250b;

    public a(String str, String str2) {
        this.f9249a = str;
        this.f9250b = str2;
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        DeviceRequestsHelper.cleanUpAdvertisementService(this.f9250b);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        if (this.f9249a.equals(nsdServiceInfo.getServiceName())) {
            return;
        }
        DeviceRequestsHelper.cleanUpAdvertisementService(this.f9250b);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
    }
}
