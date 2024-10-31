package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.nexstreaming.app.general.task.Task;

/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
class k implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f4835a = jVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SurfaceHolder.Callback callback;
        Surface surface;
        Log.d("NexEditor.java", "captureFrame: waitForCaptureDimensionsChanged[B]::onCFail : " + taskError.getMessage());
        SurfaceHolder holder = this.f4835a.f4834a.getHolder();
        callback = this.f4835a.c.ab;
        holder.removeCallback(callback);
        this.f4835a.f4834a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f4835a.c;
        surface = this.f4835a.c.N;
        nexEditor.prepareSurface(surface);
        this.f4835a.c.ac = false;
        this.f4835a.b.sendFailure(taskError);
    }
}
