package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class iy implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3995a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ iw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iy(iw iwVar, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = iwVar;
        this.f3995a = msid;
        this.b = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        TimelineView timelineView;
        VideoEditor p = this.c.b.p();
        timelineView = this.c.b.k;
        p.a(timelineView.getSelectedItem(), this.c.f3993a, this.c.b.x()).onComplete(new ja(this, bitmap)).onFailure(new iz(this));
    }
}
