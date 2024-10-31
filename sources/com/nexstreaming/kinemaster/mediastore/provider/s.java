package com.nexstreaming.kinemaster.mediastore.provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.item.a;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.NotImplementedError;

/* compiled from: BackgroundMediaStoreProvider.kt */
/* loaded from: classes.dex */
public final class s implements F {

    /* renamed from: b, reason: collision with root package name */
    private static File f21012b;

    /* renamed from: d, reason: collision with root package name */
    private final com.nexstreaming.kinemaster.mediastore.item.b f21014d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f21015e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.j f21016f;

    /* renamed from: c, reason: collision with root package name */
    public static final a f21013c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private static final MediaStoreItemId f21011a = new MediaStoreItemId("Backgrounds", "root");

    /* compiled from: BackgroundMediaStoreProvider.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public final MediaStoreItemId a(Context context, String str) {
            boolean b2;
            boolean b3;
            kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
            kotlin.jvm.internal.h.b(str, "path");
            b2 = kotlin.text.v.b(str, "@solid:", false, 2, null);
            if (!b2) {
                if (s.f21012b == null) {
                    s.f21012b = new File(context.getFilesDir(), ".km_bg");
                    File file = s.f21012b;
                    if (file == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    file.mkdirs();
                }
                File file2 = s.f21012b;
                if (file2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                String absolutePath = file2.getAbsolutePath();
                kotlin.jvm.internal.h.a((Object) absolutePath, "sExtBGDir!!.absolutePath");
                b3 = kotlin.text.v.b(str, absolutePath, false, 2, null);
                if (b3) {
                    return new MediaStoreItemId("Backgrounds", new File(str).getName());
                }
                return null;
            }
            return new MediaStoreItemId("Backgrounds", str);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public s(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext, "context.applicationContext");
        this.f21015e = applicationContext;
        this.f21014d = com.nexstreaming.kinemaster.mediastore.item.b.n.a(MediaItemType.FOLDER, f21011a);
        this.f21014d.b(R.string.mediabrowser_backgrounds);
        com.bumptech.glide.j b2 = com.bumptech.glide.c.b(this.f21015e);
        kotlin.jvm.internal.h.a((Object) b2, "Glide.with(applicationContext)");
        this.f21016f = b2;
    }

    public static final MediaStoreItemId a(Context context, String str) {
        return f21013c.a(context, str);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, Task task) {
        kotlin.jvm.internal.h.b(cVar, "item");
        kotlin.jvm.internal.h.b(task, "taskToNotify");
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.bumptech.glide.h<?> b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        if (kotlin.jvm.internal.h.a(cVar.getId(), f21011a)) {
            com.bumptech.glide.h<Bitmap> a2 = this.f21016f.a().a(Integer.valueOf(R.drawable.special_folder_icon_bg));
            a2.a((com.bumptech.glide.k<?, ? super Bitmap>) new com.bumptech.glide.load.resource.bitmap.f().b());
            return a2.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(Integer.MIN_VALUE, Integer.MIN_VALUE));
        }
        com.bumptech.glide.h<Bitmap> a3 = this.f21016f.a();
        a3.a((com.bumptech.glide.k<?, ? super Bitmap>) new com.bumptech.glide.load.resource.bitmap.f().b());
        return a3.a(((com.nexstreaming.kinemaster.mediastore.item.a) cVar).a(this.f21015e));
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> b(MediaStoreItemId mediaStoreItemId) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void c(MediaStoreItemId mediaStoreItemId) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "itemId");
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public String getProviderId() {
        return "Backgrounds";
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams, F.d dVar, F.c cVar) {
        kotlin.jvm.internal.h.b(dVar, GraphResponse.SUCCESS_KEY);
        kotlin.jvm.internal.h.b(cVar, "failure");
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.nexstreaming.kinemaster.mediastore.item.c a(MediaStoreItemId mediaStoreItemId) {
        if (kotlin.jvm.internal.h.a(mediaStoreItemId, f21011a)) {
            return this.f21014d;
        }
        a.C0108a c0108a = com.nexstreaming.kinemaster.mediastore.item.a.f20908g;
        if (mediaStoreItemId == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        String simpleId = mediaStoreItemId.getSimpleId();
        kotlin.jvm.internal.h.a((Object) simpleId, "itemId!!.simpleId");
        return c0108a.a(simpleId, this.f21015e);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FF000000.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FF555555.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FFAAAAAA.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FFFFFFFF.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FFf9b96f.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FF00a79d.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FFf8d300.jpg", this.f21015e));
        arrayList.add(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.a("@solid:FFff5252.jpg", this.f21015e));
        try {
            list = this.f21015e.getAssets().list(com.nexstreaming.kinemaster.mediastore.item.a.f20908g.b());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (list == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a.C0108a c0108a = com.nexstreaming.kinemaster.mediastore.item.a.f20908g;
                kotlin.jvm.internal.h.a((Object) str, "filename");
                arrayList.add(c0108a.a(str, this.f21015e));
            }
        }
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(QueryParams queryParams) {
        List<com.nexstreaming.kinemaster.mediastore.item.c> a2;
        List<com.nexstreaming.kinemaster.mediastore.item.c> a3;
        if (queryParams != null) {
            if (queryParams.a(MediaItemType.IMAGE)) {
                a3 = kotlin.collections.j.a(this.f21014d);
                return a3;
            }
            a2 = kotlin.collections.k.a();
            return a2;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public Bitmap a(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
        kotlin.jvm.internal.h.b(cVar, "item");
        if (kotlin.jvm.internal.h.a(cVar.getId(), f21011a)) {
            return BitmapFactory.decodeResource(this.f21015e.getResources(), R.drawable.special_folder_icon_bg);
        }
        return ((com.nexstreaming.kinemaster.mediastore.item.a) cVar).a(this.f21015e);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public int a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        return kotlin.jvm.internal.h.a(cVar.getId(), f21011a) ? 2 : 1;
    }
}
