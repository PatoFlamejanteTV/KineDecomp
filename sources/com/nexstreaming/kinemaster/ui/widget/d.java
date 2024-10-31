package com.nexstreaming.kinemaster.ui.widget;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCyclerView.java */
/* loaded from: classes.dex */
public class d implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageCyclerView.a f4388a;
    final /* synthetic */ ImageCyclerView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImageCyclerView imageCyclerView, ImageCyclerView.a aVar) {
        this.b = imageCyclerView;
        this.f4388a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        List list;
        list = this.b.d;
        list.remove(this.f4388a);
    }
}
