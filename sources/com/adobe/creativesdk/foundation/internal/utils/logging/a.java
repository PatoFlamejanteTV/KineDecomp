package com.adobe.creativesdk.foundation.internal.utils.logging;

import android.util.Log;
import java.io.PrintWriter;

/* compiled from: AdobeLogger.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f6868a;

    public a(boolean z) {
        this.f6868a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        PrintWriter printWriter;
        PrintWriter printWriter2;
        PrintWriter printWriter3;
        PrintWriter printWriter4;
        String b2;
        PrintWriter printWriter5;
        PrintWriter printWriter6;
        PrintWriter printWriter7;
        obj = c.j;
        synchronized (obj) {
            try {
                try {
                    b2 = c.b(c.f6870a.getAbsolutePath(), (int) c.f6870a.getTotalSpace());
                    int unused = c.f6874e = b2.length();
                    PrintWriter unused2 = c.f6875f = new PrintWriter(c.f6870a, "UTF-8");
                    printWriter5 = c.f6875f;
                    printWriter5.append((CharSequence) b2);
                    if (this.f6868a) {
                        printWriter7 = c.f6875f;
                        printWriter7.append((CharSequence) "************************ App Launch *********************\n");
                    }
                    printWriter6 = c.f6875f;
                } catch (Throwable th) {
                    printWriter = c.f6875f;
                    if (printWriter != null) {
                        printWriter2 = c.f6875f;
                        printWriter2.flush();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                Log.d(c.class.getSimpleName(), e2.getMessage(), e2);
                printWriter3 = c.f6875f;
                if (printWriter3 != null) {
                    printWriter4 = c.f6875f;
                }
            }
            if (printWriter6 != null) {
                printWriter4 = c.f6875f;
                printWriter4.flush();
            }
        }
    }
}
