package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class E extends com.nexstreaming.kinemaster.editorwrapper.Aa {
    final /* synthetic */ O i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(O o, Context context, InputStream inputStream, boolean z) {
        super(context, inputStream, z);
        this.i = o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(Task.TaskError taskError) {
        this.i.a(Task.Event.FAIL, R.string.project_open_err, taskError);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(NexTimeline nexTimeline) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void b(C1780za c1780za) {
        C1780za c1780za2;
        C1780za c1780za3;
        this.i.f22872g = c1780za;
        c1780za2 = this.i.f22872g;
        if (c1780za2.a() != null) {
            c1780za3 = this.i.f22872g;
            this.i.a((Set<ProjectDependency>) c1780za3.a().getDependencies());
        }
    }
}
