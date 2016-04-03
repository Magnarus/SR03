package magnas.sr03.utils;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import magnas.sr03.model.Struct;
import magnas.sr03.network.ServiceGenerator;
import magnas.sr03.network.TrombiClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Gregory on 18/03/2016.
 */
public class StructItemSelectedListener implements AdapterView.OnItemSelectedListener{

    Spinner mSousStruct;
    public StructItemSelectedListener(Spinner sousStruct) {
        mSousStruct = sousStruct;
    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner)parent;
        Struct struct = (Struct) spinner.getSelectedItem();
        TrombiClient client = ServiceGenerator.createService(TrombiClient.class);
        client.sousstructs(struct.getStructure().getStructId(), new Callback<List<Struct>>() {
            @Override
            public void success(List<Struct> structs, Response response) {
                if(structs.size() > 0) {
                    structs.add(0, new Struct(-999));
                    mSousStruct.setVisibility(View.VISIBLE);
                    ArrayAdapter<Struct> dataAdapter = new ArrayAdapter<>(parent.getContext(),
                            android.R.layout.simple_spinner_item, structs);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    mSousStruct.setAdapter(dataAdapter);
                } else {
                    mSousStruct.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("StructItemSelectedListener.failure");
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
