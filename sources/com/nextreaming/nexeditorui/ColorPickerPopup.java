package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ColorPickerPopup {
    private static ColorPickerPopup j;
    private static final int[] q = {-1, -3355444, -6710887, -8355712, -10066330, -13421773, -16777216, -14393, -8761, -57, -4262721, -4266252, -4270860, -1851660, -1932414, -1917822, -1973630, -8925319, -8931121, -8938545, -2852179, -1159861, -1135029, -1184181, -12464572, -12473906, -12485938, -6209074, -65024, -26112, -131584, -16724987, -16738100, -14417716, -7601972, -4772821, -4751317, -4802773, -14378201, -14386021, -14396261, -6150548, -8710378, -8700138, -10981355, -15505643, -15511193, -14544025, -11791513, -1481629, -1468061, -1461149, -1454237, -1513117, -4531107, -10957222, -10961002, -10964786, -10975026, -9611058, -5678898, -2794592, -1467466};

    /* renamed from: a, reason: collision with root package name */
    private final Context f4464a;
    private WindowManager d;
    private DisplayMetrics e;
    private int f;
    private int g;
    private a h;
    private b i;
    private OrientationEventListener k;
    private boolean l;
    private ColorDetailsMode o;
    private ColorTab p;
    private ViewGroup b = null;
    private boolean c = false;
    private List<c> m = new ArrayList();
    private float[] n = new float[3];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ColorDetailsMode {
        RGB,
        HSV
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ColorTab {
        Grid,
        Wheel,
        Sliders
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f4466a;
        private final int[] b;

        public c(String str, int[] iArr) {
            this.f4466a = str;
            this.b = iArr;
        }

        public int[] a() {
            return this.b;
        }

        public String b() {
            return this.f4466a;
        }
    }

    public void a(String str, int[] iArr) {
        this.m.add(new c(str, iArr));
        if (this.c) {
            b(str, iArr);
        }
    }

    public ColorPickerPopup(Context context, boolean z) {
        this.f4464a = context;
        this.d = (WindowManager) this.f4464a.getSystemService("window");
        this.e = this.f4464a.getResources().getDisplayMetrics();
        this.l = z;
    }

    private float a(float f) {
        return TypedValue.applyDimension(1, f, this.e);
    }

    private void f() {
        if (this.b == null) {
            ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f4464a.getSystemService("layout_inflater")).inflate(R.layout.n2_2_color_picker, (ViewGroup) null);
            this.b = new d(this, this.f4464a);
            this.b.addView(viewGroup);
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (this.h != null) {
            this.h.a(this.g);
        }
        if (this.i != null) {
            this.i.a(this.g, true);
        }
        a();
        return true;
    }

    private View d(int i) {
        if (this.b == null) {
            return null;
        }
        return this.b.findViewById(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ColorTab colorTab) {
        this.p = colorTab;
        switch (colorTab) {
            case Grid:
                d(R.id.colorpicker_icon_palette).setActivated(true);
                d(R.id.colorpicker_icon_fine).setActivated(false);
                d(R.id.colorpicker_icon_slider).setActivated(false);
                d(R.id.colorpicker_palette_holder).setVisibility(0);
                d(R.id.colorpicker_sliders).setVisibility(4);
                d(R.id.colorpicker_wheel).setVisibility(4);
                return;
            case Wheel:
                d(R.id.colorpicker_icon_palette).setActivated(false);
                d(R.id.colorpicker_icon_fine).setActivated(true);
                d(R.id.colorpicker_icon_slider).setActivated(false);
                d(R.id.colorpicker_palette_holder).setVisibility(4);
                d(R.id.colorpicker_sliders).setVisibility(4);
                d(R.id.colorpicker_wheel).setVisibility(0);
                return;
            case Sliders:
                d(R.id.colorpicker_icon_palette).setActivated(false);
                d(R.id.colorpicker_icon_fine).setActivated(false);
                d(R.id.colorpicker_icon_slider).setActivated(true);
                d(R.id.colorpicker_palette_holder).setVisibility(4);
                d(R.id.colorpicker_sliders).setVisibility(0);
                d(R.id.colorpicker_wheel).setVisibility(4);
                return;
            default:
                return;
        }
    }

    private void h() {
        d(R.id.colorpicker_done).setOnClickListener(new m(this));
        d(R.id.colorpicker_icon_fine).setOnClickListener(new n(this));
        d(R.id.colorpicker_icon_palette).setOnClickListener(new o(this));
        d(R.id.colorpicker_icon_slider).setOnClickListener(new p(this));
        d(R.id.colorValues).setOnClickListener(new q(this));
        for (c cVar : this.m) {
            b(cVar.b(), cVar.a());
        }
        int[] b2 = b();
        if (b2.length > 0) {
            b(this.f4464a.getString(R.string.palette_recent), b2);
        }
        b(this.f4464a.getString(R.string.palette_default), q);
        d(R.id.colorpicker_well_bottom).setOnClickListener(new r(this));
        ((ColorWheelView) d(R.id.colorpicker_wheel)).setOnColorWheelChangeListener(new s(this));
        if (this.l) {
            ((Slider) d(R.id.alphaSlider)).setListener(new t(this));
        } else {
            d(R.id.alphaSliderHolder).setVisibility(8);
        }
        ((Slider) d(R.id.redSlider)).setListener(new e(this));
        ((Slider) d(R.id.greenSlider)).setListener(new f(this));
        ((Slider) d(R.id.blueSlider)).setListener(new g(this));
    }

    private void b(String str, int[] iArr) {
        LinearLayout linearLayout = (LinearLayout) d(R.id.colorpicker_palette);
        LayoutInflater layoutInflater = (LayoutInflater) this.f4464a.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.palette_section_header, (ViewGroup) linearLayout, false);
        ((TextView) inflate.findViewById(R.id.text)).setText(str);
        linearLayout.addView(inflate);
        LinearLayout linearLayout2 = null;
        for (int i : iArr) {
            if (linearLayout2 == null || linearLayout2.getChildCount() >= 7) {
                linearLayout2 = (LinearLayout) layoutInflater.inflate(R.layout.palette_row, (ViewGroup) linearLayout, false);
                linearLayout.addView(linearLayout2);
            }
            linearLayout2.addView(a(i, linearLayout));
        }
    }

    private View a(int i, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) this.f4464a.getSystemService("layout_inflater")).inflate(R.layout.palette_color, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.swatch_image);
        float red = Color.red(i) / 255.0f;
        float green = Color.green(i) / 255.0f;
        float blue = Color.blue(i) / 255.0f;
        float sqrt = (float) Math.sqrt((green * green * 0.691d) + (red * red * 0.241d) + (blue * blue * 0.068d));
        if (sqrt < 100.0f) {
            imageView.setImageResource(R.drawable.color_swatch_dark);
        } else if (sqrt > 150.0f) {
            imageView.setImageResource(R.drawable.color_swatch_light);
        } else {
            imageView.setImageResource(R.drawable.color_swatch);
        }
        imageView.setBackgroundColor(i);
        imageView.setOnClickListener(new h(this, i));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(int i) {
        return ((((int) ((((Slider) d(R.id.alphaSlider)).getValue() * 255.0f) / 100.0f)) << 24) & (-16777216)) | (16777215 & i);
    }

    public void a() {
        if (this.c) {
            if (j == this) {
                j = null;
            }
            this.k.disable();
            this.k = null;
            this.c = false;
            if (this.b != null) {
                this.d.removeView(this.b);
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.h != null) {
            this.h.a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        String str;
        if (this.c) {
            d(R.id.colorpicker_well_top).setBackgroundColor(this.f);
            d(R.id.colorpicker_well_bottom).setBackgroundColor(this.g);
            if (z || this.p != ColorTab.Sliders) {
                ((Slider) d(R.id.redSlider)).setValue(Color.red(this.f));
                ((Slider) d(R.id.greenSlider)).setValue(Color.green(this.f));
                ((Slider) d(R.id.blueSlider)).setValue(Color.blue(this.f));
            }
            TextView textView = (TextView) d(R.id.hexColorText);
            textView.setText(String.format("#%06X", Integer.valueOf(this.f & 16777215)));
            textView.setOnLongClickListener(new i(this));
            Color.colorToHSV(this.f, this.n);
            switch (this.o) {
                case HSV:
                    str = String.format("#%06X", Integer.valueOf(this.f & 16777215)) + "\n\nH: " + String.format("%.1f", Float.valueOf(this.n[0])) + "º\nS: " + String.format("%.1f", Float.valueOf(this.n[1] * 100.0f)) + "%\nV: " + String.format("%.1f", Float.valueOf(this.n[2] * 100.0f)) + "%\n\nA: " + Color.alpha(this.f) + "\n";
                    break;
                default:
                    str = String.format("#%06X", Integer.valueOf(this.f & 16777215)) + "\n\nR: " + Color.red(this.f) + "\nG: " + Color.green(this.f) + "\nB: " + Color.blue(this.f) + "\n\nA: " + Color.alpha(this.f) + "\n";
                    break;
            }
            ((TextView) d(R.id.colorValues)).setText(str);
            ((Slider) d(R.id.alphaSlider)).setValue((Color.alpha(this.f) * 100.0f) / 255.0f);
            if (z || this.p != ColorTab.Wheel) {
                ((ColorWheelView) d(R.id.colorpicker_wheel)).setColor(this.f);
            }
        }
    }

    public void a(int i) {
        this.g = i;
        this.f = i;
        a(true);
    }

    public void b(int i) {
        a(i);
        e();
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    public void a(b bVar) {
        this.i = bVar;
    }

    public void c(int i) {
        int i2 = (-16777216) | i;
        int[] b2 = b();
        for (int i3 = 0; i3 < b2.length; i3++) {
            if (b2[i3] == i2) {
                if (i3 != 0) {
                    System.arraycopy(b2, 0, b2, 1, i3);
                    b2[0] = i2;
                    a(b2);
                    return;
                }
                return;
            }
        }
        if (b2.length < 14) {
            int[] iArr = new int[b2.length + 1];
            System.arraycopy(b2, 0, iArr, 1, b2.length);
            iArr[0] = i2;
            a(iArr);
            return;
        }
        System.arraycopy(b2, 0, b2, 1, b2.length - 1);
        b2[0] = i2;
        a(b2);
    }

    public void a(int[] iArr) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f4464a).edit();
        for (int i = 0; i < 14; i++) {
            String str = "km.recentColor." + i;
            if (i < iArr.length) {
                edit.putInt(str, iArr[i]);
            } else {
                edit.remove(str);
            }
        }
        edit.commit();
    }

    public int[] b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4464a);
        int i = 0;
        for (int i2 = 0; i2 < 14 && defaultSharedPreferences.contains("km.recentColor." + i2); i2++) {
            i = i2 + 1;
        }
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = defaultSharedPreferences.getInt("km.recentColor." + i3, 0);
        }
        return iArr;
    }

    public void a(ColorTab colorTab) {
        PreferenceManager.getDefaultSharedPreferences(this.f4464a).edit().putString("color_picker_tab_default", colorTab.name()).commit();
    }

    public ColorTab c() {
        return ColorTab.valueOf(PreferenceManager.getDefaultSharedPreferences(this.f4464a).getString("color_picker_tab_default", ColorTab.Grid.name()));
    }

    public void a(ColorDetailsMode colorDetailsMode) {
        PreferenceManager.getDefaultSharedPreferences(this.f4464a).edit().putString("color_picker_detailmode_default", colorDetailsMode.name()).commit();
    }

    public ColorDetailsMode d() {
        return ColorDetailsMode.valueOf(PreferenceManager.getDefaultSharedPreferences(this.f4464a).getString("color_picker_detailmode_default", ColorDetailsMode.RGB.name()));
    }

    public void e() {
        if (!this.c) {
            if (j != null) {
                j.a();
            }
            f();
            this.c = true;
            j = this;
            this.k = new l(this, this.f4464a, 3);
            this.k.enable();
            this.o = d();
            b(c());
            a(true);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = (int) a(442.0f);
            layoutParams.height = (int) a(242.0f);
            layoutParams.flags |= 2;
            layoutParams.format = -3;
            layoutParams.dimAmount = 0.65f;
            this.d.addView(this.b, layoutParams);
        }
    }
}
