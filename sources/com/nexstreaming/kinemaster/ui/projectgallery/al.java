package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class al implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.project.f>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ak f4138a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f4138a = akVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.project.f>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.project.f> list) {
        x xVar;
        try {
            KMUsage.getMixpanelInstance(this.f4138a.f4137a.f4134a).a("Delete Project", new JSONObject().put("Project Count", list.size()));
        } catch (JSONException e) {
            Log.e("ProjectGalleryActivity", "Mixpanel json err", e);
        }
        xVar = this.f4138a.f4137a.f4134a.g;
        xVar.a(list);
        this.f4138a.f4137a.f4134a.r();
        this.f4138a.f4137a.f4134a.p();
    }
}
