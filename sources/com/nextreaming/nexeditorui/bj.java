package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.a;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bj implements ResultTask.OnResultAvailableListener<a.C0073a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4547a;
    final /* synthetic */ ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(ba baVar, com.nexstreaming.kinemaster.ui.a.a aVar) {
        this.b = baVar;
        this.f4547a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<a.C0073a> resultTask, Task.Event event, a.C0073a c0073a) {
        this.f4547a.dismiss();
        new a.C0074a(this.b.D()).a(c0073a.getLocalizedMessage(this.b.D())).a(R.string.button_ok, new bk(this)).a().show();
    }
}
