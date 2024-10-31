package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2362m implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2365p f24728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2362m(C2365p c2365p) {
        this.f24728a = c2365p;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SurfaceHolder.Callback callback;
        Surface surface;
        Log.d("NexEditor.java", "captureFrame: getFastOptionPreviewTask::onCFail : " + taskError.getMessage());
        SurfaceHolder holder = this.f24728a.f24731a.f24732a.getHolder();
        callback = this.f24728a.f24731a.f24734c.ja;
        holder.removeCallback(callback);
        this.f24728a.f24731a.f24732a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f24728a.f24731a.f24734c;
        surface = nexEditor.R;
        nexEditor.prepareSurface(surface);
        this.f24728a.f24731a.f24734c.ka = false;
        this.f24728a.f24731a.f24733b.sendFailure(taskError);
    }
}
