package com.google.firebase.iid;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes2.dex */
public interface MessagingChannel {
    @KeepForSdk
    Task<Void> a(String str, @Nullable String str2);

    @KeepForSdk
    Task<Void> a(String str, String str2, String str3);

    @KeepForSdk
    Task<String> a(String str, @Nullable String str2, String str3, String str4);

    @KeepForSdk
    boolean a();

    @KeepForSdk
    Task<Void> b(String str, String str2, String str3);

    @KeepForSdk
    boolean b();
}
