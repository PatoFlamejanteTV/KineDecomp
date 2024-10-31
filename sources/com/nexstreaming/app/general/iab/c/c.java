package com.nexstreaming.app.general.iab.c;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import java.util.Map;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
class c implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.d f3170a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IABHelper.d dVar) {
        this.b = aVar;
        this.f3170a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n;
        Log.e("MiIABHelper", "onFail() called with getXiaomiProductListFromNexServer : t = [" + task + "], e = [" + event + "], failureReason = [" + taskError + "]");
        IABHelper.d dVar = this.f3170a;
        n = this.b.n();
        dVar.b(n);
    }
}
