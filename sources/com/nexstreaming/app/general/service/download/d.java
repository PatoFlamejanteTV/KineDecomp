package com.nexstreaming.app.general.service.download;

import com.nexstreaming.app.general.task.ResultTask;
import java.util.Map;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f19692a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f19693b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f19694c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h hVar, k kVar, int i) {
        this.f19694c = hVar;
        this.f19692a = kVar;
        this.f19693b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        map = i.f19704c;
        if (map.get(this.f19692a.e()) != null) {
            map2 = i.f19704c;
            ((ResultTask) map2.get(this.f19692a.e())).setProgress(this.f19693b, 100);
        }
    }
}
