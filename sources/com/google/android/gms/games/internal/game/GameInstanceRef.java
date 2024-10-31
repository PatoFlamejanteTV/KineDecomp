package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.PlatformType;

/* loaded from: classes.dex */
public final class GameInstanceRef extends zzc implements GameInstance {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GameInstanceRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String a() {
        return e("external_game_id");
    }

    public String c() {
        return e("instance_display_name");
    }

    public boolean d() {
        return c("real_time_support") > 0;
    }

    public boolean e() {
        return c("turn_based_support") > 0;
    }

    public int f() {
        return c("platform_type");
    }

    public String g() {
        return e("package_name");
    }

    public boolean h() {
        return c("piracy_check") > 0;
    }

    public boolean i() {
        return c("installed") > 0;
    }

    public String toString() {
        return zzw.a(this).a("ApplicationId", a()).a("DisplayName", c()).a("SupportsRealTime", Boolean.valueOf(d())).a("SupportsTurnBased", Boolean.valueOf(e())).a("PlatformType", PlatformType.a(f())).a("PackageName", g()).a("PiracyCheckEnabled", Boolean.valueOf(h())).a("Installed", Boolean.valueOf(i())).toString();
    }
}
