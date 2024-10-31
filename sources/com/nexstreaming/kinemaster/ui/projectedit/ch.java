package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import java.io.File;
import java.util.HashMap;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Ch implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ih f21804a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f21805b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f21806c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ch(Ih ih, File file, VideoEditor videoEditor) {
        this.f21804a = ih;
        this.f21805b = file;
        this.f21806c = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        if (this.f21804a.f21906a.Y() != null && (this.f21804a.f21906a.Y() instanceof NexSecondaryTimelineItem)) {
            this.f21804a.f21906a.H();
        }
        zh.a(this.f21804a.f21906a, this.f21805b);
        NexAudioClipItem a2 = this.f21806c.a(zh.k(this.f21804a.f21906a), this.f21805b.getAbsolutePath(), false);
        MediaScannerConnection.scanFile(this.f21804a.f21906a.getActivity(), new String[]{this.f21805b.getAbsolutePath()}, null, null);
        if (a2 instanceof NexAudioClipItem) {
            a2.setIsVoiceRecording(true);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "Voice");
            hashMap.put("result", "Success");
            KMEvents.EDIT_ADD_VOICE.logEvent(hashMap);
        }
        this.f21804a.f21906a.b(a2);
        if (!zh.m(this.f21804a.f21906a)) {
            new Handler().post(new Bh(this, a2));
        } else {
            zh.c(this.f21804a.f21906a, false);
        }
        this.f21806c.b(this.f21804a.f21906a);
        this.f21804a.f21906a.c(R.id.action_play_pause, true);
        this.f21804a.f21906a.l(true);
        this.f21804a.f21906a.k(true);
        this.f21804a.f21906a.j(true);
        this.f21804a.f21906a.h(true);
        this.f21804a.f21906a.i(true);
        this.f21804a.f21906a.J();
    }
}
