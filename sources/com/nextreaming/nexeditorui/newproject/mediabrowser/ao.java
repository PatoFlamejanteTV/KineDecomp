package com.nextreaming.nexeditorui.newproject.mediabrowser;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ao implements ResultTask.OnResultAvailableListener<MediaStoreItem.MediaSupportType> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4711a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(MediaBrowserFragment mediaBrowserFragment, MediaStoreItem mediaStoreItem) {
        this.b = mediaBrowserFragment;
        this.f4711a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<MediaStoreItem.MediaSupportType> resultTask, Task.Event event, MediaStoreItem.MediaSupportType mediaSupportType) {
        this.b.a(false);
        this.b.e(this.f4711a);
    }
}
