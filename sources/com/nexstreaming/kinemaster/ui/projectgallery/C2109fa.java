package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2109fa implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.app.general.nexasset.assetpackage.b>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2109fa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22919a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.app.general.nexasset.assetpackage.b>> resultTask, Task.Event event, List<com.nexstreaming.app.general.nexasset.assetpackage.b> list) {
        if (list.size() <= 0) {
            return;
        }
        this.f22919a.runOnUiThread(new RunnableC2106ea(this));
    }
}
