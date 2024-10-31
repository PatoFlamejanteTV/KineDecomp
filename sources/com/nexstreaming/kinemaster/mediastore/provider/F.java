package com.nexstreaming.kinemaster.mediastore.provider;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import java.util.List;

/* compiled from: MediaStoreProvider.kt */
/* loaded from: classes.dex */
public interface F {

    /* renamed from: a, reason: collision with root package name */
    public static final a f20963a = a.f20964a;

    /* compiled from: MediaStoreProvider.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20964a = new a();

        private a() {
        }
    }

    /* compiled from: MediaStoreProvider.kt */
    /* loaded from: classes.dex */
    public interface b extends F {
        String c();
    }

    /* compiled from: MediaStoreProvider.kt */
    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface c {
        void onFailure();
    }

    /* compiled from: MediaStoreProvider.kt */
    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface d {
        void a(List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list);
    }

    int a(com.nexstreaming.kinemaster.mediastore.item.c cVar);

    Bitmap a(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z);

    com.nexstreaming.kinemaster.mediastore.item.c a(MediaStoreItemId mediaStoreItemId);

    List<com.nexstreaming.kinemaster.mediastore.item.c> a(QueryParams queryParams) throws Task.TaskErrorException;

    List<com.nexstreaming.kinemaster.mediastore.item.c> a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) throws Task.TaskErrorException;

    void a();

    void a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams, d dVar, c cVar);

    void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, Task task);

    com.bumptech.glide.h<?> b(com.nexstreaming.kinemaster.mediastore.item.c cVar);

    ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> b(MediaStoreItemId mediaStoreItemId);

    void b();

    void c(MediaStoreItemId mediaStoreItemId);

    String getProviderId();
}
