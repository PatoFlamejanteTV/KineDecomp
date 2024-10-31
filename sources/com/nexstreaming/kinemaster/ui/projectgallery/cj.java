package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cj implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.f>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4190a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ProjectGalleryActivity projectGalleryActivity) {
        this.f4190a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.f>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.f> list) {
        x xVar;
        try {
            KMUsage.getMixpanelInstance(this.f4190a).a("Duplicate Project", new JSONObject().put("Project Count", list.size()));
        } catch (JSONException e) {
            Log.e("ProjectGalleryActivity", "Mixpanel json err", e);
        }
        xVar = this.f4190a.g;
        xVar.a(list);
        this.f4190a.r();
        this.f4190a.p();
    }
}
