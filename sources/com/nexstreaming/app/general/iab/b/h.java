package com.nexstreaming.app.general.iab.b;

import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.task.Task;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
class h implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ IABHelper.a f3164a;
    final /* synthetic */ a b;

    public h(a aVar, IABHelper.a aVar2) {
        this.b = aVar;
        this.f3164a = aVar2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3164a.a(false, null, "Nexserver data error : " + taskError.toString());
    }
}
