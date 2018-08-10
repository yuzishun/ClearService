package com.example.yuzishun.clearservice.tools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryActivity extends BaseActivity {
    String TAG = "CountryActivity";

    private List<CountrySortModel> mAllCountryList;


    private ListView country_lv_countryList;

    private CountrySortAdapter adapter;

    private SideBar sideBar;

    private TextView dialog;

    private CountryComparator pinyinComparator;

    private GetCountryNameSort countryChangeUtil;

    private CharacterParserUtil characterParserUtil;
    private LinearLayout image_back;
    private TextView title_text;
    private int[] remenList = {31,168,70,36};
    @Override
    public int intiLayout() {
        return R.layout.activity_country;
    }

    @Override
    public void initView() {
        country_lv_countryList = (ListView) findViewById(R.id.country_lv_list);

        dialog = (TextView) findViewById(R.id.country_dialog);
        sideBar = (SideBar) findViewById(R.id.country_sidebar);
        image_back =findViewById(R.id.image_back);
        title_text = findViewById(R.id.title_text);
        title_text.setText(R.string.choosecountry);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String country_number = intent.getStringExtra("country_number");
        sideBar.setTextView(dialog);

        mAllCountryList = new ArrayList<CountrySortModel>();
        pinyinComparator = new CountryComparator();
        countryChangeUtil = new GetCountryNameSort();
        characterParserUtil = new CharacterParserUtil();

        // 将联系人进行排序，按照A~Z的顺序
        Collections.sort(mAllCountryList, pinyinComparator);
        adapter = new CountrySortAdapter(this, mAllCountryList);
        country_lv_countryList.setAdapter(adapter);



    }

    @Override
    public void initData() {
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                // 该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    country_lv_countryList.setSelection(position);
                }
            }
        });
        getCountryList();

    }


    /**
     * 获取国家列表
     */
    private void getCountryList() {
        String[] countryList = getResources().getStringArray(R.array.country_code_list_ch);


        SpUtil spUtil2 = new SpUtil(CountryActivity.this,"postion");
        int postion = spUtil2.getInt("postion",0);
        adapter.check = postion;
        adapter.notifyDataSetChanged();
        for (int i = 0, length = countryList.length; i < length; i++) {
            String[] country = countryList[i].split("\\*");

            String countryName = country[0];
            String countryNumber = country[1];
            String countrySortKey = characterParserUtil.getSelling(countryName);
            CountrySortModel countrySortModel = new CountrySortModel(countryName, countryNumber,
                    countrySortKey);
            String sortLetter = countryChangeUtil.getSortLetterBySortKey(countrySortKey);
            if (sortLetter == null) {
                sortLetter = countryChangeUtil.getSortLetterBySortKey(countryName);
            }

            countrySortModel.sortLetters = sortLetter;
            mAllCountryList.add(countrySortModel);




//            if(countryNumber.equals(number)){

//
////                    }
//
//            }
        }

//
//   <item>中国               *+86   </item>
//        <item>香港               *+852  </item>
//        <item>台湾省             *+886  </item>
//        <item>加拿大             *+1    </item>

        Collections.sort(mAllCountryList, pinyinComparator);
            for (int i = 0; i <remenList.length ; i++) {
                String[] country = countryList[remenList[i]].split("\\*");

                String countryName = country[0];
                String countryNumber = country[1];
                String countrySortKey = characterParserUtil.getSelling(countryName);
                CountrySortModel countrySortModel = new CountrySortModel(countryName, countryNumber,
                        countrySortKey);
                String sortLetter = "热门";

                countrySortModel.sortLetters = sortLetter;
                mAllCountryList.add(0,countrySortModel);

            }

        adapter.updateListView(mAllCountryList);
        Log.e(TAG, "changdu" + mAllCountryList.size());



    }


}
