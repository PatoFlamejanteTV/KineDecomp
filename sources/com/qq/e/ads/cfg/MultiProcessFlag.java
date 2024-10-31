package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class MultiProcessFlag {

    /* renamed from: a */
    private static boolean f24810a;

    /* renamed from: b */
    private static boolean f24811b;

    public static boolean isMultiProcess() {
        return f24810a;
    }

    public static void setMultiProcess(boolean z) {
        if (f24811b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
        } else {
            f24811b = true;
            f24810a = z;
        }
    }
}
