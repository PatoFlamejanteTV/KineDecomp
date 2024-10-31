package com.nextreaming.nexeditorui;

import android.app.Activity;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bh implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4545a;
    final /* synthetic */ ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(ba baVar, com.nexstreaming.kinemaster.ui.a.a aVar) {
        this.b = baVar;
        this.f4545a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4545a.dismiss();
        Activity D = this.b.D();
        if (D != null) {
            new a.C0074a(D).a(taskError.getLocalizedMessage(this.b.D())).a(R.string.button_ok, new bi(this)).a().show();
        }
    }
}
