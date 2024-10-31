package com.nexstreaming.kinemaster.mediastore.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nextreaming.nexeditorui.EditorGlobal;
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
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import kotlin.text.v;
import kotlin.text.w;

/* compiled from: BackgroundItem.kt */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: c, reason: collision with root package name */
    private static File f20904c = null;

    /* renamed from: f, reason: collision with root package name */
    private static int f20907f;

    /* renamed from: h, reason: collision with root package name */
    private final String f20909h;
    private final String i;
    private final String j;
    private final Context k;
    private transient WeakReference<Bitmap> l;
    private final MediaStoreItemId m;

    /* renamed from: g, reason: collision with root package name */
    public static final C0108a f20908g = new C0108a(null);

    /* renamed from: a, reason: collision with root package name */
    private static final String f20902a = f20902a;

    /* renamed from: a, reason: collision with root package name */
    private static final String f20902a = f20902a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f20903b = f20903b;

    /* renamed from: b, reason: collision with root package name */
    private static final String f20903b = f20903b;

    /* renamed from: d, reason: collision with root package name */
    private static final String f20905d = f20905d;

    /* renamed from: d, reason: collision with root package name */
    private static final String f20905d = f20905d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<MediaStoreItemId, WeakReference<a>> f20906e = new HashMap<>();

    /* compiled from: BackgroundItem.kt */
    /* renamed from: com.nexstreaming.kinemaster.mediastore.item.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0108a {
        private C0108a() {
        }

        private final void d() {
            a.f20907f++;
            if (a.f20907f < 30) {
                return;
            }
            a.f20907f = 0;
            HashSet hashSet = null;
            for (Map.Entry entry : a.f20906e.entrySet()) {
                MediaStoreItemId mediaStoreItemId = (MediaStoreItemId) entry.getKey();
                WeakReference weakReference = (WeakReference) entry.getValue();
                if (weakReference == null || weakReference.get() == null) {
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(mediaStoreItemId);
                }
            }
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    a.f20906e.remove((MediaStoreItemId) it.next());
                }
            }
        }

        public final String a() {
            return a.f20905d;
        }

        public final String b() {
            if (EditorGlobal.l() == 1.0f) {
                return a.f20908g.a() + "/1v1";
            }
            if (EditorGlobal.l() == 0.5625f) {
                return a.f20908g.a() + "/9v16";
            }
            return a.f20908g.a() + "/16v9";
        }

        public final String c() {
            return a() + "/16v9";
        }

        public /* synthetic */ C0108a(f fVar) {
            this();
        }

        public final a a(String str, Context context) {
            a aVar;
            h.b(str, "path");
            h.b(context, com.umeng.analytics.pro.b.Q);
            MediaStoreItemId mediaStoreItemId = new MediaStoreItemId(a.f20903b, str);
            WeakReference weakReference = (WeakReference) a.f20906e.get(mediaStoreItemId);
            if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
                return aVar;
            }
            d();
            a aVar2 = new a(mediaStoreItemId, context);
            a.f20906e.put(mediaStoreItemId, new WeakReference(aVar2));
            return aVar2;
        }
    }

    public a(MediaStoreItemId mediaStoreItemId, Context context) {
        int a2;
        h.b(mediaStoreItemId, "mId");
        h.b(context, com.umeng.analytics.pro.b.Q);
        this.m = mediaStoreItemId;
        String simpleId = this.m.getSimpleId();
        h.a((Object) simpleId, "mId.simpleId");
        this.f20909h = simpleId;
        Context applicationContext = context.getApplicationContext();
        h.a((Object) applicationContext, "context.applicationContext");
        this.k = applicationContext;
        a2 = w.a((CharSequence) this.f20909h, '.', 0, false, 6, (Object) null);
        if (a2 >= 0) {
            String str = this.f20909h;
            if (str != null) {
                String substring = str.substring(0, a2);
                h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                this.i = substring;
                String str2 = this.f20909h;
                int i = a2 + 1;
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring2 = str2.substring(i);
                h.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                this.j = substring2;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        this.i = this.f20909h;
        this.j = null;
    }

    private final String b(Context context) throws IOException {
        if (n()) {
            return this.f20909h;
        }
        if (f20904c == null) {
            f20904c = new File(context.getFilesDir(), ".km_bg");
            File file = f20904c;
            if (file == null) {
                h.a();
                throw null;
            }
            file.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bg_");
        sb.append(new Regex("[^A-Za-z0-9_]").replace(this.f20909h, ""));
        sb.append(this.f20909h.hashCode());
        sb.append("_.");
        String str = this.j;
        if (str == null) {
            str = "tmp";
        }
        sb.append((Object) str);
        File file2 = new File(f20904c, sb.toString());
        if (!file2.exists()) {
            InputStream open = context.getAssets().open(f20908g.b() + '/' + this.f20909h);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[10240];
                    while (open.available() > 0) {
                        fileOutputStream.write(bArr, 0, open.read(bArr));
                    }
                } finally {
                    fileOutputStream.close();
                }
            } finally {
                open.close();
            }
        }
        String absolutePath = file2.getAbsolutePath();
        h.a((Object) absolutePath, "extFile.absolutePath");
        return absolutePath;
    }

    private final Bitmap c(Context context) {
        try {
            String b2 = b(context);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(b2, options);
            options.inJustDecodeBounds = false;
            int i = (int) ((options.outWidth / options.outHeight) * 136);
            NexImageLoader.b loadBitmap = NexImageLoader.loadBitmap(b2, i * 2, 272);
            h.a((Object) loadBitmap, "loadedBitmap");
            Bitmap a2 = loadBitmap.a();
            return a2 != null ? Bitmap.createScaledBitmap(a2, i, 136, true) : a2;
        } catch (IOException e2) {
            Log.d(f20902a, "Failed to create bg item path", e2);
            return null;
        }
    }

    public static final String m() {
        return f20908g.c();
    }

    private final boolean n() {
        boolean b2;
        boolean a2;
        b2 = v.b(this.f20909h, "@solid:", false, 2, null);
        if (!b2) {
            return false;
        }
        a2 = v.a(this.f20909h, ".jpg", false, 2, null);
        return a2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public long a() {
        return 0L;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public Bundle a(Class<?> cls) {
        h.b(cls, "providerClass");
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int b() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public Date d() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public ResultTask<MediaSupportType> e() {
        ResultTask<MediaSupportType> completedResultTask = ResultTask.completedResultTask(g());
        h.a((Object) completedResultTask, "ResultTask.completedResultTask(getSupportType())");
        return completedResultTask;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public boolean f() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaSupportType g() {
        return MediaSupportType.Supported;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getDuration() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getHeight() {
        return 9;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaStoreItemId getId() {
        return this.m;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String getNamespace() {
        String namespace = this.m.getNamespace();
        h.a((Object) namespace, "mId.namespace");
        return namespace;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getOrientation() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String getPath() {
        try {
            return b(this.k);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaItemType getType() {
        return MediaItemType.IMAGE;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getWidth() {
        return 16;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public boolean h() {
        return false;
    }

    public final Bitmap a(Context context) {
        h.b(context, "ctx");
        WeakReference<Bitmap> weakReference = this.l;
        if (weakReference != null) {
            if (weakReference == null) {
                h.a();
                throw null;
            }
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                return bitmap;
            }
        }
        if (n()) {
            String str = this.f20909h;
            if (str != null) {
                String substring = str.substring(7, 15);
                h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseLong = (int) Long.parseLong(substring, 16);
                int[] iArr = new int[576];
                int length = iArr.length;
                for (int i = 0; i < length; i++) {
                    iArr[i] = parseLong;
                }
                Bitmap createBitmap = Bitmap.createBitmap(iArr, 32, 18, Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    return null;
                }
                this.l = new WeakReference<>(createBitmap);
                return createBitmap;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Bitmap c2 = c(context);
        if (c2 == null) {
            return null;
        }
        this.l = new WeakReference<>(c2);
        return c2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String c() {
        return this.i;
    }
}
