package com.nexstreaming.kinemaster.mediastore.v2.scanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.p;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class MediaDb {
    private static final Executor b = Executors.newSingleThreadExecutor();
    private static final String[] g = {"_id", "path", "bucket_id", "bucket_name", ShareConstants.WEB_DIALOG_PARAM_TITLE, "possible_garbage", "media_type", "width", "height", "size", "has_audio", "has_video", "date_created", "date_modified", "date_taken", "fps", "orientation", "duration", "support_type"};

    /* renamed from: a, reason: collision with root package name */
    private g f3602a;
    private ContentValues c = new ContentValues();
    private AtomicBoolean d = new AtomicBoolean();
    private SQLiteDatabase e = null;
    private AtomicInteger f = new AtomicInteger();

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

        /* renamed from: a, reason: collision with root package name */
        public int f3603a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public Date f;
        public Date g;
        public int h;
        public int i;
        public MediaStoreItem.MediaSupportType j;
    }

    public MediaDb(Context context) {
        this.f3602a = new g(context, "kinemaster_media_db", null, 10);
    }

    private ContentValues g() {
        if (this.d.getAndSet(true)) {
            return new ContentValues();
        }
        this.c.clear();
        return this.c;
    }

    private void a(ContentValues contentValues) {
        if (contentValues == this.c) {
            this.d.set(false);
        }
    }

    public long a(File file) {
        long j;
        Cursor query = this.f3602a.getReadableDatabase().query("entry", new String[]{"date_modified"}, "path=?", new String[]{file.getAbsolutePath()}, null, null, null);
        if (!query.moveToFirst()) {
            j = -1;
        } else {
            j = query.getLong(0);
        }
        query.close();
        return j;
    }

    public int a(long j) {
        SQLiteDatabase writableDatabase = this.f3602a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date_created", Long.valueOf(j));
        return writableDatabase.update("entry", contentValues, "date_created>?", new String[]{j + ""});
    }

    public long a() {
        long j = -1;
        Cursor rawQuery = this.f3602a.getReadableDatabase().rawQuery("select max(date_created) from entry", null);
        if (rawQuery.moveToFirst()) {
            j = rawQuery.getLong(0);
        }
        rawQuery.close();
        return j;
    }

    public long a(File file, long j) {
        SQLiteDatabase writableDatabase = this.f3602a.getWritableDatabase();
        ContentValues g2 = g();
        g2.put("path", file.getAbsolutePath());
        g2.put("size", Long.valueOf(file.length()));
        g2.put(ShareConstants.WEB_DIALOG_PARAM_TITLE, file.getName());
        g2.put("bucket_id", Integer.valueOf(file.getParentFile().getAbsolutePath().hashCode()));
        g2.put("bucket_name", file.getParentFile().getName());
        g2.put("media_type", MediaType.FOLDER.name());
        g2.put("possible_garbage", (Integer) 0);
        g2.put("date_modified", Long.valueOf(j));
        long insertWithOnConflict = writableDatabase.insertWithOnConflict("entry", null, g2, 5);
        a(g2);
        return insertWithOnConflict;
    }

    public void b() {
        if (this.f.getAndIncrement() == 0) {
            this.e = this.f3602a.getWritableDatabase();
            this.e.beginTransaction();
        }
    }

    public void c() {
        if (this.f.decrementAndGet() == 0) {
            this.e.setTransactionSuccessful();
            this.e.endTransaction();
            this.e = null;
        }
    }

    public long a(File file, MediaType mediaType, a aVar, Bitmap bitmap) {
        if (file.getParentFile() == null) {
            return -1L;
        }
        SQLiteDatabase sQLiteDatabase = this.e;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.f3602a.getWritableDatabase();
        }
        ContentValues g2 = g();
        g2.put("path", file.getAbsolutePath());
        g2.put("size", Long.valueOf(file.length()));
        g2.put(ShareConstants.WEB_DIALOG_PARAM_TITLE, file.getName());
        g2.put("bucket_id", Integer.valueOf(file.getParentFile().getAbsolutePath().hashCode()));
        g2.put("bucket_name", file.getParentFile().getName());
        g2.put("media_type", mediaType.name());
        g2.put("possible_garbage", (Integer) 0);
        g2.put("date_modified", Long.valueOf(file.lastModified()));
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(f.f3614a, 80, byteArrayOutputStream);
            g2.put("thumbnail", byteArrayOutputStream.toByteArray());
        }
        if (aVar != null) {
            g2.put("width", Integer.valueOf(aVar.f3603a));
            g2.put("height", Integer.valueOf(aVar.b));
            g2.put("has_audio", Integer.valueOf(aVar.d ? 1 : 0));
            g2.put("has_video", Integer.valueOf(aVar.e ? 1 : 0));
            g2.put("duration", Integer.valueOf(aVar.c));
            g2.put("fps", Integer.valueOf(aVar.i));
            g2.put("orientation", Integer.valueOf(aVar.h));
            if (aVar.j != null) {
                g2.put("support_type", aVar.j.name());
            }
            if (aVar.f != null) {
                g2.put("date_created", Long.valueOf(aVar.f.getTime()));
            }
            if (aVar.g != null) {
                g2.put("date_taken", Long.valueOf(aVar.g.getTime()));
            }
        }
        long insertWithOnConflict = sQLiteDatabase.insertWithOnConflict("entry", null, g2, 5);
        a(g2);
        return insertWithOnConflict;
    }

    public void a(File file, Bitmap bitmap) {
        new e(this, file, bitmap).executeOnExecutor(b, new Void[0]);
    }

    public void d() {
        SQLiteDatabase writableDatabase = this.f3602a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("possible_garbage", (Integer) 1);
        writableDatabase.update("entry", contentValues, null, null);
    }

    public void e() {
        this.f3602a.getWritableDatabase().delete("entry", "possible_garbage==1", null);
    }

    public void b(File file) {
        this.f3602a.getWritableDatabase().delete("entry", "path==?", new String[]{file.getAbsolutePath()});
    }

    public void b(long j) {
        this.f3602a.getWritableDatabase().delete("entry", "_id==?", new String[]{String.valueOf(j)});
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(java.io.File r15) {
        /*
            r14 = this;
            r10 = 2
            r5 = 0
            r8 = 1
            r9 = 0
            r0 = 3
            java.lang.String[] r2 = new java.lang.String[r0]
            java.lang.String r0 = "_id"
            r2[r9] = r0
            java.lang.String r0 = "size"
            r2[r8] = r0
            java.lang.String r0 = "date_modified"
            r2[r10] = r0
            com.nexstreaming.kinemaster.mediastore.v2.scanner.g r0 = r14.f3602a
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()
            java.lang.String r3 = "path=?"
            java.lang.String[] r4 = new java.lang.String[r8]
            java.lang.String r1 = r15.getAbsolutePath()
            r4[r9] = r1
            java.lang.String r1 = "entry"
            r6 = r5
            r7 = r5
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r2.moveToFirst()
            if (r1 == 0) goto L63
            long r6 = r2.getLong(r8)
            long r10 = r2.getLong(r10)
            long r12 = r15.length()
            int r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r1 != 0) goto L63
            long r6 = r15.lastModified()
            int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r1 != 0) goto L63
            r1 = r8
        L4a:
            r2.close()
            if (r1 == 0) goto L62
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
            java.lang.String r5 = "possible_garbage"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r2.put(r5, r6)
            java.lang.String r5 = "entry"
            r0.update(r5, r2, r3, r4)
        L62:
            return r1
        L63:
            r1 = r9
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediastore.v2.scanner.MediaDb.c(java.io.File):boolean");
    }

    public void d(File file) {
        SQLiteDatabase writableDatabase = this.f3602a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("possible_garbage", (Integer) 0);
        writableDatabase.update("entry", contentValues, "path=?", new String[]{file.getAbsolutePath()});
    }

    private static Bitmap a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Error e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public Bitmap a(File file, int i, int i2) {
        boolean z;
        MediaType mediaType;
        Bitmap bitmap = null;
        Cursor query = this.f3602a.getReadableDatabase().query("entry", new String[]{"thumbnail", "media_type"}, "path=?", new String[]{file.getAbsolutePath()}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                MediaType valueOf = MediaType.valueOf(query.getString(1));
                byte[] blob = query.getBlob(0);
                if (blob != null) {
                    bitmap = a(blob);
                    mediaType = valueOf;
                    z = true;
                } else {
                    mediaType = valueOf;
                    z = true;
                }
            } else {
                z = false;
                mediaType = null;
            }
            query.close();
        } else {
            z = false;
            mediaType = null;
        }
        Log.d("MediaDb", "[getThumb] path: " + file + ", result: " + bitmap + ", mediaType: " + mediaType);
        if (bitmap == null && z) {
            if (mediaType == MediaType.IMAGE) {
                bitmap = p.a(file, i, i2);
            } else if (mediaType == MediaType.VIDEO && (bitmap = p.a(file.getAbsolutePath())) == null) {
                bitmap = p.b(file.getAbsolutePath(), i, i2);
            }
            if (bitmap != null && z) {
                a(file, bitmap);
            }
        }
        return bitmap;
    }

    public Cursor a(int i, int i2, String... strArr) {
        SQLiteDatabase readableDatabase = this.f3602a.getReadableDatabase();
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
            sb.append(" LIMIT " + (i + (i2 > 0 ? " OFFSET " + i2 : "")));
        }
        return readableDatabase.rawQuery(sb.toString(), null);
    }

    public SQLiteDatabase f() {
        return this.f3602a.getReadableDatabase();
    }
}
