package de.softgames.en.mylittlefarm2;


import android.graphics.Bitmap;
import android.graphics.Paint;


public class Constants {

    public static final String APP_ID = "434775953274863";
    
    public static final int ARRAY_TEXTS_MAX_LINES = 580;
    public static final int ARRAY_LEVELS_MAX_LINES = 2000;
    
    public static final int LANG_ENGLISH = 1;
    
    /* Animations */
    public static  int SPEED_ANIMATION_MENU = 50;// 44;
    
    /* Initial Currency */
    public static final int INITIAL_GOLD = 400;
    public static final int INITIAL_DIAMONDS = 60;

    public static final int DELAY_TRUCK_IN_SECONDS = 30;

    public static final int[] LEVELS_WIN = { 15,
    	40,
    	140,
    	350,
    	600,
    	900,
    	1200,
    	1850,
    	3200,
    	5800,
    	8600,
    	12500,
    	15625,
    	19531,
    	24414,
    	30518,
    	38147,
    	47684,
    	59605,
    	74506,
    	93132,
    	116415,
    	145519,
    	181899,
    	227374,
    	284217,
    	355271,
    	444089,
    	555112,
    	693889,
    	867362,
    	1084202,
    	1355253,
    	1694066,
    	2117582,
    	2646978,
    	3308722,
    	4135903,
    	5169879,
    	5867812,
    	7334766,
    	9168457,
    	11460571,
    	14325714,
    	17907143,
    	22383928,
    	27979910,
    	34974888,
    	43718610,
    	54648262,
    	68310328,
    	85387910,
    	106734887,
    	133418609,
    	166773261,
    	208466576,
    	260583220,
    	325729025,
    	407161282,
    	508951602,
    	636189503,
    	795236879,
    	994046098,
    	1242557623,
    	1553197028,
    	1941496285,
    	1941496285,
    	1941496285,
    	1941496285,
    	1941496285
};

    /* States */
    public static final byte STATE_COVER = 1;
    public static final byte STATE_LANGUAGE = 2;
    public static final byte STATE_MAIN_MENU = 3;
    public static final byte STATE_MAIN_GAME = 4;
    public static final byte STATE_START_GAME = 5;
    public static final byte STATE_MAIN_MARKET = 6;
    public static final byte STATE_MISSION = 7;
    public static final byte STATE_FACEBOOK = 8;
    public static final byte STATE_MARKET_CROPS = 9;
    public static final byte STATE_MARKET_DECO = 10;
    public static final byte STATE_MARKET_BUILDING = 11;
    public static final byte STATE_MARKET_ANIMALS = 12;
    public static final byte STATE_PRODUCTION = 13;
    public static final byte STATE_LEVEL_UP = 14;
    public static final byte STATE_STORAGE = 15;
    public static final byte STATE_FEED_MILL = 16;
    public static final byte STATE_QUEST_EXPANSION = 17;
    public static final byte STATE_NOFOOD = 18;
    public static final byte STATE_MORE_DIAMONDS = 19;
    public static final byte STATE_MORE_COINS = 20;
    public static final byte STATE_ACHIEVEMENTS = 21;
    public static final byte STATE_COLLECTIONS = 22;
    public static final byte STATE_UPGRADE_STORE = 23;
    public static final byte STATE_UPGRADE_ANIMAL = 24;
    public static final byte STATE_QUEST_BOOST = 25;
    public static final byte STATE_UPGRADE_BUILDING = 26;
    public static final byte STATE_UPGRADE_FEEDMILL = 27;
    public static final byte STATE_WIN_MATERIAL = 28;
    public static final byte STATE_SHOW_INFO_PRODUCTS = 29;
    public static final byte STATE_WIN_MASTERED = 30;
    public static final byte STATE_PROMOTION = 31;
    public static final byte STATE_TRUCKQUEST = 32;
    public static final byte STATE_INFO_TUTORIAL = 33;
    public static final byte STATE_INFO_TUTORIAL_FAKE = 34;
    public static final byte STATE_CHARACTER_MISSION = 35;
    public static final byte STATE_POP_STORAGE_FULL = 36;
    public static final byte STATE_POP_PLOW_FULL = 37;
    public static final byte STATE_LOADING_MAIN = 38;
    public static final byte STATE_LOADING_EXIT =39;
    
    public static final byte STATE_ROULETTE = 40;
    public static final byte STATE_WIN_SPIN = 41;
    public static final byte STATE_DELIVERY = 42;
    public static final byte STATE_MINE = 43;
    public static final byte STATE_PRIZE_MINE = 44;
    public static final byte STATE_INFO_UNLOCK_EXPANSION = 45;
    public static final byte STATE_WIN_NEW_MATERIALS = 46;
    public static final byte STATE_PROMOTED_COLONY = 47;

    /* Steps tutorial */
    public static final int STEP_TUTORIAL_HELLO_FARMER = 1;
    public static final int STEP_TUTORIAL_PLOW_FIELDS = 2;
    public static final int STEP_TUTORIAL_PLOW_MORE_FIELDS = 3;
    public static final int STEP_TUTORIAL_SELECT_CROPS = 4;
    public static final int STEP_TUTORIAL_BOOST_YOUR_WHEAT = 5;
    public static final int STEP_TUTORIAL_HARVEST = 6;
    public static final int STEP_TUTORIAL_MORE_WHEAT = 7;
    public static final int STEP_TUTORIAL_STORAGE = 8;
    public static final int STEP_TUTORIAL_SELECT_WHEAT_TO_BE_SOLD = 9;
    public static final int STEP_TUTORIAL_FIRST_MONEY = 10;
    public static final int STEP_TUTORIAL_ORDER_FROM_OTHERS = 11;
    public static final int STEP_TUTORIAL_YOUR_FIRST_TASK = 12;
    public static final int STEP_TUTORIAL_WIND_MILL_AND_FLOUR = 13;
    public static final int STEP_TUTORIAL_ENTER_PRODUCTION_VIEW = 14;
    public static final int STEP_TUTORIAL_PRESS_PRODUCE = 15;
    public static final int STEP_TUTORIAL_FIRST_TASK_COMPLETED = 16;
    public static final int STEP_TUTORIAL_COLLECT_YOUR_REWARD = 17;
    public static final int STEP_TUTORIAL_BECOMING_KNOWN = 18;
    public static final int STEP_TUTORIAL_FARM_FRIENDS = 19;
    public static final int STEP_TUTORIAL_WELCOME_FINAL_TUTORIAL = 20;
    public static final int STEP_TUTORIAL_LEVEL_UP = 21;
    public static final int STEP_TUTORIAL_FREE = 22;
    public static final int STEP_TUTORIAL_ENTER_SHOP = 23;
    public static final int STEP_TUTORIAL_BUILDINGS = 24;
    public static final int STEP_TUTORIAL_PLACE_ON_YARD = 25;
    public static final int STEP_TUTORIAL_BOOST_CONSTRUCTION = 26;
    public static final int STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING = 27;
    public static final int STEP_TUTORIAL_ADD_ANIMAL = 28;
    public static final int STEP_TUTORIAL_FEED_ANIMALS = 29;
    public static final int STEP_TUTORIAL_PRODUCE_FOOD = 30;
    public static final int STEP_TUTORIAL_CROPS_BECOME_FOOD = 31;
    public static final int STEP_TUTORIAL_WELL_DONE = 32;
    public static final int STEP_TUTORIAL_FIRST_EGG = 33;
    public static final int STEP_TUTORIAL_MORE_EGG = 34;
    public static final int STEP_TUTORIAL_CASH_IN_TIME = 35;
    public static final int STEP_TUTORIAL_TASKS_OWN = 36;
    public static final int STEP_TUTORIAL_EXPAND = 37;
    public static final int STEP_TUTORIAL_CONGRATULATIONS = 38;
    public static final int STEP_TUTORIAL_SPECIAL_TASKS = 39;
    public static final int STEP_TUTORIAL_GET_SPECIAL_TASKS = 40;
    public static final int STEP_TUTORIAL_YOU_MADE = 41;

    /* Expansions */
    public static final int EMPTY = 0;
    public static final int EARTHBAD = 1;
    public static final int EARTHGOOD = 2;
    public static final int EARTH_CROPS = 3;
    public static final int EARTH_BUILDING = 4;
    public static final int LIMBOBUILDING = 5;
    public static final int EXPANSION = 6;
    public static final int EXPANSIONLIMBO = 7;
    public static final int EXPANSIONLIMBO2 = 8;
    public static final int EXPANSIONLIMBO3 = 9;
    public static final int EXPANSIONLIMBO4 = 10;
    public static final int EXPANSIONLIMBO5 = 11;
    public static final int EXPANSIONLIMBO6 = 12;
    public static final int EXPANSIONLIMBO7 = 13;
    public static final int EXPANSIONLIMBO8 = 14;
    public static final int EXPANSIONLIMBO9 = 15;
    public static final int EXPANSIONLIMBO10 = 16;
    public static final int EXPANSIONLIMBO11 = 17;
    public static final int EXPANSIONLIMBO12 = 18;
    public static final int EXPANSIONLIMBO13 = 19;
    public static final int EXPANSIONLIMBO14 = 20;
    public static final int EXPANSIONLIMBO15 = 21;
    public static final int VEGETATIONBAD = 22;
    public static final int VEGETATIONBAD2 = 23;
    public static final int VEGETATIONBAD3 = 24;
    public static final int VEGETATIONBAD4 = 25;
    public static final int VEGETATIONBAD5 = 26;
    public static final int EARTH_DECORATION = 28;
    public static final int LIMBODECORATION = 29;
    // public static final int TILEDBUILDING = 30;

