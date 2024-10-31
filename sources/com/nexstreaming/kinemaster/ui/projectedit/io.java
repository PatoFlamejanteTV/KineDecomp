package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class io implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3985a;
    final /* synthetic */ File b;
    final /* synthetic */ NexExportProfile c;
    final /* synthetic */ NexVideoClipItem d;
    final /* synthetic */ ProjectEditActivity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public io(ProjectEditActivity projectEditActivity, File file, File file2, NexExportProfile nexExportProfile, NexVideoClipItem nexVideoClipItem) {
        this.e = projectEditActivity;
        this.f3985a = file;
        this.b = file2;
        this.c = nexExportProfile;
        this.d = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Activity D;
        VideoEditor p = this.e.p();
        D = this.e.D();
        p.a(D, this.f3985a, this.b, this.c.getReverseProfile()).onResultAvailable(new ip(this));
    }
}
