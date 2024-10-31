package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
class B implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f21088a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f21089b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f21090c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21091d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(VolleyNetworkService volleyNetworkService, boolean z, int i, ResultTask resultTask) {
        this.f21091d = volleyNetworkService;
        this.f21088a = z;
        this.f21089b = i;
        this.f21090c = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AssetStoreAPIData$StandardRequest a2;
        ResultTask a3;
        VolleyNetworkService volleyNetworkService = this.f21091d;
        a2 = volleyNetworkService.a(this.f21088a);
        a3 = volleyNetworkService.a(a2, this.f21089b);
        a3.onResultAvailable(new A(this)).onFailure(this.f21090c);
    }
}
