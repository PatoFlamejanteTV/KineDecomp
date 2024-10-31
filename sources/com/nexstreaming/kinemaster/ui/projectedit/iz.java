package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class iz implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ iy f3996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iz(iy iyVar) {
        this.f3996a = iyVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity D;
        Activity D2;
        TextView textView;
        D = this.f3996a.c.b.D();
        D2 = this.f3996a.c.b.D();
        Toast.makeText(D, taskError.getLocalizedMessage(D2), 1).show();
        textView = this.f3996a.c.b.M;
        textView.setVisibility(4);
        this.f3996a.c.b.L();
    }
}
