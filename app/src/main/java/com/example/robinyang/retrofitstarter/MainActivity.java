package com.example.robinyang.retrofitstarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.robinyang.retrofitstarter.httpmodel.CoffeeShop;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mBtnGet;
    Button mBtnPost;
    Button mBtnPut;
    Button mBtnDelete;
    TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGet = (Button) findViewById(R.id.btn_get);
        mBtnPost = (Button) findViewById(R.id.btn_post);
        mBtnPut = (Button) findViewById(R.id.btn_put);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mTextView1 = (TextView) findViewById(R.id.textview_1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                break;
            case R.id.btn_post:
                break;
            case R.id.btn_put:
                break;
            case R.id.btn_delete:
                break;
        }
    }

    private void asyncGet() {
        RestClient.getService().getCoffeeShop(new Callback<List<CoffeeShop>>() {
            @Override
            public void success(List<CoffeeShop> coffeeShops, Response response) {
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
