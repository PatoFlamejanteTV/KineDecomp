package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jd implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4001a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jd(ProjectEditActivity projectEditActivity) {
        this.f4001a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity D;
        Activity D2;
        TextView textView;
        D = this.f4001a.D();
        D2 = this.f4001a.D();
        Toast.makeText(D, taskError.getLocalizedMessage(D2), 1).show();
        textView = this.f4001a.M;
        textView.setVisibility(4);
        this.f4001a.L();
    }
}
