package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ResultTask.java */
/* loaded from: classes2.dex */
public class d<RESULT_COLLECTION> implements ResultTask.OnResultAvailableListener<RESULT_COLLECTION> {

    /* renamed from: a */
    final /* synthetic */ ResultTask f19739a;

    /* renamed from: b */
    final /* synthetic */ Map f19740b;

    /* renamed from: c */
    final /* synthetic */ Collection f19741c;

    public d(ResultTask resultTask, Map map, Collection collection) {
        this.f19739a = resultTask;
        this.f19740b = map;
        this.f19741c = collection;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a */
    public void onResultAvailable(ResultTask resultTask, Task.Event event, Collection collection) {
        if (this.f19739a.isRunning()) {
            this.f19740b.put(resultTask, collection);
            if (this.f19740b.size() >= this.f19741c.size()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f19741c.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((Collection) this.f19740b.get((ResultTask) it.next()));
                }
                this.f19739a.sendResult(arrayList);
            }
        }
    }
}
