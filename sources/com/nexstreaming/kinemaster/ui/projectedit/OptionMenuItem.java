package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.ep;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* loaded from: classes.dex */
public enum OptionMenuItem {
    clip_effect(a(R.id.opt_clip_effect).b(R.drawable.opt_clip_effect).c(R.drawable.opt_clip_effect_large).a(com.nexstreaming.kinemaster.ui.b.o.class).f(R.string.opt_clip_effect)),
    color_adj(a(R.id.opt_color_adj).b(R.drawable.opt_color_adj).c(R.drawable.opt_color_adj_large).a(m.class).f(R.string.opt_color_adj)),
    alpha_adj(a(R.id.opt_alpha_adj).b(R.drawable.opt_alpha_adj).c(R.drawable.opt_alpha_adj_large).a(com.nexstreaming.kinemaster.ui.projectedit.b.class).f(R.string.opt_alpha_adj)),
    color_tint(a(R.id.opt_color_tint).b(R.drawable.opt_color_tint).c(R.drawable.opt_color_tint_large).a(dc.class).f(R.string.opt_color_tint)),
    img_crop(a(R.id.opt_img_crop).b(R.drawable.opt_crop).c(R.drawable.opt_img_crop_large).a(OptionCroppingFragment.class).f(R.string.opt_img_crop)),
    vid_crop(a(R.id.opt_vid_crop).b(R.drawable.opt_crop).c(R.drawable.opt_img_crop_large).a(OptionCroppingFragment.class).f(R.string.opt_vid_crop)),
    filter(a(R.id.opt_filter).b(R.drawable.opt_filter).a((Class<? extends kp>) null).f(R.string.opt_filter)),
    rerecord(a(R.id.opt_rerecord).b(R.drawable.opt_rerecord).a((Class<? extends kp>) null).f(R.string.opt_rerecord)),
    rotate(a(R.id.opt_rotate).b(R.drawable.opt_rotate).c(R.drawable.opt_rotate_large).a(gj.class).f(R.string.opt_rotate)),
    speed_control(a(R.id.opt_speed_control).b(R.drawable.opt_speed_control).c(R.drawable.opt_speed_control_large).a(kv.class).f(R.string.opt_speed_control)),
    split_trim(a(R.id.opt_split_trim).b(R.drawable.opt_split_trim).c(R.drawable.opt_split_trim_large).a(go.class).f(R.string.opt_split_trim)),
    voicerec_review(a(R.id.opt_voicerec_review).b(R.drawable.opt_voicerec_review).c(R.drawable.opt_voicerec_review_large).d(R.drawable.opt_review_pause).e(R.drawable.opt_review_pause_large).a((Class<? extends kp>) null).f(R.string.opt_voicerec_review)),
    voicerec_rerec(a(R.id.opt_voicerec_rerec).b(R.drawable.opt_voicerec_rerecord).c(R.drawable.opt_voicerec_record_large).a(mf.class).f(R.string.opt_rerecord)),
    volume_env(a(R.id.opt_volume_env).b(R.drawable.opt_volume_env).c(R.drawable.opt_volume_env_large).a(mv.class).f(R.string.opt_volume_env)),
    volume(a(R.id.opt_volume).b(R.drawable.opt_volume).c(R.drawable.opt_volume_large).a(hp.class).f(R.string.opt_volume)),
    volume_and_balance(a(R.id.opt_volume_and_balance).b(R.drawable.opt_volume).c(R.drawable.opt_volume_large).a(hf.class).f(R.string.opt_volume).g()),
    loop(a(R.id.opt_loop).b(R.drawable.opt_icon_loop).c(R.drawable.opt_icon_loop_large).a((Class<? extends kp>) null).f(R.string.opt_loop).f()),
    vignette(a(R.id.opt_vignette).b(R.drawable.opt_icon_vignette).c(R.drawable.opt_icon_vignette_large).a((Class<? extends kp>) null).f(R.string.opt_vignette).f()),
    extend_to_end(a(R.id.opt_extend_to_end).b(R.drawable.opt_extend_to_end).c(R.drawable.opt_extend_to_end_large).a((Class<? extends kp>) null).f(R.string.opt_extend_to_end).f()),
    background(a(R.id.opt_background).b(R.drawable.opt_icon_bgm).c(R.drawable.opt_icon_bgm_large).a((Class<? extends kp>) null).f(R.string.opt_background).f()),
    color(a(R.id.opt_color).a().f(R.string.opt_color).d()),
    split_to_left(a(R.id.split_to_left).b(R.drawable.opt_split_trim_left).a((Class<? extends kp>) null).e().f(R.string.opt_split_to_left)),
    split_to_right(a(R.id.split_to_right).b(R.drawable.opt_split_trim_right).a((Class<? extends kp>) null).e().f(R.string.opt_split_to_right)),
    split_at_playhaed(a(R.id.split_at_playhead).b(R.drawable.opt_split_split_clip).a((Class<? extends kp>) null).e().f(R.string.opt_split_at_playhead)),
    split_extract_audio(a(R.id.split_extract_audio).b(R.drawable.opt_split_extract_audio).a((Class<? extends kp>) null).e().f(R.string.opt_split_extract_audio)),
    split_freezeframe(a(R.id.split_freezeframe).b(R.drawable.opt_split_freezeframe).a((Class<? extends kp>) null).e().f(R.string.opt_split_freezeframe)),
    expression_in(a(R.id.opt_in_expression).b(R.drawable.opt_in_animation).c(R.drawable.opt_in_animation_large).a(ea.class).f(R.string.opt_in_expression)),
    expression_out(a(R.id.opt_out_expression).b(R.drawable.opt_out_animation).c(R.drawable.opt_out_animation_large).a(eb.class).f(R.string.opt_out_expression)),
    expression_overall(a(R.id.opt_overall_expression).b(R.drawable.opt_overall).c(R.drawable.opt_overall_large).a(ec.class).f(R.string.opt_expression)),
    text_color(a(R.id.opt_text_color).b().d().f(R.string.opt_text_color)),
    shadow(a(R.id.opt_shadow).b().f(R.string.opt_shadow).f()),
    glow(a(R.id.opt_glow).b().f(R.string.opt_glow).f()),
    outline(a(R.id.opt_outline).b().f(R.string.opt_outline).f()),
    text_font(a(R.id.opt_text_font).b(R.drawable.opt_text_font).c().d().a((Class<? extends kp>) null).f(R.string.opt_text_font)),
    colorize_color(a(R.id.opt_colorize_color).a().f(R.string.opt_color).f()),
    background_color(a(R.id.opt_background_color).b().f(R.string.opt_background_color).f()),
    audio_effect(a(R.id.opt_audio_effect).a(ce.class).b(R.drawable.opt_audio_filter_original).c(R.drawable.opt_audio_filter_large).f(R.string.opt_audio_effect)),
    background_extend(a(R.id.opt_background_extend).b(R.drawable.opt_icon_bg_extend).a((Class<? extends kp>) null).f(R.string.opt_background_extend).e().f()),
    splitscreen(a(R.id.opt_splitscreen).b(R.drawable.opt_icon_split_screen).c(R.drawable.opt_split_screen_large).a(gz.class).f(R.string.opt_split_screen)),
    chroma_key(a(R.id.opt_chroma_key).b(R.drawable.opt_icon_chromakey).c(R.drawable.opt_chroma_key_large).a(cr.class).f(R.string.opt_chroma_key)),
    layer_mask(a(R.id.opt_layer_mask).b(R.drawable.opt_icon_layermask).c(R.drawable.opt_layermask_large).a(em.class).f(R.string.opt_layer_mask)),
    layer_name(a(R.id.opt_layer_name).b(R.drawable.opt_layer_name).c(R.drawable.opt_layer_name_large).f(R.string.opt_layer_name)),
    chroma_key_test(a(R.id.opt_chroma_key_test).b(R.drawable.opt_icon_chromakey).a(db.class).f(R.string.opt_chroma_key_details)),
    chroma_key_color(a(R.id.opt_chroma_key_color).b().f(R.string.opt_chroma_key).f()),
    strength_and_variation(a(R.id.opt_strength_and_variation).b(R.drawable.opt_icon_chromakey).f(R.string.opt_strength_and_variation).a(ha.class)),
    text_algin(a(R.id.opt_text_align).a(new lh()));

