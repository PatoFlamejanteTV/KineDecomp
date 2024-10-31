package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public final class Strings {
    private Strings() {
    }

    public static boolean a(@Nullable String str) {
        return str == null || str.length() == 0;
    }
}
