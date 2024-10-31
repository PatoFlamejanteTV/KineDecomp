package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ze, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2090ze implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ He f22806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2090ze(He he) {
        this.f22806a = he;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Toast.makeText(this.f22806a.getActivity(), taskError.getLocalizedMessage(this.f22806a.getActivity()), 1).show();
        this.f22806a.ga();
        new Handler().postDelayed(new RunnableC2082ye(this), 300L);
    }
}
