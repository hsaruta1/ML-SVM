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
    public static int thermal_line_count;  //512 ��������
    public static int thermal_col_count;   //640 ������
    public static ImageIcon icon;
    public static double ratio = 1.0;
    public static BufferedImage readImage = null; 
    public static BufferedImage tempImage = null; 

    public static int img_width = 10;    //�ǂݍ��܂��摜(�O������)�̉��Əc
    public static int img_height = 10;   //�J�n��10�ɂ��Ă��邪�A0�łȂ���Ή��ł������B

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
            JOptionPane.showMessageDialog(null, "�u./�v�ɁuInfraRedImages�v�t�H���_�����݂��Ȃ����߃A�v���P�[�V���������s�ł��܂���B");
        }

        infraRedImageName = new String[infraRedImageCount];

        String infraRedImages_f[] = infraRedImagefolder.list();
        int infraRedImageNumber = 0;

        for (String infraRed_image_name: infraRedImages_f) {        
            infraRedImageName[infraRedImageNumber] = infraRed_image_name;            
            //createCSV(infraRedImageName[infraRedImageNumber]);
            thermalCsvName = "./CSV/"+infraRedImageName[infraRedImageNumber].replace("JPG", "csv");           
            thermalCsvReader1(thermalCsvName);            
            thermalCsvReader2(thermalCsvName); // thermalCsvData��0�s0�񂩂�511�s639��ɒl���i�[����
     
            infraRedImageNumber++;
        }   

        imageNameSetterOnNorth(infraRedImageName[currentImageCounter]);   // NORTH�̏�����Ԃ͈�Ԗڂ̉摜��
        center_Image_Setter( readImageMethod(infraRedImageName[currentImageCounter]) );

        // �E�B���h�E����
        frame = new JFrame();                                  // ���C���E�E�B���h�E�쐬                                          
        //frame.setSize(disp_width, disp_height);                           // ���C���E�E�B���h�E�̃T�C�Y��ݒ�
        frame.setSize(700, 640);// ���C���E�E�B���h�E�̃T�C�Y��ݒ�
        //frame.setSize(900, 840);
        frame.setTitle("�@�B�w�K�ɂ��u�����v����");          // �E�B���h�E�̃^�C�g���ݒ�
        frame.setLocationRelativeTo(null);                     // �ŏ��ɉ�ʒ����ɕ\�������悤�ɐݒ�
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // �E�B���h�E����铮��̓o�^

        try {
            //--------  �f�[�^�Z�b�g�擾  ---------------------------------
            source = new DataSource("thermal.arff");
            data = source.getDataSet();
            data.setClassIndex(4);
            //-------------------------------------------------------------
        } catch(Exception e1) {
            JOptionPane.showMessageDialog(null, "�f�[�^�Z�b�g��ǂݍ��߂܂���ł����B");
        }

        try {
            //--------  �w�K  -------------------------------------------------------------------------------       
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

            svm.buildClassifier(data); // �w�K
          

            //svm = (LibSVM) weka.core.SerializationHelper.read("./savedModel/SVM.model"); // ���f����ǂݍ���

            //weka.core.SerializationHelper.write("./savedModel/SVM.model", svm); // ���f����ۑ�����
            //-----------------------------------------------------------------------------------------------
        } catch(Exception e2) {
             JOptionPane.showMessageDialog(null, "�f�[�^�Z�b�g�̊w�K�̉ߒ��Ŗ�肪�������܂����B");
        }


        // GUI���\������R���|�[�l���g��z�u�����郁�\�b�h�̌Ăяo��(GUI�R���|�[�l���g�̔z�u)        
        buildUI();

        // �E�B���h�E�S�̂�����
        frame.setVisible(true);  
    }

    public void buildUI() {
        // �����UI �k
        panelNORTH = new JPanel();
        panelNORTH.add(labelNORTH);
        panelNORTH.setBackground(new Color(45, 45, 45));

        // �g�債���ԊO���摜��\������p�l���Ɋւ���UI ����
        panelCENTER = new JPanel();             
        //panelCENTER.setLayout(new CardLayout());       
        panelCENTER.add(labelCENTER);  
        panelCENTER.setBackground(new Color(45, 45, 45));

        panelSOUTH = new JPanel();     
        panelSOUTH.setLayout(new BorderLayout()); 
        //panelSOUTH.add(labelSOUTH, BorderLayout.CENTER);  
        panelSOUTH.setBackground(new Color(45, 45, 45)); 
        //panelSOUTH.setForeground(Color.WHITE); 
        startButton = new JButton("�u�����v����X�^�[�g"); 
        nextButton = new JButton("���̉摜��");   
        backButton = new JButton("�O�̉摜��");
        startButton.addMouseListener(this);
        nextButton.addMouseListener(this);
        backButton.addMouseListener(this);
        //panelSOUTH.add(backButton); 
        //panelSOUTH.add(startButton); 
        //panelSOUTH.add(nextButton);
        panelSOUTH.add(backButton, BorderLayout.LINE_START);   
        panelSOUTH.add(startButton, BorderLayout.CENTER);
        panelSOUTH.add(nextButton, BorderLayout.LINE_END);
        
        frame.setLayout(new BorderLayout());                   // ��ʑS�̂̃��C�A�E�g��BorderLayout�ɐݒ�        
        frame.add(panelNORTH, BorderLayout.PAGE_START);        // btnPanel����ʏ�ɓo�^(�z�u) 
        frame.add(panelCENTER, BorderLayout.CENTER);           // panelCENTER����ʒ����ɓo�^(�z�u) 
        frame.add(panelSOUTH, BorderLayout.PAGE_END);       
    }

    // csv�t�@�C�����̃f�[�^�����݂���͈͂𑖍����āA�f�[�^�����݂���͈͂̍s���Ɨ񐔂��擾���郁�\�b�h
    public static void thermalCsvReader1(String csvName) {                                 
        String sLine = "";                                     // �ꎞ�i�[�p�ϐ�(�_�~�[�Ƃ��Ďg���ϐ�)
        ArrayList<String> arrText = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader( new FileReader(csvName) );
            
            // �t�@�C������1�s���ǂݍ���
            while (sLine != null) {                
                // �t�@�C������1�s���ǂݍ���ReadToEnd�ł�����
                sLine = br.readLine();
                if (sLine != null)
                    arrText.add(sLine); // add���\�b�h�ŒǋL
            }
                       
            br.close();
        } catch( IOException e )  {
            JOptionPane.showMessageDialog(null, "���x�f�[�^���i�[���ꂽCSV�t�@�C���u"+csvName+"�v�̓ǂݍ��݂Ɏ��s���܂����B");
        } catch( NumberFormatException e )  {
            JOptionPane.showMessageDialog(null, "���x�f�[�^���i�[���ꂽCSV�t�@�C���u"+csvName+"�v�ɕs���ȃt�H�[�}�b�g�����݂��܂��B");
        }
        thermal_line_count = arrText.size();

        // �񐔂𐔂��邽�߂ɓK���Ȕz��Ɋi�[���Đ����Ă݂�
        String temp = (String)arrText.get(0);   // string�^�ɃL���X�g
        // split���\�b�h�ŕ�����A���C�ɂ��Đ�����
        String[] temp2 = temp.split(",");
        // �񐔂𐔂���
        thermal_col_count = temp2.length;
    }

    // csv�t�@�C���ɋL����Ă���e��v�f�����ꂼ��ɑΉ����镶����^�z��Ɋi�[���郁�\�b�h
    public static void thermalCsvReader2(String csvName) {
        String sLine = ""; // �ꎞ�i�[�p
        
        ArrayList<String> arrText = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader( new FileReader(csvName) );
            
            // �t�@�C������1�s���ǂݍ���
            while (sLine != null)
            {
                
                // �t�@�C������1�s���ǂݍ���ReadToEnd�ł�����
                sLine = br.readLine();
                if (sLine != null)
                    arrText.add(sLine); // add���\�b�h�ŒǋL
            }
                       
            br.close();
        } catch( IOException e )  {
            JOptionPane.showMessageDialog(null, "���x�f�[�^���i�[���ꂽCSV�t�@�C���u"+csvName+"�v�̓ǂݍ��݂Ɏ��s���܂����B");
        } catch( NumberFormatException e )  {
            JOptionPane.showMessageDialog(null, "���x�f�[�^���i�[���ꂽCSV�t�@�C���u"+csvName+"�v�ɕs���ȃt�H�[�}�b�g�����݂��܂��B");
        }

        // ArrayList����2�����z��Ɋi�[����D
        // 2�����z��̒�`
        thermalCsvData = new String[thermal_line_count][thermal_col_count];
        int a = 0;
        int b = 0;

        for (String sOutput : arrText) {
            // ��s���ǂݍ���ŁC�e�s��split���\�b�h�ŕ�����
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
        thermalCsvReader2(thermalCsvName);   // thermalCsvData��0�s0�񂩂�511�s639��ɒl���i�[����
    }

    // InfraRedImages�t�H���_����摜��BufferedImage�^�œǂݍ��݁ABufferedImage�^�ŕԂ����\�b�h
    public static BufferedImage readImageMethod(String imageName) {
    
        try {
            readImage = ImageIO.read(new File(infraRedImagePath+"/"+imageName));
            //img_gray = ImageIO.read(new File(infraRedImagePath+"/"+imageName)); // double�^��2�����z��ɕς���
            //img_gray_tmp = ImageIO.read(new File(infraRedImagePath+"/"+imageName));// 
            
            img_width = readImage.getWidth();
            img_height = readImage.getHeight();
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "�o�b�N�O���E���h�ł̉摜�ǂݍ��݂Ɏ��s���܂����B");
        }
        return readImage;
    } 

    // ���݂̉摜����labelNORTH�ɐݒ肷�郁�\�b�h
    public static void imageNameSetterOnNorth(String fileName) {
        labelNORTH = new JLabel(fileName, JLabel.CENTER);
        labelNORTH.setFont(new Font("�l�r �S�V�b�N", Font.BOLD, 25));
        //labelNORTH.setBackground(new Color(45, 45, 45));
        labelNORTH.setForeground(Color.WHITE);
    }

    // �摜��ImageIcon�^�œǂݍ��݁A�摜���k������labelCENTER�ɃA�C�R����\��t���郁�\�b�h
    public static void center_Image_Setter(BufferedImage img) {
        ImageIcon icon = new ImageIcon(img);
        //MediaTracker tracker = new MediaTracker(this);  // �����̏I����҂�MediaTracker���`

        Image smallImg = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * ratio), -1, Image.SCALE_SMOOTH); // getScaledInstance�ő傫����ύX����
        //tracker.addImage(bigImg, 1);  // MediaTracker�ŏ����̏I����҂�
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

        // �摜�S�̂̕��ϒl�����߂�------------------------------------------------------------------------------------------
        for (int y = (filterSize/2)+1; y < thermal_line_count-(filterSize/2); y=y+skip) {   // �I��͈�(�S��)���𑖍�
            for (int x = (filterSize/2)+1; x < thermal_col_count-(filterSize/2); x=x+skip) {
                pixelCounter = pixelCounter + 1;
                thermalSum = thermalSum + Double.parseDouble(thermalCsvData[y-2][x-2]); 
            }
        }
        thermalAverage = thermalSum/pixelCounter;
        //-------------------------------------------------------------------------------------------------------------------

        // �摜�S�̂̕W���΍������߂�----------------------------------------------------------------------------------------
        for (int y = (filterSize/2)+1; y < thermal_line_count-(filterSize/2); y=y+skip) {   // �I��͈�(�S��)���𑖍�
            for (int x = (filterSize/2)+1; x < thermal_col_count-(filterSize/2); x=x+skip) {                                
                tempValue = tempValue + Math.pow(Double.parseDouble(thermalCsvData[y-2][x-2])-thermalAverage, 2);               
            }
        }
        thermalStdev = Math.sqrt(tempValue/pixelCounter);
        //-------------------------------------------------------------------------------------------------------------------
        
        // �Ǐ��I�ȁu�ő�l�v�A�u�ŏ��l�v�A�u���ϒl�v�A�u��f�l�v�����߂�----------------------------------------------------
        double sum = 0;
        for (int y = (filterSize/2)+1; y < thermal_line_count-(filterSize/2); y=y+skip) {   // �I��͈͓��𑖍�
            for (int x = (filterSize/2)+1; x < thermal_col_count-(filterSize/2); x=x+skip) {
                sum = 0;     
                sumPixelValue = 0;
                narrowThermalMax = Double.parseDouble(thermalCsvData[y-2][x-2]);  
                narrowThermalMin = Double.parseDouble(thermalCsvData[y-2][x-2]);  
                double[] data = new double[dataSize];
                int index = 0;
                for (int temp_y = y-(filterSize/2); temp_y <= y+(filterSize/2); temp_y=temp_y+1) {   // �I��͈͓��𑖍�
                    for (int temp_x = x-(filterSize/2); temp_x <= x+(filterSize/2); temp_x=temp_x+1) {
                        data[index] = Double.parseDouble(thermalCsvData[temp_y][temp_x]);
                        index = index + 1;
                        sum = sum + Double.parseDouble(thermalCsvData[temp_y][temp_x]);

                        narrowThermalAve = narrowThermalAve + Double.parseDouble(thermalCsvData[y][x]);  

                        if(Double.parseDouble(thermalCsvData[temp_y][temp_x]) > narrowThermalMax) {
                            // �Ǐ��I�ȁu�ő�l�v
                            narrowThermalMax = Double.parseDouble(thermalCsvData[temp_y][temp_x]);
                        }

                        if(Double.parseDouble(thermalCsvData[temp_y][temp_x]) < narrowThermalMin) {
                            // �Ǐ��I�ȁu�ŏ��l�v
                            narrowThermalMin = Double.parseDouble(thermalCsvData[temp_y][temp_x]);
                        }

                        // �Ǐ��I�ȁu��f�l�v�̍��v
                        int c = img.getRGB(temp_x, temp_y);
                        sumPixelValue = sumPixelValue + (r(c)+g(c)+b(c))/3;
                    }                   
                }              
                count++;

                // �Ǐ��I�ȁu���ϒl�v
                narrowThermalAve = sum/dataSize;
                
                //double temp = 0;
                //for(int i = 0; i < dataSize; i=i+1) {
                //    temp = temp + Math.pow(data[i]-narrowThermalAve, 2);
                //}
                //�Ǐ��I�ȁu�W���΍��v����͎g��Ȃ�
                //stdev = Math.sqrt(temp/dataSize);     

                //-----------------------------------------------------------------------------------------------------------
                // ���K�������Ǐ��I��narrowThermalMax
                narrowThermalMax = (narrowThermalMax-thermalAverage)/(thermalStdev);
                //System.out.println("���K�������Ǐ��I��narrowThermalMax="+narrowThermalMax);

                // ���K�������Ǐ��I��narrowThermalMin
                narrowThermalMin = (narrowThermalMin-thermalAverage)/(thermalStdev);
                //System.out.println("���K�������Ǐ��I��narrowThermalMin="+narrowThermalMin);

                // ���K�������Ǐ��I��narrowThermalAve
                narrowThermalAve = (narrowThermalAve-thermalAverage)/(thermalStdev);
                //System.out.println("���K�������Ǐ��I��narrowThermalAve="+narrowThermalAve);

                // �Ǐ��I�ȁu��f�l�v�̕���                
                avePixelValue = ( (sumPixelValue)/(filterSize*filterSize) )/255;
                //System.out.println("�Ǐ��I�ȁu��f�l�v�̕���="+avePixelValue);
                //-----------------------------------------------------------------------------------------------------------
           
                
                //System.out.println("�ő�l="+narrowThermalMax);
                //System.out.println("�ŏ��l="+narrowThermalMin);
                //System.out.println("����="+narrowThermalAve);
                //System.out.println("�W���΍�="+stdev);
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
            //--------  �f�[�^�Z�b�g�擾  ---------------------------------
            //DataSource source = new DataSource("thermal.arff");
            //Instances instances = source.getDataSet();
            //instances.setClassIndex(4);
            //-------------------------------------------------------------


            //--------  �w�K  ---------------------------------------------
            //Classifier classifier = new SMO();
            //classifier.buildClassifier(instances);  // �w�K
            //-------------------------------------------------------------


            //--------  �]��  ---------------------------------------------
            //Evaluation eval = new Evaluation(instances);
            //eval.evaluateModel(classifier, instances);
            //System.out.println(eval.toSummaryString());  // �]��
            //-------------------------------------------------------------

          
            //--------  ����f�[�^(�e�X�g�f�[�^)�쐬  ---------------------
           
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


            //--------  ���ތ��ʂ̏o��  -----------------------------------
            // �ȉ��ɒ���

            // result�̒l���u0�v�Ȃ�΁u���ӏ��v
            // result�̒l���u1�v�Ȃ�΁u����ӏ��v

            //double resultValue = classifier.classifyInstance(instance);
            double resultValue = svm.classifyInstance(instance);
            //System.out.println(result);
            if(resultValue==0.0) {
                result = true;
                //System.out.println("�u���ӏ��v\n �����̉\������");
            } else {
                result = false;
                //System.out.println("�u����ӏ��v\n ���Ȃ�");
            }
            //-------------------------------------------------------------

            //return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "�w�K�܂��͐��_�Ɏ��s���܂����B");
        }

        return result;
    }    
    

    // �C�x���g���X�i(MouseListener�C���^�[�t�F�C�X)�������ۃ��\�b�h������    
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(startButton)) {
            if(detectFlag == false) {
                try {
                    thermalCsvReaderMethod();            
                    scan(readImageMethod(infraRedImageName[currentImageCounter]));
                    detectFlag = true;
                    startButton.setText("���摜�\��");

                    ImageIO.write(tempImage, "png", new File("./���_����"+"/"+infraRedImageName[currentImageCounter]));
                } catch(Exception e5) {

                }
            } else {
                panelCENTER.remove(labelCENTER);
                center_Image_Setter( readImageMethod(infraRedImageName[currentImageCounter]) );
                panelCENTER.add(labelCENTER);

                frame.setVisible(true);
                detectFlag = false;
                startButton.setText("�u�����v����X�^�[�g");
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
                    startButton.setText("�u�����v����X�^�[�g");
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
                    startButton.setText("�u�����v����X�^�[�g");
                }

                frame.setVisible(true);
            }                       
        }
    }

    public void mouseEntered(MouseEvent e) {
        // �����
    }

    public void mouseExited(MouseEvent e) {
        // �����
    }

    public void mousePressed(MouseEvent e) {
        // �����
    }

    public void mouseReleased(MouseEvent e ){
        // �����
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
    
    // ���C�����\�b�h (�R���X�g���N�^���N�����邽�߂����ɗ��p�����)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                new ML(); 
            }  
        });                                
    }
}




