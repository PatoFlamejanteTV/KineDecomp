package com.nextreaming.nexeditorui.newproject.b;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.newproject.b.c;

/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes3.dex */
class a implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a f24336a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f24337b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar, c.a aVar) {
        this.f24337b = cVar;
        this.f24336a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        if (event.equals(Task.Event.RESULT_AVAILABLE)) {
            this.f24336a.f24348b.setImageBitmap(bitmap);
        } else {
            this.f24336a.f24348b.setBackgroundResource(R.drawable.n2_missingfile_icon_small);
        }
    }
}
