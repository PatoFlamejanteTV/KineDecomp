package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.QueryParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: FavoritesMediaStoreProvider.java */
/* loaded from: classes.dex */
public class k implements com.nexstreaming.kinemaster.mediastore.v2.l {

    /* renamed from: a, reason: collision with root package name */
    private static final MSID f3585a = new MSID("Favorites", "root");
    private com.nexstreaming.kinemaster.mediastore.v2.a b = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, f3585a);
    private com.nexstreaming.kinemaster.mediastore.v2.b c;
    private Context d;
    private MediaStore e;

    public k(Context context, com.nexstreaming.kinemaster.mediastore.v2.b bVar) {
        this.c = bVar;
        this.d = context.getApplicationContext();
        this.b.a(R.string.mediabrowser_favorites);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStore mediaStore) {
        this.e = mediaStore;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b() {
        this.e = null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public String a() {
        return "Favorites";
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public Bitmap a(MediaStoreItem mediaStoreItem, boolean z) {
        if (mediaStoreItem.c().equals(f3585a)) {
            return BitmapFactory.decodeResource(this.d.getResources(), R.drawable.special_folder_icon_fav);
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public int a(MediaStoreItem mediaStoreItem) {
        return mediaStoreItem.c().equals(f3585a) ? 2 : 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStoreItem mediaStoreItem, Task task) {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public MediaStoreItem a(MSID msid) {
        if (msid.equals(f3585a)) {
            return this.b;
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public ResultTask<MediaStoreItem> b(MSID msid) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(MSID msid, QueryParams queryParams) {
        if (!msid.equals(f3585a)) {
            return null;
        }
        Set<MSID> a2 = this.c.a();
        ArrayList arrayList = new ArrayList();
        ArrayList<ResultTask> arrayList2 = new ArrayList();
        for (MSID msid2 : a2) {
            MediaStoreItem a3 = this.e.a(msid2);
            if (a3 == null) {
                arrayList2.add(this.e.b(msid2));
            } else if (a3 != null && queryParams.a(a3.b())) {
                arrayList.add(a3);
            }
        }
        if (!arrayList2.isEmpty()) {
            Task combinedTask = ResultTask.combinedTask(arrayList2);
            combinedTask.makeWaitable();
            combinedTask.awaitTaskCompletion();
            for (ResultTask resultTask : arrayList2) {
                if (resultTask.didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
                    arrayList.add(resultTask.getResult());
                }
            }
        }
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(QueryParams queryParams) {
        return Collections.singletonList(this.b);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b(MediaStoreItem mediaStoreItem) {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void c() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void d() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void c(MSID msid) {
    }
}
