package com.example.gamer.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "extra_reply";
    public static String ITEM_CHEESE = "cheese";
    public static String ITEM_RICE = "rice";
    public static String ITEM_APPLES = "apples";
    public static String ITEM_STEAK = "steak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }

    public void addItem(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_add_cheese:
                returnItem(ITEM_CHEESE);
                break;
            case R.id.btn_add_rice:
                returnItem(ITEM_RICE);
                break;
            case R.id.btn_add_apples:
                returnItem(ITEM_APPLES);
                break;
            case R.id.btn_add_steak:
                returnItem(ITEM_STEAK);
                break;
        }
    }

    private void returnItem(String s) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, s);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
