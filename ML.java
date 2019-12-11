import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.swing.table.TableColumn;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.*;
import javax.swing.table.AbstractTableModel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import javax.swing.table.TableColumn;
import javax.swing.table.JTableHeader;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import java.util.List;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.Instances;  
import weka.core.converters.ConverterUtils.DataSource;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.Evaluation;
import java.util.Enumeration;
import weka.core.Attribute;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import weka.classifiers.functions.LibSVM;
import java.io.BufferedReader;
import java.io.FileReader;
import libsvm.svm_parameter;
//import weka.classifiers.AbstractClassifier;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Option;
import weka.core.RevisionUtils;
import weka.core.SelectedTag;
import weka.core.Tag;
import weka.core.TechnicalInformation;
import weka.core.TechnicalInformationHandler;
import weka.core.Utils;
import weka.core.Capabilities.Capability;
import weka.core.TechnicalInformation.Type;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

public class ML implements MouseListener {

    public static JFrame frame;

    public static JPanel panelNORTH;
    public static JLabel labelNORTH;

    public static JPanel panelCENTER; 
    public static JLabel labelCENTER;

    public static JPanel panelSOUTH;
    public static JLabel labelSOUTH;

    public static JButton startButton;
    public static JButton nextButton;
    public static JButton backButton;

    public static String infraRedImagePath = "./InfraRedImages";
    public static File infraRedImagefolder = new File(infraRedImagePath);
    public static String[] infraRedImageName;
    public static int count = 0;
    public static int infraRedImageCount = 0;
    public static String thermalCsvName;

    public static GraphicsEnvironment env;
    public static DisplayMode displayMode;
    public static int disp_width;
    public static int disp_height;

    public static int currentImageCounter = 0;
    public static int thermal_line_count;  //512 高さ方向
    public static int thermal_col_count;   //640 幅方向
    public static ImageIcon icon;
    public static double ratio = 1.0;
    public static BufferedImage readImage = null; 
    public static BufferedImage tempImage = null; 

    public static int img_width = 10;    //読み込まれる画像(三枚共通)の横と縦
    public static int img_height = 10;   //開始を10にしているが、0でなければ何でもいい。

    public static String[][] thermalCsvData; 

    public static int filterSize = 3;
    public static int skip = 1;
    public static int dataSize = filterSize*filterSize;

    public static double narrowThermalMax = 7777; 
    public static double narrowThermalMin = -7777;
    public static double narrowThermalAve = 0;
    public static double stdev = 0; 

    public static DataSource source;
    public static Instances data;
    //public static Classifier classifier;
    //public static RandomForest forest;
    public static LibSVM svm;

    public static boolean detectFlag = false;

    public static double sumForAve = 0;

    public static double sumPixelValue = 0;
    
    public static double avePixelValue = 0;

    public static int pixelCounter = 0;

    public static double thermalSum = 0;

    public static double thermalAverage = 0;

    public static double tempValue = 0;
 
    public static double thermalStdev = 0;

