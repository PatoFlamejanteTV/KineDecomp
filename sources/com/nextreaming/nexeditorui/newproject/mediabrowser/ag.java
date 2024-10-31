package com.nextreaming.nexeditorui.newproject.mediabrowser;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ag implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f4703a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaBrowserFragment c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MediaBrowserFragment mediaBrowserFragment, com.nexstreaming.kinemaster.ui.a.e eVar, MediaStoreItem mediaStoreItem) {
        this.c = mediaBrowserFragment;
        this.f4703a = eVar;
        this.b = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.f4703a.isShowing()) {
            this.c.e(this.b);
            this.f4703a.dismiss();
        }
    }
}
