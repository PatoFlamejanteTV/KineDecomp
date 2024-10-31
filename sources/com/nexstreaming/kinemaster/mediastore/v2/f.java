package com.nexstreaming.kinemaster.mediastore.v2;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class f implements ResultTask.OnResultAvailableListener<List<MediaStoreItem>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3561a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ResultTask c;
    final /* synthetic */ MediaStore d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaStore mediaStore, String str, boolean z, ResultTask resultTask) {
        this.d = mediaStore;
        this.f3561a = str;
        this.b = z;
        this.c = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<MediaStoreItem>> resultTask, Task.Event event, List<MediaStoreItem> list) {
        Map map;
        map = this.d.o;
        map.put(this.f3561a, resultTask);
        if (this.b && this.c != resultTask) {
            List list2 = (List) this.c.getResult();
            if (list2.size() != list.size()) {
                this.c.sendResult(list);
                return;
            }
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            Iterator<MediaStoreItem> it = list.iterator();
            while (it.hasNext()) {
                hashSet2.add(it.next().c());
            }
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                hashSet.add(((MediaStoreItem) it2.next()).c());
            }
            if (!hashSet.equals(hashSet2)) {
                this.c.sendResult(list);
            }
        }
    }
}
