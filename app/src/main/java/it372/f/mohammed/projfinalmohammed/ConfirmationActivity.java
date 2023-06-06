package it372.f.mohammed.projfinalmohammed;

//Fahad Mohammed
// Project Final
// June 8th, 2022

//Import Statements
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtSpice;
    private TextView txtChickenBurger;
    private TextView txtDineIn;
    private TextView txtNapkins;
    private TextView txtOrderTotal;
    private TextView txtRequest;
    private TextView txtLevel;
    private  TextView txtCheese;


    //this finds all the id for the private variables.
    //this also gets the information selected and entered from activity 1.
    //after getting all the information it displays it to activity 2.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Intent intent = getIntent( );
        String total = intent.getStringExtra("total");
        String [ ] fields = total.split(";");
        String name = fields[0];
        String level = fields[1];
        String chickenBurger = fields[2];
        String spice = fields[3];
        String cheese = fields[4];
        String dinein = fields[5];
        String napkin = fields[6];
        String request = fields[7];
        String orderTotal = fields[8];

        txtName = findViewById(R.id.txt_name);
        txtLevel = findViewById(R.id.txt_level);
        txtChickenBurger = findViewById(R.id.txt_chickenBurger);
        txtSpice = findViewById(R.id.txt_spice);
        txtCheese = findViewById(R.id.txt_cheese);
        txtDineIn = findViewById(R.id.txt_dineIn);
        txtNapkins = findViewById(R.id.txt_napkins);
        txtOrderTotal = findViewById(R.id.txt_orderTotal);
        txtRequest = findViewById(R.id.txt_request);
        txtName.setText("Name : " + name);
        txtLevel.setText("Burger Level : " + level);
        txtChickenBurger.setText("Burger Type : " + chickenBurger);
        txtSpice.setText("Spice Level : " + spice);
        txtCheese.setText("Selected : " + cheese);
        txtDineIn.setText("DineIn or Togo : " + dinein);
        txtNapkins.setText("Extra Napkins : " + napkin);
        txtRequest.setText("Special Request is: " + request);
        txtOrderTotal.setText("Your Order Total: " + "$" +orderTotal);


    }


}