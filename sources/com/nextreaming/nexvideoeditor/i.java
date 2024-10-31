package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class i implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceView f4833a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ NexEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NexEditor nexEditor, SurfaceView surfaceView, ResultTask resultTask) {
        this.c = nexEditor;
        this.f4833a = surfaceView;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SurfaceHolder.Callback callback;
        Surface surface;
        Log.d("NexEditor.java", "captureFrame: waitForCaptureDimensionsChanged[A]::onCFail : " + taskError.getMessage());
        SurfaceHolder holder = this.f4833a.getHolder();
        callback = this.c.ab;
        holder.removeCallback(callback);
        this.f4833a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.c;
        surface = this.c.N;
        nexEditor.prepareSurface(surface);
        this.c.ac = false;
        this.b.sendFailure(taskError);
    }
}
