package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class zzrc {
    public static final Integer zzbaB = 0;
    public static final Integer zzbaC = 1;
    private final Context mContext;
    private final ExecutorService zzaYr;

    public zzrc(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzrc(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzaYr = executorService;
    }
}
