package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BackgroundItem.java */
/* loaded from: classes.dex */
public class i implements MediaStoreItem {
    private static Map<MSID, WeakReference<i>> f = new HashMap();
    private static int g = 0;
    private static File h = null;

    /* renamed from: a, reason: collision with root package name */
    private final MSID f3583a;
    private final String b;
    private final String c;
    private final String d;
    private final Context e;
    private transient WeakReference<Bitmap> i = null;

    public static i a(String str, Context context) {
        i iVar;
        MSID msid = new MSID("Backgrounds", str);
        WeakReference<i> weakReference = f.get(msid);
        if (weakReference == null || (iVar = weakReference.get()) == null) {
            a();
            i iVar2 = new i(msid, context);
            f.put(msid, new WeakReference<>(iVar2));
            return iVar2;
        }
        return iVar;
    }

    private static void a() {
        int i = g + 1;
        g = i;
        if (i >= 30) {
            g = 0;
            HashSet hashSet = null;
            for (Map.Entry<MSID, WeakReference<i>> entry : f.entrySet()) {
                if (entry.getValue() == null || entry.getValue().get() == null) {
                    HashSet hashSet2 = hashSet == null ? new HashSet() : hashSet;
                    hashSet2.add(entry.getKey());
                    hashSet = hashSet2;
                }
            }
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    f.remove((MSID) it.next());
                }
            }
        }
    }

    public i(MSID msid, Context context) {
        this.f3583a = msid;
        this.b = msid.getSimpleId();
        this.e = context.getApplicationContext();
        int indexOf = this.b.indexOf(46);
        if (indexOf >= 0) {
            this.c = this.b.substring(0, indexOf);
            this.d = this.b.substring(indexOf + 1);
        } else {
            this.c = this.b;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b(Context context) {
        Bitmap bitmap;
        if (this.i == null || (bitmap = this.i.get()) == null) {
            if (d()) {
                int parseLong = (int) Long.parseLong(this.b.substring(7, 15), 16);
                int[] iArr = new int[576];
                for (int i = 0; i < iArr.length; i++) {
                    iArr[i] = parseLong;
                }
                Bitmap createBitmap = Bitmap.createBitmap(iArr, 32, 18, Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    return null;
                }
                this.i = new WeakReference<>(createBitmap);
                return createBitmap;
            }
            Bitmap c = c(context);
            if (c == null) {
                return null;
            }
            this.i = new WeakReference<>(c);
            return c;
        }
        return bitmap;
    }

    private boolean d() {
        return this.b.startsWith("@solid:") && this.b.endsWith(".jpg");
    }

    private Bitmap c(Context context) {
        try {
            String d = d(context);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(d, options);
            options.inJustDecodeBounds = false;
            int i = (int) ((options.outWidth / options.outHeight) * 136.0f);
            Bitmap a2 = NexImageLoader.loadBitmap(d, i * 2, 272).a();
            if (a2 != null) {
                return Bitmap.createScaledBitmap(a2, i, 136, true);
            }
            return a2;
        } catch (IOException e) {
            Log.d("BackgroundItem", "Failed to get bg item path", e);
            return null;
        }
    }

    private String d(Context context) throws IOException {
        if (d()) {
            return this.b;
        }
        if (h == null) {
            h = new File(context.getFilesDir(), ".km_bg");
            h.mkdirs();
        }
        File file = new File(h, "bg_" + this.b.replaceAll("[^A-Za-z0-9_]", "") + this.b.hashCode() + "_." + (this.d == null ? "tmp" : this.d));
        if (!file.exists()) {
            InputStream open = context.getAssets().open("backgrounds/" + this.b);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } finally {
                    fileOutputStream.close();
                }
            } finally {
                open.close();
            }
        }
        return file.getAbsolutePath();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MediaItemType b() {
        return MediaItemType.IMAGE;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MSID c() {
        return this.f3583a;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String o() {
        return this.f3583a.getNamespace();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String a(Context context) {
        return this.c;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public Date f() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String h() {
        try {
            return d(this.e);
        } catch (IOException e) {
            return null;
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public long i() {
        return 0L;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int j() {
        return 16;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int k() {
        return 9;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int l() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int m() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean n() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public Bundle a(Class<?> cls) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean r() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int s() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean t() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MediaStoreItem.MediaSupportType p() {
        return MediaStoreItem.MediaSupportType.Supported;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public ResultTask<MediaStoreItem.MediaSupportType> q() {
        return ResultTask.completedResultTask(p());
    }
}
