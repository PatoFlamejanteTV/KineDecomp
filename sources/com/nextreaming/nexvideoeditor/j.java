package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class j implements ResultTask.OnResultAvailableListener<Rect> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceView f4834a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ NexEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NexEditor nexEditor, SurfaceView surfaceView, ResultTask resultTask) {
        this.c = nexEditor;
        this.f4834a = surfaceView;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Rect> resultTask, Task.Event event, Rect rect) {
        ResultTask t;
        NexEditorDeviceProfile.c captureSize = NexEditorDeviceProfile.getDeviceProfile().getCaptureSize();
        this.f4834a.getHolder().setFixedSize(captureSize.f4483a, captureSize.b);
        t = this.c.t();
        t.setTimeout(500L).onResultAvailable(new l(this)).onFailure((Task.OnFailListener) new k(this));
    }
}
