package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class E implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$GetAssetVersionInfoResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f21096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(F f2) {
        this.f21096a = f2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$GetAssetVersionInfoResponse> resultTask, Task.Event event, AssetStoreAPIData$GetAssetVersionInfoResponse assetStoreAPIData$GetAssetVersionInfoResponse) {
        this.f21096a.f21098b.sendResult(assetStoreAPIData$GetAssetVersionInfoResponse.objList);
    }
}
