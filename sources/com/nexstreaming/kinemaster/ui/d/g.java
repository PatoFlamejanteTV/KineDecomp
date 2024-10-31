package com.nexstreaming.kinemaster.ui.d;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;
import kotlin.TypeCastException;

/* compiled from: OptionGroupAdapter.kt */
/* loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* renamed from: a */
    private int f21546a;

    /* renamed from: b */
    private final Context f21547b;

    /* renamed from: c */
    private List<? extends n> f21548c;

    /* compiled from: OptionGroupAdapter.kt */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a */
        private TextView f21549a;

        /* renamed from: b */
        private ImageView f21550b;

        /* renamed from: c */
        private View f21551c;

        /* renamed from: d */
        private ImageView f21552d;

        public final void a(TextView textView) {
            this.f21549a = textView;
        }

        public final TextView b() {
            return this.f21549a;
        }

        public final ImageView c() {
            return this.f21552d;
        }

        public final View d() {
            return this.f21551c;
        }

        public final ImageView a() {
            return this.f21550b;
        }

        public final void b(ImageView imageView) {
            this.f21552d = imageView;
        }

        public final void a(ImageView imageView) {
            this.f21550b = imageView;
        }

        public final void a(View view) {
            this.f21551c = view;
        }
    }

    public g(Context context, List<? extends n> list) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        this.f21547b = context;
        this.f21548c = list;
        this.f21546a = -1;
    }

    public final int a() {
        return this.f21546a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends n> list = this.f21548c;
        if (list != null) {
            return list.size();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<? extends n> list = this.f21548c;
        if (list != null) {
            return list.get(i);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        kotlin.jvm.internal.h.b(viewGroup, "parent");
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_group_item, viewGroup, false);
            aVar = new a();
            aVar.a((TextView) view.findViewById(R.id.group_title));
            aVar.a((ImageView) view.findViewById(R.id.group_main_icon));
            aVar.a(view.findViewById(R.id.selectView));
            aVar.b((ImageView) view.findViewById(R.id.free_icon));
            kotlin.jvm.internal.h.a((Object) view, "holderView");
            view.setTag(aVar);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.optiongroup.OptionGroupAdapter.GroupViewHolder");
            }
            aVar = (a) tag;
        }
        List<? extends n> list = this.f21548c;
        if (list != null) {
            n nVar = list.get(i);
            TextView b2 = aVar.b();
            if (b2 != null) {
                b2.setText(nVar.getTitle());
            }
            if (nVar.c() == null) {
                if (nVar.b() == 0) {
                    ImageView a2 = aVar.a();
                    if (a2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    a2.setVisibility(4);
                } else {
                    ImageView a3 = aVar.a();
                    if (a3 != null) {
                        a3.setImageResource(nVar.b());
                        ImageView a4 = aVar.a();
                        if (a4 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        a4.setVisibility(0);
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            } else {
                ImageView a5 = aVar.a();
                if (a5 != null) {
                    a5.setImageBitmap(nVar.c());
                    ImageView a6 = aVar.a();
                    if (a6 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    a6.setVisibility(0);
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            if (nVar.d()) {
                ImageView c2 = aVar.c();
                if (c2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                c2.setVisibility(4);
            } else {
                ImageView c3 = aVar.c();
                if (c3 != null) {
                    c3.setVisibility(0);
                    ImageView c4 = aVar.c();
                    if (c4 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    c4.setBackgroundResource(R.drawable.premium_03);
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            if (this.f21546a == i) {
                View d2 = aVar.d();
                if (d2 != null) {
                    d2.setVisibility(0);
                }
                TextView b3 = aVar.b();
                if (b3 != null) {
                    b3.setTextColor(ContextCompat.getColor(viewGroup.getContext(), R.color.optmenu_item_text_color_press));
                }
            } else {
                View d3 = aVar.d();
                if (d3 != null) {
                    d3.setVisibility(8);
                }
                TextView b4 = aVar.b();
                if (b4 != null) {
                    b4.setTextColor(ContextCompat.getColor(viewGroup.getContext(), R.color.optmenu_item_text_color_normal));
                }
            }
            TextView b5 = aVar.b();
            if (b5 != null) {
                b5.setMaxLines(1);
            }
            TextView b6 = aVar.b();
            if (b6 != null) {
                b6.setTextSize(1, 13.0f);
            }
            TextView b7 = aVar.b();
            if (b7 != null) {
                TextViewCompat.setAutoSizeTextTypeWithDefaults(b7, 1);
                TextView b8 = aVar.b();
                if (b8 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                Context context = viewGroup.getContext();
                kotlin.jvm.internal.h.a((Object) context, "parent.context");
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.pedit_option_menu_list_item_asset_name_min_text_size);
                Context context2 = viewGroup.getContext();
                kotlin.jvm.internal.h.a((Object) context2, "parent.context");
                int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.pedit_option_menu_list_item_asset_name_max_text_size);
                Context context3 = viewGroup.getContext();
                kotlin.jvm.internal.h.a((Object) context3, "parent.context");
                TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(b8, dimensionPixelSize, dimensionPixelSize2, context3.getResources().getDimensionPixelSize(R.dimen.pedit_option_menu_list_item_asset_name_granularity), 0);
                return view;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public final void a(int i) {
        this.f21546a = i;
        notifyDataSetInvalidated();
    }
}