    /* Button states */
    public static final int PRESS_BUTTON_OPEN_MENU = 0;
    public static final int PRESS_BUTTON_CLOSEDMENU = 1;
    public static final int PRESS_BUTTON_OPEN_MARKET = 2;
    public static final int PRESS_BUTTON_MISSION = 3;
    public static final int PRESS_BUTTON_ITEM_MARKET = 4;
    public static final int PRESS_BUTTON_MARKET_CROPS = 5;
    public static final int PRESS_BUTTON_MARKET_BUILDINGS = 6;
    public static final int PRESS_BUTTON_CLOSE_GENERAL_BG = 7;
    public static final int PRESS_BUTTON_PRODUCE = 8;
    public static final int PRESS_BUTTON_BACK = 9;
    public static final int PRESS_BUTTON_OPEN_STORAGE = 10;
    public static final int PRESS_BUTTON_MARKET_ANIMALS = 11;
    public static final int PRESS_BUTTON_AUTOMATIC = 12;
    public static final int PRESS_BUTTON_UPDGRADE_STORE = 13;
    public static final int PRESS_BUTTON_UPDGRADE_STORECLOSED = 14;
    public static final int PRESS_BUTTON_UPDGRADE_ANIMAL = 15;
    public static final int PRESS_BUTTON_MARKET_DECO = 16;
    public static final int PRESS_BUTTON_QUESTBOOST = 17;
    public static final int PRESS_BUTTON_ARROWLEFT = 18;
    public static final int PRESS_BUTTON_ARROWRIGHT = 19;
    public static final int PRESS_BUTTON_UPDGRADE_BUILDING = 20;
    public static final int PRESS_BUTTON_UPDGRADE_FEEDMILL = 21;
    public static final int PRESS_BUTTON_ADDHELPER = 22;
    public static final int PRESS_BUTTON_INVITEFACE = 23;
    public static final int PRESS_BUTTON_UPDGRADE_FEEDMILLCLOSED = 24;
    public static final int PRESS_BUTTON_CLOSE_INFOPRODUCTS = 25;
    public static final int PRESS_BUTTON_INFO_1 = 26;
    public static final int PRESS_BUTTON_INFO_2 = 27;
    public static final int PRESS_BUTTON_ACCEPT_QUEST = 28;
    public static final int PRESS_BUTTON_DENY_QUEST = 29;
    public static final int PRESS_BUTTON_OK_TUTORIAL = 30;
    public static final int PRESS_BUTTON_CLOSE_AUTOMATIC = 33;

    /* Achievements */
    public static final int ACHIEVEMENTS_CROPS = 0;
    public static final int ACHIEVEMENTS_COINS = 1;
    public static final int ACHIEVEMENTS_BUILDING = 2;
    public static final int ACHIEVEMENTS_FRIENDS = 3;
    public static final int ACHIEVEMENTS_VEGETATION = 4;
    public static final int ACHIEVEMENTS_EXPANDS = 5;
    public static final int ACHIEVEMENTS_PRODUCTS = 6;
    public static final int ACHIEVEMENTS_UPGRADE_BUILDING = 7;
    public static final int ACHIEVEMENTS_BACON = 8;
    public static final int ACHIEVEMENTS_EGGS = 9;
    public static final int ACHIEVEMENTS_MILK = 10;
    public static final int ACHIEVEMENTS_WOOL = 11;
    public static final int ACHIEVEMENTS_GOAT_MILK = 12;

    /* Boost actions */
    public static final int ACTION_BOOST_FINISH_BUILDING = 0;
    public static final int ACTION_BOOST_CONSTRUCT_BUILDING = 1;
    // public static final int ACTIONBOOST_CONSTRUCT_ANIMAL = 2;
    public static final int ACTION_BOOST_FINISH_ANIMAL = 3;

    /* Animals */
    public static final int ANIMAL_CHICKEN = 0;
    public static final int ANIMAL_COW = 1;
    public static final int ANIMAL_SHEEP = 2;
    public static final int ANIMAL_PIG = 3;
    public static final int ANIMAL_GOAT = 4;    
    public static final int ANIMAL_GOOSE = 5;   
    public static final int ANIMAL_DUCK = 6;   
    public static final int ANIMAL_HORSE = 7;   
    public static final int ANIMAL_ANGORA = 8;  
    
    public static final int ANIMAL_BEE = 9;   
    public static final int ANIMAL_BUFALO = 10;   
    public static final int ANIMAL_SQUIRELL = 11;  
  
    /* Storage */
    public static final int STORAGE_CROPS = 100;
    public static final int STORAGE_ANIMALS_PRODUCTS = 101;
    public static final int STORAGE_DECORATION = 102;
    public static final int STORAGE_BUILDING = 103;
    public static final int STORAGEANIMALS = 104;
    public static final int STORAGE_PRODUCTS = 105;

    /* Other actions */
    public static final int PLOW = 1000;
    public static final int ADD_HELPER = 1001;
    public static final int REMOVE_VEGETATIONS = 1003;
    public static final int WATERING = 1007;
    public static final int NEXT_LEVEL = 1008;
    public static final int GET_GOLD = 1009;

    /* Mission type */
    public static final int MISSION_TYPE_CROPS = 450;
    public static final int MISSION_TYPE_ANIMALS = 451;
    public static final int MISSION_TYPE_DECO = 452;
    public static final int MISSION_CREATE_PRODUCT = 453;
    public static final int MISSION_PRODUCTANIMAL = 454;

    public static final int N_TILED_WORLD_X = 38;
    public static final int N_TILED_WORLD_Y = 38;

    public static final int GOLD = 1000;
    public static final int FRIENDS = 1001;
    public static final int LEVEL = 1002;
    public static final int DIAMONDS = 1003;
    public static final int MINUTES = 1004;
    public static final int HOURS = 1005;
    public static final int XP = 1006;
    public static final int FOOD = 1007;

    public static boolean SOUND_ON = true;

