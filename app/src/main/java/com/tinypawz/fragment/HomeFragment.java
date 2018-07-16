package com.tinypawz.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinypawz.R;
import com.tinypawz.adapter.DogCategoryAdapter;
import com.tinypawz.model.DogCategoryModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView _rvDrawerLayout;
    private DogCategoryAdapter _dogAdapter;
    private ArrayList<DogCategoryModel> _listDogs = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        prepareData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        _rvDrawerLayout = view.findViewById(R.id.rv_category);

        _dogAdapter = new DogCategoryAdapter(_listDogs);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        _rvDrawerLayout.setLayoutManager(mLayoutManager);
        _rvDrawerLayout.setItemAnimator(new DefaultItemAnimator());
        _rvDrawerLayout.setAdapter(_dogAdapter);

        _rvDrawerLayout.addOnItemTouchListener(new DogCategoryAdapter.RecyclerTouchListener(getActivity(), _rvDrawerLayout, new DogCategoryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.d(TAG, "category list clicked");

                //new fragment starts
              /*  OfferFragment offerFragment = new OfferFragment();
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.frag_container, offerFragment);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();*/
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // TODO -- implementation of OnFragmentInteractionListener
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void prepareData() {
        DogCategoryModel dogCategoryModel = new DogCategoryModel("Dog\nFood", "description", R.drawable.dog_food);
        _listDogs.add(dogCategoryModel);

        dogCategoryModel = new DogCategoryModel("Dog\nAccessories", "description", R.drawable.dog_accessories);
        _listDogs.add(dogCategoryModel);

        dogCategoryModel = new DogCategoryModel("Dog\nGrooming", "description", R.drawable.dog_grooming);
        _listDogs.add(dogCategoryModel);

        dogCategoryModel = new DogCategoryModel("Dog\nSupplies", "description", R.drawable.dog_supplies);
        _listDogs.add(dogCategoryModel);
    }
}
