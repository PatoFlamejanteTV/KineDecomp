package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class b extends com.nexstreaming.kinemaster.editorwrapper.as {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Context context, InputStream inputStream, boolean z) {
        super(context, inputStream, z);
        this.f4153a = aVar;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.as
    protected void a(NexTimeline nexTimeline) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.as
    protected void b(com.nexstreaming.kinemaster.editorwrapper.ar arVar) {
        com.nexstreaming.kinemaster.editorwrapper.ar arVar2;
        com.nexstreaming.kinemaster.editorwrapper.ar arVar3;
        this.f4153a.f = arVar;
        arVar2 = this.f4153a.f;
        if (arVar2.a() != null) {
            a aVar = this.f4153a;
            arVar3 = this.f4153a.f;
            aVar.a((Set<ProjectDependency>) arVar3.a().getDependencies());
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.as
    protected void a(Task.TaskError taskError) {
        this.f4153a.a(Task.Event.FAIL, R.string.project_open_err, taskError);
    }
}
