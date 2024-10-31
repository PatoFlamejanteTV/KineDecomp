package com.facebook;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public class n implements Callable<File> {
    @Override // java.util.concurrent.Callable
    public File call() throws Exception {
        Context context;
        context = FacebookSdk.applicationContext;
        return context.getCacheDir();
    }
}
