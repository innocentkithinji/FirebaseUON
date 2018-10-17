package er.lauch.simpleblog;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity {
    private static final int GALLERY_REQUEST = 1;
    private ImageButton postImage;
    private EditText postTitle;
    private EditText postBody;
    private FloatingActionButton fab;

    private Uri imageUri = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        postImage = findViewById(R.id.postImage);
        postTitle = findViewById(R.id.postTitle);
        postBody = findViewById(R.id.postBody);
        fab = findViewById(R.id.postDone_fab);

        //

        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });
    }

    private void startPosting() {
        String Title = postTitle.getText().toString().trim();
        String Body = postBody.getText().toString().trim();

        if(!isNull()){
            Toast.makeText(this, "Posting to blog", Toast.LENGTH_SHORT).show();
            //TODO: Post Image to Storage and add Link, Title and Description
        }
    }

    private boolean isNull() {
        String Title = postTitle.getText().toString().trim();
        String Body = postBody.getText().toString().trim();

        if (imageUri == null){
            Toast.makeText(this, "Please Select an Image", Toast.LENGTH_SHORT).show();
            return true;

        }
        if(TextUtils.isEmpty(Title)){
            postTitle.setError("Cannot be null");
            return true;
        }
        if(TextUtils.isEmpty(Body)){
            postBody.setError("Cannot be null");
            return  true;
        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
            imageUri = data.getData();
            postImage.setImageURI(imageUri);


        }
    }
}