    public static int[] TreeQuantity = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0 ,0, 0, 0, 0 };
    public static final int[] NEED_MASTER_FLOWER_TREE = { 150, 600, 1500, 3000, 6000 };
    public static Paint fontAnimalfood = null;
   	
    // Decorations
    public static final int SPRING_FLOWERS = 0;
    public static final int WOOD_PILE = 1;
    public static final int HAY_BAIL = 2;
    public static final int STONES_DECO = 3;
    public static final int CLOTHES = 4;
    public static final int WOOD_PLATE = 5;
    public static final int WOOD_PLATE_2 = 6;
    public static final int WIND_WHEEL = 7;
    public static final int HAY_CART = 8;
    public static final int STONE_WATCH = 9;
    public static final int TRACTOR = 10;
    public static final int FIRE_PLACE = 11;
    public static final int HORSE_SHOES = 12;
    public static final int PARK = 13;
    public static final int HAY_TRAILER = 14;
    public static final int PICNIC = 15;
    public static final int RABBIT_HILL = 16;
    public static final int SCARE_CROW = 17;
    public static final int TREE_HOUSE = 18;
    public static final int WELL = 19;
    public static final int WOOD_STORAGE = 20;
    public static final int WOOD_HOUSE = 21;

    // CROPS
    public static final int CROP_WHEAT = 76;
    public static final int CROP_CORN = 77;
    public static final int CROP_VANILLA = 78;
    public static final int CROP_RYE = 79;
    public static final int CROP_SUGARCANE = 80;
    public static final int CROP_ONIONS = 81;
    public static final int CROP_SORGHUM = 82;
    public static final int CROP_COTTON_PLANT = 83;
    public static final int CROP_STRAWBERRY = 84;
    public static final int CROP_BLUEBERRY = 85;
    public static final int CROP_HEMP = 86;
    public static final int CROP_TOMATOES = 87;
    public static final int CROP_CACAO = 88;
    public static final int CROP_POTATOES = 89;
    public static final int CROP_APPLE_TREE = 90;
    public static final int CROP_ORANGE_TREE = 91;
    public static final int CROP_LEMON_TREE = 92;
    
    public static final int CROP_BANANAS = 470;
    public static final int CROP_CHERRY = 471;
    public static final int CROP_CLOVE = 472;
    public static final int CROP_GRAPES = 473;
    public static final int CROP_LILLIES = 474;
    public static final int CROP_MANGO = 475;
    public static final int CROP_POMEGRANATE= 476;
    public static final int CROP_TULIP = 477;    
   
    public static final int CROP_OAK = 507;    
    public static final int CROP_BIRCH = 508;    
    public static final int CROP_PINE = 509;    
    public static final int CROP_BEECH = 510;    
    
    
    
    public static final int[] CROPS_ORD = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 ,25, 26, 27, 28, 29 };

   

    
    public static final int[] CROPS_NAME = { CROP_WHEAT, CROP_CORN,
            CROP_BLUEBERRY, CROP_POTATOES, CROP_RYE,CROP_OAK, CROP_SUGARCANE,CROP_BANANAS,CROP_BIRCH,
            CROP_SORGHUM, CROP_ONIONS,  CROP_CHERRY,CROP_VANILLA, CROP_STRAWBERRY,CROP_PINE,
            CROP_TOMATOES,CROP_MANGO, CROP_COTTON_PLANT, CROP_POMEGRANATE,CROP_HEMP,CROP_GRAPES, CROP_BEECH, CROP_ORANGE_TREE, CROP_CLOVE,
            CROP_APPLE_TREE, CROP_CACAO, CROP_LILLIES, CROP_LEMON_TREE, CROP_TULIP};
    
    
	public static final int[] CROPS_AVAILABLE = { 1, 3, 4, 5, 6, 7, 8, 9, 10,
			12, 13, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 27, 29, 33,
			35, 37, 39, };

	public static final int[] CROPS_EXP = { 1, 1, 4, 6, 2, 2, 2, 4, 3, 3, 3, 3,
			1, 4, 7, 5, 5, 3, 4, 5, 5, 6, 6, 8, 6, 6, 7, 6, 8, };

	public static final int[] CROPS_FOOD = { 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2,
			2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 1, 3, 3, 3, 2, 3, 3, 3, };

    public static final int[] CROPS_ACTIVE_IN_FEED_MILL = { 0, 1, 1, 1, 2, 2, 2,
            2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, };

	public static final int[] CROPS_TIME_TO_WIN = { 1, 3, 240, 480, 10, 6, 15,
			90, 20, 35, 25, 75, 5, 120, 45, 360, 150, 60, 180, 300, 165, 40,
			720, 210, 540, 420, 240, 900, 300, };

    public static final int[] CROPS_DIAMONDS_TO_PAY = { 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static int[] CROPS_QUANTITY_LEVELS = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static final int[] CROPS_COINS_TO_PAY = { 10, 17, 93, 150, 45, 110,
			61, 400, 220, 35, 75, 550, 25, 68, 300, 120, 95, 95, 101, 104, 125,
			250, 600, 145, 450, 132, 145, 790, 160, };

	public static final int[] CROPS_MONEY_TO_WIN = { 11, 20, 101, 160, 49, 115,
			66, 25, 229, 43, 82, 35, 29, 78, 307, 131, 104, 104, 112, 116, 137,
			258, 45, 159, 30, 147, 160, 60, 176, };

 /*   public static final int[] CROPS_EARNING_GOLD = { 
    	 11, 20, 101, 160, 49, 66,
			25, 43, 82, 71, 29, 78, 131, 104, 104, 112, 116, 137, 45, 159, 30,
			147, 160, 60, 176 
    };*/
    
    //public static Image[] cropsImage = new Image[17];
    // public static Bitmap[] animalsImage = new Bitmap[6];
	public static Bitmap[] carTruck = new Bitmap[6];
    public static Bitmap[][] cropsImage = new Bitmap[29][5];
    public static Bitmap[][] animalsProducing = new Bitmap[12][10];
    public static Bitmap[][] animalsHungry = new Bitmap[12][10];

    public static Bitmap starAnimation = null;
    public static Bitmap[] decorationsImage = new Bitmap[22];
    public static Bitmap[] iconProduced = new Bitmap[254];
    public static Bitmap[] animationWaterCrop = new Bitmap[4];
    public static Bitmap[] waterReady_Img = new Bitmap[4];

    public static Bitmap underConstruction = null;
    public static Bitmap underConstructionBig = null;
    // public static Bitmap iconHungry = null;
    public static Bitmap[] productByAnimals = new Bitmap[12];
    public static ImageButton[] iconMiniOption = new ImageButton[4];
    public static Image blink = null;

    public static Bitmap backgroundFoundObecjt = null;
    public static boolean achiviementsActive = false;
    // Class Type BUILDING
    public static final int FARMHOUSE = 22;
    public static final int BARN = 23;
    public static final int FOODMILL = 24;
    public static final int WINDMILL = 25;
    public static final int BUILDINGNORMAL = 26;
    public static final int BUILDINGANIMAL = 27;
    public static final int BUILDINGMINE = 28;
    public static final int BUILDINGWHEEL = 29;
    public static final int BUILDINGDELIVERYSERVICE = 30;

    // Status Animals
    public static final int STATUS_ANIMALS_HUNGRY = 22;
    public static final int STATUS_ANIMALS_READY = 23;
    public static final int STATUS_ANIMALS_DONE = 24;
    public static final int STATUS_ANIMALS_WORKING = 25;

    public static final int[] EXPANSION_COINS = { 2500,
    	6500,
    	15200,
    	32200,
    	68000,
    	90000,
    	150000,
    	230000,
    	400000,
    	570000,
    	740000,
    	910000,
    	1080000,
    	1250000,
    	1420000,
    	1590000,
    	1760000,
    	1930000,
    	2100000,
    	2270000,
    	2440000,
    	2610000,
    	2780000,
    	2950000,
    	3120000 };

    public static final int[] EXPANSION_AVAILABLE = { 10, 14, 18, 24, 28, 36,
            42, 48, 54, 60, 66, 72, 78, 84, 90, 96, 102, 108, 114, 120, 126,
            132, 138, 144, 150, };

    public static final int[] EXPANSION_DIAMOND = { 25,
    	45,
    	75,
    	150,
    	320,
    	440,
    	620,
    	830,
    	1000,
    	1170,
    	1340,
    	1510,
    	1680,
    	1850,
    	2020,
    	2190,
    	2360,
    	2530,
    	2700,
    	2870,
    	3040,
    	3210,
    	3380,
    	3550,
    	3720,


    };

    public static boolean pressedMarket = false;
    public static int lineas = 0;
    public static int currentExpansion = 0;

    public static Bitmap[][] buildings = new Bitmap[42][6];
    public static Image animationBuilding;
    // public static Bitmap cloud = null;
    public static Bitmap buildingReady = null;
    public static Bitmap buildingReadySmall = null;
    public static Bitmap cloudSleep = null;
    public static Bitmap cloudEmpty = null;
    public static Bitmap foodAnimalSleep = null;
    public static Bitmap[] startReady = new Bitmap[18];

    public static final int WHEAT = 0;
    public static final int CORN = 1;
    public static final int BLUEBERRY = 2;
    public static final int POTATOES = 3;
    public static final int RYE = 4;
    public static final int SUGAR_CANE = 5;
    public static final int SORGHUM = 6;
    public static final int VANILLA = 8;
    public static final int ONIONS = 7;
    public static final int STRAWBERRY = 9;
    public static final int TOMATOES = 10;
    public static final int COTTON_PLANT = 11;
    public static final int HANF = 12;
    public static final int ORANGE = 13;
    public static final int APPLE = 14;
    public static final int CACAO = 15;
    public static final int LEMON = 16;

 
    
    
    public static final int WHEAT_FLOUR = 17;
    public static final int CRUSHED_GRAIN = 18;
    public static final int RYE_FLOUR = 19;
    public static final int MIXED_FLOUR = 20;
    public static final int BREAD = 21;
    public static final int DOUGH = 22;
    public static final int CROISSANT = 23;
    public static final int PRETZL = 24;
    public static final int BLUEBERRY_MUFFIN = 25;
    public static final int CHEESE_CAKE = 26;
    public static final int APPLE_PIE = 27;
    public static final int PRALINES = 28;
    public static final int GOOSE_BUTTER = 29;
    public static final int WHIPPED_CREAM = 30;
    public static final int YOGHURT = 31;
    public static final int FRUIT_JUICE = 32;
    public static final int MUESLI = 33;
    public static final int KETCHUP = 34;
    public static final int JAM = 35;
    public static final int POWDERED_SUGAR = 36;
    public static final int LEMONADE = 37;
    public static final int VANILLA_SUGAR = 38;
    public static final int SIRUP = 39;
    public static final int GRILLED_CHEESE = 40;
    public static final int BACON = 41;
    public static final int FRENCH_FRIES = 42;
    public static final int HAMBURGER = 43;
    public static final int BREAKFAST = 44;
    public static final int BRUNCH = 45;
    public static final int LUNCH = 46;
    public static final int DINNER = 47;
    public static final int WOOLBALLS = 48;
    public static final int THREADS = 49;
    public static final int SPINDLES = 50;
    public static final int WEBS = 51;
    public static final int TROUSERS = 52;
    public static final int HEMP_SHIRT = 53;
    public static final int JACKET = 54;
    public static final int COTTON_HAT = 55;

    public static final int STONES = 56;
    public static final int WOOD = 57;
    public static final int NAILS = 58;
    public static final int ROPES = 59;
    public static final int LEAF = 60;
    
 

  //  public static final int WOOL_AUX = 62;
 //   public static final int HEMP = 63;
    public static final int QUARK = 66;//64
    //flower pet shop
    public static final int SMALL_BUCKET = 67;
    public static final int VALENTIN_BUCKET = 68;
    public static final int MID_SUMMER = 69; //158;
    public static final int SUMMER_HAPPINESS = 70;
    
    //Juicery
    public static final int EXOTIC = 71;
    public static final int BERRY_JUICE = 72;
    public static final int MULTI_JUICE = 73; //158;
    public static final int POWER_JUICE = 74;

    //MAREMLEADE
    public static final int BANANA_DELUXE = 75;
    public static final int CHERRY_CRUNCH = 76;
    public static final int MANGO_SPECIAL = 77; //158;
    public static final int NUT_SPREAD = 78;
    
    //CHEESE
    public static final int CHEESE_ORIG = 79;
    public static final int BUFFALO_CHEESE = 80;
    public static final int GOAT_CHEESE2 = 81; //158;
    public static final int CHEESE_ROYAL = 82;

    //83 to 90// are crops
    
    public static final int BANANAS = 83;
    public static final int CHERRY = 84;
    public static final int CLOVE = 85;
    public static final int GRAPES = 86;
    public static final int LILLIES = 87;
    public static final int MANGO = 88;
    public static final int POMEGRANATE= 89;
    public static final int TULIP = 90;  
    
    public static final int OAK = 91;
    public static final int BIRCH = 92;
    public static final int PINE= 93;
    public static final int BEECH = 94;  
    
    //mine
    public static final int IRON_ORE = 95;//Iron Ore
    public static final int SILVER_ORE = 96;// Silver Ore
    public static final int GOLD_ORE = 97;//Gold Ore
    
    //forge
    public static final int IRON_BAR = 98;//Iron Bar	
    public static final int SILVER_BAR = 99;//Silver Bar	
    public static final int GOLD_BAR = 100;//Gold Bar	

    //WinterShop
    public static final int ICE_SKATES = 101;//IIce Skates
    public static final int SPIKES = 102;//ISpikes
    public static final int SKI = 103;//ISki
    public static final int GOLDENSLEIGH = 104;//IGolden Sleigh

    
    public static final int SHOVEL = 105;//61;
    public static final int DYNAMITE = 106;// 62;
    public static final int TNT_BOX = 107; // 63;
    public static final int JACKPOT = 108; //64;
    
    //animals
    public static final int EGGS = 156;
    public static final int MILK = 157;
    public static final int GOAT_MILK = 160; //158;
    public static final int MEAT = 159;
    public static final int WOOL = 158;//160;

    public static final int GOOSE_EGG = 161;
    public static final int DUCK_MEAT = 162;
    public static final int HORSE_HAIR = 163; //158;
    public static final int ANGORA_WOOL = 164;
    
    
    public static final int HONEY = 165;
    public static final int BUFALO_MILK = 166;
    public static final int NUTS = 167;
   
   
   

    
    /*public static final int ENCLOSURE_GOAT_TYPE = 11;
    public static final int ENCLOSURE_SHEEP_TYPE = 6;
    public static final int ENCLOSURE_CHICKEN_TYPE = 0;
    public static final int ENCLOSURE_PIG_TYPE = 9;
    public static final int ENCLOSURE_COW_TYPE = 4;
    public static final int ENCLOSURE_GOOSE_TYPE = 2;
    public static final int ENCLOSURE_DUCK_TYPE = 7;
    public static final int ENCLOSURE_HORSE_TYPE = 13;
    public static final int ENCLOSURE_ANGORA_TYPE = 15;
    public static final int ENCLOSURE_BEE_TYPE = 7;
    public static final int ENCLOSURE_BUFFALO_TYPE = 13;
    public static final int ENCLOSURE_SQUIRELL_TYPE = 15;*/
    
    
    //Buildings
    public static final int BAKERY = 0;
    public static final int CAKE = 1;
    public static final int ENCLOSURE_GOAT = 2;
    public static final int ENCLOSURE_SHEEP = 3;
    public static final int ENCLOSURE_CHICKEN = 4;
    public static final int ENCLOSURE_PIG = 5;
    public static final int ENCLOSURE_COW = 6;
    public static final int DAIRY = 7;
    public static final int FRUIT_SMASHER = 8;
    public static final int SUGAR_FACTORY = 9;
    public static final int GRILL = 10;
    public static final int RESTAURANT = 11;
    public static final int WEAVING_BUILDING = 12;
    public static final int TAILOR = 13;
    public static final int ENCLOSURE_GOOSE = 16;
    public static final int ENCLOSURE_DUCK = 17;
    public static final int ENCLOSURE_HORSE = 18;
    public static final int ENCLOSURE_ANGORA = 19;

  
    
    // new Buildings 
    public static final int CHEESE_DAIRY = 20;
    public static final int MERMERLADE = 21;
    public static final int FLOWER_SHOP = 22;
    public static final int JUICERY = 23;
    public static final int ENCLOSURE_BEE = 24;
    public static final int ENCLOSURE_BUFFALO = 25;
    public static final int ENCLOSURE_SQUIRELL = 26;
    
  //buildings winter 2
    public static final int FORGE = 27;
    public static final int WINTER_SHOP = 28;
    
    
    // Initial Buildings Type
    public static final int FARM_HOUSE = 29; // star in 27 before update winter
    public static final int STORAGE = 30;
    public static final int FEED_MILL = 31;
    public static final int WIND_MILL = 32;
    public static final int MINE = 33;
    public static final int WHEEL = 34;
    public static final int DELIVERYBUILDING = 35;
    
    
    
    // Buy more food constants
    public static final int SMALL_PKG_FOOD_QUANTITY = 10;
    public static final int SMALL_PKG_FOOD_PRICE = 10;
    public static final int BIG_PKG_FOOD_QUANTITY = 25;
    public static final int BIG_PKG_FOOD_PRICE = 20;

    // Options market menu
    public static final byte MARKET_MENU_CROPS_OPTION = 0;
    public static final byte MARKET_MENU_BUILDINGS_OPTION = 2;
    public static final byte MARKET_MENU_ANIMALS_OPTION = 1;
    public static final byte MARKET_MENU_DECORATIONS_OPTION = 3;

    

    
    /*public static final int[] CROPS_ORD_ORGI = { WHEAT, CORN,
            BLUEBERRY, POTATOES, RYE,OAK, SUGAR_CANE,BANANAS,
            BIRCH, SORGHUM, VANILLA, ONIONS, CHERRY, STRAWBERRY, PINE,
            TOMATOES,MANGO, COTTON_PLANT, POMEGRANATE,HANF,GRAPES, BEECH, ORANGE, CLOVE,
            APPLE, CACAO, LILLIES, LEMON, TULIP};  */
    
    public static final int[] CROPS_ORD_ORGI = { WHEAT, CORN,
        BLUEBERRY, POTATOES, RYE,OAK, SUGAR_CANE,BANANAS,
        BIRCH, SORGHUM,  ONIONS, CHERRY, VANILLA, STRAWBERRY, PINE,
        TOMATOES,MANGO, COTTON_PLANT, POMEGRANATE,HANF,GRAPES, BEECH, ORANGE, CLOVE,
        APPLE, CACAO, LILLIES, LEMON, TULIP}; 
    
    // New 
    // New 
    public static final int[] PRODUCT_NAME = { 
    	76,
    	77,
    	78,
    	79,
    	80,
    	81,
    	82,
    	83,
        84,
        85,
        86,
        87,
        88,
        89,
        90,
        91,
        92,
        102,
        103,
        104,
        105,
        106,
        107,
        108,
        109,
        110,
        111,
        112,
        113,
        114,
        115,
        117,
        118,
        119,
        120, 
        121,
        122,
        123,
        124,
        125,
        126,
        127,
        128,
        129,
        130,
        131,
        132,
        133,
        134,
        135,
        136,
        137,
        138,
        139,
        140,
        141,
        142,
        185,
        186,
        187,
        188,
        189,
        190,
        191,
        192,
        193,
        116,
        
        485,
        486,
        487,
        488,
        489,
        490,
        491,
        492,
        493,
        494,
        495,
        496,
        497,
        498,
        499,
        500,
        470,
        471,
        472,
        473,
        474,
        475,
        476,
        477,
           
        // winter products 
        507,//oak
        508,//birch
        509,//pine
        510, //beech
        513, //  Iron Ore
        514, // Silver Ore
        515, // Gold Ore
        516, // Iron Bar
        517, //  Silver Bar
        518, //  Gold Bar
        519, //  Ice Skates
        520, // Spikes
        521,// Ski
        522, //  Golden Sleigh
      
        530,//SHOVEL
        531,//DYNAMITE
        532, // TNT BOX
        533 //JACKPOT
   
        };
    
    // New 
    public static final int[] PRODUCT_NAMEIN_BUILDING = { 76, 77, 85, 89, 79, 80, 82, 81,
            78, 84, 87, 83, 86, 91, 90, 88, 92, 102, 103, 104, 105, 106, 107,
            108, 109, 110, 111, 112, 113, 114, 115, 117, 118, 119, 120, 121,
            122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134,
            135, 136, 137, 138, 139, 140, 141, 142, 185, 186, 187, 188, 189,
            190, 191, 192, 193, 116,  485,
            486,
            487,
            488,
            489,
            490,
            491,
            492,
            493,
            494,
            495,
            496,
            497,
            498,
            499,
            500,
            
        
            
            470,
            471,
            472,
            473,
            474,
            475,
            476,
            477,
            
            
            // winter products 
            507,//oak
            508,//birch
            509,//pine
            510, //beech
            513, //  Iron Ore
            514, // Silver Ore
            515, // Gold Ore
            516, // Iron Bar
            517, //  Silver Bar
            518, //  Gold Bar
            519, //  Ice Skates
            520, // Spikes
            521,// Ski
            522, //  Golden Sleigh
          
            530,//SHOVEL
            531,//DYNAMITE
            532, // TNT BOX
            533 //JACKPOT  
            
        
            
    };

    public static final int[] ANIMALS_ORD = { 0, 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12 };

    public static final int[] ANIMALS_XP_RECOLLECT = { 1, 1, 1, 1, 1, 1, 1, 1, 1 , 1,1,1};

 
    public static final int[][] PRODUCT_ANIMAL_INFO = {
            // 0 , 1 , 2 , 3 , 4 , 5 , 6
            // name Product , totalValue , animalsName, TimeProducts,
            // animalsNeedFood, animalsGoldWinSell, animalsXpWinSell
    	
    	
    		{ 246, 23, 217, 5 * 60, 2, 23, 2 },//chicken
            { 247, 35, 218, 10 * 60, 3, 35, 3 },//Cow
            { 248, 42, 219, 20 * 60, 4, 42, 4 },//Sheep
            { 249, 64, 220, 60 * 60, 6, 64, 6 },//Pig
            { 250, 83, 221, 180 * 60, 8, 83, 8 },//Goat
            { 466,	31, 462,	7*60, 	 3, 31, 2}, //goose
            { 467,	52, 463,	30*60, 	 5, 52, 5}, // duck 
            { 468,	94, 464,	 120*60,  9, 94, 9}, // horse
            { 469,	105, 465, 210*60,	 10, 105, 10}, //Angora
            
            { 501, 23, 504, 2 * 60, 1, 12, 1 },//bee
        	{ 502, 70, 505, 3 * 60, 3, 40, 3 },//buffalo
        	{ 503, 10, 506, 45 * 60, 6, 60, 5 },//squirell


    };
    
    
    public static final int[] BUILDING_ALL_ORIGINAL = {
    	ENCLOSURE_CHICKEN, 
    	BAKERY,
   	 	ENCLOSURE_GOOSE,DAIRY, ENCLOSURE_COW, SUGAR_FACTORY, ENCLOSURE_SHEEP,
   	    ENCLOSURE_DUCK,FRUIT_SMASHER, ENCLOSURE_PIG, CAKE, ENCLOSURE_GOAT,
        WEAVING_BUILDING,
        ENCLOSURE_HORSE, 
        GRILL,   
        ENCLOSURE_ANGORA, RESTAURANT, TAILOR,
        0, 0, FARM_HOUSE,    STORAGE, FEED_MILL, WIND_MILL, 
        ENCLOSURE_BEE, ENCLOSURE_BUFFALO, ENCLOSURE_SQUIRELL, 
           CHEESE_DAIRY, JUICERY, FLOWER_SHOP, MERMERLADE, FORGE, WINTER_SHOP };
    
    public static final int[] BUILDING_ORIGINAL = {
    	ENCLOSURE_CHICKEN, 
    	BAKERY,
   	 	ENCLOSURE_GOOSE,DAIRY, ENCLOSURE_COW, SUGAR_FACTORY, ENCLOSURE_SHEEP,
   	    ENCLOSURE_DUCK,FRUIT_SMASHER, ENCLOSURE_PIG, CAKE, ENCLOSURE_GOAT,
        WEAVING_BUILDING,
        ENCLOSURE_HORSE, 
        GRILL,   
        ENCLOSURE_ANGORA, RESTAURANT, TAILOR,
        //0, 0, FARM_HOUSE,    STORAGE, FEED_MILL, WIND_MILL, 
           
           ENCLOSURE_BEE, ENCLOSURE_BUFFALO, ENCLOSURE_SQUIRELL, 
           CHEESE_DAIRY, JUICERY, FLOWER_SHOP, MERMERLADE, FORGE, WINTER_SHOP };
   
// BUILDING CONSTANTS
    public static final int[] BUILDING_NAMES = { 
    	    195, 
    		196,
    		458,//Goose
    		201,
    		197,
    		204,
    		198,
    		459,// Duck
            203,
            199,
            200,
            202,
            207,
            460,// Horse
            205, 
            461,// Angora
            206, 
            208, 
            0, 
            0, 
            211, 
            212, 
            213, 
            214,
            
            478, 
    		479,
    		480,//News
    		481,
    		482,
    		483,
    		484,
    		
    		511, //news winter
    		512,
    	};
    
    
   
    public static final int[] BUILDING_COINS = { 250, 350, 0, 190, 0, 90, 0,
            240, 180, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, // news buildings cheese dairy etc
            0, 0,//new winter 
            };
    public static final int[] BUILDING_EXP = { 
    	0,0,0,0,0,0,0, //news
    	16, 19, 0, 15, 0, 8, 0, 17, 13,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0,//new winter 
           };

    public static final int[][] BUILDING_AVAILABLE = { 

    	
    		{ 2, 7, 22 },
            { 1, 10, 22 },
            {3,	8,	 24},//GOOSE
            { 4, 12, 24 },
            { 4, 16, 25 }, 
            { 8, 27, 34 },
            { 9, 19, 28 }, 
            {10, 18, 26},//DUCK
            { 11, 19, 38 },
            { 11, 20, 27 }, 
            { 13, 16, 31 },
            { 14, 30, 39 }, 
            { 15, 41, 47 }, 
            {16, 31, 40},//HORSE
            { 17, 32, 39 },
            {17, 32, 41},//ANGORA
            { 25, 35, 45 },
            { 29, 43, 49 }, 
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 }, 
            { 0, 0, 0 },
            { 0, 0, 0 }, 
            { 0, 0, 0 },// WINDMILL
           
        	{ 2, 6, 23 },//news
        	{ 6, 12, 29 },
        	{ 12, 22, 29 },
        	{ 4, 12,  24, },
        	{ 21, 29, 38, },
        	{ 31,	37,	41 },
        	{ 10,	19,	29 },
        	
        	{5,	10,	28},//new winter
        	{8,	25,	43},


            
           
 };

    public static final int[] BUILDING_ORD = { ENCLOSURE_BEE,
    	BAKERY,
    	ENCLOSURE_CHICKEN, 
    	ENCLOSURE_GOOSE,
    	CHEESE_DAIRY,
    	ENCLOSURE_COW,
    	ENCLOSURE_BUFFALO,
    	FORGE, //new winter
    	DAIRY, 
    	SUGAR_FACTORY, 
    	ENCLOSURE_SHEEP,
    	ENCLOSURE_DUCK,
    	MERMERLADE,
    	FRUIT_SMASHER, 
    	ENCLOSURE_PIG, 
    	ENCLOSURE_SQUIRELL, 
    	 WINTER_SHOP, // new winter
    	CAKE,
    	ENCLOSURE_GOAT,
        WEAVING_BUILDING,
        ENCLOSURE_HORSE, 
        ENCLOSURE_ANGORA, 
        GRILL,  
        JUICERY,
        RESTAURANT, 
        TAILOR,
        FLOWER_SHOP,
        
       
        0, 0, FARM_HOUSE,
            STORAGE, FEED_MILL, WIND_MILL, MINE, WHEEL, DELIVERYBUILDING };

    public static final int[] BUILDING_TYPE_ORD = { 
    	ENCLOSURE_BEE,
    	BAKERY,
    	ENCLOSURE_CHICKEN, 
    	ENCLOSURE_GOOSE,
    	CHEESE_DAIRY,
    	ENCLOSURE_COW,
    	ENCLOSURE_BUFFALO,
    	 FORGE, //new winter
    	DAIRY, 
    	SUGAR_FACTORY, 
    	ENCLOSURE_SHEEP,
    	ENCLOSURE_DUCK,
    	MERMERLADE,
    	FRUIT_SMASHER, 
    	ENCLOSURE_PIG, 
    	ENCLOSURE_SQUIRELL, 
    	 WINTER_SHOP, // new winter
    	CAKE,
    	ENCLOSURE_GOAT,
        WEAVING_BUILDING,
        ENCLOSURE_HORSE, 
        ENCLOSURE_ANGORA, 
        GRILL,  
        JUICERY,
        RESTAURANT, 
        TAILOR,
        FLOWER_SHOP,
       
       
        };

   /* public static final int[] BUILDING_TIME_ANIMAL_CONSTRUCT = 
    		{ 5, 10, 30,
              60, 120,7,45,260,360 ,
              2 ,10 ,35 //news
            
    		};*/

       
    public static final int[][] BUILDING_NEED_UPGRADE = {
        // BAKERY
        { 0, 0, 0, 0, 1, LEVEL, 5, MINUTES, 2 },
        { 6500, GOLD, 15, DIAMONDS, 5, LEVEL, 45, MINUTES, 2 },
        { 11500, GOLD, 8, LEAF, 10, LEVEL, 5, HOURS, 2 },
        { 9, NAILS, 14, WOOD, 16, LEVEL, 12, HOURS, 2 },

        // CAKE Shop
        { 0, 0, 0, 0, 13, LEVEL, 10, MINUTES, 3 },
        { 9800, GOLD, 15, DIAMONDS, 14, LEVEL, 1, HOURS, 2 },
        { 22500, GOLD, 7, NAILS, 18, LEVEL, 6, HOURS, 4 },
        { 14, STONES, 5, FRIENDS, 33, LEVEL, 12, HOURS, 1 },

        
   
        
        // DAIRY 8
        { 0, 0, 0, 0, 7, LEVEL, 5, MINUTES, 2 },
        { 7400, GOLD, 6, NAILS, 11, LEVEL, 2, HOURS, 2 },
        { 14000, GOLD, 4, ROPES, 15, LEVEL, 4, HOURS, 2 },
        { 4, FRIENDS, 11, NAILS, 21, LEVEL, 6, HOURS, 1 },
        
        
     
        

        // FRUIT SMASHER
        { 0, 0, 0, 0, 11, LEVEL, 4, HOURS, 1 },
        { 13500, GOLD, 25, DIAMONDS, 16, LEVEL, 3, HOURS, 3 },
        { 24500, GOLD, 9, ROPES, 17, LEVEL, 7, HOURS, 2 },
        { 50, DIAMONDS, 17, NAILS, 26, LEVEL, 14, HOURS, 1 },
       
        // SUGAR FACTORY
        { 0, 0, 0, 0, 8, LEVEL, 4, HOURS, 1 },
        { 25000, GOLD, 30, DIAMONDS, 15, LEVEL, 2, HOURS, 3 },
        { 9, ROPES, 6, FRIENDS, 19, LEVEL, 6, HOURS, 2 },
        { 50, DIAMONDS, 13, STONES, 37, LEVEL, 12, HOURS, 1 },


        // GRILL
        { 0, 0, 0, 0, 17, LEVEL, 12, HOURS, 1 },
        { 34000, GOLD, 8, NAILS, 20, LEVEL, 4, HOURS, 3 },
        { 52000, GOLD, 13, LEAF, 22, LEVEL, 6, HOURS, 2 },
        { 15, STONES, 8, FRIENDS, 36, LEVEL, 12, HOURS, 1 },

        // Restaurant
        { 0, 0, 0, 0, 25, LEVEL, 24, HOURS, 1 },
        { 65000, GOLD, 13, ROPES, 30, LEVEL, 2, HOURS, 3 },
        { 80000, GOLD, 17, NAILS, 32, LEVEL, 6, HOURS, 2 },
        { 18, ROPES, 8, FRIENDS, 36, LEVEL, 12, HOURS, 1 },

        
        // Weaving Building
        { 0, 0, 0, 0, 15, LEVEL, 36, HOURS, 1 },
        { 35000, GOLD, 9, ROPES, 19, LEVEL, 2, HOURS, 3 },
        { 16, STONES, 8, FRIENDS, 22, LEVEL, 6, HOURS, 2 },
        { 80000, GOLD, 18, NAILS, 28, LEVEL, 12, HOURS, 1 },

        // Tailor
        { 0, 0, 0, 0, 29, LEVEL, 30, HOURS, 1 },
        { 12500, GOLD, 25, ROPES, 31, LEVEL, 2, HOURS, 3 },
        { 16, STONES, 12, FRIENDS, 37, LEVEL, 6, HOURS, 2 },
        { 45, DIAMONDS, 18, NAILS, 40, LEVEL, 12, HOURS, 1 },
        
        // Wind Mill
        { 0, 0, 0, 0, 1, LEVEL, 1, HOURS, 2 },
        { 1250, GOLD, 15, DIAMONDS, 2, LEVEL, 2, HOURS, 2 },
        { 3600, GOLD, 9, STONES, 6, LEVEL, 3, HOURS, 2 },
        { 8500, GOLD, 15, LEAF, 12, LEVEL, 9, HOURS, 1 },
        
     // cheese 8
        { 0, 0, 0, 0, 4, LEVEL, 10, MINUTES, 2 },
        { 6600, GOLD, 8, NAILS, 8, LEVEL, 2, HOURS, 2 },
        { 12750, GOLD, 7, ROPES, 14, LEVEL, 3, HOURS, 2 },
        { 2, FRIENDS, 12, NAILS, 22, LEVEL, 5, HOURS, 1 },
        
     // juicery 8
        { 0, 0, 0, 0, 4, LEVEL, 10, MINUTES, 1 },
        { 19400, GOLD, 14, STONES, 7, LEVEL, 2, HOURS, 3 },
        { 28400, GOLD, 18, NAILS, 14, LEVEL, 6, HOURS, 2 },
        { 12, FRIENDS, 16, WOOD, 21, LEVEL, 12, HOURS, 1 },
        
    
        
     // mermelade 8
        { 0, 0, 0, 0, 4, LEVEL, 10, MINUTES, 2 },
        { 11200, GOLD, 6, STONES, 8, LEVEL, 2, HOURS, 2 },
        { 14550, GOLD, 12, WOOD, 14, LEVEL, 6, HOURS, 2 },
        { 6, FRIENDS, 12, LEAF, 21, LEVEL, 8, HOURS, 1 },
        
        
     // flower shop 8
        { 0, 0, 0, 0, 4, LEVEL, 15, MINUTES, 1 },
        { 21000, GOLD, 15, NAILS, 7, LEVEL, 3, HOURS, 2 },
        { 26000, GOLD, 17, ROPES, 14, LEVEL, 6, HOURS, 2 },
        { 14, FRIENDS, 18, NAILS, 21, LEVEL, 14, HOURS, 1 },
        
        // Forge 8
        { 0, 0, 0, 0, 5, LEVEL, 15, MINUTES, 2 },
        { 5400, GOLD, 5, STONES, 9, LEVEL, 6, HOURS, 2 },
        { 9750, GOLD, 6, NAILS, 16, LEVEL, 12, HOURS, 2 },
        { 0, FRIENDS, 0, NAILS, 0, LEVEL, 0, HOURS, 0 },
        

        // Winter Shop 8
        { 0, 0, 0, 0, 8, LEVEL, 4, HOURS, 1 },
        { 12500, GOLD, 12, STONES, 12, LEVEL, 5, HOURS, 1 },
        { 6, ROPES, 6, NAILS, 16, LEVEL, 8, HOURS, 1 },
        { 20, DIAMONDS, 8, STONES, 23, LEVEL, 12, HOURS, 1 },
        

        
        // Storage
        { 5, WOOD, 14, DIAMONDS, 3, LEVEL, 0, 0, 0 },
        { 13, LEAF, 7, STONES, 8, LEVEL, 0, 0, 0 },
        { 18, STONES, 12, NAILS, 14, LEVEL, 0, 0, 0 },
        { 14, WOOD, 19, LEAF, 20, LEVEL, 0, 0, 0 },
        { 24, WOOD, 16, ROPES, 29, LEVEL, 0, 0, 0 },
 
        
        // FeedMill
        { 1550, GOLD, 15, DIAMONDS, 3, LEVEL, 0, 0, 0 },
        { 25, DIAMONDS, 8, STONES, 7, LEVEL, 0, 0, 0 },
        { 45, DIAMONDS, 9, WOOD, 15, LEVEL, 0, 0, 0 },
        { 70, DIAMONDS, 15, NAILS, 26, LEVEL, 0, 0, 0 },
        { 99, DIAMONDS, 20, LEAF, 41, LEVEL, 0, 0, 0 }
        
       


};

    public static final int[][] BUILDING_PRODUCTS = {
        // BAKERY - 0
        { BREAD, WHEAT_FLOUR, 3, EGGS, 4, 4, 5, 181, 5, 158 },
        { DOUGH, CRUSHED_GRAIN, 4, GOOSE_EGG, 4, 2, 8, 338, 15, 294 },
        { CROISSANT, RYE_FLOUR, 6, MILK, 6, 6, 10, 1932, 25, 1680 },
        { PRETZL, MIXED_FLOUR, 7, GOOSE_EGG, 6, 2, 12, 4572, 45, 3976 },

        // CAKE - 4
        { CHEESE_CAKE, GOOSE_BUTTER, 2, EGGS, 3, 1, 12, 240, 15, 209 },
        { BLUEBERRY_MUFFIN, BLUEBERRY, 1, DOUGH, 2, 1, 12, 795, 25, 692 },
        { APPLE_PIE, APPLE, 4, VANILLA, 3, 1, 27, 2308, 50, 2007 },
        { PRALINES, CACAO, 2, DOUGH, 5, 1, 22, 2044, 45, 1778 },

        // Dairy -8
        { GOOSE_BUTTER, MILK, 4, GOOSE_EGG, 3, 1, 6, 268, 4, 233 },
        { WHIPPED_CREAM, GOAT_MILK, 2, HONEY, 3, 1, 12, 232, 8, 202 },
        { QUARK, WHIPPED_CREAM, 1, BUFALO_MILK, 2, 1, 18, 360, 15, 313 },
        { YOGHURT, GOOSE_BUTTER, 1, SUGAR_CANE, 5, 1, 22, 647, 12, 563 },
  
        // Fruit Smasher- 12
        { MUESLI, CRUSHED_GRAIN, 3, MILK, 4, 4, 8, 374, 10, 326 },
        { JAM, STRAWBERRY, 4, SUGAR_CANE, 2, 7, 14, 533, 55, 464 },
        { KETCHUP, TOMATOES, 10, -1, 0, 7, 50, 1587, 120, 1380 },
        { FRUIT_JUICE, STRAWBERRY, 2, ORANGE, 2, 6, 20, 1685, 180, 1466 },

        // Sugar Factory- 16
        { POWDERED_SUGAR, SUGAR_CANE, 2, -1, 0, 1, 20, 151, 6, 132 },
        { VANILLA_SUGAR, POWDERED_SUGAR, 2, VANILLA, 3, 1, 50, 403, 21, 351 },
        { SIRUP, VANILLA_SUGAR, 2, POWDERED_SUGAR, 4, 1, 120, 1414, 125,1230 },
        { LEMONADE, LEMON, 2, ORANGE, 4, 1, 220, 4945, 240, 4300 },

        // Grill -20
        { BACON, MEAT, 2, DUCK_MEAT, 3, 1, 80, 147, 7, 128 },
        { GRILLED_CHEESE, GOOSE_BUTTER, 3, WHIPPED_CREAM, 2, 1, 120, 241, 15, 210 },
        { FRENCH_FRIES, POTATOES, 2, KETCHUP, 2, 1, 250, 3576, 360, 3110 },
        { HAMBURGER, ONIONS, 3, BACON, 2, 1, 430, 577, 30, 502 },

        // Restaurant-24
        { BREAKFAST, FRUIT_JUICE, 2, MUESLI, 1, 1, 120, 3746, 15, 3258 },
        { BRUNCH, MILK, 3, BACON, 2, 1, 240, 415, 25, 361 },
        { LUNCH, POTATOES, 3, GRILLED_CHEESE, 2, 1, 360, 1086, 40, 945 },
        { DINNER, FRENCH_FRIES, 2, HAMBURGER, 2, 1, 440, 8307, 420, 7224 },

        // Weaving Building - 28
        { WOOLBALLS, WOOL, 2, HORSE_HAIR, 2, 1, 120, 400, 12, 84 },
        { THREADS, ANGORA_WOOL, 2, HORSE_HAIR, 2, 1, 240, 289, 30, 252 },
        { SPINDLES, ANGORA_WOOL, 2, THREADS, 2, 1, 360, 1380, 50, 672 },
        { WEBS, HANF, 2, SPINDLES, 2, 1, 440, 3036, 80, 1584 },

        // Tailor - 32
        { TROUSERS, WOOL, 2, HORSE_HAIR, 2, 1, 120, 391, 5, 84 },
        { HEMP_SHIRT, HANF, 3, THREADS, 1, 1, 240, 655, 20, 360 },
        { JACKET, ANGORA_WOOL, 2, WOOL, 2, 1, 360, 338, 25, 294 },
        { COTTON_HAT, COTTON_PLANT, 3, SPINDLES, 1, 1, 440, 1742, 30, 987 },

     // Wind Mill - 36

        { WHEAT_FLOUR, WHEAT, 2, -1, 0, 1, 2, 25, 2, 22 },
        { CRUSHED_GRAIN, WHEAT, 2, CORN, 2, 1, 4, 71, 4, 62 },
        { RYE_FLOUR, RYE, 5, -1, 0, 1, 10, 348, 5, 245 },
        { MIXED_FLOUR, RYE, 7, SORGHUM, 5, 1, 29, 641, 7, 558 },
        
     // Cheese Dairy -20
        { CHEESE_ORIG, MILK, 2, -1, 0, 1, 3, 81, 5, 11 },
        { BUFFALO_CHEESE, BUFALO_MILK, 3, CHEESE_ORIG, 1, 1, 10, 219, 12, 29 },
        { GOAT_CHEESE2, GOAT_MILK, 2, GOOSE_BUTTER, 2, 1, 24, 727, 33, 95 },
        { CHEESE_ROYAL, BUFFALO_CHEESE, 2, NUTS, 5, 1, 32, 782, 25, 102 },
        
      
               
     // Juicery -20
        { EXOTIC, MANGO, 2, POMEGRANATE, 2, 1, 7, 497, 4, 432 },
        { BERRY_JUICE, GRAPES, 4, STRAWBERRY, 3, 1, 11, 917, 8, 797 },
        { MULTI_JUICE, EXOTIC, 2, GRAPES, 6, 1, 26, 1938, 25, 1686 },
        { POWER_JUICE, MULTI_JUICE, 2, BANANAS, 3, 1, 65, 3964, 36, 3447 },
        
        
     // Mermelade -20
        { BANANA_DELUXE, BANANAS, 2, HONEY, 3, 1, 8, 99, 5, 86 },
        { CHERRY_CRUNCH, CHERRY, 3, NUTS, 6, 1, 14, 535, 12, 465 },
        { MANGO_SPECIAL, MANGO, 4, CHERRY, 3, 1, 16, 599, 33, 521 },
        { NUT_SPREAD, CACAO, 3, NUTS, 4, 1, 18, 807, 25, 702 },
        

        
     // Flower_shop -20
        //0-itemToProduce 1-Ingredient1 2-quantityIngre1  3-Ingredient2 4-quantityIngre2 
        //6- rewaXP  7-rewardCoins 8-time 9-totalnetValue
        { SMALL_BUCKET, CLOVE, 4, -1, 0, 1, 6, 732, 8, 95 },
        { VALENTIN_BUCKET, CLOVE, 2, LILLIES, 4, 1, 14, 1102, 14, 144 },
        { MID_SUMMER, LILLIES, 5, TULIP, 3, 1, 18, 1527, 32, 199 },
        { SUMMER_HAPPINESS, VALENTIN_BUCKET, 2, MID_SUMMER, 2, 1, 78, 5258, 40, 686 },
        
        
        // FORGE - 4
        { IRON_BAR, IRON_ORE, 4, -1, 0, 1, 7, 198, 8, 172 },
        { SILVER_BAR, SILVER_ORE, 3, -1, 0, 1, 13, 300, 15, 261 },
        { GOLD_BAR, GOLD_ORE, 2, -1, 0, 1, 22, 400, 25, 348 },
        { PRALINES, CACAO, 2, DOUGH, 5, 1, 22, 2044, 45, 1778 },
        
        // Winter_SHOP - 4
        { ICE_SKATES, IRON_BAR, 1, OAK, 3, 1,	8,	594,	5,	517 },
        { SPIKES, SILVER_BAR, 1, IRON_BAR, 2, 1,	13,	695,	9,	605 },
        { SKI, BIRCH, 3, PINE, 2, 			1,	22,	1496,		15,	1301 },
        { GOLDENSLEIGH, GOLD_BAR, 2, BEECH, 3, 1,	23,	1690,	26,	1470 },

    
    };
    
    public static final int[][] BUILDING_PRICE = {
        // CHICKEN
        { 150, 750, 2500 },
        // Bakery
        { 3500, 3500*2, 3500*3 },
        
        //Goose
        {380, 1000, 3500},

        // DAIRY
        { 2600, 2600*2, 2600*3 },
        // Cow
        { 500, 1500, 4500 },
        // SUGAR FACTORY
        { 10000, 10000*1, 10000*1 },
        // Sheep
        { 800, 2500, 6500 },
        
        // duck
        {1000, 3500, 6800},

        // FRUIT SMASHER
        { 8500, 8500*1, 8500*1 },
        // Pig
        { 1200, 3800, 7200 },
        // CAKE
        { 6500, 6500*2, 6500*3 },
        // Goat
        { 2500, 5200, 9600 },
    
     
     
        
        // Weaving Building
        { 17000, 17000*1, 17000*1 },
        
        // horse
        { 3500 ,8200, 	15600},
        
        
     // GRILL
        { 13500, 13500*2, 13500*1 },
        
        // angora
        {5500 , 10200 , 19600},

        
        // Restaurant
        { 47000, 47000*1, 47000*1 },
        // Tailor
        { 55000, 55000*1, 55000*1 },
        // Wind Mill
       // { 0, 0, 0 },asdf
        
        // Bee
        { 130, 700, 2600 },
     // Bufalo
        { 600, 1800, 5400 },
     // Squirell
        { 1500, 4200, 8000 },
        
     // Cheese Dairya
        { 2600, 2600*2, 2600*3 },
     // Juicery
        { 12500, 12500*2, 12500*3 },
        // flower shop
        { 16000, 16000, 16000 },
     // Mermelade
        { 6600, 6600*2, 6600*3 },
     
        // FORGE
        { 3600, 3600, 3600 },
     // WINTER SHOP
        { 7500, 7500*2, 7500*3 },
        
    };

