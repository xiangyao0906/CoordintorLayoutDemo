package componetdemo.xiangyao.com.coordintorlayoutdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 61904 on 2016/11/1.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> fragmentList;
    private int currtFragment;
    private Fragment mCurrentFragment;
    private Map<Integer, Fragment> map = new HashMap<Integer, Fragment>();

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;

    }

    @Override
    public Fragment getItem(int position) {
        fragmentList.get(currtFragment).setUserVisibleHint(true);
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        map.put(position, fragment);
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    //获取指定位置最后显示的Fragment
    public Fragment getCurrentFragment(int index) {
        return map.get(index);
    }

}
