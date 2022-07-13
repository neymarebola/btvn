package com.example.btvn.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn.Adapter.ItemAdapter;
import com.example.btvn.ApiService.JsonplaceholderApi;
import com.example.btvn.R;
import com.example.btvn.models.Item;
import com.example.btvn.models.Root;
import com.example.btvn.utils.Credentials;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class choban_fragment extends Fragment {
    private TextView res;
    private RecyclerView itemRec;
    private JsonplaceholderApi newFeedApi;
    private List<Item> listItems;
    private ItemAdapter adapter;

    public choban_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        newFeedApi = retrofit.create(JsonplaceholderApi.class);
        getNewFeed();
        return inflater.inflate(R.layout.fragment_choban, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // hien thi retrofit danh sach cac item
        itemRec = view.findViewById(R.id.choban_fragment_rec);
        listItems = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        itemRec.setLayoutManager(layoutManager);
        adapter = new ItemAdapter(getContext(), listItems);
        itemRec.setAdapter(adapter);
    }

    public void getNewFeed() {
        Call<Root> call = newFeedApi.getListNewFeed();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (!response.isSuccessful()) {
                    res.setText(response.code() + "");
                    return;
                }
                Root root = response.body();
                listItems.clear();
                for (Item item : root.getItems()) {
                    listItems.add(item);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("tag", t.getMessage());
            }
        });
    }
}