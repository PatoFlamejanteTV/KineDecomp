package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2146v implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2146v(O o) {
        this.f22989a = o;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        Context context;
        if (taskError != null) {
            this.f22989a.m = false;
            rVar = this.f22989a.i;
            rVar.dismiss();
            O o = this.f22989a;
            Task.Event event2 = Task.Event.FAIL;
            context = o.f22866a;
            o.a(event2, taskError.getLocalizedMessage(context), taskError.getMessage());
        }
    }
}
