package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.VolleyNetworkService;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class C implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$GetFeaturedAssetInfoResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ D f21092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(D d2) {
        this.f21092a = d2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$GetFeaturedAssetInfoResponse> resultTask, Task.Event event, AssetStoreAPIData$GetFeaturedAssetInfoResponse assetStoreAPIData$GetFeaturedAssetInfoResponse) {
        this.f21092a.f21094b.sendResult(new VolleyNetworkService.c(assetStoreAPIData$GetFeaturedAssetInfoResponse, null));
    }
}
