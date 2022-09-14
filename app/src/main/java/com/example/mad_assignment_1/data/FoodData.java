package com.example.mad_assignment_1.data;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

import java.util.Arrays;
import java.util.List;

public class FoodData {
    private List<Food> foodList = Arrays.asList(
            //Chicken Treat
        new Food("1", "Beef Deluxe Burger", 8.00, "Beef patty, lettuce, tomato, onion, cheese, pickles, tomato sauce and mayo.", "1", R.drawable.beef_deluxe_burger_icon),
        new Food("2", "Tempta Burger", 7.00, "Chicken breast, lettuce, cheese and mayo.", "1", R.drawable.tempta_burger_icon),
        new Food("3", "Chips", 3.00, "Crispy chips will seasoning.", "1", R.drawable.chips_icon),
        new Food("4", "Classic Tempta Wrap", 7.50, "Chicken breast, lettuce, tomato, onion, cheese, mayo.", "1", R.drawable.classic_tempta_wrap_icon),
        new Food("5", "Half Chicken and Chips", 8.50, "Succulent, seasoned half chicken with a serve of chips.", "1", R.drawable.half_chicken_and_chips_icon),
        new Food("6", "Whole Chicken", 10.00, "Succulent, seasoned whole rotisserie chicken.", "1", R.drawable.whole_chicken_icon),
        new Food("7", "Fried Pieces", 4.00, "Crunchy, southern style coating fried chicken pieces.", "1", R.drawable.fried_pieces_icon),
        new Food("8", "Mash and Gravy", 2.50, "Creamy mashed potato, covered in rich gravy.", "1", R.drawable.mash_and_gravy_icon),
            //Dominos
        new Food("9", "Cheesy Garlic Bread", 4.50, "Fresh herd and garlic bread with cheese melted on top.", "2", R.drawable.cheesy_garlic_bread_icon),
        new Food("10", "Garlic Bread", 4.00, "Hot, traditional loaves of garlic bread.", "2", R.drawable.garlic_bread_icon),
        new Food("11", "Double Beef and Onion", 8.50, "Ground beef, onion, cheese and BBQ sauce.", "2", R.drawable.double_beef_and_onion_icon),
        new Food("12", "Godfather", 8.00, "Pepperoni, sausage and mixed vegetables.", "2", R.drawable.godfather_icon),
        new Food("13", "Hawaiian", 10.00, "Leg ham, pineapple pieces and cheese.", "2", R.drawable.hawaiian_icon),
        new Food("14", "Meatlovers", 10.50, "Crispy bacon, pepperoni, ground beef, ham, cheese, and BBQ sauce.", "2", R.drawable.meatlovers_icon),
        new Food("15", "Pepperoni", 9.00, "Crispy pepperoni and cheese.", "2", R.drawable.pepperoni_icon),
        new Food("16", "Simply Cheese", 8.00, "Simply topped with melted cheese.", "2", R.drawable.simply_cheese_icon),
            //Forklore
        new Food("17", "BECK Roll", 18.50, "Scrambled eggs, bacon, hash brown, kimchi and cheese.", "3", R.drawable.beck_roll_icon),
        new Food("18", "Duck Shoyu Ramen", 24.00, "Duck broth, duck breast, ajitama egg, red onion, negi, watercress and nori.", "3", R.drawable.duck_shoyu_ramen_icon),
        new Food("19", "Katsu Chicken Sando", 20.00, "Katsu fried chicken, homemade slaw and pickles.", "3", R.drawable.katsu_chicken_sando_icon),
        new Food("20", "Mentaiko Spaghetti", 24.00, "Fish roe, butter sauce, spring onion, nori and an egg.", "3", R.drawable.mentaiko_spaghetti_icon),
        new Food("21", "Tonkotsu Congee", 20.50, "Tonkotsu broth, pork belly, mustard greens, spring onion and an ajitama egg.", "3", R.drawable.tonkotsu_congee_icon),
        new Food("22", "Spicy Miso Ramen", 26.50, "Tonkotsu broth, roasted chilli paste and miso tare.", "3", R.drawable.spicy_miso_ramen_icon),
        new Food("23", "Red Velvet Croissant", 12.00, "Raspberry cream cheese and anko (red bean).", "3", R.drawable.red_velvet_croissant_icon),
        new Food("24", "XO Scrambled Egg", 16.00, "Bacon XO sauce, red chilli oil, spring onion and coriander on scrambled eggs.", "3", R.drawable.xo_scrambled_eggs_icon),
            //Grill'd
        new Food("25", "Baa Baa Burger", 16.50, "Lamb patty, cheese, avocado, lettuce, tomato, onion, relish and mayo", "4", R.drawable.baa_baa_burger_icon),
        new Food("26", "Chilli Addict", 15.50, "Beef patty, cheese, roasted peppers, jalapenos, lettuce, onion, relish and sour cream.", "4", R.drawable.chilli_addict_icon),
        new Food("26", "Crispy Bacon and Cheese", 16.00, "Beef patty, crispy bacon, cheese, lettuce, tomato, onion, relish and mayo.", "4", R.drawable.crispy_bacon_and_cheese_icon),
        new Food("27", "Wagyu Wunder", 18.00, "Wagyu patty, cheddar cheese, pickles, onion, mustard, tomato sauce and mayo.", "4", R.drawable.wagyu_wunder_icon),
        new Food("28", "HFC Natural Bites", 6.50, "Chicken breast pieces cooked in olive oil and seasoned with salt.", "4", R.drawable.hfc_natural_bites_icon),
        new Food("29", "Sweet Potato Chips", 5.00, "Thick-cut sweet potato chips lightly seasoned with sea salt.", "4", R.drawable.sweet_potato_chips_icon),
        new Food("30", "Lipton Ice Tea (Peach)", 4.50, "Refreshing peach flavored iced tea.", "4", R.drawable.lipton_ice_tea_peach_icon),
        new Food("31", "Pepsi", 4.00, "Refreshing and sparkling pepsi.", "4", R.drawable.pepsi_icon),
            //KFC
        new Food("32", "Original Recipe Burger", 6.00, "Chicken breast with the 11 secret herbs and spices, lettuce and mayo.", "5", R.drawable.original_recipe_burger),
        new Food("33", "Zinger Burger", 7.00, "Chicken breast coated in zinger flavouring, lettuce and mayo.", "5", R.drawable.zinger_burger_icon),
        new Food("34", "Ultimate Box", 12.50, "Original recipe burger, mash 'n' gravy, chips, one pice of original recipe chicken and a drink.", "5", R.drawable.ultimate_box_icon),
        new Food("35", "Popcorn Chicken", 5.00, "Bite size pieces of chicken breast.", "5", R.drawable.popcorn_chicken_icon),
        new Food("36", "Original Recipe Chicken", 10.00, "6 pieces of chicken with the 11 secret herbs and spices.", "5", R.drawable.original_recipe_chicken_icon),
        new Food("37", "Nuggets", 5.50, "6 pieces of chicken breast coated in the 11 secret herb and spices.", "5", R.drawable.nuggets_icon),
        new Food("38", "Mountain Dew Freeze", 1.00, "Classic Mountain Dew in a slushy form.", "5", R.drawable.mountain_dew_freeze_icon),
        new Food("39", "Solo", 2.00, "Refreshing, thirst quenching Solo.", "5", R.drawable.solo_icon),
            //McDonalds
        new Food("40", "Big Mac", 6.50, "2 beef patties, lettuce, cheese, onions, pickles and McDonald's special sauce.", "6", R.drawable.big_mac_icon),
        new Food("41", "Cheese Burger", 4.50, "Beef patty, onions, tomato sauce, mustard and cheese.", "6", R.drawable.cheese_burger_icon),
        new Food("42", "Fries", 3.50, "Thinly cut French fries.", "6", R.drawable.fries_icon),
        new Food("43", "Hash Brown", 2.00, "Crunchy, golden brown crust with a fluffy potato inside.", "6", R.drawable.hash_brown_icon),
        new Food("44", "Hotcakes", 6.00, "3 fluffy hotcakes with a side of maple syrup and whipped butter.", "6", R.drawable.hotcakes_icon),
        new Food("45", "Mighty McMuffin", 7.50, "2 rashers of bacon, beef patty, egg, cheese and tomato sauce.", "6", R.drawable.mighty_mcmuffin_icon),
        new Food("46", "Fanta", 2.50, "Bright and bubbly, orange tasting soda.", "6", R.drawable.fanta_icon),
        new Food("47", "Frozen Coke", 1.00, "Classic Coca-Cola in a slushy form.", "6", R.drawable.frozen_coke_icon),
            //Nandos
        new Food("48", "Chicken BLAT", 10.50, "Grilled piece of Peri-Peri chicken, 2 rashers of bacon, avocado, lettuce, tomato, aioli and relish.",  "7", R.drawable.chicken_blat_icon),
        new Food("49", "Paella", 10.00, "Grilled chicken pieces, tomato, onion, green capsicum tossed over spicy rice.",  "7", R.drawable.paella_icon),
        new Food("50", "Half Peri-Peri Chicken", 12.50, "1/2 a grilled Peri-Peri chicken.",  "7", R.drawable.half_peri_peri_chicken_icon),
        new Food("51", "Whole Peri-Peri Chicken", 18.50, "A whole grilled Peri-Peri chicken.",  "7", R.drawable.whole_peri_peri_chicken_icon),
        new Food("52", "Mediterranean Salad", 9.50, "Feta, olives, cucumber, tomato, mixed leaves, capsicum and onion with balsamic vinaigrette.",  "7", R.drawable.mediterranean_salad_icon),
        new Food("53", "Halloumi Sticks and Dip", 4.50, "5 pieces of halloumi cheese with a smoky capsicum relish",  "7", R.drawable.halloumi_sticks_and_dip_icon),
        new Food("54", "Corn on the Cob", 5.00, "4 pieces of golden roasted corn.",  "7", R.drawable.corn_on_the_cob_icon),
        new Food("55", "Peri Peri Chips", 5.00, "Thick cut chips, dusted with Peri-Peri flavouring.",  "7", R.drawable.peri_peri_chips_icon),
            //Red Rooster
        new Food("56", "Rooster Roll", 8.50, "", "8", R.drawable.rooster_roll_icon),
        new Food("57", "Rippa Roll", 9.00, "Crunchy roll filled with fried chicken tenders, lettuce and herb mayo.", "8", R.drawable.rippa_roll_icon),
        new Food("58", "Flayva Wrap", 10.50, "2 fried chicken tenders, lettuce, cheese, tomatoes and herb mayo in a soft tortilla.", "8", R.drawable.flayva_wrap_icon),
        new Food("59", "Tropicana Combo", 12.50, "Quarter roast chicken, 2 pineapple fritters, chips and a drink.", "8", R.drawable.tropicana_combo_icon),
        new Food("60", "Cheesy Nuggets", 6.00, "6 chicken nuggets with cheese inside them.", "8", R.drawable.cheesy_nuggets_icon),
        new Food("61", "Chicken Pops", 4.50, "Bite sized chicken pieces coated in buttermilk crumb.", "8", R.drawable.chicken_pops_icon),
        new Food("62", "Crunchy Potatoes", 4.00, "Homestyle roasted potatoes with signature seasoning.", "8", R.drawable.crunchy_potatoes_icon),
        new Food("63", "Pineapple Fritter", 2.00, "A juicy pineapple ring covered in a crispy crumbed coating.", "8", R.drawable.pineapple_fritter_icon),
            //Subway
        new Food("64", "Pulled Pork", 10.00, "Slow cooked pulled pork with a Memphis-style seasoning.", "9", R.drawable.pulled_pork_icon),
        new Food("65", "Meatball Melt", 10.50, "Meatballs in a rich marinara sauce.", "9", R.drawable.meatball_melt_icon),
        new Food("66", "Tuna and Mayo", 12.00, "Tuna chunks mixed with creamy mayo.", "9", R.drawable.tuna_and_mayo_icon),
        new Food("67", "Chicken Teriyaki", 10.50, "Chicken breast stripes marinated with teriyaki sauce.", "9", R.drawable.chicken_teriyaki_icon),
        new Food("68", "Chocolate Chip Cookie", 4.00, "Milk chocolate chips in a golden cookie.", "9", R.drawable.chocolate_chip_cookie_icon),
        new Food("69", "White Chip Macadamia Nut Cookie", 4.00, "White chocolate chips and macadamias in a golden cookie.", "9", R.drawable.white_chip_macadamia_nut_cookie_icon),
        new Food("70", "Dare Iced Coffee", 3.50, "Smooth and chilled iced coffee.", "9", R.drawable.dare_iced_coffee_icon),
        new Food("71", "Mount Franklin Water", 2.50, "Cold and crisp water.", "9", R.drawable.mount_franklin_water_icon),
            //Zambrero
        new Food("72", "Burrito", 12.00, "Your choice of meat, jasmine rice, pinto beans, salsa, cheese, lettuce and sour cream.", "10", R.drawable.burrito_icon),
        new Food("73", "Power Burrito", 14.00, "Your choice of meat, black rice, salsa and lettuce.", "10", R.drawable.power_burrito_icon),
        new Food("74", "Powerbowl", 13.50, "Your choice of meat, black rice, pinto beans, salsa and lettuce.", "10", R.drawable.powerbowl_icon),
        new Food("75", "Dos Capas", 5.50, "A hard shell taco wrapped in a soft tortilla.", "10", R.drawable.dos_capas_icon),
        new Food("76", "Quesadillas", 7.00, "Your choice of meat, salsa and cheese.", "10", R.drawable.quesadillas_icon),
        new Food("77", "Nachos", 12.00, "Corn chips topped with your choice of meat, cheese, guacamole, sour cream and salsa.", "10", R.drawable.nachos_icon),
        new Food("78", "Brownie", 2.50, "A rich brownie made with dark chocolate chunks.", "10", R.drawable.brownie_icon),
        new Food("79", "Blondie", 2.50, "A sweet blondie made with golden syrup and white chocolate chunks.", "10", R.drawable.blondie_icon)
    );

    private static FoodData instance = null;

    public static FoodData getInstance() {
        if (instance == null) {
            instance = new FoodData();
        }
        return instance;
    }

    protected FoodData() {}

    public Food getAtIndex(int index) {
        return foodList.get(index);
    }

    public int size() {
        return foodList.size();
    }
}
