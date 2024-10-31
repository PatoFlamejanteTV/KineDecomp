package com.nexstreaming.app.general.iab.b;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.task.Task;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
class f implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ IABHelper.c f3162a;
    final /* synthetic */ a b;

    public f(a aVar, IABHelper.c cVar) {
        this.b = aVar;
        this.f3162a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3162a.b(IABError.NetworkError, taskError.toString());
        Log.i("WxIABHelper", "loadPurchaseInventory -> network connect");
    }
}