    public final boolean canCompact;
    public final boolean compactInList;
    public final b customItem;
    public final boolean expandedUI;
    public final Class<? extends kp> fragmentClass;
    public final int icon;
    public final int iconLarge;
    public final int iconSelected;
    public final int iconSelectedLarge;
    public final int id;
    public final int string;
    public final boolean subscriptionFeature;
    public final boolean switchWidget;
    public final Type type;

    /* loaded from: classes.dex */
    public enum Type {
        IconResource,
        Color,
        ColorWithAlpha,
        Button
    }

    /* loaded from: classes.dex */
    public interface b {
        View a(int i, View view, ViewGroup viewGroup, NexTimelineItem nexTimelineItem, OptionMenuItem optionMenuItem, ep.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f3739a;
        int b;
        int c;
        int d;
        int e;
        int f;
        Type g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        Class<? extends kp> n;
        b o;

        private a() {
            this.f3739a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = null;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = false;
            this.m = false;
            this.o = null;
        }

        a a(int i) {
            this.f3739a = i;
            return this;
        }

        a b(int i) {
            this.b = i;
            this.g = Type.IconResource;
            return this;
        }

        a c(int i) {
            this.c = i;
            return this;
        }

        a d(int i) {
            this.d = i;
            return this;
        }

        a e(int i) {
            this.e = i;
            return this;
        }

        a a() {
            this.b = 0;
            this.g = Type.Color;
            return this;
        }

        a b() {
            this.b = 0;
            this.g = Type.ColorWithAlpha;
            return this;
        }

        a c() {
            this.g = Type.Button;
            return this;
        }

        a d() {
            this.k = false;
            this.j = true;
            return this;
        }

        a e() {
            this.k = false;
            this.j = false;
            return this;
        }

        a f(int i) {
            this.f = i;
            return this;
        }

        a a(Class<? extends kp> cls) {
            this.n = cls;
            return this;
        }

        a f() {
            this.h = true;
            return this;
        }

        a a(b bVar) {
            this.o = bVar;
            return this;
        }

        a g() {
            this.m = true;
            return this;
        }
    }

