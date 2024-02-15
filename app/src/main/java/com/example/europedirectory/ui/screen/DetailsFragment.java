package com.example.europedirectory.ui.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.europedirectory.databinding.FragmentDetailsBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DetailsFragment extends Fragment {

    String url;
    private FragmentDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            url = bundle.getString("1");
            String name = bundle.getString("2");
            String desc = bundle.getString("3");
            binding.descCountry.setText(desc);
            binding.nameCountry.setText(name);
        }
        binding.downloadCountry.setOnClickListener(v -> {
            binding.progress.setVisibility(View.VISIBLE);
            SingleOnSubscribe<String> singleOnSubscribe = emitter -> {
                emitter.onSuccess(getWeb());
                binding.progress.setVisibility(View.INVISIBLE);
            };
            Single<String> single = Single.create(singleOnSubscribe);
            single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(x ->binding.descCountry.setText(x));
        });
        return binding.getRoot();

    }
    private String getWeb() {
        try {
            Document document = Jsoup.connect(url).get();

            return document.head().html();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}