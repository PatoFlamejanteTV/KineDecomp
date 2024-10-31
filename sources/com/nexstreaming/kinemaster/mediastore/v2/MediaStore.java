package com.nexstreaming.kinemaster.mediastore.v2;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.a.a.c;
import com.nextreaming.a.a.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class MediaStore {

    /* renamed from: a, reason: collision with root package name */
    private static final MSID f3551a = new MSID("MediaStore", "Root");
    private static final MediaStoreItem b = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, f3551a);
    private static final Executor e = Executors.newCachedThreadPool();
    private static final Executor f = Executors.newFixedThreadPool(2);
    private Context c;
    private com.nextreaming.a.a.e h;
    private Map<String, l> d = new LinkedHashMap();
    private Map<MSID, List<b>> g = new HashMap();
    private WeakHashMap<l, MSID> i = new WeakHashMap<>();
    private WeakHashMap<l, c> j = new WeakHashMap<>();
    private List<b> k = new ArrayList();
    private List<WeakReference<m>> l = new ArrayList();
    private Object m = new Object();
    private Map<String, ResultTask<List<MediaStoreItem>>> n = new HashMap();
    private Map<String, ResultTask<List<MediaStoreItem>>> o = new HashMap();
    private com.nexstreaming.app.general.util.m<Object> p = new com.nexstreaming.app.general.util.m<>();
    private Set<ImageView> q = new HashSet();
    private Map<MSID, Task> r = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        Bitmap a(MediaStoreItem mediaStoreItem, Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f3553a = false;
        long b = 200000;
        long c = 15000;

        public c a(boolean z, long j, long j2) {
            this.f3553a = z;
            this.b = j;
            this.c = j2;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class UnavailableDataException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public UnavailableDataException(String str) {
            super(str);
        }
    }

    public MediaStore(Context context) {
        this.c = context.getApplicationContext();
        this.h = new com.nexstreaming.kinemaster.mediastore.v2.d(this, this.c);
    }

    public void a(FragmentManager fragmentManager, c.a aVar) {
        this.h.a(fragmentManager, aVar);
    }

    public void a() {
        if (this.h != null) {
            this.h.f();
        }
    }

    public void b() {
        if (this.h != null) {
            this.h.g();
        }
    }

    public void c() {
        this.h.a();
    }

    public void a(MediaStoreItem mediaStoreItem, a aVar) {
        if (!(mediaStoreItem instanceof b)) {
            this.h.b(new d(mediaStoreItem, aVar, mediaStoreItem.b() != MediaItemType.FOLDER));
        }
    }

    public boolean a(String str) {
        return this.d.containsKey(str);
    }

    public c a(l lVar, MSID msid) {
        String a2 = lVar.a();
        if (this.d.containsKey(a2)) {
            throw new RuntimeException("duplicate namespace");
        }
        this.d.put(a2, lVar);
        if (msid != null) {
            this.i.put(lVar, msid);
        }
        c cVar = new c();
        this.j.put(lVar, cVar);
        lVar.a(this);
        return cVar;
    }

    public void b(String str) {
        l lVar = this.d.get(str);
        if (lVar != null) {
            lVar.b();
            this.d.remove(str);
            this.i.remove(lVar);
            this.j.remove(lVar);
        }
    }

    public c a(l lVar) {
        return a(lVar, (MSID) null);
    }

    public MediaStoreItem a(MSID msid) {
        if (msid.equals(f3551a)) {
            return b;
        }
        l lVar = this.d.get(msid.getNamespace());
        if (lVar == null) {
            for (b bVar : this.k) {
                if (bVar.c().equals(msid)) {
                    return bVar;
                }
            }
            return null;
        }
        return lVar.a(msid);
    }

    public ResultTask<MediaStoreItem> b(MSID msid) {
        ResultTask<MediaStoreItem> b2;
        MediaStoreItem a2 = a(msid);
        if (a2 != null) {
            return ResultTask.completedResultTask(a2);
        }
        l lVar = this.d.get(msid.getNamespace());
        if (lVar == null || (b2 = lVar.b(msid)) == null) {
            ResultTask<MediaStoreItem> resultTask = new ResultTask<>();
            resultTask.sendFailure(MediaStoreError.ItemNotFound);
            return resultTask;
        }
        return b2;
    }

    public MediaStoreItem c(String str) {
        return a(new MSID(str));
    }

    public MediaStoreItem d() {
        return b;
    }

    private ResultTask<List<MediaStoreItem>> a(QueryParams queryParams, MSID msid) {
        int i;
        ArrayList arrayList = new ArrayList();
        List<b> list = this.g.get(msid == null ? f3551a : msid);
        int i2 = 0;
        Iterator<Map.Entry<String, l>> it = this.d.entrySet().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            l value = it.next().getValue();
            if (list != null) {
                for (b bVar : list) {
                    if (bVar.c == i) {
                        arrayList.add(ResultTask.completedResultTask(Collections.singletonList(bVar)));
                    }
                }
            }
            if (this.i.get(value) == msid) {
                arrayList.add(a(value, new QueryParams(queryParams)));
            }
            i2 = i + 1;
        }
        if (list != null) {
            for (b bVar2 : list) {
                if (bVar2.c == i) {
                    arrayList.add(ResultTask.completedResultTask(Collections.singletonList(bVar2)));
                }
            }
        }
        return arrayList.size() < 1 ? ResultTask.completedResultTask(new ArrayList()) : ResultTask.combineResults(arrayList);
    }

    public ResultTask<List<MediaStoreItem>> a(l lVar, QueryParams queryParams) {
        if (lVar == null) {
            throw new RuntimeException("unknown namespace");
        }
        if (queryParams == null) {
            queryParams = new QueryParams(MediaItemType.FOLDER, MediaItemType.IMAGE, MediaItemType.VIDEO);
        }
        queryParams.a(f3551a);
        ResultTask<List<MediaStoreItem>> resultTask = new ResultTask<>();
        new e(this, lVar, resultTask).executeOnExecutor(e, queryParams);
        return resultTask;
    }

    public ResultTask<List<MediaStoreItem>> a(MSID msid, QueryParams queryParams) {
        if (msid.equals(f3551a)) {
            return a(queryParams, (MSID) null);
        }
        Iterator<b> it = this.k.iterator();
        while (it.hasNext()) {
            if (it.next().c().equals(msid)) {
                return a(queryParams, msid);
            }
        }
        l lVar = this.d.get(msid.getNamespace());
        if (lVar == null) {
            throw new RuntimeException("unknown namespace");
        }
        if (queryParams == null) {
            queryParams = new QueryParams(MediaItemType.FOLDER, MediaItemType.IMAGE, MediaItemType.VIDEO);
        }
        queryParams.a(msid);
        c cVar = this.j.get(lVar);
        boolean z = cVar != null && cVar.f3553a;
        String a2 = z ? queryParams.a() : null;
        ResultTask<List<MediaStoreItem>> resultTask = null;
        if (z) {
            ResultTask<List<MediaStoreItem>> resultTask2 = this.o.get(a2);
            if (resultTask2 != null && !resultTask2.didSignalEvent(Task.Event.FAIL) && (resultTask2.isRunning() || resultTask2.getTimeSinceResult() < cVar.b)) {
                if (resultTask2.isRunning() || resultTask2.getTimeSinceResult() < cVar.c) {
                    return resultTask2;
                }
                resultTask = resultTask2;
            }
            ResultTask<List<MediaStoreItem>> resultTask3 = this.n.get(a2);
            if (resultTask3 != null && !resultTask3.didSignalEvent(Task.Event.FAIL) && (resultTask3.isRunning() || resultTask3.getTimeSinceResult() < cVar.b)) {
                if (resultTask == null) {
                    resultTask = resultTask3;
                }
                if (resultTask3.isRunning() || resultTask3.getTimeSinceResult() < cVar.c) {
                    return resultTask;
                }
            }
        }
        ResultTask<List<MediaStoreItem>> resultTask4 = new ResultTask<>();
        boolean z2 = resultTask != null;
        ResultTask<List<MediaStoreItem>> resultTask5 = resultTask == null ? resultTask4 : resultTask;
        ResultTask<List<MediaStoreItem>> resultTask6 = z2 ? resultTask5 : null;
        if (z) {
            this.n.put(a2, resultTask4);
            resultTask4.onResultAvailable(new f(this, a2, z2, resultTask6));
        }
        new g(this, lVar, msid, resultTask4).executeOnExecutor(e, queryParams);
        return resultTask5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends com.nexstreaming.kinemaster.mediastore.v2.a {

        /* renamed from: a, reason: collision with root package name */
        final int f3552a;
        final Bitmap b;
        final int c;

        b(MSID msid, int i, int i2, MediaItemType mediaItemType) {
            super(mediaItemType, msid);
            this.f3552a = i;
            this.b = null;
            this.c = i2;
        }

        @Override // com.nexstreaming.kinemaster.mediastore.v2.a, com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
        public MediaStoreItem.MediaSupportType p() {
            return MediaStoreItem.MediaSupportType.Supported;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements e.d {

        /* renamed from: a, reason: collision with root package name */
        final MediaStoreItem f3554a;
        final a b;
        final boolean c;

        d(MediaStoreItem mediaStoreItem, a aVar, boolean z) {
            this.f3554a = mediaStoreItem;
            this.b = aVar;
            this.c = z;
        }

        public String toString() {
            return this.f3554a.c().toString();
        }

        @Override // com.nextreaming.a.a.e.d
        public boolean a() {
            return this.c;
        }
    }

    public int a(MediaStoreItem mediaStoreItem) {
        l lVar;
        if (mediaStoreItem == null) {
            return 0;
        }
        if (mediaStoreItem instanceof b) {
            return 2;
        }
        MSID c2 = mediaStoreItem.c();
        if (!c2.equals(f3551a) && (lVar = this.d.get(c2.getNamespace())) != null) {
            return lVar.a(mediaStoreItem);
        }
        return 0;
    }

    public void a(MediaStoreItem mediaStoreItem, e.InterfaceC0082e interfaceC0082e) {
        Bitmap decodeResource;
        if (mediaStoreItem instanceof b) {
            b bVar = (b) mediaStoreItem;
            if (bVar.b != null) {
                decodeResource = bVar.b;
            } else {
                decodeResource = bVar.f3552a != 0 ? BitmapFactory.decodeResource(this.c.getResources(), bVar.f3552a) : null;
            }
            if (interfaceC0082e != null) {
                interfaceC0082e.a(decodeResource);
                return;
            }
            return;
        }
        this.h.a(new d(mediaStoreItem, null, mediaStoreItem.b() != MediaItemType.FOLDER), interfaceC0082e);
    }

    public void a(MediaStoreItem mediaStoreItem, ImageView imageView, int i, a aVar) {
        if (mediaStoreItem instanceof b) {
            b bVar = (b) mediaStoreItem;
            if (bVar.b != null) {
                if (aVar != null) {
                    imageView.setImageBitmap(aVar.a(mediaStoreItem, bVar.b));
                    return;
                } else {
                    imageView.setImageBitmap(bVar.b);
                    return;
                }
            }
            if (bVar.f3552a != 0) {
                if (aVar != null) {
                    imageView.setImageBitmap(aVar.a(mediaStoreItem, BitmapFactory.decodeResource(imageView.getResources(), bVar.f3552a)));
                    return;
                } else {
                    imageView.setImageResource(bVar.f3552a);
                    return;
                }
            }
            return;
        }
        this.h.a(new d(mediaStoreItem, aVar, mediaStoreItem.b() != MediaItemType.FOLDER), imageView, i);
    }

    public ResultTask<Bitmap> b(MediaStoreItem mediaStoreItem) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        h hVar = new h(this, this.c, resultTask);
        this.q.add(hVar);
        a(mediaStoreItem, hVar, 0, (a) null);
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(d dVar) {
        Bitmap a2 = this.d.get(dVar.f3554a.o()).a(dVar.f3554a, false);
        if (dVar.b != null) {
            return dVar.b.a(dVar.f3554a, a2);
        }
        return a2;
    }

    public void a(MSID msid, MSID msid2, int i, int i2) {
        List<b> list = this.g.get(msid2);
        if (list == null) {
            list = new ArrayList<>();
            this.g.put(msid2, list);
        }
        b bVar = new b(msid, i, this.d.size(), MediaItemType.SPECIAL);
        bVar.a(i2);
        list.add(bVar);
    }

    public void b(MSID msid, MSID msid2, int i, int i2) {
        List<b> list = this.g.get(msid2);
        if (list == null) {
            list = new ArrayList<>();
            this.g.put(msid2, list);
        }
        b bVar = new b(msid, i, this.d.size(), MediaItemType.FOLDER);
        bVar.a(i2);
        list.add(bVar);
        this.k.add(bVar);
    }

    public void c(MediaStoreItem mediaStoreItem) {
        l lVar = this.d.get(mediaStoreItem.o());
        if (lVar == null) {
            throw new RuntimeException("unknown namespace");
        }
        lVar.b(mediaStoreItem);
    }

    public void a(MSID msid, int i, int i2) {
        b(msid, f3551a, i, i2);
    }

    /* loaded from: classes.dex */
    public enum MediaStoreError implements Task.TaskError {
        DownloadTaskNotSignaled,
        DownloadResultMissing,
        DownloadCancel,
        ItemNotFound;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return name();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(MediaStoreItem mediaStoreItem) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.m) {
            for (WeakReference<m> weakReference : this.l) {
                m mVar = weakReference.get();
                if (mVar == null) {
                    arrayList.add(weakReference);
                } else {
                    arrayList2.add(mVar);
                }
            }
            this.l.removeAll(arrayList);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a(mediaStoreItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaStoreItem mediaStoreItem, Task.TaskError taskError) {
        ArrayList arrayList = new ArrayList();
        ArrayList<m> arrayList2 = new ArrayList();
        synchronized (this.m) {
            for (WeakReference<m> weakReference : this.l) {
                m mVar = weakReference.get();
                if (mVar == null) {
                    arrayList.add(weakReference);
                } else {
                    arrayList2.add(mVar);
                }
            }
            this.l.removeAll(arrayList);
        }
        for (m mVar2 : arrayList2) {
            mVar2.a(mediaStoreItem);
            mVar2.a(mediaStoreItem, taskError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(MediaStoreItem mediaStoreItem) {
        ArrayList arrayList = new ArrayList();
        ArrayList<m> arrayList2 = new ArrayList();
        synchronized (this.m) {
            for (WeakReference<m> weakReference : this.l) {
                m mVar = weakReference.get();
                if (mVar == null) {
                    arrayList.add(weakReference);
                } else {
                    arrayList2.add(mVar);
                }
            }
            this.l.removeAll(arrayList);
        }
        for (m mVar2 : arrayList2) {
            mVar2.a(mediaStoreItem);
            mVar2.b(mediaStoreItem);
        }
    }

    public boolean d(MediaStoreItem mediaStoreItem) {
        if (!mediaStoreItem.n()) {
            return false;
        }
        Task task = this.r.get(mediaStoreItem.c());
        return task != null && task.isRunning();
    }

    public boolean e(MediaStoreItem mediaStoreItem) {
        Task task = this.r.get(mediaStoreItem.c());
        return task != null && task.isRunning();
    }

    public void f(MediaStoreItem mediaStoreItem) {
        c(mediaStoreItem.c());
    }

    public void c(MSID msid) {
        Task task = this.r.get(msid);
        if (task != null && task.isRunning()) {
            l lVar = this.d.get(msid.getNamespace());
            if (lVar != null) {
                lVar.c(msid);
            } else {
                task.signalEvent(Task.Event.CANCEL);
            }
        }
    }

    public Task g(MediaStoreItem mediaStoreItem) {
        Task task = this.r.get(mediaStoreItem.c());
        if (task == null || !task.isRunning()) {
            Task task2 = new Task();
            l lVar = this.d.get(mediaStoreItem.o());
            this.r.put(mediaStoreItem.c(), task2);
            new i(this, lVar, task2, mediaStoreItem).executeOnExecutor(f, mediaStoreItem);
            return task2;
        }
        return task;
    }

    public void e() {
        Iterator<Map.Entry<String, l>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().c();
        }
    }

    public void f() {
        Iterator<Map.Entry<String, l>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().d();
        }
    }

    public l h(MediaStoreItem mediaStoreItem) {
        if (mediaStoreItem == null) {
            return null;
        }
        return this.d.get(mediaStoreItem.o());
    }
}
