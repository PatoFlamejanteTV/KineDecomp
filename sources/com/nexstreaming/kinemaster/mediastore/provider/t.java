package com.nexstreaming.kinemaster.mediastore.provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.GraphResponse;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NotImplementedError;

/* compiled from: FavoritesMediaStoreProvider.kt */
/* loaded from: classes.dex */
public final class t implements F {

    /* renamed from: e, reason: collision with root package name */
    private final com.nexstreaming.kinemaster.mediastore.item.b f21021e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f21022f;

    /* renamed from: g, reason: collision with root package name */
    private MediaStore f21023g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.j f21024h;
    private final com.nexstreaming.kinemaster.mediastore.e i;

    /* renamed from: d, reason: collision with root package name */
    public static final a f21020d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private static final String f21017a = f21017a;

    /* renamed from: a, reason: collision with root package name */
    private static final String f21017a = f21017a;

    /* renamed from: b, reason: collision with root package name */
    private static final MediaStoreItemId f21018b = new MediaStoreItemId(f21017a, "root");

    /* renamed from: c, reason: collision with root package name */
    private static final String f21019c = f21019c;

    /* renamed from: c, reason: collision with root package name */
    private static final String f21019c = f21019c;

    /* compiled from: FavoritesMediaStoreProvider.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public t(Context context, com.nexstreaming.kinemaster.mediastore.e eVar) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(eVar, "mFavoritesManager");
        this.i = eVar;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext, "context.applicationContext");
        this.f21022f = applicationContext;
        this.f21021e = com.nexstreaming.kinemaster.mediastore.item.b.n.a(MediaItemType.FOLDER, f21018b);
        this.f21021e.b(R.string.mediabrowser_favorites);
        com.bumptech.glide.j b2 = com.bumptech.glide.c.b(this.f21022f);
        kotlin.jvm.internal.h.a((Object) b2, "Glide.with(mContext)");
        this.f21024h = b2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a() {
        if (this.f21023g != null) {
            this.f21023g = null;
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, Task task) {
        kotlin.jvm.internal.h.b(cVar, "item");
        kotlin.jvm.internal.h.b(task, "taskToNotify");
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> b(MediaStoreItemId mediaStoreItemId) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void b() {
        this.f21023g = KineMasterApplication.f24058f.c().p();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void c(MediaStoreItemId mediaStoreItemId) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "itemId");
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public String getProviderId() {
        return f21017a;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.bumptech.glide.h<?> b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        if (!kotlin.jvm.internal.h.a(cVar.getId(), f21018b)) {
            return null;
        }
        com.bumptech.glide.h<Bitmap> a2 = this.f21024h.a().a(Integer.valueOf(R.drawable.special_folder_icon_fav));
        a2.a((com.bumptech.glide.k<?, ? super Bitmap>) new com.bumptech.glide.load.resource.bitmap.f().b());
        return a2.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public Bitmap a(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
        kotlin.jvm.internal.h.b(cVar, "item");
        if (kotlin.jvm.internal.h.a(cVar.getId(), f21018b)) {
            return BitmapFactory.decodeResource(this.f21022f.getResources(), R.drawable.special_folder_icon_fav);
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public int a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        return kotlin.jvm.internal.h.a(cVar.getId(), f21018b) ? 2 : 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.nexstreaming.kinemaster.mediastore.item.c a(MediaStoreItemId mediaStoreItemId) {
        if (kotlin.jvm.internal.h.a(mediaStoreItemId, f21018b)) {
            return this.f21021e;
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) {
        ArrayList arrayList = new ArrayList();
        if (this.f21023g != null && kotlin.jvm.internal.h.a(mediaStoreItemId, f21018b)) {
            Set<MediaStoreItemId> a2 = this.i.a();
            ArrayList arrayList2 = new ArrayList();
            for (MediaStoreItemId mediaStoreItemId2 : a2) {
                MediaStore mediaStore = this.f21023g;
                com.nexstreaming.kinemaster.mediastore.item.c b2 = mediaStore != null ? mediaStore.b(mediaStoreItemId2) : null;
                if (b2 == null) {
                    MediaStore mediaStore2 = this.f21023g;
                    if (mediaStore2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    arrayList2.add(mediaStore2.c(mediaStoreItemId2));
                } else if (queryParams != null) {
                    if (queryParams.a(b2.getType())) {
                        arrayList.add(b2);
                    }
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            if (!arrayList2.isEmpty()) {
                Task combinedTask = Task.combinedTask(arrayList2);
                combinedTask.makeWaitable();
                combinedTask.awaitTaskCompletion();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ResultTask resultTask = (ResultTask) it.next();
                    if (resultTask.didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
                        kotlin.jvm.internal.h.a((Object) resultTask, com.umeng.commonsdk.proguard.e.ar);
                        arrayList.add(resultTask.getResult());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(QueryParams queryParams) {
        List<com.nexstreaming.kinemaster.mediastore.item.c> a2;
        a2 = kotlin.collections.j.a(this.f21021e);
        return a2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams, F.d dVar, F.c cVar) {
        kotlin.jvm.internal.h.b(dVar, GraphResponse.SUCCESS_KEY);
        kotlin.jvm.internal.h.b(cVar, "failure");
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }
}
