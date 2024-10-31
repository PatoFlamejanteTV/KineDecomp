package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.C1710n;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioViewType;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class OptionMenuItem {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<WeakReference<OptionMenuItem>> f21995a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private static OptionMenuItem[] f21996b;
    public final Object A;
    public final float B;
    public final float C;
    public final float D;
    public final AudioViewType E;

    /* renamed from: c, reason: collision with root package name */
    public final int f21997c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21998d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21999e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22000f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22001g;

    /* renamed from: h, reason: collision with root package name */
    public final int f22002h;
    public final String i;
    public final Bitmap j;
    public final Bitmap k;
    public final Bitmap l;
    public final Bitmap m;
    private String n;
    public final Class<? extends Bg> o;
    public final Type p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final b z;

    /* loaded from: classes2.dex */
    public enum Type {
        IconResource,
        Color,
        ColorWithAlpha,
        Button,
        TextField,
        TextFieldWithFont,
        Slider,
        Spinner
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean A;
        private AudioViewType B;
        private Class<? extends Bg> C;
        private b D;

        /* renamed from: a, reason: collision with root package name */
        private String f22003a;

        /* renamed from: b, reason: collision with root package name */
        private int f22004b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f22005c;

        /* renamed from: d, reason: collision with root package name */
        private int f22006d;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f22007e;

        /* renamed from: f, reason: collision with root package name */
        private int f22008f;

        /* renamed from: g, reason: collision with root package name */
        private int f22009g;

        /* renamed from: h, reason: collision with root package name */
        private int f22010h;
        private int i;
        private float j;
        private float k;
        private float l;
        private String m;
        private Type n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private boolean s;
        private boolean t;
        private boolean u;
        private boolean v;
        private Bitmap w;
        private Bitmap x;
        private Bitmap y;
        private Object z;

        static /* synthetic */ a k(a aVar) {
            aVar.m();
            return aVar;
        }

        private a() {
            this.f22004b = 0;
            this.f22005c = false;
            this.f22006d = 0;
            this.f22007e = null;
            this.f22008f = 0;
            this.f22009g = 0;
            this.f22010h = 0;
            this.i = 0;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = null;
            this.n = null;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = true;
            this.s = false;
            this.t = false;
            this.u = false;
            this.v = false;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = false;
            this.B = AudioViewType.VOICE_CHANGER;
            this.D = null;
        }

        static /* synthetic */ a a(a aVar, int i) {
            aVar.f(i);
            return aVar;
        }

        private a f(int i) {
            this.f22004b = i;
            return this;
        }

        private a m() {
            this.f22005c = true;
            return this;
        }

        public a b(int i) {
            this.f22008f = i;
            return this;
        }

        public a c(int i) {
            this.f22009g = i;
            return this;
        }

        public a d(int i) {
            this.f22010h = i;
            return this;
        }

        public a e() {
            this.f22006d = 0;
            this.n = Type.ColorWithAlpha;
            return this;
        }

        public a g() {
            this.u = true;
            return this;
        }

        public a h() {
            this.r = false;
            this.q = false;
            return this;
        }

        public a i() {
            this.v = true;
            this.f22006d = 0;
            return this;
        }

        public a j() {
            this.o = true;
            return this;
        }

        public a k() {
            this.f22006d = 0;
            this.n = Type.TextFieldWithFont;
            return this;
        }

        public a l() {
            this.A = this.n == Type.Button;
            return this;
        }

        public a a(int i) {
            this.f22006d = i;
            Type type = this.n;
            if (type == null) {
                type = Type.IconResource;
            }
            this.n = type;
            return this;
        }

        public a b(float f2, float f3, float f4) {
            this.f22006d = 0;
            this.j = f2;
            this.k = f3;
            this.l = f4;
            this.n = Type.Spinner;
            return this;
        }

        public a c() {
            this.r = false;
            this.q = true;
            return this;
        }

        public a d() {
            this.f22006d = 0;
            this.n = Type.Color;
            return this;
        }

        public a e(int i) {
            this.i = i;
            return this;
        }

        public a f() {
            this.t = true;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.f22007e = bitmap;
            return this;
        }

        public a b() {
            this.n = Type.Button;
            return this;
        }

        public a a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
            this.w = bitmap;
            this.x = bitmap2;
            this.y = bitmap3;
            return this;
        }

        public a b(String str) {
            this.f22003a = str;
            return this;
        }

        public a a(float f2, float f3, float f4) {
            this.f22006d = 0;
            this.j = f2;
            this.k = f3;
            this.l = f4;
            this.n = Type.Slider;
            return this;
        }

        public a a(Object obj) {
            this.z = obj;
            return this;
        }

        public a a(String str) {
            this.m = str;
            return this;
        }

        public a a(Class<? extends Bg> cls) {
            this.C = cls;
            return this;
        }

        public a a(b bVar) {
            this.D = bVar;
            return this;
        }

        public a a(AudioViewType audioViewType) {
            this.B = audioViewType;
            return this;
        }

        public OptionMenuItem a() {
            return new OptionMenuItem(this);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        View a(int i, View view, ViewGroup viewGroup, NexTimelineItem nexTimelineItem, OptionMenuItem optionMenuItem, C1935kd.a aVar);
    }

    static {
        a b2 = b(R.id.opt_clip_effect_expand);
        b2.a(R.drawable.opt_clipgfx);
        b2.b(R.drawable.opt_clipgfx_large);
        b2.f();
        b2.a(com.nexstreaming.kinemaster.ui.assetbrowser.n.class);
        b2.e(R.string.opt_clip_graphics);
        a b3 = b(R.id.opt_color_adj);
        b3.a(R.drawable.opt_color_adj);
        b3.b(R.drawable.opt_color_adj_large);
        b3.a(C1888fa.class);
        b3.e(R.string.opt_color_adj);
        a b4 = b(R.id.opt_alpha_adj);
        b4.a(R.drawable.opt_alpha_adj);
        b4.b(R.drawable.opt_alpha_adj_large);
        b4.a(r.class);
        b4.e(R.string.opt_alpha_adj);
        a b5 = b(R.id.opt_color_tint);
        b5.a(R.drawable.opt_color_tint);
        b5.b(R.drawable.opt_color_tint_large);
        b5.a(C1943lc.class);
        b5.e(R.string.opt_color_tint);
        a b6 = b(R.id.opt_color_filter);
        b6.a(R.drawable.opt_color_tint);
        b6.b(R.drawable.opt_color_tint_large);
        b6.f();
        b6.a(com.nexstreaming.kinemaster.ui.d.h.class);
        b6.e(R.string.opt_color_tint);
        a b7 = b(R.id.opt_img_crop);
        b7.a(R.drawable.opt_pan_zoom_large);
        b7.b(R.drawable.opt_pan_zoom_large);
        b7.a(OptionCroppingFragment.class);
        b7.e(R.string.opt_crop);
        a b8 = b(R.id.opt_vid_crop);
        b8.a(R.drawable.opt_pan_zoom_large);
        b8.b(R.drawable.opt_pan_zoom_large);
        b8.a(OptionCroppingFragment.class);
        b8.e(R.string.opt_crop);
        a b9 = b(R.id.opt_layer_crop);
        b9.a(R.drawable.opt_crop);
        b9.b(R.drawable.opt_img_crop_large);
        b9.a(ViewOnClickListenerC1970oc.class);
        b9.e(R.string.opt_crop);
        a b10 = b(R.id.opt_layer_shape);
        b10.a(R.drawable.opt_shape);
        b10.b(R.drawable.opt_shape_large);
        b10.a(Oc.class);
        b10.e(R.string.opt_layer_crop_shape);
        a b11 = b(R.id.opt_layer_nudge);
        b11.a(R.drawable.opt_crop);
        b11.b(R.drawable.opt_img_crop_large);
        b11.a(Sb.class);
        b11.e(R.string.opt_nudge);
        a b12 = b(R.id.opt_filter);
        b12.a(R.drawable.opt_filter);
        b12.a((Class<? extends Bg>) null);
        b12.e(R.string.opt_filter);
        a b13 = b(R.id.opt_rerecord);
        b13.a(R.drawable.opt_rerecord);
        b13.a((Class<? extends Bg>) null);
        b13.e(R.string.opt_rerecord);
        a b14 = b(R.id.opt_rotate);
        b14.a(R.drawable.opt_rotate);
        b14.b(R.drawable.opt_rotate_large);
        b14.a(C2048ue.class);
        b14.e(R.string.opt_rotate);
        a b15 = b(R.id.opt_rotate_for_hw);
        b15.a(R.drawable.opt_rotate);
        b15.b(R.drawable.opt_rotate_large);
        b15.a(C2074xe.class);
        b15.e(R.string.ro_panel_rotate);
        a b16 = b(R.id.opt_speed_control);
        b16.a(R.drawable.opt_speed_control);
        b16.b(R.drawable.opt_speed_control_large);
        b16.a(Ng.class);
        b16.e(R.string.opt_speed_control);
        a b17 = b(R.id.opt_split_trim);
        b17.a(R.drawable.opt_split_trim);
        b17.b(R.drawable.opt_split_trim_large);
        b17.a(He.class);
        b17.e(R.string.opt_split_trim);
        a b18 = b(R.id.opt_voicerec_review);
        b18.a(R.drawable.opt_voicerec_review);
        b18.b(R.drawable.opt_voicerec_review_large);
        b18.c(R.drawable.opt_review_pause);
        b18.d(R.drawable.opt_review_pause_large);
        b18.a((Class<? extends Bg>) null);
        b18.e(R.string.opt_voicerec_review);
        a b19 = b(R.id.opt_voicerec_rerec);
        b19.a(R.drawable.opt_voicerec_rerecord);
        b19.b(R.drawable.opt_voicerec_record_large);
        b19.a(zh.class);
        b19.e(R.string.opt_rerecord);
        a b20 = b(R.id.opt_volume_env);
        b20.a(R.drawable.opt_volume_env);
        b20.b(R.drawable.opt_volume_env_large);
        b20.a(Uh.class);
        b20.e(R.string.opt_volume_env);
        a b21 = b(R.id.opt_volume);
        b21.a(R.drawable.opt_volume);
        b21.b(R.drawable.opt_volume_large);
        b21.a(C1857bf.class);
        b21.e(R.string.opt_volume);
        a b22 = b(R.id.opt_volume_and_balance);
        b22.a(R.drawable.opt_volume);
        b22.b(R.drawable.opt_volume_large);
        b22.a(Ye.class);
        b22.e(R.string.opt_volume);
        b22.f();
        a b23 = b(R.id.opt_loop);
        b23.a(R.drawable.opt_icon_loop);
        b23.b(R.drawable.opt_icon_loop_large);
        b23.a((Class<? extends Bg>) null);
        b23.e(R.string.opt_loop);
        b23.j();
        a b24 = b(R.id.opt_vignette);
        b24.a(R.drawable.opt_icon_vignette);
        b24.b(R.drawable.opt_icon_vignette_large);
        b24.a((Class<? extends Bg>) null);
        b24.e(R.string.opt_vignette);
        b24.j();
        a b25 = b(R.id.opt_extend_to_end);
        b25.a(R.drawable.opt_extend_to_end);
        b25.b(R.drawable.opt_extend_to_end_large);
        b25.a((Class<? extends Bg>) null);
        b25.e(R.string.opt_extend_to_end);
        b25.j();
        a b26 = b(R.id.opt_background);
        b26.a(R.drawable.opt_icon_bgm);
        b26.b(R.drawable.opt_icon_bgm_large);
        b26.a((Class<? extends Bg>) null);
        b26.e(R.string.opt_background);
        b26.j();
        a b27 = b(R.id.opt_color);
        b27.d();
        b27.e(R.string.opt_color);
        b27.c();
        a b28 = b(R.id.split_to_left);
        b28.a(R.drawable.opt_split_trim_left);
        b28.a((Class<? extends Bg>) null);
        b28.h();
        b28.e(R.string.opt_split_to_left);
        a b29 = b(R.id.split_to_right);
        b29.a(R.drawable.opt_split_trim_right);
        b29.a((Class<? extends Bg>) null);
        b29.h();
        b29.e(R.string.opt_split_to_right);
        a b30 = b(R.id.split_at_playhead);
        b30.a(R.drawable.opt_split_split_clip);
        b30.a((Class<? extends Bg>) null);
        b30.h();
        b30.e(R.string.opt_split_at_playhead);
        a b31 = b(R.id.split_extract_audio);
        b31.a(R.drawable.opt_split_extract_audio);
        b31.a((Class<? extends Bg>) null);
        b31.h();
        b31.e(R.string.opt_split_extract_audio);
        a b32 = b(R.id.split_freezeframe);
        b32.a(R.drawable.opt_split_freezeframe);
        b32.a((Class<? extends Bg>) null);
        b32.h();
        b32.e(R.string.opt_split_freezeframe);
        a b33 = b(R.id.opt_in_expression);
        b33.a(R.drawable.opt_in_animation);
        b33.b(R.drawable.opt_in_animation_large);
        b33.a(Kc.class);
        b33.e(R.string.opt_in_expression);
        a b34 = b(R.id.opt_out_expression);
        b34.a(R.drawable.opt_out_animation);
        b34.b(R.drawable.opt_out_animation_large);
        b34.a(Lc.class);
        b34.e(R.string.opt_out_expression);
        a b35 = b(R.id.opt_overall_expression);
        b35.a(R.drawable.opt_overall);
        b35.b(R.drawable.opt_overall_large);
        b35.a(Mc.class);
        b35.e(R.string.opt_expression);
        a b36 = b(R.id.opt_text_color);
        b36.e();
        b36.c();
        b36.e(R.string.opt_text_color);
        a b37 = b(R.id.opt_shadow);
        b37.e();
        b37.e(R.string.opt_shadow);
        b37.j();
        a b38 = b(R.id.opt_glow);
        b38.e();
        b38.e(R.string.opt_glow);
        b38.j();
        a b39 = b(R.id.opt_outline);
        b39.e();
        b39.e(R.string.opt_outline);
        b39.j();
        a b40 = b(R.id.opt_text_font);
        b40.a(R.drawable.opt_text_font);
        b40.b();
        b40.l();
        b40.c();
        b40.a((Class<? extends Bg>) null);
        b40.e(R.string.opt_text_font);
        a b41 = b(R.id.opt_colorize_color);
        b41.d();
        b41.e(R.string.opt_color);
        b41.j();
        a b42 = b(R.id.opt_background_color);
        b42.e();
        b42.e(R.string.opt_background_color);
        b42.j();
        a b43 = b(R.id.opt_blending);
        b43.a(Xb.class);
        b43.a(R.drawable.list_icon_blend);
        b43.b(R.drawable.icon_blend_large);
        b43.e(R.string.opt_blending);
        a b44 = b(R.id.opt_audio_voice_changer);
        b44.a(com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w.class);
        b44.a(R.drawable.opt_audio_filter_original);
        b44.b(R.drawable.opt_audio_filter_large);
        b44.a(AudioViewType.VOICE_CHANGER);
        b44.e(R.string.opt_audio_voice_changer);
        a b45 = b(R.id.opt_audio_eq);
        b45.a(com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w.class);
        b45.a(R.drawable.opt_eq);
        b45.b(R.drawable.opt_eq_large);
        b45.a(AudioViewType.EQ);
        b45.e(R.string.opt_audio_eq);
        a b46 = b(R.id.opt_background_extend);
        b46.a(R.drawable.opt_icon_bg_extend);
        b46.a((Class<? extends Bg>) null);
        b46.e(R.string.opt_background_extend);
        b46.h();
        b46.j();
        a b47 = b(R.id.opt_splitscreen);
        b47.a(R.drawable.opt_icon_split_screen);
        b47.b(R.drawable.opt_split_screen_large);
        b47.a(Je.class);
        b47.e(R.string.opt_split_screen);
        a b48 = b(R.id.opt_chroma_key);
        b48.a(R.drawable.opt_icon_chromakey);
        b48.b(R.drawable.opt_chroma_key_large);
        b48.a(C1899gc.class);
        b48.e(R.string.opt_chroma_key);
        a b49 = b(R.id.opt_asset_settings);
        b49.a(R.drawable.opt_icon_asset_settings);
        b49.b(R.drawable.opt_icon_asset_settings_large);
        b49.a(C2069x.class);
        b49.e(R.string.settings_toolbar_title);
        a b50 = b(R.id.opt_layer_mask);
        b50.a(R.drawable.opt_icon_layermask);
        b50.b(R.drawable.opt_layermask_large);
        b50.a(C1891fd.class);
        b50.e(R.string.opt_layer_mask);
        a b51 = b(R.id.opt_information);
        b51.a(R.drawable.opt_info_original);
        b51.b(R.drawable.opt_info_large);
        b51.e(R.string.pref_information_category_title);
        a b52 = b(R.id.opt_chroma_key_test);
        b52.a(R.drawable.opt_icon_chromakey);
        b52.a(C1908hc.class);
        b52.e(R.string.opt_chroma_key_details);
        a b53 = b(R.id.opt_chroma_key_color);
        b53.e();
        b53.e(R.string.opt_chroma_key);
        b53.j();
        a b54 = b(R.id.opt_strength_and_variation);
        b54.a(R.drawable.opt_icon_chromakey);
        b54.e(R.string.opt_strength_and_variation);
        b54.a(Me.class);
        a b55 = b(R.id.opt_text_align);
        b55.a((b) new C1895fh());
        a b56 = b(R.id.opt_track_visibility);
        b56.a(R.drawable.ic_optmenu_track_visibility);
        b56.a((Class<? extends Bg>) null);
        b56.e(R.string.opt_track_enable);
        b56.h();
        b56.j();
        a b57 = b(R.id.opt_track_text_style);
        b57.a(R.drawable.layericon_text);
        b57.a(yh.class);
        b57.e(R.string.opt_track_text);
        b57.h();
        a b58 = b(R.id.opt_apply_style_to_all);
        b58.i();
        b58.a((Class<? extends Bg>) null);
        b58.e(R.string.action_apply_style_to_all);
        b58.h();
        b58.j();
        a b59 = b(R.id.opt_groupmenu_ungroup);
        b59.a(R.drawable.icon_layer_clip_ungroup);
        b59.b();
        b59.h();
        b59.a((Class<? extends Bg>) null);
        b59.e(R.string.opt_ungroup);
        a b60 = b(R.id.opt_layer_custom_crop);
        b60.a(R.drawable.opt_crop);
        b60.b(R.drawable.opt_img_crop_large);
        b60.a(CustomMaskEditFragment.class);
        b60.e(R.string.opt_custom_crop);
        a b61 = b(R.id.opt_extract_audio);
        b61.a(R.drawable.opt_extract_audio);
        b61.b(R.drawable.opt_extract_audio_large);
        b61.a((Class<? extends Bg>) null);
        b61.e(R.string.opt_split_extract_audio);
        a b62 = b(R.id.opt_reverse);
        b62.a(R.drawable.opt_reverse);
        b62.b(R.drawable.opt_reverse_large);
        b62.a((Class<? extends Bg>) null);
        b62.e(R.string.option_reverse);
        f21996b = new OptionMenuItem[]{new OptionMenuItem(b2), new OptionMenuItem(b3), new OptionMenuItem(b4), new OptionMenuItem(b5), new OptionMenuItem(b6), new OptionMenuItem(b7), new OptionMenuItem(b8), new OptionMenuItem(b9), new OptionMenuItem(b10), new OptionMenuItem(b11), new OptionMenuItem(b12), new OptionMenuItem(b13), new OptionMenuItem(b14), new OptionMenuItem(b15), new OptionMenuItem(b16), new OptionMenuItem(b17), new OptionMenuItem(b18), new OptionMenuItem(b19), new OptionMenuItem(b20), new OptionMenuItem(b21), new OptionMenuItem(b22), new OptionMenuItem(b23), new OptionMenuItem(b24), new OptionMenuItem(b25), new OptionMenuItem(b26), new OptionMenuItem(b27), new OptionMenuItem(b28), new OptionMenuItem(b29), new OptionMenuItem(b30), new OptionMenuItem(b31), new OptionMenuItem(b32), new OptionMenuItem(b33), new OptionMenuItem(b34), new OptionMenuItem(b35), new OptionMenuItem(b36), new OptionMenuItem(b37), new OptionMenuItem(b38), new OptionMenuItem(b39), new OptionMenuItem(b40), new OptionMenuItem(b41), new OptionMenuItem(b42), new OptionMenuItem(b43), new OptionMenuItem(b44), new OptionMenuItem(b45), new OptionMenuItem(b46), new OptionMenuItem(b47), new OptionMenuItem(b48), new OptionMenuItem(b49), new OptionMenuItem(b50), new OptionMenuItem(b51), new OptionMenuItem(b52), new OptionMenuItem(b53), new OptionMenuItem(b54), new OptionMenuItem(b55), new OptionMenuItem(b56), new OptionMenuItem(b57), new OptionMenuItem(b58), new OptionMenuItem(b59), new OptionMenuItem(b60), new OptionMenuItem(b61), new OptionMenuItem(b62)};
    }

    public void a(String str) {
        if (this.v) {
            this.n = str;
            return;
        }
        throw new IllegalStateException();
    }

    public String b() {
        return this.n;
    }

    private OptionMenuItem(a aVar) {
        Type type;
        if (!aVar.p) {
            this.f21997c = aVar.f22004b;
            this.f21998d = aVar.f22006d;
            this.x = aVar.v;
            this.j = aVar.f22007e;
            this.f21999e = aVar.f22008f != 0 ? aVar.f22008f : aVar.f22006d;
            this.f22000f = aVar.f22009g != 0 ? aVar.f22009g : aVar.f22006d;
            this.f22001g = aVar.f22010h != 0 ? aVar.f22010h : aVar.f22006d;
            this.f22002h = aVar.i;
            this.o = aVar.C;
            this.p = aVar.n;
            this.w = aVar.u;
            this.s = aVar.o;
            this.t = aVar.p;
            this.z = aVar.D;
            this.u = aVar.t;
            this.n = aVar.m;
            this.B = aVar.j;
            this.C = aVar.k;
            this.D = aVar.l;
            this.A = aVar.z;
            this.v = aVar.f22005c;
            this.i = aVar.f22003a;
            this.k = aVar.w;
            this.l = aVar.x;
            this.m = aVar.y;
            this.y = aVar.A;
            boolean z = false;
            if (this.z == null) {
                if (!aVar.r) {
                    this.q = aVar.q;
                    if (aVar.q && aVar.s) {
                        z = true;
                    }
                    this.r = z;
                } else if (this.f21998d != 0 && ((!this.s || ((type = this.p) != Type.Color && type != Type.ColorWithAlpha)) && this.p != Type.Button)) {
                    this.q = true;
                    this.r = aVar.s;
                } else {
                    this.q = false;
                    this.r = false;
                }
            } else {
                this.q = false;
                this.r = false;
            }
            this.E = aVar.B;
            f21995a.put(this.f21997c, new WeakReference<>(this));
            com.nexstreaming.app.general.util.D.a(f21995a);
            return;
        }
        throw new UnsupportedOperationException();
    }

    private static a b(int i) {
        a aVar = new a();
        a.a(aVar, i);
        return aVar;
    }

    public static a a() {
        a aVar = new a();
        a.k(aVar);
        a.a(aVar, C1710n.a());
        return aVar;
    }

    public boolean a(boolean z) {
        if (this.q) {
            return z || this.r;
        }
        return false;
    }

    public static OptionMenuItem a(int i) {
        OptionMenuItem optionMenuItem;
        WeakReference<OptionMenuItem> weakReference = f21995a.get(i);
        if (weakReference != null && (optionMenuItem = weakReference.get()) != null) {
            return optionMenuItem;
        }
        for (OptionMenuItem optionMenuItem2 : f21996b) {
            if (optionMenuItem2.f21997c == i) {
                return optionMenuItem2;
            }
        }
        return null;
    }
}
