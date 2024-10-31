package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
/* loaded from: classes.dex */
public class LibraryVersion {

    /* renamed from: a */
    private static final GmsLogger f11114a = new GmsLogger("LibraryVersion", "");

    /* renamed from: b */
    private static LibraryVersion f11115b = new LibraryVersion();

    /* renamed from: c */
    private ConcurrentHashMap<String, String> f11116c = new ConcurrentHashMap<>();

    @VisibleForTesting
    protected LibraryVersion() {
    }
}
