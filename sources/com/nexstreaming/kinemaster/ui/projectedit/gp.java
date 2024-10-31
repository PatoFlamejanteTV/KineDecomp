package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
public class gp implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ go f3933a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(go goVar) {
        this.f3933a = goVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Toast.makeText(this.f3933a.getActivity(), taskError.getLocalizedMessage(this.f3933a.getActivity()), 1).show();
        this.f3933a.A();
        new Handler().postDelayed(new gq(this), 300L);
    }
}
