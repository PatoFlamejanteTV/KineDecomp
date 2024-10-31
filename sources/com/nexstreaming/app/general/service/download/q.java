package com.nexstreaming.app.general.service.download;

import android.app.NotificationManager;
import com.nexstreaming.app.general.service.download.l;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: NexDownloadService.java */
/* loaded from: classes2.dex */
class q implements l.b {

    /* renamed from: a */
    final /* synthetic */ NexDownloadService f19727a;

    public q(NexDownloadService nexDownloadService) {
        this.f19727a = nexDownloadService;
    }

    @Override // com.nexstreaming.app.general.service.download.l.b
    public void a(l lVar, k kVar) {
        Map map;
        map = NexDownloadService.f19680b;
        map.put(kVar.c(), lVar);
        this.f19727a.b(lVar, kVar);
        this.f19727a.a(lVar, kVar);
    }

    @Override // com.nexstreaming.app.general.service.download.l.b
    public void b(k kVar) {
        NotificationManager notificationManager;
        Map map;
        notificationManager = this.f19727a.f19683e;
        notificationManager.cancel((int) kVar.a());
        map = NexDownloadService.f19680b;
        map.remove(kVar.c());
        this.f19727a.a(kVar);
    }

    @Override // com.nexstreaming.app.general.service.download.l.b
    public void a(k kVar, long j, long j2, int i) {
        this.f19727a.a(kVar, i);
    }

    @Override // com.nexstreaming.app.general.service.download.l.b
    public void a(k kVar) {
        ArrayList arrayList;
        NotificationManager notificationManager;
        Map map;
        arrayList = this.f19727a.f19684f;
        arrayList.add(kVar.g());
        notificationManager = this.f19727a.f19683e;
        notificationManager.cancel((int) kVar.a());
        map = NexDownloadService.f19680b;
        map.remove(kVar.c());
        this.f19727a.b(kVar);
    }

    @Override // com.nexstreaming.app.general.service.download.l.b
    public void a(k kVar, b bVar) {
        NotificationManager notificationManager;
        Map map;
        notificationManager = this.f19727a.f19683e;
        notificationManager.cancel((int) kVar.a());
        map = NexDownloadService.f19680b;
        map.remove(kVar.c());
        this.f19727a.b(kVar, bVar);
        this.f19727a.a(kVar, bVar);
    }
}
