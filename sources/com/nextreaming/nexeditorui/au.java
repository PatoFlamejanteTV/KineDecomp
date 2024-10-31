package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class au implements ResultTask.OnResultAvailableListener<a.C0073a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4529a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(af afVar, ResultTask resultTask) {
        this.b = afVar;
        this.f4529a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<a.C0073a> resultTask, Task.Event event, a.C0073a c0073a) {
        this.f4529a.sendResult(c0073a);
        this.b.m = c0073a.a();
        this.b.t();
    }
}
