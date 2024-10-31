package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ca, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2100ca implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2103da f22910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2100ca(C2103da c2103da) {
        this.f22910a = c2103da;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.k>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.k> list) {
        Eb eb;
        Eb eb2;
        eb = this.f22910a.f22913b.ua;
        eb.a(new ArrayList<>(list));
        eb2 = this.f22910a.f22913b.ua;
        eb2.notifyDataSetChanged();
        this.f22910a.f22913b.ma();
        this.f22910a.f22913b.ga();
    }
}