    private static a a(int i) {
        return new a().a(i);
    }

    OptionMenuItem(a aVar) {
        this.id = aVar.f3739a;
        this.icon = aVar.b;
        this.iconLarge = aVar.c != 0 ? aVar.c : aVar.b;
        this.iconSelected = aVar.d != 0 ? aVar.d : aVar.b;
        this.iconSelectedLarge = aVar.e != 0 ? aVar.e : aVar.b;
        this.string = aVar.f;
        this.fragmentClass = aVar.n;
        this.type = aVar.g;
        this.switchWidget = aVar.h;
        this.subscriptionFeature = aVar.i;
        this.customItem = aVar.o;
        this.expandedUI = aVar.m;
        if (this.customItem != null) {
            this.canCompact = false;
            this.compactInList = false;
            return;
        }
        if (!aVar.k) {
            this.canCompact = aVar.j;
            this.compactInList = aVar.j && aVar.l;
        } else if (this.icon == 0 || ((this.switchWidget && (this.type == Type.Color || this.type == Type.ColorWithAlpha)) || this.type == Type.Button)) {
            this.canCompact = false;
            this.compactInList = false;
        } else {
            this.canCompact = true;
            this.compactInList = aVar.l;
        }
    }

    public boolean getCompact(boolean z) {
        if (this.canCompact) {
            return z || this.compactInList;
        }
        return false;
    }

    public static OptionMenuItem fromId(int i) {
        for (OptionMenuItem optionMenuItem : values()) {
            if (optionMenuItem.id == i) {
                return optionMenuItem;
            }
        }
        return null;
    }
}
