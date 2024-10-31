package com.xiaomi.licensinglibrary;

/* loaded from: classes3.dex */
public interface LicenseCheckerCallback {
    void allow(int i);

    void applicationError(int i);

    void dontAllow(int i);
}
