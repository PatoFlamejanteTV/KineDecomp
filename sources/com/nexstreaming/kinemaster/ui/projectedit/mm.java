package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
public class mm implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ File f4094a;
    final /* synthetic */ VideoEditor b;
    final /* synthetic */ mh c;

    public mm(mh mhVar, File file, VideoEditor videoEditor) {
        this.c = mhVar;
        this.f4094a = file;
        this.b = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        int i;
        boolean z;
        if (this.c.f4089a.m() != null && (this.c.f4089a.m() instanceof NexSecondaryTimelineItem)) {
            this.c.f4089a.E();
        }
        this.c.f4089a.i = this.f4094a;
        VideoEditor videoEditor = this.b;
        i = this.c.f4089a.h;
        NexAudioClipItem a2 = videoEditor.a(i, this.f4094a.getAbsolutePath(), false);
        MediaScannerConnection.scanFile(this.c.f4089a.getActivity(), new String[]{this.f4094a.getAbsolutePath()}, null, null);
        if (a2 instanceof NexAudioClipItem) {
            a2.setIsVoiceRecording(true);
            KMUsage.trackAddMedia(this.c.f4089a.getActivity(), false, "Recorded Audio", a2);
        }
        this.c.f4089a.d(a2);
        z = this.c.f4089a.l;
        if (z) {
            this.c.f4089a.m = false;
        } else {
            new Handler().post(new mn(this, a2));
        }
        this.b.b(this.c.f4089a);
        this.c.f4089a.d(R.id.action_play_pause, true);
        this.c.f4089a.i(true);
        this.c.f4089a.j(true);
        this.c.f4089a.k(true);
        this.c.f4089a.l(true);
        this.c.f4089a.m(true);
        this.c.f4089a.k();
    }
}
