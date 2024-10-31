package com.nexstreaming.kinemaster.ui.share;

import java.io.File;

/* compiled from: ExportLoggerFactory.java */
/* loaded from: classes2.dex */
public class C {

    /* renamed from: a */
    private static InterfaceC2240y f23250a = new C2241z();

    /* renamed from: b */
    private static InterfaceC2240y f23251b = new A();

    public static InterfaceC2240y a() {
        return f23250a;
    }

    public static InterfaceC2240y a(File file) {
        return new B(System.nanoTime(), file);
    }
}
