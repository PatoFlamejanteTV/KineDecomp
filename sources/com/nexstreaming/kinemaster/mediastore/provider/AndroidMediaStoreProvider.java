package com.nexstreaming.kinemaster.mediastore.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.item.b;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import com.nexstreaming.kinemaster.mediastore.scanner.MediaDb;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AndroidMediaStoreProvider implements F {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f20930a = MediaStore.Files.getContentUri("external");

    /* renamed from: b, reason: collision with root package name */
    private static final MediaStoreItemId f20931b = new MediaStoreItemId("AndroidMediaStore", "F/");

    /* renamed from: c, reason: collision with root package name */
    private static b.a f20932c = new j();

    /* renamed from: d, reason: collision with root package name */
    private com.nexstreaming.kinemaster.mediastore.item.b f20933d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f20934e;

    /* renamed from: f, reason: collision with root package name */
    private Context f20935f;

    /* renamed from: g, reason: collision with root package name */
    private DisplayMetrics f20936g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f20937h;
    private ContentResolver i;
    private Paint j;
    private com.bumptech.glide.j k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Column {
        _ID("_id", "_id", "_id"),
        DATA("_data", "_data", "path"),
        DISPLAY_NAME("_display_name", "_display_name", "title"),
        SIZE("_size", "_size", "size"),
        DATE_TAKEN("datetaken", "datetaken", "date_modified"),
        WIDTH("width", "width", "width"),
        HEIGHT("height", "height", "height"),
        BUCKET_ID("bucket_id", "bucket_id", "bucket_id"),
        BUCKET_DISPLAY_NAME("bucket_display_name", "bucket_display_name", "bucket_name"),
        ORIENTATION("orientation", null, "orientation"),
        DURATION(null, "duration", "duration");

        public final String amsColumn;
        public final String imageColumn;
        public final String videoColumn;

        Column(String str, String str2, String str3) {
            this.imageColumn = str;
            this.videoColumn = str2;
            this.amsColumn = str3;
        }

        public String forType(MediaItemType mediaItemType, boolean z) {
            if (z) {
                return this.amsColumn;
            }
            int i = r.f21010b[mediaItemType.ordinal()];
            if (i == 1) {
                return this.imageColumn;
            }
            if (i == 2 || i == 3) {
                return this.videoColumn;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends CursorWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final MediaItemType f20946a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f20947b;

        /* renamed from: c, reason: collision with root package name */
        private int f20948c;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, Long> f20949d;

        public b(Cursor cursor, MediaItemType mediaItemType, boolean z) {
            super(cursor);
            this.f20948c = -1;
            this.f20949d = new HashMap();
            if (cursor != null) {
                this.f20946a = mediaItemType;
                this.f20947b = z;
            } else {
                throw new NullPointerException("null media cursor : " + mediaItemType.name());
            }
        }

        public MediaItemType a() {
            return this.f20946a;
        }

        public long b() {
            String parent;
            if (this.f20948c == -1) {
                this.f20948c = a(Column.DATA);
            }
            String string = getString(this.f20948c);
            if (string == null || (parent = new File(string).getParent()) == null) {
                return 0L;
            }
            return a(parent);
        }

        public int a(Column column) {
            if (this.f20947b) {
                String str = column.amsColumn;
                if (str == null) {
                    return -1;
                }
                return super.getColumnIndex(str);
            }
            MediaItemType mediaItemType = this.f20946a;
            if (mediaItemType == MediaItemType.IMAGE) {
                String str2 = column.imageColumn;
                if (str2 == null) {
                    return -1;
                }
                return super.getColumnIndex(str2);
            }
            if (mediaItemType != MediaItemType.VIDEO && mediaItemType != MediaItemType.FILE) {
                throw new InternalError();
            }
            String str3 = column.videoColumn;
            if (str3 == null) {
                return -1;
            }
            return super.getColumnIndex(str3);
        }

        private long a(String str) {
            Long l = this.f20949d.get(str);
            if (l != null) {
                return l.longValue();
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                long j = 0;
                for (int i = 0; i < Math.min(messageDigest.digest().length, 8); i++) {
                    j = (j << 8) | (r0[i] & 255);
                }
                this.f20949d.put(str, Long.valueOf(j));
                return j;
            } catch (NoSuchAlgorithmException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public AndroidMediaStoreProvider(Context context) {
        this.j = new Paint();
        this.f20935f = context.getApplicationContext();
        this.f20936g = context.getResources().getDisplayMetrics();
        this.f20937h = EditorGlobal.a(context.getResources());
        this.i = context.getContentResolver();
        this.f20934e = false;
        this.f20933d = null;
        this.k = com.bumptech.glide.c.b(this.f20935f);
    }

    public static MediaStoreItemId a(File file) {
        if (!file.isDirectory()) {
            return b(file.getAbsolutePath());
        }
        throw new UnsupportedOperationException();
    }

    private static MediaStoreItemId b(String str) {
        return new MediaStoreItemId("AndroidMediaStore", "I" + str);
    }

    private static String d(MediaStoreItemId mediaStoreItemId) {
        if (g(mediaStoreItemId)) {
            return mediaStoreItemId.getSimpleId().substring(1);
        }
        throw new RuntimeException("not a folder");
    }

    private static String e(MediaStoreItemId mediaStoreItemId) {
        if (h(mediaStoreItemId)) {
            return mediaStoreItemId.getSimpleId().substring(1);
        }
        throw new RuntimeException("not an item");
    }

    private static boolean f(MediaStoreItemId mediaStoreItemId) {
        mediaStoreItemId.assertNamespace("AndroidMediaStore");
        return mediaStoreItemId.getSimpleId().charAt(0) == 'B';
    }

    private static boolean g(MediaStoreItemId mediaStoreItemId) {
        mediaStoreItemId.assertNamespace("AndroidMediaStore");
        return mediaStoreItemId.getSimpleId().charAt(0) == 'F';
    }

    private static boolean h(MediaStoreItemId mediaStoreItemId) {
        mediaStoreItemId.assertNamespace("AndroidMediaStore");
        return mediaStoreItemId.getSimpleId().charAt(0) == 'I';
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams, F.d dVar, F.c cVar) {
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
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public String getProviderId() {
        return "AndroidMediaStore";
    }

    private List<com.nexstreaming.kinemaster.mediastore.item.c> b(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) {
        Comparator kVar;
        ArrayList arrayList = new ArrayList();
        String d2 = d(mediaStoreItemId);
        HashMap hashMap = new HashMap();
        if (queryParams.a(MediaItemType.VIDEO)) {
            a(d2, b(queryParams, d2, MediaItemType.VIDEO, false), hashMap, arrayList);
            a(d2, b(queryParams, d2, MediaItemType.VIDEO, true), hashMap, arrayList);
        }
        if (queryParams.a(MediaItemType.IMAGE)) {
            a(d2, b(queryParams, d2, MediaItemType.IMAGE, false), hashMap, arrayList);
            a(d2, b(queryParams, d2, MediaItemType.IMAGE, true), hashMap, arrayList);
        }
        Iterator<com.nexstreaming.kinemaster.mediastore.item.b> it = hashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().o());
        }
        if (queryParams.b().length > 1) {
            int i = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
            if (r.f21009a[queryParams.c().ordinal()] != 1) {
                kVar = new l(this, i);
            } else {
                kVar = new k(this, i);
            }
            Collections.sort(arrayList, kVar);
        }
        return arrayList;
    }

    private static MediaStoreItemId a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("F");
        sb.append(str.startsWith("/") ? "" : "/");
        sb.append(str);
        sb.append(str.endsWith("/") ? "" : "/");
        return new MediaStoreItemId("AndroidMediaStore", sb.toString());
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) {
        Comparator nVar;
        if (this.f20934e && g(mediaStoreItemId)) {
            return b(mediaStoreItemId, queryParams);
        }
        ArrayList arrayList = new ArrayList();
        String d2 = d(mediaStoreItemId);
        if (queryParams.a(MediaItemType.IMAGE)) {
            a(a(queryParams, d2, MediaItemType.IMAGE, true), arrayList);
            a(a(queryParams, d2, MediaItemType.IMAGE, false), arrayList);
        }
        if (queryParams.a(MediaItemType.VIDEO)) {
            a(a(queryParams, d2, MediaItemType.VIDEO, true), arrayList);
            a(a(queryParams, d2, MediaItemType.VIDEO, false), arrayList);
        }
        if (queryParams.b().length > 1) {
            int i = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
            int i2 = r.f21009a[queryParams.c().ordinal()];
            if (i2 == 2) {
                nVar = new n(this, i);
            } else if (i2 != 3) {
                nVar = new o(this, i);
            } else {
                nVar = new m(this, i);
            }
            Collections.sort(arrayList, nVar);
        }
        return arrayList;
    }

    public AndroidMediaStoreProvider(Context context, boolean z) {
        this.j = new Paint();
        this.f20935f = context.getApplicationContext();
        this.f20936g = context.getResources().getDisplayMetrics();
        this.f20937h = EditorGlobal.a(context.getResources());
        this.i = context.getContentResolver();
        this.f20934e = z;
        if (this.f20934e) {
            this.f20933d = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.FOLDER, f20931b);
            this.f20933d.b(R.string.mediabrowser_local);
        } else {
            this.f20933d = null;
        }
        this.k = com.bumptech.glide.c.b(this.f20935f);
    }

    private b b(QueryParams queryParams, String str, MediaItemType mediaItemType, boolean z) {
        Cursor a2 = a(queryParams, 0L, str, mediaItemType, z, true);
        if (a2 == null) {
            return null;
        }
        return new b(a2, mediaItemType, z);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.bumptech.glide.h b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (this.f20934e && cVar.getId().equals(f20931b)) {
            return this.k.a(Integer.valueOf(R.drawable.special_folder_icon_bg)).a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(Integer.MIN_VALUE, Integer.MIN_VALUE));
        }
        Bundle a2 = cVar.a(AndroidMediaStoreProvider.class);
        int dimensionPixelSize = this.f20935f.getResources().getDimensionPixelSize(R.dimen.mediabrowser_item_layout_width);
        int dimensionPixelSize2 = this.f20935f.getResources().getDimensionPixelSize(R.dimen.mediabrowser_item_layout_height);
        int i = r.f21010b[cVar.getType().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            if (cVar.getPath() != null) {
                com.bumptech.glide.h<Bitmap> a3 = this.k.a();
                a3.a(cVar.getPath());
                a3.b(0.25f);
                com.bumptech.glide.h a4 = a3.a(R.drawable.n2_no_thumb_avail);
                a4.a((com.bumptech.glide.k) new com.bumptech.glide.load.resource.bitmap.f().b());
                return a4;
            }
        } else if (i == 4) {
            String string = a2.getString("thumbItemPath");
            if (!TextUtils.isEmpty(string)) {
                com.bumptech.glide.h<Bitmap> a5 = this.k.a();
                a5.a(string);
                com.bumptech.glide.h a6 = a5.a(R.drawable.n2_no_thumb_avail);
                a6.a((com.bumptech.glide.k) new com.bumptech.glide.load.resource.bitmap.f().b());
                return a6.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(dimensionPixelSize, dimensionPixelSize2).a((com.bumptech.glide.load.j<Bitmap>) new f.a.a.a.c(R.drawable.panel_media_browser_folder_item_background_fill_mask)));
            }
        }
        return this.k.a(Integer.valueOf(R.drawable.n2_no_thumb_avail));
    }

    private com.nexstreaming.kinemaster.mediastore.item.c a(b bVar, List<com.nexstreaming.kinemaster.mediastore.item.c> list) {
        int i;
        if (bVar == null) {
            return null;
        }
        bVar.moveToPosition(-1);
        a aVar = null;
        while (bVar.moveToNext()) {
            if (aVar == null) {
                aVar = a.a(bVar);
            }
            String string = bVar.getString(aVar.f20939b);
            if (!EditorGlobal.t() || string.contains("Demo")) {
                if (!EditorGlobal.f24025d || string.contains("auto_test_file")) {
                    com.nexstreaming.kinemaster.mediastore.item.b a2 = com.nexstreaming.kinemaster.mediastore.item.b.a(bVar.a(), b(string));
                    Bundle b2 = a2.b(AndroidMediaStoreProvider.class);
                    b2.putLong("bucketId", bVar.b());
                    b2.putLong("itemId", bVar.getLong(aVar.f20938a));
                    a2.a(bVar.getLong(aVar.f20942e));
                    a2.a(bVar.getString(aVar.f20940c));
                    a2.b(bVar.getLong(aVar.f20941d));
                    a2.b(string);
                    a2.c(false);
                    if (bVar.getInt(aVar.f20943f) > 0 || bVar.getInt(aVar.f20944g) > 0) {
                        a2.a(bVar.getInt(aVar.f20943f), bVar.getInt(aVar.f20944g));
                    }
                    a2.a(f20932c);
                    a2.a(true);
                    int i2 = aVar.i;
                    if (i2 >= 0) {
                        a2.g(bVar.getInt(i2));
                    }
                    int i3 = aVar.j;
                    if (i3 >= 0 && (i = bVar.getInt(i3)) > 0) {
                        a2.c(i);
                    }
                    if (bVar.a() == MediaItemType.IMAGE) {
                        a2.b(false);
                        a2.c(0);
                    }
                    if (list == null) {
                        bVar.close();
                        return a2;
                    }
                    list.add(a2);
                }
            }
        }
        bVar.close();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f20938a = -1;

        /* renamed from: b, reason: collision with root package name */
        int f20939b = -1;

        /* renamed from: c, reason: collision with root package name */
        int f20940c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f20941d = -1;

        /* renamed from: e, reason: collision with root package name */
        int f20942e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f20943f = -1;

        /* renamed from: g, reason: collision with root package name */
        int f20944g = -1;

        /* renamed from: h, reason: collision with root package name */
        int f20945h = -1;
        int i = -1;
        int j = -1;

        a() {
        }

        static a a(Cursor cursor) {
            if (cursor == null) {
                return null;
            }
            a aVar = new a();
            int columnCount = cursor.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnName = cursor.getColumnName(i);
                if (a(columnName, Column._ID)) {
                    aVar.f20938a = i;
                } else if (a(columnName, Column.DATA)) {
                    aVar.f20939b = i;
                } else if (a(columnName, Column.DISPLAY_NAME)) {
                    aVar.f20940c = i;
                } else if (a(columnName, Column.SIZE)) {
                    aVar.f20941d = i;
                } else if (a(columnName, Column.DATE_TAKEN)) {
                    aVar.f20942e = i;
                } else if (a(columnName, Column.WIDTH)) {
                    aVar.f20943f = i;
                } else if (a(columnName, Column.HEIGHT)) {
                    aVar.f20944g = i;
                } else if (a(columnName, Column.BUCKET_DISPLAY_NAME)) {
                    aVar.f20945h = i;
                } else if (a(columnName, Column.ORIENTATION)) {
                    aVar.i = i;
                } else if (a(columnName, Column.DURATION)) {
                    aVar.j = i;
                }
            }
            return aVar;
        }

        private static boolean a(String str, Column column) {
            return str.equals(column.amsColumn) || str.equals(column.videoColumn) || str.equals(column.imageColumn);
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, Task task) {
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.nexstreaming.kinemaster.mediastore.item.c a(MediaStoreItemId mediaStoreItemId) {
        com.nexstreaming.kinemaster.mediastore.item.c a2 = a(mediaStoreItemId, false);
        return a2 == null ? a(mediaStoreItemId, true) : a2;
    }

    private com.nexstreaming.kinemaster.mediastore.item.c a(MediaStoreItemId mediaStoreItemId, boolean z) {
        mediaStoreItemId.assertNamespace("AndroidMediaStore");
        if (f(mediaStoreItemId)) {
            String d2 = d(mediaStoreItemId);
            HashMap hashMap = new HashMap();
            a(a((QueryParams) null, d2, MediaItemType.VIDEO, true), hashMap);
            a(a((QueryParams) null, d2, MediaItemType.IMAGE, true), hashMap);
            a(a((QueryParams) null, d2, MediaItemType.VIDEO, false), hashMap);
            a(a((QueryParams) null, d2, MediaItemType.IMAGE, false), hashMap);
            return hashMap.get(d2).o();
        }
        if (g(mediaStoreItemId)) {
            String d3 = d(mediaStoreItemId);
            if (d3.endsWith("/") && d3.length() > 1) {
                d3 = d3.substring(0, d3.length() - 1);
            }
            HashMap hashMap2 = new HashMap();
            a(b(null, d3, MediaItemType.VIDEO, true), hashMap2);
            a(b(null, d3, MediaItemType.IMAGE, true), hashMap2);
            a(b(null, d3, MediaItemType.VIDEO, false), hashMap2);
            a(b(null, d3, MediaItemType.IMAGE, false), hashMap2);
            if (hashMap2.size() != 1) {
                for (String str : hashMap2.keySet()) {
                }
                return null;
            }
            return hashMap2.entrySet().iterator().next().getValue().o();
        }
        return a(e(mediaStoreItemId), z);
    }

    private b a(QueryParams queryParams, String str, MediaItemType mediaItemType, boolean z) {
        Cursor a2 = a(queryParams, 0L, str, mediaItemType, z, false);
        if (a2 == null) {
            return null;
        }
        return new b(a2, mediaItemType, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.database.Cursor a(com.nexstreaming.kinemaster.mediastore.QueryParams r16, long r17, java.lang.String r19, com.nexstreaming.kinemaster.mediastore.item.MediaItemType r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider.a(com.nexstreaming.kinemaster.mediastore.QueryParams, long, java.lang.String, com.nexstreaming.kinemaster.mediastore.item.MediaItemType, boolean, boolean):android.database.Cursor");
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(QueryParams queryParams) {
        Comparator pVar;
        String string;
        if (this.f20934e) {
            return a(f20931b, queryParams);
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        if (queryParams.a(MediaItemType.VIDEO)) {
            a(a(queryParams, (String) null, MediaItemType.VIDEO, true), hashMap);
            a(a(queryParams, (String) null, MediaItemType.VIDEO, false), hashMap);
        }
        if (queryParams.a(MediaItemType.IMAGE)) {
            a(a(queryParams, (String) null, MediaItemType.IMAGE, true), hashMap);
            a(a(queryParams, (String) null, MediaItemType.IMAGE, false), hashMap);
        }
        HashMap hashMap2 = new HashMap();
        HashSet hashSet = new HashSet();
        for (com.nexstreaming.kinemaster.mediastore.item.b bVar : hashMap.values()) {
            String c2 = bVar.c();
            if (c2 != null) {
                String string2 = bVar.a(AndroidMediaStoreProvider.class).getString("thumbItemPath");
                if (string2 != null) {
                    string2 = new File(string2).getParent();
                }
                if (hashMap2.containsKey(c2)) {
                    String str = (String) hashMap2.get(c2);
                    if (str == null || !str.equals(string2)) {
                        hashSet.add(c2);
                    }
                } else {
                    hashMap2.put(c2, string2);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            for (com.nexstreaming.kinemaster.mediastore.item.b bVar2 : hashMap.values()) {
                String c3 = bVar2.c();
                if (c3 != null && hashSet.contains(c3) && (string = bVar2.a(AndroidMediaStoreProvider.class).getString("thumbItemPath")) != null) {
                    File parentFile = new File(string).getParentFile();
                    if (parentFile != null) {
                        parentFile = parentFile.getParentFile();
                    }
                    if (parentFile != null) {
                        bVar2.a(parentFile.getName() + "/\n" + c3);
                    }
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        for (com.nexstreaming.kinemaster.mediastore.item.b bVar3 : hashMap.values()) {
            String string3 = bVar3.a(AndroidMediaStoreProvider.class).getString("thumbItemPath");
            if (string3 != null) {
                String parent = new File(string3).getParent();
                if (!hashSet2.contains(parent)) {
                    hashSet2.add(parent);
                }
            }
            arrayList.add(bVar3.o());
        }
        if (queryParams.b().length > 1) {
            int i = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
            if (r.f21009a[queryParams.c().ordinal()] != 1) {
                pVar = new q(this, i);
            } else {
                pVar = new p(this, i);
            }
            Collections.sort(arrayList, pVar);
        }
        return arrayList;
    }

    private String[] a(Column[] columnArr, MediaItemType mediaItemType, boolean z) {
        int i = 0;
        for (Column column : columnArr) {
            if (column.forType(mediaItemType, z) != null) {
                i++;
            }
        }
        String[] strArr = new String[i];
        int i2 = 0;
        for (Column column2 : columnArr) {
            if (column2.forType(mediaItemType, z) != null) {
                strArr[i2] = column2.forType(mediaItemType, z);
                i2++;
            }
        }
        return strArr;
    }

    private void a(String str, b bVar, Map<String, com.nexstreaming.kinemaster.mediastore.item.b> map, List<com.nexstreaming.kinemaster.mediastore.item.c> list) {
        String substring;
        int indexOf;
        int i;
        if (bVar == null) {
            return;
        }
        bVar.moveToPosition(-1);
        a aVar = null;
        while (bVar.moveToNext()) {
            if (aVar == null) {
                aVar = a.a(bVar);
            }
            long j = bVar.getLong(aVar.f20938a);
            long j2 = bVar.getLong(aVar.f20942e);
            String string = bVar.getString(aVar.f20939b);
            if (string != null && string.startsWith(str) && ((!EditorGlobal.t() || string.contains("Demo")) && ((!EditorGlobal.f24025d || string.contains("auto_test_file")) && (indexOf = (substring = string.substring(str.length())).indexOf(47)) != 0))) {
                if (indexOf < 0) {
                    String string2 = bVar.getString(aVar.f20939b);
                    com.nexstreaming.kinemaster.mediastore.item.b a2 = com.nexstreaming.kinemaster.mediastore.item.b.a(bVar.a(), b(string2));
                    Bundle b2 = a2.b(AndroidMediaStoreProvider.class);
                    b2.putLong("bucketId", bVar.b());
                    b2.putLong("itemId", bVar.getLong(aVar.f20938a));
                    a2.a(bVar.getLong(aVar.f20942e));
                    a2.a(bVar.getString(aVar.f20940c));
                    a2.b(bVar.getLong(aVar.f20941d));
                    a2.b(string2);
                    a2.c(false);
                    if (bVar.getInt(aVar.f20943f) > 0 || bVar.getInt(aVar.f20944g) > 0) {
                        a2.a(bVar.getInt(aVar.f20943f), bVar.getInt(aVar.f20944g));
                    }
                    a2.a(f20932c);
                    a2.a(true);
                    int i2 = aVar.i;
                    if (i2 >= 0) {
                        a2.g(bVar.getInt(i2));
                    }
                    int i3 = aVar.j;
                    if (i3 >= 0 && (i = bVar.getInt(i3)) > 0) {
                        a2.c(i);
                    }
                    if (bVar.a() == MediaItemType.IMAGE) {
                        a2.b(false);
                        a2.c(0);
                    }
                    list.add(a2);
                } else {
                    if (indexOf >= 0) {
                        substring = substring.substring(0, indexOf);
                    }
                    File file = new File(string);
                    int i4 = aVar.i;
                    int i5 = i4 >= 0 ? bVar.getInt(i4) : 0;
                    if (substring != null && substring.length() > 0) {
                        com.nexstreaming.kinemaster.mediastore.item.b bVar2 = map.get(substring);
                        if (bVar2 == null) {
                            bVar2 = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.FOLDER, a(str + substring));
                            bVar2.a(substring);
                            bVar2.e(0);
                            bVar2.f(0);
                            bVar2.a(Long.MIN_VALUE);
                            map.put(substring, bVar2);
                        }
                        a(bVar2, j, j2, bVar.a(), file, i5);
                    }
                }
            }
        }
        bVar.close();
    }

    private void a(b bVar, Map<String, com.nexstreaming.kinemaster.mediastore.item.b> map) {
        if (bVar == null) {
            return;
        }
        bVar.moveToPosition(-1);
        a aVar = null;
        while (bVar.moveToNext()) {
            if (aVar == null) {
                aVar = a.a(bVar);
            }
            long j = bVar.getLong(aVar.f20938a);
            long b2 = bVar.b();
            long j2 = bVar.getLong(aVar.f20942e);
            String string = bVar.getString(aVar.f20939b);
            if (string != null && (!EditorGlobal.t() || string.contains("Demo"))) {
                if (!EditorGlobal.f24025d || string.contains("auto_test_file")) {
                    File file = new File(string);
                    int i = aVar.i;
                    int i2 = i >= 0 ? bVar.getInt(i) : 0;
                    String parent = file.getParent();
                    if (b2 != 0) {
                        com.nexstreaming.kinemaster.mediastore.item.b bVar2 = map.get(parent);
                        if (bVar2 == null) {
                            bVar2 = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.FOLDER, a(parent));
                            bVar2.a(bVar.getString(aVar.f20945h));
                            bVar2.e(0);
                            bVar2.f(0);
                            bVar2.a(Long.MIN_VALUE);
                            map.put(parent, bVar2);
                        }
                        a(bVar2, j, j2, bVar.a(), file, i2);
                    }
                }
            }
        }
        bVar.close();
    }

    private Uri a(MediaItemType mediaItemType) {
        int i = r.f21010b[mediaItemType.ordinal()];
        if (i == 1) {
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        if (i == 2) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if (i != 3) {
            return null;
        }
        return f20930a;
    }

    private com.nexstreaming.kinemaster.mediastore.item.c a(String str, boolean z) {
        com.nexstreaming.kinemaster.mediastore.item.c a2 = a(str, MediaItemType.VIDEO, z);
        if (a2 != null) {
            return a2;
        }
        com.nexstreaming.kinemaster.mediastore.item.c a3 = a(str, MediaItemType.IMAGE, z);
        if (a3 != null) {
            return a3;
        }
        com.nexstreaming.kinemaster.mediastore.item.c a4 = a(str, MediaItemType.FILE, z);
        if (a4 != null) {
            return a4;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        String name = parentFile != null ? parentFile.getName() : null;
        String name2 = file.getName();
        com.nexstreaming.kinemaster.mediastore.item.c a5 = a(name2, name, MediaItemType.VIDEO, z);
        if (a5 != null) {
            return a5;
        }
        com.nexstreaming.kinemaster.mediastore.item.c a6 = a(name2, name, MediaItemType.IMAGE, z);
        if (a6 != null) {
            return a6;
        }
        return null;
    }

    private com.nexstreaming.kinemaster.mediastore.item.c a(String str, MediaItemType mediaItemType, boolean z) {
        Cursor cursor;
        MediaDb.MediaType mediaType;
        String str2;
        String str3;
        Uri a2 = a(mediaItemType);
        String[] a3 = a(Column.values(), mediaItemType, z);
        String str4 = Column.DATA.forType(mediaItemType, z) + "=?";
        String[] strArr = {str};
        String forType = Column.DATE_TAKEN.forType(mediaItemType, z);
        if (z) {
            if (mediaItemType == MediaItemType.IMAGE) {
                mediaType = MediaDb.MediaType.IMAGE;
            } else {
                mediaType = mediaItemType == MediaItemType.VIDEO ? MediaDb.MediaType.VIDEO : null;
            }
            if (mediaType != null) {
                if (str4 == null) {
                    str3 = "";
                } else {
                    str3 = str4 + " AND ";
                }
                str2 = str3 + MessengerShareContentUtility.MEDIA_TYPE + "=\"" + mediaType.name() + "\"";
            } else {
                str2 = str4;
            }
            cursor = KineMasterApplication.f24056d.o().e().query("entry", a3, str2, strArr, null, null, forType);
        } else {
            if (mediaItemType != MediaItemType.VIDEO && mediaItemType != MediaItemType.IMAGE) {
                FileType fromFile = FileType.fromFile(str);
                if (fromFile.isImage()) {
                    mediaItemType = MediaItemType.IMAGE;
                } else if (fromFile.isVideo()) {
                    mediaItemType = MediaItemType.VIDEO;
                }
            }
            try {
                cursor = this.f20935f.getContentResolver().query(a2, a3, str4, strArr, forType);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
                cursor = null;
            }
        }
        if (cursor == null) {
            return null;
        }
        return a(new b(cursor, mediaItemType, z), (List<com.nexstreaming.kinemaster.mediastore.item.c>) null);
    }

    private com.nexstreaming.kinemaster.mediastore.item.c a(String str, String str2, MediaItemType mediaItemType, boolean z) {
        String str3;
        String[] strArr;
        Cursor query;
        MediaDb.MediaType mediaType;
        String str4;
        String str5;
        Uri a2 = a(mediaItemType);
        String[] a3 = a(Column.values(), mediaItemType, z);
        if (str2 == null) {
            str3 = Column.DISPLAY_NAME.forType(mediaItemType, z) + "=?";
            strArr = new String[]{str};
        } else {
            str3 = Column.DISPLAY_NAME.forType(mediaItemType, z) + "=? AND " + Column.BUCKET_DISPLAY_NAME.forType(mediaItemType, z) + "=?";
            strArr = new String[]{str, str2};
        }
        String forType = Column.DATE_TAKEN.forType(mediaItemType, z);
        if (z) {
            if (mediaItemType == MediaItemType.IMAGE) {
                mediaType = MediaDb.MediaType.IMAGE;
            } else {
                mediaType = mediaItemType == MediaItemType.VIDEO ? MediaDb.MediaType.VIDEO : null;
            }
            if (mediaType != null) {
                if (str3 == null) {
                    str5 = "";
                } else {
                    str5 = str3 + " AND ";
                }
                str4 = str5 + MessengerShareContentUtility.MEDIA_TYPE + "=\"" + mediaType.name() + "\"";
            } else {
                str4 = str3;
            }
            query = KineMasterApplication.f24056d.o().e().query("entry", a3, str4, strArr, null, null, forType);
        } else {
            query = this.f20935f.getContentResolver().query(a2, a3, str3, strArr, forType);
        }
        if (query == null) {
            return null;
        }
        return a(new b(query, mediaItemType, z), (List<com.nexstreaming.kinemaster.mediastore.item.c>) null);
    }

    private static void a(com.nexstreaming.kinemaster.mediastore.item.b bVar, long j, long j2, MediaItemType mediaItemType, File file, int i) {
        if (j2 > bVar.l()) {
            bVar.a(j2);
            Bundle a2 = bVar.a(AndroidMediaStoreProvider.class);
            a2.putLong("thumbItemId", j);
            a2.putString("thumbItemPath", file.getAbsolutePath());
            a2.putLong("thumbItemDateTaken", j2);
            a2.putString("thumbItemMediaType", mediaItemType.name());
            a2.putInt("thumbItemOrientation", i);
        }
        if (mediaItemType == MediaItemType.VIDEO) {
            bVar.f(bVar.n() + 1);
        } else if (mediaItemType == MediaItemType.IMAGE) {
            bVar.e(bVar.m() + 1);
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public Bitmap a(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
        File file;
        MediaItemType type;
        int a2;
        int a3;
        int a4;
        int a5;
        if (this.f20934e && cVar.getId().equals(f20931b)) {
            return BitmapFactory.decodeResource(this.f20935f.getResources(), R.drawable.special_folder_icon_bg);
        }
        int orientation = cVar.getOrientation();
        Bundle a6 = cVar.a(AndroidMediaStoreProvider.class);
        int i = r.f21010b[cVar.getType().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            file = new File(cVar.getPath());
            Long.valueOf(a6.getLong("itemId"));
            type = cVar.getType();
        } else {
            if (i != 4) {
                return BitmapFactory.decodeResource(this.f20935f.getResources(), R.drawable.n2_no_thumb_avail, null);
            }
            String string = a6.getString("thumbItemPath");
            file = string == null ? null : new File(string);
            orientation = a6.getInt("thumbItemOrientation", orientation);
            Long.valueOf(a6.getLong("thumbItemId"));
            type = MediaItemType.valueOf(a6.getString("thumbItemMediaType"));
        }
        if (file != null && file.exists()) {
            MediaDb o = KineMasterApplication.f24056d.o();
            if (o == null) {
                Crashlytics.log("MediaDb is null at AndroidMediaStoreProvider::makeThumbnail");
                return BitmapFactory.decodeResource(this.f20935f.getResources(), R.drawable.n2_no_thumb_avail, null);
            }
            Bitmap a7 = o.a(file, 355, 200);
            if (a7 == null) {
                int i2 = r.f21010b[type.ordinal()];
                if (i2 == 1) {
                    if (z) {
                        a2 = EditorGlobal.a(this.f20935f, 355);
                        a3 = EditorGlobal.a(this.f20935f, 200);
                    } else if (this.f20937h) {
                        a2 = EditorGlobal.a(this.f20935f, 211);
                        a3 = EditorGlobal.a(this.f20935f, 135);
                    } else {
                        a2 = EditorGlobal.a(this.f20935f, 106);
                        a3 = EditorGlobal.a(this.f20935f, 68);
                    }
                    a7 = com.nexstreaming.kinemaster.mediastore.m.a(file, a2, a3);
                } else if (i2 == 2 || i2 == 3) {
                    if (z) {
                        a4 = EditorGlobal.a(this.f20935f, 355);
                        a5 = EditorGlobal.a(this.f20935f, 200);
                    } else if (this.f20937h) {
                        a4 = EditorGlobal.a(this.f20935f, 211);
                        a5 = EditorGlobal.a(this.f20935f, 135);
                    } else {
                        a4 = EditorGlobal.a(this.f20935f, 106);
                        a5 = EditorGlobal.a(this.f20935f, 68);
                    }
                    Bitmap a8 = com.nexstreaming.kinemaster.mediastore.m.a(file.getAbsolutePath());
                    a7 = a8 == null ? com.nexstreaming.kinemaster.mediastore.m.a(file.getAbsolutePath(), a4, a5) : a8;
                } else if (i2 == 4 || i2 == 5) {
                    throw new InternalError();
                }
            }
            if (a7 == null) {
                return BitmapFactory.decodeResource(this.f20935f.getResources(), R.drawable.n2_no_thumb_avail, null);
            }
            return NexImageLoader.rotateImage(a7, orientation);
        }
        return BitmapFactory.decodeResource(this.f20935f.getResources(), R.drawable.n2_no_thumb_avail, null);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public int a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        return (this.f20934e && cVar.getId().equals(f20931b)) ? 2 : 1;
    }
}
