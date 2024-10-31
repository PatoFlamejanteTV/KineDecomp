package com.nexstreaming.kinemaster.codeccolorformat;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.ResultTask;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Vector;

/* loaded from: classes.dex */
public class ColorFormatChecker {

    /* renamed from: a, reason: collision with root package name */
    private static ResultTask<ColorFormat> f3286a = null;
    private f b;
    private e c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private Vector<byte[]> g;
    private Vector<byte[]> h;

    /* loaded from: classes.dex */
    public enum ColorFormat {
        UNKNOWN,
        NV12,
        NV21
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ColorFormatChecker(a aVar) {
        this();
    }

    public static ResultTask<ColorFormat> a(Context context) {
        if (f3286a == null) {
            f3286a = new ResultTask<>();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (defaultSharedPreferences.contains("km_detected_codec_color_format")) {
                String string = defaultSharedPreferences.getString("km_detected_codec_color_format", null);
                for (ColorFormat colorFormat : ColorFormat.values()) {
                    if (colorFormat.name().equals(string)) {
                        f3286a.setResult(colorFormat);
                        return f3286a;
                    }
                }
            }
            new a(defaultSharedPreferences).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void) null);
        }
        return f3286a;
    }

    private ColorFormatChecker() {
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ColorFormat b() throws IOException {
        long j = 0;
        ColorFormat colorFormat = ColorFormat.UNKNOWN;
        this.g = new Vector<>();
        this.h = new Vector<>();
        this.b = new f(1280, 720);
        this.b.a(new b(this));
        byte[] bArr = new byte[1382400];
        Arrays.fill(bArr, 0, 921600, (byte) 45);
        for (int i = 0; i < 460800; i += 2) {
            bArr[921600 + i] = -44;
            bArr[921600 + i + 1] = -127;
        }
        long j2 = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            this.b.a(bArr, j2);
            j2 += 30000;
        }
        while (!this.d) {
            this.b.a(null, j2);
        }
        try {
            this.b.a();
            this.b = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.f != null) {
            this.c = new e(this.f, null);
            this.c.a(new c(this));
            while (this.g.size() > 0) {
                byte[] bArr2 = this.g.get(0);
                if (bArr2 != null) {
                    this.c.a(bArr2, j);
                    this.g.remove(0);
                    j += 30000;
                }
            }
            while (!this.e) {
                this.c.a((ByteBuffer) null, j);
            }
            try {
                this.c.a();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (this.h.size() > 0) {
                int c = this.c.c();
                int d = this.c.d();
                byte[] bArr3 = this.h.get(0);
                if (bArr3 != null) {
                    byte b = bArr[921600];
                    byte b2 = bArr[921601];
                    byte b3 = bArr[921602];
                    byte b4 = bArr[921603];
                    byte b5 = bArr3[c * d];
                    byte b6 = bArr3[(c * d) + 1];
                    byte b7 = bArr3[(c * d) + 2];
                    if ((Math.abs(b4 - bArr3[(c * d) + 3]) + ((Math.abs(b - b5) + Math.abs(b2 - b6)) + Math.abs(b3 - b7))) / 4 > 10) {
                        return ColorFormat.NV21;
                    }
                    return ColorFormat.NV12;
                }
            }
        }
        return colorFormat;
    }
}
