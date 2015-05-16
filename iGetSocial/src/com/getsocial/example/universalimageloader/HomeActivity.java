/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.getsocial.example.universalimageloader;

import static com.getsocial.example.universalimageloader.Constants.IMAGES;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nostra13.universalimageloader.utils.L;
import com.getsocial.R;
import com.getsocial.example.universalimageloader.Constants.Extra;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class HomeActivity extends com.cds.consumer.BaseActivity  
	{

		private static final String TEST_FILE_NAME = "Universal Image Loader @#&=+-_.,!()~'%20.png";

		@Override
		public void onCreate(Bundle savedInstanceState)
			{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_home);

			}
 
		
		   

		// Intent intent = new Intent(this, ImageGridActivity.class);
		// intent.putExtra(Extra.IMAGES, IMAGES);
		// startActivity(intent);

		public void onImageListClick(View view)
			{
			Intent intent = new Intent(this, ImageListActivity.class);
			intent.putExtra(Extra.IMAGES, IMAGES);
			startActivity(intent);
			}

		public void onImageGridClick(View view)
			{
			Intent intent = new Intent(this, ImageGridActivity.class);
			intent.putExtra(Extra.IMAGES, IMAGES);
			startActivity(intent);
			}

		public void onImagePagerClick(View view)
			{
			Intent intent = new Intent(this, ImagePagerActivity.class);
			intent.putExtra(Extra.IMAGES, IMAGES);
			startActivity(intent);
			}

		public void onImageGalleryClick(View view)
			{
			Intent intent = new Intent(this, ImageGalleryActivity.class);
			intent.putExtra(Extra.IMAGES, IMAGES);
			startActivity(intent);
			}

		@Override
		public void onBackPressed()
			{
			imageLoader.stop();
			super.onBackPressed();
			}

		 

 

		
	}