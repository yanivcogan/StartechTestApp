package com.example.user.startechtestapp;

import android.content.Context;
import android.widget.FrameLayout;

import com.inneractive.api.ads.sdk.InneractiveAdManager;
import com.inneractive.api.ads.sdk.InneractiveAdView;

/**
 * Created by User on 05/11/2017.
 */

public class LayoutAdPopulator {
    public static void initializeServiceProvider (Context ctx)
    {
        InneractiveAdManager.initialize(ctx);
    }
    public static void adifyLayout(FrameLayout ParentView, Context ctx)
    {
        InneractiveAdView mBanner = new InneractiveAdView(ctx, "Nirit_MobileSchool_Android", InneractiveAdView.AdType.Banner);
        ParentView.addView(mBanner);
        mBanner.loadAd();
    }
}
