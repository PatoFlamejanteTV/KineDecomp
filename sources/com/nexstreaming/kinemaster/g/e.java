package com.nexstreaming.kinemaster.g;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
public final class e implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f3390a;
    final /* synthetic */ NexExportProfile b;
    final /* synthetic */ NexEditor c;
    final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(i iVar, NexExportProfile nexExportProfile, NexEditor nexEditor, long j) {
        this.f3390a = iVar;
        this.b = nexExportProfile;
        this.c = nexEditor;
        this.d = j;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task.OnTaskEventListener onTaskEventListener;
        Task.OnTaskEventListener onTaskEventListener2;
        Task.OnFailListener onFailListener;
        NexEditor.b a2;
        Context context;
        KMUsage.Transcode_Start.logEvent();
        i iVar = this.f3390a;
        onTaskEventListener = b.e;
        iVar.onSuccess(onTaskEventListener);
        i iVar2 = this.f3390a;
        onTaskEventListener2 = b.f;
        iVar2.onCancel(onTaskEventListener2);
        i iVar3 = this.f3390a;
        onFailListener = b.g;
        iVar3.onFailure(onFailListener);
        if (this.b.isReversed()) {
            MediaInfo a3 = MediaInfo.a(this.f3390a.a());
            int max = Math.max(a3.F(), (int) (a3.w() * a3.x() * 30 * 4 * 0.07f));
            NexEditor nexEditor = this.c;
            String absolutePath = this.f3390a.a().getAbsolutePath();
            String absolutePath2 = this.f3390a.c().getAbsolutePath();
            context = b.b;
            a2 = nexEditor.a(absolutePath, absolutePath2, new File(context.getCacheDir(), "reverse_transcode.tmp").getAbsolutePath(), a3.w(), a3.x(), max, this.d, 0, MediaInfo.a(this.f3390a.a()).y());
        } else {
            a2 = this.c.a(this.f3390a.a().getAbsolutePath(), this.f3390a.c().getAbsolutePath(), this.b.width(), this.b.height(), this.b.bitrate(), this.d, EditorGlobal.c("up"));
        }
        if (a2.a()) {
            this.f3390a.sendFailure(a2);
            b.j();
        } else {
            this.f3390a.e();
            this.f3390a.setProgress(0, 100);
            i unused = b.c = this.f3390a;
        }
    }
}
