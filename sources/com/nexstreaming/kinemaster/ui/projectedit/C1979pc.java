package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1979pc implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AsyncTaskC1988qc f22478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1979pc(AsyncTaskC1988qc asyncTaskC1988qc) {
        this.f22478a = asyncTaskC1988qc;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.f22478a.f22486a.s = bitmap;
        this.f22478a.f22486a.Aa();
    }
}
