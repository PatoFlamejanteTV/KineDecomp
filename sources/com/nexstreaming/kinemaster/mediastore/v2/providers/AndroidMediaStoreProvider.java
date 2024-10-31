package com.nexstreaming.kinemaster.mediastore.v2.providers;

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
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.QueryParams;
import com.nexstreaming.kinemaster.mediastore.v2.a;
import com.nexstreaming.kinemaster.mediastore.v2.scanner.MediaDb;
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
public class AndroidMediaStoreProvider implements com.nexstreaming.kinemaster.mediastore.v2.l {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f3569a = MediaStore.Files.getContentUri("external");
    private static final MSID c = new MSID("AndroidMediaStore", "F/");
    private static a.InterfaceC0071a j = new com.nexstreaming.kinemaster.mediastore.v2.providers.a();
    private com.nexstreaming.kinemaster.mediastore.v2.a b;
    private final boolean d;
    private Context e;
    private DisplayMetrics f;
    private boolean g;
    private ContentResolver h;
    private Paint i;

    public static MSID a(File file) {
        if (file.isDirectory()) {
            throw new UnsupportedOperationException();
        }
        return b(file.getAbsolutePath());
    }

    private static boolean d(MSID msid) {
        msid.assertNamespace("AndroidMediaStore");
        return msid.getSimpleId().charAt(0) == 'B';
    }

    private static boolean e(MSID msid) {
        msid.assertNamespace("AndroidMediaStore");
        return msid.getSimpleId().charAt(0) == 'F';
    }

    private static boolean f(MSID msid) {
        msid.assertNamespace("AndroidMediaStore");
        return msid.getSimpleId().charAt(0) == 'I';
    }

    private static MSID a(String str) {
        return new MSID("AndroidMediaStore", "F" + (str.startsWith("/") ? "" : "/") + str + (str.endsWith("/") ? "" : "/"));
    }

    private static String g(MSID msid) {
        if (!f(msid)) {
            throw new RuntimeException("not an item");
        }
        return msid.getSimpleId().substring(1);
    }

    private static String h(MSID msid) {
        if (!e(msid)) {
            throw new RuntimeException("not a folder");
        }
        return msid.getSimpleId().substring(1);
    }

    private static MSID b(String str) {
        return new MSID("AndroidMediaStore", "I" + str);
    }

    public AndroidMediaStoreProvider(Context context) {
        this.i = new Paint();
        this.e = context.getApplicationContext();
        this.f = context.getResources().getDisplayMetrics();
        this.g = EditorGlobal.a(context.getResources());
        this.h = context.getContentResolver();
        this.d = false;
        this.b = null;
    }

