package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OptionMenuAdapter.java */
/* loaded from: classes.dex */
public class ep extends BaseAdapter {
    private static int[] j = new int[0];

    /* renamed from: a, reason: collision with root package name */
    com.nexstreaming.app.general.util.q f3877a;
    com.nexstreaming.app.general.util.q b;
    com.nexstreaming.app.general.util.q c;
    private int[] d;
    private NexTimelineItem e;
    private boolean f;
    private boolean g;
    private a h;
    private List<b> i = new ArrayList();
    private View.OnClickListener k = new eq(this);

    /* compiled from: OptionMenuAdapter.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z);

        void a(OptionMenuItem optionMenuItem);

        void c(int i);
    }

    /* compiled from: OptionMenuAdapter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3878a;
        public final boolean b;
        public final int[] c;
        public final boolean d;

        /* synthetic */ b(int i, boolean z, int[] iArr, int i2, boolean z2, eq eqVar) {
            this(i, z, iArr, i2, z2);
        }

        private b(int i, boolean z, int[] iArr, int i2, boolean z2) {
            this.f3878a = i;
            this.b = z;
            this.d = z2;
            if (iArr == null || i2 <= 0) {
                this.c = ep.j;
            } else {
                this.c = new int[i2];
                System.arraycopy(iArr, 0, this.c, 0, i2);
            }
        }
    }

    public void a(int[] iArr, NexTimelineItem nexTimelineItem, com.nexstreaming.app.general.util.q qVar, com.nexstreaming.app.general.util.q qVar2, com.nexstreaming.app.general.util.q qVar3, boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        int[] a2 = a(iArr);
        this.d = a2;
        this.e = nexTimelineItem;
        this.f3877a = qVar;
        this.b = qVar2;
        this.c = qVar3;
        this.f = z;
        this.g = z2;
        this.i.clear();
        int[] iArr2 = new int[3];
        int i3 = 0;
        for (int i4 = 0; i4 < Math.min(3, a2.length); i4++) {
            if (!OptionMenuItem.fromId(this.d[i4]).canCompact) {
                z3 = false;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i3;
            if (i6 >= a2.length) {
                break;
            }
            OptionMenuItem fromId = OptionMenuItem.fromId(this.d[i6]);
            if (fromId == null) {
                i3 = i;
            } else if (fromId.getCompact(this.g) || (fromId.canCompact && z3 && i6 < 3)) {
                int i7 = i + 1;
                iArr2[i] = fromId.id;
                if (i7 >= iArr2.length) {
                    this.i.add(new b(iArr2[0], true, iArr2, i7, false, null));
                    i3 = 0;
                } else {
                    i3 = i7;
                }
            } else {
                if (i > 0) {
                    this.i.add(new b(iArr2[0], true, iArr2, i, false, null));
                    i2 = 0;
                } else {
                    i2 = i;
                }
                this.i.add(new b(fromId.id, false, null, 0, false, null));
                i3 = i2;
            }
            i5 = i6 + 1;
        }
        if (i > 0) {
            this.i.add(new b(iArr2[0], true, iArr2, i, false, null));
        }
        while (this.i.size() < 4) {
            this.i.add(new b(0, false, null, 0, true, null));
        }
    }

    private boolean b(int i) {
        switch (i) {
            case R.id.opt_layer_mask /* 2131820658 */:
            case R.id.opt_layer_name /* 2131820659 */:
                return true;
            default:
                return false;
        }
    }

    private int[] a(int[] iArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            if (!b(i4)) {
                i3++;
            }
        }
        if (i3 != iArr.length) {
            int[] iArr2 = new int[i3];
            int length = iArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = iArr[i5];
                if (b(i6)) {
                    i = i2;
                } else {
                    i = i2 + 1;
                    iArr2[i2] = i6;
                }
                i5++;
                i2 = i;
            }
            return iArr2;
        }
        return iArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.i.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b getItem(int i) {
        return this.i.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.i.get(i).f3878a;
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.f3877a.b(this.i.get(i).f3878a)) {
            return false;
        }
        return super.isEnabled(i);
    }

    private View a(b bVar, int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != R.id.optionMenuListCompactRow) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_compactrow, viewGroup, false);
        }
        View findViewById = view.findViewById(R.id.separator);
        if (findViewById != null) {
            findViewById.setVisibility(i < this.i.size() + (-1) ? 0 : 4);
        }
        Context context = viewGroup.getContext();
        a(context, bVar, view.findViewById(R.id.icon1), 0, i);
        a(context, bVar, view.findViewById(R.id.icon2), 1, i);
        a(context, bVar, view.findViewById(R.id.icon3), 2, i);
        return view;
    }

    private View b(b bVar, int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != R.id.optionMenuListPlaceholderRow) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_placeholderrow, viewGroup, false);
        }
        View findViewById = view.findViewById(R.id.separator);
        if (findViewById != null) {
            findViewById.setVisibility(i >= this.i.size() + (-1) ? 4 : 0);
        }
        return view;
    }

    private void a(Context context, b bVar, View view, int i, int i2) {
        Drawable a2;
        if (bVar == null || bVar.c == null || i >= bVar.c.length) {
            view.setVisibility(4);
            return;
        }
        OptionMenuItem fromId = OptionMenuItem.fromId(bVar.c[i]);
        view.setVisibility(0);
        if (view instanceof IconButton) {
            IconButton iconButton = (IconButton) view;
            if (fromId.switchWidget) {
                if (this.e.getSwitchOption(fromId.id)) {
                    iconButton.setBackgroundResource(R.drawable.optmenu_compact_switch_on);
                } else {
                    iconButton.setBackgroundResource(R.drawable.optmenu_compact_switch_off);
                }
            } else if (this.b.b(fromId.id)) {
                iconButton.setBackgroundResource(R.drawable.optmenu_compact_applied_ind);
            } else {
                iconButton.setBackground(null);
            }
            if (this.f3877a.b(fromId.id)) {
                iconButton.setEnabled(false);
                iconButton.setAlpha(0.35f);
            } else {
                iconButton.setEnabled(true);
                iconButton.setAlpha(1.0f);
            }
            if (fromId.type == OptionMenuItem.Type.IconResource || fromId.type == OptionMenuItem.Type.Button) {
                iconButton.setIconColorStateList(R.color.optmenu_item_text_color);
                if (this.c.b(fromId.id)) {
                    a2 = a(fromId.iconSelectedLarge, 0.8f, context);
                    iconButton.setIconColor(context.getResources().getColor(R.color.optmenu_item_text_color_press));
                } else {
                    a2 = a(fromId.iconLarge, 0.8f, context);
                }
                iconButton.setImageDrawable(a2);
                iconButton.setTag(fromId);
                iconButton.setOnClickListener(this.k);
                return;
            }
            if (fromId.type == OptionMenuItem.Type.Color) {
                iconButton.setIconColorStateList(R.color.optmenu_colorsel_border);
                iconButton.setImageDrawable(new q(context, this.e.getColorOption(fromId.id), true));
                iconButton.setTag(fromId);
                iconButton.setOnClickListener(this.k);
                return;
            }
            if (fromId.type == OptionMenuItem.Type.ColorWithAlpha) {
                iconButton.setIconColorStateList(R.color.optmenu_colorsel_border);
                iconButton.setImageDrawable(new q(context, this.e.getColorOption(fromId.id), true));
                iconButton.setTag(fromId);
                iconButton.setOnClickListener(this.k);
            }
        }
    }

    public Drawable a(int i, float f, Context context) {
        return new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), i), (int) (r0.getWidth() * f), (int) (r0.getHeight() * f), true));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        SwitchCompat switchCompat;
        b bVar = this.i.get(i);
        if (bVar.d) {
            return b(bVar, i, view, viewGroup);
        }
        if (bVar.b) {
            return a(bVar, i, view, viewGroup);
        }
        OptionMenuItem fromId = OptionMenuItem.fromId(bVar.f3878a);
        if (fromId.customItem != null) {
            return fromId.customItem.a(i, null, viewGroup, this.e, fromId, this.h);
        }
        View view4 = (!fromId.switchWidget || view == null || (switchCompat = (SwitchCompat) view.findViewById(R.id.itemSwitch)) == null || switchCompat.isChecked() == this.e.getSwitchOption(fromId.id)) ? view : null;
        if (view4 == null || view4.getId() != R.id.optionMenuListItem) {
            view4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        }
        View findViewById = view4.findViewById(R.id.appliedOptionIndicator);
        if (findViewById == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
            view3 = inflate.findViewById(R.id.appliedOptionIndicator);
            view2 = inflate;
        } else {
            view2 = view4;
            view3 = findViewById;
        }
        View findViewById2 = view2.findViewById(R.id.separator);
        if (findViewById2 != null) {
            findViewById2.setVisibility(i < this.i.size() + (-1) ? 0 : 4);
        }
        if (this.b != null && this.b.b(fromId.id)) {
            view3.setVisibility(0);
        } else {
            view3.setVisibility(4);
        }
        IconView iconView = (IconView) view2.findViewById(R.id.icon);
        if (fromId.type == OptionMenuItem.Type.IconResource) {
            iconView.setIconColorStateList(R.color.optmenu_item_text_color);
            if (this.c.b(fromId.id)) {
                iconView.setImageResource(fromId.iconSelected);
                iconView.setIconColor(viewGroup.getContext().getResources().getColor(R.color.optmenu_item_text_color_press));
            } else {
                iconView.setImageResource(fromId.icon);
            }
        } else if (fromId.type == OptionMenuItem.Type.Color) {
            iconView.setIconColorStateList(R.color.optmenu_colorsel_border);
            iconView.setImageDrawable(new q(view2.getContext(), this.e.getColorOption(fromId.id)));
        } else if (fromId.type == OptionMenuItem.Type.ColorWithAlpha) {
            iconView.setIconColorStateList(R.color.optmenu_colorsel_border);
            iconView.setImageDrawable(new q(view2.getContext(), this.e.getColorOption(fromId.id)));
        }
        View findViewById3 = view2.findViewById(R.id.opt_depth_indicator);
        ImageView imageView = (ImageView) view2.findViewById(R.id.opt_unlock_indicator);
        TextView textView = (TextView) view2.findViewById(R.id.text);
        textView.setTextColor(viewGroup.getContext().getResources().getColorStateList(R.color.optmenu_item_text_color));
        TextView textView2 = (TextView) view2.findViewById(R.id.switchText);
        View findViewById4 = view2.findViewById(R.id.buttonFrame);
        SwitchCompat switchCompat2 = (SwitchCompat) view2.findViewById(R.id.itemSwitch);
        if (fromId.type == OptionMenuItem.Type.Button) {
            iconView.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            switchCompat2.setVisibility(8);
            findViewById3.setVisibility(8);
            imageView.setVisibility(8);
            findViewById4.setVisibility(0);
            ((TextView) view2.findViewById(R.id.buttonLabel)).setText(fromId.string);
            ((ImageView) view2.findViewById(R.id.buttonLeftIcon)).setImageResource(fromId.icon);
            return view2;
        }
        findViewById4.setVisibility(8);
        iconView.setVisibility(0);
        textView.setVisibility(0);
        imageView.setVisibility(fromId.subscriptionFeature ? 0 : 8);
        if (this.f) {
            imageView.setImageResource(R.drawable.subscription_feature_unlocked);
        } else {
            imageView.setImageResource(R.drawable.subscription_feature_locked);
        }
        findViewById3.setVisibility(fromId.fragmentClass == null ? 8 : 0);
        if (fromId.switchWidget) {
            switchCompat2.setVisibility(0);
            switchCompat2.setOnCheckedChangeListener(null);
            switchCompat2.setChecked(this.e.getSwitchOption(fromId.id));
            switchCompat2.setOnCheckedChangeListener(new er(this, fromId));
            textView2.setVisibility(0);
            textView.setVisibility(8);
            textView2.setText(fromId.string);
        } else {
            switchCompat2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(fromId.string);
        }
        if (this.f3877a.b(fromId.id)) {
            iconView.setAlpha(0.5f);
            textView.setAlpha(0.5f);
            textView2.setAlpha(0.5f);
            switchCompat2.setEnabled(false);
        } else {
            iconView.setAlpha(1.0f);
            textView.setAlpha(1.0f);
            textView2.setAlpha(1.0f);
            switchCompat2.setEnabled(true);
        }
        if (this.c.b(fromId.id)) {
            textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.optmenu_item_text_color_press));
            return view2;
        }
        return view2;
    }
}
