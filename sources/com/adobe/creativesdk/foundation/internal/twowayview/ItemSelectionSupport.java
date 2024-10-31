package com.adobe.creativesdk.foundation.internal.twowayview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Checkable;

/* loaded from: classes.dex */
public class ItemSelectionSupport {

    /* renamed from: a */
    private final RecyclerView f6805a;

    /* renamed from: b */
    private ChoiceMode f6806b;

    /* renamed from: c */
    private b f6807c;

    /* renamed from: d */
    private a f6808d;

    /* renamed from: e */
    private int f6809e;

    /* loaded from: classes.dex */
    public enum ChoiceMode {
        NONE,
        SINGLE,
        MULTIPLE
    }

    /* loaded from: classes.dex */
    public static class a extends LongSparseArray<Integer> implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new com.adobe.creativesdk.foundation.internal.twowayview.b();

        public /* synthetic */ a(Parcel parcel, com.adobe.creativesdk.foundation.internal.twowayview.a aVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int size = size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(keyAt(i2));
                parcel.writeInt(valueAt(i2).intValue());
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends SparseBooleanArray implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new c();

        public /* synthetic */ b(Parcel parcel, com.adobe.creativesdk.foundation.internal.twowayview.a aVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int size = size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(keyAt(i2));
                parcel.writeInt(valueAt(i2) ? 1 : 0);
            }
        }

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    int readInt2 = parcel.readInt();
                    boolean z = true;
                    if (parcel.readInt() != 1) {
                        z = false;
                    }
                    put(readInt2, z);
                }
            }
        }
    }

    private void d() {
        int childCount = this.f6805a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f6805a.getChildAt(i);
            a(childAt, this.f6807c.get(this.f6805a.getChildPosition(childAt)));
        }
    }

    public boolean a(int i) {
        b bVar;
        if (this.f6806b == ChoiceMode.NONE || (bVar = this.f6807c) == null) {
            return false;
        }
        return bVar.get(i);
    }

    public void b() {
        boolean z;
        RecyclerView.Adapter adapter = this.f6805a.getAdapter();
        if (this.f6806b == ChoiceMode.NONE || adapter == null || !adapter.hasStableIds()) {
            return;
        }
        int itemCount = adapter.getItemCount();
        this.f6807c.clear();
        int i = 0;
        while (i < this.f6808d.size()) {
            long keyAt = this.f6808d.keyAt(i);
            int intValue = this.f6808d.valueAt(i).intValue();
            if (keyAt != adapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, itemCount);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else {
                        if (keyAt == adapter.getItemId(max)) {
                            this.f6807c.put(max, true);
                            this.f6808d.setValueAt(i, Integer.valueOf(max));
                            z = true;
                            break;
                        }
                        max++;
                    }
                }
                if (!z) {
                    this.f6808d.delete(keyAt);
                    this.f6809e--;
                    i--;
                }
            } else {
                this.f6807c.put(intValue, true);
            }
            i++;
        }
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt("choiceMode", this.f6806b.ordinal());
        bundle.putParcelable("checkedStates", this.f6807c);
        bundle.putParcelable("checkedIdStates", this.f6808d);
        bundle.putInt("checkedCount", this.f6809e);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(11)
    public void a(View view, boolean z) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z);
        } else if (Build.VERSION.SDK_INT >= 11) {
            view.setActivated(z);
        }
    }

    public void a() {
        b bVar = this.f6807c;
        if (bVar != null) {
            bVar.clear();
        }
        a aVar = this.f6808d;
        if (aVar != null) {
            aVar.clear();
        }
        this.f6809e = 0;
        d();
    }

    public void a(Bundle bundle) {
        this.f6806b = ChoiceMode.values()[bundle.getInt("choiceMode")];
        this.f6807c = (b) bundle.getParcelable("checkedStates");
        this.f6808d = (a) bundle.getParcelable("checkedIdStates");
        this.f6809e = bundle.getInt("checkedCount");
    }

    public static ItemSelectionSupport a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return null;
        }
        return (ItemSelectionSupport) recyclerView.getTag(c.a.a.a.b.e.adobe_csdk_twowayview_item_selection_support);
    }
}