    public ML() {
        //env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //displayMode = env.getDefaultScreenDevice().getDisplayMode();
        
        //disp_width = displayMode.getWidth();
        //disp_height = displayMode.getHeight();

        if(infraRedImagefolder.exists()==true) {
            count(infraRedImagefolder.listFiles());
            infraRedImageCount = count;           
        } 
        else {
            JOptionPane.showMessageDialog(null, "「./」に「InfraRedImages」フォルダが存在しないためアプリケーションを実行できません。");
        }

        infraRedImageName = new String[infraRedImageCount];

        String infraRedImages_f[] = infraRedImagefolder.list();
        int infraRedImageNumber = 0;

        for (String infraRed_image_name: infraRedImages_f) {        
            infraRedImageName[infraRedImageNumber] = infraRed_image_name;            
            //createCSV(infraRedImageName[infraRedImageNumber]);
            thermalCsvName = "./CSV/"+infraRedImageName[infraRedImageNumber].replace("JPG", "csv");           
            thermalCsvReader1(thermalCsvName);            
            thermalCsvReader2(thermalCsvName); // thermalCsvDataの0行0列から511行639列に値を格納する
     
            infraRedImageNumber++;
        }   

        imageNameSetterOnNorth(infraRedImageName[currentImageCounter]);   // NORTHの初期状態は一番目の画像名
        center_Image_Setter( readImageMethod(infraRedImageName[currentImageCounter]) );

        // ウィンドウ生成
        frame = new JFrame();                                  // メイン・ウィンドウ作成                                          
        //frame.setSize(disp_width, disp_height);                           // メイン・ウィンドウのサイズを設定
        frame.setSize(700, 640);// メイン・ウィンドウのサイズを設定
        //frame.setSize(900, 840);
        frame.setTitle("機械学習による「浮き」判定");          // ウィンドウのタイトル設定
        frame.setLocationRelativeTo(null);                     // 最初に画面中央に表示されるように設定
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ウィンドウを閉じる動作の登録

        try {
            //--------  データセット取得  ---------------------------------
            source = new DataSource("thermal.arff");
            data = source.getDataSet();
            data.setClassIndex(4);
            //-------------------------------------------------------------
        } catch(Exception e1) {
            JOptionPane.showMessageDialog(null, "データセットを読み込めませんでした。");
        }

        try {
            //--------  学習  -------------------------------------------------------------------------------       
            svm = new LibSVM();
            svm.setKernelType(new SelectedTag(LibSVM.KERNELTYPE_LINEAR, LibSVM.TAGS_KERNELTYPE));
            //svm.setKernelType(new SelectedTag(LibSVM.KERNELTYPE_RBF, LibSVM.TAGS_KERNELTYPE));
            //svm.setKernelType(new SelectedTag(LibSVM.KERNELTYPE_POLYNOMIAL, LibSVM.TAGS_KERNELTYPE));
            //svm.setKernelType(new SelectedTag(LibSVM.KERNELTYPE_SIGMOID, LibSVM.TAGS_KERNELTYPE));


            //svm_parameter pre= new svm_parameter();
            //pre.kernel_type= svm_parameter.POLY;
            //pre.gamma= 3;
            //pre.degree=1;
            //svm.setParameters(pre);

            svm.buildClassifier(data); // 学習
          

            //svm = (LibSVM) weka.core.SerializationHelper.read("./savedModel/SVM.model"); // モデルを読み込む

            //weka.core.SerializationHelper.write("./savedModel/SVM.model", svm); // モデルを保存する
            //-----------------------------------------------------------------------------------------------
        } catch(Exception e2) {
             JOptionPane.showMessageDialog(null, "データセットの学習の過程で問題が発生しました。");
        }


        // GUIを構成するコンポーネントを配置させるメソッドの呼び出し(GUIコンポーネントの配置)        
        buildUI();

        // ウィンドウ全体を可視化
        frame.setVisible(true);  
    }

    public void buildUI() {
        // 未定のUI 北
        panelNORTH = new JPanel();
        panelNORTH.add(labelNORTH);
        panelNORTH.setBackground(new Color(45, 45, 45));

        // 拡大した赤外線画像を表示するパネルに関するUI 中央
        panelCENTER = new JPanel();             
        //panelCENTER.setLayout(new CardLayout());       
        panelCENTER.add(labelCENTER);  
        panelCENTER.setBackground(new Color(45, 45, 45));

        panelSOUTH = new JPanel();     
        panelSOUTH.setLayout(new BorderLayout()); 
        //panelSOUTH.add(labelSOUTH, BorderLayout.CENTER);  
        panelSOUTH.setBackground(new Color(45, 45, 45)); 
        //panelSOUTH.setForeground(Color.WHITE); 
        startButton = new JButton("「浮き」判定スタート"); 
        nextButton = new JButton("次の画像へ");   
        backButton = new JButton("前の画像へ");
        startButton.addMouseListener(this);
        nextButton.addMouseListener(this);
        backButton.addMouseListener(this);
        //panelSOUTH.add(backButton); 
        //panelSOUTH.add(startButton); 
        //panelSOUTH.add(nextButton);
        panelSOUTH.add(backButton, BorderLayout.LINE_START);   
        panelSOUTH.add(startButton, BorderLayout.CENTER);
        panelSOUTH.add(nextButton, BorderLayout.LINE_END);
        
        frame.setLayout(new BorderLayout());                   // 画面全体のレイアウトをBorderLayoutに設定        
        frame.add(panelNORTH, BorderLayout.PAGE_START);        // btnPanelを画面上に登録(配置) 
        frame.add(panelCENTER, BorderLayout.CENTER);           // panelCENTERを画面中央に登録(配置) 
        frame.add(panelSOUTH, BorderLayout.PAGE_END);       
    }

