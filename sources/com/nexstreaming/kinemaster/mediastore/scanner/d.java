package com.nexstreaming.kinemaster.mediastore.scanner;

import com.nexstreaming.app.general.util.FileType;

/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
/* synthetic */ class d {

    /* renamed from: a */
    static final /* synthetic */ int[] f21061a = new int[FileType.FileCategory.values().length];

    static {
        try {
            f21061a[FileType.FileCategory.Video.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21061a[FileType.FileCategory.VideoOrAudio.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21061a[FileType.FileCategory.Audio.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21061a[FileType.FileCategory.Image.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f21061a[FileType.FileCategory.Font.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
