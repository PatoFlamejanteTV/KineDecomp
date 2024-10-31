package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.TextView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class iu implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3991a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iu(ProjectEditActivity projectEditActivity) {
        this.f3991a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        TextView textView;
        textView = this.f3991a.M;
        textView.setVisibility(4);
        this.f3991a.b(this.f3991a.x().a(AndroidMediaStoreProvider.a(file)));
        this.f3991a.L();
    }
}
