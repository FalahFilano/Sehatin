package com.kamurapi.sehatin;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.filano.sehatin.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button button_mulai;
    private boolean state=false;
    RecyclerView recyclerView;
    ArrayList<ActivityItem> itemList2;
    private BottomNavigationView mMainNav;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);

        button_mulai = (Button) rootView.findViewById(R.id.mulai_activity);
        mMainNav = (BottomNavigationView) rootView.findViewById(R.id.mainNav);
        TextView up_flag;
        String up_flag2;
        up_flag = rootView.findViewById(R.id.detailflag);


        recyclerView = rootView.findViewById(R.id.rvhome);
        itemList2 = new ArrayList<>();
        itemList2.add(new ActivityItem("1",getResources().getDrawable(R.drawable.cycle,null),"Bersepeda","TRAIN","250","20",
                "Bersepeda adalah salah satu cara termudah untuk menyesuaikan latihan dalam rutinitas harian Anda karena itu juga merupakan bentuk transportasi. Menghemat uang Anda, membuat lingkungan menjadi lebih baik. Transportasi sehari-hari dengan menggunakan sepeda merupakan putusan yang terbaik, hal ini karena terdapat banyak manfaat bersepeda untuk kesehatan tubuh.\n" +
                        "\n" +
                        "Bersepeda merupakan jenis olahraga ringan, sehingga lebih mudah untuk dilakukan dan dapat menjaga kesehatan sendi. Bersepeda juga dapat membantu mendapatkan bentuk tubuh.\n",
                "Latihan Teratur \n" + "Istirahat Cukup \n" + "Pengaturan Posisi Gir Sepeda \n" + "Mengonsumsi Makanan Serat Tinggi \n" + "Mengayuh secara Tetap dan Stabil"
                ));
        itemList2.add(new ActivityItem("2",getResources().getDrawable(R.drawable.jogging,null),"Lari","TRAIN","100","45",
                "Lari merupakan olahraga yang simpel dan hemat biaya karena Anda tidak memerlukan pelatih dan tidak harus pergi ke gym untuk berlari, yang Anda butuhkan hanyalah  jalur kosong di mana Anda dapat berlari.",
                "Sprint dengan jari kaki menghadap ke langitayunkan tangan sekencang mungkin, Posisi kaki seperti pergerakan jarum jam , Ganti-ganti kecepatan lari Anda"));
        itemList2.add(new ActivityItem("3", getResources().getDrawable(R.drawable.situp,null),"Sit Up","TRAIN","100","10",
                "Sit up adalah latihan resistensi bagian otot, khususnya otot perut dengan cara membaringkan diri pada sebuah media, baik media matras maupun langsung di lantai atau tanah. Pengertian sit up yakni sebuah gerakan yang bertumpu pada pinggul dan bokong kita dengan lutut yang diarahkan ke atas.",
                "Berbaringlah telentang sambil menekuk kedua lutut.  \n" +
                        "Sentuhkan ujung jari tangan di belakang telinga. \n" +
                        "Bangunkan tubuh dari lantai lalu dekatkan dada ke paha. \n" +
                        "Turunkan lagi tubuh ke lantai ke posisi semula. \n" +
                        "Lakukan sit up 3 set masing-masing 10-15 kali." ));


        state=true;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager rvHomeLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvHomeLayoutManager);

        HomeAdapter adapter = new HomeAdapter(getContext(),itemList2);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public void OnResume(){

    }

}
