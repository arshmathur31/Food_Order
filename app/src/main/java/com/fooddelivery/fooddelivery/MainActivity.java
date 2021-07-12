package com.fooddelivery.fooddelivery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity
{
    TextView menu, btv, ptv, ntv, stv, dtv, wtv;
    TextView bptv, pptv, nptv, sptv, dptv, wptv;
    String choices = "";
    String prices, usd_price_string;
    double usd_price = 0;
    Button burger, pizza , noodles , sweet, drink, water;
    //removing button
    Button rm_burger, rm_pizza, rm_noodles, rm_sweet, rm_drink, rm_water, order;
    int bp = 0, pp = 0, np = 0, sp = 0, dp = 0, wp = 0;
    int tbp = 0, tpp = 0, tnp = 0, tsp = 0, tdp = 0, twp = 0;
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menuTv);
        btv = findViewById(R.id.burger_textView);
        ptv = findViewById(R.id.pizza_textView);
        ntv = findViewById(R.id.noodle_textView);
        stv = findViewById(R.id.sweet_textView);
        dtv = findViewById(R.id.drink_textView);
        wtv = findViewById(R.id.water_textView);

        burger = (Button) findViewById(R.id.burger_button);
        pizza = (Button) findViewById(R.id.pizza_button);
        noodles = (Button) findViewById(R.id.noodle_button);
        sweet = (Button) findViewById(R.id.sweet_button);
        drink = (Button) findViewById(R.id.drink_button);
        water = (Button) findViewById(R.id.water_button);

        rm_burger = (Button) findViewById(R.id.burger_button_rm);
        rm_pizza = (Button) findViewById(R.id.pizza_button_rm);
        rm_noodles = (Button) findViewById(R.id.noodles_button_rm);
        rm_sweet = (Button) findViewById(R.id.sweet_button_rm);
        rm_drink = (Button) findViewById(R.id.drink_button_rm);
        rm_water = (Button) findViewById(R.id.water_button_rm);

        order = (Button) findViewById(R.id.order_button);
        bptv = findViewById(R.id.burger_price);
        pptv = findViewById(R.id.pizza_price);
        nptv = findViewById(R.id.noodles_price);
        sptv = findViewById(R.id.sweet_price);
        dptv = findViewById(R.id.drink_price);
        wptv = findViewById(R.id.water_price);

        Typeface french_font = ResourcesCompat.getFont(this, R.font.french);
        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);
        menu.setTypeface(french_font);
        btv.setTypeface(french_font);
        ptv.setTypeface(french_font);
        ntv.setTypeface(french_font);
        stv.setTypeface(french_font);
        dtv.setTypeface(french_font);
        wtv.setTypeface(french_font);
        bptv.setTypeface(gatholic);
        pptv.setTypeface(gatholic);
        nptv.setTypeface(gatholic);
        sptv.setTypeface(gatholic);
        dptv.setTypeface(gatholic);
        wptv.setTypeface(gatholic);
        order.setTypeface(gatholic);
    }
    public void place_order(View view)
    {
        balancesheet();
        Intent i = new Intent(MainActivity.this, orderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putString("choice_iteams", choices);
        bundle.putString("bdt_price", prices);
        bundle.putString("usd_price", usd_price_string);
        i.putExtras(bundle);
        startActivity(i);
        choices = "";
    }


    public void add_to_list(View view)
    {
        if (view == findViewById(R.id.burger_button))
        {
            Toast.makeText(this, "Burger Added", Toast.LENGTH_SHORT).show();
            bp = bp + 1;
            burger.setText(Integer.toString(bp));
        }
        else if (view == findViewById(R.id.pizza_button))
        {
            Toast.makeText(this, "Pizza Added", Toast.LENGTH_SHORT).show();
            pp = pp + 1;
            pizza.setText(Integer.toString(pp));
        }
        else if (view == findViewById(R.id.noodle_button))
        {
            Toast.makeText(this, "Noodles Added", Toast.LENGTH_SHORT).show();
            np = np + 1;
            noodles.setText(Integer.toString(np));
        }
        else if (view == findViewById(R.id.sweet_button))
        {
            Toast.makeText(this, "Sweet Added", Toast.LENGTH_SHORT).show();
            sp = sp + 1;
            sweet.setText(Integer.toString(sp));
        }
        else if (view == findViewById(R.id.drink_button))
        {
            Toast.makeText(this, "Cold Drink Added", Toast.LENGTH_SHORT).show();
            dp = dp + 1;
            drink.setText(Integer.toString(dp));
        }
        else if (view == findViewById(R.id.water_button))
        {
            Toast.makeText(this, "Water Added", Toast.LENGTH_SHORT).show();
            wp = wp + 1;
            water.setText(Integer.toString(wp));
        }
    }
    public void rmv_from_list(View view)
    {
        if (view == findViewById(R.id.burger_button_rm))
        {
            if (bp > 0)
            {
                bp = bp - 1;
                burger.setText(Integer.toString(bp));
                Toast.makeText(this, "Burger Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.pizza_button_rm))
        {
            if (pp > 0)
            {
                pp = pp - 1;
                pizza.setText(Integer.toString(pp));
                Toast.makeText(this, "Pizza Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.noodles_button_rm))
        {
            if (np > 0)
            {
                np = np - 1;
                noodles.setText(Integer.toString(np));
                Toast.makeText(this, "Noodles Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.sweet_button_rm))
        {
            if (sp > 0)
            {
                sp = sp - 1;
                sweet.setText(Integer.toString(sp));
                Toast.makeText(this, "Sweet Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.drink_button_rm))
        {
            if (dp > 0)
            {
                dp = dp - 1;
                drink.setText(Integer.toString(dp));
                Toast.makeText(this, "Cold Drink Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.water_button_rm))
        {
            if (wp > 0) {
                wp = wp - 1;
                water.setText(Integer.toString(wp));
                Toast.makeText(this, "Water Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();

        }
    }

    public void balancesheet()
    {
        tbp = bp * 100;
        tpp = pp * 150;
        tnp = np * 70;
        tsp = sp * 50;
        tdp = dp * 80;
        twp = wp * 35;
        total = tbp + tpp + tnp + tsp + tdp + twp;
        usd_price = total / 80;
        prices = Integer.toString(total);
        usd_price_string = Double.toString(usd_price);
        if (bp > 0)
        {
            choices = choices + "\n\nBurger       (" + bp + " x 100) = " + tbp;
        }
        if (pp > 0)
        {
            choices = choices + "\n\nPizza  (" + pp + " x 150) = " + tpp;
        }
        if (np > 0)
        {
            choices = choices + "\n\nNoodles      (" + np + " x 70) = " + tnp;
        }
        if (sp > 0)
        {
            choices = choices + "\n\nSweet (" + sp + " x 50) = " + tsp;
        }
        if (dp > 0)
        {
            choices = choices + "\n\nCold Drinks   (" + dp + " x 80) = " + tdp;
        }
        if (wp > 0)
        {
            choices = choices + "\n\nWater     (" + wp + " x 35) = " + twp;
        }


    }
    public void banner_about(View view)
    {
        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.about_dialogue);
        dialog.setTitle("About Developer");
        dialog.show();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dialog.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 800000);
    }
}
