package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class B extends com.nexstreaming.kinemaster.editorwrapper.Aa {
    final /* synthetic */ int i;
    final /* synthetic */ ResultTask j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Context context, InputStream inputStream, boolean z, int i, ResultTask resultTask) {
        super(context, inputStream, z);
        this.i = i;
        this.j = resultTask;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(Task.TaskError taskError) {
        this.j.sendFailure(taskError);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(NexTimeline nexTimeline) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void b(C1780za c1780za) {
        if (c1780za != null && c1780za.a() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c1780za.a().getAllDependencies());
            int i = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((ProjectDependency) it.next()).a() == this.i) {
                    i++;
                }
            }
            this.j.sendResult(Integer.valueOf(i));
            return;
        }
        this.j.sendFailure(new A(this));
    }
}
