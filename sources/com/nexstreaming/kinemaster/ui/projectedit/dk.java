package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
class dk implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dj f3845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar) {
        this.f3845a = djVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.f3845a.f3844a.i = bitmap;
        this.f3845a.f3844a.c();
    }
}
