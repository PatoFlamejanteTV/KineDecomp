package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [RESULT_COLLECTION] */
/* compiled from: ResultTask.java */
/* loaded from: classes.dex */
public final class d<RESULT_COLLECTION> implements ResultTask.OnResultAvailableListener<RESULT_COLLECTION> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3190a;
    final /* synthetic */ Map b;
    final /* synthetic */ Collection c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResultTask resultTask, Map map, Collection collection) {
        this.f3190a = resultTask;
        this.b = map;
        this.c = collection;
    }

    /* JADX WARN: Incorrect types in method signature: (Lcom/nexstreaming/app/general/task/ResultTask<TRESULT_COLLECTION;>;Lcom/nexstreaming/app/general/task/Task$Event;TRESULT_COLLECTION;)V */
    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask resultTask, Task.Event event, Collection collection) {
        if (this.f3190a.isRunning()) {
            this.b.put(resultTask, collection);
            if (this.b.size() >= this.c.size()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((Collection) this.b.get((ResultTask) it.next()));
                }
                this.f3190a.sendResult(arrayList);
            }
        }
    }
}
