package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class u implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21148a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f21149b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f21150c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21151d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VolleyNetworkService volleyNetworkService, int i, int i2, ResultTask resultTask) {
        this.f21151d = volleyNetworkService;
        this.f21148a = i;
        this.f21149b = i2;
        this.f21150c = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AssetStoreAPIData$StandardRequest m;
        ResultTask a2;
        VolleyNetworkService volleyNetworkService = this.f21151d;
        m = volleyNetworkService.m();
        a2 = volleyNetworkService.a(m, this.f21148a, this.f21149b);
        a2.onResultAvailable(new t(this)).onFailure(this.f21150c);
    }
}
