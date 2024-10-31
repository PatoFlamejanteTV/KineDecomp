package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jb implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3999a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jb(ProjectEditActivity projectEditActivity) {
        this.f3999a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity D;
        Activity D2;
        TextView textView;
        D = this.f3999a.D();
        D2 = this.f3999a.D();
        Toast.makeText(D, taskError.getLocalizedMessage(D2), 1).show();
        textView = this.f3999a.M;
        textView.setVisibility(4);
        this.f3999a.L();
    }
}
