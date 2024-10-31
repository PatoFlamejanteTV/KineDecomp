package com.nexstreaming.app.general.util;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: CloseUtil.java */
/* renamed from: com.nexstreaming.app.general.util.f */
/* loaded from: classes2.dex */
public class C1702f {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.w("CloseUtil", "Error closing resource", e2);
            }
        }
    }
}
