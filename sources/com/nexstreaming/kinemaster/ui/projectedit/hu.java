package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class hu extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3964a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hu(ProjectEditActivity projectEditActivity) {
        this.f3964a = projectEditActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MediaPrepManager mediaPrepManager;
        MediaPrepManager mediaPrepManager2;
        TimelineView timelineView;
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && com.nexstreaming.kinemaster.h.a.c(context)) {
            mediaPrepManager = this.f3964a.K;
            mediaPrepManager.a();
            mediaPrepManager2 = this.f3964a.K;
            timelineView = this.f3964a.k;
            mediaPrepManager2.a(timelineView.getTimeline());
        }
    }
}
