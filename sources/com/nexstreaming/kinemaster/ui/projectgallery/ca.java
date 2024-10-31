package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ca implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.f>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(ProjectGalleryActivity projectGalleryActivity) {
        this.f4181a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.f>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.f> list) {
        x xVar;
        x xVar2;
        boolean z;
        xVar = this.f4181a.g;
        if (xVar != null) {
            xVar2 = this.f4181a.g;
            xVar2.a(list);
            z = this.f4181a.A;
            if (z) {
                this.f4181a.a(ProjectGalleryActivity.LoadingTask.ProjectList);
            } else {
                this.f4181a.r();
            }
        }
    }
}
