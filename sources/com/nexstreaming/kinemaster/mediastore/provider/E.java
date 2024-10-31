package com.nexstreaming.kinemaster.mediastore.provider;

import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;

/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
/* synthetic */ class E {

    /* renamed from: a */
    static final /* synthetic */ int[] f20961a;

    /* renamed from: b */
    static final /* synthetic */ int[] f20962b = new int[MediaHttpDownloader.DownloadState.values().length];

    static {
        try {
            f20962b[MediaHttpDownloader.DownloadState.NOT_STARTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20962b[MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20962b[MediaHttpDownloader.DownloadState.MEDIA_COMPLETE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f20961a = new int[MediaItemType.values().length];
        try {
            f20961a[MediaItemType.VIDEO.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20961a[MediaItemType.IMAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
