package com.nexstreaming.kinemaster.mediastore.v2;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.List;

/* compiled from: MediaStoreProvider.java */
/* loaded from: classes.dex */
public interface l {
    int a(MediaStoreItem mediaStoreItem);

    Bitmap a(MediaStoreItem mediaStoreItem, boolean z);

    MediaStoreItem a(MSID msid);

    String a();

    List<MediaStoreItem> a(MSID msid, QueryParams queryParams) throws Task.TaskErrorException;

    List<MediaStoreItem> a(QueryParams queryParams) throws Task.TaskErrorException;

    void a(MediaStore mediaStore);

    void a(MediaStoreItem mediaStoreItem, Task task);

    ResultTask<MediaStoreItem> b(MSID msid);

    void b();

    void b(MediaStoreItem mediaStoreItem);

    void c();

    void c(MSID msid);

    void d();
}
