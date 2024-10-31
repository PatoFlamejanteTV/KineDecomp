package com.facebook.internal;

import com.facebook.FacebookRequestError;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookRequestErrorClassification.java */
/* loaded from: classes.dex */
public /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f293a = new int[FacebookRequestError.Category.values().length];

    static {
        try {
            f293a[FacebookRequestError.Category.OTHER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f293a[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f293a[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
