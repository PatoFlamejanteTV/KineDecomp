package com.flurry.sdk;

import android.content.Context;

/* loaded from: classes.dex */
public class aw implements ax {

    /* renamed from: a, reason: collision with root package name */
    private final ax f471a;

    public aw(ax axVar) {
        this.f471a = axVar;
    }

    @Override // com.flurry.sdk.ax
    public void a(Context context) {
        if (this.f471a != null) {
            this.f471a.a(context);
        }
    }

    @Override // com.flurry.sdk.ax
    public void b(Context context) {
        if (this.f471a != null) {
            this.f471a.b(context);
        }
    }
}
