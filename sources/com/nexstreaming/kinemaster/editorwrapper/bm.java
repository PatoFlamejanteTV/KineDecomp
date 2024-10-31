package com.nexstreaming.kinemaster.editorwrapper;

import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bm implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceView f3339a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ VideoEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(VideoEditor videoEditor, SurfaceView surfaceView, ResultTask resultTask) {
        this.c = videoEditor;
        this.f3339a = surfaceView;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.c.N().a(this.f3339a).onResultAvailable(new bo(this)).onFailure((Task.OnFailListener) new bn(this));
    }
}
