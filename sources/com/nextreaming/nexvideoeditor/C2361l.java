package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.nexstreaming.app.general.task.Task;

/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2361l implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2366q f24725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2361l(C2366q c2366q) {
        this.f24725a = c2366q;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SurfaceHolder.Callback callback;
        Surface surface;
        Log.d("NexEditor.java", "captureFrame: waitForCaptureDimensionsChanged[B]::onCFail : " + taskError.getMessage());
        SurfaceHolder holder = this.f24725a.f24732a.getHolder();
        callback = this.f24725a.f24734c.ja;
        holder.removeCallback(callback);
        this.f24725a.f24732a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f24725a.f24734c;
        surface = nexEditor.R;
        nexEditor.prepareSurface(surface);
        this.f24725a.f24734c.ka = false;
        this.f24725a.f24733b.sendFailure(taskError);
    }
}
