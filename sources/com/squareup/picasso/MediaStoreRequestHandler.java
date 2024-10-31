package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MediaStoreRequestHandler extends C2401n {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f25599b = {"orientation"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);

        final int androidKind;
        final int height;
        final int width;

        PicassoKind(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaStoreRequestHandler(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.C2401n, com.squareup.picasso.E
    public boolean a(C c2) {
        Uri uri = c2.f25547e;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // com.squareup.picasso.C2401n, com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.f25649a.getContentResolver();
        int a2 = a(contentResolver, c2.f25547e);
        String type = contentResolver.getType(c2.f25547e);
        boolean z = type != null && type.startsWith("video/");
        if (c2.c()) {
            PicassoKind a3 = a(c2.i, c2.j);
            if (!z && a3 == PicassoKind.FULL) {
                return new E.a(null, c(c2), Picasso.LoadedFrom.DISK, a2);
            }
            long parseId = ContentUris.parseId(c2.f25547e);
            BitmapFactory.Options b2 = E.b(c2);
            b2.inJustDecodeBounds = true;
            E.a(c2.i, c2.j, a3.width, a3.height, b2, c2);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, a3 == PicassoKind.FULL ? 1 : a3.androidKind, b2);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, a3.androidKind, b2);
            }
            if (thumbnail != null) {
                return new E.a(thumbnail, null, Picasso.LoadedFrom.DISK, a2);
            }
        }
        return new E.a(null, c(c2), Picasso.LoadedFrom.DISK, a2);
    }

    static PicassoKind a(int i, int i2) {
        PicassoKind picassoKind = PicassoKind.MICRO;
        if (i <= picassoKind.width && i2 <= picassoKind.height) {
            return picassoKind;
        }
        PicassoKind picassoKind2 = PicassoKind.MINI;
        return (i > picassoKind2.width || i2 > picassoKind2.height) ? PicassoKind.FULL : picassoKind2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:            r1.close();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int a(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String[] r4 = com.squareup.picasso.MediaStoreRequestHandler.f25599b     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            if (r1 == 0) goto L20
            boolean r8 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            if (r8 != 0) goto L16
            goto L20
        L16:
            int r8 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            if (r1 == 0) goto L1f
            r1.close()
        L1f:
            return r8
        L20:
            if (r1 == 0) goto L25
            r1.close()
        L25:
            return r0
        L26:
            r8 = move-exception
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            throw r8
        L2d:
            if (r1 == 0) goto L33
            r1.close()
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.MediaStoreRequestHandler.a(android.content.ContentResolver, android.net.Uri):int");
    }
}
