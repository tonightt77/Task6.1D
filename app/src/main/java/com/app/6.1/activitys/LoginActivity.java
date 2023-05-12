package com.app.demo.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.MainActivity;
import com.app.demo.R;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.beans.UserBean;
import com.app.shop.mylibrary.utils.SharedPreferencesUtil;
import com.app.shop.mylibrary.utils.StringUtil;
import com.app.shop.mylibrary.utils.ToastUtil;
import com.app.shop.mylibrary.utils.UserManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.imgv_return)
    ImageView imgvReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.inputName)
    EditText inputName;
    @BindView(R.id.inputpwd)
    EditText inputpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        tvTitle.setText("LOGIN");
    }

    @OnClick({R.id.imgv_return, R.id.toLogin, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.toLogin:
                if (StringUtil.isEmpty(inputName.getText().toString())) {
                    ToastUtil.showToast(this, "Please enter username");
                    return;
                }

                if (StringUtil.isEmpty(inputpwd.getText().toString())) {
                    ToastUtil.showToast(this, "Please enter password");
                    return;
                }


                boolean isExistedUser = UserManager.isExistedUser(inputName.getText().toString());
                if (isExistedUser) {//User is existed
                    if (UserManager.isOk(inputName.getText().toString(), inputpwd.getText().toString())) { //Correct password
                        UserBean userBean = UserManager.getUser(inputName.getText().toString());
                        SharedPreferencesUtil.saveDataBean(this, userBean, "user");
                        EventBus.getDefault().post(new EventMessage(EventMessage.LOGIN));
                        showActivity(this, MainActivity.class);
                        finish();
                    } else {
                        ToastUtil.showToast(this, "Incorrect password");
                    }
                } else {
                    ToastUtil.showToast(this, "User does not exist, please register first.");
                }
                break;
            case R.id.tv_register:
                showActivity(this, RegisterActivity.class);
                break;
        }
    }
}
