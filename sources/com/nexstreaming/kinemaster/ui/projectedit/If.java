package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.Toast;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class If implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public If(ProjectEditActivity projectEditActivity) {
        this.f21904a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        Activity u;
        u = this.f21904a.u();
        Toast.makeText(u, this.f21904a.getResources().getString(R.string.capture_done, file.getAbsolutePath()), 1).show();
        this.f21904a.Da();
    }
}
