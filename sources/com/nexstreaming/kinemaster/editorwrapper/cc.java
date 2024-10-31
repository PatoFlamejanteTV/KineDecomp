package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class cc extends as {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3356a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Task c;
    final /* synthetic */ VideoEditor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(VideoEditor videoEditor, Context context, InputStream inputStream, boolean z, File file, boolean z2, Task task) {
        super(context, inputStream, z);
        this.d = videoEditor;
        this.f3356a = file;
        this.b = z2;
        this.c = task;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.as
    protected void a(NexTimeline nexTimeline) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.as
    protected void b(ar arVar) {
        Task b;
        b = this.d.b(arVar.a());
        b.onComplete(new ce(this, arVar)).onFailure(new cd(this));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.as
    protected void a(Task.TaskError taskError) {
        this.c.sendFailure(taskError);
    }
}
