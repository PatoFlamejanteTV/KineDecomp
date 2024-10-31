package com.facebook.share.internal;

import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;

/* compiled from: MessengerShareContentUtility.java */
/* loaded from: classes.dex */
/* synthetic */ class C {

    /* renamed from: a */
    static final /* synthetic */ int[] f9501a;

    /* renamed from: b */
    static final /* synthetic */ int[] f9502b;

    /* renamed from: c */
    static final /* synthetic */ int[] f9503c = new int[ShareMessengerMediaTemplateContent.MediaType.values().length];

    static {
        try {
            f9503c[ShareMessengerMediaTemplateContent.MediaType.VIDEO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        f9502b = new int[ShareMessengerGenericTemplateContent.ImageAspectRatio.values().length];
        try {
            f9502b[ShareMessengerGenericTemplateContent.ImageAspectRatio.SQUARE.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        f9501a = new int[ShareMessengerURLActionButton.WebviewHeightRatio.values().length];
        try {
            f9501a[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioCompact.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f9501a[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioTall.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
