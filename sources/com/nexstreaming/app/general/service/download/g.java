package com.nexstreaming.app.general.service.download;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Map;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f19700a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f19701b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, k kVar) {
        this.f19701b = hVar;
        this.f19700a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = i.f19704c;
        if (map.get(this.f19700a.e()) != null) {
            map2 = i.f19704c;
            ((ResultTask) map2.get(this.f19700a.e())).sendFailure(new b(17, R.string.asset_download_failed, "User cancel"));
            map3 = i.f19704c;
            ((ResultTask) map3.get(this.f19700a.e())).signalEvent(Task.Event.CANCEL);
            map4 = i.f19704c;
            map4.remove(this.f19700a.e());
        }
    }
}
