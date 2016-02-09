package org.code_freak.com.get_images;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Get_Image extends AppCompatActivity {
    private static int RESULT_LOAD_IMG = 1;
    private static final int CAMERA_REQUEST = 12;
    String imgDecodableString;
    private ImageView ivGetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get__image_layout);
        ivGetImage = (ImageView) findViewById(R.id.ivGetImage);
        Intent data = getIntent(); //get the intent that starts this activity, in this case: gallery intent

        Intent incomingIntent = getIntent();
        try{
            Uri imageUri = (Uri) incomingIntent.getExtras().get(Intent.EXTRA_STREAM);
            ivGetImage.setImageURI(imageUri);
        }catch (NullPointerException ex){
            Log.e("kuldeep", ex.toString());
        }
    }
    public void PickFromGalary(View view){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }
    public void getImageFromCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST && resultCode==RESULT_OK) {


            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivGetImage.setImageBitmap(photo);
        }

        // When an Image is picked
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                && null != data) {
            // Get the Image from data

            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            // Get the cursor
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            //ImageView imgView = (ImageView) findViewById(R.id.i);
            // Set the Image in ImageView after decoding the String
            ivGetImage.setImageBitmap(BitmapFactory
                    .decodeFile(imgDecodableString));

        } else {
            Toast.makeText(this, "You haven't picked Image",
                    Toast.LENGTH_LONG).show();
        }

    }
    public void processImage(View view){
        switch (view.getId()){
            case R.id.btnGrey:
                ivGetImage.buildDrawingCache();
                Bitmap bitmap = ivGetImage.getDrawingCache();
                Bitmap bitmapResult = toGrayScale(bitmap);
                ivGetImage.setImageBitmap(bitmapResult);
                break;
            case R.id.btnBlue:
                ivGetImage.buildDrawingCache();
                Bitmap btmpBlue = ivGetImage.getDrawingCache();
                Bitmap btmpBlueRes = emboss(btmpBlue);
                ivGetImage.setImageBitmap(btmpBlueRes);
                break;
            case R.id.btnmagenta:
                ivGetImage.buildDrawingCache();
                Bitmap btmpMgenta = ivGetImage.getDrawingCache();
                Bitmap btmpMegRes = smooth(btmpMgenta,100);
                ivGetImage.setImageBitmap(btmpMegRes);
                break;
        }
    }
    private Bitmap toGrayScale(Bitmap bmpOriginal) {

        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }


    public static Bitmap emboss(Bitmap src) {
    double[][] EmbossConfig = new double[][] {
        { -1 ,  0, -1 },
        {  0 ,  4,  0 },
        { -1 ,  0, -1 }
    };
    ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
    convMatrix.applyConfig(EmbossConfig);
    convMatrix.Factor = 1;
    convMatrix.Offset = 127;
    return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);
}

    public void Animate(View view){
        switch (view.getId()){
            case R.id.btnAni1:
                ObjectAnimator obj1 = ObjectAnimator.ofFloat(ivGetImage,"translationX",10,0,90,898,76,90,78);
                obj1.setDuration(3000);
                obj1.start();
                Log.d("kuldeep", "animate 1 will display");
                break;
            case R.id.btnAni2:
                ObjectAnimator obj2 = ObjectAnimator.ofFloat(ivGetImage,"translationY",0,55,23,898,99,9,78);
                obj2.setDuration(5000);
                obj2.start();
                Log.d("kuldeep", "animate 2 will display");
                break;
            case R.id.btnAni3:
               Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
                animation.setDuration(1500);
                animation.start();
                ivGetImage.setAnimation(animation);
                Log.d("kuldeep","animate 3 will display");
                break;
        }
    }
    public static Bitmap smooth(Bitmap src, double value) {
        ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
        convMatrix.setAll(1);
        convMatrix.Matrix[1][1] = value;
        convMatrix.Factor = value + 8;
        convMatrix.Offset = 1;
        return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);
    }
}
