package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.VolleyNetworkService;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class A implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$AssetInfo> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f21087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(B b2) {
        this.f21087a = b2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$AssetInfo> resultTask, Task.Event event, AssetStoreAPIData$AssetInfo assetStoreAPIData$AssetInfo) {
        this.f21087a.f21090c.sendResult(new VolleyNetworkService.b(assetStoreAPIData$AssetInfo, null));
    }
}
