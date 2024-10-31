package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexExportProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Lb implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.r f21942a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.d.b.k.j f21943b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f21944c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexExportProfile f21945d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Mb f21946e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lb(Mb mb, com.nexstreaming.kinemaster.ui.a.r rVar, c.d.b.k.j jVar, boolean z, NexExportProfile nexExportProfile) {
        this.f21946e = mb;
        this.f21942a = rVar;
        this.f21943b = jVar;
        this.f21944c = z;
        this.f21945d = nexExportProfile;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        String a2;
        if (this.f21942a.isShowing()) {
            this.f21942a.i(i2);
            this.f21942a.j(i);
            a2 = this.f21946e.a(this.f21943b);
            if (this.f21944c) {
                this.f21942a.a(this.f21946e.getString(R.string.mediabrowser_transcode_in_progress_fps, a2));
            } else {
                this.f21942a.a(this.f21946e.getString(R.string.mediabrowser_transcode_in_progress, Integer.valueOf(this.f21945d.width()), Integer.valueOf(this.f21945d.displayHeight()), a2));
            }
        }
    }
}
