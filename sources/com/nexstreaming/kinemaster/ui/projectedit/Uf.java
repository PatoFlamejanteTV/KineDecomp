package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.share.ExportAndShareActivity;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Uf implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22147a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uf(ProjectEditActivity projectEditActivity) {
        this.f22147a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        Intent intent = new Intent(this.f22147a, (Class<?>) ExportAndShareActivity.class);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "edit_screen");
        file = this.f22147a.N;
        intent.setData(Uri.fromFile(file));
        this.f22147a.startActivity(intent);
    }
}
