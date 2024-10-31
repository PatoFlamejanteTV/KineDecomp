package com.firebase.ui.auth.util;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static int checkValidStyle(Context context, int i, String str, Object... objArr) {
        try {
            if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(context.getResources().getResourceTypeName(i))) {
                return i;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        } catch (Resources.NotFoundException unused) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
