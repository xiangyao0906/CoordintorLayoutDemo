package componetdemo.xiangyao.com.coordintorlayoutdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import componetdemo.xiangyao.com.coordintorlayoutdemo.R;

/**
 * Created by xiangyao on 2018/11/25.
 */

public class CommonAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CommonAdapter(@Nullable List<String> data) {
        super(R.layout.item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.itemText, item);

    }
}
