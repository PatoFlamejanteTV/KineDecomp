package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jc implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4000a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jc(ProjectEditActivity projectEditActivity) {
        this.f4000a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        Activity D;
        TextView textView;
        D = this.f4000a.D();
        Toast.makeText(D, this.f4000a.getResources().getString(R.string.capture_done, file.getAbsolutePath()), 1).show();
        textView = this.f4000a.M;
        textView.setVisibility(4);
        this.f4000a.L();
    }
}
