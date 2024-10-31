package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import android.widget.GridView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ce implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.f>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4185a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(ProjectGalleryActivity projectGalleryActivity, String str) {
        this.b = projectGalleryActivity;
        this.f4185a = str;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.f>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.f> list) {
        x xVar;
        View view;
        GridView gridView;
        xVar = this.b.g;
        xVar.a(list);
        this.b.a(ProjectGalleryActivity.LoadingTask.ProjectList);
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f().equals(this.f4185a)) {
                i = i2;
            }
        }
        view = this.b.h;
        view.setVisibility(0);
        gridView = this.b.e;
        gridView.post(new cf(this, i));
    }
}
