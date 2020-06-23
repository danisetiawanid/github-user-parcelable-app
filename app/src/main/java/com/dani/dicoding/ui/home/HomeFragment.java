package com.dani.dicoding.ui.home;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.dani.dicoding.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    View v;
    private RecyclerView rvHeroes;
    private String[] dataUsername;
    private String[] dataName;
    private String[] dataLocation;
    private String[] dataRepository;
    private String[] dataCompany;
    private String[] dataFollowers;
    private String[] dataFollowing;
    private TypedArray dataAvatar;
    private ArrayList<Hero> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_home,container,false);
        rvHeroes = (RecyclerView) v.findViewById(R.id.rv_heroes);
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHeroes.setAdapter(listHeroAdapter);
        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
        return v;




    }

    private void showSelectedHero(Hero hero) {
        Intent intent = new Intent(getActivity(), HeroesDetails.class);
        intent.putExtra(HeroesDetails.EXTRA_HERO, hero);
        startActivity(intent);
        Toast.makeText(getActivity(), "Kamu memilih user " + hero.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepare();
        addItem();


    }
    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataLocation = getResources().getStringArray(R.array.location);
        dataRepository = getResources().getStringArray(R.array.repository);
        dataCompany = getResources().getStringArray(R.array.company);
        dataFollowers = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);

    }

    private void addItem() {
        list = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setAvatar(dataAvatar.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setUsername(dataUsername[i]);
            hero.setLocation(dataLocation[i]);
            hero.setRepository(dataRepository[i]);
            hero.setCompany(dataCompany[i]);
            hero.setFollowers(dataFollowers[i]);
            hero.setFollowing(dataFollowing[i]);
            list.add(hero);
        }

}}


