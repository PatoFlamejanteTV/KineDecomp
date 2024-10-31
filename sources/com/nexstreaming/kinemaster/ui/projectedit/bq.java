package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bq implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ File f3798a;
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e b;
    final /* synthetic */ bo c;

    public bq(bo boVar, File file, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.c = boVar;
        this.f3798a = file;
        this.b = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.c.getActivity() != null && this.f3798a != null) {
            MediaScannerConnection.scanFile(this.c.getActivity(), new String[]{this.f3798a.getAbsolutePath()}, null, new br(this));
        }
    }
}
