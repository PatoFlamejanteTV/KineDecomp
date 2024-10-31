package com.nexstreaming.app.general.service.download;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.nexstreaming.app.general.service.download.n;
import java.util.Map;

/* compiled from: NexDownloadService.java */
/* loaded from: classes2.dex */
class r extends n.a {

    /* renamed from: a */
    final /* synthetic */ NexDownloadService f19728a;

    public r(NexDownloadService nexDownloadService) {
        this.f19728a = nexDownloadService;
    }

    @Override // com.nexstreaming.app.general.service.download.n
    public int a(k kVar) throws RemoteException {
        Map map;
        int c2;
        if (kVar == null) {
            return 0;
        }
        map = NexDownloadService.f19680b;
        l lVar = (l) map.get(kVar.c());
        if (lVar != null) {
            c2 = lVar.a().f19721c;
        } else {
            c2 = this.f19728a.c(kVar);
        }
        if (c2 == 0) {
            this.f19728a.d(kVar);
            return c2;
        }
        if (c2 != 1) {
            return c2;
        }
        this.f19728a.b(kVar);
        return c2;
    }

    @Override // com.nexstreaming.app.general.service.download.n
    public boolean b(m mVar) throws RemoteException {
        RemoteCallbackList remoteCallbackList;
        remoteCallbackList = this.f19728a.f19681c;
        boolean unregister = remoteCallbackList.unregister(mVar);
        if (unregister) {
            NexDownloadService.c(this.f19728a);
        }
        return unregister;
    }

    @Override // com.nexstreaming.app.general.service.download.n
    public int b(String str) throws RemoteException {
        Map map;
        Map map2;
        if (str != null) {
            map = NexDownloadService.f19680b;
            if (map != null) {
                map2 = NexDownloadService.f19680b;
                l lVar = (l) map2.get(str);
                if (lVar != null && lVar.a() != null) {
                    return lVar.a().a();
                }
            }
        }
        return 0;
    }

    @Override // com.nexstreaming.app.general.service.download.n
    public boolean a(m mVar) throws RemoteException {
        RemoteCallbackList remoteCallbackList;
        remoteCallbackList = this.f19728a.f19681c;
        if (!remoteCallbackList.register(mVar)) {
            return false;
        }
        NexDownloadService.b(this.f19728a);
        return false;
    }

    @Override // com.nexstreaming.app.general.service.download.n
    public boolean a(String str) throws RemoteException {
        Map map;
        Map map2;
        if (str == null) {
            return false;
        }
        map = NexDownloadService.f19680b;
        if (map == null) {
            return false;
        }
        map2 = NexDownloadService.f19680b;
        l lVar = (l) map2.get(str);
        if (lVar == null || lVar.a() == null) {
            return false;
        }
        return lVar.a().f19721c == 16 || lVar.a().f19721c == 0;
    }
}
