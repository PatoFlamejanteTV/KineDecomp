package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2148w implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2152y f22993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2148w(C2152y c2152y) {
        this.f22993a = c2152y;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        Context context;
        this.f22993a.f23002b.m = false;
        rVar = this.f22993a.f23002b.i;
        rVar.dismiss();
        O o = this.f22993a.f23002b;
        Task.Event event2 = Task.Event.FAIL;
        context = o.f22866a;
        o.a(event2, taskError.getLocalizedMessage(context), taskError.getMessage());
    }
}
