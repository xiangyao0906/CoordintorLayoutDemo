package componetdemo.xiangyao.com.coordintorlayoutdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import componetdemo.xiangyao.com.coordintorlayoutdemo.R;
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
    Unbinder unbinder;

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

        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://movieplayer.net-cdn.it/images/2018/02/09/mcu-calss-3.jpg");
        imageUrls.add("https://www.nerdplanet.it/wp-content/uploads/2017/06/Marvel.jpg");
        imageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMoJZuo1iSB_3daxm6ULrNfh39neginvxUXXMU3ZbSdKw8X-55jg");

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
        ImmersionBar.with(this).titleBar(toolbar).init();
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
