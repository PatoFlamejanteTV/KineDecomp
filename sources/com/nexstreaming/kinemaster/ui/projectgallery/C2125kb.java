package com.nexstreaming.kinemaster.ui.projectgallery;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.kb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2125kb implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22946a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22947b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2125kb(ProjectGalleryActivity projectGalleryActivity, String str) {
        this.f22947b = projectGalleryActivity;
        this.f22946a = str;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.k>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.k> list) {
        Eb eb;
        Eb eb2;
        View view;
        RecyclerView recyclerView;
        Eb eb3;
        Log.i("START_FLOW", "ProjectGalleryActivity:renameProjectTo GET/FINISH");
        eb = this.f22947b.ua;
        eb.a(new ArrayList<>(list));
        eb2 = this.f22947b.ua;
        eb2.notifyDataSetChanged();
        this.f22947b.a(ProjectGalleryActivity.LoadingTask.ProjectList);
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                i = 0;
                break;
            }
            com.nexstreaming.kinemaster.project.k kVar = list.get(i);
            if (kVar == null || !kVar.f().equals(this.f22946a)) {
                i++;
            } else {
                eb3 = this.f22947b.ua;
                if (!eb3.j() && list.size() >= 1 && i >= 1) {
                    i++;
                }
            }
        }
        view = this.f22947b.W;
        view.setVisibility(0);
        recyclerView = this.f22947b.sa;
        recyclerView.post(new RunnableC2122jb(this, i));
    }
}
