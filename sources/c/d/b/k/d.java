package c.d.b.k;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
public class d implements NexEditor.s {
    @Override // com.nextreaming.nexvideoeditor.NexEditor.s
    public void a(int i, int i2, int i3) {
        j jVar;
        j jVar2;
        jVar = i.f3832c;
        if (jVar != null) {
            jVar2 = i.f3832c;
            jVar2.setProgress(i2, i3);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.s
    public void a(NexEditor.b bVar, int i) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        j jVar8;
        j jVar9;
        j jVar10;
        List list;
        j jVar11;
        jVar = i.f3832c;
        if (jVar != null) {
            if (bVar == NexEditor.b.E) {
                jVar10 = i.f3832c;
                jVar10.h();
                list = i.f3830a;
                jVar11 = i.f3832c;
                list.add(jVar11);
                j unused = i.f3832c = null;
                MediaInfo.aa().onComplete(new c(this));
            } else if (bVar == NexEditor.b.N) {
                jVar8 = i.f3832c;
                File f2 = jVar8.f();
                if (f2.exists()) {
                    f2.delete();
                }
                Log.d("Transcoder", "onTranscodingDone      result==ErrorCode.TRANSCODING_USER_CANCEL!!!!!!!!!!!!!!!!!!!!!!");
                jVar9 = i.f3832c;
                jVar9.signalEvent(Task.Event.CANCEL);
            } else if (bVar.c()) {
                jVar6 = i.f3832c;
                File f3 = jVar6.f();
                if (f3.exists()) {
                    f3.delete();
                }
                jVar7 = i.f3832c;
                jVar7.sendFailure(bVar);
            } else {
                jVar2 = i.f3832c;
                File f4 = jVar2.f();
                if (f4.exists()) {
                    jVar4 = i.f3832c;
                    f4.renameTo(jVar4.a());
                    jVar5 = i.f3832c;
                    jVar5.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
                } else {
                    jVar3 = i.f3832c;
                    jVar3.sendFailure(NexEditor.b.tb);
                }
                Log.d("Transcoder", "onTranscodingDone      Task.Event.SUCCESS,Task.Event.COMPLETE!!!!!!!!!!!!!!!!!!!!!!");
            }
            j unused2 = i.f3832c = null;
        }
        i.k();
    }
}
