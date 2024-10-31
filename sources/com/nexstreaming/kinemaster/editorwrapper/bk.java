package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.m;
import com.nextreaming.nexeditorui.NexProjectHeader;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bk extends AsyncTask<Void, Void, ar> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3337a;
    final /* synthetic */ Task b;
    final /* synthetic */ VideoEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(VideoEditor videoEditor, File file, Task task) {
        this.c = videoEditor;
        this.f3337a = file;
        this.b = task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ar doInBackground(Void... voidArr) {
        Context P;
        NexTimeline nexTimeline = new NexTimeline();
        NexProjectHeader nexProjectHeader = new NexProjectHeader();
        nexProjectHeader.creationTime = new Date();
        nexTimeline.setThemeMusicVolume(50);
        nexTimeline.setProjectheader(nexProjectHeader);
        this.c.b(nexTimeline);
        P = this.c.P();
        nexTimeline.checkResources(P);
        nexTimeline.ensureItemsHaveUniqueIds();
        nexTimeline.setThemeId("com.nexstreaming.kinemaster.basic");
        return new ar(nexTimeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ar arVar) {
        com.nexstreaming.app.general.util.m mVar;
        Task task;
        this.c.e = arVar;
        this.c.E = this.f3337a;
        this.c.Q = null;
        this.c.P = null;
        this.c.H = false;
        this.c.K = true;
        mVar = this.c.j;
        mVar.a((m.a) new bl(this));
        task = this.c.p;
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        this.b.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
