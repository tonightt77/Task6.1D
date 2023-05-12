package com.app.demo.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.R;
import com.app.demo.beans.OrderBean;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.utils.GlideUtils;
import com.app.shop.mylibrary.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgv)
    ImageView imgv;
    @BindView(R.id.tv_user_from)
    TextView tv_user_from;
    @BindView(R.id.tv_time_1)
    TextView tv_time_1;
    @BindView(R.id.tv_user_to)
    TextView tv_user_to;
    @BindView(R.id.tv_time_2)
    TextView tv_time_2;
    @BindView(R.id.tv_goods_type)
    TextView tv_goods_type;
    @BindView(R.id.tv_vehicle_type)
    TextView tv_vehicle_type;
    @BindView(R.id.tv_weight)
    TextView tv_weight;
    @BindView(R.id.tv_wight)
    TextView tv_wight;
    @BindView(R.id.tv_length)
    TextView tv_length;
    @BindView(R.id.tv_height)
    TextView tv_height;


    OrderBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initData();
        tvTitle.setText("Order Details");
    }


    private void initData() {

        Bundle bundle = getIntent().getExtras();
        bean = (OrderBean) bundle.getSerializable("bean");
        GlideUtils.getInstance().loadImage(this, bean.img, imgv, R.mipmap.ic_launcher);
        tv_user_from.setText("From sender:" + bean.user_name);
        tv_user_to.setText("To receiver:" + bean.user_to);
        tv_time_1.setText("Pick up time:" + bean.time);
        tv_time_2.setText("Drop off time:");
        tv_goods_type.setText("Goods Type:\n" + bean.goodsType);
        tv_vehicle_type.setText("vehicle Type:\n" + bean.vehicleType);
        tv_weight.setText("weight:\n" + bean.weight+" kg");
        tv_wight.setText("width:\n" + bean.wight+" m");
        tv_length.setText("Length:\n" + bean.length+" m");
        tv_height.setText("Height:\n" + bean.height+" m");


    }

    @OnClick({R.id.imgv_return, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.tv_ok:

                ToastUtil.showToast(this, "calling driver");
                break;
        }
    }


}
