package com.crashlytics.android.core;

import java.io.File;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class CrashlyticsNdkData {
    public final TreeSet<File> timestampedDirectories;

    public CrashlyticsNdkData(TreeSet<File> treeSet) {
        this.timestampedDirectories = treeSet;
    }
}
