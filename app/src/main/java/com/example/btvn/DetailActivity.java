package com.example.btvn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.btvn.Adapter.SectionAdapter;
import com.example.btvn.ApiService.JsonplaceholderApi;
import com.example.btvn.models.Publisher;
import com.example.btvn.models.Root_detail;
import com.example.btvn.models.Section;
import com.example.btvn.utils.Credentials;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    TextView publisher, date, title, description;
    ImageView publisherIcon;
    RecyclerView sectionRec;
    List<Section> sectionList;
    SectionAdapter sectionAdapter;

    JsonplaceholderApi detailApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        detailApi = retrofit.create(JsonplaceholderApi.class);
        getDetail();
    }

    void getDetail() {
        Call<Root_detail> call = detailApi.getDetailNewFeed();
        call.enqueue(new Callback<Root_detail>() {
            @Override
            public void onResponse(Call<Root_detail> call, Response<Root_detail> response) {
                Root_detail root_detail = response.body();
                if (!response.isSuccessful()) {
                    return;
                }

                setDataText(root_detail);
                // display list section to recyclerView
                sectionList = new ArrayList<>();
                if (root_detail.getSections() != null &&  !root_detail.getSections().isEmpty()) {
                    sectionList.addAll(root_detail.getSections());
                }
                sectionAdapter = new SectionAdapter(getBaseContext(), sectionList);
                LinearLayoutManager manager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
                sectionRec.setLayoutManager(manager);
                sectionRec.setAdapter(sectionAdapter);
            }

            @Override
            public void onFailure(Call<Root_detail> call, Throwable t) {

            }
        });
    }

    void setDataText(Root_detail root) {
        Publisher publisher = root.getPublisher();
        String icon = publisher.getIcon();
        if (icon != null) {
            Glide.with(getBaseContext()).load(icon).into(publisherIcon);// icon nha xuat ban
        }
        if (publisher.getName() != null) {
            this.publisher.setText(publisher.getName());// ten nha xuat ban
        }
        if (root.getPublished_date() != null) {
            date.setText(root.getPublished_date());
        }
        if (root.getTitle() != null) {
            title.setText(root.getTitle());
        }
        if (root.getDescription() != null) {
            description.setText(root.getDescription());
        }
    }

    void initView() {
        publisher = findViewById(R.id.tv_publisher);
        date = findViewById(R.id.tv_date);
        title = findViewById(R.id.tv_title);
        publisherIcon = findViewById(R.id.publisher_icon);
        description = findViewById(R.id.tv_description);
        sectionRec = findViewById(R.id.section_rec);
    }
}