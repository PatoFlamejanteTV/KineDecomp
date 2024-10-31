package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: AdobeUploadErrorSummaryFragment.java */
/* loaded from: classes.dex */
public class p extends DialogFragment {

    /* renamed from: a */
    private ListView f6450a;

    /* renamed from: b */
    private ArrayList<AdobeUploadAssetData> f6451b;

    /* compiled from: AdobeUploadErrorSummaryFragment.java */
    /* loaded from: classes.dex */
    public class a extends ArrayAdapter<AdobeUploadAssetData> {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            if (p.this.f6451b == null) {
                return 0;
            }
            return p.this.f6451b.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            ImageView imageView;
            LayoutInflater layoutInflater = p.this.getLayoutInflater(null);
            if (view != null) {
                C0038a c0038a = (C0038a) view.getTag();
                textView = c0038a.f6454b;
                imageView = c0038a.f6453a;
            } else {
                view = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetview_upload_failed_assets_list_item, viewGroup, false);
                textView = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_upload_failed_asset_item_name);
                imageView = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_upload_failed_asset_item_image);
                C0038a c0038a2 = new C0038a();
                c0038a2.f6453a = imageView;
                c0038a2.f6455c = i;
                c0038a2.f6454b = textView;
                view.setTag(c0038a2);
            }
            AdobeUploadAssetData item = getItem(i);
            textView.setText(item.f5273b);
            imageView.setImageBitmap(null);
            v.c().b(item, new o(this, imageView));
            return view;
        }

        /* compiled from: AdobeUploadErrorSummaryFragment.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.upload.p$a$a */
        /* loaded from: classes.dex */
        private class C0038a {

            /* renamed from: a */
            public ImageView f6453a;

            /* renamed from: b */
            public TextView f6454b;

            /* renamed from: c */
            public int f6455c;

            private C0038a() {
                this.f6455c = -1;
            }

            /* synthetic */ C0038a(a aVar, n nVar) {
                this();
            }
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public AdobeUploadAssetData getItem(int i) {
            if (p.this.f6451b == null || i < 0 || i >= p.this.f6451b.size()) {
                return null;
            }
            return (AdobeUploadAssetData) p.this.f6451b.get(i);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetview_upload_error_details_dialog, viewGroup, false);
        float dimension = getResources().getDimension(c.a.a.a.b.c.adobe_csdk_fragment_detail_footer_border_left_radius);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dimension, dimension, dimension, dimension}, null, null));
        shapeDrawable.getPaint().setColor(-1);
        inflate.setBackground(shapeDrawable);
        this.f6450a = (ListView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_upload_error_detials_main_list);
        if (this.f6451b != null && getActivity() != null) {
            this.f6450a.setAdapter((ListAdapter) new a(getActivity(), c.a.a.a.b.g.adobe_assetview_upload_failed_assets_list_item));
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        v.b();
    }

    public void a(ArrayList<AdobeUploadAssetData> arrayList) {
        this.f6451b = arrayList;
    }
}
