package com.nexstreaming.app.general.service.download;

import android.os.Handler;
import android.os.RemoteException;
import com.nexstreaming.app.general.service.download.m;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
class h extends m.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f19702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.f19702a = iVar;
    }

    @Override // com.nexstreaming.app.general.service.download.m
    public void a(k kVar, int i) throws RemoteException {
        new Handler(this.f19702a.a().getMainLooper()).post(new d(this, kVar, i));
    }

    @Override // com.nexstreaming.app.general.service.download.m
    public void b(k kVar) throws RemoteException {
        new Handler(this.f19702a.a().getMainLooper()).post(new g(this, kVar));
    }

    @Override // com.nexstreaming.app.general.service.download.m
    public void c(k kVar) throws RemoteException {
    }

    @Override // com.nexstreaming.app.general.service.download.m
    public void d(k kVar) throws RemoteException {
        new Handler(this.f19702a.a().getMainLooper()).post(new e(this, kVar));
    }

    @Override // com.nexstreaming.app.general.service.download.m
    public void a(k kVar, b bVar) throws RemoteException {
        new Handler(this.f19702a.a().getMainLooper()).post(new f(this, kVar, bVar));
    }
}
