package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nexstreaming.kinemaster.ui.widget.ValueSpinner;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OptionMenuAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1935kd extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private static int[] f22414a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private int[] f22415b;

    /* renamed from: c, reason: collision with root package name */
    private com.nexstreaming.kinemaster.editorwrapper.Fa f22416c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f22417d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22418e;

    /* renamed from: f, reason: collision with root package name */
    private com.nexstreaming.app.general.util.z f22419f;

    /* renamed from: g, reason: collision with root package name */
    private com.nexstreaming.app.general.util.z f22420g;

    /* renamed from: h, reason: collision with root package name */
    private com.nexstreaming.app.general.util.z f22421h;
    private a j;
    private InterfaceC1997rd i = InterfaceC1997rd.f22506a;
    private List<b> k = new ArrayList();
    private View.OnClickListener l = new ViewOnClickListenerC1900gd(this);

    /* compiled from: OptionMenuAdapter.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kd$a */
    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);

        void a(int i, boolean z);

        void a(OptionMenuItem optionMenuItem);

        boolean b(int i);
    }

    /* compiled from: OptionMenuAdapter.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kd$b */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f22422a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22423b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f22424c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f22425d;

        /* synthetic */ b(int i, boolean z, int[] iArr, int i2, boolean z2, ViewOnClickListenerC1900gd viewOnClickListenerC1900gd) {
            this(i, z, iArr, i2, z2);
        }

        private b(int i, boolean z, int[] iArr, int i2, boolean z2) {
            this.f22422a = i;
            this.f22423b = z;
            this.f22425d = z2;
            if (iArr == null || i2 <= 0) {
                this.f22424c = C1935kd.f22414a;
            } else {
                this.f22424c = new int[i2];
                System.arraycopy(iArr, 0, this.f22424c, 0, i2);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.k.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.k.get(i).f22422a;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int indexOf;
        int i2;
        SwitchCompat switchCompat;
        View view2 = view;
        b bVar = this.k.get(i);
        if (bVar.f22425d) {
            return b(bVar, i, view2, viewGroup);
        }
        if (bVar.f22423b) {
            return a(bVar, i, view2, viewGroup);
        }
        OptionMenuItem a2 = OptionMenuItem.a(bVar.f22422a);
        OptionMenuItem.b bVar2 = a2.z;
        if (bVar2 != null) {
            return bVar2.a(i, null, viewGroup, (NexTimelineItem) this.f22416c, a2, this.j);
        }
        if (a2.s && (this.f22416c instanceof Fa.b) && view2 != null && (switchCompat = (SwitchCompat) view2.findViewById(R.id.itemSwitch)) != null && switchCompat.isChecked() != ((Fa.b) this.f22416c).getSwitchOption(a2.f21997c)) {
            view2 = null;
        }
        if (view2 == null || view2.getId() != R.id.optionMenuListItem) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        }
        view2.setTag(a2);
        View findViewById = view2.findViewById(R.id.appliedOptionIndicator);
        if (findViewById == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
            findViewById = view2.findViewById(R.id.appliedOptionIndicator);
        }
        View findViewById2 = view2.findViewById(R.id.separator);
        if (findViewById2 != null) {
            findViewById2.setVisibility(i < this.k.size() - 1 ? 0 : 4);
        }
        com.nexstreaming.app.general.util.z zVar = this.f22420g;
        if (zVar != null && zVar.b(a2.f21997c)) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
        IconView iconView = (IconView) view2.findViewById(R.id.icon);
        OptionMenuItem.Type type = a2.p;
        if (type == OptionMenuItem.Type.IconResource) {
            iconView.setIconColorStateList(R.color.optmenu_item_text_color);
            if (this.f22421h.b(a2.f21997c)) {
                iconView.setImageResource(a2.f22000f);
                iconView.setIconColor(viewGroup.getContext().getResources().getColor(R.color.optmenu_item_text_color_press));
            } else {
                iconView.setImageResource(a2.f21998d);
            }
        } else if (type == OptionMenuItem.Type.Color) {
            iconView.setIconColorStateList(R.color.optmenu_colorsel_border);
            iconView.setImageDrawable(new C1897ga(view2.getContext(), a(a2)));
        } else if (type == OptionMenuItem.Type.ColorWithAlpha) {
            iconView.setIconColorStateList(R.color.optmenu_colorsel_border);
            iconView.setImageDrawable(new C1897ga(view2.getContext(), a(a2)));
        } else {
            iconView.setIconColorStateList(0);
        }
        View findViewById3 = view2.findViewById(R.id.opt_depth_indicator);
        ImageView imageView = (ImageView) view2.findViewById(R.id.opt_unlock_indicator);
        TextView textView = (TextView) view2.findViewById(R.id.text);
        TextView textView2 = (TextView) view2.findViewById(R.id.textInputField);
        Slider slider = (Slider) view2.findViewById(R.id.opt_item_slider);
        ValueSpinner valueSpinner = (ValueSpinner) view2.findViewById(R.id.opt_item_spinner);
        TextView textView3 = (TextView) view2.findViewById(R.id.opt_tiny_label);
        textView.setTextColor(viewGroup.getContext().getResources().getColorStateList(R.color.optmenu_item_text_color));
        TextView textView4 = (TextView) view2.findViewById(R.id.switchText);
        View findViewById4 = view2.findViewById(R.id.buttonFrame);
        SwitchCompat switchCompat2 = (SwitchCompat) view2.findViewById(R.id.itemSwitch);
        ((ImageView) view2.findViewById(R.id.icon_premium)).setVisibility(8);
        c.d.b.m.n.a(textView2, 8, 13);
        c.d.b.m.n.a(textView, 8, 13);
        c.d.b.m.n.a(textView4, 8, 13);
        OptionMenuItem.Type type2 = a2.p;
        if (type2 == OptionMenuItem.Type.Button) {
            iconView.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(8);
            switchCompat2.setVisibility(8);
            slider.setVisibility(8);
            valueSpinner.setVisibility(8);
            findViewById3.setVisibility(8);
            imageView.setVisibility(8);
            textView3.setVisibility(8);
            findViewById4.setVisibility(0);
            if (a2.b() != null) {
                ((TextView) view2.findViewById(R.id.buttonLabel)).setText(a2.b());
            } else if (a2.f22002h != 0) {
                ((TextView) view2.findViewById(R.id.buttonLabel)).setText(a2.f22002h);
            } else {
                ((TextView) view2.findViewById(R.id.buttonLabel)).setText("");
            }
            if (a2.f21998d != 0) {
                ((ImageView) view2.findViewById(R.id.buttonLeftIcon)).setImageResource(a2.f21998d);
                ((ImageView) view2.findViewById(R.id.buttonLeftIcon)).setVisibility(0);
            } else {
                ((ImageView) view2.findViewById(R.id.buttonLeftIcon)).setImageDrawable(null);
                ((ImageView) view2.findViewById(R.id.buttonLeftIcon)).setVisibility(8);
            }
            if (a2.y) {
                ((ImageView) view2.findViewById(R.id.buttonRightIcon)).setVisibility(0);
            } else {
                ((ImageView) view2.findViewById(R.id.buttonRightIcon)).setVisibility(8);
            }
            if (this.f22419f.b(a2.f21997c)) {
                findViewById4.setAlpha(0.5f);
                findViewById4.setEnabled(false);
            } else {
                findViewById4.setAlpha(1.0f);
                findViewById4.setEnabled(true);
            }
            return view2;
        }
        View view3 = view2;
        if (type2 == OptionMenuItem.Type.Slider) {
            textView.setVisibility(8);
            iconView.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(8);
            switchCompat2.setVisibility(8);
            slider.setVisibility(0);
            valueSpinner.setVisibility(8);
            textView3.setVisibility(0);
            findViewById3.setVisibility(8);
            imageView.setVisibility(8);
            findViewById4.setVisibility(8);
            if (a2.b() != null) {
                textView3.setText(a2.b());
            } else {
                int i3 = a2.f22002h;
                if (i3 != 0) {
                    textView3.setText(i3);
                } else {
                    textView3.setText("");
                }
            }
            if (!a2.v) {
                return view3;
            }
            slider.setMinValue(a2.B);
            slider.setMaxValue(a2.C);
            slider.setStep(a2.D);
            slider.setValue(this.i.b(a2));
            slider.setListener(new C1909hd(this, a2));
            return view3;
        }
        if (type2 == OptionMenuItem.Type.Spinner) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(8);
            switchCompat2.setVisibility(8);
            slider.setVisibility(8);
            valueSpinner.setVisibility(0);
            textView3.setVisibility(0);
            findViewById3.setVisibility(8);
            imageView.setVisibility(8);
            findViewById4.setVisibility(8);
            if (a2.b() != null) {
                textView3.setText(a2.b());
            } else {
                int i4 = a2.f22002h;
                if (i4 != 0) {
                    textView3.setText(i4);
                } else {
                    textView3.setText("");
                }
            }
            if (a2.j != null) {
                iconView.setVisibility(0);
                iconView.setImageBitmap(a2.j);
            } else {
                iconView.setVisibility(8);
            }
            if (!a2.v) {
                return view3;
            }
            float round = Math.round((a2.B - a2.C) / a2.D);
            valueSpinner.setMinValue(a2.B);
            valueSpinner.setMaxValue(a2.C);
            valueSpinner.setStepSize(a2.D);
            float f2 = round / 5.0f;
            if (f2 - Math.round(f2) < 1.0E-7d) {
                valueSpinner.setLargeStepSize(a2.D * 5.0f);
            } else {
                valueSpinner.setLargeStepSize(a2.D * 4.0f);
            }
            valueSpinner.setFormat(a2.i);
            valueSpinner.setTrackBackground(a2.k);
            valueSpinner.a(a2.l, a2.m);
            valueSpinner.a(this.i.b(a2), false);
            valueSpinner.setOnValueChangeListener(new C1918id(this, a2));
            return view3;
        }
        if (type2 != OptionMenuItem.Type.TextField && type2 != OptionMenuItem.Type.TextFieldWithFont) {
            findViewById4.setVisibility(8);
            textView3.setVisibility(8);
            textView2.setVisibility(8);
            if (a2.x) {
                i2 = 0;
                textView4.setPadding(view3.getResources().getDimensionPixelOffset(R.dimen.switch_text_padding_left), 0, 0, 0);
                iconView.setVisibility(8);
            } else {
                i2 = 0;
                textView4.setPadding(0, 0, 0, 0);
                iconView.setVisibility(0);
            }
            slider.setVisibility(8);
            valueSpinner.setVisibility(8);
            textView.setVisibility(i2);
            imageView.setVisibility(a2.t ? 0 : 8);
            if (this.f22417d) {
                imageView.setImageResource(R.drawable.subscription_feature_unlocked);
            } else {
                imageView.setImageResource(R.drawable.subscription_feature_locked);
            }
            findViewById3.setVisibility(a2.o == null ? 8 : 0);
            if (a2.s) {
                switchCompat2.setVisibility(0);
                switchCompat2.setOnCheckedChangeListener(null);
                if (a2.v) {
                    switchCompat2.setChecked(this.i.c(a2));
                } else {
                    com.nexstreaming.kinemaster.editorwrapper.Fa fa = this.f22416c;
                    if (fa instanceof Fa.b) {
                        switchCompat2.setChecked(((Fa.b) fa).getSwitchOption(a2.f21997c));
                    }
                }
                switchCompat2.setOnCheckedChangeListener(new C1926jd(this, a2));
                textView4.setVisibility(0);
                textView.setVisibility(8);
                if (a2.b() != null) {
                    textView4.setText(a2.b());
                } else {
                    int i5 = a2.f22002h;
                    if (i5 != 0) {
                        textView4.setText(i5);
                    } else {
                        textView4.setText("");
                    }
                }
            } else {
                switchCompat2.setVisibility(8);
                textView4.setVisibility(8);
                textView.setVisibility(0);
                if (a2.b() != null) {
                    textView.setText(a2.b());
                } else {
                    int i6 = a2.f22002h;
                    if (i6 != 0) {
                        textView.setText(i6);
                    } else {
                        textView.setText("");
                    }
                }
            }
            if (this.f22419f.b(a2.f21997c)) {
                iconView.setAlpha(0.5f);
                textView.setAlpha(0.5f);
                textView4.setAlpha(0.5f);
                switchCompat2.setEnabled(false);
            } else {
                iconView.setAlpha(1.0f);
                textView.setAlpha(1.0f);
                textView4.setAlpha(1.0f);
                switchCompat2.setEnabled(true);
            }
            if (!this.f22421h.b(a2.f21997c)) {
                return view3;
            }
            textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.optmenu_item_text_color_press));
            return view3;
        }
        iconView.setVisibility(8);
        textView3.setVisibility(8);
        textView.setVisibility(8);
        textView2.setVisibility(0);
        textView4.setVisibility(8);
        switchCompat2.setVisibility(8);
        slider.setVisibility(8);
        valueSpinner.setVisibility(8);
        findViewById3.setVisibility(8);
        imageView.setVisibility(8);
        findViewById4.setVisibility(8);
        if (a2.b() != null) {
            textView2.setHint(a2.b());
        } else {
            textView2.setHint(a2.f22002h);
        }
        if (a2.p == OptionMenuItem.Type.TextFieldWithFont) {
            String a3 = this.i.a(a2);
            if (a3 != null && (indexOf = a3.indexOf(27)) > -1) {
                a3.substring(0, indexOf);
                a3 = a3.substring(indexOf + 1);
            }
            textView2.setText(a3);
            return view3;
        }
        textView2.setText(this.i.a(a2));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.f22419f.b(this.k.get(i).f22422a)) {
            return false;
        }
        return super.isEnabled(i);
    }

    private View b(b bVar, int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != R.id.optionMenuListPlaceholderRow) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_placeholderrow, viewGroup, false);
        }
        View findViewById = view.findViewById(R.id.separator);
        if (findViewById != null) {
            findViewById.setVisibility(i >= this.k.size() + (-1) ? 4 : 0);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public b getItem(int i) {
        return this.k.get(i);
    }

    public void a(InterfaceC1997rd interfaceC1997rd) {
        if (interfaceC1997rd == null) {
            interfaceC1997rd = InterfaceC1997rd.f22506a;
        }
        this.i = interfaceC1997rd;
    }

    public void a(int[] iArr, com.nexstreaming.kinemaster.editorwrapper.Fa fa, com.nexstreaming.app.general.util.z zVar, com.nexstreaming.app.general.util.z zVar2, com.nexstreaming.app.general.util.z zVar3, boolean z, boolean z2, boolean z3) {
        int[] a2 = a(iArr);
        this.f22415b = a2;
        this.f22416c = fa;
        this.f22419f = zVar;
        this.f22420g = zVar2;
        this.f22421h = zVar3;
        this.f22417d = z;
        this.f22418e = z2;
        this.k.clear();
        int[] iArr2 = new int[3];
        boolean z4 = z3;
        for (int i = 0; i < Math.min(3, a2.length); i++) {
            if (!OptionMenuItem.a(this.f22415b[i]).q) {
                z4 = false;
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < a2.length; i3++) {
            OptionMenuItem a3 = OptionMenuItem.a(this.f22415b[i3]);
            if (a3 != null) {
                if (!a3.a(this.f22418e) && (!a3.q || !z4 || i3 >= 3)) {
                    if (i2 > 0) {
                        this.k.add(new b(iArr2[0], true, iArr2, i2, false, null));
                        i2 = 0;
                    }
                    this.k.add(new b(a3.f21997c, false, null, 0, false, null));
                } else {
                    int i4 = i2 + 1;
                    iArr2[i2] = a3.f21997c;
                    if (i4 >= iArr2.length) {
                        this.k.add(new b(iArr2[0], true, iArr2, i4, false, null));
                        i2 = 0;
                    } else {
                        i2 = i4;
                    }
                }
            }
        }
        if (i2 > 0) {
            this.k.add(new b(iArr2[0], true, iArr2, i2, false, null));
        }
        while (this.k.size() < 4) {
            this.k.add(new b(0, false, null, 0, true, null));
        }
    }

    private boolean a(int i) {
        if (i == R.id.opt_information || i != R.id.opt_layer_mask) {
            return false;
        }
        return !EditorGlobal.q;
    }

    private int[] a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            if (!a(i2)) {
                i++;
            }
        }
        if (i == iArr.length) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 : iArr) {
            if (!a(i4)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    private View a(b bVar, int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != R.id.optionMenuListCompactRow) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_compactrow, viewGroup, false);
        }
        View findViewById = view.findViewById(R.id.separator);
        if (findViewById != null) {
            findViewById.setVisibility(i >= this.k.size() + (-1) ? 4 : 0);
        }
        Context context = viewGroup.getContext();
        a(context, bVar, view.findViewById(R.id.icon1), 0, i, view.findViewById(R.id.icon1image));
        a(context, bVar, view.findViewById(R.id.icon2), 1, i, view.findViewById(R.id.icon2image));
        a(context, bVar, view.findViewById(R.id.icon3), 2, i, view.findViewById(R.id.icon3image));
        return view;
    }

    private void a(Context context, b bVar, View view, int i, int i2, View view2) {
        int[] iArr;
        Drawable a2;
        if (bVar != null && (iArr = bVar.f22424c) != null && i < iArr.length) {
            OptionMenuItem a3 = OptionMenuItem.a(iArr[i]);
            view.setVisibility(0);
            if (view instanceof IconButton) {
                IconButton iconButton = (IconButton) view;
                if (a3.s) {
                    com.nexstreaming.kinemaster.editorwrapper.Fa fa = this.f22416c;
                    if (fa instanceof Fa.b) {
                        iconButton.setActivated(((Fa.b) fa).getSwitchOption(a3.f21997c));
                        iconButton.setBackgroundResource(R.drawable.optmenu_compact_switch_bg);
                    }
                } else if (this.f22420g.b(a3.f21997c)) {
                    iconButton.setBackgroundResource(R.drawable.optmenu_compact_applied_ind_bg);
                } else {
                    iconButton.setBackgroundResource(R.drawable.option_menu_list_item_background);
                }
                if (this.f22419f.b(a3.f21997c)) {
                    iconButton.setEnabled(false);
                    iconButton.setAlpha(0.35f);
                } else {
                    iconButton.setEnabled(true);
                    iconButton.setAlpha(1.0f);
                }
                OptionMenuItem.Type type = a3.p;
                if (type != OptionMenuItem.Type.IconResource && type != OptionMenuItem.Type.Button) {
                    if (type == OptionMenuItem.Type.Color) {
                        iconButton.setIconColorStateList(R.color.optmenu_colorsel_border);
                        iconButton.setImageDrawable(new C1897ga(context, a(a3), true));
                        iconButton.setTag(a3);
                        iconButton.setOnClickListener(this.l);
                    } else if (type == OptionMenuItem.Type.ColorWithAlpha) {
                        iconButton.setIconColorStateList(R.color.optmenu_colorsel_border);
                        iconButton.setImageDrawable(new C1897ga(context, a(a3), true));
                        iconButton.setTag(a3);
                        iconButton.setOnClickListener(this.l);
                    }
                } else {
                    iconButton.setIconColorStateList(R.color.optmenu_item_text_color);
                    if (this.f22421h.b(a3.f21997c)) {
                        a2 = a(a3.f22001g, 0.8f, context);
                        iconButton.setIconColor(context.getResources().getColor(R.color.optmenu_item_text_color_press));
                    } else {
                        a2 = a(a3.f21999e, 0.8f, context);
                    }
                    iconButton.setImageDrawable(a2);
                    iconButton.setTag(a3);
                    iconButton.setOnClickListener(this.l);
                }
            }
            view2.setVisibility(8);
            return;
        }
        view.setVisibility(4);
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private int a(OptionMenuItem optionMenuItem) {
        InterfaceC1997rd interfaceC1997rd;
        if (optionMenuItem.v && (interfaceC1997rd = this.i) != null) {
            return interfaceC1997rd.d(optionMenuItem);
        }
        com.nexstreaming.kinemaster.editorwrapper.Fa fa = this.f22416c;
        return (fa == null || !(fa instanceof Fa.a)) ? ViewCompat.MEASURED_STATE_MASK : ((Fa.a) fa).getColorOption(optionMenuItem.f21997c);
    }

    public Drawable a(int i, float f2, Context context) {
        return new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), i), (int) (r3.getWidth() * f2), (int) (r3.getHeight() * f2), true));
    }
}
