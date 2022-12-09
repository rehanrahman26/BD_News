package com.mahabub.bdnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ImageView image;
    ArrayList< HashMap<String,String> >arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        image = findViewById(R.id.Imagebutton);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,OtherNews.class));
            }
        });



        createTable();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);



    }



    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.item,viewGroup,false);

            ImageView itemCover = myView.findViewById(R.id.itemCover);
            TextView itemCat = myView.findViewById(R.id.itemCat);
            TextView itemTitle = myView.findViewById(R.id.itemTitle);
            TextView itemDes = myView.findViewById(R.id.itemDes);
            LinearLayout layItem = myView.findViewById(R.id.layItem);




            HashMap <String,String> hashMap = arrayList.get(position);
            String cat = hashMap.get("cat");
            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String des = hashMap.get("des");

            Picasso.get().load(image_url)
                    .placeholder(R.drawable.thumb)
                    .into(itemCover);

            itemCat.setText(cat);
            itemTitle.setText(title);
            itemDes.setText(des);


            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCat.setBackgroundColor(color);



            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewsDetails.TITLE = title;
                    NewsDetails.DESCRIPTION = des;

                    Bitmap bitmap = ((BitmapDrawable) itemCover.getDrawable()).getBitmap();
                    NewsDetails.MY_BITMAP = bitmap;

                    startActivity( new Intent(MainActivity.this,NewsDetails.class));
                }
            });


            return myView;
        }
    }

    //=========================================================
    //=========================================================

     private void createTable(){
        hashMap = new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/07/ফেসবুক-প্রফেশনাল-মুড-আসলে-কী.jpg");
        hashMap.put("title","ফেসবুকে বন্ধু বাড়ানোর উপায়");
        hashMap.put("des","সোশ্যাল মিডিয়াগুলোর মধ্যে জনপ্রিয়তার শীর্ষে আছে ফেসবুক। সবচেয়ে পুরোনো এবং জনপ্রিয় এই প্ল্যাটফর্মে ব্যবহারকারী আছে পুরো বিশ্বেই। স্মার্টফোন ব্যবহারকারীদের সিংহভাগই ফেসবুক ব্যবহার করছেন। প্রিয়জনের সঙ্গে চ্যাট হোক বা অপরিচিতের সঙ্গে বন্ধুত্ব তৈরি সব কিছুতেই এগিয়ে রয়েছে প্ল্যাটফর্মটি।\n" +
                "এমনকি নিয়মিত কন্টেন্ট রেকমেন্ডেশন অ্যালগরিদমে পরিবর্তন করে এই সোশ্যাল মিডিয়া জায়ান্ট। যার ফলে পছন্দের কন্টেন্ট পাবেন আপনার ফিডে। আর সেকারণেই জনপ্রিয়তার শীর্ষে পৌঁছে গেছে এই সোশ্যাল মিডিয়া প্ল্যাটফর্ম। এছাড়া কন্টেন্ট ক্রিয়েট করে আয়ও করা যায় ফেসবুকের মাধ্যমে।\n" +
                "বিভিন্ন উদ্দেশ্য থাকলেও, মূলত বন্ধুত্ব তৈরি এবং তাদের সঙ্গে তথ্য আদানপ্রদাণই ফেসবুকের প্রধান উদ্দেশ্য। তবে অনেকেই আছেন যারা দীর্ঘদিন ধরে ফেসবুক ব্যবহার করলেও সেভাবে ফ্রেন্ড রিকোয়েস্ট গ্রহণ করেন না বা ফ্রেন্ড রিকোয়েস্ট পাঠালেও অনেকেই তা ক্যানসেল করেন।\n");
        arrayList.add(hashMap);



         hashMap = new HashMap<>();
         hashMap.put("cat","TECH");
         hashMap.put("image_url","https://images.prothomalo.com/prothomalo-bangla%2F2022-11%2F0fe8920c-e9b9-41e6-86e0-c48187d028a1%2Fnasa_1.jpg");
         hashMap.put("title","মহাজাগতিক মেঘের চোখধাঁধানো ছবি তুলে চমক জেমস ওয়েবের");
         hashMap.put("des","মহাজাগতিক মেঘের অসাধারণ ছবি তুলে আবার চমক দিল যুক্তরাষ্ট্রের মহাকাশ গবেষণাপ্রতিষ্ঠান নাসার জেমস ওয়েব টেলিস্কোপ। গত বুধবার নাসার পক্ষ থেকে ওই ছবি উন্মুক্ত করা হয়েছে। ছবিতে কমলা এবং নীল ধুলার তৈরি বালুঘড়ির মতো একটি দৃশ্য ফুটে ওঠে। এই মেঘের কেন্দ্রে একটি নবীন নক্ষত্র তৈরি হচ্ছে। \n" +
                 "রঙিন এই মেঘ কেবল ইনফ্রারেড আলোতেই দৃশ্যমান হয়। তাই এর আগে এ ধরনের মেঘের ছবি সামনে আসেনি। কিন্তু জেমস ওয়েব টেলিস্কোপে থাকা নিয়ার-ইনফ্রারেড ক্যামেরায় প্রথমবারের মতো অসাধারণ এই ছবি ধারণ করা সম্ভব হয়েছে। নাসা ও ইউরোপিয়ান স্পেস এজেন্সির পক্ষ থেকে এক বিবৃতিতে এ তথ্য জানানো হয়েছে। \n" +
                 "এই মহাজাগতিক মেঘের কেন্দ্রে যে নবীন নক্ষত্রের জন্ম হচ্ছে, সেটি ‘প্রোটোস্টার এল১৫২৭’ নামে পরিচিত। এটি বালুঘড়িসদৃশ ওই মেঘের এক প্রান্তে ঘূর্ণমান মেঘের চাকতির অন্ধকারে ছিল। কিন্তু এর প্রান্ত দিয়ে যে আলোকচ্ছটা বের হচ্ছিল, তা ওই মেঘের ওপর পড়ে আলোকিত করে রেখেছে।\n" +
                 "নাসার বিবৃতিতে বলা হয়, এই মেঘ সৃষ্টি হয়েছে নক্ষত্রের সঙ্গে এর আশপাশের বস্তুর সংঘর্ষের ফলে। নীল রঙের অংশে ধুলার স্তর অত্যন্ত হালকা আর কমলা রঙের অংশে অত্যন্ত ভারী। এ প্রোটোস্টারের বয়স এক লাখ বছরের সমান। এটি তৈরির প্রাথমিক পর্যায়ে রয়েছে বলে এখনো এর নিজস্ব জ্বালানি তৈরি হয়নি।\n" +
                 "এর চারপাশে ঘিরে থাকা আমাদের সৌরজগতের সমান কালো চাকতিটিই নক্ষত্রটিকে শক্তি জোগাবে এবং ভবিষ্যতে পারমাণবিক বিক্রিয়া শুরু করবে। বিজ্ঞানীরা বলেন, ‘এই নক্ষত্রের গঠন দেখে আমাদের সৌরজগৎ প্রাথমিক অবস্থায় কেমন ছিল সে বিষয়ে ধারণা পাওয়া যায়। পৃথিবী থেকে ৪৩০ আলোকবর্ষ দূরের নক্ষত্রের আঁতুড়ঘর হিসেবে পরিচিত টার্টারাস নক্ষত্রপুঞ্জে এর অবস্থান।’\n");
         arrayList.add(hashMap);







         hashMap = new HashMap<>();
         hashMap.put("cat","BUSINESS");
         hashMap.put("image_url","https://images.prothomalo.com/prothomalo%2Fimport%2Fmedia%2F2017%2F09%2F27%2F4020470a97ed1672dc21c495ddcf2761-59cb69cd9a657.jpg");
         hashMap.put("title","টুইটারে বড় আকারের লেখা পোস্টের সুযোগ আসছে");
         hashMap.put("des","২৮০ অক্ষরের মধ্যে বার্তা লেখার বিধিনিষেধ রয়েছে টুইটারে। ফলে ইচ্ছা থাকলেও বড় পোস্ট করতে পারেন না টুইটার ব্যবহারকারীরা। বিষয়টি অজানা নয় টুইটারের নতুন মালিক ও প্রধান নির্বাহী কর্মকর্তা ইলন মাস্কের কাছে। আর তাই এক টুইটে তিনি জানিয়েছেন, শিগগিরই ২৮০ অক্ষরের বিধিনিষেধ তুলে নেবে টুইটার। ফলে ব্যবহারকারী চাইলেই ইচ্ছামতো বড় বার্তা বা প্রবন্ধ টুইটারে পোস্ট করতে পারবেন।\n" +
                 "উল্লেখ্য, ২০০৬ সালে টুইটার চালুর সময় মাত্র ১৪০ অক্ষরের বার্তা বিনিময়ের সুযোগ মিলত। তবে ব্যবহারকারীদের কাছে বড় পোস্টের চাহিদা থাকায় ২০১৮ সালে অক্ষরের সংখ্যা ২৮০ করে টুইটার। এবার মাস্কের এ ঘোষণার পর নির্দিষ্ট অক্ষরের মধ্যে বার্তা লেখার বিধিনিষেধ পুরোপুরি তুলে নিতে পারে খুদে ব্লগ লেখার সাইটটি।\n" +
                 "গত ফেব্রুয়ারি মাসে ২৮০ অক্ষরের বিধিনিষেধ শিথিলের উদ্যোগ নিয়েছিল টুইটার। এ জন্য ‘টুইটার আর্টিকেল’ নামের নতুন সুবিধা চালুর লক্ষ্যে কাজও শুরু করেছিলেন টুইটারের কর্মীরা। কিন্তু এখন পর্যন্ত সুবিধাটি চালু না হওয়ায় ২৮০ অক্ষরের মধ্যেই টুইটারে বার্তা বিনিময় করতে হয়।\n" +
                 "সূত্র: মেইল অনলাইন\n");
         arrayList.add(hashMap);









         hashMap = new HashMap<>();
         hashMap.put("cat","SPORTS");
         hashMap.put("image_url","https://images.prothomalo.com/prothomalo-bangla%2F2022-03%2F162d7dc6-c24e-41d8-b544-b8e7f1a03c02%2Fr.JPG");
         hashMap.put("title","ইউনাইটেড থেকে বের হওয়ার রাস্তা খুঁজতেই রোনালদোর এমন সাক্ষাৎকার");
         hashMap.put("des","পিয়ার্স মরগানকে দেওয়া সাক্ষাৎকারে ক্রিস্টিয়ানো রোনালদো যাঁদের সমালোচনা করেছিলেন, তাঁদের একজন ম্যানচেস্টার ইউনাইটেডের সাবেক ডিফেন্ডার গ্যারি নেভিল। রোনালদো বলেছিলেন, ‘আমরা একসঙ্গে খেললেও বন্ধু নই।’ \n" +
                 "ম্যানচেস্টার ইউনাইটেডের সাবেক এই ফুটবলার বরাবরই রোনালদোর কট্টর সমালোচক। খেলা শেষ হওয়ার আগেই মাঠ ছাড়ার ঘটনাতেও পর্তুগিজ তারকার সমালোচনা করেছিলেন নেভিল। নেভিলের সমালোচনা রোনালদো যে খুব একটা ভালোভাবে নেন না, তা এখন স্পষ্ট।\n" +
                 "রোনালদোর মুখে নিজের সমালোচনা শুনলেও দমে যাননি নেভিল। রোনালদো ইস্যুতে আবারও সরব ইউনাইটেডের সাবেক এই তারকা। নেভিলের মতে, ক্লাব ছাড়ার উপায় খুঁজতেই  নাকি এমন সাক্ষাৎকার দিয়েছেন রোনালদো। স্কাই স্পোর্টসকে তিনি বলেছেন, ‘আমার মনে হয় না, সে ম্যানচেস্টার ইউনাইটেডে আর ফিরতে চায়। ফিরতে চাইলে সে কখনোই এমন সাক্ষাৎকার দিত না। সে জানত, তার কথা এভাবে আলোচনায় আসবে, যে কারণে তার ম্যানচেস্টার ইউনাইটেডে অধ্যায়ও শেষ হবে।’\n" +
                 "চলতি মৌসুমে কোচ টেন হাগ ইউনাইটেডে যোগ দেওয়ার পর থেকেই রোনালদোর সঙ্গে বনিবনা হচ্ছে না। প্রাক্\u200C-মৌসুম পর্বে রোনালদোর অনুপস্থিতি দিয়ে যার শুরু, সেই সম্পর্ক পরবর্তী সময়ে পরিণত হয়েছে তিক্ততায়। চলতি মৌসুমে বেশির ভাগ ম্যাচেই শুরুর একাদশে জায়গা পাননি রোনালদো। এত টানাপোড়েনের কারণে রোনালদোর সঙ্গে ইউনাইটেডের সম্পর্ক যে টিকবে না, সেটা অনেকটা নিশ্চিতই ছিল।\n");
         arrayList.add(hashMap);







         hashMap = new HashMap<>();
         hashMap.put("cat","FASHION");
         hashMap.put("image_url","https://images.prothomalo.com/prothomalo-bangla%2F2022-11%2F23970240-1990-4d16-809c-ade0a9693a99%2FKabir_Hossain_01_100.jpg");
         hashMap.put("title","বিয়ের সাজে যে পরিবর্তনগুলো নজর কাড়ছে");
         hashMap.put("des","কয়েক বছর ধরেই বিয়ের সাজে এসেছে অনেক পরিবর্তন। ঐতিহ্যের সঙ্গে আধুনিকতার মেলবন্ধনে সেজে উঠছেন এখনকার কনেরা। বউসাজ মানেই খুব জমকালো হবে, এই ধারাটি তো ভেঙেছেই। সেই সঙ্গে শাড়ি, গয়না, মেকআপ—সবকিছুতেই হালকা স্নিগ্ধ বিষয়কে এখন প্রাধান্য দেওয়া হচ্ছে।\n" +
                 "চলুন, দেখে নিই গত কয়েক বছরে বউসাজে নতুন কী কী সংযুক্ত হয়েছে, তারই এক ঝলক।\n" +
                 "তাজা ফুল দিয়েই তৈরি হচ্ছে কনের ওড়না। গায়েহলুদের অনুষ্ঠানে বেশ জনপ্রিয় এমন ওড়নার ব্যবহার।সোনার বালা নয়তো সোনালি চুড়ি—এভাবেই তো সাজবে নতুন কনের হাত, এমনটাই ভাবনায় থাকে সবার। তবে সেই ধারা ভেঙে কনেরা এখন অনায়াসেই পরছেন কাচের চুড়ি। হাতভর্তি ভারী গয়নার পরিবর্তে বরং কাচের চুড়ির নান্দনিক সাজে যেন ফুটে উঠবে তাঁর আসল সৌন্দর্য।\n" +
                 "বিয়ে বা গায়েহলুদে কনেরা এখন কেডসও পরছেন। স্বাচ্ছন্দ্যের পাশাপাশি যোগ হচ্ছে স্টাইল স্টেটমেন্ট।\n");
         arrayList.add(hashMap);




         hashMap = new HashMap<>();
         hashMap.put("cat","ENTERTAINMENT");
         hashMap.put("image_url","https://images.prothomalo.com/prothomalo-bangla%2F2022-11%2F406139eb-4c43-4c47-b5fc-cef4d11ed14e%2F315643266_680777220076295_7581649037433286807_n.jpg");
         hashMap.put("title","সিডনির সকাল, সিডনির বিকেল");
         hashMap.put("des","চলচ্চিত্র ও টিভি নাটকের জনপ্রিয় অভিনেত্রী নুসরাত ইমরোজ তিশা তাঁর স্বামী নির্মাতা মোস্তফা সরয়ার ফারুকী ও মেয়ে ইলহামকে নিয়ে পারিবারিক ভ্রমণে এখন অস্ট্রেলিয়ায় আছেন। দেশটির সিডনি থেকে কয়েকটি ছবি ফেসবুকে পোস্ট করেছেন তিশা।\n" +
                 "অক্টোবর–নভেম্বর মাসে অস্ট্রেলিয়ার পথপ্রান্তর জ্যাকারান্ডা ফুলে ফুলে শোভিত সিডনিতে তোলা ছবি পোস্ট করে তিশা লিখেছেন, ‘পার্পেল সন্ধ্যা’\n" +
                 "সিডনিতে ছুটির আমেজে আছেন তিশা। সিডনি ভ্রমণ শেষে নিউজিল্যান্ডে যাওয়ার কথা রয়েছে তাঁদের\n");
         arrayList.add(hashMap);






         hashMap = new HashMap<>();
         hashMap.put("cat","SPORTS");
         hashMap.put("image_url","https://images.prothomalo.com/prothomalo-bangla%2F2022-11%2Ff4c5fc30-ef80-4d63-b8c6-c80fab045a4e%2FWorld_cup_____.jpg");
         hashMap.put("title","নতুন শতকে পাপমোচন, গৌরব আর গ্লানির গল্প");
         hashMap.put("des","ফুটবল এমন এক খেলা, যেখানে গোল হওয়া না–হওয়ার আনন্দ-বেদনার সঙ্গে জটিলতম সব ফরমেশন ও কৌশলের মজা পাওয়া যায়। যে যার জায়গা থেকে খেলাটাকে উপভোগ করতে পারার এই দুর্দান্ত সর্বজনীনতা খেলাটাকে দুনিয়ার সবচেয়ে জনপ্রিয় ইভেন্টে পরিণত করেছে। আর নিঃসন্দেহে ফুটবলের সবচেয়ে বড় আসর হলো বিশ্বকাপ ফুটবল। চার বছর পরপর হওয়া এই টুর্নামেন্টের সময় গোটা পৃথিবীর নজর থাকে কে জিতল, কে হারল। খেলাটির সব রকম মানবীয় আবেগকে ধারণ করার যে ক্ষমতা, এ কারণে বিশ্বকাপ ফুটবল শুধু হার-জিতের মধ্যে সীমাবদ্ধ নয়। এই ইতিহাস তো মানুষেরই ইতিহাস। কাতারে আর কিছুদিন পরই শুরু হবে বিশ্বকাপের ২২তম আসর। তার আগে ফিরে তাকিয়ে ২০০২ বিশ্বকাপের গল্প শোনা যাক।\n" +
                 "খ্রিষ্টীয় নতুন সহস্রাব্দটা দুনিয়ার মানুষের জন্য বড় কোনো সুসংবাদ বয়ে আনেনি। এর আগের শতকে দুই দুটি বিশ্বযুদ্ধ আর দীর্ঘ ঠান্ডা যুদ্ধের পর নতুন ধরনের মেরুকরণ দেখে দুনিয়া। যুক্তরাষ্ট্রের টুইন টাওয়ার হামলার প্রেক্ষাপটে তথাকথিত ‘ওয়ার অ্যাগেইনস্ট টেররিজমের’ নামে মার্কিনরা তাণ্ডব চালায় মধ্যপ্রাচ্যসহ দুনিয়ার নানা প্রান্তে। ধর্মের নামে, জাতের নামে মানুষের আদিম প্রবৃত্তির লড়াই চলতে থাকে আধুনিক যুগে এসেও।\n" +
                 "এই অশান্ত, ‘আমরা অথবা তোমরার’ দুনিয়ায় ফুটবল দিনকে দিন আরও আপন, এক হয়ে ওঠার উপলক্ষ হয়ে ওঠে। যদিও প্রতিদ্বন্দ্বিতার কদর্য ফুটবলকে কলুষিত করে প্রায়ই, যদিও একে আরও বেশি পণ্যে পরিণত করে নিজেদের পকেট ফুলিয়ে–ফাঁপিয়ে ওঠার সুযোগ পায় ফুটবলের মাফিয়ারা। কিন্তু সবশেষে ফুটবলের স্বপ্ন মানুষকে বাঁচিয়ে রাখে আশায়।\n" +
                 "আর নতুন সহস্রাব্দে সেই স্বপ্ন পূরণ করেছিলেন একজন ব্রাজিলীয়। পেলে আর ম্যারাডোনা ১০ নম্বর জার্সিকে করে তুলেছিলেন সবার প্রিয়, রোনালদো কিংবদন্তিতে পরিণত করলেন ৯ নম্বর জার্সিকে। আগের বিশ্বকাপের ফাইনালে রহস্যময় ঘটনাবলির মধ্যমণি, হেরে যাওয়া দলের রোনালদো এইবার দলকে পঞ্চম বিশ্বকাপ জেতাতে মূল ভূমিকা রাখলেন। নতুন সহস্রাব্দে, বিশ্বের সবচেয়ে জনবহুল মহাদেশ এশিয়ার প্রথম আয়োজন, জাপান-কোরিয়া ২০০২ বিশ্বকাপের নায়ক ছিলেন ফেনোমেনন পরিচয় পাওয়া এই গোলশিল্পী।\n");
         arrayList.add(hashMap);




     }



}