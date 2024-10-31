package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Gf implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21878a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21879b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gf(ProjectEditActivity projectEditActivity, int i) {
        this.f21879b = projectEditActivity;
        this.f21878a = i;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        MediaStoreItemId a2 = AndroidMediaStoreProvider.a(file);
        com.nexstreaming.kinemaster.mediastore.item.c b2 = this.f21879b.W().b(a2);
        this.f21879b.W().a(b2, new Ff(this, a2, b2));
    }
}
