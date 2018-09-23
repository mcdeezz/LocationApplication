package com.example.micha.locationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class Soweto extends Fragment implements AdapterView.OnItemClickListener {

    ArrayList<Location> locations;
    private final String POSITIONS = "position",
            DESCRIPTION = "description",
            PHONE = "phone",
            NAME = "name",
            STREET_ADDRESS = "street",
            SUBURB_ADDRESS = "suburb",
            IMAGE = "image";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.soweto_layout,
                container,
                false
        );
        assignLocationValuesToTheArrayList();
        LocationAdapter adapter = new LocationAdapter(
                getContext(),
                locations
        );
        ListView listView = view.findViewById(R.id.soweto_list_item_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    /*
       if an item is clicked we must display full information about the individual object on a separate layout

    */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getContext(), CustomLocationActivity.class)
                .putExtra(POSITIONS, position)
                .putExtra(IMAGE, locations.get(position).getmIcon())
                .putExtra(DESCRIPTION, locations.get(position).getmDescription())
                .putExtra(PHONE, locations.get(position).getmContactNumbers())
                .putExtra(NAME, locations.get(position).getmLocationName())
                .putExtra(STREET_ADDRESS, locations.get(position).getmStreetAddress())
                .putExtra(SUBURB_ADDRESS, locations.get(position).getmSuburbAddress())
        );
    }

    /*
        Initializing the array list

     */
    private void assignLocationValuesToTheArrayList() {
        locations = new ArrayList<>();
        locations.add(new Location(
                        "8287 Khumalo Rd, Orlando West",
                        "Hector Pieterson Museum",
                        "Soweto, 1804",
                        "The Hector Pieterson Museum is a large museum located in Orlando West, Soweto, South Africa, two blocks away from where Hector Pieterson was shot and killed. The museum is named in his honour. It became one of the first museums in Soweto when it opened on 16 June 2002. ",
                        "011 536 0611",
                        R.drawable.hector_peterson,
                        R.drawable.hector_peterson_two
                )
        );
        locations.add(new Location(
                        "8115 Vilakazi St, Orlando West",
                        "Nelson Mandela's House",
                        "Soweto, 1804",
                        "Heritage museum in Soweto, South Africa",
                        "011 936 7754",
                        R.drawable.nelson_mandels_house,
                        R.drawable.mandels_house_two
                )
        );
        locations.add(new Location(
                        " Cnr Klipspruit Valley Road & Union Road Kliptown",
                        "Walter Sisulu Square",
                        "Soweto, 1809",
                        "Walter Sisulu Square, formally known as the Walter Sisulu Square of Dedication, is located in the heart of Kliptown in Soweto, South Africa",
                        "011 945 2200",
                        R.drawable.walter_sisulu_square,
                        R.drawable.walter_sisulu_square_two
                )
        );
        locations.add(new Location(
                        "635B Zone 3, Nakedi St, Meadowlands",
                        "Naledi backpackers and Soweto Quad bike Tours",
                        "Soweto, 1852",
                        "Promoting a healthy life style of bieng active",
                        "011 936 4116",
                        R.drawable.naledi_backpackers,
                        R.drawable.naledi_backpackers_two
                )
        );
        locations.add(new Location(
                        "7481 Litabe St, Orlando",
                        "Cycle in Soweto",
                        "Soweto, 1804",
                        "Customer support selling cell phones and sim cards",
                        "079 817 4674",
                        R.drawable.cycle_in_soweto,
                        R.drawable.cycle_in_soweto_two
                )
        );

        locations.add(new Location(
                        "Chris Hani Rd, Klipspruit 318-Iq",
                        "Orlando Power Station",
                        "Soweto, 1809",
                        "Orlando Power Station is a decommissioned coal-fired power station in Soweto, South Africa. The power station was commissioned at the end of the Second World War and served Johannesburg for over 50 years.",
                        "071 674 4343",
                        R.drawable.twin_towers,
                        R.drawable.twin_towers_two
                )
        );
        locations.add(new Location(
                        "991 Bochabela St, Jabavu",
                        "Credo Mutwa Culture Village",
                        "Soweto, 1809",
                        "Outdoor museum devoted to the sculptures & other works of artist & traditional healer Credo Mutwa",
                        "011 492 1100",
                        R.drawable.credo_mutwa_culture_village,
                        R.drawable.credo_mutwa_culture_village_two
                )
        );
        locations.add(new Location(
                        "Pela St, Orlando West",
                        "Ubuntu Soweto Tours",
                        "Soweto, 1804",
                        "Bringing soweto to the world",
                        "079 897 5385",
                        R.drawable.tourism_soweto,
                        R.drawable.tourism_soweto_two
                )
        );
    }
}
