package com.umeng.commonsdk.statistics.internal;

/* compiled from: IRequestStat.java */
/* loaded from: classes3.dex */
public interface b {
    void onRequestEnd();

    void onRequestFailed();

    void onRequestStart();

    void onRequestSucceed(boolean z);
}
