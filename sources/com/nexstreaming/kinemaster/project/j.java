package com.nexstreaming.kinemaster.project;

import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f21200a = new int[ProjectGalleryActivity.SortingMode.values().length];

    static {
        try {
            f21200a[ProjectGalleryActivity.SortingMode.EDIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21200a[ProjectGalleryActivity.SortingMode.MAKE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21200a[ProjectGalleryActivity.SortingMode.NAME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
