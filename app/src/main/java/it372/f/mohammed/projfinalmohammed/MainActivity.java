package it372.f.mohammed.projfinalmohammed;
//Fahad Mohammed
// Project Final
// June 8th, 2022
//Import Statements
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

//makes the variables private.
public class MainActivity extends AppCompatActivity {
    private EditText ordName;
    private Spinner spnMeatLevel;
    private Spinner spnSpiceLevel;
    private RadioButton chickenBurger;
    private RadioButton beefBurger;
    private RadioButton yesCheese;
    private RadioButton noCheese;
    private CheckBox chkDinein;
    private CheckBox chkCarryout;
    private CheckBox chkNapkins;
    private EditText specialRequest;
    private EditText search;
    private Button btnSearch;


    //this finds all the id for the private variables.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Checks is there was a saved instance state, if yes restore it. else runs with out checking it.
        if (savedInstanceState != null) {
            ordName = (EditText) savedInstanceState.get("ordName");
            spnSpiceLevel = (Spinner) savedInstanceState.get("spnSpiceLevel");
            spnMeatLevel = (Spinner) savedInstanceState.get("spnMeatLevel");
            chickenBurger = (RadioButton) savedInstanceState.get("chickenBurger");
            beefBurger = (RadioButton) savedInstanceState.get("beefBurger");
            yesCheese = (RadioButton) savedInstanceState.get("cheese");
            noCheese = (RadioButton) savedInstanceState.get("noCheese");
            chkDinein = (CheckBox) savedInstanceState.get("chkDinein");
            chkCarryout = (CheckBox) savedInstanceState.get("chkCarryout");
            chkNapkins = (CheckBox) savedInstanceState.get("chkNapkins");
            specialRequest = (EditText) savedInstanceState.get("specialRequest");
            search = (EditText) savedInstanceState.get("search");
            btnSearch = (Button) savedInstanceState.get("btnSearch");
        }
        else {
            ordName = findViewById(R.id.ord_name);
            spnMeatLevel = findViewById(R.id.spn_meatlevel);
            spnSpiceLevel = findViewById(R.id.spn_spicelevel);
            chickenBurger = findViewById(R.id.chicken_burger);
            beefBurger = findViewById(R.id.beef_burger);
            yesCheese = findViewById(R.id.cheese);
            noCheese = findViewById(R.id.no_cheese);
            chkDinein = findViewById(R.id.chk_dinein);
            chkCarryout = findViewById(R.id.chk_carryout);
            chkNapkins = findViewById(R.id.chk_napkins);
            specialRequest = findViewById(R.id.sp_request);
            search = findViewById(R.id.search);
            btnSearch = findViewById(R.id.btn_search);

        }
    }
    //public void onSaveInstanceState(Bundle saveInstanceState) {
    //   super.onSaveInstanceState(saveInstanceState);
    //    saveInstanceState.put("ordName", ordName);
    // }
    // }
    //This sees which option is selected for the items.
    //then relays the information to the second activity
    public void itemTotal(View view){
        String name = ordName.getText( ).toString( );
        int tax = 1;
        int chekPatty = 5;
        int OrderTotal = (chekPatty+tax);
        String chicken = chickenBurger.isChecked( ) ? "Chicken Burger" : "Beef Burger";
        String cheese = yesCheese.isChecked( ) ? "Cheese" : "No Cheese";
        String spice = spnSpiceLevel.getSelectedItem( ).toString( );
        String level = spnMeatLevel.getSelectedItem( ).toString( );
        String dinein = chkDinein.isChecked( ) ? "Dine In" : "Carry Out" ;
        String napkin = chkNapkins.isChecked( ) ? "Yes" : "No ";
        String request = specialRequest.getText( ).toString( );
        String total = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%d", name , level , chicken , spice , cheese , dinein , napkin , request , OrderTotal);
        Intent intent = new Intent(this, ConfirmationActivity.class);
        intent.putExtra("total",total);
        startActivity(intent);

    }



    // onClick event handler for the reset button.
    public void onClickReset(View view) {
        ordName.setText("");
        chickenBurger.setChecked(false);
        yesCheese.setChecked(false);
        spnMeatLevel.setSelection(0);
        spnSpiceLevel.setSelection(0);
        beefBurger.setChecked(false);
        chkDinein.setChecked(false);
        chkCarryout.setChecked(false);
        chkNapkins.setChecked(false);
        specialRequest.setText("");
        //resets all the values to default.
    }
}