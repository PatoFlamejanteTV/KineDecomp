package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class v implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f4366a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.f4366a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        f fVar;
        File file;
        f fVar2;
        Context context;
        File file2;
        fVar = this.f4366a.b.t;
        fVar.a("Export completion event received.", new String[0]);
        SupportLogger.Event.Export_CompleteEventFromEngine.log(new int[0]);
        File file3 = this.f4366a.f4363a;
        file = this.f4366a.b.h;
        if (!file3.renameTo(file)) {
            this.f4366a.b.a(NexEditor.b.bl);
            return;
        }
        fVar2 = this.f4366a.b.t;
        fVar2.a("Scan exported file...", new String[0]);
        context = this.f4366a.b.b;
        file2 = this.f4366a.b.h;
        MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, null, new w(this));
    }
}
