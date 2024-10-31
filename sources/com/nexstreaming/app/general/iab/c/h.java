package com.nexstreaming.app.general.iab.c;

import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
public class h implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ IABHelper.a f3175a;
    final /* synthetic */ a b;

    public h(a aVar, IABHelper.a aVar2) {
        this.b = aVar;
        this.f3175a = aVar2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3175a.a(false, null, "NetworkError : " + taskError.getMessage());
    }
}
