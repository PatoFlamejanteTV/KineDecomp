package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.QueryParams;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BackgroundsMediaStoreProvider.java */
/* loaded from: classes.dex */
public class j implements com.nexstreaming.kinemaster.mediastore.v2.l {

    /* renamed from: a */
    private static final MSID f3584a = new MSID("Backgrounds", "root");
    private static File b;
    private com.nexstreaming.kinemaster.mediastore.v2.a c = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, f3584a);
    private Context d;

    public j(Context context) {
        this.d = context.getApplicationContext();
        this.c.a(R.string.mediabrowser_backgrounds);
    }

    public static String e() {
        return "Backgrounds";
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public String a() {
        return "Backgrounds";
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public MediaStoreItem a(MSID msid) {
        return i.a(msid.getSimpleId(), this.d);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public ResultTask<MediaStoreItem> b(MSID msid) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(MSID msid, QueryParams queryParams) throws Task.TaskErrorException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.a("@solid:FF000000.jpg", this.d));
        arrayList.add(i.a("@solid:FF555555.jpg", this.d));
        arrayList.add(i.a("@solid:FFAAAAAA.jpg", this.d));
        arrayList.add(i.a("@solid:FFFFFFFF.jpg", this.d));
        arrayList.add(i.a("@solid:FFf9b96f.jpg", this.d));
        arrayList.add(i.a("@solid:FF00a79d.jpg", this.d));
        arrayList.add(i.a("@solid:FFf8d300.jpg", this.d));
        arrayList.add(i.a("@solid:FFff5252.jpg", this.d));
        try {
            for (String str : this.d.getAssets().list("backgrounds")) {
                arrayList.add(i.a(str, this.d));
            }
        } catch (IOException e) {
            Log.e("BGndMediaStoreProvider", "Cannot get background list", e);
        }
        return arrayList;
    }

    public static MSID a(Context context, String str) {
        if (str.startsWith("@solid:")) {
            return new MSID("Backgrounds", str);
        }
        if (b == null) {
            b = new File(context.getFilesDir(), ".km_bg");
            b.mkdirs();
        }
        if (str.startsWith(b.getAbsolutePath())) {
            return new MSID("Backgrounds", new File(str).getName());
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(QueryParams queryParams) throws Task.TaskErrorException {
        return queryParams.a(MediaItemType.IMAGE) ? Collections.singletonList(this.c) : Collections.emptyList();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public Bitmap a(MediaStoreItem mediaStoreItem, boolean z) {
        return mediaStoreItem.c().equals(f3584a) ? BitmapFactory.decodeResource(this.d.getResources(), R.drawable.special_folder_icon_bg) : ((i) mediaStoreItem).b(this.d);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public int a(MediaStoreItem mediaStoreItem) {
        return mediaStoreItem.c().equals(f3584a) ? 2 : 1;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStoreItem mediaStoreItem, Task task) {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStore mediaStore) {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b(MediaStoreItem mediaStoreItem) {
        throw new IllegalArgumentException();
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
