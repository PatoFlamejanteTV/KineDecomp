package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.net.Uri;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bi implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4162a;
    final /* synthetic */ a b;
    final /* synthetic */ com.nexstreaming.kinemaster.project.f c;
    final /* synthetic */ ProjectGalleryActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(ProjectGalleryActivity projectGalleryActivity, String str, a aVar, com.nexstreaming.kinemaster.project.f fVar) {
        this.d = projectGalleryActivity;
        this.f4162a = str;
        this.b = aVar;
        this.c = fVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        KMUsage.ProjectList_EditProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, this.f4162a);
        com.nexstreaming.kinemaster.editorwrapper.ar a2 = this.b.a();
        KMUsage.trackMixpanelProjectEvent(this.d, a2 == null ? null : a2.a(), "Edit Project", null);
        Intent intent = new Intent(this.d, (Class<?>) ProjectEditActivity.class);
        intent.setFlags(67108864);
        intent.setData(Uri.fromFile(this.c.a()));
        this.d.startActivity(intent);
        this.d.overridePendingTransition(0, 0);
        this.d.o();
        this.d.C = true;
    }
}
