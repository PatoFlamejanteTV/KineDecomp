package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexExportProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class cc implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f3811a;
    final /* synthetic */ com.nexstreaming.kinemaster.g.i b;
    final /* synthetic */ boolean c;
    final /* synthetic */ NexExportProfile d;
    final /* synthetic */ bo e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bo boVar, com.nexstreaming.kinemaster.ui.a.e eVar, com.nexstreaming.kinemaster.g.i iVar, boolean z, NexExportProfile nexExportProfile) {
        this.e = boVar;
        this.f3811a = eVar;
        this.b = iVar;
        this.c = z;
        this.d = nexExportProfile;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        String a2;
        if (this.f3811a.isShowing()) {
            this.f3811a.i(i2);
            this.f3811a.h(i);
            a2 = this.e.a(this.b);
            if (this.c) {
                this.f3811a.a(this.e.getString(R.string.mediabrowser_transcode_in_progress_fps, new Object[]{a2}));
            } else {
                this.f3811a.a(this.e.getString(R.string.mediabrowser_transcode_in_progress, new Object[]{Integer.valueOf(this.d.width()), Integer.valueOf(this.d.displayHeight()), a2}));
            }
        }
    }
}
