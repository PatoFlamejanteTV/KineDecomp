package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class m implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f4837a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SurfaceHolder.Callback callback;
        Surface surface;
        Log.d("NexEditor.java", "captureFrame: getFastOptionPreviewTask::onCFail : " + taskError.getMessage());
        SurfaceHolder holder = this.f4837a.f4836a.f4834a.getHolder();
        callback = this.f4837a.f4836a.c.ab;
        holder.removeCallback(callback);
        this.f4837a.f4836a.f4834a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f4837a.f4836a.c;
        surface = this.f4837a.f4836a.c.N;
        nexEditor.prepareSurface(surface);
        this.f4837a.f4836a.c.ac = false;
        this.f4837a.f4836a.b.sendFailure(taskError);
    }
}
