package com.nextreaming.nexeditorui.newproject.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes.dex */
class b implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f4663a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, ImageView imageView) {
        this.b = aVar;
        this.f4663a = imageView;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        if (event.equals(Task.Event.RESULT_AVAILABLE)) {
            this.f4663a.setImageBitmap(bitmap);
        } else {
            this.f4663a.setBackgroundResource(R.drawable.n2_missingfile_icon_small);
        }
    }
}
