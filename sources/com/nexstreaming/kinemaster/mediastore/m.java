package com.nexstreaming.kinemaster.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.util.ConcurrentModificationException;

/* compiled from: ThumbnailHelper.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b */
    public static final m f20926b = new m();

    /* renamed from: a */
    private static final String f20925a = f20925a;

    /* renamed from: a */
    private static final String f20925a = f20925a;

    private m() {
    }

    public final Bitmap b(String str, int i, int i2) {
        String str2;
        StringBuilder sb;
        Bitmap bitmap;
        MediaInfo a2;
        kotlin.jvm.internal.h.b(str, "path");
        Log.d(f20925a, "[extractVideoThumbnail]+ path: " + str);
        Bitmap[] bitmapArr = new Bitmap[1];
        Object obj = new Object();
        try {
            try {
                a2 = MediaInfo.a(new File(str));
                kotlin.jvm.internal.h.a((Object) a2, "info");
            } catch (Exception e2) {
                e2.printStackTrace();
                synchronized (obj) {
                    obj.notify();
                    kotlin.k kVar = kotlin.k.f28545a;
                    str2 = f20925a;
                    sb = new StringBuilder();
                    sb.append("[extractVideoThumbnail]- path: ");
                    sb.append(str);
                    sb.append(", bitmap: ");
                    bitmap = bitmapArr[0];
                }
            }
            if (!a2.V() && a2.Z()) {
                a2.a(i, i2, Math.min(5000, a2.r() / 2), a2.r(), 1, 1, new k(str, bitmapArr, obj)).onFailure(new l(str, obj));
                synchronized (obj) {
                    obj.wait(500L);
                    kotlin.k kVar2 = kotlin.k.f28545a;
                }
                synchronized (obj) {
                    obj.notify();
                    kotlin.k kVar3 = kotlin.k.f28545a;
                }
                str2 = f20925a;
                sb = new StringBuilder();
                sb.append("[extractVideoThumbnail]- path: ");
                sb.append(str);
                sb.append(", bitmap: ");
                bitmap = bitmapArr[0];
                sb.append(bitmap);
                Log.d(str2, sb.toString());
                return bitmapArr[0];
            }
            synchronized (obj) {
                obj.notify();
                kotlin.k kVar4 = kotlin.k.f28545a;
            }
            Log.d(f20925a, "[extractVideoThumbnail]- path: " + str + ", bitmap: " + bitmapArr[0]);
            return null;
        } catch (Throwable th) {
            synchronized (obj) {
                obj.notify();
                kotlin.k kVar5 = kotlin.k.f28545a;
                Log.d(f20925a, "[extractVideoThumbnail]- path: " + str + ", bitmap: " + bitmapArr[0]);
                throw th;
            }
        }
    }

    public final Bitmap c(String str, int i, int i2) {
        kotlin.jvm.internal.h.b(str, "path");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a(options, i, i2);
        options.inTempStorage = new byte[65536];
        options.inPurgeable = true;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                return decodeFile;
            }
            try {
                return ThumbnailUtils.extractThumbnail(decodeFile, i, i2, 2);
            } catch (OutOfMemoryError unused) {
                return decodeFile;
            }
        } catch (OutOfMemoryError unused2) {
            return null;
        }
    }

    public static final Bitmap a(File file, int i, int i2) {
        kotlin.jvm.internal.h.b(file, "file");
        m mVar = f20926b;
        String absolutePath = file.getAbsolutePath();
        kotlin.jvm.internal.h.a((Object) absolutePath, "file.absolutePath");
        return mVar.c(absolutePath, i, i2);
    }

    private final int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i && i4 <= i2) {
            return 1;
        }
        int round = Math.round(i3 / i);
        int round2 = Math.round(i4 / i2);
        if (round > round2) {
            round2 = round;
        }
        return Math.max(1, round2);
    }

    public static final Bitmap a(String str) {
        kotlin.jvm.internal.h.b(str, "path");
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = KineMasterApplication.f24058f.c().getContentResolver();
        boolean z = false;
        Cursor query = contentResolver.query(uri, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        long j = 0;
        if (query != null) {
            if (query.moveToFirst()) {
                j = query.getLong(0);
                z = true;
            }
            query.close();
        }
        if (!z) {
            return null;
        }
        try {
            return MediaStore.Video.Thumbnails.getThumbnail(contentResolver, j, 1, null);
        } catch (SecurityException e2) {
            Log.e(f20925a, "Failed to get thumbnail", e2);
            return null;
        } catch (ConcurrentModificationException e3) {
            Log.e(f20925a, "Failed to get thumbnail", e3);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap a(java.lang.String r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediastore.m.a(java.lang.String, int, int):android.graphics.Bitmap");
    }
}
