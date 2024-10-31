package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class iw implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3993a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iw(ProjectEditActivity projectEditActivity, int i) {
        this.b = projectEditActivity;
        this.f3993a = i;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        MSID a2 = AndroidMediaStoreProvider.a(file);
        MediaStoreItem a3 = this.b.x().a(a2);
        this.b.x().b(a3).onResultAvailable(new iy(this, a2, a3)).onFailure((Task.OnFailListener) new ix(this, a2, a3));
    }
}
