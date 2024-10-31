package com.nexstreaming.app.general.iab.b;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import java.util.Map;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
class d implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.d f3160a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IABHelper.d dVar) {
        this.b = aVar;
        this.f3160a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n;
        Log.e("WxIABHelper", "onFail() called with getWechatProductListFromNexServer : t = [" + task + "], e = [" + event + "], failureReason = [" + taskError + "]");
        IABHelper.d dVar = this.f3160a;
        n = this.b.n();
        dVar.b(n);
    }
}
