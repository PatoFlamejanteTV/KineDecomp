package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
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
class ap {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task.TaskError a(File file, int i, ak akVar) {
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
                return a(bufferedInputStream, length, i, akVar);
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            return Task.makeTaskError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThumbnailError a(InputStream inputStream, long j, int i, ak akVar) throws IOException {
        al alVar;
        am amVar;
        boolean z;
        int a2;
        Bitmap bitmap;
        if (akVar == null) {
            return ThumbnailError.ParameterError;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        int readInt2 = dataInputStream.readInt();
        int readInt3 = dataInputStream.readInt();
        boolean z2 = akVar instanceof am;
        if (z2) {
            amVar = (am) akVar;
            alVar = null;
        } else {
            alVar = (al) akVar;
            amVar = null;
        }
        if (((-65536) & readInt2) == 0 && ((-65536) & readInt3) == 0) {
            z = false;
            a2 = readInt3;
        } else {
            readInt = a(readInt);
            readInt2 = a(readInt2);
            z = true;
            a2 = a(readInt3);
        }
        Bitmap bitmap2 = null;
        if (readInt == 32) {
            if (!z2) {
                bitmap2 = Bitmap.createBitmap(readInt2, a2, Bitmap.Config.ARGB_8888);
            }
            bitmap = bitmap2;
        } else if (readInt == 16) {
            if (!z2) {
                bitmap2 = Bitmap.createBitmap(readInt2, a2, Bitmap.Config.RGB_565);
            }
            bitmap = bitmap2;
        } else if (readInt == 8) {
            if (!z2) {
                bitmap2 = Bitmap.createBitmap(readInt2, a2, Bitmap.Config.ARGB_8888);
            }
            bitmap = bitmap2;
        } else {
            return ThumbnailError.UnknownFormat;
        }
        Bitmap bitmap3 = null;
        Canvas canvas = null;
        if (!z2) {
            bitmap3 = Bitmap.createBitmap(readInt2, a2, bitmap.getConfig());
            canvas = new Canvas(bitmap3);
            canvas.scale(1.0f, -1.0f);
        }
        int i2 = ((readInt2 * a2) * readInt) / 8;
        int min = (int) Math.min(i, (j - 8) / (i2 + 4));
        if (min < 1) {
            return ThumbnailError.NoThumbailsFound;
        }
        byte[] bArr = new byte[i2];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (int i3 = 0; i3 < min; i3++) {
            int readInt4 = dataInputStream.readInt();
            if (z) {
                readInt4 = a(readInt4);
            }
            if (dataInputStream.read(bArr) < i2 - 1) {
                if (z2) {
                    amVar.a(null, i3, min, readInt4);
                } else {
                    alVar.a(null, i3, min, readInt4);
                }
            } else if (z2) {
                amVar.a(bArr, i3, min, readInt4);
                wrap.rewind();
            } else {
                bitmap.copyPixelsFromBuffer(wrap);
                wrap.rewind();
                canvas.drawBitmap(bitmap, 0.0f, -a2, (Paint) null);
                alVar.a(bitmap3, i3, min, readInt4);
            }
        }
        return null;
    }

    private static int a(int i) {
        return (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8) | ((i & 255) << 24);
    }
}
