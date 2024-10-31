package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.fb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2110fb implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2110fb(ProjectGalleryActivity projectGalleryActivity) {
        this.f22920a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.k>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.k> list) {
        Eb eb;
        Eb eb2;
        Eb eb3;
        boolean z;
        Log.i("START_FLOW", "ProjectGalleryActivity:refreshProjectList GET/DONE");
        eb = this.f22920a.ua;
        if (eb != null) {
            ArrayList<com.nexstreaming.kinemaster.project.k> arrayList = new ArrayList<>();
            for (com.nexstreaming.kinemaster.project.k kVar : list) {
                if (kVar.g() > 0) {
                    arrayList.add(kVar);
                } else {
                    kVar.e().delete();
                }
            }
            eb2 = this.f22920a.ua;
            eb2.a(arrayList);
            eb3 = this.f22920a.ua;
            eb3.notifyDataSetChanged();
            z = this.f22920a.M;
            if (!z) {
                this.f22920a.ma();
            } else {
                this.f22920a.a(ProjectGalleryActivity.LoadingTask.ProjectList);
            }
        }
    }
}
