package com.nexstreaming.kinemaster.mediastore.scanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class MediaDb {

    /* renamed from: a */
    private static final Executor f21040a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static final String[] f21041b = {"_id", "path", "bucket_id", "bucket_name", "title", "possible_garbage", MessengerShareContentUtility.MEDIA_TYPE, "width", "height", "size", "has_audio", "has_video", "date_created", "date_modified", "date_taken", "fps", "orientation", "duration", "support_type"};

    /* renamed from: c */
    private h f21042c;

    /* renamed from: d */
    private ContentValues f21043d = new ContentValues();

    /* renamed from: e */
    private AtomicBoolean f21044e = new AtomicBoolean();

    /* renamed from: f */
    private SQLiteDatabase f21045f = null;

    /* renamed from: g */
    private AtomicInteger f21046g = new AtomicInteger();

    /* loaded from: classes.dex */
    public enum MediaType {
        IMAGE,
        VIDEO,
        AUDIO,
        FONT,
        FOLDER
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public int f21047a;

        /* renamed from: b */
        public int f21048b;

        /* renamed from: c */
        public int f21049c;

        /* renamed from: d */
        public boolean f21050d;

        /* renamed from: e */
        public boolean f21051e;

        /* renamed from: f */
        public Date f21052f;

        /* renamed from: g */
        public Date f21053g;

        /* renamed from: h */
        public int f21054h;
        public int i;
        public MediaSupportType j;
    }

    public MediaDb(Context context) {
        this.f21042c = new h(context, "kinemaster_media_db", null, 11);
    }

    private ContentValues g() {
        if (!this.f21044e.getAndSet(true)) {
            this.f21043d.clear();
            return this.f21043d;
        }
        return new ContentValues();
    }

    public long b(File file) {
        Cursor query = this.f21042c.getReadableDatabase().query("entry", new String[]{"date_modified"}, "path=?", new String[]{file.getAbsolutePath()}, null, null, null);
        long j = query.moveToFirst() ? query.getLong(0) : -1L;
        query.close();
        return j;
    }

    public void c() {
        this.f21042c.getWritableDatabase().delete("entry", "possible_garbage==1", null);
    }

    public long d() {
        Cursor rawQuery = this.f21042c.getReadableDatabase().rawQuery("select max(date_created) from entry", null);
        long j = rawQuery.moveToFirst() ? rawQuery.getLong(0) : -1L;
        rawQuery.close();
        return j;
    }

    public SQLiteDatabase e() {
        return this.f21042c.getReadableDatabase();
    }

    public void f() {
        SQLiteDatabase writableDatabase = this.f21042c.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("possible_garbage", (Integer) 1);
        writableDatabase.update("entry", contentValues, null, null);
    }

    private void a(ContentValues contentValues) {
        if (contentValues == this.f21043d) {
            this.f21044e.set(false);
        }
    }

    public void c(File file) {
        SQLiteDatabase writableDatabase = this.f21042c.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("possible_garbage", (Integer) 0);
        writableDatabase.update("entry", contentValues, "path=?", new String[]{file.getAbsolutePath()});
    }

    public long a(File file, long j) {
        SQLiteDatabase writableDatabase = this.f21042c.getWritableDatabase();
        ContentValues g2 = g();
        g2.put("path", file.getAbsolutePath());
        g2.put("size", Long.valueOf(file.length()));
        g2.put("title", file.getName());
        g2.put("bucket_id", Integer.valueOf(file.getParentFile().getAbsolutePath().hashCode()));
        g2.put("bucket_name", file.getParentFile().getName());
        g2.put(MessengerShareContentUtility.MEDIA_TYPE, MediaType.FOLDER.name());
        g2.put("possible_garbage", (Integer) 0);
        g2.put("date_modified", Long.valueOf(j));
        long insertWithOnConflict = writableDatabase.insertWithOnConflict("entry", null, g2, 5);
        a(g2);
        return insertWithOnConflict;
    }

    public void d(File file) {
        this.f21042c.getWritableDatabase().delete("entry", "path==?", new String[]{file.getAbsolutePath()});
    }

    public int b(long j) {
        SQLiteDatabase writableDatabase = this.f21042c.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date_created", Long.valueOf(j));
        return writableDatabase.update("entry", contentValues, "date_created>?", new String[]{j + ""});
    }

    public void b() {
        if (this.f21046g.decrementAndGet() == 0) {
            this.f21045f.setTransactionSuccessful();
            this.f21045f.endTransaction();
            this.f21045f = null;
        }
    }

    public void a() {
        if (this.f21046g.getAndIncrement() == 0) {
            this.f21045f = this.f21042c.getWritableDatabase();
            this.f21045f.beginTransaction();
        }
    }

    public long a(File file, MediaType mediaType, a aVar, Bitmap bitmap) {
        if (file.getParentFile() == null) {
            return -1L;
        }
        SQLiteDatabase sQLiteDatabase = this.f21045f;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.f21042c.getWritableDatabase();
        }
        ContentValues g2 = g();
        g2.put("path", file.getAbsolutePath());
        g2.put("size", Long.valueOf(file.length()));
        g2.put("title", file.getName());
        g2.put("bucket_id", Integer.valueOf(file.getParentFile().getAbsolutePath().hashCode()));
        g2.put("bucket_name", file.getParentFile().getName());
        g2.put(MessengerShareContentUtility.MEDIA_TYPE, mediaType.name());
        g2.put("possible_garbage", (Integer) 0);
        g2.put("date_modified", Long.valueOf(file.lastModified()));
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(g.f21086a, 80, byteArrayOutputStream);
            g2.put("thumbnail", byteArrayOutputStream.toByteArray());
        }
        if (aVar != null) {
            g2.put("width", Integer.valueOf(aVar.f21047a));
            g2.put("height", Integer.valueOf(aVar.f21048b));
            g2.put("has_audio", Integer.valueOf(aVar.f21050d ? 1 : 0));
            g2.put("has_video", Integer.valueOf(aVar.f21051e ? 1 : 0));
            g2.put("duration", Integer.valueOf(aVar.f21049c));
            g2.put("fps", Integer.valueOf(aVar.i));
            g2.put("orientation", Integer.valueOf(aVar.f21054h));
            MediaSupportType mediaSupportType = aVar.j;
            if (mediaSupportType != null) {
                g2.put("support_type", mediaSupportType.name());
            }
            Date date = aVar.f21052f;
            if (date != null) {
                g2.put("date_created", Long.valueOf(date.getTime()));
            }
            Date date2 = aVar.f21053g;
            if (date2 != null) {
                g2.put("date_taken", Long.valueOf(date2.getTime()));
            }
        }
        long insertWithOnConflict = sQLiteDatabase.insertWithOnConflict("entry", null, g2, 5);
        a(g2);
        return insertWithOnConflict;
    }

    public void a(File file, Bitmap bitmap) {
        new f(this, file, bitmap).executeOnExecutor(f21040a, new Void[0]);
    }

    public void a(long j) {
        this.f21042c.getWritableDatabase().delete("entry", "_id==?", new String[]{String.valueOf(j)});
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x004a, code lost:            if (r4 == r15.lastModified()) goto L24;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.io.File r15) {
        /*
            r14 = this;
            r0 = 3
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r1 = "_id"
            r3[r0] = r1
            r9 = 1
            java.lang.String r1 = "size"
            r3[r9] = r1
            r10 = 2
            java.lang.String r1 = "date_modified"
            r3[r10] = r1
            com.nexstreaming.kinemaster.mediastore.scanner.h r1 = r14.f21042c
            android.database.sqlite.SQLiteDatabase r11 = r1.getWritableDatabase()
            java.lang.String[] r12 = new java.lang.String[r9]
            java.lang.String r1 = r15.getAbsolutePath()
            r12[r0] = r1
            r8 = 0
            java.lang.String r13 = "path=?"
            java.lang.String r2 = "entry"
            r6 = 0
            r7 = 0
            r1 = r11
            r4 = r13
            r5 = r12
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)
            boolean r2 = r1.moveToFirst()
            if (r2 == 0) goto L4d
            long r2 = r1.getLong(r9)
            long r4 = r1.getLong(r10)
            long r6 = r15.length()
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 != 0) goto L4d
            long r2 = r15.lastModified()
            int r15 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r15 != 0) goto L4d
            goto L4e
        L4d:
            r9 = 0
        L4e:
            r1.close()
            if (r9 == 0) goto L66
            android.content.ContentValues r15 = new android.content.ContentValues
            r15.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "possible_garbage"
            r15.put(r1, r0)
            java.lang.String r0 = "entry"
            r11.update(r0, r15, r13, r12)
        L66:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediastore.scanner.MediaDb.a(java.io.File):boolean");
    }

    private static Bitmap a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Error | Exception unused) {
            return null;
        }
    }

    public Bitmap a(File file, int i, int i2) {
        Bitmap bitmap;
        boolean z = true;
        Cursor query = this.f21042c.getReadableDatabase().query("entry", new String[]{"thumbnail", MessengerShareContentUtility.MEDIA_TYPE}, "path=?", new String[]{file.getAbsolutePath()}, null, null, null);
        MediaType mediaType = null;
        if (query != null) {
            if (query.moveToFirst()) {
                MediaType valueOf = MediaType.valueOf(query.getString(1));
                byte[] blob = query.getBlob(0);
                bitmap = blob != null ? a(blob) : null;
                mediaType = valueOf;
            } else {
                bitmap = null;
                z = false;
            }
            query.close();
        } else {
            bitmap = null;
            z = false;
        }
        Log.d("MediaDb", "[getThumb] path: " + file + ", result: " + bitmap + ", mediaType: " + mediaType);
        if (bitmap == null && z) {
            if (mediaType == MediaType.IMAGE) {
                bitmap = m.a(file, i, i2);
            } else if (mediaType == MediaType.VIDEO && (bitmap = m.a(file.getAbsolutePath())) == null) {
                bitmap = m.a(file.getAbsolutePath(), i, i2);
            }
            if (bitmap != null && z) {
                a(file, bitmap);
            }
        }
        return bitmap;
    }

    public Cursor a(int i, int i2, String... strArr) {
        SQLiteDatabase readableDatabase = this.f21042c.getReadableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                sb.append(strArr[i3]);
                if (i3 < strArr.length - 1) {
                    sb.append(",");
                }
            }
        } else {
            sb.append("*");
        }
        sb.append(" FROM entry");
        if (i > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(i2 > 0 ? " OFFSET " + i2 : "");
            sb.append(" LIMIT " + sb2.toString());
        }
        return readableDatabase.rawQuery(sb.toString(), null);
    }
}
