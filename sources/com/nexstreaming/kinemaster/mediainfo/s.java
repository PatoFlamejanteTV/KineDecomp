package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.internal.view.SupportMenu;
import com.nexstreaming.app.general.task.Task;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ThumbnailParser.java */
/* loaded from: classes.dex */
class S {
    private static int a(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task.TaskError a(File file, int i, M m) {
        if (!file.exists()) {
            return ThumbnailError.RawFileNotFound;
        }
        long length = file.length();
        if (length < 8) {
            return ThumbnailError.RawFileTooSmall;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                return a(bufferedInputStream, length, i, m);
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e2) {
            return Task.makeTaskError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThumbnailError a(InputStream inputStream, long j, int i, M m) throws IOException {
        N n;
        O o;
        boolean z;
        Bitmap createBitmap;
        Canvas canvas;
        Bitmap bitmap;
        Bitmap bitmap2;
        int i2;
        ByteBuffer byteBuffer;
        int i3;
        Canvas canvas2;
        byte[] bArr;
        ByteBuffer byteBuffer2;
        if (m == null) {
            return ThumbnailError.ParameterError;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        int readInt2 = dataInputStream.readInt();
        int readInt3 = dataInputStream.readInt();
        boolean z2 = m instanceof O;
        if (z2) {
            o = (O) m;
            n = null;
        } else {
            n = (N) m;
            o = null;
        }
        if ((readInt2 & SupportMenu.CATEGORY_MASK) == 0 && ((-65536) & readInt3) == 0) {
            z = false;
        } else {
            readInt = a(readInt);
            readInt2 = a(readInt2);
            readInt3 = a(readInt3);
            z = true;
        }
        if (readInt == 32) {
            if (!z2) {
                createBitmap = Bitmap.createBitmap(readInt2, readInt3, Bitmap.Config.ARGB_8888);
            }
            createBitmap = null;
        } else if (readInt == 16) {
            if (!z2) {
                createBitmap = Bitmap.createBitmap(readInt2, readInt3, Bitmap.Config.RGB_565);
            }
            createBitmap = null;
        } else {
            if (readInt != 8) {
                return ThumbnailError.UnknownFormat;
            }
            if (!z2) {
                createBitmap = Bitmap.createBitmap(readInt2, readInt3, Bitmap.Config.ARGB_8888);
            }
            createBitmap = null;
        }
        Bitmap bitmap3 = createBitmap;
        if (z2) {
            canvas = null;
            bitmap = null;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(readInt2, readInt3, bitmap3.getConfig());
            Canvas canvas3 = new Canvas(createBitmap2);
            canvas3.scale(1.0f, -1.0f);
            bitmap = createBitmap2;
            canvas = canvas3;
        }
        int i4 = ((readInt2 * readInt3) * readInt) / 8;
        Canvas canvas4 = canvas;
        Bitmap bitmap4 = bitmap3;
        int min = (int) Math.min(i, (j - 8) / (i4 + 4));
        if (min < 1) {
            return ThumbnailError.NoThumbailsFound;
        }
        byte[] bArr2 = new byte[i4];
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        int i5 = 0;
        while (i5 < min) {
            int readInt4 = dataInputStream.readInt();
            if (z) {
                readInt4 = a(readInt4);
            }
            int i6 = readInt4;
            if (dataInputStream.read(bArr2) >= i4 - 1) {
                bitmap2 = bitmap4;
                i2 = i5;
                byteBuffer = wrap;
                i3 = min;
                canvas2 = canvas4;
                bArr = bArr2;
                if (z2) {
                    o.a(bArr, readInt2, readInt3, i2, i3, i6);
                    byteBuffer.rewind();
                } else {
                    bitmap2.copyPixelsFromBuffer(byteBuffer);
                    byteBuffer.rewind();
                    canvas2.drawBitmap(bitmap2, 0.0f, -readInt3, (Paint) null);
                    byteBuffer2 = byteBuffer;
                    n.a(bitmap, bitmap.getWidth(), bitmap.getHeight(), i2, i3, i6);
                    i5 = i2 + 1;
                    bitmap4 = bitmap2;
                    bArr2 = bArr;
                    min = i3;
                    wrap = byteBuffer2;
                    canvas4 = canvas2;
                }
            } else if (z2) {
                i2 = i5;
                byteBuffer = wrap;
                canvas2 = canvas4;
                bArr = bArr2;
                bitmap2 = bitmap4;
                i3 = min;
                o.a(null, 0, 0, i2, min, i6);
            } else {
                bitmap2 = bitmap4;
                i2 = i5;
                byteBuffer = wrap;
                i3 = min;
                canvas2 = canvas4;
                bArr = bArr2;
                n.a(null, 0, 0, i2, i3, i6);
            }
            byteBuffer2 = byteBuffer;
            i5 = i2 + 1;
            bitmap4 = bitmap2;
            bArr2 = bArr;
            min = i3;
            wrap = byteBuffer2;
            canvas4 = canvas2;
        }
        return null;
    }
}
