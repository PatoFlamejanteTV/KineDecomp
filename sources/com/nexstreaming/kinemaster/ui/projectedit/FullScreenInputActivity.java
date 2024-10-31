package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditText;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class FullScreenInputActivity extends AppCompatActivity {

    /* renamed from: a */
    protected NexEditText f21853a;

    /* renamed from: b */
    protected InputMethodManager f21854b;

    /* renamed from: c */
    protected Handler f21855c = new Handler();

    /* renamed from: d */
    private String f21856d;

    /* renamed from: e */
    private String f21857e;

    /* renamed from: f */
    private boolean f21858f;

    /* renamed from: g */
    private boolean f21859g;

    /* renamed from: h */
    private String f21860h;
    private boolean i;
    private boolean j;
    private Toast k;

    /* loaded from: classes2.dex */
    public static class a {
        private Context k;

        /* renamed from: a */
        private boolean f21861a = false;

        /* renamed from: b */
        private boolean f21862b = false;

        /* renamed from: c */
        private String f21863c = null;

        /* renamed from: d */
        private String f21864d = null;

        /* renamed from: e */
        private String f21865e = null;

        /* renamed from: f */
        private String f21866f = null;

        /* renamed from: g */
        private String f21867g = null;

        /* renamed from: h */
        private String f21868h = null;
        private boolean i = false;
        private boolean j = false;
        private boolean l = false;
        private boolean m = false;

        a(Context context) {
            this.k = context;
        }

        public a a(int i) {
            this.f21865e = this.k.getResources().getString(i);
            return this;
        }

        public a b(String str) {
            this.f21866f = str;
            return this;
        }

        public a c(boolean z) {
            this.f21861a = z;
            return this;
        }

        public a d(boolean z) {
            this.i = z;
            return this;
        }

        public a e(boolean z) {
            this.j = z;
            return this;
        }

        public a f(boolean z) {
            this.m = z;
            return this;
        }

        public a a(String str) {
            this.f21867g = str;
            return this;
        }

        public a b(boolean z) {
            this.f21862b = z;
            return this;
        }

        public a a(boolean z) {
            this.l = z;
            return this;
        }

        public Intent a() {
            Intent intent = new Intent(this.k, (Class<?>) FullScreenInputActivity.class);
            intent.putExtra("multiline", this.f21861a);
            String str = this.f21863c;
            if (str == null) {
                str = this.k.getString(R.string.button_ok);
            }
            intent.putExtra("positiveLabel", str);
            String str2 = this.f21864d;
            if (str2 == null) {
                str2 = this.k.getString(R.string.button_cancel);
            }
            intent.putExtra("negativeLabel", str2);
            String str3 = this.f21865e;
            if (str3 == null) {
                str3 = "";
            }
            intent.putExtra("hint", str3);
            String str4 = this.f21866f;
            if (str4 == null) {
                str4 = "";
            }
            intent.putExtra("text", str4);
            intent.putExtra("showFontButton", this.j);
            if (this.j) {
                Context context = this.k;
                if ((context instanceof ProjectEditActivity) && ((ProjectEditActivity) context).ja() != null && ((ProjectEditActivity) this.k).ja().t() != null) {
                    intent.putExtra("SELECTED_PROJECT", ((ProjectEditActivity) this.k).ja().t().getPath());
                }
            }
            String str5 = this.f21867g;
            if (str5 == null) {
                str5 = "";
            }
            intent.putExtra("fontId", str5);
            String str6 = this.f21868h;
            if (str6 == null) {
                str6 = "";
            }
            intent.putExtra("effectId", str6);
            intent.putExtra("promocode", this.f21862b);
            intent.putExtra("isProjectName", this.i);
            intent.putExtra("cancelIfPreviousValue", this.l);
            intent.putExtra("textDrag", this.m);
            return intent;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements InputFilter {
        private static char a(char c2) {
            if (c2 >= 'a' && c2 <= 'z') {
                return (char) (c2 - ' ');
            }
            if ((c2 < 'A' || c2 > 'Z') && (c2 < '0' || c2 > '9')) {
                return (char) 0;
            }
            return c2;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            SpannableStringBuilder spannableStringBuilder = null;
            int i5 = 0;
            for (int i6 = i; i6 < i2; i6++) {
                char charAt = charSequence.charAt(i6);
                char a2 = a(charAt);
                if (charAt == a2) {
                    i5++;
                } else {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder(charSequence, i, i2);
                        i5 = i6 - i;
                    }
                    if (a2 == 0) {
                        spannableStringBuilder.delete(i5, i5 + 1);
                    } else {
                        spannableStringBuilder.replace(i5, i5 + 1, (CharSequence) ("" + a2));
                    }
                }
            }
            return spannableStringBuilder;
        }
    }

    public static int s() {
        return 8217;
    }

    public static int t() {
        return 8224;
    }

    public void u() {
        File file;
        String str;
        String obj = this.f21853a.getText().toString();
        if (this.f21859g) {
            obj = obj.trim();
            if (obj.length() < 1) {
                b(R.string.project_rename_fail_blank);
                return;
            }
            if (this.i && (str = this.f21860h) != null && obj.equals(str.trim())) {
                this.f21854b.hideSoftInputFromWindow(this.f21853a.getWindowToken(), 0, null);
                setResult(0);
                finish();
                return;
            } else {
                if (com.nexstreaming.kinemaster.project.k.g(obj).getAbsolutePath().getBytes().length > 200) {
                    b(R.string.project_rename_fail_too_long);
                    return;
                }
                file = com.nexstreaming.kinemaster.project.k.g(obj);
                if (com.nexstreaming.kinemaster.project.k.f(obj) || file.exists()) {
                    b(R.string.project_rename_fail_name_conflict);
                    return;
                }
            }
        } else {
            file = null;
        }
        this.f21854b.hideSoftInputFromWindow(this.f21853a.getWindowToken(), 0, null);
        Intent intent = new Intent();
        intent.putExtra("fontId", this.f21857e);
        if (file != null) {
            intent.putExtra("path", file);
        }
        intent.putExtra("text", obj);
        setResult(1, intent);
        finish();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Typeface typeface;
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            String str = this.f21857e;
            AssetPackageReader assetPackageReader = null;
            r2 = null;
            r2 = null;
            r2 = null;
            Typeface typeface2 = null;
            assetPackageReader = null;
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selected_font_id");
                com.nexstreaming.app.general.nexasset.assetpackage.r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(stringExtra);
                if (a2 != null) {
                    try {
                        try {
                            AssetPackageReader a3 = AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), a2.getPackageURI(), a2.getAssetPackage().getAssetId());
                            try {
                                typeface2 = a3.f(a2.getFilePath());
                                this.f21857e = stringExtra;
                                C1702f.a(a3);
                            } catch (IOException e2) {
                                e = e2;
                                typeface = typeface2;
                                assetPackageReader = a3;
                                Log.e("NexFullScnInputActivity", "typeface error; revert", e);
                                C1702f.a(assetPackageReader);
                                typeface2 = typeface;
                                this.f21853a.setTypeface(typeface2);
                                this.f21855c.postDelayed(new Ka(this), 100L);
                            } catch (Throwable th) {
                                th = th;
                                assetPackageReader = a3;
                                C1702f.a(assetPackageReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        typeface = null;
                    }
                } else {
                    typeface = com.nexstreaming.kinemaster.fonts.d.b().a(stringExtra);
                    if (typeface != null) {
                        this.f21857e = stringExtra;
                    } else {
                        Log.e("NexFullScnInputActivity", "typeface error (OK); revert");
                        this.f21853a.setTypeface(null);
                        this.f21857e = null;
                    }
                }
                typeface2 = typeface;
            } else if (i2 != 0) {
                if (i2 == 1) {
                    this.f21853a.setTypeface(null);
                    this.f21857e = null;
                }
            } else if (str != null && com.nexstreaming.kinemaster.fonts.d.b().a(str) != null) {
                Typeface a4 = com.nexstreaming.kinemaster.fonts.d.b().a(this.f21857e);
                if (a4 == null) {
                    Log.e("NexFullScnInputActivity", "typeface error (cancel); revert");
                    this.f21853a.setTypeface(null);
                    this.f21857e = null;
                }
                typeface2 = a4;
            } else {
                this.f21853a.setTypeface(null);
                this.f21857e = null;
            }
            this.f21853a.setTypeface(typeface2);
        }
        this.f21855c.postDelayed(new Ka(this), 100L);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Typeface a2;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.fullscreeninput);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.alpha(100)));
        getWindow().setLayout(-1, -1);
        this.f21854b = (InputMethodManager) getSystemService("input_method");
        this.f21853a = (NexEditText) findViewById(R.id.textinput);
        if (NexEditorDeviceProfile.getDeviceProfile().getLimitTextInputHeight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21853a.getLayoutParams();
            layoutParams.addRule(12, 0);
            this.f21853a.setLayoutParams(layoutParams);
        }
        this.f21853a.setOnBackKeyListener(new Da(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.f21857e = intent.getStringExtra("fontId");
            this.f21856d = intent.getStringExtra("effectId");
            this.f21858f = intent.getBooleanExtra("promocode", false);
            this.f21859g = intent.getBooleanExtra("isProjectName", false);
            this.i = intent.getBooleanExtra("cancelIfPreviousValue", false);
            this.j = intent.getBooleanExtra("textDrag", false);
            this.f21853a.setHint(intent.getStringExtra("hint"));
            this.f21860h = intent.getStringExtra("text");
            this.f21853a.setText(this.f21860h);
            ((Button) findViewById(R.id.button_ok)).setText(intent.getStringExtra("positiveLabel"));
            ((Button) findViewById(R.id.button_cancel)).setText(intent.getStringExtra("negativeLabel"));
            if (this.j) {
                this.f21853a.setSelectAllOnFocus(true);
            }
            if (this.f21858f) {
                this.f21853a.setSingleLine();
                this.f21853a.setInputType(528529);
                this.f21853a.setFilters(new InputFilter[]{new b(), new InputFilter.LengthFilter(16)});
                this.f21853a.setTextSize(1, getResources().getInteger(R.integer.fullscreen_hint_size));
                this.f21853a.setTypeface(Typeface.MONOSPACE);
            }
            if (intent.getBooleanExtra("showFontButton", false)) {
                ImageButton imageButton = (ImageButton) findViewById(R.id.button_font);
                imageButton.setVisibility(0);
                this.f21853a.setPadding(0, 0, getResources().getDimensionPixelOffset(R.dimen.fullscreeninput_font_btn_padding), 0);
                imageButton.setOnClickListener(new Ea(this, intent.getStringExtra("SELECTED_PROJECT")));
                this.f21853a.setNextFocusRightId(R.id.button_font);
                imageButton.setNextFocusRightId(R.id.button_ok);
                findViewById(R.id.button_ok).setNextFocusLeftId(R.id.button_font);
                findViewById(R.id.button_cancel).setNextFocusLeftId(R.id.button_font);
            } else {
                findViewById(R.id.button_font).setVisibility(8);
            }
            if (!intent.getBooleanExtra("multiline", false)) {
                this.f21853a.setSingleLine();
                this.f21853a.setImeOptions(268435462);
            }
        }
        if (bundle != null) {
            this.f21860h = bundle.getString("text");
            this.f21857e = bundle.getString("fontId");
            this.f21853a.setText(this.f21860h);
        }
        if (this.f21857e != null && (a2 = com.nexstreaming.kinemaster.fonts.d.b().a(this.f21857e)) != null) {
            this.f21853a.setTypeface(a2);
        }
        NexEditText nexEditText = this.f21853a;
        if (nexEditText != null || !nexEditText.getText().equals("")) {
            NexEditText nexEditText2 = this.f21853a;
            nexEditText2.setSelection(nexEditText2.length());
        }
        findViewById(R.id.button_ok).setOnClickListener(new Fa(this));
        findViewById(R.id.button_cancel).setOnClickListener(new Ga(this));
        this.f21853a.addTextChangedListener(new Ha(this));
        this.f21853a.setOnEditorActionListener(new Ia(this));
        this.f21855c.postDelayed(new Ja(this), 100L);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Toast toast = this.k;
        if (toast != null) {
            toast.cancel();
            this.k = null;
        }
        this.f21853a = null;
        super.onDestroy();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("text", this.f21853a.getText().toString());
        bundle.putString("fontId", this.f21857e);
        super.onSaveInstanceState(bundle);
    }

    public void b(int i) {
        Toast toast = this.k;
        if (toast != null) {
            toast.cancel();
        }
        this.k = Toast.makeText(this, i, 1);
        this.k.setGravity(49, 0, 0);
        this.k.show();
    }

    public static String c(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        Object obj = extras.get("fontId");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static File d(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        Object obj = extras.get("path");
        if (obj instanceof File) {
            return (File) obj;
        }
        return null;
    }

    public static String e(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        Object obj = extras.get("text");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static a a(Context context) {
        return new a(context);
    }
}
