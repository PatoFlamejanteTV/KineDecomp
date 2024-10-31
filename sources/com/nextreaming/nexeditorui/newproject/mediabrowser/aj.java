package com.nextreaming.nexeditorui.newproject.mediabrowser;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class aj implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4706a;
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e b;
    final /* synthetic */ MediaBrowserFragment c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MediaBrowserFragment mediaBrowserFragment, MediaStoreItem mediaStoreItem, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.c = mediaBrowserFragment;
        this.f4706a = mediaStoreItem;
        this.b = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.c.e(this.f4706a);
        this.b.dismiss();
    }
}
