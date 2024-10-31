package com.facebook.internal;

import com.facebook.FacebookRequestError;

/* compiled from: FacebookRequestErrorClassification.java */
/* loaded from: classes.dex */
public /* synthetic */ class m {

    /* renamed from: a */
    static final /* synthetic */ int[] f9322a = new int[FacebookRequestError.Category.values().length];

    static {
        try {
            f9322a[FacebookRequestError.Category.OTHER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9322a[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f9322a[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
