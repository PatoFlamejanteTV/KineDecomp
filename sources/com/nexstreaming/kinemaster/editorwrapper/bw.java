package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bw implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.g.i f3349a;
    final /* synthetic */ Context b;
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e c;
    final /* synthetic */ VideoEditor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(VideoEditor videoEditor, com.nexstreaming.kinemaster.g.i iVar, Context context, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.d = videoEditor;
        this.f3349a = iVar;
        this.b = context;
        this.c = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        String b;
        int i3 = (int) this.f3349a.i();
        if (i3 < 0) {
            b = this.b.getString(R.string.export_est);
        } else {
            b = EditorGlobal.b(this.b.getResources(), i3);
        }
        if (i2 > 0) {
            this.c.e(b);
            this.c.i(i2);
            this.c.h(i);
        }
    }
}
