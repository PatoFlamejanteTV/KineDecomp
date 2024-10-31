package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2360k implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceView f24720a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f24721b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditor f24722c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2360k(NexEditor nexEditor, SurfaceView surfaceView, ResultTask resultTask) {
        this.f24722c = nexEditor;
        this.f24720a = surfaceView;
        this.f24721b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SurfaceHolder.Callback callback;
        Surface surface;
        Log.d("NexEditor.java", "captureFrame: waitForCaptureDimensionsChanged[A]::onCFail : " + taskError.getMessage());
        SurfaceHolder holder = this.f24720a.getHolder();
        callback = this.f24722c.ja;
        holder.removeCallback(callback);
        this.f24720a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f24722c;
        surface = nexEditor.R;
        nexEditor.prepareSurface(surface);
        this.f24722c.ka = false;
        this.f24721b.sendFailure(taskError);
    }
}
