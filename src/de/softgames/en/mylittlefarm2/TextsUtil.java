package de.softgames.en.mylittlefarm2;

public class TextsUtil {


    public static String getNameInfoProducts(String[] texts, int productShowInfo, int posBuilding) {
        String name = "";
        switch (productShowInfo) {

        case Constants.WHEAT:
        case Constants.CORN:
        case Constants.VANILLA:
        case Constants.RYE:
        case Constants.SUGAR_CANE:
        case Constants.ONIONS:
        case Constants.SORGHUM:
        case Constants.COTTON_PLANT:
        case Constants.STRAWBERRY:
        case Constants.BLUEBERRY:
        case Constants.HANF:
        //case Constants.HEMP:
        case Constants.TOMATOES:
        case Constants.CACAO:
        case Constants.POTATOES:
        case Constants.APPLE:
        case Constants.ORANGE:
        case Constants.LEMON:
        case Constants.BANANAS:
        case Constants.CHERRY:
        case Constants.CLOVE:
        case Constants.GRAPES:
        case Constants.LILLIES:
        case Constants.MANGO:
        case Constants.POMEGRANATE:
        case Constants.TULIP: 
        case Constants.OAK: 
        case Constants.BEECH: 
        case Constants.PINE: 
        case Constants.BIRCH: 
            	
            name = texts[259];
            break;

        case Constants.WHEAT_FLOUR:
        case Constants.CRUSHED_GRAIN:
        case Constants.RYE_FLOUR:
        case Constants.MIXED_FLOUR:
        case Constants.BREAD:
        case Constants.DOUGH:
        case Constants.CROISSANT:
        case Constants.PRETZL:
        case Constants.BLUEBERRY_MUFFIN:
        case Constants.CHEESE_CAKE:
        case Constants.APPLE_PIE:
        case Constants.PRALINES:
        case Constants.GOOSE_BUTTER:
        case Constants.WHIPPED_CREAM:
        case Constants.QUARK:
        case Constants.YOGHURT:
        case Constants.FRUIT_JUICE:
        case Constants.MUESLI:
        case Constants.KETCHUP:
        case Constants.JAM:
        case Constants.POWDERED_SUGAR:
        case Constants.LEMONADE:
        case Constants.VANILLA_SUGAR:
        case Constants.SIRUP:
        case Constants.GRILLED_CHEESE:
        case Constants.BACON:
        case Constants.FRENCH_FRIES:
        case Constants.HAMBURGER:
        case Constants.BREAKFAST:
        case Constants.BRUNCH:
        case Constants.LUNCH:
        case Constants.DINNER:
        case Constants.WOOLBALLS:
        case Constants.THREADS:
        case Constants.SPINDLES:
        case Constants.WEBS:
        case Constants.TROUSERS:
        case Constants.HEMP_SHIRT:
        case Constants.JACKET:
        case Constants.COTTON_HAT:
        case Constants.SMALL_BUCKET:
        case Constants.VALENTIN_BUCKET:
        case Constants.MID_SUMMER:
        case Constants.SUMMER_HAPPINESS:
        	    
        	    //Juicery
         case Constants.EXOTIC:
         case Constants.BERRY_JUICE:
         case Constants.MULTI_JUICE:
         case Constants.POWER_JUICE:

        	    //MAREMLEADE
         case Constants.BANANA_DELUXE:
         case Constants.CHERRY_CRUNCH:
         case Constants.MANGO_SPECIAL:
         case Constants.NUT_SPREAD:
        	    
        	    //CHEESE
         case Constants.CHEESE_ORIG:
         case Constants.BUFFALO_CHEESE:
         case Constants.GOAT_CHEESE2:
         case Constants.CHEESE_ROYAL:
        	 
         case Constants.GOLD_BAR:
         case Constants.IRON_BAR:
         case Constants.SILVER_BAR:
        	    
        	    //CHEESE
         case Constants.SKI:
         case Constants.ICE_SKATES:
         case Constants.GOLDENSLEIGH:
         case Constants.SPIKES:
        	
            name = texts[258] + " "  + texts[posBuilding];
            break;

        case Constants.EGGS:
        case Constants.MEAT:
        case Constants.MILK:
        case Constants.GOAT_MILK:
        case Constants.WOOL:
        case Constants.GOOSE_EGG:
        case Constants.DUCK_MEAT:
        case Constants.HORSE_HAIR:
        case Constants.ANGORA_WOOL:
        case Constants.HONEY:
        case Constants.BUFALO_MILK:
        case Constants.NUTS:
       // case Constants.WOOL_AUX:
            name = texts[273];
            break;

        case Constants.MISSION_TYPE_DECO:
            name = texts[285];
            break;
        case Constants.PLOW:
            name = texts[287];
            break;
        case Constants.ADD_HELPER:
            name = texts[286];
            break;
        case Constants.REMOVE_VEGETATIONS:
            name = texts[288];
            break;
        case Constants.WATERING:
            name = texts[284];
            break;
        case Constants.NEXT_LEVEL:
            name = texts[290];
            break;
        case Constants.GET_GOLD:
            name = texts[289];
            break;
        }
        return name;
    }
}
