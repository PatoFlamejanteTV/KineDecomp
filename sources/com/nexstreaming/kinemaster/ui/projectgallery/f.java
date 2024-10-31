package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.util.FileType;

/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
/* synthetic */ class F {

    /* renamed from: a */
    static final /* synthetic */ int[] f22831a = new int[FileType.FileCategory.values().length];

    static {
        try {
            f22831a[FileType.FileCategory.Image.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22831a[FileType.FileCategory.Video.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22831a[FileType.FileCategory.Audio.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
