package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Bf implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bf(ProjectEditActivity projectEditActivity) {
        this.f21785a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        this.f21785a.b(this.f21785a.W().b(AndroidMediaStoreProvider.a(file)), (NexTimelineItem) null);
        this.f21785a.Da();
    }
}
