package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
class di implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dh f3843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar) {
        this.f3843a = dhVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.f3843a.f3842a.h = bitmap;
        this.f3843a.f3842a.c();
    }
}
