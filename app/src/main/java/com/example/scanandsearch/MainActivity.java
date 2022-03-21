package com.example.scanandsearch;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1;
    private ImageView captureIV;
    private Button snapBtn, getSearchBtnResultsBtn;
    private RecyclerView resultsRv;
    public SearchRVAdapter searchRVAdapter;
    public ArrayList<Search> searchRVModalArrayList;
    private ProgressBar loadingPB;
    private Bitmap imageBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        captureIV = findViewById(R.id.image);
        snapBtn = findViewById(R.id.idBtnSnap);
        getSearchBtnResultsBtn = findViewById(R.id.idBtnResults);
        resultsRv = findViewById(R.id.idRVSearchResults);
        searchRVModalArrayList = new ArrayList<>();
        searchRVAdapter = new searchRVAdapter(this, searchRVModalArrayList);
        resultsRv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        resultsRv.setAdapter(searchRVAdapter);
        loadingPB = findViewById(R.id.idPBLoading);
        snapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchRVModalArrayList.clear();
                searchRVAdapter.notifyDataSetChanged();
                takePictureIntent();
            }
        });


        getSearchBtnResultsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }



}

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
        Bundle extras = data.getExtras();
        imageBitmap = (Bitmap) extras.get("data");
        captureIV.setImageBitmap(imageBitmap);
    }

}

private void takePictureIntent() {

    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (i.resolveActivity(getPackageManager() != null)){
        startActivityForResult(i,REQUEST_CODE);
    }
}
import android.content.Intent;
        import android.graphics.Bitmap;
        import android.os.Bundle;
        import android.provider.MediaStore;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.google.firebase.ml.vision.common.FirebaseVisionImage;

        import ...
        }