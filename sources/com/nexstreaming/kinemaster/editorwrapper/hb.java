package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.os.AsyncTask;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexProjectHeader;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.ProjectAspectRatio;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class hb extends AsyncTask<Void, Void, C1780za> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f20320a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Task f20321b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20322c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hb(VideoEditor videoEditor, File file, Task task) {
        this.f20322c = videoEditor;
        this.f20320a = file;
        this.f20321b = task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1780za doInBackground(Void... voidArr) {
        Context Q;
        NexTimeline nexTimeline = new NexTimeline();
        NexProjectHeader nexProjectHeader = new NexProjectHeader();
        nexProjectHeader.creationTime = new Date();
        nexProjectHeader.savedWithKMVersion = 14242;
        nexProjectHeader.savedOnPlatform = KMProto.Platform.ANDROID;
        nexProjectHeader.savedWithKMVersionName = "4.11.15.14242";
        nexTimeline.setThemeMusicVolume(50);
        nexTimeline.setProjectheader(nexProjectHeader);
        this.f20322c.c(nexTimeline);
        Q = this.f20322c.Q();
        nexTimeline.checkResources(Q);
        nexTimeline.ensureItemsHaveUniqueIds();
        if (EditorGlobal.l() == 0.5625f) {
            nexTimeline.setProjectRatio(ProjectAspectRatio.R_9_16);
        } else if (EditorGlobal.l() == 1.0f) {
            nexTimeline.setProjectRatio(ProjectAspectRatio.SQUARE);
        } else {
            nexTimeline.setProjectRatio(ProjectAspectRatio.R_16_9);
        }
        nexTimeline.setProjectAspectRatioWidth(EditorGlobal.n());
        nexTimeline.setProjectAspectRatioHeight(EditorGlobal.m());
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] newProject");
        }
        return new C1780za(nexTimeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C1780za c1780za) {
        com.nexstreaming.app.general.util.u uVar;
        Task task;
        this.f20322c.f20267h = c1780za;
        this.f20322c.F = this.f20320a;
        this.f20322c.W = null;
        this.f20322c.V = null;
        this.f20322c.I = false;
        this.f20322c.L = true;
        uVar = this.f20322c.m;
        uVar.a((u.a) new Ua(this));
        task = this.f20322c.t;
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        this.f20321b.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
