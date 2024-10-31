package com.nexstreaming.kinemaster.codeccolorformat;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.facebook.stetho.dumpapp.Framer;
import com.nexstreaming.app.general.task.ResultTask;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Vector;

/* loaded from: classes.dex */
public class ColorFormatChecker {

    /* renamed from: a */
    private static ResultTask<ColorFormat> f20143a;

    /* renamed from: b */
    private f f20144b;

    /* renamed from: c */
    private e f20145c;

    /* renamed from: d */
    private boolean f20146d;

    /* renamed from: e */
    private boolean f20147e;

    /* renamed from: f */
    private MediaFormat f20148f;

    /* renamed from: g */
    private Vector<byte[]> f20149g;

    /* renamed from: h */
    private Vector<byte[]> f20150h;

    /* loaded from: classes.dex */
    public enum ColorFormat {
        UNKNOWN,
        NV12,
        NV21
    }

    public /* synthetic */ ColorFormatChecker(a aVar) {
        this();
    }

    private ColorFormatChecker() {
        this.f20146d = false;
        this.f20147e = false;
    }

    public ColorFormat b() throws IOException {
        ColorFormat colorFormat = ColorFormat.UNKNOWN;
        this.f20149g = new Vector<>();
        this.f20150h = new Vector<>();
        this.f20144b = new f(1280, 720);
        this.f20144b.a(new b(this));
        byte[] bArr = new byte[1382400];
        Arrays.fill(bArr, 0, 921600, Framer.STDIN_FRAME_PREFIX);
        for (int i = 0; i < 460800; i += 2) {
            int i2 = i + 921600;
            bArr[i2] = -44;
            bArr[i2 + 1] = -127;
        }
        long j = 0;
        long j2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            this.f20144b.a(bArr, j2);
            j2 += com.umeng.commonsdk.proguard.c.f26227d;
        }
        while (!this.f20146d) {
            this.f20144b.a(null, j2);
        }
        try {
            this.f20144b.a();
            this.f20144b = null;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        MediaFormat mediaFormat = this.f20148f;
        if (mediaFormat == null) {
            return colorFormat;
        }
        this.f20145c = new e(mediaFormat, null);
        this.f20145c.a(new c(this));
        while (this.f20149g.size() > 0) {
            byte[] bArr2 = this.f20149g.get(0);
            if (bArr2 != null) {
                this.f20145c.a(bArr2, j);
                this.f20149g.remove(0);
                j += com.umeng.commonsdk.proguard.c.f26227d;
            }
        }
        while (!this.f20147e) {
            this.f20145c.a((ByteBuffer) null, j);
        }
        try {
            this.f20145c.a();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        if (this.f20150h.size() <= 0) {
            return colorFormat;
        }
        int c2 = this.f20145c.c();
        int b2 = this.f20145c.b();
        byte[] bArr3 = this.f20150h.get(0);
        if (bArr3 == null) {
            return colorFormat;
        }
        int i4 = c2 * b2;
        if ((((Math.abs(bArr[921600] - bArr3[i4]) + Math.abs(bArr[921601] - bArr3[i4 + 1])) + Math.abs(bArr[921602] - bArr3[i4 + 2])) + Math.abs(bArr[921603] - bArr3[i4 + 3])) / 4 > 10) {
            return ColorFormat.NV21;
        }
        return ColorFormat.NV12;
    }

    public static ResultTask<ColorFormat> a(Context context) {
        if (f20143a == null) {
            f20143a = new ResultTask<>();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (defaultSharedPreferences.contains("km_detected_codec_color_format")) {
                String string = defaultSharedPreferences.getString("km_detected_codec_color_format", null);
                for (ColorFormat colorFormat : ColorFormat.values()) {
                    if (colorFormat.name().equals(string)) {
                        f20143a.setResult(colorFormat);
                        return f20143a;
                    }
                }
            }
            new a(defaultSharedPreferences).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
        return f20143a;
    }
}
