package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.rc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1996rc implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AsyncTaskC2005sc f22505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1996rc(AsyncTaskC2005sc asyncTaskC2005sc) {
        this.f22505a = asyncTaskC2005sc;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.f22505a.f22520a.t = bitmap;
        this.f22505a.f22520a.Aa();
    }
}
