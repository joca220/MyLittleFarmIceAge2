//package de.softgames.mylittlefarm2;
//
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.StringTokenizer;
//import java.util.concurrent.ExecutionException;
//
//import pl.mobileforce.en.playstore.mylittlefarm.R;
//import android.content.Context;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Matrix;
//import android.graphics.Paint;
//import android.graphics.Paint.Align;
//import android.graphics.Typeface;
//import android.media.SoundPool;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//
//import com.facebook.Utility;
//import com.facebook.android.AsyncFacebookRunner;
//import com.facebook.android.Facebook;
//import com.flurry.android.FlurryAgent;
//
//import de.softgames.mylittlefarm2.GameCanvas.Profile;
//import de.softgames.mylittlefarm2.model.Explosion;
//
//
//public class GameThread extends Thread {
//
//    private static final String BUGS_TAG = "BugFixing";
//    private static final String TAG = GameThread.class.getSimpleName();
//
//    public static final int AUTHORIZE_ACTIVITY_RESULT_CODE = 0;
//    // Map Limits
//    private static final int MAT_SUP_X = 29;
//    private static final int MAT_SUP_Y = 29;
//    private static final int MAT_INF_X = 8;
//    private static final int MAT_INF_Y = 8;
//
//    private Resources mRes;
//    protected MyLittleFarm2Activity main;
//    private Context mContext;
//    public SurfaceHolder mSurfaceHolder;
//    protected float scaleFactor;
//    private boolean isResized = false;
//
//    private Bitmap tipsFarmer = null;
//    private Bitmap tiledGeneral = null;
//    private Bitmap[] tiledMap = new Bitmap[25];
//    private Bitmap[] iconAchievements = new Bitmap[Constants.SIZE_ACHIEVEMENTS];
//    private Bitmap[] iconCharacter = new Bitmap[8];
//    private Bitmap starAnimation1 = null;
//    private Bitmap starAnimation2 = null;
//    private Bitmap starAnimation3 = null;
//    private Bitmap starAnimation4 = null;
//    private Bitmap cloudAnimation1 = null;
//    private Bitmap cloudAnimation2 = null;
//    private Bitmap cloudAnimation3 = null;
//    private Bitmap iconProgress = null;
//    private Bitmap popTutorial = null;
//    private Bitmap iconTimePromotion = null;
//    private Bitmap shopBlocked = null;
//    private Bitmap[] iconAuxLevelUp = new Bitmap[3];
//    private Bitmap backgNoMoney = null;
//    private Bitmap offer = null;
//    private Bitmap[] iconMoreCoins = new Bitmap[6];
//    private Bitmap[] iconMoreDiamonds = new Bitmap[6];
//    //private Bitmap spriteTutorial = null;
//    private Bitmap spriteIconCrops = null;
//    //private Bitmap spriteIconsBuildings = null;
//    private Bitmap spriteIconAchievements = null;
//    private Bitmap spriteIconAnimals = null;
//    private Bitmap spriteIconCollections = null;
//    private Bitmap spriteIconDecorations = null;
//    private Bitmap spriteIconCharacters = null;
//    private Bitmap spriteIconGold = null;
//    private Bitmap spriteIconDiamonds = null;
//    private Bitmap spriteFoodIcons = null;
//    private Bitmap spriteMainMarketIcons = null;
//    private Bitmap[] iconCrops = new Bitmap[Constants.SIZE_CROPS];
//    private Bitmap[] iconBuilding = new Bitmap[Constants.SIZE_BUILDINGS];
//    private Bitmap[] iconAnimals = new Bitmap[Constants.SIZE_ANIMALS];
//    private Bitmap[] iconDecorations = new Bitmap[Constants.SIZE_DECORATIONS];
//    private Bitmap decorationsBg = null;
//    private Bitmap backgroundItemIcons = null;
//    private Bitmap backgroundGeneral = null;
//    private Bitmap backgroundItemShop = null;
//    private Bitmap backgroundPage = null;
//    private Bitmap buttonPagesActive = null;
//    private Bitmap buttonPages = null;
//    private Bitmap waterIcon = null;
//    private Bitmap backgroundItemMarket = null;
//    private Bitmap[] itemMarket = new Bitmap[6];
//    private Bitmap loadMoveFreeEmpty = null;
//    private Bitmap loadMoveFreeFull = null;
//    private Bitmap[] tiledExpansion = new Bitmap[16];
//    private Bitmap mineImage = null;
//    private Bitmap earthBad = null;
//    private Bitmap earthGood = null;
//    private Bitmap tiledSelected = null;
//    private Bitmap backgMsjSelected = null;
//    private Bitmap backgItemStorage = null;
//    private Bitmap opcExpand1 = null;
//    private Bitmap opcExpand2 = null;
//    private Bitmap backExpand = null;
//    private Bitmap backgCollections = null;
//    private Bitmap friendsAmount = null;
//    private Bitmap itemBackgFace = null;
//    private Bitmap buttonFacebook = null;
//    private Bitmap backgAllCollections = null;
//    private Bitmap backgRewardCollections = null;
//    private Bitmap starCollectionFull = null;
//    private Bitmap starCollectionEmpty = null;
//    private Bitmap buttonCashIn = null;
//    private Bitmap buttonCashInLocked = null;
//    private Bitmap barProgressAchievements = null;
//    private Bitmap achievementsBackgIcon = null;
//    private Bitmap barProgressAchievementsFull = null;
//    private Bitmap backgTask = null;
//    private Bitmap taskSelected = null;
//    private Bitmap taskItemBackg = null;
//    private Bitmap taskItemBackgBlock = null;
//    private Bitmap checkBig = null;
//    private Bitmap checkSmall = null;
//    private Bitmap loadingBarEmpty = null;
//    private Bitmap loadingBarFull = null;
//    private Bitmap backgAutomatic = null;
//    private Bitmap infoIconTip = null;
//    private Bitmap backgInfoProduct = null;
//    private Bitmap buildingPlusInfo = null;
//    private Bitmap productItemBackground = null;
//    private Bitmap productItemBackgroundInactive = null;
//    private Bitmap[] iconNoFood = new Bitmap[3];
//    private Bitmap productItemBackgroundSmall = null;
//    private Bitmap buttonCollect = null;
//    private Bitmap buttonFinish = null;
//    private Bitmap prodItemBackgSmallInac = null;
//    private Bitmap visitStoreImage = null;
//    private Bitmap iconMoreExpansion = null;
//    private Bitmap buttonProduceInactive = null;
//    private Bitmap truckDecoration = null;
//    private Bitmap[] screenTuto = new Bitmap[2];
//    private Bitmap backgDecoTruck = null;
//    private Bitmap bgTooltip = null;
//    private Bitmap bgQuestBoost = null;
//    private Bitmap iconRotate = null;
//    private Bitmap iconSaveToStorage = null;
//   // private Bitmap iconMoveDisabled = null;
//    private Bitmap iconWater = null;
//    private Bitmap iconHarverst = null;
//    private Bitmap buttonBoost = null;
//    private Bitmap lockObject = null;
//    private Bitmap cursorHand = null;
//    private Bitmap[] characterBig = new Bitmap[8];
//    private Bitmap backgroundCharacter = null;
//    private Bitmap quantityStorageIcon = null;
//    private Bitmap backgFoundCollection = null;
//    private Bitmap diamondSmall = null;
//    private Bitmap coinSmall = null;
//    private Bitmap flowerEmpty = null;
//    private Bitmap flowerFull = null;
//    private Bitmap xpSmall = null;
//    private Bitmap iconSmallEarth = null;
//    private Bitmap foodSmall = null;
//    private Bitmap foodMini = null;
//    private Bitmap detailItemShop = null;
//    private Bitmap buttonAddProductInactive = null;
//    private Bitmap buttonBuildInactive = null;
//    private Bitmap symbolPlus = null;
//    private Bitmap symbolEquals = null;
//    private Bitmap backgCollectSmall = null;
//    private Bitmap pointRedCollect = null;
//    private Bitmap iconVegetation = null;
//    private Bitmap starNivelFull = null;
//    private Bitmap starNivel = null;
//    private Bitmap carTruck = null;
//    private Bitmap carTruck2 = null;
//    private Bitmap carTruck3 = null;
//    private Bitmap carTruck4 = null;
//    
//    public int isForInviteFakebook = 0;
//    private Bitmap arrowMission = null;
//    private int animationArrowMission = 5;
//
//    private Image vegetationBad = null;
//    private Image stadisticMaster = null;
//    private Image[] collectionsImages = new Image[Constants.SIZE_COLLECTIONS];
//    private ImageButton buttonBuild = null;
//    private ImageButton buttonBack = null;
//    private ImageButton buttonArrow = null;
//    private ImageButton buttonArrowRigth = null;
//    private ImageButton buttonClose = null;
//    private ImageButton buttonCloseSmall = null;
//    private ImageButton panelCoins = null;
//    private ImageButton panelDiamonds = null;
//    private ImageButton panelSeeds = null;
//    private ImageButton starNivelEmpty = null;
//    private ImageButton iconMission = null;
//    private ImageButton iconHelper = null;
//    private ImageButton[] iconsMenuExpress = new ImageButton[5];
//    private ImageButton[] iconsMenuExpressActive = new ImageButton[2];
//    private ImageButton infoIcon = null;
//    private ImageButton buttonAddProduct = null;
//    private ImageButton buttonProduce = null;
//    private ImageButton buttonAccept = null;
//    private ImageButton buttonDenie = null;
//    private ImageButton checkedAutomatic = null;
//    private ImageButton checkedAutomaticSmall = null;
//    private ImageButton buttonUpgrade = null;
//    private ImageButton selectAll = null;
//    private ImageButton desSelectAll = null;
//    private ImageButton buttonAddHelper = null;
//    private ImageButton buttonInvite = null;
//
//    private Paint mPaint = new Paint();
//    // Facebook
//    public boolean pulblicMission = false;
//    public int facebookAction = 0;
//    public int fakeFriends = 0;
//    public int friendsFacebok = 0;
//    public int totalfriends = 0;
//    public int indexProFace = 0;
//    public boolean loadFriends = true;
//    public List<Profile> profilesFace = new ArrayList<Profile>();
//
//    private boolean mRun = false;
//    protected boolean errorGame = false;
//    protected boolean tutorialGame = true;
//    protected boolean isNoAdsItemPurchased = false;
//
//    private int totalQuantityFood = 100;
//    private int mCanvasHeight = 1;
//    private int mCanvasWidth = 1;
//
//    private int faceFriends_Y = 470;
//    private int pageCollection = 0;
//    private int pageAchievements = 0;
//    private int Pos_Init_Market_Y = 160;
//    private int diffItemGeneralShop = 18;
//
//    private long Time_EachSecond = 0;
//    private long timeAnimationShowCollection = 0;
//    private long timeAnimCloudUp = 0;
//    private boolean animationCollectionShow = false;
//    protected byte stateGame = -1;
//
//   // private int realNtree =  0;
//     
//    private int stepInAuxTutorial = 0;
//    protected int stepTutorial = -1;
//    protected int timeNotification = -1;
//    private int quantityPlots = 0;
//    private int limitTotalPlots = 6;
//    private byte backup_StateGame = -1;
//
//    private long timeSoundGame = 0;
//
//    private int[] characterChosen = new int[3];
//    private int[] missionCharacter = new int[3];
//    private boolean[] animationIconProgressCharacater = new boolean[3];
//    private int indexCharacterChosen = 0;
//
//    private int backupCharacterChosen = 0;
//
//    private int numberMaterial = 0;
//    private int[] quantityCurrentMaterial = new int[6];
//
//    private boolean doMove = false;
//    private boolean pressHold = false;
//    private boolean recentOpenMenuRotate = false;
//    private float posPressX = -1;
//    private float posPressY = -1;
//    
//    private float speedMoveMap_X = 20;
//    private float speedMoveMap_Y = 20;
//  //  private float positionFinal_X = 0;
//  //  private float positionFinal_Y = 0; 
//    private float distanceMoveMap_X = 0;
//    private float distanceMoveMap_Y = 0;
//    
//    private boolean correctPosition_X = false;
//    private boolean correctPosition_Y = false;
//   // private boolean movingtLeft = false;
//   // private boolean movingUp = false;
//    public boolean movingScreen = false;
//
//    // private boolean modeMove = false;
//    private boolean scrollingLeft = true;
//    private boolean animationScrolling = false;
//    private int scrollingCollection_X = 0;
//    private long timePrev = 0;
//    private long Time_Scrolling = 0;
//    private float rotateScale = 0.0f;
//    private long timeAnimationRotate = 0;
//    private long timeElementChosen = 0;
//    private int productShowInfo = 0;
//
//    private int elementChosen = -1;
//
//    private String[] permissions = { "offline_access", "publish_stream",
//            "user_photos", "publish_checkins", "photo_upload" };
//
//    private boolean animationCarTruck = true;
//    private boolean openMenuExpress = false;
//    private boolean runAnimationMenuExpress = false;
//    private boolean isOpenMenu = true;
//    private int spaceBetItem_X = 15;
//    private int spaceBetItem_Y = 5;
//
//    private Collection[] collectionPut = new Collection[22];
//    private CollectionWin[] collectionWin = new CollectionWin[32];
//    private int indexCollectionWin = 0;
//    private int spaceBetBorderBackgr = 40;
//    private int spaceBetBorderBackgrSuper = 170;
//    private int spaceLineMainMarket_Y = 15;
//    private int textMainMarket = 25;
//    private int diffAchivi_Y = 20;
//    private int achievementsDiffX = 20;
//    private int posPanelMarket_Y = 45;
//    private int posPanelTitleMarket_Y = 90;
//    private int posPanelCoinMarket_X = 20;
//    private int posPanelXpMarket_X = 180;
//
//    private boolean canProduce = false;
//
//    private int carTruckAnimation_X = 0;
//    private int carTruckAnimation_Y = 0;
//
//    private int posInitCar_X = 0;
//    private int posInitCar_Y = 0;
//
//    private int carTruck_X = 10;
//    private int carTruck_Y = 10;
//    private Explosion explosion;
//    private boolean explosionActive = false;
//
//    private int[] squareProduce = { 55, 430, 1150, 690 };
//    private int[] squareMission = { 120, 170, 780, 680 };
//    private int[] squareStorage = { 160, 830, 700 };
//
//    private int textInfoProduce_Y = 480;
//    private int titleGeneral_Y = 90;
//    private int titleAuxGeneral_Y = 124;
//    private int posButtonExpand_Y = 570;
//    private int posBackgExpand_Y = 190;
//
//    // Sizes items sprite
//    private int iconsSmallWidth = 91;
//    private int iconsSmallHeight = 91;
//    private int iconsAchievementsHeight = 103;
//    private int iconsBigWidth = 250;
//    private int iconsBigHeight = 200;
//    private int collectionsWidth = 247;
//    private int collectionsHeight = 50;
//  //  private int tutorialScreenWidth = 1280;
// //   private int tutorialScreenHeight = 752;
//    private int iconsCharactersWidth = 80;
//    private int iconsCharactersHeight = 100;
//    private int iconsMoreMoneyHeight = 130;
//    private int iconsMoreGoldWidth = 250;
//    private int iconsMoreDiamondsWidth = 216;
//
//    private int iconProduceFinal_X = 30;
//    private int timeProducFinal_Y = 85;
//    private int nameProductFinal_Y = 50;
//    private int plusFinal_X = 15;
//    private int plusFinalText_X = 19;
//    private int plusFinalText_Y = 20;
//    private int plusFinal_Y = 20;
//    private int posButBackgProduce_Y = 160;
//    private int restTaskBig_X = 40;
//    private int posBackgTask_Y = 175;
//    private int posBackgTask_X = 125;
//    private int buttonCashIn_X = 50;
//    private int buttonCashIn_Y = 60;
//    private int buildingChosen = -1;
//    private int nMission = 9;
//    
//    public boolean publicMission = false;
//    private int[] nTask = new int[9];
//    private int missionChosen = 0;
//    private int storageChosen = -1;
//    private int indexStorage = 0;
//    private int pageInStorage = 1;
//    private int nPageTotal = 0;
//   // private int[] cropsQuantityRecolect = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//     //       0, 0, 0, 0, 0 };
//    private int[][] itemStorage = new int[70][3];// [i][0]
//    private int[] itemCorrectStorage = new int[60];
//    private int indexCorrectStorage = 0;
//
//    private int infoTruckQuest_Y = 240;
//    private int infoTruckQuestQuantityY = 20;
//    private int typeQuest = 1;
//    private int quantityQuest = 10;
//    private int countTimeQuest = 0;
//    private boolean canRewardQuestTruck = false;
//    private boolean aceptQuestTruck = false;
//    private boolean chosenOptionQuestTruck = true;
//    private int rewardCoinTruckJoe = 0;
//    private int rewardXpTruckJoe = 0;
//
//    private int[][] quantityProduct = new int[9][6];
//    private int[][] typeProduct = new int[9][6];
//    private int[][] quantityProductDone = new int[9][6];
//    private int currentNumberMission = 0;
//    private boolean[] canRewardMission = new boolean[9];
//    private boolean[] rewardPaid = new boolean[9];
//
//   // private boolean animationIconProgress = false;
//    private int[] rewardsCoins = new int[9];
//    private int[] rewardsXP = new int[9];
//  //  private int[] rewardsTotalCoins = new int[9];
//  //  private int[] rewardsTotalXP = new int[9];
//    private int[] diamondsToFinishMission = new int[9];
//    private int[][] typeMission = new int[9][6];
//
//    private int positionDeco = 0;
//
//    private boolean animationHelpMe = false;
//    private boolean openMission = false;
//    private int indexAnimationHelpMe = 0;
//    private int timeAnimationHelp = 0;
//    private boolean[] animationNewCharacter = new boolean[3];
//    private long Time_NewCharacter = 0;
//
//    private boolean animationCursor = false;
//    private int itemToChoose = 0;
//    private int currentPage = 1;
//    private int nPages = 1;
//    private Typeface mFace = null;
//    private int startObjects = -1;
//    private int endObjects = 4;
//    private boolean animationMoveShop = false;
//    private int speed_Scroll_Market = 72;
//    private int moveShop_X = 0;
//    private int nameItemGeneral_Y = 40;
//    private int flowerMasteredText_Y = 120;
//    private int flowerMastered_Y = 70;
//    private int diamondsToBoost = 0;
//    private boolean storageFull = false;
//
//    private long timeShowInfoBox = 0;
//    private long timePressHold = 0;
//    private int totalQuantityStorage = 0;
//    private int maxItemStorage = 20;
//    private int quantityToSell = 0;
//    private int quantityFoodProduce = 0;
//    private int quantityCropForFood = 0;
//    private int quantityXPSell = 0;
//    private int quantityCoinSell = 0;
//    private int typeObjectInMiniOption = 0;
//    private int classObjectToMove = 0;
//    private int itemToReturnAgain = -1;
//
//    protected boolean animationCloudActive = false;
//    private int currentNumberCloud = 7;
//    private int posInitStar_X = 0;
//    private int posInitStar_Y = 0;
//
//    private int nameCropsAux_Y = 201;
//    private int imageAuxStor_Y = 265;
//    private int quantitySellStor_Y = 300;// 245;
//    private int chooseItemStor_Y = 320;
//    private int restPageStorage_X = 110;
//    private int storageTextRewardOffsetY = 25;
//
//    private int imageAuxFeedMill_Y = 260;
//    private int quantityCropForFood_Y = 310;
//    private int foodByCropsText_Y = 373;
//    private int foodByCropsText_X = 82;
//    private int foodMini_Y = 350;
//    private int foodMini_X = 62;
//
//    // Tutorial
//    private int tutorialTipTitleX = 80;
//    private int tutorialTipBodyY1 = 15;
//    private int tutorialBuildingTipX = 25;
//
//    private int posButtonLevelUp_Y = 540;
//    private int posButtonPromotion_Y = 540;
//    private int posButtonUpgrade_Y = 540;
//    private int posIconBackgUpgrade_Y = 240;
//    private int levelUpInfo_Y = 260;
//    private int levelUpDiamondSmallX = 25;
//    private int levelUpMsgX = 600;
//    private int levelUpMsgY = 150;
//
//    private int truckOffsetTaskBgX = 20;
//    private int buttonOffsetTextY = 70;
//    private int suggestionMsgTextOffsetY = 22;
//    private int suggestionMsgTimeOffsetY = 70;
//    private int suggestionMsgIconOffsetY = 60;
//    private int achievementsOffsetX = 25;
//
//    private int missionCharacterIconX = 60;
//    private int missionCharacterIconY = 190;
//    private int characterOffsetY = 160;
//
//    private int infoProductsTitleOffsetY = 100;
//    private int infoProductsBodyOffsetY = 190;
//
//    // Initial sizes elements to scale
//    private int missionOffsetTextY = 70;
//    private int missionOffsetCharacterY = 140;
//    private int missionOffsetCharacterX = 35;
//    private int missionOffsetIconX = 60;
//    private int missionOffsetIconY = 190;
//    private int missionOffsetText2Y = 130;
//    private int missionOffsetText2X = 200;
//    private int missionOffsetText3X = 260;
//    private int missionOffsetText3Y = 180;
//    private int missionOffsetText4Y = 250;
//
//    private int facebookTotalFriendsOffsetY = 60;
//    private int facebookOffsetHelperTextX = 20;
//    private int facebookOffsetDiamondX = 55;
//    private int facebookOffsetDiamondY = 20;
//    private int facebookOffsetToPayY = 40;
//
//    private int levelUpOffsetTitleY = 200;
//    private int levelUpOffsetInfoY = 240;
//
//    private int winMaterialOffsetTextY = 240;
//    private int infoTruckQuestIconCropY = 50;
//    private int generalShopOffsetPanelDiamondsX = 160;
//    private int generalShopOffsetY = 10;
//
//    private int collectionsDiffX = 20;
//    private int collectionsDiffY = 20;
//
//    private int bonusOffsetX = 60;
//
//    private int boostBuildingTitleOffsetY = 90;
//    private int boostBuildingInfoOffsetY = 180;
//
//    private int quantityStorageBubbleOffsetY = 40;
//    private int quantityStorageBubbleOffsetX = 115;
//
//    private int tutorialTipTextOffsetX = 80;
//    private int tutorialTipTextDiffY = 20;
//    private int tutorialTipTextOffsetY = 15;
//    private int arrowRightOffsetX = 800;
//
//    // Offsets state plow full
//    private int popUpOffsetX = 50;
//    private int popUpOffsetInitY = 130;
//    private int popUpFullOffsetEndY = 40;
//    private int popUpFullOffsetIconX = 30;
//    private int popUpFullOffsetIconY = 10;
//
//    // Offsets collections
//    private int collectionsBgOffsetX = 15;
//    private int collectionsBgOffsetY = 45;
//    private int collectionsTextOffsetX = 25;
//    private int collectionsTextOffsetY = 30;
//
//    private int collectionShowOffsetX = 20;
//    private int collectionShowOffsetY = 120;
//    private int collectionShowTextOffsetY = 30;
//
//    private int winMaterialBtnBuildOffsetY = 550;
//
//    private int moreCurrencyItemOffsetX = 135;
//    private int specialOfferTimerOffsetY = 520;
//    private int specialOfferAmountY = 215;
//
//    private int numberStarAnimation = 7;
//
//    private int[] starAnimationType = new int[numberStarAnimation];
//    private int[] cloudAnimationType = { 1, 1, 2, 1, 3, 2, 1 };
//    private int[] cloudAnimation1_X = new int[13];
//    private int[] cloudAnimation1_Y = new int[13];
//
//    private int[] starAnimation_X = new int[13];
//    private int[] starAnimation_Y = new int[13];
//
//    private int countAnimation = 0;
//
//    private int iconProductReady_Y = 70;
//    private int nameIconProReady_Y = 43;
//    private int quantityNeedCrops_Y = 17;
//    private int addTutoInfo_Y = 55;
//    private int addTutoTitle_Y = 30;
//    private int posSlotProduce_Y = 500;
//    private int animationProgress_X = 10;
//    private int countAnimationProgress = 0;
//    private long timeAnimationProgress = 0;
//    private long timeShakeCharacter = 0;
//    private long time_showIconTrucker = 0;
//
//    private String[] nameAuxLevelUp = new String[3];
//    private boolean showIconMsgTuto = true;
//    private boolean dissapearActive = false; 
//    private int character_X = 0;
//    private int countShakeCharacter = 0;
//
//    // private int[][] poScreenAutomatic = { { -567, 1218 }, };
//    // private int indexScreenAutomatic = 0;
//
//    private boolean dissapearMsj = false;
//    private int indexIconAux = 0;
//    private int loadedMainGame = -25;
//    private int productChosen = 0;
//    private int animationHold = 1;
//    private int contMoveAnimationShop = 0;
//    private boolean animationShopLeft = true;
//
//    private int[][] posTiledTutorial = { { 23, 19, 0 }, { 23, 18, 0 },
//            { 23, 17, 0 }, { 24, 19, 0 }, { 24, 18, 0 }, { 24, 17, 0 }, };
//
//    private int promotionInfoDiff_X = 80;
//    private int promotionInfo_Y = 220;
//
//    private int addTaskSelect_Y = 29;
//    private long Time_AnimationCursor = 0;
//    private int addIconAchi_Y = 20;
//    private int addNameAchie_Y = 40;
//    private int addNameAchie_X = 20;
//    private int cursorY = 0;
//    private int coinIconMission_Y = 80;
//    private int startIconMission_Y = 125;
//    private int posNoFood_Y = 270;
//    private int infoAchiviements_Y = 60;
//    private long timeStorageCapacity = 0;
//    private boolean showPaintStorageCapacity = false;
//
//    private int textNivel_X = 50;
//    private int textNivel_Y = 10;
//    private int initPosStorage_Y = 165;
//    private long Time_CarTruck = 0;
//    private long timeShowIconMsgTuto = 0;
//    private long Time_Animation_Bar = 0;
//    private int indexBarAccion = 1;
//    private int currentMultitouch = 0;
//    protected int indexMultitouch = 0;
//    protected boolean stateOnlyGreen = false;
//    private int[] multitouch_X = new int[225];
//    private int[] multitouch_Y = new int[225];
//
//    private int posButtonInviteY = 60;
//    private int posButtonAddFriendY = 40;
//    private int posButtonFriendsAmountY = 50;
//    private int diffItemButtonFriends = 22;
//
//    private boolean missionFading = false;
//    private boolean canShowInfoAuto = false;
//    // Tree crops
//    private int NTree = 0;
//    private Crop[] tree = new Crop[600];
//
//    private boolean comeStorage = false;
//    private int[][] mapContaints = new int[Constants.N_TILED_WORLD_Y][Constants.N_TILED_WORLD_X];
//    private int[][] mapObjects = new int[Constants.N_TILED_WORLD_Y][Constants.N_TILED_WORLD_X];
//    private int[][] mapExpansion = new int[7][7];
//    private int initExpand_X = 0;
//    private int initExpand_Y = 0;
//
//    Building[] buildingsPut = new Building[50];
//    Building[] buildingsSaveStorage = new Building[20];
//    private int indexBuildSaveStorage = 0;
//    private int nBuildingsPut = 0;
//    Animal[] animalsPut = new Animal[150];
//    int nAnimalsPut = 0;
//    int orderAnimalChosen = 0;
//    Decoration[] decorationsPut = new Decoration[150];
//    int nDecorationsPut = 0;
//
//    private int actionBoost = -1;
//    private int decorationChosen = -1;
//    private int animalChosen = -1;
//    private int cropChosen = -1;
//    private int timeOpenGame = 1;
//    private int timeSecondsOffer = 15 * 60;
//    private boolean runningBonus = false;
//
//    
//    private long loopStart;
//	private long loopEnd;
//	public long  loopPause;
//	
//    private boolean userPurchased = false;
//    protected int quantityExp = 0;
//    protected int quantityDiamonds = Constants.INITIAL_DIAMONDS;
//    protected int quantityCoins = Constants.INITIAL_GOLD;
//    protected int quantitySeeds = 20;
//    private int nLevel = 0;
//    private int currentDiscount = 40;
//    private int itemSelected = -1;
//    private int diamondsFound = 0;
//    private boolean canBeDragged = false;
//    private boolean showPaintDiamondsFound = false;
//    private boolean animationQuantity = true;
//    private int contAnimationQuantity = 0;
//    private int showProductAnimal = 0;
//    private long animationQuantityTime = 0;
//    private int posAnimationQuantity_Y = 0;
//    private int posAnimationQuantity_X = 0;
//    private int showDiamonds = 0;
//    private int showCoins = 0;
//    private int showExp = 0;
//    private int showFood = 0;
//    private int showMastered = 0;
//    private int showIconProduce = 0;
//    private int typeIconProduced = 0;
//    private boolean actionMandatory = false;
//    private int actionMandatory_X = 0;
//    private int actionMandatory_Y = 0;
//
//    private Paint fontAttriItemShop = null;
//    private Paint fontTimeItemShop = null;
//    private Paint fontNameItems = null;
//    private Paint fontMoneyToPay = null;
//    private Paint fontNameItemMarket = null;
//    private Paint fontAnimationQuantity = null;
//    private Paint fontQuantityMaterialProduce = null;
//    private Paint fontMainUi = null;
//    private Paint fontTitleCenter = null;
//    private Paint fontTitleLeft = null;
//    private Paint fontMsjTitle = null;
//    private Paint fontMsjTitleStroke = null;
//    private Paint fontYellowSmallLef = null;
//    private Paint fontQuantityItemSell = null;
//    private Paint fontYellowMed = null;
//    private Paint fontShowNivel = null;
//    private Paint fontWhiteSmallCenter = null;
//    private Paint fontBlackSmallCenter = null;
//    private Paint fontPaintMsjGame = null;
//    private Paint fontPaintMsjGameBig = null;
//    private Paint fontNameBuildingItems = null;
//    private Paint fontWhiteSmallLeft = null;
//    private Paint fontTitleTutorial = null;
//    private Paint fontBodyTutorial = null;
//    private Paint fontTitleTutorialStroke = null;
//    private Paint fontBodyTutorialStroke = null;
//
//    private int[][] tiledChosen;
//    private int animalBuildingOwner = 0;
//
//    protected enum Action {
//        HARVEST, PLANT, PLOW, FERTILIZE, BUILDING, REMOVE_VEGETATION, ANIMAL, WATERING, DECORATION, SAVEDECORATION, SAVEANIMAL, SAVEBUILDING, ANIMAL_FOOD, BUILDINGFINISHALL, ANIMALFINISHALL
//    };
//
//    private int typeActionAutomatic = -1;
//    protected Action actionSelect = null;
//
//    private enum MsgSuggest {
//        MSJRECOLECT, MSJPLANT, MSJPLOW, MSJFERTILIZE, MSJVEGETATION, MSJANIMAL, MSJBUILDING, MSJWATERING, MSJDECORATION
//    };
//
//    private enum TypeMsgInfo {
//        AUTOMATIC, STORAGEFULL, MOVE, PLOTSFULL, PUTANIMAL, MOVEBAD, FINISH_PRODUCTION, LEVEL_UP_FIRST
//    }
//
//    private TypeMsgInfo typeMsgInfo = null;
//    private int quantRemoVege = 0;
//
//    private MsgSuggest msgSelect = null;
//
//    protected String[] levels = new String[Constants.ARRAY_LEVELS_MAX_LINES];
//    protected String[] texts = new String[Constants.ARRAY_TEXTS_MAX_LINES];
//    private boolean mainImagesLoaded = false;
//
//    private int typeCropsMastered = 0;
//    
//    
//    public static  int SOUND_MISSION_COMPLETE = 1;
//    public static  int SOUND_LEVEL_UP = 2;
//    public static  int SOUND_ACHIEVEMENT_COMPLETE = 3;
//    public static  int SOUND_CONSTRUCTION_PLACED = 4;
//    public static  int SOUND_FEED_ANIMAL = 5;
//    public static  int SOUND_CONSTRUCTION_BOOST = 6;
//    public static  int SOUND_CONSTRUCTION_FINISHED = 7;
//    public static  int SOUND_RANDOM_BACKGROUND_SOUND = 8;
//    public static  int SOUND_RANDOM_BACKGROUND_SOUND2 = 9;
//    public static  int SOUND_RANDOM_BACKGROUND_SOUND3 = 10;
//    public static  int SOUND_BAKERY = 11;
//    public static  int SOUND_CAKESHOP = 12;
//    public static  int SOUND_ANIMAL_FOODMACHINE = 13;
//    public static  int SOUND_DAIRY = 14;
//    public static  int SOUND_SUGARFACTORY = 15;
//    public static  int SOUND_TAILOR = 16;
//    public static  int SOUND_WEAVING = 17;
//    public static  int SOUND_MILL = 18;
//    public static  int SOUND_GRILL = 19;
//    public static  int SOUND_GOURMET = 20;
//    public static  int SOUND_JUICERY = 21;
//    public static  int SOUND_CHICKEN = 22;
//    public static  int SOUND_COW = 23;
//    public static  int SOUND_SHEEP = 24;
//    public static  int SOUND_PIG = 25;
//    public static  int SOUND_GOAT = 26;
//
//    public static  int SOUND_EARNED_GOLD = 27;
//    public static  int SOUND_EARNED_DIAMONDS = 28;
//    public static  int SOUND_EARNED_XP = 29;
//    public static  int SOUND_SPENT_DIAMONDS = 30;
//    public static  int SOUND_SPENT_GOLD = 31;
//    public static  int SOUND_PLOW = 32;
//    public static  int SOUND_HARVEST = 33;
//    public static  int SOUND_PLANT = 34;
//    public static  int SOUND_CLICK = 35;
//    public static  int SOUND_BUILDING_UPGRADE = 36;
//    public static  int SOUND_REMOVE_GRASS = 37;
//    public static  int SOUND_REMOVE_STONE = 38;
//    public static  int SOUND_REMOVE_TREE = 39;
//    public static  int SOUND_AREA_UNLOCKED = 40;
//    public static SoundPool mySoundEffects;
//    
//    //loadStates
//  /*  private boolean loadStateAchievements = false;
//    private boolean loadStateCollections = false;
//    private boolean loadStateMission = false;
//    private boolean loadStateTruckQuest = false;
//    private boolean loadStateFacebook = false;
//    private boolean loadStateProduction = false;*/
//
//    /**
//     * Main Thread constructor
//     * 
//     * @param surfaceHolder
//     * @param context
//     */
//    public GameThread(SurfaceHolder surfaceHolder, Context context) {
//
//        mSurfaceHolder = surfaceHolder;
//        mContext = context;
//        mRes = context.getResources();
//        mFace = Typeface.createFromAsset(mContext.getAssets(), "vag1.ttf");
//        World.posWorldX = -567;
//        World.posWorldY = -1218;
//        initSound();
//        
//      
//    }
//    
//    private void initSound(){
//    	mySoundEffects = new SoundPool(40, 3, 0);
//
//                  SOUND_MISSION_COMPLETE = mySoundEffects.load(mContext, R.raw.mission_complete, 1);
//                     
//
//                  SOUND_LEVEL_UP = mySoundEffects.load(mContext,R.raw.level_up, 1);
//                     
//
//                  SOUND_ACHIEVEMENT_COMPLETE = mySoundEffects.load(mContext,R.raw.achievement_complete, 1);
//                     
//
//                  SOUND_CONSTRUCTION_PLACED = mySoundEffects.load(mContext,R.raw.construction_placed, 1);
//                     
//                  SOUND_FEED_ANIMAL = mySoundEffects.load(mContext,R.raw.feed_animal, 1);
//                     
//                  SOUND_CONSTRUCTION_BOOST = mySoundEffects.load(mContext,R.raw.construction_boost, 1);
//                     
//                  SOUND_CONSTRUCTION_FINISHED = mySoundEffects.load(mContext,R.raw.construction_finished, 1);
//                     
//
//                  SOUND_RANDOM_BACKGROUND_SOUND = mySoundEffects.load(mContext,R.raw.random_background_sound, 1);
//                     
//                  SOUND_RANDOM_BACKGROUND_SOUND2 = mySoundEffects.load(mContext,R.raw.random_background_sound2, 1);
//                     
//                  SOUND_RANDOM_BACKGROUND_SOUND3 = mySoundEffects.load(mContext,R.raw.random_background_sound3, 1);
//                     
//
//                  SOUND_BAKERY = mySoundEffects.load(mContext,R.raw.bakery, 1);
//                     
//                  SOUND_CAKESHOP = mySoundEffects.load(mContext,R.raw.cakeshop, 1);
//                     
//                  SOUND_ANIMAL_FOODMACHINE = mySoundEffects.load(mContext,R.raw.animal_foodmachine, 1);
//                     
//                  SOUND_DAIRY = mySoundEffects.load(mContext,R.raw.dairy, 1);
//                     
//
//                  SOUND_SUGARFACTORY = mySoundEffects.load(mContext,R.raw.sugarfactory, 1);
//                     
//                  SOUND_TAILOR = mySoundEffects.load(mContext,R.raw.tailor, 1);
//                     
//                  SOUND_WEAVING = mySoundEffects.load(mContext,R.raw.weaving, 1);
//                     
//                  SOUND_MILL = mySoundEffects.load(mContext,R.raw.mill, 1);
//                     
//                  SOUND_GRILL = mySoundEffects.load(mContext,R.raw.grill, 1);
//                     
//                  SOUND_GOURMET = mySoundEffects.load(mContext,R.raw.gourmet, 1);
//                     
//                  SOUND_JUICERY = mySoundEffects.load(mContext,R.raw.juicery, 1);
//                     
//
//                  SOUND_CHICKEN = mySoundEffects.load(mContext,R.raw.chicken, 1);
//                     
//                  SOUND_COW = mySoundEffects.load(mContext,R.raw.cow, 1);
//                     
//                  SOUND_SHEEP = mySoundEffects.load(mContext,R.raw.sheep, 1);
//                     
//                  SOUND_PIG = mySoundEffects.load(mContext,R.raw.pig, 1);
//                     
//                  SOUND_GOAT = mySoundEffects.load(mContext,R.raw.goat, 1);
//                     
//
//                  SOUND_EARNED_GOLD = mySoundEffects.load(mContext,R.raw.earn_money, 1);
//                     
//                  SOUND_EARNED_DIAMONDS = mySoundEffects.load(mContext,R.raw.diamond_earn, 1);
//                     
//                  SOUND_EARNED_XP = mySoundEffects.load(mContext,R.raw.exp_earn, 1);
//                     
//                  SOUND_SPENT_DIAMONDS = mySoundEffects.load(mContext,R.raw.diamond_spent, 1);
//                     
//                  SOUND_SPENT_GOLD = mySoundEffects.load(mContext,R.raw.gold_spent, 1);
//                     
//                  SOUND_PLOW = mySoundEffects.load(mContext,R.raw.plow_field, 1);
//                     
//                  SOUND_HARVEST = mySoundEffects.load(mContext,R.raw.harvest_crops, 1);
//                     
//                  SOUND_PLANT = mySoundEffects.load(mContext,R.raw.plant_crops, 1);
//                     
//                  SOUND_CLICK = mySoundEffects.load(mContext,R.raw.click_navigation, 1);
//                     
//                  SOUND_BUILDING_UPGRADE = mySoundEffects.load(mContext,R.raw.upgrade_building, 1);
//                     
//                  SOUND_REMOVE_GRASS = mySoundEffects.load(mContext,R.raw.remove_grass, 1);
//                     
//                  SOUND_REMOVE_STONE = mySoundEffects.load(mContext,R.raw.remove_stone, 1);
//                     
//                  SOUND_REMOVE_TREE = mySoundEffects.load(mContext,R.raw.remove_tree, 1);
//                     
//
//                  SOUND_AREA_UNLOCKED = mySoundEffects.load(mContext,R.raw.unlock_area, 1);
//                     
//                 
// }
//
//    /**
//     * AsyncTask to load the bitmaps off the main thread
//     * 
//     * @param path
//     *            in the file system
//     * @param isResizable
//     *            whether we want to resize the image or not
//     * @return
//     */
//    private Bitmap loadBitmap(String path, boolean isResizable) {
//        BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(mCanvasWidth,
//                mCanvasHeight, mRes, isResizable, mContext);
//        Bitmap bitmap = null;
//        try {
//            bitmap = bitmapWorkerTask.execute(path).get();
//        } catch (InterruptedException e) {
//            Log.e(TAG, "InterruptedException");
//        } catch (ExecutionException e) {
//            Log.e(TAG, "ExecutionException");
//        }
//        return bitmap;
//    }
//    
//    protected Bitmap loadImageAssetsSimple(String name, boolean isResizable) {
//        InputStream is = null;
//        Bitmap asset = null;
//
//        try {
//            is = mRes.getAssets().open(name);
//        } catch (IOException e) {
//            Log.e(TAG, "Error loading " + name);
//        }
//
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPurgeable = true;
//        options.inInputShareable = true;
//        asset = BitmapFactory.decodeStream(is, null, options);
//
//        if (isResizable) {
//           // Log.d(TAG, "loadImageAssetsSimple(" + name + ")");
//            asset = UtilSoftgames.resizeToCalculatedResolution(asset,
//                    mCanvasWidth, mCanvasHeight);
//        }
//        return asset;
//    }
//
//    private void doExpansion(boolean isRandom) {
//        Log.d(TAG, "doExpansion()");
//        for (int i = initExpand_Y; i < initExpand_Y + 4; i++) {
//            for (int j = initExpand_X; j < initExpand_X + 4; j++) {
//                if (isRandom) {
//                    mapContaints[i][j] = UtilSoftgames.random(22, 26);
//                } else {
//                    mapContaints[i][j] = Constants.EMPTY;
//                }
//            }
//        }
//    }
//
//    private void inicializateCollections() {
//        for (int i = 0; i < 22; i++) {
//            collectionPut[i] = new Collection();
//        }
//    }
//
//    private void inicializateExpansion() {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                mapExpansion[i][j] = 1;
//            }
//        }
//
//        mapExpansion[1][3] = 0;
//        mapExpansion[2][3] = 0;
//        mapExpansion[2][4] = 0;
//    }
//
//    private void insertFeedMill() {
//        Log.d(TAG, "insertFeedMill()");
//        int nTiledAdd = 6;
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                int posTiledX = (j * 4) + 3 + nTiledAdd;
//                int posTiledY = (i * 4) + 3 + nTiledAdd;
//                mapContaints[posTiledY][posTiledX] = Constants.EXPANSION;
//                mapContaints[posTiledY][posTiledX + 1] = Constants.EXPANSIONLIMBO;
//                mapContaints[posTiledY][posTiledX + 2] = Constants.EXPANSIONLIMBO2;
//                mapContaints[posTiledY][posTiledX + 3] = Constants.EXPANSIONLIMBO3;
//
//                mapContaints[posTiledY + 1][posTiledX] = Constants.EXPANSIONLIMBO4;
//                mapContaints[posTiledY + 1][posTiledX + 1] = Constants.EXPANSIONLIMBO5;
//                mapContaints[posTiledY + 1][posTiledX + 2] = Constants.EXPANSIONLIMBO6;
//                mapContaints[posTiledY + 1][posTiledX + 3] = Constants.EXPANSIONLIMBO7;
//
//                mapContaints[posTiledY + 2][posTiledX] = Constants.EXPANSIONLIMBO8;
//                mapContaints[posTiledY + 2][posTiledX + 1] = Constants.EXPANSIONLIMBO9;
//                mapContaints[posTiledY + 2][posTiledX + 2] = Constants.EXPANSIONLIMBO10;
//                mapContaints[posTiledY + 2][posTiledX + 3] = Constants.EXPANSIONLIMBO11;
//
//                mapContaints[posTiledY + 3][posTiledX] = Constants.EXPANSIONLIMBO12;
//                mapContaints[posTiledY + 3][posTiledX + 1] = Constants.EXPANSIONLIMBO13;
//                mapContaints[posTiledY + 3][posTiledX + 2] = Constants.EXPANSIONLIMBO14;
//                mapContaints[posTiledY + 3][posTiledX + 3] = Constants.EXPANSIONLIMBO15;
//
//            }
//        }
//
//        for (int i = 7 + nTiledAdd; i < 11 + nTiledAdd; i++) {
//            for (int j = 15 + nTiledAdd; j < 19 + nTiledAdd; j++) {
//                mapContaints[i][j] = Constants.EMPTY;
//            }
//        }
//        for (int i = 11 + nTiledAdd; i < 15 + nTiledAdd; i++) {
//            for (int j = 15 + nTiledAdd; j < 23 + nTiledAdd; j++) {
//                mapContaints[i][j] = Constants.EMPTY;
//            }
//        }
//        inicializatePosCar();
//
//        int[] posBuilding_X = { 15 + nTiledAdd, 15 + nTiledAdd, 15 + nTiledAdd,
//                17 + nTiledAdd };
//        int[] posBuilding_Y = { 11 + nTiledAdd, 7 + nTiledAdd, 9 + nTiledAdd,
//                7 + nTiledAdd };
//
//        int classType = 0;
//        int type = 16;
//        boolean haveLimbo = false;
//        for (int i = 0; i < 4; i++) {
//            switch (i) {
//            case 0:
//                classType = Constants.FARMHOUSE;
//
//                haveLimbo = true;
//                break;
//            case 1:
//                classType = Constants.BARN;
//
//                haveLimbo = true;
//                break;
//            case 2:
//                classType = Constants.FOODMILL;
//
//                haveLimbo = false;
//                break;
//            case 3:
//                classType = Constants.BUILDINGNORMAL;
//
//                haveLimbo = false;
//                break;
//            }
//            buildingsPut[nBuildingsPut] = new Building(posBuilding_X[i],
//                    posBuilding_Y[i], type + i, classType, haveLimbo);
//            mapContaints[posBuilding_Y[i]][posBuilding_X[i]] = Constants.EARTH_BUILDING;
//            mapObjects[posBuilding_Y[i]][posBuilding_X[i]] = nBuildingsPut;
//
//            if (i == 3) {
//                buildingsPut[nBuildingsPut].setShowTimeUnderConstruction(false);
//                buildingsPut[nBuildingsPut].setReady(true);
//                buildingsPut[nBuildingsPut]
//                        .setUpdgrade(buildingsPut[nBuildingsPut].getUpdgrade() + 1);
//            }
//            nBuildingsPut++;
//
//            if (haveLimbo) {
//                mapContaints[posBuilding_Y[i]][posBuilding_X[i]] = Constants.LIMBOBUILDING;
//                mapContaints[posBuilding_Y[i]][posBuilding_X[i] + 1] = Constants.LIMBOBUILDING;
//                mapContaints[posBuilding_Y[i] + 1][posBuilding_X[i]] = Constants.EARTH_BUILDING;
//                mapContaints[posBuilding_Y[i] + 1][posBuilding_X[i] + 1] = Constants.LIMBOBUILDING;
//            }
//
//            loadBuildingsImg(type + i, 0);
//        }
//
//    }
//
//    private void inicializatePosCar() {
//        Log.d(TAG, "inicializatePosCar()");
//        posInitCar_X = 29;
//        posInitCar_Y = 4;
//        int[] posCar = calculatePosInitialMap(posInitCar_X, posInitCar_Y);
//        carTruck_X = posCar[0];
//        carTruck_Y = posCar[1];
//    }
//
//    private void changeSize() {
//        Log.d(BUGS_TAG, "changeSize() mCanvasWidth: " + mCanvasWidth
//                + ", mCanvasHeight: " + mCanvasHeight);
//        double divisor = 1;
//        double multiplicator = 1;
//
//        if (mCanvasWidth == 854 && mCanvasHeight == 480) {
//            multiplicator = 1.276;
//            divisor = 2;
//        } else if (mCanvasWidth == 800 && mCanvasHeight == 480) {
//            multiplicator = 1.276;
//            divisor = 2;
//        } else if (mCanvasWidth == 480 && mCanvasHeight == 320) {
//            multiplicator = 0.4255;
//            divisor = 1;
//        } else if (mCanvasWidth == 320 && mCanvasHeight == 240) {
//            multiplicator = 7;
//            divisor = 22;
//        } else if (mCanvasWidth == 960 && mCanvasHeight == 540) {
//            multiplicator = 1.435;
//            divisor = 2;
//        } else if (mCanvasWidth == 1024 && mCanvasHeight == 600) {
//            multiplicator = 4;
//            divisor = 5;
//        } else if (mCanvasWidth == 1280 && mCanvasHeight == 720) {
//            multiplicator = 1.9145;
//            divisor = 2;
//        } else if (mCanvasWidth == 1280 && mCanvasHeight == 736) {
//            multiplicator = 0.9787;
//            divisor = 1;
//        } else if (mCanvasWidth == 1920 && mCanvasHeight == 1080) {
//            multiplicator = 1.4357;
//            divisor = 1;
//        } else if (mCanvasWidth == 1920 && mCanvasHeight == 1200) {
//            multiplicator = 1.595;
//            divisor = 1;
//        }
//
//        tutorialBuildingTipX = (int) Math
//                .round((tutorialBuildingTipX / divisor) * multiplicator);
//        achievementsOffsetX = (int) Math.round((achievementsOffsetX / divisor)
//                * multiplicator);
//
//        levelUpMsgX = (int) Math.round((levelUpMsgX / divisor) * multiplicator);
//        levelUpMsgY = (int) Math.round((levelUpMsgY / divisor) * multiplicator);
//
//        truckOffsetTaskBgX = (int) Math.round((truckOffsetTaskBgX / divisor)
//                * multiplicator);
//        missionCharacterIconX = (int) Math
//                .round((missionCharacterIconX / divisor) * multiplicator);
//        missionCharacterIconY = (int) Math
//                .round((missionCharacterIconY / divisor) * multiplicator);
//        buttonOffsetTextY = (int) Math.round((buttonOffsetTextY / divisor)
//                * multiplicator);
//
//        facebookTotalFriendsOffsetY = (int) Math
//                .round((facebookTotalFriendsOffsetY / divisor) * multiplicator);
//        facebookOffsetHelperTextX = (int) Math
//                .round((facebookOffsetHelperTextX / divisor) * multiplicator);
//        facebookOffsetDiamondX = (int) Math
//                .round((facebookOffsetDiamondX / divisor) * multiplicator);
//        facebookOffsetDiamondY = (int) Math
//                .round((facebookOffsetDiamondY / divisor) * multiplicator);
//        facebookOffsetToPayY = (int) Math
//                .round((facebookOffsetToPayY / divisor) * multiplicator);
//
//        characterOffsetY = (int) Math.round((characterOffsetY / divisor)
//                * multiplicator);
//
//        infoProductsTitleOffsetY = (int) Math
//                .round((infoProductsTitleOffsetY / divisor) * multiplicator);
//        infoProductsBodyOffsetY = (int) Math
//                .round((infoProductsBodyOffsetY / divisor) * multiplicator);
//
//        spaceBetBorderBackgrSuper = (int) Math
//                .round((spaceBetBorderBackgrSuper / divisor) * multiplicator);
//        Pos_Init_Market_Y = (int) Math.round((Pos_Init_Market_Y / divisor)
//                * multiplicator);
//        diffItemGeneralShop = (int) Math.round((diffItemGeneralShop / divisor)
//                * multiplicator);
//        posPanelMarket_Y = (int) Math.round((posPanelMarket_Y / divisor)
//                * multiplicator);
//        posPanelTitleMarket_Y = (int) Math
//                .round((posPanelTitleMarket_Y / divisor) * multiplicator);
//        posPanelCoinMarket_X = (int) Math
//                .round((posPanelCoinMarket_X / divisor) * multiplicator);
//        posPanelXpMarket_X = (int) Math.round((posPanelXpMarket_X / divisor)
//                * multiplicator);
//        spaceLineMainMarket_Y = (int) Math
//                .round((spaceLineMainMarket_Y / divisor) * multiplicator);
//        textMainMarket = (int) Math.round((textMainMarket / divisor)
//                * multiplicator);
//        promotionInfoDiff_X = (int) Math.round((promotionInfoDiff_X / divisor)
//                * multiplicator);
//        promotionInfo_Y = (int) Math.round((promotionInfo_Y / divisor)
//                * multiplicator);
//        flowerMasteredText_Y = (int) Math
//                .round((flowerMasteredText_Y / divisor) * multiplicator);
//        flowerMastered_Y = (int) Math.round((flowerMastered_Y / divisor)
//                * multiplicator);
//        nameItemGeneral_Y = (int) Math.round((nameItemGeneral_Y / divisor)
//                * multiplicator);
//        faceFriends_Y = (int) Math.round((faceFriends_Y / divisor)
//                * multiplicator);
//        collectionsDiffX = (int) Math.round((collectionsDiffX / divisor)
//                * multiplicator);
//        collectionsDiffY = (int) Math.round((collectionsDiffY / divisor)
//                * multiplicator);
//
//        iconProductReady_Y = (int) Math.round((iconProductReady_Y / divisor)
//                * multiplicator);
//        nameIconProReady_Y = (int) Math.round((nameIconProReady_Y / divisor)
//                * multiplicator);
//        quantityNeedCrops_Y = (int) Math.round((quantityNeedCrops_Y / divisor)
//                * multiplicator);
//
//        textNivel_X = (int) Math.round((textNivel_X / divisor) * multiplicator);
//        textNivel_Y = (int) Math.round((textNivel_Y / divisor) * multiplicator);
//        textInfoProduce_Y = (int) Math.round((textInfoProduce_Y / divisor)
//                * multiplicator);
//        titleGeneral_Y = (int) Math.round((titleGeneral_Y / divisor)
//                * multiplicator);
//        titleAuxGeneral_Y = (int) Math.round((titleAuxGeneral_Y / divisor)
//                * multiplicator);
//        infoAchiviements_Y = (int) Math.round((infoAchiviements_Y / divisor)
//                * multiplicator);
//        addIconAchi_Y = (int) Math.round((addIconAchi_Y / divisor)
//                * multiplicator);
//        posBackgTask_Y = (int) Math.round((posBackgTask_Y / divisor)
//                * multiplicator);
//        posBackgTask_X = (int) Math.round((posBackgTask_X / divisor)
//                * multiplicator);
//        addTaskSelect_Y = (int) Math.round((addTaskSelect_Y / divisor)
//                * multiplicator);
//        coinIconMission_Y = (int) Math.round((coinIconMission_Y / divisor)
//                * multiplicator);
//        startIconMission_Y = (int) Math.round((startIconMission_Y / divisor)
//                * multiplicator);
//
//        foodByCropsText_X = (int) Math.round((foodByCropsText_X / divisor)
//                * multiplicator);
//        foodMini_X = (int) Math.round((foodMini_X / divisor) * multiplicator);
//
//        imageAuxFeedMill_Y = (int) Math.round((imageAuxFeedMill_Y / divisor)
//                * multiplicator);
//        quantityCropForFood_Y = (int) Math
//                .round((quantityCropForFood_Y / divisor) * multiplicator);
//        foodByCropsText_Y = (int) Math.round((foodByCropsText_Y / divisor)
//                * multiplicator);
//        foodMini_Y = (int) Math.round((foodMini_Y / divisor) * multiplicator);
//
//        buttonCashIn_X = (int) Math.round((buttonCashIn_X / divisor)
//                * multiplicator);
//        buttonCashIn_Y = (int) Math.round((buttonCashIn_Y / divisor)
//                * multiplicator);
//
//        initPosStorage_Y = (int) Math.round((initPosStorage_Y / divisor)
//                * multiplicator);
//        posButtonExpand_Y = (int) Math.round((posButtonExpand_Y / divisor)
//                * multiplicator);
//        posBackgExpand_Y = (int) Math.round((posBackgExpand_Y / divisor)
//                * multiplicator);
//        posButtonLevelUp_Y = (int) Math.round((posButtonLevelUp_Y / divisor)
//                * multiplicator);
//        posButtonPromotion_Y = (int) Math
//                .round((posButtonPromotion_Y / divisor) * multiplicator);
//        posButtonUpgrade_Y = (int) Math.round((posButtonUpgrade_Y / divisor)
//                * multiplicator);
//        posIconBackgUpgrade_Y = (int) Math
//                .round((posIconBackgUpgrade_Y / divisor) * multiplicator);
//        levelUpInfo_Y = (int) Math.round((levelUpInfo_Y / divisor)
//                * multiplicator);
//        levelUpDiamondSmallX = (int) Math
//                .round((levelUpDiamondSmallX / divisor) * multiplicator);
//
//        addTutoInfo_Y = (int) Math.round((addTutoInfo_Y / divisor)
//                * multiplicator);
//        addTutoTitle_Y = (int) Math.round((addTutoTitle_Y / divisor)
//                * multiplicator);
//        posButBackgProduce_Y = (int) Math
//                .round((posButBackgProduce_Y / divisor) * multiplicator);
//        posSlotProduce_Y = (int) Math.round((posSlotProduce_Y / divisor)
//                * multiplicator);
//        posNoFood_Y = (int) Math.round((posNoFood_Y / divisor) * multiplicator);
//        infoTruckQuest_Y = (int) Math.round((infoTruckQuest_Y / divisor)
//                * multiplicator);
//        infoTruckQuestQuantityY = (int) Math
//                .round((infoTruckQuestQuantityY / divisor) * multiplicator);
//
//        iconProduceFinal_X = (int) Math.round((iconProduceFinal_X / divisor)
//                * multiplicator);
//        timeProducFinal_Y = (int) Math.round((timeProducFinal_Y / divisor)
//                * multiplicator);
//        nameProductFinal_Y = (int) Math.round((nameProductFinal_Y / divisor)
//                * multiplicator);
//        plusFinal_X = (int) Math.round((plusFinal_X / divisor) * multiplicator);
//        plusFinal_Y = (int) Math.round((plusFinal_Y / divisor) * multiplicator);
//        nameCropsAux_Y = (int) Math.round((nameCropsAux_Y / divisor)
//                * multiplicator);
//        imageAuxStor_Y = (int) Math.round((imageAuxStor_Y / divisor)
//                * multiplicator);
//        quantitySellStor_Y = (int) Math.round((quantitySellStor_Y / divisor)
//                * multiplicator);
//        chooseItemStor_Y = (int) Math.round((chooseItemStor_Y / divisor)
//                * multiplicator);
//        restPageStorage_X = (int) Math.round((restPageStorage_X / divisor)
//                * multiplicator);
//        storageTextRewardOffsetY = (int) Math
//                .round((storageTextRewardOffsetY / divisor) * multiplicator);
//
//        addNameAchie_Y = (int) Math.round((addNameAchie_Y / divisor)
//                * multiplicator);
//        addNameAchie_X = (int) Math.round((addNameAchie_X / divisor)
//                * multiplicator);
//        diffAchivi_Y = (int) Math.round((diffAchivi_Y / divisor)
//                * multiplicator);
//        achievementsDiffX = (int) Math.round((achievementsDiffX / divisor)
//                * multiplicator);
//
//        tutorialTipTitleX = (int) Math.round((tutorialTipTitleX / divisor)
//                * multiplicator);
//        tutorialTipBodyY1 = (int) Math.round((tutorialTipBodyY1 / divisor)
//                * multiplicator);
//
//        // Elements paintStateCharacterMission
//        missionOffsetTextY = (int) Math.round((missionOffsetTextY / divisor)
//                * multiplicator);
//        missionOffsetCharacterY = (int) Math
//                .round((missionOffsetCharacterY / divisor) * multiplicator);
//        missionOffsetCharacterX = (int) Math
//                .round((missionOffsetCharacterX / divisor) * multiplicator);
//        missionOffsetIconX = (int) Math.round((missionOffsetIconX / divisor)
//                * multiplicator);
//        missionOffsetIconY = (int) Math.round((missionOffsetIconY / divisor)
//                * multiplicator);
//        missionOffsetText2Y = (int) Math.round((missionOffsetText2Y / divisor)
//                * multiplicator);
//        missionOffsetText2X = (int) Math.round((missionOffsetText2X / divisor)
//                * multiplicator);
//        missionOffsetText3X = (int) Math.round((missionOffsetText3X / divisor)
//                * multiplicator);
//        missionOffsetText3Y = (int) Math.round((missionOffsetText3Y / divisor)
//                * multiplicator);
//        missionOffsetText4Y = (int) Math.round((missionOffsetText4Y / divisor)
//                * multiplicator);
//
//        levelUpOffsetTitleY = (int) Math.round((levelUpOffsetTitleY / divisor)
//                * multiplicator);
//        levelUpOffsetInfoY = (int) Math.round((levelUpOffsetInfoY / divisor)
//                * multiplicator);
//
//        winMaterialOffsetTextY = (int) Math
//                .round((winMaterialOffsetTextY / divisor) * multiplicator);
//
//        generalShopOffsetPanelDiamondsX = (int) Math
//                .round((generalShopOffsetPanelDiamondsX / divisor)
//                        * multiplicator);
//        generalShopOffsetY = (int) Math.round((generalShopOffsetY / divisor)
//                * multiplicator);
//
//        bonusOffsetX = (int) Math.round((bonusOffsetX / divisor)
//                * multiplicator);
//
//        boostBuildingTitleOffsetY = (int) Math
//                .round((boostBuildingTitleOffsetY / divisor) * multiplicator);
//        boostBuildingInfoOffsetY = (int) Math
//                .round((boostBuildingInfoOffsetY / divisor) * multiplicator);
//
//        quantityStorageBubbleOffsetY = (int) Math
//                .round((quantityStorageBubbleOffsetY / divisor) * multiplicator);
//        quantityStorageBubbleOffsetX = (int) Math
//                .round((quantityStorageBubbleOffsetX / divisor) * multiplicator);
//
//        tutorialTipTextOffsetX = (int) Math
//                .round((tutorialTipTextOffsetX / divisor) * multiplicator);
//        tutorialTipTextOffsetY = (int) Math
//                .round((tutorialTipTextOffsetY / divisor) * multiplicator);
//        tutorialTipTextDiffY = (int) Math
//                .round((tutorialTipTextDiffY / divisor) * multiplicator);
//
//        suggestionMsgTextOffsetY = (int) Math
//                .round((suggestionMsgTextOffsetY / divisor) * multiplicator);
//        suggestionMsgTimeOffsetY = (int) Math
//                .round((suggestionMsgTimeOffsetY / divisor) * multiplicator);
//        suggestionMsgIconOffsetY = (int) Math
//                .round((suggestionMsgIconOffsetY / divisor) * multiplicator);
//
//        arrowRightOffsetX = (int) Math.round((arrowRightOffsetX / divisor)
//                * multiplicator);
//
//        popUpOffsetX = (int) Math.round((popUpOffsetX / divisor)
//                * multiplicator);
//        popUpOffsetInitY = (int) Math.round((popUpOffsetInitY / divisor)
//                * multiplicator);
//        popUpFullOffsetEndY = (int) Math.round((popUpFullOffsetEndY / divisor)
//                * multiplicator);
//        popUpFullOffsetIconX = (int) Math
//                .round((popUpFullOffsetIconX / divisor) * multiplicator);
//        popUpFullOffsetIconY = (int) Math
//                .round((popUpFullOffsetIconY / divisor) * multiplicator);
//
//        collectionsBgOffsetX = (int) Math
//                .round((collectionsBgOffsetX / divisor) * multiplicator);
//        collectionsBgOffsetY = (int) Math
//                .round((collectionsBgOffsetY / divisor) * multiplicator);
//        collectionsTextOffsetX = (int) Math
//                .round((collectionsTextOffsetX / divisor) * multiplicator);
//        collectionsTextOffsetY = (int) Math
//                .round((collectionsTextOffsetY / divisor) * multiplicator);
//        collectionShowOffsetX = (int) Math
//                .round((collectionShowOffsetX / divisor) * multiplicator);
//        collectionShowOffsetY = (int) Math
//                .round((collectionShowOffsetY / divisor) * multiplicator);
//        collectionShowTextOffsetY = (int) Math
//                .round((collectionShowTextOffsetY / divisor) * multiplicator);
//
//        winMaterialBtnBuildOffsetY = (int) Math
//                .round((winMaterialBtnBuildOffsetY / divisor) * multiplicator);
//        specialOfferTimerOffsetY = (int) Math
//                .round((specialOfferTimerOffsetY / divisor) * multiplicator);
//        specialOfferAmountY = (int) Math.round((specialOfferAmountY / divisor)
//                * multiplicator);
//        moreCurrencyItemOffsetX = (int) Math
//                .round((moreCurrencyItemOffsetX / divisor) * multiplicator);
//        infoTruckQuestIconCropY = (int) Math
//                .round((infoTruckQuestIconCropY / divisor) * multiplicator);
//
//        plusFinalText_X = (int) Math.round((plusFinalText_X / divisor)
//                * multiplicator);
//        plusFinalText_Y = (int) Math.round((plusFinalText_Y / divisor)
//                * multiplicator);
//
//        if (mCanvasWidth > 1280) {
//            divisor = 1;
//            multiplicator = 1;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            squareMission[i] = (int) Math.round((squareMission[i] / divisor)
//                    * multiplicator);
//        }
//
//        for (int i = 0; i < 4; i++) {
//            squareProduce[i] = (int) Math.round((squareProduce[i] / divisor)
//                    * multiplicator);
//        }
//
//        for (int i = 0; i < 3; i++) {
//            squareStorage[i] = (int) Math.round((squareStorage[i] / divisor)
//                    * multiplicator);
//        }
//
//        int colorShadowSmallScreen = Color.BLACK;
//        int tutorialColorText = Color.WHITE;
//        int tutorialColorShadowText = Color.BLACK;
//
//        if (mCanvasWidth < 1280) {
//            tutorialColorText = Color.BLACK;
//            tutorialColorShadowText = Color.WHITE;
//            colorShadowSmallScreen = Color.WHITE;
//        }
//
//        fontNameItemMarket = UtilSoftgames.initFontText(Color.BLACK,
//                (13 / divisor) * multiplicator, (21 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.WHITE, mFace);
//        fontNameItems = UtilSoftgames.initFontText(0xff8B4513, (20 / divisor)
//                * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.WHITE, mFace);
//        fontNameBuildingItems = UtilSoftgames.initFontText(0xff8B4513,
//                (15 / divisor) * multiplicator, (24 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.WHITE, mFace);
//        fontAttriItemShop = UtilSoftgames.initFontText(0xffD2691E,
//                (18 / divisor) * multiplicator, (30 / divisor) * multiplicator,
//                Paint.Align.LEFT, Color.WHITE, mFace);
//        fontTimeItemShop = UtilSoftgames.initFontText(0xffD2691E,
//                (14 / divisor) * multiplicator, (24 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.WHITE, mFace);
//        fontMoneyToPay = UtilSoftgames.initFontText(Color.WHITE, (24 / divisor)
//                * multiplicator, (38 / divisor) * multiplicator,
//                Paint.Align.LEFT, Color.BLACK, mFace);
//        fontAnimationQuantity = UtilSoftgames.initFontText(Color.YELLOW,
//                (20 / divisor) * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//        fontQuantityMaterialProduce = UtilSoftgames.initFontText(Color.WHITE,
//                (16 / divisor) * multiplicator, (30 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//
//        fontMainUi = UtilSoftgames.initFontText(Color.DKGRAY, (16 / divisor)
//                * multiplicator, (30 / divisor) * multiplicator,
//                Paint.Align.CENTER, colorShadowSmallScreen, mFace);
//        fontTitleCenter = UtilSoftgames.initFontText(Color.YELLOW,
//                (20 / divisor) * multiplicator, (42 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//        fontTitleLeft = UtilSoftgames.initFontText(Color.YELLOW, (20 / divisor)
//                * multiplicator, (42 / divisor) * multiplicator,
//                Paint.Align.LEFT, Color.BLACK, mFace);
//        fontMsjTitle = UtilSoftgames.initFontText(Color.WHITE, (16 / divisor)
//                * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//        fontMsjTitleStroke = UtilSoftgames.initFontText2(Color.WHITE,
//                (16 / divisor) * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//
//        fontYellowMed = UtilSoftgames.initFontText(Color.YELLOW, (16 / divisor)
//                * multiplicator, (36 / divisor) * multiplicator,
//                Paint.Align.LEFT, Color.BLACK, mFace);
//        fontYellowSmallLef = UtilSoftgames.initFontText(Color.YELLOW,
//                (14 / divisor) * multiplicator, (26 / divisor) * multiplicator,
//                Paint.Align.LEFT, Color.BLACK, mFace);
//
//        fontShowNivel = UtilSoftgames.initFontText(Color.WHITE, (16 / divisor)
//                * multiplicator, (46 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//        fontBlackSmallCenter = UtilSoftgames.initFontText(Color.BLACK,
//                (16 / divisor) * multiplicator, (17 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.WHITE, mFace);
//
//        fontWhiteSmallCenter = UtilSoftgames.initFontText(Color.WHITE,
//                (12 / divisor) * multiplicator, (20 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//
//        fontPaintMsjGame = UtilSoftgames.initFontText(0xfff0da8c,
//                (12 / divisor) * multiplicator, (18 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//        fontPaintMsjGameBig = UtilSoftgames.initFontText(0xfff0da8c,
//                (20 / divisor) * multiplicator, (28 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//
//        fontQuantityItemSell = UtilSoftgames.initFontText(Color.BLACK,
//                (16 / divisor) * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.LEFT, colorShadowSmallScreen, mFace);
//        fontWhiteSmallLeft = UtilSoftgames.initFontText(Color.WHITE,
//                (16 / divisor) * multiplicator, (26 / divisor) * multiplicator,
//                Paint.Align.LEFT, Color.BLACK, mFace);
//
//        fontTitleTutorialStroke = UtilSoftgames.initFontText2(Color.YELLOW,
//                (55 / divisor) * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//        fontTitleTutorial = UtilSoftgames.initFontText(Color.YELLOW,
//                (55 / divisor) * multiplicator, (32 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.BLACK, mFace);
//
//        fontBodyTutorial = UtilSoftgames.initFontText(tutorialColorText,
//                (22 / divisor) * multiplicator, (20 / divisor) * multiplicator,
//                Paint.Align.CENTER, tutorialColorShadowText, mFace);
//        fontBodyTutorialStroke = UtilSoftgames.initFontText2(tutorialColorText,
//                (22 / divisor) * multiplicator, (20 / divisor) * multiplicator,
//                Paint.Align.CENTER, tutorialColorShadowText, mFace);
//
//        Constants.fontAnimalfood = UtilSoftgames.initFontText(Color.BLACK,
//                (12 / divisor) * multiplicator, (20 / divisor) * multiplicator,
//                Paint.Align.CENTER, Color.WHITE, mFace);
//
//        isResized = true;
//    }
//    
//    private void loadImageAchievements(){
//    	 //loadGeneralMarket();
//         loadAchievementsIcons();
//
//         backgAllCollections = loadImageAssets(
//                 "collections-achievements/achievecollection_background.png",
//                 true);
//         backgRewardCollections = loadImageAssets(
//                 "collections-achievements/achievecollection_bar_reward.png",
//                 true);
//         buttonCashIn = loadImageAssets("task/button_cashin.png", true);
//         buttonCashInLocked = loadImageAssets(
//                 "task/button_cashin_inactive.png", true);
//         barProgressAchievements = loadImageAssets(
//                 "collections-achievements/achieve_bar_inactive.png", true);
//         barProgressAchievementsFull = loadImageAssets(
//                 "collections-achievements/achieve_bar.png", true);
//         achievementsBackgIcon = loadImageAssets(
//                 "collections-achievements/achieve_icon_background.png",
//                 true);
//         starCollectionFull = loadImageAssets(
//                 "collections-achievements/achievecollection_star.png", true);
//         starCollectionEmpty = loadImageAssets(
//                 "collections-achievements/achievecollection_star_inactive.png",
//                 true);
//
//         //backgroundPage = loadImageAssets(
//           //      "marketaux/general_pages_background.png", true);
//         //buttonPagesActive = loadImageAssets(
//           //      "marketaux/general_pages_active.png", true);
//         //buttonPages = loadImageAssets(
//           //      "marketaux/general_pages_inactive.png", true);
//    }
//    
//    
//    private void loadImageCollections(){
//    	 //loadGeneralMarket();
//         //backgAllCollections = loadImageAssets(
//           //      "collections-achievements/achievecollection_background.png",
//             //    true);
//         //backgRewardCollections = loadImageAssets(
//           //      "collections-achievements/achievecollection_bar_reward.png",
//           //      true);
//        // starCollectionFull = loadImageAssets(
//          //       "collections-achievements/achievecollection_star.png", true);
//        // starCollectionEmpty = loadImageAssets(
//          //       "collections-achievements/achievecollection_star_inactive.png",
//            //     true);
//      //   buttonCashIn = loadImageAssets("task/button_cashin.png", true);
//         //buttonCashInLocked = loadImageAssets(
//           //      "task/button_cashin_inactive.png", true);
//
//       //  backgroundPage = loadImageAssets(
//        //         "marketaux/general_pages_background.png", true);
//       //  buttonPagesActive = loadImageAssets(
//         //        "marketaux/general_pages_active.png", true);
//        // buttonPages = loadImageAssets(
//          //       "marketaux/general_pages_inactive.png", true);
//    }
//    
//    
//    private void loadImageStateFacebook() {
//    	 //loadGeneralMarket();
//    	if(buttonFacebook == null){
//         buttonAddHelper = new ImageButton(loadImageAssets(
//                 "facebook/friends_addfriends.png", true), mCanvasWidth / 2,
//                 mCanvasHeight / 2 - posButtonAddFriendY, null);
//         friendsAmount = loadImageAssets("facebook/friends_amount.png", true);
//         itemBackgFace = loadImageAssets("facebook/friends_background.png",true);
//         buttonInvite = new ImageButton(loadImageAssets(
//                 "facebook/friends_facebook_button.png", true),
//                 mCanvasWidth / 2, 0, null);
//         buttonInvite.setPosY(mCanvasHeight / 2
//                 - buttonInvite.getImage().getHeight() - posButtonInviteY);
//         buttonFacebook = loadImageAssets(
//                 "facebook/friends_facebook_icon.png", true);
//    	}
//    }
//    
//    private void loadImages(){
//    	switch (stateGame) {
//    	case Constants.STATE_FACEBOOK:
//    		  loadImageStateFacebook();
//          break;
//    	 case Constants.STATE_CHARACTER_MISSION:
//    	       // Log.d(TAG, "STATE_CHARACTER_MISSION");
//    	       // characterBig = loadImageAssets("Characters/character"
//    	         //       + (characterChosen[indexCharacterChosen] + 1) + ".png",
//    	           //     false);
//    		 //for(int i = 0; i < 8; i++){
//    		 if(characterBig[characterChosen[indexCharacterChosen]] == null){
//             	characterBig[characterChosen[indexCharacterChosen]] = loadImageAssets("Characters/character"
//            	                + (characterChosen[indexCharacterChosen]+1) + ".png", true);
//    		 }
//            // }
//    	        break;
//    	case Constants.STATE_STORAGE:
//        case Constants.STATE_FEED_MILL:
//
//            quantityToSell = 0;
//            break;
//    	case Constants.STATE_LOADING_MAIN:
//    			 int diffBetButtons = 4;
//    	            int diffBetButtonsY = 10;
//
//    	            
//    	            if (loadedMainGame < 25) {
//    	                inicializateCollections();
//    	                loadGame();
//    	             
//    	                
//    	                if (!isResized) {
//    	                    changeSize();
//    	                }
//
//    	                
//    	                if (!mainImagesLoaded) {
//        	                carTruck = loadBitmap("animation/cardown.png", false);
//        	                carTruck2 = loadBitmap("animation/carcratesup.png", false);
//        	                carTruck3 = loadBitmap("animation/carcratesdown.png", false);
//        	                carTruck4 = loadBitmap("animation/Carup.png", false);
//        	                
//        	                loadTilesGeneral();
//
//        	                if (tutorialGame) {
//        	                    loadSpriteTutorial();
//        	                    tipsFarmer = loadImageAssets("generalimages/Banner.png",
//        	                            true);
//        	                    shopBlocked = loadImageAssets("mainui/menu_shop_block.png",
//        	                            true);
//        	                  
//        	                }
//        	                arrowMission = loadImageAssets("task/progress.png",  false);
//        	                mainImagesLoaded = true;
//        	            }
//    	                
//    	                loadGeneralBackg();
//
//    	                buttonBack = new ImageButton(loadImageAssets(
//    	                        "generalimages/button_back.png", true), mCanvasWidth
//    	                        / 2 - backgroundGeneral.getWidth() / 2, mCanvasHeight
//    	                        / 2 - backgroundGeneral.getHeight() / 2,
//    	                        loadImageAssets(
//    	                                "generalimages/button_back_pressed.png", true));
//    	                backgCollections = loadImageAssets(
//    	                        "collections-achievements/collection_icon_background.png",
//    	                        true);
//
//    	                Constants.starAnimation = loadImageAssets(
//    	                        "generalimages/starAnimat.png", false);
//    	                buttonBuild = new ImageButton(loadImageAssets(
//    	                        "elementsBuilding/button_large.png", true), 0, 0,
//    	                        loadImageAssets(
//    	                                "elementsBuilding/button_large_pressed.png",
//    	                                true));
//    	                backgNoMoney = loadImageAssets(
//    	                        "generalimages/market_coinsdiamonds_background.png",
//    	                        true);
//
//    	                loadMoreGoldIcons();
//    	                loadMoreDiamondsIcons();
//
//    	                offer = loadImageAssets("generalimages/round.png", true);
//    	                quantityStorageIcon = loadImageAssets(
//    	                        "Automatic/storage_capacity.png", true);
//    	                backgFoundCollection = loadImageAssets(
//    	                        "generalimages/treasure_found.png", true);
//
//    	                loadCharactersIcons();
//    	                // loadAchievementsIcons();
//
//    	            } else if (loadedMainGame < 50) {
//    	               /* Constants.animationWaterCrop = new Image(loadImageAssets(
//    	                        "watering/water_animation.png", false));
//    	                Constants.waterReady_Img = new Image(loadImageAssets(
//    	                        "watering/kanne.png", false));*/
//    	            	Bitmap aux1 = loadImageAssets( "watering/kanne.png", false);
//    	            	Bitmap aux2 = loadImageAssets( "watering/water_animation.png", false);
//    	              
//    	            	createHorizontalSprite(aux2, Constants.animationWaterCrop, aux2.getWidth()/4, aux2.getHeight(), false);
//    	                createHorizontalSprite(aux1, Constants.waterReady_Img, aux1.getWidth()/4, aux1.getHeight(), false);
//    	                
//    	                Constants.underConstruction = loadImageAssets(
//    	                        "generalimages/construction_empty.png", false);
//    	                Constants.underConstructionBig = loadImageAssets(
//    	                        "generalimages/construction_empty_big.png", false);
//    	                Constants.buildingReady = loadImageAssets(
//    	                        "elementsBuilding/constrbig.png", false);
//    	                Constants.buildingReadySmall = loadImageAssets(
//    	                        "elementsBuilding/constrsmall.png", false);
//
//    	                Constants.backgroundFoundObecjt = loadImageAssets(
//    	                        "animation/sun_blik.png", false);
//
//    	                loadMoveFreeEmpty = loadImageAssets(
//    	                        "minioption/loadmoveempty.png", false);
//    	                loadMoveFreeFull = loadImageAssets(
//    	                        "minioption/loadmovefull.png", false);
//
//    	                bgQuestBoost = loadImageAssets("generalimages/bgquest.png",
//    	                        true);
//
//    	                cloudAnimation1 = loadImageAssets("animation/animatCloud1.png",
//    	                        false);
//    	                cloudAnimation2 = loadImageAssets("animation/medium.png", false);
//    	                cloudAnimation3 = loadImageAssets("animation/small.png", false);
//
//    	                starAnimation1 = loadImageAssets("animation/star_blue.png",
//    	                        false);
//    	                starAnimation2 = loadImageAssets("animation/star_green.png",
//    	                        false);
//    	                starAnimation3 = loadImageAssets("animation/star_red.png",
//    	                        false);
//    	                starAnimation4 = loadImageAssets("animation/star_yellow.png",
//    	                        false);
//
//    	                Constants.blink = new Image(loadImageAssets(
//    	                        "generalimages/blink.png", false));
//
//    	                backgCollectSmall = loadImageAssets(
//    	                        "generalimages/collection_background_small.png", true);
//    	                pointRedCollect = loadImageAssets(
//    	                        "generalimages/collection_amount2.png", true);
//    	                iconVegetation = loadImageAssets("task/icon_vegetation.png",
//    	                        false);
//    	                buttonClose = new ImageButton(loadImageAssets(
//    	                        "generalimages/button_close.png", true), 0,
//    	                        mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2,
//    	                        loadImageAssets(
//    	                                "generalimages/button_close_pressed.png", true));
//    	                buttonCloseSmall = new ImageButton(loadImageAssets(
//    	                        "generalimages/button_close_small.png", true), 0,
//    	                        mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2,
//    	                        loadImageAssets(
//    	                                "generalimages/button_close_pressed_small.png",
//    	                                true));
//    	            } else if (loadedMainGame < 75) {
//    	                Log.d(TAG, "loadedMainGame < 75");
//    	                loadIconCrops();
//    	                checkedAutomaticSmall = new ImageButton(loadImageAssets(
//    	                        "Automatic/button_checkmarksmall.png", true), 0, 0,
//    	                        loadImageAssets(
//    	                                "Automatic/button_checkmarksmall_pressed.png",
//    	                                true));
//    	                buttonAddProduct = new ImageButton(loadImageAssets(
//    	                        "elementsBuilding/button_small.png", true), 0, 0,
//    	                        loadImageAssets(
//    	                                "elementsBuilding/button_small_pressed.png",
//    	                                true));
//
//    	                bgTooltip = loadImageAssets("watering/bg_mensaje_water.png",
//    	                        true);
//    	                iconRotate = loadImageAssets("minioption/info_rotate.png", false);
//    	                iconSaveToStorage = loadImageAssets("minioption/info_cargo.png", false);
//
//    	                //iconMoveDisabled = loadImageAssets(
//    	                  //      "minioption/info_cargo_disabled.png", false);
//    	                iconWater = loadImageAssets("minioption/info_water.png", false);
//    	                iconHarverst = loadImageAssets("minioption/info_harvest.png",
//    	                        true);
//
//    	                buttonBoost = loadImageAssets("generalimages/icons_boost.png",
//    	                        false);
//    	                lockObject = loadImageAssets("generalimages/lock.png", true);
//    	                cursorHand = loadImageAssets("generalimages/cursor.png", true);
//    	                backgAutomatic = loadImageAssets(
//    	                        "Automatic/info_background.png", true);
//    	                infoIconTip = loadImageAssets("mainui/info_icon.png", true);
//
//    	                checkedAutomatic = new ImageButton(loadImageAssets(
//    	                        "Automatic/button_checkmark.png", true), 0, 0,
//    	                        loadImageAssets(
//    	                                "Automatic/button_checkmark_pressed.png", true));
//    	                visitStoreImage = loadImageAssets(
//    	                        "Automatic/hint_storage_full.png", true);
//    	                iconMoreExpansion = loadImageAssets(
//    	                        "Automatic/Iconmoreexpan.png", true);
//    	                Constants.animationBuilding = new Image(loadImageAssets(
//    	                        "elementsBuilding/wip.png", false));
//    	                Constants.cloudSleep = loadImageAssets(
//    	                        "elementsBuilding/wcloud.png", false);
//    	                Constants.cloudEmpty = loadImageAssets(
//    	                        "elementsBuilding/wcloud_empty.png", false);
//    	                Constants.foodAnimalSleep = loadImageAssets(
//    	                        "elementsBuilding/foodcloud.png", false);
//
//    	                Constants.productByAnimals[0] = loadImageAssets(
//    	                        "productAnimals/eggsnew.png", true);
//    	                Constants.productByAnimals[1] = loadImageAssets(
//    	                        "productAnimals/milk.png", true);
//    	                Constants.productByAnimals[2] = loadImageAssets(
//    	                        "productAnimals/wool.png", true);
//    	                Constants.productByAnimals[3] = loadImageAssets(
//    	                        "productAnimals/meat.png", true);
//    	                Constants.productByAnimals[4] = loadImageAssets(
//    	                        "productAnimals/goatmilk.png", true);
//    	            } else if (loadedMainGame < 100) {
//    	                loadIconDecoration();
//    	                symbolPlus = loadImageAssets(
//    	                        "elementsBuilding/general_plus.png", true);
//
//    	                loadingBarEmpty = loadImageAssets(
//    	                        "generalimages/levelbarempty.png", false);
//    	                loadingBarFull = loadImageAssets(
//    	                        "generalimages/levelbarfull.png", false);
//
//    	                checkSmall = loadImageAssets("task/tasks_checkmark_small.png",
//    	                        true);
//    	                vegetationBad = new Image(loadImageAssets(
//    	                        "maps/tile_vegetation.png", false));
//    	                diamondSmall = loadImageAssets(
//    	                        "generalimages/general_diamond.png", true);
//    	                coinSmall = loadImageAssets("generalimages/general_gold.png",
//    	                        true);
//    	                xpSmall = loadImageAssets("generalimages/tasks_xp.png", true);
//    	                iconSmallEarth = loadImageAssets("task/icon_earth.png", true);
//    	                foodSmall = loadImageAssets("NoFood/food.png", true);
//    	                foodMini = loadImageAssets("NoFood/foodmini.png", true);
//    	                flowerEmpty = loadImageAssets(
//    	                        "marketaux/market_crops_masters_inactive.png", true);
//    	                flowerFull = loadImageAssets(
//    	                        "marketaux/market_crops_mastery.png", true);
//    	                stadisticMaster = new Image(loadImageAssets(
//    	                        "marketaux/frame_master.png", true));
//
//    	                loadCollectionsIcons();
//
//    	                iconProgress = loadImageAssets("generalimages/progress.png",
//    	                        true);
//    	                popTutorial = loadImageAssets("generalimages/poptutorial.png",
//    	                        true);
//
//    	                iconTimePromotion = loadImageAssets("mainui/timePromotion.png",
//    	                        true);
//
//    	                detailItemShop = loadImageAssets(
//    	                        "marketaux/elementbackgitemshop.png", true);
//    	                productItemBackground = loadImageAssets(
//    	                        "elementsBuilding/general_item_background.png", true);
//
//    	                panelCoins = new ImageButton(loadImageAssets(
//    	                        "mainui/coins.png", true), 0, 5, null);
//    	                panelDiamonds = new ImageButton(loadImageAssets(
//    	                        "mainui/diamonds.png", true), panelCoins.getImage()
//    	                        .getWidth() + diffBetButtons, 5, null);
//    	                panelSeeds = new ImageButton(loadImageAssets("mainui/feed.png",
//    	                        true), panelCoins.getImage().getWidth()
//    	                        + panelDiamonds.getImage().getWidth()
//    	                        + (diffBetButtons * 2), 5, null);
//    	                starNivelEmpty = new ImageButton(loadImageAssets(
//    	                        "mainui/xp.png", true), 0, 15, null);
//    	                starNivelEmpty.setPosX(mCanvasWidth
//    	                        - starNivelEmpty.getImage().getWidth());
//    	                starNivelFull = loadImageAssets("mainui/xpfull.png", true);
//    	            } else if (loadedMainGame < 125) {
//    	                // loadIconsBuildings();
//    	                starNivel = loadImageAssets("mainui/star.png", true);
//    	                iconMission = new ImageButton(loadImageAssets(
//    	                        "mainui/quests.png", true), 0, 0, null);
//    	                iconMission.setPosY(mCanvasHeight
//    	                        - iconMission.getImage().getHeight());
//    	                iconHelper = new ImageButton(loadImageAssets(
//    	                        "mainui/addfriends.png", true), 0, panelCoins
//    	                        .getImage().getHeight() + diffBetButtonsY + 10, null);
//    	                iconHelper.setPosX(mCanvasWidth
//    	                        - iconHelper.getImage().getWidth());
//    	                infoIcon = new ImageButton(loadImageAssets(
//    	                        "generalimages/icon_i.png", true), 0, 0,
//    	                        loadImageAssets("generalimages/icon_i_p.png", true));
//    	                iconsMenuExpress[0] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_close.png", true), 0, 0, null);
//    	                iconsMenuExpress[0].setPosY(mCanvasHeight
//    	                        - iconsMenuExpress[0].getImage().getHeight());
//    	                iconsMenuExpress[0].setPosX(mCanvasWidth
//    	                        - iconsMenuExpress[0].getImage().getWidth());
//    	                iconsMenuExpress[1] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_plow_inactive.png", true), mCanvasWidth,
//    	                        mCanvasHeight
//    	                                - iconsMenuExpress[0].getImage().getHeight(),
//    	                        null);
//    	                iconsMenuExpress[2] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_shop.png", true), mCanvasWidth,
//    	                        mCanvasHeight
//    	                                - iconsMenuExpress[0].getImage().getHeight(),
//    	                        null);
//    	                iconsMenuExpress[3] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_harvest_inactive.png", true),
//    	                        mCanvasWidth, mCanvasHeight
//    	                                - iconsMenuExpress[0].getImage().getHeight(),
//    	                        null);
//    	                iconsMenuExpress[4] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_cargo.png", true), mCanvasWidth,
//    	                        mCanvasHeight
//    	                                - iconsMenuExpress[0].getImage().getHeight(),
//    	                        null);
//    	                iconsMenuExpressActive[0] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_plow.png", true), mCanvasWidth,
//    	                        mCanvasHeight
//    	                                - iconsMenuExpress[0].getImage().getHeight(),
//    	                        null);
//    	                iconsMenuExpressActive[1] = new ImageButton(loadImageAssets(
//    	                        "mainui/menu_harvest.png", true), mCanvasWidth,
//    	                        mCanvasHeight
//    	                                - iconsMenuExpress[1].getImage().getHeight(),
//    	                        null);
//
//    	              /*  Constants.startReady = new Image(loadImageAssets(
//    	                        "generalimages/star.png", false));*/
//    	                Bitmap auxStar = loadImageAssets("generalimages/star.png", false);
//    	                createHorizontalSprite(auxStar, Constants.startReady, auxStar.getWidth()/18, auxStar.getHeight(), false);
//    	                waterIcon = loadImageAssets("task/icon_water.png", false);
//    	                earthGood = loadImageAssets("maps/tierra_arada.png", false);
//    	                earthBad = loadImageAssets("maps/tierra_sinarar.png", false);
//    	                for (int i = 0; i < 16; i++) {
//    	                    tiledExpansion[i] = loadImageAssets("maps/expand/"
//    	                            + (i + 1) + ".png", false);
//    	                }
//    	                mineImage = loadImageAssets("maps/mine.png", false);
//    	                tiledSelected = loadImageAssets("maps/greentransparent.png",
//    	                        false);
//    	                backgMsjSelected = loadImageAssets(
//    	                        "generalimages/bg_mensaje.png", true);
//    	                backgroundItemIcons = loadImageAssets(
//    	                        "generalimages/back_icons.png", true);
//
//    	            } else if (loadedMainGame < 150) {
//    	            	if(!tutorialGame){
//    	            	  loadImageStateFacebook();
//    	            	}
//    	            	loadImageAchievements();
//    	            	loadImageCollections();
//    	            	loadIconsFood();
//    	            	loadImageExpansion();
//    	            	loadImageStorage();
//    	            } else if (loadedMainGame < 175) {
//    	            	loadImageCharacterMission();
//    	            	 loadGeneralMarket();
//    	                 loadIconsMainMarket();
//    	                 
//    	            } else if (loadedMainGame < 200) {
//    	            	if(!tutorialGame){
//    	            		loadImageStateMission();
//   	                 		loadIconsBuildings();
//   	                 		loadIconAnimals();
//   	                 		loadImageStateTruckQuest();
//   	                 		loadImageStateProduction();
//    	            	}
//    	            }
//    		break;
//    	}
//    	
//    }
//    
//    /**
//     *   
//            }
//            loadIconsMainMarket();
//
//            break;
//        case Constants.STATE_MISSION:
//            //Log.d(TAG, "STATE_MISSION");
//        	if(!loadStateMission){
//        		loadImageStateMission();
//        	}
//        	loadStateMission = true;
//            break;
//
//        case Constants.STATE_MARKET_BUILDING:
//            Log.d(TAG, "STATE_MARKET_BUILDING");
//            loadGeneralMarket();
//            loadIconsBuildings();
//            break;
//
//        case Constants.STATE_TRUCKQUEST:
//          //  Log.d(TAG, "STATE_TRUCKQUEST");
//            
//            if(!loadStateTruckQuest){
//        		loadImageStateTruckQuest();
//        	}
//            loadStateTruckQuest = true;
//            
//            break;
//
//        case Constants.STATE_MARKET_DECO:
//            Log.d(TAG, "STATE_MARKET_DECO");
//            loadGeneralMarket();
//            break;
//
//        case Constants.STATE_MARKET_ANIMALS:
//            Log.d(TAG, "STATE_MARKET_ANIMALS");
//            loadGeneralMarket();
//            loadIconAnimals();
//
//            break;
//        case Constants.STATE_MARKET_CROPS:
//            loadGeneralMarket();
//
//            break;
//
//        case Constants.STATE_LEVEL_UP:
//            Log.d(TAG, "STATE_LEVEL_UP");
//            loadGeneralBackg();
//            if(buttonBuildInactive == null){
//            	buttonBuildInactive = loadImageAssets(
//                    "elementsBuilding/button_large_inactive.png", true);
//            }
//
//            break;
//        case Constants.STATE_PRODUCTION:
//           // Log.d(TAG, "STATE_PRODUCED");
//            if(!loadStateProduction){
//        		  loadImageStateProduction();
//          	}
//            loadStateProduction = true;
//            break;
//        }
//     */
//    
//    private void loadImageCharacterMission(){
//   
//
//            backgTask = loadImageAssets("task/tasks_background.png", true);
//            checkBig = loadImageAssets("task/tasks_checkmark_large.png",
//                    true);
//            //checkSmall = loadImageAssets("task/tasks_checkmark_small.png",
//              //      true);
//            buttonProduce = new ImageButton(loadImageAssets(
//                    "elementsBuilding/produce_active.png", true), 0, 0,
//                    null);
//            backgroundCharacter = loadImageAssets(
//                    "Characters/bacgroundCharacter.png", true);
//        
//
//       
//    }
//    
//    private void loadImageExpansion(){
//    	      opcExpand1 = loadImageAssets("generalimages/opcexpand1.png",
//                      true);
//              opcExpand2 = loadImageAssets("generalimages/opcexpand2.png",
//                      true);
//              buttonBuildInactive = loadImageAssets(
//                      "elementsBuilding/button_large_inactive.png", true);
//              backExpand = loadImageAssets("generalimages/backgexpand.png",
//                      true);
//    }
//    
//    private void loadImageStorage(){
//    	     backgItemStorage = loadImageAssets( "generalimages/feedmill_detail.png", true);
//             taskSelected = loadImageAssets("task/tasks_selected.png", true);
//             taskItemBackg = loadImageAssets(
//                     "task/tasks_item_background.png", true);
//             taskItemBackgBlock = loadImageAssets(
//                     "task/feedmill_blocked.png", true);
//            // buttonBuildInactive = loadImageAssets(
//              //       "elementsBuilding/button_large_inactive.png", true);
//             selectAll = new ImageButton(loadImageAssets(
//                     "elementsBuilding/selectAll.png", true), 0, 0, null);
//             desSelectAll = new ImageButton(loadImageAssets(
//                     "elementsBuilding/desselected.png", true), 0, 0, null);
//
//             buttonArrow = new ImageButton(loadImageAssets(
//                     "marketaux/button_arrow.png", true), 0, 0,
//                     loadImageAssets("marketaux/button_arrow_pressed.png",
//                             true));
//             buttonUpgrade = new ImageButton(loadImageAssets(
//                     "elementsBuilding/button_upgrade.png", true), 0, 0,
//                     loadImageAssets(
//                             "elementsBuilding/button_upgrade_pressed.png",
//                             true));
//             buttonArrow.setPosX(mCanvasWidth / 2
//                     - backgroundGeneral.getWidth() / 2);
//             buttonArrow.setPosY(mCanvasHeight / 2
//                     - buttonArrow.getImage().getHeight() / 2);
//
//             buttonArrowRigth = new ImageButton(loadImageAssets(
//                     "marketaux/button_arrow.png", true), 0, 0,
//                     loadImageAssets("marketaux/button_arrow_pressed.png",
//                             true));
//             buttonArrowRigth.setPosX(mCanvasWidth / 2
//                     + backgroundGeneral.getWidth() / 2
//                     - buttonArrowRigth.getImage().getWidth());
//             buttonArrowRigth.setPosY(mCanvasHeight / 2
//                     - buttonArrow.getImage().getHeight() / 2);
//
//             buttonAddProductInactive = loadImageAssets(
//                     "elementsBuilding/button_small_inactive.png", true);
//       
//    }
//    
//   /* private void loadImages() {
//        Log.d(TAG, "loadImages()");
//        switch (stateGame) {
//        case Constants.STATE_FACEBOOK:
//           // Log.d(TAG, "STATE_FACEBOOK");
//        	if(!loadStateFacebook){
//        		loadImageStateFacebook();
//        	}
//        	loadStateFacebook = true;
//            break;
//        case Constants.STATE_ACHIEVEMENTS:
//      //      Log.d(TAG, "STATE_ACHIEVEMENTS");
//        	if(!loadStateAchievements){
//        		loadImageAchievements();
//        	}
//        	loadStateAchievements = true;
//
//            break;
//        // datawareBarcode
//        case Constants.STATE_COLLECTIONS:
//           // Log.d(TAG, "STATE_COLLECTIONS");
//        	if(!loadStateCollections){
//        		loadImageCollections();
//        	}
//        	loadStateCollections = true;
//
//            break;
//        case Constants.STATE_NOFOOD:
//            Log.d(TAG, "STATE_NOFOOD");
//            loadGeneralBackg();
//            loadIconsFood();
//
//            break;
//        case Constants.STATE_QUEST_EXPANSION:
//            Log.d(TAG, "STATE_QUEST_EXPANSION");
//            loadGeneralBackg();
//            if (opcExpand1 == null) {
//                opcExpand1 = loadImageAssets("generalimages/opcexpand1.png",
//                        true);
//                opcExpand2 = loadImageAssets("generalimages/opcexpand2.png",
//                        true);
//                buttonBuildInactive = loadImageAssets(
//                        "elementsBuilding/button_large_inactive.png", true);
//                backExpand = loadImageAssets("generalimages/backgexpand.png",
//                        true);
//            }
//            break;
//        case Constants.STATE_STORAGE:
//        case Constants.STATE_FEED_MILL:
//            Log.d(TAG, "STATE_STORAGE && STATE_FEED_MILL");
//
//            quantityToSell = 0;
//            loadGeneralBackg();
//
//            if (backgItemStorage == null) {
//                backgItemStorage = loadImageAssets(
//                        "generalimages/feedmill_detail.png", true);
//                taskSelected = loadImageAssets("task/tasks_selected.png", true);
//                taskItemBackg = loadImageAssets(
//                        "task/tasks_item_background.png", true);
//                taskItemBackgBlock = loadImageAssets(
//                        "task/feedmill_blocked.png", true);
//                buttonBuildInactive = loadImageAssets(
//                        "elementsBuilding/button_large_inactive.png", true);
//                selectAll = new ImageButton(loadImageAssets(
//                        "elementsBuilding/selectAll.png", true), 0, 0, null);
//                desSelectAll = new ImageButton(loadImageAssets(
//                        "elementsBuilding/desselected.png", true), 0, 0, null);
//
//                buttonArrow = new ImageButton(loadImageAssets(
//                        "marketaux/button_arrow.png", true), 0, 0,
//                        loadImageAssets("marketaux/button_arrow_pressed.png",
//                                true));
//                buttonUpgrade = new ImageButton(loadImageAssets(
//                        "elementsBuilding/button_upgrade.png", true), 0, 0,
//                        loadImageAssets(
//                                "elementsBuilding/button_upgrade_pressed.png",
//                                true));
//                buttonArrow.setPosX(mCanvasWidth / 2
//                        - backgroundGeneral.getWidth() / 2);
//                buttonArrow.setPosY(mCanvasHeight / 2
//                        - buttonArrow.getImage().getHeight() / 2);
//
//                buttonArrowRigth = new ImageButton(loadImageAssets(
//                        "marketaux/button_arrow.png", true), 0, 0,
//                        loadImageAssets("marketaux/button_arrow_pressed.png",
//                                true));
//                buttonArrowRigth.setPosX(mCanvasWidth / 2
//                        + backgroundGeneral.getWidth() / 2
//                        - buttonArrowRigth.getImage().getWidth());
//                buttonArrowRigth.setPosY(mCanvasHeight / 2
//                        - buttonArrow.getImage().getHeight() / 2);
//
//                buttonAddProductInactive = loadImageAssets(
//                        "elementsBuilding/button_small_inactive.png", true);
//                backgroundPage = loadImageAssets(
//                        "marketaux/general_pages_background.png", true);
//                buttonPagesActive = loadImageAssets(
//                        "marketaux/general_pages_active.png", true);
//                buttonPages = loadImageAssets(
//                        "marketaux/general_pages_inactive.png", true);
//            }
//            break;
//        case Constants.STATE_UPGRADE_BUILDING:
//        case Constants.STATE_UPGRADE_ANIMAL:
//            Log.d(TAG, "STATE_UPGRADE_BUILDING && STATE_UPGRADE_ANIMAL");
//            loadGeneralBackg();
//
//            buttonBuildInactive = loadImageAssets(
//                    "elementsBuilding/button_large_inactive.png", true);
//
//            break;
//
//        case Constants.STATE_CHARACTER_MISSION:
//            Log.d(TAG, "STATE_CHARACTER_MISSION");
//            characterBig = loadImageAssets("Characters/character"
//                    + (characterChosen[indexCharacterChosen] + 1) + ".png",
//                    true);
//
//            if (backgroundCharacter == null) {
//                backgTask = loadImageAssets("task/tasks_background.png", true);
//                checkBig = loadImageAssets("task/tasks_checkmark_large.png",
//                        true);
//                checkSmall = loadImageAssets("task/tasks_checkmark_small.png",
//                        true);
//                buttonProduce = new ImageButton(loadImageAssets(
//                        "elementsBuilding/produce_active.png", true), 0, 0,
//                        null);
//                backgroundCharacter = loadImageAssets(
//                        "Characters/bacgroundCharacter.png", true);
//            }
//
//            break;
//
//        case Constants.STATE_MORE_COINS:
//            Log.d(TAG, "STATE_MORE_COINS");
//            loadGeneralBackg();
//            loadGeneralMarket();
//            loadMoreGoldIcons();
//
//            break;
//        case Constants.STATE_MORE_DIAMONDS:
//            Log.d(TAG, "STATE_MORE_DIAMONDS");
//            loadGeneralBackg();
//            loadGeneralMarket();
//            loadMoreDiamondsIcons();
//            break;
//        case Constants.STATE_COVER:
//            Log.d(TAG, "STATE_COVER");
//            int diffBetButtons = 4;
//            int diffBetButtonsY = 10;
//
//            if (!mainImagesLoaded) {
//                carTruck = loadBitmap("animation/cardown.png", false);
//                carTruck2 = loadBitmap("animation/carcratesup.png", false);
//                carTruck3 = loadBitmap("animation/carcratesdown.png", false);
//                carTruck4 = loadBitmap("animation/Carup.png", false);
//
//                loadTilesGeneral();
//
//                if (tutorialGame) {
//                    loadSpriteTutorial();
//                    tipsFarmer = loadImageAssets("generalimages/Banner.png",
//                            true);
//                    shopBlocked = loadImageAssets("mainui/menu_shop_block.png",
//                            true);
//                }
//                mainImagesLoaded = true;
//            }
//            if (loadedMainGame < 25) {
//                inicializateCollections();
//                loadGame();
//
//                if (!isResized) {
//                    changeSize();
//                }
//
//                loadGeneralBackg();
//
//                buttonBack = new ImageButton(loadImageAssets(
//                        "generalimages/button_back.png", true), mCanvasWidth
//                        / 2 - backgroundGeneral.getWidth() / 2, mCanvasHeight
//                        / 2 - backgroundGeneral.getHeight() / 2,
//                        loadImageAssets(
//                                "generalimages/button_back_pressed.png", true));
//                backgCollections = loadImageAssets(
//                        "collections-achievements/collection_icon_background.png",
//                        true);
//
//                Constants.starAnimation = loadImageAssets(
//                        "generalimages/starAnimat.png", false);
//                buttonBuild = new ImageButton(loadImageAssets(
//                        "elementsBuilding/button_large.png", true), 0, 0,
//                        loadImageAssets(
//                                "elementsBuilding/button_large_pressed.png",
//                                true));
//                backgNoMoney = loadImageAssets(
//                        "generalimages/market_coinsdiamonds_background.png",
//                        true);
//
//                loadMoreGoldIcons();
//                loadMoreDiamondsIcons();
//
//                offer = loadImageAssets("generalimages/round.png", true);
//                quantityStorageIcon = loadImageAssets(
//                        "Automatic/storage_capacity.png", true);
//                backgFoundCollection = loadImageAssets(
//                        "generalimages/treasure_found.png", true);
//
//                loadCharactersIcons();
//                // loadAchievementsIcons();
//
//            } else if (loadedMainGame < 50) {
//                Constants.animationWaterCrop = new Image(loadImageAssets(
//                        "watering/water_animation.png", false));
//                Constants.waterReady_Img = new Image(loadImageAssets(
//                        "watering/kanne.png", false));
//                Constants.underConstruction = loadImageAssets(
//                        "generalimages/construction_empty.png", false);
//                Constants.underConstructionBig = loadImageAssets(
//                        "generalimages/construction_empty_big.png", false);
//                Constants.buildingReady = loadImageAssets(
//                        "elementsBuilding/constrbig.png", false);
//                Constants.buildingReadySmall = loadImageAssets(
//                        "elementsBuilding/constrsmall.png", false);
//
//                Constants.backgroundFoundObecjt = loadImageAssets(
//                        "animation/sun_blik.png", false);
//
//                loadMoveFreeEmpty = loadImageAssets(
//                        "minioption/loadmoveempty.png", false);
//                loadMoveFreeFull = loadImageAssets(
//                        "minioption/loadmovefull.png", false);
//
//                bgQuestBoost = loadImageAssets("generalimages/bgquest.png",
//                        true);
//
//                cloudAnimation1 = loadImageAssets("animation/animatCloud1.png",
//                        false);
//                cloudAnimation2 = loadImageAssets("animation/medium.png", false);
//                cloudAnimation3 = loadImageAssets("animation/small.png", false);
//
//                starAnimation1 = loadImageAssets("animation/star_blue.png",
//                        false);
//                starAnimation2 = loadImageAssets("animation/star_green.png",
//                        false);
//                starAnimation3 = loadImageAssets("animation/star_red.png",
//                        false);
//                starAnimation4 = loadImageAssets("animation/star_yellow.png",
//                        false);
//
//                Constants.blink = new Image(loadImageAssets(
//                        "generalimages/blink.png", false));
//
//                backgCollectSmall = loadImageAssets(
//                        "generalimages/collection_background_small.png", true);
//                pointRedCollect = loadImageAssets(
//                        "generalimages/collection_amount2.png", false);
//                iconVegetation = loadImageAssets("task/icon_vegetation.png",
//                        false);
//                buttonClose = new ImageButton(loadImageAssets(
//                        "generalimages/button_close.png", true), 0,
//                        mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2,
//                        loadImageAssets(
//                                "generalimages/button_close_pressed.png", true));
//                buttonCloseSmall = new ImageButton(loadImageAssets(
//                        "generalimages/button_close_small.png", true), 0,
//                        mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2,
//                        loadImageAssets(
//                                "generalimages/button_close_pressed_small.png",
//                                true));
//            } else if (loadedMainGame < 75) {
//                Log.d(TAG, "loadedMainGame < 75");
//                loadIconCrops();
//                checkedAutomaticSmall = new ImageButton(loadImageAssets(
//                        "Automatic/button_checkmarksmall.png", true), 0, 0,
//                        loadImageAssets(
//                                "Automatic/button_checkmarksmall_pressed.png",
//                                true));
//                buttonAddProduct = new ImageButton(loadImageAssets(
//                        "elementsBuilding/button_small.png", true), 0, 0,
//                        loadImageAssets(
//                                "elementsBuilding/button_small_pressed.png",
//                                true));
//
//                bgTooltip = loadImageAssets("watering/bg_mensaje_water.png",
//                        true);
//                iconRotate = loadImageAssets("minioption/info_rotate.png", true);
//                iconSaveToStorage = loadImageAssets(
//                        "minioption/info_cargo.png", true);
//
//                iconMoveDisabled = loadImageAssets(
//                        "minioption/info_cargo_disabled.png", true);
//                iconWater = loadImageAssets("minioption/info_water.png", true);
//                iconHarverst = loadImageAssets("minioption/info_harvest.png",
//                        true);
//
//                buttonBoost = loadImageAssets("generalimages/icons_boost.png",
//                        false);
//                lockObject = loadImageAssets("generalimages/lock.png", true);
//                cursorHand = loadImageAssets("generalimages/cursor.png", true);
//                backgAutomatic = loadImageAssets(
//                        "Automatic/info_background.png", true);
//                infoIconTip = loadImageAssets("mainui/info_icon.png", true);
//
//                checkedAutomatic = new ImageButton(loadImageAssets(
//                        "Automatic/button_checkmark.png", true), 0, 0,
//                        loadImageAssets(
//                                "Automatic/button_checkmark_pressed.png", true));
//                visitStoreImage = loadImageAssets(
//                        "Automatic/hint_storage_full.png", true);
//                iconMoreExpansion = loadImageAssets(
//                        "Automatic/Iconmoreexpan.png", true);
//                Constants.animationBuilding = new Image(loadImageAssets(
//                        "elementsBuilding/wip.png", true));
//                Constants.cloudSleep = loadImageAssets(
//                        "elementsBuilding/wcloud.png", false);
//                Constants.cloudEmpty = loadImageAssets(
//                        "elementsBuilding/wcloud_empty.png", false);
//                Constants.foodAnimalSleep = loadImageAssets(
//                        "elementsBuilding/foodcloud.png", false);
//
//                Constants.productByAnimals[0] = loadImageAssets(
//                        "productAnimals/eggsnew.png", true);
//                Constants.productByAnimals[1] = loadImageAssets(
//                        "productAnimals/milk.png", true);
//                Constants.productByAnimals[2] = loadImageAssets(
//                        "productAnimals/wool.png", true);
//                Constants.productByAnimals[3] = loadImageAssets(
//                        "productAnimals/meat.png", true);
//                Constants.productByAnimals[4] = loadImageAssets(
//                        "productAnimals/goatmilk.png", true);
//            } else if (loadedMainGame < 100) {
//                loadIconDecoration();
//                symbolPlus = loadImageAssets(
//                        "elementsBuilding/general_plus.png", true);
//
//                loadingBarEmpty = loadImageAssets(
//                        "generalimages/levelbarempty.png", false);
//                loadingBarFull = loadImageAssets(
//                        "generalimages/levelbarfull.png", false);
//
//                checkSmall = loadImageAssets("task/tasks_checkmark_small.png",
//                        true);
//                vegetationBad = new Image(loadImageAssets(
//                        "maps/tile_vegetation.png", false));
//                diamondSmall = loadImageAssets(
//                        "generalimages/general_diamond.png", true);
//                coinSmall = loadImageAssets("generalimages/general_gold.png",
//                        true);
//                xpSmall = loadImageAssets("generalimages/tasks_xp.png", true);
//                iconSmallEarth = loadImageAssets("task/icon_earth.png", true);
//                foodSmall = loadImageAssets("NoFood/food.png", true);
//                foodMini = loadImageAssets("NoFood/foodmini.png", true);
//                flowerEmpty = loadImageAssets(
//                        "marketaux/market_crops_masters_inactive.png", true);
//                flowerFull = loadImageAssets(
//                        "marketaux/market_crops_mastery.png", true);
//                stadisticMaster = new Image(loadImageAssets(
//                        "marketaux/frame_master.png", true));
//
//                loadCollectionsIcons();
//
//                iconProgress = loadImageAssets("generalimages/progress.png",
//                        true);
//                popTutorial = loadImageAssets("generalimages/poptutorial.png",
//                        true);
//
//                iconTimePromotion = loadImageAssets("mainui/timePromotion.png",
//                        true);
//
//                detailItemShop = loadImageAssets(
//                        "marketaux/elementbackgitemshop.png", true);
//                productItemBackground = loadImageAssets(
//                        "elementsBuilding/general_item_background.png", true);
//
//                panelCoins = new ImageButton(loadImageAssets(
//                        "mainui/coins.png", true), 0, 5, null);
//                panelDiamonds = new ImageButton(loadImageAssets(
//                        "mainui/diamonds.png", true), panelCoins.getImage()
//                        .getWidth() + diffBetButtons, 5, null);
//                panelSeeds = new ImageButton(loadImageAssets("mainui/feed.png",
//                        true), panelCoins.getImage().getWidth()
//                        + panelDiamonds.getImage().getWidth()
//                        + (diffBetButtons * 2), 5, null);
//                starNivelEmpty = new ImageButton(loadImageAssets(
//                        "mainui/xp.png", true), 0, 15, null);
//                starNivelEmpty.setPosX(mCanvasWidth
//                        - starNivelEmpty.getImage().getWidth());
//                starNivelFull = loadImageAssets("mainui/xpfull.png", true);
//            } else if (loadedMainGame < 125) {
//                // loadIconsBuildings();
//                starNivel = loadImageAssets("mainui/star.png", true);
//                iconMission = new ImageButton(loadImageAssets(
//                        "mainui/quests.png", true), 0, 0, null);
//                iconMission.setPosY(mCanvasHeight
//                        - iconMission.getImage().getHeight());
//                iconHelper = new ImageButton(loadImageAssets(
//                        "mainui/addfriends.png", true), 0, panelCoins
//                        .getImage().getHeight() + diffBetButtonsY + 10, null);
//                iconHelper.setPosX(mCanvasWidth
//                        - iconHelper.getImage().getWidth());
//                infoIcon = new ImageButton(loadImageAssets(
//                        "generalimages/icon_i.png", true), 0, 0,
//                        loadImageAssets("generalimages/icon_i_p.png", true));
//                iconsMenuExpress[0] = new ImageButton(loadImageAssets(
//                        "mainui/menu_close.png", true), 0, 0, null);
//                iconsMenuExpress[0].setPosY(mCanvasHeight
//                        - iconsMenuExpress[0].getImage().getHeight());
//                iconsMenuExpress[0].setPosX(mCanvasWidth
//                        - iconsMenuExpress[0].getImage().getWidth());
//                iconsMenuExpress[1] = new ImageButton(loadImageAssets(
//                        "mainui/menu_plow_inactive.png", true), mCanvasWidth,
//                        mCanvasHeight
//                                - iconsMenuExpress[0].getImage().getHeight(),
//                        null);
//                iconsMenuExpress[2] = new ImageButton(loadImageAssets(
//                        "mainui/menu_shop.png", true), mCanvasWidth,
//                        mCanvasHeight
//                                - iconsMenuExpress[0].getImage().getHeight(),
//                        null);
//                iconsMenuExpress[3] = new ImageButton(loadImageAssets(
//                        "mainui/menu_harvest_inactive.png", true),
//                        mCanvasWidth, mCanvasHeight
//                                - iconsMenuExpress[0].getImage().getHeight(),
//                        null);
//                iconsMenuExpress[4] = new ImageButton(loadImageAssets(
//                        "mainui/menu_cargo.png", true), mCanvasWidth,
//                        mCanvasHeight
//                                - iconsMenuExpress[0].getImage().getHeight(),
//                        null);
//                iconsMenuExpressActive[0] = new ImageButton(loadImageAssets(
//                        "mainui/menu_plow.png", true), mCanvasWidth,
//                        mCanvasHeight
//                                - iconsMenuExpress[0].getImage().getHeight(),
//                        null);
//                iconsMenuExpressActive[1] = new ImageButton(loadImageAssets(
//                        "mainui/menu_harvest.png", true), mCanvasWidth,
//                        mCanvasHeight
//                                - iconsMenuExpress[1].getImage().getHeight(),
//                        null);
//
//                Constants.startReady = new Image(loadImageAssets(
//                        "generalimages/star.png", false));
//                waterIcon = loadImageAssets("task/icon_water.png", false);
//                earthGood = loadImageAssets("maps/tierra_arada.png", false);
//                earthBad = loadImageAssets("maps/tierra_sinarar.png", false);
//                for (int i = 0; i < 16; i++) {
//                    tiledExpansion[i] = loadImageAssets("maps/expand/"
//                            + (i + 1) + ".png", false);
//                }
//                mineImage = loadImageAssets("maps/mine.png", false);
//                tiledSelected = loadImageAssets("maps/greentransparent.png",
//                        false);
//                backgMsjSelected = loadImageAssets(
//                        "generalimages/bg_mensaje.png", true);
//                backgroundItemIcons = loadImageAssets(
//                        "generalimages/back_icons.png", true);
//
//            } else if (loadedMainGame < 150) {
//            	
//            } else if (loadedMainGame < 175) {
//            	as
//            }
//            break;
//        case Constants.STATE_MAIN_MARKET:
//            Log.d(TAG, "STATE_MAIN_MARKET");
//            loadGeneralBackg();
//
//            if (backgroundItemMarket == null) {
//                backgroundItemMarket = loadImageAssets(
//                        "mainmarket/shop_background.png", true);
//            }
//            loadIconsMainMarket();
//
//            break;
//        case Constants.STATE_MISSION:
//            //Log.d(TAG, "STATE_MISSION");
//        	if(!loadStateMission){
//        		loadImageStateMission();
//        	}
//        	loadStateMission = true;
//            break;
//
//        case Constants.STATE_MARKET_BUILDING:
//            Log.d(TAG, "STATE_MARKET_BUILDING");
//            loadGeneralMarket();
//            loadIconsBuildings();
//            break;
//
//        case Constants.STATE_TRUCKQUEST:
//          //  Log.d(TAG, "STATE_TRUCKQUEST");
//            
//            if(!loadStateTruckQuest){
//        		loadImageStateTruckQuest();
//        	}
//            loadStateTruckQuest = true;
//            
//            break;
//
//        case Constants.STATE_MARKET_DECO:
//            Log.d(TAG, "STATE_MARKET_DECO");
//            loadGeneralMarket();
//            break;
//
//        case Constants.STATE_MARKET_ANIMALS:
//            Log.d(TAG, "STATE_MARKET_ANIMALS");
//            loadGeneralMarket();
//            loadIconAnimals();
//
//            break;
//        case Constants.STATE_MARKET_CROPS:
//            loadGeneralMarket();
//
//            break;
//
//        case Constants.STATE_LEVEL_UP:
//            Log.d(TAG, "STATE_LEVEL_UP");
//            loadGeneralBackg();
//            if(buttonBuildInactive == null){
//            	buttonBuildInactive = loadImageAssets(
//                    "elementsBuilding/button_large_inactive.png", true);
//            }
//
//            break;
//        case Constants.STATE_PRODUCTION:
//           // Log.d(TAG, "STATE_PRODUCED");
//            if(!loadStateProduction){
//        		  loadImageStateProduction();
//          	}
//            loadStateProduction = true;
//            break;
//        }
//    }*/
//    
//    private void loadImageStateProduction(){
//    	// loadGeneralBackg();
//         buildingPlusInfo = loadImageAssets(
//                 "elementsBuilding/plus_large.png", true);
//         backgInfoProduct = loadImageAssets(
//                 "elementsBuilding/production_item_result.png", true);
//         // productItemBackground =
//         // loadImageAssets("elementsBuilding/general_item_background.png");
//         productItemBackgroundSmall = loadImageAssets(
//                 "elementsBuilding/production_item_background.png", true);
//         prodItemBackgSmallInac = loadImageAssets(
//                 "elementsBuilding/production_item_background_inactive.png",
//                 true);
//         symbolEquals = loadImageAssets("elementsBuilding/general_result.png",
//                 true);
//
//         productItemBackgroundInactive = loadImageAssets(
//                 "elementsBuilding/general_item_background_inactive.png",
//                 true);
//         buttonCollect = loadImageAssets(
//                 "elementsBuilding/collectbutton.png", true);
//         buttonFinish = loadImageAssets("elementsBuilding/finishbutton.png",
//                 true);
//         buttonUpgrade = new ImageButton(
//                 loadImageAssets("elementsBuilding/button_upgrade.png", true),
//                 0,
//                 0,
//                 loadImageAssets(
//                         "elementsBuilding/button_upgrade_pressed.png", true));
//
//         buttonAddProductInactive = loadImageAssets(
//                 "elementsBuilding/button_small_inactive.png", true);
//
//        // buttonBuildInactive = loadImageAssets(
//           //      "elementsBuilding/button_large_inactive.png", true);
//
//        // buttonProduce = new ImageButton(loadImageAssets(
//          //       "elementsBuilding/produce_active.png", true), 0, 0, null);
//         //buttonProduceInactive = loadImageAssets(
//           //      "elementsBuilding/produce_inactive.png", true);
//    }
//    
//    private void loadImageStateTruckQuest(){
//    	//loadGeneralBackg();
//        taskItemBackg = loadImageAssets("task/tasks_item_background.png",
//                true);
//        buttonAccept = new ImageButton(loadImageAssets(
//                "truckquest/button_accept.png", true), 0, 0, null);
//        buttonDenie = new ImageButton(loadImageAssets(
//                "truckquest/button_deny.png", true), 0, 0, null);
//        truckDecoration = loadImageAssets("truckquest/truck.png", true);
//        backgDecoTruck = loadImageAssets("truckquest/background.png", true);
//    }
//    
//    private void loadImageStateMission(){
//    	//loadGeneralBackg();
//
//      //  buttonCashIn = loadImageAssets("task/button_cashin.png", true);
//       // buttonCashInLocked = loadImageAssets(
//         //       "task/button_cashin_inactive.png", true);
//        //backgTask = loadImageAssets("task/tasks_background.png", true);
//        //taskSelected = loadImageAssets("task/tasks_selected.png", true);
//        //taskItemBackg = loadImageAssets("task/tasks_item_background.png",
//          //      true);
//       // checkBig = loadImageAssets("task/tasks_checkmark_large.png", true);
//      //  checkSmall = loadImageAssets("task/tasks_checkmark_small.png", true);
//      //  buttonProduce = new ImageButton(loadImageAssets(
//        //        "elementsBuilding/produce_active.png", true), 0, 0, null);
//        buttonProduceInactive = loadImageAssets(
//                "elementsBuilding/produce_inactive.png", true);
//
//    }
//
//    private void loadIconsMainMarket() {
//        Log.d(TAG, "loadIconsMainMarket()");
//        int itemWidth = 253;
//        int itemHeight = 179;
//        if (spriteMainMarketIcons != null) {
//            return;
//        } else {
//            spriteMainMarketIcons = loadImageAssets(
//                    "mainmarket/spriteIconsMainMarket.png", false);
//            createHorizontalSprite(spriteMainMarketIcons, itemMarket,
//                    itemWidth, itemHeight, true);
//            
//            spriteMainMarketIcons = null;
//        }
//    }
//
//    private void loadIconsFood() {
//        Log.d(TAG, "loadIconsFood()");
//        int itemWidth = 96;
//        int itemHeight = 99;
//        if (spriteFoodIcons != null) {
//            return;
//        } else {
//            spriteFoodIcons = loadImageAssets("NoFood/spriteFoodIcons.png",
//                    false);
//            createHorizontalSprite(spriteFoodIcons, iconNoFood, itemWidth,
//                    itemHeight, true);
//        
//            spriteFoodIcons = null;
//        }
//    }
//
//    private void loadTilesGeneral() {
//        Log.d(TAG, "loadTilesGeneral()");
//
//        // TODO maybe resize for 240x320?
//        tiledGeneral = loadBitmap("maps/newMaps/tile2.png", false);
//
//        tiledMap[0] = loadBitmap("maps/newMaps/tile3.png", false);
//        tiledMap[1] = loadBitmap("maps/newMaps/tile4.png", false);
//        tiledMap[2] = loadBitmap("maps/newMaps/tile5.png", false);
//        tiledMap[3] = loadBitmap("maps/newMaps/tile6.png", false);
//        tiledMap[4] = loadBitmap("maps/newMaps/tile7.png", false);
//        tiledMap[5] = loadBitmap("maps/newMaps/tile8.png", false);
//        tiledMap[6] = loadBitmap("maps/newMaps/tile9.png", false);
//        tiledMap[7] = loadBitmap("maps/newMaps/tile10.png", false);
//        tiledMap[8] = loadBitmap("maps/newMaps/tile11.png", false);
//
//        tiledMap[9] = loadBitmap("maps/newMaps/tree1.png", false);
//        tiledMap[10] = loadBitmap("maps/newMaps/tree2.png", false);
//        tiledMap[11] = loadBitmap("maps/newMaps/tree3.png", false);
//        tiledMap[12] = loadBitmap("maps/newMaps/tree4.png", false);
//        tiledMap[13] = loadBitmap("maps/newMaps/tree5.png", false);
//        tiledMap[14] = loadBitmap("maps/newMaps/tree6.png", false);
//        tiledMap[15] = loadBitmap("maps/newMaps/tree7.png", false);
//        tiledMap[16] = loadBitmap("maps/newMaps/tree8.png", false);
//        tiledMap[17] = loadBitmap("maps/newMaps/tree9.png", false);
//        tiledMap[18] = loadBitmap("maps/newMaps/tree10.png", false);
//
//        tiledMap[19] = loadBitmap("maps/newMaps/road/road2.png", false);
//        tiledMap[20] = loadBitmap("maps/newMaps/road/road3.png", false);
//        tiledMap[21] = loadBitmap("maps/newMaps/road/road4.png", false);
//        tiledMap[22] = loadBitmap("maps/newMaps/road/road5.png", false);
//        tiledMap[23] = loadBitmap("maps/newMaps/road/road6.png", false);
//        tiledMap[24] = loadBitmap("maps/newMaps/road/road7.png", false);
//    }
//
//    private void loadMoreDiamondsIcons() {
//        Log.d(TAG, "loadMoreDiamondsIcons()");
//        if (spriteIconDiamonds != null) {
//            return;
//        } else {
//            spriteIconDiamonds = loadImageAssets(
//                    "MoreMoney/spriteDiamondsShop.png", false);
//            createHorizontalSprite(spriteIconDiamonds, iconMoreDiamonds,
//                    iconsMoreDiamondsWidth, iconsMoreMoneyHeight, true);
//        
//            spriteIconDiamonds = null;
//        }
//    }
//
//    private void loadMoreGoldIcons() {
//        Log.d(TAG, "loadMoreGoldIcons()");
//        if (spriteIconGold != null) {
//            return;
//        } else {
//            spriteIconGold = loadImageAssets("MoreMoney/spriteGoldShop.png",
//                    false);
//            createHorizontalSprite(spriteIconGold, iconMoreCoins,
//                    iconsMoreGoldWidth, iconsMoreMoneyHeight, true);
//            spriteIconGold = null;
//        }
//    }
//
//    private void createHorizontalSprite(Bitmap sprite, Bitmap[] array,
//            int itemWidth, int itemHeight, boolean isResizable) {
//        int offset = 0;
//        Bitmap auxBitmap = null;
//        for (int i = 0; i < array.length; i++) {
//            auxBitmap = Bitmap.createBitmap(sprite, offset, 0, itemWidth,
//                    itemHeight);
//
//            if(isResizable){
//            	array[i] = UtilSoftgames.resizeToCalculatedResolution(auxBitmap,
//                    mCanvasWidth, mCanvasHeight);
//            } else {
//            	array[i] = auxBitmap;
//            }
//            offset += itemWidth;
//
//            auxBitmap = null;
//
//        }
//    }
//
//    private void loadCharactersIcons() {
//        Log.d(TAG, "loadCharactersIcons()");
//        if (spriteIconCharacters != null) {
//            return;
//        } else {
//            spriteIconCharacters = loadImageAssets(
//                    "Characters/spriteCharactersIcon.png", false);
//
//            createHorizontalSprite(spriteIconCharacters, iconCharacter,
//                    iconsCharactersWidth, iconsCharactersHeight, true);
//
//            spriteIconCharacters = null;
//        }
//    }
//
//    private void loadIconAnimals() {
//        Log.d(TAG, "loadIconAnimals()");
//        if (spriteIconAnimals != null) {
//            return;
//        } else {
//            spriteIconAnimals = loadImageAssets(
//                    "iconAnimals/spriteAnimals.png", false);
//			createHorizontalSprite(spriteIconAnimals, iconAnimals,
//                    iconsBigWidth, iconsBigHeight, true);
//
//            spriteIconAnimals = null;
//        }
//    }
//
//    private void loadSpriteTutorial() {
//        Log.d(TAG, "loadSpriteTutorial()");
//      /*  if (spriteTutorial != null) {
//            return;
//        } else {
//            spriteTutorial = loadImageAssets("tutorial/spriteTutorial.jpg",
//                    false);
//
//            createHorizontalSprite(spriteTutorial, screenTuto,
//                    tutorialScreenWidth, tutorialScreenHeight, false);
//
//        }*/
//    	/*if((mCanvasWidth == 1196 && mCanvasHeight == 720) || (mCanvasWidth == 1280 && mCanvasHeight == 720)){
//    		screenTuto[0] = loadImageAssets("tutorial/spriteTutorial1.jpg", false);
//    		screenTuto[1] = loadImageAssets("tutorial/spriteTutorial2.jpg", false);
//    	} else {*/
//    		screenTuto[0] = loadImageAssets("tutorial/spriteTutorial1.jpg", true);
//    		screenTuto[1] = loadImageAssets("tutorial/spriteTutorial2.jpg", true);
//    	
//    //	}
//    }
//
//    private void loadCollectionsIcons() {
//        Log.d(TAG, "loadCollectionsIcons()");
//        if (spriteIconCollections != null) {
//            return;
//        } else {
//            spriteIconCollections = loadImageAssets(
//                    "collections-achievements/spriteCollectionsIcons.png",
//                    false);
//
//            int offsetIcon = 0;
//            Bitmap auxBitmap = null;
//            for (int i = 0; i < collectionsImages.length; i++) {
//                // This sprite is vertical
//                auxBitmap = Bitmap.createBitmap(spriteIconCollections, 0,
//                        offsetIcon, collectionsWidth, collectionsHeight);
//                auxBitmap = UtilSoftgames.resizeToCalculatedResolution(
//                        auxBitmap, mCanvasWidth, mCanvasHeight);
//                collectionsImages[i] = new Image(auxBitmap);
//                offsetIcon += collectionsHeight;
//            }
//            // Let's ensure that this can be garbage collected
//            auxBitmap = null;
//        }
//    }
//
//    private void loadAchievementsIcons() {
//        Log.d(TAG, "loadAchievementsIcons()");
//        if (spriteIconAchievements != null) {
//            return;
//        } else {
//            spriteIconAchievements = loadImageAssets(
//                    "collections-achievements/iconsAchievements/spriteAchievementsIcons.png",
//                    false);
//
//            createHorizontalSprite(spriteIconAchievements, iconAchievements,
//                    iconsSmallWidth, iconsAchievementsHeight, true);
//            spriteIconAchievements = null;
//        }
//    }
//
//    private void loadIconCrops() {
//        Log.d(TAG, "loadIconCrops()");
//        if (spriteIconCrops != null) {
//            return;
//        } else {
//            spriteIconCrops = loadImageAssets("iconCrops/spriteIconCrops.png",
//                    false);
//
//            createHorizontalSprite(spriteIconCrops, iconCrops, iconsSmallWidth,
//                    iconsSmallHeight, true);
//            spriteIconCrops = null;
//        }
//    }
//
//    private void loadIconDecoration() {
//        Log.d(TAG, "loadIconDecoration()");
//
//        decorationsBg = loadImageAssets("iconsDecoration/decoration_bg.png",
//                true);
//
//        if (spriteIconDecorations != null) {
//            return;
//        } else {
//            spriteIconDecorations = loadImageAssets(
//                    "iconsDecoration/spriteDecorations.png", false);
//
//            createHorizontalSprite(spriteIconDecorations, iconDecorations,
//                    iconsBigWidth, iconsBigHeight, true);
//            spriteIconDecorations = null;
//        }
//    }
//
//    private void loadIconsBuildings() {
//        Log.d(TAG, "loadIconBuilding()");
///*
//        if (spriteIconsBuildings != null) {
//            return;
//        } else {
//            spriteIconsBuildings = loadImageAssets(
//                    "iconsBuilding/iconsBuildingsSprite.png", false);
//
//            createHorizontalSprite(spriteIconsBuildings, iconBuilding,
//                    iconsBigWidth, iconsBigHeight, false);
//
//        }*/
//        for(int i = 0; i < 14; i++){
//        	iconBuilding[i] =  loadImageAssets("iconsBuilding/icon"+ i + ".png", true);
//        }
//    }
//
//    private void loadGeneralBackg() {
//        Log.d(TAG, "loadGeneralBackg()");
//        if (backgroundGeneral != null) {
//            return;
//        }
//        backgroundGeneral = loadImageAssets(
//                "generalimages/general_background.png", true);
//        buttonClose = new ImageButton(loadImageAssets(
//                "generalimages/button_close.png", true), 0, mCanvasHeight / 2
//                - backgroundGeneral.getHeight() / 2, loadImageAssets(
//                "generalimages/button_close_pressed.png", true));
//        buttonClose.setPosX(mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2
//                - buttonClose.getImage().getWidth());
//
//    }
//
//    private void preparateMoving(int tiledX, int tiledY) {
//    	int []pos = calculatePosInitialMap(tiledX, tiledY);
//        movingScreen = true;
//        int positionFinal_X = World.posWorldX + pos[0];
//        int positionFinal_Y = World.posWorldY + pos[1]; 
//        correctPosition_X = false;
//        correctPosition_Y = false;
//        
//        int[][] posRefe = tiledChosenInMap(null, null, null);
//        int[] pos2 = calculatePosInitialMap(posRefe[0][0], posRefe[0][1]);
//        
//        int positionCurrent_X =  World.posWorldX + pos2[0];
//        int positionCurrent_Y =  World.posWorldY + pos2[1];
//        
//        distanceMoveMap_X = World.posWorldX + (positionCurrent_X - positionFinal_X);
//        distanceMoveMap_Y = World.posWorldY + (positionCurrent_Y - positionFinal_Y);
//        speedMoveMap_X = ((positionCurrent_X - positionFinal_X) < 0)? -10 : 10;
//        speedMoveMap_Y = ((positionCurrent_Y - positionFinal_Y) < 0)? -10 : 10;
//        
//    }
//    private void movingScreenAutomatically(Canvas canvas) {
//    
//    	if(movingScreen){
//              if(!correctPosition_X){
//            	  World.posWorldX += speedMoveMap_X;
//    				
//    				if(speedMoveMap_X < 0){
//    					if(World.posWorldX < distanceMoveMap_X){
//    						//World.posWorldX = distanceMoveMap_X;
//    						correctPosition_X = true;
//    					}
//    				} else {
//    					if(World.posWorldX > distanceMoveMap_X){
//    					   correctPosition_X = true;
//    					}
//    				}
//    			}
//    		
//    		
//    		if(!correctPosition_Y){
//    			World.posWorldY += speedMoveMap_Y;
//				
//				if(speedMoveMap_Y < 0){
//					if(World.posWorldY < distanceMoveMap_Y){
//						correctPosition_Y = true;
//					}
//				} else {
//					if(World.posWorldY > distanceMoveMap_Y){
//					   correctPosition_Y = true;
//					}
//				}
//    		}
//    		
//    		if(correctPosition_Y && correctPosition_X){
//    			movingScreen = false;
//    		}
//    	
//    	}
//          
//          
//    	
//    }
//    
//    /*private int[] foundPositionCenterFromTiled(int tiled_X, int tiled_Y){
//    	int []posfinal = new int[2];
//    	
//    	for(int i = 0; i < 3; i++){
//    		
//    	}
//    	
//    	return posfinal;
//    	
//    }*/
//    
//    private void paintStateWinMaterial(Canvas canvas) {
//        Log.d(TAG, "paintStateWinMaterial");
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[270], null);
//        animationElementChosen();
//        int posX = mCanvasWidth / 2 - productItemBackground.getWidth() / 2;
//        int posY = winMaterialOffsetTextY;
//
//        canvas.drawBitmap(productItemBackground, posX, posY, null);
//
//        canvas.drawBitmap(Constants.iconProduced[numberMaterial + 56], posX
//                + productItemBackground.getWidth() / 2
//                - Constants.iconProduced[numberMaterial + 56].getWidth() / 2,
//                posY + 20, null);
//        // TODO was 56, products names were moved one position
//        canvas.drawText(texts[Constants.PRODUCT_NAME[numberMaterial + 57]],
//                posX + productItemBackground.getWidth() / 2, posY
//                        + productItemBackground.getHeight()
//                        - buttonAddProduct.getImage().getHeight(),
//                fontQuantityMaterialProduce);
//
//        buttonBuild.setPosX((mCanvasWidth / 2)
//                - buttonBuild.getImage().getWidth() / 2);
//
//        buttonBuild.setPosY(winMaterialBtnBuildOffsetY);
//        buttonBuild.paint(canvas);
//
//        canvas.drawText(texts[271] + "", mCanvasWidth / 2,
//                buttonBuild.getPosY()
//                        + (buttonBuild.getImage().getHeight() / 4) * 3,
//                fontQuantityMaterialProduce);
//    }
//
//    private void paintStateBuild(Canvas canvas) {
//
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        switch (buildingsPut[buildingChosen].getCurrentStatus()) {
//        case EMPTY:
//            // paintBuildEmpty(canvas);
//            break;
//        case READY:
//        case PRODUCING:
//        case PRODUCED:
//            paintBuildReady(canvas);
//            break;
//        case CHOOSE:
//            paintBuildChoose(canvas);
//            break;
//        }
//        transCurrent1Second();
//        paintPopUpInfo(canvas);
//        if (tutorialGame && stateGame == Constants.STATE_PRODUCTION) {
//            paintInfoTutorial(canvas, 0);
//        }
//
//    }
//
//    private void paintBuildChoose(Canvas canvas) {
//        Log.d(TAG, "paintBuildChoose");
//        paintTitleGeneral(canvas,
//                texts[Constants.BUILDING_NAME[buildingsPut[buildingChosen]
//                        .getType()]], texts[5]);
//
//        if (buildingsPut[buildingChosen].getUpdgrade() < 4) {
//            buttonUpgrade.setPosX(buttonClose.getPosX()
//                    - buttonUpgrade.getImage().getWidth() - 10);
//            buttonUpgrade.setPosY(buttonClose.getPosY() + 40);
//            buttonUpgrade.paintWithText(canvas, texts[194],
//                    fontWhiteSmallCenter, 10, 0);
//
//        }
//
//        int diff = 10;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 4) / 2;
//        int posY = posButBackgProduce_Y;
//        int typeIcon = 0;
//
//        for (int i = 0; i < 4; i++) {
//            typeIcon = buildingsPut[buildingChosen].getItemProduce()[i];
//
//            if (buildingsPut[buildingChosen].getUpdgrade() - 1 >= i) {
//                canvas.drawBitmap(productItemBackground, posX, posY, null);
//
//                canvas.drawText(
//                        (typeIcon > 155) ? texts[Constants.PRODUCT_ANIMAL_INFO[typeIcon - 156][0]]
//                                : texts[Constants.PRODUCT_NAME[typeIcon]], posX
//                                + productItemBackground.getWidth() / 2, posY
//                                + (productItemBackground.getHeight() / 4) * 3,
//                        fontQuantityMaterialProduce);
//
//            } else {
//                canvas.drawBitmap(productItemBackgroundInactive, posX, posY,
//                        null);
//
//                if (buildingsPut[buildingChosen].getUpdgrade() == i) {
//                    buttonUpgrade.setPosX(posX
//                            + productItemBackground.getWidth() / 2
//                            - buttonUpgrade.getImage().getWidth() / 2);
//                    buttonUpgrade.setPosY(posY
//                            + productItemBackground.getHeight()
//                            - buttonUpgrade.getImage().getHeight());
//                    buttonUpgrade.paintWithText(canvas, texts[194],
//                            fontWhiteSmallCenter, 10, 0);
//
//                }
//
//            }
//            canvas.drawBitmap(Constants.iconProduced[typeIcon], posX
//                    + productItemBackground.getWidth() / 2
//                    - Constants.iconProduced[typeIcon].getWidth() / 2, posY
//                    + productItemBackground.getHeight() / 2
//                    - Constants.iconProduced[typeIcon].getHeight() / 2, null);
//
//            if (tutorialGame
//                    && i == 0
//                    && stepTutorial == Constants.STEP_TUTORIAL_ENTER_PRODUCTION_VIEW) {
//                paintAnimationCursor(canvas,
//                        posX + productItemBackground.getWidth() / 2
//                                - cursorHand.getWidth() / 2, posY
//                                + productItemBackground.getHeight() / 2
//                                - cursorHand.getHeight() / 3 + cursorY, -1);
//
//            }
//
//            posX += productItemBackground.getWidth() + diff;
//        }
//
//        paintBuildingSlot(canvas);
//        animationElementChosen();
//
//    }
//
//    private void paintTitleGeneral(Canvas canvas, String title, String msjTitle) {
//
//        canvas.drawText(title, mCanvasWidth / 2, titleGeneral_Y,
//                fontTitleCenter);
//        if (msjTitle != null) {
//            canvas.drawText(msjTitle, mCanvasWidth / 2, titleAuxGeneral_Y,
//                    fontMsjTitle);
//        }
//    }
//
//    private void validateMission() {
//        for (int h = 0; h < nMission; h++) {
//            canRewardMission[h] = true;
//
//            for (int i = 0; i < nTask[h]; i++) {
//                if (isReadyTask(i, h) != quantityProduct[h][i]) {
//                    canRewardMission[h] = false;
//                    break;
//                }
//
//            }
//
//            if (canRewardMission[h]) {
//              //  rewardsTotalCoins[h] = rewardsCoins[h];
//             //   rewardsTotalXP[h] = rewardsXP[h];
//                stateGame = Constants.STATE_MISSION;
//                missionChosen = h;
//                if(tutorialGame){
//                	stepTutorial = Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED;
//                }
//               
//            } else {
//              //  rewardsTotalCoins[h] = 0;
//             //   rewardsTotalXP[h] = 0;
//            }
//
//        }
//
//    }
//
//    protected void restValueMission(int type, int posProduct) {
//
//        boolean addProduct = false;
//
//        // int posObject = 0;
//        boolean rewardPaid = false;
//        for (int h = 0; h < nMission; h++) {
//            for (int i = 0; i < nTask[h]; i++) {
//                addProduct = false;
//                if (type == Constants.MISSION_TYPE_CROPS
//                        && typeMission[h][i] == type) {
//
//                    if (typeProduct[h][i] == posProduct) {
//                        addProduct = true;
//                    }
//                } else if (type == Constants.MISSION_TYPE_ANIMALS
//                        && typeMission[h][i] == type) {
//
//                    if (typeProduct[h][i] + 15 == posProduct) {
//                        addProduct = true;
//                    }
//                } else if (type == Constants.MISSION_TYPE_DECO
//                        && typeMission[h][i] == type) {
//
//                    if (typeProduct[h][i] == posProduct) {
//                        addProduct = true;
//                    }
//                } else if (typeMission[h][i] == type) {
//                    addProduct = true;
//                }
//
//                if (addProduct) {
//                    if (quantityProductDone[h][i] + 1 <= quantityProduct[h][i]) {
//                        quantityProductDone[h][i] += 1;
//                        if (/*
//                             * quantityProductDone[h][i]
//                             */isReadyTask(i, h) == quantityProduct[h][i]) {
//                            //animationIconProgress = true;
//                            for (int m = 0; m < 3; m++) {
//                                if (h == missionCharacter[m]) {
//                                    animationIconProgressCharacater[m] = true;
//                                }
//                            }
//                        }
//                        rewardPaid = true;
//                        if (typeMission[h][i] == Constants.GET_GOLD) {
//                            recalculateDiamondsForFinish(h);
//                        } else {
//                            /*diamondsToFinishMission[h] -= valuesDiamondsFinishMission(
//                                    type, posProduct);*/
//                        }
//
//                    }
//                    break;
//                }
//
//            }
//
//            canRewardMission[h] = true;
//            for (int i = 0; i < nTask[h]; i++) {
//                if (isReadyTask(i, h) != quantityProduct[h][i]) {
//                    canRewardMission[h] = false;
//                    break;
//                }
//
//            }
//
//            if (canRewardMission[h]) {
//             //   rewardsTotalCoins[h] = rewardsCoins[h];
//            //    rewardsTotalXP[h] = rewardsXP[h];
//                
//                stateGame = Constants.STATE_MISSION;
//                missionChosen = h;
//               /* if(tutorialGame){
//                	stepTutorial = Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED;
//                }*/
//            }
//
//            if (rewardPaid) {
//                break;
//            }
//        }
//
//    }
//
//    private void recalculateDiamondsForFinish(int tempMission) {
//        diamondsToFinishMission[tempMission] = 0;
//        for (int i = 0; i < nTask[tempMission]; i++) {
//            if (quantityProductDone[tempMission][i] < quantityProduct[tempMission][i]) {
//                if (quantityProduct[tempMission][i] >= 500) {
//                    int rest = (quantityProduct[tempMission][i] - quantityProductDone[tempMission][i]);
//                    if (rest < 500 && rest > 1) {
//                        rest = 1;
//                    } else {
//                        rest = rest / 500;
//                    }
//                    int quant = (rest) * 3;
//                    if (quant < 0)
//                        quant = 0;
//                    diamondsToFinishMission[tempMission] += quant;
//                }
//            }
//        }
//    }
//
//    private void paintNeedProduct(Canvas canvas, int posX, int posY,
//            Bitmap icon, int quantityCurrentCrops, int quantityNeedCrops,
//            int type, int diamondsForAddProduct) {
//        Log.d(TAG, "paintNeedProduct()");
//        canvas.drawBitmap(productItemBackground, posX, posY, null);
//
//        infoIcon.setPosX(posX + 10);
//        infoIcon.setPosY(posY + 10);
//        infoIcon.paint(canvas);
//
//        canvas.drawBitmap(icon, posX + productItemBackground.getWidth() / 2
//                - icon.getWidth() / 2, posY + productItemBackground.getHeight()
//                / 2 - icon.getHeight() / 2 - iconProductReady_Y, null);
//
//        canvas.drawText(
//                (type > 155) ? texts[Constants.PRODUCT_ANIMAL_INFO[type - 156][0]]
//                        : texts[Constants.PRODUCT_NAMEIN_BUILDING[type]], posX
//                        + productItemBackground.getWidth() / 2, posY
//                        + productItemBackground.getHeight()
//                        - buttonAddProduct.getImage().getHeight()
//                        - nameIconProReady_Y, fontQuantityMaterialProduce);
//
//        canvas.drawText(quantityCurrentCrops + "/" + quantityNeedCrops, posX
//                + productItemBackground.getWidth() / 2,
//                posY + productItemBackground.getHeight()
//                        - buttonAddProduct.getImage().getHeight()
//                        - quantityNeedCrops_Y, fontWhiteSmallCenter);
//
//        buttonAddProduct.setPosX(posX + productItemBackground.getWidth() / 2
//                - buttonAddProduct.getImage().getWidth() / 2);
//        buttonAddProduct.setPosY(posY + productItemBackground.getHeight()
//                - buttonAddProduct.getImage().getHeight());
//
//        if (quantityCurrentCrops < quantityNeedCrops) {
//            buttonAddProduct.paint(canvas);
//            canProduce = false;
//        } else {
//            canvas.drawBitmap(buttonAddProductInactive, posX
//                    + productItemBackground.getWidth() / 2
//                    - buttonAddProduct.getImage().getWidth() / 2, posY
//                    + productItemBackground.getHeight()
//                    - buttonAddProduct.getImage().getHeight(), null);
//        }
//
//        String[] textToShow = { texts[16] + " (" + diamondsForAddProduct, ")" };
//        Bitmap[] imageToShow = { diamondSmall, null };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, textToShow, imageToShow,
//                fontMoneyToPay, posX + productItemBackground.getWidth() / 2,
//                buttonAddProduct.getPosY()
//                        + (buttonAddProduct.getImage().getHeight() / 3) * 2);
//
//    }
//
//    private int convertStorageToProducts(int productType, int quantity) {
//        Log.d(TAG, "convertStorageToProducts()");
//        int quantityItem = 0;
//        boolean found = false;
//        for (int i = 0; i < indexStorage; i++) {
//            if (itemStorage[i][0] == Constants.STORAGE_CROPS
//                    && itemStorage[i][1] == productType) {
//                found = true;
//            } else if (itemStorage[i][0] == Constants.STORAGE_ANIMALS_PRODUCTS
//                    && itemStorage[i][1] == productType - 156) {
//                found = true;
//            } else if (itemStorage[i][0] == Constants.STORAGE_PRODUCTS
//                    && itemStorage[i][1] == productType /*- 17*/) {
//                found = true;
//            }
//
//            if (found) {
//                addProductToStorage(productType, quantity);
//                quantityItem = itemStorage[i][2];
//                break;
//            }
//        }
//
//        if (!found && quantity != 0) {
//            addProductToStorage(productType, quantity);
//        }
//        return quantityItem;
//    }
//
//    private void addProductToStorage(int productType, int quantity) {
//        Log.d(TAG, "convertStorageToProducts");
//        int typeItem = 0;
//        int typeStorageProduct = 0;
//
//        if (productType >= 156) {
//            typeItem = Constants.STORAGE_ANIMALS_PRODUCTS;
//            typeStorageProduct = productType - 156;
//        } else if (productType >= 17) {
//            typeItem = Constants.STORAGE_PRODUCTS;
//            typeStorageProduct = productType;// -17;
//        } else {
//            typeItem = Constants.STORAGE_CROPS;
//            typeStorageProduct = productType;
//        }
//
//        assignStorage(typeItem, quantity, typeStorageProduct);
//    }
//
//    private void paintBuildReady(Canvas canvas) {
//        Log.d(TAG, "paintBuildReady");
//        buttonBack.paint(canvas);
//        paintTitleGeneral(canvas,
//                texts[Constants.BUILDING_NAME[buildingsPut[buildingChosen]
//                        .getType()]], texts[5]);
//
//        int diff = symbolPlus.getWidth() + 8;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 3) / 2;
//        int posY = posButBackgProduce_Y;// 200;
//        canProduce = true;
//        int quantityNeedCrops = 0;
//        int quantityCurrentCrops = 0;
//        int type = 0;
//        for (int i = 0; i < 3; i++) {
//
//            switch (i) {
//            case 0:
//                type = buildingsPut[buildingChosen].getMaterialProcesing2()[productChosen];
//                if (type != -1) {
//                    canvas.drawBitmap(symbolPlus,
//                            posX + productItemBackground.getWidth() + 2, posY
//                                    + productItemBackground.getHeight() / 2
//                                    - symbolPlus.getHeight() / 2, null);
//                } else {
//                    posX += productItemBackground.getWidth() + diff;
//                    canvas.drawBitmap(symbolEquals,
//                            posX + productItemBackground.getWidth() + 2, posY
//                                    + productItemBackground.getHeight() / 2
//                                    - symbolPlus.getHeight() / 2, null);
//                    i++;
//                }
//                type = buildingsPut[buildingChosen].getMaterialProcesing1()[productChosen];
//                quantityCurrentCrops = convertStorageToProducts(type, 0);
//                quantityNeedCrops = buildingsPut[buildingChosen]
//                        .getQuantityMaterialProcesing1()[productChosen];
//
//                paintNeedProduct(
//                        canvas,
//                        posX,
//                        posY,
//                        Constants.iconProduced[type],
//                        quantityCurrentCrops,
//                        quantityNeedCrops,
//                        type,
//                        buildingsPut[buildingChosen].getDiamondAddMaterial_1()[productChosen]);
//
//                break;
//
//            case 1:
//                type = buildingsPut[buildingChosen].getMaterialProcesing2()[productChosen];
//
//                if (type != -1) {
//                    quantityCurrentCrops = convertStorageToProducts(type, 0);
//                    quantityNeedCrops = buildingsPut[buildingChosen]
//                            .getQuantityMaterialProcesing2()[productChosen];
//                    paintNeedProduct(canvas, posX, posY,
//                            Constants.iconProduced[type], quantityCurrentCrops,
//                            quantityNeedCrops, type,
//                            buildingsPut[buildingChosen]
//                                    .getDiamondAddMaterial_2()[productChosen]);
//
//                } else {
//                    canvas.drawBitmap(productItemBackgroundInactive, posX,
//                            posY, null);
//                }
//
//                canvas.drawBitmap(symbolEquals,
//                        posX + productItemBackground.getWidth() + 2, posY
//                                + productItemBackground.getHeight() / 2
//                                - symbolPlus.getHeight() / 2, null);
//                break;
//
//            case 2:
//                int posIcon = buildingsPut[buildingChosen].getItemProduce()[productChosen];
//
//                canvas.drawBitmap(backgInfoProduct, posX, posY
//                        + productItemBackground.getHeight() / 2
//                        - backgInfoProduct.getHeight() / 2, null);
//
//                canvas.drawText(
//                        texts[147]
//                                + " "
//                                + buildingsPut[buildingChosen]
//                                        .getTimeProducts()[productChosen]
//                                + " Sec", posX + backgInfoProduct.getWidth()
//                                / 2, posY + timeProducFinal_Y,
//                        fontWhiteSmallCenter);
//
//                canvas.drawText(texts[Constants.PRODUCT_NAME[posIcon]], posX
//                        + backgInfoProduct.getWidth() / 2, posY
//                        + nameProductFinal_Y, fontQuantityMaterialProduce);
//
//                canvas.drawBitmap(buildingPlusInfo,
//                        posX + backgInfoProduct.getWidth() / 2 + plusFinal_X,
//                        posY + productItemBackground.getHeight() / 2
//                                - plusFinal_Y, null);
//
//                canvas.drawText(
//                        "" + getInfoProducts(posIcon, 5) + " XP",
//                        posX + backgInfoProduct.getWidth() / 2
//                                + buildingPlusInfo.getWidth() + plusFinalText_X,
//                        posY + productItemBackground.getHeight() / 2
//                                - plusFinalText_Y
//                                + (buildingPlusInfo.getHeight() / 3) * 2,
//                        fontWhiteSmallLeft);
//
//                canvas.drawBitmap(buildingPlusInfo,
//                        posX + backgInfoProduct.getWidth() / 2 + plusFinal_X,
//                        posY + productItemBackground.getHeight() / 2
//                                + buildingPlusInfo.getHeight(), null);
//
//                canvas.drawText(
//                        "" + getInfoProducts(posIcon, 7) + " Gold",
//                        posX + backgInfoProduct.getWidth() / 2
//                                + buildingPlusInfo.getWidth() + plusFinalText_X,
//                        posY + productItemBackground.getHeight() / 2
//                                + buildingPlusInfo.getHeight()
//                                + (buildingPlusInfo.getHeight() / 3) * 2,
//                        fontWhiteSmallLeft);
//
//                if (canProduce) {
//                    buttonProduce.setPosX(posX + backgInfoProduct.getWidth()
//                            / 2 - buttonProduce.getImage().getWidth() / 2);
//                    buttonProduce.setPosY(posY + backgInfoProduct.getHeight()
//                            - buttonProduce.getImage().getHeight() / 2);
//                    buttonProduce.paint(canvas);
//
//                } else {
//                    canvas.drawBitmap(buttonProduceInactive, posX
//                            + backgInfoProduct.getWidth() / 2
//                            - buttonProduce.getImage().getWidth() / 2, posY
//                            + backgInfoProduct.getHeight()
//                            - buttonProduce.getImage().getHeight() / 2, null);
//                }
//
//                canvas.drawBitmap(Constants.iconProduced[posIcon], posX
//                        + iconProduceFinal_X,
//                        posY + productItemBackground.getHeight() / 2
//                                - Constants.iconProduced[posIcon].getHeight()
//                                / 2, null);
//
//                canvas.drawText(texts[29], posX + backgInfoProduct.getWidth()
//                        / 2, buttonAddProduct.getPosY()
//                        + (buttonAddProduct.getImage().getHeight() / 3) * 2,
//                        fontQuantityMaterialProduce);
//
//                if (tutorialGame
//                        && stepTutorial == Constants.STEP_TUTORIAL_PRESS_PRODUCE
//                        && stepInAuxTutorial == 7 && canProduce) {
//                    paintAnimationCursor(canvas, buttonProduce.getPosX()
//                            + buttonProduce.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                            buttonProduce.getPosY()
//                                    + buttonProduce.getImage().getHeight() / 2
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//
//                }
//                break;
//            }
//
//            posX += productItemBackground.getWidth() + diff;
//        }
//
//        paintBuildingSlot(canvas);
//
//        animationElementChosen();
//    }
//
//    private void paintBuildingSlot(Canvas canvas) {
//
//        int diff = 15;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackgroundSmall.getWidth() + diff) * 5) / 2;
//        int posY = posSlotProduce_Y;
//
//        canvas.drawText(texts[4],
//                mCanvasWidth / 2 - backgroundGeneral.getWidth() / 2
//                        + squareProduce[0], textInfoProduce_Y, fontYellowMed);
//
//        for (int i = 0; i < 5; i++) {
//            if (buildingsPut[buildingChosen].getSlot()[i] == 3) {// Done
//
//                canvas.drawBitmap(productItemBackgroundSmall, posX, posY, null);
//
//                int posIcon = buildingsPut[buildingChosen].getItemProducing()[i];
//
//                canvas.drawBitmap(Constants.iconProduced[posIcon], posX
//                        + productItemBackgroundSmall.getWidth() / 2
//                        - Constants.iconProduced[posIcon].getWidth() / 2, posY
//                        + productItemBackgroundSmall.getHeight() / 2
//                        - Constants.iconProduced[posIcon].getHeight() / 2, null);
//
//                canvas.drawText(texts[144],
//                        posX + productItemBackgroundSmall.getWidth() / 2,
//                        posY + 25, fontQuantityMaterialProduce);
//
//                canvas.drawBitmap(buttonCollect, posX
//                        + productItemBackgroundSmall.getWidth() / 2
//                        - buttonCollect.getWidth() / 2, posY
//                        + productItemBackgroundSmall.getHeight()
//                        - buttonCollect.getHeight() / 2, null);
//
//                if (tutorialGame
//                        && i == 0
//                        && stepTutorial == Constants.STEP_TUTORIAL_PRESS_PRODUCE
//                        && stepInAuxTutorial == 9) {
//                    paintAnimationCursor(
//                            canvas,
//                            posX + productItemBackgroundSmall.getWidth() / 2
//                                    - buttonCollect.getWidth() / 2
//                                    + buttonCollect.getWidth() / 2
//                                    - cursorHand.getWidth() / 2, posY
//                                    + productItemBackgroundSmall.getHeight()
//                                    - buttonCollect.getHeight() / 2
//                                    + cursorHand.getHeight() / 2 + cursorY, -1);
//
//                }
//            } else if (buildingsPut[buildingChosen].getSlot()[i] == 2) { // Producing
//                canvas.drawBitmap(productItemBackgroundSmall, posX, posY, null);
//
//                int posIcon = buildingsPut[buildingChosen].getItemProducing()[i];
//
//                canvas.drawBitmap(Constants.iconProduced[posIcon], posX
//                        + productItemBackgroundSmall.getWidth() / 2
//                        - Constants.iconProduced[posIcon].getWidth() / 2, posY
//                        + productItemBackgroundSmall.getHeight() / 2
//                        - Constants.iconProduced[posIcon].getHeight() / 2, null);
//
//                if (buildingsPut[buildingChosen].getCurrentSlotActive() == i) {
//                    canvas.drawText(
//                            ""
//                                    + buildingsPut[buildingChosen]
//                                            .getTimeForRecollect(i),
//                            posX + productItemBackgroundSmall.getWidth() / 2,
//                            posY + 35, fontQuantityMaterialProduce);
//
//                    canvas.drawBitmap(buttonFinish, posX
//                            + productItemBackgroundSmall.getWidth() / 2
//                            - buttonCollect.getWidth() / 2, posY
//                            + productItemBackgroundSmall.getHeight()
//                            - buttonCollect.getHeight() / 2, null);
//                    // canvas.drawText("1",
//                    // posX + productItemBackgroundSmall.getWidth() / 2
//                    // - buttonCollect.getWidth() / 2 + 75, posY
//                    // + productItemBackgroundSmall.getHeight()
//                    // + buttonCollect.getHeight() / 2,
//                    // fontWhiteSmallLeft);
//                    if (tutorialGame
//                            && i == 0
//                            && stepTutorial == Constants.STEP_TUTORIAL_PRESS_PRODUCE
//                            && stepInAuxTutorial == 8) {
//                        paintAnimationCursor(canvas,
//                                posX + productItemBackgroundSmall.getWidth()
//                                        / 2 - buttonCollect.getWidth() / 2
//                                        + buttonFinish.getWidth() / 2
//                                        - cursorHand.getWidth() / 2,
//                                posY + productItemBackgroundSmall.getHeight()
//                                        - buttonFinish.getHeight() / 2
//                                        + cursorY, -1);
//
//                    }
//                } else {
//                    canvas.drawText(texts[145], posX
//                            + productItemBackgroundSmall.getWidth() / 2,
//                            posY + 35, fontQuantityMaterialProduce);
//                }
//            } else if (buildingsPut[buildingChosen].getSlot()[i] == 0) { // empty
//                canvas.drawBitmap(productItemBackgroundSmall, posX, posY, null);
//                canvas.drawText(texts[143],
//                        posX + prodItemBackgSmallInac.getWidth() / 2, posY
//                                + (prodItemBackgSmallInac.getHeight() / 3) * 2,
//                        fontQuantityMaterialProduce);
//
//            } else if (buildingsPut[buildingChosen].getSlot()[i] == 1) { // block
//                canvas.drawBitmap(prodItemBackgSmallInac, posX, posY, null);
//                canvas.drawText("15", posX + prodItemBackgSmallInac.getWidth()
//                        / 2 - 20, posY
//                        + (prodItemBackgSmallInac.getHeight() / 3) * 2,
//                        fontQuantityMaterialProduce);
//                canvas.drawBitmap(diamondSmall,
//                        posX + prodItemBackgSmallInac.getWidth() / 2 + 10, posY
//                                + (prodItemBackgSmallInac.getHeight() / 2)
//                                - diamondSmall.getHeight() / 2, null);
//            }
//            posX += productItemBackgroundSmall.getWidth() + diff;
//        }
//    }
//
//    private void loadGeneralMarket() {
//        Log.d(TAG, "loadGeneralMarket()");
//        //loadGeneralBackg();
//        backgroundItemMarket = loadImageAssets("mainmarket/shop_background.png", true);
//        if (buttonArrow == null) {
//            buttonArrow = new ImageButton(loadImageAssets(
//                    "marketaux/button_arrow.png", true), 0, 0, loadImageAssets(
//                    "marketaux/button_arrow_pressed.png", true));
//            buttonArrow.setPosX(mCanvasWidth / 2 - backgroundGeneral.getWidth()
//                    / 2);
//            buttonArrow.setPosY(mCanvasHeight / 2
//                    - buttonArrow.getImage().getHeight() / 2);
//        }
//
//        if (buttonArrowRigth == null) {
//            buttonArrowRigth = new ImageButton(loadImageAssets(
//                    "marketaux/button_arrow.png", true), 0, 0, loadImageAssets(
//                    "marketaux/button_arrow_pressed.png", true));
//            buttonArrowRigth.setPosX(mCanvasWidth / 2
//                    + backgroundGeneral.getWidth() / 2
//                    - buttonArrowRigth.getImage().getWidth());
//            buttonArrowRigth.setPosY(mCanvasHeight / 2
//                    - buttonArrow.getImage().getHeight() / 2);
//        }
//
//        if (backgroundItemShop == null) {
//            backgroundItemShop = loadImageAssets(
//                    "marketaux/market_crops_background.png", true);
//        }
//        if (backgroundPage == null) {
//            backgroundPage = loadImageAssets(
//                    "marketaux/general_pages_background.png", true);
//        }
//        if (buttonPagesActive == null) {
//            buttonPagesActive = loadImageAssets(
//                    "marketaux/general_pages_active.png", true);
//        }
//        if (buttonPages == null) {
//            buttonPages = loadImageAssets(
//                    "marketaux/general_pages_inactive.png", true);
//        }
//        
//        
//        
//    }
//
//    private Bitmap loadImageAssets(String name, boolean isResizable) {
//        // return loadBitmap(name, isResizable);
//        return loadImageAssetsSimple(name, isResizable);
//    }
//
//    // Thread method
//    public void run() {
//        setName("GameThread " + getId());
//        
//      //  int sleepTime = 0;
// //       long timeDiff = 0;
////        long beginTime = 0;
//
//        stateGame = Constants.STATE_COVER;
//        timePrev = System.currentTimeMillis();
//        errorGame = false;
//        int 	fpsSleep;
//		
//    	
//		loopPause = System.currentTimeMillis();
//		
//		
//
//	    	
//		Constants.pressedMarket = false;	
//	    	
//        while (mRun) {
//        	loopStart = System.currentTimeMillis();
//        	Canvas canvas = null;
//            // try locking the canvas for exclusive pixel editing
//            // in the surface
//            try {
//                canvas = mSurfaceHolder.lockCanvas(null);
//                synchronized (mSurfaceHolder) {
//                   // beginTime = System.currentTimeMillis();
//                    // framesSkipped = 0; // resetting the frames skipped
//                    // update game state
//                    doDraw(canvas);
//                    
//                   // sleep(30);
//                    // calculate how long did the cycle take
//                   /* timeDiff = System.currentTimeMillis() - beginTime;
//                    // calculate sleep time
//                    sleepTime = (int) (50 - timeDiff);
//
//                    if (sleepTime > 0) {
//                        // if sleepTime > 0 we're OK
//                        try {
//                            // send the thread to sleep for a short period
//                            // very useful for battery saving
//                            Thread.sleep(sleepTime);
//                        } catch (InterruptedException e) {
//                        }
//                    }*/
//                }
//
//            } catch (Exception e) {
//                Log.e(TAG, "", e);
//                // Used when saving
//             //   errorGame = true;
//            } finally {
//                // in case of an exception the surface is not left in
//                // an inconsistent state
//                if (canvas != null) {
//                    mSurfaceHolder.unlockCanvasAndPost(canvas);
//                }
//            }
//            
//            loopEnd = System.currentTimeMillis();
//			
//    		
//			
//			if (loopEnd-loopPause>1000) {
//				loopPause=loopEnd;
//			}
//			
//			// limit gamespeed to a nice frame rate 
//			// (best is 40-60fps)  
//			// math example: (1000/32fps = 31ms per frame)
//			if (loopEnd-loopStart<50) {
//				fpsSleep=50-(int)(loopEnd-loopStart);
//			} else { 
//				fpsSleep=2;  // incase we are trailing behind fps
//			}
//
//			try {
//				sleep(fpsSleep);
//			} catch (InterruptedException e) {}
//        }
//
//    }
//
//    public void setRunning(boolean b) {
//        mRun = b;
//    }
//
//    public boolean getRunning() {
//        return mRun;
//    }
//
//    public void setSurfaceSize(int width, int height) {
//        Log.d(TAG, "setSurfaceSize(" + width + ", " + height + ")");
//        // synchronized to make sure these all change atomically
//        synchronized (mSurfaceHolder) {
//            mCanvasWidth = width;
//            mCanvasHeight = height;
//        }
//    }
//
//    public boolean doTouch(MotionEvent event) {
//        boolean retorno = true;
//        synchronized (mSurfaceHolder) {
//            switch (stateGame) {
//            case Constants.STATE_MAIN_GAME:
//                touchStateMainGame(event);
//                break;
//            case Constants.STATE_MARKET_BUILDING:
//            case Constants.STATE_MARKET_CROPS:
//            case Constants.STATE_MARKET_ANIMALS:
//            case Constants.STATE_MARKET_DECO:
//            case Constants.STATE_COLLECTIONS:
//            case Constants.STATE_ACHIEVEMENTS:
//                posPressX = event.getX();
//                posPressY = event.getY();
//                canBeDragged = true;
//                break;
//            case Constants.STATE_COVER:
//            	  main.hideLoadingScreen();
//                  stateGame = Constants.STATE_LOADING_MAIN;
//                  retorno = false;
//                  mPaint.setColor(Color.BLACK);
//                  UtilSoftgames.mCanvasHeight = mCanvasHeight;
//                  UtilSoftgames.mCanvasWidth = mCanvasWidth;
//                  UtilSoftgames.mRes = mRes;
//            	break;
//            case Constants.STATE_LOADING_MAIN:
//            	
//            	 retorno = false;
//            	break;
//            }
//        }
//        doMove = false;
//        return retorno;
//    }
//
//    private void touchStateMainGame(MotionEvent event) {
//
//       
//        posPressX = event.getX();
//        posPressY = event.getY();
//
//        if (!tutorialGame) {
//            int[][] touch = tiledChosenInMap(event, null, null);
//            World.posMoveFreeX = -1;
//            World.posMoveFreeY = -1;
//            if (touchInAnyObject(event, touch)) {
//                if (!pressHold) {
//                    timePressHold = System.currentTimeMillis();
//                }
//                pressHold = true;
//                World.posMoveFreeX = event.getX();
//                World.posMoveFreeY = event.getY();
//            }
//        }
//    }
//
//    private boolean touchInAnyObject(MotionEvent event, int[][] touch) {
//       // Log.d(TAG, "touchInAnyObject");
//        for (int i = 0; i < NTree; i++) {
//            if (touch[0][0] == tree[i].getPosX()
//                    && touch[0][1] == tree[i].getPosY()) {
//                if (tree[i].isMenuRotate()) {
//                    tree[i].setMenuRotate(false);
//                    // tree[i].setMoveFree(true);
//
//                }
//                return true;
//            }
//        }
//
//        for (int i = 0; i < nDecorationsPut; i++) {
//            if (touch[0][0] == decorationsPut[i].getPos_X()
//                    && touch[0][1] == decorationsPut[i].getPos_Y()) {
//                if (decorationsPut[i].isMenuRotate()) {
//                    decorationsPut[i].setMenuRotate(false);
//                    // decorationsPut[i].setMoveFree(true);
//
//                }
//                return true;
//            }
//        }
//
//        for (int i = 0; i < nBuildingsPut; i++) {
//            if ((buildingsPut[i].getClassType() == Constants.BUILDINGANIMAL || buildingsPut[i]
//                    .getClassType() == Constants.BUILDINGNORMAL)
//                    && (touch[0][0] == buildingsPut[i].getPosX()
//                            && touch[0][1] == buildingsPut[i].getPosY() || (buildingsPut[i]
//                            .isFourSpace() && (buildingsPut[i].getPosX_1() == touch[0][0]
//                            && buildingsPut[i].getPosY_1() == touch[0][1]
//                            || buildingsPut[i].getPosX_2() == touch[0][0]
//                            && buildingsPut[i].getPosY_2() == touch[0][1] || buildingsPut[i]
//                            .getPosX_3() == touch[0][0]
//                            && buildingsPut[i].getPosY_3() == touch[0][1])))) {
//                if (/* buildingsPut[i].isReady() && */buildingsPut[i]
//                        .isMenuRotate()) {
//                    buildingsPut[i].setMenuRotate(false);
//                    // buildingsPut[i].setMoveFree(true);
//                }
//
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean doMove(MotionEvent event) {
//        boolean retorno = true;
//        pressHold = false;
//        animationHold = 1;
//        synchronized (mSurfaceHolder) {
//            switch (stateGame) {
//            case Constants.STATE_MAIN_GAME:
//                doMove = moveMainGame(event);
//                if(doMove){
//                	return false;
//                }
//                break;
//            case Constants.STATE_MARKET_CROPS:
//                if (tutorialGame) {
//                    return false;
//                }
//                if ((event.getX() > posPressX + 6.1
//                        || event.getX() < posPressX - 6.1
//                        || event.getY() > posPressY + 6.1 || event.getY() < posPressY - 6.1)) {
//                    moveMarketCrops(event, Constants.cropsImage.length);
//                    canBeDragged = false;
//                }
//                break;
//            case Constants.STATE_MARKET_ANIMALS:
//                if (tutorialGame) {
//                    return false;
//                }
//                if ((event.getX() > posPressX + 6.1
//                        || event.getX() < posPressX - 6.1
//                        || event.getY() > posPressY + 6.1 || event.getY() < posPressY - 6.1)) {
//                    moveMarketCrops(event, Constants.SIZE_ANIMALS);
//                    canBeDragged = false;
//                }
//                break;
//            case Constants.STATE_MARKET_BUILDING:
//                if (tutorialGame) {
//                    return false;
//                }
//                if ((event.getX() > posPressX + 6.1
//                        || event.getX() < posPressX - 6.1
//                        || event.getY() > posPressY + 6.1 || event.getY() < posPressY - 6.1)) {
//                    moveMarketCrops(event, Constants.BUILDING_TYPE_ORD.length);
//                    canBeDragged = false;
//                }
//                break;
//            case Constants.STATE_MARKET_DECO:
//                if ((event.getX() > posPressX + 6.1
//                        || event.getX() < posPressX - 6.1
//                        || event.getY() > posPressY + 6.1 || event.getY() < posPressY - 6.1)) {
//                    moveMarketCrops(event, Constants.decorationsImage.length);
//                    canBeDragged = false;
//                }
//                break;
//            case Constants.STATE_ACHIEVEMENTS:
//            case Constants.STATE_COLLECTIONS:
//                if ((event.getX() > posPressX + 6.1
//                        || event.getX() < posPressX - 6.1
//                        || event.getY() > posPressY + 6.1 || event.getY() < posPressY - 6.1)) {
//                    moveMarketCollections(event, 7);
//                    canBeDragged = false;
//                }
//                break;
//            }
//        }
//        return retorno;
//    }
//
//    private void moveMarketCollections(MotionEvent event, int finMaxObjects) {
//        if (posPressX > event.getX()
//                && event.getY() > (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2) + Pos_Init_Market_Y
//                && event.getY() < (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2)
//                        + Pos_Init_Market_Y
//                        + backgroundItemShop.getHeight()) {
//
//            scrollingLeft = true;
//
//        } else if (posPressX < event.getX()
//                && event.getY() > (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2) + Pos_Init_Market_Y
//                && event.getY() < (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2)
//                        + Pos_Init_Market_Y
//                        + backgroundItemShop.getHeight()) {
//
//            scrollingLeft = false;
//
//        }
//    }
//
//    private void moveMarketCrops(MotionEvent event, int finMaxObjects) {
//        if (posPressX > event.getX()
//                && event.getY() > (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2) + Pos_Init_Market_Y
//                && event.getY() < (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2)
//                        + Pos_Init_Market_Y
//                        + backgroundItemShop.getHeight()) {
//
//            if (startObjects + 1 < finMaxObjects - 3) {
//                moveShop_X -= 4;
//                if (moveShop_X <= -(backgroundItemShop.getWidth() + 2)) {
//                    moveShop_X = 0;
//                    startObjects += 1;
//                    endObjects += 1;
//                }
//            }
//
//        } else if (posPressX < event.getX()
//                && event.getY() > (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2) + Pos_Init_Market_Y
//                && event.getY() < (mCanvasHeight / 2 - backgroundGeneral
//                        .getHeight() / 2)
//                        + Pos_Init_Market_Y
//                        + backgroundItemShop.getHeight()) {
//
//            if (startObjects - 1 >= -1) {
//                moveShop_X += 4;
//                if (moveShop_X >= (backgroundItemShop.getWidth() + 2)) {
//                    moveShop_X = 0;
//                    startObjects -= 1;
//                    endObjects -= 1;
//                }
//            }
//
//        }
//    }
//
//    private boolean zoomActive() {
//        if (GameCanvas.mScaleDetector.isInProgress()) {
//            Log.d(TAG, "mScaleDetector.isInProgress() ");
//            doMove = true;
//
//            World.mScaleFactor *= scaleFactor;
//
//            World.mScaleFactor = Math.max(0.7f,
//                    Math.min(World.mScaleFactor, 1.3f));
//
//            if (World.mScaleFactor > 1.3f)
//                World.mScaleFactor = 1.3f;
//            if (World.mScaleFactor < 0.7f)
//                World.mScaleFactor = 0.7f;
//
//            int[][] posRefe = tiledChosenInMap(null, null, null);
//            int[] pos = calculatePosInitialMap(posRefe[0][0], posRefe[0][1]);
//
//            World.tamTiledX = (int) (160 * World.mScaleFactor);
//            World.tamTiledY = (int) (80 * World.mScaleFactor);
//
//            positionWorldInZoom(posRefe[0][0], posRefe[0][1], pos);
//
//            return true;
//        }
//        return false;
//    }
//
//    private boolean touchOutMap(int posX, int posY, MotionEvent event,
//            int direccion) {
//    	if (stateOnlyGreen) {
//            return false;
//        }
//
//        int[][] touch = tiledChosenInMap(null, posX, posY);
//
//        int limit = -1;
//        switch (direccion) {
//        case 0:
//            if (touch[0][0] <= MAT_INF_X + limit
//                    || touch[0][1] <= MAT_INF_Y + limit) {
//                return true;
//            }
//            break;
//        case 1:
//            if (touch[0][0] <= MAT_INF_X + limit || touch[0][1] > MAT_SUP_Y + 0) {
//                return true;
//            }
//            break;
//        case 2:
//            if (touch[0][0] > MAT_SUP_X + 0 || touch[0][1] <= MAT_INF_Y + limit) {
//                return true;
//            }
//            break;
//        case 3:
//            if (touch[0][0] > MAT_SUP_X + 0 || touch[0][1] > MAT_SUP_Y + 0) {
//                return true;
//            }
//            break;
//        }
//
//        return false;
//    }
//
//    /*
//     * private boolean activeMoveFree(){
//     * 
//     * for(int i = 0; i < nBuildingsPut; i++){ if(buildingsPut[i].isMenuRotate()
//     * || buildingsPut[i].isMoveFree()){ return true; } }
//     * 
//     * for(int i = 0; i < nDecorationsPut; i++){
//     * if(decorationsPut[i].isMenuRotate() || decorationsPut[i].isMoveFree()){
//     * return true; } } for(int i = 0; i < NTree; i++){
//     * if(tree[i].isMenuRotate() || tree[i].isMoveFree()){ return true; } }
//     * 
//     * return false; }
//     */
//
//    private boolean moveMainGame(MotionEvent event) {
//        boolean retorno = false;
//
//        /*
//         * int[][] touch = tiledChoosedInMap(event,null,null);
//         * if(touchInAnyObject(event, touch) || activeMoveFree()){ boolean
//         * isMove = false; isMove = (World.Pos_Move_Free_X == -1) ? false: true;
//         * World.Pos_Move_Free_X = event.getX(); World.Pos_Move_Free_Y =
//         * event.getY(); if(isMove){ return false; }//false; }
//         */
//
//        if (zoomActive()) {
//            return true;
//        }
//        if((event.getX() > posPressX+6.1 || event.getX() < posPressX-6.1 
//				|| event.getY() > posPressY+6.1 || event.getY() < posPressY-6.1) ){
//        	
//        
//
//        if ((int) event.getX() > (int) posPressX
//                && (int) event.getY() > (int) posPressY) {
//
//            // if thereisMovement
//            if (touchOutMap((int) posPressX, (int) posPressY, event, 0)) {
//                return true;
//            }
//
//            World.posWorldX += (event.getX() - posPressX);
//            World.posWorldY += (event.getY() - posPressY);
//            posPressX = event.getX();
//            posPressY = event.getY();
//            retorno = true;
//        } else if ((int) event.getX() > (int) posPressX
//                && (int) event.getY() <= (int) posPressY) {
//            /*
//             * if(Constants.Pos_World_X + (event.getX() - Pos_Press_X) +
//             * tamWorld_X > mCanvasWidth || Constants.Pos_World_Y - (Pos_Press_Y
//             * - event.getY()) + tamWorld_Y < 0){ return true; }
//             */
//            // if thereisMovement
//            if (touchOutMap((int) posPressX, (int) posPressY, event, 1)) {
//                return true;
//            }
//
//            World.posWorldX += (event.getX() - posPressX);
//            World.posWorldY -= (posPressY - event.getY());
//            posPressX = event.getX();
//            posPressY = event.getY();
//            retorno = true;
//        } else if ((int) event.getX() < (int) posPressX
//                && (int) event.getY() > (int) posPressY) {
//            /*
//             * if(Constants.Pos_World_X - (Pos_Press_X - event.getX()) +
//             * tamWorld_X < 0 || Constants.Pos_World_Y + (event.getY() -
//             * Pos_Press_Y) + tamWorld_Y > mCanvasHeight){ return true; }
//             */
//            // if thereisMovement
//            if (touchOutMap((int) posPressX, (int) posPressY, event, 2)) {
//                return true;
//            }
//            World.posWorldX -= (posPressX - event.getX());
//            World.posWorldY += (event.getY() - posPressY);
//            posPressX = event.getX();
//            posPressY = event.getY();
//            retorno = true;
//        } else if ((int) event.getX() < (int) posPressX
//                && (int) event.getY() <= (int) posPressY) {
//
//            /*
//             * if(Constants.Pos_World_X - (event.getX() - Pos_Press_X) -
//             * tamWorld_X < 0 || Constants.Pos_World_Y - (event.getY() -
//             * Pos_Press_Y) - tamWorld_Y < 0){ return true; }
//             */
//            // if thereisMovement
//            if (touchOutMap((int) posPressX, (int) posPressY, event, 3)) {
//                return true;
//            }
//            World.posWorldX -= (posPressX - event.getX());
//            World.posWorldY -= (posPressY - event.getY());
//            posPressX = event.getX();
//            posPressY = event.getY();
//            retorno = true;
//        }
//        }
//        return retorno;
//    }
//
//    private boolean manageTutorialTouches(MotionEvent event) {
//
//        boolean touchOK = false;
//
//        // Enable the close button every time the user levels up
//        if (stateGame == Constants.STATE_LEVEL_UP) {
//            int posX = ((mCanvasWidth / 2) + mCanvasWidth / 4)
//                    - buttonBuildInactive.getWidth() / 2;
//            int posY = posButtonLevelUp_Y;
//
//            if (buttonClose.touch(event)
//                    || thereIsTouch(event, posX,
//                            posX + buttonBuildInactive.getWidth(), posY, posY
//                                    + buttonBuildInactive.getHeight())) {
//                touchOK = true;
//            }
//        }
//
//        Log.d(TAG, "manageTutorialTouches -> stepTutorial: " + stepTutorial
//                + ", stepGame: " + stateGame);
//
//        int valueToValidate = -1;
//        int totalPlow = 6;
//        switch (stepTutorial) {
//
//        case Constants.STEP_TUTORIAL_HELLO_FARMER:
//            FlurryAgent.logEvent("STEP_TUTORIAL_HELLO_FARMER = 1");
//           
//            break;
//        case Constants.STEP_TUTORIAL_PLOW_FIELDS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_PLOW_FIELDS = 2");
//            valueToValidate = 0;
//            break;
//        case Constants.STEP_TUTORIAL_PLOW_MORE_FIELDS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_PLOW_MORE_FIELDS  = 3");
//            valueToValidate = 0;
//            break;
//        case Constants.STEP_TUTORIAL_SELECT_CROPS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_SELECT_CROPS = 4");
//            valueToValidate = 1;
//            break;
//        case Constants.STEP_TUTORIAL_HARVEST:
//            FlurryAgent.logEvent("STEP_TUTORIAL_HARVEST = 6");
//            valueToValidate = 2;
//            break;
//        case Constants.STEP_TUTORIAL_MORE_WHEAT:
//            FlurryAgent.logEvent("STEP_TUTORIAL_MORE_WHEAT = 7");
//            totalPlow = 4;
//            if (stepInAuxTutorial == 2) {
//                valueToValidate = 3;
//            } else if (stepInAuxTutorial == 3) {
//                valueToValidate = 1;
//            } else if (stepInAuxTutorial == 5) {
//                valueToValidate = 2;
//            } else if (stepInAuxTutorial == 7) {
//                valueToValidate = 2;
//            } else {
//                if (canShowInfoAuto && !storageFull) {
//                    int posBackgAutomatic_Y = mCanvasHeight
//                            - backgAutomatic.getHeight() - 30;
//                    int posBackgAutomatic_X = mCanvasWidth / 2
//                            - backgAutomatic.getWidth() / 2;
//
//                    if (checkedAutomatic.touch(event)) {
//                        touchOK = true;
//                    }
//
//                    if (thereIsTouch(event, posBackgAutomatic_X,
//                            posBackgAutomatic_X + backgAutomatic.getWidth(),
//                            posBackgAutomatic_Y, posBackgAutomatic_Y
//                                    + backgAutomatic.getHeight())) {
//                        touchOK = true;
//                    }
//                }
//            }
//            break;
//        case Constants.STEP_TUTORIAL_BOOST_YOUR_WHEAT:
//            FlurryAgent.logEvent("STEP_TUTORIAL_BOOST_YOUR_WHEAT  = 5");
//
//            if (stepInAuxTutorial == 2) {
//                if (canShowInfoAuto && !storageFull) {
//                    int posBackgAutomatic_Y = mCanvasHeight
//                            - backgAutomatic.getHeight() - 30;
//                    int posBackgAutomatic_X = mCanvasWidth / 2
//                            - backgAutomatic.getWidth() / 2;
//
//                    if (checkedAutomatic.touch(event)) {
//                        touchOK = true;
//                    }
//
//                    if (thereIsTouch(event, posBackgAutomatic_X,
//                            posBackgAutomatic_X + backgAutomatic.getWidth(),
//                            posBackgAutomatic_Y, posBackgAutomatic_Y
//                                    + backgAutomatic.getHeight())) {
//                        touchOK = true;
//                    }
//                }
//            }
//
//            if (stepInAuxTutorial == 0 || stepInAuxTutorial == 1) {
//                int[] posit = calculatePosInitialMap(posTiledTutorial[0][0],
//                        posTiledTutorial[0][1]);
//
//                if (touchCorrectInTiled(posit[0] + World.posWorldX, posit[1]
//                        + World.posWorldY, event.getX(), event.getY())) {
//                    touchOK = true;
//                    stepInAuxTutorial++;
//                }
//            }
//
//            break;
//        case Constants.STEP_TUTORIAL_STORAGE:
//            FlurryAgent.logEvent("STEP_TUTORIAL_STORAGE = 8");
//            int[][] posibleTouch = { { 21, 13 }, { 22, 13 }, { 21, 14 },
//                    { 22, 14 },
//
//            };
//            for (int i = 0; i < 4; i++) {
//                int[] posit = calculatePosInitialMap(posibleTouch[i][0],
//                        posibleTouch[i][1]);
//                if (touchCorrectInTiled(posit[0] + World.posWorldX, posit[1]
//                        + World.posWorldY, event.getX(), event.getY())) {
//                    touchOK = true;
//                }
//            }
//            break;
//        case Constants.STEP_TUTORIAL_SELECT_WHEAT_TO_BE_SOLD:
//            FlurryAgent.logEvent("STEP_TUTORIAL_SELECT_WHEAT_TO_BE_SOLD = 9");
//            if (stateGame == Constants.STATE_STORAGE) {
//                int posItem_Y = initPosStorage_Y;
//                int posItem_X = 10 + buttonArrow.getPosX()
//                        + buttonArrow.getImage().getWidth();
//
//                if (selectAll.touch(event)) {
//                    touchOK = true;
//                }
//
//                if (tutorialGame) {
//                    if (stepInAuxTutorial == 0) {
//                        if (thereIsTouch(event, posItem_X, posItem_X
//                                + taskItemBackg.getWidth(), posItem_Y,
//                                posItem_Y + taskItemBackg.getHeight())) {
//                            touchOK = true;
//                        }
//                    }
//
//                    if (stepInAuxTutorial == 2) {
//                        if (buttonAddProduct.touch(event)) {
//                            touchOK = true;
//                        }
//                    }
//                }
//            }
//            break;
//
//        case Constants.STEP_TUTORIAL_FIRST_MONEY:
//            FlurryAgent.logEvent("STEP_TUTORIAL_FIRST_MONEY = 10");
//            if (tutorialGame
//                    && ((stepInAuxTutorial == 3 && stepTutorial == Constants.STEP_TUTORIAL_FIRST_MONEY) || (stepTutorial == Constants.STEP_TUTORIAL_COLLECT_YOUR_REWARD && stepInAuxTutorial == 9))) {
//                if (buttonClose.touch(event)) {
//                    touchOK = true;
//                }
//            }
//
//            break;
//        case Constants.STEP_TUTORIAL_ORDER_FROM_OTHERS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_ORDER_FROM_OTHERS = 11");
//            if (iconMission.touch(event)) {
//                touchOK = true;
//            }
//
//            break;
//        case Constants.STEP_TUTORIAL_YOUR_FIRST_TASK:
//            FlurryAgent.logEvent("STEP_TUTORIAL_YOUR_FIRST_TASK = 12");
//            if (tutorialGame && stepInAuxTutorial == 4) {
//                if (buttonClose.touch(event)) {
//                    touchOK = true;
//                    preparateMoving(23, 13);
//                }
//            }
//            break;
//        case Constants.STEP_TUTORIAL_WIND_MILL_AND_FLOUR:
//            FlurryAgent.logEvent("STEP_TUTORIAL_YOUR_FIRST_TASK = 13");
//            int[] posit2 = calculatePosInitialMap(23, 13);
//            if (touchCorrectInTiled(posit2[0] + World.posWorldX, posit2[1]
//                    + World.posWorldY, event.getX(), event.getY())) {
//                touchOK = true;
//            }
//            break;
//
//        case Constants.STEP_TUTORIAL_ENTER_PRODUCTION_VIEW:
//            FlurryAgent.logEvent("STEP_TUTORIAL_ENTER_PRODUCTION_VIEW = 14");
//            if (tutorialGame) {
//                int diff = 10;
//                int posX = mCanvasWidth / 2
//                        - ((productItemBackground.getWidth() + diff) * 4) / 2;
//                int posY = posButBackgProduce_Y;
//
//                if (thereIsTouch(event, posX,
//                        posX + productItemBackground.getWidth(), posY, posY
//                                + productItemBackground.getHeight())) {
//                    touchOK = true;
//                }
//            }
//            break;
//        case Constants.STEP_TUTORIAL_PRESS_PRODUCE:
//            FlurryAgent.logEvent("STEP_TUTORIAL_PRESS_PRODUCE = 15");
//            if (tutorialGame
//                    && (stepInAuxTutorial == 5 || stepInAuxTutorial == 6)) {
//
//                int diff = symbolPlus.getWidth() + 8;
//                int posX = mCanvasWidth / 2
//                        - ((productItemBackground.getWidth() + diff) * 3) / 2;
//                int posY = posButBackgProduce_Y;
//
//                buttonAddProduct.setPosX(posX
//                        + productItemBackground.getWidth() / 2
//                        - buttonAddProduct.getImage().getWidth() / 2);
//                buttonAddProduct.setPosY(posY
//                        + productItemBackground.getHeight()
//                        - buttonAddProduct.getImage().getHeight());
//
//                if (buttonAddProduct.touch(event)) {
//                    touchOK = true;
//                }
//
//            }
//
//            if (tutorialGame && stepInAuxTutorial == 7) {
//                if (buttonProduce.touch(event)) {
//                    touchOK = true;
//                }
//            }
//
//            if (stateGame == Constants.STATE_PRODUCTION) {
//
//                int diff = 15;
//                int posX = mCanvasWidth / 2
//                        - ((productItemBackgroundSmall.getWidth() + diff) * 5)
//                        / 2;
//                int posY = posSlotProduce_Y;
//
//                int posLess_X = posX + productItemBackgroundSmall.getWidth() / 2 - buttonCollect.getWidth() / 2;
//                int posBig_X = posLess_X + buttonCollect.getWidth();
//                int posLess_Y =  posY  + productItemBackgroundSmall.getHeight() - buttonCollect.getHeight();
//                int posBig_Y = posLess_Y + buttonCollect.getHeight();
//                
//                if (buildingsPut[buildingChosen].getSlot()[0] == 3) {// Done
//                    if (thereIsTouch(event,posLess_X,posBig_X,posLess_Y,posBig_Y)) {
//
//                        if (tutorialGame) {
//                            touchOK = true;
//
//                        }
//
//                    }
//                    /*
//                     *     canvas.drawBitmap(buttonCollect, posX
//                        + productItemBackgroundSmall.getWidth() / 2
//                        - buttonCollect.getWidth() / 2, posY
//                        + productItemBackgroundSmall.getHeight()
//                        - buttonCollect.getHeight() / 2, null);
//                     */
//                } else if (buildingsPut[buildingChosen].getSlot()[0] == 2) { // Producing
//                    if (buildingsPut[buildingChosen].getCurrentSlotActive() == 0) {
//                    	 if (thereIsTouch(event,posLess_X,posBig_X,posLess_Y,posBig_Y)) {
//
//
//                            if (tutorialGame) {
//                                touchOK = true;
//                            }
//                        }
//                    }
//                }
//
//            }
//            break;
//        case Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED:
//            /*FlurryAgent.logEvent("STEP_TUTORIAL_FIRST_TASK_COMPLETED = 16");
//            if (buttonClose.touch(event) || iconMission.touch(event)) {
//                touchOK = true;
//            }*/
//        	 if (stateGame == Constants.STATE_MISSION) {
//                 int posXLess = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                         - buttonCashIn.getWidth() - buttonCashIn_X;
//                 int posYLess = mCanvasHeight - buttonCashIn.getHeight()
//                         - buttonCashIn_Y;
//                 int posXBig = posXLess + buttonCashIn.getWidth();
//                 int posYBig = posYLess + buttonCashIn.getHeight();
//                 if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//                     touchOK = true;
//                 }
//
//             }
//            break;
//
//        case Constants.STEP_TUTORIAL_COLLECT_YOUR_REWARD:
//            FlurryAgent.logEvent("STEP_TUTORIAL_COLLECT_YOUR_REWARD = 17");
//            if (stateGame == Constants.STATE_MISSION) {
//                int posXLess = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                        - buttonCashIn.getWidth() - buttonCashIn_X;
//                int posYLess = mCanvasHeight - buttonCashIn.getHeight()
//                        - buttonCashIn_Y;
//                int posXBig = posXLess + buttonCashIn.getWidth();
//                int posYBig = posYLess + buttonCashIn.getHeight();
//                if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//                    touchOK = true;
//                }
//
//            }
//            break;
//        case Constants.STEP_TUTORIAL_BECOMING_KNOWN:
//            FlurryAgent.logEvent("STEP_TUTORIAL_BECOMING_KNOWN = 18");
//            int backgTaskBig_X = (mCanvasWidth / 2 + backgroundGeneral
//                    .getWidth() / 2) - backgTask.getWidth() - restTaskBig_X;
//
//            if (!canRewardMission[missionChosen]
//                    && thereIsTouch(
//                            event,
//                            backgTaskBig_X + backgTask.getWidth() / 2
//                                    - buttonProduce.getImage().getWidth() / 2,
//                            backgTaskBig_X + backgTask.getWidth() / 2
//                                    + buttonProduce.getImage().getWidth() / 2,
//                            posBackgTask_Y
//                                    + backgTask.getHeight()
//                                    - (buttonProduce.getImage().getHeight() / 4)
//                                    * 3,
//                            posBackgTask_Y
//                                    + backgTask.getHeight()
//                                    - (buttonProduce.getImage().getHeight() / 4)
//                                    * 3 + buttonProduceInactive.getHeight())) {
//
//                touchOK = true;
//            }
//
//            if (stateGame == Constants.STATE_MISSION) {
//                int posXLess = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                        - buttonCashIn.getWidth() - buttonCashIn_X;
//                int posYLess = mCanvasHeight - buttonCashIn.getHeight()
//                        - buttonCashIn_Y;
//                int posXBig = posXLess + buttonCashIn.getWidth();
//                int posYBig = posYLess + buttonCashIn.getHeight();
//                if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//                    touchOK = true;
//                }
//
//            }
//
//            break;
//        case Constants.STEP_TUTORIAL_FARM_FRIENDS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_FARM_FRIENDS = 19");
//
//            /*int posCharacter_Y = characterOffsetY;
//            if (thereIsTouch(event, 0, iconCharacter[0].getWidth(),
//                    posCharacter_Y,
//                    posCharacter_Y + iconCharacter[0].getHeight())) {
//                touchOK = true;
//            }*/
//            if (buttonClose.touch(event)) {
//                touchOK = true;
//                time_showIconTrucker = System.currentTimeMillis();
//            }
//            break;
//        case Constants.STEP_TUTORIAL_WELCOME_FINAL_TUTORIAL:
//            FlurryAgent.logEvent("STEP_TUTORIAL_MORE_REWARDING = 20");
//            /*if (buttonClose.touch(event)) {
//                touchOK = true;
//            }*/
//            break;
//        /*case Constants.STEP_TUTORIAL_FREE:
//            FlurryAgent.logEvent("STEP_TUTORIAL_FREE = 22");
//            touchOK = true;
//            break;
//        case Constants.STEP_TUTORIAL_ENTER_SHOP:
//
//            FlurryAgent.logEvent("STEP_TUTORIAL_ENTER_SHOP = 23");
//            if (openMenuExpress) {
//                for (int i = 0; i < 5; i++) {
//                    if (tutorialGame && i == 2) {
//                        if (iconsMenuExpress[i].touch(event)) {
//                            touchOK = true;
//                            break;
//                        }
//                    }
//                }
//            } else {
//                if (iconsMenuExpress[0].touch(event)) {
//                    touchOK = true;
//                }
//            }
//
//            if (stateGame == Constants.STATE_MAIN_MARKET) {
//
//                int item_X = mCanvasWidth
//                        / 2
//                        - ((backgroundItemMarket.getWidth() + spaceBetItem_X) * 3)
//                        / 2;
//                int item_Y = spaceBetBorderBackgrSuper;
//                for (int i = 0; i < 6; i++) {
//                    if (thereIsTouch(event, item_X, item_X
//                            + backgroundItemMarket.getWidth(), item_Y, item_Y
//                            + backgroundItemMarket.getHeight())) {
//                        if (i == 4) {
//                            touchOK = true;
//                        }
//                    }
//
//                    item_X += backgroundItemMarket.getWidth() + spaceBetItem_X;
//                    if (i == 2) {
//                        item_X = mCanvasWidth
//                                / 2
//                                - ((backgroundItemMarket.getWidth() + spaceBetItem_X) * 3)
//                                / 2;
//                        item_Y += backgroundItemMarket.getHeight()
//                                + spaceBetItem_Y;
//                    }
//
//                }
//
//            }
//
//            break;
//        case Constants.STEP_TUTORIAL_BUILDINGS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_BUILDINGS = 24");
//            int posBackgItemShop_X = mCanvasWidth
//                    / 2
//                    - ((backgroundItemShop.getWidth() + diffItemGeneralShop) * 3)
//                    / 2 - backgroundItemShop.getWidth() + diffItemGeneralShop;
//            int posBackgItemShop_Y = Pos_Init_Market_Y;
//
//            for (int i = startObjects; i < 1; i++) {
//                if (i >= 0) {
//                    if (thereIsTouch(event, posBackgItemShop_X,
//                            posBackgItemShop_X + backgroundItemShop.getWidth(),
//                            posBackgItemShop_Y, posBackgItemShop_Y
//                                    + backgroundItemShop.getHeight())) {
//                        touchOK = true;
//                    }
//                }
//                posBackgItemShop_X += backgroundItemShop.getWidth()
//                        + diffItemGeneralShop;
//            }
//
//            break;
//        case Constants.STEP_TUTORIAL_PLACE_ON_YARD:
//            FlurryAgent.logEvent("STEP_TUTORIAL_PLACE_ON_YARD = 25");
//            touchOK = true;
//            break;
//
//        case Constants.STEP_TUTORIAL_BOOST_CONSTRUCTION:
//        case Constants.STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING:
//        case Constants.STEP_TUTORIAL_ADD_ANIMAL:
//        case Constants.STEP_TUTORIAL_CROPS_BECOME_FOOD:
//        case Constants.STEP_TUTORIAL_FEED_ANIMALS:
//        case Constants.STEP_TUTORIAL_FIRST_EGG:
//
//            if (stepTutorial == Constants.STEP_TUTORIAL_BOOST_CONSTRUCTION) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_BOOST_CONSTRUCTION = 26");
//            }
//            if (stepTutorial == Constants.STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING) {
//                FlurryAgent
//                        .logEvent("STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING = 27");
//            }
//            if (stepTutorial == Constants.STEP_TUTORIAL_ADD_ANIMAL) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_ADD_ANIMAL = 28");
//            }
//            if (stepTutorial == Constants.STEP_TUTORIAL_CROPS_BECOME_FOOD) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_CROPS_BECOME_FOOD = 31");
//            }
//            if (stepTutorial == Constants.STEP_TUTORIAL_FEED_ANIMALS) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_FEED_ANIMALS = 29");
//            }
//            if (stepTutorial == Constants.STEP_TUTORIAL_FIRST_EGG) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_FIRST_EGG = 33");
//            }
//
//            if (stateGame == Constants.STATE_QUEST_BOOST) {
//                if (buttonAddProduct.touch(event)) {
//                    touchOK = true;
//                }
//            }
//
//            for (int i = 0; i < nBuildingsPut; i++) {
//                if (buildingsPut[i].getClassType() == Constants.BUILDINGANIMAL) {
//
//                    if (stepTutorial == Constants.STEP_TUTORIAL_ENTER_SHOP
//                            || stepTutorial == Constants.STEP_TUTORIAL_BUILDINGS
//                            || stepTutorial == Constants.STEP_TUTORIAL_BOOST_CONSTRUCTION
//                            || stepTutorial == Constants.STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING) {
//                        int[][] posibleTouch2 = {
//                                { buildingsPut[i].getPosX(),
//                                        buildingsPut[i].getPosY() },
//                                { buildingsPut[i].getPosX() + 1,
//                                        buildingsPut[i].getPosY() },
//                                { buildingsPut[i].getPosX(),
//                                        buildingsPut[i].getPosY() + 1 },
//                                { buildingsPut[i].getPosX() + 1,
//                                        buildingsPut[i].getPosY() + 1 },
//
//                        };
//                        for (int a = 0; a < 4; a++) {
//                            int[] posit1 = calculatePosInitialMap(
//                                    posibleTouch2[a][0], posibleTouch2[a][1]);
//
//                            if (touchCorrectInTiled(
//                                    posit1[0] + World.posWorldX, posit1[1]
//                                            + World.posWorldY, event.getX(),
//                                    event.getY())) {
//                                touchOK = true;
//                            }
//                        }
//                    } else {
//                        int[] posit1 = calculatePosInitialMap(
//                                buildingsPut[i].getPosX(),
//                                buildingsPut[i].getPosY());
//                        if (touchCorrectInTiled(posit1[0] + World.posWorldX,
//                                posit1[1] + World.posWorldY, event.getX(),
//                                event.getY())) {
//                            touchOK = true;
//                        }
//                    }
//                }
//            }
//
//            for (int i = 0; i < nBuildingsPut; i++) {
//                if (buildingChosen != -1 && buildingChosen == i
//                        && buildingsPut[i].isShowTimeUnderConstruction()) {
//                    int[] position = calculatePosInitialMap(
//                            buildingsPut[i].getPosX(),
//                            buildingsPut[i].getPosY());
//                    int posX = position[0] + World.posWorldX + World.tamTiledX
//                            / 2 - buttonBoost.getWidth() / 2;
//                    int posY = position[1] + World.posWorldY + World.tamTiledY;
//                    if (buildingsPut[i].getTimeUnderConstruct() == 0) {
//
//                    } else if (thereIsTouch(event, posX,
//                            posX + buttonBoost.getWidth(), posY, posY
//                                    + buttonBoost.getHeight())) {
//
//                        touchOK = true;
//                    }
//                }
//            }
//
//            if (stateGame == Constants.STATE_FEED_MILL) {
//
//                if (tutorialGame && stepInAuxTutorial == 3) {
//                    if (buttonClose.touch(event)) {
//                        touchOK = true;
//                    }
//                }
//
//                int posItem_X = 10 + buttonArrow.getPosX()
//                        + buttonArrow.getImage().getWidth();
//                int posItem_Y = initPosStorage_Y;
//
//                if (selectAll.touch(event)) {
//                    touchOK = true;
//                }
//
//                if (thereIsTouch(event, posItem_X,
//                        posItem_X + taskItemBackg.getWidth(), posItem_Y,
//                        posItem_Y + taskItemBackg.getHeight())) {
//                    if (tutorialGame && stepInAuxTutorial == 0) {
//                        touchOK = true;
//                    }
//                    break;
//                }
//
//                if (buttonAddProduct.touch(event) && storageChosen != -1) {
//                    if (quantitySeeds + quantityFoodProduce <= totalQuantityFood) {
//
//                        if (tutorialGame && stepInAuxTutorial == 2) {
//                            touchOK = true;
//                        }
//                    }
//                }
//            }
//
//            if (stateGame == Constants.STATE_MARKET_ANIMALS) {
//
//                posBackgItemShop_X = mCanvasWidth
//                        / 2
//                        - ((backgroundItemShop.getWidth() + diffItemGeneralShop) * 3)
//                        / 2 - backgroundItemShop.getWidth()
//                        + diffItemGeneralShop;
//                posBackgItemShop_Y = Pos_Init_Market_Y;
//
//                for (int i = startObjects; i < 1; i++) {
//
//                    if (i >= 0) {
//                        if (thereIsTouch(
//                                event,
//                                posBackgItemShop_X,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth(),
//                                posBackgItemShop_Y, posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight())) {
//                            touchOK = true;
//                        }
//                    }
//                    posBackgItemShop_X += backgroundItemShop.getWidth()
//                            + diffItemGeneralShop;
//
//                }
//            }
//            // Force user to click the boost button
//            if (buttonAddProduct.touch(event)) {
//                touchOK = true;
//            }
//
//            break;
//
//        case Constants.STEP_TUTORIAL_PRODUCE_FOOD:
//            FlurryAgent.logEvent("STEP_TUTORIAL_PRODUCE_FOOD = 30");
//            if (stateGame == Constants.STATE_NOFOOD) {
//                int diff = productItemBackground.getWidth() + 20;
//                int posX = mCanvasWidth / 2 - (diff * 3) / 2;
//                int posY = posNoFood_Y;
//                for (int i = 0; i < 1; i++) {
//                    buttonAddProduct.setPosX(posX
//                            + productItemBackground.getWidth() / 2
//                            - buttonAddProduct.getImage().getWidth() / 2);
//                    buttonAddProduct.setPosY(posY
//                            + productItemBackground.getHeight()
//                            - buttonAddProduct.getImage().getHeight() / 2);
//                    if (buttonAddProduct.touch(event)) {
//                        if (i == 0) {
//                            touchOK = true;
//                            break;
//                        }
//                    }
//                }
//            }
//            break;
//
//        case Constants.STEP_TUTORIAL_WELL_DONE:
//        case Constants.STEP_TUTORIAL_MORE_EGG:
//
//            if (stepTutorial == Constants.STEP_TUTORIAL_WELL_DONE) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_WELL_DONE = 32");
//            }
//            if (stepTutorial == Constants.STEP_TUTORIAL_MORE_EGG) {
//                FlurryAgent.logEvent("STEP_TUTORIAL_MORE_EGG = 34");
//            }
//
//            for (int i = 0; i < nBuildingsPut; i++) {
//                if (buildingsPut[i].getClassType() == Constants.BUILDINGANIMAL) {
//
//                    int[] posit1 = calculatePosInitialMap(
//                            buildingsPut[i].getPosX() + 1,
//                            buildingsPut[i].getPosY());
//
//                    if (touchCorrectInTiled(posit1[0] + World.posWorldX,
//                            posit1[1] + World.posWorldY, event.getX(),
//                            event.getY())) {
//                        touchOK = true;
//                    }
//
//                }
//
//            }
//            if (stateGame == Constants.STATE_MARKET_ANIMALS) {
//
//                posBackgItemShop_X = mCanvasWidth
//                        / 2
//                        - ((backgroundItemShop.getWidth() + diffItemGeneralShop) * 3)
//                        / 2 - backgroundItemShop.getWidth()
//                        + diffItemGeneralShop;
//                posBackgItemShop_Y = Pos_Init_Market_Y;
//
//                for (int i = startObjects; i < 1; i++) {
//
//                    if (i >= 0) {
//                        if (thereIsTouch(
//                                event,
//                                posBackgItemShop_X,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth(),
//                                posBackgItemShop_Y, posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight())) {
//                            touchOK = true;
//                        }
//                    }
//                    posBackgItemShop_X += backgroundItemShop.getWidth()
//                            + diffItemGeneralShop;
//
//                }
//            }
//            break;
//
//        case Constants.STEP_TUTORIAL_TASKS_OWN:
//            FlurryAgent.logEvent("STEP_TUTORIAL_TASKS_OWN = 36");
//            if (buttonClose.touch(event)) {
//                touchOK = true;
//            }
//            break;
//        case Constants.STEP_TUTORIAL_CASH_IN_TIME:
//            FlurryAgent.logEvent("STEP_TUTORIAL_CASH_IN_TIME = 35");
//            if (iconMission.touch(event)) {
//                touchOK = true;
//            }
//
//            if (stateGame == Constants.STATE_MISSION) {
//                int posXLess = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                        - buttonCashIn.getWidth() - buttonCashIn_X;
//                int posYLess = mCanvasHeight - buttonCashIn.getHeight()
//                        - buttonCashIn_Y;
//                int posXBig = posXLess + buttonCashIn.getWidth();
//                int posYBig = posYLess + buttonCashIn.getHeight();
//                if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//                    touchOK = true;
//                }
//
//            }
//            break;
//
//        case Constants.STEP_TUTORIAL_EXPAND:
//            FlurryAgent.logEvent("STEP_TUTORIAL_EXPAND = 37");
//            int[][] possibleExpansion = { { 25, 13 }, { 26, 13 }, { 27, 13 },
//                    { 28, 13 }, { 25, 14 }, { 26, 14 }, { 27, 14 }, { 28, 14 },
//                    { 25, 15 }, { 26, 15 }, { 27, 15 }, { 28, 15 }, { 25, 16 },
//                    { 26, 16 }, { 27, 16 }, { 28, 16 }, };
//            for (int i = 0; i < 16; i++) {
//                int[] posit3 = calculatePosInitialMap(possibleExpansion[i][0],
//                        possibleExpansion[i][1]);
//                if (touchCorrectInTiled(posit3[0] + World.posWorldX, posit3[1]
//                        + World.posWorldY, event.getX(), event.getY())) {
//                    touchOK = true;
//                }
//            }
//            if (buttonBuild.touch(event)) {
//                touchOK = true;
//            }
//            break;
//        case Constants.STEP_TUTORIAL_CONGRATULATIONS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_CONGRATULATIONS = 38");
//            // Position farm house
//            int[] posit5 = calculatePosInitialMap(22, 18);
//            if (touchCorrectInTiled(posit5[0] + World.posWorldX, posit5[1]
//                    + World.posWorldY, event.getX(), event.getY())) {
//                touchOK = true;
//            }
//
//            if (stateGame == Constants.STATE_ACHIEVEMENTS) {
//
//                int diff_Y = backgAllCollections.getHeight() + 20;
//                int posX = mCanvasWidth / 2 - backgAllCollections.getWidth()
//                        / 2;
//                int posY = spaceBetBorderBackgrSuper;
//                int posCashIn_X = posX + backgAllCollections.getWidth()
//                        - buttonCashIn.getWidth() - 20;
//                int posCashIn_Y = posY + backgAllCollections.getHeight() / 2
//                        - buttonCashIn.getHeight() / 2;
//
//                posY += diff_Y;
//                posCashIn_Y = posY + backgAllCollections.getHeight() / 2
//                        - buttonCashIn.getHeight() / 2;
//                // Position reward
//                if (thereIsTouch(event, posCashIn_X,
//                        posCashIn_X + buttonCashIn.getWidth(), posCashIn_Y,
//                        posCashIn_Y + buttonCashIn.getHeight())) {
//                    stepInAuxTutorial += 1;
//                    touchOK = true;
//                    break;
//                }
//
//            }
//
//            if (buttonClose.touch(event) && stepInAuxTutorial == 1) {
//                touchOK = true;
//            }
//            break;
//
//        case Constants.STEP_TUTORIAL_GET_SPECIAL_TASKS:
//            FlurryAgent.logEvent("STEP_TUTORIAL_GET_SPECIAL_TASKS = 40");
//            int[] posit4 = calculatePosInitialMap(21, 20);
//            if (touchCorrectInTiled(posit4[0] + World.posWorldX, posit4[1]
//                    + World.posWorldY, event.getX(), event.getY())) {
//                touchOK = true;
//            }
//            if (buttonAccept != null && buttonAccept.touch(event)) {
//                touchOK = true;
//            }
//            break;
//        case Constants.STEP_TUTORIAL_YOU_MADE:
//            FlurryAgent.logEvent("STEP_TUTORIAL_YOU_MADE = 41");
//            if (buttonAccept.touch(event)) {
//                touchOK = true;
//            }
//            break;
//
//        }*/
//}
//
//        if (valueToValidate != -1) {
//            for (int i = 0; i < totalPlow; i++) {
//                if (posTiledTutorial[i][2] == valueToValidate) {
//                    int[] posit = calculatePosInitialMap(
//                            posTiledTutorial[i][0], posTiledTutorial[i][1]);
//
//                    if (touchCorrectInTiled(posit[0] + World.posWorldX,
//                            posit[1] + World.posWorldY, event.getX(),
//                            event.getY())) {
//                        touchOK = true;
//                    }
//                    break;
//                }
//            }
//        }
//
//        return touchOK;
//    }
//
//    public boolean doTouchUp(MotionEvent event) {
//        //
//        boolean retorno = true;
//        pressHold = false;
//        animationHold = 1;
//        if (doMove)
//            return false;
//        if (recentOpenMenuRotate) {
//            recentOpenMenuRotate = false;
//            return false;
//        }
//
//        if (tutorialGame
//                && (stateGame == Constants.STATE_MAIN_GAME
//                        || stateGame == Constants.STATE_STORAGE
//                        || stateGame == Constants.STATE_MISSION
//                        || stateGame == Constants.STATE_ACHIEVEMENTS
//                        || stateGame == Constants.STATE_LEVEL_UP
//                        || stateGame == Constants.STATE_FEED_MILL
//                        || stateGame == Constants.STATE_PRODUCTION
//                        || stateGame == Constants.STATE_CHARACTER_MISSION
//                        || stateGame == Constants.STATE_QUEST_BOOST
//                        || stateGame == Constants.STATE_QUEST_EXPANSION
//                        || stateGame == Constants.STATE_TRUCKQUEST
//                        || stateGame == Constants.STATE_MAIN_MARKET
//                        || stateGame == Constants.STATE_MARKET_BUILDING || stateGame == Constants.STATE_MARKET_ANIMALS)) {
//
//            if (!manageTutorialTouches(event)) {
//                return false;
//            }
//        }
//
//        synchronized (mSurfaceHolder) {
//            switch (stateGame) {
//            case Constants.STATE_MAIN_GAME:
//                touchUpMainGame(event);
//                break;
//            case Constants.STATE_MAIN_MARKET:
//                touchUpMainMarket(event);
//                break;
//            case Constants.STATE_COLLECTIONS:
//                touchUpCollections(event);
//                break;
//            case Constants.STATE_MARKET_DECO:
//                touchUpMarketCrops(event, Constants.PRESS_BUTTON_MARKET_DECO);
//                break;
//            case Constants.STATE_MARKET_CROPS:
//                touchUpMarketCrops(event, Constants.PRESS_BUTTON_MARKET_CROPS);
//                break;
//            case Constants.STATE_MARKET_BUILDING:
//                touchUpMarketCrops(event,
//                        Constants.PRESS_BUTTON_MARKET_BUILDINGS);
//                break;
//            case Constants.STATE_MARKET_ANIMALS:
//                touchUpMarketCrops(event, Constants.PRESS_BUTTON_MARKET_ANIMALS);
//                break;
//            case Constants.STATE_PRODUCTION:
//                touchUpStateProduced(event);
//                break;
//            case Constants.STATE_LEVEL_UP:
//                touchUpLevel(event);
//                break;
//            case Constants.STATE_STORAGE:
//                touchUpStateStorage(event);
//                break;
//            case Constants.STATE_MISSION:
//                touchUpStateMission(event);
//                break;
//            case Constants.STATE_FEED_MILL:
//                touchUpStateFeedMill(event);
//                break;
//            case Constants.STATE_QUEST_EXPANSION:
//                touchUpStateQuestExpansion(event);
//                break;
//            case Constants.STATE_NOFOOD:
//                touchUpStateNoFood(event);
//                break;
//            case Constants.STATE_UPGRADE_STORE:
//                touchUpStateUpdgradeStore(event);
//                break;
//            case Constants.STATE_UPGRADE_BUILDING:
//                touchUpStateUpgradeBuilding(event);
//                break;
//            case Constants.STATE_UPGRADE_ANIMAL:
//                touchUpStateUpdgradeAnimal(event);
//                break;
//            case Constants.STATE_UPGRADE_FEEDMILL:
//                touchUpStateUpgradeFeedMill(event);
//                break;
//            case Constants.STATE_QUEST_BOOST:
//                touchUpStateQuestBoost(event);
//                break;
//            case Constants.STATE_ACHIEVEMENTS:
//                touchUpStateAchievements(event);
//                break;
//            case Constants.STATE_FACEBOOK:
//                touchUpStateFacebook(event);
//                break;
//            case Constants.STATE_SHOW_INFO_PRODUCTS:
//                touchUpStateInfoProducts(event);
//                break;
//            case Constants.STATE_WIN_MATERIAL:
//                touchUpStateWinMaterial(event);
//                break;
//            case Constants.STATE_MORE_COINS:
//                touchUpStateMoreCoins(event);
//                break;
//            case Constants.STATE_MORE_DIAMONDS:
//                touchUpStateMoreDiamonds(event);
//                break;
//            case Constants.STATE_PROMOTION:
//                touchUpStatePromotion(event);
//                break;
//            case Constants.STATE_WIN_MASTERED:
//                touchUpStateWinMastered(event);
//                break;
//            case Constants.STATE_TRUCKQUEST:
//                touchUpStateTruckQuest(event);
//                break;
//            case Constants.STATE_INFO_TUTORIAL:
//                touchUpInfoTutorial(event);
//                break;
//            case Constants.STATE_INFO_TUTORIAL_FAKE:
//                touchUpInfoTutorialFake(event);
//                break;
//            case Constants.STATE_CHARACTER_MISSION:
//                touchUpStateCharacterMission(event);
//                break;
//            case Constants.STATE_POP_PLOW_FULL:
//                touchUpStatePopPlowFull(event);
//                break;
//            case Constants.STATE_POP_STORAGE_FULL:
//                touchUpStatePopStorageFull(event);
//                break;
//
//            }
//        }
//        if (closedButtonGeneral(event)) {
//            elementChosen = Constants.PRESS_BUTTON_CLOSE_GENERAL_BG;
//            timeElementChosen = System.currentTimeMillis();
//        }
//
//        return retorno;
//    }
//
//    private void touchUpStatePopPlowFull(MotionEvent event) {
//        if (buttonAddProduct.touch(event)) {
//            stateGame = Constants.STATE_QUEST_EXPANSION;
//            loadImages();
//            int nTiledAdd = 6;
//            boolean found = false;
//
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    if (mapExpansion[i][j] == 1) {
//                        if ((i - 1 > 0 && mapExpansion[i - 1][j] == 0)
//                                || (i + 1 < 5 && mapExpansion[i + 1][j] == 0)
//                                || (j + 1 < 5 && mapExpansion[i][j + 1] == 0)
//                                || (j - 1 > 0 && mapExpansion[i][j - 1] == 0)) {
//                            initExpand_X = (((int) j) * 4) + 3 + nTiledAdd;
//                            initExpand_Y = (((int) i) * 4) + 3 + nTiledAdd;
//                            found = true;
//                            break;
//                        }
//                    }
//                }
//                if (found) {
//                    break;
//                }
//            }
//        }
//
//    }
//
//    private void touchUpStatePopStorageFull(MotionEvent event) {
//        if (buttonAddProduct.touch(event)) {
//            if (buildingsPut[1].getUpdgrade() + 1 < 6) {
//                buildingChosen = 1;
//                stateGame = Constants.STATE_STORAGE;
//                loadImages();
//                stateGame = Constants.STATE_UPGRADE_STORE;
//
//            }
//        }
//    }
//
//    private void touchUpStateCharacterMission(MotionEvent event) {
//
//        int backgroundCharacter_Y = mCanvasHeight / 2
//                - backgroundCharacter.getHeight() / 2;
//
//        int posIcon_X = mCanvasWidth / 2 + missionCharacterIconX;
//        int posIcon_Y = backgroundCharacter_Y + missionCharacterIconY;
//
//        for (int i = 0; i < nTask[missionCharacter[indexCharacterChosen]]; i++) {
//            infoIcon.setPosX(posIcon_X - iconCrops[0].getWidth() / 2);
//            infoIcon.setPosY(posIcon_Y - iconCrops[0].getHeight() / 2);
//
//            if (infoIcon.touch(event)) {
//                backup_StateGame = stateGame;
//                stateGame = Constants.STATE_SHOW_INFO_PRODUCTS;
//                productShowInfo = convertToProductShowInfo(i,
//                        missionCharacter[indexCharacterChosen]);
//                return;
//
//            }
//
//            posIcon_X += (backgTask.getWidth() / 3);
//            if (i == 2) {
//                posIcon_X = mCanvasWidth / 2 + missionCharacterIconX;
//                posIcon_Y += backgTask.getHeight() / 3;
//            }
//        }
//
//        if (buttonProduce.touch(event)) {
//            missionChosen = missionCharacter[indexCharacterChosen];
//            if (!canRewardMission[missionCharacter[indexCharacterChosen]]) {
//                skipMission(event);
//
//            } else {
//                finalizeMission();
//
//                explosion = new Explosion(50, (int) event.getX(),
//                        (int) event.getY());
//                explosionActive = true;
//
//                UtilSoftgames.alphaImage = 0;
//                animationNewCharacter[indexCharacterChosen] = true;
//                Time_NewCharacter = System.currentTimeMillis();
//
//            }
//        }
//
//    }
//
//    private void touchUpStateMoreCoins(MotionEvent event) {
//        int diff_X = backgNoMoney.getWidth() + 10;
//        int diff_Y = backgNoMoney.getHeight() + 10;
//        int posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//        int posY = spaceBetBorderBackgrSuper;
//        for (int i = 0; i < 6; i++) {
//            if (thereIsTouch(event, posX, posX + backgNoMoney.getWidth(), posY,
//                    posY + backgNoMoney.getHeight())) {
//                switch (i) {
//                case 0:
//                    Constants.SKU_BUY = "hf3_coins1";
//                    break;
//                case 1:
//                    Constants.SKU_BUY = "hf3_coins2";
//                    break;
//                case 2:
//                    Constants.SKU_BUY = "hf3_coins3";
//                    break;
//                case 3:
//                    Constants.SKU_BUY = "hf3_coins4";
//                    break;
//                case 4:
//                    Constants.SKU_BUY = "hf3_coins5";
//                    break;
//                case 5:
//                    Constants.SKU_BUY = "hf3_coins6";
//                    break;
//                }
//                main.buyInGame();
//                break;
//            }
//
//            posX += diff_X;
//            if (i == 2) {
//                posY += diff_Y;
//                posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//            }
//        }
//
//        if (buttonArrowRigth.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_ARROWRIGHT;
//            timeElementChosen = System.currentTimeMillis();
//        }
//    }
//
//    public void payPurcharse() {
//        Log.d(TAG, "payPurcharse() " + Constants.SKU_BUY);
//        if (Constants.SKU_BUY.equals("hf3_coins1")) {
//            quantityCoins += Constants.HF3_COINS1_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_coins2")) {
//            quantityCoins += Constants.HF3_COINS3_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_coins3")) {
//            quantityCoins += Constants.HF3_COINS3_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_coins4")) {
//            quantityCoins += Constants.HF3_COINS4_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_coins5")) {
//            quantityCoins += Constants.HF3_COINS5_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_coins6")) {
//            quantityCoins += Constants.HF3_COINS6_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_diamonds1")) {
//            quantityDiamonds += Constants.HF3_DIAMONDS1_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_diamonds2")) {
//            quantityDiamonds += Constants.HF3_DIAMONDS2_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_diamonds3")) {
//            quantityDiamonds += Constants.HF3_DIAMONDS3_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_diamonds4")) {
//            quantityDiamonds += Constants.HF3_DIAMONDS4_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_diamonds5")) {
//            quantityDiamonds += Constants.HF3_DIAMONDS5_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_diamonds6")) {
//            quantityDiamonds += Constants.HF3_DIAMONDS6_AMOUNT;
//        } else if (Constants.SKU_BUY.equals("hf3_bonuspackage_40")) {
//            quantityDiamonds += Constants.HF3_BONUSPACKAGE_40_DIAMONDS;
//            quantityCoins += Constants.HF3_BONUSPACKAGE_40_COINS;
//        } else if (Constants.SKU_BUY.equals("hf3_bonuspackage_50")) {
//            quantityDiamonds += Constants.HF3_BONUSPACKAGE_50_DIAMONDS;
//            quantityCoins += Constants.HF3_BONUSPACKAGE_50_COINS;
//        } else if (Constants.SKU_BUY.equals("hf3_bonuspackage_60")) {
//            quantityDiamonds += Constants.HF3_BONUSPACKAGE_60_DIAMONDS;
//            quantityCoins += Constants.HF3_BONUSPACKAGE_60_COINS;
//        } else if (Constants.SKU_BUY.equals("hf3_bonuspackage_70")) {
//            quantityDiamonds += Constants.HF3_BONUSPACKAGE_70_DIAMONDS;
//            quantityCoins += Constants.HF3_BONUSPACKAGE_70_COINS;
//	} else if (Constants.SKU_BUY.equals("disable_all_ads")) {
//	    isNoAdsItemPurchased = true;
//	} else {
//            quantityDiamonds += Constants.HF3_PROMO_DIAMONDS;
//            quantityCoins += Constants.HF3_PROMO_COINS;
//        }
//        userPurchased = true;
//        runningBonus = false;
//    }
//
//    @SuppressWarnings("deprecation")
//    private void touchUpStateMoreDiamonds(MotionEvent event) {
//        int diff_X = backgNoMoney.getWidth() + 10;
//        int diff_Y = backgNoMoney.getHeight() + 10;
//        int posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//        int posY = spaceBetBorderBackgrSuper;
//        for (int i = 0; i < 6; i++) {
//            if (thereIsTouch(event, posX, posX + backgNoMoney.getWidth(), posY,
//                    posY + backgNoMoney.getHeight())) {
//                switch (i) {
//                case 0:
//                    Constants.SKU_BUY = "hf3_diamonds1";
//                    break;
//                case 1:
//                    Constants.SKU_BUY = "hf3_diamonds2";
//                    break;
//                case 2:
//                    Constants.SKU_BUY = "hf3_diamonds3";
//                    break;
//                case 3:
//                    Constants.SKU_BUY = "hf3_diamonds4";
//                    break;
//                case 4:
//                    Constants.SKU_BUY = "hf3_diamonds5";
//                    break;
//                case 5:
//                    Constants.SKU_BUY = "hf3_diamonds6";
//                    break;
//                }
//                main.buyInGame();
//                break;
//            }
//
//            posX += diff_X;
//            if (i == 2) {
//                posY += diff_Y;
//                posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//            }
//        }
//        if (buttonArrow.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_ARROWLEFT;
//            timeElementChosen = System.currentTimeMillis();
//
//        }
//        if (infoIcon.touch(event)) {
//            main.showDialog(MyLittleFarm2Activity.DIALOG_INFO);
//        }
//    }
//
//    private void touchUpStatePromotion(MotionEvent event) {
//        if (buttonBuild.touch(event)) {
//            switch (currentDiscount) {
//            case 40:
//                Constants.SKU_BUY = "hf3_bonuspackage_40";
//                break;
//            case 50:
//                Constants.SKU_BUY = "hf3_bonuspackage_50";
//                break;
//            case 60:
//                Constants.SKU_BUY = "hf3_bonuspackage_60";
//                break;
//            case 70:
//                Constants.SKU_BUY = "hf3_bonuspackage_70";
//                break;
//            }
//            main.buyInGame();
//            stateGame = Constants.STATE_MAIN_GAME;
//
//        }
//    }
//
//    private void touchUpStateTruckQuest(MotionEvent event) {
//        if (buttonDenie.touch(event)) {
//        	if(assignQuantity(0, 0, 0, 0, -10, 0, 0, mCanvasWidth/2, mCanvasHeight/2)){
//        		elementChosen = Constants.PRESS_BUTTON_DENY_QUEST;
//        		timeElementChosen = System.currentTimeMillis();
//        	} else {
//        		 stateGame = Constants.STATE_MORE_DIAMONDS;
//        	}
//        }
//
//        if (buttonAccept.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_ACCEPT_QUEST;
//            timeElementChosen = System.currentTimeMillis();
//
//        }
//
//    }
//
//    private void touchUpStateWinMastered(MotionEvent event) {
//        if (buttonBuild.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_CLOSE_GENERAL_BG;
//            timeElementChosen = System.currentTimeMillis();
//        }
//    }
//
//    private void touchUpStateWinMaterial(MotionEvent event) {
//        if (buttonBuild.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_CLOSE_GENERAL_BG;
//            timeElementChosen = System.currentTimeMillis();
//            UtilSoftgames.alphaImage = 0;
//            animationNewCharacter[indexCharacterChosen] = true;
//            Time_NewCharacter = System.currentTimeMillis();
//        }
//    }
//
//    // FIXME Facebook touchUpStateFacebook
//    private void touchUpStateFacebook(MotionEvent event) {
//
//        if (buttonAddHelper.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_ADDHELPER;
//            timeElementChosen = System.currentTimeMillis();
//        }
//
//        if (buttonInvite.touch(event)) {
//            Log.d(TAG, "touchUpStateFacebook() buttonInvite touched");
//            elementChosen = Constants.PRESS_BUTTON_INVITEFACE;
//            timeElementChosen = System.currentTimeMillis();
//            if (Utility.mFacebook == null) {
//                Utility.mFacebook = new Facebook(Constants.APP_ID);
//                Utility.mAsyncRunner = new AsyncFacebookRunner(
//                        Utility.mFacebook);
//            }
//            
//            if (!Utility.mFacebook.isSessionValid()) {
//                facebookAction = Constants.FACEBOOK_INVITE_FRIENDS;
//                Utility.mFacebook.authorize(main, permissions,
//                        Facebook.FORCE_DIALOG_AUTH,
//                        main.gameCanvas.new LoginDialogListener());
//            } else {
//            	inviteFacebook();
//            }
//        }
//    }
//
//    private void touchUpStateAchievements(MotionEvent event) {
//
//        if (!canBeDragged) {
//            animationScrolling = true;
//            if (scrollingLeft) {
//                if (pageAchievements + 2 > Constants.NUMBER_ACHIEVEMENTS) {
//                    animationScrolling = false;
//                    return;
//                }
//
//            } else {
//                if (pageAchievements - 2 < 0) {
//                    animationScrolling = false;
//                    return;
//                }
//            }
//            return;
//        }
//
//        if (buttonArrow.touch(event)) {
//            animationScrolling = true;
//            scrollingLeft = false;
//
//            if (pageAchievements - 2 < 0) {
//                animationScrolling = false;
//                return;
//            }
//
//            return;
//        }
//
//        if (buttonArrowRigth.touch(event)) {
//            animationScrolling = true;
//            scrollingLeft = true;
//            if (pageAchievements + 2 > Constants.NUMBER_ACHIEVEMENTS) {
//                animationScrolling = false;
//                return;
//            }
//            return;
//        }
//
//        int diff_Y = backgAllCollections.getHeight() + diffAchivi_Y;
//        int posX = mCanvasWidth / 2 - backgAllCollections.getWidth() / 2;
//        int posY = spaceBetBorderBackgrSuper;
//        int posCashIn_X = posX + backgAllCollections.getWidth()
//                - buttonCashIn.getWidth() - 20;
//        int posCashIn_Y = posY + backgAllCollections.getHeight() / 2
//                - buttonCashIn.getHeight() / 2;
//
//        for (int i = pageAchievements; i < pageAchievements + 2; i++) {
//            if (i == 15)
//                return;
//            if (Constants.CURRENT_QUANTITY_ACHIEVEMENTS[i] >= Constants.ACHIEVEMENTS_INFO[i][(Constants.LEVEL_ACHIEVEMENTS[i] * 2)]
//                    && !Constants.COMPLETE_ACHIEVEMENTS[i]) {
//                if (thereIsTouch(event, posCashIn_X,
//                        posCashIn_X + buttonCashIn.getWidth(), posCashIn_Y,
//                        posCashIn_Y + buttonCashIn.getHeight())) {
//                    if (Constants.LEVEL_ACHIEVEMENTS[i] + 1 < 5) {
//                        sound(mContext, 3);
//
//                        if(Constants.LEVEL_ACHIEVEMENTS[i]+1 != 4){
//                        assignQuantity(
//                                0,
//                                0,
//                                0,
//                                0,
//                                0,
//                                Constants.ACHIEVEMENTS_INFO[i][Constants.LEVEL_ACHIEVEMENTS[i] * 2 + 1],
//                                0, mCanvasWidth / 2, mCanvasHeight / 2);
//                        } else {
//                        	 assignQuantity(
//                                     0,
//                                     0,
//                                     0,
//                                     0,
//                                     1,
//                                     0, 0, mCanvasWidth / 2, mCanvasHeight / 2);
//                        }
//
//                        Constants.LEVEL_ACHIEVEMENTS[i]++;
//                        Constants.numberArchievementsComplete += 1;
//
//                        if (buildingsPut[0].getUpdgrade() + 1 < 6) {
//                            if (Constants.numberArchievementsComplete >= Constants.NUMBER_ACHIEVEMENTS_FOR_UPGRADE[buildingsPut[0]
//                                    .getUpdgrade()]) {
//                                Constants.numberArchievementsComplete = 0;
//                                buildingsPut[0].setUpdgrade(buildingsPut[0]
//                                        .getUpdgrade() + 1);
//                                if (Constants.buildings[buildingsPut[0]
//                                        .getType()][buildingsPut[0]
//                                        .getUpdgrade()] == null) {
//                                    loadBuildingsImg(buildingsPut[0].getType(),
//                                            buildingsPut[0].getUpdgrade());
//                                }
//
//                                int[] pos = calculatePosInitialMap(
//                                        buildingsPut[0].getPosX(),
//                                        buildingsPut[0].getPosY());
//                                inicializateAnimationCloud(pos[0]
//                                        + World.posWorldX, pos[1]
//                                        + World.posWorldY);
//                                stateGame = Constants.STATE_MAIN_GAME;
//
//                            }
//                        }
//
//                        Constants.CURRENT_QUANTITY_ACHIEVEMENTS[i] = 0;
//                        if (Constants.LEVEL_ACHIEVEMENTS[i] == 4) {
//                            Constants.COMPLETE_ACHIEVEMENTS[i] = true;
//                        }
//
//                        Constants.achiviementsActive = false;
//                        for (int h = 0; h < Constants.CURRENT_QUANTITY_ACHIEVEMENTS.length; h++) {
//                            if (Constants.CURRENT_QUANTITY_ACHIEVEMENTS[h] >= Constants.ACHIEVEMENTS_INFO[h][(Constants.LEVEL_ACHIEVEMENTS[h] * 2)]) {
//                                Constants.achiviementsActive = true;
//                                break;
//                            }
//                        }
//                        if (tutorialGame) {
//                            stepTutorial++;
//                            // stepInAuxTutorial ++;
//                            if (stepTutorial == Constants.STEP_TUTORIAL_SPECIAL_TASKS) {
//                                time_showIconTrucker = System
//                                        .currentTimeMillis();
//                                showIconMsgTuto = true;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//
//            posY += diff_Y;
//            posCashIn_Y = posY + backgAllCollections.getHeight() / 2
//                    - buttonCashIn.getHeight() / 2;
//        }
//    }
//
//    public boolean closedButtonGeneral(MotionEvent event) {
//
//        if (stateGame == Constants.STATE_PROMOTION
//                || stateGame == Constants.STATE_PRODUCTION
//                || stateGame == Constants.STATE_MAIN_MARKET
//                || stateGame == Constants.STATE_MISSION
//                || stateGame == Constants.STATE_MARKET_CROPS
//                || stateGame == Constants.STATE_MARKET_BUILDING
//                || stateGame == Constants.STATE_MARKET_DECO
//                || stateGame == Constants.STATE_MARKET_ANIMALS
//                || stateGame == Constants.STATE_LEVEL_UP
//                || stateGame == Constants.STATE_STORAGE
//                || stateGame == Constants.STATE_FEED_MILL
//                || stateGame == Constants.STATE_QUEST_EXPANSION
//                || stateGame == Constants.STATE_NOFOOD
//                || stateGame == Constants.STATE_MORE_COINS
//                || stateGame == Constants.STATE_MORE_DIAMONDS
//                || stateGame == Constants.STATE_COLLECTIONS
//                || stateGame == Constants.STATE_ACHIEVEMENTS
//                || stateGame == Constants.STATE_UPGRADE_ANIMAL
//                || stateGame == Constants.STATE_QUEST_BOOST
//                || stateGame == Constants.STATE_FACEBOOK
//                || stateGame == Constants.STATE_UPGRADE_BUILDING
//                || stateGame == Constants.STATE_WIN_MATERIAL
//                || stateGame == Constants.STATE_WIN_MASTERED
//                || stateGame == Constants.STATE_TRUCKQUEST
//                || stateGame == Constants.STATE_CHARACTER_MISSION
//                || stateGame == Constants.STATE_POP_PLOW_FULL
//                || stateGame == Constants.STATE_POP_STORAGE_FULL) {
//
//            if (event != null) {
//                if (buttonClose.touch(event)) {
//
//                   /* if (stateGame == Constants.STATE_ACHIEVEMENTS) {
//                        disposeAchievementsBitmaps();
//                    }
//                    if (stateGame == Constants.STATE_FACEBOOK) {
//                        disposeFacebookBitmaps();
//                    }
//
//                    if (stateGame == Constants.STATE_PRODUCTION) {
//                        disposeProductionViewBitmaps();
//                    }
//
//                    if (stateGame == Constants.STATE_MARKET_BUILDING) {
//                        disposeMarketBuildingsBitmaps();
//                    }
//                    
//                    if (stateGame == Constants.STATE_TRUCKQUEST) {
//                        disposeQuestTruckBitmaps();
//                    }
//                    
//                    if (stateGame == Constants.STATE_TRUCKQUEST) {
//                        disposeQuestTruckBitmaps();
//                    }*/
//                    
//                    if (stateGame == Constants.STATE_MARKET_CROPS) {
//                    	actionSelect = null;
//                    	currentMultitouch = 0;
//                        indexMultitouch = 0;
//                        msgSelect = null;
//                    }
//
//                    if(tutorialGame && stepTutorial == Constants.STEP_TUTORIAL_FARM_FRIENDS){
//                    	insertThingMap();
//                    }
//                    stateGame = Constants.STATE_MAIN_GAME;
//                    return true;
//                }
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void insertThingMap(){
//    	int nTiledAdd = 6;
//    	 initExpand_X = (((int) 3) * 4) + 3 + nTiledAdd;
//         initExpand_Y = (((int) 0) * 4) + 3 + nTiledAdd;
//         mapExpansion[(initExpand_Y - 3 - nTiledAdd) / 4][(initExpand_X - 3 - nTiledAdd) / 4] = 0;
//         doExpansion(false);
//    	
//    	initExpand_X = (((int) 4) * 4) + 3 + nTiledAdd;
//        initExpand_Y = (((int) 0) * 4) + 3 + nTiledAdd;
//        mapExpansion[(initExpand_Y - 3 - nTiledAdd) / 4][(initExpand_X - 3 - nTiledAdd) / 4] = 0;
//        doExpansion(false);
//   	
//   		initExpand_X = (((int) 4) * 4) + 3 + nTiledAdd;
//   		initExpand_Y = (((int) 1) * 4) + 3 + nTiledAdd;
//   	    mapExpansion[(initExpand_Y - 3 - nTiledAdd) / 4][(initExpand_X - 3 - nTiledAdd) / 4] = 0;
//		doExpansion(false);
//		
//		   boolean isFourSpace = true;
//          
//		   int []posBuilding_X = {27, 27, 21};
//		   int []posBuilding_Y = {17, 12, 10};
//		   int []classTypeBuilding = {0,3,1};
//		   int []typeBuilding ={Constants.BUILDINGANIMAL, Constants.BUILDINGANIMAL, Constants.BUILDINGNORMAL};
//           for(int i = 0; i < 3; i++){
//        	   	Constants.buildingUsed[classTypeBuilding[i]] += 1;
//        	   	
//        	   	if(typeBuilding[i] == Constants.BUILDINGNORMAL){
//           			isFourSpace = false;
//           		}
//        	   	
//           		buildingsPut[nBuildingsPut] = new Building(posBuilding_X[i], posBuilding_Y[i], classTypeBuilding[i],typeBuilding[i], isFourSpace);
//
//           		
//           		
//           		mapContaints[posBuilding_Y[i]][posBuilding_X[i]] = Constants.EARTH_BUILDING;
//           		mapObjects[posBuilding_Y[i]][posBuilding_X[i]] = nBuildingsPut;
//
//           		if (isFourSpace) {
//               		mapContaints[posBuilding_Y[i]][posBuilding_X[i]] = Constants.LIMBOBUILDING;
//               		mapContaints[posBuilding_Y[i]][posBuilding_X[i] + 1] = Constants.LIMBOBUILDING;
//               		mapContaints[posBuilding_Y[i] + 1][posBuilding_X[i]] = Constants.EARTH_BUILDING;
//               		mapContaints[posBuilding_Y[i] + 1][posBuilding_X[i] + 1] = Constants.LIMBOBUILDING;
//               		mapObjects[posBuilding_Y[i] + 1][posBuilding_X[i]] = nBuildingsPut;
//           		}
//           
//           		buildingsPut[nBuildingsPut].setUpdgrade(1);
//           		loadBuildingsImg(Constants.BUILDING_ORD[classTypeBuilding[i]], 0);
//           		buildingsPut[nBuildingsPut].setReady(true);
//           		
//           		
//           		nBuildingsPut++;
//           }
//           //23,41,06,12,18
//           int []posAnimal_X = {27, 27, 28, 27 , 28};
//		   int []posAnimal_Y = {17, 18, 18, 12,  13};
//		   int []classTypeAnimal = {0,0,0,1,1};
//		   int []producingAnimal = {1,0,1,1,1};
//		   int []timeAnimalReady = {60,0,60,120,120};
//		   int [] buildingOwnerAnimal = {(nBuildingsPut-2),(nBuildingsPut-2),(nBuildingsPut-2),(nBuildingsPut-1),(nBuildingsPut-1)};
//           for(int i = 0; i < 5; i++){
//           animalsPut[nAnimalsPut] = new Animal(
//        		   posAnimal_X[i],
//        		   posAnimal_Y[i], classTypeAnimal[i],
//        		   buildingOwnerAnimal[1]);
//           animalsPut[nAnimalsPut].setStatus((producingAnimal[i] == 1) ? Constants.STATUS_ANIMALS_WORKING : Constants.STATUS_ANIMALS_HUNGRY);
//         
//           if((producingAnimal[i] == 1)){
//        	   animalsPut[nAnimalsPut].setTimeTranscurrentProducing(timeAnimalReady[i]);
//           }
//           
//           if (Constants.animalsProducing[Constants.ANIMALS_ORD[classTypeAnimal[i]]][0] == null) {
//               loadAnimalsImg(classTypeAnimal[i]);
//           }
//           
//           nAnimalsPut++;
//           Constants.animalUsed[classTypeAnimal[i]] += 1;
//           }
//
//           
//           
//           int []posCrops_X = {23, 23, 23, 24, 24, 24, 23, 24, 25, 26, 23, 23, 23, 24, 24, 24, 25, 25, 25, 26};
//		   int []posCrops_Y = {19, 18, 17, 19, 18, 17, 15, 15, 15, 15, 11, 10, 9, 11, 10, 9, 11, 10, 9, 19};
//		   int []classTypeCrops = 
//		   			{Constants.WHEAT,Constants.WHEAT,Constants.WHEAT,Constants.WHEAT,Constants.WHEAT,Constants.WHEAT,
//				   	 Constants.CORN,Constants.CORN,Constants.CORN, Constants.CORN,
//				   	 Constants.BLUEBERRY, Constants.BLUEBERRY, Constants.BLUEBERRY,
//				   	 Constants.BLUEBERRY, Constants.BLUEBERRY, Constants.BLUEBERRY,
//				   	 Constants.WHEAT,Constants.WHEAT,Constants.WHEAT,
//				   	 Constants.APPLE,
//		   			};
//        	/**
//        	 * 6x wheat(ready), 4xcorn (20 seconds left), 3 additional wheat (1min left), 3x blueberry (2 minutes), 3 additional blueberry (5 minutes), 1 Apple tree (ready in 1:30 min)
//        	 */
//		   int []timeReadyCrops = {0, 0, 0, 0, 0, 0,     
//				   					30, 30, 30, 30, 
//				   					120,  120, 120, 
//				   					300, 300, 300, 
//				   					60, 60, 60,
//				   					90};
//		   for(int i = 0; i < classTypeCrops.length; i++){
//			   tree[NTree] = new Crop(Constants.CROPS_ORD[classTypeCrops[i]], posCrops_X[i], posCrops_Y[i]);
//			   tree[NTree].setId(60 + classTypeCrops[i]);
//			   mapContaints[posCrops_Y[i]][posCrops_X[i]] = Constants.EARTH_CROPS;
//			   mapObjects[posCrops_Y[i]][posCrops_X[i]] = NTree;
//			   int time = (((Constants.CROPS_TIME_TO_WIN[tree[NTree].getType()] * 60)) / 5 * 4);
//			   tree[NTree].setTimeTranscurrent(time - timeReadyCrops[i]);
//			   if (Constants.cropsImage[Constants.CROPS_ORD[tree[NTree].getType()]][0] == null) {
//	                loadCrops(tree[NTree].getType());
//	            }
//			   
//			   NTree++;
//		   }
//		   
//
//		   int []posDecoration_X = {24, 28};
//		   int []posDecoration_Y = {12, 10};
//		   int []classTypeDecoration = {1,2};
//		   for(int i = 0; i < 2; i++){
//
//			   decorationsPut[nDecorationsPut] = new Decoration(posDecoration_X[i],
//                       posDecoration_Y[i], classTypeDecoration[i]);
//			   
//               mapContaints[posDecoration_Y[i]][posDecoration_X[i]] = Constants.EARTH_DECORATION;
//               mapObjects[posDecoration_Y[i]][posDecoration_X[i]] = nDecorationsPut;
//
//              
//               
//               nDecorationsPut++;
//		   }
//    }
//    
//  /*  private void disposeMarketBuildingsBitmaps() {
//        disposeBitmap(spriteIconsBuildings);
//    }
//
//    private void disposeQuestTruckBitmaps() {
//        disposeImageButton(buttonAccept);
//        disposeImageButton(buttonDenie);
//        disposeBitmap(truckDecoration);
//        disposeBitmap(backgDecoTruck);
//        
//    }
//    
//    private void disposeProductionViewBitmaps() {
//        disposeBitmap(buildingPlusInfo);
//        disposeBitmap(backgInfoProduct);
//        disposeBitmap(productItemBackgroundSmall);
//        disposeBitmap(prodItemBackgSmallInac);
//        disposeBitmap(symbolEquals);
//        disposeBitmap(productItemBackgroundInactive);
//        disposeBitmap(buttonCollect);
//        disposeBitmap(buttonFinish);
//        disposeBitmap(buttonAddProductInactive);
//    }
//
//    private void disposeFacebookBitmaps() {
//        disposeImageButton(buttonAddHelper);
//        disposeBitmap(friendsAmount);
//        disposeBitmap(itemBackgFace);
//        disposeImageButton(buttonInvite);
//        disposeBitmap(buttonFacebook);
//    }
//
//    private void disposeAchievementsBitmaps() {
//        disposeBitmap(spriteIconAchievements);
//        disposeBitmap(backgAllCollections);
//        disposeBitmap(backgRewardCollections);
//        disposeBitmap(buttonCashIn);
//        disposeBitmap(buttonCashInLocked);
//        disposeBitmap(barProgressAchievements);
//        disposeBitmap(barProgressAchievementsFull);
//        disposeBitmap(achievementsBackgIcon);
//        disposeBitmap(starCollectionFull);
//        disposeBitmap(starCollectionEmpty);
//    }
//
//    private void disposeBitmap(Bitmap bitmap) {
//        if (bitmap != null) {
//            bitmap.recycle();
//            bitmap = null;
//        }
//    }
//
//    // Use carefully, some views share buttons
//    private void disposeImageButton(ImageButton imageButton) {
//        if (imageButton != null) {
//            imageButton.recycle();
//            imageButton = null;
//        }
//    }
//*/
//    private void touchUpStateInfoProducts(MotionEvent event) {
//        if (buttonClose.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_CLOSE_INFOPRODUCTS;
//            timeElementChosen = System.currentTimeMillis();
//            return;
//        }
//
//        if (buttonAddProduct.touch(event)) {
//
//            switch (productShowInfo) {
//            case Constants.WHEAT:
//            case Constants.CORN:
//            case Constants.VANILLA:
//            case Constants.RYE:
//            case Constants.SUGAR_CANE:
//            case Constants.ONIONS:
//            case Constants.SORGHUM:
//            case Constants.COTTON_PLANT:
//            case Constants.STRAWBERRY:
//            case Constants.BLUEBERRY:
//            case Constants.HANF:
//            case Constants.TOMATOES:
//            case Constants.CACAO:
//            case Constants.POTATOES:
//            case Constants.APPLE:
//            case Constants.ORANGE:
//            case Constants.LEMON:
//                stateGame = Constants.STATE_MARKET_CROPS;
//                animationCursor = true;
//                itemToChoose = 0;
//                chooseItemInShop(iconCrops.length);
//
//                loadImages();
//                break;
//
//            case Constants.WHEAT_FLOUR:
//            case Constants.CRUSHED_GRAIN:
//            case Constants.RYE_FLOUR:
//            case Constants.MIXED_FLOUR:
//            case Constants.BREAD:
//            case Constants.DOUGH:
//            case Constants.CROISSANT:
//            case Constants.PRETZL:
//            case Constants.BLUEBERRY_MUFFIN:
//            case Constants.CHEESE_CAKE:
//            case Constants.APPLE_PIE:
//            case Constants.PRALINES:
//            case Constants.CHEESE:
//            case Constants.BUTTER:
//            case Constants.GOAT_CHEESE:
//            case Constants.YOGHURT:
//            case Constants.FRUIT_JUICE:
//            case Constants.MUESLI:
//            case Constants.KETCHUP:
//            case Constants.JAM:
//            case Constants.POWDERED_SUGAR:
//            case Constants.LEMONADE:
//            case Constants.VANILLA_SUGAR:
//            case Constants.SIRUP:
//            case Constants.GRILLED_CHEESE:
//            case Constants.BACON:
//            case Constants.FRENCH_FRIES:
//            case Constants.HAMBURGER:
//            case Constants.BREAKFAST:
//            case Constants.BRUNCH:
//            case Constants.LUNCH:
//            case Constants.DINNER:
//            case Constants.WOOLBALLS:
//            case Constants.THREADS:
//            case Constants.SPINDLES:
//            case Constants.WEBS:
//            case Constants.TROUSERS:
//            case Constants.HEMP_SHIRT:
//          //  case Constants.HEMP:
//            case Constants.JACKET:
//            case Constants.COTTON_HAT:
//                int type = getPosBuilding();
//                for (int i = 0; i < nBuildingsPut; i++) {
//                    if (buildingsPut[i].getType() == type) {
//                        buildingChosen = i;
//                        stateGame = Constants.STATE_PRODUCTION;
//                        buildingsPut[buildingChosen].changeStatus(4);
//                        loadImages();
//                        for (int f = 0; f < 4; f++) {
//                            loadProductsImg(buildingsPut[buildingChosen]
//                                    .getItemProduce()[f]);
//                            loadProductsImg(buildingsPut[buildingChosen]
//                                    .getMaterialProcesing1()[f]);
//                            loadProductsImg(buildingsPut[buildingChosen]
//                                    .getMaterialProcesing2()[f]);
//                        }
//                        return;
//                    }
//                }
//
//                stateGame = Constants.STATE_MARKET_BUILDING;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = type;
//                chooseItemInShop(Constants.BUILDING_TYPE_ORD.length);
//
//                loadImages();
//
//                break;
//
//            case Constants.EGGS:
//                stateGame = Constants.STATE_MARKET_ANIMALS;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = 0;
//                chooseItemInShop(5);
//                loadImages();
//                break;
//            case Constants.MEAT:
//                stateGame = Constants.STATE_MARKET_ANIMALS;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = 3;
//                chooseItemInShop(5);
//                loadImages();
//                break;
//            case Constants.MILK:
//                stateGame = Constants.STATE_MARKET_ANIMALS;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = 1;
//                chooseItemInShop(5);
//                loadImages();
//                break;
//            case Constants.WOOL:
//         //   case Constants.WOOL_AUX:
//                stateGame = Constants.STATE_MARKET_ANIMALS;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = 2;
//                chooseItemInShop(5);
//                loadImages();
//                break;
//            case Constants.GOAT_MILK:
//                stateGame = Constants.STATE_MARKET_ANIMALS;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = 4;
//                chooseItemInShop(5);
//                loadImages();
//                break;
//
//            case Constants.MISSION_TYPE_DECO:
//
//                stateGame = Constants.STATE_MARKET_DECO;
//                animationCursor = true;
//                itemToChoose = 0;
//                productShowInfo = positionDeco;
//                chooseItemInShop(6);
//                loadImages();
//                break;
//            default:
//                stateGame = backup_StateGame;
//                break;
//            }
//        }
//    }
//
//    private void touchUpInfoTutorialFake(MotionEvent event) {
//        if (buttonAddProduct.touch(event)) {
//
//            stateGame = backup_StateGame;
//
//            return;
//        }
//
//    }
//
//    private void touchUpInfoTutorial(MotionEvent event) {
//       // elementChosen = Constants.PRESS_BUTTON_OK_TUTORIAL;
//      //  timeElementChosen = System.currentTimeMillis();
//    	
//    	stepTutorial++;
//    	if (stepTutorial == Constants.STEP_TUTORIAL_PLOW_FIELDS) {
//    		UtilSoftgames.setValuesForTransparent();
//    		timeShowIconMsgTuto = System.currentTimeMillis();
//    		showIconMsgTuto = true;
//    		stateGame = Constants.STATE_MAIN_GAME;
//    		System.currentTimeMillis();
//    		screenTuto = null;
//    		 preparateMoving(22, 18);
//    		 
//    		 loadImageStateMission();
//             loadIconsBuildings();
//             loadIconAnimals();
//             loadImageStateTruckQuest();
//             loadImageStateProduction();
//         	
//    		System.gc();
//    	}
//
//        return;
//    }
//
//    private void touchUpStateQuestBoost(MotionEvent event) {
//        if (buttonAddProduct.touch(event)) {
//            if (isTransactionPossible(Constants.DIAMONDS, diamondsToBoost)) {
//                if (assignQuantity(0, 0, 0, 0, -diamondsToBoost, 0, 0,
//                        mCanvasWidth / 2, mCanvasHeight / 2)) {
//                    elementChosen = Constants.PRESS_BUTTON_QUESTBOOST;
//                    timeElementChosen = System.currentTimeMillis();
//                    sound(mContext, 6);
//                }
//            }
//            return;
//        }
//    }
//
//    private void touchUpStateUpgradeFeedMill(MotionEvent event) {
//
//        if (buttonClose.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_UPDGRADE_FEEDMILLCLOSED;
//            timeElementChosen = System.currentTimeMillis();
//            return;
//        }
//
//        boolean canUpgrade = true;
//        int diff = 20;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 3) / 2;
//        for (int i = 0; i < 6; i += 2) {
//            int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i];
//            int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//            int currentQuantity = getCurrentQuantity(type);
//
//            if (i == 2 && currentQuantity < quantityValue
//                    && type != Constants.DIAMONDS) {
//            	 buttonAddProduct.setPosX(posX
//                         + productItemBackground.getWidth() / 2
//                         - buttonAddProduct.getImage().getWidth() / 2);
//                if (buttonAddProduct.touch(event)
//                        && isTransactionPossible(Constants.DIAMONDS, 10)) {
//                    if (type != Constants.FRIENDS) {
//                        assignQuantity(0, 0, 0, 0, -10, 0, 0, mCanvasWidth / 2,
//                                mCanvasHeight);
//                        quantityCurrentMaterial[type - 56] += 1;
//
//                    } else {
//                        addFakeFriends();
//                    }
//                }
//               
//            }
//            posX += productItemBackground.getWidth() + diff;
//
//            if (currentQuantity < quantityValue) {
//                canUpgrade = false;
//            }
//        }
//
//        if (canUpgrade && buttonBuild.touch(event)) {
//
//            elementChosen = Constants.PRESS_BUTTON_UPDGRADE_FEEDMILL;
//            timeElementChosen = System.currentTimeMillis();
//        }
//
//    }
//
//    private void touchUpStateUpdgradeAnimal(MotionEvent event) {
//        if (buttonBuild.touch(event)) {
//            if (animalsPut[typeObjectInMiniOption].getUpdgrade() + 1 < 5) {
//                animalsPut[typeObjectInMiniOption]
//                        .setShowTimeUnderConstruction(true);
//                animalsPut[typeObjectInMiniOption].setReady(false);
//                animalsPut[typeObjectInMiniOption].setMenuRotate(false);
//                animalsPut[typeObjectInMiniOption].setMoveFree(false);
//                // animalsPut[typeObjectInMiniOption].setUpdgrade(animalsPut[typeObjectInMiniOption].getUpdgrade()
//                // + 1);
//            }
//            elementChosen = Constants.PRESS_BUTTON_UPDGRADE_ANIMAL;
//            timeElementChosen = System.currentTimeMillis();
//        }
//
//    }
//
//    private void touchUpStateUpgradeBuilding(MotionEvent event) {
//        boolean canUpgrade = true;
//        int diff = 20;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 3) / 2;
//        for (int i = 0; i < 6; i += 2) {
//            int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i];
//            int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//            int currentQuantity = getCurrentQuantity(type);
//
//            if (i <= 2 && currentQuantity < quantityValue
//                    && type != Constants.DIAMONDS && type != Constants.GOLD) {
//            	 buttonAddProduct.setPosX(posX
//                         + productItemBackground.getWidth() / 2
//                         - buttonAddProduct.getImage().getWidth() / 2);
//            	if (buttonAddProduct.touch(event)) {
//                    if (type != Constants.FRIENDS) {
//                        if (isTransactionPossible(Constants.DIAMONDS, 10)) {
//                            assignQuantity(0, 0, 0, 0, -10, 0, 0,
//                                    mCanvasWidth / 2, mCanvasHeight);
//                            quantityCurrentMaterial[type - 56] += 1;
//                        }
//                    } else {
//                        addFakeFriends();
//                    }
//                }
//            	 
//            }
//            posX += productItemBackground.getWidth() + diff;
//
//            if (currentQuantity < quantityValue) {
//                canUpgrade = false;
//            }
//        }
//
//        if (canUpgrade && buttonBuild.touch(event)) {
//            if (buildingsPut[buildingChosen].getUpdgrade() + 1 < 5) {
//                buildingsPut[buildingChosen].setShowTimeUnderConstruction(true);
//                buildingsPut[buildingChosen].setReady(false);
//                buildingsPut[buildingChosen].setMenuRotate(false);
//                buildingsPut[buildingChosen].setMoveFree(false);
//                for (int i = 0; i < 6; i += 2) {
//                    int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                            .getPosOrderInfos()
//                            + buildingsPut[buildingChosen].getUpdgrade()][i];
//                    int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                            .getPosOrderInfos()
//                            + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//
//                    switch (type) {
//                    case Constants.GOLD:
//                        if (isTransactionPossible(Constants.GOLD, quantityValue)) {
//                            quantityCoins -= quantityValue;
//                        } else {
//                            return;
//                        }
//
//                        break;
//                    case Constants.DIAMONDS:
//                        if (isTransactionPossible(Constants.DIAMONDS,
//                                quantityValue)) {
//                            quantityDiamonds -= quantityValue;
//                        } else {
//                            return;
//                        }
//                        break;
//                    case Constants.LEVEL:
//                        break;
//                    case Constants.FRIENDS:
//                        break;
//
//                    case Constants.STONES:
//                    case Constants.WOOD:
//                    case Constants.ROPES:
//                    case Constants.NAILS:
//                    case Constants.LEAF:
//                        quantityCurrentMaterial[type - 56] -= quantityValue;
//                        break;
//                    }
//
//                }
//
//            }
//
//            elementChosen = Constants.PRESS_BUTTON_UPDGRADE_BUILDING;
//            timeElementChosen = System.currentTimeMillis();
//
//            sound(main, SoundUtil.SOUND_BUILDING_UPGRADE);
//        }
//    }
//
//    private void putCollection(int posTiledX, int posTiledY, int type, int pos,
//            boolean putCollection) {
//        if (putCollection) {
//            int posObject = 0;
//            collectionPut[type].setQuantityItems(
//                    collectionPut[type].getQuantityItems()[pos - 1] + 1,
//                    pos - 1);
//            if(showCashIn(type)){
//            	stateGame = Constants.STATE_COLLECTIONS;
//            	pageCollection = type/2;
//            }
//            if (indexCollectionWin < 30) {
//                posObject = indexCollectionWin;
//                indexCollectionWin++;
//            } else {
//                for (int i = 0; i < indexCollectionWin; i++) {
//                    if (!collectionWin[i].isActive()) {
//                        posObject = i;
//                        break;
//                    }
//                }
//            }
//
//            collectionWin[posObject] = new CollectionWin();
//            collectionWin[posObject].setPosTiledX(posTiledX);
//            collectionWin[posObject].setPosTiledY(posTiledY);
//            collectionWin[posObject].setType(type);
//            collectionWin[posObject].setPosition(pos);
//            collectionWin[posObject].setActive(true);
//            collectionWin[posObject].timeToDissapear = System
//                    .currentTimeMillis();
//        }
//    }
//
//    private void touchUpStateUpdgradeStore(MotionEvent event) {
//
//        if (buttonClose.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_UPDGRADE_STORECLOSED;
//            timeElementChosen = System.currentTimeMillis();
//        }
//
//        boolean canUpgrade = true;
//        int diff = 20;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 3) / 2;
//        for (int i = 0; i < 6; i += 2) {
//            int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i];
//            int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//            int currentQuantity = getCurrentQuantity(type);
//           
//            if (i <= 2 && currentQuantity < quantityValue) {
//                buttonAddProduct.setPosX(posX
//                        + productItemBackground.getWidth() / 2
//                        - buttonAddProduct.getImage().getWidth() / 2);
//                if (buttonAddProduct.touch(event)
//                        && isTransactionPossible(Constants.DIAMONDS, 10)) {
//                    if (type != Constants.FRIENDS) {
//                        assignQuantity(0, 0, 0, 0, -10, 0, 0, mCanvasWidth / 2,
//                                mCanvasHeight);
//                        quantityCurrentMaterial[type - 56] += 1;
//
//                    } else {
//                        addFakeFriends();
//                    }
//                }
//            }
//
//            if (currentQuantity < quantityValue) {
//                canUpgrade = false;
//            }
//
//            posX += productItemBackground.getWidth() + diff;
//        }
//
//        if (canUpgrade && buttonBuild.touch(event)) {
//
//            elementChosen = Constants.PRESS_BUTTON_UPDGRADE_STORE;
//            timeElementChosen = System.currentTimeMillis();
//        }
//    }
//
//    private void touchUpStateNoFood(MotionEvent event) {
//        int diff = productItemBackground.getWidth() + 20;
//        int posX = mCanvasWidth / 2 - (diff * 3) / 2;
//        int posY = posNoFood_Y;
//        for (int i = 0; i < 3; i++) {
//            buttonAddProduct.setPosX(posX + productItemBackground.getWidth()
//                    / 2 - buttonAddProduct.getImage().getWidth() / 2);
//            buttonAddProduct.setPosY(posY + productItemBackground.getHeight()
//                    - buttonAddProduct.getImage().getHeight() / 2);
//            if (buttonAddProduct.touch(event)) {
//                if (i == 0) {
//                    buildingChosen = 2;
//                    stateGame = Constants.STATE_FEED_MILL;
//                    loadImages();
//                    if (tutorialGame) {
//                        if (10 - totalQuantityStorage > 0) {
//                            assignStorage(Constants.STORAGE_CROPS,
//                                    10 - totalQuantityStorage, 0);
//                        }
//                        stepTutorial++;
//                        stepInAuxTutorial = 0;
//                    }
//                }
//		if (!tutorialGame) {
//                    if (i == 1 && isTransactionPossible(Constants.DIAMONDS,
//				Constants.SMALL_PKG_FOOD_PRICE)) {
//                        assignQuantity(0, 0, 0,
//                                Constants.SMALL_PKG_FOOD_QUANTITY,
//                                -Constants.SMALL_PKG_FOOD_PRICE, 0, 0,
//                                mCanvasWidth / 2, mCanvasHeight / 2);
//                    }
//
//                    if (i == 2 && isTransactionPossible(Constants.DIAMONDS,
//				Constants.BIG_PKG_FOOD_PRICE)) {
//                        assignQuantity(0, 0, 0,
//                                Constants.BIG_PKG_FOOD_QUANTITY,
//                                -Constants.BIG_PKG_FOOD_PRICE, 0, 0,
//                                mCanvasWidth / 2, mCanvasHeight / 2);
//                    }
//                }
//
//            }
//
//            posX += diff;
//        }
//    }
//
//    private void touchUpStateQuestExpansion(MotionEvent event) {
//        int tiledAdd = 6;
//        if (buttonBuild.touch(event)) {
//            if (isTransactionPossible(Constants.DIAMONDS,
//                    Constants.EXPANSION_DIAMOND[Constants.currentExpansion])) {
//                quantityDiamonds -= Constants.EXPANSION_DIAMOND[Constants.currentExpansion];
//                Constants.currentExpansion++;
//                limitTotalPlots = Constants.EXPANSION_AVAILABLE[Constants.currentExpansion];
//                mapExpansion[(initExpand_Y - 3 - tiledAdd) / 4][(initExpand_X - 3 - tiledAdd) / 4] = 0;
//                doExpansion(false);
//                stateGame = Constants.STATE_MAIN_GAME;
//                validateAchievements(Constants.ACHIEVEMENTS_EXPANDS, 1);
//                if (tutorialGame) {
//                    stepTutorial++;
//                    stepInAuxTutorial = 0;
//                }
//                // put the respective collection
//                createCollectionForExpansion(mCanvasWidth / 2,
//                        mCanvasHeight / 2);
//            }
//
//        }
//
//        int posX = (mCanvasWidth / 2) / 2 - buttonBuild.getImage().getWidth()
//                / 2;
//        int posY = buttonBuild.getPosY();
//        
//        if (thereIsTouch(event, posX, posX + buttonBuildInactive.getWidth(),
//                posY, posY + buttonBuildInactive.getHeight())) {
//
//            if (isTransactionPossible(Constants.GOLD,
//                    Constants.EXPANSION_COINS[Constants.currentExpansion])) {
//                quantityCoins -= Constants.EXPANSION_COINS[Constants.currentExpansion];
//                Constants.currentExpansion++;
//                limitTotalPlots = Constants.EXPANSION_AVAILABLE[Constants.currentExpansion];                
//                mapExpansion[(initExpand_Y - 3 - tiledAdd) / 4][(initExpand_X - 3 - tiledAdd) / 4] = 0;
//                doExpansion(true);
//                stateGame = Constants.STATE_MAIN_GAME;
//                validateAchievements(Constants.ACHIEVEMENTS_EXPANDS, 1);
//
//                // put the respective collection
//                createCollectionForExpansion(posX, posY);
//            }
//
//        }
//
//    }
//
//    private void createCollectionForExpansion(int posX, int posY) {
//        int pos = 1;
//        int random = UtilSoftgames.random(0, 100);
//        if (random < 20) {
//            pos = 1;
//        } else if (random < 35) {
//            pos = 2;
//        } else if (random < 25) {
//            pos = 3;
//        } else if (random < 15) {
//            pos = 4;
//        } else if (random >= 5) {
//            pos = 5;
//        }
//        putCollection(posX, posY, 19, pos, canPutCollection(100));
//    }
//
//    private boolean isTransactionPossible(int itemToDeduct, int amountToDeduct) {
//        // If the user is running out of coins playing the tutorial we refill
//        // some
//        if (tutorialGame) {
//            if (quantityCoins - amountToDeduct <= 0) {
//                quantityCoins += 200;
//            }
//            if (quantityDiamonds - amountToDeduct <= 0) {
//                quantityDiamonds += 15;
//            }
//        }
//
//        switch (itemToDeduct) {
//        case Constants.GOLD:
//
//            if ((quantityCoins - amountToDeduct) >= 0) {
//                sound(main, SoundUtil.SOUND_SPENT_GOLD);
//                return true;
//            } else {
//                if (stateOnlyGreen) {
//                    disableStateOnlyGreen();
//                }
//                stateGame = Constants.STATE_MORE_COINS;
//                loadImages();
//            }
//            break;
//        case Constants.DIAMONDS:
//
//            if ((quantityDiamonds - amountToDeduct) >= 0) {
//                sound(main, SoundUtil.SOUND_SPENT_DIAMONDS);
//                return true;
//            } else {
//                if (stateOnlyGreen) {
//                    disableStateOnlyGreen();
//                }
//                stateGame = Constants.STATE_MORE_DIAMONDS;
//                loadImages();
//            }
//            break;
//
//        default:
//            break;
//        }
//        return false;
//    }
//
//    private void touchUpStateFeedMill(MotionEvent event) {
//        int posItem_X = 10 + buttonArrow.getPosX()
//                + buttonArrow.getImage().getWidth();
//        int diffItem_X = 6;
//        int posItem_Y = initPosStorage_Y;
//
//        // int posBackgNItemSell_X = (mCanvasWidth/2 +
//        // backgroundGeneral.getWidth()/2) - spaceBetBorderBackgr -
//        // backgItemStorage.getWidth()/2 -
//        // ((backgNitemSell.getImage().getWidth() + 5)*3)/2;
//        if (storageChosen != -1) {
//
//            if (selectAll.touch(event)) {
//                quantityCropForFood = getQuantityProductInStorage(storageChosen);//cropsQuantityRecolect[storageChosen];
//                if (tutorialGame && stepInAuxTutorial == 1) {
//                    stepInAuxTutorial++;
//                }
//                quantityFoodProduce = quantityCropForFood
//                        * Constants.CROPS_FOOD[storageChosen];
//            }
//            /*
//             * for (int i = 0; i < 3; i++) {
//             * 
//             * backgNitemSell.setPosX(posBackgNItemSell_X);
//             * backgNitemSell.setPosY(posItem_Y + backgItemStorage.getHeight()/
//             * 2 - backgNitemSell.getImage().getHeight() / 2 - 8); if
//             * (backgNitemSell.touch(event)) { switch (i) { case 0:
//             * if((cropsQuantityRecolect[storageChoosed] - quantityCropForFood
//             * >= 1)){ quantityCropForFood += 1; }
//             * 
//             * break; case 1: if((cropsQuantityRecolect[storageChoosed] -
//             * quantityCropForFood >= 5)){ quantityCropForFood += 5; } else {
//             * quantityCropForFood += cropsQuantityRecolect[storageChoosed] -
//             * quantityCropForFood; } //quantityToSell +=
//             * (itemStorage[storageChoosed][2] >= 5) ? 5 :
//             * itemStorage[storageChoosed][2]; break; case 2:
//             * quantityCropForFood = cropsQuantityRecolect[storageChoosed];
//             * if(tutorialGame && stepInAuxTutorial == 1){ stepInAuxTutorial ++;
//             * } break; }
//             * 
//             * quantityFoodProduce = quantityCropForFood *
//             * Constants.cropsFood[storageChoosed];
//             * 
//             * break; }
//             * 
//             * posBackgNItemSell_X += backgNitemSell.getImage().getWidth() + 5;
//             * }
//             */
//        }
//
//        if (buttonArrow.touch(event)) {
//            pageInStorage -= 1;
//            if (pageInStorage < 1) {
//                pageInStorage = 1;
//            }
//            return;
//        }
//
//        if (buttonArrowRigth.touch(event)) {
//            pageInStorage += 1;
//            if (pageInStorage > nPageTotal) {
//                pageInStorage -= 1;
//            }
//            return;
//        }
//
//        int initItem = -9;
//        int finItem = 0;
//        if (indexCorrectStorage <= 9) {
//            finItem = indexCorrectStorage;
//            initItem = 0;
//        } else {
//            do {
//                initItem += 9;
//                finItem += 9;
//            } while (finItem < pageInStorage * 9);
//
//            if (finItem > indexCorrectStorage) {
//                finItem = indexCorrectStorage;
//            }
//        }
//
//        if (buttonUpgrade.touch(event)) {
//            if (buildingsPut[2].getUpdgrade() + 1 < 6) {
//                stateGame = Constants.STATE_UPGRADE_FEEDMILL;
//            }
//        }
//
//        /*
//         * if(thereIsTouch(event, posItem_X, posItem_X +
//         * taskItemBackg.getWidth(), posItem_Y, posItem_Y +
//         * taskItemBackg.getHeight())){ if(buildingsPut[2].getUpdgrade()+1 < 6){
//         * State_Game = Constants.State_Updgrade_FeedMill; } } posItem_X +=
//         * taskItemBackg.getWidth() + diffItem_X;
//         */
//
//        for (int i = initItem; i < finItem; i++) {
//
//            if (thereIsTouch(event, posItem_X,
//                    posItem_X + taskItemBackg.getWidth(), posItem_Y, posItem_Y
//                            + taskItemBackg.getHeight())) {
//            	int totalCrops = getQuantityProductInStorage(itemCorrectStorage[i]);
//                if (Constants.CROPS_ACTIVE_IN_FEED_MILL[itemCorrectStorage[i]] <= buildingsPut[2]
//                        .getUpdgrade()
//                        && totalCrops > 0) {
//
//                    if (storageChosen == i) {
//                        if (totalCrops
//                                - quantityCropForFood - 1 >= 0) {
//                            quantityCropForFood += 1;
//                        }
//
//                    } else {
//                        if (totalCrops - 1 >= 0) {
//                            quantityCropForFood = 1;
//                        }
//                    }
//                    quantityFoodProduce = quantityCropForFood
//                            * Constants.CROPS_FOOD[itemCorrectStorage[i]];
//                    storageChosen = itemCorrectStorage[i]; // i;
//                    if (tutorialGame && stepInAuxTutorial == 0) {
//                        stepInAuxTutorial++;
//                        dissapearMsj = true;
//                    }
//                }
//                break;
//            }
//
//            posItem_X += taskItemBackg.getWidth() + diffItem_X;
//            if (i == initItem + 2 || i == initItem + 5) {
//                posItem_X = 10 + buttonArrow.getPosX()
//                        + buttonArrow.getImage().getWidth();
//                ;
//                posItem_Y += taskItemBackg.getHeight() + 5;
//            }
//        }
//
//        if (buttonAddProduct.touch(event) && storageChosen != -1) {
//            if (quantitySeeds + quantityFoodProduce <= totalQuantityFood) {
//
//                assignStorage(Constants.STORAGE_CROPS, -quantityCropForFood,
//                        storageChosen);
//                storageChosen = -1;
//
//                assignQuantity(0, 0, 0, quantityFoodProduce, 0, 0, 0,
//                        mCanvasWidth / 2, mCanvasHeight / 2);
//                if (tutorialGame && stepInAuxTutorial == 2) {
//                    stepInAuxTutorial++;
//                }
//            } else {
//                if (buildingsPut[2].getUpdgrade() + 1 < 6) {
//                    stateGame = Constants.STATE_UPGRADE_FEEDMILL;
//                }
//            }
//        }
//    }
//
//    private void touchUpStateMission(MotionEvent event) {
//        int posItem_X = posBackgTask_X;
//        int posItem_Y = posBackgTask_Y;
//        for (int i = 0; i < nMission; i++) {
//            if (thereIsTouch(event, posItem_X,
//                    posItem_X + taskItemBackg.getWidth(), posItem_Y, posItem_Y
//                            + taskItemBackg.getHeight())) {
//                missionChosen = i;
//                return;
//            }
//
//            posItem_X += taskItemBackg.getWidth() + 5;
//            if (i == 2 || i == 5) {
//                posItem_X = posBackgTask_X;
//                posItem_Y += taskItemBackg.getHeight() + 5;
//            }
//        }
//
//        int backgTaskBig_X = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                - backgTask.getWidth() - restTaskBig_X;
//
//        if (!canRewardMission[missionChosen]
//                && thereIsTouch(event, backgTaskBig_X + backgTask.getWidth()
//                        / 2 - buttonProduce.getImage().getWidth() / 2,
//                        backgTaskBig_X + backgTask.getWidth() / 2
//                                + buttonProduce.getImage().getWidth() / 2,
//                        posBackgTask_Y + backgTask.getHeight()
//                                - (buttonProduce.getImage().getHeight() / 4)
//                                * 3, posBackgTask_Y + backgTask.getHeight()
//                                - (buttonProduce.getImage().getHeight() / 4)
//                                * 3 + buttonProduceInactive.getHeight())) {
//            skipMission(event);
//
//            if (tutorialGame && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                stepTutorial = Constants.STEP_TUTORIAL_FARM_FRIENDS;
//                //stateGame = Constants.STATE_MAIN_GAME;
//                /*if (stepTutorial == Constants.STEP_TUTORIAL_FARM_FRIENDS) {
//                    stateGame = Constants.STATE_MAIN_GAME;
//                }*/
//                dissapearMsj = false;
//            }
//            return;
//        }
//
//        int posIcon_X = backgTaskBig_X + (backgTask.getWidth() / 3) / 2;
//        int posIcon_Y = posBackgTask_Y + backgTask.getHeight() / 4;
//
//        for (int i = 0; i < nTask[missionChosen]; i++) {
//            infoIcon.setPosX(posIcon_X - iconCrops[0].getWidth() / 2);
//            infoIcon.setPosY(posIcon_Y - iconCrops[0].getHeight() / 2);
//
//            if (infoIcon.touch(event)) {
//
//                backup_StateGame = stateGame;
//                stateGame = Constants.STATE_SHOW_INFO_PRODUCTS;
//                productShowInfo = convertToProductShowInfo(i, missionChosen);
//                return;
//
//            }
//
//            posIcon_X += (backgTask.getWidth() / 3);
//            if (i == 2) {
//                posIcon_X = backgTaskBig_X + (backgTask.getWidth() / 3) / 2;
//                posIcon_Y += backgTask.getHeight() / 3;
//            }
//        }
//
//        int posXLess = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                - buttonCashIn.getWidth() - buttonCashIn_X;
//        int posYLess = mCanvasHeight - buttonCashIn.getHeight()
//                - buttonCashIn_Y;
//        int posXBig = posXLess + buttonCashIn.getWidth();
//        int posYBig = posYLess + buttonCashIn.getHeight();
//        if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//            if (canRewardMission[missionChosen] /*&& !rewardPaid[missionChosen]*/) {
//                finalizeMission();
//
//                explosion = new Explosion(50, (int) event.getX(),
//                        (int) event.getY());
//                explosionActive = true;
//                if (tutorialGame) {// 17
//                    stepTutorial++;
//                    dissapearMsj = false;
//                }
//            }
//        }
//    }
//
//    private int convertToProductShowInfo(int pos, int posMissionChoosed) {
//        int info = 0;
//        switch (typeMission[posMissionChoosed][pos]) {
//        case Constants.MISSION_CREATE_PRODUCT:
//            info = typeProduct[posMissionChoosed][pos];
//            break;
//
//        case Constants.MISSION_PRODUCTANIMAL:
//            info = typeProduct[posMissionChoosed][pos];
//            break;
//        case Constants.MISSION_TYPE_CROPS:
//            info = typeProduct[posMissionChoosed][pos];
//            break;
//        case Constants.MISSION_TYPE_DECO:
//            info = typeMission[posMissionChoosed][pos];
//            positionDeco = typeProduct[posMissionChoosed][pos];
//            break;
//        default:
//            info = typeMission[posMissionChoosed][pos];
//            break;
//
//        }
//
//        return info;
//        // typeMission[missionChoosed][i]
//    }
//
//    private int getMaterial() {
//        int number = UtilSoftgames.random(0, 100);
//
//        if (number < 25) {
//            number = 0;
//        } else if (number < 45) {
//            number = 1;
//        } else if (number < 55) {
//            number = 2;
//        } else if (number < 95) {
//            number = 3;
//        } else if (number <= 100) {
//            number = 4;
//        } else {
//            number = 1;
//        }
//
//        return number;
//    }
//
//    private void touchUpStateStorage(MotionEvent event) {
//        int posItem_X = 10 + buttonArrow.getPosX()
//                + buttonArrow.getImage().getWidth();
//        int diffItem_X = 6;
//        int posItem_Y = initPosStorage_Y;
//
//        // int posBackgNItemSell_X = (mCanvasWidth/2 +
//        // backgroundGeneral.getWidth()/2) - spaceBetBorderBackgr -
//        // backgItemStorage.getWidth()/2 -
//        // ((backgNitemSell.getImage().getWidth() + 5)*3)/2;
//        if (storageChosen != -1) {
//            if (selectAll.touch(event)) {
//                quantityToSell = itemStorage[storageChosen][2];
//                if (tutorialGame && stepInAuxTutorial == 1) {
//                    stepInAuxTutorial++;
//                }
//
//                switch (itemStorage[storageChosen][0]) {
//                case Constants.STORAGE_CROPS:
//                    quantityXPSell = quantityToSell
//                            * Constants.CROPS_EXP[itemStorage[storageChosen][1]];
//                    quantityCoinSell = quantityToSell
//                            * Constants.CROPS_MONEY_TO_WIN[itemStorage[storageChosen][1]];
//                    break;
//                case Constants.STORAGE_ANIMALS_PRODUCTS:
//                    quantityXPSell = quantityToSell
//                            * Constants.PRODUCT_ANIMAL_INFO[itemStorage[storageChosen][1]][6];
//                    quantityCoinSell = quantityToSell
//                            * Constants.PRODUCT_ANIMAL_INFO[itemStorage[storageChosen][1]][5];
//                    break;
//                case Constants.STORAGE_PRODUCTS:
//                    quantityXPSell = quantityToSell
//                            * getInfoProducts(itemStorage[storageChosen][1], 6);
//                    quantityCoinSell = quantityToSell
//                            * getInfoProducts(itemStorage[storageChosen][1], 7);
//                    break;
//                case Constants.STORAGE_DECORATION:
//                    quantityXPSell = quantityToSell
//                            * Constants.DECORATIONS_INFO[itemStorage[storageChosen][1]][3]
//                            / 2;
//                    quantityCoinSell = quantityToSell
//                            * Constants.DECORATIONS_INFO[itemStorage[storageChosen][1]][4];
//                    break;
//                default:
//                    quantityXPSell = quantityToSell * 10;
//                    quantityCoinSell = quantityToSell * 100;
//                    break;
//                }
//            }
//
//        }
//
//        if (buttonArrow.touch(event)) {
//            pageInStorage -= 1;
//            if (pageInStorage < 1) {
//                pageInStorage = 1;
//            }
//            return;
//        }
//
//        if (buttonArrowRigth.touch(event)) {
//            pageInStorage += 1;
//            if (pageInStorage > nPageTotal) {
//                pageInStorage -= 1;
//            }
//            return;
//        }
//
//        // calculateNPageStorage();
//
//        int initItem = -9;
//        int finItem = 0;
//        if (indexCorrectStorage <= 9) {
//            finItem = indexCorrectStorage;
//            initItem = 0;
//        } else {
//            do {
//                initItem += 9;
//                finItem += 9;
//            } while (finItem < pageInStorage * 9);
//
//            if (finItem > indexCorrectStorage) {
//                finItem = indexCorrectStorage;
//            }
//        }
//
//        if (buttonUpgrade.touch(event)) {
//            if (buildingsPut[1].getUpdgrade() + 1 < 6) {
//                stateGame = Constants.STATE_UPGRADE_STORE;
//            }
//        }
//
//        boolean canSell = true;
//        for (int i = initItem; i < finItem; i++) {
//            if (thereIsTouch(event, posItem_X,
//                    posItem_X + taskItemBackg.getWidth(), posItem_Y, posItem_Y
//                            + taskItemBackg.getHeight())) {
//
//                if (i != -1
//                        && (itemStorage[itemCorrectStorage[i]][0] == Constants.STORAGE_DECORATION
//                                || itemStorage[itemCorrectStorage[i]][0] == Constants.STORAGEANIMALS || itemStorage[itemCorrectStorage[i]][0] == Constants.STORAGE_BUILDING)) {
//
//                    if (itemStorage[itemCorrectStorage[i]][0] == Constants.STORAGE_BUILDING) {
//                        canSell = false;
//                    }
//                    checkedAutomaticSmall.setPosX(posItem_X
//                            + taskItemBackg.getWidth()
//                            - checkedAutomaticSmall.getImage().getWidth());
//                    checkedAutomaticSmall.setPosY(posItem_Y
//                            + taskItemBackg.getHeight()
//                            - checkedAutomaticSmall.getImage().getHeight());
//                    if (checkedAutomaticSmall.touch(event)) {
//                        timeShowInfoBox = System.currentTimeMillis();
//                        typeMsgInfo = TypeMsgInfo.MOVE;
//                        stateOnlyGreen = true;
//
//                        switch (itemStorage[itemCorrectStorage[i]][0]) {
//                        case Constants.STORAGE_DECORATION:
//                            typeObjectInMiniOption = nDecorationsPut;
//                            decorationsPut[nDecorationsPut] = new Decoration(
//                                    -1000, -1000,
//                                    itemStorage[itemCorrectStorage[i]][1]);
//                            nDecorationsPut++;
//                            classObjectToMove = Constants.EARTH_DECORATION;
//                            comeStorage = true;
//                            break;
//
//                        case Constants.STORAGE_BUILDING:
//                            for (int a = 0; a < nBuildingsPut; a++) {
//                                if (buildingsPut[a].getPosX() == -1000) {
//                                    typeObjectInMiniOption = a;
//                                    break;
//                                }
//                            }
//
//                            for (int k = 0; k < indexBuildSaveStorage; k++) {
//                                if (buildingsSaveStorage[k].getType() == itemStorage[itemCorrectStorage[i]][1]) {
//                                    buildingsPut[typeObjectInMiniOption] = new Building(
//                                            -1000,
//                                            -1000,
//                                            itemStorage[itemCorrectStorage[i]][1],
//                                            Constants.BUILDINGNORMAL, false);
//
//                                    for (int j = 0; j < 5; j++) {
//                                        buildingsPut[typeObjectInMiniOption]
//                                                .setSlot(
//                                                        buildingsSaveStorage[k]
//                                                                .getSlot()[j],
//                                                        j);
//                                        buildingsPut[typeObjectInMiniOption]
//                                                .setItemProducing(
//                                                        buildingsSaveStorage[k]
//                                                                .getItemProducing()[j],
//                                                        j);
//                                        buildingsPut[typeObjectInMiniOption]
//                                                .setTimeProductsInSlot(
//                                                        buildingsSaveStorage[k]
//                                                                .getTimeProductsInSlot()[j],
//                                                        j);
//                                    }
//
//                                    buildingsPut[typeObjectInMiniOption]
//                                            .setUpdgrade(buildingsSaveStorage[k]
//                                                    .getUpdgrade());
//
//                                    buildingsPut[typeObjectInMiniOption]
//                                            .setReady(buildingsSaveStorage[k]
//                                                    .isReady());
//                                    buildingsPut[typeObjectInMiniOption]
//                                            .setFlip(buildingsSaveStorage[k]
//                                                    .isFlip());
//                                    buildingsPut[typeObjectInMiniOption]
//                                            .setShowTimeUnderConstruction(buildingsSaveStorage[k]
//                                                    .isShowTimeUnderConstruction());
//                                    buildingsPut[typeObjectInMiniOption]
//                                            .setTimeUnderConstruct(buildingsSaveStorage[k]
//                                                    .getTimeUnderConstruct());
//                                    buildingsPut[typeObjectInMiniOption]
//                                            .setCurrentSlotActive(buildingsSaveStorage[k]
//                                                    .getCurrentSlotActive());
//                                    comeStorage = true;
//
//                                    buildingsSaveStorage[k].setType(-1000);
//                                    // nBuildingsPut ++;
//                                    break;
//                                }
//
//                            }
//                            classObjectToMove = Constants.EARTH_BUILDING;
//                            break;
//                        }
//
//                        itemStorage[itemCorrectStorage[i]][2] -= 1;
//                        totalQuantityStorage -= 1;
//
//                        if (totalQuantityStorage < maxItemStorage) {
//                            storageFull = false;
//                        }
//
//                        stateGame = Constants.STATE_MAIN_GAME;
//
//                        itemToReturnAgain = i;
//
//                        return;
//                    }
//                }
//                // quantityToSell = 1;
//
//                if (storageChosen == itemCorrectStorage[i]) {
//                    if (itemStorage[storageChosen][2] - quantityToSell - 1 >= 0) {
//                        quantityToSell += 1;
//                    }
//
//                } else {
//                    quantityToSell = 1;
//                }
//
//                storageChosen = itemCorrectStorage[i];
//
//                switch (itemStorage[storageChosen][0]) {
//                case Constants.STORAGE_CROPS:
//                    quantityXPSell = quantityToSell
//                            * Constants.CROPS_EXP[itemStorage[storageChosen][1]];
//                    quantityCoinSell = quantityToSell
//                            * Constants.CROPS_MONEY_TO_WIN[itemStorage[storageChosen][1]];
//
//                    if (tutorialGame && stepInAuxTutorial == 0) {
//                        stepInAuxTutorial++;
//                        dissapearMsj = true;
//                    }
//                    break;
//                case Constants.STORAGE_ANIMALS_PRODUCTS:
//                    quantityXPSell = quantityToSell
//                            * Constants.PRODUCT_ANIMAL_INFO[itemStorage[storageChosen][1]][6];
//                    quantityCoinSell = quantityToSell
//                            * Constants.PRODUCT_ANIMAL_INFO[itemStorage[storageChosen][1]][5];
//                    break;
//                case Constants.STORAGE_PRODUCTS:
//                    quantityXPSell = quantityToSell
//                            * getInfoProducts(itemStorage[storageChosen][1], 6);
//                    quantityCoinSell = quantityToSell
//                            * getInfoProducts(itemStorage[storageChosen][1], 7);
//                    break;
//                case Constants.STORAGE_DECORATION:
//                    quantityXPSell = quantityToSell
//                            * Constants.DECORATIONS_INFO[itemStorage[storageChosen][1]][3]
//                            / 2;
//                    quantityCoinSell = quantityToSell
//                            * Constants.DECORATIONS_INFO[itemStorage[storageChosen][1]][4];
//                    break;
//                default:
//                    quantityXPSell = quantityToSell * 10;
//                    quantityCoinSell = quantityToSell * 100;
//                    break;
//                }
//
//                break;
//            }
//            posItem_X += taskItemBackg.getWidth() + diffItem_X;
//            if (i == initItem + 2 || i == initItem + 5) {
//                posItem_X = 10 + buttonArrow.getPosX()
//                        + buttonArrow.getImage().getWidth();
//                ;
//                posItem_Y += taskItemBackg.getHeight() + 5;
//            }
//        }
//
//        if (canSell) {
//
//            if (buttonAddProduct.touch(event) && storageChosen != -1) {
//                itemStorage[storageChosen][2] -= quantityToSell;
//                totalQuantityStorage -= quantityToSell;
//                if (totalQuantityStorage < maxItemStorage) {
//                    storageFull = false;
//                }
//                if (chosenOptionQuestTruck
//                        && aceptQuestTruck
//                        && getQuantityProductInStorage(typeQuest) < quantityQuest) {
//                    canRewardQuestTruck = false;
//                }
//
//                /*if (itemStorage[storageChosen][0] == Constants.STORAGE_CROPS) {
//                    cropsQuantityRecolect[itemStorage[storageChosen][1]] -= quantityToSell;
//                }*/
//
//                assignQuantity(0, 0, 0, 0, 0, quantityCoinSell, quantityXPSell,
//                        mCanvasWidth / 2, mCanvasHeight / 2);
//                storageChosen = -1;
//                if (tutorialGame && stepInAuxTutorial == 2
//                        && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                    stepInAuxTutorial++;
//                    stepTutorial++;
//                    dissapearMsj = false;
//                    // State_Game = Constants.State_InfoTutorial;
//                }
//            }
//        }
//    }
//
//    private int getInfoProducts(int classType, int type) {
//        int info = 0;
//        for (int i = 0; i < Constants.BUILDING_PRODUCTS.length; i++) {
//            if (Constants.BUILDING_PRODUCTS[i][0] == classType) {
//                info = Constants.BUILDING_PRODUCTS[i][type];
//                break;
//            }
//        }
//
//        return info;
//    }
//
//    private void touchBuildProduce(MotionEvent event) {
//        if (buttonBack.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_BACK;
//            timeElementChosen = System.currentTimeMillis();
//            return;
//        }
//
//        int diff = symbolPlus.getWidth() + 8;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 3) / 2;
//        int posY = posButBackgProduce_Y;
//        int quantityNeedCrops = 0;
//        int quantityCurrentCrops = 0;
//        for (int i = 0; i < 2; i++) {
//
//            int type = buildingsPut[buildingChosen].getMaterialProcesing2()[productChosen];
//            if (type == -1) {
//                posX += productItemBackground.getWidth() + diff;
//                // i ++;
//            }
//            buttonAddProduct.setPosX(posX + productItemBackground.getWidth()
//                    / 2 - buttonAddProduct.getImage().getWidth() / 2);
//            buttonAddProduct.setPosY(posY + productItemBackground.getHeight()
//                    - buttonAddProduct.getImage().getHeight());
//            if (buttonAddProduct.touch(event)) {
//
//                if (i == 0) {
//
//                    quantityCurrentCrops = convertStorageToProducts(
//                            buildingsPut[buildingChosen]
//                                    .getMaterialProcesing1()[productChosen],
//                            0);
//                    quantityNeedCrops = buildingsPut[buildingChosen]
//                            .getQuantityMaterialProcesing1()[productChosen];
//                    if (quantityCurrentCrops < quantityNeedCrops) {
//                        if (assignQuantity(
//                                0,
//                                0,
//                                0,
//                                0,
//                                -buildingsPut[buildingChosen]
//                                        .getDiamondAddMaterial_1()[productChosen],
//                                0, 0, mCanvasWidth / 2, mCanvasHeight / 2)) {
//                            convertStorageToProducts(
//                                    buildingsPut[buildingChosen]
//                                            .getMaterialProcesing1()[productChosen],
//                                    1);
//                        }
//                        if (tutorialGame) {
//                            stepInAuxTutorial++;
//                            dissapearMsj = true;
//                        }
//                    }
//                } else {
//                    if (buildingsPut[buildingChosen].getMaterialProcesing2()[productChosen] != -1) {
//                        // productShowInfo =
//                        // buildingsPut[buildingChoosed].getMaterialProcesing2()[prouductChoosed];
//                        quantityCurrentCrops = convertStorageToProducts(
//                                buildingsPut[buildingChosen]
//                                        .getMaterialProcesing2()[productChosen],
//                                0);
//                        quantityNeedCrops = buildingsPut[buildingChosen]
//                                .getQuantityMaterialProcesing2()[productChosen];
//                        if (quantityCurrentCrops < quantityNeedCrops) {
//                            if (assignQuantity(
//                                    0,
//                                    0,
//                                    0,
//                                    0,
//                                    -buildingsPut[buildingChosen]
//                                            .getDiamondAddMaterial_2()[productChosen],
//                                    0, 0, mCanvasWidth / 2, mCanvasHeight / 2)) {
//                                convertStorageToProducts(
//                                        buildingsPut[buildingChosen]
//                                                .getMaterialProcesing2()[productChosen],
//                                        1);
//                            }
//                        }
//                    }
//                }
//
//                break;
//            }
//
//            infoIcon.setPosX(posX + 10);
//            infoIcon.setPosY(posY + 10);
//            if (infoIcon.touch(event)) {
//                elementChosen = (i == 0) ? Constants.PRESS_BUTTON_INFO_1
//                        : Constants.PRESS_BUTTON_INFO_2;
//                timeElementChosen = System.currentTimeMillis();
//                break;
//            }
//
//            posX += productItemBackground.getWidth() + diff;
//        }
//
//        if (buttonProduce.touch(event) && canProduce) {
//
//            elementChosen = Constants.PRESS_BUTTON_PRODUCE;
//            timeElementChosen = System.currentTimeMillis();
//            // prevent user to produce during free time
//            if (tutorialGame && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                // State_Game = Constants.State_InfoTutorial;
//                stepInAuxTutorial++;
//                dissapearMsj = true;
//            }
//        }
//    }
//
//    private void defineQuestTruck() {
//        typeQuest = chooseCropsForMission();
//        quantityQuest = UtilSoftgames.random(5, 15);
//
//        if (nLevel >= 5) {
//            quantityQuest = UtilSoftgames.random(5, 30);
//        } else if (nLevel >= 10) {
//            quantityQuest = UtilSoftgames.random(5, 40);
//        } else if (nLevel >= 15) {
//            quantityQuest = UtilSoftgames.random(5, 50);
//        } else if (nLevel >= 20) {
//            quantityQuest = UtilSoftgames.random(5, 60);
//        }
//
//        if (tutorialGame && stepTutorial < Constants.STEP_TUTORIAL_FIRST_MONEY) {
//            typeQuest = 1;
//            quantityQuest = 10;
//        }
//
//        animationCarTruck = true;
//        canRewardQuestTruck = false;
//        aceptQuestTruck = false;
//
//        rewardCoinTruckJoe = (int) ((Constants.CROPS_EARNING_GOLD[typeQuest] * 1.12) * quantityQuest);
//        rewardXpTruckJoe = (int) (Constants.CROPS_EXP[typeQuest] * 1.12)
//                * quantityQuest;
//
//    }
//    
//    private boolean missionPredefined(int numberMission){
//    	
//    	rewardPaid[numberMission] = false;
//        canRewardMission[numberMission] = false;
//        rewardsCoins[numberMission] = 0;
//        rewardsXP[numberMission] = 0;
//        
//    	switch(currentNumberMission){
//    	case 1: // 3 wheat
//    		// nMission = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//             nTask[numberMission] = 1;
//             typeMission[numberMission][0] = Constants.MISSION_TYPE_CROPS;
//             typeProduct[numberMission][0] = 0;
//             loadProductsImg(typeProduct[numberMission][0]);
//             quantityProduct[numberMission][0] = 3;
//             rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]]
//                     * quantityProduct[numberMission][0];
//             rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]
//                     * quantityProduct[numberMission][0];
//
//            // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//           //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//             diamondsToFinishMission[numberMission] = 6;
//    		return true;
//    	case 2: //plow
//    		//nMission = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//            nTask[numberMission] = 1;
//            typeMission[numberMission][0] = Constants.PLOW;
//            typeProduct[numberMission][0] = 0;
//           
//            quantityProduct[numberMission][0] = 3;
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]]
//                    * quantityProduct[numberMission][1];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]
//                    * quantityProduct[numberMission][0];
//
//           // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//          //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 6;
//    		return true;
//    		
//    	case 3: // 4 corn
//    		nTask[numberMission] = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//            typeMission[numberMission][0] = Constants.MISSION_TYPE_CROPS;
//            typeProduct[numberMission][0] = Constants.CORN;
//            quantityProduct[numberMission][0] = 4;
//            loadProductsImg(typeProduct[numberMission][0]);
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]] * quantityProduct[numberMission][0];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]  * quantityProduct[numberMission][0];
//         
//           // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//          //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 6;
//            return true;
//    	case 4:// 1 egg
//    		 nTask[numberMission] = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//             typeMission[numberMission][0] = Constants.MISSION_PRODUCTANIMAL;
//             typeProduct[numberMission][0] = Constants.EGGS;
//             quantityProduct[numberMission][0] = 1;
//             loadProductsImg(typeProduct[numberMission][0]);
//             rewardsCoins[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][0] - 156][5]) * (1.15))
//             			* quantityProduct[numberMission][0];
//             rewardsXP[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][0] - 156][6]) * (1.15))
//             			* quantityProduct[numberMission][0];
//
//           //  rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//           //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    		
//    	case 5://1 Wheat flower
//    		 nTask[numberMission] = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//             typeMission[numberMission][0] = Constants.MISSION_CREATE_PRODUCT;
//             typeProduct[numberMission][0] = Constants.WHEAT_FLOUR;
//             quantityProduct[numberMission][0] = 1;
//             loadProductsImg(typeProduct[numberMission][0]);
//             
//             rewardsCoins[numberMission] += getInfoProducts(typeProduct[numberMission][0], 7)
//             	* quantityProduct[numberMission][0];
//             rewardsXP[0] += getInfoProducts(typeProduct[numberMission][0], 6)
//             	* quantityProduct[numberMission][0];
//
//
//           //  rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//           //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    		
//    	case 6: //1 milk
//    		 nTask[numberMission] = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//             typeMission[numberMission][0] = Constants.MISSION_PRODUCTANIMAL;
//             typeProduct[numberMission][0] = Constants.MILK;
//             quantityProduct[numberMission][0] = 1;
//             loadProductsImg(typeProduct[numberMission][0]);
//             rewardsCoins[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][0] - 156][5]) * (1.15))
//  				* quantityProduct[numberMission][0];
//             rewardsXP[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][0] - 156][6]) * (1.15))
//  				* quantityProduct[numberMission][0];
//
//            // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//            // rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    	case 7: //blueberry
//    		nTask[numberMission] = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//            typeMission[numberMission][0] = Constants.MISSION_TYPE_CROPS;
//            typeProduct[numberMission][0] = Constants.BLUEBERRY;
//            quantityProduct[numberMission][0] = 5;
//            loadProductsImg(typeProduct[numberMission][0]);
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]] * quantityProduct[numberMission][0];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]  * quantityProduct[numberMission][0];
//          
//
//           // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//           // rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    	case 8: // apple
//    		nTask[numberMission] = 1;
//    		 quantityProductDone[numberMission][0] = 0;
//            typeMission[numberMission][0] = Constants.MISSION_TYPE_CROPS;
//            typeProduct[numberMission][0] = Constants.APPLE;
//            quantityProduct[numberMission][0] = 1;
//            loadProductsImg(typeProduct[numberMission][0]);
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]] * quantityProduct[numberMission][0];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]  * quantityProduct[numberMission][0];
//          
//
//           // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//           // rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    	case 9: // 5 Wheat, 3 corn
//    		nTask[numberMission] = 2;
//    		 quantityProductDone[numberMission][0] = 0;
//            typeMission[numberMission][0] = Constants.MISSION_TYPE_CROPS;
//            typeProduct[numberMission][0] = Constants.WHEAT;
//            quantityProduct[numberMission][0] = 5;
//            loadProductsImg(typeProduct[numberMission][0]);
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]] * quantityProduct[numberMission][0];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]  * quantityProduct[numberMission][0];
//            
//            typeMission[numberMission][1] = Constants.MISSION_TYPE_CROPS;
//            typeProduct[numberMission][1] = Constants.CORN;
//            quantityProduct[numberMission][1] = 3;
//            quantityProductDone[numberMission][1] = 0;
//            loadProductsImg(typeProduct[numberMission][1]);
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][1]] * quantityProduct[numberMission][1];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][1]]  * quantityProduct[numberMission][1];
//
//          //  rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//          //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    	case 10: // 1 Bread & 5x sprinkle water
//    		
//    		 nTask[numberMission] = 2;
//    		 quantityProductDone[numberMission][0] = 0;
//             typeMission[numberMission][0] = Constants.MISSION_CREATE_PRODUCT;
//             typeProduct[numberMission][0] = Constants.BREAD;
//             quantityProduct[numberMission][0] = 1;
//             loadProductsImg(typeProduct[numberMission][0]);
//             
//             rewardsCoins[numberMission] += getInfoProducts(typeProduct[numberMission][0], 7)
//          		* quantityProduct[numberMission][0];
//             rewardsXP[0] += getInfoProducts(typeProduct[numberMission][0], 6)
//          		* quantityProduct[numberMission][0];
//             
//             typeMission[numberMission][1] = Constants.WATERING;
//             typeProduct[numberMission][1] = 0;
//             quantityProductDone[numberMission][1] = 0;
//             loadProductsImg(typeProduct[numberMission][1]);
//             quantityProduct[numberMission][1] = 5;
//             rewardsCoins[numberMission] += 40 * quantityProduct[numberMission][1];
//             rewardsXP[numberMission] += 5 * quantityProduct[numberMission][1];
//           //  rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//           //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//             diamondsToFinishMission[numberMission] = 10;
//    		return true;
//    	case 11: // 5x corn & 2 eggs
//    		//nMission = 1;
//            nTask[numberMission] = 2;
//            quantityProductDone[numberMission][0] = 0;
//            typeMission[numberMission][0] = Constants.MISSION_TYPE_CROPS;
//            typeProduct[numberMission][0] =  Constants.CORN;
//            quantityProduct[numberMission][0] = 5;
//            loadProductsImg(typeProduct[numberMission][0]);
//            rewardsCoins[numberMission] += Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][0]] * quantityProduct[numberMission][0];
//            rewardsXP[numberMission] += Constants.CROPS_EXP[typeProduct[numberMission][0]]  * quantityProduct[numberMission][0];
//
//            
//            typeMission[numberMission][1] = Constants.MISSION_PRODUCTANIMAL;
//            typeProduct[numberMission][1] = 156;
//            quantityProductDone[numberMission][1] = 0;
//            loadProductsImg(typeProduct[numberMission][1]);
//            quantityProduct[numberMission][1] = 2;
//            rewardsCoins[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][1] - 156][5]) * (1.15))
// 				* quantityProduct[numberMission][1];
//            rewardsXP[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][1] - 156][6]) * (1.15))
// 				* quantityProduct[numberMission][1];
//           
//          //  rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//          //  rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 10;
//
//           
//    		return true;
//    	case 12: //Spring Flowers, Wood Pile
//    		
//    		
//            //nMission = 1;
//            nTask[numberMission] = 2;
//            typeProduct[numberMission][0] = 1;
//            typeProduct[numberMission][1] = 2;
//            for(int i = 0; i < 2; i++){
//            	typeMission[numberMission][i] = Constants.MISSION_TYPE_DECO;
//            	 quantityProductDone[numberMission][i] = 0;
//            	quantityProduct[numberMission][i] = 1;
//            	
//            	rewardsCoins[numberMission] += (20 * quantityProduct[numberMission][i]);
//                rewardsXP[numberMission] += (15 * quantityProduct[numberMission][i]);
//
//            }
//         //   rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//        //    rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            diamondsToFinishMission[numberMission] = 8;
//    		return true;
//    	}
//    	
//    	return false;
//    	
//    }
//
//    /*
//     * 1- collect 3 sugar canes 2 - plow 6 fields 3 - grow 5 sugar canes & 4
//     * carrots 4 - water 5 crops 5 - earn 500 gold 6- collect 1 tomato & 3
//     * carrots & 3 sugar canes 7 - remove vegetation
//     */
//    private void defineMission(boolean isCreate) {
//        int backupNMission = 0;
//        // boolean isSecondMission = false;
//        int[] listMissionToChange = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//        if (isCreate) {
//            backupNMission = nMission;
//            listMissionToChange[missionChosen] = 1;
//        }
//        
//        if (tutorialGame) {
//            if (!isCreate) {
//                nMission = 1;
//                nTask[0] = 1;
//                typeMission[0][0] = Constants.MISSION_CREATE_PRODUCT;
//                typeProduct[0][0] = 17;
//                loadProductsImg(typeProduct[0][0]);
//                quantityProduct[0][0] = 1;
//                rewardsCoins[0] += getInfoProducts(typeProduct[0][0], 7)
//                        * quantityProduct[0][0];
//                rewardsXP[0] += getInfoProducts(typeProduct[0][0], 6)
//                        * quantityProduct[0][0];
//                diamondsToFinishMission[0] = 3;
//                return;
//            } else if (stepTutorial == Constants.STEP_TUTORIAL_COLLECT_YOUR_REWARD) {
//                rewardPaid[0] = false;
//                canRewardMission[0] = false;
//                nMission = 1;
//                nTask[0] = 2;
//
//                typeMission[0][0] = Constants.MISSION_CREATE_PRODUCT;
//                typeProduct[0][0] = 17;
//                loadProductsImg(typeProduct[0][0]);
//                quantityProduct[0][0] = 1;
//                rewardsCoins[0] += getInfoProducts(typeProduct[0][0], 7)
//                        * quantityProduct[0][0];
//                rewardsXP[0] += getInfoProducts(typeProduct[0][0], 6)
//                        * quantityProduct[0][0];
//
//                typeMission[0][1] = Constants.MISSION_TYPE_CROPS;
//                typeProduct[0][1] = 0;
//                loadProductsImg(typeProduct[0][1]);
//                quantityProduct[0][1] = 3;
//                rewardsCoins[0] += Constants.CROPS_MONEY_TO_WIN[typeProduct[0][1]]
//                        * quantityProduct[0][1];
//                rewardsXP[0] += Constants.CROPS_EXP[typeProduct[0][1]]
//                        * quantityProduct[0][1];
//
//                diamondsToFinishMission[0] = 6;
//                return;
//            } else if (stepTutorial == Constants.STEP_TUTORIAL_BECOMING_KNOWN) {
//
//               /* rewardPaid[0] = false;
//                canRewardMission[0] = false;
//                nMission = 1;
//                nTask[0] = 1;
//                typeMission[0][0] = Constants.MISSION_PRODUCTANIMAL;
//                typeProduct[0][0] = 156;
//                loadProductsImg(typeProduct[0][0]);
//                quantityProduct[0][0] = 2;
//                rewardsCoins[0] += 40 * quantityProduct[0][0];
//                rewardsXP[0] += 5 * quantityProduct[0][0];
//
//                diamondsToFinishMission[0] = 8;
//                return;*/
//            }
//            /*
//             * Task 1: 7 Corn & 5 Wheat Task 2: 2 Eggs 4 Corn Task 3: 4 Eggs
//             */
//            /* else if (stepTutorial == Constants.STEP_TUTORIAL_CASH_IN_TIME) {
//                
//                for (int i = 0; i < 3; i++) {
//                    canRewardMission[i] = false;
//                    rewardPaid[i] = false;
//                }
//                nMission = 3;
//                nTask[0] = 2;
//                nTask[1] = 2;
//                nTask[2] = 1;
//
//                // Mission 1
//                typeMission[0][0] = Constants.MISSION_TYPE_CROPS;
//                typeProduct[0][0] = 1;
//                loadProductsImg(typeProduct[0][0]);
//                quantityProduct[0][0] = 3;
//                rewardsCoins[0] += Constants.CROPS_MONEY_TO_WIN[typeProduct[0][0]]
//                        * quantityProduct[0][0];
//                rewardsXP[0] += Constants.CROPS_EXP[typeProduct[0][0]]
//                        * quantityProduct[0][0];
//
//                typeMission[0][1] = Constants.MISSION_TYPE_CROPS;
//                typeProduct[0][1] = 0;
//                loadProductsImg(typeProduct[0][1]);
//                quantityProduct[0][1] = 2;
//                rewardsCoins[0] += Constants.CROPS_MONEY_TO_WIN[typeProduct[0][1]]
//                        * quantityProduct[0][1];
//                rewardsXP[0] += Constants.CROPS_EXP[typeProduct[0][1]]
//                        * quantityProduct[0][1];
//
//                // Mission 2
//                typeMission[1][0] = Constants.MISSION_PRODUCTANIMAL;
//                typeProduct[1][0] = 156;
//                loadProductsImg(typeProduct[1][0]);
//                quantityProduct[1][0] = 1;
//                rewardsCoins[1] += 40 * quantityProduct[1][0];
//                rewardsXP[1] += 5 * quantityProduct[1][0];
//
//                typeMission[1][1] = Constants.MISSION_TYPE_CROPS;
//                typeProduct[1][1] = 1;
//                loadProductsImg(typeProduct[1][1]);
//                quantityProduct[1][1] = 2;
//                rewardsCoins[1] += Constants.CROPS_MONEY_TO_WIN[typeProduct[1][1]]
//                        * quantityProduct[1][1];
//                rewardsXP[1] += Constants.CROPS_EXP[typeProduct[1][1]]
//                        * quantityProduct[1][1];
//
//                // Mission 3
//                typeMission[2][0] = Constants.MISSION_PRODUCTANIMAL;
//                typeProduct[2][0] = 156;
//                loadProductsImg(typeProduct[2][0]);
//                quantityProduct[2][0] = 3;
//                rewardsCoins[2] += 40 * quantityProduct[2][0];
//                rewardsXP[2] += 5 * quantityProduct[2][0];
//
//                diamondsToFinishMission[0] = 6;
//                diamondsToFinishMission[1] = 12;
//                diamondsToFinishMission[2] = 9;
//
//                return;
//            }*/
//        }
//
//        if(nLevel < 1){
//			nMission = 3;
//		} else if(nLevel < 2){
//			nMission = 5;
//		}  else if(nLevel < 3){
//			nMission = 5;
//		} else if(nLevel < 4){
//			nMission = 6;
//		} else if(nLevel < 5){
//			nMission = 7;
//		} else if(nLevel < 6){
//			nMission = 8;
//		}  else if(nLevel < 7){
//			nMission = 9;
//		}  else if(nLevel < 10){
//			nMission = 9;
//		} else {
//			nMission = 9;
//		} 
//        
//       
//        
//        if (isCreate && backupNMission != nMission) {
//            for (int z = backupNMission; z < nMission; z++) {
//                listMissionToChange[z] = 1;
//            }
//        }
//        
//        
//       
//
//        int numberTask = 0;
//        int numberMission = 0;
//        boolean isRepeat = false;
//        boolean foundMission = false;
//        do {
//            if (isCreate) {
//                foundMission = false;
//                for (int i = numberMission; i < listMissionToChange.length; i++) {
//                    if (listMissionToChange[i] == 1) {
//                        currentNumberMission++;
//                        numberMission = i;
//                        foundMission = true;
//                        break;
//                    }
//                }
//
//                if (!foundMission) {
//                    return;
//                }
//
//                if(missionPredefined(numberMission)){
//                	numberMission++;
//                	continue;
//                }
//                	 
//                
//                
//               
//            }
//            numberTask = 0;
//
//            rewardPaid[numberMission] = false;
//            canRewardMission[numberMission] = false;
//            diamondsToFinishMission[numberMission] = 0;
//            rewardsCoins[numberMission] = 0;
//            rewardsXP[numberMission] = 0;
//
//            if (nLevel < 1) {
//                nTask[numberMission] = 1;
//            } else if (nLevel <= 4) {
//                nTask[numberMission] = UtilSoftgames.random(1, 2);
//            } else if (nLevel < 6) {
//                nTask[numberMission] = UtilSoftgames.random(1, 3);
//            } else if (nLevel < 8) {
//                nTask[numberMission] = UtilSoftgames.random(1, 4);
//            } else if (nLevel < 10) {
//                nTask[numberMission] = UtilSoftgames.random(2, 5);
//            } else {
//                nTask[numberMission] = UtilSoftgames.random(2, 6);
//            }
//
//            int count2 = 0;
//            do {
//                isRepeat = false;
//                int randMission = UtilSoftgames.random(0, 100);
//                // Probability 12 out of 100
//                if (randMission > 0 && randMission <= 12) {
//                    typeMission[numberMission][numberTask] = Constants.REMOVE_VEGETATIONS;
//                    if (randMission >= 3) {
//                        typeMission[numberMission][numberTask] = Constants.ADD_HELPER;
//                    } else if (randMission >= 6) {
//                        typeMission[numberMission][numberTask] = Constants.NEXT_LEVEL;
//                    } else if (randMission >= 9) {
//                        typeMission[numberMission][numberTask] = Constants.MISSION_TYPE_DECO;
//                    }
//                }
//                // Probability 18 out of 100
//                if (randMission > 12 && randMission <= 30) {
//                    typeMission[numberMission][numberTask] = Constants.PLOW;
//                    if (randMission > 20) {
//                        typeMission[numberMission][numberTask] = Constants.WATERING;
//                    }
//                }
//                // Probability 30 out of 100
//                if (randMission > 30 && randMission <= 65) {
//                    typeMission[numberMission][numberTask] = Constants.MISSION_CREATE_PRODUCT;
//                    if (randMission > 55) {
//                        typeMission[numberMission][numberTask] = Constants.MISSION_TYPE_DECO;
//                    } else if (randMission > 45) {
//                        typeMission[numberMission][numberTask] = Constants.MISSION_PRODUCTANIMAL;
//                    }
//                }
//                // Probability 40 out of 100
//                if (randMission > 65) {
//                    typeMission[numberMission][numberTask] = Constants.MISSION_TYPE_CROPS;
//                }
//
//                switch (typeMission[numberMission][numberTask]) {
//                case Constants.PLOW:
//                case Constants.GET_GOLD:
//                case Constants.NEXT_LEVEL:
//                case Constants.MISSION_TYPE_CROPS:
//                case Constants.MISSION_TYPE_DECO:
//                case Constants.MISSION_CREATE_PRODUCT:
//                case Constants.REMOVE_VEGETATIONS:
//                case Constants.ADD_HELPER:
//                case Constants.WATERING:
//
//                    int t = numberMission;
//                    for (int i = 0; i < nTask[t]; i++) {
//                        if (numberMission == t && i == numberTask) {
//
//                        } else if ((typeMission[numberMission][numberTask] == typeMission[t][i])) {
//                            isRepeat = true;
//                            break;
//                        }
//                    }
//
//                    break;
//
//                }
//
//                count2++;
//                if (count2 == 20) {
//                    count2 = 0;
//                    isRepeat = false;
//                }
//                if (!isRepeat
//                        && !blockTask(typeMission[numberMission][numberTask])) {
//                    count2 = 0;
//                    numberTask++;
//                }
//            } while (numberTask < nTask[numberMission]);
//
//            for (int i = 0; i < nTask[numberMission]; i++) {
//                quantityProductDone[numberMission][i] = 0;
//
//                switch (typeMission[numberMission][i]) {
//                case Constants.MISSION_PRODUCTANIMAL:
//                    boolean isRepeatProductAnimal = true;
//
//                    do {
//
//                        typeProduct[numberMission][i] = chooseMissionCreateAnimalProduct();
//                        isRepeatProductAnimal = false;
//                        int j = numberMission;
//                        for (int g = 0; g < nTask[j]; g++) {
//                            if (numberMission == j && i == g) {
//
//                            } else if (typeProduct[numberMission][i] == typeProduct[j][g]) {
//                                isRepeatProductAnimal = true;
//                                break;
//                            }
//                        }
//
//                    } while (isRepeatProductAnimal);
//
//                    loadProductsImg(typeProduct[numberMission][i]);
//                    quantityProduct[numberMission][i] = UtilSoftgames.random(1,
//                            5);
//
//                    rewardsCoins[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][i] - 156][5]) * (1.07))
//                            * quantityProduct[numberMission][i];
//                    rewardsXP[numberMission] += (int) ((Constants.PRODUCT_ANIMAL_INFO[typeProduct[numberMission][i] - 156][6]) * (1.07))
//                            * quantityProduct[numberMission][i];
//                    break;
//
//                case Constants.MISSION_CREATE_PRODUCT:
//
//                    boolean isRepeatProduct = true;
//                    int count3 = 0;
//                    do {
//
//                        typeProduct[numberMission][i] = chooseMissionCreateProduct();
//                        isRepeatProduct = false;
//                        int j = numberMission;
//                        for (int g = 0; g < nTask[j]; g++) {
//                            if (numberMission == j && i == g) {
//
//                            } else if (typeProduct[numberMission][i] == typeProduct[j][g]) {
//                                isRepeatProduct = true;
//                                break;
//                            }
//                        }
//                        count3++;
//                        if (count3 == 20) {
//                            isRepeatProduct = false;
//                        }
//                    } while (isRepeatProduct);
//
//                    loadProductsImg(typeProduct[numberMission][i]);
//                    quantityProduct[numberMission][i] = UtilSoftgames.random(1,
//                            5);
//                    rewardsCoins[numberMission] += getInfoProducts(
//                            typeProduct[numberMission][i], 7)
//                            * quantityProduct[numberMission][i];
//                    rewardsXP[numberMission] += getInfoProducts(
//                            typeProduct[numberMission][i], 6)
//                            * quantityProduct[numberMission][i];
//                    break;
//
//                case Constants.MISSION_TYPE_CROPS:
//                    int[] validateCrops = chooseCropsForMissionTask();
//                    int[] validateCropsFinal = new int[35];
//                    boolean foundCrops = false;
//                    int index = 0;
//                    for (int h = 0; h < validateCrops.length; h++) {
//                        foundCrops = false;
//                        for (int g = 0; g < i; g++) {
//                            if (validateCrops[h] == typeProduct[numberMission][g]) {
//                                foundCrops = true;
//                                break;
//                            }
//                        }
//                        if (!foundCrops) {
//                            validateCropsFinal[index] = validateCrops[h];
//                            index++;
//                        }
//                    }
//                    typeProduct[numberMission][i] = validateCropsFinal[UtilSoftgames
//                            .random(0, index - 1)];
//
//                    quantityProduct[numberMission][i] = UtilSoftgames.random(1,
//                            10);
//                    rewardsCoins[numberMission] += (Constants.CROPS_MONEY_TO_WIN[typeProduct[numberMission][i]]
//                            * quantityProduct[numberMission][i])* (1.07);
//                    rewardsXP[numberMission] += (Constants.CROPS_EXP[typeProduct[numberMission][i]]
//                            * quantityProduct[numberMission][i])* (1.07);
//
//                    break;
//                case Constants.MISSION_TYPE_ANIMALS:
//
//                    break;
//                case Constants.WATERING:
//                    if (nLevel < 6) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(1, 20);
//                    } else if (nLevel < 11) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(10, 40);
//                    } else if (nLevel < 16) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(20, 60);
//                    } else {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(40, 200);
//                    }
//                 //   if (currentNumberMission == 4) {
//                   //     quantityProduct[numberMission][i] = 5;
//                   // }
//                    rewardsCoins[numberMission] += (5 * quantityProduct[numberMission][i]);
//                    rewardsXP[numberMission] += (1 * quantityProduct[numberMission][i]);
//                    typeProduct[numberMission][i] = 0;
//
//                    break;
//                case Constants.ADD_HELPER:
//                    if (nLevel < 9) {
//                        quantityProduct[numberMission][i] = 1;
//                    } else if (nLevel < 13) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(1, 2);
//                    } else {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(1, 3);
//                    }
//
//                    rewardsCoins[numberMission] += 70 * quantityProduct[numberMission][i];
//                    rewardsXP[numberMission] += 8 * quantityProduct[numberMission][i];
//                    typeProduct[numberMission][i] = 0;
//                    break;
//                case Constants.REMOVE_VEGETATIONS:
//                    if (nLevel < 7) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(1, 2);
//                    } else if (nLevel < 11) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(2, 4);
//                    } else {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(3, 4);
//                    }
//
//                   // if (currentNumberMission == 7) {
//                     //   quantityProduct[numberMission][i] = 1;
//                   // }
//                    rewardsCoins[numberMission] += (100 * quantityProduct[numberMission][i]);
//                    rewardsXP[numberMission] += (15 * quantityProduct[numberMission][i]);
//                    typeProduct[numberMission][i] = 0;
//                    break;
//                case Constants.MISSION_TYPE_DECO:
//                    typeProduct[numberMission][i] = chooseDecorationMission();
//                    quantityProduct[numberMission][i] = UtilSoftgames.random(1,
//                            3);
//                    rewardsCoins[numberMission] += (20 * quantityProduct[numberMission][i]);
//                    rewardsXP[numberMission] += (15 * quantityProduct[numberMission][i]);
//
//
//                    break;
//                case Constants.GET_GOLD:
//                    if (nLevel < 5) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(5, 20);
//                        quantityProduct[numberMission][i] *= 100;
//                    } else if (nLevel < 11) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(20, 60);
//                        quantityProduct[numberMission][i] *= 100;
//                    } else {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(50, 200);
//                        quantityProduct[numberMission][i] *= 100;
//                    }
//
//                   // if (currentNumberMission == 5) {
//                     //   quantityProduct[numberMission][i] = 500;
//                   // }
//                    rewardsCoins[numberMission] += 20 * (quantityProduct[numberMission][i] / 500);
//                    rewardsXP[numberMission] += 2 * (quantityProduct[numberMission][i] / 500);
//                    typeProduct[numberMission][i] = 0;
//                    break;
//                case Constants.NEXT_LEVEL:
//                    quantityProduct[numberMission][i] = 1;
//                    rewardsCoins[numberMission] += (50 * (nLevel + 1) * 0.5);
//                    rewardsXP[numberMission] += (20 * (nLevel + 1) * 0.5);
//                    typeProduct[numberMission][i] = 0;
//                    break;
//                case Constants.PLOW:
//                    if (nLevel < 6) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(1, 20);
//                    } else if (nLevel < 11) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(10, 40);
//                    } else if (nLevel < 16) {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(20, 60);
//                    } else {
//                        quantityProduct[numberMission][i] = UtilSoftgames
//                                .random(40, 200);
//                    }
//
//                //    if (currentNumberMission == 2) {
//                  //      quantityProduct[numberMission][i] = 6;
//                   // }
//
//                    rewardsCoins[numberMission] += (5 * quantityProduct[numberMission][i]);
//                    rewardsXP[numberMission] += (1 * quantityProduct[numberMission][i]);
//                    typeProduct[numberMission][i] = 0;
//                    break;
//                }
//
//                if (quantityProduct[numberMission][i] >= 500) {
//                    diamondsToFinishMission[numberMission] += (quantityProduct[numberMission][i] / 500) * 3;
//                } else {
//                    diamondsToFinishMission[numberMission] += valuesDiamondsFinishMission(
//                            typeMission[numberMission][i],
//                            typeProduct[numberMission][i])
//                            * quantityProduct[numberMission][i];
//                }
//               // rewardsTotalCoins[numberMission] = rewardsCoins[numberMission];
//               // rewardsTotalXP[numberMission] = rewardsXP[numberMission];
//            }
//
//            numberMission++;
//        } while (numberMission < nMission);
//
//    }
//
//    private void defineCharacter() {
//
//        switch (nMission) {
//        case 1:
//            if (missionCharacter[0] == -1) {
//                missionCharacter[0] = 0;
//            }
//            break;
//        case 2:
//            if (missionCharacter[0] == -1) {
//                missionCharacter[0] = 0;
//            }
//            if (missionCharacter[1] == -1) {
//                missionCharacter[1] = 1;
//            }
//            break;
//        case 3:
//            if (missionCharacter[0] == -1) {
//                missionCharacter[0] = 0;
//            }
//            if (missionCharacter[1] == -1) {
//                missionCharacter[1] = 1;
//            }
//
//            if (missionCharacter[2] == -1) {
//                missionCharacter[2] = 2;
//            }
//
//            break;
//        case 4:
//            if (missionCharacter[0] == -1) {
//                missionCharacter[0] = 0;
//            }
//            if (missionCharacter[1] == -1) {
//                missionCharacter[1] = 1;
//            }
//
//            if (missionCharacter[2] == -1) {
//                missionCharacter[2] = UtilSoftgames.random(2, 3);
//            }
//            break;
//
//        default:
//            boolean found = true;
//            int[] missionAvailable = new int[9];
//            int indexMiAvai = 0;
//            for (int j = 0; j < nMission; j++) {
//
//                found = false;
//
//                for (int i = 0; i < 3; i++) {
//                    if (missionCharacter[i] == j) {
//                        found = true;
//                    }
//                }
//
//                if (!found) {
//                    missionAvailable[indexMiAvai] = j;
//                    indexMiAvai++;
//                }
//            }
//            for (int i = 0; i < 3; i++) {
//                if (missionCharacter[i] == -1) {
//                    // while(isRepeat){
//                    int chosen = UtilSoftgames.random(0, indexMiAvai - 1);
//                    missionCharacter[i] = missionAvailable[chosen];
//                    // isRepeat = false;
//                    /*
//                     * for(int h = 0; h < 3; h++){ if(i != h &&
//                     * missionCharacter[h] == missionCharacter[i]){ isRepeat =
//                     * true; break; } }
//                     */
//                    // }
//                }
//            }
//            break;
//        }
//
//        chosenCharacter();
//
//    }
//
//    private void chosenCharacter() {
//        int totalCharacter = 3;
//        // boolean isRepeat = true;
//        if (nMission < 3) {
//            totalCharacter = nMission;
//        }
//
//        int[] characterAvailable = new int[9];
//        int indexMiAvai = 0;
//        boolean found = true;
//        for (int j = 0; j < 7; j++) {
//
//            found = false;
//            for (int i = 0; i < totalCharacter; i++) {
//                if (characterChosen[i] == j || backupCharacterChosen == j) {
//                    found = true;
//                }
//            }
//
//            if (!found) {
//                characterAvailable[indexMiAvai] = j;
//                indexMiAvai++;
//            }
//        }
//
//        for (int i = 0; i < totalCharacter; i++) {
//            if (characterChosen[i] == -1) {
//                int chosen = UtilSoftgames.random(0, indexMiAvai - 1);
//                characterChosen[i] = characterAvailable[chosen];
//            }
//        }
//
//    }
//
//    private int chooseMissionCreateAnimalProduct() {
//        int indexProducts = 0;
//        int[] animalAvailable = new int[7];
//        int posBuilding = 0;
//        animalAvailable[indexProducts] = 0;
//        indexProducts++;
//        for (int i = 1; i < 5; i++) {
//            if (i == 1) {
//                posBuilding = 3;
//            } else if (i == 2) {
//                posBuilding = 5;
//            } else if (i == 3) {
//                posBuilding = 7;
//            } else if (i == 4) {
//                posBuilding = 9;
//            }
//
//            if ((nLevel + 1) >= Constants.BUILDING_AVAILABLE[posBuilding][0]) {
//                animalAvailable[indexProducts] = i;
//                indexProducts++;
//            }
//        }
//
//        int rand = UtilSoftgames.random(0, indexProducts);
//        return animalAvailable[rand] + 156;
//    }
//
//    private int chooseMissionCreateProduct() {
//        int[] possibleProducts = new int[70];
//        int indexProducts = 0;
//        for (int i = 0; i < Constants.BUILDING_ORD.length; i++) {
//            if ((nLevel + 1) >= Constants.BUILDING_AVAILABLE[i][0]) {
//                int startProduct = -1;
//                switch (Constants.BUILDING_ORD[i]) {
//
//                case Constants.BAKERY:
//                    startProduct = 0;
//                    break;
//                case Constants.CAKE:
//                    startProduct = 4;
//                    break;
//                case Constants.DAIRY:
//                    startProduct = 8;
//                    break;
//                case Constants.FRUIT_SMASHER:
//                    startProduct = 12;
//                    break;
//                case Constants.SUGAR_FACTORY:
//                    startProduct = 16;
//                    break;
//                case Constants.GRILL:
//                    startProduct = 20;
//                    break;
//                case Constants.RESTAURANT:
//                    startProduct = 24;
//                    break;
//                case Constants.WEAVING_BUILDING:
//                    startProduct = 28;
//                    break;
//                case Constants.TAILOR:
//                    startProduct = 32;
//                    break;
//                case Constants.WIND_MILL:
//                    startProduct = 36;
//                    break;
//                }
//
//                if (startProduct != -1) {
//                    for (int a = indexProducts; a < indexProducts + 4; a++) {
//                        if (nLevel >= Constants.BUILDING_NEED_UPGRADE[startProduct][4]) {
//                            possibleProducts[a] = Constants.BUILDING_PRODUCTS[startProduct][0];
//                        }
//                        startProduct++;
//                    }
//                    indexProducts += 4;
//                }
//            }
//        }
//        int random = UtilSoftgames.random(0, indexProducts);
//        return possibleProducts[random];
//    }
//
//    private int chooseDecorationMission() {
//        int typeCrops = 0;
//        int[] validates = new int[35];
//        int indexValidate = 0;
//        for (int i = 0; i < iconDecorations.length; i++) {
//            if (nLevel + 1 >= Constants.DECORATIONS_INFO[i][0]) {
//                validates[indexValidate] = i;
//                indexValidate++;
//            }
//        }
//
//        indexValidate--;
//        typeCrops = UtilSoftgames.random(0, indexValidate);
//        return validates[typeCrops];
//    }
//
//    private int valuesDiamondsFinishMission(int type, int posType) {
//        int diamonds = 3;
//        switch (type) {
//
//        case Constants.MISSION_PRODUCTANIMAL:
//            if (Constants.PRODUCT_ANIMAL_INFO[posType - 156][5] < 25) {
//                diamonds = 1;
//            } else if (Constants.PRODUCT_ANIMAL_INFO[posType - 156][5] < 50) {
//                diamonds = 2;
//            } else {
//                diamonds = 3;
//            }
//            break;
//        case Constants.MISSION_CREATE_PRODUCT:
//            if (getInfoProducts(posType, 9) <= 100) {
//                diamonds = 2;
//            } else if (getInfoProducts(posType, 9) <= 200) {
//                diamonds = 5;
//            } else if (getInfoProducts(posType, 9) <= 400) {
//                diamonds = 8;
//            } else if (getInfoProducts(posType, 9) <= 800) {
//                diamonds = 15;
//            } else if (getInfoProducts(posType, 9) <= 1300) {
//                diamonds = 20;
//            } else if (getInfoProducts(posType, 9) <= 2000) {
//                diamonds = 25;
//            } else {
//                diamonds = 40;
//            }
//
//            break;
//        case Constants.MISSION_TYPE_CROPS:
//            if (Constants.CROPS_COINS_TO_PAY[posType] <= 50) {
//                diamonds = 1;
//            } else if (Constants.CROPS_COINS_TO_PAY[posType] <= 90) {
//                diamonds = 2;
//            } else if (Constants.CROPS_COINS_TO_PAY[posType] <= 150) {
//                diamonds = 3;
//            } else if (Constants.CROPS_COINS_TO_PAY[posType] <= 200) {
//                diamonds = 4;
//            } else if (Constants.CROPS_COINS_TO_PAY[posType] <= 350) {
//                diamonds = 5;
//            } else {
//                diamonds = 6;
//            }
//
//            break;
//
//        case Constants.MISSION_TYPE_ANIMALS:
//            diamonds = 3;
//
//            break;
//        case Constants.WATERING:
//            diamonds = 1;
//            break;
//        case Constants.ADD_HELPER:
//            diamonds = 5;
//            break;
//        case Constants.REMOVE_VEGETATIONS:
//            diamonds = 25;
//            break;
//        case Constants.MISSION_TYPE_DECO:
//
//            if (Constants.DECORATIONS_INFO[posType][7] == Constants.GOLD
//                    && Constants.DECORATIONS_INFO[posType][1] <= 500) {
//                diamonds = 10;
//            } else if (Constants.DECORATIONS_INFO[posType][7] == Constants.GOLD
//                    && Constants.DECORATIONS_INFO[posType][1] <= 1500) {
//                diamonds = 20;
//            } else if (Constants.DECORATIONS_INFO[posType][7] == Constants.GOLD
//                    && Constants.DECORATIONS_INFO[posType][1] <= 3000) {
//                diamonds = 30;
//            } else if (Constants.DECORATIONS_INFO[posType][7] == Constants.GOLD
//                    && Constants.DECORATIONS_INFO[posType][1] <= 6000) {
//                diamonds = 50;
//            } else if (Constants.DECORATIONS_INFO[posType][7] == Constants.GOLD
//                    && Constants.DECORATIONS_INFO[posType][1] <= 10000) {
//                diamonds = 50;
//            } else if (Constants.DECORATIONS_INFO[posType][7] == Constants.GOLD) {
//                diamonds = 100;
//            } else if (Constants.DECORATIONS_INFO[posType][7] == Constants.DIAMONDS) {
//                diamonds = Constants.DECORATIONS_INFO[posType][2];
//            }
//
//            break;
//        case Constants.GET_GOLD:
//            break;
//        case Constants.NEXT_LEVEL:
//            diamonds = 25;
//            break;
//        case Constants.PLOW:
//            diamonds = 1;
//            break;
//        }
//
//        return diamonds;
//    }
//
//    private int chooseCropsForMission() {
//        int typeCrops = 0;
//        int[] validates = new int[35];
//        int indexValidate = 0;
//        for (int i = 0; i < Constants.cropsImage.length; i++) {
//            if (nLevel + 1 >= Constants.CROPS_AVAILABLE[i]) {
//                validates[indexValidate] = Constants.CROPS_ORD[i];
//                indexValidate++;
//            }
//        }
//
//        indexValidate--;
//        typeCrops = UtilSoftgames.random(0, indexValidate);
//        return validates[typeCrops];
//    }
//
//    private int[] chooseCropsForMissionTask() {
//        int[] validates = new int[35];
//        int indexValidate = 0;
//        for (int i = 0; i < Constants.cropsImage.length; i++) {
//            if (nLevel + 1 >= Constants.CROPS_AVAILABLE[i]) {
//                validates[indexValidate] = Constants.CROPS_ORD[i];
//                indexValidate++;
//            }
//        }
//
//        indexValidate--;
//
//        return validates;
//    }
//
//    private void touchUpLevel(MotionEvent event) {
//        if (buttonBuild.touch(event)) {
//            if (Utility.mFacebook == null) {
//                Utility.mFacebook = new Facebook(Constants.APP_ID);
//
//            }
//
//            if (!Utility.mFacebook.isSessionValid()) {
//                facebookAction = Constants.FACEBOOK_POST_LEVELUP;
//                Utility.mFacebook.authorize(main, permissions,
//                        Facebook.FORCE_DIALOG_AUTH,
//                        main.gameCanvas.new LoginDialogListener());
//            } else {
//               // main.gameCanvas.postOnMyWall(false, nLevel);
//            	publicInMyWall(false);
//            }
//        }
//
//        int posX = ((mCanvasWidth / 2) + mCanvasWidth / 4)
//                - buttonBuildInactive.getWidth() / 2;
//        int posY = posButtonLevelUp_Y;
//        // Detect the touch event in the continue button
//        if (thereIsTouch(event, posX, posX + buttonBuildInactive.getWidth(),
//                posY, posY + buttonBuildInactive.getHeight())) {
//            elementChosen = Constants.PRESS_BUTTON_CLOSE_GENERAL_BG;
//            timeElementChosen = System.currentTimeMillis();
//        }
//    }
//
//    private void touchUpStateProduced(MotionEvent event) {
//        int diff = 8;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 4) / 2;
//        int posY = 200;
//
//        switch (buildingsPut[buildingChosen].getCurrentStatus()) {
//        case EMPTY:
//            // touchBuildEmpty(event);
//            break;
//        case READY:
//        case PRODUCING:
//        case PRODUCED:
//            touchBuildProduce(event);
//            break;
//        case CHOOSE:
//            buttonUpgrade.setPosX(buttonClose.getPosX()
//                    - buttonUpgrade.getImage().getWidth() - 10);
//            buttonUpgrade.setPosY(buttonClose.getPosY() + 40);
//            if (buttonUpgrade.touch(event)) {
//                if (buildingsPut[buildingChosen].getUpdgrade() + 1 < 5
//                        && buildingsPut[buildingChosen].canUpgrade()) {
//                    stateGame = Constants.STATE_UPGRADE_BUILDING;
//                    loadImages();
//                } else {
//                    typeMsgInfo = TypeMsgInfo.FINISH_PRODUCTION;
//                    timeShowInfoBox = System.currentTimeMillis();
//                }
//            }
//            diff = 10;
//            posX = mCanvasWidth / 2
//                    - ((productItemBackground.getWidth() + diff) * 4) / 2;
//            posY = posButBackgProduce_Y;
//            for (int i = 0; i < 4; i++) {
//                if (thereIsTouch(event, posX,
//                        posX + productItemBackground.getWidth(), posY, posY
//                                + productItemBackground.getHeight())) {
//                    if (buildingsPut[buildingChosen].getUpdgrade() - 1 >= i) {
//                        productChosen = i;
//                        buildingsPut[buildingChosen].changeStatus(1);
//                        if (tutorialGame
//                                && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                            stepTutorial++;
//                            assignStorage(Constants.STORAGE_CROPS, 4, 0);
//                            stepInAuxTutorial += 2;
//                        }
//                    } else {
//                        buttonUpgrade.setPosX(posX
//                                + productItemBackground.getWidth() / 2
//                                - buttonUpgrade.getImage().getWidth() / 2);
//                        buttonUpgrade.setPosY(posY
//                                + productItemBackground.getHeight()
//                                - buttonUpgrade.getImage().getHeight());
//                        if (buttonUpgrade.touch(event)) {
//                            if (buildingsPut[buildingChosen].getUpdgrade() + 1 < 5
//                                    && buildingsPut[buildingChosen]
//                                            .canUpgrade()) {
//                                stateGame = Constants.STATE_UPGRADE_BUILDING;
//                                loadImages();
//                            } else {
//                                typeMsgInfo = TypeMsgInfo.FINISH_PRODUCTION;
//                                timeShowInfoBox = System.currentTimeMillis();
//                            }
//                        }
//                    }
//                }
//
//                posX += productItemBackground.getWidth() + diff;
//            }
//            break;
//        }
//
//        if (touchInMsjStorageFull(event)) {
//            return;
//        }
//        touchInSlot(event);
//
//    }
//
//    private boolean blockTask(int type) {
//        boolean isBlock = false;
//        switch (type) {
//        case Constants.MISSION_TYPE_CROPS:
//            break;
//        case Constants.MISSION_TYPE_ANIMALS:
//            if (nLevel < 4) {
//                isBlock = true;
//            }
//            break;
//        case Constants.GET_GOLD:
//
//            break;
//        case Constants.MISSION_TYPE_DECO:
//
//            if (nLevel < 4) {
//                isBlock = true;
//            }
//            break;
//        case Constants.REMOVE_VEGETATIONS:
//            if (nLevel < 2) {
//                isBlock = true;
//            }
//            break;
//        case Constants.ADD_HELPER:
//            if (nLevel < 4) {
//                isBlock = true;
//            }
//            break;
//        case Constants.MISSION_CREATE_PRODUCT:
//            if (nLevel < 2) {
//                isBlock = true;
//            }
//            break;
//
//        }
//
//        return isBlock;
//    }
//
//    private boolean touchInMsjStorageFull(MotionEvent event) {
//
//        return false;
//    }
//
//    private void touchInSlot(MotionEvent event) {
//        int diff = 15;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackgroundSmall.getWidth() + diff) * 5) / 2;
//        int posY = posSlotProduce_Y;
//
//        for (int i = 0; i < 5; i++) {
//            if (buildingsPut[buildingChosen].getSlot()[i] == 3) {// Done
//                if (thereIsTouch(event,
//                        posX + productItemBackgroundSmall.getWidth() / 2
//                                - buttonCollect.getWidth() / 2, posX
//                                + productItemBackgroundSmall.getWidth() / 2
//                                + buttonCollect.getWidth() / 2, posY
//                                + buttonCollect.getHeight() / 2, posY
//                                + productItemBackgroundSmall.getHeight()
//                                + buttonCollect.getHeight() / 2)) {
//
//                    buildingsPut[buildingChosen].getSlot()[i] = 0;
//                    assignStorage(Constants.STORAGE_PRODUCTS, 1,
//                            buildingsPut[buildingChosen].getItemProducing()[i]);
//                    validateAchievements(Constants.ACHIEVEMENTS_PRODUCTS, 1);
//                    assignQuantity(0, 0, 0, 0, 0, 0, 1, mCanvasWidth / 2,
//                            mCanvasHeight / 2);
//                    if (tutorialGame
//                            && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                        // State_Game = Constants.State_InfoTutorial;
//                        stepTutorial++;
//                        dissapearMsj = false;
//                    }
//
//                }
//            } else if (buildingsPut[buildingChosen].getSlot()[i] == 2) { // Producing
//                if (buildingsPut[buildingChosen].getCurrentSlotActive() == i) {
//                    if (thereIsTouch(event,
//                            posX + productItemBackgroundSmall.getWidth() / 2
//                                    - buttonFinish.getWidth() / 2, posX
//                                    + productItemBackgroundSmall.getWidth() / 2
//                                    + buttonFinish.getWidth() / 2, posY
//                                    + buttonFinish.getHeight() / 2, posY
//                                    + productItemBackgroundSmall.getHeight()
//                                    + buttonFinish.getHeight() / 2)) {
//
//                        if (assignQuantity(0, 0, 0, 0, -1, 0, 0,
//                                mCanvasWidth / 2, mCanvasHeight / 2)) {
//                            buildingsPut[buildingChosen].changeStatus(3);
//                            buildingsPut[buildingChosen].getSlot()[buildingsPut[buildingChosen]
//                                    .getCurrentSlotActive()] = 3;
//                            buildingsPut[buildingChosen].setTimeTranscurrent(0);
//                            for (int h = 0; h < 5; h++) {
//                                if (buildingsPut[buildingChosen].getSlot()[h] == 2) {
//                                    buildingsPut[buildingChosen]
//                                            .setCurrentSlotActive(h);
//                                    break;
//                                }
//                            }
//                            if (tutorialGame
//                                    && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                                stepInAuxTutorial++;
//                            }
//                        }
//                    }
//                }
//            } else if (buildingsPut[buildingChosen].getSlot()[i] == 1) { // block
//                if (thereIsTouch(event, posX,
//                        posX + productItemBackgroundSmall.getWidth(), posY,
//                        posY + productItemBackgroundSmall.getHeight())) {
//                    if (isTransactionPossible(Constants.DIAMONDS, 15)) {
//                        buildingsPut[buildingChosen].getSlot()[i] = 0;
//                        assignQuantity(0, 0, 0, 0, -15, 0, 0, mCanvasWidth / 2,
//                                mCanvasHeight / 2);
//                    }
//                }
//            }
//
//            posX += productItemBackgroundSmall.getWidth() + diff;
//        }
//    }
//
//    private void touchUpMarketCrops(MotionEvent event, int actionType) {
//        if (!canBeDragged) {
//
//            if (moveShop_X > 0) {
//                animationMoveShop = true;
//                contMoveAnimationShop = 0;
//                animationShopLeft = false;
//            } else if (moveShop_X < 0) {
//                animationMoveShop = true;
//                contMoveAnimationShop = 0;
//                animationShopLeft = true;
//            }
//        } else {
//
//            if (actionSelect != Action.PLANT && buttonBack.touch(event)) {
//                elementChosen = Constants.PRESS_BUTTON_BACK;
//                timeElementChosen = System.currentTimeMillis();
//                animationCursor = false;
//                return;
//            }
//
//            if (buttonArrow.touch(event)) {
//                elementChosen = Constants.PRESS_BUTTON_ARROWLEFT;
//                timeElementChosen = System.currentTimeMillis();
//                return;
//            }
//
//            if (buttonArrowRigth.touch(event)) {
//                elementChosen = Constants.PRESS_BUTTON_ARROWRIGHT;
//                timeElementChosen = System.currentTimeMillis();
//                return;
//            }
//
//            boolean canBuy = true;
//
//            int posBackgItemShop_X = mCanvasWidth
//                    / 2
//                    - ((backgroundItemShop.getWidth() + diffItemGeneralShop) * 3)
//                    / 2 - backgroundItemShop.getWidth() + diffItemGeneralShop;
//            int posBackgItemShop_Y = Pos_Init_Market_Y;
//            for (int i = startObjects; i < endObjects; i++) {
//
//                if (i >= 0) {
//
//                    buttonAddProduct.setPosX(posBackgItemShop_X
//                            + backgroundItemShop.getWidth() / 2
//                            - buttonAddProduct.getImage().getWidth() / 2);
//
//                    if (buttonAddProduct.touch(event)
//                            || thereIsTouch(
//                                    event,
//                                    posBackgItemShop_X,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth(),
//                                    posBackgItemShop_Y, posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight())) {
//
//                        switch (actionType) {
//                        case Constants.PRESS_BUTTON_MARKET_DECO:
//                            if ((nLevel + 1) < Constants.DECORATIONS_INFO[i][0]) {
//                                canBuy = false;
//                            }
//                            if (canBuy) {
//                                stateOnlyGreen = true;
//                                typeMsgInfo = TypeMsgInfo.MOVE;
//                                timeShowInfoBox = System.currentTimeMillis();
//                            }
//                            break;
//                        case Constants.PRESS_BUTTON_MARKET_BUILDINGS:
//                            int itemPrice = Constants.BUILDING_PRICE[i][Constants.buildingUsed[i]];
//
//                            if (Constants.buildingUsed[i] < 3
//                                    && (nLevel + 1) < Constants.BUILDING_AVAILABLE[i][Constants.buildingUsed[i]]) {
//                                canBuy = false;
//                            }
//                            if (Constants.buildingUsed[i] == 3) {
//                                canBuy = false;
//                            }
//                            if (!isTransactionPossible(Constants.GOLD,
//                                    itemPrice)) {
//                                canBuy = false;
//                            }
//                            if (canBuy) {
//                                stateOnlyGreen = true;
//                                if (!tutorialGame) {
//                                    typeMsgInfo = TypeMsgInfo.MOVE;
//                                    timeShowInfoBox = System
//                                            .currentTimeMillis();
//                                }
//                            }
//
//                            break;
//                        case Constants.PRESS_BUTTON_MARKET_CROPS:
//                            if ((nLevel + 1) < Constants.CROPS_AVAILABLE[i]) {
//                                canBuy = false;
//                            }
//                            break;
//                        case Constants.PRESS_BUTTON_MARKET_ANIMALS:
//
//                            if (animationCursor && itemToChoose != i) {
//                                canBuy = false;
//                            }
//
//                            break;
//                        }
//
//                        if (canBuy) {
//                            animationCursor = false;
//                            itemSelected = i;
//                            elementChosen = actionType;
//                            timeElementChosen = System.currentTimeMillis();
//                        }
//                        break;
//                    }
//                }
//                posBackgItemShop_X += backgroundItemShop.getWidth()
//                        + diffItemGeneralShop;
//            }
//        }
//    }
//
//    private void touchUpCollections(MotionEvent event) {
//
//        if (!canBeDragged) {
//            animationScrolling = true;
//            if (scrollingLeft) {
//                if (pageCollection + 2 > 20) {
//                    animationScrolling = false;
//                    return;
//                }
//
//            } else {
//                if (pageCollection - 2 < 0) {
//                    animationScrolling = false;
//                    return;
//                }
//            }
//            return;
//        }
//
//        if (buttonBack.touch(event)) {
//            elementChosen = Constants.PRESS_BUTTON_BACK;
//            timeElementChosen = System.currentTimeMillis();
//            return;
//        }
//
//        int posBackg_X = mCanvasWidth / 2 - backgAllCollections.getWidth() / 2;
//        int posBackg_Y = spaceBetBorderBackgrSuper;
//
//        int posXLess = posBackg_X + backgAllCollections.getWidth()
//                - buttonCashIn.getWidth() - 20;
//        int posXBig = posBackg_X + backgAllCollections.getWidth() - 20;
//
//        int posYLess = posBackg_Y + backgAllCollections.getHeight() / 2
//                - buttonCashIn.getHeight() / 2;
//        int posYBig = posBackg_Y + backgAllCollections.getHeight() / 2
//                + buttonCashIn.getHeight() / 2;
//
//        if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//            if (showCashIn(pageCollection)) {
//                payRewardCollect(pageCollection);
//               // stateGame = Constants.STATE_MAIN_GAME;
//            }
//        }
//
//        int diff_Y = backgAllCollections.getHeight() + 20;
//        posYLess += diff_Y;
//        posYBig += diff_Y;
//        if (thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)) {
//            if (showCashIn(pageCollection + 1)) {
//                payRewardCollect(pageCollection + 1);
//              //  stateGame = Constants.STATE_MAIN_GAME;
//            }
//        }
//
//        if (buttonArrow.touch(event)) {
//            // elementChoosed = Constants.PRESS_BUTTON_ARROWLEFT;
//            // Time_ElementChoosed = System.currentTimeMillis();
//            animationScrolling = true;
//            scrollingLeft = false;
//
//            if (pageCollection - 2 < 0) {
//                animationScrolling = false;
//                return;
//            }
//
//            return;
//        }
//
//        if (buttonArrowRigth.touch(event)) {
//            // elementChoosed = Constants.PRESS_BUTTON_ARROWRIGHT;
//            // Time_ElementChoosed = System.currentTimeMillis();
//            animationScrolling = true;
//            scrollingLeft = true;
//            if (pageCollection + 2 > 20) {
//                animationScrolling = false;
//                return;
//            }
//
//            return;
//        }
//    }
//
//    private void payRewardCollect(int type) {
//        int coinReward = 0;
//        int diamondReward = 0;
//        int xpReward = 0;
//        for (int a = 0; a < 6; a += 2) {
//            if (a < Constants.rewardCollection[type].length) {
//                int quantity = Constants.rewardCollection[type][a];
//                switch (Constants.rewardCollection[type][a + 1]) {
//                case Constants.GOLD:
//                    coinReward = quantity;
//                    break;
//                case Constants.DIAMONDS:
//                    diamondReward = quantity;
//                    break;
//                case Constants.XP:
//                    xpReward = quantity;
//                    break;
//                }
//            }
//
//        }
//        assignQuantity(0, 0, 0, 0, diamondReward, coinReward, xpReward,
//                mCanvasWidth / 2, mCanvasHeight / 2);
//
//        for (int i = 0; i < 5; i++) {
//            collectionPut[type].setQuantityItems(
//                    collectionPut[type].getQuantityItems()[i] - 1, i);
//        }
//
//        collectionPut[type].setLevel(collectionPut[type].getLevel() + 1);
//
//    }
//
//    private boolean showCashIn(int type) {
//        boolean show = true;
//
//        int maxCount = 1;
//
//        int cont = 0;
//        for (int i = 0; i < 5; i++) {
//            if (collectionPut[type].getQuantityItems()[i] >= maxCount) {
//                cont++;
//            }
//        }
//        show = (cont == 5) ? true : false;
//        return show;
//    }
//
//    private void touchUpMainMarket(MotionEvent event) {
//        int item_X = mCanvasWidth / 2
//                - ((backgroundItemMarket.getWidth() + spaceBetItem_X) * 3) / 2;
//        int item_Y = spaceBetBorderBackgrSuper;
//        for (int i = 0; i < 6; i++) {
//            if (thereIsTouch(event, item_X,
//                    item_X + backgroundItemMarket.getWidth(), item_Y, item_Y
//                            + backgroundItemMarket.getHeight())) {
//                elementChosen = Constants.PRESS_BUTTON_ITEM_MARKET;
//                itemSelected = i;
//                if (tutorialGame && i == 4) {
//                    itemToChoose = 0;
//
//                    if (stepTutorial != Constants.STEP_TUTORIAL_BECOMING_KNOWN
//                            && stepTutorial == Constants.STEP_TUTORIAL_ENTER_SHOP) {
//                        stepTutorial++;
//                        dissapearMsj = false;
//                    }
//                }
//
//                startObjects = -1;
//                endObjects = 4;
//                timeElementChosen = System.currentTimeMillis();
//            }
//
//            item_X += backgroundItemMarket.getWidth() + spaceBetItem_X;
//            if (i == 2) {
//                item_X = mCanvasWidth
//                        / 2
//                        - ((backgroundItemMarket.getWidth() + spaceBetItem_X) * 3)
//                        / 2;
//                item_Y += backgroundItemMarket.getHeight() + spaceBetItem_Y;
//            }
//
//        }
//    }
//
//    private boolean touchInExpansion(MotionEvent event, int[][] touch) {
//
//        if (stateOnlyGreen) {
//            return false;
//        }
//
//        int tiledAdd = 6;
//        int posX = touch[0][0] - 3 - tiledAdd;
//        int posY = touch[0][1] - 3 - tiledAdd;
//
//        if (mapExpansion[(int) posY / 4][(int) posX / 4] == 1
//                && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//            if (stateOnlyGreen) {
//                typeMsgInfo = TypeMsgInfo.MOVEBAD;
//                timeShowInfoBox = System.currentTimeMillis();
//                return false;
//            }
//            stateGame = Constants.STATE_QUEST_EXPANSION;
//            loadImages();
//            initExpand_X = (((int) posX / 4) * 4) + 3 + tiledAdd;
//            initExpand_Y = (((int) posY / 4) * 4) + 3 + tiledAdd;
//            return true;
//        }
//
//        return false;
//    }
//
//    private boolean touchInTileProhib(int[][] touch) {
//
//        if (touch[0][0] <= MAT_INF_X || touch[0][0] >= MAT_SUP_X) {
//            return true;
//        }
//        if (touch[0][1] <= MAT_INF_Y || touch[0][1] >= MAT_SUP_Y) {
//            return true;
//        }
//
//        int nTiledAdd = 6;
//        int[] tiledProhiben_X = { 15, 16, 17, 18, 19, 20, 21, 22, 15, 16 };
//        int[] tiledProhiben_Y = { 14, 14, 14, 14, 14, 14, 14, 14, 13, 13 };
//        for (int i = 0; i < tiledProhiben_Y.length; i++) {
//            if (touch[0][0] == tiledProhiben_X[i] + nTiledAdd
//                    && touch[0][1] == tiledProhiben_Y[i] + nTiledAdd) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean touchInDecoration(int[][] touch, boolean holdPressed) {
//        for (int i = 0; i < nDecorationsPut; i++) {
//            if (decorationsPut[i].getPos_X() == touch[0][0]
//                    && decorationsPut[i].getPos_Y() == touch[0][1]) {
//                if (holdPressed && !decorationsPut[i].isMenuRotate()) {
//                    decorationsPut[i].setMenuRotate(true);
//                    stateOnlyGreen = true;
//                    typeMsgInfo = TypeMsgInfo.MOVE;
//                    timeShowInfoBox = System.currentTimeMillis();
//                }
//
//                decorationChosen = i;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean touchInCrops(int[][] touch, boolean holdPressed) {
//
//        if (stateOnlyGreen) {
//            return false;
//        }
//
//        for (int i = 0; i < NTree; i++) {
//            if (tree[i].getPosX() == touch[0][0]
//                    && tree[i].getPosY() == touch[0][1]) {
//
//                if (holdPressed && !tree[i].isMenuRotate()) {
//                    tree[i].setMenuRotate(true);
//                    stateOnlyGreen = true;
//                    msgSelect = null;
//                    typeMsgInfo = TypeMsgInfo.MOVE;
//                    timeShowInfoBox = System.currentTimeMillis();
//                }
//
//                cropChosen = i;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean touchInAnimal(MotionEvent event, int[][] touch,
//            boolean holdPressed) {
//        if (stateOnlyGreen) {
//            return false;
//        }
//        for (int i = 0; i < nAnimalsPut; i++) {
//            if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_HUNGRY
//                    && !touchRepeated(animalsPut[i].getPos_X(),
//                            animalsPut[i].getPos_Y())) {
//
//                int[] posAnimal = calculatePosInitialMap(
//                        animalsPut[i].getPos_X(), animalsPut[i].getPos_Y());
//
//                int posAnimal_X = posAnimal[0] + World.posWorldX;
//                int posAnimal_Y = posAnimal[1] + World.posWorldY;
//
//                int posIconProduct_X = posAnimal_X + World.tamTiledX / 2
//                        - Constants.cloudEmpty.getWidth() / 2;
//                int posIconProduct_Y = posAnimal_Y
//                        - Constants.cloudEmpty.getHeight();
//
//                if (event == null)
//                    return false;
//                if (thereIsTouch(event, posIconProduct_X, posIconProduct_X
//                        + Constants.cloudEmpty.getWidth(), posIconProduct_Y,
//                        posIconProduct_Y + Constants.cloudEmpty.getHeight())
//                        || (animalsPut[i].getPos_X() == touch[0][0] && animalsPut[i]
//                                .getPos_Y() == touch[0][1])) {
//                    actionAnimal(i, holdPressed, 0);
//                    // collectionForAnimal(animalsPut[i].getType(),
//                    // animalsPut[i].getPos_X(), animalsPut[i].getPos_Y());
//                    return true;
//                }
//
//            } else if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_READY
//                    && !touchRepeated(animalsPut[i].getPos_X(),
//                            animalsPut[i].getPos_Y())) {
//
//                int[] posAnimal = calculatePosInitialMap(
//                        animalsPut[i].getPos_X(), animalsPut[i].getPos_Y());
//
//                int posAnimal_X = posAnimal[0] + World.posWorldX;
//                int posAnimal_Y = posAnimal[1] + World.posWorldY;
//
//                int posIconProduct_X = posAnimal_X
//                        + World.tamTiledX
//                        / 2
//                        - Constants.productByAnimals[animalsPut[i].getType()]
//                                .getWidth() / 2;
//                int posIconProduct_Y = posAnimal_Y
//                        + World.tamTiledY
//                        / 2
//                        - (int) (Constants.animalsProducing[animalsPut[i]
//                                .getType()][0].getHeight() * World.mScaleFactor)
//                        + 5
//                        - Constants.productByAnimals[animalsPut[i].getType()]
//                                .getHeight();
//
//                if (event == null)
//                    return false;
//                if (thereIsTouch(
//                        event,
//                        posIconProduct_X,
//                        posIconProduct_X
//                                + Constants.productByAnimals[animalsPut[i]
//                                        .getType()].getWidth(),
//                        posIconProduct_Y,
//                        posIconProduct_Y
//                                + Constants.productByAnimals[animalsPut[i]
//                                        .getType()].getHeight())
//                        || (animalsPut[i].getPos_X() == touch[0][0] && animalsPut[i]
//                                .getPos_Y() == touch[0][1])) {
//                    actionAnimal(i, holdPressed, 0);
//
//                    return true;
//                }
//
//            }
//        }
//
//        for (int i = 0; i < nAnimalsPut; i++) {
//            // animalsPut[i].setSelected(false);
//            if ((animalsPut[i].getPos_X() == touch[0][0] && animalsPut[i]
//                    .getPos_Y() == touch[0][1])) {
//                orderAnimalChosen = 0;
//                actionAnimal(i, holdPressed, 0);
//
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void actionAnimal(int type, boolean holdPressed, int position) {
//        if (animalsPut[type].getStatus() == Constants.STATUS_ANIMALS_READY) {
//            /*if (totalQuantityStorage + 1 > maxItemStorage) {
//                storageFull = true;
//                stateGame = Constants.STATE_POP_STORAGE_FULL;
//                return;
//            }*/
//        	if(isStorageFull(1)){
//        		return;
//        	}
//            soundAnimal(animalsPut[type].getType());
//            assignStorage(Constants.STORAGE_ANIMALS_PRODUCTS, 1,
//                    animalsPut[type].getType());
//            restValueMission(Constants.MISSION_PRODUCTANIMAL,
//                    animalsPut[type].getType() + 156);// Buque
//            animalsPut[type].setStatus(Constants.STATUS_ANIMALS_HUNGRY);
//            switch (animalsPut[type].getType()) {
//            case 0:
//                showProductAnimal = 1;
//                validateAchievements(Constants.ACHIEVEMENTS_EGGS, 1);
//                break;
//            case 1:
//                showProductAnimal = 2;
//                validateAchievements(Constants.ACHIEVEMENTS_MILK, 1);
//                break;
//            case 2:
//                showProductAnimal = 3;
//                validateAchievements(Constants.ACHIEVEMENTS_WOOL, 1);
//                break;
//            case 3:
//                showProductAnimal = 4;
//                validateAchievements(Constants.ACHIEVEMENTS_BACON, 1);
//                break;
//            case 4:
//                showProductAnimal = 5;
//                validateAchievements(Constants.ACHIEVEMENTS_GOAT_MILK, 1);
//                break;
//
//            }
//
//            int[] posAni = getTiledInAnimal(type, position);
//            posAni = calculatePosInitialMap(posAni[0], posAni[1]);
//
//            assignQuantity(0, showProductAnimal, 0, 0, 0, 0,
//                    Constants.ANIMALS_XP_RECOLLECT[animalsPut[type].getType()],
//                    posAni[0] + World.posWorldX - World.tamTiledX / 2,
//                    posAni[1] + World.posWorldY - World.tamTiledY / 2);
//
//            collectionForAnimal(animalsPut[type].getType(),
//                    animalsPut[type].getPos_X(), animalsPut[type].getPos_Y());
//            if (tutorialGame) {
//
//                if (stepTutorial == Constants.STEP_TUTORIAL_FIRST_EGG) {
//                    animalsPut[1].setStatus(Constants.STATUS_ANIMALS_READY);
//                    animalsPut[1].setProducing(false);
//                    animalsPut[1]
//                            .setTimeTranscurrentProducing(Constants.PRODUCT_ANIMAL_INFO[animalsPut[0]
//                                    .getType()][3]);
//                    animalsPut[1].setSelected(false);
//                }
//                stepTutorial++;
//                dissapearMsj = false;
//
//            }
//
//        } else if (animalsPut[type].getStatus() == Constants.STATUS_ANIMALS_WORKING) {
//            soundAnimal(animalsPut[type].getType());
//            animalsPut[type].setProducing(true);
//            dissapearMsj = true;
//            for (int i = 0; i < nAnimalsPut; i++) {
//                animalsPut[i].setSelected(false);
//            }
//            animalsPut[type].setSelected(true);
//            currentMultitouch = 0;
//            indexMultitouch = 0;
//        } else if (animalsPut[type].isReady() && holdPressed
//                && !animalsPut[type].isMenuRotate()) {
//            // animalsPut[type].setMenuRotate(true);
//            // animalsPut[type].setSelected(true);
//            // animalsPut[type].setOpenMenu(false);
//        } else {
//            if (!holdPressed && !animalsPut[type].isMenuRotate()
//                    && animalsPut[type].isReady()) {
//                // animalsPut[type].setOpenMenu(true);
//                // animalsPut[type].setSelected(true);
//                if (animalsPut[type].getStatus() == Constants.STATUS_ANIMALS_HUNGRY) {
//                    int[] posit = getTiledInAnimal(type, orderAnimalChosen);
//                    if (!touchRepeated(posit[0], posit[1])) {
//                        actionSelect = Action.ANIMAL_FOOD;
//                        multitouch_X[indexMultitouch] = posit[0];
//                        multitouch_Y[indexMultitouch] = posit[1];
//                        indexMultitouch++;
//
//                    }
//
//                }
//            } else if (!animalsPut[type].isReady()) {
//                animalsPut[type].setShowTimeUnderConstruction(true);
//            }
//        }
//        animalChosen = type;
//    }
//
//    private boolean touchInUIMain(MotionEvent event) {
//
//        if (panelCoins.touch(event)) {
//           stateGame = Constants.STATE_MORE_COINS;
//            loadImages();
//        	  
//            return true;
//        }
//
//        if (panelDiamonds.touch(event)) {
//            stateGame = Constants.STATE_MORE_DIAMONDS;
//            loadImages();
//            return true;
//        }
//
//        if (panelSeeds.touch(event)) {
//            if (isStepFreeTutorial()) {
//                return false;
//            }
//            stateGame = Constants.STATE_NOFOOD;
//            loadImages();
//            return true;
//        }
//
//        if (iconMission.touch(event)) {
//            if (isStepFreeTutorial()) {
//                return false;
//            }
//            elementChosen = Constants.PRESS_BUTTON_MISSION;
//            timeElementChosen = System.currentTimeMillis();
//            openMission = true;
//            return true;
//        }
//
//        int posCharacter_Y = characterOffsetY;
//        for (int i = 0; i < 3; i++) {
//            if (characterChosen[i] != -1) {
//
//                if (tutorialGame
//                        && (stepTutorial == Constants.STEP_TUTORIAL_FREE
//                                || stepTutorial == Constants.STEP_TUTORIAL_GET_SPECIAL_TASKS
//                                || stepTutorial == Constants.STEP_TUTORIAL_CONGRATULATIONS || stepTutorial == Constants.STEP_TUTORIAL_PLACE_ON_YARD)) {
//                    return false;
//                }
//
//                if (thereIsTouch(event, 0, iconCharacter[0].getWidth(),
//                        posCharacter_Y,
//                        posCharacter_Y + iconCharacter[0].getHeight())) {
//
//                    if (isStepFreeTutorial()) {
//                        return false;
//                    }
//
//                    stateGame = Constants.STATE_CHARACTER_MISSION;
//                    indexCharacterChosen = i;
//                    loadImages();
//                    if (tutorialGame
//                            && stepTutorial == Constants.STEP_TUTORIAL_FARM_FRIENDS) {
//                        stepTutorial++;
//                    }
//
//                    return true;
//                }
//            }
//
//            posCharacter_Y += iconCharacter[0].getHeight() + 15;
//        }
//
//        if (iconHelper.touch(event)) {
//            if (isStepFreeTutorial()) {
//                return false;
//            }
//            stateGame = Constants.STATE_FACEBOOK;
//            if (Utility.mFacebook == null) {
//                Utility.mFacebook = new Facebook(Constants.APP_ID);
//                Utility.mAsyncRunner = new AsyncFacebookRunner(
//                        Utility.mFacebook);
//            }
//            loadImages();
//            return true;
//        }
//
//        if (runningBonus) {
//            int posTimePromotion_X = mCanvasWidth
//                    - iconTimePromotion.getWidth();
//
//            if (thereIsTouch(event, posTimePromotion_X, posTimePromotion_X
//                    + iconTimePromotion.getWidth(), iconHelper.getPosY()
//                    + iconHelper.getImage().getHeight() + 5,
//                    iconHelper.getPosY() + iconHelper.getImage().getHeight()
//                            + 5 + iconTimePromotion.getHeight())) {
//                stateGame = Constants.STATE_PROMOTION;
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    private boolean isStepFreeTutorial() {
//        if (tutorialGame && stepTutorial == Constants.STEP_TUTORIAL_FREE) {
//            typeMsgInfo = TypeMsgInfo.LEVEL_UP_FIRST;
//            timeShowInfoBox = System.currentTimeMillis();
//            return true;
//        }
//        return false;
//    }
//
//    public void sound(Context mContext, int type) {
//       // SoundUtil.playSound2(mContext, type, main);
//    //	int origionalVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//    //	mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
//    	
//    	
//    	mySoundEffects.play(getTypeSound(type), 0.6F, 1.0F, 1, 0, 1.0F);
//    }
//    
//    public int getTypeSound(int type){
//    	int sound = 0;
// 	   switch (type) {
//        
//
//        case SoundUtil.SOUND_MISSION_COMPLETE:
//     	   sound = SOUND_MISSION_COMPLETE;
//            break;
//
//        case SoundUtil.SOUND_LEVEL_UP:
//     	   sound = SOUND_LEVEL_UP;
//            break;
//
//        case SoundUtil.SOUND_ACHIEVEMENT_COMPLETE:
//     	   sound = SOUND_ACHIEVEMENT_COMPLETE;
//            break;
//
//        case SoundUtil.SOUND_CONSTRUCTION_PLACED:
//     	     sound = SOUND_CONSTRUCTION_PLACED;
//            break;
//        case SoundUtil.SOUND_FEED_ANIMAL:
//     	   sound = SOUND_FEED_ANIMAL;
//            break;
//        case SoundUtil.SOUND_CONSTRUCTION_BOOST:
//     	   sound = SOUND_CONSTRUCTION_BOOST;
//            break;
//        case SoundUtil.SOUND_CONSTRUCTION_FINISHED:
//     	   sound = SOUND_CONSTRUCTION_FINISHED;
//            break;
//
//        case SoundUtil.SOUND_RANDOM_BACKGROUND_SOUND:
//     	   sound = SOUND_RANDOM_BACKGROUND_SOUND;
//            break;
//        case SoundUtil.SOUND_RANDOM_BACKGROUND_SOUND2:
//     	   sound = SOUND_RANDOM_BACKGROUND_SOUND2;
//            break;
//        case SoundUtil.SOUND_RANDOM_BACKGROUND_SOUND3:
//     	   sound = SOUND_RANDOM_BACKGROUND_SOUND3;
//            break;
//
//        case SoundUtil.SOUND_BAKERY:
//     	   sound = SOUND_BAKERY;
//            break;
//        case SoundUtil.SOUND_CAKESHOP:
//     	   sound = SOUND_CAKESHOP;
//            break;
//        case SoundUtil.SOUND_ANIMAL_FOODMACHINE:
//     	   sound = SOUND_ANIMAL_FOODMACHINE;
//            break;
//        case SoundUtil.SOUND_DAIRY:
//     	   sound = SOUND_DAIRY;
//            break;
//
//        case SoundUtil.SOUND_SUGARFACTORY:
//     	   sound = SOUND_SUGARFACTORY;
//            break;
//        case SoundUtil.SOUND_TAILOR:
//     	   sound = SOUND_TAILOR;
//            break;
//        case SoundUtil.SOUND_WEAVING:
//     	   sound = SOUND_WEAVING;
//            break;
//        case SoundUtil.SOUND_MILL:
//     	   sound = SOUND_MILL;
//            break;
//        case SoundUtil.SOUND_GRILL:
//     	   sound = SOUND_GRILL;
//            break;
//        case SoundUtil.SOUND_GOURMET:
//     	   sound = SOUND_GOURMET;
//            break;
//        case SoundUtil.SOUND_JUICERY:
//     	   sound = SOUND_JUICERY;
//            break;
//
//        case SoundUtil.SOUND_CHICKEN:
//     	   sound = SOUND_CHICKEN;
//            break;
//        case SoundUtil.SOUND_COW:
//     	   sound = SOUND_COW;
//            break;
//        case SoundUtil.SOUND_SHEEP:
//     	   sound = SOUND_SHEEP;
//            break;
//        case SoundUtil.SOUND_PIG:
//     	   sound = SOUND_PIG;
//            break;
//        case SoundUtil.SOUND_GOAT:
//     	   sound = SOUND_GOAT;
//            break;
//
//        case SoundUtil.SOUND_EARNED_GOLD:
//     	   sound = SOUND_EARNED_GOLD;
//            break;
//        case SoundUtil.SOUND_EARNED_DIAMONDS:
//     	   sound = SOUND_EARNED_DIAMONDS;
//            break;
//        case SoundUtil.SOUND_EARNED_XP:
//     	   sound = SOUND_EARNED_XP;
//            break;
//        case SoundUtil.SOUND_SPENT_DIAMONDS:
//     	   sound = SOUND_SPENT_DIAMONDS;
//            break;
//        case SoundUtil.SOUND_SPENT_GOLD:
//     	   sound = SOUND_SPENT_GOLD;
//            break;
//        case SoundUtil.SOUND_PLOW:
//     	   sound = SOUND_PLOW;
//            break;
//        case SoundUtil.SOUND_HARVEST:
//     	   sound = SOUND_HARVEST;
//            break;
//        case SoundUtil.SOUND_PLANT:
//     	   sound = SOUND_PLANT;
//            break;
//        case SoundUtil.SOUND_CLICK:
//     	   sound = SOUND_CLICK;
//            break;
//        case SoundUtil.SOUND_BUILDING_UPGRADE:
//     	   sound = SOUND_BUILDING_UPGRADE;
//            break;
//        case SoundUtil.SOUND_REMOVE_GRASS:
//     	   sound = SOUND_REMOVE_GRASS;
//            break;
//        case SoundUtil.SOUND_REMOVE_STONE:
//     	   sound = SOUND_REMOVE_STONE;
//            break;
//        case SoundUtil.SOUND_REMOVE_TREE:
//     	   sound = SOUND_REMOVE_TREE;
//            break;
//
//        case SoundUtil.SOUND_AREA_UNLOCKED:
//     	   sound = SOUND_AREA_UNLOCKED;
//            break;
//        }
// 	   return sound;
//    }
//
//    private void soundManinGame() {
//        if (System.currentTimeMillis() - timeSoundGame >= 90000) {
//            timeSoundGame = System.currentTimeMillis();
//            SoundUtil.soundManinGame(mContext, main);
//            
//            if(!openMission){
//            	animationHelpMe = true;
//            	indexAnimationHelpMe = UtilSoftgames.random(0, 2);
//            }
//            
//            openMission = false;
//        }
//    }
//
//    private void soundAnimal(int type) {
//        SoundUtil.soundAnimal(mContext, type, main);
//    }
//
//    private void soundBuilding(int type) {
//        SoundUtil.soundBuilding(mContext, type, main);
//    }
//
//    private void positionWorldInZoom(int tiledX, int tiledY, int[] pos) {
//
//        // System.out.println("antes pos "+ pos[0] + "y " + pos[1]);
//        int posInitialX = pos[0] + World.posWorldX;
//        int posInitialY = pos[1] + World.posWorldY;
//        // System.out.println("des pos "+ posInitialX + "y " + posInitialY);
//
//        posInitialX -= (World.tamTiledX / 2) * (tiledX + 1);
//        posInitialY -= (World.tamTiledY / 2) * (tiledX + 1);
//        /*
//         * for(int i = tiledX; i >= 0; i--){
//         * 
//         * posInitialX -= Constants.Tam_Tiled_X/2; posInitialY -=
//         * Constants.Tam_Tiled_Y/2; }
//         */
//
//        posInitialX += (World.tamTiledX / 2) * (tiledY + 1);
//        posInitialY -= (World.tamTiledY / 2) * (tiledY + 1);
//
//        /*
//         * for(int i = tiledY; i >= 0; i--){
//         * 
//         * posInitialX += Constants.Tam_Tiled_X/2; posInitialY -=
//         * Constants.Tam_Tiled_Y/2; }
//         */
//
//        World.posWorldX = posInitialX
//                - (mCanvasWidth / 2 - World.tamTiledX / 2);
//        World.posWorldY = posInitialY + World.tamTiledY;
//    }
//
//    private boolean touchInBuilding(int[][] touch, boolean holdPressed) {
//
//        if (stateOnlyGreen) {
//            return false;
//        }
//
//        for (int i = 0; i < nBuildingsPut; i++) {
//            if (buildingsPut[i].getPosX() == touch[0][0]
//                    && buildingsPut[i].getPosY() == touch[0][1]
//                    || (buildingsPut[i].isFourSpace() && (buildingsPut[i]
//                            .getPosX_1() == touch[0][0]
//                            && buildingsPut[i].getPosY_1() == touch[0][1]
//                            || buildingsPut[i].getPosX_2() == touch[0][0]
//                            && buildingsPut[i].getPosY_2() == touch[0][1] || buildingsPut[i]
//                            .getPosX_3() == touch[0][0]
//                            && buildingsPut[i].getPosY_3() == touch[0][1]))) {
//                buildingChosen = i;
//
//                switch (buildingsPut[i].getClassType()) {
//
//                case Constants.BUILDINGNORMAL:
//                    if (holdPressed && !buildingsPut[i].isMenuRotate()
//                            && buildingsPut[i].getType() <= Constants.TAILOR) {
//                        buildingsPut[i].setMenuRotate(true);
//                        buildingsPut[i].setShowTimeUnderConstruction(false);
//                        stateOnlyGreen = true;
//                        typeMsgInfo = TypeMsgInfo.MOVE;
//                        timeShowInfoBox = System.currentTimeMillis();
//                        // buildingsPut[i].setOpenMenu(false);
//                    } else {
//                        if (!holdPressed && !buildingsPut[i].isMenuRotate()
//                                && buildingsPut[i].isReady()) {
//                            for (int a = 0; a < 5; a++) {
//                                if (buildingsPut[i].getSlot()[a] == 3) {
//                                    
//                                    
//                                	if(!isStorageFull(1)){
//                                		 assignStorage(Constants.STORAGE_PRODUCTS,
//                                            1,
//                                            buildingsPut[buildingChosen]
//                                                    .getItemProducing()[a]);
//                                   
//                                    	typeIconProduced = buildingsPut[i]
//                                                                        .getItemProducing()[a];
//                                    	
//                                    	  buildingsPut[buildingChosen].getSlot()[a] = 0;
//                                    	  
//                                    	validateAchievements(
//                                            Constants.ACHIEVEMENTS_PRODUCTS, 1);
//                                    	int[] posit = calculatePosInitialMap(
//                                            touch[0][0], touch[0][1]);
//                                    	int xpWon = 0;
//                                    	
//                                    	try {
//                                    		xpWon = Constants.BUILDING_PRODUCTS[buildingsPut[buildingChosen]
//                                                .getPosOrderInfos() + a][5];
//                                    	} catch (Exception e) {
//                                    		Log.e(TAG,
//                                                "touchInBuilding - case: BUILDINGNORMAL",
//                                                e);
//                                    	}
//                                    	
//                                    	assignQuantity(0, 0, 1, 0, 0, 0, xpWon,
//                                            posit[0] + World.posWorldX,
//                                            posit[1] + World.posWorldY);
//
//                                    	collectionForBuilding(
//                                            buildingsPut[i].getType(),
//                                            buildingsPut[i].getPosX(),
//                                            buildingsPut[i].getPosY());
//                                    }
//                                    return true;
//                                }
//                            }
//                            // buildingsPut[i].setOpenMenu(true);
//                            buildingChosen = i;
//                            soundBuilding(buildingsPut[buildingChosen]
//                                    .getType());
//                            stateGame = Constants.STATE_PRODUCTION;
//                            buildingsPut[buildingChosen].changeStatus(4);
//                            loadImages();
//                            for (int f = 0; f < 4; f++) {
//                                loadProductsImg(buildingsPut[buildingChosen]
//                                        .getItemProduce()[f]);
//                                loadProductsImg(buildingsPut[buildingChosen]
//                                        .getMaterialProcesing1()[f]);
//                                loadProductsImg(buildingsPut[buildingChosen]
//                                        .getMaterialProcesing2()[f]);
//                            }
//
//                            if (tutorialGame) {
//                                if (stepTutorial == Constants.STEP_TUTORIAL_WIND_MILL_AND_FLOUR) {
//                                    stepTutorial++;
//                                    
//                                }
//                            }
//
//                        } else if (!holdPressed) {
//                            if (!buildingsPut[i].isOpenBuilding()) {
//                                buildingsPut[i]
//                                        .setShowTimeUnderConstruction(true);
//                                dissapearMsj = true;
//                            } else {
//                                int[] pos = calculatePosInitialMap(
//                                        buildingsPut[i].getPosX(),
//                                        buildingsPut[i].getPosY());
//
//                                inicializateAnimationCloud(pos[0]
//                                        + World.posWorldX, pos[1]
//                                        + World.posWorldY);
//                                buildingsPut[i].setReady(true);
//
//                                validateAchievements(
//                                        Constants.ACHIEVEMENTS_BUILDING, 1);
//                                buildingsPut[buildingChosen]
//                                        .setUpdgrade(buildingsPut[buildingChosen]
//                                                .getUpdgrade() + 1);
//                                if (Constants.buildings[Constants.BUILDING_ORD[buildingsPut[buildingChosen]
//                                        .getType()]][buildingsPut[buildingChosen]
//                                        .getUpdgrade() - 1] == null) {
//                                    loadBuildingsImg(
//                                            Constants.BUILDING_ORD[buildingsPut[buildingChosen]
//                                                    .getType()],
//                                            buildingsPut[buildingChosen]
//                                                    .getUpdgrade() - 1);
//                                }
//                            }
//                        }
//                    }
//
//                    break;
//                case Constants.WINDMILL:
//                    break;
//                case Constants.BARN:
//                	storageChosen = -1;
//                    stateGame = Constants.STATE_STORAGE;
//                    loadImages();
//                    if (tutorialGame) {
//                        if (stepTutorial == Constants.STEP_TUTORIAL_STORAGE) {
//                            stepTutorial++;
//                        }
//                    }
//
//                    break;
//                case Constants.FARMHOUSE:
//                    if (stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                        stateGame = Constants.STATE_ACHIEVEMENTS;
//                        loadImages();
//                        if (Constants.achiviementsActive) {
//                            for (int s = 0; s < Constants.CURRENT_QUANTITY_ACHIEVEMENTS.length; s += 2) {
//                                if (Constants.CURRENT_QUANTITY_ACHIEVEMENTS[s] >= Constants.ACHIEVEMENTS_INFO[s][(Constants.LEVEL_ACHIEVEMENTS[s] * 2)]) {
//                                    pageAchievements = s;
//                                    break;
//                                } else if (s + 1 < Constants.CURRENT_QUANTITY_ACHIEVEMENTS.length
//                                        && Constants.CURRENT_QUANTITY_ACHIEVEMENTS[s + 1] >= Constants.ACHIEVEMENTS_INFO[s + 1][(Constants.LEVEL_ACHIEVEMENTS[s + 1] * 2)]) {
//                                    pageAchievements = s;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                    break;
//
//                case Constants.FOODMILL:
//                    if (stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                    	storageChosen = -1;
//                        stateGame = Constants.STATE_FEED_MILL;
//                        loadImages();
//                    }
//                    break;
//                case Constants.BUILDINGANIMAL:
//                    boolean canOpenMarket = true;
//                    for (int j = 0; j < nAnimalsPut; j++) {
//                        if (animalsPut[j].getPos_X() == touch[0][0]
//                                && animalsPut[j].getPos_Y() == touch[0][1]) {
//                            canOpenMarket = false;
//                            break;
//                        }
//                    }
//
//                    if (!holdPressed && !buildingsPut[i].isReady()) {
//                        if (!buildingsPut[i].isOpenBuilding()) {
//                            buildingsPut[i].setShowTimeUnderConstruction(true);
//                            if (tutorialGame) {
//                                stepInAuxTutorial++;
//                                dissapearMsj = true;
//                            }
//                        } else {
//                            int[] pos = calculatePosInitialMap(
//                                    buildingsPut[i].getPosX(),
//                                    buildingsPut[i].getPosY());
//
//                            inicializateAnimationCloud(
//                                    pos[0] + World.posWorldX, pos[1]
//                                            + World.posWorldY);
//                            buildingsPut[i].setReady(true);
//
//                            validateAchievements(
//                                    Constants.ACHIEVEMENTS_BUILDING, 1);
//                            buildingsPut[buildingChosen]
//                                    .setUpdgrade(buildingsPut[buildingChosen]
//                                            .getUpdgrade() + 1);
//                            if (Constants.buildings[Constants.BUILDING_ORD[buildingsPut[buildingChosen]
//                                    .getType()]][buildingsPut[buildingChosen]
//                                    .getUpdgrade() - 1] == null) {
//                                loadBuildingsImg(
//                                        Constants.BUILDING_ORD[buildingsPut[buildingChosen]
//                                                .getType()],
//                                        buildingsPut[buildingChosen]
//                                                .getUpdgrade() - 1);
//                            }
//                        }
//                    } else if (buildingsPut[i].isReady() && canOpenMarket
//                            && !holdPressed && !buildingsPut[i].isMenuRotate()) {
//                        if (actionSelect != Action.ANIMAL) {
//                            stateGame = Constants.STATE_MARKET_ANIMALS;
//                            animationCursor = true;
//                            itemToChoose = 0;
//                            actionMandatory = true;
//                            actionMandatory_X = touch[0][0];
//                            actionMandatory_Y = touch[0][1];
//                            switch (Constants.BUILDING_ORD[buildingsPut[i]
//                                    .getType()]) {
//                            case Constants.ENCLOSURE_CHICKEN:
//                                productShowInfo = Constants.ANIMAL_CHICKEN;
//                                break;
//                            case Constants.ENCLOSURE_COW:
//                                productShowInfo = Constants.ANIMAL_COW;
//                                break;
//                            case Constants.ENCLOSURE_SHEEP:
//                                productShowInfo = Constants.ANIMAL_SHEEP;
//                                break;
//                            case Constants.ENCLOSURE_PIG:
//                                productShowInfo = Constants.ANIMAL_PIG;
//                                break;
//                            case Constants.ENCLOSURE_GOAT:
//                                productShowInfo = Constants.ANIMAL_GOAT;
//                                break;
//                            }
//                            loadImages();
//                            chooseItemInShop(5);
//                        }
//                        buildingChosen = -1;
//                        return false;
//                    } else if (holdPressed && !buildingsPut[i].isMenuRotate()) {
//                        buildingsPut[i].setMenuRotate(true);
//                        buildingsPut[i].setShowTimeUnderConstruction(false);
//                        stateOnlyGreen = true;
//                        typeMsgInfo = TypeMsgInfo.MOVE;
//                        timeShowInfoBox = System.currentTimeMillis();
//                        return true;
//                    } else {
//                        return false;
//                    }
//
//                }
//
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void inicializateAnimationCloud(int posX, int posY) {
//        animationCloudActive = true;
//
//        // posX = mCanvasWidth/2;
//        // posY = mCanvasHeight/2;
//        posInitStar_X = posX;
//        posInitStar_Y = posY;
//
//        int posInit_X = posX - 90;
//        int posInit_Y = posY;
//        for (int i = 0; i < numberStarAnimation; i++) {
//            starAnimation_X[i] = posInit_X + 176;
//            starAnimation_Y[i] = posInit_Y + 30;
//            starAnimationType[i] = UtilSoftgames.random(1, 4);
//        }
//
//        int[] currentPos_X = { 45, 93, 136, 258, 232, 235, 159 };
//        int[] currentPos_Y = { 46, 71, 71, 46, 65, 102, 88 };
//
//        for (int i = 0; i < currentNumberCloud; i++) {
//
//            switch (cloudAnimationType[i]) {
//            case 1:
//                currentPos_X[i] += cloudAnimation1.getWidth() / 2;
//                currentPos_Y[i] += cloudAnimation1.getHeight() / 2;
//                break;
//            case 2:
//                currentPos_X[i] += cloudAnimation2.getWidth() / 2;
//                currentPos_Y[i] += cloudAnimation2.getHeight() / 2;
//                break;
//            case 3:
//                currentPos_X[i] += cloudAnimation3.getWidth() / 2;
//                currentPos_Y[i] += cloudAnimation3.getHeight() / 2;
//                break;
//            }
//            cloudAnimation1_X[i] = posInit_X + currentPos_X[i];
//            cloudAnimation1_Y[i] = posInit_Y + currentPos_Y[i];
//        }
//    }
//
//    private void chooseItemInShop(int finalItem) {
//        startObjects = -1;
//        endObjects = 4;
//        for (int i = 0; i < finalItem; i += 3) {
//            if (i == productShowInfo) {
//                itemToChoose = i;
//                break;
//            } else if (i + 1 == productShowInfo) {
//                itemToChoose = i + 1;
//                break;
//            } else if (i + 2 == productShowInfo) {
//                itemToChoose = i + 2;
//                break;
//            }
//            startObjects += 3;
//            endObjects += 3;
//        }
//
//        if (itemToChoose > finalItem - 3) {
//            startObjects -= 1;
//            endObjects -= 1;
//        }
//    }
//
//    private boolean isTouchSplit(MotionEvent event, int[] position) {
//        int posBackMsjSelected_X = (position[0] + World.posWorldX)
//                + World.tamTiledX / 2 - backgMsjSelected.getWidth() / 2;
//        int posBackMsjSelected_Y = (position[1] + World.posWorldY)
//                + World.tamTiledY;
//
//        if (thereIsTouch(event, posBackMsjSelected_X, posBackMsjSelected_X
//                + bgTooltip.getWidth() / 2, posBackMsjSelected_Y,
//                posBackMsjSelected_Y + bgTooltip.getHeight())) {
//
//            return true;
//        }
//
//        return false;
//    }
//
//    private boolean isTouchSaveInStorage(MotionEvent event, int[] position) {
//        int posBackMsjSelected_X = (position[0] + World.posWorldX)
//                + World.tamTiledX / 2 - backgMsjSelected.getWidth() / 2;
//        int posBackMsjSelected_Y = (position[1] + World.posWorldY)
//                + World.tamTiledY;
//
//        if (thereIsTouch(event,
//                posBackMsjSelected_X + bgTooltip.getWidth() / 2,
//                posBackMsjSelected_X + bgTooltip.getWidth(),
//                posBackMsjSelected_Y,
//                posBackMsjSelected_Y + bgTooltip.getHeight())) {
//
//            return true;
//        }
//        return false;
//    }
//
//    private boolean touchInTruck(MotionEvent event) {
//        int posXLess = carTruck_X + carTruckAnimation_X + World.posWorldX
//                + World.tamTiledX / 2 - carTruck2.getWidth() / 2;
//
//        int posXBig = carTruck_X + carTruckAnimation_X + World.posWorldX
//                + World.tamTiledX / 2 + carTruck2.getWidth() / 2;
//
//        int posYLess = carTruck_Y + carTruckAnimation_Y + World.posWorldY
//                + World.tamTiledY / 2 - carTruck2.getHeight() / 2;
//
//        int posYBig = carTruck_Y + carTruckAnimation_Y + World.posWorldY
//                + World.tamTiledY / 2 + carTruck2.getHeight() / 2;
//
//        if (stepTutorial != Constants.STEP_TUTORIAL_FREE
//                && thereIsTouch(event, posXLess, posXBig, posYLess, posYBig)
//                && carTruckAnimation_X == 0) {
//            if (!canRewardQuestTruck) {
//                stateGame = Constants.STATE_TRUCKQUEST;
//                loadImages();
//            } else {
//                assignStorage(Constants.STORAGE_CROPS, -quantityQuest,
//                        typeQuest);
//                assignQuantity(0, 0, 0, 0, 0, rewardCoinTruckJoe,
//                        rewardXpTruckJoe, posXLess, posYLess);
//                canRewardQuestTruck = false;
//                countTimeQuest = Constants.DELAY_TRUCK_IN_SECONDS;
//                chosenOptionQuestTruck = true;
//                animationCarTruck = false;
//            }
//            return true;
//        }
//
//        if (tutorialGame && stepTutorial == Constants.STEP_TUTORIAL_FREE) {
//            typeMsgInfo = TypeMsgInfo.LEVEL_UP_FIRST;
//            timeShowInfoBox = System.currentTimeMillis();
//        }
//        return false;
//    }
//
//    private boolean touchInButtonBoost(MotionEvent event, int[][] touch) {
//        if (animalChosen != -1) {
//            int[] posAni = getTiledInAnimal(animalChosen, orderAnimalChosen);
//            int[] posit = calculatePosInitialMap(posAni[0], posAni[1]);
//            int posX = posit[0] + World.posWorldX + World.tamTiledX / 2
//                    - buttonBoost.getWidth() / 2;
//            int posY = posit[1] + World.posWorldY + World.tamTiledY;
//
//            if (animalsPut[animalChosen].isShowTimeUnderConstruction()) {
//
//            } else {
//
//                for (int j = 0; j < animalsPut[animalChosen].getUpdgrade(); j++) {
//                    if (animalsPut[animalChosen].getProducing()) {
//
//                        if (thereIsTouch(event, posX,
//                                posX + buttonBoost.getWidth(), posY, posY
//                                        + buttonBoost.getHeight())) {
//
//                            stateGame = Constants.STATE_QUEST_BOOST;
//                            diamondsToBoost = Constants.PRODUCT_ANIMAL_INFO[animalsPut[animalChosen]
//                                    .getType()][4];
//                            actionBoost = Constants.ACTION_BOOST_FINISH_ANIMAL;
//                            return true;
//                        }
//                    }
//                }
//
//            }
//        }
//
//        for (int i = 0; i < nBuildingsPut; i++) {
//            if (buildingChosen != -1 && buildingChosen == i
//                    && buildingsPut[i].isShowTimeUnderConstruction()) {
//                int[] position = calculatePosInitialMap(
//                        buildingsPut[i].getPosX(), buildingsPut[i].getPosY());
//                int posX = position[0] + World.posWorldX + World.tamTiledX / 2
//                        - buttonBoost.getWidth() / 2;
//                int posY = position[1] + World.posWorldY + World.tamTiledY;
//                if (buildingsPut[i].getTimeUnderConstruct() == 0) {
//
//                } else if (thereIsTouch(event, posX,
//                        posX + buttonBoost.getWidth(), posY,
//                        posY + buttonBoost.getHeight())) {
//                    stateGame = Constants.STATE_QUEST_BOOST;
//
//                    int timeToFinishInMins = buildingsPut[i]
//                            .getTimeUnderConstruct() / 60;
//                    diamondsToBoost = (int) Math
//                            .ceil(3 * timeToFinishInMins / 10.0);
//                    // Ensure that the users pays at least 3 diamonds
//                    if (diamondsToBoost < 3) {
//                        diamondsToBoost = 3;
//                    }
//                    actionBoost = Constants.ACTION_BOOST_CONSTRUCT_BUILDING;
//                    return true;
//                }
//
//            }
//        }
//        return false;
//    }
//
//    private boolean touchInMenuRotate(MotionEvent event, int[][] touch) {
//        for (int i = 0; i < NTree; i++) {
//
//            if (tree[i].isMenuRotate()) {
//                int[] position = calculatePosInitialMap(tree[i].getPosX(),
//                        tree[i].getPosY());
//
//                if (isTouchSplit(event, position)) {
//                    if (tree[i].isFlip()) {
//                        tree[i].setFlip(false);
//                    } else {
//                        tree[i].setFlip(true);
//                    }
//                    tree[i].setMenuRotate(false);
//                    return true;
//                } else {
//                    classObjectToMove = Constants.EARTH_CROPS;
//                    typeObjectInMiniOption = i;
//                    if (doMoveToObject(touch)) {
//                        tree[i].setMenuRotate(false);
//                        return true;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < nDecorationsPut; i++) {
//            if (decorationsPut[i].isMenuRotate()) {
//                int[] position = calculatePosInitialMap(
//                        decorationsPut[i].getPos_X(),
//                        decorationsPut[i].getPos_Y());
//
//                if (isTouchSplit(event, position)) {
//                    if (decorationsPut[i].isFlip()) {
//                        decorationsPut[i].setFlip(false);
//                    } else {
//                        decorationsPut[i].setFlip(true);
//                    }
//                    stateOnlyGreen = false;
//                    decorationsPut[i].setMenuRotate(false);
//                    return true;
//
//                } else if (isTouchSaveInStorage(event, position)) {
//                    actionSelect = Action.SAVEDECORATION;
//                    multitouch_X[indexMultitouch] = decorationsPut[i]
//                            .getPos_X();
//                    multitouch_Y[indexMultitouch] = decorationsPut[i]
//                            .getPos_Y();
//                    indexMultitouch++;
//                    itemSelected = decorationsPut[i].getType();
//                    stateOnlyGreen = false;
//                    decorationsPut[i].setMenuRotate(false);
//                    return true;
//                } else {
//                    classObjectToMove = Constants.EARTH_DECORATION;
//                    typeObjectInMiniOption = i;
//                    if (doMoveToObject(touch)) {
//                        decorationsPut[i].setMenuRotate(false);
//                        return true;
//                    }
//                }
//            }
//        }
//
//        int i = buildingChosen;
//
//        if (i == -1)
//            return false;
//
//        if (buildingsPut[i].isMenuRotate()) {
//            int[] position = calculatePosInitialMap(buildingsPut[i].getPosX(),
//                    buildingsPut[i].getPosY());
//
//            if (isTouchSplit(event, position)) {
//                if (buildingsPut[i].isFlip()) {
//                    buildingsPut[i].setFlip(false);
//                } else {
//                    buildingsPut[i].setFlip(true);
//                }
//                buildingsPut[i].setMenuRotate(false);
//                stateOnlyGreen = false;
//                return true;
//                /*
//                 * } else if (isTouchSaveInStorage(event, position)) {
//                 * 
//                 * if (buildingsPut[i].getClassType() ==
//                 * Constants.BUILDINGNORMAL) { actionSelect =
//                 * Action.SAVEBUILDING; multitouch_X[indexMultitouch] =
//                 * buildingsPut[i].getPosX(); multitouch_Y[indexMultitouch] =
//                 * buildingsPut[i].getPosY(); indexMultitouch++;
//                 * buildingsPut[i].setMenuRotate(false); } return true;
//                 */
//            } else {
//                classObjectToMove = Constants.EARTH_BUILDING;
//                typeObjectInMiniOption = i;
//                if (doMoveToObject(touch)) {
//                    buildingsPut[i].setMenuRotate(false);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private int[] getTiledInAnimal(int type, int post) {
//        int[] position = new int[2];
//
//        switch (post) {
//        case 0:
//            position[0] = animalsPut[type].getPos_X();
//            position[1] = animalsPut[type].getPos_Y();
//            break;
//        }
//
//        return position;
//    }
//
//    private boolean touchInAutomatic(MotionEvent event) {
//        int posBackgAutomatic_Y = mCanvasHeight - backgAutomatic.getHeight()
//                - 30;
//        int posBackgAutomatic_X = mCanvasWidth / 2 - backgAutomatic.getWidth()
//                / 2;
//
//        if (canShowInfoAuto && !storageFull) {
//
//            if (buttonClose.touch(event) && !tutorialGame) {
//                elementChosen = Constants.PRESS_BUTTON_CLOSE_AUTOMATIC;
//                timeElementChosen = System.currentTimeMillis();
//                return true;
//            }
//
//            if (checkedAutomatic.touch(event)) {
//                elementChosen = Constants.PRESS_BUTTON_AUTOMATIC;
//                timeElementChosen = System.currentTimeMillis();
//                return true;
//            }
//
//            if (thereIsTouch(event, posBackgAutomatic_X, posBackgAutomatic_X
//                    + backgAutomatic.getWidth(), posBackgAutomatic_Y,
//                    posBackgAutomatic_Y + backgAutomatic.getHeight())) {
//                doAutomatic();
//                canShowInfoAuto = false;
//                return true;
//            }
//
//        } else if (touchInMsjStorageFull(event)) {
//            return true;
//        }
//
//        return false;
//    }
//
//    private boolean touchInMenuExpress(MotionEvent event) {
//
//        if (actionSelect == Action.ANIMAL_FOOD) {
//            actionSelect = null;
//        }
//        if (!openMenuExpress) {
//            if (iconsMenuExpress[0].touch(event)) {
//                sound(main, SoundUtil.SOUND_CLICK);
//                elementChosen = Constants.PRESS_BUTTON_OPEN_MENU;
//                timeElementChosen = System.currentTimeMillis();
//                msgSelect = null;
//                if (stateOnlyGreen) {
//                    disableStateOnlyGreen();
//                }
//                return true;
//            }
//        } else if (openMenuExpress && !runAnimationMenuExpress) {
//            if (iconsMenuExpress[0].touch(event)) {
//                elementChosen = Constants.PRESS_BUTTON_CLOSEDMENU;
//                timeElementChosen = System.currentTimeMillis();
//                return true;
//            } else if (iconsMenuExpress[2].touch(event)
//                    && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                elementChosen = Constants.PRESS_BUTTON_OPEN_MARKET;
//                timeElementChosen = System.currentTimeMillis();
//
//                return true;
//            } else if (iconsMenuExpress[4].touch(event)) {
//                elementChosen = Constants.PRESS_BUTTON_OPEN_STORAGE;
//                buildingChosen = 1;
//                timeElementChosen = System.currentTimeMillis();
//                return true;
//            } else if (iconsMenuExpress[1].touch(event)) {
//                animationCarTruck = true;
//                return true;
//            }
//            openMenuExpress = false;
//            msgSelect = null;
//            iconsMenuExpress[0].setPosX(mCanvasWidth
//                    - iconsMenuExpress[0].getImage().getWidth());
//            sound(main, SoundUtil.SOUND_CLICK);
//        }
//        return false;
//    }
//
//    //
//    private boolean doMoveToObject(int[][] touch) {
//
//        if (mapContaints[touch[0][1]][touch[0][0]] == Constants.EMPTY) {
//            typeMsgInfo = null;
//            switch (classObjectToMove) {
//
//            case Constants.EARTH_BUILDING:
//
//                if (buildingsPut[typeObjectInMiniOption].isFourSpace()) {
//
//                    int[][] touchVerificate = new int[2][2];
//                    touchVerificate[0][0] = touch[0][0];
//                    touchVerificate[0][1] = touch[0][1];
//                    for (int i = 0; i < 4; i++) {
//                        if (touchInTileProhib(touchVerificate)
//                                || mapContaints[touchVerificate[0][1]][touchVerificate[0][0]] != Constants.EMPTY) {
//
//                            typeMsgInfo = TypeMsgInfo.MOVEBAD;
//                            timeShowInfoBox = System.currentTimeMillis();
//                            return false;
//                        }
//
//                        if (i == 0) {
//                            touchVerificate[0][0] += 1;
//                        } else if (i == 1) {
//                            touchVerificate[0][1] += 1;
//                            touchVerificate[0][0] -= 1;
//                        } else if (i == 2) {
//                            touchVerificate[0][0] += 1;
//                        }
//                    }
//
//                    mapContaints[buildingsPut[typeObjectInMiniOption]
//                            .getPosY_1()][buildingsPut[typeObjectInMiniOption]
//                            .getPosX_1()] = Constants.EMPTY;
//                    mapContaints[buildingsPut[typeObjectInMiniOption]
//                            .getPosY_2()][buildingsPut[typeObjectInMiniOption]
//                            .getPosX_2()] = Constants.EMPTY;
//                    mapContaints[buildingsPut[typeObjectInMiniOption]
//                            .getPosY_3()][buildingsPut[typeObjectInMiniOption]
//                            .getPosX_3()] = Constants.EMPTY;
//
//                    mapContaints[touch[0][1]][touch[0][0] + 1] = Constants.LIMBOBUILDING;
//                    mapContaints[touch[0][1] + 1][touch[0][0]] = Constants.EARTH_BUILDING;
//                    mapContaints[touch[0][1] + 1][touch[0][0] + 1] = Constants.LIMBOBUILDING;
//
//                    for (int i = 0; i < nAnimalsPut; i++) {
//                        if (animalsPut[i].getPos_X() == buildingsPut[typeObjectInMiniOption]
//                                .getPosX()
//                                && animalsPut[i].getPos_Y() == buildingsPut[typeObjectInMiniOption]
//                                        .getPosY()) {
//                            animalsPut[i].setAllPos(touch[0][0], touch[0][1]);
//                        } else if (animalsPut[i].getPos_X() == buildingsPut[typeObjectInMiniOption]
//                                .getPosX_1()
//                                && animalsPut[i].getPos_Y() == buildingsPut[typeObjectInMiniOption]
//                                        .getPosY_1()) {
//                            animalsPut[i].setAllPos(touch[0][0] + 1,
//                                    touch[0][1]);
//                        } else if (animalsPut[i].getPos_X() == buildingsPut[typeObjectInMiniOption]
//                                .getPosX_2()
//                                && animalsPut[i].getPos_Y() == buildingsPut[typeObjectInMiniOption]
//                                        .getPosY_2()) {
//                            animalsPut[i].setAllPos(touch[0][0],
//                                    touch[0][1] + 1);
//                        } else if (animalsPut[i].getPos_X() == buildingsPut[typeObjectInMiniOption]
//                                .getPosX_3()
//                                && animalsPut[i].getPos_Y() == buildingsPut[typeObjectInMiniOption]
//                                        .getPosY_3()) {
//                            animalsPut[i].setAllPos(touch[0][0] + 1,
//                                    touch[0][1] + 1);
//                        }
//                    }
//                } else if (touchInTileProhib(touch)) {
//                    // FIXME stateOnlyGreen tileProhibit
//                    // typeMsgInfo = TypeMsgInfo.MOVEBAD;
//                    // timeShowInfoBox = System.currentTimeMillis();
//                    // disableStateOnlyGreen();
//                    return false;
//                }
//
//                if (!comeStorage) {
//                    mapContaints[buildingsPut[typeObjectInMiniOption].getPosY()][buildingsPut[typeObjectInMiniOption]
//                            .getPosX()] = Constants.EMPTY;
//                }
//                comeStorage = false;
//                buildingsPut[typeObjectInMiniOption].setPosALL(touch[0][0],
//                        touch[0][1]);
//                if (buildingsPut[typeObjectInMiniOption].isFourSpace()) {
//                    mapContaints[touch[0][1]][touch[0][0]] = Constants.LIMBOBUILDING;
//                } else {
//                    mapContaints[touch[0][1]][touch[0][0]] = Constants.EARTH_BUILDING;
//                }
//                mapObjects[touch[0][1]][touch[0][0]] = typeObjectInMiniOption;
//                stateOnlyGreen = false;
//                return true;
//            case Constants.EARTH_DECORATION:
//                try {
//                    if (decorationsPut[typeObjectInMiniOption].getPos_Y() != -1000
//                            && decorationsPut[typeObjectInMiniOption]
//                                    .getPos_X() != -1000) {
//                        mapContaints[decorationsPut[typeObjectInMiniOption]
//                                .getPos_Y()][decorationsPut[typeObjectInMiniOption]
//                                .getPos_X()] = Constants.EMPTY;
//                    }
//
//                    mapContaints[touch[0][1]][touch[0][0]] = Constants.EARTH_DECORATION;
//
//                    if (Constants.DECORATIONS_INFO[decorationsPut[typeObjectInMiniOption]
//                            .getType()][8] == 1) {
//                        mapContaints[touch[0][1]][touch[0][0]] = Constants.LIMBODECORATION;
//                        mapContaints[touch[0][1]][touch[0][0] + 1] = Constants.LIMBODECORATION;
//                        mapContaints[touch[0][1] + 1][touch[0][0] + 1] = Constants.LIMBODECORATION;
//                        mapContaints[touch[0][1] + 1][touch[0][0]] = Constants.EARTH_DECORATION;
//
//                        mapContaints[decorationsPut[typeObjectInMiniOption]
//                                .getPos_Y()][decorationsPut[typeObjectInMiniOption]
//                                .getPos_X() + 1] = Constants.EMPTY;
//                        mapContaints[decorationsPut[typeObjectInMiniOption]
//                                .getPos_Y() + 1][decorationsPut[typeObjectInMiniOption]
//                                .getPos_X()] = Constants.EMPTY;
//                        mapContaints[decorationsPut[typeObjectInMiniOption]
//                                .getPos_Y() + 1][decorationsPut[typeObjectInMiniOption]
//                                .getPos_X() + 1] = Constants.EMPTY;
//                    }
//
//                    decorationsPut[typeObjectInMiniOption]
//                            .setPos_X(touch[0][0]);
//                    decorationsPut[typeObjectInMiniOption]
//                            .setPos_Y(touch[0][1]);
//                    mapObjects[touch[0][1]][touch[0][0]] = typeObjectInMiniOption;
//                } catch (Exception e) {
//                    Log.e(TAG, "Error moving decoration", e);
//                }
//
//                stateOnlyGreen = false;
//                return true;
//            case Constants.EARTH_CROPS:
//                mapContaints[tree[typeObjectInMiniOption].getPosY()][tree[typeObjectInMiniOption]
//                        .getPosX()] = Constants.EMPTY;
//                tree[typeObjectInMiniOption].setPosX(touch[0][0]);
//                tree[typeObjectInMiniOption].setPosY(touch[0][1]);
//                mapContaints[touch[0][1]][touch[0][0]] = Constants.EARTH_CROPS;
//                mapObjects[touch[0][1]][touch[0][0]] = typeObjectInMiniOption;
//                stateOnlyGreen = false;
//                return true;
//            }
//
//        } else {
//            return false;
//            // FIXME stateOnlyGreen map not empty
//
//        }
//
//        return false;
//    }
//
//    private boolean isMoveObject(int[][] touch) {
//        for (int i = 0; i < nAnimalsPut; i++) {
//            // animalsPut[i].setOpenMenu(false);
//            // for(int j = 0; j <animalsPut[i].getUpdgrade(); j++){
//            animalsPut[i].setProducing(false);
//            animalsPut[i].setSelected(false);
//            // }
//            // animalsPut[i].setMenuRotate(false);
//            animalsPut[i].setShowTimeUnderConstruction(false);
//            // animalsPut[i].setMoveFree(false);
//        }
//
//        for (int i = 0; i < nBuildingsPut; i++) {
//            // buildingsPut[i].setOpenMenu(false);
//            buildingsPut[i].setMenuRotate(false);
//            // buildingsPut[i].setMoveFree(false);
//            buildingsPut[i].setShowTimeUnderConstruction(false);
//        }
//
//        for (int i = 0; i < nDecorationsPut; i++) {
//            decorationsPut[i].setMenuRotate(false);
//            // decorationsPut[i].setMoveFree(false);
//        }
//
//        for (int i = 0; i < NTree; i++) {
//            tree[i].setMenuRotate(false);
//            // tree[i].setMoveFree(false);
//        }
//
//        itemToReturnAgain = -1;
//
//        if (comeStorage) {
//            if (doMoveToObject(touch)) {
//                return true;
//            }
//
//        }
//
//        return false;
//    }
//
//    public void disableStateOnlyGreen() {
//        stateOnlyGreen = false;
//        typeMsgInfo = null;
//        comeStorage = false;
//
//        if (buildingChosen != -1) {
//            buildingsPut[buildingChosen].setMenuRotate(false);
//        }
//
//        if (decorationChosen != -1) {
//            decorationsPut[decorationChosen].setMenuRotate(false);
//        }
//
//        if (cropChosen != -1) {
//            tree[cropChosen].setMenuRotate(false);
//        }
//    }
//
//    private boolean touchCancelRotate(MotionEvent event) {
//        if (buttonCloseSmall.touch(event)) {
//            disableStateOnlyGreen();
//            buttonCloseSmall.setPosX(-10);
//            return true;
//        }
//        buttonCloseSmall.setPosX(-10);
//        return false;
//    }
//
//    private void touchUpMainGame(MotionEvent event) {
//
//        int[][] touch = tiledChosenInMap(event, null, null);
//        if (touchCancelRotate(event) || touchInUIMain(event)
//                || touchInMenuRotate(event, touch) || touchInTruck(event)
//                || touchInButtonBoost(event, touch) || touchInAutomatic(event)
//                || touchInMenuExpress(event) || touchInBuilding(touch, false)
//                || touchInAnimal(event, touch, false)
//                || touchInTileProhib(touch)
//
//                || touchInExpansion(event, touch)
//                || touchInDecoration(touch, false)) {
//
//            if (elementChosen != Constants.PRESS_BUTTON_AUTOMATIC
//                    && actionSelect != Action.ANIMAL_FOOD
//                    && actionSelect != Action.SAVEDECORATION
//                    && actionSelect != Action.SAVEBUILDING) {
//                msgSelect = null;
//                actionSelect = null;
//            }
//            return;
//        }
//
//        if (isMoveObject(touch)) {
//            return;
//        }
//
//        int backupChoosed_X = 0;
//        int backupChoosed_Y = 0;
//        if (tiledChosen != null) {
//            backupChoosed_X = tiledChosen[0][0];
//            backupChoosed_Y = tiledChosen[0][1];
//        }
//        tiledChosen = touch;
//
//        if (msgSelect != null && indexMultitouch < 1) {
//            if (backupChoosed_X == tiledChosen[0][0]
//                    && backupChoosed_Y == tiledChosen[0][1]) {
//                switch (msgSelect) {
//                case MSJPLOW:
//                    actionSelect = Action.PLOW;
//                    break;
//                case MSJPLANT:
//                    if (actionSelect != Action.PLANT) {
//                        actionSelect = Action.PLANT;
//                        stateGame = Constants.STATE_MARKET_CROPS;
//                        loadImages();
//                        // return;
//                    }
//                    break;
//                case MSJFERTILIZE:
//                    actionSelect = Action.FERTILIZE;
//                    break;
//                case MSJRECOLECT:
//                    actionSelect = Action.HARVEST;
//                    break;
//                case MSJVEGETATION:
//                    actionSelect = Action.REMOVE_VEGETATION;
//                    break;
//                case MSJANIMAL:
//                    actionSelect = Action.ANIMAL;
//                    break;
//                case MSJWATERING:
//                    actionSelect = Action.WATERING;
//                    break;
//                default:
//                    break;
//                }
//
//                // return;
//            }
//        }
//
//        if (openMenuExpress) {
//            openMenuExpress = false;
//            iconsMenuExpress[0].setPosX(mCanvasWidth
//                    - iconsMenuExpress[0].getImage().getWidth());
//        }
//
//        if (isValidAction()) {
//            if (!touchRepeated(tiledChosen[0][0], tiledChosen[0][1])
//                    || indexMultitouch == 0) {
//                multitouch_X[indexMultitouch] = tiledChosen[0][0];
//                multitouch_Y[indexMultitouch] = tiledChosen[0][1];
//                indexMultitouch++;
//            } else {
//                if (currentMultitouch < indexMultitouch - 1) {
//                    for (int i = 0; i < indexMultitouch; i++) {
//                        if (tiledChosen[0][1] == multitouch_Y[i]
//                                && tiledChosen[0][0] == multitouch_X[i]) {
//                            multitouch_X[i] = -1000;
//                            break;
//                        }
//                    }
//                }
//            }
//        } else {
//            if (indexMultitouch > 0) {
//                return;
//            }
//
//            switch (mapContaints[tiledChosen[0][1]][tiledChosen[0][0]]) {
//            case Constants.EARTHBAD:
//                msgSelect = MsgSuggest.MSJPLOW;
//                break;
//            case Constants.VEGETATIONBAD:
//                quantRemoVege = 250;
//                msgSelect = MsgSuggest.MSJVEGETATION;
//                break;
//            case Constants.VEGETATIONBAD2:
//                quantRemoVege = 500;
//                msgSelect = MsgSuggest.MSJVEGETATION;
//                break;
//            case Constants.VEGETATIONBAD3:
//                quantRemoVege = 750;
//                msgSelect = MsgSuggest.MSJVEGETATION;
//                break;
//            case Constants.VEGETATIONBAD4:
//                quantRemoVege = 1000;
//                msgSelect = MsgSuggest.MSJVEGETATION;
//                break;
//            case Constants.VEGETATIONBAD5:
//                quantRemoVege = 1250;
//                msgSelect = MsgSuggest.MSJVEGETATION;
//                break;
//            case Constants.EARTH_CROPS:
//                for (int i = 0; i < NTree; i++) {
//                    if (tree[i].getPosX() == tiledChosen[0][0]
//                            && tree[i].getPosY() == tiledChosen[0][1]) {
//                        if (tree[i].readyWatering
//                                && !tree[i].animationReadyWatering) {
//                            msgSelect = MsgSuggest.MSJWATERING;
//                        } else if (tree[i].getTiled() < 5) {
//                            msgSelect = MsgSuggest.MSJFERTILIZE;
//                        } else if (tree[i].getTiled() >= 5
//                                && tree[i].getTiled() <= 6) {
//                            msgSelect = MsgSuggest.MSJRECOLECT;
//                            actionSelect = Action.HARVEST;
//                            if (!touchRepeated(tiledChosen[0][0],
//                                    tiledChosen[0][1]) || indexMultitouch == 0) {
//                                multitouch_X[indexMultitouch] = tiledChosen[0][0];
//                                multitouch_Y[indexMultitouch] = tiledChosen[0][1];
//                                indexMultitouch++;
//                            }
//                        } else {
//                            msgSelect = MsgSuggest.MSJPLOW;
//                        }
//                    }
//                }
//                break;
//            case Constants.EARTHGOOD:
//                msgSelect = MsgSuggest.MSJPLANT;
//                if (actionSelect != Action.PLANT) {
//                    actionSelect = Action.PLANT;
//                    stateGame = Constants.STATE_MARKET_CROPS;
//                    loadImages();
//
//                    multitouch_X[indexMultitouch] = tiledChosen[0][0];
//                    multitouch_Y[indexMultitouch] = tiledChosen[0][1];
//                    indexMultitouch++;
//
//                    if (tutorialGame) {
//                        itemToChoose = 0;
//                    }
//                }
//                break;
//            case Constants.EMPTY:
//                if (actionSelect == Action.DECORATION) {
//                    msgSelect = MsgSuggest.MSJDECORATION;
//                } else if (actionSelect == Action.ANIMAL) {
//                    msgSelect = MsgSuggest.MSJANIMAL;
//                } else {
//                    msgSelect = MsgSuggest.MSJPLOW;
//                }
//                break;
//            }
//        }
//    }
//
//    private boolean canPutAnimal() {
//        for (int i = 0; i < nBuildingsPut; i++) {
//            if (buildingsPut[i].isFourSpace() && buildingsPut[i].isReady()) {
//                if ((tiledChosen[0][0] == buildingsPut[i].getPosX() && tiledChosen[0][1] == buildingsPut[i]
//                        .getPosY())
//                        || (tiledChosen[0][0] == buildingsPut[i].getPosX_1() && tiledChosen[0][1] == buildingsPut[i]
//                                .getPosY_1())
//                        || (tiledChosen[0][0] == buildingsPut[i].getPosX_2() && tiledChosen[0][1] == buildingsPut[i]
//                                .getPosY_2())
//                        || (tiledChosen[0][0] == buildingsPut[i].getPosX_3() && tiledChosen[0][1] == buildingsPut[i]
//                                .getPosY_3())) {
//                    for (int j = 0; j < nAnimalsPut; j++) {
//                        if (animalsPut[j].getPos_X() == tiledChosen[0][0]
//                                && animalsPut[j].getPos_Y() == tiledChosen[0][1]) {
//                            return false;
//                        }
//                    }
//
//                    animalBuildingOwner = i;// buildingsPut[i].getType();
//                    switch (Constants.BUILDING_ORD[buildingsPut[i].getType()]) {
//                    case Constants.ENCLOSURE_CHICKEN:
//                        if (itemSelected != Constants.ANIMAL_CHICKEN) {
//                            return false;
//                        }
//                        break;
//                    case Constants.ENCLOSURE_COW:
//                        if (itemSelected != Constants.ANIMAL_COW) {
//                            return false;
//                        }
//                        break;
//
//                    case Constants.ENCLOSURE_PIG:
//                        if (itemSelected != Constants.ANIMAL_PIG) {
//                            return false;
//                        }
//                        break;
//                    case Constants.ENCLOSURE_GOAT:
//                        if (itemSelected != Constants.ANIMAL_GOAT) {
//                            return false;
//                        }
//                        break;
//                    case Constants.ENCLOSURE_SHEEP:
//                        if (itemSelected != Constants.ANIMAL_SHEEP) {
//                            return false;
//                        }
//                        break;
//
//                    default:
//                        return false;
//
//                    }
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean isValidAction() {
//
//        boolean isValidate = false;
//
//        // restriction
//        if (actionSelect == null
//                && mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EMPTY) {
//
//            actionSelect = Action.PLOW;
//            return true;
//        }
//
//        if (actionSelect == Action.HARVEST
//                && mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EARTHBAD) {
//
//            actionSelect = Action.PLOW;
//            return true;
//        }
//
//        if (actionSelect != null) {
//
//            switch (actionSelect) {
//            case ANIMAL_FOOD:
//                if (!touchRepeated(tiledChosen[0][0], tiledChosen[0][1])) {
//                    isValidate = true;
//                }
//                break;
//
//            case REMOVE_VEGETATION:
//                if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.VEGETATIONBAD
//                        || mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.VEGETATIONBAD2
//                        || mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.VEGETATIONBAD3
//                        || mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.VEGETATIONBAD4
//                        || mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.VEGETATIONBAD5) {
//                    isValidate = true;
//                }
//
//                break;
//            case DECORATION:
//                if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EMPTY) {
//                    isValidate = true;
//                }
//
//                if (Constants.DECORATIONS_INFO[itemSelected][8] == 1) {
//                    if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0] + 1] != Constants.EMPTY
//                            || mapContaints[tiledChosen[0][1] + 1][tiledChosen[0][0]] != Constants.EMPTY
//                            || mapContaints[tiledChosen[0][1] + 1][tiledChosen[0][0] + 1] != Constants.EMPTY) {
//                        isValidate = false;
//                    }
//                }
//                // Code to verify that the tile is valid
//                // int[][] touchVerificateDeco = new int[2][2];
//                // touchVerificateDeco[0][1] = tiledChosen[0][1];
//                // if (touchInTileProhib(touchVerificateDeco)) {
//                // isValidate = false;
//                // }
//                // for (int i = 0; i < 4; i++) {
//                // if (touchInTileProhib(touchVerificateDeco)) {
//                // isValidate = false;
//                // }
//                //
//                // if (i == 0) {
//                // touchVerificateDeco[0][0] += 1;
//                // } else if (i == 1) {
//                // touchVerificateDeco[0][1] += 1;
//                // touchVerificateDeco[0][0] -= 1;
//                // } else if (i == 2) {
//                // touchVerificateDeco[0][0] += 1;
//                // }
//                // }
//                break;
//            case ANIMAL:
//                if (canPutAnimal()) {
//                    isValidate = true;
//                }
//                break;
//            case PLOW:
//                if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EMPTY
//                        || mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EARTHBAD) {
//                    isValidate = true;
//                }
//
//                for (int i = 0; i < NTree; i++) {
//                    if (tree[i].getPosX() == tiledChosen[0][0]
//                            && tree[i].getPosY() == tiledChosen[0][1]
//                            && tree[i].getTiled() > 6) {
//                        isValidate = true;
//                        break;
//                    }
//                }
//                break;
//            case PLANT:
//                if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EARTHGOOD) {
//                    isValidate = true;
//                }
//                break;
//            case WATERING:
//                for (int i = 0; i < NTree; i++) {
//                    if (tree[i].getPosX() == tiledChosen[0][0]
//                            && tree[i].getPosY() == tiledChosen[0][1]
//                            && tree[i].readyWatering) {
//                        isValidate = true;
//                        break;
//                    }
//                }
//                break;
//            case FERTILIZE:
//
//                for (int i = 0; i < NTree; i++) {
//                    if (tree[i].getPosX() == tiledChosen[0][0]
//                            && tree[i].getPosY() == tiledChosen[0][1]
//                            && tree[i].getTiled() < 5) {
//                        isValidate = true;
//                        break;
//                    }
//                }
//                break;
//            case HARVEST:
//                for (int i = 0; i < NTree; i++) {
//                    if (tree[i].getPosX() == tiledChosen[0][0]
//                            && tree[i].getPosY() == tiledChosen[0][1]
//                            && tree[i].getTiled() >= 5
//                            && tree[i].getTiled() <= 6) {
//                        isValidate = true;
//                        break;
//                    }
//                }
//                break;
//            case BUILDING:
//
//                if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0]] == Constants.EMPTY) {
//                    isValidate = true;
//                }
//
//                if (Constants.BUILDING_ORD[itemSelected] == Constants.ENCLOSURE_CHICKEN
//                        || Constants.BUILDING_ORD[itemSelected] == Constants.ENCLOSURE_COW
//                        || Constants.BUILDING_ORD[itemSelected] == Constants.ENCLOSURE_SHEEP
//                        || Constants.BUILDING_ORD[itemSelected] == Constants.ENCLOSURE_PIG
//                        || Constants.BUILDING_ORD[itemSelected] == Constants.ENCLOSURE_GOAT) {
//                    if (mapContaints[tiledChosen[0][1]][tiledChosen[0][0] + 1] != Constants.EMPTY
//                            || mapContaints[tiledChosen[0][1] + 1][tiledChosen[0][0]] != Constants.EMPTY
//                            || mapContaints[tiledChosen[0][1] + 1][tiledChosen[0][0] + 1] != Constants.EMPTY) {
//                        isValidate = false;
//                    }
//
//                    int[][] touchVerificate = new int[2][2];
//                    touchVerificate[0][0] = tiledChosen[0][0];
//                    touchVerificate[0][1] = tiledChosen[0][1];
//
//                    for (int i = 0; i < 4; i++) {
//                        if (touchInTileProhib(touchVerificate)) {
//                            isValidate = false;
//                        }
//
//                        if (i == 0) {
//                            touchVerificate[0][0] += 1;
//                        } else if (i == 1) {
//                            touchVerificate[0][1] += 1;
//                            touchVerificate[0][0] -= 1;
//                        } else if (i == 2) {
//                            touchVerificate[0][0] += 1;
//                        }
//                    }
//                }
//                if (!isValidate) {
//                    // FIXME stateOnlyGreen isValidAction
//                    // disableStateOnlyGreen
//                }
//
//                break;
//
//            }
//        }
//
//        return isValidate;
//    }
//
//    private boolean touchRepeated(int tiledX, int tiledY) {
//        boolean isTouchRepeat = false;
//        for (int i = 0; i < indexMultitouch; i++) {
//            if (tiledY == multitouch_Y[i] && tiledX == multitouch_X[i]) {
//                isTouchRepeat = true;
//            }
//        }
//
//        return isTouchRepeat;
//    }
//
//    private int[][] tiledChosenInMap(MotionEvent event, Integer posTiledX,
//            Integer posTiledY) {
//        int[][] tiledChoosed = new int[1][2];
//        int Pos_Initial_Map_X = mCanvasWidth / 2 - World.tamTiledX / 2;// (Constants.N_TiledWorld_X
//                                                                       // *
//                                                                       // Constants.Tam_Tiled_X)
//                                                                       // /
//                                                                       // 2;
//        int Pos_Initial_Map_Y = 0;
//        int Aux_Pos_Initial_Map_X = mCanvasWidth / 2 - World.tamTiledX / 2;// (Constants.N_TiledWorld_X
//                                                                           // *
//                                                                           // Constants.Tam_Tiled_X)
//                                                                           // /
//                                                                           // 2;
//        int Aux_Pos_Initial_Map_Y = 0;
//        boolean found = false;
//
//        float posX = 0;
//        float posY = 0;
//        if (posTiledX != null && posTiledY != null) {
//            posX = posTiledX;
//            posY = posTiledY;
//        } else if (event == null) {
//            posX = mCanvasWidth / 2;
//            posY = mCanvasHeight / 2;
//        } else {
//            posX = event.getX();
//            posY = event.getY();
//        }
//
//        for (byte nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y; nTiledY++) {
//            Pos_Initial_Map_X = Aux_Pos_Initial_Map_X;
//            Pos_Initial_Map_Y = Aux_Pos_Initial_Map_Y;
//            for (byte nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//                if (posX >= World.posWorldX + Pos_Initial_Map_X
//                        && posX <= World.posWorldX + Pos_Initial_Map_X
//                                + World.tamTiledX
//                        && posY >= World.posWorldY + Pos_Initial_Map_Y
//                        && posY <= World.posWorldY + Pos_Initial_Map_Y
//                                + World.tamTiledY
//                        && (touchCorrectInTiled(World.posWorldX
//                                + Pos_Initial_Map_X, World.posWorldY
//                                + Pos_Initial_Map_Y, posX, posY))) {
//                    tiledChoosed[0][0] = nTiledX;
//                    tiledChoosed[0][1] = nTiledY;
//
//                    found = true;
//                    break;
//                }
//
//                Pos_Initial_Map_X += World.tamTiledX / 2;
//                Pos_Initial_Map_Y += World.tamTiledY / 2;
//            }
//            if (found) {
//                break;
//            }
//            Aux_Pos_Initial_Map_X -= World.tamTiledX / 2;
//            Aux_Pos_Initial_Map_Y += World.tamTiledY / 2;
//        }
//
//        if (!found) {
//            tiledChoosed[0][0] = 25;
//            tiledChoosed[0][1] = 25;
//        }
//
//        return tiledChoosed;
//    }
//
//    private boolean touchCorrectInTiled(int init_X, int init_Y, float touchX,
//            float touchY) {
//        int fin_X1 = 0;
//        int fin_X2 = 0;
//
//        boolean invertir = false;
//        for (int i = init_Y; i <= init_Y + World.tamTiledY; i++) {
//            for (int j = init_X + World.tamTiledX / 2; j <= init_X
//                    + World.tamTiledX / 2 + fin_X1; j++) {
//                if ((int) touchX == j && (int) touchY == i) {
//
//                    return true;
//                }
//            }
//
//            for (int j = init_X + World.tamTiledX / 2; j >= init_X
//                    + World.tamTiledX / 2 + fin_X2; j--) {
//                if ((int) touchX == j && (int) touchY == i) {
//
//                    return true;
//                }
//            }
//
//            if (i == init_Y + World.tamTiledY / 2) {
//                invertir = true;
//            }
//            if (invertir) {
//                fin_X1 -= 2;
//                fin_X2 += 2;
//            } else {
//                fin_X1 += 2;
//                fin_X2 -= 2;
//            }
//        }
//        // indexRegisterDebug ++;
//        return false;
//    }
//
//    private void paintStateLoading(Canvas canvas){
//    	if(loadedMainGame == -25){
//    		 Paint paint = new Paint();
//    	        paint.setColor(Color.BLACK);
//    	        canvas.drawRect(0, 0, mCanvasWidth, mCanvasHeight, paint); 
//    	        Paint newPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    	        newPaint.setStrokeWidth(1);
//    	        newPaint.setTextSize(30);
//    	        newPaint.setTextAlign(Align.CENTER);
//    	        newPaint.setTypeface(mFace);
//    	        newPaint.setColor(Color.WHITE);
//    	        String textAux = "LOADING...";
//    	        if(loadedMainGame == 225){
//    	        //	textAux = "PRESS THE SCREEN TO CONTINUE";
//    	        }
//    	        canvas.drawText(textAux, mCanvasWidth / 2, mCanvasHeight/2, newPaint);
//    	}
//    	  if (System.currentTimeMillis() - timePrev >= 700) {
//              timePrev = System.currentTimeMillis();
//             if (loadedMainGame == 225) {
//            	  stateGame = Constants.STATE_MAIN_GAME;
//            	  if (timeOpenGame >= 2 && !userPurchased && !runningBonus) {
//            		  stateGame = Constants.STATE_PROMOTION;
//            		  runningBonus = true;
//            	  }
//            	  if (tutorialGame) {
//            		  stateGame = Constants.STATE_INFO_TUTORIAL;
//            	  }
//            	  System.gc();
//
//             }
//             if(loadedMainGame >= 0){
//            	 loadImages();
//             }
//              if(loadedMainGame != 225){
//            	  loadedMainGame += 25;
//              }
//    	  }
//    }
//    
//    public void doDraw(Canvas canvas) {
//        if (canvas == null)
//            return;
//        canvas.save();
//        canvas.translate(0, 0);
//        switch (stateGame) {
//        case Constants.STATE_LOADING_MAIN:
//        	paintStateLoading(canvas);
//        	break;
//        case Constants.STATE_COVER:
//            paintStateCover(canvas);
//            break;
//        case Constants.STATE_MAIN_GAME:
//            main.hideAdWhirl();
//          //  main.showMoreGamesButton();
//            paintStateMainGame(canvas);
//            break;
//        case Constants.STATE_MAIN_MARKET:
//            paintStateMainMarket(canvas);
//            break;
//        case Constants.STATE_MISSION:
//            paintStateMission(canvas);
//            if (!tutorialGame && !isNoAdsItemPurchased) {
//                main.showAdWhirl();
//            }
//            break;
//        case Constants.STATE_MARKET_CROPS:
//            paintStateMarketCrops(canvas);
//            break;
//        case Constants.STATE_MARKET_ANIMALS:
//            paintStateMarketAnimal(canvas);
//            break;
//        case Constants.STATE_MARKET_DECO:
//            paintStateMarketDecoration(canvas);
//            break;
//        case Constants.STATE_MARKET_BUILDING:
//            paintStateMarketBuilding(canvas);
//            break;
//        case Constants.STATE_PRODUCTION:
//            paintStateBuild(canvas);
//            break;
//        case Constants.STATE_WIN_MATERIAL:
//            paintStateWinMaterial(canvas);
//            if (!tutorialGame && !isNoAdsItemPurchased) {
//                main.showAdWhirl();
//            }
//            break;
//        case Constants.STATE_LEVEL_UP:
//            paintStateLevelUp(canvas);
//            if (!tutorialGame && !isNoAdsItemPurchased) {
//                main.showAdWhirl();
//            }
//            break;
//        case Constants.STATE_STORAGE:
//            paintStateStorage(canvas);
//            break;
//        case Constants.STATE_FACEBOOK:
//            paintStateFacebook(canvas);
//            break;
//        case Constants.STATE_FEED_MILL:
//            paintStateFeedMill(canvas);
//            break;
//        case Constants.STATE_QUEST_EXPANSION:
//            paintStateQuestExpansion(canvas);
//            break;
//        case Constants.STATE_NOFOOD:
//            paintStateNoFood(canvas);
//            break;
//        case Constants.STATE_MORE_COINS:
//            paintStateMoreCoins(canvas);
//            break;
//        case Constants.STATE_MORE_DIAMONDS:
//            paintStateMoreDiamonds(canvas);
//            break;
//        case Constants.STATE_COLLECTIONS:
//            paintStateCollections(canvas);
//            break;
//        case Constants.STATE_ACHIEVEMENTS:
//            paintStateAchievements(canvas);
//            break;
//        case Constants.STATE_UPGRADE_STORE:
//            paintStateUpdgradeBuilding(canvas);
//            break;
//        case Constants.STATE_UPGRADE_ANIMAL:
//            break;
//        case Constants.STATE_QUEST_BOOST:
//
//            paintStateQuestBoost(canvas);
//
//            break;
//        case Constants.STATE_UPGRADE_BUILDING:
//            paintStateUpdgradeBuilding(canvas);
//            break;
//        case Constants.STATE_UPGRADE_FEEDMILL:
//            paintStateUpdgradeBuilding(canvas);
//            break;
//        case Constants.STATE_SHOW_INFO_PRODUCTS:
//            paintStateShowInfoProducts(canvas);
//            break;
//        case Constants.STATE_WIN_MASTERED:
//            Paint_State_WinMastered(canvas);
//            break;
//        case Constants.STATE_PROMOTION:
//            paintStatePromotion(canvas);
//            break;
//        case Constants.STATE_TRUCKQUEST:
//            paintStateTruckQuest(canvas);
//            break;
//
//        case Constants.STATE_INFO_TUTORIAL:
//           
//            if (stepTutorial >= 1) {
//            	paintStateMainGame(canvas);
//                paintInfoTutorial(canvas, 0);
//            } else {
//                paintScreenTutorial(canvas);
//            }
//            break;
//        case Constants.STATE_CHARACTER_MISSION:
//            paintStateCharacterMission(canvas);
//            break;
//
//        case Constants.STATE_POP_PLOW_FULL:
//            paintStatePopPlowFull(canvas);
//            break;
//        case Constants.STATE_POP_STORAGE_FULL:
//            paintStatePopUpStorageFull(canvas);
//            break;
//        }
//
//        paintAnimationQuantityUp(canvas);
//        
//        if (main != null && stateGame != Constants.STATE_MAIN_GAME) {
//            // Let's hide the more games button to avoid overlapping
//               main.hideMoreGamesButton();
//           } else if(main != null){
//               main.showMoreGamesButton();
//           }
//
//        canvas.restore();
//    }
//
//    private void paintStatePopUpStorageFull(Canvas canvas) {
//        paintStateMainGame(canvas);
//
//        UtilSoftgames.paintImageInCenter(canvas, bgQuestBoost, mCanvasWidth,
//                mCanvasHeight);
//
//        buttonClose.setPosX(mCanvasWidth / 2 + bgQuestBoost.getWidth() / 2
//                - buttonClose.getImage().getWidth() / 2);
//        buttonClose.setPosY(mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2);
//        buttonClose.paint(canvas);
//
//        buttonAddProduct.setPosX(mCanvasWidth / 2
//                - buttonAddProduct.getImage().getWidth() / 2);
//        buttonAddProduct.setPosY(mCanvasHeight / 2 + bgQuestBoost.getHeight()
//                / 2 - buttonAddProduct.getImage().getHeight() / 2);
//        buttonAddProduct.paintWithText(canvas, texts[439],
//                fontWhiteSmallCenter, 0, 15);
//
//        int posInit_X2 = (mCanvasWidth / 2 - bgQuestBoost.getWidth() / 2)
//                + popUpOffsetX;
//        int posFin_X2 = (mCanvasWidth / 2 + bgQuestBoost.getWidth() / 2)
//                - popUpOffsetX;
//
//        int posInitY2 = (mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2)
//                + popUpOffsetInitY;
//        int posFin_Y2 = (mCanvasHeight / 2 + bgQuestBoost.getHeight() / 2)
//                - popUpFullOffsetEndY;
//
//        paintSquare(canvas, posInit_X2, posInitY2, posFin_X2, posFin_Y2,
//                0xff0d2e4f);
//
//        canvas.drawBitmap(visitStoreImage, posInit_X2 + popUpFullOffsetIconX,
//                posInitY2 + popUpFullOffsetIconY, null);
//
//        canvas.drawText(texts[63], mCanvasWidth / 2, posInitY2
//                - popUpFullOffsetEndY, fontTitleCenter);
//
//        paintDivisionText(canvas, texts[64],
//                mCanvasWidth / 2 + visitStoreImage.getWidth() / 2, posInitY2
//                        + popUpFullOffsetEndY, 28, 16, posInitY2
//                        + popUpFullOffsetEndY, fontQuantityMaterialProduce);
//
//    }
//
//    private void paintStatePopPlowFull(Canvas canvas) {
//        paintStateMainGame(canvas);
//        UtilSoftgames.paintImageInCenter(canvas, bgQuestBoost, mCanvasWidth,
//                mCanvasHeight);
//
//        buttonClose.setPosX(mCanvasWidth / 2 + bgQuestBoost.getWidth() / 2
//                - buttonClose.getImage().getWidth() / 2);
//        buttonClose.setPosY(mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2);
//        buttonClose.paint(canvas);
//
//        int posInit_X = (mCanvasWidth / 2 - bgQuestBoost.getWidth() / 2)
//                + popUpOffsetX;
//        int posFin_X = (mCanvasWidth / 2 + bgQuestBoost.getWidth() / 2)
//                - popUpOffsetX;
//
//        int posInitY = (mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2)
//                + popUpOffsetInitY;
//        int posFin_Y = (mCanvasHeight / 2 + bgQuestBoost.getHeight() / 2)
//                - popUpFullOffsetEndY;
//
//        paintSquare(canvas, posInit_X, posInitY, posFin_X, posFin_Y, 0xff0d2e4f);
//
//        canvas.drawBitmap(iconMoreExpansion, posInit_X + popUpFullOffsetIconX,
//                posInitY + popUpFullOffsetIconY, null);
//
//        canvas.drawText(texts[98], mCanvasWidth / 2, posInitY
//                - popUpFullOffsetEndY, fontTitleCenter);
//
//        paintDivisionText(
//                canvas,
//                texts[99]
//                        .replaceAll(
//                                "%",
//                                ""
//                                        + (Constants.EXPANSION_AVAILABLE[Constants.currentExpansion + 1] - Constants.EXPANSION_AVAILABLE[Constants.currentExpansion])),
//                mCanvasWidth / 2 + iconMoreExpansion.getWidth() / 2, posInitY
//                        + popUpFullOffsetEndY, 28, 16, posInitY
//                        + popUpFullOffsetEndY, fontQuantityMaterialProduce);
//
//        if (!tutorialGame && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//            buttonAddProduct.setPosX(mCanvasWidth / 2
//                    - buttonAddProduct.getImage().getWidth() / 2);
//            buttonAddProduct.setPosY(mCanvasHeight / 2
//                    + bgQuestBoost.getHeight() / 2
//                    - buttonAddProduct.getImage().getHeight() / 2);
//            buttonAddProduct.paintWithText(canvas, texts[438],
//                    fontWhiteSmallCenter, 0, 15);
//        }
//    }
//
//    private void paintStateCharacterMission(Canvas canvas) {
//        paintStateMainGame(canvas);
//
//        int backgroundCharacter_X = mCanvasWidth / 2
//                - backgroundCharacter.getWidth() / 2;
//        int backgroundCharacter_Y = mCanvasHeight / 2
//                - backgroundCharacter.getHeight() / 2;
//        canvas.drawBitmap(backgroundCharacter, backgroundCharacter_X,
//                backgroundCharacter_Y, null);
//
//        buttonClose.setPosY(mCanvasHeight / 2 - backgroundCharacter.getHeight()
//                / 2);
//        buttonClose.setPosX(mCanvasWidth / 2 + backgroundCharacter.getWidth()
//                / 2 - buttonClose.getImage().getWidth());
//        buttonClose.paint(canvas);
//
//        if (tutorialGame
//                && stepTutorial == Constants.STEP_TUTORIAL_WELCOME_FINAL_TUTORIAL) {
//            paintAnimationCursor(canvas,
//                    buttonClose.getPosX() + buttonClose.getImage().getWidth()
//                            / 2 - cursorHand.getWidth() / 2,
//                    buttonClose.getPosY() + buttonClose.getImage().getHeight()
//                            / 2 - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        canvas.drawText(texts[431], mCanvasWidth / 2, backgroundCharacter_Y
//                + missionOffsetTextY, fontTitleCenter);
//        if(characterBig[(characterChosen[indexCharacterChosen])] != null){
//        	canvas.drawBitmap(characterBig[(characterChosen[indexCharacterChosen])], backgroundCharacter_X
//                + missionOffsetCharacterX, backgroundCharacter_Y
//                + missionOffsetCharacterY, null);
//        }
//
//        int posIcon_X = mCanvasWidth / 2 + missionOffsetIconX;
//        int posIcon_Y = backgroundCharacter_Y + missionOffsetIconY;
//        int posCheckMarkIcon_X = 0;
//        int posCheckMarkIcon_Y = 0;
//
//        int backgTaskBig_X = mCanvasWidth / 2;
//        int backgTaskBig_Y = backgroundCharacter_Y + missionOffsetCharacterY;
//        canvas.drawText(texts[432], mCanvasWidth / 2, backgroundCharacter_Y
//                + missionOffsetText2Y, fontMoneyToPay);
//        canvas.drawBitmap(backgTask, backgTaskBig_X, backgTaskBig_Y, null);
//        int diamondsToSkip = 0;
//        for (int i = 0; i < nTask[missionCharacter[indexCharacterChosen]]; i++) {
//            paintIconType(canvas,
//                    typeMission[missionCharacter[indexCharacterChosen]][i],
//                    posIcon_X, posIcon_Y, i,
//                    missionCharacter[indexCharacterChosen]);
//
//            posCheckMarkIcon_X = (posIcon_X + iconCrops[0].getWidth() / 2)
//                    - checkSmall.getWidth();
//            posCheckMarkIcon_Y = (posIcon_Y + iconCrops[0].getHeight() / 2)
//                    - checkSmall.getHeight();
//            int quantityDone = isReadyTask(i,
//                    missionCharacter[indexCharacterChosen]);
//
//            if (quantityDone == quantityProduct[missionCharacter[indexCharacterChosen]][i]) {
//                canvas.drawBitmap(checkSmall, posCheckMarkIcon_X,
//                        posCheckMarkIcon_Y, null);
//
//            } else {
//              int itemNeed = quantityProduct[missionCharacter[indexCharacterChosen]][i] - quantityDone;
//            	
//            	diamondsToSkip += (valuesDiamondsFinishMission(typeMission[missionCharacter[indexCharacterChosen]][i],
//                        typeProduct[missionCharacter[indexCharacterChosen]][i]))*itemNeed;
//                canvas.drawText(
//                        quantityDone
//                                + "/"
//                                + quantityProduct[missionCharacter[indexCharacterChosen]][i],
//                        posIcon_X, posIcon_Y + iconCrops[0].getHeight() / 2,
//                        Constants.fontAnimalfood);
//            }
//
//            posIcon_X += (backgTask.getWidth() / 3);
//            if (i == 2) {
//                posIcon_X = mCanvasWidth / 2 + missionOffsetIconX;
//                posIcon_Y += backgTask.getHeight() / 3;
//            }
//        }
//        
//        diamondsToFinishMission[missionCharacter[indexCharacterChosen]] =  diamondsToSkip;
//
//        if (!canRewardMission[missionCharacter[indexCharacterChosen]]) {
//            buttonProduce.setPosX(backgTaskBig_X + backgTask.getWidth() / 2
//                    - buttonProduce.getImage().getWidth() / 2);
//            buttonProduce.setPosY(backgTaskBig_Y + backgTask.getHeight()
//                    - (buttonProduce.getImage().getHeight() / 4) * 3);
//            buttonProduce.paint(canvas);
//
//            String[] auxString2 = {
//                    texts[13]
//                            + " ("
//                            + diamondsToFinishMission[missionCharacter[indexCharacterChosen]],
//                    ")" };
//            Bitmap[] auxBitmap2 = { diamondSmall, null };
//
//            UtilSoftgames.PaintTextWithImageInLine(canvas, auxString2,
//                    auxBitmap2, fontMoneyToPay, buttonProduce.getPosX()
//                            + buttonProduce.getImage().getWidth() / 2,
//                    buttonProduce.getPosY()
//                            + (buttonProduce.getImage().getHeight() / 3) * 2);
//
//        } else {
//            buttonProduce.setPosX(backgTaskBig_X + backgTask.getWidth() / 2
//                    - buttonProduce.getImage().getWidth() / 2);
//            buttonProduce.setPosY(backgTaskBig_Y + backgTask.getHeight()
//                    - (buttonProduce.getImage().getHeight() / 4) * 3);
//            buttonProduce.paint(canvas);
//
//            String[] auxString2 = { texts[433] };
//            Bitmap[] auxBitmap2 = { null, null };
//
//            UtilSoftgames.PaintTextWithImageInLine(canvas, auxString2,
//                    auxBitmap2, fontMoneyToPay, buttonProduce.getPosX()
//                            + buttonProduce.getImage().getWidth() / 2,
//                    buttonProduce.getPosY()
//                            + (buttonProduce.getImage().getHeight() / 3) * 2);
//
//        }
//
//        canvas.drawText(texts[25] + ":", backgroundCharacter_X
//                + missionOffsetText2X, backgroundCharacter_Y
//                + missionOffsetText2Y, fontMoneyToPay);
//
//        String[] auxString = { ""
//                + rewardsCoins[missionCharacter[indexCharacterChosen]] };
//        Bitmap[] auxBitmap = { coinSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontAttriItemShop, backgroundCharacter_X + missionOffsetText3X,
//                backgroundCharacter_Y + missionOffsetText3Y);
//
//        String[] auxString1 = { ""
//                + rewardsXP[missionCharacter[indexCharacterChosen]] };
//        Bitmap[] auxBitmap1 = { xpSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString1, auxBitmap1,
//                fontAttriItemShop, backgroundCharacter_X + missionOffsetText3X,
//                backgroundCharacter_Y + missionOffsetText4Y);
//
//        animationElementChosen();
//        if (tutorialGame) {
//            paintInfoTutorial(canvas, 0);
//        }
//    }
//
//    private void paintScreenTutorial(Canvas canvas) {
//        if (stepTutorial <= 0) {
//            UtilSoftgames.paintImageInCenter(canvas,
//                    screenTuto[stepTutorial + 1], mCanvasWidth, mCanvasHeight);
//        }
//    }
//
//    private void paintStateTruckQuest(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[303], null);
//
//        int posTask_X = (mCanvasWidth / 4) * 3 + truckOffsetTaskBgX;
//        int posTask_Y = (mCanvasHeight / 3) * 2
//                - (truckDecoration.getHeight() / 3) * 2;
//        int taskItemBackg_Y = posTask_Y + backgDecoTruck.getHeight() / 2
//                - taskItemBackg.getHeight() / 2;
//        int backgDecoTruck_X = mCanvasWidth / 2 + backgroundGeneral.getWidth()
//                / 2 - backgDecoTruck.getWidth() - 40;
//
//        String msj = texts[305].replaceAll("%",
//                texts[Constants.CROPS_NAME[typeQuest]]);
//        msj = msj.replaceAll("X", "" + quantityQuest);
//
//        paintDivisionText(canvas, msj,
//                backgDecoTruck_X + backgDecoTruck.getWidth() / 2,
//                infoTruckQuest_Y, 36, 50, infoTruckQuest_Y, fontMsjTitle);
//
//        canvas.drawBitmap(backgDecoTruck, backgDecoTruck_X, posTask_Y, null);
//
//        canvas.drawBitmap(truckDecoration,
//                mCanvasWidth / 2 - backgroundGeneral.getWidth() / 2 + 40,
//                posTask_Y, null);
//
//        canvas.drawBitmap(taskItemBackg, posTask_X, taskItemBackg_Y, null);
//
//        canvas.drawBitmap(
//                iconCrops[typeQuest],
//                posTask_X + taskItemBackg.getWidth() / 2
//                        - iconCrops[typeQuest].getWidth() / 2, posTask_Y
//                        + infoTruckQuestIconCropY, null);
//
//        canvas.drawText(getQuantityProductInStorage(typeQuest) + "/"
//                + quantityQuest, posTask_X + taskItemBackg.getWidth() / 2,
//                posTask_Y + taskItemBackg.getHeight()
//                        - Constants.fontAnimalfood.getTextSize()
//                        + infoTruckQuestQuantityY, Constants.fontAnimalfood);
//
//        canvas.drawText(texts[306],
//                mCanvasWidth / 2 + backgDecoTruck.getWidth() / 4, posTask_Y
//                        + (backgDecoTruck.getHeight() / 2),
//                fontQuantityMaterialProduce);
//
//        String[] auxString = { texts[25] + ": " + rewardCoinTruckJoe,
//                "" + rewardXpTruckJoe };
//        Bitmap[] auxBitmap = { coinSmall, xpSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontMoneyToPay, backgDecoTruck_X + backgDecoTruck.getWidth()
//                        / 2, posTask_Y + backgDecoTruck.getHeight() + 40);
//
//        buttonAccept.setPosX(backgDecoTruck_X);
//        buttonAccept.setPosY(posTask_Y + backgDecoTruck.getHeight()
//                + buttonOffsetTextY);
//
//        buttonDenie.setPosX(backgDecoTruck_X
//                + buttonAccept.getImage().getWidth() + 20);
//        buttonDenie.setPosY(posTask_Y + backgDecoTruck.getHeight()
//                + buttonOffsetTextY);
//
//        //if (!chosenOptionQuestTruck) {
//          //  buttonAccept.paintWithText(canvas, texts[307], fontMsjTitle, 0, 10);
//         //   buttonDenie.paintWithText(canvas, texts[308], fontMsjTitle, 0, 10);
//        //} else {
//            buttonAccept.paintWithText(canvas, texts[435], fontMsjTitle, 0, 0);
//          //  buttonDenie.paintWithText(canvas, texts[434] + " (10", fontMsjTitle, 0, 0);
//            buttonDenie.paint(canvas);
//            String[] auxString2 = { texts[434] + " (10" ,
//                    ")"  };
//            Bitmap[] auxBitmap2 = { diamondSmall, null };
//            
//            UtilSoftgames.PaintTextWithImageInLine(canvas, auxString2, auxBitmap2,
//                    fontMoneyToPay, buttonDenie.getPosX() + buttonDenie.getImage().getWidth()/2
//                            , buttonDenie.getPosY() + (buttonDenie.getImage().getHeight()/3)*2);
//        //}
//
//        if (tutorialGame) {
//            paintAnimationCursor(canvas,
//                    buttonAccept.getPosX() + buttonAccept.getImage().getWidth()
//                            / 2 - cursorHand.getWidth() / 2,
//                    buttonAccept.getPosY()
//                            + buttonAccept.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 2 + cursorY, -1);
//        }
//
//        animationElementChosen();
//    }
//
//    private void paintStatePromotion(Canvas canvas) {
//        // paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//
//        paintTitleGeneral(canvas, texts[299], texts[300]);
//
//        int diff_X = promotionInfoDiff_X;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff_X));
//        int posY = promotionInfo_Y;
//        canvas.drawBitmap(productItemBackground, posX, posY, null);
//        canvas.drawBitmap(iconMoreDiamonds[5], posX,
//                posY + productItemBackground.getHeight() / 2
//                        - iconMoreDiamonds[5].getHeight() / 2, null);
//        canvas.drawBitmap(offer, posX + productItemBackground.getWidth()
//                - offer.getWidth() / 2, posY - offer.getHeight() / 2, null);
//        canvas.drawText(currentDiscount + "% OFF",
//                posX + productItemBackground.getWidth(), posY + 10,
//                fontQuantityMaterialProduce);
//
//        canvas.drawText(getCurrentPromoAmount(Constants.DIAMONDS), posX
//                + productItemBackground.getWidth() / 2, posY
//                + specialOfferAmountY, fontQuantityMaterialProduce);
//
//        canvas.drawBitmap(
//                symbolPlus,
//                posX + productItemBackground.getWidth() + 2,
//                posY + productItemBackground.getHeight() / 2
//                        - symbolPlus.getHeight() / 2, null);
//
//        posX += productItemBackground.getWidth() + diff_X;
//
//        canvas.drawBitmap(productItemBackground, posX, posY, null);
//        canvas.drawBitmap(
//                iconMoreCoins[5],
//                posX,
//                posY + productItemBackground.getHeight() / 2
//                        - iconMoreCoins[5].getHeight() / 2, null);
//        canvas.drawBitmap(offer, posX + productItemBackground.getWidth()
//                - offer.getWidth() / 2, posY - offer.getHeight() / 2, null);
//        canvas.drawText(currentDiscount + "% OFF",
//                posX + productItemBackground.getWidth(), posY + 10,
//                fontQuantityMaterialProduce);
//        canvas.drawText(getCurrentPromoAmount(Constants.GOLD), posX
//                + productItemBackground.getWidth() / 2, posY
//                + specialOfferAmountY, fontQuantityMaterialProduce);
//
//       
//
//        canvas.drawText(
//                texts[301] + " "
//                        + UtilSoftgames.secondsToString(timeSecondsOffer),
//                mCanvasWidth / 2, specialOfferTimerOffsetY,
//                fontQuantityMaterialProduce);
//
//        buttonBuild.setPosX((mCanvasWidth / 2)
//                - buttonBuild.getImage().getWidth() / 2);
//        buttonBuild.setPosY(posButtonPromotion_Y);
//        buttonBuild.paintWithText(canvas, texts[298],
//                fontQuantityMaterialProduce, 0, 0);
//
//    }
//
//    private String getCurrentPromoAmount(int currencyType) {
//        String sAmountDiamonds = "";
//        String sAmountGold = "";
//        switch (currentDiscount) {
//        case 40:
//            sAmountDiamonds = Integer.toString(Constants.HF3_BONUS_DIAMONDS[0]);
//            sAmountGold = Integer.toString(Constants.HF3_BONUS_COINS[0]);
//            break;
//        case 50:
//            sAmountDiamonds = Integer.toString(Constants.HF3_BONUS_DIAMONDS[1]);
//            sAmountGold = Integer.toString(Constants.HF3_BONUS_COINS[1]);
//            break;
//        case 60:
//            sAmountDiamonds = Integer.toString(Constants.HF3_BONUS_DIAMONDS[2]);
//            sAmountGold = Integer.toString(Constants.HF3_BONUS_COINS[2]);
//            break;
//        case 70:
//            sAmountDiamonds = Integer.toString(Constants.HF3_BONUS_DIAMONDS[3]);
//            sAmountGold = Integer.toString(Constants.HF3_BONUS_COINS[3]);
//            break;
//        }
//        switch (currencyType) {
//        case Constants.GOLD:
//            return sAmountGold + " coins";
//        case Constants.DIAMONDS:
//            return sAmountDiamonds + " diamonds";
//        default:
//            return "";
//        }
//    }
//
//    private void Paint_State_WinMastered(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[293], texts[292]);
//
//        int numberMastered = Constants.CROPS_QUANTITY_LEVELS[typeCropsMastered] - 1;
//
//        canvas.drawText(texts[294], mCanvasWidth / 2, mCanvasHeight / 2 + 60,
//                fontPaintMsjGameBig);
//        canvas.drawText(texts[295], mCanvasWidth / 2, mCanvasHeight / 2 + 165,
//                fontPaintMsjGameBig);
//
//        canvas.drawBitmap(iconCrops[typeCropsMastered], mCanvasWidth / 2
//                - iconCrops[typeCropsMastered].getWidth() / 2, mCanvasHeight
//                / 2 - iconCrops[typeCropsMastered].getHeight(), null);
//
//        paintMasteredCrops(canvas, mCanvasWidth / 2, mCanvasHeight / 2
//                - iconCrops[0].getHeight() - flowerFull.getHeight() - 75,
//                typeCropsMastered);
//
//        String[] auxString = {
//                "+"
//                        + Constants.rewardsMastered[numberMastered][0]
//                        + " "
//                        + ((Constants.rewardsMastered[numberMastered][1] == Constants.GOLD) ? texts[296]
//                                + " "
//                                : texts[11] + " "),
//                " +" + Constants.rewardsMastered[numberMastered][2] + " Xp " };
//        Bitmap[] auxBitmap = {
//                (Constants.rewardsMastered[numberMastered][1] == Constants.GOLD) ? coinSmall
//                        : diamondSmall, xpSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontMoneyToPay, mCanvasWidth / 2, mCanvasHeight / 2 + 110);
//
//        buttonBuild.setPosX((mCanvasWidth / 2)
//                - buttonBuild.getImage().getWidth() / 2);
//        buttonBuild.setPosY(550);
//        buttonBuild.paint(canvas);
//
//        canvas.drawText(texts[271] + "", mCanvasWidth / 2,
//                buttonBuild.getPosY()
//                        + (buttonBuild.getImage().getHeight() / 4) * 3,
//                fontQuantityMaterialProduce);
//
//    }
//
//    private void paintStateShowInfoProducts(Canvas canvas) {
//        UtilSoftgames.paintImageInCenter(canvas, bgQuestBoost, mCanvasWidth,
//                mCanvasHeight);
//
//        canvas.drawText(texts[262], mCanvasWidth / 2, mCanvasHeight / 2
//                - bgQuestBoost.getHeight() / 2 + infoProductsTitleOffsetY,
//                fontTitleCenter);
//
//        paintDivisionText(canvas, TextsUtil.getNameInfoProducts(texts,
//                productShowInfo, Constants.BUILDING_NAME[getPosBuilding()]),
//                mCanvasWidth / 2, mCanvasHeight / 2 - bgQuestBoost.getHeight()
//                        / 2 + infoProductsBodyOffsetY, 26, 40, 0,
//                fontQuantityMaterialProduce);
//
//        buttonAddProduct.setPosX(mCanvasWidth / 2
//                - buttonAddProduct.getImage().getWidth() / 2);
//        buttonAddProduct.setPosY(mCanvasHeight / 2 + bgQuestBoost.getHeight()
//                / 2 - buttonAddProduct.getImage().getHeight() / 2);
//        buttonAddProduct.paint(canvas);
//
//        if (productShowInfo == Constants.PLOW
//                || productShowInfo == Constants.ADD_HELPER
//                || productShowInfo == Constants.REMOVE_VEGETATIONS
//                || productShowInfo == Constants.WATERING
//                || productShowInfo == Constants.NEXT_LEVEL
//                || productShowInfo == Constants.GET_GOLD) {
//
//            canvas.drawText("OK", mCanvasWidth / 2, mCanvasHeight / 2
//                    + bgQuestBoost.getHeight() / 2
//                    + buttonAddProduct.getImage().getHeight() / 4,
//                    fontQuantityMaterialProduce);
//        } else {
//            canvas.drawText(texts[260], mCanvasWidth / 2, mCanvasHeight / 2
//                    + bgQuestBoost.getHeight() / 2
//                    + buttonAddProduct.getImage().getHeight() / 4,
//                    fontQuantityMaterialProduce);
//        }
//
//        buttonClose.setPosX(mCanvasWidth / 2 + bgQuestBoost.getWidth() / 2
//                - buttonClose.getImage().getWidth() / 2);
//        buttonClose.setPosY(mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2);
//        buttonClose.paint(canvas);
//
//        animationElementChosen();
//    }
//
//    private int getOrderProduct(int type) {
//        int info = 0;
//        for (int i = 0; i < Constants.BUILDING_PRODUCTS.length; i++) {
//            if (Constants.BUILDING_PRODUCTS[i][0] == type) {
//                info = i;
//                break;
//            }
//        }
//
//        return info;
//    }
//
//    private int getPosBuilding() {
//        int type = 0;
//        switch (getOrderProduct(productShowInfo) / 4) {
//        case 0:
//            type = 1;
//            break;
//        case 1:
//            type = 5;
//            break;
//        case 2:
//            type = 6;
//            break;
//        case 3:
//            type = 8;
//            break;
//        case 4:
//            type = 9;
//            break;
//        case 5:
//            type = 10;
//            break;
//        case 6:
//            type = 11;
//            break;
//        case 7:
//            type = 12;
//            break;
//        case 8:
//            type = 13;
//            break;
//        case 9:
//            type = 19;
//            break;
//        }
//        return type;
//    }
//
//    private void paintStateQuestBoost(Canvas canvas) {
//        paintStateMainGame(canvas);
//        int posBackg_Y = mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2;
//
//        UtilSoftgames.paintImageInCenter(canvas, bgQuestBoost, mCanvasWidth,
//                mCanvasHeight);
//
//        canvas.drawText(texts[94], mCanvasWidth / 2, posBackg_Y
//                + boostBuildingTitleOffsetY, fontTitleCenter);
//
//        paintDivisionText(canvas,
//                texts[95].replaceAll("%", String.valueOf(diamondsToBoost)),
//                mCanvasWidth / 2, posBackg_Y + boostBuildingInfoOffsetY, 26,
//                40, 0, fontQuantityMaterialProduce);
//
//        buttonAddProduct.setPosX(mCanvasWidth / 2
//                - buttonAddProduct.getImage().getWidth() / 2);
//        buttonAddProduct.setPosY(mCanvasHeight / 2 + bgQuestBoost.getHeight()
//                / 2 - buttonAddProduct.getImage().getHeight() / 2);
//        buttonAddProduct.paint(canvas);
//
//        canvas.drawText(String.valueOf(diamondsToBoost), mCanvasWidth / 2
//                - diamondSmall.getWidth() / 2,
//                mCanvasHeight / 2 + bgQuestBoost.getHeight() / 2
//                        + buttonAddProduct.getImage().getHeight() / 4,
//                fontQuantityMaterialProduce);
//
//        buttonClose.setPosX(mCanvasWidth / 2 + bgQuestBoost.getWidth() / 2
//                - buttonClose.getImage().getWidth() / 2);
//        buttonClose.setPosY(mCanvasHeight / 2 - bgQuestBoost.getHeight() / 2);
//        buttonClose.paint(canvas);
//
//        canvas.drawBitmap(diamondSmall, mCanvasWidth / 2 + 15, mCanvasHeight
//                / 2 + bgQuestBoost.getHeight() / 2 - diamondSmall.getHeight()
//                / 2, null);
//
//        if (tutorialGame) {
//            paintAnimationCursor(canvas,
//                    buttonAddProduct.getPosX()
//                            + buttonAddProduct.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                    buttonAddProduct.getPosY()
//                            + buttonAddProduct.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        animationElementChosen();
//
//    }
//
//    private void paintStateUpdgradeBuilding(Canvas canvas) {
//        paintBackGeneral(canvas);
//	String nameBuilding = texts[Constants.BUILDING_NAME[buildingsPut[buildingChosen]
//		.getType()]];
//
//	paintTitleGeneral(canvas, texts[194] + " " + nameBuilding, texts[67]);
//
//        int diff = 20;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * 3) / 2;
//        int posY = posIconBackgUpgrade_Y;
//        boolean canUpgrade = true;
//
//        for (int i = 0; i < 6; i += 2) {
//            int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i];
//            int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                    .getPosOrderInfos()
//                    + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//            Bitmap iconAux = getIconUpgrade(type);
//            int currentQuantity = getCurrentQuantity(type);
//
//            if (currentQuantity < quantityValue) {
//                canUpgrade = false;
//            }
//
//            canvas.drawBitmap(productItemBackground, posX, posY, null);
//
//            canvas.drawText(currentQuantity + "/" + quantityValue, posX
//                    + productItemBackground.getWidth() / 2, posY
//                    + (productItemBackground.getHeight() / 3) * 2,
//                    fontQuantityMaterialProduce);
//
//            canvas.drawBitmap(iconAux, posX + productItemBackground.getWidth()
//                    / 2 - iconAux.getWidth() / 2, posY + 20, null);
//            if ((i == 2 && currentQuantity < quantityValue && type != Constants.DIAMONDS)
//                    || (i == 0 && currentQuantity < quantityValue
//                            && type != Constants.DIAMONDS && type != Constants.GOLD)) {
//                buttonAddProduct.setPosX(posX
//                        + productItemBackground.getWidth() / 2
//                        - buttonAddProduct.getImage().getWidth() / 2);
//                buttonAddProduct.setPosY(posY
//                        + productItemBackground.getHeight()
//                        - buttonAddProduct.getImage().getHeight() / 2);
//                buttonAddProduct.paint(canvas);
//
//                String[] textToShow = { texts[16] + " (" + " 10", ")" };
//                Bitmap[] imageToShow = { diamondSmall, null };
//
//                UtilSoftgames.PaintTextWithImageInLine(canvas, textToShow,
//                        imageToShow, fontMoneyToPay, posX
//                                + productItemBackground.getWidth() / 2,
//                        buttonAddProduct.getPosY()
//                                + (buttonAddProduct.getImage().getHeight() / 3)
//                                * 2);
//
//            }
//
//            posX += productItemBackground.getWidth() + diff;
//        }
//
//        if (canUpgrade) {
//            buttonBuild.setPosX((mCanvasWidth / 2)
//                    - buttonBuild.getImage().getWidth() / 2);
//            buttonBuild.setPosY(posButtonUpgrade_Y);
//            buttonBuild.paint(canvas);
//        } else {
//            canvas.drawBitmap(buttonBuildInactive, (mCanvasWidth / 2)
//                    - buttonBuildInactive.getWidth() / 2, posButtonUpgrade_Y,
//                    null);
//        }
//
//        canvas.drawText(texts[194] + "", mCanvasWidth / 2, posButtonUpgrade_Y
//                + (buttonBuild.getImage().getHeight() / 4) * 3,
//                fontQuantityMaterialProduce);
//
//        animationElementChosen();
//
//        paintPopUpInfo(canvas);
//
//    }
//
//    private int getCurrentQuantity(int type) {
//        int aux = 0;
//        switch (type) {
//        case Constants.GOLD:
//            aux = quantityCoins;
//            break;
//        case Constants.DIAMONDS:
//            aux = quantityDiamonds;
//            break;
//        case Constants.LEVEL:
//            aux = nLevel + 1;
//            break;
//
//        case Constants.FRIENDS:
//            aux = totalfriends;
//            break;
//        case Constants.STONES:
//        case Constants.WOOD:
//        case Constants.ROPES:
//        case Constants.NAILS:
//        case Constants.LEAF:
//            aux = quantityCurrentMaterial[type - 56];
//            break;
//        }
//
//        return aux;
//    }
//
//    private Bitmap getIconUpgrade(int type) {
//        Bitmap aux = null;
//        switch (type) {
//        case Constants.GOLD:
//            aux = coinSmall;
//            break;
//        case Constants.DIAMONDS:
//            aux = diamondSmall;
//            break;
//        case Constants.LEVEL:
//            aux = starNivel;
//            break;
//
//        case Constants.STONES:
//            loadProductsImg(Constants.STONES);
//            aux = Constants.iconProduced[Constants.STONES];
//            break;
//        case Constants.WOOD:
//            loadProductsImg(Constants.WOOD);
//            aux = Constants.iconProduced[Constants.WOOD];
//            break;
//        case Constants.FRIENDS:
//            aux = iconHelper.getImage();
//            break;
//        case Constants.ROPES:
//            loadProductsImg(Constants.ROPES);
//            aux = Constants.iconProduced[Constants.ROPES];
//            break;
//        case Constants.NAILS:
//            loadProductsImg(Constants.NAILS);
//            aux = Constants.iconProduced[Constants.NAILS];
//            break;
//        case Constants.LEAF:
//            loadProductsImg(Constants.LEAF);
//            aux = Constants.iconProduced[Constants.LEAF];
//            break;
//        }
//
//        return aux;
//    }
//
//    /*
//     * private void Paint_State_Updgrade_Animal(Canvas canvas) {
//     * Paint_BackGeneral(canvas); Paint_Title_General(canvas, texto[70],
//     * texto[71]);
//     * 
//     * int diff = 20; int posX = mCanvasWidth/2 -
//     * ((productItemBackground.getWidth() + diff)*3)/2; int posY = 280;
//     * 
//     * canvas.drawText(texto[72], mCanvasWidth/2, 190, fontMsjTitle);
//     * 
//     * for(int i = 0; i < 3; i++){ canvas.drawBitmap(productItemBackground,
//     * posX,posY, null);
//     * 
//     * posX += productItemBackground.getWidth() + diff; }
//     * 
//     * buttonBuild.setPosX((mCanvasWidth/2) -
//     * buttonBuild.getImage().getWidth()/2); buttonBuild.setPosY(550);
//     * buttonBuild.paint(canvas);
//     * 
//     * animationElementChoosed(); }
//     */
//
//    /*
//     * private void Paint_State_Updgrade_Store(Canvas canvas) {
//     * Paint_BackGeneral(canvas); Paint_Title_General(canvas, texto[65],
//     * texto[66]);
//     * 
//     * int diff = 20; int posX = mCanvasWidth/2 -
//     * ((productItemBackground.getWidth() + diff)*3)/2; int posY = 240; boolean
//     * canUpgrade = true;
//     * 
//     * for(int i = 0; i < 6; i += 2){ int quantityValue =
//     * Constants.buildingNeedUpgrade
//     * [buildingsPut[buildingChoosed].getPosOrderInfo()*4 +
//     * buildingsPut[buildingChoosed].getUpdgrade()][i]; int type = Constants.
//     * buildingNeedUpgrade[buildingsPut[buildingChoosed].getPosOrderInfo()*4 +
//     * buildingsPut[buildingChoosed].getUpdgrade()][i + 1]; Bitmap iconAux =
//     * getIconUpgrade(type); int currentQuantity = getCurrentQuantity(type);
//     * 
//     * if(currentQuantity < quantityValue){ canUpgrade = false; }
//     * 
//     * canvas.drawBitmap(productItemBackground, posX,posY, null);
//     * 
//     * canvas.drawText(currentQuantity + "/" +quantityValue , posX +
//     * productItemBackground.getWidth()/2, posY +
//     * (productItemBackground.getHeight()/3)*2, fontQuantityMaterialProduce);
//     * 
//     * 
//     * canvas.drawBitmap(iconAux , posX + productItemBackground.getWidth()/2 -
//     * iconAux.getWidth()/2, posY + 20, null); if(i == 2 && currentQuantity <
//     * quantityValue && type != Constants.Diamonds){
//     * buttonAddProduct.setPosX(posX + productItemBackground.getWidth()/2 -
//     * buttonAddProduct.getImage().getWidth()/2); buttonAddProduct.setPosY(posY
//     * + productItemBackground.getHeight() -
//     * buttonAddProduct.getImage().getHeight()/2);
//     * buttonAddProduct.paint(canvas);
//     * 
//     * String []textToShow = {texto[16] + " (" + " 10", ")"}; Bitmap
//     * []imageToShow = {diamondSmall, null};
//     * 
//     * UtilSoftgames.PaintTextWithImageInLine(canvas,textToShow , imageToShow,
//     * fontMoneyToPay, posX + productItemBackground.getWidth() / 2,
//     * buttonAddProduct.getPosY() + (buttonAddProduct.getImage().getHeight() /
//     * 3)*2);
//     * 
//     * }
//     * 
//     * posX += productItemBackground.getWidth() + diff; }
//     * 
//     * if(canUpgrade){ buttonBuild.setPosX((mCanvasWidth/2) -
//     * buttonBuild.getImage().getWidth()/2); buttonBuild.setPosY(550);
//     * buttonBuild.paint(canvas); } else { canvas.drawBitmap(buttonBuildInactive
//     * , (mCanvasWidth/2) - buttonBuildInactive.getWidth()/2, 550, null); }
//     * 
//     * canvas.drawText(texto[194] +"", mCanvasWidth/2, 550 +
//     * (buttonBuild.getImage().getHeight()/4)*3, fontQuantityMaterialProduce);
//     * 
//     * animationElementChoosed(); Paint_AnimationQuantity(canvas); }
//     */
//
//    private void paintStateAchievements(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[36], texts[37]);
//
//        int diff_Y = backgAllCollections.getHeight() + diffAchivi_Y;
//        int posBackg_X = mCanvasWidth / 2 - backgAllCollections.getWidth() / 2;
//        int posBackg_Y = spaceBetBorderBackgrSuper;
//        int addPage = 2;
//        int totalPage = 4;
//        int diff_X = 0;
//
//        if (animationScrolling) {
//
//            canvas.save();
//            canvas.translate(0, 0);
//            canvas.clipRect(buttonArrow.getPosX()
//                    + buttonArrow.getImage().getWidth(), 0,
//                    buttonArrowRigth.getPosX(), mCanvasHeight);
//            if (scrollingLeft) {
//                if (pageAchievements + 2 > 20) {
//                    animationScrolling = false;
//                    return;
//                }
//                diff_X = (mCanvasWidth / 2 - backgAllCollections.getWidth() / 2)
//                        + backgAllCollections.getWidth() + achievementsDiffX;
//                totalPage = 4;
//                addPage = 2;
//            } else {
//                if (pageAchievements - 2 < 0) {
//                    animationScrolling = false;
//                    return;
//                }
//                totalPage = -4;
//                addPage = -2;
//                diff_X = -((mCanvasWidth / 2 - backgAllCollections.getWidth() / 2))
//                        - backgAllCollections.getWidth() - achievementsDiffX;
//            }
//
//            int i = pageAchievements;
//            do {
//                posBackg_Y = spaceBetBorderBackgrSuper;
//
//                paintAchievements(canvas, i,
//                        posBackg_X + scrollingCollection_X, posBackg_Y);
//
//                posBackg_Y += diff_Y;
//
//                if (i + 1 != Constants.NUMBER_ACHIEVEMENTS) {
//                    paintAchievements(canvas, i + 1, posBackg_X
//                            + scrollingCollection_X, posBackg_Y);
//                }
//
//                posBackg_X += diff_X;
//                i += addPage;
//            } while (i != totalPage + pageAchievements);
//            canvas.restore();
//        } else {
//            paintAchievements(canvas, pageAchievements, posBackg_X, posBackg_Y);
//
//            posBackg_Y += diff_Y;
//
//            if (pageAchievements + 1 != Constants.NUMBER_ACHIEVEMENTS) {
//                paintAchievements(canvas, pageAchievements + 1, posBackg_X,
//                        posBackg_Y);
//            }
//
//        }
//
//        buttonBack.paint(canvas);
//
//        if (pageAchievements != 0) {
//            buttonArrow.paint(canvas);
//        }
//
//        if (pageAchievements + 1 != Constants.NUMBER_ACHIEVEMENTS) {
//            buttonArrowRigth.setPosX(mCanvasWidth / 2
//                    + backgroundGeneral.getWidth() / 2
//                    - buttonArrowRigth.getImage().getWidth());
//            buttonArrowRigth.paintFlip(canvas);
//        }
//
//        paintIndicatorPages(canvas, Constants.NUMBER_ACHIEVEMENTS,
//                pageAchievements / 2,
//                mCanvasHeight / 2 + backgroundGeneral.getHeight() / 2
//                        - buttonPagesActive.getHeight());
//
//        animationElementChosen();
//        scrollingCollection(false);
//
//    }
//
//    private int quantityBarProgressAchievements(int type) {
//
//        float quantity = 0;
//        try {
//
//            float prom = (Constants.CURRENT_QUANTITY_ACHIEVEMENTS[type] * 100);
//            prom = prom
//                    / Constants.ACHIEVEMENTS_INFO[type][(Constants.LEVEL_ACHIEVEMENTS[type] * 2)];
//            prom = prom / 100;
//            quantity = barProgressAchievementsFull.getWidth() * prom;
//        } catch (Exception e) {
//            System.out.println("error");
//        }
//
//        return (int) quantity;
//    }
//
//    private void paintAchievements(Canvas canvas, int type, int posX, int posY) {
//        int posBackgCollections_X = posX + achievementsOffsetX;
//        int posBackgCollections_Y = posY + backgAllCollections.getHeight()
//                - backgRewardCollections.getHeight() - 5;
//
//        canvas.drawBitmap(backgAllCollections, posX, posY, null);
//
//        canvas.drawText(texts[Constants.NAME_ACHIEVEMENTS[type]], posX
//                + addNameAchie_X, posY + addNameAchie_Y, fontQuantityItemSell);
//
//        canvas.drawBitmap(
//                achievementsBackgIcon,
//                posBackgCollections_X,
//                posBackgCollections_Y - addIconAchi_Y
//                        - achievementsBackgIcon.getHeight(), null);
//        canvas.drawBitmap(
//                iconAchievements[type],
//                posBackgCollections_X + achievementsBackgIcon.getWidth() / 2
//                        - iconAchievements[type].getWidth() / 2,
//                posBackgCollections_Y - addIconAchi_Y
//                        - achievementsBackgIcon.getHeight() / 2
//                        - iconAchievements[type].getHeight() / 2, null);
//
//        canvas.drawBitmap(barProgressAchievements, posBackgCollections_X
//                + achievementsBackgIcon.getWidth(), posBackgCollections_Y - 20
//                - barProgressAchievements.getHeight(), null);
//
//        paintAnimationBarLoading(
//                canvas,
//                barProgressAchievementsFull,
//                posBackgCollections_X + achievementsBackgIcon.getWidth(),
//                posBackgCollections_Y - 20
//                        - barProgressAchievements.getHeight(),
//                posBackgCollections_X + achievementsBackgIcon.getWidth()
//                        + quantityBarProgressAchievements(type),
//                posBackgCollections_Y - 20);
//
//        paintDivisionText(
//                canvas,
//                texts[Constants.NAME_ACHIEVEMENTS[type] + 1]
//                        .replaceAll(
//                                "%",
//                                Constants.ACHIEVEMENTS_INFO[type][(Constants.LEVEL_ACHIEVEMENTS[type] * 2)]
//                                        + ""), posBackgCollections_X
//                        + backgAllCollections.getWidth() / 2, posY
//                        + infoAchiviements_Y, 25, 30, posY + infoAchiviements_Y
//                        + 10, fontQuantityMaterialProduce);
//
//        canvas.drawBitmap(backgRewardCollections, posBackgCollections_X,
//                posBackgCollections_Y, null);
//
//        String[] auxString = { texts[179]
//                + " "
//                + Constants.ACHIEVEMENTS_INFO[type][(Constants.LEVEL_ACHIEVEMENTS[type] * 2) + 1] };
//        Bitmap aux = (Constants.LEVEL_ACHIEVEMENTS[type] < 4)? coinSmall : diamondSmall;
//        Bitmap[] auxBitmap = { aux };
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontAttriItemShop, posBackgCollections_X
//                        + backgRewardCollections.getWidth() / 2,
//                posBackgCollections_Y
//                        + (backgRewardCollections.getHeight() / 3) * 2);
//
//        int posCashIn_X = posX + backgAllCollections.getWidth()
//                - buttonCashIn.getWidth() - 20;
//        int posCashIn_Y = posY + backgAllCollections.getHeight() / 2
//                - buttonCashIn.getHeight() / 2;
//
//        int diff_X = 5;
//        int star_X = (posCashIn_X + buttonCashIn.getWidth() / 2)
//                - ((starCollectionFull.getWidth() + diff_X) * 5) / 2;
//        int star_Y = posCashIn_Y - starCollectionFull.getHeight() - 2;
//        for (int i = 0; i < 5; i++) {
//
//            if (Constants.LEVEL_ACHIEVEMENTS[type] > i) {
//                canvas.drawBitmap(starCollectionFull, star_X, star_Y, null);
//            } else {
//                canvas.drawBitmap(starCollectionEmpty, star_X, star_Y, null);
//            }
//
//            star_X += starCollectionFull.getWidth() + diff_X;
//        }
//
//        if (Constants.CURRENT_QUANTITY_ACHIEVEMENTS[type] >= Constants.ACHIEVEMENTS_INFO[type][(Constants.LEVEL_ACHIEVEMENTS[type] * 2)]
//                && !Constants.COMPLETE_ACHIEVEMENTS[type]) {
//            canvas.drawBitmap(buttonCashIn, posCashIn_X, posCashIn_Y, null);
//            canvas.drawText(
//                    texts[180],
//                    posBackgCollections_X + achievementsBackgIcon.getWidth()
//                            + barProgressAchievementsFull.getWidth() / 2,
//                    posBackgCollections_Y - 20
//                            - barProgressAchievements.getHeight() / 3,
//                    fontQuantityMaterialProduce);
//
//            if (tutorialGame && type == 9) {
//                paintAnimationCursor(
//                        canvas,
//                        posCashIn_X + buttonCashIn.getWidth() / 2
//                                - cursorHand.getWidth() / 2,
//                        posCashIn_Y + buttonCashIn.getHeight() / 2
//                                - cursorHand.getHeight() / 2 + cursorY, -1);
//            }
//
//        } else {
//
//            canvas.drawText(
//                    Constants.CURRENT_QUANTITY_ACHIEVEMENTS[type]
//                            + "/"
//                            + Constants.ACHIEVEMENTS_INFO[type][(Constants.LEVEL_ACHIEVEMENTS[type] * 2)],
//                    posBackgCollections_X + achievementsBackgIcon.getWidth()
//                            + barProgressAchievementsFull.getWidth() / 2,
//                    posBackgCollections_Y - 20
//                            - barProgressAchievements.getHeight() / 3,
//                    fontQuantityMaterialProduce);
//
//            canvas.drawBitmap(buttonCashInLocked, posCashIn_X, posCashIn_Y,
//                    null);
//        }
//
//    }
//
//    private void validateAchievements(int type, int quantity) {
//        switch (type) {
//        case Constants.ACHIEVEMENTS_CROPS:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[0] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_COINS:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[3] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_BUILDING:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[11] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_FRIENDS:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[1] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_VEGETATION:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[10] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_EXPANDS:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[9] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_PRODUCTS:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[2] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_UPGRADE_BUILDING:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[12] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_BACON:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[6] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_EGGS:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[4] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_MILK:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[5] += quantity;
//            break;
//        case Constants.ACHIEVEMENTS_WOOL:
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[7] += quantity;
//            break;
//        }
//
//        for (int i = 0; i < Constants.CURRENT_QUANTITY_ACHIEVEMENTS.length; i++) {
//            if (Constants.CURRENT_QUANTITY_ACHIEVEMENTS[i] >= Constants.ACHIEVEMENTS_INFO[i][(Constants.LEVEL_ACHIEVEMENTS[i] * 2)]) {
//                Constants.achiviementsActive = true;
//                break;
//            }
//        }
//    }
//
//    private void paintCollection(Canvas canvas, int type, int posBackg_X,
//            int posBackg_Y) {
//
//        int posStar_X = posBackg_X + backgAllCollections.getWidth() / 2;
//        int posBackgCollections_X = posBackg_X + collectionsBgOffsetX;
//        int posBackgCollections_Y = posBackg_Y + collectionsBgOffsetY;
//
//        canvas.drawBitmap(backgAllCollections, posBackg_X, posBackg_Y, null);
//        canvas.drawBitmap(backgRewardCollections, posBackgCollections_X,
//                posBackg_Y + backgAllCollections.getHeight()
//                        - backgRewardCollections.getHeight() - 5, null);
//
//        canvas.drawText(texts[223 + type], posBackg_X + collectionsTextOffsetX,
//                posBackg_Y + collectionsTextOffsetY, fontAttriItemShop);
//
//        String[] auxString = new String[3];
//        Bitmap[] auxBitmap = new Bitmap[3];
//        int index = 0;
//        for (int a = 0; a < 6; a += 2) {
//            if (a < Constants.rewardCollection[type].length) {
//                auxString[index] = "" + Constants.rewardCollection[type][a];
//                switch (Constants.rewardCollection[type][a + 1]) {
//                case Constants.GOLD:
//                    auxBitmap[index] = coinSmall;
//                    break;
//                case Constants.DIAMONDS:
//                    auxBitmap[index] = diamondSmall;
//                    break;
//                case Constants.XP:
//                    auxBitmap[index] = xpSmall;
//                    break;
//                }
//            } else {
//                auxString[index] = null;
//                auxBitmap[index] = null;
//            }
//            index++;
//        }
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontMoneyToPay,
//                posBackgCollections_X + backgRewardCollections.getWidth() / 2,
//                posBackg_Y + backgAllCollections.getHeight() - 10);
//
//        for (int j = 0; j < 5; j++) {
//
//            if (collectionPut[type].getLevel() > j) {
//                canvas.drawBitmap(starCollectionFull, posStar_X,
//                        posBackg_Y + 8, null);
//            } else {
//                canvas.drawBitmap(starCollectionEmpty, posStar_X,
//                        posBackg_Y + 8, null);
//            }
//
//            canvas.drawBitmap(backgCollections, posBackgCollections_X,
//                    posBackgCollections_Y, null);
//
//            collectionsImages[type].paint(canvas, (j + 1),
//                    posBackgCollections_X + backgCollections.getWidth() / 2
//                            - (collectionsImages[type].auxImage.getWidth() / 5)
//                            / 2,
//                    posBackgCollections_Y + backgCollections.getHeight() / 2
//                            - (collectionsImages[type].auxImage.getHeight())
//                            / 2, collectionsImages[type].auxImage.getHeight(),
//                    collectionsImages[type].auxImage.getWidth() / 5, false,
//                    false, false);
//
//            canvas.drawText(collectionPut[type].getQuantityItems()[j] + "",
//                    posBackgCollections_X + backgCollections.getWidth()
//                            - collectionsTextOffsetX, posBackgCollections_Y
//                            + backgCollections.getHeight()
//                            - collectionsBgOffsetX, fontQuantityMaterialProduce);
//
//            posStar_X += starCollectionFull.getWidth() + 5;
//            posBackgCollections_X += backgCollections.getWidth() + 5;
//        }
//
//        if (showCashIn(type)) {
//            canvas.drawBitmap(
//                    buttonCashIn,
//                    posBackg_X + backgAllCollections.getWidth()
//                            - buttonCashIn.getWidth() - 20, posBackg_Y
//                            + backgAllCollections.getHeight() / 2
//                            - buttonCashIn.getHeight() / 2, null);
//        } else {
//            canvas.drawBitmap(buttonCashInLocked, posBackg_X
//                    + backgAllCollections.getWidth() - buttonCashIn.getWidth()
//                    - 20, posBackg_Y + backgAllCollections.getHeight() / 2
//                    - buttonCashIn.getHeight() / 2, null);
//        }
//    }
//
//    private void paintStateCollections(Canvas canvas) {
//
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[38], texts[39]);
//        int diff_Y = backgAllCollections.getHeight() + collectionsDiffY;
//        int posBackg_X = mCanvasWidth / 2 - backgAllCollections.getWidth() / 2;
//        int posBackg_Y = spaceBetBorderBackgrSuper;
//        int addPage = 2;
//        int totalPage = 4;
//        int diff_X = 0;
//
//        if (animationScrolling) {
//
//            canvas.save();
//            canvas.translate(0, 0);
//            canvas.clipRect(buttonArrow.getPosX()
//                    + buttonArrow.getImage().getWidth(), 0,
//                    buttonArrowRigth.getPosX(), mCanvasHeight);
//            if (scrollingLeft) {
//                if (pageCollection + 2 > 20) {
//                    animationScrolling = false;
//                    return;
//                }
//                diff_X = (mCanvasWidth / 2 - backgAllCollections.getWidth() / 2)
//                        + backgAllCollections.getWidth() + collectionsDiffX;
//                totalPage = 4;
//                addPage = 2;
//            } else {
//                if (pageCollection - 2 < 0) {
//                    animationScrolling = false;
//                    return;
//                }
//                totalPage = -4;
//                addPage = -2;
//                diff_X = -((mCanvasWidth / 2 - backgAllCollections.getWidth() / 2))
//                        - backgAllCollections.getWidth() - collectionsDiffX;
//            }
//
//            // for(int i = pageCollection; i < pageCollection + totalPage; i
//            // += addPage){
//            int i = pageCollection;
//            do {
//                posBackg_Y = spaceBetBorderBackgrSuper;
//
//                paintCollection(canvas, i, posBackg_X + scrollingCollection_X,
//                        posBackg_Y);
//
//                posBackg_Y += diff_Y;
//
//                if (i + 1 != 22) {
//                    paintCollection(canvas, i + 1, posBackg_X
//                            + scrollingCollection_X, posBackg_Y);
//                }
//
//                posBackg_X += diff_X;
//                i += addPage;
//            } while (i != totalPage + pageCollection);
//            canvas.restore();
//        } else {
//            paintCollection(canvas, pageCollection, posBackg_X, posBackg_Y);
//
//            posBackg_Y += diff_Y;
//
//            if (pageCollection + 1 != 22) {
//                paintCollection(canvas, pageCollection + 1, posBackg_X,
//                        posBackg_Y);
//                // buttonArrowRigth.paintFlip(canvas);
//            }
//        }
//        buttonBack.paint(canvas);
//
//        if (pageCollection != 0) {
//            buttonArrow.paint(canvas);
//        }
//
//        if (pageCollection + 1 != 21) {
//            buttonArrowRigth.setPosX(mCanvasWidth / 2
//                    + backgroundGeneral.getWidth() / 2
//                    - buttonArrowRigth.getImage().getWidth());
//            buttonArrowRigth.paintFlip(canvas);
//        }
//
//        animationElementChosen();
//        scrollingCollection(true);
//
//        paintIndicatorPages(canvas, 21, pageCollection / 2,
//                mCanvasHeight / 2 + backgroundGeneral.getHeight() / 2
//                        - buttonPagesActive.getHeight());
//    }
//
//    private void paintIndicatorPages(Canvas canvas, int items, int pageUsed,
//            int posIndicator_Y) {
//        int addPageAux = (items % 3 == 0) ? 0 : 1;
//        nPages = items / 2 + addPageAux;
//
//        int posButtonPage_X = mCanvasWidth / 2
//                - ((buttonPagesActive.getWidth() + 2) * nPages) / 2;
//        int posButtonPage_Y = posIndicator_Y;
//        for (int i = 0; i <= nPages; i++) {
//            if (i == pageUsed) {
//                canvas.drawBitmap(buttonPagesActive, posButtonPage_X,
//                        posButtonPage_Y, null);
//            } else {
//                canvas.drawBitmap(buttonPages, posButtonPage_X,
//                        posButtonPage_Y, null);
//            }
//
//            posButtonPage_X += buttonPagesActive.getWidth() + 2;
//        }
//    }
//
//    private void scrollingCollection(boolean isCollection) {
//        if (System.currentTimeMillis() - Time_Scrolling >= 10) {
//            Time_Scrolling = System.currentTimeMillis();
//            if (animationScrolling) {
//                if (scrollingLeft) {
//
//                    // pageCollection += 2;
//
//                    scrollingCollection_X -= 60;
//
//                    if (scrollingCollection_X < -(mCanvasWidth / 2 - backgAllCollections
//                            .getWidth() / 2)
//                            - backgAllCollections.getWidth()
//                            - 20) {
//                        scrollingCollection_X = 0;
//                        animationScrolling = false;
//                        if (isCollection) {
//                            pageCollection += 2;
//                        } else {
//                            pageAchievements += 2;
//                        }
//                    }
//                } else {
//
//                    scrollingCollection_X += 60;
//                    if (scrollingCollection_X > ((mCanvasWidth / 2 - backgAllCollections
//                            .getWidth() / 2) + 20)
//                            + backgAllCollections.getWidth()) {
//                        scrollingCollection_X = 0;
//                        animationScrolling = false;
//                        if (isCollection) {
//                            pageCollection -= 2;
//                        } else {
//                            pageAchievements -= 2;
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private void paintStateMoreDiamonds(Canvas canvas) {
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[40], texts[41]);
//
//        int diff_X = backgNoMoney.getWidth() + 10;
//        int diff_Y = backgNoMoney.getHeight() + 10;
//        int posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//        int posY = spaceBetBorderBackgrSuper;
//        for (int i = 0; i < 6; i++) {
//            canvas.drawBitmap(backgNoMoney, posX, posY, null);
//            canvas.drawBitmap(
//                    iconMoreDiamonds[i],
//                    posX + backgNoMoney.getWidth() / 2
//                            - iconMoreDiamonds[i].getWidth() / 2, posY
//                            + backgNoMoney.getHeight() / 2
//                            - iconMoreDiamonds[i].getHeight() / 2, null);
//            canvas.drawText(Integer.toString(Constants.HF3_DIAMONDS[i])
//                    + " Diamonds", posX + backgNoMoney.getWidth() / 2
//                    - iconMoreDiamonds[i].getWidth() / 2
//                    + moreCurrencyItemOffsetX, posY + backgNoMoney.getHeight()
//                    / 2 - iconMoreDiamonds[i].getHeight() / 2 - 10,
//                    fontNameItems);
//            posX += diff_X;
//            if (i == 2) {
//                posY += diff_Y;
//                posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//            }
//        }
//        buttonArrow.paint(canvas);
//
//        infoIcon.setPosY(mCanvasHeight / 2 - backgroundGeneral.getHeight() / 2
//                + 20);
//        infoIcon.setPosX(mCanvasWidth / 2 - backgroundGeneral.getWidth() / 2
//                + infoIcon.getImage().getWidth());
//        infoIcon.paint(canvas);
//
//        animationElementChosen();
//    }
//
//    private void paintStateMoreCoins(Canvas canvas) {
//        paintBackGeneral(canvas);
//
//        paintTitleGeneral(canvas, texts[42], texts[43]);
//
//        int diff_X = backgNoMoney.getWidth() + 10;
//        int diff_Y = backgNoMoney.getHeight() + 10;
//        int posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//        int posY = spaceBetBorderBackgrSuper;
//        for (int i = 0; i < 6; i++) {
//            canvas.drawBitmap(backgNoMoney, posX, posY, null);
//            canvas.drawBitmap(
//                    iconMoreCoins[i],
//                    posX + backgNoMoney.getWidth() / 2
//                            - iconMoreCoins[i].getWidth() / 2,
//                    posY + backgNoMoney.getHeight() / 2
//                            - iconMoreCoins[i].getHeight() / 2, null);
//
//            canvas.drawText(
//                    Integer.toString(Constants.HF3_COINS[i]) + " Coins",
//                    posX + backgNoMoney.getWidth() / 2
//                            - iconMoreCoins[i].getWidth() / 2
//                            + moreCurrencyItemOffsetX,
//                    posY + backgNoMoney.getHeight() / 2
//                            - iconMoreCoins[i].getHeight() / 2 - 10,
//                    fontNameItems);
//
//            posX += diff_X;
//            if (i == 2) {
//                posY += diff_Y;
//                posX = mCanvasWidth / 2 - (diff_X * 3) / 2;
//            }
//        }
//        buttonArrowRigth.paintFlip(canvas);
//
//        animationElementChosen();
//
//    }
//
//    private void paintStateNoFood(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[33], texts[34]);
//
//        int diff = productItemBackground.getWidth() + 20;
//        int posX = mCanvasWidth / 2 - (diff * 3) / 2;
//        int posY = posNoFood_Y;
//        int[] diamondsFood = { 0, Constants.SMALL_PKG_FOOD_PRICE,
//                Constants.BIG_PKG_FOOD_PRICE };
//        int[] quantityFood = { 0, Constants.SMALL_PKG_FOOD_QUANTITY,
//                Constants.BIG_PKG_FOOD_QUANTITY };
//
//        for (int i = 0; i < 3; i++) {
//            canvas.drawBitmap(productItemBackground, posX, posY, null);
//            canvas.drawBitmap(
//                    iconNoFood[i],
//                    posX + productItemBackground.getWidth() / 2
//                            - iconNoFood[i].getWidth() / 2, posY
//                            + productItemBackground.getHeight() / 2
//                            - iconNoFood[i].getHeight(), null);
//
//            buttonAddProduct.setPosX(posX + productItemBackground.getWidth()
//                    / 2 - buttonAddProduct.getImage().getWidth() / 2);
//            buttonAddProduct.setPosY(posY + productItemBackground.getHeight()
//                    - buttonAddProduct.getImage().getHeight() / 2);
//
//            if (i == 0) {
//                buttonAddProduct.paint(canvas);
//            }
//
//            if (i > 0) {
//                if (!tutorialGame) {
//
//                    buttonAddProduct.paint(canvas);
//                    canvas.drawText("+" + quantityFood[i] + " " + texts[35],
//                            posX + productItemBackground.getWidth() / 2, posY
//                                    + productItemBackground.getHeight()
//                                    - (productItemBackground.getHeight() / 3),
//                            fontQuantityMaterialProduce);
//
//                    String[] textToShow = { texts[16] + " (" + diamondsFood[i],
//                            ")" };
//                    Bitmap[] imageToShow = { diamondSmall, null };
//
//                    UtilSoftgames
//                            .PaintTextWithImageInLine(canvas, textToShow,
//                                    imageToShow, fontMoneyToPay, posX
//                                            + productItemBackground.getWidth()
//                                            / 2, buttonAddProduct.getPosY()
//                                            + (buttonAddProduct.getImage()
//                                                    .getHeight() / 3) * 2);
//
//                }
//            } else {
//                canvas.drawText(texts[183],
//                        posX + productItemBackground.getWidth() / 2, posY
//                                + productItemBackground.getHeight()
//                                - (productItemBackground.getHeight() / 3),
//                        fontQuantityMaterialProduce);
//
//                canvas.drawText(texts[29],
//                        posX + productItemBackground.getWidth() / 2,
//                        buttonAddProduct.getPosY()
//                                + (buttonAddProduct.getImage().getHeight() / 3)
//                                * 2, fontQuantityMaterialProduce);
//
//                if (tutorialGame) {
//                    paintAnimationCursor(canvas, buttonAddProduct.getPosX()
//                            + buttonAddProduct.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                            buttonAddProduct.getPosY()
//                                    + buttonAddProduct.getImage().getHeight()
//                                    / 2 - cursorHand.getHeight() / 2 + cursorY,
//                            -1);
//                }
//
//            }
//            posX += diff;
//        }
//
//        animationElementChosen();
//        if (tutorialGame) {
//            paintInfoTutorial(canvas, 0);
//        }
//
//    }
//
//    private void paintStateQuestExpansion(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[31], texts[32]);
//
//        canvas.drawBitmap(backExpand,
//                (mCanvasWidth / 2) / 2 - backExpand.getWidth() / 2,
//                posBackgExpand_Y, null);
//        canvas.drawBitmap(
//                opcExpand1,
//                (mCanvasWidth / 2) / 2 - opcExpand1.getWidth() / 2,
//                posBackgExpand_Y + backExpand.getHeight() / 2
//                        - opcExpand1.getHeight() / 2, null);
//
//        canvas.drawText(texts[276], (mCanvasWidth / 2) / 2,
//                posBackgExpand_Y + 40, fontQuantityMaterialProduce);
//
//        canvas.drawText(texts[277], (mCanvasWidth / 2) / 2, posBackgExpand_Y
//                + backExpand.getHeight() - 40, fontQuantityMaterialProduce);
//
//        canvas.drawBitmap(backExpand, (mCanvasWidth / 2) + mCanvasWidth / 4
//                - backExpand.getWidth() / 2, posBackgExpand_Y, null);
//
//        canvas.drawBitmap(
//                opcExpand2,
//                (mCanvasWidth / 2) + mCanvasWidth / 4 - opcExpand2.getWidth()
//                        / 2,
//                posBackgExpand_Y + backExpand.getHeight() / 2
//                        - opcExpand2.getHeight() / 2, null);
//
//        canvas.drawText(texts[278], (mCanvasWidth / 2) + mCanvasWidth / 4,
//                posBackgExpand_Y + 40, fontQuantityMaterialProduce);
//
//        canvas.drawText(texts[279], (mCanvasWidth / 2) + mCanvasWidth / 4,
//                posBackgExpand_Y + backExpand.getHeight() - 40,
//                fontQuantityMaterialProduce);
//
//        canvas.drawText(texts[280], (mCanvasWidth / 2),
//                posBackgExpand_Y + backExpand.getHeight() / 2
//                        + (fontQuantityMaterialProduce.getTextSize() / 2),
//                fontQuantityMaterialProduce);
//
//        buttonBuild.setPosX((mCanvasWidth / 2) + mCanvasWidth / 4
//                - buttonBuildInactive.getWidth() / 2);
//        buttonBuild.setPosY(posButtonExpand_Y);
//        buttonBuild.paint(canvas);
//
//        canvas.drawBitmap(buttonBuildInactive, (mCanvasWidth / 2) / 2
//                - buttonBuild.getImage().getWidth() / 2, posButtonExpand_Y,
//                null);
//
//        String[] auxString = { texts[275] + " "
//                + Constants.EXPANSION_COINS[Constants.currentExpansion] };
//        Bitmap[] auxBitmap = { coinSmall };
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontMoneyToPay, (mCanvasWidth / 2) / 2, buttonBuild.getPosY()
//                        + ((buttonBuildInactive.getHeight() / 3) * 2));
//
//        String[] auxString1 = { texts[275] + " "
//                + Constants.EXPANSION_DIAMOND[Constants.currentExpansion] };
//        Bitmap[] auxBitmap1 = { diamondSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString1, auxBitmap1,
//                fontMoneyToPay, (int) ((mCanvasWidth / 2) + mCanvasWidth / 4),
//                buttonBuild.getPosY()
//                        + ((buttonBuildInactive.getHeight() / 3) * 2));
//
//        if (tutorialGame) {
//            paintAnimationCursor(canvas,
//                    buttonBuild.getPosX() + buttonBuild.getImage().getWidth()
//                            / 2 - cursorHand.getWidth() / 2,
//                    buttonBuild.getPosY() + buttonBuild.getImage().getHeight()
//                            / 2 - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        animationElementChosen();
//    }
//
//    // FIXME Facebook paintStateFacebook
//    private void paintStateFacebook(Canvas canvas) {
//
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[252], texts[253]);
//        String buttonConnectText = "";
//
//        /*if (Utility.mFacebook.isSessionValid()) {
//            String query = "SELECT name, current_location, uid, pic_square FROM user WHERE is_app_user  AND uid IN (SELECT uid2 FROM friend WHERE uid1 = me())  order by name";
//            Bundle params = new Bundle();
//            params.putString("method", "fql.query");
//            params.putString("query", query);
//            try {
//                Utility.mAsyncRunner.request(null, params,
//                        main.gameCanvas.new FriendsRequestListener());
//            } catch (Exception e) {
//             Log.e(TAG, "paintStateFacebook", e);
//            }
// 
//        }*/
//
//        buttonInvite.paint(canvas);
//
//        if (Utility.mFacebook.isSessionValid()) {
//            buttonConnectText = texts[256];
//        } else {
//            buttonConnectText = texts[255];
//        }
//
//        canvas.drawText(buttonConnectText, buttonInvite.getPosX()
//                + buttonInvite.getImage().getWidth() / 2,
//                buttonInvite.getPosY()
//                        + (buttonInvite.getImage().getHeight() / 3) * 2,
//                fontQuantityMaterialProduce);
//
//        buttonAddHelper.paint(canvas);
//
//        canvas.drawText(texts[257], buttonAddHelper.getPosX()
//                + buttonAddHelper.getImage().getWidth() / 2
//                + facebookOffsetHelperTextX, buttonAddHelper.getPosY()
//                + (buttonAddHelper.getImage().getHeight() / 3) * 2,
//                fontQuantityMaterialProduce);
//
//        canvas.drawBitmap(diamondSmall, buttonAddHelper.getPosX()
//                + buttonAddHelper.getImage().getWidth()
//                - facebookOffsetDiamondX, buttonAddHelper.getPosY()
//                + (buttonAddHelper.getImage().getHeight() / 2)
//                - facebookOffsetDiamondY, fontQuantityMaterialProduce);
//
//        int friendsAmount_X = mCanvasWidth / 2 - friendsAmount.getWidth() - 20;
//        int friendsAmount_Y = mCanvasHeight / 2 - friendsAmount.getHeight() / 2
//                - posButtonFriendsAmountY;
//        canvas.drawBitmap(friendsAmount, friendsAmount_X, friendsAmount_Y, null);
//
//        String[] auxString = {
//                (((totalfriends) * .5) > 20) ? "20 % " : ((totalfriends) * .5)
//                        + "% ", "BONUS" };
//        Bitmap[] auxBitmap = { coinSmall, null };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontMoneyToPay, friendsAmount_X + friendsAmount.getWidth() / 2,
//                friendsAmount_Y + friendsAmount.getHeight()
//                        + facebookOffsetToPayY);
//
//        canvas.drawText(texts[254], friendsAmount_X + friendsAmount.getWidth()
//                / 2, friendsAmount_Y - 5, fontQuantityMaterialProduce);
//
//        canvas.drawText((totalfriends) + "",
//                mCanvasWidth / 2 - friendsAmount.getWidth() - 10
//                        + friendsAmount.getWidth() / 2, mCanvasHeight / 2
//                        - facebookTotalFriendsOffsetY,
//                fontQuantityMaterialProduce);
//
//        int pos_Backg_Item_X = mCanvasWidth / 2
//                - ((itemBackgFace.getWidth() + diffItemButtonFriends) * 3) / 2;
//
//        int pos_Backg_Item_Y = faceFriends_Y;
//
//        try {
//            for (int i = 0; i < 3; i++) {
//                canvas.drawBitmap(itemBackgFace, pos_Backg_Item_X,
//                        pos_Backg_Item_Y, null);
//
//                // if (i == indexProFace + 2) {
//                // canvas.drawBitmap(buttonFacebook,
//                // pos_Backg_Item_X + itemBackgFace.getWidth() / 2
//                // - buttonFacebook.getWidth() / 2,
//                // pos_Backg_Item_Y + itemBackgFace.getHeight() / 2
//                // - buttonFacebook.getHeight() / 2, null);
//                //
//                // } else {
//
//                if (profilesFace != null && !profilesFace.isEmpty() && profilesFace.get(i).getPicture() != null) {
//                    canvas.drawBitmap(profilesFace.get(i).getPicture(),
//                            pos_Backg_Item_X
//                                    + itemBackgFace.getWidth()
//                                    / 2
//                                    - profilesFace.get(i).getPicture()
//                                            .getWidth() / 2, pos_Backg_Item_Y
//                                    + itemBackgFace.getHeight()
//                                    / 2
//                                    - profilesFace.get(i).getPicture()
//                                            .getHeight() / 2 - 10, null);
//
//                }
//
//                // }
//                pos_Backg_Item_X += itemBackgFace.getWidth()
//                        + diffItemButtonFriends;
//
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "paintStateFacebook()", e);
//        }
//        
//        animationElementChosen();
//    }
//
//    private void paintStateFeedMill(Canvas canvas) {
//        //loadImages();
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[26], texts[27]);
//        int posItem_X = 5 + buttonArrow.getPosX()
//                + buttonArrow.getImage().getWidth();
//        int diffItem_X = 6;
//        paintSquare(canvas, posItem_X - 3, squareStorage[0], squareStorage[1],
//                squareStorage[2], 0xff0d2e4f);
//
//        int posItem_Y = initPosStorage_Y;
//        Bitmap imageAux = null;
//        String nameCropsAux = "";
//        int foodByCrops = 0;
//        
//        canvas.drawBitmap(backgItemStorage,
//                (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                        - spaceBetBorderBackgr - backgItemStorage.getWidth(),
//                posItem_Y, null);
//
//        if (buildingsPut[2].getUpdgrade() + 1 < 6) {
//            buttonUpgrade.setPosX(buttonClose.getPosX()
//                    - buttonUpgrade.getImage().getWidth() - 10);
//            buttonUpgrade.setPosY(buttonClose.getPosY() + 40);
//            buttonUpgrade.paintWithText(canvas, texts[194],
//                    fontWhiteSmallCenter, 10, 0);
//
//        }
//
//        selectAll.setPosX((mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                - spaceBetBorderBackgr - backgItemStorage.getWidth() / 2
//                - (selectAll.getImage().getWidth()) / 2);
//        selectAll.setPosY(posItem_Y + backgItemStorage.getHeight() / 2
//                - selectAll.getImage().getHeight() / 2 - 8);
//
//        if (storageChosen != -1
//                && quantityCropForFood == getQuantityProductInStorage(storageChosen)) {
//            desSelectAll.setPosX(selectAll.getPosX());
//            desSelectAll.setPosY(selectAll.getPosY());
//            desSelectAll.paintWithText(canvas, texts[430],
//                    fontQuantityMaterialProduce, 0, 0);
//        } else {
//            selectAll.paintWithText(canvas, texts[430],
//                    fontQuantityMaterialProduce, 0, 0);
//        }
//
//        if (tutorialGame && stepInAuxTutorial == 1) {
//            paintAnimationCursor(canvas,
//                    selectAll.getPosX() + selectAll.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                    selectAll.getPosY() + selectAll.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        buttonAddProduct.setPosX((mCanvasWidth / 2 + backgroundGeneral
//                .getWidth() / 2)
//                - spaceBetBorderBackgr
//                - backgItemStorage.getWidth()
//                / 2
//                - buttonAddProduct.getImage().getWidth() / 2);
//        buttonAddProduct.setPosY(posItem_Y + backgItemStorage.getHeight()
//                - buttonAddProduct.getImage().getHeight() - 15);
//        buttonAddProduct.paint(canvas);
//        canvas.drawText(texts[29], buttonAddProduct.getPosX()
//                + buttonAddProduct.getImage().getWidth() / 2,
//                buttonAddProduct.getPosY()
//                        + (buttonAddProduct.getImage().getHeight() / 3) * 2,
//                fontMsjTitle);
//
//        canvas.drawText(texts[28], buttonAddProduct.getPosX()
//                + buttonAddProduct.getImage().getWidth() / 2, posItem_Y
//                + (backgItemStorage.getHeight() / 3) * 2 - 25,
//                fontAnimationQuantity);
//
//        if (tutorialGame && stepInAuxTutorial == 2) {
//            paintAnimationCursor(canvas,
//                    buttonAddProduct.getPosX()
//                            + buttonAddProduct.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                    buttonAddProduct.getPosY()
//                            + buttonAddProduct.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        canvas.drawBitmap(foodSmall,
//                buttonAddProduct.getPosX()
//                        + buttonAddProduct.getImage().getWidth() / 2
//                        - foodSmall.getWidth() - 10, posItem_Y
//                        + (backgItemStorage.getHeight() / 3) * 2 - 8, null);
//
//        canvas.drawText("x " + quantityFoodProduce, buttonAddProduct.getPosX()
//                + buttonAddProduct.getImage().getWidth() / 2 + 10, posItem_Y
//                + (backgItemStorage.getHeight() / 3) * 2 + 25,
//                fontQuantityItemSell);
//
//        int diffBetIconQuanti = 10;
//        int nItemCorrect = calculateNPageFeedMill();
//
//        int initItem = -9;
//        int finItem = 0;
//        if (indexCorrectStorage <= 9) {
//            finItem = indexCorrectStorage;
//            initItem = 0;
//        } else {
//            do {
//                initItem += 9;
//                finItem += 9;
//            } while (finItem < pageInStorage * 9);
//
//            if (finItem > indexCorrectStorage) {
//                finItem = indexCorrectStorage;
//            }
//        }
//
//        nPageTotal = nItemCorrect;
//        int add = ((nPageTotal % 9) == 0) ? 0 : 1;
//        nPageTotal = (nPageTotal / 9) + add;
//
//        for (int i = initItem; i < finItem; i++) {
//            canvas.drawBitmap(taskItemBackg, posItem_X, posItem_Y, null);
//
//            if (storageChosen == itemCorrectStorage[i]) {
//                canvas.drawBitmap(
//                        taskSelected,
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                - taskSelected.getWidth() / 2, posItem_Y
//                                + addTaskSelect_Y, null);
//
//                nameCropsAux = texts[Constants.CROPS_NAME[itemCorrectStorage[i]]];
//                imageAux = iconCrops[itemCorrectStorage[i]];
//                foodByCrops = Constants.CROPS_FOOD[itemCorrectStorage[i]];
//            }
//
//            canvas.drawBitmap(iconCrops[itemCorrectStorage[i]], posItem_X
//                    + taskItemBackg.getWidth() / 2
//                    - iconCrops[itemCorrectStorage[i]].getWidth()
//                    - diffBetIconQuanti, posItem_Y + taskItemBackg.getHeight()
//                    / 2 - iconCrops[itemCorrectStorage[i]].getHeight() / 2,
//                    null);
//
//            if (i == 0 && tutorialGame && stepInAuxTutorial == 0) {
//                paintAnimationCursor(
//                        canvas,
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                - cursorHand.getWidth() / 2,
//                        posItem_Y + taskItemBackg.getHeight() / 2
//                                - cursorHand.getHeight() / 3 + cursorY, -1);
//            }
//            int totalQuanityCrop = getQuantityProductInStorage(itemCorrectStorage[i]);
//            if (Constants.CROPS_ACTIVE_IN_FEED_MILL[itemCorrectStorage[i]] > buildingsPut[2]
//                    .getUpdgrade()) {
//
//                canvas.drawBitmap(taskItemBackgBlock, posItem_X, posItem_Y,
//                        null);
//
//                canvas.drawText(texts[146],
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                + diffBetIconQuanti,
//                        posItem_Y + (taskItemBackg.getHeight() / 3) * 2 - 20,
//                        fontNameItemMarket);
//
//            } else if (totalQuanityCrop == 0) {
//                canvas.drawBitmap(taskItemBackgBlock, posItem_X, posItem_Y,
//                        null);
//
//                canvas.drawText("x "
//                        + totalQuanityCrop,
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                + diffBetIconQuanti,
//                        posItem_Y + (taskItemBackg.getHeight() / 3) * 2 - 20,
//                        fontQuantityItemSell);
//
//            } else {
//                canvas.drawText("x "
//                        + totalQuanityCrop,
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                + diffBetIconQuanti,
//                        posItem_Y + (taskItemBackg.getHeight() / 3) * 2 - 20,
//                        fontQuantityItemSell);
//            }
//
//            posItem_X += taskItemBackg.getWidth() + diffItem_X;
//            if (i == initItem + 2 || i == initItem + 5) {
//                posItem_X = 10 + buttonArrow.getPosX()
//                        + buttonArrow.getImage().getWidth();
//                posItem_Y += taskItemBackg.getHeight() + 5;
//            }
//        }
//
//        if (pageInStorage > 1) {
//            buttonArrow.paint(canvas);
//        }
//
//        if (pageInStorage < nPageTotal) {
//            buttonArrowRigth.setPosX(arrowRightOffsetX);
//            buttonArrowRigth.paintFlip(canvas);
//        }
//
//        if (imageAux != null) {
//
//            canvas.drawText(
//                    nameCropsAux,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2, nameCropsAux_Y,
//                    fontNameItems);
//
//            canvas.drawBitmap(
//                    imageAux,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2
//                            - imageAux.getWidth() - 10, imageAuxFeedMill_Y,
//                    null);
//
//            canvas.drawText(
//                    "x " + quantityCropForFood,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2) + 10
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2,
//                    quantityCropForFood_Y, fontQuantityItemSell);
//
//            canvas.drawText(texts[100] + " x " + foodByCrops,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            - foodByCropsText_X - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2,
//                    foodByCropsText_Y, fontQuantityItemSell);
//
//            canvas.drawBitmap(foodMini,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            + foodMini_X - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2, foodMini_Y, null);
//
//        } else {
//            canvas.drawText(
//                    texts[75],
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2,
//                    chooseItemStor_Y, fontNameItemMarket);
//        }
//
//        canvas.drawBitmap(backgroundPage,
//                mCanvasWidth / 2 - backgroundPage.getWidth() / 2
//                        - restPageStorage_X,
//                mCanvasHeight - backgroundPage.getHeight(), null);
//
//        int posButtonPage_X = mCanvasWidth / 2
//                - ((buttonPagesActive.getWidth() + 2) * nPageTotal) / 2
//                - restPageStorage_X;
//        int posButtonPage_Y = mCanvasHeight - buttonPagesActive.getHeight();
//        for (int i = 1; i <= nPageTotal; i++) {
//            if (i == pageInStorage) {
//                canvas.drawBitmap(buttonPagesActive, posButtonPage_X,
//                        posButtonPage_Y, null);
//            } else {
//                canvas.drawBitmap(buttonPages, posButtonPage_X,
//                        posButtonPage_Y, null);
//            }
//
//            posButtonPage_X += buttonPagesActive.getWidth() + 2;
//        }
//
//        animationElementChosen();
//
//        if (tutorialGame) {
//            paintInfoTutorial(canvas, 140);
//        }
//
//    }
//
//    private void paintStateLevelUp(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[18], texts[19] + " " + (nLevel + 1));
//
//        int diff = 20;
//        int posX = mCanvasWidth / 2
//                - ((productItemBackground.getWidth() + diff) * indexIconAux)
//                / 2;
//        int posY = levelUpInfo_Y;
//
//        canvas.drawText(texts[20], mCanvasWidth / 2, levelUpOffsetTitleY,
//                fontMsjTitle);
//        canvas.drawText(texts[21], mCanvasWidth / 2, levelUpOffsetInfoY,
//                fontAnimationQuantity);
//
//        for (int i = 0; i < indexIconAux; i++) {
//            canvas.drawBitmap(productItemBackground, posX, posY, null);
//            canvas.drawBitmap(iconAuxLevelUp[i],
//                    posX + productItemBackground.getWidth() / 2
//                            - iconAuxLevelUp[i].getWidth() / 2, posY
//                            + productItemBackground.getHeight() / 2
//                            - iconAuxLevelUp[i].getHeight() / 2, null);
//
//            canvas.drawText(nameAuxLevelUp[i],
//                    posX + productItemBackground.getWidth() / 2, posY
//                            + productItemBackground.getHeight()
//                            - fontWhiteSmallCenter.getTextSize() - 4,
//                    fontWhiteSmallCenter);
//
//            posX += productItemBackground.getWidth() + diff;
//        }
//
//        buttonBuild.setPosX((mCanvasWidth / 2) / 2
//                - buttonBuild.getImage().getWidth() / 2);
//        buttonBuild.setPosY(posButtonLevelUp_Y);
//        buttonBuild.paint(canvas);
//
//        canvas.drawBitmap(buttonBuildInactive, (mCanvasWidth / 2)
//                + mCanvasWidth / 4 - buttonBuildInactive.getWidth() / 2,
//                posButtonLevelUp_Y, null);
//
//        canvas.drawText(texts[271],
//                (int) ((mCanvasWidth / 2) + mCanvasWidth / 4),
//                (int) (buttonBuild.getPosY() + ((buttonBuildInactive
//                        .getHeight() / 4) * 3)), fontQuantityMaterialProduce);
//
//        canvas.drawBitmap(
//                diamondSmall,
//                buttonBuild.getImage().getWidth() - levelUpDiamondSmallX,
//                (buttonBuild.getPosY() + ((buttonBuildInactive.getHeight() / 4) * 3))
//                        - diamondSmall.getHeight(), null);
//
//        canvas.drawText(texts[272],
//                buttonBuild.getPosX() + buttonBuildInactive.getWidth() / 2,
//                buttonBuild.getPosY()
//                        + ((buttonBuildInactive.getHeight() / 4) * 3),
//                fontQuantityMaterialProduce);
//
//        if (tutorialGame
//                && (stepTutorial == Constants.STEP_TUTORIAL_FREE || stateGame == Constants.STATE_LEVEL_UP)) {
//            paintAnimationCursor(
//                    canvas,
//                    ((mCanvasWidth / 2) + mCanvasWidth / 4)
//                            - cursorHand.getWidth() / 2, buttonBuild.getPosY()
//                            + buttonBuild.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//        animationElementChosen();
//
//    }
//
//    private void paintAnimationCursor(Canvas canvas, int posX, int posY,
//            int type) {
//        if (animationCursor && itemToChoose == type) {
//            canvas.drawBitmap(cursorHand, posX, posY, null);
//
//            if (System.currentTimeMillis() - Time_AnimationCursor >= 150) {
//                Time_AnimationCursor = System.currentTimeMillis();
//                cursorY = (cursorY == 0) ? 15 : 0;
//                animationArrowMission = (animationArrowMission == 5) ? 10: 5;
//            }
//        }
//    }
//
//    private int numberIndicatorMaster(int[] Limits, int quantity) {
//        int indicator = 0;
//        for (int i = 0; i < 5; i++) {
//            if (quantity >= Limits[i]) {
//                indicator++;
//            } else {
//                break;
//            }
//        }
//        return indicator;
//    }
//
//    private void paintMasteredCrops(Canvas canvas, int posBackgItemShop_X,
//            int posBackgItemShop_Y, int position) {
//        int flower_X = posBackgItemShop_X - ((flowerFull.getWidth() + 2) * 5)
//                / 2 + moveShop_X;
//        int flower_Y = posBackgItemShop_Y + flowerMastered_Y;
//
//        for (int m = 0; m < 5; m++) {
//            if (Constants.CROPS_QUANTITY_LEVELS[Constants.CROPS_ORD[position]] > m) {
//                canvas.drawBitmap(flowerFull, flower_X, flower_Y, null);
//            } else {
//                canvas.drawBitmap(flowerEmpty, flower_X, flower_Y, null);
//            }
//
//            flower_X += flowerFull.getWidth() + 2;
//        }
//
//        int numberFlower = numberIndicatorMaster(
//                Constants.NEED_MASTER_FLOWER_TREE,
//                Constants.TreeQuantity[Constants.CROPS_ORD[position]]);
//
//        int positionMaster = 1;
//        int quantityLess = 0;
//        if (numberFlower > 0) {
//            quantityLess = Constants.NEED_MASTER_FLOWER_TREE[numberFlower - 1];
//        }
//
//        if (numberFlower < 5) {
//            int diffTotal = Constants.NEED_MASTER_FLOWER_TREE[numberFlower]
//                    - quantityLess;
//            int diffParcial = Constants.TreeQuantity[Constants.CROPS_ORD[position]]
//                    - quantityLess;
//
//            if (diffParcial < diffTotal / 5) {
//                positionMaster = 1;
//            } else if (diffParcial < (diffTotal / 5) * 2) {
//                positionMaster = 2;
//            } else if (diffParcial < (diffTotal / 5) * 3) {
//                positionMaster = 3;
//            } else if (diffParcial < (diffTotal / 5) * 4) {
//                positionMaster = 4;
//            } else if (diffParcial < (diffTotal / 5) * 5) {
//                positionMaster = 5;
//            }
//        } else {
//            positionMaster = 1;
//        }
//
//        stadisticMaster.paint(canvas, positionMaster, posBackgItemShop_X
//                + moveShop_X - (stadisticMaster.auxImage.getWidth() / 5) / 2,
//                flower_Y + flowerEmpty.getHeight() + 4,
//                stadisticMaster.auxImage.getHeight(),
//                stadisticMaster.auxImage.getWidth() / 5, false, false, false);
//    }
//
//    private void paintGeneralShop(Canvas canvas, int menuOption, int nItems,
//            String title) {
//        
//        paintBackGeneral(canvas);
//        buttonBack.paint(canvas);
//        buttonArrow.paint(canvas);
//        buttonArrowRigth.setPosX(mCanvasWidth / 2
//                + backgroundGeneral.getWidth() / 2
//                - buttonArrowRigth.getImage().getWidth());
//        buttonArrowRigth.paintFlip(canvas);
//
//        panelDiamonds.setPosX(mCanvasWidth / 2
//                - generalShopOffsetPanelDiamondsX);
//        panelDiamonds.setPosY(posPanelMarket_Y + generalShopOffsetY);
//        panelDiamonds.paint(canvas);
//
//        panelCoins.setPosX(panelDiamonds.getPosX()
//                + panelDiamonds.getImage().getWidth() + 4);
//        panelCoins.setPosY(posPanelMarket_Y + generalShopOffsetY);
//        panelCoins.paint(canvas);
//
//        canvas.drawText(title, buttonBack.getPosX()
//                + buttonBack.getImage().getWidth() + 10, posPanelTitleMarket_Y,
//                fontTitleLeft);
//        canvas.drawText("" + quantityCoins, panelCoins.getPosX()
//                + panelCoins.getImage().getWidth() / 2 + 10,
//                panelCoins.getPosY() + (panelCoins.getImage().getHeight() / 3)
//                        * 2, fontMainUi);
//        canvas.drawText("" + quantityDiamonds, panelDiamonds.getPosX()
//                + panelDiamonds.getImage().getWidth() / 2 + 10,
//                panelDiamonds.getPosY()
//                        + (panelDiamonds.getImage().getHeight() / 3) * 2,
//                fontMainUi);
//
//        int posBackgItemShop_X = mCanvasWidth / 2
//                - ((backgroundItemShop.getWidth() + diffItemGeneralShop) * 3)
//                / 2 - backgroundItemShop.getWidth() + diffItemGeneralShop;
//        int posBackgItemShop_Y = Pos_Init_Market_Y;
//        int posButton_Y = posBackgItemShop_Y + backgroundItemShop.getHeight()
//                - buttonAddProduct.getImage().getHeight();
//
//        canvas.save();
//        canvas.translate(0, 0);
//        canvas.clipRect(posBackgItemShop_X + backgroundItemShop.getWidth()
//                + diffItemGeneralShop, 0, posBackgItemShop_X
//                + ((backgroundItemShop.getWidth() + diffItemGeneralShop) * 4),
//                mCanvasHeight);
//
//        for (int i = startObjects; i < endObjects; i++) {
//
//            if (i >= 0) {
//                switch (menuOption) {
//                case Constants.MARKET_MENU_CROPS_OPTION:
//                    if (i < nItems && iconCrops[i] != null) {
//                        canvas.drawBitmap(backgroundItemShop,
//                                posBackgItemShop_X + moveShop_X,
//                                posBackgItemShop_Y, null);
//
//                        paintMasteredCrops(canvas, posBackgItemShop_X
//                                + backgroundItemShop.getWidth() / 2,
//                                posBackgItemShop_Y, i);
//
//                        canvas.drawText(
//                                texts[97]
//                                        + " "
//                                        + Constants.CROPS_TIME_TO_WIN[Constants.CROPS_ORD[i]]
//                                        + " min(s)",
//                                posBackgItemShop_X + moveShop_X
//                                        + backgroundItemShop.getWidth() / 2,
//                                posBackgItemShop_Y + flowerFull.getHeight()
//                                        + flowerMasteredText_Y,
//                                fontTimeItemShop);
//
//                        canvas.drawText(
//                                texts[Constants.CROPS_NAME[Constants.CROPS_ORD[i]]],
//                                posBackgItemShop_X + moveShop_X
//                                        + backgroundItemShop.getWidth() / 2,
//                                posBackgItemShop_Y + nameItemGeneral_Y,
//                                fontNameItems);
//
//                        canvas.drawBitmap(
//                                iconCrops[i],
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - iconCrops[i].getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - iconCrops[i].getHeight() / 2, null);
//
//                        paintAnimationCursor(
//                                canvas,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - cursorHand.getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - cursorHand.getHeight() / 2 + cursorY,
//                                i);
//
//                        if ((nLevel + 1) < Constants.CROPS_AVAILABLE[i]) {
//                            canvas.drawBitmap(
//                                    lockObject,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth() / 2
//                                            - lockObject.getWidth() / 2
//                                            + moveShop_X,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2 + iconCrops[i].getHeight() / 2
//                                            - lockObject.getHeight(), null);
//
//                            canvas.drawText(
//                                    texts[216] + " "
//                                            + Constants.CROPS_AVAILABLE[i],
//                                    posBackgItemShop_X + moveShop_X
//                                            + backgroundItemShop.getWidth() / 2,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2
//                                            + iconCrops[i].getHeight()
//                                            / 2
//                                            + Constants.fontAnimalfood
//                                                    .getTextSize(),
//                                    Constants.fontAnimalfood);
//
//                        }
//                        canvas.drawBitmap(detailItemShop, posBackgItemShop_X
//                                + backgroundItemShop.getWidth() / 2
//                                - detailItemShop.getWidth() / 2 + moveShop_X,
//                                posButton_Y - detailItemShop.getHeight(), null);
//
//                        canvas.drawBitmap(coinSmall, posBackgItemShop_X
//                                + posPanelCoinMarket_X + moveShop_X,
//                                posButton_Y - detailItemShop.getHeight() / 2
//                                        - coinSmall.getHeight() / 2, null);
//
//                        canvas.drawText(
//                                ""
//                                        + Constants.CROPS_MONEY_TO_WIN[Constants.CROPS_ORD[i]],
//                                posBackgItemShop_X + posPanelCoinMarket_X + 8
//                                        + coinSmall.getWidth() + moveShop_X,
//                                posButton_Y - detailItemShop.getHeight() / 2
//                                        + coinSmall.getHeight() / 4,
//                                fontAttriItemShop);
//
//                        canvas.drawBitmap(xpSmall, posBackgItemShop_X
//                                + posPanelXpMarket_X + moveShop_X,
//                                posButton_Y - detailItemShop.getHeight() / 2
//                                        - xpSmall.getHeight() / 2, null);
//
//                        canvas.drawText(""
//                                + Constants.CROPS_EXP[Constants.CROPS_ORD[i]],
//                                posBackgItemShop_X + posPanelXpMarket_X + 8
//                                        + xpSmall.getWidth() + moveShop_X,
//                                posButton_Y - detailItemShop.getHeight() / 2
//                                        + xpSmall.getHeight() / 4,
//                                fontAttriItemShop);
//
//                        buttonAddProduct.setPosX(posBackgItemShop_X
//                                + backgroundItemShop.getWidth() / 2
//                                - buttonAddProduct.getImage().getWidth() / 2
//                                + moveShop_X);
//                        buttonAddProduct.setPosY(posButton_Y);
//                        buttonAddProduct.paint(canvas);
//
//                        canvas.drawBitmap(
//                                coinSmall,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - coinSmall.getWidth() - 10
//                                        + moveShop_X,
//                                buttonAddProduct.getPosY()
//                                        + (buttonAddProduct.getImage()
//                                                .getHeight() / 2)
//                                        - coinSmall.getHeight() / 2, null);
//
//                        canvas.drawText(
//                                ""
//                                        + Constants.CROPS_COINS_TO_PAY[Constants.CROPS_ORD[i]],
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        + 10 + moveShop_X,
//                                buttonAddProduct.getPosY()
//                                        + (buttonAddProduct.getImage()
//                                                .getHeight() / 4) * 3,
//                                fontMoneyToPay);
//
//                    }
//
//                    break;
//                case Constants.MARKET_MENU_BUILDINGS_OPTION:
//                    if (i < nItems && iconBuilding[i] != null) {
//                        canvas.drawBitmap(backgroundItemShop,
//                                posBackgItemShop_X + moveShop_X,
//                                posBackgItemShop_Y, null);
//
//                        canvas.drawText(texts[Constants.BUILDING_NAME[i]],
//                                posBackgItemShop_X + moveShop_X
//                                        + backgroundItemShop.getWidth() / 2,
//                                posBackgItemShop_Y + nameItemGeneral_Y,
//                                fontNameBuildingItems);
//
//                        canvas.drawBitmap(
//                                iconBuilding[i],
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - iconBuilding[i].getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - iconBuilding[i].getHeight() / 2, null);
//
//                        buttonAddProduct.setPosX(posBackgItemShop_X
//                                + backgroundItemShop.getWidth() / 2
//                                - buttonAddProduct.getImage().getWidth() / 2
//                                + moveShop_X);
//                        buttonAddProduct.setPosY(posButton_Y);
//                        buttonAddProduct.paint(canvas);
//
//                        paintAnimationCursor(
//                                canvas,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - cursorHand.getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - cursorHand.getHeight() / 2 + cursorY,
//                                i);
//
//                        if (Constants.buildingUsed[i] < 3
//                                && (nLevel + 1) < Constants.BUILDING_AVAILABLE[i][Constants.buildingUsed[i]]) {
//                            canvas.drawBitmap(
//                                    lockObject,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth() / 2
//                                            - lockObject.getWidth() / 2
//                                            + moveShop_X,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2 + iconBuilding[i].getHeight()
//                                            / 2 - lockObject.getHeight(), null);
//
//                            canvas.drawText(
//                                    texts[216]
//                                            + " "
//                                            + Constants.BUILDING_AVAILABLE[i][Constants.buildingUsed[i]],
//                                    posBackgItemShop_X + moveShop_X
//                                            + backgroundItemShop.getWidth() / 2,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2
//                                            + iconBuilding[i].getHeight()
//                                            / 2
//                                            + Constants.fontAnimalfood
//                                                    .getTextSize(),
//                                    Constants.fontAnimalfood);
//
//                        } else if (Constants.buildingUsed[i] == 3) {
//                            canvas.drawBitmap(
//                                    lockObject,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth() / 2
//                                            - lockObject.getWidth() / 2
//                                            + moveShop_X,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2 + iconBuilding[i].getHeight()
//                                            / 2 - lockObject.getHeight(), null);
//
//                        }
//
//                        if (Constants.buildingUsed[i] < 3) {
//                            String[] auxString = { ""
//                                    + Constants.BUILDING_PRICE[i][Constants.buildingUsed[i]] };
//                            Bitmap[] auxBitmap = { coinSmall };
//                            UtilSoftgames
//                                    .PaintTextWithImageInLine(
//                                            canvas,
//                                            auxString,
//                                            auxBitmap,
//                                            fontMoneyToPay,
//                                            posBackgItemShop_X
//                                                    + moveShop_X
//                                                    + backgroundItemShop
//                                                            .getWidth() / 2,
//                                            buttonAddProduct.getPosY()
//                                                    + (buttonAddProduct
//                                                            .getImage()
//                                                            .getHeight())
//                                                    - coinSmall.getHeight() / 2);
//                        }
//
//                    }
//                    break;
//                case Constants.MARKET_MENU_ANIMALS_OPTION:
//                    if (i < nItems && iconAnimals[i] != null) {
//                        canvas.drawBitmap(backgroundItemShop,
//                                posBackgItemShop_X + moveShop_X,
//                                posBackgItemShop_Y, null);
//                        canvas.drawBitmap(
//                                iconAnimals[i],
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - iconAnimals[i].getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - iconAnimals[i].getHeight() / 2, null);
//
//                        paintAnimationCursor(
//                                canvas,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - cursorHand.getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - cursorHand.getHeight() / 2 + cursorY,
//                                i);
//
//                        if (isAnimalAvailable(i)) {
//
//                            buttonAddProduct.setPosX(posBackgItemShop_X
//                                    + backgroundItemShop.getWidth() / 2
//                                    - buttonAddProduct.getImage().getWidth()
//                                    / 2 + moveShop_X);
//                            buttonAddProduct.setPosY(posButton_Y);
//                            buttonAddProduct.paint(canvas);
//
//                            canvas.drawText(
//                                    texts[Constants.PRODUCT_ANIMAL_INFO[i][2]],
//                                    posBackgItemShop_X + moveShop_X
//                                            + backgroundItemShop.getWidth() / 2,
//                                    posBackgItemShop_Y + nameItemGeneral_Y,
//                                    fontNameItems);
//
//                            String[] auxString2 = { ""
//                                    + Constants.ANIMAL_PRICE[i][Constants.animalUsed[i]] };
//                            Bitmap[] auxBitmap2 = { (Constants.ANIMAL_TYPE_PRICE[i][Constants.animalUsed[i]] == Constants.GOLD) ? coinSmall
//                                    : diamondSmall };
//
//                            UtilSoftgames
//                                    .PaintTextWithImageInLine(
//                                            canvas,
//                                            auxString2,
//                                            auxBitmap2,
//                                            fontMoneyToPay,
//                                            posBackgItemShop_X
//                                                    + moveShop_X
//                                                    + backgroundItemShop
//                                                            .getWidth() / 2,
//                                            buttonAddProduct.getPosY()
//                                                    + (buttonAddProduct
//                                                            .getImage()
//                                                            .getHeight())
//                                                    - coinSmall.getHeight() / 2);
//                        } else {
//                            canvas.drawBitmap(
//                                    lockObject,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth() / 2
//                                            - lockObject.getWidth() / 2
//                                            + moveShop_X,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2 + iconAnimals[i].getHeight()
//                                            / 2 - lockObject.getHeight(), null);
//                        }
//                    }
//                    break;
//                case Constants.MARKET_MENU_DECORATIONS_OPTION:
//                    if (i < nItems && iconDecorations[i] != null) {
//                        canvas.drawBitmap(backgroundItemShop,
//                                posBackgItemShop_X + moveShop_X,
//                                posBackgItemShop_Y, null);
//                        canvas.drawBitmap(
//                                iconDecorations[i],
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - iconDecorations[i].getWidth() / 2
//                                        + moveShop_X, posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - iconDecorations[i].getHeight() / 2,
//                                null);
//
//                        canvas.drawText(
//                                texts[Constants.DECORATIONS_INFO[i][5]],
//                                posBackgItemShop_X + moveShop_X
//                                        + backgroundItemShop.getWidth() / 2,
//                                posBackgItemShop_Y + nameItemGeneral_Y,
//                                fontNameItems);
//
//                        if ((nLevel + 1) < Constants.DECORATIONS_INFO[i][0]) {
//                            canvas.drawBitmap(
//                                    lockObject,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth() / 2
//                                            - lockObject.getWidth() / 2
//                                            + moveShop_X,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2
//                                            + iconDecorations[i].getHeight()
//                                            / 2 - lockObject.getHeight(), null);
//
//                            canvas.drawText(
//                                    texts[216] + " "
//                                            + Constants.DECORATIONS_INFO[i][0],
//                                    posBackgItemShop_X + moveShop_X
//                                            + backgroundItemShop.getWidth() / 2,
//                                    posBackgItemShop_Y
//                                            + backgroundItemShop.getHeight()
//                                            / 2
//                                            + iconDecorations[i].getHeight()
//                                            / 2
//                                            + Constants.fontAnimalfood
//                                                    .getTextSize(),
//                                    Constants.fontAnimalfood);
//
//                        } else {
//                            canvas.drawBitmap(
//                                    detailItemShop,
//                                    posBackgItemShop_X
//                                            + backgroundItemShop.getWidth() / 2
//                                            - detailItemShop.getWidth() / 2
//                                            + moveShop_X, posButton_Y
//                                            - detailItemShop.getHeight(), null);
//
//                            canvas.drawBitmap(xpSmall, posBackgItemShop_X
//                                    + posPanelXpMarket_X + moveShop_X,
//                                    posButton_Y - detailItemShop.getHeight()
//                                            / 2 - xpSmall.getHeight() / 2, null);
//
//                            canvas.drawText(""
//                                    + Constants.DECORATIONS_INFO[i][3],
//                                    posBackgItemShop_X + posPanelXpMarket_X + 8
//                                            + xpSmall.getWidth() + moveShop_X,
//                                    posButton_Y - detailItemShop.getHeight()
//                                            / 2 + xpSmall.getHeight() / 4,
//                                    fontAttriItemShop);
//                        }
//
//                        paintAnimationCursor(
//                                canvas,
//                                posBackgItemShop_X
//                                        + backgroundItemShop.getWidth() / 2
//                                        - cursorHand.getWidth() / 2
//                                        + moveShop_X,
//                                posBackgItemShop_Y
//                                        + backgroundItemShop.getHeight() / 2
//                                        - cursorHand.getHeight() / 2 + cursorY,
//                                i);
//
//                        buttonAddProduct.setPosX(posBackgItemShop_X
//                                + backgroundItemShop.getWidth() / 2
//                                - buttonAddProduct.getImage().getWidth() / 2
//                                + moveShop_X);
//                        buttonAddProduct.setPosY(posButton_Y);
//                        buttonAddProduct.paint(canvas);
//
//                        String[] auxString = { ""
//                                + ((Constants.DECORATIONS_INFO[i][7] == Constants.GOLD) ? Constants.DECORATIONS_INFO[i][1]
//                                        : Constants.DECORATIONS_INFO[i][2]) };
//                        Bitmap[] auxBitmap = { (Constants.DECORATIONS_INFO[i][7] == Constants.GOLD) ? coinSmall
//                                : diamondSmall };
//                        UtilSoftgames.PaintTextWithImageInLine(
//                                canvas,
//                                auxString,
//                                auxBitmap,
//                                fontMoneyToPay,
//                                posBackgItemShop_X + moveShop_X
//                                        + backgroundItemShop.getWidth() / 2,
//                                buttonAddProduct.getPosY()
//                                        + (buttonAddProduct.getImage()
//                                                .getHeight())
//                                        - coinSmall.getHeight() / 2);
//
//                    }
//                    break;
//                }
//            }
//            if (itemSelected == i) {
//                getOverImage(backgroundItemShop, posBackgItemShop_X,
//                        posBackgItemShop_Y, canvas, Color.BLACK);
//            }
//
//            posBackgItemShop_X += backgroundItemShop.getWidth()
//                    + diffItemGeneralShop;
//        }
//        canvas.restore();
//
//        // pages
//        canvas.drawBitmap(backgroundPage,
//                mCanvasWidth / 2 - backgroundPage.getWidth() / 2, mCanvasHeight
//                        - backgroundPage.getHeight(), null);
//
//        int addPageAux = (nItems % 3 == 0) ? 0 : 1;
//        nPages = nItems / 3 + addPageAux;
//
//        int posButtonPage_X = mCanvasWidth / 2
//                - ((buttonPagesActive.getWidth() + 2) * nPages) / 2;
//        int posButtonPage_Y = mCanvasHeight - buttonPagesActive.getHeight();
//        for (int i = 1; i <= nPages; i++) {
//            if (i == currentPage) {
//                canvas.drawBitmap(buttonPagesActive, posButtonPage_X,
//                        posButtonPage_Y, null);
//            } else {
//                canvas.drawBitmap(buttonPages, posButtonPage_X,
//                        posButtonPage_Y, null);
//            }
//
//            posButtonPage_X += buttonPagesActive.getWidth() + 2;
//        }
//
//        animationRestorePostionCrops(nItems);
//        animationElementChosen();
//        transCurrent1Second();
//    }
//
//    /**
//     * Check if it is possible to buy the an animal
//     * 
//     * @param i
//     * @return
//     */
//    private boolean isAnimalAvailable(int i) {
//        boolean isAnimalAvailable = false;
//        for (int j = 0; j < nBuildingsPut; j++) {
//            switch (i) {
//            case Constants.ANIMAL_CHICKEN:
//                if (buildingsPut[j].getType() == 0) {
//                    isAnimalAvailable = true;
//                }
//                break;
//            case Constants.ANIMAL_COW:
//                if (buildingsPut[j].getType() == 3) {
//                    isAnimalAvailable = true;
//                }
//                break;
//            case Constants.ANIMAL_SHEEP:
//                if (buildingsPut[j].getType() == 5) {
//                    isAnimalAvailable = true;
//                }
//                break;
//            case Constants.ANIMAL_PIG:
//                if (buildingsPut[j].getType() == 7) {
//                    isAnimalAvailable = true;
//                }
//                break;
//            case Constants.ANIMAL_GOAT:
//                if (buildingsPut[j].getType() == 9) {
//                    isAnimalAvailable = true;
//                }
//                break;
//            default:
//                break;
//            }
//        }
//        return isAnimalAvailable;
//
//    }
//
//    private void animationRestorePostionCrops(int maxFinObjects) {
//        if (animationMoveShop) {
//            if (System.currentTimeMillis() - timePrev >= 1) {
//                timePrev = System.currentTimeMillis();
//                if (animationShopLeft) {
//
//                    if (startObjects + 1 < maxFinObjects - 3) {
//                        moveShop_X -= speed_Scroll_Market;
//                        if (moveShop_X <= -(backgroundItemShop.getWidth() + 2)) {
//                            moveShop_X = 0;
//                            startObjects += 1;
//                            endObjects += 1;
//                            contMoveAnimationShop++;
//
//                        }
//                    } else {
//                        currentPage = nPages;
//                    }
//
//                } else if (!animationShopLeft) {
//
//                    if (startObjects - 1 >= -1) {
//                        moveShop_X += speed_Scroll_Market;
//                        if (moveShop_X >= (backgroundItemShop.getWidth() + 2)) {
//                            moveShop_X = 0;
//                            startObjects -= 1;
//                            endObjects -= 1;
//                            contMoveAnimationShop++;
//                        }
//                    } else {
//                        currentPage = 1;
//                    }
//                }
//            }
//
//            if (contMoveAnimationShop >= 3) {
//                animationMoveShop = false;
//                if (animationShopLeft) {
//                    currentPage++;
//                } else {
//                    currentPage--;
//                }
//            }
//        }
//    }
//
//    private void paintStateMarketDecoration(Canvas canvas) {
//        // Paint_State_MainGame(canvas);
//        paintGeneralShop(canvas, Constants.MARKET_MENU_DECORATIONS_OPTION,
//                Constants.decorationsImage.length, texts[9]);
//    }
//
//    private void paintStateMarketBuilding(Canvas canvas) {
//        //loadIconsBuildings();
//        paintGeneralShop(canvas, Constants.MARKET_MENU_BUILDINGS_OPTION,
//                Constants.BUILDING_TYPE_ORD.length, texts[10]);
//        if (tutorialGame) {
//            paintInfoTutorial(canvas, 0);
//        }
//
//    }
//
//    private void paintStateMarketCrops(Canvas canvas) {
//        paintGeneralShop(canvas, Constants.MARKET_MENU_CROPS_OPTION,
//                Constants.cropsImage.length, texts[7]);
//
//    }
//
//    private void paintStateMarketAnimal(Canvas canvas) {
//        paintGeneralShop(canvas, Constants.MARKET_MENU_ANIMALS_OPTION, 5,
//                texts[8]);
//
//    }
//
//    private void paintAnimationQuantityUp(Canvas canvas) {
//        
//        int pos_X = posAnimationQuantity_X;
//        int pos_Y = posAnimationQuantity_Y;
//        String signo = "+";
//        // Controls the speed of the animation
//        int diff = 18;
//        if (animationQuantity) {
//            if (showProductAnimal > 0) {
//                // canvas.drawBitmap(Constants.productByAnimals[showProductAnimal-1],
//                // pos_X + 30,
//                // pos_Y -
//                // Constants.productByAnimals[showProductAnimal-1].getHeight(),
//                // null);
//
//                String[] auxStrinDiamonds = { "+1" };
//                Bitmap[] auxBitmapDiamonds = { Constants.productByAnimals[showProductAnimal - 1] };
//                UtilSoftgames.PaintTextWithImageInLine(canvas,
//                        auxStrinDiamonds, auxBitmapDiamonds, fontMoneyToPay,
//                        pos_X, pos_Y);
//                pos_Y -= diff;
//
//                if (contAnimationQuantity <= 3) {
//                    pos_X -= 2;
//                } else if (contAnimationQuantity <= 5) {
//                    pos_X -= 3;
//                } else if (contAnimationQuantity <= 7) {
//                    pos_X -= 4;
//                } else if (contAnimationQuantity <= 9) {
//                    pos_X -= 5;
//                }
//                // pos_Y -= diff;
//            }
//
//            if (showMastered != 0) {
//                signo = (showMastered < 0) ? "" : "+";
//
//                String[] auxStringMastered = { signo + showMastered };
//                Bitmap[] auxBitmapMastered = { flowerFull };
//                UtilSoftgames.PaintTextWithImageInLine(canvas,
//                        auxStringMastered, auxBitmapMastered, fontMoneyToPay,
//                        pos_X, pos_Y);
//
//                pos_Y -= diff;
//            }
//
//            if (showFood != 0) {
//                signo = (showFood < 0) ? "" : "+";
//                // canvas.drawText(signo + showFood, pos_X, pos_Y,
//                // fontAnimationQuantity);
//
//                // canvas.drawBitmap(foodSmall, pos_X + 30, pos_Y -
//                // foodSmall.getHeight(), null);
//
//                String[] auxStrinDiamonds = { signo + showFood };
//                Bitmap[] auxBitmapDiamonds = { foodSmall };
//                UtilSoftgames.PaintTextWithImageInLine(canvas,
//                        auxStrinDiamonds, auxBitmapDiamonds, fontMoneyToPay,
//                        pos_X, pos_Y);
//                pos_Y -= diff;
//
//            }
//
//            if (showIconProduce != 0) {
//                signo = (showIconProduce < 0) ? "" : "+";
//                canvas.drawText(signo + showIconProduce, pos_X, pos_Y,
//                        fontAnimationQuantity);
//
//                canvas.drawBitmap(
//                        Constants.iconProduced[typeIconProduced],
//                        pos_X + 30,
//                        pos_Y
//                                - Constants.iconProduced[typeIconProduced]
//                                        .getHeight() / 2, null);
//                pos_Y -= diff;
//            }
//
//            if (showDiamonds != 0) {
//                signo = (showDiamonds < 0) ? "" : "+";
//                // canvas.drawText(signo + showDiamonds, pos_X, pos_Y,
//                // fontAnimationQuantity);
//                // canvas.drawBitmap(diamondSmall, pos_X + 30, pos_Y -
//                // diamondSmall.getHeight(), null);
//
//                String[] auxStrinDiamonds = { signo + showDiamonds };
//                Bitmap[] auxBitmapDiamonds = { diamondSmall };
//                UtilSoftgames.PaintTextWithImageInLine(canvas,
//                        auxStrinDiamonds, auxBitmapDiamonds, fontMoneyToPay,
//                        pos_X, pos_Y);
//                pos_Y -= diff;
//            }
//            if (showCoins != 0) {
//                signo = (showCoins < 0) ? "" : "+";
//                // canvas.drawText(signo + showCoins , pos_X, pos_Y,
//                // fontAnimationQuantity);
//                // canvas.drawBitmap(coinSmall, pos_X + 30, pos_Y -
//                // coinSmall.getHeight(), null);
//
//                String[] auxStrinCoins = { signo + showCoins };
//                Bitmap[] auxBitmapCoins = { coinSmall };
//                UtilSoftgames.PaintTextWithImageInLine(canvas, auxStrinCoins,
//                        auxBitmapCoins, fontMoneyToPay, pos_X, pos_Y);
//                pos_Y -= diff;
//            }
//            if (showExp != 0) {
//                signo = (showExp < 0) ? "" : "+";
//                // canvas.drawText(signo + showExp, pos_X, pos_Y,
//                // fontAnimationQuantity);
//                // canvas.drawBitmap(xpSmall, pos_X + 30, pos_Y -
//                // xpSmall.getHeight(), null);
//
//                String[] auxStringXp = { signo + showExp };
//                Bitmap[] auxBitmapXp = { xpSmall };
//                UtilSoftgames.PaintTextWithImageInLine(canvas, auxStringXp,
//                        auxBitmapXp, fontMoneyToPay, pos_X, pos_Y);
//                pos_Y -= diff;
//            }
//
//            if (System.currentTimeMillis() - animationQuantityTime >= 70) {
//                animationQuantityTime = System.currentTimeMillis();
//                posAnimationQuantity_Y = pos_Y;
//                posAnimationQuantity_X = pos_X;
//                contAnimationQuantity++;
//                if (contAnimationQuantity >= 12) {
//                    contAnimationQuantity = 0;
//                    animationQuantity = false;
//                    showProductAnimal = -1;
//                    showDiamonds = 0;
//                    showCoins = 0;
//                    showExp = 0;
//                    showIconProduce = 0;
//                    showFood = 0;
//
//                    explosionActive = false;
//                }
//            }
//        }
//    }
//
//    private void paintStateMission(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[251], texts[12]);
//        paintSquare(canvas, squareMission[0], squareMission[1],
//                squareMission[2], squareMission[3], 0xff0d2e4f);
//
//        int posItem_X = posBackgTask_X;
//        int posItem_Y = posBackgTask_Y;
//        for (int i = 0; i < nMission; i++) {
//            canvas.drawBitmap(taskItemBackg, posItem_X, posItem_Y, null);
//
//            for (int k = 0; k < 3; k++) {
//                if (missionCharacter[k] == i) {
//                    Matrix auxMatriz = new Matrix();
//                    auxMatriz.setTranslate(posItem_X + 30, posItem_Y + 34);
//                    auxMatriz.preScale(0.3f, 0.3f);
//                    canvas.drawBitmap(iconCharacter[characterChosen[k]],
//                            auxMatriz, null);
//                    break;
//                }
//            }
//
//            if (missionChosen == i) {
//                canvas.drawBitmap(
//                        taskSelected,
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                - taskSelected.getWidth() / 2, posItem_Y
//                                + addTaskSelect_Y, null);
//            }
//
//            String[] auxString = { "" + rewardsCoins[i] };
//            Bitmap[] auxBitmap = { coinSmall };
//
//            UtilSoftgames.PaintTextWithImageInLine(canvas, auxString,
//                    auxBitmap, fontAttriItemShop,
//                    posItem_X + taskItemBackg.getWidth() / 2 + 5, posItem_Y
//                            + coinIconMission_Y);
//
//            String[] auxString1 = { "" + rewardsXP[i] };
//            Bitmap[] auxBitmap1 = { xpSmall };
//
//            UtilSoftgames.PaintTextWithImageInLine(canvas, auxString1,
//                    auxBitmap1, fontAttriItemShop,
//                    posItem_X + taskItemBackg.getWidth() / 2 + 5, posItem_Y
//                            + startIconMission_Y);
//
//            if (canRewardMission[i]) {
//                canvas.drawBitmap(
//                        checkBig,
//                        posItem_X + taskItemBackg.getWidth()
//                                - checkBig.getWidth(),
//                        posItem_Y + taskItemBackg.getHeight()
//                                - checkBig.getHeight(), null);
//            }
//
//            posItem_X += taskItemBackg.getWidth() + 5;
//            if (i == 2 || i == 5) {
//                posItem_X = posBackgTask_X;
//                posItem_Y += taskItemBackg.getHeight() + 5;
//            }
//        }
//
//        int backgTaskBig_X = (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                - backgTask.getWidth() - restTaskBig_X;
//
//        canvas.drawBitmap(backgTask, backgTaskBig_X, posBackgTask_Y, null);
//
//        if (!canRewardMission[missionChosen]) {
//        	buttonProduce.setPosX(backgTaskBig_X + backgTask.getWidth() / 2
//                    - buttonProduce.getImage().getWidth() / 2);
//            buttonProduce.setPosY(posBackgTask_Y + backgTask.getHeight()
//                    - (buttonProduce.getImage().getHeight() / 4) * 3);
//           if(nLevel < 2){
//        	   buttonProduce.paint(canvas);
//           } else {
//        	   UtilSoftgames.animationSmallToBig(canvas, buttonProduce.getImage(), buttonProduce.getPosX() + buttonProduce.getImage().getWidth()/2,
//        			   buttonProduce.getPosY() + buttonProduce.getImage().getHeight()/2,  1.1f, 0.9f);
//           }
//           
//         
//
//            if (tutorialGame
//                    && stepTutorial == Constants.STEP_TUTORIAL_BECOMING_KNOWN) {
//                paintAnimationCursor(canvas,
//                        buttonProduce.getPosX()
//                                + buttonProduce.getImage().getWidth() / 2
//                                - cursorHand.getWidth() / 2,
//                        buttonProduce.getPosY()
//                                + buttonProduce.getImage().getHeight() / 2
//                                - cursorHand.getHeight() / 3 + cursorY, -1);
//            }
//        } else {
//            canvas.drawBitmap(buttonProduceInactive,
//                    backgTaskBig_X + backgTask.getWidth() / 2
//                            - buttonProduce.getImage().getWidth() / 2,
//                    posBackgTask_Y + backgTask.getHeight()
//                            - (buttonProduce.getImage().getHeight() / 4) * 3,
//                    null);
//
//        }
//
//        int posIcon_X = backgTaskBig_X + (backgTask.getWidth() / 3) / 2;
//        int posIcon_Y = posBackgTask_Y + backgTask.getHeight() / 4;
//        int posCheckMarkIcon_X = 0;
//        int posCheckMarkIcon_Y = 0;
//        int diamondsToSkip = 0;
//        for (int i = 0; i < nTask[missionChosen]; i++) {
//            paintIconType(canvas, typeMission[missionChosen][i], posIcon_X,
//                    posIcon_Y, i, missionChosen);
//
//            posCheckMarkIcon_X = (posIcon_X + iconCrops[0].getWidth() / 2)
//                    - checkSmall.getWidth();
//            posCheckMarkIcon_Y = (posIcon_Y + iconCrops[0].getHeight() / 2)
//                    - checkSmall.getHeight();
//            int quantityDone = isReadyTask(i, missionChosen);
//
//            if (quantityDone == quantityProduct[missionChosen][i]) {
//                canvas.drawBitmap(checkSmall, posCheckMarkIcon_X,
//                        posCheckMarkIcon_Y, null);
//
//            } else {
//            	int itemNeed = quantityProduct[missionChosen][i] - quantityDone;
//            	
//            	diamondsToSkip += (valuesDiamondsFinishMission(typeMission[missionChosen][i],
//                        typeProduct[missionChosen][i]))*itemNeed;
//            	
//                canvas.drawText(quantityDone + "/"
//                        + quantityProduct[missionChosen][i], posIcon_X,
//                        posIcon_Y + iconCrops[0].getHeight() / 2,
//                        Constants.fontAnimalfood);
//            }
//
//            posIcon_X += (backgTask.getWidth() / 3);
//            if (i == 2) {
//                posIcon_X = backgTaskBig_X + (backgTask.getWidth() / 3) / 2;
//                posIcon_Y += backgTask.getHeight() / 3;
//            }
//        }
//        
//        diamondsToFinishMission[missionChosen] = diamondsToSkip;
//        String[] auxString2 = {
//                texts[13] + " (" + diamondsToFinishMission[missionChosen],
//                ")" };
//        Bitmap[] auxBitmap2 = { diamondSmall, null };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString2,
//                auxBitmap2, fontMoneyToPay, buttonProduce.getPosX()
//                        + buttonProduce.getImage().getWidth() / 2,
//                buttonProduce.getPosY()
//                        + (buttonProduce.getImage().getHeight() / 3) * 2);
//
//        String[] auxString = { "" + rewardsCoins[missionChosen] };
//        Bitmap[] auxBitmap = { coinSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString, auxBitmap,
//                fontAttriItemShop, backgTaskBig_X + (backgTask.getWidth() / 3)
//                        / 2, posBackgTask_Y + backgTask.getHeight()
//                        + coinIconMission_Y);
//
//        String[] auxString1 = { "" + rewardsXP[missionChosen] };
//        Bitmap[] auxBitmap1 = { xpSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(canvas, auxString1, auxBitmap1,
//                fontAttriItemShop, backgTaskBig_X + (backgTask.getWidth() / 3)
//                        / 2, posBackgTask_Y + backgTask.getHeight()
//                        + startIconMission_Y);
//
//        if (explosionActive) {
//            if (explosion != null) {
//                explosion.draw(canvas);
//                explosion.update(null);
//            }
//        } else {
//            if (!canRewardMission[missionChosen]) {
//                canvas.drawBitmap(buttonCashInLocked,
//                        (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                                - buttonCashIn.getWidth() - buttonCashIn_X,
//                        mCanvasHeight - buttonCashIn.getHeight()
//                                - buttonCashIn_Y, null);
//            } else {
//
//                UtilSoftgames.animationSmallToBig(canvas, buttonCashIn,
//                        (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                                - buttonCashIn.getWidth() / 2 - buttonCashIn_X,
//                        mCanvasHeight - buttonCashIn.getHeight() / 2
//                                - buttonCashIn_Y, 1.1f, 0.9f);
//
//                if (tutorialGame) {
//                    paintAnimationCursor(
//                            canvas,
//                            (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                                    - buttonCashIn.getWidth()
//                                    / 2
//                                    - buttonCashIn_X
//                                    + buttonCashIn.getWidth()
//                                    / 2 - cursorHand.getWidth() / 2,
//                            mCanvasHeight - buttonCashIn.getHeight() / 2
//                                    - buttonCashIn_Y + buttonCashIn.getHeight()
//                                    / 2 - cursorHand.getHeight() / 3 + cursorY,
//                            -1);
//                }
//            }
//        }
//
//        paintPopUpInfo(canvas);
//        if (tutorialGame && stateGame == Constants.STATE_MISSION) {
//            paintInfoTutorial(canvas, 160);
//        }
//    }
//
//    
//   
//    
//    private int getQuantityProductInStorage(int productType) {
//        boolean found = false;
//        for (int i = 0; i < indexStorage; i++) {
//            if (itemStorage[i][0] == Constants.STORAGE_CROPS
//                    && itemStorage[i][1] == productType) {
//                found = true;
//            } else if (itemStorage[i][0] == Constants.STORAGE_ANIMALS_PRODUCTS
//                    && itemStorage[i][1] == productType - 156) {
//                found = true;
//            } else if (itemStorage[i][0] == Constants.STORAGE_PRODUCTS
//                    && itemStorage[i][1] == productType /*- 17*/) {
//                found = true;
//            }
//
//            if (found) {
//                return itemStorage[i][2];
//            }
//        }
//
//        return 0;
//    }
//
//    private int isReadyTask(int type, int posMission) {
//        if (typeMission[posMission][type] == Constants.MISSION_TYPE_CROPS
//                || typeMission[posMission][type] == Constants.MISSION_CREATE_PRODUCT
//                || typeMission[posMission][type] == Constants.MISSION_PRODUCTANIMAL) {
//            int quantity = getQuantityProductInStorage(typeProduct[posMission][type]);
//            if (quantity >= quantityProduct[posMission][type]) {
//                return quantityProduct[posMission][type];
//            } else {
//                return quantity;
//            }
//        }
//
//        if (quantityProductDone[posMission][type] >= quantityProduct[posMission][type]) {
//            return quantityProduct[posMission][type];
//        } else {
//            return quantityProductDone[posMission][type];
//        }
//
//    }
//
//    private void paintIconType(Canvas canvas, int type, int posIcon_X,
//            int posIcon_Y, int i, int showMission) {
//
//        switch (type) {
//        case Constants.MISSION_TYPE_CROPS:
//
//            canvas.drawBitmap(
//                    iconCrops[typeProduct[showMission][i]],
//                    posIcon_X
//                            - iconCrops[typeProduct[showMission][i]].getWidth()
//                            / 2,
//                    posIcon_Y
//                            - iconCrops[typeProduct[showMission][i]]
//                                    .getHeight() / 2, null);
//            break;
//        case Constants.MISSION_TYPE_ANIMALS:
//            break;
//        case Constants.WATERING:
//            canvas.drawBitmap(waterIcon, posIcon_X - waterIcon.getWidth() / 2,
//                    posIcon_Y - waterIcon.getHeight() / 2, null);
//
//            break;
//        case Constants.ADD_HELPER:
//            canvas.drawBitmap(iconHelper.getImage(), posIcon_X
//                    - iconHelper.getImage().getWidth() / 2, posIcon_Y
//                    - iconHelper.getImage().getHeight() / 2, null);
//
//            break;
//        case Constants.REMOVE_VEGETATIONS:
//            canvas.drawBitmap(iconVegetation,
//                    posIcon_X - iconVegetation.getWidth() / 2, posIcon_Y
//                            - iconVegetation.getHeight() / 2, null);
//
//            break;
//        case Constants.MISSION_TYPE_DECO:
//
//            /*
//             * canvas.drawBitmap(iconDecorations[typeProduct[missionChoosed][
//             * i]], posIcon_X -
//             * iconDecorations[typeProduct[missionChoosed][i]].getWidth()/2,
//             * posIcon_Y -
//             * iconDecorations[typeProduct[missionChoosed][i]].getHeight ()/2,
//             * null);
//             */
//            float sizeToReduce = 0.35f;
//
//            Matrix matrixnew = new Matrix();
//            matrixnew
//                    .setTranslate(
//                            posIcon_X
//                                    - (int) (iconDecorations[typeProduct[showMission][i]]
//                                            .getWidth() * sizeToReduce) / 2,
//                            posIcon_Y
//                                    - (int) (iconDecorations[typeProduct[showMission][i]]
//                                            .getHeight() * sizeToReduce) / 2);
//
//            matrixnew.preScale(sizeToReduce, sizeToReduce);
//
//            canvas.drawBitmap(iconDecorations[typeProduct[showMission][i]],
//                    matrixnew, null);
//            break;
//        case Constants.GET_GOLD:
//            canvas.drawBitmap(coinSmall, posIcon_X - coinSmall.getWidth() / 2,
//                    posIcon_Y - coinSmall.getHeight() / 2, null);
//
//            break;
//        case Constants.NEXT_LEVEL:
//            canvas.drawBitmap(xpSmall, posIcon_X - xpSmall.getWidth() / 2,
//                    posIcon_Y - xpSmall.getHeight() / 2, null);
//
//            break;
//        case Constants.PLOW:
//            canvas.drawBitmap(iconSmallEarth,
//                    posIcon_X - iconSmallEarth.getWidth() / 2, posIcon_Y
//                            - iconSmallEarth.getHeight() / 2, null);
//
//            break;
//        case Constants.MISSION_CREATE_PRODUCT:
//        case Constants.MISSION_PRODUCTANIMAL:
//            canvas.drawBitmap(
//                    Constants.iconProduced[typeProduct[showMission][i]],
//                    posIcon_X
//                            - Constants.iconProduced[typeProduct[showMission][i]]
//                                    .getWidth() / 2,
//                    posIcon_Y
//                            - Constants.iconProduced[typeProduct[showMission][i]]
//                                    .getHeight() / 2, null);
//
//            break;
//        }
//
//        infoIcon.setPosX(posIcon_X - iconCrops[0].getWidth() / 2);
//        infoIcon.setPosY(posIcon_Y - iconCrops[0].getHeight() / 2);
//        infoIcon.paintScale(canvas, 0.50f);
//
//    }
//
//    private void paintBackGeneral(Canvas canvas) {
//        canvas.drawBitmap(backgroundGeneral, mCanvasWidth / 2
//                - backgroundGeneral.getWidth() / 2, mCanvasHeight / 2
//                - backgroundGeneral.getHeight() / 2, null);
//        buttonClose.setPosY(mCanvasHeight / 2 - backgroundGeneral.getHeight()
//                / 2);
//        buttonClose.setPosX(mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2
//                - buttonClose.getImage().getWidth());
//        buttonClose.paint(canvas);
//        if (tutorialGame
//                && ((stepTutorial == Constants.STEP_TUTORIAL_TASKS_OWN)
//                        || (stepTutorial == Constants.STEP_TUTORIAL_CONGRATULATIONS && stepInAuxTutorial == 1)
//                        || (stepTutorial == Constants.STEP_TUTORIAL_CROPS_BECOME_FOOD && stepInAuxTutorial == 3)
//                        || stepTutorial == Constants.STEP_TUTORIAL_FARM_FRIENDS
//                        || stepTutorial == Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED
//                        || (stepInAuxTutorial == 4 && stepTutorial == Constants.STEP_TUTORIAL_YOUR_FIRST_TASK) || (stepInAuxTutorial == 3 && stepTutorial == Constants.STEP_TUTORIAL_FIRST_MONEY))) {
//            paintAnimationCursor(canvas,
//                    buttonClose.getPosX() + buttonClose.getImage().getWidth()
//                            / 2 - cursorHand.getWidth() / 2,
//                    buttonClose.getPosY() + buttonClose.getImage().getHeight()
//                            / 2 - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//    }
//
//    private void paintStateMainMarket(Canvas canvas) {
//        paintStateMainGame(canvas);
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[74], null);
//
//        int item_X = mCanvasWidth / 2
//                - ((backgroundItemMarket.getWidth() + spaceBetItem_X) * 3) / 2;
//        int item_Y = spaceBetBorderBackgrSuper;
//
//        for (int i = 0; i < 6; i++) {
//            canvas.drawBitmap(backgroundItemMarket, item_X, item_Y, null);
//            canvas.drawBitmap(itemMarket[i],
//                    item_X + backgroundItemMarket.getWidth() / 2
//                            - itemMarket[i].getWidth() / 2, item_Y
//                            + backgroundItemMarket.getHeight() / 2
//                            - itemMarket[i].getHeight() / 2
//                            - spaceLineMainMarket_Y, null);
//
//            if (itemSelected == i) {
//                getOverImage(backgroundItemMarket, item_X, item_Y, canvas,
//                        Color.BLACK);
//            }
//
//            canvas.drawText(texts[6 + i],
//                    item_X + backgroundItemMarket.getWidth() / 2,
//                    item_Y + backgroundItemMarket.getHeight() - textMainMarket,
//                    fontNameItemMarket);
//
//            if (i == 4) {
//                if (tutorialGame
//                        && stepTutorial == Constants.STEP_TUTORIAL_ENTER_SHOP) {
//                    paintAnimationCursor(canvas,
//                            item_X + backgroundItemMarket.getWidth() / 2
//                                    - cursorHand.getWidth() / 2, item_Y
//                                    + backgroundItemMarket.getHeight() / 2
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//                }
//            }
//
//            item_X += backgroundItemMarket.getWidth() + spaceBetItem_X;
//            if (i == 2) {
//                item_X = mCanvasWidth
//                        / 2
//                        - ((backgroundItemMarket.getWidth() + spaceBetItem_X) * 3)
//                        / 2;
//                item_Y += backgroundItemMarket.getHeight() + spaceBetItem_Y;
//            }
//
//        }
//        if (tutorialGame && stateGame == Constants.STATE_MAIN_MARKET) {
//            paintInfoTutorial(canvas, 0);
//        }
//        // animationElementChoosed();
//    }
//
//    private void getOverImage(Bitmap image, int posX, int posY, Canvas canvas,
//            int Color) {
//       /* BlurMaskFilter blurFilter = new BlurMaskFilter(13,
//                BlurMaskFilter.Blur.OUTER);
//
//        Paint shadowPaint = new Paint();
//        shadowPaint.setMaskFilter(blurFilter);
//        shadowPaint.setColor(0xFFFFFFFF);
//        int[] offsetXY = new int[2];
//        Bitmap shadowImage = image.extractAlpha(shadowPaint, offsetXY);
//        offsetXY[0] = posX;
//        offsetXY[1] = posY;
//        Paint shadowPaint2 = new Paint();
//        shadowPaint2.setColor(Color);
//        shadowPaint2.setStrokeWidth(34);
//        canvas.drawBitmap(shadowImage, offsetXY[0] - 13, offsetXY[1] - 13,
//                shadowPaint2);*/
//
//    }
//
//    private void paintStateCover(Canvas canvas) {
//       // Log.e(TAG, "paintStateCover()");
//        
//        
//       /* if (System.currentTimeMillis() - timePrev >= 3500) {
//            timePrev = System.currentTimeMillis();
//            main.hideLoadingScreen();
//            stateGame = Constants.STATE_LOADING_MAIN;
//            
//        }*/
//       
//       
//       
//      
//            //Log.e(TAG, "loadedMainGame == " + loadedMainGame);
//        
//
//    }
//
//    private void paintSquare(Canvas canvas, int posInit_X, int posInitY,
//            int posFin_X, int posFin_Y, int color) {
//        Paint paint = new Paint();
//        paint.setColor(color);
//        canvas.drawRect(posInit_X, posInitY, posFin_X, posFin_Y, paint);
//    }
//
//    private void paintStateMainGame(Canvas canvas) {
//
//        paintWorldGame(canvas);
//        paintObjectTest(canvas);
//        paintUIMain(canvas);
//        paintActionSelect(canvas);
//        animationMainGame(canvas);
//
//        transCurrent1Second();
//
//     //   if (quantityDiamonds > Constants.BOOST_PLOW_COST) {
//            paintAutomatic(canvas);
//      //  }
//
//        paintPopUpInfo(canvas);
//        paintQuantityStorage(canvas);
//        paintDiamondsFound(canvas);
//        paintShowCollection(canvas);
//        paintAnimationCloudUp(canvas);
//        soundManinGame();
//
//        if (comeStorage) {
//            paintObjectToMove(canvas, classObjectToMove, typeObjectInMiniOption);
//        }
//        
//      
//        
//        if (tutorialGame && stateGame == Constants.STATE_MAIN_GAME
//                && !canShowInfoAuto) {
//            paintInfoTutorial(canvas, 0);
//            if (stepTutorial == Constants.STEP_TUTORIAL_WELCOME_FINAL_TUTORIAL) {
//                if (System.currentTimeMillis() - time_showIconTrucker >= 1500) {
//                    time_showIconTrucker = System.currentTimeMillis();
//                        tutorialGame = false;
//                        stateGame = Constants.STATE_CHARACTER_MISSION;
//                        indexCharacterChosen = 0;
//                        loadImages();
//                        saveGame();
//                        finishTutorial();
//                }
//            }
//            
//        }
//
//        if (explosionActive) {
//            if (explosion != null) {
//                explosion.draw(canvas);
//                explosion.update(null);
//            }
//        }
//        
//        movingScreenAutomatically(canvas);
//
//    }
//
//    private void finishTutorial() {
//        Log.d(TAG, "finishTutorial()");
//        // Dispose no longer needed bitmaps
//      //  disposeBitmap(tipsFarmer);
//      //  disposeBitmap(shopBlocked);
//     //   disposeBitmap(spriteTutorial);
//        tipsFarmer = null;
//        shopBlocked = null;
//        shopBlocked = null;
//    }
//
//    private void paintInfoTutorial(Canvas canvas, int centerX) {
//        if (stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//            int numberText = 310;
//            int[] numberParrafo = { 2, 1, 1, 1, 2, 2, 2, 2, 2,
//                    2,// 10
//                    1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1,
//                    1, 2, 1, 2, 2, 2, 1, 1, 2, 2, 3 };
//            int centerY = mCanvasHeight;
//            switch (stepTutorial) {
//            case Constants.STEP_TUTORIAL_HELLO_FARMER:
//                numberText = 310;
//                centerY = mCanvasHeight / 2;
//                break;
//            case Constants.STEP_TUTORIAL_PLOW_FIELDS:
//                numberText = 313;
//                break;
//            case Constants.STEP_TUTORIAL_PLOW_MORE_FIELDS:
//                numberText = 315;
//                break;
//            case Constants.STEP_TUTORIAL_SELECT_CROPS:
//                numberText = 317;
//                break;
//
//            case Constants.STEP_TUTORIAL_BOOST_YOUR_WHEAT:
//                numberText = 319;
//              //  centerY = mCanvasHeight / 2;
//                break;
//            case Constants.STEP_TUTORIAL_HARVEST:
//                numberText = 322;
//
//                break;
//            case Constants.STEP_TUTORIAL_MORE_WHEAT:
//                numberText = 325;
//
//                break;
//            case Constants.STEP_TUTORIAL_STORAGE:
//                numberText = 328; // start Here
//
//                break;
//            case Constants.STEP_TUTORIAL_SELECT_WHEAT_TO_BE_SOLD:
//                numberText = 331;
//
//                break;
//            case Constants.STEP_TUTORIAL_FIRST_MONEY:
//                numberText = 334;
//
//                break;
//            case Constants.STEP_TUTORIAL_ORDER_FROM_OTHERS:
//                numberText = 337;
//                break;
//
//            case Constants.STEP_TUTORIAL_YOUR_FIRST_TASK:
//                numberText = 339;
//                break;
//            case Constants.STEP_TUTORIAL_WIND_MILL_AND_FLOUR:
//                numberText = 342;
//
//                break;
//            case Constants.STEP_TUTORIAL_ENTER_PRODUCTION_VIEW:
//                numberText = 345;
//
//                break;
//            case Constants.STEP_TUTORIAL_PRESS_PRODUCE:
//                numberText = 348;
//
//                break;
//            case Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED:
//                numberText = 351;
//
//                break;
//            case Constants.STEP_TUTORIAL_COLLECT_YOUR_REWARD:
//                numberText = 354;
//
//                break;
//            case Constants.STEP_TUTORIAL_BECOMING_KNOWN:
//                numberText = 357;
//
//                break;
//            case Constants.STEP_TUTORIAL_FARM_FRIENDS:
//                numberText = 444;
//                break;
//            case Constants.STEP_TUTORIAL_WELCOME_FINAL_TUTORIAL:
//                numberText = 447;
//                break;
//            case Constants.STEP_TUTORIAL_LEVEL_UP:
//                numberText = 450;
//                break;
//
//            case Constants.STEP_TUTORIAL_ENTER_SHOP:
//                numberText = 441;
//                break;
//            case Constants.STEP_TUTORIAL_BUILDINGS:
//                numberText = 366;
//                centerX = centerX + tutorialBuildingTipX;
//                break;
//            case Constants.STEP_TUTORIAL_PLACE_ON_YARD:
//                numberText = 369;
//                break;
//            case Constants.STEP_TUTORIAL_BOOST_CONSTRUCTION:
//                numberText = 371;
//                break;
//            case Constants.STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING:
//                numberText = 373;
//                break;
//            case Constants.STEP_TUTORIAL_ADD_ANIMAL:
//                numberText = 375;
//                break;
//
//            case Constants.STEP_TUTORIAL_FEED_ANIMALS:
//                numberText = 378;
//                break;
//            case Constants.STEP_TUTORIAL_PRODUCE_FOOD:
//                numberText = 381;
//                // centerY = mCanvasHeight / 4;
//                break;
//            case Constants.STEP_TUTORIAL_CROPS_BECOME_FOOD:
//                numberText = 383;
//                break;
//            case Constants.STEP_TUTORIAL_WELL_DONE:
//                numberText = 385;
//                break;
//            case Constants.STEP_TUTORIAL_FIRST_EGG:
//                numberText = 388;
//                break;
//            case Constants.STEP_TUTORIAL_MORE_EGG:
//                numberText = 390;
//                break;
//            case Constants.STEP_TUTORIAL_CASH_IN_TIME:
//                numberText = 393;
//                break;
//            case Constants.STEP_TUTORIAL_TASKS_OWN:
//                numberText = 396;
//                break;
//            case Constants.STEP_TUTORIAL_EXPAND:
//                numberText = 399;
//                break;
//            case Constants.STEP_TUTORIAL_CONGRATULATIONS:
//                numberText = 401;
//                break;
//            case Constants.STEP_TUTORIAL_SPECIAL_TASKS:
//                numberText = 403;
//                break;
//            case Constants.STEP_TUTORIAL_GET_SPECIAL_TASKS:
//                numberText = 405;
//                break;
//            case Constants.STEP_TUTORIAL_YOU_MADE:
//                numberText = 408;
//                break;
//            }
//
//            if (dissapearMsj) {
//                return;
//            }
//
//            // Avoid shaky screen
//            centerY -= 5;
//
//            int posBackg_Y = centerY - tipsFarmer.getHeight();
//            int posBackg_X = mCanvasWidth / 2 - centerX - tipsFarmer.getWidth()
//                    / 2;
//
//            canvas.drawBitmap(tipsFarmer, posBackg_X, posBackg_Y, null);
//
//            canvas.drawText(texts[numberText], mCanvasWidth / 2
//                    + tutorialTipTitleX - centerX, posBackg_Y + addTutoTitle_Y,
//                    fontTitleTutorialStroke);
//            canvas.drawText(texts[numberText], mCanvasWidth / 2
//                    + tutorialTipTitleX - centerX, posBackg_Y + addTutoTitle_Y,
//                    fontTitleTutorial);
//
//            String textBody = texts[numberText + 1];
//            int posBody_Y = posBackg_Y + addTutoInfo_Y;
//
//            if (numberParrafo[stepTutorial - 1] == 2) {
//                posBody_Y += tutorialTipBodyY1;
//            } else if (numberParrafo[stepTutorial - 1] == 1) {
//                posBody_Y += tutorialTipBodyY1 * 2;
//            }
//            for (int i = 1; i <= numberParrafo[stepTutorial - 1]; i++) {
//                textBody = texts[numberText + i];
//
//                paintDivisionText(canvas, textBody, mCanvasWidth / 2
//                        + tutorialTipTextOffsetX - centerX, posBody_Y,
//                        tutorialTipTextDiffY, 69, posBody_Y,
//                        fontBodyTutorialStroke);
//                posBody_Y = paintDivisionText(canvas, textBody, mCanvasWidth
//                        / 2 + tutorialTipTextOffsetX - centerX, posBody_Y,
//                        tutorialTipTextDiffY, 69, posBody_Y, fontBodyTutorial);
//
//                posBody_Y += 5;
//            }
//
//        }
//
//        animationElementChosen();
//    }
//
//    private void paintAnimationCloudUp(Canvas canvas) {
//        if (animationCloudActive) {
//
//            for (int i = 0; i < numberStarAnimation; i++) {
//
//                switch (starAnimationType[i]) {
//                case 1:
//                    canvas.drawBitmap(starAnimation1, starAnimation_X[i],
//                            starAnimation_Y[i], null);
//                    break;
//                case 2:
//                    canvas.drawBitmap(starAnimation2, starAnimation_X[i],
//                            starAnimation_Y[i], null);
//                    break;
//                case 3:
//                    canvas.drawBitmap(starAnimation3, starAnimation_X[i],
//                            starAnimation_Y[i], null);
//                    break;
//                default:
//                    canvas.drawBitmap(starAnimation4, starAnimation_X[i],
//                            starAnimation_Y[i], null);
//                    break;
//                }
//
//            }
//
//            for (int i = 0; i < currentNumberCloud; i++) {
//
//                switch (cloudAnimationType[i]) {
//                case 1:
//                    UtilSoftgames.paintImageRotate(canvas, cloudAnimation1,
//                            cloudAnimation1_X[i], cloudAnimation1_Y[i]);
//                    // canvas.drawBitmap(cloudAnimation1,
//                    // cloudAnimation1_X[i], cloudAnimation1_Y[i], null);
//                    break;
//                case 2:
//                    UtilSoftgames.paintImageRotate(canvas, cloudAnimation2,
//                            cloudAnimation1_X[i], cloudAnimation1_Y[i]);
//                    // canvas.drawBitmap(cloudAnimation2,
//                    // cloudAnimation1_X[i], cloudAnimation1_Y[i], null);
//                    break;
//                case 3:
//                    UtilSoftgames.paintImageRotate(canvas, cloudAnimation3,
//                            cloudAnimation1_X[i], cloudAnimation1_Y[i]);
//                    // canvas.drawBitmap(cloudAnimation3,
//                    // cloudAnimation1_X[i], cloudAnimation1_Y[i], null);
//                    break;
//                }
//
//            }
//
//            if (System.currentTimeMillis() - timeAnimCloudUp >= 10) {
//                timeAnimCloudUp = System.currentTimeMillis();
//                for (int i = 0; i < currentNumberCloud; i++) {
//                    cloudAnimation1_Y[i] -= 4;
//                }
//                countAnimation++;
//
//                if (countAnimation == 1) {
//                    int posInit_X = posInitStar_X - 90 + 176;
//                    int posInit_Y = posInitStar_Y + 30;
//                    int[] auxAnim_X = { 11, 0, -49, -22, 50, 0, 75 };
//                    int[] auxAnim_Y = { -13, 0, -13, -31, 10, -59, -22 };
//                    for (int i = 0; i < numberStarAnimation; i++) {
//                        starAnimation_X[i] = posInit_X + auxAnim_X[i];
//                        starAnimation_Y[i] = posInit_Y + auxAnim_Y[i];
//                    }
//                } else {
//
//                    for (int i = 0; i < numberStarAnimation; i++) {
//                        starAnimation_Y[i] -= 7;
//                        switch (i) {
//                        case 0:
//                            starAnimation_X[i] += 7;
//                            starAnimation_Y[i] -= 8;
//                            break;
//                        case 2:
//                            starAnimation_X[i] -= 10;
//                            starAnimation_Y[i] -= 8;
//                            break;
//                        case 3:
//                            starAnimation_X[i] -= 12;
//                            starAnimation_Y[i] -= 12;
//                            break;
//                        case 4:
//                            starAnimation_X[i] += 15;
//                            starAnimation_Y[i] -= 3;
//                            break;
//                        case 5:
//                            starAnimation_Y[i] -= 14;
//                            break;
//                        case 6:
//                            starAnimation_X[i] += 14;
//                            starAnimation_Y[i] -= 10;
//                            break;
//                        }
//                    }
//                }
//
//                if (countAnimation >= 15) {
//                    animationCloudActive = false;
//                    countAnimation = 0;
//                    if (tutorialGame
//                            && stepTutorial < Constants.STEP_TUTORIAL_FIRST_EGG
//                            && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                        stepTutorial++;
//                    }
//
//                }
//
//            }
//        }
//    }
//
//    private void paintShowCollection(Canvas canvas) {
//
//        if (Constants.canShowCollection) {
//            int posX = mCanvasWidth - backgFoundCollection.getWidth()
//                    - collectionShowOffsetX;
//            int posY = collectionShowOffsetY;
//            int diff = 1;
//            canvas.drawBitmap(backgFoundCollection, posX, posY, null);
//
//            canvas.drawText(texts[223 + Constants.typeCollectionShow], posX
//                    + backgFoundCollection.getWidth() / 2, posY
//                    + collectionShowTextOffsetY, fontNameBuildingItems);
//
//            posX += backgFoundCollection.getWidth() / 2
//                    - ((backgCollectSmall.getWidth() + diff) * 5) / 2;
//            posY += backgFoundCollection.getHeight()
//                    - backgCollectSmall.getHeight() - collectionShowTextOffsetY;
//
//            for (int i = 1; i <= 5; i++) {
//                canvas.drawBitmap(backgCollectSmall, posX, posY, null);
//
//                if (i == Constants.posCollectionShow) {
//                    if (animationCollectionShow) {
//                        collectionsImages[Constants.typeCollectionShow]
//                                .paint(canvas,
//                                        (i),
//                                        posX
//                                                + backgCollectSmall.getWidth()
//                                                / 2
//                                                - (collectionsImages[Constants.typeCollectionShow].auxImage
//                                                        .getWidth() / 5) / 2,
//                                        posY
//                                                + backgCollectSmall.getHeight()
//                                                / 2
//                                                - (collectionsImages[Constants.typeCollectionShow].auxImage
//                                                        .getHeight()) / 2,
//                                        collectionsImages[Constants.typeCollectionShow].auxImage
//                                                .getHeight(),
//                                        collectionsImages[Constants.typeCollectionShow].auxImage
//                                                .getWidth() / 5, false, false,
//                                        false);
//                    }
//                    if (System.currentTimeMillis()
//                            - timeAnimationShowCollection >= 70) {
//                        timeAnimationShowCollection = System
//                                .currentTimeMillis();
//                        animationCollectionShow = (animationCollectionShow) ? false
//                                : true;
//                    }
//                } else {
//                    collectionsImages[Constants.typeCollectionShow]
//                            .paint(canvas,
//                                    (i),
//                                    posX
//                                            + backgCollectSmall.getWidth()
//                                            / 2
//                                            - (collectionsImages[Constants.typeCollectionShow].auxImage
//                                                    .getWidth() / 5) / 2,
//                                    posY
//                                            + backgCollectSmall.getHeight()
//                                            / 2
//                                            - (collectionsImages[Constants.typeCollectionShow].auxImage
//                                                    .getHeight()) / 2,
//                                    collectionsImages[Constants.typeCollectionShow].auxImage
//                                            .getHeight(),
//                                    collectionsImages[Constants.typeCollectionShow].auxImage
//                                            .getWidth() / 5, false, false,
//                                    false);
//                }
//                canvas.drawText(
//                        collectionPut[Constants.typeCollectionShow]
//                                .getQuantityItems()[i - 1] + "", posX
//                                + backgCollectSmall.getWidth() - 10, posY
//                                + backgCollectSmall.getHeight() - 5,
//                        fontWhiteSmallCenter);
//
//                posX += (backgCollectSmall.getWidth() + diff);
//            }
//
//            if (System.currentTimeMillis() - Constants.timeShowCollection >= 5000) {
//                Constants.timeShowCollection = System.currentTimeMillis();
//                Constants.canShowCollection = false;
//            }
//        }
//
//    }
//
//    private void paintAnimationFoundObject(Canvas canvas) {
//        Matrix matrix = new Matrix();
//        matrix.postRotate(rotateScale,
//                Constants.backgroundFoundObecjt.getWidth() / 2,
//                Constants.backgroundFoundObecjt.getHeight() / 2);
//
//        // recreate the new Bitmap
//        Bitmap resizedBitmap = Bitmap.createBitmap(
//                Constants.backgroundFoundObecjt, 0, 0,
//                Constants.backgroundFoundObecjt.getWidth(),
//                Constants.backgroundFoundObecjt.getHeight(), matrix, true);
//
//        canvas.drawBitmap(resizedBitmap,
//                mCanvasWidth / 2 - resizedBitmap.getWidth() / 2, mCanvasHeight
//                        / 2 - resizedBitmap.getHeight() / 2, null);
//
//        canvas.drawBitmap(diamondSmall,
//                mCanvasWidth / 2 - diamondSmall.getWidth() / 2, mCanvasHeight
//                        / 2 - diamondSmall.getHeight() / 2, null);
//
//        if (System.currentTimeMillis() - timeAnimationRotate >= 20) {
//            timeAnimationRotate = System.currentTimeMillis();
//            rotateScale += 4;
//            if (rotateScale >= 360) {
//                rotateScale = 0;
//            }
//
//        }
//    }
//
//    private void paintDiamondsFound(Canvas canvas) {
//        if (showPaintDiamondsFound) {
//            Bitmap[] bitmapAux = { diamondSmall, null };
//
//            String[] stringAux = {
//                    texts[182].replaceAll("X", diamondsFound + ""), texts[11] };
//            UtilSoftgames.PaintTextWithImageInLine(canvas, stringAux,
//                    bitmapAux, fontYellowSmallLef, mCanvasWidth / 2, panelCoins
//                            .getImage().getHeight() + 40);
//
//            paintAnimationFoundObject(canvas);
//
//            if (System.currentTimeMillis() - timeStorageCapacity >= 4000) {
//                timeStorageCapacity = System.currentTimeMillis();
//                showPaintDiamondsFound = false;
//            }
//        }
//    }
//
//    private void paintQuantityStorage(Canvas canvas) {
//        if (showPaintStorageCapacity) {
//            canvas.drawBitmap(quantityStorageIcon, mCanvasWidth / 2
//                    - quantityStorageIcon.getWidth() / 2, panelCoins.getImage()
//                    .getHeight() + quantityStorageBubbleOffsetY, null);
//            canvas.drawText(
//                    texts[181] + " " + totalQuantityStorage + "/"
//                            + maxItemStorage,
//                    mCanvasWidth / 2 - quantityStorageIcon.getWidth() / 2
//                            + quantityStorageBubbleOffsetX,
//                    panelCoins.getImage().getHeight()
//                            + (quantityStorageIcon.getHeight() / 3) * 2
//                            + quantityStorageBubbleOffsetY, fontYellowSmallLef);
//            if (System.currentTimeMillis() - timeStorageCapacity >= 4000) {
//                timeStorageCapacity = System.currentTimeMillis();
//                showPaintStorageCapacity = false;
//            }
//        }
//    }
//
//    /**
//     * Draws a blue box with an informative message
//     * 
//     * @param canvas
//     */
//    private void paintPopUpInfo(Canvas canvas) {
//        if (typeMsgInfo == null)
//            return;
//        int posBackgAutomatic_Y = mCanvasHeight - backgAutomatic.getHeight()
//                - 30;
//        int posBackgAutomatic_X = mCanvasWidth / 2 - backgAutomatic.getWidth()
//                / 2;
//
//        switch (typeMsgInfo) {
//        case MOVEBAD:
//            if (tutorialGame) {
//                posBackgAutomatic_Y = panelSeeds.getPosY()
//                        + panelSeeds.getImage().getHeight() + 5;
//            }
//            canvas.drawBitmap(backgAutomatic, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//            canvas.drawBitmap(infoIconTip, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//            canvas.drawText(texts[283], mCanvasWidth / 2, posBackgAutomatic_Y
//                    + (backgAutomatic.getHeight() / 4) * 3,
//                    fontQuantityMaterialProduce);
//            break;
//        case LEVEL_UP_FIRST:
//            if (tutorialGame) {
//
//                posBackgAutomatic_Y = panelSeeds.getPosY()
//                        + panelSeeds.getImage().getHeight() + 5;
//                canvas.drawBitmap(backgAutomatic, posBackgAutomatic_X,
//                        posBackgAutomatic_Y, null);
//                canvas.drawBitmap(infoIconTip, posBackgAutomatic_X,
//                        posBackgAutomatic_Y, null);
//                canvas.drawText(texts[453], mCanvasWidth / 2,
//                        posBackgAutomatic_Y + (backgAutomatic.getHeight() / 4)
//                                * 3, fontQuantityMaterialProduce);
//            }
//            break;
//        case AUTOMATIC:
//            break;
//        case PUTANIMAL:
//            break;
//        case MOVE:
//            canvas.drawBitmap(backgAutomatic, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//            canvas.drawBitmap(infoIconTip, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//
//            canvas.drawText(texts[69], mCanvasWidth / 2, posBackgAutomatic_Y
//                    + (backgAutomatic.getHeight() / 4) * 3,
//                    fontQuantityMaterialProduce);
//            break;
//        case PLOTSFULL:
//
//            break;
//        case STORAGEFULL:
//
//            break;
//        case FINISH_PRODUCTION:
//            canvas.drawBitmap(backgAutomatic, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//            canvas.drawBitmap(infoIconTip, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//            canvas.drawText(texts[454], mCanvasWidth / 2, posBackgAutomatic_Y
//                    + (backgAutomatic.getHeight() / 2) + 10,
//                    fontQuantityMaterialProduce);
//            break;
//        }
//
//    }
//
//    private void paintAutomatic(Canvas canvas) {
//        if (canShowInfoAuto && !storageFull) {
//            if (actionSelect == null) {
//                canShowInfoAuto = false;
//                return;
//            }
//            int posBackgAutomatic_Y = mCanvasHeight
//                    - backgAutomatic.getHeight() - 30;
//            int posBackgAutomatic_X = mCanvasWidth / 2
//                    - backgAutomatic.getWidth() / 2;
//            canvas.drawBitmap(backgAutomatic, posBackgAutomatic_X,
//                    posBackgAutomatic_Y, null);
//
//            checkedAutomatic.setPosX(posBackgAutomatic_X
//                    + backgAutomatic.getWidth()
//                    - checkedAutomatic.getImage().getWidth() - 20);
//            checkedAutomatic.setPosY(posBackgAutomatic_Y
//                    + backgAutomatic.getHeight() / 2
//                    - checkedAutomatic.getImage().getHeight() / 2);
//            checkedAutomatic.paint(canvas);
//
//            buttonClose.setPosX(posBackgAutomatic_X
//                    - buttonCloseSmall.getImage().getWidth() / 2);
//            buttonClose.setPosY(posBackgAutomatic_Y
//                    - buttonCloseSmall.getImage().getHeight() / 2);
//            buttonClose.paint(canvas);
//            String msjToShow = "";
//            String quantity = "";
//            switch (actionSelect) {
//            case ANIMALFINISHALL:
//                msjToShow = "finish  all Animals";
//                quantity = texts[52];
//                break;
//            case BUILDINGFINISHALL:
//                msjToShow = "finish  all Buildings";
//                quantity = texts[52];
//                break;
//            case ANIMAL_FOOD:
//                msjToShow = "Give food all animals";
//                quantity = texts[52];
//                ;
//                break;
//            case PLOW:
//                msjToShow = texts[51];
//                quantity = texts[52];
//                break;
//            case FERTILIZE:
//                msjToShow = texts[55];
//                quantity = texts[56];
//                break;
//            case PLANT:
//                msjToShow = texts[53];
//                quantity = texts[54];
//                break;
//            case HARVEST:
//                msjToShow = texts[57];
//                quantity = texts[58];
//                break;
//            case WATERING:
//                msjToShow = texts[59];
//                quantity = texts[60];
//                break;
//            }
//
//            canvas.drawText(msjToShow, mCanvasWidth / 2, posBackgAutomatic_Y
//                    + backgAutomatic.getHeight() / 4, fontMsjTitleStroke);
//            canvas.drawText(msjToShow, mCanvasWidth / 2, posBackgAutomatic_Y
//                    + backgAutomatic.getHeight() / 4, fontMsjTitle);
//
//            // canvas.drawText(quantity, mCanvasWidth/2 ,
//            // posBackgAutomatic_Y + (backgAutomatic.getHeight()/4)*2,
//            // fontQuantityMaterialProduce);
//
//            String[] stringAux = { quantity };
//            Bitmap[] bitmapAux = { diamondSmall };
//            UtilSoftgames.PaintTextWithImageInLine(canvas, stringAux,
//                    bitmapAux, fontTitleLeft, mCanvasWidth / 2,
//                    posBackgAutomatic_Y + (backgAutomatic.getHeight() / 4) * 3);
//            if (tutorialGame) {
//                paintAnimationCursor(
//                        canvas,
//                        (checkedAutomatic.getPosX()
//                                + checkedAutomatic.getImage().getWidth() / 2 - cursorHand
//                                .getWidth() / 2), checkedAutomatic.getPosY()
//                                + checkedAutomatic.getImage().getHeight() / 2
//                                - cursorHand.getHeight() / 3 + cursorY, -1);
//
//            }
//
//        }
//    }
//
//    private void saveHelpers() {
//        String register = "";
//
//        register = String.valueOf(fakeFriends);
//        register += "|" + String.valueOf(friendsFacebok);
//
//        saveData("RegisterFriendsMLF2", register);
//    }
//
//    private void saveTutorial() {
//        String register = "";
//
//        register = String.valueOf(tutorialGame);
//
//        saveData("RegisterTutorialsMLF2", register);
//    }
//
//    private void saveCharacters() {
//        String register = "";
//
//        for (int i = 0; i < 3; i++) {
//            register += String.valueOf(characterChosen[i]);
//            register += "|";
//
//            register += String.valueOf(missionCharacter[i]);
//            register += "|";
//        }
//
//        saveData("RegisterCharactersMLF2", register);
//    }
//
//    private void saveItems() {
//
//        String register = String.valueOf(NTree);
//        register += "|";
//        register += String.valueOf(nAnimalsPut);
//        register += "|";
//        register += String.valueOf(nDecorationsPut);
//        register += "|";
//        register += String.valueOf(quantitySeeds);
//        register += "|";
//        register += String.valueOf(nLevel);
//        register += "|";
//        register += String.valueOf(quantityCoins);
//        register += "|";
//        register += String.valueOf(quantityExp);
//        register += "|";
//        register += String.valueOf(quantityDiamonds);
//        register += "|";
//        register += String.valueOf(isNoAdsItemPurchased);
//        register += "|";
//        register += String.valueOf(maxItemStorage);
//        register += "|";
//        register += String.valueOf(totalQuantityStorage);
//        register += "|";
//        register += String.valueOf(totalQuantityFood);
//        register += "|";
//        register += String.valueOf(indexStorage);
//        // register+="|";
//        // register += String.valueOf(nBuildingsPut);
//        register += "|";
//        register += String.valueOf((readInformationWeb() / 1000));
//        register += "|";
//        register += String.valueOf(quantityPlots);
//        register += "|";
//        register += String.valueOf(limitTotalPlots);
//
//        for (int i = 0; i < Constants.buildingUsed.length; i++) {
//            register += "|";
//            register += String.valueOf(Constants.buildingUsed[i]);
//        }
//
//        for (int i = 0; i < Constants.animalUsed.length; i++) {
//            register += "|";
//            register += String.valueOf(Constants.animalUsed[i]);
//        }
//
//        register += "|";
//        register += String.valueOf(Constants.currentExpansion);
//
//        for (int i = 0; i < quantityCurrentMaterial.length; i++) {
//            register += "|";
//            register += String.valueOf(quantityCurrentMaterial[i]);
//        }
//
//        saveData("RegisterItemMLF2", register);
//    }
//
//    private void saveCarInfo() {
//        String register = String.valueOf(userPurchased);
//
//        register += "|";
//        register += String.valueOf(timeOpenGame);
//
//        register += "|";
//        register += String.valueOf(runningBonus);
//
//        register += "|";
//        register += String.valueOf(timeSecondsOffer);
//
//        register += "|";
//        register += String.valueOf(currentDiscount);
//
//        register += "|";
//        register += String.valueOf(typeQuest);
//        register += "|";
//        register += String.valueOf(quantityQuest);
//        register += "|";
//        register += String.valueOf(countTimeQuest);
//        register += "|";
//        register += String.valueOf(canRewardQuestTruck);
//        register += "|";
//        register += String.valueOf(aceptQuestTruck);
//        register += "|";
//        register += String.valueOf(chosenOptionQuestTruck);
//        register += "|";
//        register += String.valueOf(animationCarTruck);
//
//        register += "|";
//        register += String.valueOf(carTruckAnimation_X);
//        register += "|";
//        register += String.valueOf(carTruckAnimation_Y);
//
//        register += "|";
//        register += String.valueOf(posInitCar_X);
//        register += "|";
//        register += String.valueOf(posInitCar_Y);
//
//        register += "|";
//        register += String.valueOf(carTruck_X);
//        register += "|";
//        register += String.valueOf(carTruck_Y);
//
//        register += "|";
//        register += String.valueOf(rewardCoinTruckJoe);
//        register += "|";
//        register += String.valueOf(rewardXpTruckJoe);
//
//        saveData("RegisterCarInfoMLF2", register);
//    }
//
//    private void saveCollection() {
//        String register = "";
//
//        for (int i = 0; i < 22; i++) {
//            for (int j = 0; j < 5; j++) {
//                register += String
//                        .valueOf(collectionPut[i].getQuantityItems()[j]);
//                register += ",";
//            }
//
//            register += String.valueOf(collectionPut[i].getLevel());
//            if (i < 21) {
//                register += ",";
//            }
//        }
//
//        saveData("RegisterCollectionsMLF2", register);
//    }
//
//    private void saveMissions() {
//        String register = "";
//
//        register = String.valueOf(nMission);
//        register += "|" + currentNumberMission;
//
//        for (int i = 0; i < nMission; i++) {
//            register += "|" + nTask[i];
//            register += "|" + rewardsCoins[i];
//            register += "|" + rewardsXP[i];
//            register += "|" + rewardsCoins[i];
//            register += "|" + rewardsXP[i];
//            register += "|" + diamondsToFinishMission[i];
//            register += "|" + canRewardMission[i];
//            register += "|" + rewardPaid[i];
//            for (int h = 0; h < nTask[i]; h++) {
//                register += "|" + typeMission[i][h];
//                register += "|" + quantityProduct[i][h];
//                register += "|" + typeProduct[i][h];
//                register += "|" + quantityProductDone[i][h];
//            }
//        }
//
//        saveData("RegisterMissionMLF2", register);
//
//    }
//
//    private void saveMap() {
//        String register = "";
//        for (int i = 0; i < Constants.N_TILED_WORLD_Y; i++) {
//            for (int j = 0; j < Constants.N_TILED_WORLD_X; j++) {
//                if (j > MAT_INF_X && j < MAT_SUP_X && i > MAT_INF_Y
//                        && i < MAT_SUP_Y) {
//                    register += mapContaints[i][j];
//                    register += ",";
//                }
//            }
//        }
//
//        for (int i = 0; i < Constants.N_TILED_WORLD_Y; i++) {
//            for (int j = 0; j < Constants.N_TILED_WORLD_X; j++) {
//                if (j > MAT_INF_X && j < MAT_SUP_X && i > MAT_INF_Y
//                        && i < MAT_SUP_Y) {
//                    register += mapObjects[i][j];
//                    register += ",";
//                }
//
//            }
//        }
//
//        saveData("RegisterMapMLF2", register);
//    }
//
//    public void saveTree() {
//        String register = "";
//        timeNotification = 99999000;
//        for (int i = 0; i < NTree; i++) {
//        	//if(tree[i].getPosX() != -1000){
//            	register += tree[i].getType();
//            	register += ",";
//            	register += tree[i].getPosX();
//            	register += ",";
//            	register += tree[i].getPosY();
//            	register += ",";
//            	register += tree[i].getTimeTranscurrent();
//            	register += ",";
//            	register += tree[i].getTiled();
//            	register += ",";
//            if (tree[i].getTiled() < 5 && tree[i].getPosX() != -1000) {
//            		int timeForReady = (Constants.CROPS_TIME_TO_WIN[tree[i].getType()] * 60) - tree[i].getTimeTranscurrent();
//                	if (timeNotification > timeForReady * 60) {
//                		timeNotification = timeForReady * 60;
//                	}
//            	}
//        //	}
//        }
//        saveData("RegisterTreeMLF2", register);
//    }
//    
//   
//
//    private void saveAnimal() {
//        String register = "";
//
//        for (int i = 0; i < nAnimalsPut; i++) {
//            register += animalsPut[i].getPos_X();
//            register += ",";
//            register += animalsPut[i].getPos_Y();
//            register += ",";
//            register += animalsPut[i].getType();
//            register += ",";
//            register += animalsPut[i].getTypeBuildingOwner();
//            register += ",";
//            register += animalsPut[i].getStatus();
//            register += ",";
//            register += animalsPut[i].getTimeTranscurrentProducing();
//            // register+=",";
//            // register +=animalsPut[i].getTimeUnderConstruct();
//
//            if (i < nAnimalsPut - 1) {
//                register += ",";
//            }
//        }
//        saveData("RegisterAnimalMLF2", register);
//    }
//
//    private void saveDecoration() {
//        String register = "";
//        for (int i = 0; i < nDecorationsPut; i++) {
//            register += decorationsPut[i].getPos_X();
//            register += ",";
//            register += decorationsPut[i].getPos_Y();
//            register += ",";
//            register += decorationsPut[i].getType();
//            register += ",";
//            register += decorationsPut[i].isFlip();
//            if (i < nDecorationsPut - 1) {
//                register += ",";
//            }
//        }
//        saveData("RegisterDecorationMLF2", register);
//    }
//
//    private void saveBuilding() {
//        String register = "";
//
//        /*
//         * int trueNBuildingsPut = 0;
//         * 
//         * for(int i = 0; i < nBuildingsPut; i++){ if(buildingsPut[i].getPosX()
//         * != -1000){ trueNBuildingsPut++; } }
//         */
//
//        register += nBuildingsPut;
//        register += ",";
//        for (int i = 0; i < nBuildingsPut; i++) {
//            // if(buildingsPut[i].getPosX() != -1000){
//            register += buildingsPut[i].getPosX();
//            register += ",";
//            register += buildingsPut[i].getPosY();
//            register += ",";
//            register += buildingsPut[i].getType();
//            register += ",";
//            register += buildingsPut[i].getClassType();
//            register += ",";
//            register += buildingsPut[i].isFourSpace();
//            register += ",";
//            register += buildingsPut[i].getPosX_1();
//            register += ",";
//            register += buildingsPut[i].getPosY_1();
//            register += ",";
//            register += buildingsPut[i].getPosX_2();
//            register += ",";
//            register += buildingsPut[i].getPosY_2();
//            register += ",";
//            register += buildingsPut[i].getPosX_3();
//            register += ",";
//            register += buildingsPut[i].getPosY_3();
//            register += ",";
//
//            for (int j = 0; j < 5; j++) {
//                register += buildingsPut[i].getSlot()[j];
//                register += ",";
//                register += buildingsPut[i].getItemProducing()[j];
//                register += ",";
//                register += buildingsPut[i].getTimeProductsInSlot()[j];
//                register += ",";
//            }
//            register += buildingsPut[i].getUpdgrade();
//            register += ",";
//            register += buildingsPut[i].isReady();
//            register += ",";
//            register += buildingsPut[i].isFlip();
//            register += ",";
//            register += buildingsPut[i].isShowTimeUnderConstruction();
//            register += ",";
//            register += buildingsPut[i].getTimeUnderConstruct();
//            register += ",";
//            register += buildingsPut[i].getCurrentSlotActive();
//            if (i < nBuildingsPut - 1) {
//                register += ",";
//            }
//            // }
//        }
//
//        saveData("RegisterBuildingMLF2", register);
//    }
//
//    private void saveExpansion() {
//        String register = "";
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                register += mapExpansion[i][j];
//                register += ",";
//            }
//        }
//        saveData("RegisterExpansionMLF2", register);
//    }
//
//    private void saveStorage() {
//        String register = "";
//      //  System.out.println("indexStorage " + indexStorage);
//        for (int i = 0; i < indexStorage; i++) {
//            register += itemStorage[i][0];
//            register += ",";
//            register += itemStorage[i][1];
//            register += ",";
//            register += itemStorage[i][2];
//            register += ",";
//
//        }
//
//        for (int i = 0; i < 17/*cropsQuantityRecolect.length*/; i++) {
//            register += "0";//cropsQuantityRecolect[i];
//            register += ",";
//        }
//
//        saveData("RegisterStorageMLF2", register);
//    }
//
//    private void saveAchiviements() {
//        String register = "";
//
//        for (int i = 0; i < Constants.LEVEL_ACHIEVEMENTS.length; i++) {
//            register += Constants.LEVEL_ACHIEVEMENTS[i];
//            register += ",";
//        }
//
//        for (int i = 0; i < Constants.CURRENT_QUANTITY_ACHIEVEMENTS.length; i++) {
//            register += Constants.CURRENT_QUANTITY_ACHIEVEMENTS[i];
//            register += ",";
//        }
//
//        saveData("RegisterAchievementsMLF2", register);
//    }
//
//    private void saveBuildingInStorage() {
//        String register = "";
//
//        int trueIndexBuildStorage = 0;
//
//        for (int i = 0; i < indexBuildSaveStorage; i++) {
//            if (buildingsSaveStorage[i].getType() != -1000) {
//                trueIndexBuildStorage++;
//            }
//        }
//
//        register += trueIndexBuildStorage;
//        register += ",";
//
//        for (int i = 0; i < indexBuildSaveStorage; i++) {
//            if (buildingsSaveStorage[i].getType() != -1000) {
//                register += buildingsSaveStorage[i].getPosX();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosY();
//                register += ",";
//                register += buildingsSaveStorage[i].getType();
//                register += ",";
//                register += buildingsSaveStorage[i].getClassType();
//                register += ",";
//                register += buildingsSaveStorage[i].isFourSpace();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosX_1();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosY_1();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosX_2();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosY_2();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosX_3();
//                register += ",";
//                register += buildingsSaveStorage[i].getPosY_3();
//                register += ",";
//
//                for (int j = 0; j < 5; j++) {
//                    register += buildingsSaveStorage[i].getSlot()[j];
//                    register += ",";
//                    register += buildingsSaveStorage[i].getItemProducing()[j];
//                    register += ",";
//                    register += buildingsSaveStorage[i].getTimeProductsInSlot()[j];
//                    register += ",";
//                }
//                register += buildingsSaveStorage[i].getUpdgrade();
//                register += ",";
//                register += buildingsSaveStorage[i].isReady();
//                register += ",";
//                register += buildingsSaveStorage[i].isFlip();
//                register += ",";
//                register += buildingsSaveStorage[i]
//                        .isShowTimeUnderConstruction();
//                register += ",";
//                register += buildingsSaveStorage[i].getTimeUnderConstruct();
//                register += ",";
//                register += buildingsSaveStorage[i].getCurrentSlotActive();
//
//                if (i < indexBuildSaveStorage - 1) {
//                    register += ",";
//                }
//            }
//        }
//
//        saveData("RegisterBuildingStorageMLF2", register);
//    }
//
//    public void saveGame() {
//        Log.d(TAG, "saveGame()");
//        saveTutorial();
//        saveItems();
//        saveCharacters();
//        saveCarInfo();
//        saveMap();
//        saveTree();
//        saveAnimal();
//        saveDecoration();
//        saveBuilding();
//        saveExpansion();
//        saveStorage();
//        saveAchiviements();
//        saveCollection();
//        saveMissions();
//        saveHelpers();
//        saveBuildingInStorage();
//        saveMastered();
//        saveQuantintyAchievementsComplete();
//    }
//
//    
//    private void saveQuantintyAchievementsComplete() {
//    	  String register = "";
//          register += String.valueOf(Constants.numberArchievementsComplete);
//
//          saveData("quantityAchievementsMLF2", register);
//
//    }
//    private void saveMastered() {
//        String register = "";
//        for (int i = 0; i < Constants.TreeQuantity.length; i++) {
//            register += String.valueOf(Constants.TreeQuantity[i]);
//            register += "|";
//        }
//
//        for (int i = 0; i < Constants.CROPS_QUANTITY_LEVELS.length; i++) {
//            register += String.valueOf(Constants.CROPS_QUANTITY_LEVELS[i]);
//            register += "|";
//        }
//
//        saveData("RegisterMasteredMLF2", register);
//    }
//
//    private void saveData(String register, String data) {
//        FileOutputStream fos = null;
//        try {
//            fos = main.openFileOutput(register, 0);
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeUTF(data);
//            dos.flush();
//            dos.close();
//        } catch (Exception e) {
//        } finally {
//            try {
//                if (fos != null) {
//                    fos.close();
//                }
//            } catch (Exception exc) {
//            }
//        }
//    }
//
//    private String loadData(String register) {
//        String info = "-1";
//
//        FileInputStream fis = null;
//
//        try {
//            fis = main.openFileInput(register);
//            DataInputStream dis = new DataInputStream(fis);
//            info = dis.readUTF();
//        } catch (Exception e) {
//            return null;
//        } finally {
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//            } catch (Exception exc) {
//            }
//        }
//
//        if (info.equals("-1")) {
//            return null;
//        }
//
//        return info;
//    }
//
//    private long readInformationWeb() {
//        long currentTime = System.currentTimeMillis();
//        /*
//         * try {
//         * 
//         * HttpClient client = new DefaultHttpClient(); HttpGet request = new
//         * HttpGet("http://utils.softgames.de/timestamp.php"); // Get the
//         * response ResponseHandler<String> responseHandler = new
//         * BasicResponseHandler(); String response_str = client.execute(request,
//         * responseHandler); // textView.setText(response_str); //
//         * System.out.println("result: " + response_str); currentTime =
//         * Long.parseLong(response_str); currentTime = currentTime * 1000;
//         * 
//         * } catch (Exception e) { //
//         * System.out.println("Some error occurred."); // currentTime = 0;// 0;
//         * }
//         */
//
//        return currentTime;
//    }
//
//    private void resetValuesCharacter() {
//        for (int i = 0; i < 3; i++) {
//            characterChosen[i] = -1;
//            missionCharacter[i] = -1;
//        }
//    }
//    
//    private void restartGame(){
//    	 resetValuesCharacter();
//         defineMission(false);
//         defineCharacter();
//         defineQuestTruck();
//         insertFeedMill();
//         inicializateExpansion();
//    }
//
//    private void loadGame() {
//        Log.d(TAG, "loadGame()");
//        String data = "";
//        if (loadData("RegisterItemMLF2") == null) {
//        	restartGame();
//            return;
//        }
//
//        tutorialGame = Boolean.parseBoolean(loadData("RegisterTutorialsMLF2"));
//       // tutorialGame = true; //buque
//        // tutorialGame = false;
//        // stepTutorial = Constants.STEP_TUTORIAL_FREE;
//        // itemToChoosed = -1;
//        // animationCursor = true;
//        // stepInAuxTutorial = 0;
//        // assigStorage(Constants.STORAGECROPS, 10,0);
//
//        if (tutorialGame) {
//           /* resetValuesCharacter();
//            defineMission(false);
//            defineCharacter();
//            defineQuestTruck();
//            insertFeedMill();
//            inicializateExpansion();*/
//        	restartGame();
//            return;
//        }
//
//        StringTokenizer tokens = new StringTokenizer(
//                loadData("RegisterItemMLF2"), "|");
//
//        NTree = Integer.parseInt(tokens.nextToken());
//        nAnimalsPut = Integer.parseInt(tokens.nextToken());
//        nDecorationsPut = Integer.parseInt(tokens.nextToken());
//        quantitySeeds = Integer.parseInt(tokens.nextToken());
//        nLevel = Integer.parseInt(tokens.nextToken());
//
//       
//        quantityCoins = Integer.parseInt(tokens.nextToken());
//        quantityExp = Integer.parseInt(tokens.nextToken());
//        quantityDiamonds = Integer.parseInt(tokens.nextToken());
//        
//        nLevel = 3;//buque
//        quantityCoins = 999999999;//buque
//        quantityDiamonds = 900000;//buque
//        
//        isNoAdsItemPurchased = Boolean.parseBoolean(tokens.nextToken());
//        maxItemStorage = Integer.parseInt(tokens.nextToken());
//        totalQuantityStorage = Integer.parseInt(tokens.nextToken());
//        totalQuantityFood = Integer.parseInt(tokens.nextToken());
//        indexStorage = Integer.parseInt(tokens.nextToken());
//        // nBuildingsPut = Integer.parseInt(tokens.nextToken());
//        int timeTransInSec = ((int) (readInformationWeb() / 1000) - Integer
//                .parseInt(tokens.nextToken()));
//        quantityPlots = Integer.parseInt(tokens.nextToken());
//        limitTotalPlots = Integer.parseInt(tokens.nextToken());
//        for (int i = 0; i < Constants.buildingUsed.length; i++) {
//            Constants.buildingUsed[i] = Integer.parseInt(tokens.nextToken());
//        }
//
//        for (int i = 0; i < Constants.animalUsed.length; i++) {
//            Constants.animalUsed[i] = Integer.parseInt(tokens.nextToken());
//        }
//        Constants.currentExpansion = Integer.parseInt(tokens.nextToken());
//
//        for (int i = 0; i < quantityCurrentMaterial.length; i++) {
//            quantityCurrentMaterial[i] = Integer.parseInt(tokens.nextToken());
//        }
//
//        tokens = new StringTokenizer(loadData("RegisterCarInfoMLF2"), "|");
//
//        userPurchased = Boolean.parseBoolean(tokens.nextToken());
//        timeOpenGame = Integer.parseInt(tokens.nextToken());
//        timeOpenGame += 1;
//        runningBonus = Boolean.parseBoolean(tokens.nextToken());
//        timeSecondsOffer = Integer.parseInt(tokens.nextToken());
//        timeSecondsOffer -= timeTransInSec;
//        currentDiscount = Integer.parseInt(tokens.nextToken());
//
//        if (timeSecondsOffer <= 0) {
//            runningBonus = false;
//            timeSecondsOffer = 15 * 60;
//            currentDiscount += 10;
//
//            if (currentDiscount > 70) {
//                currentDiscount = 70;
//            }
//        }
//
//        typeQuest = Integer.parseInt(tokens.nextToken());
//        quantityQuest = Integer.parseInt(tokens.nextToken());
//        countTimeQuest = Integer.parseInt(tokens.nextToken());
//        countTimeQuest -= timeTransInSec;
//
//        canRewardQuestTruck = Boolean.parseBoolean(tokens.nextToken());
//        aceptQuestTruck = Boolean.parseBoolean(tokens.nextToken());
//        chosenOptionQuestTruck = Boolean.parseBoolean(tokens.nextToken());
//        animationCarTruck = Boolean.parseBoolean(tokens.nextToken());
//        
//        carTruckAnimation_X = Integer.parseInt(tokens.nextToken());
//        carTruckAnimation_Y = Integer.parseInt(tokens.nextToken());
//        posInitCar_X = Integer.parseInt(tokens.nextToken());
//        posInitCar_Y = Integer.parseInt(tokens.nextToken());
//        carTruck_X = Integer.parseInt(tokens.nextToken());
//        carTruck_Y = Integer.parseInt(tokens.nextToken());
//
//       /* if (chosenOptionQuestTruck && !aceptQuestTruck) {
//            if (countTimeQuest <= 0) {
//                animationCarTruck = true;
//                chosenOptionQuestTruck = true;
//                inicializatePosCar();
//                defineQuestTruck();
//            }
//        }*/
//
//        rewardCoinTruckJoe = Integer.parseInt(tokens.nextToken());
//        rewardXpTruckJoe = Integer.parseInt(tokens.nextToken());
//        StringTokenizer tokensAux ;
//        
//        data = loadData("RegisterMapMLF2");
//        if(data == null){
//        	data = "";
//        	restartGame();
//        	tutorialGame = true;
//        } else {
//        	tokensAux = new StringTokenizer(data, ",");
//
//        	for (int i = 0; i < Constants.N_TILED_WORLD_Y; i++) {
//        		for (int j = 0; j < Constants.N_TILED_WORLD_X; j++) {
//        			if (j > MAT_INF_X && j < MAT_SUP_X && i > MAT_INF_Y
//                        && i < MAT_SUP_Y) {
//        				mapContaints[i][j] = Integer
//                            .parseInt(tokensAux.nextToken());
//        			}
//        		}
//        	}
//
//        	for (int i = 0; i < Constants.N_TILED_WORLD_Y; i++) {
//        		for (int j = 0; j < Constants.N_TILED_WORLD_X; j++) {
//        			if (j > MAT_INF_X && j < MAT_SUP_X && i > MAT_INF_Y
//                        && i < MAT_SUP_Y) {
//        				mapObjects[i][j] = Integer.parseInt(tokensAux.nextToken());
//        			}
//        		}
//        	}
//        }
//
//        tokensAux = new StringTokenizer(loadData("RegisterTreeMLF2"), ",");
//      //  int realTree = 0;
//        int type = 0;
//    	int posX = 0;
//        int posY = 0;
//        int timeTransCurrent = 0;
//        int nTiled = 0;
//        for (int i = 0; i < NTree; i++) {
//        	
//        	try{
//        		type = Integer.parseInt(tokensAux.nextToken());
//        		posX = Integer.parseInt(tokensAux.nextToken());
//        		posY = Integer.parseInt(tokensAux.nextToken());
//        		timeTransCurrent = Integer.parseInt(tokensAux.nextToken());
//        		nTiled = Integer.parseInt(tokensAux.nextToken());
//        	} catch (NoSuchElementException e) {
//				//continue;
//			}
//        	
//            
//        	
//            tree[i] = new Crop(type, posX, posY);
//            tree[i].setTimeTranscurrent(timeTransCurrent);
//            tree[i].setTiled(nTiled);
//            
//            if (Constants.cropsImage[Constants.CROPS_ORD[tree[i].getType()]][0] == null) {
//                loadCrops(tree[i].getType());
//            }
//            tree[i].setTimeTranscurrent(tree[i].getTimeTranscurrent()
//                    + timeTransInSec);
//            
//           // realTree ++;
//        }
//       // NTree = realTree;
//
//        data = loadData("RegisterAnimalMLF2");
//        if(data == null){
//        	data = "";
//        	nAnimalsPut = 0;
//        }
//        tokensAux = new StringTokenizer(data, ",");
//        for (int i = 0; i < nAnimalsPut; i++) {
//            animalsPut[i] = new Animal(Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()));
//
//            animalsPut[i].setStatus(Integer.parseInt(tokensAux.nextToken()));
//            animalsPut[i].setTimeTranscurrentProducing(Integer
//                    .parseInt(tokensAux.nextToken()));
//            // animalsPut[i].setTimeUnderConstruct(Integer.parseInt(tokensAux.nextToken()));
//
//            if (Constants.animalsProducing[Constants.ANIMALS_ORD[animalsPut[i]
//                    .getType()]][0] == null) {
//                loadAnimalsImg(animalsPut[i].getType());
//            }
//
//            if (animalsPut[i].isReady()) {
//                if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_WORKING) {
//                    animalsPut[i].setTimeTranscurrentProducing(animalsPut[i]
//                            .getTimeTranscurrentProducing() - timeTransInSec);
//                    if (animalsPut[i].getTimeTranscurrentProducing() <= 0) {
//                        animalsPut[i].setStatus(Constants.STATUS_ANIMALS_READY);
//                        animalsPut[i].setProducing(false);
//                        animalsPut[i]
//                                .setTimeTranscurrentProducing(Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                                        .getType()][3]);
//                    }
//
//                }
//
//            }
//        }
//
//        data = loadData("RegisterCharactersMLF2");
//        if(data == null){
//        	data = "";
//        } else {
//        	tokensAux = new StringTokenizer(data, "|");
//        	for (int i = 0; i < 3; i++) {
//            	characterChosen[i] = Integer.parseInt(tokensAux.nextToken());
//            	missionCharacter[i] = Integer.parseInt(tokensAux.nextToken());
//        	}
//        }
//
//        data = loadData("RegisterDecorationMLF2");
//        if(data == null){
//        	data = "";
//        	nDecorationsPut = 0;
//        }
//        tokensAux = new StringTokenizer(data, ",");
//        for (int i = 0; i < nDecorationsPut; i++) {
//            decorationsPut[i] = new Decoration(Integer.parseInt(tokensAux
//                    .nextToken()), Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()));
//            decorationsPut[i].setFlip(Boolean.parseBoolean(tokensAux
//                    .nextToken()));
//            /*if (Constants.decorationsImage[Constants.DECORATIONS_INFO[decorationsPut[i]
//                    .getType()][6]] == null) {
//                loadDecorationsImg(decorationsPut[i].getType());
//            }*/
//        }
//
//        data = loadData("RegisterBuildingMLF2");
//        if(data == null){
//        	data = "";
//        } else {
//        tokensAux = new StringTokenizer(data, ",");
//
//        nBuildingsPut = Integer.parseInt(tokensAux.nextToken());
//
//        for (int i = 0; i < nBuildingsPut; i++) {
//            buildingsPut[i] = new Building(Integer.parseInt(tokensAux
//                    .nextToken()), Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()),
//                    Boolean.parseBoolean(tokensAux.nextToken()));
//
//            buildingsPut[i].setPosX_1(Integer.parseInt(tokensAux.nextToken()));
//            buildingsPut[i].setPosY_1(Integer.parseInt(tokensAux.nextToken()));
//            buildingsPut[i].setPosX_2(Integer.parseInt(tokensAux.nextToken()));
//            buildingsPut[i].setPosY_2(Integer.parseInt(tokensAux.nextToken()));
//            buildingsPut[i].setPosX_3(Integer.parseInt(tokensAux.nextToken()));
//            buildingsPut[i].setPosY_3(Integer.parseInt(tokensAux.nextToken()));
//
//            for (int j = 0; j < 5; j++) {
//                buildingsPut[i].setSlot(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//                buildingsPut[i].setItemProducing(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//                buildingsPut[i].setTimeProductsInSlot(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//            }
//
//            buildingsPut[i]
//                    .setUpdgrade(Integer.parseInt(tokensAux.nextToken()));
//
//            buildingsPut[i]
//                    .setReady(Boolean.parseBoolean(tokensAux.nextToken()));
//            buildingsPut[i]
//                    .setFlip(Boolean.parseBoolean(tokensAux.nextToken()));
//            buildingsPut[i].setShowTimeUnderConstruction(Boolean
//                    .parseBoolean(tokensAux.nextToken()));
//            buildingsPut[i].setTimeUnderConstruct(Integer.parseInt(tokensAux
//                    .nextToken()));
//            buildingsPut[i].setCurrentSlotActive(Integer.parseInt(tokensAux
//                    .nextToken()));
//
//            int upd = buildingsPut[i].getUpdgrade();
//            if (buildingsPut[i].getClassType() == Constants.BUILDINGNORMAL
//                    || buildingsPut[i].getClassType() == Constants.BUILDINGANIMAL) {
//                upd -= 1;
//            }
//            if (upd != -1) {
//                if (Constants.buildings[Constants.BUILDING_ORD[buildingsPut[i]
//                        .getType()]][upd] == null) {
//                    loadBuildingsImg(
//                            Constants.BUILDING_ORD[buildingsPut[i].getType()],
//                            upd);
//                }
//            }
//
//            for (int f = 0; f < 4; f++) {
//                loadProductsImg(buildingsPut[i].getItemProduce()[f]);
//                loadProductsImg(buildingsPut[i].getMaterialProcesing1()[f]);
//                loadProductsImg(buildingsPut[i].getMaterialProcesing2()[f]);
//            }
//
//            if (buildingsPut[i].isReady()) {
//                if (buildingsPut[i].getSlot()[buildingsPut[i]
//                        .getCurrentSlotActive()] == 2) {
//                    buildingsPut[i].setTimeTranscurrent(buildingsPut[i]
//                            .getTimeTranscurrent() + timeTransInSec);
//                }
//
//                if (buildingsPut[i].getSlot()[buildingsPut[i]
//                        .getCurrentSlotActive()] == 2
//                        && buildingsPut[i].getTimeTranscurrent() >= buildingsPut[i]
//                                .getTimeProductsInSlot()[buildingsPut[i]
//                                .getCurrentSlotActive()]) {
//
//                    buildingsPut[i].changeStatus(3);
//                    buildingsPut[i].getSlot()[buildingsPut[i]
//                            .getCurrentSlotActive()] = 3;
//                    buildingsPut[i].setTimeTranscurrent(0);
//                    for (int h = 0; h < 5; h++) {
//                        if (buildingsPut[i].getSlot()[h] == 2) {
//                            buildingsPut[i].setCurrentSlotActive(h);
//                            break;
//                        }
//                    }
//                }
//
//            } else {
//                buildingsPut[i].setTimeUnderConstruct(buildingsPut[i]
//                        .getTimeUnderConstruct() - timeTransInSec);
//            }
//        }
//        }
//        
//        data = loadData("RegisterStorageMLF2");
//        if(data == null){
//        	data = "";
//        	indexStorage = 0;
//        } else {
//        tokensAux = new StringTokenizer(data, ",");
//        try{
//        	for (int i = 0; i < indexStorage; i++) {
//        		itemStorage[i][0] = Integer.parseInt(tokensAux.nextToken());
//        		itemStorage[i][1] = Integer.parseInt(tokensAux.nextToken());
//        		loadProductsImg(itemStorage[i][1]);
//        		itemStorage[i][2] = Integer.parseInt(tokensAux.nextToken());
//        	}
//
//        	/*for (int i = 0; i < cropsQuantityRecolect.length; i++) {
//        		cropsQuantityRecolect[i] = Integer.parseInt(tokensAux.nextToken());
//        	}*/
//        
//        } catch (NoSuchElementException e) { }
//        }
//        
//        data = loadData("RegisterExpansionMLF2");
//        if(data == null){
//        	data = "";
//        } else {
//        	tokensAux = new StringTokenizer(data, ",");
//        	for (int i = 0; i < 5; i++) {
//        		for (int j = 0; j < 5; j++) {
//        			mapExpansion[i][j] = Integer.parseInt(tokensAux.nextToken());
//        		}
//        	}
//        }
//        
//        data = loadData("RegisterAchievementsMLF2");
//        if(data == null){
//        	data = "";
//        } else {
//        tokensAux = new StringTokenizer(data,
//                ",");
//        for (int i = 0; i < Constants.LEVEL_ACHIEVEMENTS.length; i++) {
//            Constants.LEVEL_ACHIEVEMENTS[i] = Integer.parseInt(tokensAux
//                    .nextToken());
//        }
//
//        for (int i = 0; i < Constants.CURRENT_QUANTITY_ACHIEVEMENTS.length; i++) {
//            Constants.CURRENT_QUANTITY_ACHIEVEMENTS[i] = Integer
//                    .parseInt(tokensAux.nextToken());
//        }
//        }
//        tokensAux = new StringTokenizer(loadData("RegisterCollectionsMLF2"),
//                ",");
//        for (int i = 0; i < 22; i++) {
//            collectionPut[i].setLevel(Integer.parseInt(tokensAux.nextToken()));
//            for (int j = 0; j < 5; j++) {
//                collectionPut[i].setQuantityItems(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//            }
//        }
//
//        tokensAux = new StringTokenizer(loadData("RegisterMissionMLF2"), "|");
//
//        nMission = Integer.parseInt(tokensAux.nextToken());
//        currentNumberMission = Integer.parseInt(tokensAux.nextToken());
//        int garbage = 0; //this variable is not need.. but its need for read the data saved.
//        for (int i = 0; i < nMission; i++) {
//            nTask[i] = Integer.parseInt(tokensAux.nextToken());
//            rewardsCoins[i] = Integer.parseInt(tokensAux.nextToken());
//            rewardsXP[i] = Integer.parseInt(tokensAux.nextToken());
//            garbage = Integer.parseInt(tokensAux.nextToken());
//            garbage = Integer.parseInt(tokensAux.nextToken());
//            diamondsToFinishMission[i] = Integer
//                    .parseInt(tokensAux.nextToken());
//            canRewardMission[i] = Boolean.parseBoolean(tokensAux.nextToken());
//            rewardPaid[i] = Boolean.parseBoolean(tokensAux.nextToken());
//            for (int h = 0; h < nTask[i]; h++) {
//                typeMission[i][h] = Integer.parseInt(tokensAux.nextToken());
//
//                quantityProduct[i][h] = Integer.parseInt(tokensAux.nextToken());
//                typeProduct[i][h] = Integer.parseInt(tokensAux.nextToken());
//                quantityProductDone[i][h] = Integer.parseInt(tokensAux
//                        .nextToken());
//                loadProductsImg(typeProduct[i][h]);
//            }
//        }
//
//        tokensAux = new StringTokenizer(loadData("RegisterFriendsMLF2"), "|");
//
//        fakeFriends = Byte.parseByte(tokensAux.nextToken());
//        friendsFacebok = Byte.parseByte(tokensAux.nextToken());
//        totalfriends = friendsFacebok + fakeFriends;
//
//        tokensAux = new StringTokenizer(
//                loadData("RegisterBuildingStorageMLF2"), ",");
//        indexBuildSaveStorage = Integer.parseInt(tokensAux.nextToken());
//        for (int i = 0; i < indexBuildSaveStorage; i++) {
//            buildingsSaveStorage[i] = new Building(Integer.parseInt(tokensAux
//                    .nextToken()), Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()),
//                    Integer.parseInt(tokensAux.nextToken()),
//                    Boolean.parseBoolean(tokensAux.nextToken()));
//
//            buildingsSaveStorage[i].setPosX_1(Integer.parseInt(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setPosY_1(Integer.parseInt(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setPosX_2(Integer.parseInt(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setPosY_2(Integer.parseInt(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setPosX_3(Integer.parseInt(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setPosY_3(Integer.parseInt(tokensAux
//                    .nextToken()));
//
//            for (int j = 0; j < 5; j++) {
//                buildingsSaveStorage[i].setSlot(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//                buildingsSaveStorage[i].setItemProducing(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//                buildingsSaveStorage[i].setTimeProductsInSlot(
//                        Integer.parseInt(tokensAux.nextToken()), j);
//            }
//
//            buildingsSaveStorage[i].setUpdgrade(Integer.parseInt(tokensAux
//                    .nextToken()));
//
//            buildingsSaveStorage[i].setReady(Boolean.parseBoolean(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setFlip(Boolean.parseBoolean(tokensAux
//                    .nextToken()));
//            buildingsSaveStorage[i].setShowTimeUnderConstruction(Boolean
//                    .parseBoolean(tokensAux.nextToken()));
//            buildingsSaveStorage[i].setTimeUnderConstruct(Integer
//                    .parseInt(tokensAux.nextToken()));
//            buildingsSaveStorage[i].setCurrentSlotActive(Integer
//                    .parseInt(tokensAux.nextToken()));
//
//            int upd = buildingsSaveStorage[i].getUpdgrade();
//            if (buildingsSaveStorage[i].getClassType() == Constants.BUILDINGNORMAL
//                    || buildingsSaveStorage[i].getClassType() == Constants.BUILDINGANIMAL) {
//                upd -= 1;
//            }
//            if (upd != -1) {
//                if (Constants.buildings[Constants.BUILDING_ORD[buildingsSaveStorage[i]
//                        .getType()]][upd] == null) {
//                    loadBuildingsImg(
//                            Constants.BUILDING_ORD[buildingsSaveStorage[i]
//                                    .getType()],
//                            upd);
//                }
//            }
//            if (buildingsSaveStorage[i].getClassType() == Constants.BUILDINGNORMAL) {
//
//                for (int f = 0; f < 4; f++) {
//                    loadProductsImg(buildingsSaveStorage[i].getItemProduce()[f]);
//                    loadProductsImg(buildingsSaveStorage[i]
//                            .getMaterialProcesing1()[f]);
//                    loadProductsImg(buildingsSaveStorage[i]
//                            .getMaterialProcesing2()[f]);
//                }
//
//            }
//
//        }
//
//        tokensAux = new StringTokenizer(loadData("RegisterMasteredMLF2"), "|");
//        for (int i = 0; i < Constants.TreeQuantity.length; i++) {
//            Constants.TreeQuantity[i] = Integer.parseInt(tokensAux.nextToken());
//        }
//
//        for (int i = 0; i < Constants.CROPS_QUANTITY_LEVELS.length; i++) {
//            Constants.CROPS_QUANTITY_LEVELS[i] = Integer.parseInt(tokensAux
//                    .nextToken());
//        }
//        
//        try{
//        tokensAux = new StringTokenizer(loadData("quantityAchievementsMLF2"), "|");
//        
//         if(tokensAux != null){
//        	 Constants.numberArchievementsComplete = Integer.parseInt(tokensAux.nextToken());
//         }
//         
//        }catch (Exception e) {
//			
//		}
//
//    }
//
//    private void transCurrent1Second() {
//
//        if (System.currentTimeMillis() - Time_EachSecond >= 1000) {
//            Time_EachSecond = System.currentTimeMillis();
//
//            if (runningBonus) {
//                timeSecondsOffer -= 1;
//                if (timeSecondsOffer == 0) {
//                    runningBonus = false;
//                    timeSecondsOffer = 15 * 60;
//                    currentDiscount += 10;
//
//                    if (currentDiscount > 70) {
//                        currentDiscount = 70;
//                    }
//                }
//            }
//
//            for (int i = 0; i < nBuildingsPut; i++) {
//                if (buildingsPut[i].isReady()) {
//                    if (buildingsPut[i].getSlot()[buildingsPut[i]
//                            .getCurrentSlotActive()] == 2) {
//                        buildingsPut[i].setTimeTranscurrent(buildingsPut[i]
//                                .getTimeTranscurrent() + 1);
//                    }
//
//                    if (buildingsPut[i].getSlot()[buildingsPut[i]
//                            .getCurrentSlotActive()] == 2
//                            && buildingsPut[i].getTimeTranscurrent() >= buildingsPut[i]
//                                    .getTimeProductsInSlot()[buildingsPut[i]
//                                    .getCurrentSlotActive()]) {
//
//                        buildingsPut[i].changeStatus(3);
//                        buildingsPut[i].getSlot()[buildingsPut[i]
//                                .getCurrentSlotActive()] = 3;
//                        buildingsPut[i].setTimeTranscurrent(0);
//                        for (int h = 0; h < 5; h++) {
//                            if (buildingsPut[i].getSlot()[h] == 2) {
//                                buildingsPut[i].setCurrentSlotActive(h);
//                                break;
//                            }
//                        }
//                    }
//
//                } else {
//                    buildingsPut[i].setTimeUnderConstruct(buildingsPut[i]
//                            .getTimeUnderConstruct() - 1);
//                }
//            }
//
//            for (int i = 0; i < NTree; i++) {
//                if (!tutorialGame
//                        || stepTutorial >= Constants.STEP_TUTORIAL_FREE) {
//                    tree[i].setTimeTranscurrent(tree[i].getTimeTranscurrent() + 1);
//                }
//            }
//
//            for (int i = 0; i < nAnimalsPut; i++) {
//                if (animalsPut[i].isReady()) {
//                    if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_WORKING) {
//                        animalsPut[i]
//                                .setTimeTranscurrentProducing(animalsPut[i]
//                                        .getTimeTranscurrentProducing() - 1);
//                        if (animalsPut[i].getTimeTranscurrentProducing() <= 0) {
//                            animalsPut[i]
//                                    .setStatus(Constants.STATUS_ANIMALS_READY);
//                            animalsPut[i].setProducing(false);
//                            animalsPut[i]
//                                    .setTimeTranscurrentProducing(Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                                            .getType()][3]);
//                        }
//
//                    }
//
//                }/*
//                  * else { animalsPut[i].setTimeUnderConstruct(animalsPut[i].
//                  * getTimeUnderConstruct() -1); }
//                  */
//            }
//
//            // if(choosedOptionQuestTruck && !aceptQuestTruck){
//            if (!animationCarTruck) {
//                countTimeQuest--;
//                if (countTimeQuest <= 0) {
//                    animationCarTruck = true;
//                    chosenOptionQuestTruck = true;
//                    inicializatePosCar();
//                    defineQuestTruck();
//                }
//            }
//        }
//
//        if (System.currentTimeMillis() - timeShowInfoBox >= 2000) {
//            timeShowInfoBox = System.currentTimeMillis();
//            typeMsgInfo = null;
//            if (itemToReturnAgain != -1) {
//                itemStorage[itemToReturnAgain][2] += 1;
//                totalQuantityStorage += 1;
//                if (totalQuantityStorage >= maxItemStorage) {
//                    storageFull = true;
//                }
//                itemToReturnAgain = -1;
//            }
//        }
//
//        if (pressHold && System.currentTimeMillis() - timePressHold >= 250) {
//            animationHold++;
//            timePressHold = System.currentTimeMillis();
//
//            if (animationHold == 5) {
//                animationHold = 1;
//                pressHold = false;
//                int[][] touch = tiledChosenInMap(null, (int) posPressX,
//                        (int) posPressY);
//                if (touchInBuilding(touch, true)
//                        // || touchInAnimal(touch,true)
//                        || touchInCrops(touch, true)
//                        || touchInDecoration(touch, true)) {
//                    recentOpenMenuRotate = true;
//                    return;
//                }
//            }
//
//        }
//
//    }
//
//    // Draws elements on the second layer
//    private void paintActionSelect(Canvas canvas) {
//
//        if (actionSelect != null) {
//            float sizeToReduce = 0.55f;
//            switch (actionSelect) {
//            case DECORATION:
//                if (itemSelected != -1) {
//
//                    Matrix matrixnew = new Matrix();
//                    matrixnew.setTranslate(
//                            mCanvasWidth
//                                    - ((int) (iconDecorations[itemSelected]
//                                            .getWidth() * sizeToReduce)) - 2,
//                            mCanvasHeight
//                                    - (((iconsMenuExpress[1].getImage()
//                                            .getHeight()) * 2) - 5)
//                                    + backgroundItemIcons.getHeight()
//                                    / 2
//                                    - (int) (iconDecorations[itemSelected]
//                                            .getHeight() * sizeToReduce) / 2);
//
//                    matrixnew.preScale(sizeToReduce, sizeToReduce);
//                    canvas.drawBitmap(decorationsBg, matrixnew, null);
//                    canvas.drawBitmap(iconDecorations[itemSelected], matrixnew,
//                            null);
//
//                    paintButtonCloseSmall(canvas, sizeToReduce);
//
//                }
//                break;
//            case ANIMAL:
//                if (itemSelected != -1) {
//
//                    Matrix matrixnew = new Matrix();
//                    matrixnew.setTranslate(
//                            mCanvasWidth
//                                    - ((int) (iconAnimals[itemSelected]
//                                            .getWidth() * sizeToReduce)) - 2,
//                            mCanvasHeight
//                                    - (((iconsMenuExpress[1].getImage()
//                                            .getHeight()) * 2) - 5)
//                                    + backgroundItemIcons.getHeight()
//                                    / 2
//                                    - (int) (iconAnimals[itemSelected]
//                                            .getHeight() * sizeToReduce) / 2);
//                    matrixnew.preScale(sizeToReduce, sizeToReduce);
//                    canvas.drawBitmap(decorationsBg, matrixnew, null);
//                    canvas.drawBitmap(iconAnimals[itemSelected], matrixnew,
//                            null);
//                    paintButtonCloseSmall(canvas, sizeToReduce);
//                }
//                break;
//            case PLOW:
//                iconsMenuExpressActive[0].setPosX(mCanvasWidth
//                        - iconsMenuExpressActive[0].getImage().getWidth());
//                iconsMenuExpressActive[0]
//                        .setPosY(mCanvasHeight
//                                - (iconsMenuExpressActive[0].getImage()
//                                        .getHeight() * 2) - 5);
//                iconsMenuExpressActive[0].paint(canvas);
//                break;
//            case HARVEST:
//                iconsMenuExpressActive[1].setPosX(mCanvasWidth
//                        - iconsMenuExpressActive[1].getImage().getWidth());
//                iconsMenuExpressActive[1]
//                        .setPosY(mCanvasHeight
//                                - (iconsMenuExpressActive[1].getImage()
//                                        .getHeight() * 2) - 5);
//                iconsMenuExpressActive[1].paint(canvas);
//                break;
//            case PLANT:
//
//                if (itemSelected != -1) {
//
//                    canvas.drawBitmap(backgroundItemIcons, mCanvasWidth
//                            - backgroundItemIcons.getWidth(), mCanvasHeight
//                            - (iconsMenuExpress[1].getImage().getHeight() * 2)
//                            - 5, null);
//
//                    canvas.drawBitmap(iconCrops[itemSelected], mCanvasWidth
//                            - backgroundItemIcons.getWidth() / 2
//                            - iconCrops[itemSelected].getWidth() / 2,
//                            mCanvasHeight
//                                    - ((iconsMenuExpress[1].getImage()
//                                            .getHeight() * 2) - 5)
//                                    + backgroundItemIcons.getHeight() / 2
//                                    - iconCrops[itemSelected].getHeight() / 2,
//                            null);
//                    paintButtonCloseSmall(canvas, sizeToReduce);
//                }
//                break;
//            case BUILDING:
//
//                Matrix matrixnew = new Matrix();
//                matrixnew
//                        .setTranslate(
//                                mCanvasWidth
//                                        - ((int) (iconBuilding[itemSelected]
//                                                .getWidth() * sizeToReduce))
//                                        - 2,
//                                mCanvasHeight
//                                        - (((iconsMenuExpress[1].getImage()
//                                                .getHeight()) * 2) - 5)
//                                        + backgroundItemIcons.getHeight()
//                                        / 2
//                                        - (int) (iconBuilding[itemSelected]
//                                                .getHeight() * sizeToReduce)
//                                        / 2);
//                matrixnew.preScale(sizeToReduce, sizeToReduce);
//
//                canvas.drawBitmap(decorationsBg, matrixnew, null);
//                canvas.drawBitmap(iconBuilding[itemSelected], matrixnew, null);
//                paintButtonCloseSmall(canvas, sizeToReduce);
//
//                break;
//            }
//        }
//    }
//
//    private void paintButtonCloseSmall(Canvas canvas, float sizeToReduce) {
//        if (!tutorialGame) {
//            buttonCloseSmall.setPosX(mCanvasWidth
//                    - buttonCloseSmall.getImage().getWidth());
//            buttonCloseSmall
//                    .setPosY(mCanvasHeight
//                            - (((iconsMenuExpress[1].getImage().getHeight()) * 2) - 5)
//                            + backgroundItemIcons.getHeight()
//                            / 2
//                            - (int) (iconDecorations[itemSelected].getHeight() * sizeToReduce)
//                            / 2 - buttonCloseSmall.getImage().getHeight() / 2);
//            buttonCloseSmall.paint(canvas);
//        }
//    }
//
//    private void animationMainGame(Canvas canvas) {
//        animationOpenMenuExpress();
//        animationElementChosen();
//    }
//
//    private void animationElementChosen() {
//
//        if (System.currentTimeMillis() - timeElementChosen >= 150) {
//            timeElementChosen = System.currentTimeMillis();
//            switch (elementChosen) {
//
//            case Constants.PRESS_BUTTON_ACCEPT_QUEST:
//                /*if (!chosenOptionQuestTruck) {
//                    chosenOptionQuestTruck = true;
//                    aceptQuestTruck = true;
//                    if (getQuantityProductInStorage(typeQuest) >= quantityQuest) {
//                        canRewardQuestTruck = true;
//                    }
//                    if (tutorialGame) {
//                        stepTutorial++;
//                        time_showIconTrucker = System.currentTimeMillis();
//                    }
//                }*/
//            	 //aceptQuestTruck = true;
//                stateGame = Constants.STATE_MAIN_GAME;
//
//                break;
//            case Constants.PRESS_BUTTON_CLOSE_AUTOMATIC:
//                canShowInfoAuto = false;
//                break;
//            case Constants.PRESS_BUTTON_DENY_QUEST:
//                countTimeQuest = Constants.DELAY_TRUCK_IN_SECONDS;
//                chosenOptionQuestTruck = true;
//                aceptQuestTruck = false;
//                animationCarTruck = false;
//                stateGame = Constants.STATE_MAIN_GAME;
//                break;
//            case Constants.PRESS_BUTTON_CLOSE_INFOPRODUCTS:
//                // State_Game = Constants.State_Produced;
//                stateGame = backup_StateGame;
//                break;
//            case Constants.PRESS_BUTTON_ADDHELPER:
//                addFakeFriends();
//                break;
//            case Constants.PRESS_BUTTON_INVITEFACE:
//
//                break;
//            case Constants.PRESS_BUTTON_ARROWLEFT:
//                if (stateGame == Constants.STATE_MORE_DIAMONDS) {
//                    stateGame = Constants.STATE_MORE_COINS;
//                    loadImages();
//                } else if (stateGame == Constants.STATE_ACHIEVEMENTS) {
//                    pageAchievements -= 2;
//                    if (pageAchievements < 0) {
//                        pageAchievements += 2;
//                    }
//                } else if (stateGame == Constants.STATE_COLLECTIONS) {
//                    pageCollection -= 2;
//                    if (pageCollection < 0) {
//                        pageCollection += 2;
//                    }
//                } else {
//                    animationMoveShop = true;
//                    contMoveAnimationShop = 0;
//                    animationShopLeft = false;
//                }
//                break;
//            case Constants.PRESS_BUTTON_UPDGRADE_FEEDMILL:
//                totalQuantityFood += 10;
//
//                for (int i = 0; i < 6; i += 2) {
//                    int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                            .getPosOrderInfos()
//                            + buildingsPut[buildingChosen].getUpdgrade()][i];
//                    int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                            .getPosOrderInfos()
//                            + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//
//                    switch (type) {
//                    case Constants.GOLD:
//                        if (isTransactionPossible(Constants.GOLD, quantityValue)) {
//                            quantityCoins -= quantityValue;
//                        } else {
//                            return;
//                        }
//
//                        break;
//                    case Constants.DIAMONDS:
//                        if (isTransactionPossible(Constants.DIAMONDS,
//                                quantityValue)) {
//                            quantityDiamonds -= quantityValue;
//                        } else {
//                            return;
//                        }
//
//                        break;
//                    case Constants.LEVEL:
//                        break;
//
//                    case Constants.STONES:
//                    case Constants.WOOD:
//                    case Constants.ROPES:
//                    case Constants.NAILS:
//                    case Constants.LEAF:
//                        quantityCurrentMaterial[type - 56] -= quantityValue;
//                        break;
//                    }
//
//                }
//
//                buildingsPut[2].setUpdgrade(buildingsPut[2].getUpdgrade() + 1);
//                if (Constants.buildings[buildingsPut[2].getType()][buildingsPut[2]
//                        .getUpdgrade()] == null) {
//                    loadBuildingsImg(buildingsPut[2].getType(),
//                            buildingsPut[2].getUpdgrade());
//                }
//
//                int[] pos = calculatePosInitialMap(buildingsPut[2].getPosX(),
//                        buildingsPut[2].getPosY());
//                inicializateAnimationCloud(pos[0] + World.posWorldX, pos[1]
//                        + World.posWorldY);
//
//                stateGame = Constants.STATE_MAIN_GAME;
//                break;
//            case Constants.PRESS_BUTTON_ARROWRIGHT:
//                if (stateGame == Constants.STATE_MORE_COINS) {
//                    stateGame = Constants.STATE_MORE_DIAMONDS;
//                    loadImages();
//                } else if (stateGame == Constants.STATE_ACHIEVEMENTS) {
//                    pageAchievements += 2;
//                    if (pageAchievements > 15) {
//                        pageAchievements -= 2;
//                    }
//                } else if (stateGame == Constants.STATE_COLLECTIONS) {
//                    pageCollection += 2;
//                    if (pageCollection > 20) {
//                        pageCollection -= 2;
//                    }
//                } else {
//                    animationMoveShop = true;
//                    contMoveAnimationShop = 0;
//                    animationShopLeft = true;
//                }
//                break;
//
//            
//            case Constants.PRESS_BUTTON_QUESTBOOST:
//
//                switch (actionBoost) {
//
//                case Constants.ACTION_BOOST_FINISH_BUILDING:
//                    for (int i = 0; i < 5; i++) {
//                        if (buildingsPut[buildingChosen].getSlot()[i] == 2) { // Producing
//
//                            buildingsPut[buildingChosen].changeStatus(3);
//                            buildingsPut[buildingChosen].getSlot()[buildingsPut[buildingChosen]
//                                    .getCurrentSlotActive()] = 3;
//                            buildingsPut[buildingChosen].setTimeTranscurrent(0);
//                            for (int h = 0; h < 5; h++) {
//                                if (buildingsPut[buildingChosen].getSlot()[h] == 2) {
//                                    buildingsPut[buildingChosen]
//                                            .setCurrentSlotActive(h);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//
//                    for (int i = 0; i < nBuildingsPut; i++) {
//                        if (buildingsPut[i].canFinishAll()) {
//                            actionSelect = Action.BUILDINGFINISHALL;
//                            canShowInfoAuto = true;
//                        }
//                    }
//                    stateGame = Constants.STATE_MAIN_GAME;
//                    break;
//                case Constants.ACTION_BOOST_CONSTRUCT_BUILDING:
//                    buildingsPut[buildingChosen].setTimeUnderConstruct(0);
//
//                    stateGame = Constants.STATE_MAIN_GAME;
//
//                    if (tutorialGame
//                            && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                        stepTutorial++;
//                        dissapearMsj = false;
//                    }
//
//                    break;
//                case Constants.ACTION_BOOST_FINISH_ANIMAL:
//                    if (animalsPut[animalChosen].getStatus() == Constants.STATUS_ANIMALS_WORKING) {
//                        animalsPut[animalChosen]
//                                .setStatus(Constants.STATUS_ANIMALS_READY);
//                        animalsPut[animalChosen].setProducing(false);
//                        animalsPut[animalChosen]
//                                .setTimeTranscurrentProducing(Constants.PRODUCT_ANIMAL_INFO[animalsPut[animalChosen]
//                                        .getType()][3]);
//                        animalsPut[animalChosen].setSelected(false);
//                        stateGame = Constants.STATE_MAIN_GAME;
//
//                        for (int i = 0; i < nAnimalsPut; i++) {
//                            // for(int j = 0; j <
//                            // animalsPut[i].getUpdgrade(); j++){
//                            if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_WORKING) {
//                                actionSelect = Action.ANIMALFINISHALL;
//                                canShowInfoAuto = true;
//                            }
//                            // }
//                        }
//                        if (tutorialGame
//                                && stepTutorial < Constants.STEP_TUTORIAL_PRODUCE_FOOD
//                                && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//                            stepTutorial++;
//                            dissapearMsj = false;
//                        }
//                    }
//
//                    break;
//
//                }
//
//                break;
//            case Constants.PRESS_BUTTON_INFO_1:
//                backup_StateGame = stateGame;
//                stateGame = Constants.STATE_SHOW_INFO_PRODUCTS;
//                productShowInfo = buildingsPut[buildingChosen]
//                        .getMaterialProcesing1()[productChosen];
//
//                break;
//            case Constants.PRESS_BUTTON_INFO_2:
//                backup_StateGame = stateGame;
//                stateGame = Constants.STATE_SHOW_INFO_PRODUCTS;
//                if (buildingsPut[buildingChosen].getMaterialProcesing2()[productChosen] != -1) {
//                    productShowInfo = buildingsPut[buildingChosen]
//                            .getMaterialProcesing2()[productChosen];
//                }
//                break;
//            case Constants.PRESS_BUTTON_UPDGRADE_BUILDING:
//                stateGame = Constants.STATE_MAIN_GAME;
//                break;
//            case Constants.PRESS_BUTTON_UPDGRADE_ANIMAL:
//                stateGame = Constants.STATE_MAIN_GAME;
//                break;
//            case Constants.PRESS_BUTTON_UPDGRADE_FEEDMILLCLOSED:
//                stateGame = Constants.STATE_FEED_MILL;
//                break;
//            case Constants.PRESS_BUTTON_UPDGRADE_STORE:
//                int[] quantityAddStorage = { 20, 30, 50, 90, 170, 260 };
//
//                for (int i = 0; i < 6; i += 2) {
//                    int quantityValue = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                            .getPosOrderInfos()
//                            + buildingsPut[buildingChosen].getUpdgrade()][i];
//                    int type = Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                            .getPosOrderInfos()
//                            + buildingsPut[buildingChosen].getUpdgrade()][i + 1];
//
//                    switch (type) {
//                    case Constants.GOLD:
//                        if (isTransactionPossible(Constants.GOLD, quantityValue)) {
//                            quantityCoins -= quantityValue;
//                        }
//                        break;
//                    case Constants.DIAMONDS:
//                        if (isTransactionPossible(Constants.DIAMONDS,
//                                quantityValue)) {
//                            quantityDiamonds -= quantityValue;
//                        }
//                        break;
//                    case Constants.LEVEL:
//                        break;
//
//                    case Constants.STONES: // convertStorageToProducts(Constants.Stones,
//                                           // -quantityValue);break;
//                    case Constants.WOOD: // convertStorageToProducts(Constants.Wood,
//                                         // -quantityValue); break;
//                    case Constants.ROPES: // convertStorageToProducts(Constants.Robes,
//                                          // -quantityValue); break;
//                    case Constants.NAILS: // convertStorageToProducts(Constants.Nails,
//                                          // -quantityValue); break;
//                    case Constants.LEAF:
//                        quantityCurrentMaterial[type - 56] -= quantityValue;
//                        // convertStorageToProducts(Constants.Leafs,
//                        // -quantityValue);
//                        break;
//                    }
//
//                }
//
//                buildingsPut[1].setUpdgrade(buildingsPut[1].getUpdgrade() + 1);
//                if (Constants.buildings[buildingsPut[1].getType()][buildingsPut[1]
//                        .getUpdgrade()] == null) {
//                    loadBuildingsImg(buildingsPut[1].getType(),
//                            buildingsPut[1].getUpdgrade());
//                }
//                maxItemStorage = quantityAddStorage[buildingsPut[1]
//                        .getUpdgrade()];
//                if (totalQuantityStorage < maxItemStorage) {
//                    storageFull = false;
//                }
//                int[] posit = calculatePosInitialMap(buildingsPut[1].getPosX(),
//                        buildingsPut[1].getPosY());
//                inicializateAnimationCloud(posit[0] + World.posWorldX, posit[1]
//                        + World.posWorldY);
//
//                stateGame = Constants.STATE_MAIN_GAME;
//                break;
//            case Constants.PRESS_BUTTON_UPDGRADE_STORECLOSED:
//                stateGame = Constants.STATE_STORAGE;
//                break;
//            case Constants.PRESS_BUTTON_BACK:
//                if (stateGame == Constants.STATE_MARKET_CROPS
//                        || stateGame == Constants.STATE_MARKET_ANIMALS
//                        || stateGame == Constants.STATE_MARKET_BUILDING
//                        || stateGame == Constants.STATE_MARKET_DECO
//                        || stateGame == Constants.STATE_COLLECTIONS) {
//                    stateGame = Constants.STATE_MAIN_MARKET;
//                    loadImages();
//                } else if (stateGame == Constants.STATE_PRODUCTION) {
//                    buildingsPut[buildingChosen].changeStatus(4);
//                }
//                break;
//            case Constants.PRESS_BUTTON_AUTOMATIC:
//                doAutomatic();
//                canShowInfoAuto = false;
//                break;
//            case Constants.PRESS_BUTTON_PRODUCE:
//                boolean slotBusy = false;
//                for (int i = 0; i < 5; i++) {
//                    if (buildingsPut[buildingChosen].getSlot()[i] == 0) {
//
//                        for (int h = 0; h < 5; h++) {
//                            if (buildingsPut[buildingChosen].getSlot()[h] == 2) {
//                                slotBusy = true;
//                                break;
//                            }
//                        }
//                        if (!slotBusy) {
//                            buildingsPut[buildingChosen]
//                                    .setCurrentSlotActive(i);
//                            buildingsPut[buildingChosen].setTimeTranscurrent(0);
//                        }
//
//                        buildingsPut[buildingChosen]
//                                .setItemProducing(buildingsPut[buildingChosen]
//                                        .getItemProduce()[productChosen], i);
//                        buildingsPut[buildingChosen]
//                                .setTimeProductsInSlot(
//                                        buildingsPut[buildingChosen]
//                                                .getTimeProducts()[productChosen],
//                                        i);
//
//                        convertStorageToProducts(
//                                buildingsPut[buildingChosen]
//                                        .getMaterialProcesing1()[productChosen],
//                                -buildingsPut[buildingChosen]
//                                        .getQuantityMaterialProcesing1()[productChosen]);
//                        convertStorageToProducts(
//                                buildingsPut[buildingChosen]
//                                        .getMaterialProcesing2()[productChosen],
//                                -buildingsPut[buildingChosen]
//                                        .getQuantityMaterialProcesing2()[productChosen]);
//
//                        buildingsPut[buildingChosen].changeStatus(2);
//                        buildingsPut[buildingChosen].getSlot()[i] = 2;
//                        break;
//                    }
//                }
//                break;
//            case Constants.PRESS_BUTTON_CLOSE_GENERAL_BG:
//
//                if (stateGame == Constants.STATE_WIN_MATERIAL
//                        || stateGame == Constants.STATE_LEVEL_UP
//                        || stateGame == Constants.STATE_SHOW_INFO_PRODUCTS) {
//
//                    if (tutorialGame
//                            && stepTutorial == Constants.STEP_TUTORIAL_FREE) {
//                        stepTutorial++;
//                        shopBlocked = null;
//                        stateGame = Constants.STATE_MAIN_GAME;
//                    } else {
//                        stateGame = backup_StateGame;
//                    }
//                } else if (stateGame == Constants.STATE_MARKET_CROPS) {
//                    actionSelect = null;
//                    stateGame = Constants.STATE_MAIN_GAME;
//                    animationCursor = false;
//                } else {
//
//                    stateGame = Constants.STATE_MAIN_GAME;
//                    animationCursor = false;
//
//                    if (tutorialGame
//                            && stepTutorial != Constants.STEP_TUTORIAL_FREE) {
//
//                        stepInAuxTutorial++;
//                        if (stepTutorial == Constants.STEP_TUTORIAL_WELCOME_FINAL_TUTORIAL) {
//                            time_showIconTrucker = System.currentTimeMillis();
//                            quantityExp += 1;
//                        }
//                        animationCursor = true;
//                        if (stepTutorial != Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED
//                                && stepTutorial != Constants.STEP_TUTORIAL_CROPS_BECOME_FOOD) {
//                            stepTutorial++;
//                        }
//                        if (stepTutorial == Constants.STEP_TUTORIAL_ORDER_FROM_OTHERS) {
//                            missionFading = true;
//                            UtilSoftgames.alphaImage = 0;
//                            Time_NewCharacter = System.currentTimeMillis();
//                        }
//                    }
//                }
//                break;
//            case Constants.PRESS_BUTTON_OPEN_MENU:
//                runAnimationMenuExpress = true;
//                openMenuExpress = true;
//                isOpenMenu = true;
//                actionSelect = null;
//                dissapearMsj = true;
//                int posX = mCanvasWidth
//                        - iconsMenuExpress[0].getImage().getWidth();
//                int spaceBetIcons = 5;
//                for (int i = 0; i < 5; i++) {
//                    iconsMenuExpress[i].setPosX(posX);
//                    iconsMenuExpress[i].setPosY(mCanvasHeight
//                            - iconsMenuExpress[i].getImage().getHeight());
//                    posX += (iconsMenuExpress[0].getImage().getWidth() + spaceBetIcons);
//                }
//                break;
//            case Constants.PRESS_BUTTON_CLOSEDMENU:
//                runAnimationMenuExpress = true;
//                isOpenMenu = false;
//                break;
//            case Constants.PRESS_BUTTON_OPEN_STORAGE:
//                stateGame = Constants.STATE_STORAGE;
//                loadImages();
//                break;
//            case Constants.PRESS_BUTTON_OPEN_MARKET:
//                stateGame = Constants.STATE_MAIN_MARKET;
//                loadImages();
//                openMenuExpress = false;
//                iconsMenuExpress[0].setPosX(mCanvasWidth
//                        - iconsMenuExpress[0].getImage().getWidth());
//
//                break;
//            case Constants.PRESS_BUTTON_MISSION:
//                stateGame = Constants.STATE_MISSION;
//                loadImages();
//                if (tutorialGame
//                        && stepTutorial != Constants.STEP_TUTORIAL_CASH_IN_TIME
//                        && stepTutorial != Constants.STEP_TUTORIAL_FREE
//                        && stepTutorial != Constants.STEP_TUTORIAL_PLACE_ON_YARD) {
//                    stepTutorial++;
//                }
//                break;
//            case Constants.PRESS_BUTTON_MARKET_BUILDINGS:
//                if (Constants.buildings[Constants.BUILDING_TYPE_ORD[itemSelected]][0] == null) {
//                    loadBuildingsImg(Constants.BUILDING_TYPE_ORD[itemSelected],
//                            0);
//                }
//                actionSelect = Action.BUILDING;
//                stateGame = Constants.STATE_MAIN_GAME;
//                if (tutorialGame
//                        && stepTutorial == Constants.STEP_TUTORIAL_BUILDINGS) {
//                    stepTutorial++;
//                }
//                break;
//            case Constants.PRESS_BUTTON_MARKET_ANIMALS:
//                if (Constants.animalsProducing[Constants.ANIMALS_ORD[itemSelected]][0] == null) {
//                    loadAnimalsImg(itemSelected);
//                }
//                actionSelect = Action.ANIMAL;
//                stateGame = Constants.STATE_MAIN_GAME;
//                if (actionMandatory) {
//                    actionMandatory = false;
//                    multitouch_X[indexMultitouch] = actionMandatory_X;
//                    multitouch_Y[indexMultitouch] = actionMandatory_Y;
//                    indexMultitouch++;
//                }
//
//                break;
//            case Constants.PRESS_BUTTON_MARKET_DECO:
//
//                /*if (Constants.decorationsImage[Constants.DECORATIONS_INFO[itemSelected][6]] == null) {
//                    loadDecorationsImg(itemSelected);
//                }*/
//                actionSelect = Action.DECORATION;
//                stateGame = Constants.STATE_MAIN_GAME;
//                break;
//            case Constants.PRESS_BUTTON_MARKET_CROPS:
//                if (itemSelected == -1)
//                    return;
//                if (Constants.cropsImage[Constants.CROPS_ORD[itemSelected]][0] == null) {
//                    loadCrops(itemSelected);
//                }
//
//                stateGame = Constants.STATE_MAIN_GAME;
//                if (actionSelect == null) {
//                    actionSelect = Action.PLANT;
//                }
//                break;
//            case Constants.PRESS_BUTTON_ITEM_MARKET:
//                switch (itemSelected) {
//                case 0:
//                    stateGame = Constants.STATE_COLLECTIONS;
//
//                    for (int s = 0; s < 22; s += 2) {
//                        if (showCashIn(s)) {
//                            pageCollection = s;
//                            break;
//                        } else if (showCashIn(s + 1)) {
//                            pageCollection = s;
//                            break;
//                        }
//                    }
//                    loadImages();
//                    break;
//                case 1:
//                    stateGame = Constants.STATE_MARKET_CROPS;
//                    loadImages();
//                    break;
//                case 2:
//                    stateGame = Constants.STATE_MARKET_ANIMALS;
//                    loadImages();
//                    break;
//                case 3:
//                    stateGame = Constants.STATE_MARKET_DECO;
//                    loadImages();
//                    break;
//                case 4:
//                    stateGame = Constants.STATE_MARKET_BUILDING;
//                    loadImages();
//                    break;
//                case 5:
//                    stateGame = Constants.STATE_MORE_DIAMONDS;
//                    loadImages();
//                    break;
//                }
//                itemSelected = -1;
//                break;
//            }
//            elementChosen = -1;
//        }
//    }
//
//    private void addFakeFriends() {
//        if (isTransactionPossible(Constants.DIAMONDS, 10)) {
//            quantityDiamonds -= 10;
//            fakeFriends += 1;
//            assignQuantity(0, 0, 0, 0, -10, 0, 0, mCanvasWidth / 2,
//                    mCanvasHeight / 2);
//            totalfriends = friendsFacebok + fakeFriends;
//            restValueMission(Constants.ADD_HELPER, 0);
//        } else {
//            return;
//        }
//    }
//
//   
//
//    private void loadAnimalsImg(int type) {
//        //Log.d(TAG, "loadAnimalsImg");
//        Bitmap auxBitmap =  null;
//        Bitmap auxBitmap_2 =  null;
//        switch (Constants.ANIMALS_ORD[type]) {
//        case Constants.ANIMAL_GOAT:
//           /* Constants.animalsHungry[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/goat/goathungry.png", false));
//            Constants.animalsProducing[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/goat/goatfeed.png", false));*/
//        	auxBitmap =  loadImageAssets("animals/goat/goathungry.png", false);
//            auxBitmap_2 = loadImageAssets("animals/goat/goatfeed.png", false);
//            break;
//        case Constants.ANIMAL_SHEEP:
//            /*Constants.animalsHungry[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/sheep/sheephungry.png", false));
//            Constants.animalsProducing[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/sheep/sheepfeed.png", false));*/
//        	auxBitmap =  loadImageAssets("animals/sheep/sheephungry.png", false);
//            auxBitmap_2 = loadImageAssets("animals/sheep/sheepfeed.png", false);
//            break;
//        case Constants.ANIMAL_CHICKEN:
//          /*  Constants.animalsHungry[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/chicken/chickenhungry.png", false));
//            Constants.animalsProducing[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/chicken/chickenfeed.png", false));*/
//        	auxBitmap =  loadImageAssets("animals/chicken/chickenhungry.png", false);
//            auxBitmap_2 = loadImageAssets("animals/chicken/chickenfeed.png", false);
//            break;
//        case Constants.ANIMAL_PIG:
//          /*  Constants.animalsHungry[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/pig/pighungry.png", false));
//            Constants.animalsProducing[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/pig/pigfeed.png", false));*/
//        	auxBitmap =  loadImageAssets("animals/pig/pighungry.png", false);
//            auxBitmap_2 = loadImageAssets("animals/pig/pigfeed.png", false);
//            break;
//        case Constants.ANIMAL_COW:
//        /*    Constants.animalsHungry[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/cow/cowhungry.png", false));
//            Constants.animalsProducing[Constants.ANIMALS_ORD[type]] = new Image(
//                    loadImageAssets("animals/cow/cowfeed.png", false));*/
//        	auxBitmap =  loadImageAssets("animals/cow/cowhungry.png", false);
//            auxBitmap_2 = loadImageAssets("animals/cow/cowfeed.png", false);
//            break;
//        }
//        
//        createHorizontalSprite(auxBitmap, Constants.animalsHungry[Constants.ANIMALS_ORD[type]],
//        		auxBitmap.getWidth()/10, auxBitmap.getHeight(), true);
//        
//        createHorizontalSprite(auxBitmap_2,  Constants.animalsProducing[Constants.ANIMALS_ORD[type]],
//        		auxBitmap_2.getWidth()/10, auxBitmap_2.getHeight(), true);
//    }
//
//    private void loadProductsImg(int type) {
//
//        if (type == -1 || Constants.iconProduced[type] != null)
//            return;
//        switch (type) {
//        case Constants.WHEAT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/wheat.png", true);
//            break;
//        case Constants.CORN:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/corn.png", true);
//            break;
//        case Constants.VANILLA:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/vanilla.png", true);
//            break;
//        case Constants.RYE:
//            Constants.iconProduced[type] = loadImageAssets("iconCrops/rye.png",
//                    true);
//            break;
//        case Constants.SUGAR_CANE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/sugarcane.png", true);
//            break;
//        case Constants.ONIONS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/onion.png", true);
//            break;
//        case Constants.SORGHUM:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/sorghum.png", true);
//            break;
//        case Constants.COTTON_PLANT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/cotton.png", true);
//            break;
//        case Constants.STRAWBERRY:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/strawberry.png", true);
//            break;
//        case Constants.BLUEBERRY:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/blueberry.png", true);
//            break;
//        case Constants.HANF:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/hemf.png", true);
//            break;
//        case Constants.TOMATOES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/tomato.png", true);
//            break;
//        case Constants.CACAO:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/cacao.png", true);
//            break;
//        case Constants.POTATOES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/potato.png", true);
//            break;
//        case Constants.APPLE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/apple.png", true);
//            break;
//        case Constants.ORANGE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/orange.png", true);
//            break;
//        case Constants.LEMON:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "iconCrops/lemon.png", true);
//            break;
//
//        case Constants.WHEAT_FLOUR:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/flour.png", true);
//            break;
//        case Constants.CRUSHED_GRAIN:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/crushed.png", true);
//            break;
//        case Constants.RYE_FLOUR:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/ryebag.png", true);
//            break;
//        case Constants.MIXED_FLOUR:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/mix.png", true);
//            break;
//        case Constants.BREAD:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/bread.png", true);
//            break;
//        case Constants.DOUGH:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/dough.png", true);
//            break;
//        case Constants.CROISSANT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/croissant.png", true);
//            break;
//        case Constants.PRETZL:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/pretzl.png", true);
//            break;
//        case Constants.BLUEBERRY_MUFFIN:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/muffin.png", true);
//            break;
//        case Constants.CHEESE_CAKE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/cheesecake.png", true);
//            break;
//        case Constants.APPLE_PIE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/applepie.png", true);
//            break;
//        case Constants.PRALINES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/pralines.png", true);
//            break;
//        case Constants.CHEESE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/cheese.png", true);
//            break;
//        case Constants.BUTTER:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/butter.png", true);
//            break;
//        case Constants.GOAT_CHEESE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/goatcheese.png", true);
//            break;
//        case Constants.YOGHURT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/yoghurt.png", true);
//            break;
//        case Constants.FRUIT_JUICE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/juice.png", true);
//            break;
//        case Constants.MUESLI:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/mussli.png", true);
//            break;
//        case Constants.KETCHUP:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/ketchup.png", true);
//            break;
//        case Constants.JAM:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/jam.png", true);
//            break;
//        case Constants.POWDERED_SUGAR:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/sugarpuder.png", true);
//            break;
//        case Constants.LEMONADE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/lemonade.png", true);
//            break;
//        case Constants.VANILLA_SUGAR:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/vanillasugar.png", true);
//            break;
//        case Constants.SIRUP:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/syrup.png", true);
//            break;
//        case Constants.GRILLED_CHEESE:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/grilled cheese.png", true);
//            break;
//        case Constants.BACON:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/bacon.png", true);
//            break;
//        case Constants.FRENCH_FRIES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/fries.png", true);
//            break;
//        case Constants.HAMBURGER:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/hamburger.png", true);
//            break;
//        case Constants.BREAKFAST:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/breakfast.png", true);
//            break;
//        case Constants.BRUNCH:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/brunch.png", true);
//            break;
//        case Constants.LUNCH:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/lunch.png", true);
//            break;
//        case Constants.DINNER:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/dinner.png", true);
//            break;
//        case Constants.WOOLBALLS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/woolballs.png", true);
//            break;
//        case Constants.THREADS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/threads.png", true);
//            break;
//        case Constants.SPINDLES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/spindles.png", true);
//            break;
//        case Constants.WEBS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/webs.png", true);
//            break;
//        case Constants.TROUSERS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/pants.png", true);
//            break;
//        case Constants.HEMP_SHIRT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/tshirt.png", true);
//            break;
//        case Constants.JACKET:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/jacket.png", true);
//            break;
//        case Constants.COTTON_HAT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/hat.png", true);
//            break;
//        case Constants.EGGS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/eggs.png", true);
//            break;
//        case Constants.MEAT:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/meat.png", true);
//            break;
//        case Constants.MILK:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/milk.png", true);
//            break;
//        case Constants.WOOL:
//    //    case Constants.WOOL_AUX:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/wool.png", true);
//            break;
//
//        case Constants.STONES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/icon_ice.png", true);
//            break;
//        case Constants.WOOD:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/icon_wood.png", true);
//            break;
//        case Constants.NAILS:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/icon_nails.png", true);
//            break;
//        case Constants.GOAT_MILK:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/goatmilk.png", true);
//            break;
//        case Constants.ROPES:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/icon_rope.png", true);
//            break;
//        case Constants.LEAF:
//            Constants.iconProduced[type] = loadImageAssets(
//                    "elementsBuilding/icons_products/leaf.png", true);
//            break;
//       // case Constants.HEMP:
//      //      Constants.iconProduced[type] = loadImageAssets(
//     //               "iconCrops/hemf.png", true);
//         //   break;
//        }
//    }
//
//    private void loadCrops(int type) {
//        Log.d(TAG, "loadCropsImg");
//        Bitmap auxBitmap =  null;
//        switch (Constants.CROPS_ORD[type]) {
//        case Constants.WHEAT:
//         //   Constants.cropsImage[Constants.WHEAT] = new Image(loadImageAssets(
//           //         "crops/wheat.png", false));
//            auxBitmap =  loadImageAssets("crops/wheat.png", false);
//           
//            break;
//        case Constants.CORN:
//          //  Constants.cropsImage[Constants.CORN] = new Image(loadImageAssets(
//            //        "crops/corn.png", false));
//        	 auxBitmap =  loadImageAssets("crops/corn.png", false);
//            break;
//        case Constants.VANILLA:
//        //    Constants.cropsImage[Constants.VANILLA] = new Image(
//          //          loadImageAssets("crops/vanilla.png", false));
//        	 auxBitmap =  loadImageAssets("crops/vanilla.png", false);
//            break;
//        case Constants.RYE:
//            //Constants.cropsImage[Constants.RYE] = new Image(loadImageAssets(
//              //      "crops/rye.png", false));
//        	 auxBitmap =  loadImageAssets("crops/rye.png", false);
//            break;
//        case Constants.SUGAR_CANE:
//           // Constants.cropsImage[Constants.SUGAR_CANE] = new Image(
//             //       loadImageAssets("crops/sugarcane.png", false));
//        	 auxBitmap =  loadImageAssets("crops/sugarcane.png", false);
//            break;
//        case Constants.ONIONS:
//          //  Constants.cropsImage[Constants.ONIONS] = new Image(loadImageAssets(
//            //        "crops/onion.png", false));
//        	 auxBitmap =  loadImageAssets("crops/onion.png", false);
//            break;
//
//        case Constants.SORGHUM:
//          //  Constants.cropsImage[Constants.SORGHUM] = new Image(
//            //        loadImageAssets("crops/sorghum.png", false));
//        	 auxBitmap =  loadImageAssets("crops/sorghum.png", false);
//            break;
//        case Constants.COTTON_PLANT:
//        //    Constants.cropsImage[Constants.COTTON_PLANT] = new Image(
//          //          loadImageAssets("crops/cotton_plant.png", false));
//        	 auxBitmap =  loadImageAssets("crops/wheat.png", false);
//            break;
//        case Constants.STRAWBERRY:
//          //  Constants.cropsImage[Constants.STRAWBERRY] = new Image(
//            //        loadImageAssets("crops/strawberry.png", false));
//        	 auxBitmap =  loadImageAssets("crops/strawberry.png", false);
//            break;
//        case Constants.BLUEBERRY:
//          //  Constants.cropsImage[Constants.BLUEBERRY] = new Image(
//            //        loadImageAssets("crops/blueberry.png", false));
//        	 auxBitmap =  loadImageAssets("crops/blueberry.png", false);
//            break;
//        case Constants.HANF:
//           // Constants.cropsImage[Constants.HANF] = new Image(loadImageAssets(
//             //       "crops/hanf.png", false));
//        	 auxBitmap =  loadImageAssets("crops/hanf.png", false);
//            break;
//        case Constants.TOMATOES:
//           // Constants.cropsImage[Constants.TOMATOES] = new Image(
//             //       loadImageAssets("crops/tomato.png", false));
//        	 auxBitmap =  loadImageAssets("crops/tomato.png", false);
//            break;
//
//        case Constants.CACAO:
//         //   Constants.cropsImage[Constants.CACAO] = new Image(loadImageAssets(
//           //         "crops/cacao.png", false));
//        	 auxBitmap =  loadImageAssets("crops/cacao.png", false);
//            break;
//        case Constants.POTATOES:
//         //   Constants.cropsImage[Constants.POTATOES] = new Image(
//        //            loadImageAssets("crops/potato.png", false));
//        	 auxBitmap =  loadImageAssets("crops/potato.png", false);
//            break;
//        case Constants.APPLE:
//           // Constants.cropsImage[Constants.APPLE] = new Image(loadImageAssets(
//             //       "crops/apple.png", false));
//        	 auxBitmap =  loadImageAssets("crops/apple.png", false);
//            break;
//        case Constants.ORANGE:
//            //Constants.cropsImage[Constants.ORANGE] = new Image(loadImageAssets(
//              //      "crops/orange.png", false));
//        	 auxBitmap =  loadImageAssets("crops/orange.png", false);
//            break;
//        case Constants.LEMON:
//            //Constants.cropsImage[Constants.LEMON] = new Image(loadImageAssets(
//              //      "crops/lemon.png", false));
//        	 auxBitmap =  loadImageAssets("crops/lemon.png", false);
//            break;
//
//        }
//        
//        createHorizontalSprite(auxBitmap,  Constants.cropsImage[Constants.CROPS_ORD[type]],
//        		auxBitmap.getWidth()/8, auxBitmap.getHeight(), false);
//    }
//
//   
//    private void loadBuildingsImg(int type, int upgrade) {
//        switch (type) {
//
//        case Constants.ENCLOSURE_CHICKEN:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/enclousure/chicken.png", false);
//            break;
//        case Constants.BAKERY:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/bakery/bakery0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.ENCLOSURE_COW:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/enclousure/cow.png", false);
//            break;
//        case Constants.ENCLOSURE_SHEEP:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/enclousure/sheep.png", false);
//            break;
//        case Constants.ENCLOSURE_PIG:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/enclousure/pig.png", false);
//            break;
//        case Constants.CAKE:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/cakes/cakes0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.DAIRY:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Dairy/dairy0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.ENCLOSURE_GOAT:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/enclousure/goat.png", false);
//            break;
//        case Constants.FRUIT_SMASHER:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Fruit/fruitsmasher0" + (upgrade + 1) + ".png",
//                    false);
//            break;
//        case Constants.SUGAR_FACTORY:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Sugar/sugar0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.GRILL:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Grill/grill0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.RESTAURANT:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Gourmet/gourmet0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.WEAVING_BUILDING:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Wheel/wheel0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.TAILOR:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/Tailor/tailor0" + (upgrade + 1) + ".png", false);
//            break;
//
//        case 16:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/farmhouse/farmhouse0" + (upgrade + 1) + ".png",
//                    false);
//            break;
//        case 17:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/barn/barn0" + (upgrade + 1) + ".png", false);
//            break;
//        case Constants.FEED_MILL:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/foodmill/foodmachine0" + (upgrade + 1) + ".png",
//                    false);
//            break;
//        case 19:
//            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
//                    "building/windmill/windmill0" + (upgrade + 1) + ".png",
//                    false);
//            break;
//
//        }
//    }
//
//    private void animationOpenMenuExpress() {
//
//        if (openMenuExpress) {
//            if (runAnimationMenuExpress) {
//                if (isOpenMenu) {
//                    for (int i = 0; i < 5; i++) {
//                        iconsMenuExpress[i].setPosX(iconsMenuExpress[i]
//                                .getPosX() - Constants.SPEED_ANIMATION_MENU);
//                    }
//                    if (iconsMenuExpress[4].getPosX()
//                            + iconsMenuExpress[4].getImage().getWidth() < mCanvasWidth) {
//                        runAnimationMenuExpress = false;
//                    }
//                } else {
//                    for (int i = 0; i < 5; i++) {
//                        iconsMenuExpress[i].setPosX(iconsMenuExpress[i]
//                                .getPosX() + Constants.SPEED_ANIMATION_MENU);
//                    }
//                    if (iconsMenuExpress[0].getPosX()
//                            + iconsMenuExpress[4].getImage().getWidth() + 1 > mCanvasWidth) {
//                        runAnimationMenuExpress = false;
//                        openMenuExpress = false;
//                    }
//                }
//            }
//        }
//
//    }
//
//    private void paintUIMain(Canvas canvas) {
//
//        panelCoins.setPosX(0);
//        panelCoins.setPosY(5);
//        panelCoins.paint(canvas);
//        canvas.drawText("" + quantityCoins, panelCoins.getPosX()
//                + panelCoins.getImage().getWidth() / 2 + 10,
//                panelCoins.getPosY() + (panelCoins.getImage().getHeight() / 3)
//                        * 2, fontMainUi);
//
//        panelDiamonds.setPosX(panelCoins.getImage().getWidth() + 4);
//        panelDiamonds.setPosY(5);
//        panelDiamonds.paint(canvas);
//
//        canvas.drawText("" + quantityDiamonds, panelDiamonds.getPosX()
//                + panelDiamonds.getImage().getWidth() / 2 + 10,
//                panelDiamonds.getPosY()
//                        + (panelDiamonds.getImage().getHeight() / 3) * 2,
//                fontMainUi);
//
//        panelSeeds.paint(canvas);
//        canvas.drawText(quantitySeeds + "/" + totalQuantityFood,
//                panelSeeds.getPosX() + panelSeeds.getImage().getWidth() / 2
//                        + 20, panelSeeds.getPosY()
//                        + (panelSeeds.getImage().getHeight() / 3) * 2,
//                fontMainUi);
//
//        starNivelEmpty.paint(canvas);
//
//        paintAnimationBarLoading(canvas, starNivelFull,
//                starNivelEmpty.getPosX(), starNivelEmpty.getPosY(),
//                starNivelEmpty.getPosX() + (int) quantityExpBarra() + 30,
//                starNivelEmpty.getPosY() + starNivelFull.getHeight());
//
//        canvas.drawBitmap(starNivel,
//                starNivelEmpty.getPosX() - (starNivel.getWidth() / 3), 5, null);
//
//        canvas.drawText("" + (nLevel + 1), starNivelEmpty.getPosX()
//                - (starNivel.getWidth() / 3) + textNivel_X,
//                starNivelEmpty.getPosY()
//                        + (starNivelEmpty.getImage().getHeight() / 2)
//                        + textNivel_Y, fontShowNivel);
//
//        canvas.drawText(quantityExp + "/" + Constants.LEVELS_WIN[nLevel],
//                starNivelEmpty.getPosX() + starNivelEmpty.getImage().getWidth()
//                        / 2 + 10, starNivelEmpty.getPosY()
//                        + (starNivelEmpty.getImage().getHeight() / 2) + 10,
//                fontMainUi);
//
//        if (!animationCarTruck) {
//            canvas.drawText(UtilSoftgames.secondsToString(countTimeQuest),
//                    iconMission.getPosX() + iconMission.getImage().getWidth()
//                            / 2, iconMission.getPosY() - 25,
//                    fontWhiteSmallCenter);
//        }
//
//        if (!tutorialGame
//                || stepTutorial >= Constants.STEP_TUTORIAL_ORDER_FROM_OTHERS) {
//            paintIconMission(canvas);
//        }
//
//        if (!tutorialGame
//                || stepTutorial >= Constants.STEP_TUTORIAL_FARM_FRIENDS) {
//            paintCharacter(canvas);
//        }
//
//        if (!Constants.canShowCollection) {
//            iconHelper.paint(canvas);
//
//            if (runningBonus) {
//                int posTimePromotion_X = mCanvasWidth
//                        - iconTimePromotion.getWidth();
//                canvas.drawBitmap(iconTimePromotion, posTimePromotion_X,
//                        iconHelper.getPosY()
//                                + iconHelper.getImage().getHeight() + 5, null);
//
//                canvas.drawText(currentDiscount + "% OFF", posTimePromotion_X
//                        + bonusOffsetX, iconHelper.getPosY()
//                        + iconHelper.getImage().getHeight()
//                        + (iconTimePromotion.getHeight() / 3) * 2,
//                        fontQuantityMaterialProduce);
//
//                canvas.drawText(
//                        UtilSoftgames.secondsToString(timeSecondsOffer),
//                        posTimePromotion_X + iconTimePromotion.getWidth() / 2
//                                + 30, iconHelper.getPosY()
//                                + iconHelper.getImage().getHeight()
//                                + (iconTimePromotion.getHeight() / 3) * 2,
//                        fontNameItems);
//            }
//        }
//        if (openMenuExpress) {
//            for (int i = 0; i < 5; i++) {
//                if (tutorialGame && stepTutorial == Constants.STEP_TUTORIAL_FREE && i == 2) {
//                    canvas.drawBitmap(shopBlocked,
//                            iconsMenuExpress[i].getPosX(),
//                            iconsMenuExpress[i].getPosY(), null);
//                } else {
//                    iconsMenuExpress[i].paint(canvas);
//                }
//                if (tutorialGame
//                        && stepTutorial == Constants.STEP_TUTORIAL_ENTER_SHOP
//                        && i == 2) {
//                    paintAnimationCursor(
//                            canvas,
//                            iconsMenuExpress[i].getPosX()
//                                    + iconsMenuExpress[i].getImage().getWidth()
//                                    / 2 - cursorHand.getWidth() / 2,
//                            iconsMenuExpress[i].getPosY()
//                                    + iconsMenuExpress[i].getImage()
//                                            .getHeight() / 2
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//                }
//            }
//        } else {
//            iconsMenuExpress[0].paintFlip(canvas);
//
//            if (tutorialGame
//                    && stepTutorial == Constants.STEP_TUTORIAL_ENTER_SHOP) {
//                animationCursor = true;
//                paintAnimationCursor(canvas, iconsMenuExpress[0].getPosX()
//                        + iconsMenuExpress[0].getImage().getWidth() / 2
//                        - cursorHand.getWidth() / 2,
//                        iconsMenuExpress[0].getPosY()
//                                + iconsMenuExpress[0].getImage().getHeight()
//                                / 2 - cursorHand.getHeight() / 3 + cursorY, -1);
//            }
//        }
//        
//        if (tutorialGame && stepTutorial == Constants.STEP_TUTORIAL_FREE) {
//             main.showButtonSkipTutorial();
//        } else {
//            main.hideButtonSkipTutorial();
//        }
//
//    }
//
//    private void paintIconMission(Canvas canvas) {
//        // Log.d(TAG, "paintIconMission");
//        if (missionFading) {
//            UtilSoftgames.transparentImage(canvas, iconMission.getImage(),
//                    iconMission.getPosX(), iconMission.getPosY(), false, false);
//
//            if (System.currentTimeMillis() - Time_NewCharacter >= 1000) {
//                missionFading = false;
//            }
//            return;
//        }
//
//        iconMission.paint(canvas);
//
//        canvas.drawBitmap(pointRedCollect,
//                iconMission.getPosX() + iconMission.getImage().getWidth()
//                        - pointRedCollect.getWidth() / 2, iconMission.getPosY()
//                        - pointRedCollect.getHeight() / 2 + 10, null);
//
//        canvas.drawText("" + nMission, iconMission.getPosX()
//                + iconMission.getImage().getWidth(),
//                iconMission.getPosY() + 15, fontWhiteSmallCenter);
//
//        canvas.drawText(texts[436], iconMission.getPosX()
//                + iconMission.getImage().getWidth() / 2, iconMission.getPosY()
//                + (iconMission.getImage().getHeight() / 4) * 3,
//                fontQuantityMaterialProduce);
//
//        if (tutorialGame
//                && (stepTutorial == Constants.STEP_TUTORIAL_CASH_IN_TIME
//                        || stepTutorial == Constants.STEP_TUTORIAL_ORDER_FROM_OTHERS || stepTutorial == Constants.STEP_TUTORIAL_FIRST_TASK_COMPLETED)
//                && stateGame == Constants.STATE_MAIN_GAME) {
//            paintAnimationCursor(canvas,
//                    iconMission.getPosX() + iconMission.getImage().getWidth()
//                            / 2 - cursorHand.getWidth() / 2,
//                    iconMission.getPosY() + iconMission.getImage().getHeight()
//                            / 2 - cursorHand.getHeight() / 3 + cursorY, -1);
//            
//            canvas.drawBitmap(arrowMission, iconMission.getPosX() + iconMission.getImage().getWidth() + animationArrowMission,
//            		iconMission.getPosY() + iconMission.getImage().getHeight()/2 - arrowMission.getHeight()/2 , null);
//            
//            canvas.drawText("Mission!", iconMission.getPosX() + iconMission.getImage().getWidth() + animationArrowMission + arrowMission.getWidth()/2,
//            		iconMission.getPosY() + iconMission.getImage().getHeight()/2 - arrowMission.getHeight()/2 + arrowMission.getHeight()/2 + 5,
//            		fontBlackSmallCenter);
//
//        }
//        for (int s = 0; s < nMission; s++) {
//            if (canRewardMission[s]) {
//                canvas.drawBitmap(checkSmall,
//                        iconMission.getPosX()
//                                + iconMission.getImage().getWidth()
//                                - checkSmall.getWidth(), iconMission.getPosY()
//                                + iconMission.getImage().getHeight()
//                                - checkSmall.getHeight(), null);
//                break;
//            }
//        }
//    }
//
//    private void paintCharacter(Canvas canvas) {
//
//        int posCharacter_Y = characterOffsetY;
//        // boolean validateDoubleAnimation = false;
//
//        for (int i = 0; i < 3; i++) {
//            if (characterChosen[i] != -1) {
//                if (canRewardMission[missionCharacter[i]]
//                        || animationNewCharacter[i]) {
//                    if (System.currentTimeMillis() - timeShakeCharacter >= 40) {
//                        timeShakeCharacter = System.currentTimeMillis();
//                        if (countShakeCharacter > 10) {
//                            character_X = (character_X == 5) ? 9 : 0;
//                        }
//                        countShakeCharacter++;
//                        if (countShakeCharacter > 20) {
//                            countShakeCharacter = 0;
//                        }
//
//                    }
//                } else {
//                    character_X = 5;
//                }
//
//                if (!animationNewCharacter[i]) {
//                    canvas.drawBitmap(iconCharacter[characterChosen[i]],
//                            character_X, posCharacter_Y, null);
//                    
//                    if(animationHelpMe && !tutorialGame){
//                    	if(indexAnimationHelpMe == i){
//                    		canvas.drawBitmap(arrowMission, character_X + iconCharacter[characterChosen[i]].getWidth()  + animationArrowMission,
//                    				posCharacter_Y + iconCharacter[characterChosen[i]].getHeight()/2 - arrowMission.getHeight()/2 , null);
//                    
//                    		canvas.drawText("Help me!", character_X + iconCharacter[characterChosen[i]].getWidth()  + animationArrowMission + arrowMission.getWidth()/2,
//                    				posCharacter_Y + iconCharacter[characterChosen[i]].getHeight()/2 + 5,
//                    				fontBlackSmallCenter);
//                    	}
//                    	
//                    	 if (System.currentTimeMillis() - Time_AnimationCursor >= 150) {
//                             Time_AnimationCursor = System.currentTimeMillis();
//                            animationArrowMission = (animationArrowMission == 5) ? 10: 5;
//                            timeAnimationHelp ++;
//                            if(timeAnimationHelp >= 10){
//                            	timeAnimationHelp = 0;
//                            	animationHelpMe = false;
//                            }
//                         }
//                    }
//                } else {
//
//                    UtilSoftgames.transparentImage(canvas,
//                            iconCharacter[characterChosen[i]], character_X,
//                            posCharacter_Y, false, false);
//                    animationProgress(
//                            canvas,
//                            iconCharacter[characterChosen[i]].getWidth()
//                                    + animationProgress_X,
//                            posCharacter_Y
//                                    + iconCharacter[characterChosen[i]]
//                                            .getHeight() / 2
//                                    - iconProgress.getHeight() / 2, -2,
//                            texts[437]);
//                    if (System.currentTimeMillis() - Time_NewCharacter >= 850) {
//                        animationNewCharacter[i] = false;
//                    }
//                }
//
//                if (tutorialGame
//                        && stepTutorial == Constants.STEP_TUTORIAL_FARM_FRIENDS) {
//                    paintAnimationCursor(
//                            canvas,
//                            iconCharacter[characterChosen[i]].getWidth() / 2
//                                    - cursorHand.getWidth() / 2,
//                            posCharacter_Y
//                                    + iconCharacter[characterChosen[i]]
//                                            .getHeight() / 2
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//                }
//
//                if (canRewardMission[missionCharacter[i]]) {
//                    canvas.drawBitmap(
//                            checkSmall,
//                            iconCharacter[characterChosen[i]].getWidth()
//                                    - checkSmall.getWidth() / 2,
//                            posCharacter_Y
//                                    + iconCharacter[characterChosen[i]]
//                                            .getHeight()
//                                    - checkSmall.getHeight(), null);
//                } else if (animationIconProgressCharacater[i]) {
//                    // validateDoubleAnimation = true;
//                    animationProgress(
//                            canvas,
//                            iconCharacter[characterChosen[i]].getWidth()
//                                    + animationProgress_X,
//                            posCharacter_Y
//                                    + iconCharacter[characterChosen[i]]
//                                            .getHeight() / 2
//                                    - iconProgress.getHeight() / 2, i,
//                            texts[297]);
//                }
//
//            }
//
//            posCharacter_Y += iconCharacter[0].getHeight() + 15;
//        }
//    }
//
//    private void animationProgress(Canvas canvas, int posX, int posY,
//            int posAnimationIcon, String msj) {
//        Log.d(TAG, "animationProgress");
//        canvas.drawBitmap(iconProgress, posX, posY, null);
//
//        canvas.drawText(msj, posX + iconProgress.getWidth() / 2, posY
//                + (iconProgress.getHeight() / 3) * 2, fontNameBuildingItems);
//
//        if (System.currentTimeMillis() - timeAnimationProgress >= 250) {
//            timeAnimationProgress = System.currentTimeMillis();
//            animationProgress_X = (animationProgress_X == 10) ? 20 : 10;
//            countAnimationProgress++;
//            if (countAnimationProgress > 8) {
//                countAnimationProgress = 0;
//
//                switch (posAnimationIcon) {
//                case -2:
//                    break;
//                case -1:
//                    //animationIconProgress = false;
//                    break;
//                default:
//                    animationIconProgressCharacater[posAnimationIcon] = false;
//                    break;
//                }
//
//            }
//        }
//    }
//
//    private void skipMission(MotionEvent event) {
//        Log.d(TAG, "skipMission()");
//        int amountToDeduct = diamondsToFinishMission[missionChosen];
//        if (isTransactionPossible(Constants.DIAMONDS, amountToDeduct)) {
//
//            assignQuantity(0, 0, 0, 0, -amountToDeduct,
//                    rewardsCoins[missionChosen], rewardsXP[missionChosen],
//                    mCanvasWidth / 2, mCanvasHeight / 2);
//
//            if (stateGame == Constants.STATE_CHARACTER_MISSION) {
//                stateGame = Constants.STATE_MAIN_GAME;
//            }
//
//            rewardPaid[missionChosen] = true;
//            sound(mContext, 1);
//
//            for (int i = 0; i < nTask[missionChosen]; i++) {
//                int quantity = quantityProduct[missionChosen][i];
//                int quantityInStorage = getQuantityProductInStorage(typeProduct[missionChosen][i]);
//                if (typeMission[missionChosen][i] == Constants.MISSION_TYPE_CROPS) {
//                    if (quantity >= quantityInStorage) {
//                        quantity = quantityInStorage;
//                    }
//                    if (quantity != 0) {
//                        assignStorage(Constants.STORAGE_CROPS, -quantity,
//                                typeProduct[missionChosen][i]);
//                    }
//                } else if (typeMission[missionChosen][i] == Constants.MISSION_CREATE_PRODUCT) {
//                    if (quantity >= quantityInStorage) {
//                        quantity = quantityInStorage;
//                    }
//                    if (quantity != 0) {
//                        assignStorage(Constants.STORAGE_PRODUCTS, -quantity,
//                                typeProduct[missionChosen][i]);
//                    }
//                } else if (typeMission[missionChosen][i] == Constants.MISSION_PRODUCTANIMAL) {
//                    if (quantity >= quantityInStorage) {
//                        quantity = quantityInStorage;
//                    }
//                    if (quantity != 0) {
//                        assignStorage(Constants.STORAGE_ANIMALS_PRODUCTS,
//                                -quantity, typeProduct[missionChosen][i] - 156);
//                    }
//                }
//            }
//
//            for (int i = 0; i < 3; i++) {
//                if (missionChosen == missionCharacter[i]) {
//                    missionCharacter[i] = -1;
//                    backupCharacterChosen = characterChosen[i];
//                    characterChosen[i] = -1;
//                    break;
//                }
//            }
//            defineMission(true);
//            defineCharacter();
//            boolean winMaterial = true;
//
//            int randWinMaterial = UtilSoftgames.random(1, 10);
//            if (randWinMaterial < 8) {
//                winMaterial = false;
//            }
//            validateMission();
//            if (winMaterial && !tutorialGame) {
//                if (stateGame != Constants.STATE_LEVEL_UP) {
//                    backup_StateGame = stateGame;
//                } else {
//                    backup_StateGame = Constants.STATE_MAIN_GAME;
//                }
//
//                stateGame = Constants.STATE_WIN_MATERIAL;
//                numberMaterial = getMaterial();
//                loadProductsImg(numberMaterial + 56);
//                quantityCurrentMaterial[numberMaterial] += 1;
//            }
//
//            UtilSoftgames.alphaImage = 0;
//            animationNewCharacter[indexCharacterChosen] = true;
//            Time_NewCharacter = System.currentTimeMillis();
//
//            // Display explosion
//            explosion = new Explosion(50, (int) event.getX(),
//                    (int) event.getY());
//            explosionActive = true;
//            
//            return;
//        }
//    }
//    
//    
//
//    private void finalizeMission() {
//        Log.d(TAG, "finalizeMission");
//        if (stateGame == Constants.STATE_CHARACTER_MISSION) {
//            stateGame = Constants.STATE_MAIN_GAME;
//        }
//
//        rewardPaid[missionChosen] = true;
//        sound(mContext, 1);
//        assignQuantity(0, 0, 0, 0, 0, rewardsCoins[missionChosen],
//                rewardsXP[missionChosen], mCanvasWidth / 2,
//                mCanvasHeight / 2);
//
//        for (int i = 0; i < nTask[missionChosen]; i++) {
//            int quantity = quantityProduct[missionChosen][i];
//            int quantityInStorage = getQuantityProductInStorage(typeProduct[missionChosen][i]);
//            if (quantityInStorage > 0) {
//                if (typeMission[missionChosen][i] == Constants.MISSION_TYPE_CROPS) {
//                    assignStorage(Constants.STORAGE_CROPS, -quantity,
//                            typeProduct[missionChosen][i]);
//                } else if (typeMission[missionChosen][i] == Constants.MISSION_CREATE_PRODUCT) {
//                    assignStorage(Constants.STORAGE_PRODUCTS, -quantity,
//                            typeProduct[missionChosen][i]);
//                } else if (typeMission[missionChosen][i] == Constants.MISSION_PRODUCTANIMAL) {
//                    assignStorage(Constants.STORAGE_ANIMALS_PRODUCTS,
//                            -quantity, typeProduct[missionChosen][i] - 156);
//                }
//            }
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if (missionChosen == missionCharacter[i]) {
//                missionCharacter[i] = -1;
//                backupCharacterChosen = characterChosen[i];
//                characterChosen[i] = -1;
//                break;
//            }
//        }
//        defineMission(true);
//        defineCharacter();
//        boolean winMaterial = true;
//        validateMission();
//        int randWinMaterial = UtilSoftgames.random(1, 10);
//        if (randWinMaterial < 8) {
//            winMaterial = false;
//        }
//        if (winMaterial && !tutorialGame) {
//            backup_StateGame = stateGame;
//            stateGame = Constants.STATE_WIN_MATERIAL;
//            numberMaterial = getMaterial();
//            loadProductsImg(numberMaterial + 56);
//            quantityCurrentMaterial[numberMaterial] += 1;
//        }
//    }
//
//    private float quantityExpBarra() {
//
//        float quantity = 0;
//        try {
//
//            float prom = (quantityExp * 100);
//            prom = prom / Constants.LEVELS_WIN[nLevel];
//            prom = prom / 100;
//            quantity = (starNivelFull.getWidth() - 30) * prom;
//        } catch (Exception e) {
//            Log.e(TAG, "Error", e);
//        }
//        return quantity;
//    }
//
//    private void paintStateStorage(Canvas canvas) {
//        paintStateMainGame(canvas);
//       // loadImages();        
//        paintBackGeneral(canvas);
//        paintTitleGeneral(canvas, texts[22] + " " + totalQuantityStorage + "/"
//                + maxItemStorage, texts[23]);
//        int posItem_X = 10 + buttonArrow.getPosX()
//                + buttonArrow.getImage().getWidth();
//        int diffItem_X = 6;
//        float sizeToReduce = 0.3f;
//        Matrix matrixnew = null;
//        paintSquare(canvas, posItem_X - 3, squareStorage[0], squareStorage[1],
//                squareStorage[2], 0xff0d2e4f);
//        int posItem_Y = initPosStorage_Y;
//        Bitmap imageAux = null;
//        String nameCropsAux = "";
//        int diffBetIconQuanti = 10;
//        int nItemCorrect = calculateNPageStorage();
//
//        canvas.drawBitmap(backgItemStorage,
//                (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                        - spaceBetBorderBackgr - backgItemStorage.getWidth(),
//                posItem_Y, null);
//
//        if (buildingsPut[1].getUpdgrade() + 1 < 6) {
//            buttonUpgrade.setPosX(buttonClose.getPosX()
//                    - buttonUpgrade.getImage().getWidth() - 10);
//            buttonUpgrade.setPosY(buttonClose.getPosY() + 40);
//            buttonUpgrade.paintWithText(canvas, texts[194],
//                    fontWhiteSmallCenter, 10, 0);
//
//        }
//
//        selectAll.setPosX((mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                - spaceBetBorderBackgr - backgItemStorage.getWidth() / 2
//                - (selectAll.getImage().getWidth()) / 2);
//        selectAll.setPosY(posItem_Y + backgItemStorage.getHeight() / 2
//                - selectAll.getImage().getHeight() / 2 - 8);
//
//        if (storageChosen != -1
//                && quantityToSell == itemStorage[storageChosen][2]) {
//            desSelectAll.setPosX(selectAll.getPosX());
//            desSelectAll.setPosY(selectAll.getPosY());
//            desSelectAll.paintWithText(canvas, texts[430],
//                    fontQuantityMaterialProduce, 0, 0);
//        } else {
//            selectAll.paintWithText(canvas, texts[430],
//                    fontQuantityMaterialProduce, 0, 0);
//        }
//
//        buttonAddProduct.setPosX((mCanvasWidth / 2 + backgroundGeneral
//                .getWidth() / 2)
//                - spaceBetBorderBackgr
//                - backgItemStorage.getWidth()
//                / 2
//                - buttonAddProduct.getImage().getWidth() / 2);
//        buttonAddProduct.setPosY(posItem_Y + backgItemStorage.getHeight()
//                - buttonAddProduct.getImage().getHeight() - 15);
//
//        canvas.drawText(texts[25], buttonAddProduct.getPosX()
//                + buttonAddProduct.getImage().getWidth() / 2, posItem_Y
//                + (backgItemStorage.getHeight() / 3) * 2
//                - storageTextRewardOffsetY, fontAnimationQuantity);
//
//        if (tutorialGame && stepInAuxTutorial == 1) {
//            paintAnimationCursor(canvas,
//                    selectAll.getPosX() + selectAll.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                    selectAll.getPosY() + selectAll.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        String[] stringAux = { "+" + quantityCoinSell };
//        Bitmap[] bitmapAux = { coinSmall };
//        UtilSoftgames.PaintTextWithImageInLine(canvas, stringAux, bitmapAux,
//                fontQuantityItemSell, buttonAddProduct.getPosX()
//                        + buttonAddProduct.getImage().getWidth() / 2, posItem_Y
//                        + (backgItemStorage.getHeight() / 3) * 2 + 15);
//
//        String[] stringAux1 = { "+" + quantityXPSell };
//        Bitmap[] bitmapAux1 = { xpSmall };
//
//        UtilSoftgames.PaintTextWithImageInLine(
//                canvas,
//                stringAux1,
//                bitmapAux1,
//                fontQuantityItemSell,
//                buttonAddProduct.getPosX()
//                        + buttonAddProduct.getImage().getWidth() / 2,
//                posItem_Y + (backgItemStorage.getHeight() / 3) * 2
//                        + coinSmall.getHeight() + 15);
//
//        boolean canSell = true;
//
//        int initItem = -9;
//        int finItem = 0;
//        if (indexCorrectStorage <= 9) {
//            finItem = indexCorrectStorage;
//            initItem = 0;
//        } else {
//            do {
//                initItem += 9;
//                finItem += 9;
//            } while (finItem < pageInStorage * 9);
//
//            if (finItem > indexCorrectStorage) {
//                finItem = indexCorrectStorage;
//            }
//        }
//
//        nPageTotal = nItemCorrect;
//        int add = ((nPageTotal % 9) == 0) ? 0 : 1;
//        nPageTotal = (nPageTotal / 9) + add;
//
//        if (pageInStorage > 1) {
//            buttonArrow.paint(canvas);
//        }
//
//        if (pageInStorage < nPageTotal) {
//            buttonArrowRigth.setPosX(arrowRightOffsetX);
//            buttonArrowRigth.paintFlip(canvas);
//        }
//        boolean changeSize = false;
//        for (int i = initItem; i < finItem; i++) {
//
//            canvas.drawBitmap(taskItemBackg, posItem_X, posItem_Y, null);
//
//            if (storageChosen == itemCorrectStorage[i]) {
//                canvas.drawBitmap(
//                        taskSelected,
//                        posItem_X + taskItemBackg.getWidth() / 2
//                                - taskSelected.getWidth() / 2, posItem_Y
//                                + addTaskSelect_Y, null);
//            }
//            switch (itemStorage[itemCorrectStorage[i]][0]) {
//            case Constants.STORAGE_CROPS:
//                canvas.drawBitmap(
//                        iconCrops[itemStorage[itemCorrectStorage[i]][1]],
//                        posItem_X
//                                + taskItemBackg.getWidth()
//                                / 2
//                                - iconCrops[itemStorage[itemCorrectStorage[i]][1]]
//                                        .getWidth() - diffBetIconQuanti,
//                        posItem_Y
//                                + taskItemBackg.getHeight()
//                                / 2
//                                - iconCrops[itemStorage[itemCorrectStorage[i]][1]]
//                                        .getHeight() / 2, null);
//
//                if (storageChosen == itemCorrectStorage[i]) {
//                    imageAux = iconCrops[itemStorage[itemCorrectStorage[i]][1]];
//                    nameCropsAux = texts[Constants.CROPS_NAME[Constants.CROPS_ORD[itemStorage[itemCorrectStorage[i]][1]]]];
//                }
//
//                if (tutorialGame && stepInAuxTutorial == 0) {
//                    paintAnimationCursor(canvas,
//                            posItem_X + taskItemBackg.getWidth() / 2
//                                    - cursorHand.getWidth() / 2, posItem_Y
//                                    + taskItemBackg.getHeight() / 2
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//                }
//
//                break;
//            case Constants.STORAGE_ANIMALS_PRODUCTS:
//                canvas.drawBitmap(
//                        Constants.productByAnimals[itemStorage[itemCorrectStorage[i]][1]],
//                        posItem_X
//                                + taskItemBackg.getWidth()
//                                / 2
//                                - Constants.productByAnimals[itemStorage[itemCorrectStorage[i]][1]]
//                                        .getWidth() - diffBetIconQuanti,
//                        posItem_Y
//                                + taskItemBackg.getHeight()
//                                / 2
//                                - Constants.productByAnimals[itemStorage[itemCorrectStorage[i]][1]]
//                                        .getHeight() / 2, null);
//
//                if (storageChosen == itemCorrectStorage[i]) {
//                    imageAux = Constants.productByAnimals[itemStorage[itemCorrectStorage[i]][1]];
//                    nameCropsAux = texts[Constants.PRODUCT_ANIMAL_INFO[itemStorage[itemCorrectStorage[i]][1]][0]];
//                }
//
//                break;
//            case Constants.STORAGE_PRODUCTS:
//                canvas.drawBitmap(
//                        Constants.iconProduced[itemStorage[itemCorrectStorage[i]][1]],
//                        posItem_X
//                                + taskItemBackg.getWidth()
//                                / 2
//                                - Constants.iconProduced[itemStorage[itemCorrectStorage[i]][1]]
//                                        .getWidth() - diffBetIconQuanti,
//                        posItem_Y
//                                + taskItemBackg.getHeight()
//                                / 2
//                                - Constants.iconProduced[itemStorage[itemCorrectStorage[i]][1]]
//                                        .getHeight() / 2, null);
//
//                if (storageChosen == itemCorrectStorage[i]) {
//                    imageAux = Constants.iconProduced[itemStorage[itemCorrectStorage[i]][1]];
//                    nameCropsAux = texts[Constants.PRODUCT_NAME[itemStorage[itemCorrectStorage[i]][1]]];
//                }
//                break;
//            case Constants.STORAGE_DECORATION:
//
//                matrixnew = new Matrix();
//                matrixnew
//                        .setTranslate(
//                                posItem_X
//                                        + taskItemBackg.getWidth()
//                                        / 2
//                                        - (int) (iconDecorations[itemStorage[itemCorrectStorage[i]][1]]
//                                                .getWidth() * sizeToReduce)
//                                        - diffBetIconQuanti,
//                                posItem_Y
//                                        + taskItemBackg.getHeight()
//                                        / 2
//                                        - (int) (iconDecorations[itemStorage[itemCorrectStorage[i]][1]]
//                                                .getHeight() * sizeToReduce)
//                                        / 2);
//
//                matrixnew.preScale(sizeToReduce, sizeToReduce);
//
//                canvas.drawBitmap(
//                        iconDecorations[itemStorage[itemCorrectStorage[i]][1]],
//                        matrixnew, null);
//
//                if (storageChosen == itemCorrectStorage[i]) {
//                    changeSize = true;
//                    imageAux = iconDecorations[itemStorage[itemCorrectStorage[i]][1]];
//                    nameCropsAux = texts[Constants.DECORATIONS_INFO[itemStorage[itemCorrectStorage[i]][1]][5]];
//                }
//
//                checkedAutomaticSmall.setPosX(posItem_X
//                        + taskItemBackg.getWidth()
//                        - checkedAutomaticSmall.getImage().getWidth());
//                checkedAutomaticSmall.setPosY(posItem_Y
//                        + taskItemBackg.getHeight()
//                        - checkedAutomaticSmall.getImage().getHeight());
//                checkedAutomaticSmall.paint(canvas);
//                break;
//            case Constants.STORAGE_BUILDING:
//
//                matrixnew = new Matrix();
//                matrixnew
//                        .setTranslate(
//                                posItem_X
//                                        + taskItemBackg.getWidth()
//                                        / 2
//                                        - (int) (iconBuilding[itemStorage[itemCorrectStorage[i]][1]]
//                                                .getWidth() * sizeToReduce)
//                                        - diffBetIconQuanti,
//                                posItem_Y
//                                        + taskItemBackg.getHeight()
//                                        / 2
//                                        - (int) (iconBuilding[itemStorage[itemCorrectStorage[i]][1]]
//                                                .getHeight() * sizeToReduce)
//                                        / 2);
//
//                matrixnew.preScale(sizeToReduce, sizeToReduce);
//
//                canvas.drawBitmap(
//                        iconBuilding[itemStorage[itemCorrectStorage[i]][1]],
//                        matrixnew, null);
//
//                // changeSize = true;
//                if (storageChosen == itemCorrectStorage[i]) {
//                    canSell = false;
//                    changeSize = true;
//                    imageAux = iconBuilding[itemStorage[itemCorrectStorage[i]][1]];
//                    nameCropsAux = texts[Constants.BUILDING_NAME[itemStorage[itemCorrectStorage[i]][1]]];
//                }
//
//                checkedAutomaticSmall.setPosX(posItem_X
//                        + taskItemBackg.getWidth()
//                        - checkedAutomaticSmall.getImage().getWidth());
//                checkedAutomaticSmall.setPosY(posItem_Y
//                        + taskItemBackg.getHeight()
//                        - checkedAutomaticSmall.getImage().getHeight());
//                checkedAutomaticSmall.paint(canvas);
//                break;
//
//            }
//            canvas.drawText("x " + itemStorage[itemCorrectStorage[i]][2],
//                    posItem_X + taskItemBackg.getWidth() / 2
//                            + diffBetIconQuanti,
//                    posItem_Y + (taskItemBackg.getHeight() / 3) * 2 - 20,
//                    fontQuantityItemSell);
//
//            posItem_X += taskItemBackg.getWidth() + diffItem_X;
//            if (i == initItem + 2 || i == initItem + 5) {
//                posItem_X = 10 + buttonArrow.getPosX()
//                        + buttonArrow.getImage().getWidth();
//                ;
//                posItem_Y += taskItemBackg.getHeight() + 5;
//            }
//        }
//
//        if (canSell) {
//            buttonAddProduct.paint(canvas);
//        } else {
//            canvas.drawBitmap(buttonAddProductInactive,
//                    buttonAddProduct.getPosX(), buttonAddProduct.getPosY(),
//                    null);
//        }
//        canvas.drawText(texts[24], buttonAddProduct.getPosX()
//                + buttonAddProduct.getImage().getWidth() / 2,
//                buttonAddProduct.getPosY()
//                        + (buttonAddProduct.getImage().getHeight() / 3) * 2,
//                fontMsjTitle);
//
//        if (tutorialGame && stepInAuxTutorial == 2) {
//            paintAnimationCursor(canvas,
//                    buttonAddProduct.getPosX()
//                            + buttonAddProduct.getImage().getWidth() / 2
//                            - cursorHand.getWidth() / 2,
//                    buttonAddProduct.getPosY()
//                            + buttonAddProduct.getImage().getHeight() / 2
//                            - cursorHand.getHeight() / 3 + cursorY, -1);
//        }
//
//        if (imageAux != null) {
//            // posItem_Y = 165;
//
//            canvas.drawText(
//                    nameCropsAux,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2, nameCropsAux_Y,
//                    fontNameItems);
//
//            matrixnew = new Matrix();
//
//            if (changeSize) {
//                matrixnew.setTranslate(
//                        (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                                - spaceBetBorderBackgr
//                                - backgItemStorage.getWidth() / 2
//                                - (int) (imageAux.getWidth() * sizeToReduce)
//                                - 10, imageAuxStor_Y);
//                matrixnew.preScale(sizeToReduce, sizeToReduce);
//            } else {
//                matrixnew.setTranslate(
//                        (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                                - spaceBetBorderBackgr
//                                - backgItemStorage.getWidth() / 2
//                                - imageAux.getWidth() - 10, imageAuxStor_Y);
//            }
//
//            canvas.drawBitmap(imageAux, matrixnew, null);
//
//            canvas.drawText(
//                    "x " + quantityToSell,
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2) + 10
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2,
//                    quantitySellStor_Y, fontQuantityItemSell);
//
//        } else {
//            canvas.drawText(
//                    texts[75],
//                    (mCanvasWidth / 2 + backgroundGeneral.getWidth() / 2)
//                            - spaceBetBorderBackgr
//                            - backgItemStorage.getWidth() / 2,
//                    chooseItemStor_Y, fontNameItemMarket);
//        }
//
//        canvas.drawBitmap(backgroundPage,
//                mCanvasWidth / 2 - backgroundPage.getWidth() / 2
//                        - restPageStorage_X,
//                mCanvasHeight - backgroundPage.getHeight(), null);
//
//        int posButtonPage_X = mCanvasWidth / 2
//                - ((buttonPagesActive.getWidth() + 2) * nPageTotal) / 2
//                - restPageStorage_X;
//        int posButtonPage_Y = mCanvasHeight - buttonPagesActive.getHeight();
//        for (int i = 1; i <= nPageTotal; i++) {
//            if (i == pageInStorage) {
//                canvas.drawBitmap(buttonPagesActive, posButtonPage_X,
//                        posButtonPage_Y, null);
//            } else {
//                canvas.drawBitmap(buttonPages, posButtonPage_X,
//                        posButtonPage_Y, null);
//            }
//
//            posButtonPage_X += buttonPagesActive.getWidth() + 2;
//        }
//
//        if (tutorialGame && stateGame == Constants.STATE_STORAGE) {
//            paintInfoTutorial(canvas, 140);
//        }
//
//        animationElementChosen();
//        // Paint_AnimationQuantity(canvas);
//    }
//
//    private int calculateNPageFeedMill() {
//        int nPages = 1;
//        indexCorrectStorage = 0;
//
//        for (int i = 0; i < iconCrops.length; i++) {
//            // if(cropsQuantityRecolect[i] != 0 ||
//            // Constants.cropsActiveInFeedMill[i] >
//            // buildingsPut[2].getUpdgrade()){
//            itemCorrectStorage[indexCorrectStorage] = i;
//            indexCorrectStorage++;
//            nPages++;
//            // }
//        }
//        Log.d(TAG, "calculateNPageFeedMill -> nPages: " + nPages);
//        return nPages;
//    }
//
//    private int calculateNPageStorage() {
//        int nPages = 1;
//        indexCorrectStorage = 0;
//
//        for (int i = 0; i < indexStorage; i++) {
//            if (itemStorage[i][2] != 0) {
//                itemCorrectStorage[indexCorrectStorage] = i;
//                indexCorrectStorage++;
//                nPages++;
//            }
//        }
//
//        // int add = ((nPages % 9) == 0) ? 0: 1;
//        Log.d(TAG, "calculateNPageFeedMill -> nPages: " + nPages);
//        return nPages;// (nPages/9) + add;
//    }
//
//    private boolean thereIsTouch(MotionEvent event, int posXLess, int posXBig,
//            int posYLess, int posYBig) {
//        boolean thereIsTouch = false;
//        if (event.getX() >= posXLess && event.getX() <= posXBig
//                && event.getY() >= posYLess && event.getY() <= posYBig) {
//            thereIsTouch = true;
//        }
//
//        return thereIsTouch;
//    }
//
//    private void paintObjectTest(Canvas canvas) {
//
//      
//        int Pos_Initial_Map_X = mCanvasWidth / 2 - World.tamTiledX / 2;//(Constants.N_TILED_WORLD_X * World.tamTiledX) / 2;
//        int Pos_Initial_Map_Y = 0;
//        int Aux_Pos_Initial_Map_X = mCanvasWidth / 2 - World.tamTiledX / 2;//(Constants.N_TILED_WORLD_X * World.tamTiledX) / 2;
//        int Aux_Pos_Initial_Map_Y = 0;
//   
//
//        for (int nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y;  nTiledY++) {
//        	   Pos_Initial_Map_X = Aux_Pos_Initial_Map_X;
//               Pos_Initial_Map_Y = Aux_Pos_Initial_Map_Y;
//            for (int nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//            	
//            	  if (Pos_Initial_Map_X + World.posWorldX + World.tamTiledX <= 0
//                          || Pos_Initial_Map_Y + World.posWorldY + World.tamTiledY <= 0
//                          || Pos_Initial_Map_X + World.posWorldX > mCanvasWidth
//                          || Pos_Initial_Map_Y + World.posWorldY > mCanvasHeight) {
//
//                  	 	Pos_Initial_Map_X += World.tamTiledX/2;
//                  	 	Pos_Initial_Map_Y += World.tamTiledY/2;
//                      continue;
//                 }
//             //   posit = calculatePosInitialMap(nTiledX, nTiledY);
//             //  Pos_Initial_Map_X = posit[0];
//             //  Pos_Initial_Map_Y = posit[1];
//                if (nTiledX > 5 && nTiledX < 32 && nTiledY > 5 && nTiledY < 32) {
//                    if (needPaintWorld(canvas, Pos_Initial_Map_X, Pos_Initial_Map_Y, nTiledX, nTiledY)) {
//                        paintElementsInMap(canvas, Pos_Initial_Map_X,
//                                Pos_Initial_Map_Y, nTiledX, nTiledY);
//                       
//                    }
//                 //   paintCollectionInMap(canvas, Pos_Initial_Map_X,
//                   //         Pos_Initial_Map_Y, nTiledX, nTiledY);
//
//                    if (stateOnlyGreen) {
//                        int[][] touch = new int[2][2];
//                        touch[0][0] = nTiledX;
//                        touch[0][1] = nTiledY;
//
//                        if (mapContaints[nTiledY][nTiledX] != Constants.EMPTY
//                                || touchInTileProhib(touch)) {
//                            World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                                    + World.posWorldX, Pos_Initial_Map_Y
//                                    + World.posWorldY);
//                            World.mMatrixflip.preScale(World.mScaleFactor,
//                                    World.mScaleFactor);
//
//                            canvas.drawBitmap(tiledSelected, World.mMatrixflip,
//                                    null);
//                        } else if ((actionSelect == Action.BUILDING && isbuildingFourSpace(itemSelected))
//                                || (classObjectToMove == Constants.EARTH_BUILDING && isbuildingFourSpace(typeObjectInMiniOption))
//                                || (actionSelect == Action.DECORATION && Constants.DECORATIONS_INFO[itemSelected][8] == 1)) {
//                            boolean notTiledProhib = false;
//                            for (int i = 0; i < 3; i++) {
//                                int[][] touchAux = new int[2][2];
//                                if (i == 0) {
//                                    touchAux[0][0] = nTiledX + 1;
//                                    touchAux[0][1] = nTiledY;
//                                } else if (i == 1) {
//                                    touchAux[0][0] = nTiledX;
//                                    touchAux[0][1] = nTiledY + 1;
//                                } else if (i == 2) {
//                                    touchAux[0][0] = nTiledX + 1;
//                                    touchAux[0][1] = nTiledY + 1;
//                                }
//
//                                if (touchInTileProhib(touchAux)) {
//                                    notTiledProhib = true;
//                                    break;
//                                }
//                            }
//
//                            if (notTiledProhib
//                                    || (mapContaints[nTiledY][nTiledX + 1] != Constants.EMPTY
//                                            || mapContaints[nTiledY + 1][nTiledX] != Constants.EMPTY || mapContaints[nTiledY + 1][nTiledX + 1] != Constants.EMPTY)) {
//
//                                World.mMatrixflip.setTranslate(
//                                        Pos_Initial_Map_X + World.posWorldX,
//                                        Pos_Initial_Map_Y + World.posWorldY);
//                                World.mMatrixflip.preScale(World.mScaleFactor,
//                                        World.mScaleFactor);
//                                canvas.drawBitmap(tiledSelected,
//                                        World.mMatrixflip, null);
//                            }
//
//                        }
//                    }
//                }
//                
//                Pos_Initial_Map_X += World.tamTiledX/2;
//                Pos_Initial_Map_Y += World.tamTiledY/2;
//            }
//            Aux_Pos_Initial_Map_X -=   World.tamTiledX/2;
//            Aux_Pos_Initial_Map_Y +=   World.tamTiledY/2;
//
//        }
//
//        Paint_Multitouch(canvas);
//        paintCollectionInMap(canvas);
//
//        paintCar(canvas);
//        if (!stateOnlyGreen) {
//            if (tiledChosen != null && msgSelect != null && indexMultitouch < 1) {
//                int[] position = calculatePosInitialMap(tiledChosen[0][0],
//                        tiledChosen[0][1]);
//
//                paintSuggestionMsg(canvas, position[0], position[1],
//                        tiledChosen[0][0], tiledChosen[0][1]);
//
//            }
//
//        }
//        if (indexMultitouch > 0) {
//            int[] position = calculatePosInitialMap(
//                    multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch]);
//
//            paintBarAction(canvas, position[0] + World.posWorldX, position[1]
//                    + World.posWorldY);
//        }
//
//        paintObjectInMap(canvas);
//
//        paintActionTutorial(canvas);
//
//    }
//
//    private boolean isbuildingFourSpace(int itemChoosed) {
//        if (Constants.BUILDING_TYPE_ORD[itemChoosed] == Constants.ENCLOSURE_CHICKEN
//                || Constants.BUILDING_TYPE_ORD[itemChoosed] == Constants.ENCLOSURE_COW
//                || Constants.BUILDING_TYPE_ORD[itemChoosed] == Constants.ENCLOSURE_SHEEP
//                || Constants.BUILDING_TYPE_ORD[itemChoosed] == Constants.ENCLOSURE_GOAT
//                || Constants.BUILDING_TYPE_ORD[itemChoosed] == Constants.ENCLOSURE_PIG) {
//            return true;
//        }
//        return false;
//    }
//
//    private void paintActionTutorial(Canvas canvas) {
//
//        if (tutorialGame && stateGame == Constants.STATE_MAIN_GAME) {
//            int valueToValidate = -1;
//            int popTutorial_X = 10;
//            int popTutorial_Y = 10;
//            switch (stepTutorial) {
//            case 2:
//                valueToValidate = 0;
//                break;
//            case 3:
//                valueToValidate = 0;
//                break;
//            case 4:
//                valueToValidate = 1;
//                break;
//            case 5:
//            case 6:
//                valueToValidate = 2;
//                break;
//            case 7:
//                if (stepInAuxTutorial == 2) {
//                    valueToValidate = 3;
//                } else if (stepInAuxTutorial == 3) {
//                    valueToValidate = 1;
//                } else if (stepInAuxTutorial == 5) {
//                    valueToValidate = 2;
//                } else if (stepInAuxTutorial == 7) {
//                    valueToValidate = 2;
//                }
//                break;
//
//            case 8:
//                int[] posit = calculatePosInitialMap(22, 14);
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(canvas, posit[0] + World.posWorldX
//                        + World.tamTiledX / 2 - cursorHand.getWidth() / 2,
//                        posit[1] + World.posWorldY + World.tamTiledY / 2
//                                - cursorHand.getHeight() / 2 + cursorY, -1);
//
//                break;
//
//            case 13:
//                int[] posit2 = calculatePosInitialMap(23, 13);
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(canvas, posit2[0] + World.posWorldX
//                        + World.tamTiledX / 2 - cursorHand.getWidth() / 2,
//                        posit2[1] + World.posWorldY + World.tamTiledY / 2
//                                - cursorHand.getHeight() / 2 + cursorY, -1);
//
//                break;
//            case Constants.STEP_TUTORIAL_EXPAND:
//                int[] posit3 = calculatePosInitialMap(27, 16);
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(canvas, posit3[0] + World.posWorldX
//                        + World.tamTiledX / 2 - cursorHand.getWidth() / 2,
//                        posit3[1] + World.posWorldY + World.tamTiledY / 2
//                                - cursorHand.getHeight() / 2 + cursorY, -1);
//
//                break;
//            case Constants.STEP_TUTORIAL_CONGRATULATIONS:
//                int[] posit5 = calculatePosInitialMap(22, 18);
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(canvas, posit5[0] + World.posWorldX
//                        + World.tamTiledX / 2 - cursorHand.getWidth() / 2,
//                        posit5[1] + World.posWorldY + World.tamTiledY / 2
//                                - cursorHand.getHeight() / 2 + cursorY, -1);
//                break;
//
//            case Constants.STEP_TUTORIAL_GET_SPECIAL_TASKS:
//                int[] posit4 = calculatePosInitialMap(21, 20);
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(canvas, posit4[0] + World.posWorldX
//                        + World.tamTiledX / 2 - cursorHand.getWidth() / 2,
//                        posit4[1] + World.posWorldY + World.tamTiledY / 2
//                                - cursorHand.getHeight() / 2 + cursorY, -1);
//
//                break;
//            }
//
//            if (valueToValidate != -1 && !canShowInfoAuto) {
//                for (int i = 0; i < 6; i++) {
//                    if (posTiledTutorial[i][2] == valueToValidate) {
//                        int[] posit = calculatePosInitialMap(
//                                posTiledTutorial[i][0], posTiledTutorial[i][1]);
//                        if (i == 0) {
//                            popTutorial_X = posit[0] + World.posWorldX
//                                    + World.tamTiledX / 2
//                                    - popTutorial.getWidth() / 2;
//                            popTutorial_Y = posit[1] + World.posWorldY
//                                    - popTutorial.getHeight() / 2;
//
//                        }
//                        World.mMatrixflip.setTranslate(posit[0]
//                                + World.posWorldX, posit[1] + World.posWorldY);
//                        World.mMatrixflip.preScale(World.mScaleFactor,
//                                World.mScaleFactor);
//                        canvas.drawBitmap(tiledSelected, World.mMatrixflip,
//                                null);
//                        itemToChoose = -1;
//                        animationCursor = true;
//                        paintAnimationCursor(canvas, posit[0] + World.posWorldX
//                                + World.tamTiledX / 2 - cursorHand.getWidth()
//                                / 2, posit[1] + World.posWorldY
//                                + World.tamTiledY / 2 - cursorHand.getHeight()
//                                / 3 + cursorY, -1);
//
//                        break;
//                    }
//                }
//            }
//
//            if (showIconMsgTuto) {
//                UtilSoftgames.transparentImage(canvas, popTutorial,
//                        popTutorial_X + popTutorial.getWidth() / 2,
//                        popTutorial_Y, dissapearActive, true);
//                if (UtilSoftgames.alphaImage != 0) {
//                    canvas.drawText("Click here!",
//                            popTutorial_X + popTutorial.getWidth() / 2,
//                            popTutorial_Y + (popTutorial.getHeight() / 6),
//                            fontBlackSmallCenter);
//                }
//                if (System.currentTimeMillis() - timeShowIconMsgTuto >= 2800) {
//                    timeShowIconMsgTuto = System.currentTimeMillis();
//                    if (dissapearActive) {
//                        dissapearActive = false;
//                        showIconMsgTuto = false;
//                    } else {
//                        dissapearActive = true;
//                    }
//                }
//            }
//        }
//    }
//
//    private void paintCar(Canvas canvas) {
//        // Log.d(TAG, "paintCar");
//        if (animationCarTruck) {
//
//            /**
//             * this for the zoom
//             */
//            int[] posCar = calculatePosInitialMap(posInitCar_X, posInitCar_Y);
//            carTruck_X = posCar[0];
//            carTruck_Y = posCar[1];
//
//            if (posInitCar_Y < 20) {
//
//                World.mMatrixflip.setTranslate(
//                        carTruck_X + carTruckAnimation_X + World.posWorldX
//                                + World.tamTiledX / 2
//                                - (carTruck4.getWidth() * World.mScaleFactor)
//                                / 2 - 20, carTruck_Y + carTruckAnimation_Y
//                                + World.posWorldY + World.tamTiledY / 2
//                                - (carTruck4.getHeight() * World.mScaleFactor)
//                                / 2 - 12);
//
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//
//                canvas.drawBitmap(carTruck, World.mMatrixflip, null);
//            } else {
//
//                World.mMatrixflip.setTranslate(
//                        carTruck_X + carTruckAnimation_X + World.posWorldX
//                                + World.tamTiledX / 2
//                                - (carTruck2.getWidth() * World.mScaleFactor)
//                                / 2, carTruck_Y + carTruckAnimation_Y
//                                + World.posWorldY + World.tamTiledY / 2
//                                - (carTruck2.getHeight() * World.mScaleFactor)
//                                / 2);
//
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//
//                canvas.drawBitmap(carTruck4, World.mMatrixflip, null);
//            }
//
//            if (canRewardQuestTruck) {
//                UtilSoftgames
//                        .paintAnimationStart(
//                                canvas,
//                                carTruck_X
//                                        + carTruckAnimation_X
//                                        + World.posWorldX
//                                        + World.tamTiledX
//                                        / 2
//                                        - (int) (carTruck.getWidth() * World.mScaleFactor)
//                                        / 2,
//
//                                carTruck_Y
//                                        + carTruckAnimation_Y
//                                        + World.posWorldY
//                                        + World.tamTiledY
//                                        / 2
//                                        - (int) (carTruck.getHeight() * World.mScaleFactor)
//                                        / 2);
//            }
//            if (System.currentTimeMillis() - Time_CarTruck >= 50) {
//                Time_CarTruck = System.currentTimeMillis();
//
//                if (posInitCar_Y < 20) {
//                    carTruckAnimation_X -= (4 * World.mScaleFactor);
//                    carTruckAnimation_Y += (2 * World.mScaleFactor);
//
//                    if (carTruckAnimation_X * -1 >= World.tamTiledX / 2) {
//                        carTruckAnimation_X = 0;
//                        carTruckAnimation_Y = 0;
//                        posInitCar_Y += 1;
//                        // int []posCar =
//                        // calculatePosInitialMap(posInitCar_X,
//                        // posInitCar_Y);
//                        // carTruck_X = posCar[0];
//                        // carTruck_Y = posCar[1];
//                    }
//                } else if (posInitCar_X > 21) {
//                    carTruckAnimation_X -= (4 * World.mScaleFactor);
//                    carTruckAnimation_Y -= (2 * World.mScaleFactor);
//
//                    if (carTruckAnimation_X * -1 >= World.tamTiledX / 2) {
//                        carTruckAnimation_X = 0;
//                        carTruckAnimation_Y = 0;
//                        posInitCar_X -= 1;
//                        // int []posCar =
//                        // calculatePosInitialMap(posInitCar_X,
//                        // posInitCar_Y);
//                        // carTruck_X = posCar[0];
//                        // carTruck_Y = posCar[1];
//                    }
//                }
//
//            }
//        } else if (chosenOptionQuestTruck /* && !aceptQuestTruck */
//                && posInitCar_Y != 4) {
//
//            /**
//             * this for the zoom
//             */
//            int[] posCar = calculatePosInitialMap(posInitCar_X, posInitCar_Y);
//            carTruck_X = posCar[0];
//            carTruck_Y = posCar[1];
//
//            if (posInitCar_X < 29) {
//                World.mMatrixflip.setTranslate(
//                        carTruck_X + carTruckAnimation_X + World.posWorldX
//                                + World.tamTiledX / 2
//                                - (carTruck3.getWidth() * World.mScaleFactor)
//                                / 2
//                                + (carTruck3.getWidth() * World.mScaleFactor),
//                        carTruck_Y + carTruckAnimation_Y + World.posWorldY
//                                + World.tamTiledY / 2
//                                - (carTruck3.getHeight() * World.mScaleFactor)
//                                / 2);
//
//                World.mMatrixflip.preScale(World.mScaleFactor * -1,
//                        World.mScaleFactor);
//
//                if (aceptQuestTruck) {
//                    canvas.drawBitmap(carTruck3, World.mMatrixflip, null);
//                } else {
//                    canvas.drawBitmap(carTruck, World.mMatrixflip, null);
//                }
//            } else {
//                World.mMatrixflip.setTranslate(
//                        carTruck_X + carTruckAnimation_X + World.posWorldX
//                                + World.tamTiledX / 2
//                                - (carTruck2.getWidth() * World.mScaleFactor)
//                                / 2
//                                + (carTruck2.getWidth() * World.mScaleFactor)
//                                - 20, carTruck_Y + carTruckAnimation_Y
//                                + World.posWorldY + World.tamTiledY / 2
//                                - (carTruck2.getHeight() * World.mScaleFactor)
//                                / 2 - 12);
//
//                World.mMatrixflip.preScale(World.mScaleFactor * -1,
//                        World.mScaleFactor);
//
//                if (aceptQuestTruck) {
//                    canvas.drawBitmap(carTruck2, World.mMatrixflip, null);
//                } else {
//                    canvas.drawBitmap(carTruck4, World.mMatrixflip, null);
//                }
//
//            }
//            if (System.currentTimeMillis() - Time_CarTruck >= 50) {
//                Time_CarTruck = System.currentTimeMillis();
//
//                if (posInitCar_X < 29) {
//                    carTruckAnimation_X += (4 * World.mScaleFactor);
//                    carTruckAnimation_Y += (2 * World.mScaleFactor);
//
//                    if (carTruckAnimation_X >= World.tamTiledX / 2) {
//                        carTruckAnimation_X = 0;
//                        carTruckAnimation_Y = 0;
//                        posInitCar_X += 1;
//
//                    }
//                } else if (posInitCar_Y > 4) {
//                    carTruckAnimation_X += (4 * World.mScaleFactor);
//                    carTruckAnimation_Y -= (2 * World.mScaleFactor);
//
//                    if (carTruckAnimation_X >= World.tamTiledX / 2) {
//                        carTruckAnimation_X = 0;
//                        carTruckAnimation_Y = 0;
//                        posInitCar_Y -= 1;
//
//                    }
//                }
//            }
//        }
//
//    }
//
//    private void paintCollectionInMap(Canvas canvas) {
//        // Log.d(TAG, "paintCollectionInMap");
//        for (int i = 0; i < indexCollectionWin; i++) {
//            if (collectionWin[i].isActive()
//                    /*&& collectionWin[i].getPosTiledX() == nTiledX
//                    && collectionWin[i].getPosTiledY() == nTiledY*/) {
//                
//                int[] pos = calculatePosInitialMap(collectionWin[i].getPosTiledX(), collectionWin[i].getPosTiledY());
//                int posX = pos[0];
//                int posY = pos[1];
//                collectionWin[i].updateStatus();
//                collectionsImages[collectionWin[i].getType()]
//                        .paint(canvas,
//                                collectionWin[i].getPosition(),
//                                posX
//                                        + World.posWorldX
//                                        + World.tamTiledX
//                                        / 2
//                                        - (collectionsImages[collectionWin[i]
//                                                .getType()].auxImage.getWidth() / 5)
//                                        / 2,
//                                posY
//                                        + World.posWorldY
//                                        + World.tamTiledY
//                                        / 2
//                                        - (collectionsImages[collectionWin[i]
//                                                .getType()].auxImage
//                                                .getHeight()) / 2,
//                                collectionsImages[collectionWin[i].getType()].auxImage
//                                        .getHeight(),
//                                collectionsImages[collectionWin[i].getType()].auxImage
//                                        .getWidth() / 5, false, false, false);
//            }
//        }
//    }
//
//    private void paintWorldGame(Canvas canvas) {
//        //Paint paint = new Paint();
//        //paint.setColor(Color.BLACK);
//        canvas.drawRect(0, 0, mCanvasWidth, mCanvasHeight, mPaint);
//        
//        int Pos_Initial_Map_X = mCanvasWidth / 2 - World.tamTiledX / 2;//(Constants.N_TILED_WORLD_X * World.tamTiledX) / 2;
//        int Pos_Initial_Map_Y = 0;
//        int Aux_Pos_Initial_Map_X = mCanvasWidth / 2 - World.tamTiledX / 2;//(Constants.N_TILED_WORLD_X * World.tamTiledX) / 2;
//        int Aux_Pos_Initial_Map_Y = 0;
//        int IndexLevel = 0;
//   
//        boolean found = false;
//        for (int nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y; nTiledY++) {
//        	  Pos_Initial_Map_X = Aux_Pos_Initial_Map_X;
//              Pos_Initial_Map_Y = Aux_Pos_Initial_Map_Y;
//            for (int nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//             
//                if (Pos_Initial_Map_X + World.posWorldX + World.tamTiledX <= 0
//                        || Pos_Initial_Map_Y + World.posWorldY + World.tamTiledY <= 0
//                        || Pos_Initial_Map_X + World.posWorldX > mCanvasWidth
//                        || Pos_Initial_Map_Y + World.posWorldY > mCanvasHeight) {
//
//                	 if (nTiledX > 5 && nTiledX < 32 && nTiledY > 5 && nTiledY < 32) {
//                          IndexLevel ++;
//                	 }
//       			 	Pos_Initial_Map_X += World.tamTiledX/2;
//	                Pos_Initial_Map_Y += World.tamTiledY/2;
//                    continue;
//                }
//                int[] posit = new int[2];
//            	posit[0] = Pos_Initial_Map_X;
//            	posit[1] = Pos_Initial_Map_Y;
//            	
//                if (nTiledX > 5 && nTiledX < 32 && nTiledY > 5 && nTiledY < 32) {
//                	
//                	
//                    found = paintExpansion(canvas, posit, nTiledY, nTiledX);
//
//                    if (!found) {
//                        paintWorldNew(canvas, Pos_Initial_Map_X, Pos_Initial_Map_Y, IndexLevel);
//                    }
//                    
//                    IndexLevel++;
//                }else {
//                    if (nTiledX < 6) {
//                        // agua
//                        World.mMatrixflip.setTranslate(posit[0]
//                                + World.posWorldX, posit[1] + World.posWorldY);
//                        World.mMatrixflip.preScale(World.mScaleFactor,
//                                World.mScaleFactor);
//                        canvas.drawBitmap(tiledMap[3], World.mMatrixflip, null);
//
//                    } else if (nTiledX >= 6 && nTiledY < 6) {
//                        // arbol grande
//                        World.mMatrixflip.setTranslate(posit[0]
//                                + World.posWorldX, posit[1] + World.posWorldY
//                                + World.tamTiledY - tiledMap[14].getHeight()
//                                * World.mScaleFactor);
//                        World.mMatrixflip.preScale(World.mScaleFactor,
//                                World.mScaleFactor);
//                        canvas.drawBitmap(tiledMap[14], World.mMatrixflip, null);
//
//                    } else if (nTiledX >= Constants.N_TILED_WORLD_X - 6) {
//                        World.mMatrixflip.setTranslate(posit[0]
//                                + World.posWorldX, posit[1] + World.posWorldY
//                                + World.tamTiledY - tiledMap[9].getHeight()
//                                * World.mScaleFactor);
//                        World.mMatrixflip.preScale(World.mScaleFactor,
//                                World.mScaleFactor);
//                        canvas.drawBitmap(tiledMap[9], World.mMatrixflip, null);
//
//                    } else if (nTiledX >= 6
//                            && nTiledY >= Constants.N_TILED_WORLD_Y - 6) {
//                        World.mMatrixflip.setTranslate(posit[0]
//                                + World.posWorldX, posit[1] + World.posWorldY
//                                + World.tamTiledY - tiledMap[9].getHeight()
//                                * World.mScaleFactor);
//                        World.mMatrixflip.preScale(World.mScaleFactor,
//                                World.mScaleFactor);
//                        canvas.drawBitmap(tiledMap[9], World.mMatrixflip, null);
//                    }
//                }
//              
//                Pos_Initial_Map_X += World.tamTiledX/2;
//                Pos_Initial_Map_Y += World.tamTiledY/2;
//            }
//            Aux_Pos_Initial_Map_X -=   World.tamTiledX/2;
//            Aux_Pos_Initial_Map_Y +=   World.tamTiledY/2;
//        }
//    }
//
//    private boolean paintExpansion(Canvas canvas, int[] posit, int nTiledY,
//            int nTiledX) {
//        // Log.d(TAG, "paintExpansion");
//        boolean found = false;
//        switch (mapContaints[nTiledY][nTiledX]) {
//        case Constants.EXPANSION:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[0], World.mMatrixflip, null);
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[1], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO2:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[2], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO3:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[3], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO4:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[4], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO5:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[5], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO6:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[6], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO7:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[7], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO8:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[8], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO9:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[9], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO10:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[10], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO11:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[11], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO12:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[12], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO13:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[13], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO14:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[14], World.mMatrixflip, null);
//
//            found = true;
//            break;
//        case Constants.EXPANSIONLIMBO15:
//            World.mMatrixflip.setTranslate(posit[0] + World.posWorldX, posit[1]
//                    + World.posWorldY);// +
//                                       // (Constants.Tam_Tiled_Y*4)
//                                       // -
//                                       // (expansionImg.getHeight()
//                                       // * World.mScaleFactor) );
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledExpansion[15], World.mMatrixflip, null);
//
//            found = true;
//            break;
//
//        }
//
//        return found;
//    }
//
//    /*private int calcuIndexlevel(int nTiledX, int nTiledY) {
//        int IndexLevel = 0;
//        nTiledX -= 6;
//        nTiledY -= 6;
//        IndexLevel = nTiledX + (nTiledY * 26);// (nTiledX+1 * nTiledY+1) -
//        return IndexLevel;
//    }*/
//
//    /**
//     * Draws an object on the map depending on the type of earth
//     * 
//     * @param canvas
//     * @param posX
//     * @param posY
//     * @param nTiledX
//     * @param nTiledY
//     */
//    private void paintElementsInMap(Canvas canvas, int posX, int posY,
//            int nTiledX, int nTiledY) {
//
//        switch (mapContaints[nTiledY][nTiledX]) {
//        case Constants.EARTH_BUILDING:
//            if (buildingsPut[mapObjects[nTiledY][nTiledX]].isFourSpace()) {
//                nTiledY -= 1;
//                posY -= ((World.tamTiledY / 2) * World.mScaleFactor);
//                posX += ((World.tamTiledX / 2) * World.mScaleFactor);
//            }
//            boolean canShowHandInAnimal = true;
//            buildingsPut[mapObjects[nTiledY][nTiledX]].paint(canvas, posX,
//                    posY, isSelectedObject(posX, posY));
//            if (buildingsPut[mapObjects[nTiledY][nTiledX]].getClassType() == Constants.BUILDINGANIMAL
//                    && !buildingsPut[mapObjects[nTiledY][nTiledX]].isMoveFree()) {
//                for (int i = 0; i < nAnimalsPut; i++) {
//                    if (animalsPut[i].getPos_X() == nTiledX
//                            && animalsPut[i].getPos_Y() == nTiledY) {
//
//                        animalsPut[i].paint(canvas, posX, posY);
//                        if (animalsPut[i].getProducing()) {
//                            canShowHandInAnimal = false;
//                        }
//
//                    } else if (animalsPut[i].getPos_X() == nTiledX + 1
//                            && animalsPut[i].getPos_Y() == nTiledY) {
//
//                        animalsPut[i]
//                                .paint(canvas,
//                                        posX
//                                                + (int) ((World.tamTiledX / 2) * World.mScaleFactor),
//                                        posY
//                                                + (int) ((World.tamTiledY / 2) * World.mScaleFactor));
//                        if (animalsPut[i].getProducing()) {
//                            canShowHandInAnimal = false;
//                        }
//                    } else if (animalsPut[i].getPos_X() == nTiledX
//                            && animalsPut[i].getPos_Y() == nTiledY + 1) {
//
//                        animalsPut[i]
//                                .paint(canvas,
//                                        posX
//                                                - (int) ((World.tamTiledX / 2) * World.mScaleFactor),
//                                        posY
//                                                + (int) ((World.tamTiledY / 2) * World.mScaleFactor));
//                        if (animalsPut[i].getProducing()) {
//                            canShowHandInAnimal = false;
//                        }
//                    } else if (animalsPut[i].getPos_X() == nTiledX + 1
//                            && animalsPut[i].getPos_Y() == nTiledY + 1) {
//
//                        animalsPut[i]
//                                .paint(canvas,
//                                        posX,
//                                        posY
//                                                + (int) ((World.tamTiledY) * World.mScaleFactor));
//                        if (animalsPut[i].getProducing()) {
//                            canShowHandInAnimal = false;
//                        }
//                    }
//                }
//            }
//            if (tutorialGame
//                    && canShowHandInAnimal
//                    && (stepTutorial == Constants.STEP_TUTORIAL_BOOST_CONSTRUCTION
//                            || stepTutorial == Constants.STEP_TUTORIAL_UNWRAP_FINISHED_BUILDING
//                            || stepTutorial == Constants.STEP_TUTORIAL_ADD_ANIMAL
//                            || stepTutorial == Constants.STEP_TUTORIAL_CROPS_BECOME_FOOD
//                            || stepTutorial == Constants.STEP_TUTORIAL_FEED_ANIMALS || stepTutorial == Constants.STEP_TUTORIAL_FIRST_EGG)
//                    && !buildingsPut[mapObjects[nTiledY][nTiledX]]
//                            .isShowTimeUnderConstruction()) {
//
//                itemToChoose = -1;
//                animationCursor = true;
//
//                if (buildingsPut[mapObjects[nTiledY][nTiledX]].getClassType() == Constants.BUILDINGANIMAL) {
//                    paintAnimationCursor(canvas, posX + World.posWorldX
//                            + World.tamTiledX / 2 - cursorHand.getWidth() / 2,
//                            posY + World.posWorldY + World.tamTiledY / 2
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//                }
//            }
//
//            else if (tutorialGame
//                    && canShowHandInAnimal
//                    && (stepTutorial == Constants.STEP_TUTORIAL_WELL_DONE || stepTutorial == Constants.STEP_TUTORIAL_MORE_EGG)
//                    && !buildingsPut[mapObjects[nTiledY][nTiledX]]
//                            .isShowTimeUnderConstruction()) {
//
//                itemToChoose = -1;
//                animationCursor = true;
//
//                if (buildingsPut[mapObjects[nTiledY][nTiledX]].getClassType() == Constants.BUILDINGANIMAL) {
//                    paintAnimationCursor(canvas, posX + World.posWorldX
//                            + World.tamTiledX - cursorHand.getWidth() / 2,
//                            posY + World.posWorldY + World.tamTiledY
//                                    - cursorHand.getHeight() / 3 + cursorY, -1);
//                }
//            }
//            break;
//
//        case Constants.EARTH_DECORATION:
//
//            Decoration deco = decorationsPut[mapObjects[nTiledY][nTiledX]];
//            if(deco == null){
//            	return;
//            }
//            if (Constants.DECORATIONS_INFO[deco.getType()][8] == 1) {
//                nTiledY -= 1;
//                posY -= ((World.tamTiledY / 2) * World.mScaleFactor);
//                posX += ((World.tamTiledX / 2) * World.mScaleFactor);
//            }
//            deco.paint(canvas, posX, posY);
//
//            break;
//        case Constants.EARTH_CROPS:
//            tree[mapObjects[nTiledY][nTiledX]].paint(canvas, posX, posY,
//                    isSelectedObject(nTiledX, nTiledY));
//            break;
//        }
//
//    }
//
//    private void doAutomatic() {
//        
//        if (actionSelect == null)
//            return;
//        switch (actionSelect) {
//        case PLOW:
//            automaticPlow();
//            break;
//        case HARVEST:
//            automaticHarvest();
//            if (tutorialGame
//                    && stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                stepTutorial++;
//                dissapearMsj = false;
//                UtilSoftgames.setValuesForTransparent();
//                timeShowIconMsgTuto = System.currentTimeMillis();
//                showIconMsgTuto = true;
//                stepInAuxTutorial = 0;
//             //   sadas
//              
//               preparateMoving(21, 13);
//               
//           
//            }
//            break;
//        case FERTILIZE:
//            automaticFertilize();
//            if (tutorialGame && stepTutorial != Constants.STEP_TUTORIAL_FREE
//                    && stepTutorial != Constants.STEP_TUTORIAL_PLACE_ON_YARD) {
//                if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                    stepInAuxTutorial++;
//                } else {
//                    stepTutorial++;
//                    UtilSoftgames.setValuesForTransparent();
//                    timeShowIconMsgTuto = System.currentTimeMillis();
//                    showIconMsgTuto = true;
//                    dissapearMsj = false;
//                }
//            }
//            break;
//        case PLANT:
//            automaticPlant();
//            if (tutorialGame
//                    && stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                stepInAuxTutorial++;
//            }
//            break;
//        case WATERING:
//            automaticWatering();
//            break;
//        case ANIMAL_FOOD:
//            if (isTransactionPossible(Constants.DIAMONDS, 5)) {
//                assignQuantity(0, 0, 0, 0, -5, 0, 0, mCanvasWidth / 2,
//                        mCanvasHeight / 2);
//                automaticFoodInAnimal();
//            }
//            break;
//        case BUILDINGFINISHALL:
//            if (isTransactionPossible(Constants.DIAMONDS, 5)) {
//                assignQuantity(0, 0, 0, 0, -5, 0, 0, mCanvasWidth / 2,
//                        mCanvasHeight / 2);
//                automaticFinishAllBuilding();
//            }
//            break;
//        case ANIMALFINISHALL:
//            if (isTransactionPossible(Constants.DIAMONDS, 5)) {
//                assignQuantity(0, 0, 0, 0, -5, 0, 0, mCanvasWidth / 2,
//                        mCanvasHeight / 2);
//                automaticFinishAllAnimal();
//            }
//            break;
//
//        }
//
//    }
//
//    private void automaticFinishAllAnimal() {
//        Log.d(TAG, "automaticFinishAllAnimal");
//        for (int i = 0; i < nAnimalsPut; i++) {
//            if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_WORKING) {
//                animalsPut[i].setStatus(Constants.STATUS_ANIMALS_READY);
//                animalsPut[i].setProducing(false);
//                animalsPut[i]
//                        .setTimeTranscurrentProducing(Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                                .getType()][3]);
//                animalsPut[i].setSelected(false);
//            }
//        }
//    }
//
//    private void automaticFinishAllBuilding() {
//        Log.d(TAG, "automaticFinishAllBuilding");
//        for (int i = 0; i < nBuildingsPut; i++) {
//            for (int h = 0; h < 5; h++) {
//                if (buildingsPut[i].getClassType() == Constants.BUILDINGNORMAL
//                        && buildingsPut[i].getSlot()[h] == 2) {
//                    buildingsPut[i].changeStatus(3);
//                    buildingsPut[i].getSlot()[h] = 3;
//                    buildingsPut[i].setTimeTranscurrent(0);
//                }
//            }
//        }
//        actionSelect = null;
//    }
//
//    private void automaticFoodInAnimal() {
//        for (int i = 0; i < nAnimalsPut; i++) {
//            if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_HUNGRY
//                    && quantitySeeds >= Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                            .getType()][4]) {
//                quantitySeeds -= Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                        .getType()][4];
//                animalsPut[i].setStatus(Constants.STATUS_ANIMALS_WORKING);
//            }
//        }
//        actionSelect = null;
//    }
//
//    private void automaticWatering() {
//        if (isTransactionPossible(Constants.DIAMONDS,
//                Constants.BOOST_WATERING_COST)) {
//            quantityDiamonds -= Constants.BOOST_WATERING_COST;
//
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].readyWatering) {
//                    tree[i].animationReadyWatering = true;
//                    restValueMission(Constants.WATERING, 0);
//                }
//            }
//        }
//    }
//
//    private void automaticHarvest() {
//        if (isTransactionPossible(Constants.DIAMONDS,
//                Constants.BOOST_HARVEST_COST)) {
//            quantityDiamonds -= Constants.BOOST_HARVEST_COST;
//            harvestPlant(0, 0, true);
//        }
//    }
//
//    private void automaticFertilize() {
//        if (isTransactionPossible(Constants.DIAMONDS,
//                Constants.BOOST_FERTILIZE_COST)) {
//            quantityDiamonds -= Constants.BOOST_FERTILIZE_COST;
//
//            for (int i = 0; i < NTree; i++) {
//                if (!tree[i].isReady()) {
//                    tree[i].setTiled(5);
//                }
//            }
//        }
//    }
//
//    private void automaticPlant() {
//        if (isTransactionPossible(Constants.DIAMONDS,
//                Constants.BOOST_PLANTING_COST)) {
//            quantityDiamonds -= Constants.BOOST_PLANTING_COST;
//
//            boolean canPayPlant = false;
//            int diamonds = 0;
//            int coins = 0;
//            int mastered = 0;
//            for (byte nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y; nTiledY++) {
//                for (byte nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//                    if (mapContaints[nTiledY][nTiledX] == Constants.EARTHGOOD) {
//                        canPayPlant = false;
//                        diamonds -= Constants.CROPS_DIAMONDS_TO_PAY[Constants.CROPS_ORD[itemSelected]];
//                        coins -= Constants.CROPS_COINS_TO_PAY[Constants.CROPS_ORD[itemSelected]];
//
//                        if (quantityDiamonds + diamonds >= 0
//                                && quantityCoins + coins >= 0) {
//                            canPayPlant = true;
//                            Constants.TreeQuantity[Constants.CROPS_ORD[itemSelected]] += 1;
//                            winMastered(Constants.CROPS_ORD[itemSelected]);
//                        }
//
//                        if (canPayPlant) {
//                            plantCrops(nTiledX, nTiledY, true);
//                            mastered += 1;
//                        } else {
//                            return;
//                        }
//
//                    }
//                }
//            }
//
//            assignQuantity(mastered, 0, 0, 0, diamonds, coins, 0,
//                    mCanvasWidth / 2, mCanvasHeight / 2);
//        }
//    }
//
//    private void automaticPlow() {
//        Log.d(TAG, "automaticPlow");
//
//        if (isTransactionPossible(Constants.DIAMONDS, Constants.BOOST_PLOW_COST)) {
//            quantityDiamonds -= Constants.BOOST_PLOW_COST;
//
//            int coinWin = 0;
//            int expWin = 0;
//            for (byte nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y; nTiledY++) {
//                for (byte nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//                    if (mapContaints[nTiledY][nTiledX] == Constants.EARTHBAD) {
//                        if (quantityCoins - coinWin >= 10) {
//                            coinWin -= 10;
//                            expWin += 1;
//                            mapContaints[nTiledY][nTiledX] = Constants.EARTHGOOD;
//                            restValueMission(Constants.PLOW, 0);
//                        } else {
//                            stateGame = Constants.STATE_MORE_COINS;
//                            loadImages();
//                            break;
//                        }
//                    }
//                }
//            }
//
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].isWhitered()) {
//                    if (quantityCoins - coinWin >= 10) {
//                        coinWin -= 10;
//                        expWin += 1;
//                        mapContaints[tree[i].getPosY()][tree[i].getPosX()] = Constants.EARTHGOOD;
//                        restValueMission(Constants.PLOW, 0);
//                        tree[i].died();
//                    } else {
//                        stateGame = Constants.STATE_MORE_COINS;
//                        loadImages();
//                        break;
//                    }
//                }
//            }
//
//            assignQuantity(0, 0, 0, 0, 0, coinWin, expWin, mCanvasWidth / 2,
//                    mCanvasHeight / 2);
//
//        }
//
//    }
//
//    private boolean isSelectedObject(int posX, int posY) {
//        boolean isSelected = false;
//        if (tiledChosen != null && msgSelect != null) {
//            if (tiledChosen[0][0] == posX && tiledChosen[0][1] == posY) {
//                isSelected = true;
//            }
//        }
//        return isSelected;
//    }
//
//    private void paintObjectInMap(Canvas canvas) {
//
//        if (decorationChosen != -1
//                && decorationsPut[decorationChosen].isMenuRotate()) {
//            paintMenuRotate(canvas,
//                    decorationsPut[decorationChosen].getPos_X(),
//                    decorationsPut[decorationChosen].getPos_Y(), true,
//                    Constants.EARTH_DECORATION, decorationChosen);
//
//        } else if (buildingChosen != -1
//                && buildingsPut[buildingChosen].isMenuRotate()) {
//            paintMenuRotate(canvas, buildingsPut[buildingChosen].getPosX(),
//                    buildingsPut[buildingChosen].getPosY(), false,
//                    Constants.EARTH_BUILDING, buildingChosen);
//
//        } else if (cropChosen != -1 && tree[cropChosen].isMenuRotate()) {
//            paintMenuRotate(canvas, tree[cropChosen].getPosX(),
//                    tree[cropChosen].getPosY(), false, Constants.EARTH_CROPS,
//                    cropChosen);
//        }
//
//        if (buildingChosen != -1 && !buildingsPut[buildingChosen].isReady()
//                && buildingsPut[buildingChosen].isShowTimeUnderConstruction()) {
//            paintTimeUnderConstr(
//                    canvas,
//                    buildingsPut[buildingChosen].getPosX(),
//                    buildingsPut[buildingChosen].getPosY(),
//                    buildingsPut[buildingChosen].getTimeForConstruction(),
//                    buildingsPut[buildingChosen].getTimeUnderConstruct(),
//
//                    buildingsPut[buildingChosen]
//                            .transformToSeconds(
//                                    Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                                            .getPosOrderInfos()
//                                            + buildingsPut[buildingChosen]
//                                                    .getUpdgrade()][6],
//                                    Constants.BUILDING_NEED_UPGRADE[buildingsPut[buildingChosen]
//                                            .getPosOrderInfos()
//                                            + buildingsPut[buildingChosen]
//                                                    .getUpdgrade()][7]));
//        }
//
//        if (animalChosen != -1 && animalsPut[animalChosen].isReady()
//                && animalsPut[animalChosen].getProducing()) {
//            int[] posit = getTiledInAnimal(animalChosen, orderAnimalChosen);
//            Paint_Producing(canvas, posit[0], posit[1],
//                    animalsPut[animalChosen].getTimeForProducing(),
//                    animalsPut[animalChosen].getTimeTranscurrentProducing(),
//                    Constants.PRODUCT_ANIMAL_INFO[animalsPut[animalChosen]
//                            .getType()][3]);
//        }
//
//        if (pressHold) {
//            int posBackMsjSelected_X = (int) World.posMoveFreeX
//                    - loadMoveFreeEmpty.getWidth()
//                    - loadMoveFreeEmpty.getWidth() / 2;
//            int posBackMsjSelected_Y = (int) World.posMoveFreeY;
//
//            canvas.drawBitmap(loadMoveFreeFull, posBackMsjSelected_X,
//                    posBackMsjSelected_Y - World.tamTiledY, null);
//
//            paintAnimationBarLoading(
//                    canvas,
//                    loadMoveFreeEmpty,
//                    posBackMsjSelected_X,
//                    posBackMsjSelected_Y - World.tamTiledY,
//                    posBackMsjSelected_X + loadMoveFreeEmpty.getWidth(),
//                    posBackMsjSelected_Y
//                            - World.tamTiledY
//                            + loadMoveFreeEmpty.getHeight()
//                            - (animationHold * (loadMoveFreeEmpty.getHeight() / 4)));
//        }
//
//    }
//
//    private int quantityBarForTime(int currentTime, int timeFinal) {
//        int quantity = 0;
//        quantity = ((timeFinal - currentTime) * 100) / timeFinal;
//
//        int add = ((quantity % 13) == 0) ? 0 : 1;
//        return (quantity / 13) + add;
//    }
//
//    private void paintTimeUnderConstr(Canvas canvas, int posTiled_X,
//            int posTiled_Y, String timeConstruction, int currentTime,
//            int timeFinal) {
//        int[] position = calculatePosInitialMap(posTiled_X, posTiled_Y);
//        int posBackMsjSelected_X = (position[0] + World.posWorldX)
//                + World.tamTiledX / 2;
//        int posBackMsjSelected_Y = (position[1] + World.posWorldY);
//
//        int posLoadingBar_X = posBackMsjSelected_X - loadingBarEmpty.getWidth()
//                / 2;
//        int posLoadingBar_Y = posBackMsjSelected_Y
//                - loadingBarEmpty.getHeight() / 2;
//
//        canvas.drawBitmap(loadingBarEmpty, posLoadingBar_X, posLoadingBar_Y,
//                null);
//
//        paintAnimationBarLoading(
//                canvas,
//                loadingBarFull,
//                posLoadingBar_X,
//                posLoadingBar_Y,
//                posLoadingBar_X
//                        + (quantityBarForTime(currentTime, timeFinal) * (loadingBarFull
//                                .getWidth() / 8)), posLoadingBar_Y
//                        + loadingBarFull.getHeight());
//
//        if (currentTime != 0) {
//            canvas.drawText(timeConstruction, posBackMsjSelected_X,
//                    posLoadingBar_Y - loadingBarEmpty.getHeight() / 2,
//                    fontAnimationQuantity);
//            canvas.drawBitmap(buttonBoost,
//                    posBackMsjSelected_X - buttonBoost.getWidth() / 2,
//                    posBackMsjSelected_Y + World.tamTiledY, null);
//            if (tutorialGame && stateGame == Constants.STATE_MAIN_GAME) {
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(
//                        canvas,
//                        posBackMsjSelected_X + buttonBoost.getWidth() / 2
//                                - cursorHand.getWidth() / 2,
//                        posBackMsjSelected_Y + World.tamTiledY
//                                + buttonBoost.getHeight() / 2
//                                - cursorHand.getHeight() / 3 + cursorY, -1);
//            }
//
//        } else {
//            canvas.drawText(texts[96], posBackMsjSelected_X, posLoadingBar_Y
//                    - loadingBarEmpty.getHeight() / 2, fontAnimationQuantity);
//            checkedAutomaticSmall.setPosX(posBackMsjSelected_X
//                    - checkedAutomaticSmall.getImage().getWidth() / 2);
//            checkedAutomaticSmall.setPosY(posBackMsjSelected_Y
//                    + World.tamTiledY);
//            checkedAutomaticSmall.paint(canvas);
//        }
//
//    }
//
//    private void Paint_Producing(Canvas canvas, int posTiled_X, int posTiled_Y,
//            String timeConstruction, int currentTime, int timeFinal) {
//        Log.d(TAG, "Paint_Producing");
//        int[] position = calculatePosInitialMap(posTiled_X, posTiled_Y);
//        int posBackMsjSelected_X = (position[0] + World.posWorldX)
//                + World.tamTiledX / 2;
//        int posBackMsjSelected_Y = (position[1] + World.posWorldY);
//
//        int posLoadingBar_X = posBackMsjSelected_X - loadingBarEmpty.getWidth()
//                / 2;
//        int posLoadingBar_Y = posBackMsjSelected_Y
//                - loadingBarEmpty.getHeight() / 2;
//
//        canvas.drawBitmap(loadingBarEmpty, posLoadingBar_X, posLoadingBar_Y,
//                null);
//
//        paintAnimationBarLoading(
//                canvas,
//                loadingBarFull,
//                posLoadingBar_X,
//                posLoadingBar_Y,
//                posLoadingBar_X
//                        + (quantityBarForTime(currentTime, timeFinal) * (loadingBarFull
//                                .getWidth() / 8)), posLoadingBar_Y
//                        + loadingBarFull.getHeight());
//
//        if (currentTime != 0) {
//            canvas.drawText(timeConstruction, posBackMsjSelected_X,
//                    posLoadingBar_Y - loadingBarEmpty.getHeight() / 2,
//                    fontAnimationQuantity);
//            canvas.drawBitmap(buttonBoost,
//                    posBackMsjSelected_X - buttonBoost.getWidth() / 2,
//                    posBackMsjSelected_Y + World.tamTiledY, null);
//
//            if (tutorialGame && stateGame == Constants.STATE_MAIN_GAME) {
//                itemToChoose = -1;
//                animationCursor = true;
//                paintAnimationCursor(
//                        canvas,
//                        posBackMsjSelected_X + buttonBoost.getWidth() / 2
//                                - cursorHand.getWidth() / 2,
//                        posBackMsjSelected_Y + World.tamTiledY
//                                + buttonBoost.getHeight() / 2
//                                - cursorHand.getHeight() / 3 + cursorY, -1);
//            }
//        } else {
//            /*
//             * canvas.drawText(texto[96], posBackMsjSelected_X, posLoadingBar_Y
//             * - loadingBarEmpty.getHeight()/2, fontAnimationQuantity);
//             * checkedAutomaticSmall.setPosX(posBackMsjSelected_X -
//             * checkedAutomaticSmall.getImage().getWidth()/2);
//             * checkedAutomaticSmall.setPosY(posBackMsjSelected_Y +
//             * Constants.Tam_Tiled_Y); checkedAutomaticSmall.paint(canvas);
//             */
//        }
//
//    }
//
//    private void paintMenuRotate(Canvas canvas, int posTiled_X, int posTiled_Y,
//            boolean canSaved, int classtype, int type) {
//
//        int[] position = calculatePosInitialMap(posTiled_X, posTiled_Y);
//        int posBackMsjSelected_X = (position[0] + World.posWorldX)
//                + World.tamTiledX / 2 - bgTooltip.getWidth() / 2;
//        int posBackMsjSelected_Y = (position[1] + World.posWorldY)
//                + World.tamTiledY;
//
//        canvas.drawBitmap(bgTooltip, posBackMsjSelected_X,
//                posBackMsjSelected_Y, null);
//
//        paintDivisionText(canvas, texts[69],
//                posBackMsjSelected_X + bgTooltip.getWidth() / 2,
//                posBackMsjSelected_Y + suggestionMsgTextOffsetY, 17, 16,
//                posBackMsjSelected_Y + 5, fontPaintMsjGame);
//
//        canvas.drawBitmap(
//                iconRotate,
//                posBackMsjSelected_X + bgTooltip.getWidth() / 4
//                        - iconRotate.getWidth() / 2, posBackMsjSelected_Y
//                        + suggestionMsgIconOffsetY, null);
//
//        if (canSaved) {
//            canvas.drawBitmap(iconSaveToStorage,
//                    posBackMsjSelected_X + (bgTooltip.getWidth() / 4) * 3
//                            - iconSaveToStorage.getWidth() / 2 - 10,
//                    posBackMsjSelected_Y + suggestionMsgIconOffsetY, null);
//        } else {
//            // FIXME enable this option
//            // canvas.drawBitmap(iconMoveDisabled,
//            // posBackMsjSelected_X + (bgTooltip.getWidth() / 4) * 3
//            // - iconSaveToStorage.getWidth() / 2 - 10,
//            // posBackMsjSelected_Y + suggestionMsgIconOffsetY, null);
//
//        }
//        paintObjectToMove(canvas, classtype, type);
//    }
//
//    private void paintObjectToMove(Canvas canvas, int classtype, int type) {
//        Log.d(TAG, "paintObjectToMove");
//        float sizeToReduce = 0.5f;
//        switch (classtype) {
//        case Constants.EARTH_DECORATION: // decorations
//            Log.d(BUGS_TAG, "paintObjectToMove -> EARTH_DECORATION");
//            type = decorationsPut[type].getType();
//            Bitmap iconCurrentDecoration = iconDecorations[type];
//            Matrix matrixnew = new Matrix();
//            matrixnew
//                    .setTranslate(
//                            mCanvasWidth
//                                    - ((int) (iconCurrentDecoration.getWidth() * sizeToReduce))
//                                    - 2,
//                            mCanvasHeight
//                                    - (((iconsMenuExpress[1].getImage()
//                                            .getHeight()) * 2) - 5)
//                                    + backgroundItemIcons.getHeight()
//                                    / 2
//                                    - (int) (iconCurrentDecoration.getHeight() * sizeToReduce)
//                                    / 2);
//
//            matrixnew.preScale(sizeToReduce, sizeToReduce);
//            canvas.drawBitmap(decorationsBg, matrixnew, null);
//            canvas.drawBitmap(iconCurrentDecoration, matrixnew, null);
//            // FIXME problematic
//            // paintButtonCloseSmall(canvas, sizeToReduce);
//            buttonCloseSmall.setPosX(mCanvasWidth
//                    - buttonCloseSmall.getImage().getWidth());
//            buttonCloseSmall.setPosY(mCanvasHeight
//                    - (((iconsMenuExpress[1].getImage().getHeight()) * 2) - 5)
//                    + backgroundItemIcons.getHeight() / 2
//                    - (int) (iconDecorations[type].getHeight() * sizeToReduce)
//                    / 2 - buttonCloseSmall.getImage().getHeight() / 2);
//            buttonCloseSmall.paint(canvas);
//
//            break;
//        case Constants.EARTH_CROPS: // crops:
//            type = tree[type].getType();
//            canvas.drawBitmap(backgroundItemIcons, mCanvasWidth
//                    - backgroundItemIcons.getWidth(), mCanvasHeight
//                    - (iconsMenuExpress[1].getImage().getHeight() * 2) - 5,
//                    null);
//
//            canvas.drawBitmap(
//                    iconCrops[type],
//                    mCanvasWidth - backgroundItemIcons.getWidth() / 2
//                            - iconCrops[type].getWidth() / 2,
//                    mCanvasHeight
//                            - ((iconsMenuExpress[1].getImage().getHeight() * 2) - 5)
//                            + backgroundItemIcons.getHeight() / 2
//                            - iconCrops[type].getHeight() / 2, null);
//
//            // paintButtonCloseSmall(canvas, sizeToReduce);
//            buttonCloseSmall.setPosX(mCanvasWidth
//                    - buttonCloseSmall.getImage().getWidth());
//            buttonCloseSmall.setPosY(mCanvasHeight
//                    - (iconsMenuExpress[1].getImage().getHeight() * 2) - 5
//                    - buttonCloseSmall.getImage().getHeight() / 2);
//            buttonCloseSmall.paint(canvas);
//            break;
//        case Constants.EARTH_BUILDING: // Building
//            //loadIconsBuildings();
//            type = buildingsPut[type].getType();
//            Matrix matrixnew2 = new Matrix();
//            matrixnew2
//                    .setTranslate(
//                            mCanvasWidth
//                                    - ((int) (iconBuilding[type].getWidth() * sizeToReduce))
//                                    - 2,
//                            mCanvasHeight
//                                    - (((iconsMenuExpress[1].getImage()
//                                            .getHeight()) * 2) - 5)
//                                    + backgroundItemIcons.getHeight()
//                                    / 2
//                                    - (int) (iconBuilding[type].getHeight() * sizeToReduce)
//                                    / 2);
//            matrixnew2.preScale(sizeToReduce, sizeToReduce);
//            canvas.drawBitmap(decorationsBg, matrixnew2, null);
//            canvas.drawBitmap(iconBuilding[type], matrixnew2, null);
//
//            // FIXME problematic
//            // paintButtonCloseSmall(canvas, sizeToReduce);
//            buttonCloseSmall.setPosX(mCanvasWidth
//                    - buttonCloseSmall.getImage().getWidth());
//            buttonCloseSmall.setPosY(mCanvasHeight
//                    - (((iconsMenuExpress[1].getImage().getHeight()) * 2) - 5)
//                    + backgroundItemIcons.getHeight() / 2
//                    - (int) (iconBuilding[type].getHeight() * sizeToReduce) / 2
//                    - buttonCloseSmall.getImage().getHeight() / 2);
//            buttonCloseSmall.paint(canvas);
//            break;
//        }
//    }
//
//    private void paintAnimationBarLoading(Canvas canvas, Bitmap image,
//            int posX, int posY, int width, int heigth) {
//
//        canvas.save();
//        canvas.translate(0, 0);
//        canvas.clipRect(posX, posY, width, heigth);
//        canvas.drawBitmap(image, posX, posY, null);
//        canvas.restore();
//    }
//
//    private void paintBarAction(Canvas canvas, int Pos_X, int Pos_Y) {
//
//        if (stateGame != Constants.STATE_MAIN_GAME)
//            return;
//        if (indexBarAccion < loadingBarFull.getWidth()) {
//            canvas.drawBitmap(loadingBarEmpty, Pos_X, Pos_Y, null);
//            paintAnimationBarLoading(canvas, loadingBarFull, Pos_X, Pos_Y,
//                    Pos_X + indexBarAccion, Pos_Y + loadingBarFull.getHeight());
//
//            if (System.currentTimeMillis() - Time_Animation_Bar >= 2) {
//                Time_Animation_Bar = System.currentTimeMillis();
//                indexBarAccion += 24;
//            }
//        } else {
//            indexBarAccion = 1;
//            doAction();
//            do {
//                if (currentMultitouch == indexMultitouch - 1) {
//                    currentMultitouch = -1;
//                    indexMultitouch = 0;
//                    msgSelect = null;
//
//                    if(stateGame == Constants.STATE_MAIN_GAME){
//                    	canShowInfoAutomatic();
//                    }
//
//                }
//
//                currentMultitouch++;
//            } while ((indexMultitouch > 0 && currentMultitouch > 0 && multitouch_X[currentMultitouch] == -1000));
//        }
//
//    }
//
//    private void canShowInfoAutomatic() {
//        Log.d(TAG, "canShowInfoAutomatic");
//        canShowInfoAuto = false;
//        if (actionSelect == null)
//            return;
//        if (typeActionAutomatic == actionSelect.ordinal()) {
//            return;
//        }
//        typeActionAutomatic = actionSelect.ordinal();
//        switch (actionSelect) {
//
//        case ANIMAL_FOOD:
//            for (int i = 0; i < nAnimalsPut; i++) {
//                for (int j = 0; j < animalsPut[i].getUpdgrade(); j++) {
//                    if (animalsPut[i].getStatus() == Constants.STATUS_ANIMALS_HUNGRY
//                            && quantitySeeds >= Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                                    .getType()][4]) {
//                        canShowInfoAuto = true;
//                        break;
//                    }
//                }
//            }
//            if (!canShowInfoAuto) {
//                actionSelect = null;
//            }
//            break;
//        case PLOW:
//            for (byte nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y; nTiledY++) {
//                for (byte nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//                    if (mapContaints[nTiledY][nTiledX] == Constants.EARTHBAD) {
//                        canShowInfoAuto = true;
//                        break;
//                    }
//                }
//            }
//
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].getTiled() == 8 && tree[i].getPosX() != -1000) {
//                    canShowInfoAuto = true;
//                    break;
//                }
//            }
//            if (tutorialGame) {
//                canShowInfoAuto = false;
//            }
//            break;
//        case PLANT:
//            for (byte nTiledY = 0; nTiledY < Constants.N_TILED_WORLD_Y; nTiledY++) {
//                for (byte nTiledX = 0; nTiledX < Constants.N_TILED_WORLD_X; nTiledX++) {
//                    if (mapContaints[nTiledY][nTiledX] == Constants.EARTHGOOD) {
//                        canShowInfoAuto = true;
//                        break;
//                    }
//                }
//            }
//            if (tutorialGame && stepInAuxTutorial == 0) {
//                canShowInfoAuto = false;
//            }
//            break;
//        case FERTILIZE:
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].getTiled() < 5) {
//                    canShowInfoAuto = true;
//                    break;
//                }
//            }
//            break;
//        case HARVEST:
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].getPosY() != -1000 && tree[i].getTiled() >= 5
//                        && tree[i].getTiled() < 8) {
//                    canShowInfoAuto = true;
//                    break;
//                }
//            }
//            if (tutorialGame && stepInAuxTutorial <= 2) {
//                canShowInfoAuto = false;
//            }
//            break;
//        case WATERING:
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].readyWatering) {
//                    canShowInfoAuto = true;
//                    break;
//                }
//            }
//            break;
//
//        }
//
//    }
//
//    private void doAction() {
//        int[] position = null;
//        
//        if (actionSelect == null)
//            return;
//
//        switch (actionSelect) {
//        case ANIMAL_FOOD:
//
//            for (int i = 0; i < nAnimalsPut; i++) {
//                if (animalsPut[i].getPos_X() == multitouch_X[currentMultitouch]
//                        && animalsPut[i].getPos_Y() == multitouch_Y[currentMultitouch]) {
//
//                    if (quantitySeeds
//                            - Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                                    .getType()][4] >= 0) {
//                        animalsPut[i]
//                                .setStatus(Constants.STATUS_ANIMALS_WORKING);
//                        animalsPut[i].setSelected(false);
//
//                        sound(mContext, 5);
//
//                        int[] posit = getTiledInAnimal(i, orderAnimalChosen);
//
//                        posit = calculatePosInitialMap(posit[0], posit[1]);
//
//                        assignQuantity(0, 0, 0,
//                                -Constants.PRODUCT_ANIMAL_INFO[animalsPut[i]
//                                        .getType()][4], 0, 0, 0, posit[0]
//                                        + World.posWorldX, posit[1]
//                                        + World.posWorldY);
//
//                        if (stepTutorial == Constants.STEP_TUTORIAL_WELL_DONE) {
//                            animalsPut[0]
//                                    .setStatus(Constants.STATUS_ANIMALS_READY);
//                            animalsPut[0].setProducing(false);
//                            animalsPut[0]
//                                    .setTimeTranscurrentProducing(Constants.PRODUCT_ANIMAL_INFO[animalsPut[0]
//                                            .getType()][3]);
//                            animalsPut[0].setSelected(false);
//                        }
//
//                        if (tutorialGame
//                                && stepTutorial < Constants.STEP_TUTORIAL_FIRST_EGG) {
//                            stepTutorial++;
//                        }
//                        dissapearMsj = false;
//                    } else {
//                        stateGame = Constants.STATE_NOFOOD;
//                        loadImages();
//                        if (tutorialGame) {
//                            stepTutorial++;
//                        }
//                    }
//                    break;
//                }
//            }
//            break;
//        case DECORATION:
//
//            int[] posAni = calculatePosInitialMap(
//                    multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch]);
//            int coinPay = 0;
//            int diamondsPay = 0;
//            if (Constants.DECORATIONS_INFO[itemSelected][7] == Constants.GOLD) {
//                coinPay = Constants.DECORATIONS_INFO[itemSelected][1];
//            } else {
//                diamondsPay = Constants.DECORATIONS_INFO[itemSelected][2];
//            }
//
//            if (isTransactionPossible(Constants.DIAMONDS, diamondsPay)
//                    && isTransactionPossible(Constants.GOLD, coinPay)) {
//                assignQuantity(0, 0, 0, 0, -diamondsPay, -coinPay,
//                        Constants.DECORATIONS_INFO[itemSelected][3], posAni[0]
//                                + World.posWorldX - World.tamTiledX / 2,
//                        posAni[1] + World.posWorldY - World.tamTiledY / 2);
//
//                mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = Constants.EARTH_DECORATION;
//                mapObjects[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = nDecorationsPut;
//
//                if (Constants.DECORATIONS_INFO[itemSelected][8] == 1) {
//                    mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = Constants.LIMBODECORATION;
//                    mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch] + 1] = Constants.LIMBODECORATION;
//                    mapContaints[multitouch_Y[currentMultitouch] + 1][multitouch_X[currentMultitouch] + 1] = Constants.LIMBODECORATION;
//                    mapContaints[multitouch_Y[currentMultitouch] + 1][multitouch_X[currentMultitouch]] = Constants.EARTH_DECORATION;
//                    mapObjects[multitouch_Y[currentMultitouch] + 1][multitouch_X[currentMultitouch]] = nDecorationsPut;
//                }
//
//                decorationsPut[nDecorationsPut] = new Decoration(
//                        multitouch_X[currentMultitouch],
//                        multitouch_Y[currentMultitouch], itemSelected);
//                restValueMission(Constants.MISSION_TYPE_DECO,
//                        decorationsPut[nDecorationsPut].getType());
//                nDecorationsPut++;
//
//                stateOnlyGreen = true;
//
//                typeMsgInfo = TypeMsgInfo.MOVE;
//                timeShowInfoBox = System.currentTimeMillis();
//
//            }
//
//            break;
//        case ANIMAL:
//            position = calculatePosInitialMap(multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch]);
//            int diamonds = 0;
//            int coins = 0;
//            if (Constants.ANIMAL_TYPE_PRICE[itemSelected][Constants.animalUsed[itemSelected]] == Constants.GOLD) {
//                coins = Constants.ANIMAL_PRICE[itemSelected][Constants.animalUsed[itemSelected]];
//            } else {
//                diamonds = Constants.ANIMAL_PRICE[itemSelected][Constants.animalUsed[itemSelected]];
//            }
//            if (isTransactionPossible(Constants.DIAMONDS, diamonds)
//                    && isTransactionPossible(Constants.GOLD, coins)) {
//                assignQuantity(0, 0, 0, 0, -diamonds, -coins, 0, position[0]
//                        + World.posWorldX, position[1] + World.posWorldY);
//            } else {
//                return;
//            }
//
//            if (!tutorialGame) {
//                typeMsgInfo = TypeMsgInfo.PUTANIMAL;
//                timeShowInfoBox = System.currentTimeMillis();
//            }
//            animalsPut[nAnimalsPut] = new Animal(
//                    multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch], itemSelected,
//                    animalBuildingOwner);
//            nAnimalsPut++;
//
//            Constants.animalUsed[itemSelected] += 1;
//            actionSelect = null;
//            msgSelect = null;
//            if (tutorialGame) {
//                if (stepTutorial != Constants.STEP_TUTORIAL_WELL_DONE) {
//                    stepTutorial++;
//                }
//            }
//
//            break;
//        case REMOVE_VEGETATION:
//            if (isTransactionPossible(Constants.GOLD, quantRemoVege)) {
//
//                quantityCoins -= quantRemoVege;
//                mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = Constants.EMPTY;
//                actionSelect = null;
//                msgSelect = null;
//
//                if (UtilSoftgames.random(0, 100) > 85) {
//                    showPaintDiamondsFound = true;
//                    diamondsFound = UtilSoftgames.random(1, 3);
//                    quantityDiamonds += diamondsFound;
//                    timeStorageCapacity = System.currentTimeMillis();
//                }
//                validateAchievements(Constants.ACHIEVEMENTS_VEGETATION, 1);
//                restValueMission(Constants.REMOVE_VEGETATIONS, 0);
//
//            }
//
//            break;
//        case PLOW:
//            int touchInX = multitouch_X[currentMultitouch];
//            int touchInY = multitouch_Y[currentMultitouch];
//
//            position = calculatePosInitialMap(touchInX, touchInY);
//            if (validateLimitPlow()
//                    && assignQuantity(0, 0, 0, 0, 0,
//                            Constants.ACTION_PLOW_COST, 1, position[0]
//                                    + World.posWorldX, position[1]
//                                    + World.posWorldY)) {
//                mapContaints[touchInY][touchInX] = Constants.EARTHGOOD;
//                restValueMission(Constants.PLOW, 0);
//                plowPlantWhitered();
//            }
//
//            sound(main, SoundUtil.SOUND_PLOW);
//
//            if (tutorialGame && stepTutorial < Constants.STEP_TUTORIAL_STORAGE) {
//
//                int value = 0;
//                int finalVerification = 6;
//                if (stepTutorial == Constants.STEP_TUTORIAL_PLOW_FIELDS) {
//                    finalVerification = 1;
//                }
//
//                if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                    finalVerification = 4;
//                    value = 3;
//                }
//
//                boolean plowComplete = true;
//
//                for (int i = 0; i < 6; i++) {
//                    if (posTiledTutorial[i][2] == value
//                            && posTiledTutorial[i][0] == tiledChosen[0][0]
//                            && posTiledTutorial[i][1] == tiledChosen[0][1]) {
//                        posTiledTutorial[i][2] = 1;
//
//                        if (i == 2) {
//                            dissapearMsj = true;
//                        }
//
//                        for (int t = 0; t < finalVerification; t++) {
//                            if (posTiledTutorial[t][2] == value) {
//                                plowComplete = false;
//                            }
//                        }
//
//                        if (plowComplete) {
//                            if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                                stepInAuxTutorial++;
//                            } else {
//                                if (stepTutorial != Constants.STEP_TUTORIAL_FREE && stepTutorial != Constants.STEP_TUTORIAL_PLACE_ON_YARD) {
//                                    stepTutorial++;
//                                }
//                                UtilSoftgames.setValuesForTransparent();
//                                timeShowIconMsgTuto = System
//                                        .currentTimeMillis();
//                                showIconMsgTuto = true;
//                                dissapearMsj = false;
//                            }
//
//                        }
//                        break;
//                    }
//                }
//
//            }
//
//            break;
//        case PLANT:
//            plantCrops(multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch], false);
//            if (tutorialGame) {
//                boolean plowComplete = true;
//                int finalVerification = 6;
//
//                if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                    finalVerification = 1;
//                }
//
//                for (int i = 0; i < finalVerification; i++) {
//                    if (posTiledTutorial[i][2] == 1
//                            && posTiledTutorial[i][0] == multitouch_X[currentMultitouch]
//                            && posTiledTutorial[i][1] == multitouch_Y[currentMultitouch]) {
//                        posTiledTutorial[i][2] = 2;
//                        if (i == 1) {
//                            dissapearMsj = true;
//                        }
//                        for (int t = 0; t < finalVerification; t++) {
//                            if (posTiledTutorial[t][2] == 1) {
//                                plowComplete = false;
//                            }
//                        }
//
//                        if (plowComplete) {
//                            if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                                stepInAuxTutorial++;
//                            } else {
//                                if (stepTutorial != Constants.STEP_TUTORIAL_FREE && stepTutorial != Constants.STEP_TUTORIAL_PLACE_ON_YARD) {
//                                    stepTutorial++;
//                                }
//
//                                UtilSoftgames.setValuesForTransparent();
//                                timeShowIconMsgTuto = System
//                                        .currentTimeMillis();
//                                showIconMsgTuto = true;
//                                dissapearMsj = false;
//                            }
//                        }
//                        break;
//                    }
//                }
//
//            }
//            sound(main, SoundUtil.SOUND_PLANT);
//            break;
//        case FERTILIZE:
//            if (isTransactionPossible(Constants.DIAMONDS, 1)) {
//                for (int i = 0; i < NTree; i++) {
//                    if (tree[i].getPosX() == multitouch_X[currentMultitouch]
//                            && tree[i].getPosY() == multitouch_Y[currentMultitouch]) {
//                        tree[i].setTiled(5);
//
//                        break;
//                    }
//                }
//                if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                    stepInAuxTutorial++;
//                }
//                assignQuantity(0, 0, 0, 0, -1, 0, 0, mCanvasWidth / 2,
//                        mCanvasHeight / 2);
//            }
//
//            break;
//        case WATERING:
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].getPosX() == multitouch_X[currentMultitouch]
//                        && tree[i].getPosY() == multitouch_Y[currentMultitouch]) {
//                    tree[i].animationReadyWatering = true;
//                    
//                    int[] positions = calculatePosInitialMap(
//                            multitouch_X[currentMultitouch],
//                            multitouch_Y[currentMultitouch]);
//                  
//                    assignQuantity(0, 0, 0, 0, 0, 0,  1,
//                    		positions[0] + World.posWorldX,
//                    		positions[1] + World.posWorldY);
//                    
//                    restValueMission(Constants.WATERING, 0);
//                    
//                    break;
//                }
//            }
//            break;
//        case HARVEST:
//            harvestPlant(multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch], false);
//            if (tutorialGame) {
//                boolean plowComplete = true;
//                int finalVerification = 6;
//                if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                    finalVerification = 1;
//
//                }
//                for (int i = 0; i < finalVerification; i++) {
//                    if (posTiledTutorial[i][2] == 2
//                            && posTiledTutorial[i][0] == multitouch_X[currentMultitouch]
//                            && posTiledTutorial[i][1] == multitouch_Y[currentMultitouch]) {
//                        posTiledTutorial[i][2] = 3;
//                        if (i == 1) {
//                            dissapearMsj = true;
//                        }
//                        for (int t = 0; t < finalVerification; t++) {
//                            if (posTiledTutorial[t][2] == 2) {
//                                plowComplete = false;
//                            }
//                        }
//
//                        if (plowComplete) {
//                            if (stepTutorial == Constants.STEP_TUTORIAL_MORE_WHEAT) {
//                                stepInAuxTutorial++;
//                            } else {
//                                if (stepTutorial != Constants.STEP_TUTORIAL_FREE && stepTutorial != Constants.STEP_TUTORIAL_PLACE_ON_YARD) {
//                                    stepTutorial++;
//                                }
//                                UtilSoftgames.setValuesForTransparent();
//                                timeShowIconMsgTuto = System
//                                        .currentTimeMillis();
//                                showIconMsgTuto = true;
//                                dissapearMsj = false;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//            sound(main, SoundUtil.SOUND_HARVEST);
//            break;
//        case BUILDING:
//            int[] posAnim = calculatePosInitialMap(
//                    multitouch_X[currentMultitouch],
//                    multitouch_Y[currentMultitouch]);
//
//            int buildingPriceInCoins = -Constants.BUILDING_PRICE[itemSelected][Constants.buildingUsed[itemSelected]];
//
//            if (isTransactionPossible(Constants.GOLD, buildingPriceInCoins)) {
//                assignQuantity(0, 0, 0, 0, 0, buildingPriceInCoins, 0,
//                        posAnim[0] + World.posWorldX - World.tamTiledX / 2,
//                        posAnim[1] + World.posWorldY - World.tamTiledY / 2);
//
//                boolean isFourSpace = false;
//                int classType = Constants.BUILDINGNORMAL;
//                if (Constants.BUILDING_TYPE_ORD[itemSelected] == Constants.ENCLOSURE_CHICKEN
//                        || Constants.BUILDING_TYPE_ORD[itemSelected] == Constants.ENCLOSURE_COW
//                        || Constants.BUILDING_TYPE_ORD[itemSelected] == Constants.ENCLOSURE_SHEEP
//                        || Constants.BUILDING_TYPE_ORD[itemSelected] == Constants.ENCLOSURE_GOAT
//                        || Constants.BUILDING_TYPE_ORD[itemSelected] == Constants.ENCLOSURE_PIG) {
//                    isFourSpace = true;
//                    classType = Constants.BUILDINGANIMAL;
//                }
//
//                Constants.buildingUsed[itemSelected] += 1;
//
//                buildingsPut[nBuildingsPut] = new Building(
//                        multitouch_X[currentMultitouch],
//                        multitouch_Y[currentMultitouch], itemSelected,
//                        classType, isFourSpace);
//
//                mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = Constants.EARTH_BUILDING;
//                mapObjects[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = nBuildingsPut;
//
//                if (isFourSpace) {
//                    mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] = Constants.LIMBOBUILDING;
//                    mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch] + 1] = Constants.LIMBOBUILDING;
//                    mapContaints[multitouch_Y[currentMultitouch] + 1][multitouch_X[currentMultitouch]] = Constants.EARTH_BUILDING;
//                    mapContaints[multitouch_Y[currentMultitouch] + 1][multitouch_X[currentMultitouch] + 1] = Constants.LIMBOBUILDING;
//                    // FIXME 2x2 buildings this code leads to a NPE
//                    mapObjects[multitouch_Y[currentMultitouch] + 1][multitouch_X[currentMultitouch]] = nBuildingsPut;
//                }
//
//                nBuildingsPut++;
//                sound(mContext, SoundUtil.SOUND_CONSTRUCTION_PLACED);
//                actionSelect = null;
//                msgSelect = null;
//
//                // TODO Make sure that the chicken house was put in the map
//                if (tutorialGame) {
//                    // stepTutorial++;
//                    // TODO finish this solution for the tutorial
//                    boolean isChickenHousePut = false;
//                    for (int i = 0; i < nBuildingsPut; i++) {
//                        // Chicken enclosure has type == 0
//                        if (buildingsPut[i].getType() == Constants.ENCLOSURE_CHICKEN_TYPE) {
//                            isChickenHousePut = true;
//                        }
//                    }
//                    if (isChickenHousePut) {
//                        stepTutorial++;
//                    }
//                }
//                stateOnlyGreen = false;
//            }
//            break;
//        case SAVEDECORATION:
//            try {
//
//                if (totalQuantityStorage + 1 <= maxItemStorage) {
//                    mapContaints[decorationsPut[decorationChosen].getPos_Y()][decorationsPut[decorationChosen]
//                            .getPos_X()] = Constants.EMPTY;
//                    Log.d(BUGS_TAG, "itemSelected: " + itemSelected);
//                    if (Constants.DECORATIONS_INFO[itemSelected][8] == 1) {
//                        mapContaints[decorationsPut[decorationChosen]
//                                .getPos_Y()][decorationsPut[decorationChosen]
//                                .getPos_X() + 1] = Constants.EMPTY;
//                        mapContaints[decorationsPut[decorationChosen]
//                                .getPos_Y() + 1][decorationsPut[decorationChosen]
//                                .getPos_X() + 1] = Constants.EMPTY;
//                        mapContaints[decorationsPut[decorationChosen]
//                                .getPos_Y() + 1][decorationsPut[decorationChosen]
//                                .getPos_X()] = Constants.EMPTY;
//                    }
//
//                    decorationsPut[decorationChosen].setPos_X(-1000);
//                    decorationsPut[decorationChosen].setPos_Y(-1000);
//                    assignStorage(Constants.STORAGE_DECORATION, 1,
//                            decorationsPut[decorationChosen].getType());
//                } else {
//                    storageFull = true;
//                    stateGame = Constants.STATE_POP_STORAGE_FULL;
//                    /*
//                     * typeMsjInfo = TypeMsjInfo.STORAGEFULL;
//                     * timeShowInfoStorageFull = System.currentTimeMillis();
//                     */
//                }
//
//            } catch (Exception e) {
//                Log.e(TAG, "Error saving decoration", e);
//            }
//            actionSelect = null;
//            break;
//        case SAVEANIMAL:
//
//            break;
//        case SAVEBUILDING:
//            if (totalQuantityStorage + 1 <= maxItemStorage) {
//
//                assignStorage(Constants.STORAGE_BUILDING, 1,
//                        buildingsPut[buildingChosen].getType());
//
//                buildingsSaveStorage[indexBuildSaveStorage] = new Building(
//                        buildingsPut[buildingChosen].getPosX(),
//                        buildingsPut[buildingChosen].getPosY(),
//                        buildingsPut[buildingChosen].getType(),
//                        buildingsPut[buildingChosen].getClassType(),
//                        buildingsPut[buildingChosen].isFourSpace());
//
//                for (int j = 0; j < 5; j++) {
//                    buildingsSaveStorage[indexBuildSaveStorage].setSlot(
//                            buildingsPut[buildingChosen].getSlot()[j], j);
//                    buildingsSaveStorage[indexBuildSaveStorage]
//                            .setItemProducing(buildingsPut[buildingChosen]
//                                    .getItemProducing()[j], j);
//                    buildingsSaveStorage[indexBuildSaveStorage]
//                            .setTimeProductsInSlot(buildingsPut[buildingChosen]
//                                    .getTimeProductsInSlot()[j], j);
//                }
//
//                buildingsSaveStorage[indexBuildSaveStorage]
//                        .setUpdgrade(buildingsPut[buildingChosen].getUpdgrade());
//
//                buildingsSaveStorage[indexBuildSaveStorage]
//                        .setReady(buildingsPut[buildingChosen].isReady());
//                buildingsSaveStorage[indexBuildSaveStorage]
//                        .setFlip(buildingsPut[buildingChosen].isFlip());
//                buildingsSaveStorage[indexBuildSaveStorage]
//                        .setShowTimeUnderConstruction(buildingsPut[buildingChosen]
//                                .isShowTimeUnderConstruction());
//                buildingsSaveStorage[indexBuildSaveStorage]
//                        .setTimeUnderConstruct(buildingsPut[buildingChosen]
//                                .getTimeUnderConstruct());
//                buildingsSaveStorage[indexBuildSaveStorage]
//                        .setCurrentSlotActive(buildingsPut[buildingChosen]
//                                .getCurrentSlotActive());
//
//                indexBuildSaveStorage++;
//                mapContaints[buildingsPut[buildingChosen].getPosY()][buildingsPut[buildingChosen]
//                        .getPosX()] = Constants.EMPTY;
//                mapObjects[buildingsPut[buildingChosen].getPosY()][buildingsPut[buildingChosen]
//                        .getPosX()] = Constants.EMPTY;
//                buildingsPut[buildingChosen].setPosX(-1000);
//                buildingsPut[buildingChosen].setPosY(-1000);
//
//            } else {
//                storageFull = true;
//                stateGame = Constants.STATE_POP_STORAGE_FULL;
//                // typeMsjInfo = TypeMsjInfo.STORAGEFULL;
//                // timeShowInfoStorageFull = System.currentTimeMillis();
//            }
//            actionSelect = null;
//            break;
//        }
//
//    }
//
//    private boolean validateLimitPlow() {
//        Log.d(TAG, "validateLimitPlow");
//        if (quantityPlots + 1 > limitTotalPlots
//                && mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] == Constants.EMPTY) {
//            stateGame = Constants.STATE_POP_PLOW_FULL;
//            return false;
//        }
//
//        if (mapContaints[multitouch_Y[currentMultitouch]][multitouch_X[currentMultitouch]] == Constants.EMPTY) {
//            quantityPlots++;
//        }
//        return true;
//    }
//
//    private void harvestPlant(int posX, int posY, boolean recolectAll) {
//        Log.d(TAG, "harvestPlant");
//
//        boolean canRecolect = false;
//        int masteredWin = 0;
//        int expWin = 0;
//
//        for (int i = 0; i < NTree; i++) {
//            canRecolect = false;
//
//            if (!isStorageFull()) {
//                if (recolectAll) {
//                    if (tree[i].isReady()) {
//                        canRecolect = true;
//                        masteredWin += 2;
//                        expWin += 1;
//
//                    }
//                } else if (tree[i].getPosX() == posX
//                        && tree[i].getPosY() == posY && tree[i].isReady()) {
//                    canRecolect = true;
//                }
//            }
//
//            if (canRecolect) {
//                Constants.TreeQuantity[tree[i].getType()] += 2;
//                winMastered(tree[i].getType());
//
//                assignStorage(Constants.STORAGE_CROPS, 1, tree[i].getType());
//                restValueMission(Constants.MISSION_TYPE_CROPS,
//                        tree[i].getType());
//                if (storageFull && expWin > 0) {
//                    // When storage is full the expWin counter is one unit ahead
//                    // the actual value
//                    assignQuantity(masteredWin, 0, 0, 0, 0, 0, expWin - 1,
//                            mCanvasWidth / 2, mCanvasHeight / 2);
//                    return;
//                }
//
//                int typeCollection = 0;
//                int posCollection = 0;
//                int percentageCollection = 0;
//                int random = UtilSoftgames.random(0, 100);
//                if (random < 7) {
//                    posCollection = 1;
//                } else if (random < 18) {
//                    posCollection = 2;
//                } else if (random < 34) {
//                    posCollection = 3;
//                } else if (random < 65) {
//                    posCollection = 4;
//                } else if (random >= 65) {
//                    posCollection = 5;
//                }
//
//                switch (tree[i].getType()) {
//                case Constants.WHEAT:
//                case Constants.RYE:
//                case Constants.SORGHUM:
//                    typeCollection = Constants.COLLECTION_GOOD_START;
//                    percentageCollection = 1;
//                    break;
//                case Constants.CORN:
//                case Constants.VANILLA:
//                case Constants.HANF:
//                    typeCollection = Constants.COLLECTION_FRESH_JUICY;
//                    percentageCollection = 4;
//                    break;
//                case Constants.SUGAR_CANE:
//                case Constants.ONIONS:
//                case Constants.COTTON_PLANT:
//                    typeCollection = Constants.COLLECTION_FLOWER_DAY;
//                    percentageCollection = 4;
//                    break;
//                case Constants.STRAWBERRY:
//                case Constants.BLUEBERRY:
//                case Constants.CACAO:
//                    typeCollection = Constants.COLLECTION_EXOTIC_DAY;
//                    percentageCollection = 4;
//                    break;
//                case Constants.TOMATOES:
//                case Constants.POTATOES:
//                    typeCollection = Constants.COLLECTION_ALL_MINE;
//                    percentageCollection = 5;
//                    break;
//
//                case Constants.APPLE:
//                case Constants.ORANGE:
//                case Constants.LEMON:
//                    typeCollection = Constants.COLLECTION_TREE_COLL;
//                    percentageCollection = 9;
//                    break;
//                }
//
//                putCollection(tree[i].getPosX(), tree[i].getPosY(), typeCollection, posCollection,
//                        canPutCollection(percentageCollection));
//
//                validateAchievements(Constants.ACHIEVEMENTS_CROPS, 1);
//                if (tree[i].getType() != Constants.APPLE
//                        && tree[i].getType() != Constants.ORANGE
//                        && tree[i].getType() != Constants.LEMON) {
//                    mapContaints[tree[i].getPosY()][tree[i].getPosX()] = Constants.EARTHBAD;
//                    tree[i].died();
//                } else {
//                    tree[i].setTiled(1);
//                    tree[i].setReady(false);
//                    tree[i].timeWatering = 120;
//                    tree[i].setTimeTranscurrent(0);
//                }
//                if (!recolectAll) {
//                    int[] position = calculatePosInitialMap(posX, posY);
//                    assignQuantity(2, 0, 0, 0, 0, 0, 1, position[0]
//                            + World.posWorldX, position[1] + World.posWorldY);
//                    break;
//                }
//            }
//        }
//
//        if (recolectAll && !isStorageFull()) {
//            assignQuantity(masteredWin, 0, 0, 0, 0, 0, expWin,
//                    mCanvasWidth / 2, mCanvasHeight / 2);
//
//        }
//    }
//
//    private void collectionForAnimal(int typeBuilding, int posBuilding_X,
//            int posBuilding_Y) {
//        Log.d(TAG, "collectionForAnimal");
//        int typeCollection = 0;
//        int posCollection = 0;
//        int percentageCollection = 0;
//        int random = UtilSoftgames.random(0, 100);
//        if (random < 7) {
//            posCollection = 1;
//        } else if (random < 18) {
//            posCollection = 2;
//        } else if (random < 34) {
//            posCollection = 3;
//        } else if (random < 65) {
//            posCollection = 4;
//        } else if (random >= 65) {
//            posCollection = 5;
//        }
//
//        switch (typeBuilding) {
//        case Constants.ANIMAL_COW:
//        case Constants.ANIMAL_CHICKEN:
//        case Constants.ANIMAL_SHEEP:
//            typeCollection = Constants.COLLECTION_ANIMAL_FARM;
//            percentageCollection = 15;
//            break;
//        case Constants.ANIMAL_PIG:
//        case Constants.ANIMAL_GOAT:
//            typeCollection = Constants.COLLECTION_ANIMAL_FARM_2;
//            percentageCollection = 20;
//            break;
//
//        }
//
//        putCollection(posBuilding_X, posBuilding_Y, typeCollection, posCollection,
//                canPutCollection(percentageCollection));
//
//    }
//
//    private void collectionForBuilding(int typeBuilding, int posBuilding_X,
//            int posBuilding_Y) {
//        Log.d(TAG, "collectionForBuilding");
//        int typeCollection = 0;
//        int posCollection = 0;
//        int percentageCollection = 0;
//        int random = UtilSoftgames.random(0, 100);
//        if (random < 7) {
//            posCollection = 1;
//        } else if (random < 18) {
//            posCollection = 2;
//        } else if (random < 34) {
//            posCollection = 3;
//        } else if (random < 65) {
//            posCollection = 4;
//        } else if (random >= 65) {
//            posCollection = 5;
//        }
//
//        switch (typeBuilding) {
//        case Constants.WIND_MILL:
//            typeCollection = Constants.COLLECTION_CATS_MICE;
//            percentageCollection = 22;
//            break;
//        case Constants.BAKERY:
//            typeCollection = Constants.COLLECTION_BAKERY_STORY;
//            percentageCollection = 33;
//            break;
//        case Constants.CAKE:
//            typeCollection = Constants.COLLECTION_YUMMY_CAKES;
//            percentageCollection = 1;
//            break;
//        case Constants.DAIRY:
//            typeCollection = Constants.COLLECTION_GOT_MILK;
//            percentageCollection = 25;
//            break;
//        case Constants.FRUIT_SMASHER:
//            typeCollection = Constants.COLLECTION_YUMMY_JAM;
//            percentageCollection = 100;
//            break;
//        case Constants.SUGAR_FACTORY:
//            typeCollection = Constants.COLLECTION_SWEET_SUGAR;
//            percentageCollection = 15;
//            break;
//        case Constants.GRILL:
//            typeCollection = Constants.COLLECTION_HAM_MEAT;
//            percentageCollection = 15;
//            break;
//        case Constants.RESTAURANT:
//            typeCollection = Constants.COLLECTION_RESTAURANT_STORY;
//            percentageCollection = 20;
//            break;
//        case Constants.WEAVING_BUILDING:
//            typeCollection = Constants.COLLECTION_NICE_NEEDLES;
//            percentageCollection = 50;
//            break;
//        case Constants.TAILOR:
//            typeCollection = Constants.COLLECTION_NICE_SOFT;
//            percentageCollection = 50;
//            break;
//        case Constants.FEED_MILL:
//            typeCollection = Constants.COLLECTION_LETS_CREATE;
//            percentageCollection = 50;
//            break;
//        }
//
//        putCollection(posBuilding_X, posBuilding_Y, typeCollection, posCollection,
//                canPutCollection(percentageCollection));
//
//    }
//
//    private boolean canPutCollection(int percentage) {
//        boolean can = false;
//        int random = UtilSoftgames.random(0, 90);
//        if (random <= percentage) {
//            can = true;
//        }
//        return can;
//    }
//
//    private void plantCrops(int posX, int posY, boolean isAutomatic) {
//        
//        if (stateOnlyGreen) {
//            return;
//        }
//        
//        boolean canPay = false;
//        if (itemSelected == -1)
//            return;
//
//        if (mapContaints[posY][posX] != Constants.EARTHGOOD) {
//            return;
//        }
//
//        if (!isAutomatic) {
//            int costInDiamonds = Constants.CROPS_DIAMONDS_TO_PAY[Constants.CROPS_ORD[itemSelected]];
//            int costInCoins = Constants.CROPS_COINS_TO_PAY[Constants.CROPS_ORD[itemSelected]];
//
//            if (isTransactionPossible(Constants.GOLD, costInCoins)
//                    && isTransactionPossible(Constants.DIAMONDS, costInDiamonds)) {
//                int diamonds = -costInDiamonds;
//                int coins = -costInCoins;
//                int[] position = calculatePosInitialMap(
//                        multitouch_X[currentMultitouch],
//                        multitouch_Y[currentMultitouch]);
//                if (itemSelected != -1) {
//                    Constants.TreeQuantity[Constants.CROPS_ORD[itemSelected]] += 1;
//                    winMastered(Constants.CROPS_ORD[itemSelected]);
//                }
//                canPay = assignQuantity(1, 0, 0, 0, diamonds, coins, 0,
//                        position[0] + World.posWorldX, position[1]
//                                + World.posWorldY);
//            }
//
//        } else {
//            canPay = true;
//        }
//
//        if (canPay && itemSelected != -1) {
//        	int posFree = getPosFreeCrops();
//        	
//        	if(posFree == -1){
//        		try {
//        			tree[NTree] = new Crop(Constants.CROPS_ORD[itemSelected], posX,
//                        posY);
//        		} catch (Exception e) {
//        			// TODO: sometimes a exception is thrown here
//        			Log.e(TAG, "plantCrops() -> itemSelected: " + itemSelected, e);
//        		}
//
//        		tree[NTree].setId(60 + itemSelected);
//        		mapContaints[posY][posX] = Constants.EARTH_CROPS;
//        		mapObjects[posY][posX] = NTree;
//        		NTree++;
//        	} else {
//        		try {
//        			tree[posFree] = new Crop(Constants.CROPS_ORD[itemSelected], posX, posY);
//        		} catch (Exception e) {
//        		}
//
//        		tree[posFree].setId(60 + itemSelected);
//        		mapContaints[posY][posX] = Constants.EARTH_CROPS;
//        		mapObjects[posY][posX] = posFree;
//        		
//        	}
//        }
//    }
//    
//    private int getPosFreeCrops(){
//    	int pos = -1;
//    	for(int i = 0; i < NTree; i++){
//    		if(tree[i].getPosX() == -1000){
//    			pos = i;
//    			break;
//    		}
//    	}
//    	
//    	return pos;
//    }
//
//    private void plowPlantWhitered() {
//        if (stateOnlyGreen) {
//            return;
//        }
//        int posX = multitouch_X[currentMultitouch];
//        int posY = multitouch_Y[currentMultitouch];
//        for (int i = 0; i < NTree; i++) {
//            if ((tree[i].getPosX() == posX && tree[i].getPosY() == posY && tree[i]
//                    .isWhitered())) {
//                tree[i].died();
//                break;
//            }
//        }
//
//    }
//
//    private void assignStorage(int typeItem, int quantity,
//            int typeStorageProduct) {
//
//        boolean foundInStorage = false;
//        int posFound = 0;
//        for (int i = 0; i < indexStorage; i++) {
//            if (itemStorage[i][0] == typeItem
//                    && itemStorage[i][1] == typeStorageProduct) {
//                foundInStorage = true;
//                posFound = i;
//                break;
//            }
//        }
//
//        if (isStorageFull(quantity)) {
//            return;
//        }
//
//        totalQuantityStorage += quantity;
//
//        /*if (typeItem == Constants.STORAGE_CROPS) {
//            cropsQuantityRecolect[typeStorageProduct] += quantity;
//        }*/
//
//        if (foundInStorage) {
//            itemStorage[posFound][0] = typeItem;
//            itemStorage[posFound][1] = typeStorageProduct;
//            itemStorage[posFound][2] += quantity;
//        } else {
//            itemStorage[indexStorage][0] = typeItem;
//            itemStorage[indexStorage][1] = typeStorageProduct;
//            itemStorage[indexStorage][2] += quantity;
//            indexStorage++;
//        }
//
//        if (typeItem == Constants.STORAGE_CROPS
//                || typeItem == Constants.STORAGE_PRODUCTS) {
//            validateMission();
//            if (/*chosenOptionQuestTruck && aceptQuestTruck
//                    && */getQuantityProductInStorage(typeQuest) >= quantityQuest) {
//                canRewardQuestTruck = true;
//            } else {
//                canRewardQuestTruck = false;
//            }
//        }
//
//        timeStorageCapacity = System.currentTimeMillis();
//        showPaintStorageCapacity = true;
//
//    }
//
//    private boolean isStorageFull(int quantity) {
//        if (totalQuantityStorage + quantity > maxItemStorage) {
//        	storageFull = true;
//            stateGame = Constants.STATE_POP_STORAGE_FULL;
//            return true;
//        } else
//            return false;
//    }
//
//    private boolean isStorageFull() {
//        if (totalQuantityStorage >= maxItemStorage) {
//            stateGame = Constants.STATE_POP_STORAGE_FULL;
//            return true;
//        } else
//            return false;
//    }
//
//    private int getAddCoinsByFriends(int coins) {
//        int addCoins = 0;
//        if (coins > 0) {
//            int percent = (int) (totalfriends * .5);
//            if (percent > 20) {
//                percent = 20;
//            }
//            addCoins = (coins * percent) / 100;
//        }
//        return addCoins;
//    }
//
//    // FIXME itemSelected works for plowing but not for collecting
//    private void winMastered(int type) {
//       // Log.d(TAG, "winMastered");
//        int levelCrops = Constants.CROPS_QUANTITY_LEVELS[type];
//        if (levelCrops < 5 && Constants.TreeQuantity[type] > Constants.NEED_MASTER_FLOWER_TREE[levelCrops]) {
//            typeCropsMastered = type;
//            int coins = 0;
//            int diamonds = 0;
//            if (Constants.rewardsMastered[Constants.CROPS_QUANTITY_LEVELS[type]][1] == Constants.GOLD) {
//                coins = Constants.rewardsMastered[Constants.CROPS_QUANTITY_LEVELS[type]][0];
//            } else {
//                diamonds = Constants.rewardsMastered[Constants.CROPS_QUANTITY_LEVELS[type]][0];
//            }
//            assignQuantity(
//                    0,
//                    0,
//                    0,
//                    0,
//                    diamonds,
//                    coins,
//                    Constants.rewardsMastered[Constants.CROPS_QUANTITY_LEVELS[type]][2],
//                    mCanvasWidth / 2, mCanvasHeight / 2);
//            Constants.CROPS_QUANTITY_LEVELS[type] += 1;
//
//            if (Constants.CROPS_QUANTITY_LEVELS[type] > 5) {
//                Constants.CROPS_QUANTITY_LEVELS[type] -= 1;
//                return;
//            }
//            // rewardsMastered premio
//            stateGame = Constants.STATE_WIN_MASTERED;
//
//        }
//    }
//
//    protected boolean assignQuantity(int masteredCrops, int productAnimal,
//            int iconProduce, int food, int diamonds, int coins, int exp,
//            int posAnimation_X, int posAnimation_Y) {
//
//        if (quantityCoins + coins < 0) {
//            // go to market money
//            return false;
//        } else if (quantityDiamonds + diamonds < 0) {
//            // go to market diamonds
//            return false;
//        }
//
//        int addCoins = 0;
//        if (coins > 0) {
//            validateAchievements(Constants.ACHIEVEMENTS_COINS, coins);
//            addCoins = getAddCoinsByFriends(coins);
//            for (int i = 0; i < coins + addCoins; i++) {
//                restValueMission(Constants.GET_GOLD, 0);
//            }
//        }
//        addCoins = 0;// buque;
//        showProductAnimal = productAnimal;
//        showIconProduce = iconProduce;
//        showCoins = coins + addCoins;
//        showDiamonds = diamonds;
//        showFood = food;
//
//        showExp = exp;
//        quantityExp += exp;
//        // }
//
//        showMastered = masteredCrops;
//        posAnimationQuantity_X = posAnimation_X + World.tamTiledX / 2;
//        posAnimationQuantity_Y = posAnimation_Y + World.tamTiledY / 2;
//        quantityDiamonds += diamonds;
//        quantityCoins += coins + addCoins;
//
//        if (coins > 0) {
//            sound(main, SoundUtil.SOUND_EARNED_GOLD);
//        }
//
//        if (diamonds > 0) {
//            sound(main, SoundUtil.SOUND_EARNED_DIAMONDS);
//        }
//
//        if (exp >= 1) {
//            sound(main, SoundUtil.SOUND_EARNED_XP);
//        }
//
//        try {
//            logFlurryEventCurrency(quantityDiamonds, quantityCoins);
//        } catch (Exception e) {
//            Log.e(TAG, "Error logging flurry event");
//        }
//
//        quantitySeeds += food;
//        validateLevelUp();
//        animationQuantity = true;
//        animationQuantityTime = System.currentTimeMillis();
//        return true;
//    }
//
//    private void logFlurryEventCurrency(int quantityDiamonds, int quantityCoins) {
//        if (isBetween(quantityDiamonds, 200, 500)) {
//            FlurryAgent.logEvent("USER_REACHED_DIAMONDS_200");
//        } else if (isBetween(quantityDiamonds, 500, 1000)) {
//            FlurryAgent.logEvent("USER_REACHED_DIAMONDS_500");
//        } else if (quantityDiamonds > 1000) {
//            FlurryAgent.logEvent("USER_REACHED_DIAMONDS_1000");
//        }
//
//        if (isBetween(quantityCoins, 1000, 5000)) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_1000");
//        } else if (isBetween(quantityCoins, 5000, 10000)) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_5000");
//        } else if (isBetween(quantityCoins, 10000, 20000)) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_10000");
//        } else if (isBetween(quantityCoins, 20000, 30000)) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_20000");
//        } else if (isBetween(quantityCoins, 30000, 40000)) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_30000");
//        } else if (isBetween(quantityCoins, 30000, 40000)) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_40000");
//        } else if (quantityCoins > 50000) {
//            FlurryAgent.logEvent("USER_REACHED_COINS_50000");
//        }
//    }
//
//    private boolean isBetween(int value, int floor, int ceil) {
//        if (value >= floor && value < ceil) {
//            return true;
//        }
//        return false;
//    }
//
//    protected void validateLevelUp() {
//
//        if (!errorGame && (quantityExp % 100 == 0)) {
//            saveGame();
//        }
//
//        if (quantityExp >= Constants.LEVELS_WIN[nLevel]) {
//
//            if (!errorGame && !tutorialGame) {
//                saveGame();
//            }
//
//            if (nLevel < 70) {
//                quantityExp = quantityExp - Constants.LEVELS_WIN[nLevel];
//                nLevel++;
//                FlurryAgent.logEvent("USER_REACHED_LEVEL_" + nLevel);
//                sound(mContext, 2);
//                quantityDiamonds += 1;
//                restValueMission(Constants.NEXT_LEVEL, 0);
//                if (Utility.mFacebook == null) {
//                    Utility.mFacebook = new Facebook(Constants.APP_ID);
//                    Utility.mAsyncRunner = new AsyncFacebookRunner(
//                            Utility.mFacebook);
//                }
//
//                backup_StateGame = stateGame;
//                stateGame = Constants.STATE_LEVEL_UP;
//                // loadImages();
//                if (tutorialGame) {
//                    animationCursor = true;
//                    itemToChoose = -1;
//                }
//                indexIconAux = 0;
//
//                // Let's make sure the icons for the building are loaded
//                //loadIconsBuildings();
//
//                for (int i = 0; i < iconCrops.length; i++) {
//                    if ((nLevel + 1) == Constants.CROPS_AVAILABLE[i]) {
//                        iconAuxLevelUp[indexIconAux] = iconCrops[i];
//                        nameAuxLevelUp[indexIconAux] = texts[Constants.CROPS_NAME[Constants.CROPS_ORD[i]]];
//                        indexIconAux++;
//                    }
//                    if (indexIconAux >= 3) {
//                        break;
//                    }
//                }
//
//                String sTypeUpgrade = "";
//                for (int currentIconBuilding = 0; currentIconBuilding < iconBuilding.length; currentIconBuilding++) {
//                    // Let's check if there is a second or third instance
//                    // available for this building
//                    for (int nextAvailable = 0; nextAvailable < 3; nextAvailable++) {
//                        if (indexIconAux < 3
//                                && (nLevel + 1) == Constants.BUILDING_AVAILABLE[currentIconBuilding][nextAvailable]) {
//                            iconAuxLevelUp[indexIconAux] = UtilSoftgames
//                                    .resizeBitmap(
//                                            iconBuilding[currentIconBuilding],
//                                            (int) (iconBuilding[currentIconBuilding]
//                                                    .getWidth() * 0.5),
//                                            (int) (iconBuilding[currentIconBuilding]
//                                                    .getHeight() * 0.5));
//                            nameAuxLevelUp[indexIconAux] = texts[Constants.BUILDING_NAME[currentIconBuilding]];
//                            if (nextAvailable == 0) {
//                                sTypeUpgrade = "New";
//                            }
//                            if (nextAvailable > 0) {
//                                sTypeUpgrade = (nextAvailable == 1) ? "2nd"
//                                        : "3rd";
//                                nameAuxLevelUp[indexIconAux] += " "
//                                        + sTypeUpgrade;
//                            }
//
//                            indexIconAux++;
//                        }
//                    }
//
//                    if (indexIconAux >= 3) {
//                        break;
//                    }
//                }
//
//                for (int i = 0; i < iconDecorations.length; i++) {
//                    if (indexIconAux < 3
//                            && (nLevel + 1) == Constants.DECORATIONS_INFO[i][0]) {
//                        iconAuxLevelUp[indexIconAux] = UtilSoftgames
//                                .resizeBitmap(
//                                        iconDecorations[i],
//                                        (int) (iconDecorations[i].getWidth() * 0.5),
//                                        (int) (iconDecorations[i].getHeight() * 0.5));
//                        nameAuxLevelUp[indexIconAux] = texts[Constants.DECORATIONS_INFO[i][5]];
//                        indexIconAux++;
//                    }
//                    if (indexIconAux >= 3) {
//                        break;
//                    }
//                }
//
//                // Let's check if there is an upgrade available for this
//                // building
//                int nUpgrade = 4;
//                for (int currentBuilding = 0; currentBuilding < Constants.BUILDING_NEED_UPGRADE.length; currentBuilding += nUpgrade) {
//                    if (currentBuilding >= 40) {
//                        nUpgrade = 5;
//                    }
//                    for (int currentUpgrade = 0; currentUpgrade < nUpgrade; currentUpgrade++) {
//                        if (indexIconAux < 3
//                                && (nLevel + 1) == Constants.BUILDING_NEED_UPGRADE[currentBuilding
//                                        + currentUpgrade][4]) {
//
//                            int[] buildingAttr = getBuildingAttrByNeedUpgradeIndex(currentBuilding);
//
//                        Bitmap iconBuildingUpgraded = getBuildingImage(
//                                    buildingAttr[0], currentUpgrade, true);
//
//                            iconAuxLevelUp[indexIconAux] = UtilSoftgames
//                                    .resizeBitmap(iconBuildingUpgraded,
//                                            (int) (iconBuildingUpgraded
//                                                    .getWidth() * 0.5),
//                                            (int) (iconBuildingUpgraded
//                                                    .getHeight() * 0.5));
//
//                            nameAuxLevelUp[indexIconAux] = texts[buildingAttr[1]];
//                            sTypeUpgrade = "Upgrade " + (currentUpgrade + 1);
//                            nameAuxLevelUp[indexIconAux] += " " + sTypeUpgrade;
//
//                            indexIconAux++;
//                        }
//                    }
//
//                    if (indexIconAux >= 3) {
//                        break;
//                    }
//
//                }
//
//                loadImages();
//
//            }
//        }
//    }
//
//    private int[] getBuildingAttrByNeedUpgradeIndex(int key) {
//        int[] sValue = new int[2];
//        if (key >= 0) {
//            sValue[0] = Constants.BAKERY;
//            sValue[1] = 196;
//        }
//        if (key >= 4) {
//            sValue[0] = Constants.CAKE;
//            sValue[1] = 200;
//        }
//        if (key >= 8) {
//            sValue[0] = Constants.DAIRY;
//            sValue[1] = 201;
//        }
//        if (key >= 12) {
//            sValue[0] = Constants.FRUIT_SMASHER;
//            sValue[1] = 203;
//        }
//        if (key >= 16) {
//            sValue[0] = Constants.SUGAR_FACTORY;
//            sValue[1] = 204;
//        }
//        if (key >= 20) {
//            sValue[0] = Constants.GRILL;
//            sValue[1] = 205;
//        }
//        if (key >= 24) {
//            sValue[0] = Constants.RESTAURANT;
//            sValue[1] = 206;
//        }
//        if (key >= 28) {
//            sValue[0] = Constants.WEAVING_BUILDING;
//            sValue[1] = 207;
//        }
//        if (key >= 32) {
//            sValue[0] = Constants.TAILOR;
//            sValue[1] = 208;
//        }
//        if (key >= 36) {
//            sValue[0] = Constants.WIND_MILL;
//            sValue[1] = 214;
//        }
//        if (key >= 40) {
//            sValue[0] = Constants.STORAGE;
//            sValue[1] = 212;
//        }
//        if (key >= 45) {
//            sValue[0] = Constants.FEED_MILL;
//            sValue[1] = 213;
//        }
//
//        return sValue;
//    }
//
//    private Bitmap getBuildingImage(int type, int upgrade, boolean resize) {
//        Log.d(TAG, "getBuildingImage");
//        Bitmap result = null;
//        switch (type) {
//
//        case Constants.ENCLOSURE_CHICKEN:
//            result = loadImageAssets("building/enclousure/chicken.png", resize);
//            break;
//        case Constants.BAKERY:
//            result = loadImageAssets("building/bakery/bakery0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.ENCLOSURE_COW:
//            result = loadImageAssets("building/enclousure/cow.png", resize);
//            break;
//        case Constants.ENCLOSURE_SHEEP:
//            result = loadImageAssets("building/enclousure/sheep.png", resize);
//            break;
//        case Constants.ENCLOSURE_PIG:
//            result = loadImageAssets("building/enclousure/pig.png", resize);
//            break;
//        case Constants.CAKE:
//            result = loadImageAssets("building/cakes/cakes0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.DAIRY:
//            result = loadImageAssets("building/Dairy/dairy0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.ENCLOSURE_GOAT:
//            result = loadImageAssets("building/enclousure/goat.png", resize);
//            break;
//        case Constants.FRUIT_SMASHER:
//            result = loadImageAssets("building/Fruit/fruitsmasher0"
//                    + (upgrade + 1) + ".png", resize);
//            break;
//        case Constants.SUGAR_FACTORY:
//            result = loadImageAssets("building/Sugar/sugar0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.GRILL:
//            result = loadImageAssets("building/Grill/grill0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.RESTAURANT:
//            result = loadImageAssets("building/Gourmet/gourmet0"
//                    + (upgrade + 1) + ".png", resize);
//            break;
//        case Constants.WEAVING_BUILDING:
//            result = loadImageAssets("building/Wheel/wheel0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.TAILOR:
//            result = loadImageAssets("building/Tailor/tailor0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//
//        case Constants.FARM_HOUSE:
//            result = loadImageAssets("building/farmhouse/farmhouse0"
//                    + (upgrade + 1) + ".png", resize);
//            break;
//        case Constants.STORAGE:
//            result = loadImageAssets("building/barn/barn0" + (upgrade + 1)
//                    + ".png", resize);
//            break;
//        case Constants.FEED_MILL:
//            result = loadImageAssets("building/foodmill/foodmachine0"
//                    + (upgrade + 1) + ".png", resize);
//            break;
//        case Constants.WIND_MILL:
//            result = loadImageAssets("building/windmill/windmill0"
//                    + (upgrade + 1) + ".png", resize);
//            break;
//
//        }
//        return result;
//
//    }
//
//    private int[] calculatePosInitialMap(int tiledX, int tiledY) {
//
//        int[] position = new int[2];
//
//        int posInitialMapX = mCanvasWidth / 2 - World.tamTiledX / 2;
//        int posInitialMapY = 0;
//
//        posInitialMapX -= (World.tamTiledX / 2 * tiledY);
//        posInitialMapY += (World.tamTiledY / 2 * tiledY);
//
//        posInitialMapX += (World.tamTiledX / 2 * tiledX);
//        posInitialMapY += (World.tamTiledY / 2 * tiledX);
//
//        position[0] = posInitialMapX;
//        position[1] = posInitialMapY;
//
//        return position;
//    }
//
//    private void paintSuggestionMsg(Canvas canvas, int Pos_Initial_Map_X,
//            int Pos_Initial_Map_Y, int tiledX, int tiledY) {
//
//        if (mapContaints[tiledY][tiledX] == Constants.EMPTY) {
//            World.mMatrixflip.setTranslate(Pos_Initial_Map_X + World.posWorldX,
//                    Pos_Initial_Map_Y + World.posWorldY);
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(tiledSelected, World.mMatrixflip, null);
//        }
//
//        int posBackMsjSelected_X = (Pos_Initial_Map_X + World.posWorldX)
//                + World.tamTiledX / 2 - backgMsjSelected.getWidth() / 2;
//        int posBackMsjSelected_Y = (Pos_Initial_Map_Y + World.posWorldY)
//                + World.tamTiledY;
//
//        String msjToShow = "";
//        switch (msgSelect) {
//        case MSJANIMAL:
//            msjToShow = texts[46];
//            break;
//        case MSJBUILDING:
//            msjToShow = texts[46];
//            break;
//        case MSJFERTILIZE:
//            msjToShow = texts[47];
//            break;
//        case MSJPLANT:
//            msjToShow = texts[49];
//            break;
//        case MSJPLOW:
//            msjToShow = texts[45];
//            break;
//        case MSJRECOLECT:
//            msjToShow = texts[48];
//            break;
//        case MSJVEGETATION:
//            msjToShow = texts[50] + " " + texts[282] + " " + quantRemoVege;
//            break;
//        case MSJWATERING:
//            msjToShow = texts[62];
//            break;
//        }
//
//        // int posMsjTitle_Y = posBackMsjSelected_Y + 30;
//
//        if (msgSelect != MsgSuggest.MSJFERTILIZE) {
//            canvas.drawBitmap(backgMsjSelected, posBackMsjSelected_X,
//                    posBackMsjSelected_Y, null);
//
//            paintDivisionText(canvas, msjToShow, posBackMsjSelected_X
//                    + backgMsjSelected.getWidth() / 2, posBackMsjSelected_Y
//                    + backgMsjSelected.getHeight() / 2 - 15,
//                    (int) (fontPaintMsjGameBig.getTextSize()), 16,
//                    posBackMsjSelected_Y + 5, fontPaintMsjGameBig);
//
//        } else {
//            posBackMsjSelected_X = (Pos_Initial_Map_X + World.posWorldX)
//                    + World.tamTiledX / 2 - bgTooltip.getWidth() / 2;
//            canvas.drawBitmap(bgTooltip, posBackMsjSelected_X,
//                    posBackMsjSelected_Y, null);
//
//            canvas.drawBitmap(iconHarverst,
//                    posBackMsjSelected_X + bgTooltip.getWidth() / 4
//                            - iconHarverst.getWidth() / 2, posBackMsjSelected_Y
//                            + suggestionMsgTimeOffsetY + 5, null);
//            canvas.drawBitmap(iconWater,
//                    posBackMsjSelected_X + (bgTooltip.getWidth() / 4) * 3
//                            - iconWater.getWidth() / 2, posBackMsjSelected_Y
//                            + suggestionMsgTimeOffsetY + 5, null);
//
//            for (int i = 0; i < NTree; i++) {
//                if (tree[i].getPosX() == tiledX && tree[i].getPosY() == tiledY) {
//                    canvas.drawText(tree[i].getTimeForPay(true),
//                            posBackMsjSelected_X + bgTooltip.getWidth() / 4,
//                            posBackMsjSelected_Y + suggestionMsgTimeOffsetY,
//                            fontPaintMsjGame);
//                    canvas.drawText(tree[i].getTimeForPay(false),
//                            posBackMsjSelected_X + (bgTooltip.getWidth() / 4)
//                                    * 3, posBackMsjSelected_Y
//                                    + suggestionMsgTimeOffsetY,
//                            fontPaintMsjGame);
//                    // posMsjTitle_Y -= 27;
//                    break;
//                }
//            }
//
//            paintDivisionText(canvas, msjToShow, posBackMsjSelected_X
//                    + bgTooltip.getWidth() / 2, posBackMsjSelected_Y
//                    + suggestionMsgTextOffsetY, 17, 22,
//                    posBackMsjSelected_Y + 5, fontPaintMsjGame);
//        }
//
//    }
//
//    private int paintDivisionText(Canvas canvas, String textToDivide, int posX,
//            int posY, int diffText, int maxCaract, int posOnlyLine_Y,
//            Paint paintText) {
//        String[] Mens = new String[10];
//        Mens[0] = textToDivide;
//        Mens = UtilSoftgames.splitString(Mens, maxCaract, 1);
//
//        if (Constants.lineas == 1 && posOnlyLine_Y != 0) {
//            posY = posOnlyLine_Y;
//        }
//
//        for (int i = 0; i < Constants.lineas; i++) {
//            canvas.drawText(Mens[i].trim(), posX, posY, paintText);
//            posY += diffText;
//        }
//
//        return posY;
//    }
//
//    private void Paint_Multitouch(Canvas canvas) {
//
//        for (int i = currentMultitouch; i < indexMultitouch; i++) {
//           
//            	
//            	int[] pos = calculatePosInitialMap(multitouch_X[i],  multitouch_Y[i]);
//            	int Pos_Initial_Map_X = pos[0];
//                int Pos_Initial_Map_Y = pos[1];
//
//                if (actionSelect != null && actionSelect == Action.ANIMAL_FOOD) {
//                    animalsPut[animalChosen].setSelected(true);
//                } else {
//                    World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                            + World.posWorldX, Pos_Initial_Map_Y
//                            + World.posWorldY);
//                    World.mMatrixflip.preScale(World.mScaleFactor,
//                            World.mScaleFactor);
//
//                    canvas.drawBitmap(tiledSelected, World.mMatrixflip, null);
//                }
//                //break;
//            }
//        
//    }
//
//    private boolean needPaintWorld(Canvas canvas, int Pos_Initial_Map_X,
//            int Pos_Initial_Map_Y, int tiledX, int tiledY) {
//
//        switch (mapContaints[tiledY][tiledX]) {
//        case Constants.EXPANSION:
//            // Log.d(TAG, "needPaintWorld -> case: EXPANSION");
//            return false;
//        case Constants.EXPANSIONLIMBO:
//            // Log.d(TAG, "needPaintWorld -> case: EXPANSIONLIMBO");
//            return false;
//        case Constants.EARTHGOOD:
//            // Log.d(TAG, "needPaintWorld -> case: EARTHGOOD");
//            World.mMatrixflip.setTranslate(Pos_Initial_Map_X + World.posWorldX,
//                    Pos_Initial_Map_Y + World.posWorldY);
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(earthGood, World.mMatrixflip, null);
//            if (isSelectedObject(tiledX, tiledY)) {
//                UtilSoftgames.animationSelectedObject(canvas, earthGood,
//                        Pos_Initial_Map_X + World.posWorldX, Pos_Initial_Map_Y
//                                + World.posWorldY, false, 1, 1);
//            }
//
//            return false;
//        case Constants.VEGETATIONBAD:
//        case Constants.VEGETATIONBAD2:
//        case Constants.VEGETATIONBAD3:
//        case Constants.VEGETATIONBAD4:
//        case Constants.VEGETATIONBAD5:
//
//            vegetationBad
//                    .paint(canvas,
//                            (mapContaints[tiledY][tiledX] - 22) + 1,
//                            Pos_Initial_Map_X + World.posWorldX,
//                            (Pos_Initial_Map_Y + World.posWorldY)
//                                    + ((int) (World.tamTiledY) - (int) (vegetationBad.auxImage
//                                            .getHeight() * World.mScaleFactor)),
//                            (int) (vegetationBad.auxImage.getHeight() * World.mScaleFactor),
//                            (int) (vegetationBad.auxImage.getWidth() * World.mScaleFactor) / 5,
//                            true, isSelectedObject(tiledX, tiledY), false);
//
//            return false;
//        case Constants.EARTHBAD:
//            // Log.d(TAG, "needPaintWorld -> case: EARTHBAD");
//            World.mMatrixflip.setTranslate(Pos_Initial_Map_X + World.posWorldX,
//                    Pos_Initial_Map_Y + World.posWorldY);
//            World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
//            canvas.drawBitmap(earthBad, World.mMatrixflip, null);
//            if (isSelectedObject(tiledX, tiledY)) {
//                UtilSoftgames.animationSelectedObject(canvas, earthBad,
//                        Pos_Initial_Map_X + World.posWorldX, Pos_Initial_Map_Y
//                                + World.posWorldY, false, 1, 1);
//            }
//
//            return false;
//
//        }
//        return true;
//    }
//
//    private void paintWorldNew(Canvas g, int Pos_Initial_Map_X,
//            int Pos_Initial_Map_Y, int IndexLevel) {
//        // Log.d(TAG, "paintWorldNew");
//        int nTiled = Integer.parseInt(levels[IndexLevel]);
//        try {
//            if (nTiled == 0) {
//                return;
//            }
//
//            switch (nTiled) {
//            case 2:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledGeneral, World.mMatrixflip, null);
//                break;
//            case 3:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[0], World.mMatrixflip, null);
//                break;
//            case 4:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[1], World.mMatrixflip, null);
//                break;
//            case 5:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[2], World.mMatrixflip, null);
//                break;
//            case 6:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[3], World.mMatrixflip, null);
//                break;
//
//            case 12:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[6], World.mMatrixflip, null);
//                break;
//            case 13:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[7], World.mMatrixflip, null);
//                break;
//            case 14:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[8], World.mMatrixflip, null);
//                break;
//            case 15:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[4], World.mMatrixflip, null);
//                break;
//            case 16:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[5], World.mMatrixflip, null);
//                break;
//
//            // tree big
//            case 29:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[9].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[9], World.mMatrixflip, null);
//                break;
//            case 30:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[10].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[10], World.mMatrixflip, null);
//                break;
//            case 31:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[11].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[11], World.mMatrixflip, null);
//                break;
//            case 32:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[12].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[12], World.mMatrixflip, null);
//                break;
//            case 33:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[13].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[13], World.mMatrixflip, null);
//                break;
//
//            // tree small
//            case 34:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[14].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[14], World.mMatrixflip, null);
//                break;
//            case 35:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[15].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[15], World.mMatrixflip, null);
//                break;
//            case 36:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[16].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[16], World.mMatrixflip, null);
//                break;
//            case 37:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[17].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[17], World.mMatrixflip, null);
//                break;
//            case 38:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY
//                        + World.tamTiledY - tiledMap[18].getHeight()
//                        * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[18], World.mMatrixflip, null);
//                break;
//
//            // Mine
//            case 39:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledGeneral, World.mMatrixflip, null);
//
//                World.mMatrixflip.setTranslate(
//                        Pos_Initial_Map_X + World.posWorldX + World.tamTiledX
//                                - (mineImage.getWidth() * World.mScaleFactor)
//                                / 2, // - (160
//                                     // *World.mScaleFactor)/2,
//                        Pos_Initial_Map_Y + World.posWorldY + (World.tamTiledY)
//                                - mineImage.getHeight() * World.mScaleFactor);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(mineImage, World.mMatrixflip, null);
//                break;
//
//            // road
//            case 40:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledGeneral, World.mMatrixflip, null);
//                break;
//            case 41:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[19], World.mMatrixflip, null);
//                break;
//            case 42:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[20], World.mMatrixflip, null);
//                break;
//            case 43:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[21], World.mMatrixflip, null);
//                break;
//            case 44:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[22], World.mMatrixflip, null);
//                break;
//            case 45:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[23], World.mMatrixflip, null);
//                break;
//            case 46:
//                World.mMatrixflip.setTranslate(Pos_Initial_Map_X
//                        + World.posWorldX, Pos_Initial_Map_Y + World.posWorldY);
//                World.mMatrixflip.preScale(World.mScaleFactor,
//                        World.mScaleFactor);
//                g.drawBitmap(tiledMap[24], World.mMatrixflip, null);
//                break;
//            }
//
//        } catch (Exception e) {
//            Log.e(TAG, "IndexLevel: " + IndexLevel);
//        }
//    }
//
//    public int getCurrentLevel() {
//        return this.nLevel;
//    }
//
//    public void rewardDiamonds(int amount) {
//
//        assignQuantity(0, 0, 0, 0, amount, 0, 0, mCanvasWidth / 2,
//                mCanvasHeight / 2);
//        elementChosen = Constants.PRESS_BUTTON_CLOSE_GENERAL_BG;
//    }
//    public void publicInMyWall(boolean mission){
//		 Constants.pressedMarket = true;
//		 pulblicMission = mission;
//		String msg = "reached Level "+ (nLevel+1 ) ;
//		 if(mission){
//			 msg = "reached Mission "+ (nMission+1 ) ;
//		 }
//		    /*Bundle params = new Bundle();
//           params.putString("caption", main.getString(R.string.app_name));
//           params.putString("description", 
//           		"Howdy Friend! I just "+ msg + " in Zombie Farmer for Android! Join me on my island and let´s play together! Here you can download the game: http://goo.gl/Kd7LI ");//); Constants.Texto[34]+ String.valueOf(Constants.NNivel+1));
//           params.putString("picture", Utility.HACK_ICON_URL);
//           params.putString("link", "http://goo.gl/Kd7LI");
//           params.putString("name", "Join my island in Zombie Farmer");*/
//
//
//       	Bundle params = new Bundle();
//       	params.putString("caption",
//       		mContext.getString(R.string.app_name));
//       	params.putString("description", String.format(mContext.getString(R.string.wallpost), msg));
//       	params.putString("picture", Utility.HACK_ICON_URL);
//       	params.putString("link", "http://goo.gl/Kd7LI");
//       	params.putString("name", "Join my island in My Little Farm 2!");
//           
//           
//        Utility.mFacebook.dialog(main, "feed", params, main.gameCanvas.new UpdateStatusListener());
//           //String access_token = Utility.mFacebook.getAccessToken();
//           //System.out.println(access_token);
//          // AdjustIo.trackEvent("20tr4w");
//	}
//	
//	public void inviteFacebook(){
//		 Constants.pressedMarket = true;
//		  String query = "select name, current_location, uid, pic_square from user where uid in (select uid2 from friend where uid1=me()) order by name";
//        Bundle params = new Bundle();
//        params.putString("method", "fql.query");
//        params.putString("query", query);
//        Utility.mAsyncRunner.request(null, params,
//                main.gameCanvas.new FriendsRequestListener());
//       // AdjustIo.trackEvent("20tr4w");
//	}
//
//
//}*/