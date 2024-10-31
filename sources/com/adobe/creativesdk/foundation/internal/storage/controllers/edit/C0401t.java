package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
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
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.util.List;

/* compiled from: AdobeEditErrorSummaryFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0401t extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private List<AdobeCCFilesEditAssetData> f6073a;

    /* compiled from: AdobeEditErrorSummaryFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.t$a */
    /* loaded from: classes.dex */
    public class a extends ArrayAdapter<AdobeCCFilesEditAssetData> {

        /* compiled from: AdobeEditErrorSummaryFragment.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.t$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0032a {

            /* renamed from: a, reason: collision with root package name */
            private ImageView f6075a;

            /* renamed from: b, reason: collision with root package name */
            private TextView f6076b;

            /* renamed from: c, reason: collision with root package name */
            private int f6077c;

            private C0032a() {
                this.f6077c = -1;
            }

            public ImageView a() {
                return this.f6075a;
            }

            public TextView b() {
                return this.f6076b;
            }

            public void a(ImageView imageView) {
                this.f6075a = imageView;
            }

            public void a(TextView textView) {
                this.f6076b = textView;
            }

            public void a(int i) {
                this.f6077c = i;
            }
        }

        a(Context context, int i) {
            super(context, i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            if (C0401t.this.f6073a == null) {
                return 0;
            }
            return C0401t.this.f6073a.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            ImageView imageView;
            LayoutInflater layoutInflater = C0401t.this.getLayoutInflater(null);
            if (view != null) {
                C0032a c0032a = (C0032a) view.getTag();
                textView = c0032a.b();
                imageView = c0032a.a();
            } else {
                view = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetview_upload_failed_assets_list_item, viewGroup, false);
                textView = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_upload_failed_asset_item_name);
                imageView = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_upload_failed_asset_item_image);
                C0032a c0032a2 = new C0032a();
                c0032a2.a(imageView);
                c0032a2.a(i);
                c0032a2.a(textView);
                view.setTag(c0032a2);
            }
            AdobeCCFilesEditAssetData item = getItem(i);
            if (item != null) {
                textView.setText(item.f6025a);
                if (!item.f6026b) {
                    imageView.setImageResource(c.a.a.a.b.d.collection_folder);
                } else {
                    item.f6027c.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, new C0582ma(30.0f, 30.0f), new C0400s(this, imageView));
                }
            }
            return view;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public AdobeCCFilesEditAssetData getItem(int i) {
            if (C0401t.this.f6073a == null || i < 0 || i >= C0401t.this.f6073a.size()) {
                return null;
            }
            return (AdobeCCFilesEditAssetData) C0401t.this.f6073a.get(i);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetview_edit_error_details_dialog, viewGroup, false);
        float dimension = getResources().getDimension(c.a.a.a.b.c.adobe_csdk_fragment_detail_footer_border_left_radius);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dimension, dimension, dimension, dimension}, null, null));
        shapeDrawable.getPaint().setColor(-1);
        if (Build.VERSION.SDK_INT >= 16) {
            inflate.setBackground(shapeDrawable);
        } else {
            inflate.setBackgroundDrawable(shapeDrawable);
        }
        ListView listView = (ListView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_edit_error_detials_main_list);
        if (this.f6073a != null && getActivity() != null) {
            listView.setAdapter((ListAdapter) new a(getActivity(), c.a.a.a.b.g.adobe_assetview_upload_failed_assets_list_item));
        }
        return inflate;
    }

    public void a(List<AdobeCCFilesEditAssetData> list) {
        this.f6073a = list;
    }
}
