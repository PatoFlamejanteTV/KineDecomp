package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzark;
import java.util.Map;

@zzark
@Deprecated
/* loaded from: classes.dex */
public class NativeAdMapper {

    /* renamed from: a */
    protected boolean f10276a;

    /* renamed from: b */
    protected boolean f10277b;

    /* renamed from: c */
    protected Bundle f10278c = new Bundle();

    /* renamed from: d */
    protected View f10279d;

    /* renamed from: e */
    private View f10280e;

    /* renamed from: f */
    private VideoController f10281f;

    /* renamed from: g */
    private boolean f10282g;

    public void a(View view) {
    }

    public void a(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public final void a(boolean z) {
        this.f10277b = z;
    }

    @Deprecated
    public void b(View view) {
    }

    public final void b(boolean z) {
        this.f10276a = z;
    }

    public void c(View view) {
    }

    public final boolean c() {
        return this.f10277b;
    }

    public final boolean d() {
        return this.f10276a;
    }

    public final VideoController e() {
        return this.f10281f;
    }

    public boolean f() {
        return this.f10282g;
    }

    public void g() {
    }

    public final View h() {
        return this.f10280e;
    }

    public View a() {
        return this.f10279d;
    }

    public final Bundle b() {
        return this.f10278c;
    }

    public final void a(VideoController videoController) {
        this.f10281f = videoController;
    }
}
