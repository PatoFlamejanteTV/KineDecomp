package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public class ProcessUtils {

    /* renamed from: a */
    private static String f11280a;

    /* renamed from: b */
    private static int f11281b;

    private ProcessUtils() {
    }

    @KeepForSdk
    @Nullable
    public static String a() {
        if (f11280a == null) {
            if (f11281b == 0) {
                f11281b = Process.myPid();
            }
            f11280a = a(f11281b);
        }
        return f11280a;
    }

    @Nullable
    private static String a(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = a(sb.toString());
            try {
                str = bufferedReader.readLine().trim();
                IOUtils.a(bufferedReader);
            } catch (IOException unused) {
                IOUtils.a(bufferedReader);
                return str;
            } catch (Throwable th) {
                bufferedReader2 = bufferedReader;
                th = th;
                IOUtils.a(bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }

    private static BufferedReader a(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