    public AndroidMediaStoreProvider(Context context, boolean z) {
        this.i = new Paint();
        this.e = context.getApplicationContext();
        this.f = context.getResources().getDisplayMetrics();
        this.g = EditorGlobal.a(context.getResources());
        this.h = context.getContentResolver();
        this.d = z;
        if (this.d) {
            this.b = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, c);
            this.b.a(R.string.mediabrowser_local);
        } else {
            this.b = null;
        }
    }

    public boolean e() {
        return this.d;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public String a() {
        return "AndroidMediaStore";
    }

    private List<MediaStoreItem> b(MSID msid, QueryParams queryParams) {
        Comparator bVar;
        ArrayList arrayList = new ArrayList();
        String h = h(msid);
        HashMap hashMap = new HashMap();
        if (queryParams.a(MediaItemType.VIDEO)) {
            a(h, b(queryParams, h, MediaItemType.VIDEO, false), hashMap, arrayList);
            a(h, b(queryParams, h, MediaItemType.VIDEO, true), hashMap, arrayList);
        }
        if (queryParams.a(MediaItemType.IMAGE)) {
            a(h, b(queryParams, h, MediaItemType.IMAGE, false), hashMap, arrayList);
            a(h, b(queryParams, h, MediaItemType.IMAGE, true), hashMap, arrayList);
        }
        Iterator<com.nexstreaming.kinemaster.mediastore.v2.a> it = hashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        if (queryParams.b().length > 1) {
            int i = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
            switch (queryParams.c()) {
                case DATE:
                    bVar = new com.nexstreaming.kinemaster.mediastore.v2.providers.b(this, i);
                    break;
                default:
                    bVar = new c(this, i);
                    break;
            }
            Collections.sort(arrayList, bVar);
        }
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(MSID msid, QueryParams queryParams) {
        Comparator eVar;
        if (this.d && e(msid)) {
            return b(msid, queryParams);
        }
        ArrayList arrayList = new ArrayList();
        String h = h(msid);
        if (queryParams.a(MediaItemType.IMAGE)) {
            a(a(queryParams, h, MediaItemType.IMAGE, true), arrayList);
            a(a(queryParams, h, MediaItemType.IMAGE, false), arrayList);
        }
        if (queryParams.a(MediaItemType.VIDEO)) {
            a(a(queryParams, h, MediaItemType.VIDEO, true), arrayList);
            a(a(queryParams, h, MediaItemType.VIDEO, false), arrayList);
        }
        if (queryParams.b().length > 1) {
            int i = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
            switch (queryParams.c()) {
                case DISPLAY_NAME:
                    eVar = new e(this, i);
                    break;
                case SIZE:
                    eVar = new d(this, i);
                    break;
                default:
                    eVar = new f(this, i);
                    break;
            }
            Collections.sort(arrayList, eVar);
        }
        return arrayList;
    }

    private MediaStoreItem a(b bVar, List<MediaStoreItem> list) {
        if (bVar == null) {
            return null;
        }
        bVar.moveToPosition(-1);
        a aVar = null;
        while (bVar.moveToNext()) {
            if (aVar == null) {
                aVar = a.a(bVar);
            }
            String string = bVar.getString(aVar.b);
            com.nexstreaming.kinemaster.mediastore.v2.a a2 = com.nexstreaming.kinemaster.mediastore.v2.a.a(bVar.a(), b(string));
            Bundle b2 = a2.b(AndroidMediaStoreProvider.class);
            b2.putLong("bucketId", bVar.b());
            b2.putLong("itemId", bVar.getLong(aVar.f3571a));
            a2.b(bVar.getLong(aVar.e));
            a2.a(bVar.getString(aVar.c));
            a2.c(bVar.getLong(aVar.d));
            a2.b(string);
            a2.a(false);
            if (bVar.getInt(aVar.f) > 0 || bVar.getInt(aVar.g) > 0) {
                a2.a(bVar.getInt(aVar.f), bVar.getInt(aVar.g));
            }
            if (bVar.a() == MediaItemType.IMAGE) {
                a2.c(false);
            }
            a2.a(j);
            a2.b(true);
            if (aVar.i >= 0) {
                a2.d(bVar.getInt(aVar.i));
            }
            if (aVar.j >= 0) {
                a2.e(bVar.getInt(aVar.j));
            }
            if (list == null) {
                bVar.close();
                return a2;
            }
            list.add(a2);
        }
        bVar.close();
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b(MediaStoreItem mediaStoreItem) {
        Uri uri;
        String str;
        if (mediaStoreItem != null) {
            switch (mediaStoreItem.b()) {
                case IMAGE:
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    str = "_data=?";
                    break;
                case VIDEO:
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    str = "_data=?";
                    break;
                default:
                    return;
            }
            String[] strArr = {mediaStoreItem.h()};
            if (this.e.getContentResolver().delete(uri, str, strArr) > 0) {
                Log.i("AndroidMediaStorePvdr", "Deleted media = " + mediaStoreItem.h());
                return;
            }
            if (this.e.getContentResolver().delete(f3569a, str, strArr) > 0) {
                Log.i("AndroidMediaStorePvdr", "Deleted media = " + mediaStoreItem.h() + " in Exteranl File uri");
                File file = new File(mediaStoreItem.h());
                if (file.exists()) {
                    Log.i("AndroidMediaStorePvdr", "Deleted file is still existing.");
                    file.delete();
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void c() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void d() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStoreItem mediaStoreItem, Task task) {
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public MediaStoreItem a(MSID msid) {
        MediaStoreItem a2 = a(msid, false);
        if (a2 == null) {
            return a(msid, true);
        }
        return a2;
    }

    private MediaStoreItem a(MSID msid, boolean z) {
        msid.assertNamespace("AndroidMediaStore");
        if (d(msid)) {
            String h = h(msid);
            HashMap hashMap = new HashMap();
            a(a((QueryParams) null, h, MediaItemType.VIDEO, true), hashMap);
            a(a((QueryParams) null, h, MediaItemType.IMAGE, true), hashMap);
            a(a((QueryParams) null, h, MediaItemType.VIDEO, false), hashMap);
            a(a((QueryParams) null, h, MediaItemType.IMAGE, false), hashMap);
            return hashMap.get(h).a();
        }
        if (e(msid)) {
            String h2 = h(msid);
            if (h2.endsWith("/") && h2.length() > 1) {
                h2 = h2.substring(0, h2.length() - 1);
            }
            HashMap hashMap2 = new HashMap();
            a(b(null, h2, MediaItemType.VIDEO, true), hashMap2);
            a(b(null, h2, MediaItemType.IMAGE, true), hashMap2);
            a(b(null, h2, MediaItemType.VIDEO, false), hashMap2);
            a(b(null, h2, MediaItemType.IMAGE, false), hashMap2);
            if (hashMap2.size() != 1) {
                for (String str : hashMap2.keySet()) {
                }
                return null;
            }
            return hashMap2.entrySet().iterator().next().getValue().a();
        }
        return a(g(msid), z);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public ResultTask<MediaStoreItem> b(MSID msid) {
        return null;
    }

    private b a(QueryParams queryParams, String str, MediaItemType mediaItemType, boolean z) {
        Cursor a2 = a(queryParams, 0L, str, mediaItemType, z, false);
        if (a2 == null) {
            return null;
        }
        return new b(a2, mediaItemType, z);
    }

    private b b(QueryParams queryParams, String str, MediaItemType mediaItemType, boolean z) {
        Cursor a2 = a(queryParams, 0L, str, mediaItemType, z, true);
        if (a2 == null) {
            return null;
        }
        return new b(a2, mediaItemType, z);
    }

    private Cursor a(QueryParams queryParams, long j2, String str, MediaItemType mediaItemType, boolean z, boolean z2) {
        Cursor query;
        MediaDb.MediaType mediaType;
        String str2;
        String str3 = null;
        String[] strArr = null;
        Uri a2 = a(mediaItemType);
        String[] a3 = a(Column.values(), mediaItemType, z);
        if (j2 != 0) {
            str3 = Column.BUCKET_ID.forType(mediaItemType, z) + "=?";
            strArr = new String[]{String.valueOf(j2)};
        } else if (str != null) {
            String forType = Column.DATA.forType(mediaItemType, z);
            String replace = str.replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
            if (!replace.endsWith(File.separator)) {
                replace = replace + File.separator;
            }
            str3 = forType + " LIKE ? ESCAPE '\\'";
            if (!z2) {
                str3 = str3 + " AND SUBSTR(" + forType + ", " + (replace.length() + 1) + ") NOT LIKE '%/%'";
            }
            strArr = new String[]{replace + "%"};
        }
        String str4 = null;
        if (queryParams != null) {
            switch (queryParams.c()) {
                case DATE:
                    str4 = Column.DATE_TAKEN.forType(mediaItemType, z);
                    break;
                case DISPLAY_NAME:
                    str4 = Column.DISPLAY_NAME.forType(mediaItemType, z);
                    break;
                case SIZE:
                    str4 = Column.SIZE.forType(mediaItemType, z);
                    break;
            }
        }
        if (str4 != null) {
            str4 = str4 + " " + queryParams.d().name();
        }
        if (z) {
            if (mediaItemType == MediaItemType.IMAGE) {
                mediaType = MediaDb.MediaType.IMAGE;
            } else if (mediaItemType != MediaItemType.VIDEO) {
                mediaType = null;
            } else {
                mediaType = MediaDb.MediaType.VIDEO;
            }
            if (mediaType != null) {
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3 + " AND ";
                }
                str3 = str2 + "media_type=\"" + mediaType.name() + "\"";
            }
            query = KineMasterApplication.a().d().f().query("entry", a3, str3, strArr, null, null, str4);
        } else {
            query = this.e.getContentResolver().query(a2, a3, str3, strArr, str4);
        }
        if (query != null && !query.moveToFirst()) {
            query.close();
            return null;
        }
        return query;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(QueryParams queryParams) {
        Comparator gVar;
        String string;
        if (this.d) {
            return a(c, queryParams);
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
        for (com.nexstreaming.kinemaster.mediastore.v2.a aVar : hashMap.values()) {
            String a2 = aVar.a((Context) null);
            if (a2 != null) {
                String string2 = aVar.a(AndroidMediaStoreProvider.class).getString("thumbItemPath");
                String parent = string2 != null ? new File(string2).getParent() : string2;
                if (hashMap2.containsKey(a2)) {
                    String str = (String) hashMap2.get(a2);
                    if (str == null || !str.equals(parent)) {
                        hashSet.add(a2);
                    }
                } else {
                    hashMap2.put(a2, parent);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            for (com.nexstreaming.kinemaster.mediastore.v2.a aVar2 : hashMap.values()) {
                String a3 = aVar2.a((Context) null);
                if (a3 != null && hashSet.contains(a3) && (string = aVar2.a(AndroidMediaStoreProvider.class).getString("thumbItemPath")) != null) {
                    File parentFile = new File(string).getParentFile();
                    if (parentFile != null) {
                        parentFile = parentFile.getParentFile();
                    }
                    if (parentFile != null) {
                        aVar2.a(parentFile.getName() + "/\n" + a3);
                    }
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        for (com.nexstreaming.kinemaster.mediastore.v2.a aVar3 : hashMap.values()) {
            String string3 = aVar3.a(AndroidMediaStoreProvider.class).getString("thumbItemPath");
            if (string3 != null) {
                String parent2 = new File(string3).getParent();
                if (!hashSet2.contains(parent2)) {
                    hashSet2.add(parent2);
                }
            }
            arrayList.add(aVar3.a());
        }
        if (queryParams.b().length > 1) {
            int i = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
            switch (queryParams.c()) {
                case DATE:
                    gVar = new g(this, i);
                    break;
                default:
                    gVar = new h(this, i);
                    break;
            }
            Collections.sort(arrayList, gVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends CursorWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final MediaItemType f3572a;
        private boolean b;
        private int c;
        private Map<String, Long> d;

        public b(Cursor cursor, MediaItemType mediaItemType, boolean z) {
            super(cursor);
            this.c = -1;
            this.d = new HashMap();
            if (cursor == null) {
                throw new NullPointerException("null media cursor : " + mediaItemType.name());
            }
            this.f3572a = mediaItemType;
            this.b = z;
        }

        public MediaItemType a() {
            return this.f3572a;
        }

        public long b() {
            if (this.c == -1) {
                this.c = a(Column.DATA);
            }
            String string = getString(this.c);
            if (string == null) {
                return 0L;
            }
            return a(new File(string).getParent());
        }

        public int a(Column column) {
            if (this.b) {
                if (column.amsColumn == null) {
                    return -1;
                }
                return super.getColumnIndex(column.amsColumn);
            }
            if (this.f3572a == MediaItemType.IMAGE) {
                if (column.imageColumn != null) {
                    return super.getColumnIndex(column.imageColumn);
                }
                return -1;
            }
            if (this.f3572a == MediaItemType.VIDEO || this.f3572a == MediaItemType.FILE) {
                if (column.videoColumn != null) {
                    return super.getColumnIndex(column.videoColumn);
                }
                return -1;
            }
            throw new InternalError();
        }

        private long a(String str) {
            Long l = this.d.get(str);
            if (l != null) {
                return l.longValue();
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                int min = Math.min(messageDigest.digest().length, 8);
                long j = 0;
                int i = 0;
                while (i < min) {
                    long j2 = (r6[i] & 255) | (j << 8);
                    i++;
                    j = j2;
                }
                this.d.put(str, Long.valueOf(j));
                return j;
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f3571a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        int e = -1;
        int f = -1;
        int g = -1;
        int h = -1;
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
                    aVar.f3571a = i;
                } else if (a(columnName, Column.DATA)) {
                    aVar.b = i;
                } else if (a(columnName, Column.DISPLAY_NAME)) {
                    aVar.c = i;
                } else if (a(columnName, Column.SIZE)) {
                    aVar.d = i;
                } else if (a(columnName, Column.DATE_TAKEN)) {
                    aVar.e = i;
                } else if (a(columnName, Column.WIDTH)) {
                    aVar.f = i;
                } else if (a(columnName, Column.HEIGHT)) {
                    aVar.g = i;
                } else if (a(columnName, Column.BUCKET_DISPLAY_NAME)) {
                    aVar.h = i;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Column {
        _ID("_id", "_id", "_id"),
        DATA("_data", "_data", "path"),
        DISPLAY_NAME("_display_name", "_display_name", ShareConstants.WEB_DIALOG_PARAM_TITLE),
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

        public String forType(MediaItemType mediaItemType, boolean z) {
            if (z) {
                return this.amsColumn;
            }
            switch (mediaItemType) {
                case IMAGE:
                    return this.imageColumn;
                case VIDEO:
                case FILE:
                    return this.videoColumn;
                default:
                    return null;
            }
        }

        Column(String str, String str2, String str3) {
            this.imageColumn = str;
            this.videoColumn = str2;
            this.amsColumn = str3;
        }
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

    private void a(String str, b bVar, Map<String, com.nexstreaming.kinemaster.mediastore.v2.a> map, List<MediaStoreItem> list) {
        String substring;
        int indexOf;
        if (bVar != null) {
            bVar.moveToPosition(-1);
            a aVar = null;
            while (true) {
                a aVar2 = aVar;
                if (bVar.moveToNext()) {
                    aVar = aVar2 == null ? a.a(bVar) : aVar2;
                    long j2 = bVar.getLong(aVar.f3571a);
                    long j3 = bVar.getLong(aVar.e);
                    String string = bVar.getString(aVar.b);
                    if (string != null && string.startsWith(str) && (indexOf = (substring = string.substring(str.length())).indexOf(47)) != 0) {
                        if (indexOf < 0) {
                            String string2 = bVar.getString(aVar.b);
                            com.nexstreaming.kinemaster.mediastore.v2.a a2 = com.nexstreaming.kinemaster.mediastore.v2.a.a(bVar.a(), b(string2));
                            Bundle b2 = a2.b(AndroidMediaStoreProvider.class);
                            b2.putLong("bucketId", bVar.b());
                            b2.putLong("itemId", bVar.getLong(aVar.f3571a));
                            a2.b(bVar.getLong(aVar.e));
                            a2.a(bVar.getString(aVar.c));
                            a2.c(bVar.getLong(aVar.d));
                            a2.b(string2);
                            a2.a(false);
                            if (bVar.getInt(aVar.f) > 0 || bVar.getInt(aVar.g) > 0) {
                                a2.a(bVar.getInt(aVar.f), bVar.getInt(aVar.g));
                            }
                            if (bVar.a() == MediaItemType.IMAGE) {
                                a2.c(false);
                            }
                            a2.a(j);
                            a2.b(true);
                            if (aVar.i >= 0) {
                                a2.d(bVar.getInt(aVar.i));
                            }
                            if (aVar.j >= 0) {
                                a2.e(bVar.getInt(aVar.j));
                            }
                            list.add(a2);
                        } else {
                            String substring2 = indexOf >= 0 ? substring.substring(0, indexOf) : substring;
                            File file = new File(string);
                            int i = 0;
                            if (aVar.i >= 0) {
                                i = bVar.getInt(aVar.i);
                            }
                            if (substring2 != null && substring2.length() > 0) {
                                com.nexstreaming.kinemaster.mediastore.v2.a aVar3 = map.get(substring2);
                                if (aVar3 == null) {
                                    aVar3 = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, a(str + substring2));
                                    aVar3.a(substring2);
                                    aVar3.c(0);
                                    aVar3.b(0);
                                    aVar3.b(Long.MIN_VALUE);
                                    map.put(substring2, aVar3);
                                }
                                a(aVar3, j2, j3, bVar.a(), file, i);
                            }
                        }
                    }
                } else {
                    bVar.close();
                    return;
                }
            }
        }
    }

    private void a(b bVar, Map<String, com.nexstreaming.kinemaster.mediastore.v2.a> map) {
        com.nexstreaming.kinemaster.mediastore.v2.a aVar;
        if (bVar != null) {
            bVar.moveToPosition(-1);
            a aVar2 = null;
            while (true) {
                a aVar3 = aVar2;
                if (bVar.moveToNext()) {
                    aVar2 = aVar3 == null ? a.a(bVar) : aVar3;
                    long j2 = bVar.getLong(aVar2.f3571a);
                    long b2 = bVar.b();
                    long j3 = bVar.getLong(aVar2.e);
                    String string = bVar.getString(aVar2.b);
                    if (string != null) {
                        File file = new File(string);
                        int i = 0;
                        if (aVar2.i >= 0) {
                            i = bVar.getInt(aVar2.i);
                        }
                        String parent = file.getParent();
                        if (b2 != 0) {
                            com.nexstreaming.kinemaster.mediastore.v2.a aVar4 = map.get(parent);
                            if (aVar4 == null) {
                                aVar = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, a(parent));
                                aVar.a(bVar.getString(aVar2.h));
                                aVar.c(0);
                                aVar.b(0);
                                aVar.b(Long.MIN_VALUE);
                                map.put(parent, aVar);
                            } else {
                                aVar = aVar4;
                            }
                            a(aVar, j2, j3, bVar.a(), file, i);
                        }
                    }
                } else {
                    bVar.close();
                    return;
                }
            }
        }
    }

    private Uri a(MediaItemType mediaItemType) {
        switch (mediaItemType) {
            case IMAGE:
                return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            case VIDEO:
                return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            case FILE:
                return f3569a;
            default:
                return null;
        }
    }

    private MediaStoreItem a(String str, boolean z) {
        MediaStoreItem a2 = a(str, MediaItemType.VIDEO, z);
        if (a2 != null) {
            return a2;
        }
        MediaStoreItem a3 = a(str, MediaItemType.IMAGE, z);
        if (a3 != null) {
            return a3;
        }
        MediaStoreItem a4 = a(str, MediaItemType.FILE, z);
        if (a4 != null) {
            return a4;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        String name = parentFile != null ? parentFile.getName() : null;
        String name2 = file.getName();
        MediaStoreItem a5 = a(name2, name, MediaItemType.VIDEO, z);
        if (a5 != null) {
            return a5;
        }
        MediaStoreItem a6 = a(name2, name, MediaItemType.IMAGE, z);
        if (a6 != null) {
            return a6;
        }
        return null;
    }

    private MediaStoreItem a(String str, MediaItemType mediaItemType, boolean z) {
        Cursor cursor;
        MediaDb.MediaType mediaType;
        String str2;
        Uri a2 = a(mediaItemType);
        String[] a3 = a(Column.values(), mediaItemType, z);
        String str3 = Column.DATA.forType(mediaItemType, z) + "=?";
        String[] strArr = {str};
        String forType = Column.DATE_TAKEN.forType(mediaItemType, z);
        if (z) {
            if (mediaItemType == MediaItemType.IMAGE) {
                mediaType = MediaDb.MediaType.IMAGE;
            } else if (mediaItemType != MediaItemType.VIDEO) {
                mediaType = null;
            } else {
                mediaType = MediaDb.MediaType.VIDEO;
            }
            if (mediaType != null) {
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3 + " AND ";
                }
                str3 = str2 + "media_type=\"" + mediaType.name() + "\"";
            }
            cursor = KineMasterApplication.a().d().f().query("entry", a3, str3, strArr, null, null, forType);
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
                cursor = this.e.getContentResolver().query(a2, a3, str3, strArr, forType);
            } catch (SQLiteException e) {
                e.printStackTrace();
                cursor = null;
            }
        }
        return a(new b(cursor, mediaItemType, z), (List<MediaStoreItem>) null);
    }

    private MediaStoreItem a(String str, String str2, MediaItemType mediaItemType, boolean z) {
        String str3;
        String[] strArr;
        Cursor query;
        MediaDb.MediaType mediaType;
        String str4;
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
            } else if (mediaItemType != MediaItemType.VIDEO) {
                mediaType = null;
            } else {
                mediaType = MediaDb.MediaType.VIDEO;
            }
            if (mediaType != null) {
                if (str3 == null) {
                    str4 = "";
                } else {
                    str4 = str3 + " AND ";
                }
                str3 = str4 + "media_type=\"" + mediaType.name() + "\"";
            }
            query = KineMasterApplication.a().d().f().query("entry", a3, str3, strArr, null, null, forType);
        } else {
            query = this.e.getContentResolver().query(a2, a3, str3, strArr, forType);
        }
        return a(new b(query, mediaItemType, z), (List<MediaStoreItem>) null);
    }

    private static void a(com.nexstreaming.kinemaster.mediastore.v2.a aVar, long j2, long j3, MediaItemType mediaItemType, File file, int i) {
        if (j3 > aVar.g()) {
            aVar.b(j3);
            Bundle a2 = aVar.a(AndroidMediaStoreProvider.class);
            a2.putLong("thumbItemId", j2);
            a2.putString("thumbItemPath", file.getAbsolutePath());
            a2.putLong("thumbItemDateTaken", j3);
            a2.putString("thumbItemMediaType", mediaItemType.name());
            a2.putInt("thumbItemOrientation", i);
        }
        if (mediaItemType == MediaItemType.VIDEO) {
            aVar.b(aVar.d() + 1);
        } else if (mediaItemType == MediaItemType.IMAGE) {
            aVar.c(aVar.e() + 1);
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public Bitmap a(MediaStoreItem mediaStoreItem, boolean z) {
        MediaItemType valueOf;
        File file;
        int a2;
        int a3;
        int a4;
        int a5;
        if (this.d && mediaStoreItem.c().equals(c)) {
            return BitmapFactory.decodeResource(this.e.getResources(), R.drawable.special_folder_icon_bg);
        }
        int l = mediaStoreItem.l();
        Bundle a6 = mediaStoreItem.a(AndroidMediaStoreProvider.class);
        switch (mediaStoreItem.b()) {
            case IMAGE:
            case VIDEO:
            case FILE:
                File file2 = new File(mediaStoreItem.h());
                Long.valueOf(a6.getLong("itemId"));
                file = file2;
                valueOf = mediaStoreItem.b();
                break;
            case FOLDER:
                String string = a6.getString("thumbItemPath");
                File file3 = string == null ? null : new File(string);
                Long.valueOf(a6.getLong("thumbItemId"));
                valueOf = MediaItemType.valueOf(a6.getString("thumbItemMediaType"));
                file = file3;
                break;
            default:
                return BitmapFactory.decodeResource(this.e.getResources(), R.drawable.n2_no_thumb_avail, null);
        }
        if (file == null || !file.exists()) {
            return BitmapFactory.decodeResource(this.e.getResources(), R.drawable.n2_no_thumb_avail, null);
        }
        Bitmap a7 = KineMasterApplication.a().d().a(file, 355, 200);
        if (a7 == null) {
            switch (valueOf) {
                case IMAGE:
                    if (z) {
                        a4 = EditorGlobal.a(this.e, 355);
                        a5 = EditorGlobal.a(this.e, 200);
                    } else if (this.g) {
                        a4 = EditorGlobal.a(this.e, 211);
                        a5 = EditorGlobal.a(this.e, 135);
                    } else {
                        a4 = EditorGlobal.a(this.e, 106);
                        a5 = EditorGlobal.a(this.e, 68);
                    }
                    a7 = com.nexstreaming.kinemaster.mediastore.v2.p.a(file, a4, a5);
                    if (a7 != null) {
                    }
                    break;
                case VIDEO:
                case FILE:
                    if (z) {
                        a2 = EditorGlobal.a(this.e, 355);
                        a3 = EditorGlobal.a(this.e, 200);
                    } else if (this.g) {
                        a2 = EditorGlobal.a(this.e, 211);
                        a3 = EditorGlobal.a(this.e, 135);
                    } else {
                        a2 = EditorGlobal.a(this.e, 106);
                        a3 = EditorGlobal.a(this.e, 68);
                    }
                    Bitmap a8 = com.nexstreaming.kinemaster.mediastore.v2.p.a(file.getAbsolutePath());
                    a7 = a8 == null ? com.nexstreaming.kinemaster.mediastore.v2.p.b(file.getAbsolutePath(), a2, a3) : a8;
                    if (a7 != null) {
                    }
                    break;
                case FOLDER:
                case SPECIAL:
                    throw new InternalError();
            }
        }
        if (a7 == null) {
            return BitmapFactory.decodeResource(this.e.getResources(), R.drawable.n2_no_thumb_avail, null);
        }
        return NexImageLoader.rotateImage(a7, l);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public int a(MediaStoreItem mediaStoreItem) {
        return (this.d && mediaStoreItem.c().equals(c)) ? 2 : 1;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(com.nexstreaming.kinemaster.mediastore.v2.MediaStore mediaStore) {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void c(MSID msid) {
    }
}
