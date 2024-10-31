package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
public class Container {

    /* renamed from: a, reason: collision with root package name */
    private final String f2202a;
    private ab b;

    /* loaded from: classes.dex */
    public interface FunctionCallMacroCallback {
    }

    /* loaded from: classes.dex */
    public interface FunctionCallTagCallback {
    }

    private synchronized ab c() {
        return this.b;
    }

    public String a() {
        return this.f2202a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        c().a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.b = null;
    }
}
