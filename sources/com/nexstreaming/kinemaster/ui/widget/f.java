package com.nexstreaming.kinemaster.ui.widget;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCyclerView.java */
/* loaded from: classes2.dex */
public class f implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageCyclerView.a f23864a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImageCyclerView f23865b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImageCyclerView imageCyclerView, ImageCyclerView.a aVar) {
        this.f23865b = imageCyclerView;
        this.f23864a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        List list;
        list = this.f23865b.f23766h;
        list.remove(this.f23864a);
    }
}
