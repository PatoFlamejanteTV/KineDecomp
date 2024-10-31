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
class r implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$GetCategoryListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f21143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(s sVar) {
        this.f21143a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$GetCategoryListResponse> resultTask, Task.Event event, AssetStoreAPIData$GetCategoryListResponse assetStoreAPIData$GetCategoryListResponse) {
        List<AssetStoreAPIData$AssetInfo> list = assetStoreAPIData$GetCategoryListResponse.objList;
        if (list == null) {
            this.f21143a.f21145b.sendResult(Collections.emptyList());
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AssetStoreAPIData$AssetInfo> it = assetStoreAPIData$GetCategoryListResponse.objList.iterator();
        while (it.hasNext()) {
            arrayList.add(new VolleyNetworkService.b(it.next(), null));
        }
        this.f21143a.f21145b.sendResult(arrayList);
    }
}
