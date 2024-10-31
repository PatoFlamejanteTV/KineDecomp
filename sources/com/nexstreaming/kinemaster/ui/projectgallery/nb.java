package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class nb implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nb(ProjectGalleryActivity projectGalleryActivity) {
        this.f22961a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.k>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.k> list) {
        Eb eb;
        Eb eb2;
        eb = this.f22961a.ua;
        eb.a(new ArrayList<>(list));
        eb2 = this.f22961a.ua;
        eb2.notifyDataSetChanged();
        this.f22961a.ma();
        this.f22961a.ga();
    }
}
