package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes2.dex */
class Be implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fe f21784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Be(Fe fe) {
        this.f21784a = fe;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Toast.makeText(this.f21784a.f21847b.f21877b.getActivity(), taskError.getLocalizedMessage(this.f21784a.f21847b.f21877b.getActivity()), 1).show();
        this.f21784a.f21847b.f21877b.ga();
        new Handler().postDelayed(new Ae(this), 300L);
    }
}
