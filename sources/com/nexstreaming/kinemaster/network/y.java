package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.VolleyNetworkService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class y implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$GetCategoryInfoResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f21155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(z zVar) {
        this.f21155a = zVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$GetCategoryInfoResponse> resultTask, Task.Event event, AssetStoreAPIData$GetCategoryInfoResponse assetStoreAPIData$GetCategoryInfoResponse) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        ResultTask resultTask4;
        List<AssetStoreAPIData$CategoryInfo> list = assetStoreAPIData$GetCategoryInfoResponse.objList;
        if (list == null) {
            resultTask4 = this.f21155a.f21156a.w;
            resultTask4.sendResult(Collections.emptyList());
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AssetStoreAPIData$CategoryInfo> it = assetStoreAPIData$GetCategoryInfoResponse.objList.iterator();
        while (it.hasNext()) {
            arrayList.add(new VolleyNetworkService.StoreCategoryInfoImp(it.next(), null));
        }
        resultTask2 = this.f21155a.f21156a.w;
        resultTask2.sendResult(arrayList);
        VolleyNetworkService volleyNetworkService = this.f21155a.f21156a;
        resultTask3 = volleyNetworkService.w;
        volleyNetworkService.v = resultTask3;
        this.f21155a.f21156a.x = System.nanoTime();
        this.f21155a.f21156a.w = null;
    }
}
