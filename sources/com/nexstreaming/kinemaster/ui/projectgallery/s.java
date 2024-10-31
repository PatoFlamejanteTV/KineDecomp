package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.net.Uri;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
class s implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.project.f f4220a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.nexstreaming.kinemaster.project.f fVar) {
        this.b = rVar;
        this.f4220a = fVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        KMUsage.ProjectList_EditProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "edit_button_export_list");
        Intent intent = new Intent(this.b.f4219a, (Class<?>) ProjectEditActivity.class);
        intent.setData(Uri.fromFile(this.f4220a.a()));
        this.b.f4219a.startActivity(intent);
        this.b.f4219a.overridePendingTransition(0, 0);
        this.b.f4219a.finish();
    }
}
