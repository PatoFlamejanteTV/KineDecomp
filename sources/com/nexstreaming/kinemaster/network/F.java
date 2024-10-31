package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class F implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f21097a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f21098b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21099c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(VolleyNetworkService volleyNetworkService, String str, ResultTask resultTask) {
        this.f21099c = volleyNetworkService;
        this.f21097a = str;
        this.f21098b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AssetStoreAPIData$AssetVersionInfoRequest b2;
        ResultTask a2;
        VolleyNetworkService volleyNetworkService = this.f21099c;
        b2 = volleyNetworkService.b(this.f21097a);
        a2 = volleyNetworkService.a(b2);
        a2.onResultAvailable(new E(this)).onFailure(this.f21098b);
    }
}
