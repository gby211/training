package com.example.p0761_tab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//
//    public class CollectionDemoFragment extends Fragment {
//        // When requested, this adapter returns a DemoObjectFragment,
//        // representing an object in the collection.
//        DemoCollectionAdapter demoCollectionAdapter;
//        ViewPager2 viewPager;
//
//        @Nullable
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                                 @Nullable Bundle savedInstanceState) {
//            return inflater.inflate(R.layout.collection_demo, container, false);
//        }
//
//        @Override
//        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//            demoCollectionAdapter = new DemoCollectionAdapter(this);
//            viewPager = view.findViewById(R.id.pager);
//            viewPager.setAdapter(demoCollectionAdapter);
//        }
//    }
//
//    public class DemoCollectionAdapter extends FragmentStateAdapter {
//        public DemoCollectionAdapter(Fragment fragment) {
//            super(fragment);
//        }
//
//        @NonNull
//        @Override
//        public Fragment createFragment(int position) {
//            // Return a NEW fragment instance in createFragment(int)
//            Fragment fragment = new DemoObjectFragment();
//            Bundle args = new Bundle();
//            // Our object is just an integer :-P
//            args.putInt(DemoObjectFragment.ARG_OBJECT, position + 1);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public int getItemCount() {
//            return 100;
//        }
//    }
//
//    // Instances of this class are fragments representing a single
//// object in our collection.
//    public class DemoObjectFragment extends Fragment {
//        public static final String ARG_OBJECT = "object";
//
//        @Nullable
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                                 @Nullable Bundle savedInstanceState) {
//            return inflater.inflate(R.layout.fragment_collection_object, container, false);
//        }
//
//        @Override
//        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//            Bundle args = getArguments();
//            ((TextView) view.findViewById(android.R.id.text1))
//                    .setText(Integer.toString(args.getInt(ARG_OBJECT)));
//        }
//    }
}