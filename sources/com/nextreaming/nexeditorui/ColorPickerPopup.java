package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
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

    /* renamed from: a */
    private static ColorPickerPopup f23991a;

    /* renamed from: b */
    private static final int[] f23992b = {-1, -3355444, -6710887, -8355712, -10066330, -13421773, ViewCompat.MEASURED_STATE_MASK, -14393, -8761, -57, -4262721, -4266252, -4270860, -1851660, -1932414, -1917822, -1973630, -8925319, -8931121, -8938545, -2852179, -1159861, -1135029, -1184181, -12464572, -12473906, -12485938, -6209074, -65024, -26112, -131584, -16724987, -16738100, -14417716, -7601972, -4772821, -4751317, -4802773, -14378201, -14386021, -14396261, -6150548, -8710378, -8700138, -10981355, -15505643, -15511193, -14544025, -11791513, -1481629, -1468061, -1461149, -1454237, -1513117, -4531107, -10957222, -10961002, -10964786, -10975026, -9611058, -5678898, -2794592, -1467466};

    /* renamed from: c */
    private final Context f23993c;

    /* renamed from: f */
    private WindowManager f23996f;

    /* renamed from: g */
    private DisplayMetrics f23997g;

    /* renamed from: h */
    private int f23998h;
    private int i;
    private a j;
    private b k;
    private OrientationEventListener l;
    private boolean m;
    private ColorDetailsMode p;
    private ColorTab q;

    /* renamed from: d */
    private ViewGroup f23994d = null;

    /* renamed from: e */
    private boolean f23995e = false;
    private List<c> n = new ArrayList();
    private float[] o = new float[3];

    /* loaded from: classes.dex */
    public enum ColorDetailsMode {
        RGB,
        HSV
    }

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

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        private final String f23999a;

        /* renamed from: b */
        private final int[] f24000b;

        public c(String str, int[] iArr) {
            this.f23999a = str;
            this.f24000b = iArr;
        }

        public int[] a() {
            return this.f24000b;
        }

        public String b() {
            return this.f23999a;
        }
    }

    public ColorPickerPopup(Context context, boolean z) {
        this.f23993c = context;
        this.f23996f = (WindowManager) this.f23993c.getSystemService("window");
        this.f23997g = this.f23993c.getResources().getDisplayMetrics();
        this.m = z;
    }

    public int d(int i) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((int) ((((Slider) e(R.id.alphaSlider)).getValue() * 255.0f) / 100.0f)) << 24) & ViewCompat.MEASURED_STATE_MASK);
    }

    private View e(int i) {
        ViewGroup viewGroup = this.f23994d;
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.findViewById(i);
    }

    private void f() {
        if (this.f23994d != null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f23993c.getSystemService("layout_inflater")).inflate(R.layout.n2_2_color_picker, (ViewGroup) null);
        this.f23994d = new C2324o(this, this.f23993c);
        this.f23994d.addView(viewGroup);
        i();
    }

    public void g() {
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.f23998h);
        }
    }

    public boolean h() {
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.i);
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(this.i, true);
        }
        a();
        return true;
    }

    private void i() {
        e(R.id.colorpicker_done).setOnClickListener(new ViewOnClickListenerC2326p(this));
        e(R.id.colorpicker_icon_fine).setOnClickListener(new ViewOnClickListenerC2328q(this));
        e(R.id.colorpicker_icon_palette).setOnClickListener(new r(this));
        e(R.id.colorpicker_icon_slider).setOnClickListener(new ViewOnClickListenerC2331s(this));
        e(R.id.colorValues).setOnClickListener(new ViewOnClickListenerC2333t(this));
        for (c cVar : this.n) {
            b(cVar.b(), cVar.a());
        }
        int[] d2 = d();
        if (d2.length > 0) {
            b(this.f23993c.getString(R.string.palette_recent), d2);
        }
        b(this.f23993c.getString(R.string.palette_default), f23992b);
        e(R.id.colorpicker_well_bottom).setOnClickListener(new ViewOnClickListenerC2335u(this));
        ((ColorWheelView) e(R.id.colorpicker_wheel)).setOnColorWheelChangeListener(new C2337v(this));
        if (this.m) {
            ((Slider) e(R.id.alphaSlider)).setListener(new C2339w(this));
        } else {
            e(R.id.alphaSliderHolder).setVisibility(8);
        }
        ((Slider) e(R.id.redSlider)).setListener(new C2306f(this));
        ((Slider) e(R.id.greenSlider)).setListener(new C2308g(this));
        ((Slider) e(R.id.blueSlider)).setListener(new C2310h(this));
    }

    public void c(int i) {
        b(i);
        e();
    }

    public void b(ColorTab colorTab) {
        this.q = colorTab;
        int i = C2322n.f24318a[colorTab.ordinal()];
        if (i == 1) {
            e(R.id.colorpicker_icon_palette).setActivated(true);
            e(R.id.colorpicker_icon_fine).setActivated(false);
            e(R.id.colorpicker_icon_slider).setActivated(false);
            e(R.id.colorpicker_palette_holder).setVisibility(0);
            e(R.id.colorpicker_sliders).setVisibility(4);
            e(R.id.colorpicker_wheel).setVisibility(4);
            return;
        }
        if (i == 2) {
            e(R.id.colorpicker_icon_palette).setActivated(false);
            e(R.id.colorpicker_icon_fine).setActivated(true);
            e(R.id.colorpicker_icon_slider).setActivated(false);
            e(R.id.colorpicker_palette_holder).setVisibility(4);
            e(R.id.colorpicker_sliders).setVisibility(4);
            e(R.id.colorpicker_wheel).setVisibility(0);
            return;
        }
        if (i != 3) {
            return;
        }
        e(R.id.colorpicker_icon_palette).setActivated(false);
        e(R.id.colorpicker_icon_fine).setActivated(false);
        e(R.id.colorpicker_icon_slider).setActivated(true);
        e(R.id.colorpicker_palette_holder).setVisibility(4);
        e(R.id.colorpicker_sliders).setVisibility(0);
        e(R.id.colorpicker_wheel).setVisibility(4);
    }

    public int[] d() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f23993c);
        int i = 0;
        int i2 = 0;
        while (i < 14) {
            if (!defaultSharedPreferences.contains("km.recentColor." + i)) {
                break;
            }
            i2 = i + 1;
            i = i2;
        }
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = defaultSharedPreferences.getInt("km.recentColor." + i3, 0);
        }
        return iArr;
    }

    public ColorTab c() {
        return ColorTab.valueOf(PreferenceManager.getDefaultSharedPreferences(this.f23993c).getString("color_picker_tab_default", ColorTab.Grid.name()));
    }

    public void e() {
        if (this.f23995e) {
            return;
        }
        ColorPickerPopup colorPickerPopup = f23991a;
        if (colorPickerPopup != null) {
            colorPickerPopup.a();
        }
        f();
        this.f23995e = true;
        f23991a = this;
        this.l = new C2320m(this, this.f23993c, 3);
        this.l.enable();
        this.p = b();
        b(c());
        a(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 17;
        layoutParams.width = this.f23993c.getResources().getDimensionPixelSize(R.dimen.colorpicker_dialog_width);
        layoutParams.height = this.f23993c.getResources().getDimensionPixelSize(R.dimen.colorpicker_dialog_height);
        layoutParams.flags |= 2;
        layoutParams.format = -3;
        layoutParams.dimAmount = 0.65f;
        this.f23996f.addView(this.f23994d, layoutParams);
    }

    public void a(String str, int[] iArr) {
        this.n.add(new c(str, iArr));
        if (this.f23995e) {
            b(str, iArr);
        }
    }

    private View a(int i, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) this.f23993c.getSystemService("layout_inflater")).inflate(R.layout.palette_color, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.swatch_image);
        float red = Color.red(i) / 255.0f;
        float green = Color.green(i) / 255.0f;
        float blue = Color.blue(i) / 255.0f;
        double d2 = red * red;
        Double.isNaN(d2);
        double d3 = green * green;
        Double.isNaN(d3);
        double d4 = blue * blue;
        Double.isNaN(d4);
        float sqrt = (float) Math.sqrt((d2 * 0.241d) + (d3 * 0.691d) + (d4 * 0.068d));
        if (sqrt < 100.0f) {
            imageView.setImageResource(R.drawable.color_swatch_dark);
        } else if (sqrt > 150.0f) {
            imageView.setImageResource(R.drawable.color_swatch_light);
        } else {
            imageView.setImageResource(R.drawable.color_swatch);
        }
        imageView.setBackgroundColor(i);
        imageView.setOnClickListener(new ViewOnClickListenerC2312i(this, i));
        return inflate;
    }

    public void a() {
        if (this.f23995e) {
            if (f23991a == this) {
                f23991a = null;
            }
            this.l.disable();
            this.l = null;
            this.f23995e = false;
            ViewGroup viewGroup = this.f23994d;
            if (viewGroup != null) {
                this.f23996f.removeView(viewGroup);
                this.f23994d = null;
            }
        }
    }

    private void b(String str, int[] iArr) {
        LinearLayout linearLayout = (LinearLayout) e(R.id.colorpicker_palette);
        LayoutInflater layoutInflater = (LayoutInflater) this.f23993c.getSystemService("layout_inflater");
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

    public void a(boolean z) {
        String str;
        if (this.f23995e) {
            e(R.id.colorpicker_well_top).setBackgroundColor(this.f23998h);
            e(R.id.colorpicker_well_bottom).setBackgroundColor(this.i);
            if (z || this.q != ColorTab.Sliders) {
                ((Slider) e(R.id.redSlider)).setValue(Color.red(this.f23998h));
                ((Slider) e(R.id.greenSlider)).setValue(Color.green(this.f23998h));
                ((Slider) e(R.id.blueSlider)).setValue(Color.blue(this.f23998h));
            }
            TextView textView = (TextView) e(R.id.hexColorText);
            textView.setText(String.format("#%06X", Integer.valueOf(this.f23998h & ViewCompat.MEASURED_SIZE_MASK)));
            textView.setOnLongClickListener(new ViewOnLongClickListenerC2318l(this));
            Color.colorToHSV(this.f23998h, this.o);
            if (C2322n.f24319b[this.p.ordinal()] != 1) {
                str = String.format("#%06X", Integer.valueOf(16777215 & this.f23998h)) + "\n\nR: " + Color.red(this.f23998h) + "\nG: " + Color.green(this.f23998h) + "\nB: " + Color.blue(this.f23998h) + "\n\nA: " + Color.alpha(this.f23998h) + "\n";
            } else {
                str = String.format("#%06X", Integer.valueOf(16777215 & this.f23998h)) + "\n\nH: " + String.format("%.1f", Float.valueOf(this.o[0])) + "º\nS: " + String.format("%.1f", Float.valueOf(this.o[1] * 100.0f)) + "%\nV: " + String.format("%.1f", Float.valueOf(this.o[2] * 100.0f)) + "%\n\nA: " + Color.alpha(this.f23998h) + "\n";
            }
            ((TextView) e(R.id.colorValues)).setText(str);
            ((Slider) e(R.id.alphaSlider)).setValue((Color.alpha(this.f23998h) * 100.0f) / 255.0f);
            if (z || this.q != ColorTab.Wheel) {
                ((ColorWheelView) e(R.id.colorpicker_wheel)).setColor(this.f23998h);
            }
        }
    }

    public void b(int i) {
        this.i = i;
        this.f23998h = i;
        a(true);
    }

    public ColorDetailsMode b() {
        return ColorDetailsMode.valueOf(PreferenceManager.getDefaultSharedPreferences(this.f23993c).getString("color_picker_detailmode_default", ColorDetailsMode.RGB.name()));
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    public void a(int i) {
        int i2 = i | ViewCompat.MEASURED_STATE_MASK;
        int[] d2 = d();
        for (int i3 = 0; i3 < d2.length; i3++) {
            if (d2[i3] == i2) {
                if (i3 == 0) {
                    return;
                }
                System.arraycopy(d2, 0, d2, 1, i3);
                d2[0] = i2;
                a(d2);
                return;
            }
        }
        if (d2.length < 14) {
            int[] iArr = new int[d2.length + 1];
            System.arraycopy(d2, 0, iArr, 1, d2.length);
            iArr[0] = i2;
            a(iArr);
            return;
        }
        System.arraycopy(d2, 0, d2, 1, d2.length - 1);
        d2[0] = i2;
        a(d2);
    }

    public void a(int[] iArr) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f23993c).edit();
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

    public void a(ColorTab colorTab) {
        PreferenceManager.getDefaultSharedPreferences(this.f23993c).edit().putString("color_picker_tab_default", colorTab.name()).commit();
    }

    public void a(ColorDetailsMode colorDetailsMode) {
        PreferenceManager.getDefaultSharedPreferences(this.f23993c).edit().putString("color_picker_detailmode_default", colorDetailsMode.name()).commit();
    }
}
