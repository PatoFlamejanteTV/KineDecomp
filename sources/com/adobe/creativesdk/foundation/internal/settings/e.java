package com.adobe.creativesdk.foundation.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.a.a.b.g;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import java.util.List;

/* compiled from: CloudPickerActivity.java */
/* loaded from: classes.dex */
class e extends ArrayAdapter<AdobeCloud> implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f5206a;

    /* renamed from: b, reason: collision with root package name */
    private List<AdobeCloud> f5207b;

    /* compiled from: CloudPickerActivity.java */
    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f5208a;

        /* renamed from: b, reason: collision with root package name */
        private AdapterView<?> f5209b;

        /* renamed from: c, reason: collision with root package name */
        private View f5210c;

        a(AdapterView<?> adapterView, View view, int i) {
            this.f5208a = i;
            this.f5209b = adapterView;
            this.f5210c = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((CloudPickerActivity) e.this.f5206a).onItemClick(this.f5209b, this.f5210c, this.f5208a, 0L);
        }
    }

    /* compiled from: CloudPickerActivity.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private TextView f5212a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f5213b;

        /* renamed from: c, reason: collision with root package name */
        private ImageView f5214c;

        b(View view) {
            a((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_cloud_name));
            b((ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_cloud_icon_image));
            a((ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_Default_Cloud_selector));
        }

        TextView a() {
            return this.f5212a;
        }

        void b(ImageView imageView) {
            this.f5213b = imageView;
        }

        ImageView c() {
            return this.f5213b;
        }

        void a(TextView textView) {
            this.f5212a = textView;
        }

        public ImageView b() {
            return this.f5214c;
        }

        public void a(ImageView imageView) {
            this.f5214c = imageView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, List<AdobeCloud> list) {
        super(context, 0, list);
        this.f5206a = context;
        this.f5207b = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f5207b.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = ((LayoutInflater) this.f5206a.getSystemService("layout_inflater")).inflate(g.cloud_tab_item, (ViewGroup) null);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.f5207b.isEmpty()) {
            bVar.b().setVisibility(4);
            bVar.c().setVisibility(4);
        } else {
            bVar.b().setColorFilter(c.a.a.a.b.b.adobe_csdk_asset_ux_settings_secondary);
            AdobeCloud adobeCloud = this.f5207b.get(i);
            bVar.a().setText(adobeCloud.getName());
            if (!adobeCloud.isPrivateCloud()) {
                bVar.c().setImageResource(c.a.a.a.b.d.ic_cc_24);
            } else {
                bVar.c().setImageResource(c.a.a.a.b.d.ic_cc_private_24);
                if (adobeCloud.getLogoURL() != null) {
                    new f(bVar.c()).execute(adobeCloud.getLogoURL().toString());
                }
            }
            bVar.b().setVisibility(4);
            if (adobeCloud.equals(com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c()) && ((CloudPickerActivity) this.f5206a).f5200h) {
                bVar.b().setVisibility(0);
                ((CloudPickerActivity) this.f5206a).a(Integer.valueOf(i));
                bVar.b().setOnClickListener(new a((AdapterView) viewGroup, view, i));
            }
            view.setOnClickListener(new a((AdapterView) viewGroup, view, i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
