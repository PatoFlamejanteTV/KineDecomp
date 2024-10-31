package com.nexstreaming.kinemaster.g;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
public final class c implements NexEditor.r {
    @Override // com.nextreaming.nexvideoeditor.NexEditor.r
    public void a(int i, int i2, int i3) {
        i iVar;
        i iVar2;
        iVar = b.c;
        if (iVar != null) {
            iVar2 = b.c;
            iVar2.setProgress(i2, i3);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.r
    public void a(NexEditor.b bVar, int i) {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        i iVar7;
        i iVar8;
        i iVar9;
        i iVar10;
        List list;
        i iVar11;
        iVar = b.c;
        if (iVar != null) {
            if (bVar == NexEditor.b.D) {
                iVar10 = b.c;
                iVar10.f();
                list = b.f3388a;
                iVar11 = b.c;
                list.add(iVar11);
                i unused = b.c = null;
                MediaInfo.q().onComplete(new d(this));
            } else if (bVar == NexEditor.b.M) {
                iVar8 = b.c;
                File c = iVar8.c();
                if (c.exists()) {
                    c.delete();
                }
                Log.d("Transcoder", "onTranscodingDone      result==ErrorCode.TRANSCODING_USER_CANCEL!!!!!!!!!!!!!!!!!!!!!!");
                iVar9 = b.c;
                iVar9.signalEvent(Task.Event.CANCEL);
            } else if (bVar.a()) {
                iVar6 = b.c;
                File c2 = iVar6.c();
                if (c2.exists()) {
                    c2.delete();
                }
                iVar7 = b.c;
                iVar7.sendFailure(bVar);
            } else {
                iVar2 = b.c;
                File c3 = iVar2.c();
                if (c3.exists()) {
                    iVar4 = b.c;
                    c3.renameTo(iVar4.b());
                    iVar5 = b.c;
                    iVar5.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
                } else {
                    iVar3 = b.c;
                    iVar3.sendFailure(NexEditor.b.bt);
                }
                Log.d("Transcoder", "onTranscodingDone      Task.Event.SUCCESS,Task.Event.COMPLETE!!!!!!!!!!!!!!!!!!!!!!");
            }
            i unused2 = b.c = null;
        }
        b.j();
    }
}
