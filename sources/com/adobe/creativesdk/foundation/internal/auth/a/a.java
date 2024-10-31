package com.adobe.creativesdk.foundation.internal.auth.a;

import java.util.Timer;

/* compiled from: AdobeContinuableEventHandler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static a f4873a;

    /* renamed from: b */
    private boolean f4874b;

    /* renamed from: c */
    private Timer f4875c;

    public static void a() {
        a aVar = f4873a;
        if (aVar != null) {
            aVar.b();
        }
    }

    private synchronized void b() {
        if (this.f4874b) {
            this.f4875c.cancel();
            this.f4874b = false;
        }
    }
}
