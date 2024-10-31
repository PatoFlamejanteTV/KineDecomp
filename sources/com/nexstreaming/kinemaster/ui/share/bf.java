package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;

/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
class bf implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ be f4317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f4317a = beVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AndroidMediaStoreProvider c;
        MSID a2 = AndroidMediaStoreProvider.a(this.f4317a.b.f4315a);
        if (a2 != null) {
            ShareIntentActivity.c cVar = this.f4317a.b.b.f4314a;
            File file = this.f4317a.b.f4315a;
            c = this.f4317a.b.b.b.c();
            cVar.a(file, c.a(a2));
        }
    }
}
