package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class PlayerColumnNames {
    public final String A;
    public final String B;

    /* renamed from: a, reason: collision with root package name */
    public final String f1377a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

    public PlayerColumnNames(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1377a = "external_player_id";
            this.b = "profile_name";
            this.c = "profile_icon_image_uri";
            this.d = "profile_icon_image_url";
            this.e = "profile_hi_res_image_uri";
            this.f = "profile_hi_res_image_url";
            this.g = "last_updated";
            this.h = "is_in_circles";
            this.i = "played_with_timestamp";
            this.j = "current_xp_total";
            this.k = "current_level";
            this.l = "current_level_min_xp";
            this.m = "current_level_max_xp";
            this.n = "next_level";
            this.o = "next_level_max_xp";
            this.p = "last_level_up_timestamp";
            this.q = "player_title";
            this.r = "has_all_public_acls";
            this.s = "is_profile_visible";
            this.t = "most_recent_external_game_id";
            this.u = "most_recent_game_name";
            this.v = "most_recent_activity_timestamp";
            this.w = "most_recent_game_icon_uri";
            this.x = "most_recent_game_hi_res_uri";
            this.y = "most_recent_game_featured_uri";
            this.z = "has_debug_access";
            this.A = "gamer_tag";
            this.B = "real_name";
            return;
        }
        this.f1377a = str + "external_player_id";
        this.b = str + "profile_name";
        this.c = str + "profile_icon_image_uri";
        this.d = str + "profile_icon_image_url";
        this.e = str + "profile_hi_res_image_uri";
        this.f = str + "profile_hi_res_image_url";
        this.g = str + "last_updated";
        this.h = str + "is_in_circles";
        this.i = str + "played_with_timestamp";
        this.j = str + "current_xp_total";
        this.k = str + "current_level";
        this.l = str + "current_level_min_xp";
        this.m = str + "current_level_max_xp";
        this.n = str + "next_level";
        this.o = str + "next_level_max_xp";
        this.p = str + "last_level_up_timestamp";
        this.q = str + "player_title";
        this.r = str + "has_all_public_acls";
        this.s = str + "is_profile_visible";
        this.t = str + "most_recent_external_game_id";
        this.u = str + "most_recent_game_name";
        this.v = str + "most_recent_activity_timestamp";
        this.w = str + "most_recent_game_icon_uri";
        this.x = str + "most_recent_game_hi_res_uri";
        this.y = str + "most_recent_game_featured_uri";
        this.z = str + "has_debug_access";
        this.A = str + "gamer_tag";
        this.B = str + "real_name";
    }
}
