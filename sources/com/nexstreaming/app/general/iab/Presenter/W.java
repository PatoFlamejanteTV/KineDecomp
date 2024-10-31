package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.HashMap;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class W implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ X f19362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(X x) {
        this.f19362a = x;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error", IABError.NetworkError.name());
        hashMap.put("Result", taskError.toString());
        KMUsage.sever_sub_error.logEvent(hashMap);
        this.f19362a.f19364b.onNext(new d.a(BillingResponse.GENERAL_FAILURE.getIntErrorCode()));
    }
}
