package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.util.ConcurrentModificationException;

/* compiled from: ThumbnailHelper.java */
/* loaded from: classes.dex */
public class p {
    public static Bitmap a(File file, int i, int i2) {
        return a(file.getAbsolutePath(), i, i2);
    }

    public static Bitmap a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a(options, i, i2);
        options.inTempStorage = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
        options.inPurgeable = true;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                return ThumbnailUtils.extractThumbnail(decodeFile, i, i2, 2);
            }
            return decodeFile;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i && i4 <= i2) {
            return 1;
        }
        int round = Math.round(i3 / i);
        int round2 = Math.round(i4 / i2);
        if (round <= round2) {
            round = round2;
        }
        return Math.max(1, round);
    }

    public static Bitmap a(String str) {
        boolean z;
        long j;
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = KineMasterApplication.a().getContentResolver();
        Cursor query = contentResolver.query(uri, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        if (query == null) {
            z = false;
            j = 0;
        } else {
            if (!query.moveToFirst()) {
                z = false;
                j = 0;
            } else {
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
        } catch (SecurityException | ConcurrentModificationException e) {
            Log.e("ThumbnailHelper", "Failed to get thumbnail", e);
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static Bitmap b(String str, int i, int i2) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                if (frameAtTime != null) {
                    frameAtTime = ThumbnailUtils.extractThumbnail(frameAtTime, i, i2, 2);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
                Log.d("ThumbnailHelper", "[createVideoThumbnail] path: " + str + ", bitmap: " + frameAtTime);
                bitmap = frameAtTime;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e3) {
                    e3.printStackTrace();
                }
                Log.d("ThumbnailHelper", "[createVideoThumbnail] path: " + str + ", bitmap: " + ((Object) null));
                bitmap = null;
            } catch (RuntimeException e4) {
                e4.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e5) {
                    e5.printStackTrace();
                }
                Log.d("ThumbnailHelper", "[createVideoThumbnail] path: " + str + ", bitmap: " + ((Object) null));
                bitmap = null;
            }
            return bitmap == null ? c(str, i, i2) : bitmap;
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e6) {
                e6.printStackTrace();
            }
            Log.d("ThumbnailHelper", "[createVideoThumbnail] path: " + str + ", bitmap: " + ((Object) null));
            throw th;
        }
    }

    public static synchronized Bitmap c(String str, int i, int i2) {
        Bitmap bitmap;
        MediaInfo a2;
        synchronized (p.class) {
            Log.d("ThumbnailHelper", "[extractVideoThumbnail]+ path: " + str);
            Bitmap[] bitmapArr = new Bitmap[1];
            Object obj = new Object();
            try {
                try {
                    a2 = MediaInfo.a(new File(str));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("ThumbnailHelper", "[extractVideoThumbnail]- path: " + str + ", bitmap: " + bitmapArr[0]);
                }
                if (a2.m()) {
                    bitmap = null;
                } else {
                    a2.a(i, i2, Math.min(5000, a2.y() / 2), a2.y(), 1, 1, new r(str, i, i2, bitmapArr, obj)).onFailure(new q(str, obj));
                    synchronized (obj) {
                        obj.wait();
                    }
                    Log.d("ThumbnailHelper", "[extractVideoThumbnail]- path: " + str + ", bitmap: " + bitmapArr[0]);
                    bitmap = bitmapArr[0];
                }
            } finally {
                Log.d("ThumbnailHelper", "[extractVideoThumbnail]- path: " + str + ", bitmap: " + bitmapArr[(char) 0]);
            }
        }
        return bitmap;
    }
}
