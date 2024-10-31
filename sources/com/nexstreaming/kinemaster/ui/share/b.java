package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

/* compiled from: ExportLoggerFactory.java */
/* loaded from: classes2.dex */
class B implements InterfaceC2240y {

    /* renamed from: a */
    final /* synthetic */ long f23246a;

    /* renamed from: b */
    final /* synthetic */ File f23247b;

    public B(long j, File file) {
        this.f23246a = j;
        this.f23247b = file;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.InterfaceC2240y
    public synchronized void a(String str, String... strArr) {
        long nanoTime = System.nanoTime() - this.f23246a;
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
        }
        String format = String.format(Locale.US, str, sb);
        long j = nanoTime / 60000000000L;
        long j2 = (nanoTime % 60000000000L) / 1000000000;
        long j3 = (nanoTime % 1000000000) / 1000;
        String str3 = format.charAt(format.length() - 1) == '\n' ? String.format(Locale.getDefault(), "%4d:%02d.%06d ", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)) + format.substring(0, format.length() - 1).replace("\n", "\n               ") + "\n" : String.format(Locale.getDefault(), "%4d:%02d.%06d ", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)) + format.replace("\n", "\n               ") + "\n";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f23247b, true);
            try {
                fileOutputStream.write(str3.getBytes());
                fileOutputStream.close();
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            Log.e("ExportLogger", "Fail to write log: " + str3, e2);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.InterfaceC2240y
    public boolean a() {
        return true;
    }
}
