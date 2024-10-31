package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.HashMap;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1690t implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC1691u f19408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1690t(RunnableC1691u runnableC1691u) {
        this.f19408a = runnableC1691u;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error", IABError.NetworkError.name());
        hashMap.put("Result", taskError.toString());
        String bool = Boolean.toString(c.d.b.m.i.f(KineMasterApplication.f24058f.a()));
        kotlin.jvm.internal.h.a((Object) bool, "java.lang.Boolean.toStri…etApplicationInstance()))");
        hashMap.put("network", bool);
        KMEvents.SEVER_SUB_ERROR.logEvent(hashMap);
        this.f19408a.f19410b.onNext(new d.a(4));
        c.d.b.b.k d2 = c.d.b.b.i.d();
        kotlin.jvm.internal.h.a((Object) d2, "FirebaseManager.getRemoteConfig()");
        if (d2.j()) {
            RunnableC1691u runnableC1691u = this.f19408a;
            C1695y c1695y = runnableC1691u.f19409a.f19411a;
            io.reactivex.n nVar = runnableC1691u.f19410b;
            kotlin.jvm.internal.h.a((Object) nVar, "it");
            com.nexstreaming.app.general.iab.assist.c.a(c1695y, nVar);
        }
    }
}
