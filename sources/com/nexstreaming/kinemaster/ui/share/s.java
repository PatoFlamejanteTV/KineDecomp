package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
public class s implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4363a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar, File file) {
        this.b = kVar;
        this.f4363a = file;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        f fVar;
        boolean z;
        f fVar2;
        VideoEditor videoEditor;
        NexExportProfile nexExportProfile;
        int i;
        int i2;
        int i3;
        fVar = this.b.t;
        fVar.a("...seek complete.", new String[0]);
        SupportLogger.Event.Export_SeekComplete.log(new int[0]);
        z = this.b.k;
        if (z) {
            this.b.e();
            return;
        }
        fVar2 = this.b.t;
        fVar2.a("Send export request to engine", new String[0]);
        videoEditor = this.b.f;
        VideoEditor.a a2 = videoEditor.x().a(this.f4363a);
        nexExportProfile = this.b.i;
        VideoEditor.a a3 = a2.a(nexExportProfile);
        i = this.b.q;
        VideoEditor.a a4 = a3.a(i);
        i2 = this.b.r;
        if (i2 > 0) {
            i3 = this.b.r;
            a4.b(i3);
        }
        a4.a().onProgress(new y(this)).onComplete(new v(this)).onFailure(new u(this)).onCancel(new t(this));
        this.b.l = true;
    }
}
