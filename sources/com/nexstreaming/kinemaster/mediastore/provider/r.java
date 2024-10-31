package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
public /* synthetic */ class r {

    /* renamed from: a */
    static final /* synthetic */ int[] f21009a;

    /* renamed from: b */
    static final /* synthetic */ int[] f21010b = new int[MediaItemType.values().length];

    static {
        try {
            f21010b[MediaItemType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21010b[MediaItemType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21010b[MediaItemType.FILE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21010b[MediaItemType.FOLDER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f21010b[MediaItemType.SPECIAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f21009a = new int[QueryParams.SortBy.values().length];
        try {
            f21009a[QueryParams.SortBy.DATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f21009a[QueryParams.SortBy.DISPLAY_NAME.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f21009a[QueryParams.SortBy.SIZE.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
