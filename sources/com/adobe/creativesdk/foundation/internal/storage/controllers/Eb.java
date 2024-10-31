package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesFragment.java */
/* loaded from: classes.dex */
public class Eb implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Hb f5630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Eb(Hb hb) {
        this.f5630a = hb;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f5630a.C();
    }
}
