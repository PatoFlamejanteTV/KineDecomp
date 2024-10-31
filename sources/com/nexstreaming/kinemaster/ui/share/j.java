package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

/* compiled from: ExportLoggerFactory.java */
/* loaded from: classes.dex */
final class j implements f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f4353a;
    final /* synthetic */ File b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(long j, File file) {
        this.f4353a = j;
        this.b = file;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.f
    public synchronized void a(String str, String... strArr) {
        FileOutputStream fileOutputStream;
        long nanoTime = System.nanoTime() - this.f4353a;
        String format = String.format(Locale.US, str, strArr);
        long j = nanoTime / 60000000000L;
        long j2 = (nanoTime % 60000000000L) / 1000000000;
        long j3 = (nanoTime % 1000000000) / 1000;
        String str2 = format.charAt(format.length() + (-1)) == '\n' ? String.format("%4d:%02d.%06d ", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)) + format.substring(0, format.length() - 1).replace("\n", "\n               ") + "\n" : String.format("%4d:%02d.%06d ", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)) + format.replace("\n", "\n               ") + "\n";
        try {
            fileOutputStream = new FileOutputStream(this.b, true);
        } catch (IOException e) {
            Log.e("ExportLogger", "Fail to write log: " + str2, e);
        }
        try {
            fileOutputStream.write(str2.getBytes());
        } finally {
            fileOutputStream.close();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.f
    public boolean a() {
        return true;
    }
}
