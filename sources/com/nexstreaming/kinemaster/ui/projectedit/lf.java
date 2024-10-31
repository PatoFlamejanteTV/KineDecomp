package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Lf implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lf(ProjectEditActivity projectEditActivity) {
        this.f21950a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        com.nexstreaming.kinemaster.mediastore.item.c b2 = this.f21950a.W().b(AndroidMediaStoreProvider.a(file));
        this.f21950a.W().a(b2, new Kf(this, b2));
    }
}
