package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ki implements ResultTask.OnResultAvailableListener<int[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f4033a;
    final /* synthetic */ MediaInfo b;
    final /* synthetic */ long c;
    final /* synthetic */ Task d;
    final /* synthetic */ ProjectEditActivity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ki(ProjectEditActivity projectEditActivity, NexVideoClipItem nexVideoClipItem, MediaInfo mediaInfo, long j, Task task) {
        this.e = projectEditActivity;
        this.f4033a = nexVideoClipItem;
        this.b = mediaInfo;
        this.c = j;
        this.d = task;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<int[]> resultTask, Task.Event event, int[] iArr) {
        Activity D;
        Activity D2;
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] - iArr[i2 - 1] > i) {
                i = iArr[i2] - iArr[i2 - 1];
            }
            if (i2 == iArr.length - 1 && this.f4033a.getDuration() - iArr[i2] > i) {
                i = this.f4033a.getDuration() - iArr[i2];
            }
        }
        long B = ((((((i * this.b.B()) / 1000) * this.b.x()) * this.b.w()) * 3) / 2) + this.c;
        if (B <= 0) {
            B = 1;
        }
        D = this.e.D();
        if (!com.nexstreaming.app.general.util.i.a(EditorGlobal.c(D), B, 10485760L)) {
            this.d.signalEvent(Task.Event.FAIL);
            D2 = this.e.D();
            new a.C0074a(D2).a(R.string.fail_enospc).a(R.string.button_ok, new kj(this)).a().show();
            return;
        }
        this.d.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
