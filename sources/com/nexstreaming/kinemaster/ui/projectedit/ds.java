package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
public class ds implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f3853a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(OptionCroppingFragment optionCroppingFragment) {
        this.f3853a = optionCroppingFragment;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.f3853a.i = bitmap;
        this.f3853a.c();
    }
}
