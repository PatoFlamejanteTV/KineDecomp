package com.nexstreaming.kinemaster.util.update;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.util.update.AssetUpdateChecker;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUpdateChecker.java */
/* loaded from: classes2.dex */
public class q extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AssetUpdateChecker f23971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AssetUpdateChecker assetUpdateChecker) {
        this.f23971a = assetUpdateChecker;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        List list;
        com.nexstreaming.app.general.nexasset.assetpackage.h hVar;
        ResultTask resultTask;
        List list2;
        boolean f2;
        List list3;
        long j;
        this.f23971a.a(AssetUpdateChecker.State.PROGRESS);
        list = this.f23971a.f23947d;
        list.clear();
        this.f23971a.f23951h = 0L;
        ArrayList<com.nexstreaming.app.general.nexasset.assetpackage.b> arrayList = new ArrayList();
        hVar = this.f23971a.f23946c;
        for (com.nexstreaming.app.general.nexasset.assetpackage.b bVar : hVar.c()) {
            if (bVar.hasUpdate()) {
                list3 = this.f23971a.f23947d;
                list3.add(bVar);
                AssetUpdateChecker assetUpdateChecker = this.f23971a;
                j = assetUpdateChecker.f23951h;
                assetUpdateChecker.f23951h = j + bVar.getAssetSize();
            } else {
                arrayList.add(bVar);
            }
        }
        if (arrayList.size() != 0) {
            f2 = this.f23971a.f();
            if (f2) {
                StringBuilder sb = new StringBuilder();
                for (com.nexstreaming.app.general.nexasset.assetpackage.b bVar2 : arrayList) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append(bVar2.getAssetIdx());
                }
                KineMasterApplication.m().q().a(sb.toString()).onResultAvailable(new p(this, arrayList));
                return;
            }
        }
        resultTask = this.f23971a.f23948e;
        list2 = this.f23971a.f23947d;
        resultTask.sendResult(list2);
        this.f23971a.a(AssetUpdateChecker.State.DONE);
    }
}
