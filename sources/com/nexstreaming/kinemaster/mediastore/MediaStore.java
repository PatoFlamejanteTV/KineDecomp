package com.nexstreaming.kinemaster.mediastore;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.ImageView;
import c.e.a.a.f;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import com.nexstreaming.kinemaster.mediastore.provider.GoogleDriveProvider;
import com.nexstreaming.kinemaster.mediastore.provider.s;
import com.nexstreaming.kinemaster.mediastore.provider.t;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.KineMasterApplication;
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
    public static final MediaStoreItemId f20847a = new MediaStoreItemId("CloudFolder", "_add");

    /* renamed from: b, reason: collision with root package name */
    public static final MediaStoreItemId f20848b = new MediaStoreItemId("CloudFolder", "root");

    /* renamed from: c, reason: collision with root package name */
    private static final MediaStoreItemId f20849c = new MediaStoreItemId("MediaStore", "Root");

    /* renamed from: d, reason: collision with root package name */
    private static final com.nexstreaming.kinemaster.mediastore.item.c f20850d = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.FOLDER, f20849c);

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f20851e = Executors.newCachedThreadPool();

    /* renamed from: f, reason: collision with root package name */
    private static final Executor f20852f = Executors.newFixedThreadPool(2);

    /* renamed from: g, reason: collision with root package name */
    private Context f20853g;
    private c.e.a.a.f i;

    /* renamed from: h, reason: collision with root package name */
    private Object f20854h = new Object();
    private WeakHashMap<F, MediaStoreItemId> j = new WeakHashMap<>();
    private WeakHashMap<F, e> k = new WeakHashMap<>();
    private List<b> l = new ArrayList();
    private List<WeakReference<h>> m = new ArrayList();
    private Map<String, F> n = new LinkedHashMap();
    private Map<MediaStoreItemId, List<b>> o = new HashMap();
    private Map<MediaStoreItemId, Task> p = new HashMap();

    /* loaded from: classes.dex */
    public enum MediaStoreError implements Task.TaskError {
        DownloadTaskNotSignaled,
        DownloadResultMissing,
        DownloadCancel,
        ItemNotFound,
        UnknownError;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }
    }

    /* loaded from: classes.dex */
    public static class UnavailableDataException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public UnavailableDataException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends com.nexstreaming.kinemaster.mediastore.item.b {
        final int O;
        final Bitmap P;
        final int Q;

        b(MediaStoreItemId mediaStoreItemId, int i, int i2, MediaItemType mediaItemType) {
            super(mediaItemType, mediaStoreItemId);
            this.O = i;
            this.P = null;
            this.Q = i2;
        }

        @Override // com.nexstreaming.kinemaster.mediastore.item.b, com.nexstreaming.kinemaster.mediastore.item.c
        public MediaSupportType g() {
            return MediaSupportType.Supported;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        boolean f20867a = false;

        /* renamed from: b, reason: collision with root package name */
        long f20868b = 200000;

        /* renamed from: c, reason: collision with root package name */
        long f20869c = 15000;

        e a() {
            this.f20867a = true;
            this.f20868b = 1800000L;
            this.f20869c = 15000L;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f implements f.d {

        /* renamed from: a, reason: collision with root package name */
        final com.nexstreaming.kinemaster.mediastore.item.c f20870a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f20871b;

        f(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
            this.f20870a = cVar;
            this.f20871b = z;
        }

        @Override // c.e.a.a.f.d
        public boolean a() {
            return this.f20871b;
        }

        public String toString() {
            return this.f20870a.getId().toString();
        }
    }

    private MediaStore(Context context) {
        this.f20853g = context;
        this.i = new com.nexstreaming.kinemaster.mediastore.f(this, this.f20853g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList<h> arrayList2 = new ArrayList();
        synchronized (this.f20854h) {
            for (WeakReference<h> weakReference : this.m) {
                h hVar = weakReference.get();
                if (hVar == null) {
                    arrayList.add(weakReference);
                } else {
                    arrayList2.add(hVar);
                }
            }
            this.m.removeAll(arrayList);
        }
        for (h hVar2 : arrayList2) {
            hVar2.a(cVar);
            hVar2.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.f20854h) {
            for (WeakReference<h> weakReference : this.m) {
                h hVar = weakReference.get();
                if (hVar == null) {
                    arrayList.add(weakReference);
                } else {
                    arrayList2.add(hVar);
                }
            }
            this.m.removeAll(arrayList);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(cVar);
        }
    }

    private com.bumptech.glide.h h(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        return this.n.get(cVar.getNamespace()).b(cVar);
    }

    public F c(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (cVar == null) {
            return null;
        }
        return this.n.get(cVar.getNamespace());
    }

    public int d(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        F f2;
        if (cVar == null) {
            return 0;
        }
        if (cVar instanceof b) {
            return 2;
        }
        MediaStoreItemId id = cVar.getId();
        if (id.equals(f20849c) || (f2 = this.n.get(id.getNamespace())) == null) {
            return 0;
        }
        return f2.a(cVar);
    }

    public boolean e(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        Task task;
        return cVar.h() && (task = this.p.get(cVar.getId())) != null && task.isRunning();
    }

    /* loaded from: classes.dex */
    private class c extends AsyncTask<QueryParams, Void, List<com.nexstreaming.kinemaster.mediastore.item.c>> {

        /* renamed from: a, reason: collision with root package name */
        private Task.TaskError f20859a;

        /* renamed from: b, reason: collision with root package name */
        private F f20860b;

        /* renamed from: c, reason: collision with root package name */
        private List<b> f20861c;

        /* renamed from: d, reason: collision with root package name */
        private ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> f20862d;

        public c(F f2, List<b> list, ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> resultTask) {
            this.f20860b = f2;
            this.f20861c = list;
            this.f20862d = resultTask;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.nexstreaming.kinemaster.mediastore.item.c> doInBackground(QueryParams... queryParamsArr) {
            try {
                return this.f20860b.a(queryParamsArr[0].a(), queryParamsArr[0]);
            } catch (Task.TaskErrorException e2) {
                this.f20859a = e2.getTaskError();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<com.nexstreaming.kinemaster.mediastore.item.c> list) {
            if (list != null) {
                if (this.f20861c != null) {
                    ArrayList arrayList = new ArrayList(list.size() + this.f20861c.size());
                    arrayList.addAll(this.f20861c);
                    arrayList.addAll(list);
                    this.f20862d.sendResult(arrayList);
                } else {
                    this.f20862d.sendResult(list);
                }
            } else {
                this.f20862d.sendFailure(this.f20859a);
            }
            super.onPostExecute(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends AsyncTask<QueryParams, Void, List<com.nexstreaming.kinemaster.mediastore.item.c>> {

        /* renamed from: a, reason: collision with root package name */
        private F f20864a;

        /* renamed from: b, reason: collision with root package name */
        private ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> f20865b;

        /* renamed from: c, reason: collision with root package name */
        private Task.TaskError f20866c;

        d(F f2, ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> resultTask) {
            this.f20864a = f2;
            this.f20865b = resultTask;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.nexstreaming.kinemaster.mediastore.item.c> doInBackground(QueryParams... queryParamsArr) {
            try {
                return this.f20864a.a(queryParamsArr[0]);
            } catch (Task.TaskErrorException e2) {
                this.f20866c = e2.getTaskError();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<com.nexstreaming.kinemaster.mediastore.item.c> list) {
            if (list != null) {
                this.f20865b.sendResult(list);
            } else {
                this.f20865b.sendFailure(this.f20866c);
            }
            super.onPostExecute(list);
        }
    }

    private boolean b(String str) {
        return this.n.containsKey(str);
    }

    public ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> c(MediaStoreItemId mediaStoreItemId) {
        ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> b2;
        com.nexstreaming.kinemaster.mediastore.item.c b3 = b(mediaStoreItemId);
        if (b3 != null) {
            return ResultTask.completedResultTask(b3);
        }
        F f2 = this.n.get(mediaStoreItemId.getNamespace());
        if (f2 != null && (b2 = f2.b(mediaStoreItemId)) != null) {
            return b2;
        }
        ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> resultTask = new ResultTask<>();
        resultTask.sendFailure(MediaStoreError.ItemNotFound);
        return resultTask;
    }

    private e b(F f2) {
        return a(f2, (MediaStoreItemId) null);
    }

    public static void a(Activity activity) {
        if (KineMasterApplication.f24056d.p() != null) {
            return;
        }
        MediaStore mediaStore = new MediaStore(activity);
        KineMasterApplication.f24056d.a(mediaStore);
        if (KineMasterApplication.f24056d.k() == null) {
            KineMasterApplication.f24056d.a(new com.nexstreaming.kinemaster.mediastore.e(activity));
        }
        mediaStore.b(new s(activity));
        mediaStore.b(new t(activity, KineMasterApplication.f24056d.k()));
        if (((I) activity).y().a(activity)) {
            a(mediaStore, activity);
        }
        mediaStore.b(new AndroidMediaStoreProvider(activity, PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("pref_mbrowser_hierarchy", false)));
    }

    public com.nexstreaming.kinemaster.mediastore.item.c b(MediaStoreItemId mediaStoreItemId) {
        if (mediaStoreItemId.equals(f20849c)) {
            return f20850d;
        }
        F f2 = this.n.get(mediaStoreItemId.getNamespace());
        if (f2 == null) {
            for (b bVar : this.l) {
                if (bVar.getId().equals(mediaStoreItemId)) {
                    return bVar;
                }
            }
            return null;
        }
        return f2.a(mediaStoreItemId);
    }

    public void b(MediaStoreItemId mediaStoreItemId, MediaStoreItemId mediaStoreItemId2, int i, int i2) {
        List<b> list = this.o.get(mediaStoreItemId2);
        if (list == null) {
            list = new ArrayList<>();
            this.o.put(mediaStoreItemId2, list);
        }
        b bVar = new b(mediaStoreItemId, i, this.n.size(), MediaItemType.SPECIAL);
        bVar.b(i2);
        list.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends AsyncTask<com.nexstreaming.kinemaster.mediastore.item.c, Long, Task.TaskError> {

        /* renamed from: a, reason: collision with root package name */
        private Task f20855a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<MediaStore> f20856b;

        /* renamed from: c, reason: collision with root package name */
        private F f20857c;

        /* renamed from: d, reason: collision with root package name */
        private com.nexstreaming.kinemaster.mediastore.item.c f20858d;

        a(F f2, Task task, MediaStore mediaStore) {
            this.f20857c = f2;
            this.f20855a = task;
            this.f20856b = new WeakReference<>(mediaStore);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task.TaskError doInBackground(com.nexstreaming.kinemaster.mediastore.item.c... cVarArr) {
            this.f20858d = cVarArr[0];
            Task task = new Task();
            task.makeWaitable();
            task.onProgress(new Task.OnProgressListener() { // from class: com.nexstreaming.kinemaster.mediastore.b
                @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
                public final void onProgress(Task task2, Task.Event event, int i, int i2) {
                    MediaStore.a.this.a(task2, event, i, i2);
                }
            });
            this.f20857c.a(this.f20858d, task);
            task.awaitTaskCompletion();
            if (task.isRunning()) {
                return MediaStoreError.DownloadTaskNotSignaled;
            }
            if (task.didSignalEvent(Task.Event.CANCEL)) {
                return MediaStoreError.DownloadCancel;
            }
            if (task.didSignalEvent(Task.Event.FAIL)) {
                return task.getTaskError();
            }
            if (this.f20858d.h()) {
                return MediaStoreError.DownloadResultMissing;
            }
            return null;
        }

        public /* synthetic */ void a(Task task, Task.Event event, int i, int i2) {
            publishProgress(Long.valueOf((i << 32) | (i2 & 4294967295L)));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Task.TaskError taskError) {
            super.onPostExecute(taskError);
            if (taskError == null) {
                this.f20855a.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
                this.f20856b.get().g(this.f20858d);
            } else if (taskError == MediaStoreError.DownloadCancel) {
                this.f20855a.signalEvent(Task.Event.CANCEL);
                this.f20856b.get().f(this.f20858d);
            } else {
                this.f20855a.sendFailure(taskError);
                this.f20856b.get().a(this.f20858d, taskError);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Long... lArr) {
            super.onProgressUpdate(lArr);
            long longValue = lArr[0].longValue();
            this.f20855a.setProgress((int) (longValue >> 32), (int) longValue);
            this.f20856b.get().g(this.f20858d);
        }
    }

    public boolean a(Activity activity, String str) {
        GoogleDriveProvider googleDriveProvider = new GoogleDriveProvider(activity, str);
        if (b(googleDriveProvider.getProviderId())) {
            return false;
        }
        a(googleDriveProvider, f20848b).a();
        return true;
    }

    public Task b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        Task task = this.p.get(cVar.getId());
        if (task != null && task.isRunning()) {
            return task;
        }
        Task task2 = new Task();
        F f2 = this.n.get(cVar.getNamespace());
        this.p.put(cVar.getId(), task2);
        new a(f2, task2, this).executeOnExecutor(f20852f, cVar);
        return task2;
    }

    private e a(F f2, MediaStoreItemId mediaStoreItemId) {
        String providerId = f2.getProviderId();
        if (!this.n.containsKey(providerId)) {
            this.n.put(providerId, f2);
            if (mediaStoreItemId != null) {
                this.j.put(f2, mediaStoreItemId);
            }
            e eVar = new e();
            this.k.put(f2, eVar);
            f2.b();
            return eVar;
        }
        throw new RuntimeException("duplicate namespace");
    }

    public void a(F f2) {
        if (f2 == null) {
            return;
        }
        f2.a();
        this.n.remove(f2.getProviderId());
        this.j.remove(f2);
        this.k.remove(f2);
    }

    public com.nexstreaming.kinemaster.mediastore.item.c a(String str) {
        return b(new MediaStoreItemId(str));
    }

    public com.nexstreaming.kinemaster.mediastore.item.c a() {
        return f20850d;
    }

    private ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> a(QueryParams queryParams, MediaStoreItemId mediaStoreItemId) {
        ArrayList arrayList = new ArrayList();
        List<b> list = this.o.get(mediaStoreItemId == null ? f20849c : mediaStoreItemId);
        int i = 0;
        Iterator<Map.Entry<String, F>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            F value = it.next().getValue();
            if (list != null) {
                for (b bVar : list) {
                    if (bVar.Q == i) {
                        arrayList.add(ResultTask.completedResultTask(Collections.singletonList(bVar)));
                    }
                }
            }
            if (this.j.get(value) == mediaStoreItemId) {
                arrayList.add(a(value, new QueryParams(queryParams)));
            }
            i++;
        }
        if (list != null) {
            for (b bVar2 : list) {
                if (bVar2.Q == i) {
                    arrayList.add(ResultTask.completedResultTask(Collections.singletonList(bVar2)));
                }
            }
        }
        if (arrayList.size() < 1) {
            return ResultTask.completedResultTask(new ArrayList());
        }
        return ResultTask.combineResults(arrayList);
    }

    private ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> a(F f2, QueryParams queryParams) {
        if (f2 != null) {
            if (queryParams == null) {
                queryParams = new QueryParams(MediaItemType.FOLDER, MediaItemType.IMAGE, MediaItemType.VIDEO);
            }
            queryParams.a(f20849c);
            ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> resultTask = new ResultTask<>();
            KineMasterApplication.f24056d.r();
            new d(f2, resultTask).executeOnExecutor(f20851e, queryParams);
            return resultTask;
        }
        throw new RuntimeException("unknown namespace");
    }

    @Deprecated
    public ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) {
        final ResultTask resultTask = null;
        if (mediaStoreItemId.equals(f20849c)) {
            return a(queryParams, (MediaStoreItemId) null);
        }
        Iterator<b> it = this.l.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(mediaStoreItemId)) {
                return a(queryParams, mediaStoreItemId);
            }
        }
        F f2 = this.n.get(mediaStoreItemId.getNamespace());
        if (f2 != null) {
            final boolean z = false;
            if (queryParams == null) {
                queryParams = new QueryParams(MediaItemType.FOLDER, MediaItemType.IMAGE, MediaItemType.VIDEO);
            }
            queryParams.a(mediaStoreItemId);
            e eVar = this.k.get(f2);
            boolean z2 = eVar != null && eVar.f20867a;
            final ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> resultTask2 = new ResultTask<>();
            if (z2) {
                resultTask2.onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.mediastore.a
                    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
                    public final void onResultAvailable(ResultTask resultTask3, Task.Event event, Object obj) {
                        MediaStore.a(z, resultTask, resultTask3, event, (List) obj);
                    }
                });
            }
            if (f2 instanceof F.b) {
                f2.a(mediaStoreItemId, queryParams, new F.d() { // from class: com.nexstreaming.kinemaster.mediastore.d
                    @Override // com.nexstreaming.kinemaster.mediastore.provider.F.d
                    public final void a(List list) {
                        ResultTask.this.sendResult(list);
                    }
                }, new F.c() { // from class: com.nexstreaming.kinemaster.mediastore.c
                    @Override // com.nexstreaming.kinemaster.mediastore.provider.F.c
                    public final void onFailure() {
                        ResultTask.this.sendFailure(MediaStore.MediaStoreError.UnknownError);
                    }
                });
            } else {
                new c(f2, this.o.get(mediaStoreItemId), resultTask2).executeOnExecutor(f20851e, queryParams);
            }
            return resultTask2;
        }
        throw new RuntimeException("unknown namespace");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(boolean z, ResultTask resultTask, ResultTask resultTask2, Task.Event event, List list) {
        if (!z || resultTask == resultTask2) {
            return;
        }
        List list2 = (List) resultTask.getResult();
        if (list2.size() != list.size()) {
            resultTask.sendResult(list);
            return;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet2.add(((com.nexstreaming.kinemaster.mediastore.item.c) it.next()).getId());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            hashSet.add(((com.nexstreaming.kinemaster.mediastore.item.c) it2.next()).getId());
        }
        if (hashSet.equals(hashSet2)) {
            return;
        }
        resultTask.sendResult(list);
    }

    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, f.e eVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            Bitmap bitmap = null;
            Bitmap bitmap2 = bVar.P;
            if (bitmap2 != null) {
                bitmap = bitmap2;
            } else if (bVar.O != 0) {
                bitmap = BitmapFactory.decodeResource(this.f20853g.getResources(), bVar.O);
            }
            if (eVar != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                    return;
                } else {
                    eVar.a();
                    return;
                }
            }
            return;
        }
        if (this.n.get(cVar.getNamespace()) instanceof F.b) {
            com.bumptech.glide.h<?> b2 = ((F.b) this.n.get(cVar.getNamespace())).b(cVar);
            if (b2 != null) {
                b2.a((com.bumptech.glide.h<?>) new g(this, eVar));
                return;
            } else {
                if (eVar != null) {
                    eVar.a();
                    return;
                }
                return;
            }
        }
        this.i.a(new f(cVar, cVar.getType() != MediaItemType.FOLDER), eVar);
    }

    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, ImageView imageView) {
        if (cVar == null || imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            Bitmap bitmap = bVar.P;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            int i = bVar.O;
            if (i != 0) {
                imageView.setImageResource(i);
                return;
            }
            return;
        }
        com.bumptech.glide.h h2 = h(cVar);
        if (h2 != null) {
            h2.a(imageView);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, ImageView imageView, int i) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            Bitmap bitmap = bVar.P;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            int i2 = bVar.O;
            if (i2 != 0) {
                imageView.setImageResource(i2);
                return;
            }
            return;
        }
        com.bumptech.glide.h h2 = h(cVar);
        if (h2 != null) {
            h2.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().b(i)).a(imageView);
        }
    }

    public void a(MediaStoreItemId mediaStoreItemId, MediaStoreItemId mediaStoreItemId2, int i, int i2) {
        List<b> list = this.o.get(mediaStoreItemId2);
        if (list == null) {
            list = new ArrayList<>();
            this.o.put(mediaStoreItemId2, list);
        }
        b bVar = new b(mediaStoreItemId, i, this.n.size(), MediaItemType.FOLDER);
        bVar.b(i2);
        list.add(bVar);
        this.l.add(bVar);
    }

    public void a(MediaStoreItemId mediaStoreItemId, int i, int i2) {
        a(mediaStoreItemId, f20849c, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, Task.TaskError taskError) {
        ArrayList arrayList = new ArrayList();
        ArrayList<h> arrayList2 = new ArrayList();
        synchronized (this.f20854h) {
            for (WeakReference<h> weakReference : this.m) {
                h hVar = weakReference.get();
                if (hVar == null) {
                    arrayList.add(weakReference);
                } else {
                    arrayList2.add(hVar);
                }
            }
            this.m.removeAll(arrayList);
        }
        for (h hVar2 : arrayList2) {
            hVar2.a(cVar);
            hVar2.a(cVar, taskError);
        }
    }

    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        a(cVar.getId());
    }

    public void a(MediaStoreItemId mediaStoreItemId) {
        Task task = this.p.get(mediaStoreItemId);
        if (task == null || !task.isRunning()) {
            return;
        }
        F f2 = this.n.get(mediaStoreItemId.getNamespace());
        if (f2 != null) {
            f2.c(mediaStoreItemId);
        } else {
            task.signalEvent(Task.Event.CANCEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public Bitmap a(f fVar) {
        return this.n.get(fVar.f20870a.getNamespace()).a(fVar.f20870a, false);
    }

    private static void a(MediaStore mediaStore, Activity activity) {
        mediaStore.a(f20848b, R.drawable.special_folder_icon_cloud, R.string.mediabrowser_cloudstorage);
        mediaStore.b(f20847a, f20848b, R.drawable.special_item_icon_add_gdrive, R.string.add_account);
        Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(activity).getStringSet("com.kinemaster.cloud_folder_accts", null);
        if (stringSet != null) {
            for (String str : stringSet) {
                if (TextUtils.isEmpty(str)) {
                    return;
                } else {
                    mediaStore.a(new GoogleDriveProvider(activity, str), f20848b).a();
                }
            }
        }
    }
}
