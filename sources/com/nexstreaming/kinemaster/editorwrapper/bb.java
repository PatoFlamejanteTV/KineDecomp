package com.nexstreaming.kinemaster.editorwrapper;

import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bb implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceView f20296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f20297b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20298c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(VideoEditor videoEditor, SurfaceView surfaceView, ResultTask resultTask) {
        this.f20298c = videoEditor;
        this.f20296a = surfaceView;
        this.f20297b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20298c.R().a(this.f20296a).onResultAvailable(new ab(this)).onFailure((Task.OnFailListener) new Xa(this));
    }
}
