package componetdemo.xiangyao.com.coordintorlayoutdemo.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import componetdemo.xiangyao.com.coordintorlayoutdemo.R;
import componetdemo.xiangyao.com.coordintorlayoutdemo.adapter.CommonAdapter;
import componetdemo.xiangyao.com.coordintorlayoutdemo.base.BaseLazyFragment;

/**
 *
 */
public class HomeSubFragment extends BaseLazyFragment {
    @BindView(R.id.homeRecycleview)
    RecyclerView homeRecycleview;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_home_sub, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    public static HomeSubFragment newInstance() {

        Bundle args = new Bundle();

        HomeSubFragment fragment = new HomeSubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public HomeSubFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFragmentFirstVisible() {
        initData();
    }


    protected void initData() {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add("sodagreen" + i);
        }
        CommonAdapter commonAdapter = new CommonAdapter(strings);
        homeRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeRecycleview.setAdapter(commonAdapter);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
