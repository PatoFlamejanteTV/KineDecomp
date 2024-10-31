package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class J implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f23284a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f23285b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(U u, boolean z) {
        this.f23285b = u;
        this.f23284a = z;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        InterfaceC2240y interfaceC2240y;
        boolean z;
        InterfaceC2240y interfaceC2240y2;
        VideoEditor videoEditor2;
        float l = EditorGlobal.l();
        videoEditor = this.f23285b.f23306f;
        if (l != videoEditor.s().a().getProjectRatio().getValue()) {
            videoEditor2 = this.f23285b.f23306f;
            EditorGlobal.a(videoEditor2.s().a().getProjectRatio().getValue());
        }
        interfaceC2240y = this.f23285b.t;
        if (interfaceC2240y.a()) {
            this.f23285b.e();
        }
        SupportLogger.Event.Export_ProjectLoaded.log(new int[0]);
        z = this.f23285b.k;
        if (z) {
            this.f23285b.g();
            return;
        }
        interfaceC2240y2 = this.f23285b.t;
        interfaceC2240y2.a("Wait for media task...", new String[0]);
        MediaInfo.aa().onComplete(new I(this));
    }
}
