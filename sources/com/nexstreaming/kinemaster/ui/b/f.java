package com.nexstreaming.kinemaster.ui.b;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.kmpackage.UserFieldType;
import com.nexstreaming.kinemaster.kmpackage.au;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nextreaming.nexeditorui.ColorPickerView;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class f extends com.nexstreaming.kinemaster.ui.b.c {
    private ListView b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private ScrollView f;
    private b g;
    private ImageView h;
    private TextView i;
    private com.nexstreaming.kinemaster.kmpackage.b j;
    private DurationSpinner k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private boolean[] o;
    private EffectLibrary p;
    private View q;
    private NexTimelineItem.j r;
    private a s;

    /* renamed from: a, reason: collision with root package name */
    private int[] f3690a = {R.drawable.test_icon, R.drawable.test_icon, R.drawable.test_icon};
    private boolean t = false;
    private View.OnClickListener u = new h(this);

    /* compiled from: EffectSettingsFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.clip_effect_fragment, viewGroup, false);
        this.q = inflate;
        b(inflate);
        f(R.string.effect_settings_panel_title);
        d(true);
        a(inflate);
        this.b = (ListView) inflate.findViewById(R.id.effectListView);
        this.c = (LinearLayout) inflate.findViewById(R.id.noneBtnHolder);
        this.c.setOnClickListener(this.u);
        this.d = (LinearLayout) inflate.findViewById(R.id.effectBtnHolder);
        this.d.setOnClickListener(this.u);
        this.k = (DurationSpinner) inflate.findViewById(R.id.durationSpinner);
        this.e = (LinearLayout) inflate.findViewById(R.id.defaultViewHolder);
        this.f = (ScrollView) inflate.findViewById(R.id.effectViewHolder);
        this.h = (ImageView) inflate.findViewById(R.id.effectIcon);
        this.i = (TextView) inflate.findViewById(R.id.effectName);
        this.l = (LinearLayout) inflate.findViewById(R.id.effectSettingsHolder);
        this.k.setOnValueChangeListener(new g(this));
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (i()) {
            a(R.id.action_undo, 0, R.id.action_redo, 0);
        } else if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        g_();
        if (i()) {
            String effectID = ((NexTransitionItem) m()).getEffectID();
            if (effectID == null || effectID.equals("none")) {
                d(R.id.action_delete, false);
            } else {
                d(R.id.action_delete, true);
            }
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onPause() {
        c();
        if (this.t) {
            this.t = false;
            super.d();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void d() {
        this.t = true;
        f_();
    }

    private NexTimelineItem.j h() {
        if (m() == null || !(m() instanceof NexPrimaryTimelineItem)) {
            return null;
        }
        return (NexTimelineItem.j) m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return m() != null && (m() instanceof NexTransitionItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NexTransitionItem j() {
        if (i()) {
            return (NexTransitionItem) m();
        }
        return null;
    }

    public void a(View view) {
        this.g = new b();
        this.b = (ListView) view.findViewById(R.id.effectListView);
        this.b.setAdapter((ListAdapter) this.g);
        for (int i : this.f3690a) {
            this.g.a(i, "Effect List 01");
        }
    }

    private float a(NexTransitionItem nexTransitionItem) {
        if (nexTransitionItem == null || nexTransitionItem.getTransition() == null) {
            return 0.0f;
        }
        float maximumDuration = nexTransitionItem.getTransition().getMaximumDuration() / 1000.0f;
        if (30.0f <= maximumDuration) {
            return 30.0f;
        }
        return maximumDuration;
    }

    private boolean a(com.nexstreaming.kinemaster.kmpackage.b bVar) {
        if (bVar != null && bVar != this.j && !bVar.a().equals("none") && this.r != null) {
            this.j = bVar;
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.r.setEffect(this.j);
            if (j() != null) {
                this.k.setVisibility(0);
                this.k.setScrollMaxValue(a(j()));
                this.k.setMaxValue(a(j()));
                this.k.a(this.r.getEffectDuration() / 1000.0f, false);
            }
            this.h.setImageBitmap(this.j.c(getActivity()));
            this.i.setText(this.j.a(getActivity()));
            e();
            g(R.id.editmode_fxtime);
            return true;
        }
        if (bVar != null && (bVar == null || !bVar.a().equals("None") || this.r == null)) {
            return false;
        }
        this.j = null;
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        if (i()) {
            this.k.setVisibility(8);
        } else {
            g(0);
        }
        if (this.r == null) {
            return true;
        }
        this.r.setEffect(bVar);
        return true;
    }

    /* compiled from: EffectSettingsFragment.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f3693a;
        String b;

        c(int i, String str) {
            this.f3693a = i;
            this.b = str;
        }
    }

    public static FragmentTransaction a(FragmentTransaction fragmentTransaction) {
        return fragmentTransaction.setCustomAnimations(R.animator.optpanel_slide_in_from_bottom, R.animator.optpanel_fade_out, R.animator.optpanel_fade_in, R.animator.optpanel_slide_out_from_bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EffectSettingsFragment.java */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        private ArrayList<c> b = new ArrayList<>();

        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Context context = viewGroup.getContext();
            if (view == null) {
                View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.rec_effect_item, viewGroup, false);
                ((ImageView) inflate.findViewById(R.id.effectIcon)).setImageDrawable(f.this.getResources().getDrawable(this.b.get(i).f3693a));
                ((TextView) inflate.findViewById(R.id.effectName)).setText(this.b.get(i).b);
                return inflate;
            }
            return view;
        }

        public void a(int i, String str) {
            this.b.add(new c(i, str));
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == R.id.edit_fx_userfield_text) {
            if (i2 == 1) {
                String a2 = a(FullScreenInputActivity.b(intent));
                String c2 = FullScreenInputActivity.c(intent);
                if (this.s != null) {
                    this.s.a(a2, c2);
                    this.s = null;
                    return;
                }
                return;
            }
            if (this.s != null) {
                this.s.a(null, null);
                this.s = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r10 = this;
            r4 = 0
            r3 = 1
            r2 = 0
            android.widget.LinearLayout r0 = r10.l
            if (r0 != 0) goto L8
        L7:
            return
        L8:
            com.nextreaming.nexeditorui.NexTimelineItem$j r0 = r10.r
            if (r0 == 0) goto L7
            android.widget.LinearLayout r0 = r10.l
            r0.removeAllViews()
            boolean[] r0 = r10.o
            if (r0 == 0) goto L19
            boolean[] r0 = r10.o
            r0[r2] = r2
        L19:
            android.app.Activity r0 = r10.getActivity()
            com.nexstreaming.kinemaster.kmpackage.EffectLibrary r0 = com.nexstreaming.kinemaster.kmpackage.EffectLibrary.a(r0)
            if (r0 == 0) goto L7
            com.nextreaming.nexeditorui.NexTimelineItem$j r1 = r10.r
            java.lang.String r1 = r1.getEffectID()
            com.nexstreaming.kinemaster.kmpackage.b r0 = r0.c(r1)
            if (r0 == 0) goto L7
            boolean r1 = r0 instanceof com.nexstreaming.kinemaster.kmpackage.a
            if (r1 == 0) goto L3b
            boolean[] r1 = r10.o
            if (r1 == 0) goto L3b
            boolean[] r1 = r10.o
            r1[r2] = r3
        L3b:
            java.util.List r6 = r0.e()
            r10.m = r4
            r10.n = r4
            int r7 = r6.size()
            r5 = r2
        L48:
            if (r5 >= r7) goto L7
            java.lang.Object r0 = r6.get(r5)
            com.nexstreaming.kinemaster.kmpackage.au r0 = (com.nexstreaming.kinemaster.kmpackage.au) r0
            com.nexstreaming.kinemaster.kmpackage.UserFieldType r1 = com.nexstreaming.kinemaster.kmpackage.UserFieldType.undefined
            int r4 = r5 + 1
            if (r4 >= r7) goto Lad
            int r1 = r5 + 1
            java.lang.Object r1 = r6.get(r1)
            com.nexstreaming.kinemaster.kmpackage.au r1 = (com.nexstreaming.kinemaster.kmpackage.au) r1
            android.app.Activity r4 = r10.getActivity()
            java.lang.String r4 = r0.a(r4)
            android.app.Activity r8 = r10.getActivity()
            java.lang.String r8 = r1.a(r8)
            com.nexstreaming.kinemaster.kmpackage.UserFieldType r1 = r1.f()
            if (r4 == r8) goto L7c
            if (r4 == 0) goto Lad
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto Lad
        L7c:
            r4 = r1
            r1 = r3
        L7e:
            int[] r8 = com.nexstreaming.kinemaster.ui.b.f.AnonymousClass1.f3691a
            com.nexstreaming.kinemaster.kmpackage.UserFieldType r9 = r0.f()
            int r9 = r9.ordinal()
            r8 = r8[r9]
            switch(r8) {
                case 1: goto L91;
                case 2: goto La5;
                case 3: goto La9;
                default: goto L8d;
            }
        L8d:
            int r0 = r5 + 1
            r5 = r0
            goto L48
        L91:
            java.lang.String r1 = "icontoggle"
            java.lang.String r4 = r0.d()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto La1
            r10.a(r0)
            goto L8d
        La1:
            r10.b(r0)
            goto L8d
        La5:
            r10.a(r0, r4, r1)
            goto L8d
        La9:
            r10.c(r0)
            goto L8d
        Lad:
            r4 = r1
            r1 = r2
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.b.f.e():void");
    }

    public static String a(String str) {
        char charAt;
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (55296 <= charAt2 && charAt2 <= 56319) {
                i++;
                if (i < length && 56320 <= (charAt = str.charAt(i)) && charAt2 <= 65535) {
                    stringBuffer.append(charAt2);
                    stringBuffer.append(charAt);
                }
            } else {
                stringBuffer.append(charAt2);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private void a(au auVar, UserFieldType userFieldType, boolean z) {
        String str;
        Font f;
        boolean z2 = z && userFieldType == UserFieldType.color;
        int e = auVar.e();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? 0 : -1, e > 1 ? getResources().getDimensionPixelOffset(R.dimen.effect_textview_height_geeater_than_one) : getResources().getDimensionPixelOffset(R.dimen.effect_textview_height));
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.effect_textview_left_margin);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.effect_textview_right_margin);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.effect_textview_top_margin);
        TextView textView = new TextView(getActivity());
        textView.setTag(auVar.b());
        textView.setBackgroundResource(R.drawable.n2_input_bgbig);
        textView.setTextSize(1, 12.0f);
        getActivity().getWindow().setSoftInputMode(48);
        if (e <= 1) {
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        }
        String b2 = auVar.b();
        String str2 = this.r.getEffectOptions().get(b2);
        if (str2 == null) {
            str2 = "";
        }
        String a2 = a(str2);
        String a3 = auVar.a(getActivity());
        Typeface typeface = null;
        int indexOf = a2.indexOf(27);
        if (indexOf > -1) {
            if (this.p != null && (f = this.p.f(a2.substring(0, indexOf))) != null) {
                try {
                    typeface = f.b(getActivity());
                } catch (Font.TypefaceLoadException e2) {
                    Log.e("EffectSettingsFragment", "Failed to get typeface for : " + f.m(), e2);
                }
            }
            str = a2.substring(indexOf + 1);
        } else {
            str = a2;
        }
        if (str == null || str.length() < 1) {
            textView.setTextColor(-6710887);
            textView.setText(a3);
        } else {
            textView.setTextColor(-16777216);
            textView.setText(str);
        }
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        textView.setGravity(16);
        textView.setOnTouchListener(new i(this, auVar, b2, a3, e));
        if (z2) {
            layoutParams.weight = 1.0f;
            this.n = new LinearLayout(getActivity());
            this.n.setOrientation(0);
            this.n.setGravity(16);
            this.n.addView(textView, layoutParams);
            this.l.addView(this.n, new LinearLayout.LayoutParams(-1, -2));
            return;
        }
        this.l.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(String str) {
        if ("textleft".equals(str)) {
            return R.drawable.text_align_left;
        }
        if ("textcenter".equals(str)) {
            return R.drawable.text_align_center;
        }
        if ("textright".equals(str)) {
            return R.drawable.text_align_right;
        }
        return 0;
    }

    private void a(au auVar) {
        String b2 = auVar.b();
        ImageButton imageButton = new ImageButton(getActivity());
        imageButton.setBackgroundResource(R.drawable.btn_effect_option);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.effect_icon_toggle_padding);
        imageButton.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        if (this.r.getEffectOptions().get(b2) == null) {
            auVar.c();
        }
        List<au.a> g = auVar.g();
        int[] iArr = {0};
        String str = this.r.getEffectOptions().get(b2);
        String c2 = (str == null || str.trim().length() < 1) ? auVar.c() : str;
        for (au.a aVar : g) {
            if (aVar.a().equals(c2)) {
                iArr[0] = g.indexOf(aVar);
            }
        }
        imageButton.setImageResource(d(g.get(iArr[0]).b()));
        imageButton.setOnClickListener(new k(this, b2, auVar, iArr, g, imageButton));
        if (this.n != null) {
            this.n.addView(imageButton);
            this.n = null;
            return;
        }
        if (this.m == null || this.m.getChildCount() >= 3) {
            this.m = new LinearLayout(getActivity());
            this.m.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.effect_icon_toggle_margin);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.effect_icon_toggle_margin);
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.effect_icon_toggle_margin);
            layoutParams.gravity = 1;
            this.l.addView(this.m, layoutParams);
        }
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.m.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        linearLayout.addView(imageButton, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        layoutParams4.leftMargin = getResources().getDimensionPixelOffset(R.dimen.effect_icon_toggle_margin);
        layoutParams4.rightMargin = getResources().getDimensionPixelOffset(R.dimen.effect_icon_toggle_margin);
        TextView textView = new TextView(getActivity());
        textView.setText(auVar.a(getActivity()));
        textView.setTextSize(1, EditorGlobal.b(getResources()) ? 18.0f : 10.0f);
        textView.setGravity(1);
        linearLayout.addView(textView, layoutParams4);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.q = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.k = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.l = null;
        super.onDestroyView();
    }

    private void b(au auVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.effect_selection_margin);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.effect_selection_margin);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.effect_selection_margin);
        Spinner spinner = new Spinner(getActivity());
        List<au.a> g = auVar.g();
        ArrayList arrayList = new ArrayList();
        String b2 = auVar.b();
        int i = 0;
        String str = this.r.getEffectOptions().get(b2);
        String c2 = (str == null || str.trim().length() < 1) ? auVar.c() : str;
        for (au.a aVar : g) {
            if (aVar.a().equals(c2)) {
                i = g.indexOf(aVar);
            }
            arrayList.add(aVar.a(getActivity()));
        }
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(getActivity(), R.layout.n2_2_spinneritem, arrayList));
        spinner.setSelection(i);
        spinner.setPopupBackgroundResource(R.drawable.spinner_popup_background);
        spinner.setOnItemSelectedListener(new l(this, b2, g));
        this.l.addView(spinner, layoutParams);
    }

    private void c(au auVar) {
        String b2 = auVar.b();
        ColorPickerView colorPickerView = new ColorPickerView(getActivity());
        colorPickerView.setBackgroundResource(R.drawable.n2_colorsel);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.effect_color_padding);
        colorPickerView.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        colorPickerView.setAllowFineAdjustment(true);
        String str = this.r.getEffectOptions().get(b2);
        if (str == null) {
            str = auVar.c();
        }
        colorPickerView.setSelectedColor(com.nexstreaming.app.general.util.c.a(str) | (-16777216));
        colorPickerView.setOnClickListener(new m(this, colorPickerView));
        colorPickerView.setListener(new n(this, b2));
        if (this.n != null) {
            this.n.addView(colorPickerView);
            this.n = null;
            return;
        }
        if (this.m == null || this.m.getChildCount() >= 3) {
            this.m = new LinearLayout(getActivity());
            this.m.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.effect_color_margin);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.effect_color_margin);
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.effect_color_margin);
            layoutParams.gravity = 1;
            this.l.addView(this.m, layoutParams);
        }
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.m.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        linearLayout.addView(colorPickerView, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        layoutParams4.leftMargin = getResources().getDimensionPixelOffset(R.dimen.effect_color_margin);
        layoutParams4.rightMargin = getResources().getDimensionPixelOffset(R.dimen.effect_color_margin);
        TextView textView = new TextView(getActivity());
        textView.setText(auVar.a(getActivity()));
        textView.setTextSize(1, EditorGlobal.b(getResources()) ? 18.0f : 10.0f);
        textView.setGravity(1);
        linearLayout.addView(textView, layoutParams4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (m() != null) {
            this.r = h();
            this.p = EffectLibrary.a(getActivity());
            this.j = null;
            if (this.r != null && this.p != null) {
                a(this.p.c(this.r.getEffectID()));
            }
            if (j() != null) {
                float durationLimit = 30000 < j().getDurationLimit() ? 30.0f : j().getDurationLimit() / 1000.0f;
                this.k.setScrollMaxValue(durationLimit);
                this.k.setMaxValue(durationLimit);
                this.k.a(this.r.getEffectDuration() / 1000.0f, false);
            }
            if (i()) {
                a(R.id.action_undo, 0, R.id.action_redo, 0);
            }
        }
    }
}