    // csvファイル内のデータが存在する範囲を走査して、データが存在する範囲の行数と列数を取得するメソッド
    public static void thermalCsvReader1(String csvName) {                                 
        String sLine = "";                                     // 一時格納用変数(ダミーとして使う変数)
        ArrayList<String> arrText = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader( new FileReader(csvName) );
            
            // ファイルから1行ずつ読み込む
            while (sLine != null) {                
                // ファイルから1行ずつ読み込むReadToEndでもいい
                sLine = br.readLine();
                if (sLine != null)
                    arrText.add(sLine); // addメソッドで追記
            }
                       
            br.close();
        } catch( IOException e )  {
            JOptionPane.showMessageDialog(null, "温度データが格納されたCSVファイル「"+csvName+"」の読み込みに失敗しました。");
        } catch( NumberFormatException e )  {
            JOptionPane.showMessageDialog(null, "温度データが格納されたCSVファイル「"+csvName+"」に不正なフォーマットが存在します。");
        }
        thermal_line_count = arrText.size();

        // 列数を数えるために適当な配列に格納して数えてみる
        String temp = (String)arrText.get(0);   // string型にキャスト
        // splitメソッドで文字列アレイにして数える
        String[] temp2 = temp.split(",");
        // 列数を数える
        thermal_col_count = temp2.length;
    }

    // csvファイルに記されている各列要素をそれぞれに対応する文字列型配列に格納するメソッド
    public static void thermalCsvReader2(String csvName) {
        String sLine = ""; // 一時格納用
        
        ArrayList<String> arrText = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader( new FileReader(csvName) );
            
            // ファイルから1行ずつ読み込む
            while (sLine != null)
            {
                
                // ファイルから1行ずつ読み込むReadToEndでもいい
                sLine = br.readLine();
                if (sLine != null)
                    arrText.add(sLine); // addメソッドで追記
            }
                       
            br.close();
        } catch( IOException e )  {
            JOptionPane.showMessageDialog(null, "温度データが格納されたCSVファイル「"+csvName+"」の読み込みに失敗しました。");
        } catch( NumberFormatException e )  {
            JOptionPane.showMessageDialog(null, "温度データが格納されたCSVファイル「"+csvName+"」に不正なフォーマットが存在します。");
        }

        // ArrayListから2次元配列に格納する．
        // 2次元配列の定義
        thermalCsvData = new String[thermal_line_count][thermal_col_count];
        int a = 0;
        int b = 0;

        for (String sOutput : arrText) {
            // 一行ずつ読み込んで，各行をsplitメソッドで分ける
            String[] temp_line = sOutput.split(",");
            for (String value : temp_line)
            {
                thermalCsvData[a][b] = value;
                b++;
            }
            b = 0;
            a++;
        }                
    }

    public static void thermalCsvReaderMethod() {
        thermalCsvName = "./CSV/"+infraRedImageName[currentImageCounter].replace("JPG", "csv");
        thermalCsvReader1(thermalCsvName);
        thermalCsvReader2(thermalCsvName);   // thermalCsvDataの0行0列から511行639列に値を格納する
    }

    // InfraRedImagesフォルダから画像をBufferedImage型で読み込み、BufferedImage型で返すメソッド
    public static BufferedImage readImageMethod(String imageName) {
    
        try {
            readImage = ImageIO.read(new File(infraRedImagePath+"/"+imageName));
            //img_gray = ImageIO.read(new File(infraRedImagePath+"/"+imageName)); // double型の2次元配列に変える
            //img_gray_tmp = ImageIO.read(new File(infraRedImagePath+"/"+imageName));// 
            
            img_width = readImage.getWidth();
            img_height = readImage.getHeight();
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "バックグラウンドでの画像読み込みに失敗しました。");
        }
        return readImage;
    } 

    // 現在の画像名をlabelNORTHに設定するメソッド
    public static void imageNameSetterOnNorth(String fileName) {
        labelNORTH = new JLabel(fileName, JLabel.CENTER);
        labelNORTH.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 25));
        //labelNORTH.setBackground(new Color(45, 45, 45));
        labelNORTH.setForeground(Color.WHITE);
    }

    // 画像をImageIcon型で読み込み、画像を縮小してlabelCENTERにアイコンを貼り付けるメソッド
    public static void center_Image_Setter(BufferedImage img) {
        ImageIcon icon = new ImageIcon(img);
        //MediaTracker tracker = new MediaTracker(this);  // 処理の終了を待つMediaTrackerを定義

        Image smallImg = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * ratio), -1, Image.SCALE_SMOOTH); // getScaledInstanceで大きさを変更する
        //tracker.addImage(bigImg, 1);  // MediaTrackerで処理の終了を待つ
        ImageIcon smallIcon = new ImageIcon(smallImg);
        try {
            //tracker.waitForAll();
        } 
        catch (Exception e) {
            System.out.println("Error in center_Image_Setter()");
        }
    
        labelCENTER = new JLabel(smallIcon, JLabel.CENTER);     
        labelCENTER.setIcon(smallIcon);
    }

    public static void count(File[] list) {
        for (File f : list) {
            if (f.isDirectory()) {
                count(f.listFiles());
            } 
            else if (f.isFile()) {
	        count++;
            }
        }
    }

    public static void scan(BufferedImage img) {

        // 画像全体の平均値を求める------------------------------------------------------------------------------------------
        for (int y = (filterSize/2)+1; y < thermal_line_count-(filterSize/2); y=y+skip) {   // 選択範囲(全体)内を走査
            for (int x = (filterSize/2)+1; x < thermal_col_count-(filterSize/2); x=x+skip) {
                pixelCounter = pixelCounter + 1;
                thermalSum = thermalSum + Double.parseDouble(thermalCsvData[y-2][x-2]); 
            }
        }
        thermalAverage = thermalSum/pixelCounter;
        //-------------------------------------------------------------------------------------------------------------------

        // 画像全体の標準偏差を求める----------------------------------------------------------------------------------------
        for (int y = (filterSize/2)+1; y < thermal_line_count-(filterSize/2); y=y+skip) {   // 選択範囲(全体)内を走査
            for (int x = (filterSize/2)+1; x < thermal_col_count-(filterSize/2); x=x+skip) {                                
                tempValue = tempValue + Math.pow(Double.parseDouble(thermalCsvData[y-2][x-2])-thermalAverage, 2);               
            }
        }
        thermalStdev = Math.sqrt(tempValue/pixelCounter);
        //-------------------------------------------------------------------------------------------------------------------
        
        // 局所的な「最大値」、「最小値」、「平均値」、「画素値」を求める----------------------------------------------------
        double sum = 0;
        for (int y = (filterSize/2)+1; y < thermal_line_count-(filterSize/2); y=y+skip) {   // 選択範囲内を走査
            for (int x = (filterSize/2)+1; x < thermal_col_count-(filterSize/2); x=x+skip) {
                sum = 0;     
                sumPixelValue = 0;
                narrowThermalMax = Double.parseDouble(thermalCsvData[y-2][x-2]);  
                narrowThermalMin = Double.parseDouble(thermalCsvData[y-2][x-2]);  
                double[] data = new double[dataSize];
                int index = 0;
                for (int temp_y = y-(filterSize/2); temp_y <= y+(filterSize/2); temp_y=temp_y+1) {   // 選択範囲内を走査
                    for (int temp_x = x-(filterSize/2); temp_x <= x+(filterSize/2); temp_x=temp_x+1) {
                        data[index] = Double.parseDouble(thermalCsvData[temp_y][temp_x]);
                        index = index + 1;
                        sum = sum + Double.parseDouble(thermalCsvData[temp_y][temp_x]);

                        narrowThermalAve = narrowThermalAve + Double.parseDouble(thermalCsvData[y][x]);  

                        if(Double.parseDouble(thermalCsvData[temp_y][temp_x]) > narrowThermalMax) {
                            // 局所的な「最大値」
                            narrowThermalMax = Double.parseDouble(thermalCsvData[temp_y][temp_x]);
                        }

                        if(Double.parseDouble(thermalCsvData[temp_y][temp_x]) < narrowThermalMin) {
                            // 局所的な「最小値」
                            narrowThermalMin = Double.parseDouble(thermalCsvData[temp_y][temp_x]);
                        }

                        // 局所的な「画素値」の合計
                        int c = img.getRGB(temp_x, temp_y);
                        sumPixelValue = sumPixelValue + (r(c)+g(c)+b(c))/3;
                    }                   
                }              
                count++;

                // 局所的な「平均値」
                narrowThermalAve = sum/dataSize;
                
                //double temp = 0;
                //for(int i = 0; i < dataSize; i=i+1) {
                //    temp = temp + Math.pow(data[i]-narrowThermalAve, 2);
                //}
                //局所的な「標準偏差」今回は使わない
                //stdev = Math.sqrt(temp/dataSize);     

                //-----------------------------------------------------------------------------------------------------------
                // 正規化した局所的なnarrowThermalMax
                narrowThermalMax = (narrowThermalMax-thermalAverage)/(thermalStdev);
                //System.out.println("正規化した局所的なnarrowThermalMax="+narrowThermalMax);

                // 正規化した局所的なnarrowThermalMin
                narrowThermalMin = (narrowThermalMin-thermalAverage)/(thermalStdev);
                //System.out.println("正規化した局所的なnarrowThermalMin="+narrowThermalMin);

                // 正規化した局所的なnarrowThermalAve
                narrowThermalAve = (narrowThermalAve-thermalAverage)/(thermalStdev);
                //System.out.println("正規化した局所的なnarrowThermalAve="+narrowThermalAve);

                // 局所的な「画素値」の平均                
                avePixelValue = ( (sumPixelValue)/(filterSize*filterSize) )/255;
                //System.out.println("局所的な「画素値」の平均="+avePixelValue);
                //-----------------------------------------------------------------------------------------------------------
           
                
                //System.out.println("最大値="+narrowThermalMax);
                //System.out.println("最小値="+narrowThermalMin);
                //System.out.println("平均="+narrowThermalAve);
                //System.out.println("標準偏差="+stdev);
                //System.out.println("\n");   
                //System.out.println("x="+x+" y="+y); 
     
                if( detect(narrowThermalMax, narrowThermalMin, narrowThermalAve, avePixelValue) == true ) {                   
                    img.setRGB(x, y, 0x00FFFF);                         
                    tempImage = img; 
                }                            
   	    }  
        }  

        panelCENTER.remove(labelCENTER);
        center_Image_Setter(img);
        panelCENTER.add(labelCENTER);

        frame.setVisible(true);
    }
      
        
    public static boolean detect(double maxValue, double minValue, double aveValue, double stdevValue) {
        boolean result = false;
        try {
            //--------  データセット取得  ---------------------------------
            //DataSource source = new DataSource("thermal.arff");
            //Instances instances = source.getDataSet();
            //instances.setClassIndex(4);
            //-------------------------------------------------------------


            //--------  学習  ---------------------------------------------
            //Classifier classifier = new SMO();
            //classifier.buildClassifier(instances);  // 学習
            //-------------------------------------------------------------


            //--------  評価  ---------------------------------------------
            //Evaluation eval = new Evaluation(instances);
            //eval.evaluateModel(classifier, instances);
            //System.out.println(eval.toSummaryString());  // 評価
            //-------------------------------------------------------------

          
            //--------  事例データ(テストデータ)作成  ---------------------
           
            Attribute max = new Attribute("max", 0);
            Attribute min = new Attribute("min", 1);
            Attribute ave = new Attribute("ave", 2);
            Attribute stdev = new Attribute("stdev", 3);

            Instance instance = new Instance(5);

            instance.setValue(max, maxValue);
            instance.setValue(min, minValue);
            instance.setValue(ave, aveValue);
            instance.setValue(stdev, stdevValue);

            instance.setDataset(data);
            //-------------------------------------------------------------


            //--------  分類結果の出力  -----------------------------------
            // 以下に注意

            // resultの値が「0」ならば「問題箇所」
            // resultの値が「1」ならば「正常箇所」

            //double resultValue = classifier.classifyInstance(instance);
            double resultValue = svm.classifyInstance(instance);
            //System.out.println(result);
            if(resultValue==0.0) {
                result = true;
                //System.out.println("「問題箇所」\n 浮きの可能性あり");
            } else {
                result = false;
                //System.out.println("「正常箇所」\n 問題なし");
            }
            //-------------------------------------------------------------

            //return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "学習または推論に失敗しました。");
        }

        return result;
    }    
    

    // イベントリスナ(MouseListenerインターフェイス)が持つ抽象メソッドを実装    
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(startButton)) {
            if(detectFlag == false) {
                try {
                    thermalCsvReaderMethod();            
                    scan(readImageMethod(infraRedImageName[currentImageCounter]));
                    detectFlag = true;
                    startButton.setText("元画像表示");

                    ImageIO.write(tempImage, "png", new File("./推論結果"+"/"+infraRedImageName[currentImageCounter]));
                } catch(Exception e5) {

                }
            } else {
                panelCENTER.remove(labelCENTER);
                center_Image_Setter( readImageMethod(infraRedImageName[currentImageCounter]) );
                panelCENTER.add(labelCENTER);

                frame.setVisible(true);
                detectFlag = false;
                startButton.setText("「浮き」判定スタート");
            }

        } else if(e.getSource().equals(nextButton)) {
            if(currentImageCounter < (count-1)) {
                currentImageCounter = currentImageCounter + 1;
                panelCENTER.remove(labelCENTER);
                center_Image_Setter( readImageMethod(infraRedImageName[currentImageCounter]) );
                panelCENTER.add(labelCENTER);

                panelNORTH.remove(labelNORTH);
                imageNameSetterOnNorth(infraRedImageName[currentImageCounter]);
                panelNORTH.add(labelNORTH);

                if(detectFlag == true) {
                    detectFlag = false;
                    startButton.setText("「浮き」判定スタート");
                }

                frame.setVisible(true);
            }

          
           

        } else if(e.getSource().equals(backButton)) {
            if(currentImageCounter > 0) {
                currentImageCounter = currentImageCounter - 1;
                panelCENTER.remove(labelCENTER);
                center_Image_Setter( readImageMethod(infraRedImageName[currentImageCounter]) );
                panelCENTER.add(labelCENTER);

                panelNORTH.remove(labelNORTH);
                imageNameSetterOnNorth(infraRedImageName[currentImageCounter]);
                panelNORTH.add(labelNORTH);

                if(detectFlag == true) {
                    detectFlag = false;
                    startButton.setText("「浮き」判定スタート");
                }

                frame.setVisible(true);
            }                       
        }
    }

    public void mouseEntered(MouseEvent e) {
        // 空実装
    }

    public void mouseExited(MouseEvent e) {
        // 空実装
    }

    public void mousePressed(MouseEvent e) {
        // 空実装
    }

    public void mouseReleased(MouseEvent e ){
        // 空実装
    }

    public static int a(int c){
        return c>>>24;
    }
    public static int r(int c){
        return c>>16&0xff;
    }
    public static int g(int c){
        return c>>8&0xff;
    }
    public static int b(int c){
        return c&0xff;
    }
    public static int rgb(int r,int g,int b){
        return 0xff000000 | r <<16 | g <<8 | b;
    }
    public static int argb(int a,int r,int g,int b){
        return a<<24 | r <<16 | g <<8 | b;
    }    
    
    // メインメソッド (コンストラクタを起動するためだけに利用される)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                new ML(); 
            }  
        });                                
    }
}




