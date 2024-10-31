package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ShareIntentArrayAdapter.java */
/* loaded from: classes2.dex */
public class ua extends BaseAdapter {

    /* renamed from: a */
    private Context f23387a;

    /* renamed from: b */
    private Intent[] f23388b;

    /* compiled from: ShareIntentArrayAdapter.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a */
        ImageView f23389a;

        /* renamed from: b */
        TextView f23390b;

        private a() {
        }

        /* synthetic */ a(ta taVar) {
            this();
        }
    }

    public ua(Context context, Intent[] intentArr) {
        this.f23387a = context;
        this.f23388b = intentArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23388b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Intent[] intentArr = this.f23388b;
        if (intentArr == null || intentArr.length <= i) {
            return null;
        }
        return intentArr[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Intent intent = this.f23388b[i];
        if (view == null) {
            view = LayoutInflater.from(this.f23387a).inflate(R.layout.share_app_grid_item, viewGroup, false);
            aVar = new a();
            aVar.f23389a = (ImageView) view.findViewById(R.id.app_icon);
            aVar.f23390b = (TextView) view.findViewById(R.id.app_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            aVar.f23389a.setImageDrawable(this.f23387a.getPackageManager().getActivityIcon(intent));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        aVar.f23390b.setText(intent.getStringExtra("displayName"));
        return view;
    }
}
