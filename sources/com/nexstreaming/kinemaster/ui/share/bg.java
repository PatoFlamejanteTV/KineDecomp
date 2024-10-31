package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class bg implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Intent f4318a;
    final /* synthetic */ ShareIntentActivity b;

    public bg(ShareIntentActivity shareIntentActivity, Intent intent) {
        this.b = shareIntentActivity;
        this.f4318a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4318a.setAction(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT);
        this.f4318a.setClass(this.b, ProjectGalleryActivity.class);
        this.f4318a.setFlags(67108864);
        this.b.startActivity(this.f4318a);
        this.b.finish();
    }
}
