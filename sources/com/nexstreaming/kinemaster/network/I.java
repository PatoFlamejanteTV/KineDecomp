package com.nexstreaming.kinemaster.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class I implements ResultTask.OnResultAvailableListener<AssetStoreAPIData$AuthorizeOrRefreshResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(VolleyNetworkService volleyNetworkService) {
        this.f21102a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AssetStoreAPIData$AuthorizeOrRefreshResponse> resultTask, Task.Event event, AssetStoreAPIData$AuthorizeOrRefreshResponse assetStoreAPIData$AuthorizeOrRefreshResponse) {
        Task task;
        Task task2;
        Context context;
        String str;
        Task task3;
        this.f21102a.m = false;
        String str2 = assetStoreAPIData$AuthorizeOrRefreshResponse.access_token;
        if (str2 == null || str2.length() < 1) {
            task = this.f21102a.k;
            task.sendFailure(SessionError.AUTH_BAD_SERVER_RESPONSE);
            return;
        }
        if (assetStoreAPIData$AuthorizeOrRefreshResponse.expires_in < 60) {
            task3 = this.f21102a.k;
            task3.sendFailure(SessionError.EXPIRATION_TOO_SHORT);
            return;
        }
        this.f21102a.o = assetStoreAPIData$AuthorizeOrRefreshResponse.access_token;
        this.f21102a.t = SystemClock.elapsedRealtime();
        this.f21102a.s = SystemClock.elapsedRealtime() + (assetStoreAPIData$AuthorizeOrRefreshResponse.expires_in * 1000);
        task2 = this.f21102a.k;
        task2.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        context = this.f21102a.j;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        str = this.f21102a.o;
        edit.putString("access_token", str).putInt("scope", assetStoreAPIData$AuthorizeOrRefreshResponse.scope).apply();
    }
}
