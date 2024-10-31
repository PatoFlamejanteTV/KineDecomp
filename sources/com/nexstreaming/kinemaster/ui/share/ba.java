package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;

/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class ba implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ File f4312a;
    final /* synthetic */ ShareIntentActivity.c b;
    final /* synthetic */ ShareIntentActivity c;

    public ba(ShareIntentActivity shareIntentActivity, File file, ShareIntentActivity.c cVar) {
        this.c = shareIntentActivity;
        this.f4312a = file;
        this.b = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.c.runOnUiThread(new bb(this));
    }
}
