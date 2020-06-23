package com.dani.dicoding.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dani.dicoding.R;
import com.dani.dicoding.ui.MainActivity;



public class HeroesDetails extends AppCompatActivity {
    private TextView name, username,location,repository,company,followers,following ;
    private ImageView avatar;
    public static final String EXTRA_HERO = "extra_hero";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_githubdetail);
        name = findViewById(R.id.tv_name);
        username = findViewById(R.id.tv_username);
        location = findViewById(R.id.tv_location);
        repository = findViewById(R.id.tv_repository);
        company = findViewById(R.id.tv_company);
        followers = findViewById(R.id.tv_followers);
        following = findViewById(R.id.tv_following);
        avatar = findViewById(R.id.img_item_photo);


//        PARCELABLE GET DATA

        Hero hero = getIntent().getParcelableExtra(EXTRA_HERO);
        String nama = hero.getName();
        String username = hero.getUsername();
        String location = hero.getLocation();
        String repository = hero.getRepository();
        String company = hero.getCompany();
        String followers = hero.getFollowers();
        String following = hero.getFollowing();


        int gambar = hero.getAvatar();
        name.setText(nama);
        this.username.setText(username);
        this.location.setText(location);
        this.repository.setText(repository);
        this.company.setText(company);
        this.followers.setText(followers);
        this.following.setText(following);
        avatar.setImageResource(gambar);

    }

    public void pindahkehome(View view) {
        Intent intent = new Intent(HeroesDetails.this, MainActivity.class);
        startActivity(intent);
    }
}
