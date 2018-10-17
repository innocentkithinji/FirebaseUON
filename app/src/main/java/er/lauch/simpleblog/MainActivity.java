package er.lauch.simpleblog;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private RecyclerView blogs;
    //TODO: Config  firebase authentication and Firebase DB
    //TODO: Setup Login Providers.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: Check Current User and start Login Activity

        setContentView(R.layout.activity_main);
        blogs =  findViewById(R.id.blogRecyclerView);
        blogs.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = findViewById(R.id.add_Post_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(postIntent);
            }
        });

        //TODO: Show Blogs in the Recycler View;

    }


    @Override
    protected void onStart() {
        super.onStart();
        //TODO: create adpater
    }

    //TODO: create ViewHolder Class
}
