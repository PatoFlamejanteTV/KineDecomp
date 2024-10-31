package c.d.b.k;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
public class e implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f3826a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexExportProfile f3827b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditor f3828c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f3829d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(j jVar, NexExportProfile nexExportProfile, NexEditor nexEditor, long j) {
        this.f3826a = jVar;
        this.f3827b = nexExportProfile;
        this.f3828c = nexEditor;
        this.f3829d = j;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task.OnTaskEventListener onTaskEventListener;
        Task.OnTaskEventListener onTaskEventListener2;
        Task.OnFailListener onFailListener;
        NexEditor.b a2;
        Context context;
        j jVar = this.f3826a;
        onTaskEventListener = i.f3834e;
        jVar.onSuccess(onTaskEventListener);
        j jVar2 = this.f3826a;
        onTaskEventListener2 = i.f3835f;
        jVar2.onCancel(onTaskEventListener2);
        j jVar3 = this.f3826a;
        onFailListener = i.f3836g;
        jVar3.onFailure(onFailListener);
        if (this.f3827b.isReversed()) {
            MediaInfo a3 = MediaInfo.a(this.f3826a.e());
            int max = Math.max(a3.I(), (int) (a3.R() * a3.v() * 30 * 4 * 0.07f));
            NexEditor nexEditor = this.f3828c;
            String absolutePath = this.f3826a.e().getAbsolutePath();
            String absolutePath2 = this.f3826a.f().getAbsolutePath();
            context = i.f3831b;
            a2 = nexEditor.a(absolutePath, absolutePath2, new File(context.getCacheDir(), "reverse_transcode.tmp").getAbsolutePath(), a3.R(), a3.v(), max, this.f3829d, 0, MediaInfo.a(this.f3826a.e()).r());
        } else {
            MediaInfo a4 = MediaInfo.a(this.f3826a.e());
            int width = this.f3827b.width();
            int height = this.f3827b.height();
            if (a4.z() == 0 && a4.R() < a4.v()) {
                width = this.f3827b.height();
                height = this.f3827b.width();
            } else if (a4.z() == 0 && a4.R() == a4.v()) {
                width = this.f3827b.height();
                height = this.f3827b.height();
            }
            a2 = this.f3828c.a(this.f3826a.e().getAbsolutePath(), this.f3826a.f().getAbsolutePath(), width, height, this.f3827b.bitrate(), this.f3829d, EditorGlobal.a("up"));
        }
        if (a2.c()) {
            this.f3826a.sendFailure(a2);
            i.k();
        } else {
            this.f3826a.i();
            this.f3826a.setProgress(0, 100);
            j unused = i.f3832c = this.f3826a;
        }
    }
}
