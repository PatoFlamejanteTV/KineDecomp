package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class lb extends Aa {
    final /* synthetic */ File i;
    final /* synthetic */ boolean j;
    final /* synthetic */ Task k;
    final /* synthetic */ VideoEditor l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lb(VideoEditor videoEditor, Context context, InputStream inputStream, boolean z, File file, boolean z2, Task task) {
        super(context, inputStream, z);
        this.l = videoEditor;
        this.i = file;
        this.j = z2;
        this.k = task;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(Task.TaskError taskError) {
        this.k.sendFailure(taskError);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(NexTimeline nexTimeline) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void b(C1780za c1780za) {
        Task c2;
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] loadProject -> onSuccess: " + c1780za);
        }
        c2 = this.l.c(c1780za.a());
        c2.onComplete(new kb(this, c1780za)).onFailure(new ib(this));
    }
}
