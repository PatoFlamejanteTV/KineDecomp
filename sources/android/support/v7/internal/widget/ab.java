package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v7.b.a;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: TintManager.java */
/* loaded from: classes.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f162a;
    private static final PorterDuff.Mode b;
    private static final WeakHashMap<Context, ab> c;
    private static final a d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;
    private final WeakReference<Context> k;
    private SparseArray<ColorStateList> l;
    private ColorStateList m;

    static {
        f162a = Build.VERSION.SDK_INT < 21;
        b = PorterDuff.Mode.SRC_IN;
        c = new WeakHashMap<>();
        d = new a(6);
        e = new int[]{a.d.abc_textfield_search_default_mtrl_alpha, a.d.abc_textfield_default_mtrl_alpha, a.d.abc_ab_share_pack_mtrl_alpha};
        f = new int[]{a.d.abc_ic_ab_back_mtrl_am_alpha, a.d.abc_ic_go_search_api_mtrl_alpha, a.d.abc_ic_search_api_mtrl_alpha, a.d.abc_ic_commit_search_api_mtrl_alpha, a.d.abc_ic_clear_mtrl_alpha, a.d.abc_ic_menu_share_mtrl_alpha, a.d.abc_ic_menu_copy_mtrl_am_alpha, a.d.abc_ic_menu_cut_mtrl_alpha, a.d.abc_ic_menu_selectall_mtrl_alpha, a.d.abc_ic_menu_paste_mtrl_am_alpha, a.d.abc_ic_menu_moreoverflow_mtrl_alpha, a.d.abc_ic_voice_search_api_mtrl_alpha};
        g = new int[]{a.d.abc_textfield_activated_mtrl_alpha, a.d.abc_textfield_search_activated_mtrl_alpha, a.d.abc_cab_background_top_mtrl_alpha, a.d.abc_text_cursor_mtrl_alpha};
        h = new int[]{a.d.abc_popup_background_mtrl_mult, a.d.abc_cab_background_internal_bg, a.d.abc_menu_hardkey_panel_mtrl_mult};
        i = new int[]{a.d.abc_edit_text_material, a.d.abc_tab_indicator_material, a.d.abc_textfield_search_material, a.d.abc_spinner_mtrl_am_alpha, a.d.abc_spinner_textfield_background_material, a.d.abc_ratingbar_full_material, a.d.abc_switch_track_mtrl_alpha, a.d.abc_switch_thumb_material, a.d.abc_btn_default_mtrl_shape, a.d.abc_btn_borderless_material};
        j = new int[]{a.d.abc_btn_check_material, a.d.abc_btn_radio_material};
    }

    public static Drawable a(Context context, int i2) {
        return d(i2) ? a(context).a(i2) : android.support.v4.a.a.a(context, i2);
    }

    public static ab a(Context context) {
        ab abVar = c.get(context);
        if (abVar == null) {
            ab abVar2 = new ab(context);
            c.put(context, abVar2);
            return abVar2;
        }
        return abVar;
    }

    private ab(Context context) {
        this.k = new WeakReference<>(context);
    }

    public Drawable a(int i2) {
        return a(i2, false);
    }

    public Drawable a(int i2, boolean z) {
        Context context = this.k.get();
        if (context == null) {
            return null;
        }
        Drawable a2 = android.support.v4.a.a.a(context, i2);
        if (a2 != null) {
            if (Build.VERSION.SDK_INT >= 8) {
                a2 = a2.mutate();
            }
            ColorStateList c2 = c(i2);
            if (c2 != null) {
                a2 = android.support.v4.b.a.a.c(a2);
                android.support.v4.b.a.a.a(a2, c2);
                PorterDuff.Mode b2 = b(i2);
                if (b2 != null) {
                    android.support.v4.b.a.a.a(a2, b2);
                }
            } else {
                if (i2 == a.d.abc_cab_background_top_material) {
                    return new LayerDrawable(new Drawable[]{a(a.d.abc_cab_background_internal_bg), a(a.d.abc_cab_background_top_mtrl_alpha)});
                }
                if (!a(i2, a2) && z) {
                    a2 = null;
                }
            }
        }
        return a2;
    }

    public final boolean a(int i2, Drawable drawable) {
        int i3;
        int i4;
        PorterDuff.Mode mode;
        boolean z;
        Context context = this.k.get();
        if (context == null) {
            return false;
        }
        if (a(e, i2)) {
            i4 = a.C0016a.colorControlNormal;
            mode = null;
            z = true;
            i3 = -1;
        } else if (a(g, i2)) {
            i4 = a.C0016a.colorControlActivated;
            mode = null;
            z = true;
            i3 = -1;
        } else if (a(h, i2)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i4 = 16842801;
            i3 = -1;
        } else if (i2 != a.d.abc_list_divider_mtrl_alpha) {
            i3 = -1;
            i4 = 0;
            mode = null;
            z = false;
        } else {
            i4 = R.attr.colorForeground;
            i3 = Math.round(40.8f);
            mode = null;
            z = true;
        }
        if (!z) {
            return false;
        }
        a(drawable, y.a(context, i4), mode);
        if (i3 != -1) {
            drawable.setAlpha(i3);
        }
        return true;
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(int i2) {
        return a(f, i2) || a(e, i2) || a(g, i2) || a(i, i2) || a(h, i2) || a(j, i2) || i2 == a.d.abc_cab_background_top_material;
    }

    final PorterDuff.Mode b(int i2) {
        if (i2 != a.d.abc_switch_thumb_material) {
            return null;
        }
        return PorterDuff.Mode.MULTIPLY;
    }

    public final ColorStateList c(int i2) {
        ColorStateList g2;
        Context context = this.k.get();
        if (context == null) {
            return null;
        }
        ColorStateList colorStateList = this.l != null ? this.l.get(i2) : null;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (i2 == a.d.abc_edit_text_material) {
            g2 = f(context);
        } else if (i2 == a.d.abc_switch_track_mtrl_alpha) {
            g2 = d(context);
        } else if (i2 == a.d.abc_switch_thumb_material) {
            g2 = e(context);
        } else if (i2 == a.d.abc_btn_default_mtrl_shape || i2 == a.d.abc_btn_borderless_material) {
            g2 = g(context);
        } else if (i2 == a.d.abc_spinner_mtrl_am_alpha || i2 == a.d.abc_spinner_textfield_background_material) {
            g2 = h(context);
        } else if (a(f, i2)) {
            g2 = y.b(context, a.C0016a.colorControlNormal);
        } else if (a(i, i2)) {
            g2 = b(context);
        } else {
            g2 = a(j, i2) ? c(context) : colorStateList;
        }
        if (g2 != null) {
            if (this.l == null) {
                this.l = new SparseArray<>();
            }
            this.l.append(i2, g2);
            return g2;
        }
        return g2;
    }

    private ColorStateList b(Context context) {
        if (this.m == null) {
            int a2 = y.a(context, a.C0016a.colorControlNormal);
            int a3 = y.a(context, a.C0016a.colorControlActivated);
            this.m = new ColorStateList(new int[][]{y.f194a, y.b, y.c, y.d, y.e, y.f, y.h}, new int[]{y.c(context, a.C0016a.colorControlNormal), a3, a3, a3, a3, a3, a2});
        }
        return this.m;
    }

    private ColorStateList c(Context context) {
        return new ColorStateList(new int[][]{y.f194a, y.e, y.h}, new int[]{y.c(context, a.C0016a.colorControlNormal), y.a(context, a.C0016a.colorControlActivated), y.a(context, a.C0016a.colorControlNormal)});
    }

    private ColorStateList d(Context context) {
        return new ColorStateList(new int[][]{y.f194a, y.e, y.h}, new int[]{y.a(context, R.attr.colorForeground, 0.1f), y.a(context, a.C0016a.colorControlActivated, 0.3f), y.a(context, R.attr.colorForeground, 0.3f)});
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList b2 = y.b(context, a.C0016a.colorSwitchThumbNormal);
        if (b2 != null && b2.isStateful()) {
            iArr[0] = y.f194a;
            iArr2[0] = b2.getColorForState(iArr[0], 0);
            iArr[1] = y.e;
            iArr2[1] = y.a(context, a.C0016a.colorControlActivated);
            iArr[2] = y.h;
            iArr2[2] = b2.getDefaultColor();
        } else {
            iArr[0] = y.f194a;
            iArr2[0] = y.c(context, a.C0016a.colorSwitchThumbNormal);
            iArr[1] = y.e;
            iArr2[1] = y.a(context, a.C0016a.colorControlActivated);
            iArr[2] = y.h;
            iArr2[2] = y.a(context, a.C0016a.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList f(Context context) {
        return new ColorStateList(new int[][]{y.f194a, y.g, y.h}, new int[]{y.c(context, a.C0016a.colorControlNormal), y.a(context, a.C0016a.colorControlNormal), y.a(context, a.C0016a.colorControlActivated)});
    }

    private ColorStateList g(Context context) {
        int a2 = y.a(context, a.C0016a.colorButtonNormal);
        int a3 = y.a(context, a.C0016a.colorControlHighlight);
        return new ColorStateList(new int[][]{y.f194a, y.d, y.b, y.h}, new int[]{y.c(context, a.C0016a.colorButtonNormal), android.support.v4.b.a.a(a3, a2), android.support.v4.b.a.a(a3, a2), a2});
    }

    private ColorStateList h(Context context) {
        return new ColorStateList(new int[][]{y.f194a, y.g, y.h}, new int[]{y.c(context, a.C0016a.colorControlNormal), y.a(context, a.C0016a.colorControlNormal), y.a(context, a.C0016a.colorControlActivated)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TintManager.java */
    /* loaded from: classes.dex */
    public static class a extends android.support.v4.f.g<Integer, PorterDuffColorFilter> {
        public a(int i) {
            super(i);
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return a((a) Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((a) Integer.valueOf(b(i, mode)), (Integer) porterDuffColorFilter);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    public static void a(View view, aa aaVar) {
        Drawable background = view.getBackground();
        if (aaVar.d) {
            a(background, aaVar.f161a.getColorForState(view.getDrawableState(), aaVar.f161a.getDefaultColor()), aaVar.c ? aaVar.b : null);
        } else {
            background.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 10) {
            view.invalidate();
        }
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = b;
        }
        PorterDuffColorFilter a2 = d.a(i2, mode);
        if (a2 == null) {
            a2 = new PorterDuffColorFilter(i2, mode);
            d.a(i2, mode, a2);
        }
        drawable.setColorFilter(a2);
    }
}
