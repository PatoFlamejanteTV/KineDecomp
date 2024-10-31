package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class PlusOneDummyView extends FrameLayout {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        private Context f2156a;

        private a(Context context) {
            this.f2156a = context;
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public Drawable a(int i) {
            return this.f2156a.getResources().getDrawable(android.R.drawable.btn_default);
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public boolean a() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private Context f2157a;

        private b(Context context) {
            this.f2157a = context;
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public Drawable a(int i) {
            String str;
            try {
                Resources resources = this.f2157a.createPackageContext("com.google.android.gms", 4).getResources();
                switch (i) {
                    case 0:
                        str = "ic_plusone_small";
                        break;
                    case 1:
                        str = "ic_plusone_medium";
                        break;
                    case 2:
                        str = "ic_plusone_tall";
                        break;
                    default:
                        str = "ic_plusone_standard";
                        break;
                }
                return resources.getDrawable(resources.getIdentifier(str, "drawable", "com.google.android.gms"));
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public boolean a() {
            try {
                this.f2157a.createPackageContext("com.google.android.gms", 4).getResources();
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements d {

        /* renamed from: a, reason: collision with root package name */
        private Context f2158a;

        private c(Context context) {
            this.f2158a = context;
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public Drawable a(int i) {
            String str;
            switch (i) {
                case 0:
                    str = "ic_plusone_small_off_client";
                    break;
                case 1:
                    str = "ic_plusone_medium_off_client";
                    break;
                case 2:
                    str = "ic_plusone_tall_off_client";
                    break;
                default:
                    str = "ic_plusone_standard_off_client";
                    break;
            }
            return this.f2158a.getResources().getDrawable(this.f2158a.getResources().getIdentifier(str, "drawable", this.f2158a.getPackageName()));
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public boolean a() {
            return (this.f2158a.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.f2158a.getPackageName()) == 0 || this.f2158a.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.f2158a.getPackageName()) == 0 || this.f2158a.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.f2158a.getPackageName()) == 0 || this.f2158a.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.f2158a.getPackageName()) == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(int i);

        boolean a();
    }

    public PlusOneDummyView(Context context, int i) {
        super(context);
        Button button = new Button(context);
        button.setEnabled(false);
        button.setBackgroundDrawable(a().a(i));
        Point a2 = a(i);
        addView(button, new FrameLayout.LayoutParams(a2.x, a2.y, 17));
    }

    private Point a(int i) {
        int i2 = 24;
        int i3 = 20;
        Point point = new Point();
        switch (i) {
            case 0:
                i3 = 14;
                break;
            case 1:
                i2 = 32;
                break;
            case 2:
                i2 = 50;
                break;
            default:
                i2 = 38;
                i3 = 24;
                break;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, i2, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, i3, displayMetrics);
        point.x = (int) (applyDimension + 0.5d);
        point.y = (int) (applyDimension2 + 0.5d);
        return point;
    }

    private d a() {
        d bVar = new b(getContext());
        if (!bVar.a()) {
            bVar = new c(getContext());
        }
        return !bVar.a() ? new a(getContext()) : bVar;
    }
}
