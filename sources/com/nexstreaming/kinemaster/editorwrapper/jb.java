package com.nexstreaming.kinemaster.editorwrapper;

import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class jb implements u.a<VideoEditor.e> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kb f20327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jb(kb kbVar) {
        this.f20327a = kbVar;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(VideoEditor.e eVar) {
        C1780za c1780za;
        if (EditorGlobal.p) {
            StringBuilder sb = new StringBuilder();
            sb.append("[VideoEditor] loadProject -> syncEditorToTimeline -> onTaskEvent() -> notify() m_project: ");
            c1780za = this.f20327a.f20330b.l.f20267h;
            sb.append(c1780za);
            Crashlytics.log(sb.toString());
        }
        eVar.c();
    }
}
