package com.facebook;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public final class m implements Callable<File> {
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File call() throws Exception {
        Context context;
        context = FacebookSdk.applicationContext;
        return context.getCacheDir();
    }
}
