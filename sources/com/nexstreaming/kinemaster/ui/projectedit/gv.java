package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
public class gv implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gu f3939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(gu guVar) {
        this.f3939a = guVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Toast.makeText(this.f3939a.b.b.getActivity(), taskError.getLocalizedMessage(this.f3939a.b.b.getActivity()), 1).show();
        this.f3939a.b.b.A();
        new Handler().postDelayed(new gw(this), 300L);
    }
}
