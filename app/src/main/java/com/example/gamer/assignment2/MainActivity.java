package com.example.gamer.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final int ITEM_REQUEST = 1;
    public int count = 0;
    public int maxItems = 10;
    private static String MY_COUNT = "count";
    private static String MY_ITEM = "item";

    @BindView(R.id.btn_add_item)
    Button btnAddItem;
    @BindView(R.id.tv_item_1)
    TextView tvItem1;
    @BindView(R.id.tv_item_2)
    TextView tvItem2;
    @BindView(R.id.tv_item_3)
    TextView tvItem3;
    @BindView(R.id.tv_item_4)
    TextView tvItem4;
    @BindView(R.id.tv_item_5)
    TextView tvItem5;
    @BindView(R.id.tv_item_6)
    TextView tvItem6;
    @BindView(R.id.tv_item_7)
    TextView tvItem7;
    @BindView(R.id.tv_item_8)
    TextView tvItem8;
    @BindView(R.id.tv_item_9)
    TextView tvItem9;
    @BindView(R.id.tv_item_10)
    TextView tvItem10;
    TextView[] allTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });
        allTextViews = new TextView[10];
        allTextViews[0] = tvItem1;
        allTextViews[1] = tvItem2;
        allTextViews[2] = tvItem3;
        allTextViews[3] = tvItem4;
        allTextViews[4] = tvItem5;
        allTextViews[5] = tvItem6;
        allTextViews[6] = tvItem7;
        allTextViews[7] = tvItem8;
        allTextViews[8] = tvItem9;
        allTextViews[9] = tvItem10;

        if (savedInstanceState != null) {
            int countBack = 0;
            countBack = savedInstanceState.getInt(MY_COUNT);
            count = countBack;
            for (int i = 0; i < count; i++) {
                String itemKey = MY_ITEM + i;
                String itemVal = savedInstanceState.getString(itemKey);
                allTextViews[i].setText(itemVal);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MY_COUNT, count);
        for (int i = 0; i < count; i++) {
            String itemKey = MY_ITEM + i;
            String itemVal = allTextViews[i].getText().toString();
            outState.putString(itemKey, itemVal);
        }
    }

    private void launchActivity() {
        Intent intent = new Intent(this, ItemActivity.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(ItemActivity.EXTRA_REPLY);
                if (count < maxItems) {
                    allTextViews[count].setText(reply);
                    count++;
                } else {
                    Toast.makeText(this, "List Is Full", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
