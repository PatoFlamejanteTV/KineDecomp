package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f476a = bc.class.getSimpleName();
    PrintStream g;
    PrintWriter h;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            if (this.g != null) {
                th.printStackTrace(this.g);
            } else if (this.h != null) {
                th.printStackTrace(this.h);
            } else {
                th.printStackTrace();
            }
            as.a(6, f476a, "", th);
        }
    }
}
