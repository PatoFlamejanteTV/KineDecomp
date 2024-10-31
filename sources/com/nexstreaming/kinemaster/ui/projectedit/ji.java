package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ji implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ji(ProjectEditActivity projectEditActivity) {
        this.f4006a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        MediaStoreItem a2 = this.f4006a.x().a(AndroidMediaStoreProvider.a(file));
        this.f4006a.x().b(a2).onResultAvailable(new jk(this, a2)).onFailure((Task.OnFailListener) new jj(this, a2));
    }
}
