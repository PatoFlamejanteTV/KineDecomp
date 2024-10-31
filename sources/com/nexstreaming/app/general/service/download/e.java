package com.nexstreaming.app.general.service.download;

import com.nexstreaming.app.general.task.ResultTask;
import java.util.Map;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f19695a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f19696b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar, k kVar) {
        this.f19696b = hVar;
        this.f19695a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        Map map3;
        map = i.f19704c;
        if (map.get(this.f19695a.e()) != null) {
            map2 = i.f19704c;
            ((ResultTask) map2.get(this.f19695a.e())).sendResult(this.f19695a);
            map3 = i.f19704c;
            map3.remove(this.f19695a.e());
        }
    }
}
