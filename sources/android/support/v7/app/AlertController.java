package android.support.v7.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a */
    private final Context f2098a;

    /* renamed from: b */
    final AppCompatDialog f2099b;

    /* renamed from: c */
    private final Window f2100c;

    /* renamed from: d */
    private final int f2101d;

    /* renamed from: e */
    private CharSequence f2102e;

    /* renamed from: f */
    private CharSequence f2103f;

    /* renamed from: g */
    ListView f2104g;

    /* renamed from: h */
    private View f2105h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    private boolean n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: android.support.v7.app.AlertController.1
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message3 = alertController.q) != null) {
                obtain = Message.obtain(message3);
            } else {
                AlertController alertController2 = AlertController.this;
                if (view == alertController2.s && (message2 = alertController2.u) != null) {
                    obtain = Message.obtain(message2);
                } else {
                    AlertController alertController3 = AlertController.this;
                    obtain = (view != alertController3.w || (message = alertController3.y) == null) ? null : Message.obtain(message);
                }
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController4 = AlertController.this;
            alertController4.R.obtainMessage(1, alertController4.f2099b).sendToTarget();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.app.AlertController$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message3 = alertController.q) != null) {
                obtain = Message.obtain(message3);
            } else {
                AlertController alertController2 = AlertController.this;
                if (view == alertController2.s && (message2 = alertController2.u) != null) {
                    obtain = Message.obtain(message2);
                } else {
                    AlertController alertController3 = AlertController.this;
                    obtain = (view != alertController3.w || (message = alertController3.y) == null) ? null : Message.obtain(message);
                }
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController4 = AlertController.this;
            alertController4.R.obtainMessage(1, alertController4.f2099b).sendToTarget();
        }
    }

    /* renamed from: android.support.v7.app.AlertController$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f2107a;

        /* renamed from: b */
        final /* synthetic */ View f2108b;

        AnonymousClass2(View view, View view2) {
            findViewById = view;
            view2 = view2;
        }

        @Override // android.support.v4.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            AlertController.a(nestedScrollView, findViewById, view2);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f2110a;

        /* renamed from: b */
        final /* synthetic */ View f2111b;

        AnonymousClass3(View view, View view2) {
            findViewById = view;
            view2 = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.A, findViewById, view2);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements AbsListView.OnScrollListener {

        /* renamed from: a */
        final /* synthetic */ View f2113a;

        /* renamed from: b */
        final /* synthetic */ View f2114b;

        AnonymousClass4(View view, View view2) {
            findViewById = view;
            view2 = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.a(absListView, findViewById, view2);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: android.support.v7.app.AlertController$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f2116a;

        /* renamed from: b */
        final /* synthetic */ View f2117b;

        AnonymousClass5(View view, View view2) {
            findViewById = view;
            view2 = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.f2104g, findViewById, view2);
        }
    }

    /* loaded from: classes.dex */
    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean mCancelable = true;

        /* renamed from: android.support.v7.app.AlertController$AlertParams$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends ArrayAdapter<CharSequence> {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f2119a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                recycleListView = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null && zArr[i]) {
                    recycleListView.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.AlertController$AlertParams$2 */
        /* loaded from: classes.dex */
        public class AnonymousClass2 extends CursorAdapter {

            /* renamed from: a */
            private final int f2121a;

            /* renamed from: b */
            private final int f2122b;

            /* renamed from: c */
            final /* synthetic */ RecycleListView f2123c;

            /* renamed from: d */
            final /* synthetic */ AlertController f2124d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                recycleListView = recycleListView;
                alertController = alertController;
                Cursor cursor2 = getCursor();
                this.f2121a = cursor2.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                this.f2122b = cursor2.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f2121a));
                recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2122b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return AlertParams.this.mInflater.inflate(alertController.M, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.AlertController$AlertParams$3 */
        /* loaded from: classes.dex */
        public class AnonymousClass3 implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ AlertController f2126a;

            AnonymousClass3(AlertController alertController) {
                alertController = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlertParams.this.mOnClickListener.onClick(alertController.f2099b, i);
                if (AlertParams.this.mIsSingleChoice) {
                    return;
                }
                alertController.f2099b.dismiss();
            }
        }

        /* renamed from: android.support.v7.app.AlertController$AlertParams$4 */
        /* loaded from: classes.dex */
        public class AnonymousClass4 implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f2128a;

            /* renamed from: b */
            final /* synthetic */ AlertController f2129b;

            AnonymousClass4(RecycleListView recycleListView, AlertController alertController) {
                recycleListView = recycleListView;
                alertController = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null) {
                    zArr[i] = recycleListView.isItemChecked(i);
                }
                AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f2099b, i, recycleListView.isItemChecked(i));
            }
        }

        /* loaded from: classes.dex */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void a(AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.L, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                Cursor cursor = this.mCursor;
                if (cursor == null) {
                    listAdapter = new ArrayAdapter<CharSequence>(this.mContext, alertController.M, R.id.text1, this.mItems) { // from class: android.support.v7.app.AlertController.AlertParams.1

                        /* renamed from: a */
                        final /* synthetic */ RecycleListView f2119a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Context context, int i2, int i22, CharSequence[] charSequenceArr, RecycleListView recycleListView2) {
                            super(context, i2, i22, charSequenceArr);
                            recycleListView = recycleListView2;
                        }

                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i2, view, viewGroup);
                            boolean[] zArr = AlertParams.this.mCheckedItems;
                            if (zArr != null && zArr[i2]) {
                                recycleListView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    listAdapter = new CursorAdapter(this.mContext, cursor, false) { // from class: android.support.v7.app.AlertController.AlertParams.2

                        /* renamed from: a */
                        private final int f2121a;

                        /* renamed from: b */
                        private final int f2122b;

                        /* renamed from: c */
                        final /* synthetic */ RecycleListView f2123c;

                        /* renamed from: d */
                        final /* synthetic */ AlertController f2124d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(Context context, Cursor cursor2, boolean z, RecycleListView recycleListView2, AlertController alertController2) {
                            super(context, cursor2, z);
                            recycleListView = recycleListView2;
                            alertController = alertController2;
                            Cursor cursor22 = getCursor();
                            this.f2121a = cursor22.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                            this.f2122b = cursor22.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor2) {
                            ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor2.getString(this.f2121a));
                            recycleListView.setItemChecked(cursor2.getPosition(), cursor2.getInt(this.f2122b) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor2, ViewGroup viewGroup) {
                            return AlertParams.this.mInflater.inflate(alertController.M, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.mIsSingleChoice) {
                    i = alertController2.N;
                } else {
                    i = alertController2.O;
                }
                int i2 = i;
                Cursor cursor2 = this.mCursor;
                if (cursor2 != null) {
                    listAdapter = new SimpleCursorAdapter(this.mContext, i2, cursor2, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.mAdapter;
                    if (listAdapter == null) {
                        listAdapter = new CheckedItemAdapter(this.mContext, i2, R.id.text1, this.mItems);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView2);
            }
            alertController2.H = listAdapter;
            alertController2.I = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.AlertParams.3

                    /* renamed from: a */
                    final /* synthetic */ AlertController f2126a;

                    AnonymousClass3(AlertController alertController2) {
                        alertController = alertController2;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        AlertParams.this.mOnClickListener.onClick(alertController.f2099b, i3);
                        if (AlertParams.this.mIsSingleChoice) {
                            return;
                        }
                        alertController.f2099b.dismiss();
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.AlertParams.4

                    /* renamed from: a */
                    final /* synthetic */ RecycleListView f2128a;

                    /* renamed from: b */
                    final /* synthetic */ AlertController f2129b;

                    AnonymousClass4(RecycleListView recycleListView2, AlertController alertController2) {
                        recycleListView = recycleListView2;
                        alertController = alertController2;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null) {
                            zArr[i3] = recycleListView.isItemChecked(i3);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f2099b, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView2.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                recycleListView2.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView2.setChoiceMode(2);
            }
            alertController2.f2104g = recycleListView2;
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i = this.mIconId;
                if (i != 0) {
                    alertController.setIcon(i);
                }
                int i2 = this.mIconAttrId;
                if (i2 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i2));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            if (this.mPositiveButtonText != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            if (this.mNegativeButtonText != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            if (this.mNeutralButtonText != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                a(alertController);
            }
            View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                } else {
                    alertController.setView(view2);
                    return;
                }
            }
            int i3 = this.mViewLayoutResId;
            if (i3 != 0) {
                alertController.setView(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ButtonHandler extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f2131a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f2131a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2131a.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f2132a;

        /* renamed from: b */
        private final int f2133b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f2132a, getPaddingRight(), z2 ? getPaddingBottom() : this.f2133b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.RecycleListView);
            this.f2133b = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f2132a = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f2098a = context;
        this.f2099b = appCompatDialog;
        this.f2100c = window;
        this.R = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.AlertDialog, android.support.v7.appcompat.R.attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.f2101d = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f2100c.findViewById(android.support.v7.appcompat.R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(android.support.v7.appcompat.R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(android.support.v7.appcompat.R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(android.support.v7.appcompat.R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(android.support.v7.appcompat.R.id.customPanel);
        c(viewGroup);
        View findViewById7 = viewGroup.findViewById(android.support.v7.appcompat.R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(android.support.v7.appcompat.R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(android.support.v7.appcompat.R.id.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        b(a3);
        a(a4);
        d(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(android.support.v7.appcompat.R.id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f2103f == null && this.f2104g == null) ? null : a2.findViewById(android.support.v7.appcompat.R.id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(android.support.v7.appcompat.R.id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f2104g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view = this.f2104g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                a(a3, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f2104g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.I;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }

    private void c(ViewGroup viewGroup) {
        View view = this.f2105h;
        if (view == null) {
            view = this.i != 0 ? LayoutInflater.from(this.f2098a).inflate(this.i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.f2100c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f2100c.findViewById(android.support.v7.appcompat.R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.f2104g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void d(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f2100c.findViewById(android.support.v7.appcompat.R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f2100c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.f2102e)) && this.P) {
            this.E = (TextView) this.f2100c.findViewById(android.support.v7.appcompat.R.id.alertTitle);
            this.E.setText(this.f2102e);
            int i = this.B;
            if (i != 0) {
                this.D.setImageResource(i);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            } else {
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        this.f2100c.findViewById(android.support.v7.appcompat.R.id.title_template).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public Button getButton(int i) {
        if (i == -3) {
            return this.w;
        }
        if (i == -2) {
            return this.s;
        }
        if (i != -1) {
            return null;
        }
        return this.o;
    }

    public int getIconAttributeResId(int i) {
        TypedValue typedValue = new TypedValue();
        this.f2098a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.f2104g;
    }

    public void installContent() {
        this.f2099b.setContentView(a());
        b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i == -1) {
                this.p = charSequence;
                this.q = message;
                this.r = drawable;
                return;
            }
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setButtonPanelLayoutHint(int i) {
        this.Q = i;
    }

    public void setCustomTitle(View view) {
        this.G = view;
    }

    public void setIcon(int i) {
        this.C = null;
        this.B = i;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.f2103f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f2102e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i) {
        this.f2105h = null;
        this.i = i;
        this.n = false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void setView(View view) {
        this.f2105h = view;
        this.i = 0;
        this.n = false;
    }

    public void setIcon(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.f2105h = view;
        this.i = 0;
        this.n = true;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    private int a() {
        int i = this.K;
        if (i == 0) {
            return this.J;
        }
        return this.Q == 1 ? i : this.J;
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.f2100c.findViewById(android.support.v7.appcompat.R.id.scrollIndicatorUp);
        View findViewById2 = this.f2100c.findViewById(android.support.v7.appcompat.R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById == null && view2 == null) {
            return;
        }
        if (this.f2103f != null) {
            this.A.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: android.support.v7.app.AlertController.2

                /* renamed from: a */
                final /* synthetic */ View f2107a;

                /* renamed from: b */
                final /* synthetic */ View f2108b;

                AnonymousClass2(View findViewById3, View view22) {
                    findViewById = findViewById3;
                    view2 = view22;
                }

                @Override // android.support.v4.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView, int i3, int i22, int i32, int i4) {
                    AlertController.a(nestedScrollView, findViewById, view2);
                }
            });
            this.A.post(new Runnable() { // from class: android.support.v7.app.AlertController.3

                /* renamed from: a */
                final /* synthetic */ View f2110a;

                /* renamed from: b */
                final /* synthetic */ View f2111b;

                AnonymousClass3(View findViewById3, View view22) {
                    findViewById = findViewById3;
                    view2 = view22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.A, findViewById, view2);
                }
            });
            return;
        }
        ListView listView = this.f2104g;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.app.AlertController.4

                /* renamed from: a */
                final /* synthetic */ View f2113a;

                /* renamed from: b */
                final /* synthetic */ View f2114b;

                AnonymousClass4(View findViewById3, View view22) {
                    findViewById = findViewById3;
                    view2 = view22;
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i3, int i22, int i32) {
                    AlertController.a(absListView, findViewById, view2);
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i3) {
                }
            });
            this.f2104g.post(new Runnable() { // from class: android.support.v7.app.AlertController.5

                /* renamed from: a */
                final /* synthetic */ View f2116a;

                /* renamed from: b */
                final /* synthetic */ View f2117b;

                AnonymousClass5(View findViewById3, View view22) {
                    findViewById = findViewById3;
                    view2 = view22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.f2104g, findViewById, view2);
                }
            });
            return;
        }
        if (findViewById3 != null) {
            viewGroup.removeView(findViewById3);
        }
        if (view22 != null) {
            viewGroup.removeView(view22);
        }
    }

    private void b(ViewGroup viewGroup) {
        this.A = (NestedScrollView) this.f2100c.findViewById(android.support.v7.appcompat.R.id.scrollView);
        this.A.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        this.F = (TextView) viewGroup.findViewById(R.id.message);
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f2103f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f2104g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f2104g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void a(ViewGroup viewGroup) {
        int i;
        this.o = (Button) viewGroup.findViewById(R.id.button1);
        this.o.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            i = 0;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f2101d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            i = 1;
        }
        this.s = (Button) viewGroup.findViewById(R.id.button2);
        this.s.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f2101d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            i |= 2;
        }
        this.w = (Button) viewGroup.findViewById(R.id.button3);
        this.w.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                int i4 = this.f2101d;
                drawable3.setBounds(0, 0, i4, i4);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.w.setVisibility(0);
            i |= 4;
        }
        if (a(this.f2098a)) {
            if (i == 1) {
                a(this.o);
            } else if (i == 2) {
                a(this.s);
            } else if (i == 4) {
                a(this.w);
            }
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
