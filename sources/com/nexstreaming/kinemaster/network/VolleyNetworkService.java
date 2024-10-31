package com.nexstreaming.kinemaster.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.crashlytics.android.Crashlytics;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.N;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class VolleyNetworkService implements InterfaceC1820i {

    /* renamed from: a, reason: collision with root package name */
    private static final Gson f21107a = new Gson();

    /* renamed from: b, reason: collision with root package name */
    private C1819h f21108b;

    /* renamed from: c, reason: collision with root package name */
    private String f21109c;

    /* renamed from: e, reason: collision with root package name */
    private String f21111e;
    private int i;
    private Context j;
    private Task l;
    private String o;
    private String p;
    private String q;
    private String r;
    private long s;
    private long t;
    private AssetEnv u;
    private ResultTask<List<InterfaceC1822k>> v;
    private ResultTask<List<InterfaceC1822k>> w;
    private long x;

    /* renamed from: d, reason: collision with root package name */
    private String f21110d = null;

    /* renamed from: f, reason: collision with root package name */
    private String f21112f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f21113g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f21114h = "2.2";
    private Task k = new Task();
    private boolean m = false;
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class StoreCategoryInfoImp implements InterfaceC1822k, Serializable {
        private Map<String, String> categoryName;
        private List<m> subcategoryList;
        private final AssetStoreAPIData$CategoryInfo wrapped;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ StoreCategoryInfoImp(AssetStoreAPIData$CategoryInfo assetStoreAPIData$CategoryInfo, w wVar) {
            this(assetStoreAPIData$CategoryInfo);
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
        public String getCategoryAliasName() {
            return this.wrapped.category_aliasName;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
        public int getCategoryIdx() {
            return this.wrapped.category_idx;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
        public Map<String, String> getCategoryName() {
            if (this.categoryName == null) {
                this.categoryName = VolleyNetworkService.d(this.wrapped.categoryName);
            }
            return this.categoryName;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
        public String getIconURL() {
            return this.wrapped.imagePath;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
        public List<m> getSubCategories() {
            if (this.subcategoryList == null) {
                List<AssetStoreAPIData$SubcategoryInfo> list = this.wrapped.subcategory_info;
                if (list == null) {
                    this.subcategoryList = Collections.emptyList();
                } else {
                    this.subcategoryList = new ArrayList(list.size());
                    Iterator<AssetStoreAPIData$SubcategoryInfo> it = this.wrapped.subcategory_info.iterator();
                    while (it.hasNext()) {
                        this.subcategoryList.add(new StoreSubcategoryInfoImp(it.next(), getCategoryIdx(), null));
                    }
                }
            }
            return this.subcategoryList;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
        public ViewType getViewType() {
            return VolleyNetworkService.b(this.wrapped.view_type, getCategoryIdx());
        }

        private StoreCategoryInfoImp(AssetStoreAPIData$CategoryInfo assetStoreAPIData$CategoryInfo) {
            this.categoryName = null;
            this.subcategoryList = null;
            this.wrapped = assetStoreAPIData$CategoryInfo;
        }
    }

    /* loaded from: classes.dex */
    private static class StoreSubcategoryInfoImp implements m, Serializable {
        private final int categoryIdx;
        private Map<String, String> subcategoryName;
        private final AssetStoreAPIData$SubcategoryInfo wrapped;

        /* synthetic */ StoreSubcategoryInfoImp(AssetStoreAPIData$SubcategoryInfo assetStoreAPIData$SubcategoryInfo, int i, w wVar) {
            this(assetStoreAPIData$SubcategoryInfo, i);
        }

        @Override // com.nexstreaming.kinemaster.network.m
        public int getCategoryIdx() {
            return this.categoryIdx;
        }

        @Override // com.nexstreaming.kinemaster.network.m
        public String getSubcategoryAliasName() {
            return this.wrapped.subcategory_aliasName;
        }

        @Override // com.nexstreaming.kinemaster.network.m
        public int getSubcategoryIdx() {
            return this.wrapped.subcategory_idx;
        }

        @Override // com.nexstreaming.kinemaster.network.m
        public Map<String, String> getSubcategoryName() {
            if (this.subcategoryName == null) {
                this.subcategoryName = VolleyNetworkService.d(this.wrapped.subcategoryName);
            }
            return this.subcategoryName;
        }

        @Override // com.nexstreaming.kinemaster.network.m
        public ViewType getViewType() {
            return VolleyNetworkService.b(this.wrapped.view_type, getCategoryIdx());
        }

        private StoreSubcategoryInfoImp(AssetStoreAPIData$SubcategoryInfo assetStoreAPIData$SubcategoryInfo, int i) {
            this.subcategoryName = null;
            this.wrapped = assetStoreAPIData$SubcategoryInfo;
            this.categoryIdx = i;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f21115a;

        /* renamed from: b, reason: collision with root package name */
        private String f21116b;

        /* renamed from: c, reason: collision with root package name */
        private String f21117c;

        /* renamed from: d, reason: collision with root package name */
        private String f21118d;

        /* renamed from: e, reason: collision with root package name */
        private String f21119e;

        /* renamed from: f, reason: collision with root package name */
        private String f21120f;

        /* renamed from: g, reason: collision with root package name */
        private AssetEnv f21121g;

        public a(Context context) {
            this.f21115a = context;
        }

        public a a(String str) {
            this.f21120f = str;
            return this;
        }

        public a b(String str) {
            if (!str.endsWith("/")) {
                this.f21116b = str + "/";
            } else {
                this.f21116b = str;
            }
            return this;
        }

        public a c(String str) {
            this.f21119e = str;
            return this;
        }

        public a d(String str) {
            this.f21118d = str;
            return this;
        }

        public a e(String str) {
            this.f21117c = str;
            return this;
        }

        public a a(AssetEnv assetEnv) {
            this.f21121g = assetEnv;
            return this;
        }

        public InterfaceC1820i a() {
            return new VolleyNetworkService(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InterfaceC1821j {

        /* renamed from: a, reason: collision with root package name */
        private final AssetStoreAPIData$AssetInfo f21122a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, String> f21123b;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, String> f21124c;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f21125d;

        /* renamed from: e, reason: collision with root package name */
        List<String> f21126e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(AssetStoreAPIData$AssetInfo assetStoreAPIData$AssetInfo, w wVar) {
            this(assetStoreAPIData$AssetInfo);
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int a() {
            return this.f21122a.idx;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String b() {
            return this.f21122a.product_id;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public Map<String, String> c() {
            if (this.f21123b == null) {
                this.f21123b = VolleyNetworkService.d(this.f21122a.subcategoryName);
            }
            return this.f21123b;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String d() {
            return this.f21122a.audioclip_path;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String e() {
            return this.f21122a.thumbnail_path + "_s";
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String f() {
            return this.f21122a.title;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String g() {
            return this.f21122a.imagePath;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String getAssetId() {
            return this.f21122a.asset_id;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int getAssetVersion() {
            return this.f21122a.asset_version;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String getCategoryAliasName() {
            return this.f21122a.category_aliasName;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String getPriceType() {
            return this.f21122a.priceType;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int h() {
            return this.f21122a.asset_filesize;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int i() {
            return this.f21122a.availablePurchase;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public Map<String, String> j() {
            if (this.f21124c == null) {
                this.f21124c = VolleyNetworkService.d(this.f21122a.assetName);
            }
            return this.f21124c;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String k() {
            return null;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String l() {
            return this.f21122a.asset_filepath;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public Map<String, String> m() {
            if (this.f21125d == null) {
                this.f21125d = VolleyNetworkService.c(this.f21122a.assetName);
            }
            return this.f21125d;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int n() {
            return this.f21122a.subcategory_idx;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public List<String> o() {
            if (this.f21126e == null) {
                this.f21126e = new ArrayList();
                List<AssetStoreAPIData$ThumbInfo> list = this.f21122a.thumb;
                if (list != null) {
                    Iterator<AssetStoreAPIData$ThumbInfo> it = list.iterator();
                    while (it.hasNext()) {
                        String str = it.next().file_path;
                        if (str != null) {
                            this.f21126e.add(str);
                        }
                    }
                }
            }
            return this.f21126e;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String p() {
            AssetStoreAPIData$AssetInfo assetStoreAPIData$AssetInfo = this.f21122a;
            return assetStoreAPIData$AssetInfo != null ? assetStoreAPIData$AssetInfo.thumbnail_path : "";
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String q() {
            return this.f21122a.description;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int r() {
            return this.f21122a.category_idx;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String s() {
            return this.f21122a.payfee;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public int t() {
            return this.f21122a.update_time;
        }

        @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
        public String u() {
            return this.f21122a.videoclip_path;
        }

        private b(AssetStoreAPIData$AssetInfo assetStoreAPIData$AssetInfo) {
            this.f21122a = assetStoreAPIData$AssetInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements l {

        /* renamed from: a, reason: collision with root package name */
        private final AssetStoreAPIData$GetFeaturedAssetInfoResponse f21127a;

        /* renamed from: b, reason: collision with root package name */
        private List<InterfaceC1821j> f21128b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(AssetStoreAPIData$GetFeaturedAssetInfoResponse assetStoreAPIData$GetFeaturedAssetInfoResponse, w wVar) {
            this(assetStoreAPIData$GetFeaturedAssetInfoResponse);
        }

        @Override // com.nexstreaming.kinemaster.network.l
        public List<InterfaceC1821j> a() {
            List<AssetStoreAPIData$AssetInfo> list;
            if (this.f21128b == null) {
                this.f21128b = new ArrayList();
                AssetStoreAPIData$GetFeaturedAssetInfoResponse assetStoreAPIData$GetFeaturedAssetInfoResponse = this.f21127a;
                if (assetStoreAPIData$GetFeaturedAssetInfoResponse != null && (list = assetStoreAPIData$GetFeaturedAssetInfoResponse.objList) != null) {
                    Iterator<AssetStoreAPIData$AssetInfo> it = list.iterator();
                    while (it.hasNext()) {
                        this.f21128b.add(new b(it.next(), null));
                    }
                }
            }
            return this.f21128b;
        }

        private c(AssetStoreAPIData$GetFeaturedAssetInfoResponse assetStoreAPIData$GetFeaturedAssetInfoResponse) {
            this.f21128b = null;
            this.f21127a = assetStoreAPIData$GetFeaturedAssetInfoResponse;
        }
    }

    public VolleyNetworkService(a aVar) {
        this.f21109c = null;
        this.f21111e = null;
        this.i = 5;
        this.u = AssetEnv.PRODUCTION;
        this.j = aVar.f21115a;
        this.f21109c = aVar.f21116b;
        this.f21111e = aVar.f21117c;
        this.i = Integer.valueOf(aVar.f21118d).intValue();
        this.p = aVar.f21119e;
        this.q = aVar.f21120f;
        this.u = aVar.f21121g;
        this.f21108b = C1819h.a(this.j);
    }

    private static int c(int i) {
        return i;
    }

    private Task j() {
        if (!this.m && !this.n) {
            if (!this.k.isRunning()) {
                this.k = new Task();
            }
            if (l()) {
                if (n()) {
                    o().onComplete(new G(this)).onFailure(this.k);
                    return this.k;
                }
                return Task.COMPLETED_TASK;
            }
            if (this.f21111e != null) {
                if (this.p != null) {
                    AssetStoreAPIData$AuthorizeRequest assetStoreAPIData$AuthorizeRequest = new AssetStoreAPIData$AuthorizeRequest();
                    assetStoreAPIData$AuthorizeRequest.app_uuid = N.c(this.j);
                    assetStoreAPIData$AuthorizeRequest.app_name = N.a(this.j);
                    assetStoreAPIData$AuthorizeRequest.app_version = N.d(this.j);
                    assetStoreAPIData$AuthorizeRequest.app_ucode = this.f21111e;
                    String str = this.f21110d;
                    if (str == null) {
                        str = "UUID!" + assetStoreAPIData$AuthorizeRequest.app_uuid;
                    }
                    assetStoreAPIData$AuthorizeRequest.client_id = str;
                    assetStoreAPIData$AuthorizeRequest.application = k();
                    assetStoreAPIData$AuthorizeRequest.market_id = this.f21112f;
                    assetStoreAPIData$AuthorizeRequest.edition = this.p;
                    assetStoreAPIData$AuthorizeRequest.scope = this.i;
                    assetStoreAPIData$AuthorizeRequest.client_info = this.f21113g;
                    this.m = true;
                    Crashlytics.log("raw_authorize");
                    a(assetStoreAPIData$AuthorizeRequest).onResultAvailable(new I(this)).onFailure((Task.OnFailListener) new H(this));
                    return this.k;
                }
                throw new IllegalStateException("no edition id set");
            }
            throw new IllegalStateException("no mUcode set");
        }
        return this.k;
    }

    private String k() {
        String str = this.q;
        return str != null ? str : N.b();
    }

    private boolean l() {
        return this.o != null && SystemClock.elapsedRealtime() <= this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AssetStoreAPIData$StandardRequest m() {
        return a(true);
    }

    private boolean n() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.o != null) {
            long j = this.s;
            if (elapsedRealtime <= j - 10000 && elapsedRealtime > (this.t + j) / 2) {
                return true;
            }
        }
        return false;
    }

    private Task o() {
        if (this.n) {
            return this.l;
        }
        if (!this.m) {
            if (this.f21111e != null) {
                if (this.o == null) {
                    return Task.makeFailedTask(SessionError.NO_TOKEN);
                }
                this.l = new Task();
                AssetStoreAPIData$RefreshOrDeleteAuthRequest assetStoreAPIData$RefreshOrDeleteAuthRequest = new AssetStoreAPIData$RefreshOrDeleteAuthRequest();
                assetStoreAPIData$RefreshOrDeleteAuthRequest.access_token = this.o;
                assetStoreAPIData$RefreshOrDeleteAuthRequest.app_ucode = this.f21111e;
                assetStoreAPIData$RefreshOrDeleteAuthRequest.application = k();
                this.n = true;
                b(assetStoreAPIData$RefreshOrDeleteAuthRequest).onResultAvailable(new o(this)).onFailure((Task.OnFailListener) new n(this));
                return this.l;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<List<InterfaceC1822k>> g() {
        if (this.v != null && System.nanoTime() < this.x + 900000000000L) {
            return this.v;
        }
        ResultTask<List<InterfaceC1822k>> resultTask = this.w;
        if (resultTask == null || !resultTask.isRunning()) {
            this.w = new ResultTask<>();
            j().onComplete(new z(this)).onFailure(this.w);
        }
        ResultTask<List<InterfaceC1822k>> resultTask2 = this.v;
        return resultTask2 != null ? resultTask2 : this.w;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public int h() {
        return this.i;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<List<InterfaceC1821j>> d() {
        Crashlytics.log("raw_getProductList");
        final ResultTask<List<InterfaceC1821j>> resultTask = new ResultTask<>();
        j().onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.network.a
            @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
            public final void onTaskEvent(Task task, Task.Event event) {
                VolleyNetworkService.this.a(resultTask, task, event);
            }
        }).onFailure(resultTask);
        return resultTask;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<SubscriptionInfo> e() {
        Crashlytics.log("raw_getSubscriptionInfo");
        final ResultTask<SubscriptionInfo> resultTask = new ResultTask<>();
        j().onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.network.d
            @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
            public final void onTaskEvent(Task task, Task.Event event) {
                VolleyNetworkService.this.b(resultTask, task, event);
            }
        }).onFailure(resultTask);
        return resultTask;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public void f() {
        if (a(new w(this))) {
            j().onComplete(new x(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public void c() {
        C1819h.a(this.j).b().a().clear();
        this.v = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(int i) {
        c(i);
        return i;
    }

    private ResultTask<List<InterfaceC1821j>> d(int i) {
        ResultTask<List<InterfaceC1821j>> resultTask = new ResultTask<>();
        j().onComplete(new s(this, i, resultTask)).onFailure(resultTask);
        return resultTask;
    }

    private ResultTask<AssetStoreAPIData$GetCategoryListResponse> c(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest) {
        return a(assetStoreAPIData$StandardRequest, AssetStoreAPIData$GetCategoryListResponse.class, "product", "list", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<AssetStoreAPIData$GetFeaturedAssetInfoResponse> c(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest, int i) {
        return a(assetStoreAPIData$StandardRequest, AssetStoreAPIData$GetFeaturedAssetInfoResponse.class, "featured", "list", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> c(List<AssetStoreAPIData$LangString> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (AssetStoreAPIData$LangString assetStoreAPIData$LangString : list) {
                hashMap.put(assetStoreAPIData$LangString.language_code, assetStoreAPIData$LangString.string_desc);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> d(List<AssetStoreAPIData$LangString> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (AssetStoreAPIData$LangString assetStoreAPIData$LangString : list) {
                hashMap.put(assetStoreAPIData$LangString.language_code, assetStoreAPIData$LangString.string_title);
            }
        }
        return hashMap;
    }

    public /* synthetic */ void b(final ResultTask resultTask, Task task, Task.Event event) {
        a(c(this.o)).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.network.c
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask2, Task.Event event2, Object obj) {
                VolleyNetworkService.a(ResultTask.this, resultTask2, event2, (AssetStoreAPIData$GetSubscriptionInfoResponse) obj);
            }
        }).onFailure(resultTask);
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public AssetEnv b() {
        return this.u;
    }

    private ResultTask<AssetStoreAPIData$AuthorizeOrRefreshResponse> b(AssetStoreAPIData$RefreshOrDeleteAuthRequest assetStoreAPIData$RefreshOrDeleteAuthRequest) {
        return a(assetStoreAPIData$RefreshOrDeleteAuthRequest, AssetStoreAPIData$AuthorizeOrRefreshResponse.class, "oauth", "refreshauth", new Object[0]);
    }

    private AssetStoreAPIData$SubscriptionRequest c(String str) {
        AssetStoreAPIData$SubscriptionRequest assetStoreAPIData$SubscriptionRequest = new AssetStoreAPIData$SubscriptionRequest();
        assetStoreAPIData$SubscriptionRequest.access_token = str;
        return assetStoreAPIData$SubscriptionRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<AssetStoreAPIData$GetCategoryInfoResponse> b(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest) {
        return a(assetStoreAPIData$StandardRequest, AssetStoreAPIData$GetCategoryInfoResponse.class, "category", "info", new Object[0]);
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public String a() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d<TREQUEST, TRESPONSE> extends Request<TRESPONSE> {
        private final ResultTask<TRESPONSE> p;
        private final Class<TRESPONSE> q;
        private final TREQUEST r;

        public d(String str, TREQUEST trequest, ResultTask<TRESPONSE> resultTask, Class<TRESPONSE> cls) {
            super(1, str, new J(str, trequest, resultTask));
            this.p = resultTask;
            this.q = cls;
            this.r = trequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int c(com.android.volley.j jVar) {
            try {
                String trim = new String(jVar.f8071b, com.android.volley.a.f.a(jVar.f8072c, "utf-8")).trim();
                if (trim.length() > 0) {
                    char charAt = trim.charAt(0);
                    if (charAt == '[') {
                        trim = trim.substring(0, trim.lastIndexOf(93) + 1);
                    } else if (charAt == '{') {
                        trim = trim.substring(0, trim.lastIndexOf(125) + 1);
                    } else if (charAt == '\"') {
                        trim = trim.substring(0, trim.lastIndexOf(34) + 1);
                    }
                }
                AssetStoreAPIData$StatusResponse assetStoreAPIData$StatusResponse = (AssetStoreAPIData$StatusResponse) VolleyNetworkService.f21107a.fromJson(trim, AssetStoreAPIData$StatusResponse.class);
                if (assetStoreAPIData$StatusResponse == null) {
                    return 0;
                }
                return assetStoreAPIData$StatusResponse.result;
            } catch (JsonSyntaxException | UnsupportedEncodingException unused) {
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.android.volley.Request
        public com.android.volley.m<TRESPONSE> a(com.android.volley.j jVar) {
            int i = jVar.f8070a;
            VolleyNetworkService.b(i);
            if (i != 200) {
                return com.android.volley.m.a(new ServerError(jVar));
            }
            try {
                String trim = new String(jVar.f8071b, com.android.volley.a.f.a(jVar.f8072c, "utf-8")).trim();
                if (trim.length() > 0) {
                    char charAt = trim.charAt(0);
                    if (charAt == '[') {
                        trim = trim.substring(0, trim.lastIndexOf(93) + 1);
                    } else if (charAt == '{') {
                        trim = trim.substring(0, trim.lastIndexOf(125) + 1);
                    } else if (charAt == '\"') {
                        trim = trim.substring(0, trim.lastIndexOf(34) + 1);
                    }
                }
                return com.android.volley.m.a(VolleyNetworkService.f21107a.fromJson(trim, (Class) this.q), com.android.volley.a.f.a(jVar));
            } catch (JsonSyntaxException e2) {
                return com.android.volley.m.a(new ParseError(e2));
            } catch (UnsupportedEncodingException e3) {
                return com.android.volley.m.a(new ParseError(e3));
            }
        }

        @Override // com.android.volley.Request
        public String d() {
            return io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE;
        }

        @Override // com.android.volley.Request
        public byte[] a() {
            return VolleyNetworkService.f21107a.toJson(this.r).getBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.android.volley.Request
        public void a(TRESPONSE tresponse) {
            this.p.sendResult(tresponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<AssetStoreAPIData$GetCategoryListResponse> b(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest, int i) {
        return a(assetStoreAPIData$StandardRequest, AssetStoreAPIData$GetCategoryListResponse.class, "category", "list", Integer.valueOf(i));
    }

    public /* synthetic */ void a(final ResultTask resultTask, Task task, Task.Event event) {
        c(m()).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.network.b
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask2, Task.Event event2, Object obj) {
                VolleyNetworkService.a(ResultTask.this, resultTask2, event2, (AssetStoreAPIData$GetCategoryListResponse) obj);
            }
        }).onFailure(resultTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AssetStoreAPIData$AssetVersionInfoRequest b(String str) {
        AssetStoreAPIData$AssetVersionInfoRequest assetStoreAPIData$AssetVersionInfoRequest = new AssetStoreAPIData$AssetVersionInfoRequest();
        a((AssetStoreAPIData$StandardRequest) assetStoreAPIData$AssetVersionInfoRequest);
        AssetStoreAPIData$AssetVersionInfoRequest assetStoreAPIData$AssetVersionInfoRequest2 = assetStoreAPIData$AssetVersionInfoRequest;
        assetStoreAPIData$AssetVersionInfoRequest2.asset_idx = str;
        return assetStoreAPIData$AssetVersionInfoRequest2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ResultTask resultTask, ResultTask resultTask2, Task.Event event, AssetStoreAPIData$GetCategoryListResponse assetStoreAPIData$GetCategoryListResponse) {
        List<AssetStoreAPIData$AssetInfo> list = assetStoreAPIData$GetCategoryListResponse.objList;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<AssetStoreAPIData$AssetInfo> it = assetStoreAPIData$GetCategoryListResponse.objList.iterator();
            while (it.hasNext()) {
                arrayList.add(new b(it.next(), null));
            }
            resultTask.sendResult(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewType b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i == 5) {
                return ViewType.AUDIO;
            }
            if (i != 16) {
                return ViewType.GRID;
            }
            return ViewType.AUDIO_MUSERK;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1605349828:
                if (str.equals("audio_muserk")) {
                    c2 = 3;
                    break;
                }
                break;
            case -290659282:
                if (str.equals("featured")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3181382:
                if (str.equals("grid")) {
                    c2 = 0;
                    break;
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return ViewType.GRID;
        }
        if (c2 == 1) {
            return ViewType.FEATURED;
        }
        if (c2 == 2) {
            return ViewType.AUDIO;
        }
        if (c2 != 3) {
            return ViewType.GRID;
        }
        return ViewType.AUDIO_MUSERK;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<List<InterfaceC1821j>> a(InterfaceC1822k interfaceC1822k) {
        return d(interfaceC1822k.getCategoryIdx());
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<List<InterfaceC1821j>> a(m mVar) {
        return a(mVar.getCategoryIdx(), mVar.getSubcategoryIdx());
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<InterfaceC1821j> a(int i, boolean z) {
        ResultTask<InterfaceC1821j> resultTask = new ResultTask<>();
        j().onComplete(new B(this, z, i, resultTask)).onFailure(resultTask);
        return resultTask;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<l> a(int i) {
        ResultTask<l> resultTask = new ResultTask<>();
        j().onComplete(new D(this, i, resultTask)).onFailure(resultTask);
        return resultTask;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public ResultTask<List<AssetStoreAPIData$AssetVersionInfo>> a(String str) {
        ResultTask<List<AssetStoreAPIData$AssetVersionInfo>> resultTask = new ResultTask<>();
        j().onComplete(new F(this, str, resultTask)).onFailure(resultTask);
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ResultTask resultTask, ResultTask resultTask2, Task.Event event, AssetStoreAPIData$GetSubscriptionInfoResponse assetStoreAPIData$GetSubscriptionInfoResponse) {
        SubscriptionInfo subscriptionInfo = assetStoreAPIData$GetSubscriptionInfoResponse.skuList;
        if (subscriptionInfo != null) {
            resultTask.sendResult(subscriptionInfo);
        } else {
            resultTask.sendFailure(Task.makeTaskError("null skuList"));
        }
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1820i
    public boolean a(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j == null) {
            return false;
        }
        long t = interfaceC1821j.t();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > t && currentTimeMillis < t + 1209600;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Task.TaskError taskError) {
        if (taskError != SessionError.TOKEN_EXPIRED) {
            return false;
        }
        this.o = null;
        j();
        return true;
    }

    private ResultTask<AssetStoreAPIData$AuthorizeOrRefreshResponse> a(AssetStoreAPIData$AuthorizeRequest assetStoreAPIData$AuthorizeRequest) {
        return a(assetStoreAPIData$AuthorizeRequest, AssetStoreAPIData$AuthorizeOrRefreshResponse.class, "oauth", "authorize", new Object[0]);
    }

    private ResultTask<AssetStoreAPIData$StatusResponse> a(AssetStoreAPIData$RefreshOrDeleteAuthRequest assetStoreAPIData$RefreshOrDeleteAuthRequest) {
        return a(assetStoreAPIData$RefreshOrDeleteAuthRequest, AssetStoreAPIData$StatusResponse.class, "oauth", "delauth", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<AssetStoreAPIData$GetCategoryListResponse> a(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest, int i, int i2) {
        return a(assetStoreAPIData$StandardRequest, AssetStoreAPIData$GetCategoryListResponse.class, "category", "list", Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<AssetStoreAPIData$AssetInfo> a(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest, int i) {
        return a(assetStoreAPIData$StandardRequest, AssetStoreAPIData$AssetInfo.class, "asset", "info", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<AssetStoreAPIData$GetAssetVersionInfoResponse> a(AssetStoreAPIData$AssetVersionInfoRequest assetStoreAPIData$AssetVersionInfoRequest) {
        return a(assetStoreAPIData$AssetVersionInfoRequest, AssetStoreAPIData$GetAssetVersionInfoResponse.class, "2", "asset", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, new Object[0]);
    }

    private ResultTask<AssetStoreAPIData$GetSubscriptionInfoResponse> a(AssetStoreAPIData$SubscriptionRequest assetStoreAPIData$SubscriptionRequest) {
        return a(assetStoreAPIData$SubscriptionRequest, AssetStoreAPIData$GetSubscriptionInfoResponse.class, "subscription", "list", new Object[0]);
    }

    private <TREQUEST, TRESPONSE> ResultTask<TRESPONSE> a(TREQUEST trequest, Class<TRESPONSE> cls, String str, String str2, Object... objArr) {
        return a(trequest, cls, this.f21114h, str, str2, objArr);
    }

    private <TREQUEST, TRESPONSE> ResultTask<TRESPONSE> a(TREQUEST trequest, Class<TRESPONSE> cls, String str, String str2, String str3, Object... objArr) {
        if (this.f21109c != null) {
            ResultTask<TRESPONSE> resultTask = new ResultTask<>();
            StringBuilder sb = new StringBuilder(this.f21109c.length() + 64);
            sb.append(this.f21109c);
            sb.append('v');
            sb.append(str);
            sb.append('/');
            sb.append(str2);
            sb.append('/');
            sb.append(str3);
            for (Object obj : objArr) {
                sb.append('/');
                sb.append(String.valueOf(obj));
            }
            d dVar = new d(sb.toString(), trequest, resultTask, cls);
            dVar.a((com.android.volley.o) new com.android.volley.d(15000, 1, 1.0f));
            this.f21108b.a(dVar);
            resultTask.onFailure((Task.OnFailListener) new p(this));
            return resultTask;
        }
        throw new IllegalStateException("Base URL not set");
    }

    private boolean a(Task.OnTaskEventListener onTaskEventListener) {
        if (this.m) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.j);
        String string = defaultSharedPreferences.getString("access_token", null);
        int i = defaultSharedPreferences.getInt("scope", 5);
        if (string == null || i == this.i) {
            return true;
        }
        AssetStoreAPIData$RefreshOrDeleteAuthRequest assetStoreAPIData$RefreshOrDeleteAuthRequest = new AssetStoreAPIData$RefreshOrDeleteAuthRequest();
        assetStoreAPIData$RefreshOrDeleteAuthRequest.access_token = string;
        assetStoreAPIData$RefreshOrDeleteAuthRequest.app_ucode = this.f21111e;
        assetStoreAPIData$RefreshOrDeleteAuthRequest.application = k();
        this.m = true;
        a(assetStoreAPIData$RefreshOrDeleteAuthRequest).onComplete(onTaskEventListener).onFailure((Task.OnFailListener) new q(this, onTaskEventListener));
        return false;
    }

    private ResultTask<List<InterfaceC1821j>> a(int i, int i2) {
        ResultTask<List<InterfaceC1821j>> resultTask = new ResultTask<>();
        j().onComplete(new u(this, i, i2, resultTask)).onFailure(resultTask);
        return resultTask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <REQUEST> REQUEST a(AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest) {
        if (this.p != null) {
            assetStoreAPIData$StandardRequest.access_token = this.o;
            String str = this.q;
            if (str == null) {
                str = k();
            }
            assetStoreAPIData$StandardRequest.application = str;
            assetStoreAPIData$StandardRequest.edition = this.p;
            String str2 = this.r;
            if (str2 == null) {
                str2 = this.j.getResources().getConfiguration().locale.toString().replace(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR, "-");
            }
            assetStoreAPIData$StandardRequest.language = str2;
            int i = v.f21152a[this.u.ordinal()];
            if (i == 1) {
                assetStoreAPIData$StandardRequest.env = 1;
            } else if (i != 2) {
                assetStoreAPIData$StandardRequest.env = 3;
            } else {
                assetStoreAPIData$StandardRequest.env = 2;
            }
            return assetStoreAPIData$StandardRequest;
        }
        throw new IllegalStateException("edition not set");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AssetStoreAPIData$StandardRequest a(boolean z) {
        AssetStoreAPIData$StandardRequest assetStoreAPIData$StandardRequest = z ? new AssetStoreAPIData$StandardRequest() : new AssetStoreAPIData$NoCacheStandardRequest();
        a(assetStoreAPIData$StandardRequest);
        return assetStoreAPIData$StandardRequest;
    }
}
