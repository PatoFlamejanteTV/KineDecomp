package com.nexstreaming.kinemaster.mediainfo;

import com.nextreaming.nexeditorui.ExclusionList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC1794l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20746a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1794l(String str) {
        this.f20746a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExclusionList exclusionList;
        exclusionList = MediaInfo.f20673c;
        exclusionList.remove(this.f20746a);
    }
}
