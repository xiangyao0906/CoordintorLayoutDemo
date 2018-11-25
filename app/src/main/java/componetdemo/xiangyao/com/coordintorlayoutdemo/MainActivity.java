package componetdemo.xiangyao.com.coordintorlayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import componetdemo.xiangyao.com.coordintorlayoutdemo.adapter.ViewPagerAdapter;
import componetdemo.xiangyao.com.coordintorlayoutdemo.base.BaseActivity;
import componetdemo.xiangyao.com.coordintorlayoutdemo.fragment.HomeFragment;
import componetdemo.xiangyao.com.coordintorlayoutdemo.fragment.MineFragment;
import componetdemo.xiangyao.com.coordintorlayoutdemo.fragment.NewsFragment;
import componetdemo.xiangyao.com.coordintorlayoutdemo.utils.Constant;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.homeImg)
    ImageView homeImg;
    @BindView(R.id.homeText)
    TextView homeText;
    @BindView(R.id.homeLayout)
    LinearLayout homeLayout;
    @BindView(R.id.messageImg)
    ImageView messageImg;
    @BindView(R.id.messageText)
    TextView messageText;
    @BindView(R.id.messageLayout)
    LinearLayout messageLayout;
    @BindView(R.id.mineImg)
    ImageView mineImg;
    @BindView(R.id.mineText)
    TextView mineText;
    @BindView(R.id.mineLayout)
    LinearLayout mineLayout;
    @BindView(R.id.main_content)
    LinearLayout mainContent;
    List<Fragment> fragmentList;


    public MainActivity() {
        fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(NewsFragment.newInstance());
        fragmentList.add(MineFragment.newInstance());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        viewpager.addOnPageChangeListener(this);

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeBgAndTextColor(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void changeBgAndTextColor(int selectPage) {

        homeImg.setBackgroundResource(R.mipmap.ic_tab_strip_icon_feed);
        messageImg.setBackgroundResource(R.mipmap.ic_tab_strip_icon_category);
        mineImg.setBackgroundResource(R.mipmap.ic_tab_strip_icon_follow);

        switch (selectPage) {
            case Constant.HOME:
                homeImg.setBackgroundResource(R.mipmap.ic_tab_strip_icon_feed_selected);
                break;
            case Constant.NEWS:
                messageImg.setBackgroundResource(R.mipmap.ic_tab_strip_icon_category_selected);
                break;
            case Constant.MINE:
                mineImg.setBackgroundResource(R.mipmap.ic_tab_strip_icon_follow_selected);
                break;
            default:
                break;
        }
    }


    @OnClick({R.id.homeLayout, R.id.messageLayout, R.id.mineLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homeLayout:
                changeBgAndTextColor(Constant.HOME);
                viewpager.setCurrentItem(Constant.HOME);
                break;
            case R.id.messageLayout:
                changeBgAndTextColor(Constant.NEWS);
                viewpager.setCurrentItem(Constant.NEWS);
                break;
            case R.id.mineLayout:
                changeBgAndTextColor(Constant.MINE);
                viewpager.setCurrentItem(Constant.MINE);
                break;
            default:
                break;
        }
    }
}
