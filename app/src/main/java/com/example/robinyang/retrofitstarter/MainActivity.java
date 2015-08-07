package com.example.robinyang.retrofitstarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.robinyang.retrofitstarter.httpmodel.CoffeeShop;
import com.google.gson.Gson;
import com.mj.core.util.L;


import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBtnGet;
    Button mBtnPost;
    Button mBtnPut;
    Button mBtnDelete;
    EditText mEditText;
    TextView mTextView1;
    EditText mEtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGet = (Button) findViewById(R.id.btn_get);
        mBtnPost = (Button) findViewById(R.id.btn_post);
        mBtnPut = (Button) findViewById(R.id.btn_put);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mEditText = (EditText) findViewById(R.id.editText);
        mTextView1 = (TextView) findViewById(R.id.textview_1);
        mEtId = (EditText) findViewById(R.id.et_id);
        mBtnGet.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);
        mBtnPut.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                asyncGet();
                break;
            case R.id.btn_post:
                asyncPost(mEditText.getText().toString().trim());
                break;
            case R.id.btn_put:
                asyncPut(mEditText.getText().toString().trim());
                break;
            case R.id.btn_delete:
                asyncDelete(Integer.valueOf(mEtId.getText().toString().trim()));
                break;
        }
    }

    private void asyncGet() {
        RestClient.getService().getCoffeeShop(new Callback<List<CoffeeShop>>() {
            @Override
            public void success(List<CoffeeShop> coffeeShops, Response response) {
                L.d(coffeeShops);
                mTextView1.setText("asnycGet: " + coffeeShops.toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void asyncPost(String requestData) {
        L.d(requestData);
        CoffeeShop coffeeShop = new Gson().fromJson(requestData, CoffeeShop.class);
        RestClient.getService().postCoffeeShop(coffeeShop, new Callback<CoffeeShop>() {
            @Override
            public void success(CoffeeShop coffeeShop, Response response) {
                L.d(coffeeShop);
                mTextView1.setText("asnycPost: " + coffeeShop.toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void asyncPut(String requestData) {
        RestClient.getService().putCoffeeShop(new Gson().fromJson(requestData, CoffeeShop.class),
                new Callback<CoffeeShop>() {
                    @Override
                    public void success(CoffeeShop coffeeShop, Response response) {
                        L.d(coffeeShop);
                        mTextView1.setText("asnycPut: " + coffeeShop.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        L.d(error.getMessage());
                    }
                });
    }

    private void asyncDelete(int id) {
        RestClient.getService().deleteCoffeeShop(id, new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {
                L.d(response.getStatus());
            }

            @Override
            public void failure(RetrofitError error) {
                L.d(error.getMessage());
            }
        });
    }
}