public static boolean canShowCollection = false;
public static long timeShowCollection = 0;
public static int typeCollectionShow = 0;
public static int posCollectionShow = 0;

public static int[] buildingUsed = {
        // CHICKEN
        0,
        // Bakery
        0,
        // Cow
        0,
        // Sheep
        0,
        // Pig
        0,
        // CAKE
        0,
        // DAIRY
        0,
        // Goat
        0,
        // SUGAR FACTORY
        0,
        // FRUIT SMASHER
        0,
        // GRILL
        0,
        // Restaurant
        0,
        // Weaving Building
        0,
        // Tailor
        0,
        // Wind Mill
        0,//Goose
        
        0,
        // Duck
        0,
        // Horse
        0,
        // Angora
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,

};

public static int[] animalUsed = {
        // CHICKEN
        0,
        // Cow
        0,
        // Sheep
        0,
        // Pig
        0,
        // Goat
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,};

/*public static final int[][] ANIMAL_TYPE_PRICE = {
	{ GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
    { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
    { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
    
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD,  DIAMONDS, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, GOLD,  DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, },
        { GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, GOLD, DIAMONDS, GOLD, }

};*/

public static final int[][] ANIMAL_PRICE = {
	
	{50,	100,	1, 		250,	350,	3, 		850,	750,	6, 		1200,	1450,	9,		1950,	2200,	12, 	2700}, //Chicken
	{250,	350,	500,	3, 		750,	950,	6, 		1250,	1450,	9, 		1850,	16, 	2350,	2800,	20, 	3500}, // Cow
	{350,	550,	4, 		850,	1050,	9, 		1200,	1500,	1800,	14, 	1950,	2200,	14, 	2800,	19, 	3800}, //Sheep
	{650,	850,	6, 		1200,	1500,	13, 	1850,	2750,	19, 	3200,	3450,	22, 	3950,	4200,	25, 	4703}, //Pig
	{750,	950,	7, 		1300,	1750,	14, 	1950,	2850,	21, 	3500,	4450,	26, 	4950,	5200,	29, 	5800}, //Goat
	{125,	250,	1, 		600,	900,	3, 		1200,	1500,	6, 		1800,	2200,	9, 		2500,	3200,	12, 	4000}, //Goose
	{550,	780,	5, 		1000,	1300,	12, 	1550,	2350,	17, 	2900,	3400,	21,		4350,	5200,	24, 	5700}, //Duck
	{850,	1350,	9, 		1800,	2750,	15, 	3250,	3850,	23, 	5500,	6450,	27,		6950,	7200,	31, 	8800}, //Horse
	{950,	1950,	8, 		2300,	2950,	16, 	3550,	4850,	25, 	5500,	6450,	28, 	6950,	8200,	31, 	8800}, //Angora
	{45,	90,		1, 		230,	300,	2, 		750,	850,	3, 		1100,	1250,	4, 		1850,	2000,	6,		2700}, //Bee
	{275,	390,	550,	2, 		850,	1050,	3, 		1450,	1650,	3, 		2150,	2550,	3150,	3, 		3950,	4500}, //Buffalo
	{700,	900,	1100,	4, 		1650,	1900,	6, 		2500,	3400,	9, 		4100,	4650,	11, 	5200,	6600,	12 }, //Squirrel
	
	

};

    public static final int COLLECTION_GOOD_START = 0;
    public static final int COLLECTION_FRESH_JUICY = 1;
    public static final int COLLECTION_FLOWER_DAY = 2;
    public static final int COLLECTION_EXOTIC_DAY = 3;
    public static final int COLLECTION_ALL_MINE = 4;
    public static final int COLLECTION_TREE_COLL = 5;
    public static final int COLLECTION_CATS_MICE = 6;
    public static final int COLLECTION_BAKERY_STORY = 7;
    public static final int COLLECTION_YUMMY_CAKES = 8;
    public static final int COLLECTION_GOT_MILK = 9;
    public static final int COLLECTION_YUMMY_JAM = 10;
    public static final int COLLECTION_SWEET_SUGAR = 11;
    public static final int COLLECTION_HAM_MEAT = 12;
    public static final int COLLECTION_RESTAURANT_STORY = 13;
    public static final int COLLECTION_NICE_NEEDLES = 14;
    public static final int COLLECTION_NICE_SOFT = 15;
    public static final int COLLECTION_LETS_CREATE = 16;
    public static final int COLLECTION_ANIMAL_FARM = 17;
    public static final int COLLECTION_ANIMAL_FARM_2 = 18;
    public static final int COLLECTION_EXPAND_CULTIVATE = 19;
    public static final int COLLECTION_ROCKS_ROSES = 20;
    public static final int COLLECTION_DIAMONDS_MY_FRIENDS = 21;
    
    public static int[][] rewardCollection = { /*{ 150, GOLD }, { 250, GOLD },
            { 500, GOLD }, { 500, GOLD, 150, XP }, { 750, GOLD, 200, XP },
            { 2000, GOLD, 350, XP }, { 5000, GOLD, 200, XP, 1, DIAMONDS },
            { 9000, GOLD, 400, XP, 3, DIAMONDS }, { 3000, GOLD, 800, XP },
            { 3000, GOLD, 750, XP }, { 2000, GOLD, 500, XP },
            { 4000, GOLD, 1000, XP }, { 8000, GOLD, 1500, XP },
            { 10000, GOLD, 1800, XP }, { 10000, GOLD, 1500, XP },
            { 5000, GOLD, 3000, XP, 5, DIAMONDS },
            { 100, GOLD, 50, XP, 1, DIAMONDS }, { 1000, GOLD, 250, XP },
            { 2000, GOLD, 500, XP }, { 1500, GOLD, 5, DIAMONDS },
            { 500, GOLD, 2, DIAMONDS }, { 25, DIAMONDS }*/
    
    	{ 50, GOLD },
    	{ 150, GOLD },
    	{ 200, GOLD },
    	{ 300, GOLD, 25, XP },
    	{ 150, GOLD, 20, XP },
    	{ 100, GOLD, 35, XP },
    	{ 100, GOLD, 15, XP },
    	{ 300, GOLD, 40, XP},
    	{ 250, GOLD, 30, XP },
    	{ 150, GOLD, 8, XP },
    	{ 320, GOLD, 30, XP },
    	{ 375, GOLD, 30, XP },
    	{ 400, GOLD, 35, XP },
    	{ 250, GOLD, 30, XP },
    	{ 400, GOLD, 40, XP },
    	{ 170, GOLD,50, XP },
    	{ 50, GOLD, 50, XP},
    	{ 100, GOLD, 15, XP },
    	{ 120, GOLD, 10, XP },
    	{ 400, GOLD  },
    	{ 250, GOLD  },
    	{ 3, DIAMONDS }
    };

    public static int[][] rewardsMastered = { { 25, GOLD, 5, XP },
            { 50, GOLD, 10, XP }, { 100, GOLD, 15, XP },
            { 200, GOLD, 20, XP }, { 1, DIAMONDS, 30, XP } };

    
   
    /*
     * Available Level 0 Price (Gold) 1 Price (Diamonds) 2 XP when purchased 3
     * Sell Deco (Gold) 4 name 5 Order 6 TypePay 7 isFourSpace 8 1 == yes , 0 ==
     * n0
     */

    public static final int[][] DECORATIONS_INFO = {
            { 2, 250, 0, 2, 75, 263, 0, GOLD, 0 },
            { 3, 450, 0, 4, 135, 264, 1, GOLD, 0 },
            { 5, 0, 5, 5, 100, 265, 2, DIAMONDS, 0 },
            { 6, 350, 0, 3, 105, 413, 3, GOLD, 0 },
            { 7, 650, 0, 5, 195, 414, 4, GOLD, 0 },
            { 9, 1000, 0, 8, 300, 415, 5, GOLD, 0 },
            { 12, 1000, 0, 8, 300, 416, 6, GOLD, 0 },
            { 13, 0, 7, 7, 150, 266, 7, DIAMONDS, 0 },
            { 15, 0, 9, 9, 250, 267, 8, DIAMONDS, 0 },
            { 18, 1500, 0, 8, 450, 417, 9, GOLD, 0 },
            { 20, 0, 25, 25, 700, 268, 10, DIAMONDS, 0 },
            { 22, 0, 15, 15, 500, 418, 11, DIAMONDS, 1 },
            { 23, 3500, 0, 10, 1050, 419, 12, GOLD, 1 },
            { 26, 0, 20, 20, 600, 420, 13, DIAMONDS, 1 },
            { 27, 0, 15, 15, 500, 421, 14, DIAMONDS, 0 },
            { 30, 0, 18, 18, 500, 422, 15, DIAMONDS, 1 },
            { 34, 4500, 0, 14, 1350, 423, 16, GOLD, 1 },
            { 36, 0, 24, 24, 800, 424, 17, DIAMONDS, 0 },
            { 38, 12500, 0, 20, 3750, 425, 18, GOLD, 1 },
            { 40, 0, 15, 15, 700, 426, 19, DIAMONDS, 0 },
            { 43, 0, 25, 25, 900, 427, 20, DIAMONDS, 0 },
            { 45, 15000, 0, 21, 4500, 428, 21, GOLD, 1 },

    };

    public static int numberArchievementsComplete = 0;

    public static final int[] NAME_ACHIEVEMENTS = { 148, 150, 152, 154, 156,
            158, 160, 162, 164, 166, 168, 170, 172, 174, 176 };

    public static final int NUMBER_ACHIEVEMENTS = 15;

    public static final boolean[] COMPLETE_ACHIEVEMENTS = { false, false,
            false, false, false, false, false, false, false, false, false,
            false, false, false, false, };

    public static final int[] NUMBER_ACHIEVEMENTS_FOR_UPGRADE = { 1, 10, 15,
            20, 25 };

    public static final int[] LEVEL_ACHIEVEMENTS = { 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0 };

    public static final int[] CURRENT_QUANTITY_ACHIEVEMENTS = { 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static final int[][] ACHIEVEMENTS_INFO = {
          /*  { 25, 1, 250, 3, 1000, 6, 10000, 12, 100000, 20 },
            { 2, 5, 10, 10, 40, 15, 70, 30, 100, 50 },
            { 10, 1, 50, 3, 250, 6, 1000, 12, 10000, 20 },
            { 1000, 1, 10000, 3, 50000, 6, 100000, 12, 1000000, 20 },
            { 10, 1, 50, 3, 200, 6, 1500, 12, 5000, 20 },
            { 7, 1, 25, 3, 100, 6, 1200, 12, 4000, 20 },
            { 5, 1, 20, 3, 80, 6, 1000, 12, 3000, 20 },
            { 3, 2, 17, 3, 60, 6, 900, 12, 2000, 20 },
            { 500, 2, 2500, 5, 10000, 10, 25000, 15, 50000, 20 },
            { 1, 3, 3, 6, 6, 9, 10, 12, 15, 15 },
            { 5, 1, 10, 3, 25, 6, 50, 12, 100, 20 },
            { 3, 2, 6, 4, 10, 6, 20, 12, 40, 20 },
            { 1, 1, 5, 3, 10, 4, 15, 12, 30, 20 },
            { 100, 10, 1000, 100, 10000, 1000, 50000, 500, 100000, 10000 },
            { 1000, 1, 5000, 10, 20000, 50, 50000, 150, 100000, 500 }*/
    	{250,	50,		2500,	250, 	50000,	500,	250000,		1000, 	1000000,	1}, 
    	{2,		150, 	10,		200, 	40,		300,	70,			400, 	100,		1}, 
    	{50,	50, 	250,	150, 	1500,	200, 	15000,		300, 	50000,		1}, 
    	{1000,	50, 	50000,	150,	250000,	450, 	1000000,	1000, 	10000000,	1}, 
    	{10,	150, 	550,	175, 	1850,	250, 	9000,		450, 	60000,		1}, 
    	{7,		75, 	150,	150, 	800,	230, 	3600,		300, 	55000,		1}, 
    	{5,		50, 	250,	250, 	1200,	420, 	8000,		1000, 	35000,		1}, 
    	{3,		80, 	170,	175, 	900,	260, 	6800,		450, 	30000,		1}, 
    	{1000,	50, 	5000,	150, 	25000,	240, 	200000,		150, 	5000000,	1}, 
    	{1,		65, 	3,		150, 	8,		450, 	14,			300, 	20,			1}, 
    	{5,		90, 	25,		175, 	50,		255, 	75,			1000, 	100,		1}, 
    	{3,		80, 	9,		150, 	15,		250, 	35,			450, 	50,			1}, 
    	{3,		50, 	11,		150, 	23,		455, 	36,			150, 	50,			1}, 
    	{100,	100, 	1000,	175, 	10000,	300, 	50000,		600, 	100000,		1}, 
    	{1000,	50, 	15000,	150, 	100000,	305, 	500000,		1000, 	1000000,	1} 


    };

    // Actions costs
    public static final int ACTION_PLOW_COST = 0;

    public static final int BOOST_PLOW_COST = 5;
    public static final int BOOST_WATERING_COST = 5;
    public static final int BOOST_HARVEST_COST = 5;
    public static final int BOOST_FERTILIZE_COST = 20;
    public static final int BOOST_PLANTING_COST = 5;

    public static final int REFUND_DIAMONDS = 0;
    public static final int REFUND_COINS = 1;
    public static final int REFUND_FOOD = 2;
    public static final int REFUND_XP = 3;
    public static final int REFUND_ALL = 4;

    // InApp products
    public static String SKU_BUY = "mlfht_diamonds3_1";
    
    public static String HF3_NO_ADS = "disable_all_ads_1";
    
    public static final int HF3_DIAMONDS1_AMOUNT = 5;
    public static final int HF3_DIAMONDS2_AMOUNT = 27;
    public static final int HF3_DIAMONDS3_AMOUNT = 60;
    public static final int HF3_DIAMONDS4_AMOUNT = 180;
    public static final int HF3_DIAMONDS5_AMOUNT = 400;
    public static final int HF3_DIAMONDS6_AMOUNT = 850;

    public static final int HF3_COINS1_AMOUNT = 500;
    public static final int HF3_COINS2_AMOUNT = 1250;
    public static final int HF3_COINS3_AMOUNT = 3000;
    public static final int HF3_COINS4_AMOUNT = 7000;
    public static final int HF3_COINS5_AMOUNT = 15500;
    public static final int HF3_COINS6_AMOUNT = 32500;

    public static final int HF3_BONUSPACKAGE_40_COINS = 800;
    public static final int HF3_BONUSPACKAGE_40_DIAMONDS = 20;
    public static final int HF3_BONUSPACKAGE_50_COINS = 1200;
    public static final int HF3_BONUSPACKAGE_50_DIAMONDS = 25;
    public static final int HF3_BONUSPACKAGE_60_COINS = 1200;
    public static final int HF3_BONUSPACKAGE_60_DIAMONDS = 30;
    public static final int HF3_BONUSPACKAGE_70_COINS = 2000;
    public static final int HF3_BONUSPACKAGE_70_DIAMONDS = 50;

    public static final int[] HF3_BONUS_COINS = { HF3_BONUSPACKAGE_40_COINS,
            HF3_BONUSPACKAGE_50_COINS, HF3_BONUSPACKAGE_60_COINS,
            HF3_BONUSPACKAGE_70_COINS };
    public static final int[] HF3_BONUS_DIAMONDS = {
            HF3_BONUSPACKAGE_40_DIAMONDS, HF3_BONUSPACKAGE_50_DIAMONDS,
            HF3_BONUSPACKAGE_60_DIAMONDS, HF3_BONUSPACKAGE_70_DIAMONDS };

    public static final int HF3_PROMO_DIAMONDS = 20;
    public static final int HF3_PROMO_COINS = 1000;

    public static final int[] HF3_COINS = { HF3_COINS1_AMOUNT,
            HF3_COINS2_AMOUNT, HF3_COINS3_AMOUNT, HF3_COINS4_AMOUNT,
            HF3_COINS5_AMOUNT, HF3_COINS6_AMOUNT };
    public static final int[] HF3_DIAMONDS = { HF3_DIAMONDS1_AMOUNT,
            HF3_DIAMONDS2_AMOUNT, HF3_DIAMONDS3_AMOUNT, HF3_DIAMONDS4_AMOUNT,
            HF3_DIAMONDS5_AMOUNT, HF3_DIAMONDS6_AMOUNT };

    public static final int FACEBOOK_INVITE_FRIENDS = 1;
    public static final int FACEBOOK_POST_LEVELUP = 2;
    public static final int FACEBOOK_POST_MISSION = 3;

    public static final int SIZE_ACHIEVEMENTS = 15;
    public static final int SIZE_BUILDINGS = 27;
    public static final int SIZE_DECORATIONS = 22;
    public static final int SIZE_ANIMALS = 12;
    public static final int SIZE_CROPS = 29;
    public static final int SIZE_COLLECTIONS = 22;
}

