package com.nexstreaming.kinemaster.network;

import android.os.SystemClock;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class o implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$AuthorizeOrRefreshResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21139a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(VolleyNetworkService volleyNetworkService) {
        this.f21139a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$AuthorizeOrRefreshResponse> resultTask, Task.Event event, AssetStoreAPIData$AuthorizeOrRefreshResponse assetStoreAPIData$AuthorizeOrRefreshResponse) {
        Task task;
        Task task2;
        Task task3;
        this.f21139a.n = false;
        String str = assetStoreAPIData$AuthorizeOrRefreshResponse.access_token;
        if (str == null || str.length() < 1) {
            task = this.f21139a.l;
            task.sendFailure(SessionError.AUTH_BAD_SERVER_RESPONSE);
        } else {
            if (assetStoreAPIData$AuthorizeOrRefreshResponse.expires_in < 60) {
                task3 = this.f21139a.l;
                task3.sendFailure(SessionError.EXPIRATION_TOO_SHORT);
                return;
            }
            this.f21139a.o = assetStoreAPIData$AuthorizeOrRefreshResponse.access_token;
            this.f21139a.t = SystemClock.elapsedRealtime();
            this.f21139a.s = SystemClock.elapsedRealtime() + (assetStoreAPIData$AuthorizeOrRefreshResponse.expires_in * 1000);
            task2 = this.f21139a.l;
            task2.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        }
    }
}
