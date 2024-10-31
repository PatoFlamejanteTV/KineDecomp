package com.nexstreaming.kinemaster.util.update;

import android.util.SparseArray;
import com.nexstreaming.app.general.nexasset.assetpackage.db.AssetPackageRecord;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.AssetStoreAPIData$AssetVersionInfo;
import com.nexstreaming.kinemaster.util.update.AssetUpdateChecker;
import java.util.List;

/* compiled from: AssetUpdateChecker.java */
/* loaded from: classes2.dex */
class p implements ResultTask.OnResultAvailableListener<List<AssetStoreAPIData$AssetVersionInfo>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f23969a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f23970b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q qVar, List list) {
        this.f23970b = qVar;
        this.f23969a = list;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<AssetStoreAPIData$AssetVersionInfo>> resultTask, Task.Event event, List<AssetStoreAPIData$AssetVersionInfo> list) {
        com.nexstreaming.app.general.nexasset.assetpackage.h hVar;
        ResultTask resultTask2;
        List list2;
        List list3;
        long j;
        List list4;
        ResultTask resultTask3;
        List list5;
        if (list == null) {
            list4 = this.f23970b.f23971a.f23947d;
            list4.clear();
            resultTask3 = this.f23970b.f23971a.f23948e;
            list5 = this.f23970b.f23971a.f23947d;
            resultTask3.sendResult(list5);
            return;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            for (AssetStoreAPIData$AssetVersionInfo assetStoreAPIData$AssetVersionInfo : list) {
                sparseArray.put(assetStoreAPIData$AssetVersionInfo.idx, assetStoreAPIData$AssetVersionInfo);
            }
            hVar = this.f23970b.f23971a.f23946c;
            com.nexstreaming.app.general.nexasset.assetpackage.db.a b2 = hVar.b();
            for (com.nexstreaming.app.general.nexasset.assetpackage.b bVar : this.f23969a) {
                AssetStoreAPIData$AssetVersionInfo assetStoreAPIData$AssetVersionInfo2 = (AssetStoreAPIData$AssetVersionInfo) sparseArray.get(bVar.getAssetIdx());
                if (assetStoreAPIData$AssetVersionInfo2 != null && assetStoreAPIData$AssetVersionInfo2.asset_version != bVar.getAssetVersion()) {
                    AssetPackageRecord assetPackageRecord = (AssetPackageRecord) bVar;
                    assetPackageRecord.hasUpdate = true;
                    assetPackageRecord.assetSize = assetStoreAPIData$AssetVersionInfo2.asset_filesize;
                    b2.d(assetPackageRecord);
                    list3 = this.f23970b.f23971a.f23947d;
                    list3.add(assetPackageRecord);
                    AssetUpdateChecker assetUpdateChecker = this.f23970b.f23971a;
                    j = this.f23970b.f23971a.f23951h;
                    assetUpdateChecker.f23951h = j + assetPackageRecord.getAssetSize();
                }
            }
            resultTask2 = this.f23970b.f23971a.f23948e;
            list2 = this.f23970b.f23971a.f23947d;
            resultTask2.sendResult(list2);
            this.f23970b.f23971a.g();
        } finally {
            this.f23970b.f23971a.a(AssetUpdateChecker.State.DONE);
        }
    }
}
