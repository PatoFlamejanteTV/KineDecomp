package com.nexstreaming.app.general.service.download;

import com.nexstreaming.app.general.task.ResultTask;
import java.util.Map;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f19697a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f19698b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f19699c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar, k kVar, b bVar) {
        this.f19699c = hVar;
        this.f19697a = kVar;
        this.f19698b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        Map map3;
        map = i.f19704c;
        if (map.get(this.f19697a.e()) != null) {
            map2 = i.f19704c;
            ((ResultTask) map2.get(this.f19697a.e())).sendFailure(this.f19698b);
            map3 = i.f19704c;
            map3.remove(this.f19697a.e());
        }
    }
}
