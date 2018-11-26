package componetdemo.xiangyao.com.coordintorlayoutdemo.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.TriangularPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import componetdemo.xiangyao.com.coordintorlayoutdemo.R;
import componetdemo.xiangyao.com.coordintorlayoutdemo.adapter.ViewPagerAdapter;
import componetdemo.xiangyao.com.coordintorlayoutdemo.base.BaseFragment;
import componetdemo.xiangyao.com.coordintorlayoutdemo.utils.MyImageLoadCache;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.titleLayout)
    LinearLayout titleLayout;
    @BindView(R.id.youthBanner)
    Banner banner;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    Unbinder unbinder;
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.smarRefreshLayout)
    SmartRefreshLayout smarRefreshLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    List<String> titleString;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        super.initData();
        titleString = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            titleString.add("经济" + i);
        }
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://movieplayer.net-cdn.it/images/2018/02/09/mcu-calss-3.jpg");
        imageUrls.add("https://movieplayer.net-cdn.it/images/2018/02/09/mcu-calss-3.jpg");
        imageUrls.add("https://movieplayer.net-cdn.it/images/2018/02/09/mcu-calss-3.jpg");

        banner.setImages(imageUrls)
                .setImageLoader(new MyImageLoadCache())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setDelayTime(4000)
                .start();
    }

    @Override
    protected void initView() {
        super.initView();
        smarRefreshLayout.setEnableLoadMore(false);
        ImmersionBar.with(this).titleBar(toolbar).init();
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                int i1 = banner.getBottom() - titleLayout.getBottom();
                int total = 0;
                total = Math.abs(verticalOffset) + total;

                if (total <= 0) {  //在顶部时完全透明
                    toolbar.setBackgroundColor(Color.argb(0, 242, 242, 242));
                } else if (total <= i1) {  //在滑动高度中时，设置透明度百分比（当前高度/总高度）
                    double d = (double) total / i1;
                    double alpha = (d * 255);
                    toolbar.setBackgroundColor(Color.argb((int) alpha, 242, 242, 242));
                } else { //滑出总高度 完全不透明
                    toolbar.setBackgroundColor(Color.argb(255, 242, 242, 242));
                }

            }
        });


        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < titleString.size(); i++) {
            HomeSubFragment homeSubFragment = HomeSubFragment.newInstance();
            fragmentList.add(homeSubFragment);
        }
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), fragmentList));

        final CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return titleString == null ? 0 : titleString.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);

                clipPagerTitleView.setText(titleString.get(index));
                clipPagerTitleView.setTextColor(Color.parseColor("#f2c4c4"));
                clipPagerTitleView.setClipColor(Color.WHITE);

                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });

                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                TriangularPagerIndicator indicator = new TriangularPagerIndicator(context);
                indicator.setLineColor(Color.parseColor("#e94220"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
