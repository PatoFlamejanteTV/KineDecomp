package com.nexstreaming.app.general.service.download;

import com.nexstreaming.kinemaster.network.C1819h;

/* compiled from: NexDownloadService.java */
/* loaded from: classes2.dex */
public class p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ k f19725a;

    /* renamed from: b */
    final /* synthetic */ NexDownloadService f19726b;

    public p(NexDownloadService nexDownloadService, k kVar) {
        this.f19726b = nexDownloadService;
        this.f19725a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1819h.a(this.f19726b).a().a(this.f19725a.f(), new o(this));
    }
}
