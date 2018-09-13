package com.dommy.selectcustom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.dommy.selectcustom.util.CommonUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txt_value)
    TextView tvValue; // 选种值
    @BindViews({R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4, R.id.radio5, R.id.radio6, R.id.radio7})
    List<CheckBox> radios; // 单选组
    @BindViews({R.id.checkbox1, R.id.checkbox2, R.id.checkbox3, R.id.checkbox4, R.id.checkbox5, R.id.checkbox6, R.id.checkbox7})
    List<CheckBox> checkBoxes; // 多选组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // 如果有初始状态需要显示，参见：
        // com.dommy.selectcustom.util.CommonUtil.checkOne()
        // com.dommy.selectcustom.util.CommonUtil.checkMany()
    }

    /**
     * 单选项点击事件
     * @param checkBox
     */
    @OnClick({R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4, R.id.radio5, R.id.radio6, R.id.radio7})
    void changeRadios(CheckBox checkBox) {
        CommonUtil.unCheck(radios);
        checkBox.setChecked(true);

        // 显示选中项值
        String checkedValues = CommonUtil.getOne(radios);
        tvValue.setText("选中了：" + checkedValues);
    }

    /**
     * 复选项点击事件
     * @param checkBox
     */
    @OnClick({R.id.checkbox1, R.id.checkbox2, R.id.checkbox3, R.id.checkbox4, R.id.checkbox5, R.id.checkbox6, R.id.checkbox7})
    void changeCheckBoxs(CheckBox checkBox) {
        // 显示选中项值
        String checkedValues = CommonUtil.getMany(checkBoxes);
        tvValue.setText("选中了：" + checkedValues);
    }
}
