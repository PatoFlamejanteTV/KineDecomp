package com.nexstreaming.app.general.iab.c;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
class e implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ IABHelper.c f3172a;
    final /* synthetic */ a b;

    public e(a aVar, IABHelper.c cVar) {
        this.b = aVar;
        this.f3172a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3172a.b(IABError.NetworkError, taskError.toString());
        Log.i("MiIABHelper", "loadPurchaseInventory -> network connect");
    }
}
