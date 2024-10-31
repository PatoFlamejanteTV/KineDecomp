package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public class StringResourceValueReader {

    /* renamed from: a */
    private final Resources f11136a;

    /* renamed from: b */
    private final String f11137b;

    public StringResourceValueReader(Context context) {
        Preconditions.a(context);
        this.f11136a = context.getResources();
        this.f11137b = this.f11136a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @KeepForSdk
    @Nullable
    public String a(String str) {
        int identifier = this.f11136a.getIdentifier(str, "string", this.f11137b);
        if (identifier == 0) {
            return null;
        }
        return this.f11136a.getString(identifier);
    }
}
